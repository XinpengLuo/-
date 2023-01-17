### 左神 LeetCode刷题23讲 https://www.bilibili.com/video/BV1dV41147wQ?p=23

#### 第二讲

> #### [剑指 Offer 39. 数组中出现次数超过一半的数字](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

首先哈希表记录肯定是可以解决的 但是这样解决肯定会空间上 你懂的 排序应该也可以 

我们考虑这样的算法：因为题目中是出现次数超过一半 **即刚好等于一半也是不可以的**

对于数组中 **每次删掉两个不同的数字  ** *如果没有剩下数字代表这个数组不存在超过一半的！！！*

 那么剩下的数字 **有可能**是出现次数超过一半的那个数字

比如 2 3 2 4 2 就相当于打架 我每次拿一个人跟你同归于尽 由于我出现次数超过了一半 **所以我最差都还剩了一个**  比如这个例子 

但是也有可能不满足比如 2 3 2 4 5 比如2前面都跟他打完了 但是剩下的那个由于没有人跟他打 所以剩下的就是他自己 所以不正确 所以我们需要再遍历一次数组去统计剩下的数字是否是出现了一半

整个都是on 和o1

至于怎么删除两个不同的数字 当然不会真正的去模拟这个过程 我们采用投票法的方式？

初始的时候声明两个变量 一个candi 表示上一个不同的数字 一个hp 表示它打完架后剩下多少次

每次遍历的时候看看hp == 0？

-  如果等于0 代表前面的数字刚好都打完架 那么自己就要变成被打的那个 并且hp = 1 candi = num[i]
-  如果hp ！= 0 那么
  -  如果当前数字和上一个数字不相等 则hp -- 不是hp 直接等于0 哈 因为他前面个可能出现很多次 
  - 如果和上一个数字相等 则hp++

最后如果hp = 0 代表刚好两两互相打完 没有大于一半的数字 如果hp 不等于0 就去查找candi出现的次数

```java
public int findNumberOverHalf(int[] nums){
        int candi = 0, hp = 0;
        for(int i = 0; i < nums.length; i++){
            if(hp == 0){ //好好看 写的真好
                candi = nums[i];
                hp++;
            }
            else{
                if(candi != nums[i])
                    hp--;
                else
                    hp++;
            }
        }
        if(hp == 0)
            return -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == candi)
                count++;
        if(count > nums.length / 2)
            return candi;
        return -1;
    }
```

> 拓展： 求数组长度为n 再给你一个数字k 求出所有出现次数大于 n / k 的数字

首先数组中最多有k - 1 这样个数字 （**注意不是让你求出现次数大于k 而是出现次数大于 n / k的**）  所以我们就是维护候选人有k - 1个 用哈希表维护 key为候选人 value 为hp

每一次当候选人没有满 则添加候选人 **否则将所有候选人都-1** 因为要同等 候选人的hp为0就删掉候选人

最后统计所有候选人是否满足出现的次数

```java
public List<Integer> findOverK(int[] nums, int k){
    HashMap<Integer,Integer> map = new HashMap<>(); //key -- candi value -- hp
    for(int i = 0; i < nums.length; i++){
        if(map.containsKey(nums[i]))
            map.put(nums[i],map.get(nums[i]) + 1);
        else{
            if(map.size() == k - 1)
                removeOne(map);
            else
                map.put(nums[i],1);
        }
    }
    List<Integer> ans = new ArrayList<>();
    HashMap<Integer,Integer> real = getAllReal(map,nums);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if(real.get(entry.getKey()) > nums.length / k)
            ans.add(entry.getKey());
    }
    return ans;
}
public void removeOne(HashMap<Integer,Integer> map){
    List<Integer> removeList = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int key = entry.getKey();
        int value = entry.getValue();
        if(value == 1)
            removeList.add(key);
        map.put(key,value - 1);
    }
    for (Integer integer : removeList) {
        map.remove(integer);
    }
}
public HashMap<Integer,Integer> getAllReal(HashMap<Integer,Integer> map, int[] nums){
    HashMap<Integer,Integer> real = new HashMap<>(); //key -- num value -- realCount
    for(int i = 0; i < nums.length; i++){
        int curVal = nums[i];
        if(map.containsKey(curVal))
            real.put(curVal,real.getOrDefault(curVal,0) + 1);
    }
    return real;
}
```

### 第三讲

> 请你构造一个长度为n的数组 其中对于任何的i < j < k 都不满足的 arr[i] + arr[k] == 2 * arr[j]

取一个数字的向下取整的话 直接是 n / 2 **向上取整的话 就是(n + 1 ) / 2**

如果n = 1 那么数组就是1

如果对于一个已经满足条件的数组 如{2,1,3}

对其进行奇变换：即构造第几个奇数 如第二个奇数 3 第一个奇数 1 第三个奇数 5 则新的奇变换为{3,1,5}

偶数变换为：{4,2,6} 

可以得证 奇数变换后 和 偶数变换后 都是满足的 代数带入就可以证明了

继续带值 奇数变换后 和 偶数变换后的数组拼接在一起也是满足的

如果拼接好的数组中任选三个数 这三个数如果都是偶数区间或者都是奇数区间那么直接满足 如果一个来自于左边 一个来字右边 两个偶数不可能加起来等于一个奇数

```java
  public int[] createArr(int n){
        int[] arr = {1};
        while (arr.length != n){
            int[] tempOdd = new int[arr.length]; //奇数变换的数组
            int[] tempEven = new int[2 * arr.length > n ? n - arr.length : arr.length]; //偶数变换的数组
            for(int i = 0; i < tempOdd.length; i++)
                tempOdd[i] = 2 * (arr[i]) + 1;
            for(int i = 0; i < tempEven.length; i++)
                tempEven[i] = 2 * arr[i];
            int[] temp = new int[tempEven.length + tempOdd.length];
            System.arraycopy(tempOdd,0,temp,0,tempOdd.length);
            System.arraycopy(tempEven,0,temp,tempOdd.length,tempEven.length);
            arr = temp;
        }
        return arr;
    }
    public int[] makeNo(int size){
        if(size == 1)
            return new int[]{1};
        int halfSize = (size + 1) / 2;
        int[] base = makeNo(halfSize);
        int[] ans = new int[size];
        int index = 0;
        for(; index < halfSize;index++)
            ans[index] = base[index] * 2 + 1;
        for(int i = 0; index < size; i++,index++)
            ans[index] = base[i] * 2;
        return ans;
    }
```

### 第四讲

> 假设现在你有一个函数可以随机返回1到5 请加工此函数让它随机返回[a b]

既然要等概率返回`[a,b]` 那么概率等同于返回`[0, b - a]`

考虑表示`b - a`一共需要多少个二进制位 如果我们等概率去模拟每一位 那么一定能等概率表示出`[0,b - a]`

当表示的数字大于`b - a` 直接重新来过

所以对于每一位二进制位只有 0 和 1 的取值 所以如何等概率拿到0 和 1？

对于等概率拿到1 到 5 时，如果小于3 时 则返回0 如果大于3时 则返回1 等于3 时重新来过 由此可以推广到任意数字

```java
 public int randomGetNum(){
        return (int) (Math.random() * 5 + 1);
    }
    //根据上面的函数等概率返回 0 和 1
    public int randomBinary(){
        int res = randomGetNum();
        while (res == 3)
            res = randomGetNum();
        if(res < 3)
            zero++;
        else
            one++;
        return res < 3 ? 0 : 1;
    }
    //根据二进制位 模拟
    public int randomGetAns(int a, int b){
        //先求出为了覆盖需要多少个二进制位
        int temp = 1, count = 1;
        while (temp < b - a)
            {
                count++;
                temp += temp << 1;
            }
        int sum = 0;
        do{
            sum = 0;
            for(int i = 0; i < count; i++)
                sum += (randomBinary() << i);
        }while (sum > b - a);
        return sum + a;
    }

```

