### 数据结构算法日记

#### 11月26日

1. 冒泡排序

   冒泡排序的重点在于两两交换 每一轮排序都把最大或者最小的元素浮动到最右边 一共比较**长度-1轮** 每一轮比较**长度-i-1次** 减1 是因为三个数字排两次 减i 是因为排好的不用管了

2. 选择排序

   遍历整个数组 每一次遍历都把当前元素当作最小元素 再用另外一个指针扫描后面 遇到比他小的就把它当作最小值 记录下标和值 一轮循环后交换

3. 单链表操作

   这里主要是每次查找 添加时 遍历的条件 要依靠临时的头节点

4. 反转单链表

   这里主要是记录反转的当前节点的下一个节点

5. 单链表倒数第k个元素

   先求链表长度 再算算要遍历多少次

6. 合并两个有序的单链表

   先从合并两个有序的单链表开始 两个指针分别指向两个链表 依次比较 如果哪一个链表的元素小一点 就将当前链表的元素添加到新的链表 并且当前链表指针加1 另外个链表不变 退出条件是 直到其中一个链表遍历完毕。 然后最后判断下是否另一个链表是否没有遍历玩 没有遍历完的话 直接追加到尾部

7. 双链表好处以及特点

   - 可以双向查找 可以自我删除
   - 遍历方法和单链表一样 只是可以向前也可以向后
   - 添加元素的话 先找到屁股 不仅要next指向新节点 新节点的pre也要指向屁股
   - 删除的话 temp.pre.next = temp.next; temp.next.pre = temp.pre 如果删除最后一个节点的话不要动第 二句话哟



#### 11月30日

**约瑟夫问题**

1. 构建时如果是添加第一个节点 就将它给first 让 cur也指向first 并且当前节点的next指向first
2. 如果不是的话 就让cur的next指向新的节点 新的节点的next指向first 然后让cur指向新的节点 
3. 遍历的话新建一个辅助节点 指向first 然后一直向下遍历 直到当前节点的next又回到了first为止
4. 出来的话 首先将first 指向是第几个报数的 然后 需要一个辅助指针 事先指向最后一个节点 这里的最后节点是相对于**first**而言的 即永远指向first的前一个节点  当报数的时候 两个指针同时向前移动m - 1 次  出圈的时候 first再向前移动一次 helper当前节点的next指向新的first![image-20201130210045210](/Users/luoxinpeng/Library/Application Support/typora-user-images/image-20201130210045210.png)



#### 12月2日

**链表栈**

1. 区别不大也需要个头指针 同时需要一个尾指针指向链表的最后一个元素添加的时候直接next就行
2. 出去的时候遍历到最后个节点的前一个节点 设置next为null  并且尾指针向前移动

**数组栈**

1. 使用数组来模拟栈
2. 定义一个top来表示栈顶 初始化为-1
3. 入栈 top++ s[top] = data; 出栈 data = s[top] top--撒



#### 12月3日

**回文链表 或者 回文字符串**

1. 链表的话可以反转 再比较 但是他们都可以通过栈压进去 再弹出来 判断是否相等

奇偶链表

1. 将偶数的节点添加到另一个链表中 再结合下



#### 12月7日

**合并区间**

​		首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：

1. 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；

2. 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。

**队列**

1. 队列是一个有序列表 可以用数组或者链表来存储（分别对应顺序存储和链式存储）
2. 先入先出 front代表头部 rear代表尾部 加入的时候尾指针后移 删除的时候头指针后移
3. rear == maxSize - 1**队列满 rear是指向队列最后的元素 front总是指向队首的前一个元素 初始化为-1**
4. 如果这样的话 数据取出后 空间依然不能得到使用

**环形队列**

1. front变量的含义作为调整 就指向队列的第一个元素 **即不再是第一个元素的前一个** 初始值为0
2. rear变量的含义为指向最后和元素的后一个位置 希望空出一个空间作为一个约定 初始值为0
3. 队列满的时候是 **(rear + 1) & maxSize = front** 因为你想想如果满的话 rear指向最后个元素的后一个元素，如果满的话 代表后一个元素再后一个就是front了 那么我们 + 1 % 一下就指向了front 这种情况包含rear指向数组的最后个元素
4. 数组的元素的个数为 (rear - front + maxSize) % maxSize 因为rear - front 可能为负数 所以需要加一下 再摸一下
5. 入队列的时候 直接arr[rear] = value rear后移的时候注意取模 因为一直在转圈 rear = (rear + 1) % maxSize
6. 出队列的时候先取出数据 value = arr[front]  再后移 取模 front = (front + 1) % maxSize

**删除排序数组中重复的项**

> 给定一个**排序数组**，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
>
> 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成

1. 使用快慢指针的方法 初始的时候 慢指针指向下标为0 快指针指向下标为1 
2. 快指针向前扫描 扫描次数为数组的长度 循环结束则整个操作结束 ***如果快慢指针的元素相等不执行任何操作***
3. 如果不想等 代表终于可以去重了 这时候满指针 + 1 新的慢指针指向的元素等于快指针 继续扫描直到结束

**重新排列数组**

> 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
>
> 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

1. 分别生命两个指针指向x1处 和 y1处 
2. 新建一个数组长度为2n 遍历 判断奇偶性 分别将i指针指向的值赋给他再加一 j指针同理

#### 12月8日

看了《java编程思想》 87页

#### 12月9日

看倒了150页 刷了几道简单的数组题 

#### 12月9日 到 12月29日

看了java全部吧 然后看了黑多黑马视频 以及耍了一些题

#### 12月30日

学了递归 学了左神算法

> 找出链表的中间节点 是奇数的话 就中间 偶数的话 上中点

以前的我只会求出链表的长度 然后算坐标 现在学会了快慢指针法 初始的时候快慢指针都指向head 当快指针还能往前走两步的时候 慢指针走一步 快指针走两步 循环结束的时候自然慢指针到达了中点



> 跟据链表的头节点 以及传入的值 让小于值的节点全部放在左边 等于的在中间 大于的在右边

这样创建三个链表 分别有头尾指针 依次遍历初始头节点 根据大小依次加入对应的新链表 注意加入的时候是否是第一次添加 然后头指针指向第一次添加的元素 尾指针指向最后一次添加的元素 最后遍历完成后 三个新链表分别判断是否为空 再首尾相连

> 克隆复杂链表 就是带random的

- 第一种方法利用哈希表

  先遍历将节点和节点的克隆（即new出来 值相同 但是没有next 和 random的指针）存入hashMap 再遍历一次

  ```java
  while (temp != null)
          {
              nodeNodeHashMap.get(temp).next = nodeNodeHashMap.get(temp.next);
              nodeNodeHashMap.get(temp).random = nodeNodeHashMap.get(temp.random);
              temp = temp.next;
          }
  ```

- 第二种方法 利用穿插节点

  先构造这样的结构 1 > 1' > 2 > 2' > 3 > 3' > 4 > 4' 

  再依次遍历 判断原节点是否有random 有的话为复制出来的节点添加random指针

  最后再分离这个穿插链表 返回head.next 

今天收获了很多干货 觉得快慢指针十分的神奇 左神的视频非常可以！ 加油 还可以感受

### 12月31日

> 判断环形链表

- 方法1 利用hashset 依次存入hash表中 每次遍历先判断是否存在于hashset中 如果有代表有环 顺带可以返回第一个入环节点
- 方法2 快慢指针的方法 当快慢指针不重叠的时候慢指针走一步 快指针走两步 如果快指针走到了null 代表无环 如果两者重叠了 则快指针回到head 当两者不重叠的时候 各自走一步 重叠的时候 代表入环的第一个节点

> 返回相交链表的第一个节点 两个链表都可能有环也可能没有环

这里要分情况讨论

1. 两个链表都无环 
2. 两个链表都有环 （如果相交 则必定共用一个环）**不存在一个有环 一个没有环还相交 **
   1. 如果两个入环节点相同 则分为两个链表相交的地方是否在环状开始之前 则他们入环的第一个节点必定相同 此时将入环节点之前看成两个链表都无环即可
   2. 两个链表入环的地方不同 则判断两个环是否属于同一个环 将一个链表的入环节点依次遍历能否遍历到另一个环的入环节点 如果能代表是相交的

对判断两个相交链表的方法做一说明 当然可以用hashset的方法 依次判断 
但是可以这样 两个链表必定一长一短（同等长度不影响） 则相交的地方最早为短的那根链表的头节点 所以“长链表”长的地方 让两条链表长度相等 再依次都走一步 直到两个节点相同为止

```java
public ListNode getIntersectionNodeNoLoop(ListNode headA, ListNode headB)
{
    if(headA == null || headB == null)
        return null;
    int n = 0;
    ListNode cur1 = headA;
    ListNode cur2 = headB;
    while (cur1.next != null){
        n++;
        cur1 = cur1.next;
    }
    while (cur2.next != null){
        n--;
        cur2 = cur2.next;
    }
  	//如果有相交那么他们最后一个节点的内存地址肯定相同
    if(cur1 != cur2)
        return null;
    cur1 = n > 0 ? headA : headB;
    cur2 = cur1 == headA ? headB : headA;
    n = Math.abs(n);
    while (n != 0){
        n--;
        cur1 = cur1.next;
    }
    while (cur1 != cur2){
        cur1 = cur1.next;
        cur2 = cur2.next;
    }
    return cur1;
}
```

> 是否可以根据当前节点。没有头节点来删除当前节点

**不可能**

以下做法只是借尸还魂 他本身的内存地址还在 而且如果是服务器的话 会有特别多的问题

```java
node.val = node.next.val;
node.next = node.next.next;
```

且不能删除最后个节点

直接职位空如 c = null； 只是将引用置为空 如下图所示

![image-20210101001627367](/Users/luoxinpeng/Library/Application Support/typora-user-images/image-20210101001627367.png)

### 2021 1月5日

认识异或运算 收获非常大！！！

> 什么是异或运算？

两个数字（二进制表示）对每一位进行运算 如果当前位相同则为0 不相同就为1 

**直接记住 两个数字无进位二进制加法即可！**

两个结论

* 0 ^ N = N （想想无进位加法即可）（想想0 和 0 异或运算由于位相同则为0 0和1 运算位不同 为1 所以 就是数字本身。）
* N ^ N = 0  (当前位相同则为0)

> 一串数字 已经知道一些数字出现了偶数次 只有一个数字出现了奇数次 求这个数字

直接将整个数字挨个异或运算即可 因为偶数次的数字运算后就为0 相当于 0  ^ 出现奇数次的数字 就等于那个数字本身

> 提取出int型数字的最右侧的那个1

**结论： 将当前数字取反 后 加上一个1 再对原数字进行 与运算**
即 <code>rightOne = eor & (~eor + 1)</code>

首先取反后 最右侧的那个1 变成了0 其右侧原本的0 全部变成了1 再加上了1 之后 一直进位 将最右侧由1 变成0 最后变成了1 相当于 最右侧1 以及后边 全部又变了回来 但是左边的是取反后的结果。 最后再进行& 运算  左边的是和取反后的结果进行运算 所以全部为0 右边自然不变 所以就提取出了最右侧的1 

> 已知一个数组中 有两个数字出现了奇数次 其余的都出现了偶数次 求出这两个数字

1. 首先将这个数组逐次进行异或运算 **最后的结果肯定是两个出现了 奇数次的数字** 异或的结果 原因同上
2. 这个结果必定不为0 因为只有两个相同数字才会运算成0。故肯定有一位为1 利用上述方法 提取出最右侧的1 
3. 为什么这一位会有1 呢 代表在这一位上要么一个为1 要么一个为0 
4. 所以我们将原数组分为两组 一组为那一位上为0的 另一组为那一位上为1 的 这样就讲两个奇数次数字分开了
5. 再对其中一组进行异或运算 就跟一个数组求出现了一个奇数次的数字一样 就得出了其中一个数字
6. 再将求出的数字和一开始的异或结果进行异或运算 就求出了另一个数字 

**注意一定要分清楚 异或运算和 与运算 以及 或运算的区别**

1. 与运算 两位同时为1 结果才为1 &
2. 或运算 其中一个为1 结果就为1 |
3. 异或运算 两位相等为0 否则为1 ^

代码如下 还是挺有意思的 从来没有这样写过。

```java
public static void findTwoNumberOdd(int[] arr){
  int eor = 0;
  for(int i = 0; i < arr.length; i++){
    eor = arr[i] ^ eor;
  }
  //注意下面取反的符号表示哦
  int rightOne = eor & (~eor + 1);
  //这个变量表示分组后的异或运算的值
  int onlyOne = 0;
  for(int i = 0; i < arr.length; i++){
    //如果一个数字和只有一位为1的数字进行与运算不等于0。代表在为1的那一位上他也为1 因为只有都为1 才为1 所以其他位肯定为0 这样我们就变相将为1 的那组给提取出来了
    if(arr[i] & rightOne != 0)
      onlyOne = onlyOne ^ arr[i];
  }
  System.out.print(onlyOne, onlyOne ^ eor);
}
```

> 求一个数字中的1 的个数

```java
public static getOneCount(int number){
  int count = 0;
  while(number != 0){
    int rightOne = number & (~number + 1);
    count++;
    //这句话相当于将最右边的那个1 变为0 然后再对新数字进行求最右边的1 
    //011011010000
    //000000010000
    //011011000000
    number = number ^ rightOne;
  }n
  return count;
}
```

### 1月6日

> 将数组中小于某个数字的数字放到左边 大于的放到右边

不能使用n2 太蠢了

首先声明一个指向小于区间最后一个数字的指针j 初始为-1 依次遍历数组 如果当前数字小于目标数字就将当前数字和j指针的下一个数字进行交换 并且j++ 大于的不管 这样即可 注意是否交换有值得优化 的地方 比如判断是否是自己和自己交换 即i是否等于j+1

> 荷兰国旗问题 小于target的放到左边 等于的放到中间 大于的放到右边

i指针初始指向-1 代表指向小雨区间的最后一个数字 
j指针指向length 代表大于区间
整个过程是不断扩大小于区间和大于区间即可
用cur指针依次遍历数组 当小于target的时候扩大小于区间 将i指针的后一个数字和此数字交换 i++
当大于target数组的时候 将j指针的前一个数字进行交换 并且j-- 此时交换后cur指针不变进行下一次循环 判断交换后的数字究竟是何方神圣
如果等于target时 直接cur++ 即可
**什么时候遍历结束？**
当cur > j 时 结束

### 1月13日 

前面看了一些网络吧

1. 堆就是一个完全二叉树 分为大根堆和小根堆 **大根堆任何一个子树的最大值都是头部**
2. 数组转完全二叉树 2 * i + 1 为左子节点 2 * i + 2 为右子节点 父节点为 （i - 1） / 2

**堆排序**

1. 建立大根堆  依次遍历数组 判断当前节点和其父节点的大小 如果不满足大小关系就一直往上换
2. 创建heapSize 变量 表示当前heap的size
3. 将堆的堆顶元素和堆的最后一个元素交换 然后heapSize - 1 然后从0开始到heapSize - 1处重新堆化 
   堆化是指 判断将当前元素和左孩子以及有孩子进行大小比较 并且交换 如果交换 就继续对交换后的index值进行堆化
4. 重复3的操作直到堆的大小为1 结束 这样每次换到最后的都是整个数组中的最大值

 ### 1月15日

> 求栈中最小值

准备两个栈 一个栈(a)专门存放原数据 一个栈(b)专门存放最小值 a每进一个数字 比较b栈的栈顶元素 如果比他小 那么将其也压入b栈 如果比他大 那么把辅助栈的栈顶元素再压一遍 代表取了最小值 则将b栈的栈顶元素再次压一遍

> 两个队列模拟栈

准备两个队列 一个data 一个help 当入“栈”时 data直接add 出的时候 将队列的前n-1个数全部放到help里 那么data剩下的那个就是模拟栈的栈顶元素 最后改变引用 data指向help。help指向data

> 两个栈模拟队列

准备两个栈 进的时候进data栈 出的时候将data栈的数据push进help栈 再从help栈取栈顶元素 
所以取的时候都是从help时取的 
但是倒的时候 一定要判断 help栈为空时才到 比如现在data栈有3个数据 倒入help中 然后我们取一次值 此时help有两个 然后data又来了一个 我们再取 此时不需要倒 只需要从help中弹出即可。

> 螺旋打印矩阵

取左上角和右下角两个数 按顺时针打印 一圈打印完后 两个数字依次往内扩展 
如果左上角和右下角 行相同或者列相同 分情况考虑

**5月12日再看**

给你左上角和右下角两个坐标 实现一个函数打印他们两个数代表的框 然后左上角向右下角移动 右下角向左上角移动 当这两个点大小不符合的时候退出
其实判断三种情况 两个点是否同行 两个点是否同列 两个点是否满足普遍情况

### 1月16日

> 之字型打印矩阵

声明a b两指针 初始都指向原点 a每一次向右移动一次 当右边没有了向下移动一次 b每一次向下移动一次 当下面没有了向右移动一次 那么a b两个点总能形成一个对角线 再打印对角线上的交点即可 至于是正反打印 布尔变量判断即可

> 矩阵旋转90度

其实这个和螺旋矩阵差不多 都不要局限于坐标的变换 也是左上 右下两个点作为突破口 每一圈要移动的循环次数 以及 移动到哪里即可

**也是左上角和右下角的两个数**

每一圈的数字只在圈内变化 有点烦这道题

> 行和列都排序好的矩阵 查找数字

设置从矩阵的右上角开始查找 为什么不是左上角原点呢？ 如果是左上角的话 右边的和下面的都比他大 如果要进行大小判断不知道如何移动 但是右上角的话 如果目标数字比当前数字小 那么我就向左移动 否则向下移动 直到找到或者遍历完即可

> 判断回文链表

方法1 压入栈中
方法2 慢指针走一步 快指针走两步 那么结束的时候慢指针来到中点的位置 那么将中点后的节点进行逆序 再和头节点依次遍历下来进行比较

### 1月17日 

> 树的前序遍历 非递归版

准备一个栈 先将头节点压入 再取出 输出值 再压入右节点 再压入左节点 当栈不为空时进行循环

> 树的中序遍历

当前节点不为空 将当前节点压入栈中 当前节点往左边跑 当前节点不为空 从栈里取出一个 打印 当前节点再往右边跑

```java
public static inOrderUnRecur(Node head){
  if(head != null){
    Stack<Node> stack = new Stack<>();
    while(!stack.isEmpty() || head != null)
    {
      if(head != null){
        stack.push(head);
        head = head.left;
      }else{
        head = stack.pop();
        print(head.val);
        head = head.right;
      }
    }
  }
}
```

> 树的后序遍历

```java
if(head != null){
  Stack<Node> s1 = new Stack<>();
  Stack<Node> s2 = new Stack<>();
  s1.push(head);
  while(!s1.isEmpty()){
    head = s1.pop();
    s2.push(head);
    if(head.left != null)
      s1.push(head.left);
    if(head.right != null) 
      s1.push(head.right);
  }
  while(!s2.isEmpty())
    print(s2.pop().val);
}
```

> 一个二叉树 有parent节点 right节点 left节点 给定任意一个节点 求其后继节点 **及中序遍历的后一个节点**

如果该点有右子树那么该后继节点一定是其**右子树的最左那个节点**
如果它没有右子树那么该后继节点一定是**其所在某一子树中 该节点属于属于其左子树的最后的一个节点  的 那个子树的父节点**

> 一个二叉树 有parent节点 right节点 left节点 给定任意一个节点 求其后继节点 **及中序遍历的前一个节点**

如果该点有左子树那么该前驱节点一定是其**左子树的最右节点**
如果它没有左子树那么该后继节点一定是**其所在某一子树中 该节点属于属于其右子树的最后的一个节点  的 那个子树的父节点**



### 1月18日和19日20日

> 判断搜索二叉树

中序遍历的结果是有序的就是 虽然道理是这样 但是我们不可能将中序遍历的结果存储在容器里再去判断 这样的话空间复杂度就是O(n) 所以我们要做到在遍历时就判断 这就需要每次遍历一个节点都将当前节点的值保存 遍历到下一个节点时 与保存的这个节点的值进行比较

```java
public static boolean isBst(TreeNode root){
  if(root != null){
    Stack<TreeNode> stack = new LinkedList<>();
    Long val = Long.MIN_VALUE;
    while(!stack.isEmpty() || root != null){
      if(root != null){
        stack.push(root);
        root = root.left;
      }
      else{
        root = stack.pop();
        if(val > root.val)
          return false;
        val = root.val;
        root = root.right;
      }
    }
  }
}
```

> 判断完全二叉树

判断完全二叉树需要借助层次遍历 

* 如果一个节点**有右孩子但是没有左孩子**则必不是完全的
* 如果一个节点有左孩子但是没有右孩子了 **则后面的节点必须都是叶子节点即 没有左右孩子**

```java
public static boolean isCBT(TreeNode node){
  if(node == null)
    return true;
  Queue<TreeNode> queue = new LinkedList<>();
  queue.add(node);
  boolean flag = false;
  TreeNode temp = null;
  while(!queue.isEmpty()){
    temp = queue.poll();
    if((flag && (temp.left != null || temp.right != null)) || (temp.right != null && temp.left == null))
      return false;
    if(temp.left != null)
      queue.add(temp.left);
    if(temp.right != null)
      queue.add(temp.right);
    if(temp.left != null && temp.right == null)
      flag = true;
    return true;
  }
}
```



> 判断平衡二叉树

```java
public static ReturnData isAVL(TreeNode root){
  if(root == null)
    return new ReturnData(true,0);
  ReturnData leftData = isAVL(root.left);
  if(!leftData.isA)
    return new ReturnData(false,0);
  ReturnData rightData = isAVL(root.right);
  if(!rightData.isA)
    return new ReturnData(false,0);
  if(Math.abs(rightData.height - leftData.height) > 1)
    return new ReturnData(false,0);
  return new ReturnData(true,Math.max(leftData.height,rightData.height) + 1);
}
class ReturnData{
  boolean isA;
  int height;
  public ReturnData(boolean isA, int height){
    this.isA = isA;
    this.height = height;
  }
}
```



> 求完全二叉树的节点个数

*注意下述中完全二叉树和满二叉树的区别*

* 一个头节点 **如果它的右子树的左边界到了整棵二叉树的最后一层** 代表 **头节点的左子树是满二叉树** 此时可以根据计算满二叉树（注意不是完全二叉树）公示计算其
   左子树的高度 加上头节点的个数 即
  2的(h - 1evel)次方 - 1 + 1 即 2的(h - 1)次方 **相当于 1 向左 移动了(h - 1)位**。然后再递归的求其右子树 **因为其右子树也是一颗完全二叉树**
* 如果 **右子树的左边界没有到** 代表其右子树是满二叉树 而且高度比左子树少1 其左子树是完全二叉树 那么其右子树加上当前头节点的值为 2 的 (n - level - 1)次方 再去递归求其左子树
* 注意level表示当前节点在整棵树第几层

> 先序遍历序列化二叉树 并且 反序列化

首先序列化的意思就是将**树按照某种顺序 生成一个特定字符串 包含空节点** 
注意不管是空还是非空 值的后面都要加上**后缀**  因为比如一个节点是2 一个节点3 还有一个节点是23 那么就无法区分

先序遍历的结果是 **当前节点的值加上左子树的序列化结果 再加上右子树序列化的结果 最后再返回** （不知不觉自己都开始有点递归的感觉了） 

```java
public static String preSequenceFy(Node head){
String result = "";
if(node == null)
  return "#_";
result += node.val + "_";
result += preSequenceFy(node.left);
result += preSequenceFy(node.right);
return result;
}
```

其实有时候想递归 **我们不一定要从头想起 可以从尾部想起** 前提是先写出代码

反序列化 返回头节点 先读出头节点再设置其左节点再将左节点一直递归下去

```java
  static int index = 0;
    public static Node preReSequenceFy(String[] s){
        if(s[index] == "#")
            {
                index++;
                return null;
            }
        Node head = new Node(Integer.valueOf(s[index++]));
        head.left = preReSequenceFy(s);
        head.right = preReSequenceFy(s);
        return head;
    }
```



>  层次遍历序列化二叉树 以及反序列化

二叉树的层次遍历序列化比较简单

首先说一下**二叉树的层次遍历** 需要借助队列 先将头节点加入到队列中 再当队列不为空的时候 取一个队列中的元素  打印 如果左孩子不为空则加入到队列中 如果右孩子不为空加到队列中
直到队列为空即可。

那么序列化就是首先将头节点加入到字符串中 注意这个是迭代不是递归 然后当左不为空时先加入字符串再加入队列 如果为空就加入空的代表符 表交简单不写了

反序列化 同样要借助队列 

先取出字符数组的第一个值 声成头节点 返回这个head 然后将head加入到队列中 当队列不为空时一直执行以下逻辑

* 从队列里弹出一个元素
* 看看字符串下个下表是否是空位 如果是空位将弹出的元素的左节点设置为null 否则新建一个 右节点 最后指针后移
* 右节点同理
* 判断设置的左节是否为空 如果不为空则将左孩子加入队列 右孩子同理



### 1月21日

> 设计一种结构 insert(key) 不重复加入 delete(key) 从原本的结构中移除 getRandom() 随机返回一个key 要求这三种方法时间复杂度都是0(1)

准备两个hash表 一个表 存放<Size,key> 另一个存放<Key,size> 其中size表示当前的容量 也表示第几次加入
加入的时候 两个表都要add

getRandom()的话 生成0 到 size的 随机数 再从hash表中取
delete的话 先获取到要delete的size 以及最后一条记录的size 最后将两张表都删除 再将最后一条记录补到删除的位置即可 最后size--；

> 布隆过滤器

 先来几个公式

- 要开辟的字节数组的大小 m 其中p为失误率  n为样本大小
  $$
  m =- ( \frac {n  *  lnP}{(ln2) ^ 2} )
  $$

- 确定哈希函数的个数  ln2 可以看成0.7
  $$
  K = ln2 * \frac {m} {n}
  $$

- 新的失误率为
  $$
  (1 - e ^ -\frac{n * K}{m}) ^ K
  $$

**大致流程**

1. 申请大小为m 的字节数组 此*字节数组并不是是以Byte*类型的数组 而是int型 总的大小为int大小 * 4 * 8 因为一个int是4个字节 每个字节又是8位
2. 当新来了一个url 先经过hash函数 得到要描黑的位置（此位置是指第几个字节描黑）
3. 将要描黑的位置 / 32 得到在int数组中要描黑的index 再将描黑的位置 % 32 得到在指定下标的index数组中 第几位被描黑
4. <code>int intIndex = index / 32</code> <code>int byteIndex = index % 32</code>
5. 经过这样的运算<code> arr[intIndex] | (1 << byteIndex)  </code> 对应的位置就被描黑了 位运算是让对应位被描黑 再与原数字进行或运算 只要一个为1 就为1 就得到了想要的结果
6. 再将当前url 经过剩下的hash函数 描黑对应的位置
7. 查询的时候 如果对应位置都被描黑了 则在 否则不在 
8. 所以这样可能会失误 但是失误不会是原本在的说不在 只会是原本不在 但是说在



### 1月22日

> 认识一致性哈希

感觉是跟负载均衡相关 然后创建虚拟节点抢占环 这里先不做要求

> 镜像二叉树

利用层次遍历 依次将左右指向交换 如果交换后 左指针不为空 则加入到队列中 如果右指针不为空 加入到队列中



 ### 1月23日

> 并查集

其实难度也还好 在**每一个集合中有一个代表节点它的父节点指向它自己** 集合中每个节点都会有其父节点 以及 当前集合有多少个元素 **但是这个属性只需要代表节点满足即可** 这样就形成了一个头节点下面挂载了很多子节点的结构

1. 首先利用两张哈希表来模拟其每个节点的父节点 以及所在集合的节点个数 **初始的时候每一个节点各自生成一个集合**

   ```java
   public UnionFindSet(List<Node> list){
       fatherMap = new HashMap<>();
       sizeMap = new HashMap<>();
       for (Node node : list) {
           fatherMap.put(node,node); //一开始每个节点形成一个集合
           sizeMap.put(node,1);
       }
   }	
   ```

2. 如何判断两个节点属于同一个集合呢？？ ***只要这两个节点所在的集合的代表节点 是相同的那么他们就属于同一个集合*** 所以下面展示如何寻找其代表节点
   根据代表节点的特性。其father等于它自己 所以我们一直递归或者迭代即可。**注意找其代表节点的过程 要将其沿路的所有节点都挂在代表节点的下面**

   ```java
   public Node findHead(Node node){
     if(root == null)
       return null;
     Node parent = fatherMap.get(node);
     if(parent != node)
       parent = findHead(parent);
     fatherMap.put(node,parent);
     return parent;
   }
   
   public Node findHead(Node node){
     if(root == null)
       return null;
     Node parent = fatherMap.get(node);
     Stack<Node> stack = new Stack<>();
     while(parent != node){
       stack.push(node);
       node = parent;
       parent = fatherMap.get(parent);
     }
     while (!stack.isEmpty())
               fatherMap.put(stack.pop(),parent);
     return parent;
   }
   public boolean isSame(Node node1, Node node2){
     return findHead(node1) == findHead(node2);
   }
   ```

3. 合并两个集合 **是哪个集合的代表头节点的size小 就将小的挂在大的下边**

   ```java
    public void UnionSet(Node node1, Node node2){
           if(node1 == null || node2 == null)
               return;
           Node head1 = findHead(node1);
           Node head2 = findHead(node2);
           if(head1 != head2){
               int size1 = sizeMap.get(head1);
               int size2 = sizeMap.get(head2);
               if(size1 <= size2){
                   fatherMap.put(head1,head2);
                   sizeMap.put(head2,size1 + size2);
               }
               else {
                   fatherMap.put(head2,head1);
                   sizeMap.put(head1,size1 + size2);
               }
           }
       }
   ```

> 岛屿问题

想象一下像生化病毒感染一样 我们依次遍历原始矩阵 如果某个元素为1 则递归的遍历其上下左右 直至遇到不为1为止 当然要注意边界条件

```java
 public int countIsland(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1){
                    count++;
                    infect(matrix,i,j,r,c);
                }
            }
        }
        return count;
    }
    private void infect(int[][] m,int i,int j,int r,int c){
        if(i < 0 || i >= r || j < 0 || j >= c || m[i][j] != 1)
            return;
        m[i][j] = 2;
        infect(m,i + 1,j,r,c);
        infect(m,i,j + 1,r,c);
        infect(m,i - 1,j,r,c);
        infect(m,i,j - 1,r,c);
    }
```



> 并查集解决岛屿问题

大致思想是将矩阵分块 处理边界的时候 用并查集的思想来处理

### 1月24日

> 前缀树

1. 首先谈一下结构 整个结构是一个根节点 以及 多叉树 **根据传入的字符串生成其对应的路径**

<img src="/Users/luoxinpeng/Library/Application Support/typora-user-images/image-20210124153935270.png" alt="image-20210124153935270" style="zoom:5%;" />

2. 每一个节点有三个属性 path代表走过当前节点的次数 end代表以当前节点结尾的次数 next数组代表a到z的路径是否为空

3. 插入时 将字符串转换为char数组 依次从root节点移动node节点 将char[i] - 'a' 获取在next中的index 并且对应的path++ 最后一个节点end++

   ```java
    public void insert(String word){
           if(word.isEmpty())
               return;
           char[] chars = word.toCharArray();
           int index = 0;
           TrieNode node = root;
           for (char aChar : chars) {
               index = aChar - 'a';
               if(node.next[index] == null){
                   node.next[index] = new TrieNode();
               }
               node = node.next[index];
               node.path++;
           }
           node.end++;
       }	
   ```

4. 查找某个字符串出现了几次时时也是按照上面这个路径 如果中间某条路径为null 直接return 0 否则return最后一个的end
5. 查找某个以某个字符串的前缀出现了几次时 如果null 返回0 否则返回最后一个的path
6. 删除时要注意一点 其实也是按路线遍历 沿途的path-- 最后一个节点end-- 但是考虑到如果--path == 0 则代表其实后面的都不存在了 直接将当前路径置为null 即可



### 1月26日

什么是字典序？
字典中排列的顺序

> 工程问题

### 1月27日

> 安排会议ss

### 1月28日

> 打印字符串的全排列 和 全序列

> 从矩阵的左上角到右下角的最小路径和

> 最大二叉树

第一次自己纯手写 纯思路 解决了一道二叉树递归的题 真的太开心了！！！！ 哇哈哈 

通过自己不断改正的感觉真的太爽了. Di  8 

### 1月29日

> 二叉搜索树的范围和

> 二叉树的坡度

### 1月30日 

> 递增顺序查找树

> 合法二叉搜索树

> 求和路径

>  二叉搜索树的第k大节点

> 二叉树的子结构

> [二叉搜索树节点最小距离]

### 1月31日

> 插入排序链表

**关于动态规划和暴力递归的思考**

> 从矩阵的某个点（左上角）到右下角最小路径和是多少？

像我之前的想法 无非就是一直传递sum 然后判断如何防止越界 但是看了下左神从暴力递归到动态规划的思想 做了以下改变

1. 首先判断最小条件（base case）？ 当当前点已经到了最下角的时候  那么问题就变成了最下角的点到最下角的点的最小路径是多少 **那么当前点到最下角就是其本身**
2. 如果没到 要移动的话 并不把当前节点的值累加到sum中传递下去 而是返回 **当前节点的值 + 下一个移动点的最小路径和** 看是下还是右
3. 至于移动的规则。列行 符合即可

<img src="/Users/luoxinpeng/Library/Application Support/typora-user-images/image-20210131211730243.png" alt="image-20210131211730243" style="zoom:30%;" />

*如何到动态规划呢*

如上图 沿途并不记录解 硬展开 例如上图重复计算了e 时间复杂度是 2的l次方
**让我们先到记忆化搜索**

每计算完一个结点的值 当将result 放到map里 每次要计算下一次的时候 先看map里有没有 有的话直接取 没有的话再递归 最后将当前结点的值 存入到map里

优化到了o(n) n为矩阵的节点个数

*到动态规划*

先确认目标 和 base case。再看看普遍的位置依赖什么位置 在这里分三种 一是 到了最后一行 二是到了最后一列 三是 在中间 感觉一直在算矩阵

<img src="/Users/luoxinpeng/Library/Application Support/typora-user-images/image-20210131215210721.png" alt="image-20210131215210721" style="zoom:33%;" />

> 数组累加和是否等于target 从递归到动态规划

### 2月22日

之前看了好久好久的网络啊 看到了运输层了 加上过年 

> 删除链表中的重复元素2

 

### 3月15日

> 单调栈解决 求一个数组中每一个元素 左边比他大的最近的 右边比他大的最近的

维持一个栈 让栈里的元素维持从大到小的顺序（由底向顶）依次遍历数组 如果数组比栈顶元素小 入栈 否则 
弹出栈顶的元素 并记录栈顶元素的信息 其中让它弹出的那个元素 就是 右边比他大最近的 它左边离它最近比他大的 就是 下一个栈顶
遍历完后 再遍历栈 栈里的每个元素右边比它大的都是null 左边比它大的 就是下一个栈顶

### 3月16日

> 给定一个数组 将数组转换成二叉树 二叉树要满足值最大的节点 就是。树的根节点 对于每一颗子树都是这样

1. 大根堆构建 大根堆就满足这个意思 时间复杂度还是O(n)
2. 使用单调栈 获得上一问题的信息 然后将 **左边和右边都没有比他大的节点** 作为头节点（很明显这个节点肯定最大）  再对于每一个**左边没有比他大 但是右边有比他大的节点（单边同理）** 将此节点串在右边比他大的节点下 对于**两边都有比自身大的节点** 将其串在左右较小的那个上 

> 给定一个数组 数组的每个值代表矩形的个数 求构成的直方图中最大矩形有多少个方块

以每个单独的一列为标杆 分别向左向右看 直到看到比他低的值为止 移动的次数乘以他自己的高度 就是将此列看成标杆的最大值。 对数组中的每个值都进行此操作 比较出最大值

<img src="/Users/luoxinpeng/Library/Application Support/typora-user-images/image-20210315183015214.png" alt="image-20210315183015214" style="zoom:33%;" />

*用单调栈的思想来阐述*

1. 维持一个由栈底到栈顶从小到大的顺序
2. 如果新来的一个元素比栈顶元素还 要小 则将栈顶元素弹出 此时栈顶元素能向右边扩的最大值就是让他弹出的那个元素（开区间） 向左边扩的最大值就是新的栈顶元素 （如果栈为空 那么就是 -1 即最左边）
3. 数组遍历完后 栈肯定不为空  栈里的每个元素的右边界为数组的长度 因为没有元素让它出栈 左边为下一个栈顶
4. <img src="/Users/luoxinpeng/Library/Application Support/typora-user-images/image-20210315193129658.png" alt="image-20210315193129658" style="zoom:33%;" />

> 给定一个矩阵 里面全是0 和 1 求1构成的最大矩阵的面积

对矩阵的每一行进行遍历 每一行都看成直方图求面积 遍历到下一行时 如果当前值是0 则将新的对应列的大小变成0 否则相加 再求新的直方图的面积



### 3月18日

> 一个矩阵代表环形的山的高度 求能相互看到对方的对数

如果数组中每个数字都不想等

那么当矩阵个数为1 时 对数是0 是2 时 是 1 大于等于3 时 是 (n - 2) * 2 + 1

对于此环形山 除去最高点和第二高点 以自己为中心分别向左向右出发 必有2对 因为碰到比自己高的暂停 如果没碰到那么最高点和次高点就是让他们暂停的理由 再加上 最高点和次高点 中间 的那一条

### 3月19日

> 一个矩阵代表环形的山的高度 求能相互看到对方的对数（会有相同的高度）

1. 首先找到数组中最大值 然后维持一个单调栈（从大到小）然后从最大值的下标开始向前递进（环形）

   **为什么是从最大值开始呢**

   因为这样可以确保在逆时针上一定有比他大的 且不重复

2. 如果下一个值比栈顶元素小 那么入栈

3. 如果相等 则将栈顶元素记录的元素出现的次数 + 1 

4. 如果比它大 则栈顶元素出栈 很明显栈顶元素的下一个元素 就是阻碍他看不到的（逆时针方向） 让它弹出的那个元素就是阻碍他看不到的（顺时针方向）
   则记录出栈的元素的山峰对 一共是C(2,time) + 2 * time (前面是排列组合 n个相同的山峰选两个出来能互相看到) 对于每个山峰 **逆时针方向能看到下一个栈顶  顺时针方向能看到让他弹出的元素 所以是 2 * time**

5. 数组遍历完后 遍历栈 对于非倒数第二个节点 还是上面的公式 因为总有至少2个比他大的

6. 对于倒数第二个节点 如果最大的那个节点只出现了2 次 那么就有2个比他们大 所以还是那个公司 如果只有1 个 那么只加上一个**time**

7. 对于最后一个元素 就是他们自己之前是否能互相看到 为C(2,time)

有点难 逻辑听了之后感觉还行 就是自己想感觉想不出这些。。。。 啊啊啊 城市要我吧 少活5年也行 呜呜呜呜求你啦！！

### 3月20日

> morris遍历

此遍历的特点是 充分利用叶子结点空余的指针 **并且对于有左子树的节点会回到此节点两次 没有的只有一次**

1. 判断当前节点是否有左子树 如果没有则将当前指针指向此节点的右节点 **如果有则找到左子树的最右节点**
2. 如果此最右节点的右指针为空 *则将最右的这个节点的右指针指向当前节点* 并且指向当前节点的指针 **指向 当前节点的左节点**
3. 如果此最右节点的右指针不为空 则将右指针指向变为空 **同时指向当前节点的指针指向右子树** 
4. 重复以上过程 直到cur指针指向空为止

> 如何用morris遍历实现前序 中序 后序 遍历

**关于前序遍历**

在此遍历中 如果一个节点他有左子树 那么会来到这个节点两次 第一次是真正来的时候 第二次是遍历完左子树回来的时候
所以如果一个节点有左子树 则在第一次进来的时候打印 没有的话 直接打印 这样的顺序即是中序遍历

**关于中序遍历**
根据以上可得 来到一个节点的第二次的时候 就是遍历完左子树的时候 所以在第二次打印 没有的 直接打印即可

后序遍历

逆序打印 现场查询吧

> 如何使用avl树 红黑树

这两种树了解性质即可 treemap是红黑树 以及怎么使用 以及如何用红黑树解决高楼轮廓的问题

> 自己解决了八皇后 还行

> 求1到n 可以构成多少种二叉搜索树

也是递归 加 记忆话搜索 当n < = 2 时 很明显能构成的就只有n种

我们的思想是当n大于2时 让数组中的每个元素都当一次爸爸 看看以它为中心的左边有多少个数字 再求其左边能构成多少种 右边同理
两边的种数相乘可以得到当前头部的值 这样循环下去



>  关于java字符串

String s1="123";

String s2=new String("123");

这里s1==s2的结果是false;

为什么结果会不同呢，这里还要涉及到java中字符串缓冲池的问题。
**字符串缓冲池只针对于字面值创建的方式**

java中有字符串缓冲池的概念，通俗的说，就是有个池子，里面放了字符串对象，如果下次申请的新的字符串在池子里已经有了，那就直接把池子里已经有的字符串对象的地址给新的字符串变量，因此池子里原来有的字符串的那个变量和新申请的变量，其实指向的是同一个内存空间。因此例子1里面s1和s2用到的都是同一个内存空间的“123”。所以此时==的结果是true。

再说例子2，由于s2 用new 操作符重新申请了空间，没有用到缓冲池里的原有变量，因此s1和s2虽然对象的值都是“123”，但所属不同内存空间，所以==的结果为false。

> 关于java中 equal 和 == 的区别

|        |  基本数据类型  |                           对象类型                           |
| :----: | :------------: | :----------------------------------------------------------: |
|   ==   | 比较值是否相同 |                     比较饮用地址是否相同                     |
| equals |                | equals没有被重写就比较对象的引用地址是否相同<br />如果重写了的话根据重写的逻辑而定 |

```java
   public static void test(){
        String s1 = "hello";
        String s2 = s1 + ",world";
        String s3 = "hello" + ",world";
        String s4 = "hello,world";
        String s5 = new String("hello,world");
     		//System.out.println(s1 == "hello"); true
			  // System.out.println(s2.equals(s4)); true
        // System.out.println(s2==s4);　 false　　　　
        // System.out.println(s3==s4);　　true　　　
        // System.out.println(s4==s5);　 false　　　　
    }
```

首先如果是**两个字面值**的字符串相加 那么是从字符串池里找 看是否找到再看是否新建 所以<code>s3  == s4 </code> 
如果是一个 **已有对象 加 字面值** 那么是将当前已有对象转换成StringBuilder 然后 通过 append方法添加 再toString() 故返回的对象 肯定 是新的 <code>s2 != s4</code>

new String 不用说了吧

### 3月21日

> 求一个数组中 最长的子数组为target的长度

首先既然是子数组了 那么这个子数组一定是以数组中某个元素作为结尾的 

对于数组中的每一个数组进行考虑 如果当前元素能够以此结尾达到target  那么从数组下标0开始一直加到当前元素记录为sum 由于是连续的 所以数组可以划分为两部分 
后部分是 以当前元素结尾的target 另一部分是 sum - target 那么看看从0往后遍历 谁先到达 sum - target。那么剩下的就是最长的长度

> 求一个数组中奇数和偶数相等的最长子数组

将奇数变为1 偶数变为-1 求target为0的最长子数组

> 以消息体的结构处理二叉树 求二叉树的最大值和最小值

求左子树的最大值和最小值 以及右子树的最大值和最小值 再将其与根节点的值比较 

> 以消息体的形式求二叉树最大搜索二叉树

分别要考虑左子树的最大搜索二叉树的大小 以及 右边最大二叉搜索树的大小 如果左边二叉搜索树的头节点能和 根节点以及 右边的二叉搜索树的根节点连接一在一起 那么就返回根节点

> 求二叉树中任意节点之间的最长路径

<code>maxPath = Math.max(Math.max(left.maxPath,right.maxPath),leftDepth + 1 + rightDepth)</code>

比较左边的最长路径 以及 右边的最长路径 以及包含自己的最长路径

包含自己的最长路径 = 左边的深度 + 1 + 右边的深度

> 求一个部门的活跃值

当前节点来的活跃值 = 当前节点的值 + 儿子节点不来的活跃值

当前节点不来的活跃值 = 儿子节点来的活跃值

### 3月22日

> LRU缓存算法

> 二叉搜索树转双向链表

> 全排列 以及 全组合问题

> 二叉树中所有距离为k的节点

利用hashmap添加父亲 分别向三个方向递归

> 最长同值路径

```java
int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        help(root);
        return maxPath;
    }
    public int help(TreeNode root){
        if(root == null)
            return 0;
        int left = help(root.left);
        int right = help(root.right);
        if(root.left != null && root.left.val == root.val)
            left = left + 1;
        else
            left = 0;
        if(root.right != null && root.right.val == root.val)
            right = right + 1;
        else
            right = 0;
        maxPath = Math.max(maxPath,left + right);
        return Math.max(left,right);
    }
```

> 二叉树中的最大路径和

这道题和上面那道题的关键都是要做到边递归边记录信息

**不管是什么路径 他都会有一个头节点** 即使是叶子结点 也可以看成两个子树是0

由于树中存在正负值 所以我们每次要比较

1. 左子树最大单一路径和 + root.val
2. 右子树最大单一路径和  + root.val
3. 左子树最大单一路径和 + 右子树最大单一路径和 + root.val;
4. root.val （可能左右都是负的 那么就会越加越小）
5. 当前记录的最大路径和

*那么什么又是单一路径和？*

单一路径和是指某一节点只能向左走 或者 向右走的路径和

所以某一节点的最大单一路径和 =  Math.max(Math.max(左边的最大单一路径和，右边最大的单一路径和)  + root.val ,root.val)

所以在help递归函数中 我们返回的是某一节点的最大

### 3月27日

> 动态规划解决机器人问题

> 动态规划解决左上角到右下角的最小路径和

> 动态规划的思想解释 一个数组每个数字可以挑也可以不挑 求其最大值

```java
dp[i] = Math.max(nums[i] + dp[i + 1],dp[i + 1]);
```

这其中每个元素表示为 从右往左以第i号元素结尾的子数组的最大值

> 动态规划解决 目标和

```java
dp[i][j] = dp[i + 1][j + nums[i]] + dp[i + 1][j - nums[i]]
  public int help(int[] nums, int target, int i,int sum){
        if(i == nums.length){
            if(sum == target)
                return 1;
            return 0;
        }
        return help(nums,target, i + 1,sum + nums[i]) + help(nums,target, i + 1, sum - nums[i]);
    }
    //动态规划
    public int DynamicPlan(int[] nums, int S){
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            maxValue = nums[i] + maxValue;
        }
        if(maxValue < S)
            return 0;
        int c = maxValue * 2 + 1;
        int r = nums.length + 1;
        int[][] dp = new int[r][c];
        dp[r - 1][S + maxValue] = 1;
        for(int i = r - 2; i >= 0; i--)
            for(int j = 0; j < c; j++){
                int a = j + nums[i] >= c ? 0 : dp[i + 1][j + nums[i]];
                int b = j - nums[i] < 0 ? 0 : dp[i + 1][j - nums[i]];
                dp[i][j] = a + b;
            }
        return dp[0][0 + maxValue];

    }
```

这其中每个元素代表的含义是 当来到i位置时 且当前和为j时 加到target有几种方法 很明显dp[nums.length + 1] [taget] = 1 

因为当前i已经是越界后的第一个元素了 累加和为target 就只有一种方法啦 其实都是暴力递归来的



> 递归解决可被3整除的最大和 以及动态规划版本

> 递归解决换钱的方法数 以及动态规划

先说左神的递归版本

```java
  public int process(int[] arr, int index,int target){
        int res = 0;
        if(index == arr.length){ //其实就想像成从左往右挨着选 每一种可以选很多张 也可以选0张 数组走完 比较当前值
            res = target == 0 ? 1 : 0;
        }else{
            for(int time = 0; arr[index] * time <= target; time++) //time 代表当前index所指向的钱的张数
                res += process(arr,index + 1,target - arr[index] * time);
        }
        return res;
    }
```

左神的动态规划版本

```java
  public int dpNew(int[] coins,int amount){
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[coins.length][0] = 1;
        for(int i = coins.length - 1; i >=0; i--)
            for(int j = 0; j < amount + 1; j++){
                for(int k = 0; j - coins[i] * k >= 0; k++)
                    dp[i][j] += dp[i + 1][j - coins[i] * k];
            }
        return dp[0][amount];
    }
```

其中dp[i] [j] 的含义是 来到当前i下标的数组时 要找 目标和为 j 的 方法数
而在动态规划方程中 每一个普通的元素的等于 其下面一行元素 减去 0个 arr[i] 1个arr[i] ....的和 直到其小于0 

说人话就是 比如我当前来到了数组的第二个元素 数组的第二个元素为3 我现在和为12 我总共的方法数为 我当前数字选0个 看看来到第三个元素时 和为 12 + 0 有多少种 再加上 我当前选1 个 看看来到第三个元素时 和为 12 - 1 * 3 有多少种。。。。

**如何优化？**

当来到i j位置时 其实dp[i] [j]  = dp[i] [j - arr[i]]] + dp[i + 1] [j]

因为从右往左已经累加过了 

<img src="/Users/luoxinpeng/Library/Application Support/typora-user-images/image-20210330001209487.png" alt="image-20210330001209487" style="zoom:33%;" />

> 解决博弈问题

> 滑动窗口解决全是正数的数组求最长子数组的长度

注意这里只能针对全是正数

> 打家劫舍 动态规划 

> 动态规划解决博弈论

> 动态规划解决三角形求最小和

> 动态规划解决 马在棋盘的问题

数组原来是可以三维的。。。。。。

以及求方法数目 和 方法概率时 其实可以相互转换的

> 一个数组每次只能从首部 和 末尾拿一个数字 求k次后 拿到的总和是多少

1. 暴力递归

2. 动态规划

3. 滑动窗口

   拿完数字之后 剩下的也是连续的 如果让连续的最小 那么拿出的就是最大值 由于拿了k个 所以剩下的就是 length - k 个数字 即窗口大小 让窗口大小维持最小即可

> 动态规划解决剪绳子

### 4月13日

> 求一个数组中最长的子数组小于等于aim的长度

> 跳跃游戏递归和动态规划

> 优美的排列

> 黄金矿工

> 动态规划解决零钱的最少数量

> 字幕大小全排列

> 顺次数
>
> 

> 连续差相同的数字



### 4月18日

左神中级班第一节

> 贪心和打表方式解决苹果的最小袋子数量

> 打表法解决吃草问题

> 石子游戏 博弈论 动态规划 递归

注意这种博弈论问题 父过程的先手到了子过程就是后手

首先不用去想到底谁拿谁不该拿 我们只考虑一种情况 对于同一个人 他只有两种情况 即

- 当前状态下我是先手拿
- 当前状态下我是后手拿

我们对于第一种情况显然 公式为 左边右边选一个 然后加上后手拿的东西 取最大值即

<code>Math.max(arr[left] + second(left + 1, right),arr[right] + second(left,right - 1))</code>

对于后手的情况 我们的获得的情况不用取叠加值 只需要返回下一次我们先手时就好啦 即是我们下一次轮到我们先手的时候 由于大家都是超好发挥 所以取最小那个

<code>Math.min(this.first(arr, left + 1, right), this.first(arr, left, right - 1))</code>

至于两个边界情况 对于先手 只有一个时 就拿 后手返回0

打表法就是打印出 然后找规律

> 预处理技巧 解决 正方形染色问题 最终结果要让数组的左边全是G 右边全是R

1. 第一种方法

   我们分别这样想 数组的左边的长度分别是0 到 lenght 右边即为剩下的长度 每次都要让左边的全是g 右边全是 r 所以每一次都统计左边的r 和右边的 g 平方的复杂度

2. 预处理

   提前生成两个数组 分别表示 红色和绿色的个数

>  求矩阵中边长全部为1 的正方形的边长

**首先矩阵中如何求出所有的子矩形**
矩阵中任选一个点  $ n^{2} $ 我们再任选一个点$n^2$  可以组成唯一的一个巨型 但是会有重复的 即使减去重复的 整个复杂度也是 $n^4$ 

**然后矩阵中如何求出所有的子正方形**

矩阵中任选一个点  $ n^{2}  $ 再以此点为顶点 不断扩大其边长（不会向上或者向左试探！！ 不然会重复呀） 知道超过row的最大值 或者col的最大值 就是此点为顶点的所有正方形

拿到正方形后 去验证当前正方形是否边全部为1 如果再次遍历的话 整个复杂度会四次方

所以提前准备两个数组 down 和 right 分别表示 以当前元素为起点 向下和向右分别有多少个连续的1 如果这些连续的1大于等于边长则满足 

> 1. 一个函数可以等概率返回1到5 加工出等概率返回1到7
> 2. 一个函数等概率返回a到b 加工出等概率返回c到d
> 3. 一个函数p概率返回1 1 - p 概率返回 0 加工出等概率返回0 和 1

左神中级班第二节

> n个节点的二叉树一共有几种结构

首先题目问的是结构 也就是说**同一结构不同值只算成一种情况**

那么很明显n = 0时 一共1种结构 及 null

n = 1时 也是1种结构 n = 2时 两种 

当n > 2时 我们给做节点分配a 个节点  右边分配 n - a - 1个节点（**减掉的1 根节点**） 然后

```java
for(int i = 0; i <= n - 1; i++){
            res = res + getNumberTrees(i) * getNumberTrees(n - i - 1);
        }
        return res;
```

> 完整括号字符串
>
> 1. 生成n对有效括号
> 2. 判断有效括号 带*
> 3. 将现有字符串改成合格的括号字符串最少需要添加多少个括号

**首先讲一下如何判断一个字符串是否是有效括号的算法**

声明一个变量等于0 然后从左往右遍历 如果遇到左括号 + 1 右括号 - 1 如果在某一时刻 count = - 1 那么代表右括号比左括号先出现 则直接false

如果遍历完后 count == 0 则代表 左括号和右括号的数量相等 且可以相互抵消 那么就说明符合的

1. 递归生成所有可能的字符串 根据刚才的规则筛选 边生成边筛选

2. 递归判断 当遇到 * 时 <code>return checkValidStringHelp(str,index + 1, count - 1) || checkValidStringHelp(str,index + 1, count + 1) ||checkValidStringHelp(str,index + 1, count);</code>

   再将此改成动态规划

3. 利用刚才的判断算法 如果count = -1 了 则ans + 1 并且count  + 1 最后看count为多少 则代表 左括号比右括号多多count个 再将ans + count

> 差值为k的数字对

> magic 操作 以后再做

### 4月19日

> 动态规划解决[解码方法](https://leetcode-cn.com/problems/decode-ways/)

> 数组中连续子数组和最大

### 5月3日

>  股票的最大利润六道题

> 分隔数组以得到最大值

### 5月6日

> 删除并获得点数

排序后成了打家劫舍

> 矩阵中的路径

> 小球会落向何处

> 下降路径最小和

> 分汤

题不难 就是第一次遇到解空间是double的 注意一个小技巧 n + 25 - 1 / 25 是向上取整

> 分披萨

一个人拿了一块披萨后 前一块和后一块会被别人拿走 求这个人能拿到最多的披萨大小是多少（披萨的块数是3的倍数）

可以将此问题转换成 **在3n个数中拿n个数 且每一个数字不能两两相邻 求最大和是多少**

我们可以很轻松的列举出所有情况 但由于是环状的 所以 **头部和尾部不能出现在同一个解中** 所以我们控制边界条件 两次比较即可

这道题和打家劫舍2 环状很像

> 打家劫舍2

> 做菜顺序

### 5月8日

> 左神中级班.第三节.括号的深度

还是那个算法遇到左括号count++ 右括号count-- 整个过程中count的最大值就是括号的深度

> 左神中级班.第三节.找到最长的有效括号子串

这道题直接写动态规划

首先声明dp数组每一项为dp[i] **表示以第i个字符结尾 的 有效最大子串长度**

很明显如果第i个字符是左括号那么dp[i] = 0 因为没有任何一个有效的括号字符串是以左括号结尾的

如果第i个字符是右括号 那我们就看看d[i - 1] 等于多少 假如d[i - 1] = 3 则i位置前3个位置都是有效的 **那么再看i - 1位置往前推d[i -  1]的位置 是不是 左括号**

1. 如果是右括号 则d[i] = 0 因为如果此位置之前还多出了一个左括号那么d[i - 1]的位置就不对了

2. 如果再前一个是左括号那么d[i] 起码是  d[i - 1] + 2 **即这个左括号 和 i位置的右括号相匹配** 再看看 这个左括号前的那个位置的有效长度是多少 接上去

   即d[i] = 2 + d[i - 1] + d[i - 1 - d[i - 1] - 1]

> 左神中级班.第三节.将栈里的数据排序 要求最多使用一个额外的栈存放临时数据 栈顶元素最大

结果栈从小到大 辅助栈从大到小

从给的栈中依次取元素压入辅助栈 如果辅助栈为空直接压入 **如果当前给的元素比辅助栈顶的元素大** 则辅助栈一直弹出 并且压到给的栈中 直到给的元素能够进去辅助栈为止 辅助栈弹出的元素又压回去原栈

这样辅助栈的元素就是从大到小 再倒回去

### 5月12日

> 左神中级班.第四节.洗衣机问题

- 先看看所有的衣服能不能整除洗衣机的个数 如果可以的话 再继续下面的 否则直接返回-1
- 遍历整个数组 对整个数组进行考量 
  1. 如果i位置左边所有实际的衣服 剪去 应有的衣服 是 负数 且右边也是 则代表i位置要往两边发 则一共是 两边的绝对值相加 
  2. 如果两边一正一负 则应该是两边绝对值较大的那个
- 答案是满足最欢情况下的ans 即边遍历边记录

### 6月4日

> #### [停在原地的方案数](https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/)

题很简单 主要是两个坑

1. 关于取模的话 每两个数相加就要取模 不是所有加起来再取
2. 二维到1维的优化 可以新开辟一个临时数组 每一次

### 6月5日

> #### [最少侧跳次数](https://leetcode-cn.com/problems/minimum-sideway-jumps/)

挺常规的一道递归改动态规划的题 分情况讨论即可 学到一个小技巧

无效值 根据场景前面要加的 可以设置为 Interger.MAX_VALUE - 1

> #### [堆箱子](https://leetcode-cn.com/problems/pile-box-lcci/)

按照长 宽 高 某一个进行排序后 最终的答案一定是排序后的子序列

然后就成了向前递归的擅长的题目了 

只是一些解空间有负数的时候 可以适当的改成正空间 + 1

> #### [下降路径最小和  II](https://leetcode-cn.com/problems/minimum-falling-path-sum-ii/)

很常规 甚至可以直接写出转移方程

### 8月25日

> #### [787. K 站中转内最便宜的航班](https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/)

很久没写题了 真的好生疏 好菜 得自我反省下！

首先递归版本都写的很头疼 属实不应该

大致翻一下就是

从前向后递归（不用排序）

如果当前航班的起点是传入的起点就选择 否则返回大值 

注意临界条件 一个是起点==终点了 代表到了

第二个是 转航班的次数用完了

```java
  public int getMinMoney(int k, int[][] flights, int src, int dst){
        if(src == dst)
            return 0;
        if(k < 0)
            return 100007;
        int minMoney = 100007;
        for (int[] flight : flights) {
            if(flight[0] == src)
                minMoney = Math.min(minMoney,flight[2] + getMinMoney(k - 1,flights,flight[1],dst));
        }
        return minMoney;
    }
```

改成动态规划

行代表起点 列代表次数

**每一个元素代表起点为i最多转k次的最小钱**

注意这里的边界条件 首先当矩阵的行数等于 == 目的地时 肯定都是0 自己到自己都是0

然后矩阵的第一列 由于代表的意思是 只换乘0次 所以直接看原数组是否有直到的航班 有就是那个价格 否则就是无效值

对于普通位置的数据 动态方程可以简述为 如果该数组有以当前行为起点的航班 就是当前价格 + 当前航班到达的点的地方 转换次数为k的最小值

```java
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
   int[][] dp = new int[n][k + 1];
        for (int i = 0; i < dp.length; i++) {
            if(i == dst)
                dp[i][0] = 0;
            else{
                dp[i][0] = 100007;
                for (int[] flight : flights) {
                    if(flight[0] == i && flight[1] == dst)
                        dp[i][0] = flight[2];
                }
            }
        }
         if(k > 0){
            for(int j = 1; j <= k; j++)
                for(int i = 0; i < dp.length; i++){
                    if(i != dst){
                           int minMoney = 100007;
                    for (int[] flight : flights) {
                        if(flight[0] == i)
                            minMoney = Math.min(minMoney,flight[2] + dp[flight[1]][j - 1]);
                    }
                    dp[i][j] = minMoney;
                    }
                 
                }
        }
  
        return dp[src][k] == 100007 ? -1 : dp[src][k];
    }
}
```

### 8月26日

> #### [出界的路径数](https://leetcode-cn.com/problems/out-of-boundary-paths/)

数据太大取模运算时 注意几个相加时可能会溢出 所以数据类型取long 每加一次 取模 最后再取模

> #### [根到叶路径上的不足节点](https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths/)

一道还算常规的树的题目 整体还好 就是好久没做树了 复习下感觉 

这道题有个坑是 如果某个非叶子结点的左右孩子结点都被删除了 它自身形成了新的叶子结点 这个新叶子结点也应该被一并删除 不应感参与新的比较

假如通过节点 `node` 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 `limit`，则该节点被称之为「不足节点」，需要被删除。

### 8月27日

> #### [跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

 挺简单的动态规划

> #### [跳跃游戏 III](https://leetcode-cn.com/problems/jump-game-iii/)

这道题不能用动态规划 因为要看是从哪里过来的

这里的技巧是将访问的数组变为-1

如果访问到变成-1 的地方 直接返回false 因为变成-1的地方有两个原因

* 此点本身不为0
* 此点已经被计算过或者正在计算 避免重复计算

### 9月19日

> [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)

这道题也是递归到动态规划

如果有一点的index走到头了 那么肯定返回0

如果两个的当前下标所对应的字母刚好相等 那么一定是返回 1 + 两个下标向前的子解

怎么证明呢？

就好比你在两个原串上都加了两个相同的字母 那么肯定是最终值加上相同的数量

如果两个下标所对应的值不相同

那么就比较两个分别进1的最大值

```java
public int longestCommonSubsequence(String text1, String text2) {
    return help(text1,text2,0,0);
}
public int help(String text1, String text2, int index1, int index2){
    if(index1 >= text1.length() || index2 >= text2.length())
        return 0;
    else if(text1.charAt(index1) == text2.charAt(index2))
        return 1 + help(text1,text2,index1 + 1, index2 + 1);
    else
        return Math.max(help(text1,text2,index1 + 1,index2),help(text1,text2,index1,index2 + 1));
}

public int longestCommonSubsequence(String text1, String text2) {
int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = text1.length() - 1; i >= 0; i--)
            for(int j = text2.length() - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
            }
        return dp[0][0];
    }
```

> #### [118. 杨辉三角](https://leetcode-cn.com/problems/pascals-triangle/)

其实蛮简单的

第几行就有的数字的数量就是它的行号

对于每一行的数字（下标为index）的值 = 上一行index - 1的值 加上 上一行index的值 当然考虑越界

> #### [650. 只有两个键的键盘](https://leetcode-cn.com/problems/2-keys-keyboard/)

 用preNum来记录复制中的内容 用curNum来记录当前记事本有多少个字符

对于第一步 肯定要先复制 故preNum 等于 0 时 返回 1 + 问题的子解 这里的1代表操作次数

对于一般情况 要么是 返回 1 + 子解（现有的数字+ 内存里的数字 并且维持内存里的数字不变）

要么是改变内存里的数字 2 + 子解（内存里的数字更新为现在有的数字 现在有的数字 加上 现在有的数字） 

为什么是2呢？ 因为你改变复制后 下一步必须粘贴 否则无限循环

可以改成动态规划

```java
public int minSteps(int n) {
    return help(n,0,1);
}
public int help(int targetNum,int preNum, int curNum){
    if(curNum > targetNum)
        return 3000;
    if(curNum == targetNum)
        return 0;
    if(preNum == 0)
        return 1 + help(targetNum,curNum,curNum);
    return Math.min(2 + help(targetNum,curNum,curNum + curNum),1 + help(targetNum,preNum,curNum + preNum));
}
public int dp(int n){
    int[][] dp = new int[n + 1][n + 1];
    for(int i = n - 1; i >= 0; i--)
        for(int j = n - 1; j >= 0; j--){
            if(j != 0)
                dp[i][j] = Math.min(2 + getValue(dp,i + i,i),1 + getValue(dp,i + j,j));
            else
                dp[i][j] = 1 + getValue(dp,i,i);
        }
    return dp[1][0];
}
public int getValue(int[][] dp, int i, int j){
    if(i > dp.length - 1)
        return 3000;
    return dp[i][j];
}
```

### 9月20日

> #### [300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)

这道题怎么说呢 写好的递归改成动态规划还不是很好改

递归无非就是index向下走 如果当前值比前一个值大 就 return max（要当前值 加入子序列 ， 继续用前面的值当子序列）

可以看到是两个参数

如果直接动态规划的话 反而更简单 动态转移方程也比较好想 **dp[i] 表示已当前元素结束的序列 的最长递增子序列的长度是多少**
对于第一个元素 当然是1 然后数组从前向后遍历 **每一个元素的初始值应该为1 应为再差 他都可以以它自己结尾 所以长度为1**

然后在从数组的开始位置遍历到当前元素的前一个位置 每一次如果有当前元素比遍历到的元素大 那么遍历到的元素的最大升序序列加上当前元素肯定也满足 所以+ 1

```java
public int dp(int[] nums){
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int res = 1;
    for(int i = 1; i < dp.length; i++){
        dp[i] = 1;
        for(int j = 0; j < i; j++){
            if(nums[j] < nums[i])
                dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
        res = Math.max(res,dp[i]);
    }
    for (int i : dp) {
        System.out.println(i);
    }
    return res;
}
```

> 最长递增子序列的个数

```java
public int getDp(int[] nums){
    int[] dp = new int[nums.length];
    int[] counts = new int[nums.length];
    for (int i = 0; i < counts.length; i++) {
        counts[i] = 1;
    }
    dp[0] = 1;
    int maxLength = 1;
    for(int i = 1; i < dp.length; i++){
        dp[i] = 1;
        for(int j = 0; j < i; j++){
            if(nums[j] < nums[i])
               {
                   if(dp[j] + 1 > dp[i]){
                       dp[i] = dp[j] + 1; //如果最长递增子序列更新了 那么出现的次数 就是让他更新的值的次数
                       counts[i] = counts[j];
                   }
                   else if(dp[j] + 1 == dp[i]) //如果刚好算上自己 等于自己现在最长值 那么加上它出现的次数
                       counts[i] += counts[j];
               }
        }
        maxLength = Math.max(dp[i],maxLength);
        }
    int count = 0;
    for(int i = 0; i < dp.length; i++){
        if(dp[i] == maxLength)
            count += counts[i];
    }
    return count;
    }
```

### 9月21日

> [14. 最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/)

既然是每一个字符串都有公共前缀 那么就取第一个字符串依次取其头部 去和后面的字符串比较 如果后面的字符串都能starwith 它 那么代表其截取的长度是符合的 如果比上一个大 更新即可

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
String res = "";
        for(int i = 0; i < strs[0].length(); i++){
            String temp = strs[0].substring(0,i + 1);
            boolean flag = true;
            for(int j = 1; j < strs.length; j++)
                if(!strs[j].startsWith(temp)){
                    flag = false;
                    break;
                }
            if(flag && temp.length() > res.length())
                res = temp;
        }
        return res;
    }
}
```

> String是一个特殊的包装类数据。可以用：
> String str = new String("abc");
> String str = "abc";
> 两种的形式来创建，第一种是用new()来新建对象的，它会在存放于堆中。每调用一次就会创建一个新的对象。
> 而第二种是先在栈中创建一个对String类的对象引用变量str，然后查找栈中有没有存放"abc"，如果没有，则将"abc"存放进栈，并令str指向”abc”，如果已经有”abc” 则直接令str指向“abc”。

> #### [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

这道题用滑动窗口来解决 首先子串不是子序列 所以必须是连续且顺序相同

那么结果肯定是以字符串某个字符开始的结果 也就是说依次求出按照**每一个字符开始的最长字串 那么结果一定是在其中**（最大值）

考虑滑动窗口 左指针指向某个字符开始的最长字串的起始位置 右指针指向结束位置 当求完当前字符的后 依次向后扫描求 此时 **起始指针 + 1 到结束指针 一定是不重复的(相当于一个子集)** 那么只需要移动尾指针 当尾指针无法移动了就找到了 这中间的过程用hashset来实现  注意每一轮要删掉上一轮的起始位置

```java
public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        HashSet<Character> hashSet = new HashSet<>();
        int res = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while (j < s.length() && hashSet.add(s.charAt(j)))
                {
                    j++;
                }
            res = Math.max(res,j - i);
            System.out.println(j - i);
            hashSet.remove(s.charAt(i));
        }
        return res;
    }

```

> #### [139. 单词拆分](https://leetcode-cn.com/problems/word-break/)
>
> 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
>
> 说明：
>
> 拆分时可以重复使用字典中的单词。
> 你可以假设字典中没有重复的单词。
>
> 输入: s = "leetcode", wordDict = ["leet", "code"]
> 输出: true
> 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

也是一个很正常的递归的从前向后扫描 每一次扫描的长度直到当前区间包含的字符串能在wordDict中找到 然后将剩下的字符串再一次递归 如果index来到了字符串最后 代表前面全部能找到对应的字典 则返回true

```java
public boolean help(String target, List<String> wordDict, int index){
    if(index >= target.length())
        return true;
    boolean flag = false;
    for(int i = index; i < target.length(); i++)
        if(wordDict.contains(target.substring(index,i + 1)))
            {
                flag = flag || help(target,wordDict,i + 1);
            }
    return flag;
}

public boolean dp(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[s.length()] = true;
    for(int i = dp.length - 2; i >= 0; i--){
        boolean flag = false;
        for(int j = i; j < s.length(); j++){
            if(wordDict.contains(s.substring(i,j + 1))){
                flag = flag || dp[j + 1];
            }
        }
        dp[i] = flag;
    }
    return dp[0];
}
```

> #### [140. 单词拆分 II](https://leetcode-cn.com/problems/word-break-ii/)

直接递归回溯即可。。。。。。

#### 9月22日

> #### [725. 分隔链表](https://leetcode-cn.com/problems/split-linked-list-in-parts/)

都是些基本功操作 思想是每个段落的基本长度为 n / k 剩下的 n % k 每一个添加到一组里面 然后就是些边界条件判断

> #### [165. 比较版本号](https://leetcode-cn.com/problems/compare-version-numbers/)

 当年的面试题 哎 今天看来也太简单了

方法一 利用split函数 注意 '.' 需要使用转义字符 然后将分隔后的字符串数组转换成int值 进行比较即可 缺点是要开辟新的空间

方法二 一边遍历一边比较 每一次每一个字符串都只遍历 一个'.'前面的位置 并且根据乘法规则乘 10 转换成相应的数字比较即可

> #### [290. 单词规律](https://leetcode-cn.com/problems/word-pattern/)

哈希表记录查找即可

> #### [97. 交错字符串](https://leetcode-cn.com/problems/interleaving-string/)

递归到动态规划

每一次递归 都是两种情况 如果s1的前几个符合s3所对应的 就传下去 s2符合的 就传下去 两种情况都列出来 两个参数一个指向s1 一个指向s2 s3 要对比的就是 s1 + s2 

其实就是每次递归 在满足字母相同的情况下 要么选i个s1 要么选i个s2 挺简单的其实 主要是一些边界条件 比较难扣
                    

```java
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    if(s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = dp[i].length - 1; j >= 0; j--){
                if(i + j >= s3.length())
                    {
                        dp[i][j] = true;
                        continue;
                    }
                boolean flag = false;
                int targetIndex = i + j;
                int a = targetIndex;
                for(int k = i; k < s1.length(); k++){
                    
                    if(s1.charAt(k) == s3.charAt(a)){
                        flag = flag || ( k + 1 >= dp.length ? false : dp[k + 1][j]);
                        a++;
                    }
                    else
                        break;
                }
                int b = targetIndex;
                for(int k = j; k < s2.length(); k++){
                   
                    if(s2.charAt(k) == s3.charAt(b)){
                        flag = flag || (k + 1 >= dp[i].length ? false : dp[i][k + 1]) ;
                        b++;
                    }
                    else
                        break;
                }
                dp[i][j] = flag;
            }
        }
        return dp[0][0];
    }
}
```

> #### [474. 一和零](https://leetcode-cn.com/problems/ones-and-zeroes/)

三维的背包问题 太简单 常规 不解释

> [至少有 K 个重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/)

首先我们开辟一个26长度的数组 每一个数对应相应的字母的出现次数 即count[char - 'a']

我们先扫描一圈数组 统计处当前字符串各个字符的出现次数

然后遍历字符串 

如果发现当前字符没有大于k 那么最终答案肯定不包含当前字符 故去统计其左边和右边 取最大值即可 分治的思想 记得改变start 和 end即可

```java
class Solution {
    public int longestSubstring(String s, int k) {
        return help(s,k,0,s.length() - 1);
    }
    public int help(String s, int k, int start, int end){
      if(start > end)
            return 0;
        int[] count = new int[26];
        for(int i = start; i <= end; i++)
            count[s.charAt(i) - 'a']++;
        for(int i = start; i <= end; i++){
            if(count[s.charAt(i)- 'a']  < k){
                int l = help(s,k,start,i - 1);
                int r = help(s,k,i + 1,end);
                return Math.max(l,r);
            }
        }
        return end - start + 1;
    }
}

```

> #### [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

直接排序 api太差劲了

根据堆排序的规则 先建堆 然后每一次堆顶都是最大的 那么我们取n次 堆化n次 即是答案

> #### [521. 最长特殊序列 Ⅰ](https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/)

对于两个字符串 如果equals相等 那么直接返回-1。因为肯定子序列都是相通的

对于不相同的情况下大的字符串的那个本身也是序列之一 它不可能是小的那个的子集 返回其长度即可

> #### [1079. 活字印刷](https://leetcode-cn.com/problems/letter-tile-possibilities/)

跟全排列2一样 

其实就是对所给的字符串选n次 每次从剩下没有被选过的中选择 选择的时候可以选也可以不选 但都要让选择的次数加1 因为不选也是一种选择 最后有可能组成的排列是一样的 所以要用到 hashset

> #### [从叶结点开始的最小字符串](https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/)

注意stringBuilder 和 字符串的compareTo即可

### 9月24日

> #### [397. 整数替换](https://leetcode-cn.com/problems/integer-replacement/)

注意动态规划加一时 等价于变换成 除以2的偶数

> #### [396. 旋转函数](https://leetcode-cn.com/problems/rotate-function/)

1. 递归
2. 迭代
3. 动态规划
4. 找规律 F(n)=F(n-1)+sum-n*nums[pos];

### 9月26日

> #### [583. 两个字符串的删除操作](https://leetcode-cn.com/problems/delete-operation-for-two-strings/)

1.第一种解法 

​	由于要删除的次数最小 所以他们剩下的肯定是最长公共子序列 所以这道题就可以先求最长公共子序列 然后返回

​	每个字符串和最长公共子序列的差值和即可

2. 第二种解法

   还是来模拟删除 模拟删除时 可以不用删除字符串之类的 直接移动index即可 

   递归终止的条件是什么呢？ 是其中一个字符串走到尾部了 如果另一个字符串还没到尾部 就代表他比公共的多了没到尾部的步数

   所以递归终止的条件为二者当前下标到长度的差值

   至于一般的处理 如果当前两个下标的字符相等 则不需要删除 直接向后加一即可

   如果两个不相等 则代表一次操作中要删除一个字符 所以两边都要试一试 返回最小值加一即可

### 9月27日

> #### [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)

以前觉得很难的题 现在都觉得好简单 关于字符串的问题 如果问题提出可以编辑 删除 替换 其实不用真的去改变字符串
只需要移动下标即可 如替换就是 操作数加一 然后移动下标 其实怎么说呢 这道题真的还蛮简单的 就是移动下标的思想

只是注意递归的终止条件 如果两个下标有一个达到尾部了 那么看是否都是两个都到尾部 如果都到尾部了 那么就返回0。代表相等

如果不相等 那就是返回没到头的那个差值 因为对于他而言 剩下的可以是删除 替换都可以啦

> #### [不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/)

这也算困难题？
s中的子序列有多少个t 
无非就是两个下标一个指向s 一个指向t 从前向后递归
遇到s[i] == t[j] 的时候 我们可以让两个下标都往前面走  即表示配对
但是j也可以等后面的相同的配对 即j走 i不走 这种情况 也适用于两个字符不相等的时候 代表当前i不等于j的字符 所以i往前找
递归终止条件是一方走到了尽头 如果是j 代表匹配完 返回1

```python
 public int numDistinct(String s, String t) {
        return help(s,t,0,0);
    }
    public int help(String s, String t, int index1, int index2){
        if(index1 == s.length() || index2 == t.length()){
            if(index2 == t.length())
                return 1;
            return 0;
        }
        int res = 0;
        if(s.charAt(index1) == t.charAt(index2))
            res += help(s,t,index1 + 1,index2 + 1);
        res += help(s,t,index1 + 1,index2);
        return res;
    }
    public int dp(String s, String t){
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i][t.length()] = 1;
        for(int i = dp.length - 1; i >= 0; i--)
            for(int j = dp[i].length - 2; j >= 0; j--){
                int res = 0;
                if(s.charAt(i) == t.charAt(j))
                    res += dp[i + 1][j + 1];
                res += dp[i + 1][j];
                dp[i][j] = res;
            }
        return dp[0][0];
    }
```

> #### [392. 判断子序列](https://leetcode-cn.com/problems/is-subsequence/)

看下面的代码 为什么下面是直接return 找到 而不是叠加 同上面道题不一样 因为只需要找到 不需要找到次数
对于找到如果后面还有 那我们可以把后面那个删除 例如 afffabc 去匹配 abc 第一次匹配到a了 后面那个a可以不管 效果是一样的

```java
public boolean help(String s, String t, int index1, int index2){
    if(index1 >= s.length())
        return true;
    if(index2 >= t.length())
        return false;
    if(s.charAt(index1) == t.charAt(index2)) //为什么下面是直接return 找到 而不是叠加 
        return help(s,t,index1 + 1, index2 + 1);
    return help(s,t,index1,index2 + 1);
}
```

> #### [ 最长连续递增序列](https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/)

第一种方法自己悟吧 就是遇到比前一个小的 那么更新 动态规划反而更简单 对于第一个元素就是长度为自己 对与后面每一个元素 如果比前一个大 则是前一个的长度加上1 否则 就是1

```java
public int findLengthOfLCIS(int[] nums) {
    if(nums == null || nums.length == 0)
        return 0;
    int max = 1;
    int start = 0;
    for(int i = 1; i < nums.length; i++){
        if(nums[i] <= nums[i - 1]){
            start = i;
        }
        max = Math.max(i - start + 1, max);
    }
    return max;
}

public int findLengthOfLCIS(int[] nums) {
if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < dp.length; i++){
            if(nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
```

#### [718. 最长重复子数组](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/)

记住，子序列默认不连续，子数组默认连续

这道题递归不好写 直接动态规划吧
以数组a作为行 数组b作为列 dp[i][j } 表示的意思是以a数组的i元素和b数组的j元素作为截止时两个的最长连续子数组 这个子数组是包含他们的
所以对于普通的情况 如果两个字符相等 那么代表包含 则长度加一 再看看两个数组的分别前一个是多少 加上来 否则当前等于0

```java
class Solution {
   public int findLength(int[] A, int[] B) {
        //直接动态规划吧
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[A.length][B.length];
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++){
                if(A[i] == B[j])
                    dp[i][j] = getValue(dp,i - 1, j - 1) + 1;
                else
                    dp[i][j] = 0;
                max = Math.max(max,dp[i][j]);
            }
        return max;
    }
    public int getValue(int[][] dp, int i, int j){
        if(i < 0 || j < 0)
            return 0;
        return dp[i][j];
    }
}
```

> #### [1035. 不相交的线](https://leetcode-cn.com/problems/uncrossed-lines/)

可以根据题意 很简单的写出递归和动态规划版本

但其实这道题就是求最长公共子序列！！！！

### 9月28日

> 排序专题

1. 归并排序

   就是把数组一直对半拆分 类似于递归一样 一直往下分 分到最后每个子数组就一个值 然后往上归 
   然后将左边的和右边的合并 就是两个有序数组的合并 新建一个临时数组 存放合并的值 再改变原数组

   应用：链表的归并排序
   按照链表的中点分为左右两部分 子函数返回两个有序列表的头节点 再合并两个有两个有序链表

### 10月1日

> #### [面试题 16.18. 模式匹配](https://leetcode-cn.com/problems/pattern-matching-lcci/)

其实算法的思想很简单 就是不断分配a的长度和b的长度 去匹配整个字符串 类似于一个二元一次方程 只是有很多地方需要注意
一些边界条件呀

1. 如果patter为空 那么value也必须为空

2. 如果value为空 则patter中只能有一个字符 该字符表示空 另一个不存在

3. 再来考虑两个value 和 patter不为空的情况下 在此情况下 在patter中a的字符可能出现x个 b的字符可能出现y 个 这里我们以a为自变量 b为因变量 可得
   <code>lengthY = (valueLength - lengthA * countA) / countB</code>

     其中<code>lengthA</code>在<code>[0,valueLength / countA]</code> 上变化 即表示a可能表示空 或者 b表示空的话 那么全部都由于a来匹配

   很明显上述两个式子中 都要除以 countA 或者 countB 而在一边的情况中 这两个值都很有可能是0

   当countA等于0 时 即全为b 我们则把patter中b全部换为a 即可巧妙避免

   对于countB 等于0时 直接 让y的长度等于0 即可

4. 剩下的过程都是不断枚举a 和 b的长度 看是否匹配即可。

> #### [1048. 最长字符串链](https://leetcode-cn.com/problems/longest-string-chain/)

听常规的一道动态规划 将字符串数组按照长度大小排序后 就可以使用我们平常最欢用的向后递归了

注意判断是否可以添加一个字符后 两个字符串代表的值相等的判断方法

```java
public boolean isValid(String word1, String word2){
         if(word2.length() - word1.length() != 1)
            return false;
        int flag = 0;
        int i = 0,j = 0;
        while(i< word1.length() && j < word2.length()){
            if(word1.charAt(i) == word2.charAt(j)){
                i++;
                j++;
            }else{
                flag++;
                j++;
                if( flag > 1) 
                    return false;
            }
        }
        return true;
    }
```

> #### [1653. 使字符串平衡的最少删除次数](https://leetcode-cn.com/problems/minimum-deletions-to-make-string-balanced/)

挺简单的动态规划现在都懒得写递归了 
首先dp[0] 肯定是0 不管这个字符是a还是b。因为题目说的是存在a 再考虑 是a的话 当然满足 是b的话 因为前面没有a 所以直接也为0

对于一般情况 如果当前字符是b 那么平衡的次数 就是上一个的平衡次数 因为上一个经过n次后 已经平衡了 你再来一个b 也满足这个条件

如果当前字符是a 那就要考虑了 因为a前面不能有b 所以比较要么删除前面所有的b 或者 删除自己

> #### [1578. 避免重复字母的最小删除成本](https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/)

首先说明一点 在满足动态规划的方法下 不会出现说删掉前一个字符 会出现 现在的字符 会和前前一个字符相等的情况下 这样的话就代表当前字符和前一个字符并不相等 怎么会删除呢～

那么动态转移方城其实很容易写出来 就是遇到和前一个字符相同时 当前字符结尾的成本 为 删除最小的成本 加上 前一个成本 然后把代价函数换为代价较为大的那个 最小的那个走了

留下的就是最大的了 考虑这样一种情况 假设 a a 我们其实删除的是第二个a。现在又来一个a 虽然是和i - 1 比较是否相等 但由于前两个字符相同 所以比较是一样的 并且代价函数也已经换好了

### 10月2日

> #### [面试题 17.08. 马戏团人塔](https://leetcode-cn.com/problems/circus-tower-lcci/)

先排序 然后基本不用递归 就可以写出动态规划

dp[i] 表示以i为结尾的最大层数 每一次从前向后依次比较 如果i比j都大 那么就等与dp[j] + 1 记录最大值即可 

### 10月5日

> #### [983. 最低票价](https://leetcode-cn.com/problems/minimum-cost-for-tickets/)

现在来看动态规划 很多地方都想把把变量压缩成一维的这样可以省下很多空间

对于这道题 首先我们可以把价格写到每次返回的加和值上 然后对于index 以及 当前index选择不同票价包含的天数 一开始把有效期都保存起来 但是完全不用 直接把index
移动到包含的过期那次就可以了 

```java
public int help(int[] days, int[] costs, int day, int index){
    if(index >= days.length)
        return 0;
    if(days[index] <= day)
        return help(days,costs,day,index + 1);
    int res = Integer.MAX_VALUE;
    res = Math.min(res,help(days,costs,day + 1,index + 1) + costs[0]);
    res = Math.min(res,help(days,costs,day + 7,index + 1) + costs[1]);
    res = Math.min(res,help(days,costs,day + 30,index + 1) + costs[2]);
    return res;
}
public int helpOneDe(int[] days, int[] costs, int index){
    if(index >= days.length)
        return 0;
    int res = Integer.MAX_VALUE;
    int tempDay = days[index];
    int tempIndex = index;
    while (tempIndex < days.length && days[tempIndex] < tempDay + 1)
        tempIndex++;
    res = Math.min(res,costs[0] + helpOneDe(days,costs,tempIndex));
    tempIndex = index;
    while (tempIndex < days.length && days[tempIndex] < tempDay + 7)
        tempIndex++;
    res = Math.min(res,costs[1] + helpOneDe(days,costs,tempIndex));
    tempIndex = index;
    while (tempIndex < days.length && days[tempIndex] < tempDay + 30)
        tempIndex++;
    res = Math.min(res,costs[2] + helpOneDe(days,costs,tempIndex));
    return res;
}
public int dp(int[] days, int[] costs){
    int[] dp = new int[days.length + 1];
    for(int i = dp.length - 2; i >= 0; i--){
        int res = Integer.MAX_VALUE;
        int tempDay = days[i];
        int tempIndex = i;
        while (tempIndex < days.length && days[tempIndex] < tempDay + 1)
            tempIndex++;
        res = Math.min(res,costs[0] + dp[tempIndex]);
        tempIndex = i;
        while (tempIndex < days.length && days[tempIndex] < tempDay + 7)
            tempIndex++;
        res = Math.min(res,costs[1] + dp[tempIndex]);
        tempIndex = i;
        while (tempIndex < days.length && days[tempIndex] < tempDay + 30)
            tempIndex++;
        res = Math.min(res,costs[2] + dp[tempIndex]);
        dp[i] = res;
    }
    return dp[0];
}
```

### 10月7日

> #### [434. 字符串中的单词数](https://leetcode-cn.com/problems/number-of-segments-in-a-string/)

不要觉得这道题很简单 其实挺烦的

首先题目对于单词的定义是 **连续的不是空格的字符** 意思就是像 , , , ,算四个单词 因为每一个逗号都不是空格 而且连续
很明显我们会去想统计空格的个数来判断单词个数 但是如果一个字符串 前面有很多空格开头 两个单词的分隔又是 多个空格 很明显答案不对
所以我们要统计的是 当前一个字符不是空格 然后后面是空格的个数 末尾添加一个空格，可以将空串，空格结尾，字符结尾三种状况归一考虑，减少额外的判断

> #### [956. 最高的广告牌](https://leetcode-cn.com/problems/tallest-billboard/)

草泥马草泥马 一个小细节卡了一上午

首先解空间为负数并不可怕 当你把解空间整体右边移动后 j值的变换其实无所谓 只要他们的转移关系还在就行

对于这种频繁比较的值 要注意返回的无效值是0 还是负数 如果返回值是负数 那么数组的初始值一定要看好 因为它初始值为0 啊！！！！！！！

再回到这道题的思路 其实很简单 就是从前向后递归 一个长度可以乘以1 乘以-1 可以不要 对于乘以1 代表往左边加长度 乘以负一往右边加长度 当递归结束后 看看两边的差值是否为0 

如果为0 代表方案可行 不行返回无效值 至于广告牌的高度 在递归后面加上即可。

```java
class Solution {
  public int tallestBillboard(int[] rods) {
        return help(rods,0,0);
    }
    public int help(int[] rods, int index, int tempValue){
        if(index >= rods.length){
            if(tempValue == 0)
                return 0;
            return -5000;
        }
        return Math.max(help(rods,index + 1,tempValue),Math.max(help(rods,index + 1,tempValue + rods[index]) + rods[index],
                help(rods,index + 1,tempValue - rods[index])));
    }
    public int tallestBillboard(int[] rods) {
 int maxValue = 0;
        for (int rod : rods) {
            maxValue += rod;
        }
        int[][] dp = new int[rods.length + 1][maxValue * 2 + 1];
        for(int i = 0; i < dp[rods.length].length; i++)
            if(i != maxValue)
                dp[rods.length][i] = Integer.MIN_VALUE / 3;
        for(int i = dp.length - 2; i >= 0; i--) // --> index
            for(int j = 0; j < maxValue * 2 + 1; j++){
                dp[i][j] = Integer.MIN_VALUE / 3; //就是这里！！！！！！！！！！！！
               dp[i][j] = Math.max(dp[i][j],dp[i + 1][j]);
               dp[i][j] = Math.max(getValue(i + 1,j + rods[i],dp) + rods[i],dp[i][j]);
               dp[i][j] = Math.max(getValue(i + 1,j - rods[i],dp),dp[i][j]);
            }

        return dp[0][maxValue];
    }
    public int getValue(int i , int j, int[][] dp){
        if(j < 0 || j >= dp[i].length)
            return Integer.MIN_VALUE / 3;
        return dp[i][j];
    }
}
```

### 10月17日

再看荷兰国旗问题 

> 讲小于等于target的数字放在数组的左边 大于target的数字放在右边

注意：这里没有要求小于target的数字一定在等于target的数字的左边！

思想：用下标i记录小于区间的最后一个数字的下标 一开始等于-1 用cur指针遍历数组 从0开始

- 遇到小于等于target的数字与i记录的下标的下一个进行交换 即讲该数字扩大到小于区间的最后个数字 并且cur + 1
  注意这里交换并**不能等同于 直接让小于区间加一 然后 cur + 1 因为** 你遇到小于等于target的数字时候 前面可能很多大雨他的数字 如果直接加一 就把他们算进去了 这就是这道题和真正的荷兰国旗不一样的地方
- 遇到大于target的数字的时候 不用管 因为我们维护了小于等于target的区间 剩下的自然就是大于的啦！



> 荷兰国旗问题 小于的放左边 等于的放中间 大于的放右边

用i指针记录小于区间的最后一个数字 用j指针记录大于区间的第一个数

初始 i = - 1 j = arr.length 

cur 扫描整个数组 遇到小于target的 和 小于区间的最后个数字的后面一个数字交换 并且扩大小于区间 i++ 然后 cur ++ 

这里为什么cur也不用考虑的直接加一呢？
因为小于区间后面的数字只可能是cur现在指向的数字 或者是 等于target的数字 如果是前一种情况自然加一 对于后者 只是单独的交换几个相同的数字而已不影响

对于 大于target的数字 将大于区间的第一个数字的前一个数组交换过来 并且大于区间向前走 

此时cur 不加一！

当cur < right 时 一直循环

> 求二叉搜索树中第k小的数字

用迭代的方法写二叉搜索树的中序遍历方法 每次要打印元素的时候 k-- k==0 时 就是答案

```java
public int findNumber(TreeNode root , int k){
  Stack<TreeNode> stack = new Stack<>();
  while(!stack.isEmpty() || root != null){
    if(root != null){
      stack.push(root);
      root = root.left;
    }
    else{
      root = stack.pop();
      if(--k == 0)
        return root.val;
      root = root.right;
    }
  }
}
```

> #### [1235. 规划兼职工作](https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling/)

按照以前的方案来写递归 和 动态规划都不难 但是会超时！

尤其是发现以前的方法 变量的维度总是比别人的答案多一维 变相的增加了许许多多的空间和时间上的浪费

然后来分析这道题 首先说怎么转换成我们常用的套路呢？

那就是排序 排序后答案就会按照时间的序列排序 *我们的答案就是这个序列的一个子序列*  这是不排序所带不来的。

然后如何定义dp[i] 每一个元素代表当范围为0到i时 最大的利润

我们对于每一个i：

- 不要这个兼职 那么此时最大的利润就是前一个的

- 要这个兼职 那么由于是按照结束时间排序的 要了这个兼职后 在前面就只能选结束时间小于当前项目的开始时间的项目。 如果有多个项目满足这个时间关系那我们到底要选哪个项目呢？

  **答案就是前面所有项目中最后一个结束时间小于本项目的开始时间的** 

  为什么呢？ 因为这样的动态规划是递增的！ 项目越多 利润肯定越多或者相等 也就是说排序后 我们划分的小范围越大 只会比前面的范围大或者等于它 所以只需要找到最后一个结束时间小于当前项目的开始时间就好

  那怎么加速这个过程呢？很容易想到全部遍历 但由于是排序后的 所以二分查找找上界即可

  注意这里的 miidle = （left  + right + 1) / 2 因为如果两个数字的话 会陷入死循环 看具体代码吧

比较完两种情况取最大值 代码看下面 包含排序 二分 很多细节 好好看

注意这里不能把动态规划的定义为 以当前元素结尾的最大值 其实也可以 只是向前查找就必须全部遍历了。这样的加速不适用

```java
 int[][] time = new int[startTime.length][3];
        for (int i = 0; i < time.length; i++) {
            time[i][0] = startTime[i];
            time[i][1] = endTime[i];
            time[i][2] = profit[i];
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] dp = new int[startTime.length];
        dp[0] = time[0][2];
        for(int i = 1; i < dp.length; i++){
            dp[i] = time[i][2];
            int left = 0;
            int right = i - 1;
            while (left < right){
                int middle = (left + right + 1) / 2; //有坑
                if(time[middle][1] <= time[i][0])
                    left = middle;
                else
                    right = middle - 1;
            }
            if(time[left][1] <= time[i][0])
                dp[i] += dp[left];
            dp[i] = Math.max(dp[i],dp[i - 1]);
        }
        return dp[dp.length - 1];
```

> #### [2008. 出租车的最大盈利](https://leetcode-cn.com/problems/maximum-earnings-from-taxi/)

同上面题 一样 数组都帮你创建好了 ……

### 10月18日

> #### [879. 盈利计划](https://leetcode-cn.com/problems/profitable-schemes/)

其实是非常简单的一道三维的动态规划题目 但是这种非常好想的题目 出在困难的话 一般都是数据量特别大 特别容易超出内存和时间

对于这道题 我们不用傻傻的去记录真正每一次情况获得了多少利润 当给定的要求利润 减少到小于0 就让它 一直等于0 这样就可以判断有没有达到他要求的利润 又get到了一个点 嘻嘻

> #### [453. 最小操作次数使数组元素相等](https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/)

每次都有n - 1 个数字 变大1 那么就是每次有一个数字 减少1 （相比较于大小的话）
显然考虑后者 要计算的情况会好很多 由于每次都有数字减少1 那么当所有数字都变成数组中最小的数字时 即代价最小 因为数字不可以增大呀！

### 10月21日

> #### [66. 加一](https://leetcode-cn.com/problems/plus-one/)

对于这种题 一种非常朴素的做法就是转换成数字再去做 再转换回来 显然这样开辟的空间和溢出问题都要考虑

我们这样 对于数组中的每一个元素 从后向前遍历 如果当然数组下标的值不等于9 不进位 那么就加一 如果等于9 代表要进位了 直接等于0 即可
这里对于两种情况

- 第一种 一上来第一位就小于9 那么➕1 返回即可
- 第二种 由于是前一位进位后的加一 如果当前位不等于9 那么他进位后 也是对的 

对于这种情况直接返回即可

如果一个for循环结束了 都没有返回 代表现在数组里的全部都是0

那么代表要进一位 所以返回新的数组 比原来的长1 然后第一位是0 即可

> #### [1138. 字母板上的路径](https://leetcode-cn.com/problems/alphabet-board-path/)

关于这道题 没有必要去递归回溯全部可能 这样太蠢
注意棋盘是有顺序的 即可以通过距离a的距离 通过模运算和除法算出每个字符的位置
这里一开始犯了一个错误 总是想去算**新的位置和旧的位置的距离** 
我们遍历每一个字符 计算出每个字符的位置 和 上一个字符的位置 通过坐标相减就好了 
正数 负数 分别对应 各种移动
然后StringBuilder 的repeat挺好用的

> [881. 救生艇](https://leetcode-cn.com/problems/boats-to-save-people/)

要让船少 则搭乘2个人的必须多 爽指针 最轻的人和最重的人组合 如果不能组合 则给最重的单独一条船 



### 10月23日

> #### [413. 等差数列划分](https://leetcode-cn.com/problems/arithmetic-slices/)

其实没有想的那么复杂 一定要递归和动态规划 直接朴素遍历就好啦
首先从前向后加一个循环 此循环代表 以当前元素为起点的等差数列
故差值肯定是i + 1  -  i 数组的值啦 
然后再加一个for循环 从i + 1的位置开始 和 i + 1 + 1比较差值是否为刚才那个 如果是加 1 否则代表后面都不是 
注意一些边界条件即可。

```java
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0;
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++){ //枚举道倒数第三个元素 因为要保证最小长度为3
            int d = nums[i + 1] - nums[i]; //求出差值
            for(int j = i + 1; j < nums.length - 1; j++){ //
                if(nums[j + 1] - nums[j] == d)//是j + 1 和j 比较 一来就保证了 3个
                    res++;
                else
                    break;    
            }
         }
         return res;    
    }
}
```

### 10月26日

> #### [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)

由于num1 的元素都存在于 num2中 所以这道题就变成了 求num2中的每一个元素最近的比自己大的元素 这种很明显用单调栈

关于单调栈前面都写好了 这里由于num1的出现顺序在num2是无序的 所以需要用到哈希表来记录对应的关系 不然哈希表都不用 

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
int[] res = new int[nums1.length];
        // 问题转换为求每一个元素的 离它最近的下一个更大值 因为num1的顺序和num2出现的顺序不一样要哈希表
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i != nums2.length){
            if(stack.isEmpty() || nums2[stack.peek()] > nums2[i]){
                stack.push(i);
                i = i + 1;
                continue;
            }
            int temp = stack.pop();
            hashMap.put(nums2[temp],nums2[i]);
        }
        while (!stack.isEmpty())
            hashMap.put(nums2[stack.pop()],-1);
        for (int j = 0; j < nums1.length; j++) {
            res[j] = hashMap.get(nums1[j]);
        }
        return res;
    }
}
```

### 10月27日

> #### [503. 下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii/)

首先抛开一些其他的思想 对于数组中的每个元素求右边离它最近的比他的 这是一个非常常规的单调栈操作 只是此时要数组循环考虑 对于左边就变成了求左边离当前元素最远的最大元素
事实证明两个单调栈 或者 其他思想都不行

最简单的方法 将前n - 1个拼到数组的后面即可 当然肯定不用实际拼 数组下标取模即可 

这样做或许会造成反复入栈 、 数组赋值操作 但都无关紧要。

注意一些小技巧

- 首先给结果数组全部给 -1。这样很容易规避了 数组中所有值为同一个值的情况
- 栈里存放的是下标！！ 且要取模！ 这样才能造成一一对应的关系

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        
        while (i != nums.length * 2 - 1){
            if(stack.isEmpty() || nums[stack.peek()] >= nums[i % nums.length]){
                stack.push(i % nums.length);
                i++;
                continue;
            }
            int temp = stack.pop();
            res[temp] = nums[i % nums.length];
        }
        return res;
    }
}
```

> #### [1335. 工作计划的最低难度](https://leetcode-cn.com/problems/minimum-difficulty-of-a-job-schedule/)

其实是一道很简单的动态规划呀 真的好简单 只是今天注意力不集中 才花了这么多时间
题目的意思有一点没有说清楚 就是工作列表必须全部做完 且必须是在最后一天全部做完

然后每一天都要做的 话 有一个很好的表达可以很好的少些很多代码。即剩余未安排的工作小于天数的话 直接返回无效值

```java
public int dp(int[] jobDifficulty, int d){
        int[][] dp = new int[d + 1][jobDifficulty.length + 1];
        for(int i = 0; i < dp[0].length - 1; i++)
            dp[0][i] = 50000;
        for(int i = 1; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++){
                if(jobDifficulty.length - j < i)
                    dp[i][j] = 50000;
                else{
                    int max = 0, res = 50000;
                    for(int k = j; k < jobDifficulty.length; k++){
                        max = Math.max(max,jobDifficulty[k]);
                        res = Math.min(res,max + dp[i - 1][k + 1]);
                    }
                    dp[i][j] = res;
                }
            }
        return dp[d][0] == 50000 ? -1 : dp[d][0];
    }
```

### 11月1日

> #### [移掉 K 位数字](https://leetcode-cn.com/problems/remove-k-digits/)

首先这道题 是道贪心题 要使剩下的数字尽可能小 **就必须要小的数字尽可能靠前 即从左向右看 把较大的数字移除掉** 很容易想到单调栈的思想 维持一个从栈底到栈顶从小到大的单调栈 **如果遇到比栈顶大的才入栈** 如果遇到比栈顶小的 代表栈顶此时并不是最优解 应该出栈 

但是这里很明显不能全部遍历完 因为我们只能移出k个数字 故整个单调栈的思路循环的次数应该是Min(num.length,k)

当执行完单调栈的思路后，我们可能面临以下两种情况：

- k没有到0 因为整个没有遇到足够的元素让栈顶出栈
- i没有到末尾 因为k先走完了 就是已经找到了最优解 

对于这两种情况 不需要去各种if嵌套 我们只需要两个while 循环让其都走到其本身该到的尾部即可（个人觉得个人这段代码写的很漂亮）

其实对于大多数情况这道题已经解决完了， 但是很明显有些情况会出现前导0 对于栈这个思想由于是反过来的 很难在遍历的时候就去去除

这里用了一个比较笨的思路 记录stringbuilder最后一个非0的下标 然后手动reverse 和 append 效率大大降低 下次可以实现双端队列实现单调栈 

```java
 public String removeKdigits(String num, int k) {
        //维护一个从栈底到栈顶从小到大的单调栈
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < num.length() && k != 0){
            if(stack.isEmpty() || stack.peek() <=  num.charAt(i) - '0'){
                stack.push(num.charAt(i) - '0');
                i++;
                continue;
            }
            stack.pop();
            k--;
        }
        while (i < num.length())
            stack.push(num.charAt(i++) - '0');
        while (k-- != 0)
            stack.pop();
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0, lastIndex = 0;
        while (!stack.isEmpty())
            {
                int temp = stack.pop();
                if(temp != 0)
                    lastIndex = index;
                stringBuilder.append(temp);
                index++;
            }
        String res = "";
        for(int j = lastIndex; j >= 0 && stringBuilder.length() != 0; j--)
            res += stringBuilder.charAt(j);
        return res.equals("") ? "0" : res;
    }
```

> #### [575. 分糖果](https://leetcode-cn.com/problems/distribute-candies/)

很经典的贪心题！

对于妹妹要分到的糖的种类越多 假设有n 个 糖果 一共有 m种类 由于是平均分 妹妹最多拿到 n / 2个糖果 如果糖的种类 m > n / 2 那么代表妹妹最多可以让每一个糖果都不一样 那么她就拿到 n / 2种糖果
如果m < n / 2那么妹妹一定要全部种类都拿到

用排序或者哈希找出糖果的种类都可

```java
public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < candyType.length; i++)
            set.add(candyType[i]);
        return Math.min(set.size(),candyType.length / 2);    
        }
```

> #### [739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)

太简单 不说了

> #### [647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)

用中心扩展法 中心扩展法是找到回文的中心然后 左右分别遍历  中心不仅是一个字符也可以是两个字符 一共有 2 * len  - 1个中心 left 开始位置是 i / 2 right是 left + i % 2

自己回来看的时候这样想

带一些例子进去 如果left 和 right 起始的时候重叠在一起 那就是以当前指向的元素向左向右展开 如果没有重叠 那不用说了 都懂得

```java
 int res = 0;
        for(int i = 0; i < s.length() * 2 - 1; i++){
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;
```

> #### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

用上面的定理找出所有的回文子串 通过比较长度截取 注意res一开始要给到第一个元素 因为自身就是回文

```java
class Solution {
    public String longestPalindrome(String s) {

String res = String.valueOf(s.charAt(0));
        for(int i = 0; i < s.length() * 2 - 1; i++){
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left + 1> res.length())
                    res = s.substring(left,right + 1);
                left--;
                right++;
            }
        }
        return res;
    }
}
```

### 11月2日

> #### [646. 最长数对链](https://leetcode-cn.com/problems/maximum-length-of-pair-chain/)

三种方法解决

首先不管是哪种方法 肯定要对数组先进性排序 至于为什么需要排序 我个人数学不好很难给出证明 如果你看懂了后面的递归 **你就会明白答案肯定是排序后的一个子序列** （这道题虽然很明显是一道最长递增子序列的变形题，但是我觉得没必要太过强调类型，如果懂思路其他类似的动态规划都有相似的思路）

#### 第一种递归

为什么要先写递归？ 

因为动态规划就是从递归来的！（写熟递归后，动态规划转换方程才会有更好的空间感）

递归的思路大致如下：

从前向后扫描，对于每一个数对我们可以选择不要，在满足当前下标和上一个下标所对应的大小关系后可以选择要，当选择要这个元素后，当前下标向前走，上一个下标变成当前下标。

对于一开始时，由于没有上一个下标，所以我们设定特殊值为-1，当没有上一个可以比较的元素或者满足大小比对关系时都可以选择要这个下标，然后比较两种要法的大小返回即可，有点基础的应该看起来很简单

```java
public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        return help(pairs,0,-1);
    }
public int help(int[][] pairs, int index, int preIndex){
        if(index == pairs.length)
            return 0;
        int res = 0;
        if( preIndex == -1 || pairs[index][0] > pairs[preIndex][1])
            res = 1 + help(pairs,index + 1,index);
        return Math.max(help(pairs,index + 1,preIndex),res);
    }
```

为什么这样一个从前向后的扫描和取舍一定会找到答案？ 因为我们对数组进行排序了！ 答案肯定是一个有序序列，所以答案就是排序后数组的子序列！

#### 第二种 由递归中得到的动态规划

递归显然会超时，但竟然递归都出来了，动态规划的解空间，临界值，动态转移方程一看便知！

对于**解空间**：上面递归有两个参数，所以动态规划需要二维的，分别为index，在[0,length]变化，然后是preIndex,每一次都在[-1.index - 1]上变化，即preIndex永远不大于index

由此可知index最多到length, preIndex最多到length - 1 故我们开辟的数组大小可能是dp[length + 1] [length] 。 但这样是不对的 

因为这里有一个一般动态规划很少遇见的点：解空间可能为负数，对于preIndex 从 -1 开始，所以要多一个数字，故应该是dp[length + 1] [length + 1]

至于临界值，转移方程代码里 已经注释：

```java
public int dp(int[][] pairs){
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[][] dp = new int[pairs.length + 1][pairs.length + 1];
        for(int i = dp.length - 2; i >= 0; i--) //倒数第一行代表临界值 全部是0 所以从倒数第二行开始
            for(int j = 0; j <= i; j++){ //这里将整个解空间都右边移动了 所以 0 其实 代表 - 1
                int res = 0;
                if(j == 0 || pairs[i][0] > pairs[j - 1][1]) //为什么是j - 1 因为右边移动了！！！
                    res = 1 + dp[i + 1][i + 1]; //注意这里 因为你j移动了 所以对应的也要移动
                res = Math.max(dp[i + 1][j],res);
                dp[i][j] = res;
            }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[0][0];
    }
```

#### 第三种换一种思想的动态规划

定义dp数组 长度等于length dp的每一个元素的含义是，以当前下标结尾的最长数对链是多长 对于数组中的每一个元素肯定最小为自身即 都是自己的本身

我们依旧从前向后遍历，遍历到每一项元素后，再开启一个子循环看看前面每一个满足大小要求的关系的元素的最长长度 + 1 和 自身比较哪个更大，不断更新 和记录

```java
public int newDp(int[][] pairs){
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < pairs.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[j] + 1,dp[i]) ;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
```

> #### [516. 最长回文子序列](https://leetcode-cn.com/problems/longest-palindromic-subsequence/)

注意这道题和最长回文子串的区别 

**子串必须是连续的 可以用中心扩展法**

但是子序列可以是不连续 **但是必须正向的**

 对于这道题一开始我的水平很明显想不出太好的递归 在查阅资料后 明白这叫区间dp

并且根据dp自己写出了递归版本 感觉收获好大

这样考虑一个dp或者递归 递归的参数是区间left 到 right 的回文子串

如果left = right 字符哈 那么就是 left+ 1 到 right - 1 的值 加上2 

否则就是抛开左边或者右边的大的那个值 

```java
public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < dp.length; i++)
            dp[i][i] = 1;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = i + 1; j < dp[i].length; j++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        return dp[0][n - 1];
    }
    public int longTest(String s){
        return help(s,0,s.length() - 1);
    }
    public int help(String s, int left, int right){
        if(left > right)
            return 0;
        if(left == right)
            return 1;
        if(s.charAt(left) == s.charAt(right))
            return 2 + help(s,left + 1,right - 1);
        else
            return Math.max(help(s,left,right - 1),help(s,left + 1,right));
    }

```

> #### [409. 最长回文串](https://leetcode-cn.com/problems/longest-palindrome/)

这道题的意思和前面的都不一样 不需要什么连续或者不连续。意思就是给了你一个数组 你随便选怎么组合 

我们不需要去模拟什么回文不回文 如果一个字符出现了偶数次 那么都选上 因为偶数怎么都能构成回文 如果出现了奇数次 那么就当奇数- 1 个构成偶数

最后加上 1。因为我们可以用一个奇数构成中心。

```java
class Solution {
    public int longestPalindrome(String s) {
HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i),1);
        }
        int res = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> temp : map.entrySet()) {
            if(temp.getValue() % 2 == 0)
                res += temp.getValue();
            else
               { 
                   flag = true;
                   res += temp.getValue() - 1;
               }
        }
        return flag ? res + 1 : res;
    }
}
```

空了可以好好看如何通过字符数组来存储值 而不用哈希表

### 11月3日

> 左神 随想
>
> 给你一个有序的数组，数组中有正有负，问数组中每个数字都平方后，一共有多少种不同的数字？

- 第一种方法 hashset 直接平方后 丢进去就可以了 这样空间复杂度为n 时间复杂度为n

- 第二种方法 按照数组的绝对值排序 然后从左向右遍历 如果当前值的平方不等于前面值的平方 就 加1。每一次都要更新前面个值的平方 因为有排序 所以时间复杂度为logn n 空间复杂度 o1

- 第三种方法 双指针 左指针指向首部 右指针指向末尾 **当左指针小于等于右指针的时候** 对于每一次比较

  - 如果左指针指向的绝对值大于右指针指向的绝对值 代表左指针之前的都没有等于或者小于右指针的 **此时左指针向右移动到第一个不等于自身的位置** ans ++
  - 如果右指针指向的绝对值大于左指针指向的绝对值 代表右指针之后的都没有等于小于等于左指针的 **此时右指针向左移动到第一个不等于自身的位置** ans++
  - 如果两边的值相等 两边都移动到第一个不等于自身的位置 ans++

  这个方法时间复杂度 n 空间复杂度 1

**这道题的变形是： 给你一个数组 数组中的数字先递减后递增 问你数组中一共有几种数字？**

为什么是一样的呢？ 假如刚才的有序数组带负数都平方后，平方和的序列不就是先递减后递增嘛？

所以直接用上面的双指针策略即可。

> #### [367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)

这道题虽然简单 但是有一个溢出的坑

首先很明显想到是去枚举一个范围里的数字 让他平方得到我们的数字

那么范围应该是[1,n / 2]

我们在求其平方的时候 一定要用long 想一下如果让你求820000 是不是完全平方数 **第一次得到一般49000的平方直接就溢出了**

```java
class Solution {
    public boolean isPerfectSquare(int num) {
 if(num == 1)
            return true;
        int left = 1;
        int right = num / 2;
        while (left <= right){
            int mid = (left + right) / 2;
            System.out.println(mid);
            long temp =(long) mid * mid; //如果是int 就溢出了
            if(temp == num)
                return true;
            else if(temp < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
```

> #### [面试题 10.01. 合并排序的数组](https://leetcode-cn.com/problems/sorted-merge-lcci/)
>
> 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
>
> 初始化 A 和 B 的元素数量分别为 m 和 n。
>

这道题的最优解 不是那么一眼就可以看出来的 

首先合并后排序 和 声明一个新的数组再排序 都是直接能想出来的。

但是这里A数组 后面全部是空的位置 显然是留给b的 所以我们把思路变成这样从A数组的末尾向前看 依次填入值

tail指针指向a的末尾 i指向m的末尾 j指向n的末尾 依次比较大小和是否越界 再填入相应的值 不用考虑是否覆盖！！ 因为空的位置够多 或者 a本身都在移动 

注意下面的代码 写的非常好看！

```java
public void merge(int[] A, int m, int[] B, int n) {
         int i = m - 1, j = n - 1, tail = m + n - 1; //a的末尾
        while (i >= 0 || j >= 0){ //越界了也跑 当两个都越界了再退出
            int cur = 0;
            if(i == -1) //一个越界了 直接等于另外个没有越界的
                cur = B[j--];
            else if(j == -1)
                cur = A[i--];
            else if(A[i] > B[j])
                cur = A[i--];
            else
                cur = B[j--];
            A[tail--] = cur; //每次都是给末尾赋值 全部采用--的形式 写的非常漂亮！
        }
    }
```

> [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

不要去模拟 我们去看每个方块上面的水是多少就好了

第一个方块和第二个方块上面的水肯定是0 **因为他们是边界 上面有水肯定会溢出去啦**

所以如果数组长度小于2 直接返回0 

对于每一个普通的位置（1 到 n - 2）上水的多少 =  **左边数组的最大值 和 右边数组的最大值 取小的那个 减去 当前值 如果是负数 那么就是0** 

再把每一个水相加起来就好了

所以问题转换成了如何求每个普通数字的左边最大值 和 右边最大值

- 方法一 暴力法

  没什么好说的 每一次遍历到一个位置 都开启子循环向前向后查找 分别的最大 再求即可 很明显 暴力 不好 代码简单不写了

- 方法二 两个临时数组

  意思就是开辟两个新的数组 一个存放0到当前位置的左边最大值 另一个存放n到当前位置的右边最大值

  ```java
  public int trapBetter(int[] height){
      if(height.length < 2)
          return 0;
      int[] left = new int[height.length];
      int[] right = new int[height.length];
      left[0] = height[0];
      right[right.length - 1] = height[height.length - 1];
      for(int i = 1; i < height.length; i++)
          if(height[i] > left[i - 1])
              left[i] = height[i];
          else
              left[i] = left[i - 1];
      for(int i = right.length - 2; i >= 0; i--)
          if(height[i] > right[i + 1])
              right[i] = height[i];
          else
              right[i] = right[i + 1];
      int ans = 0;
      for(int i = 1; i < height.length - 1; i++)
          ans += Math.max(Math.min(left[i - 1],right[i + 1]) - height[i],0);
      return ans;
  }
  ```

- 方法三 一个临时数组 一个临时变量

  因为我们是从左往右的，所以记录左边最大值的时候其实可以一边遍历 一遍记录 至于右边最大值还是要扫描

  ```java
   public int trapBetterBetter(int[] height){
          if(height.length < 2)
              return 0;
          int[] right = new int[height.length];
          right[right.length - 1] = height[height.length - 1];
          for(int i = right.length - 2; i >= 0; i--)
              if(height[i] > right[i + 1])
                  right[i] = height[i];
              else
                  right[i] = right[i + 1];
          int ans = 0;
          int leftMax = height[0];
          for(int i = 1; i < height.length - 1; i++)
          {
              ans += Math.max(Math.min(leftMax,right[i + 1]) - height[i],0);
              leftMax = height[i] > leftMax ? height[i] : leftMax;
          }
          return ans;
      }
  ```

- 方法四 双指针

  首先leftMax 依然等于第一个元素 rightMax依然等于数组最后个元素

  **另i 指向 1 j 指向 n - 2 当i <= j 时执行下面过程：**

  如果**leftMax < rightMax**, 代表i指向的位置 左边的最大值就是leftMax 我们此时不需要去知道rightMax 因为即使我们没有看完整个右边 已经有一个元素比leftMax大了 根据我们的计算规则 只需要知道小的那个就可以了

  所以对于i指针指向的位置 水 就算出来了 **然后更新leftMax i++**

  如果leftMax >= rightMax 就去更新j指向的数字的数值 道题同上

  ```java
  public int doublePoint(int[] height){
          if(height.length < 2)
              return 0;
          int leftMax = height[0];
          int rightMax = height[height.length - 1];
          int ans = 0;
          int i = 1, j = height.length - 2;
          while (i <= j){
              if(leftMax < rightMax){
                  ans += Math.max(leftMax - height[i],0);
                  leftMax = Math.max(leftMax,height[i]);
                  i++;
              }
              else{
                  ans += Math.max(rightMax - height[j],0);
                  rightMax = Math.max(rightMax,height[j]);
                  j--;
              }
          }
          return ans;
      }
  ```

  > #### [1218. 最长定差子序列](https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/)

  有点类似于最长递增子序列 **意思就是求最长按给定的公差的子序列**

  用左神的方法 就是从前向后扫描 对于每一个元素如果满足跟前面个元素的公差关系就可以要或者不要 然后写出递归 然后改成动态规划 **或者可以直接用最长递增子序列的dp公式改一下**

  ```java
  public int longestSubsequence(int[] arr, int difference) {
      return help(arr,0,difference,-1);
  }
  public int help(int[] arr, int index, int difference, int preIndex){
      if(index == arr.length)
          return 0;
      if(preIndex == -1 || arr[preIndex] + difference == arr[index])
          return Math.max(1 + help(arr,index + 1,difference,index),help(arr,index + 1,difference,preIndex)) ;
      return help(arr,index + 1,difference,preIndex);
  }
  public int dp(int[] arr, int difference){  //直接用最长递增子序列的公式改一下 --> 超时
      int[] dp = new int[arr.length];
      int ans = 0;
      for (int i = dp.length - 1; i >= 0; i--) {
          dp[i] = 1;
      }
      for(int i = 1; i < dp.length; i++){
          for(int j = 0; j < i; j++)
              if(arr[j] + difference == arr[i])
                  dp[i] = Math.abs(dp[j] + 1);
          ans = Math.max(ans,dp[i]);
      }
      return ans;
  }
  ```

  但是这样会超时 我们这样考虑这样的dp dp中每个元素代表以**当前元素结尾的最长定差子序列是多少** 所以很明显**后面的元素肯定比前面的元素大 活着最差都是相等** 
  对于每一个元素能让他发生改变的是由于dp[arr[i] - difference ]决定的 如果之前有这个元素 那么就是 之前的 + 1 否则就是1 

  ```java
  HashMap<Integer, Integer> hashMap = new HashMap<>();
          int ans = 1;
          for(int i = 0; i < arr.length; i++){
              if(hashMap.containsKey(arr[i] - difference)){
                  hashMap.put(arr[i],hashMap.get(arr[i] - difference) + 1);
                  ans = Math.max(hashMap.get(arr[i]),ans);
              }
              else
                  hashMap.put(arr[i],1);
          }
          return ans;
  ```

  注意这样写哈希表的写法 很丑陋 写成这样非常好看

  ```java
  class Solution {
      public int longestSubsequence(int[] arr, int difference) {
  HashMap<Integer, Integer> hashMap = new HashMap<>();
          int ans = 1;
          for(int i = 0; i < arr.length; i++){
              hashMap.put(arr[i],hashMap.getOrDefault(arr[i] - difference,0) + 1);
              ans = Math.max(hashMap.get(arr[i]),ans);
          }
          return ans;
      }
  }
  ```

  #### ### 11月5日

  > #### [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

  首先肯定可以开辟一个新的数组 然后计算下标赋值即可 即新的下标为 (i + k) % nums.length

  但是这里介绍一个新的方法 首先将整个数组反转 然后将0 到 k - 1再反转 再把 k到数组末尾反转即可 注意一些边界条件

  **如何反转整个数组？ 就是首尾两个指针分别交换即可 因为第二个变成倒数第二个这个意思**

  ```java
  public void rotate(int[] nums, int k){
          k %= nums.length; //这一步 一定要 因为如果超出数组长度 就是 减去数组长度 剩下的那个 步数
          reverse(nums,0,nums.length - 1);
          reverse(nums,0,k);
          reverse(nums,k + 1, nums.length  -1);
      }
      public void reverse(int[] nums, int i, int j){
          while (i < j){
              int temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
              i++;
              j--;
         
  ```

  ### 11月7日

  > #### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

  这道题完全是用来锻炼双指针抽象思维的

  首先声明一对快慢指针 初始的时候都指向第0个元素 慢指针代表全是大于0的范围 快指针一直向前扫描 遇到不等于0 的数字 就和i指向的数字交换  或者 直接赋值（这里是两种解法的意思） 其实很简单

  但是说不清楚 就是慢指针代表处理好的范围 快指针一直扩大搜寻范围
  
  ```java
  public void moveZeroes(int[] nums) {
          int i = 0; int j = 0;
          while(j < nums.length){
              if(nums[j] != 0)
                  swap(nums,i++,j);
              j++;    
          }
      }
      public void swap(int[] nums, int i, int j){
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }
  class Solution {
      public void moveZeroes(int[] nums) {
          int i = 0; int j = 0;
          while(j < nums.length){
              if(nums[j] != 0)
                  nums[i++] = nums[j];
              j++;    
          }
          while(i < nums.length)
              nums[i++] = 0;
      }
  }
  ```
  
  > #### [481. 神奇字符串](https://leetcode-cn.com/problems/magical-string/)
  
  挺无聊的一道题 就是模拟它 然后统计前面1出现的次数
  
  关键是模拟的思路：
  
  首先神奇字符串的前三个肯定是122 所以n <= 3 时 直接返回 1
  
  然后利用一个stringbuffer 接收模拟的字符串
  
  让i指针一开始指向 数组下标2的位置 **i指向的数字代表后面要拼接的数字出现的次数**
  
  至于拼接什么数字呢？ 是由1 和 2 交替 执行的 一开始是 2。那么就贴1。一开始是1 就贴2 
  
  然后最后统计1的个数就好了 好无聊这道题

> #### [31. 下一个排列](https://leetcode-cn.com/problems/next-permutation/)

如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：

1.我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
2.我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：

	1. 在尽可能靠右的低位进行交换，需要从后向前查找将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
	2.将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 	123546 比 123564 更小，123546 就是 123465 的下一个排列

注意下面的代码写的非常漂亮！！！ 一些控制边界怎么写的 多学习一下！！

```java
 public void next(int[] nums){
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) //从后向前 找到第一个不满足降序的
            i--;
        if(i > 0){
            int j = nums.length - 1; //从后向前找到第一个 大于 要换的
            while (j > i && nums[j] <= nums[i])
                j--;
            swap(nums,i,j);
        }
        int start = i + 1, end = nums.length - 1; //交换后 必然有序 所以直接反转即可
        while (start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
```

> #### [下一个更大元素 III](https://leetcode-cn.com/problems/next-greater-element-iii/)

同上面题一样的 题意都是一样的 只是这次不是直接给我们数组了 而是直接给我们数字 所以我们将数字转换成数组

这里先将数字转换成字符串 转换的方法不是string 提取 而是 直接 数字 加上 空字符串即可

最后由于这道题要求32位整数 即 int 的 最大值 故我们用long接收 如果大于就返回-1

```java
public int nextGreaterElement(int n) {
        String s = n + ""; //数字转字符串
        int[] nums = new int[s.length()];
        for(int i = 0; i < nums.length; i++)
            nums[i] = s.charAt(i) - '0'; //char 转换成对应的数字
        if(nums.length <= 1)
            return -1; //如果就一个数字 -1
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if(i < 0)
            return -1; //如果都是降序的 即最大了 不用走了 没有比他大的了 直接返回 -1
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i])
            j--;
        swap(nums,i,j);
        int start = i + 1, end = nums.length - 1;
        while (start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
        long res = 0; //可能会溢出 用long接收
        for (int num : nums) {
            res = res * 10 + num;
        }
        return res > Integer.MAX_VALUE ? -1 : (int) res; 
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
```

> #### [560. 和为 K 的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)

这道题和求数组中最长小于等于target的子数组的长度有点类似 但是解法完全不一样 注意都是子数组 **数字必须是连续的**

一个好的方法是一边遍历整个数组 一边记录前缀和 **注意是前缀和！！！！** 就是从数组0位置 到当前位置截止的和

对于每一个当前位置 如果有那么子数组 == k 那么当前前缀和 - k **一定是之前某个元素的前缀和** 那么此解就是某个元素的后面一个到当前元素

因为前缀和是连续的 所以上式成立 

至于怎么记录前缀和呢 当然可以用数组 每次再去查找数组就行 但是用哈希表记录次数就好啦！！！！

```java
 public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        int ans = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            ans += map.getOrDefault(preSum - k,0);
            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }
        return ans;
    }
```

### 11月8日

> #### [299. 猜数字游戏](https://leetcode-cn.com/problems/bulls-and-cows/)

首先我的思想也是对的 如何计算公牛呢？ 无非就是两个字符串一起遍历 然后位置相同的情况下 字母 相同 公牛加一即可

怎么计算母牛呢？ 首先我们不用去计算母牛出现的位置 我们只需要记录不相同时，**统计两个字符串出现不同字符的个数即可。**

然后母牛的个数 是两个不同字符最小的那个 相加即可

比如说第一个字符串有3个0 第二个字符串有2个0。那么母牛就是2 你可以随意组合他们的位置 

至于怎么记录母牛不同字符串相对应的个数 **我一开始想着用哈希表 但是后来直接开辟数组 用与'0'的相对距离即可**

```java
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] a = new int[10];
        int[] b = new int[10]; //非常好这个方法
        for(int i = 0; i < secret.length(); i++)
            {
                char tempA = secret.charAt(i);
                char tempB = guess.charAt(i);
                if(tempA == tempB)
                    bulls++;
                else{
                    a[tempA - '0']++;
                    b[tempB - '0']++;
                }    
            }
        for(int i = 0; i < a.length; i++)
            cows += Math.min(a[i],b[i]);
        String res = bulls + "A" + cows + "B";
        return res;        
}
}
```

> #### [598. 范围求和 II](https://leetcode-cn.com/problems/range-addition-ii/)

首先不用去真的模拟求和过程 再去遍历 这样肯定很蠢

因为每次都是在从左上角为起点的区间里操作 **所以所有操作的覆盖的同一处就是所有操作的交集 即为最小的那个部分**

所以我们遍历操作求出最小的交集的面积即可。

```java
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
  int x = m;
        int y = n;
        for (int[] op : ops) {
            x = Math.min(op[0],x);
            y = Math.min(op[1],y);
        }
        return x * y;
    }
}
```

### 11月9日

> #### [488. 祖玛游戏](https://leetcode-cn.com/problems/zuma-game/)

很久没有写回溯了 那种感觉竟然不是很好了

首先这种题如果没什么思路的化 直接模拟

对于一个字符串如何根据祖马游戏的规则进行删除 就是利用sb对象的delete 查找区间删除即可

然后就是不断每次模拟期盼 添加字符串就好了 主要看代码

```java
class Solution {
    public int findMinStep(String board, String hand) {
        HashMap<String,Integer> map = new HashMap<>(); // 添加缓存
        int res = help(board,hand.toCharArray(),map);

        return res > hand.length() ? -1 : res;
    }
    public int help(String board, char[] hand,HashMap<String,Integer> map){
        if(board.length() == 0 || board.equals(""))
            return 0;
        if(map.containsKey(board))
            return map.get(board);
        int res = 16;
        for(int i = 0; i < hand.length; i++){
            char c = hand[i];
            if(c != '0') //用于记录这个球是否用过
            {
                for(int j = 0; j < board.length(); j++){  //注意这里board的长度会动态绑定 一直都在变换 如果你后面有修改的话
                    StringBuilder sb = new StringBuilder();
                    sb.append(board.substring(0,j));
                    sb.append(c);
                    sb.append(board.substring(j)); //这一段字符串的操作 好好学一下
                    removeBoardSame(sb,j);
                    hand[i] = '0';
                    res = Math.min(help(sb.toString(),hand,map) + 1,res);
                    hand[i] = c;
                 }
            }
        }
        map.put(board,res);
        return res;
    }
    public void removeBoardSame(StringBuilder sb,int index){
        if(index < 0)
            return;

        char c = sb.charAt(index);
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && sb.charAt(left) == c)
            left--;
        while (right < sb.length() && sb.charAt(right) == c)
            right++;
        int length = right - left - 1;
        if(length >= 3)
        {
            sb.delete(left + 1,right);
            removeBoardSame(sb,left);
        }
    }
}
```

### 11月10日

> #### [495. 提莫攻击](https://leetcode-cn.com/problems/teemo-attacking/)

太简单了 不解释 注意边界条件就好了

```java
public int findPoisonedDuration(int[] timeSeries, int duration) {
int ans = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if(timeSeries[i] - timeSeries[i - 1] >= duration)
                ans += duration;
            else
                ans += timeSeries[i] - timeSeries[i - 1];
        }
        ans += duration; //注意最后一次攻击 或者攻击只有一次的话 这里要加一个duratioon
        return ans;
    }
```

> #### [155. 最小栈](https://leetcode-cn.com/problems/min-stack/)

利用辅助栈 记录每一个元素所对应的最小值 如果一个元素要进栈（真正保存元素的栈 正常进入）

对于记录最小值的栈 我们进行下面的策略 如果它比最小栈的栈顶元素还要小 那么就直接打进去  **意思就是辅助栈的栈顶元素永远是最小值**

否则 将辅助栈的栈顶元素再压一次

> #### [581. 最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/)

这道题不简单 有点难想 但是好歹几种解法的思想都是一样的

最短的排序区间 排序后 整个数组有序 那就代表此区间 **左边的区间 和 右边的区间不需要排序**

所以第一种方法：

​	我们开辟一个一摸一样的数组 内存地址当然不一样啦 然后将此数组排序 **对比排序后的数组 和 原来的数组 头部 和 尾部 最多到哪个位置都是相同的 那么中间剩下的就是那个最短区间**

​	对于有序的数组 这样方法会让左边右边错乱 所以要特别判断下 所以这个方法其实很蠢！

```java
public int findUnsortedSubarray(int[] nums) {
        boolean flag = true;
        for(int i = 0; i < nums.length - 1; i++)
            if(nums[i + 1] < nums[i])
                flag = false;
        if(flag)
            return 0;
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);
        int left = 0, right = nums.length - 1;
        while (left < nums.length && nums[left] == temp[left])
            left++;
        while (right >= 0 && nums[right] == temp[right])
            right--;
        return right - left + 1;
    }

//此方法唯一不同的地方就是 i和j 循环的区间 很灵性 可以排除数组本身就是有序的情况
public int findUnsortedSubArray(int[] nums){
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
    }
```

第二种方法 双指针！！！！：

我们可以将数组分成三部分 左边是有序的a 中间是无序的b 右边是无序的c

我们无非就是要找到**无序的左边界和右边界**

怎么确定一个无序的区间呢？ 首先这里必须说明我自己想的无序区间 和 这里不太一样

比如这样一串数字 1234 **5 3 2 1** 8 9 10 我们可以说 5 3 2 1 是无序区间 也可以将 范围分别向前向后扩 

一个真正的有序区间是**，最后一个没有让最大值更新的位置** 从左到右遍历 更新最大值 如果到了当前位置需要更新最大值 代表是有序的 **如果不用 代表 肯定逆序**

上面是找到右边界

对于左边界就是从末尾到开头更新最小值

如何判断数组本身就是有序的呢 那就是开始的变量根本就没有动过。

```java
public int findUnsortedByDoublePoint(int[] nums){
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int n = nums.length;
        int r = -1, l = -1;
        for(int i = 0; i <= nums.length; i++){
            if(nums[i] > maxValue)
                maxValue = nums[i];
            else
                r = i;
            if(nums[n - i - 1] <= minValue) //玩弄下标直接一次循环搞定
                minValue = nums[n - i - 1];
            else
                l = n - i - 1;
        }
        return r == -1 ? 0 : r - l + 1; //如果等于初始值代表整个都是有序的 返回0
    }
```

> #### [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)

这道题其实和普通动态规划都是一致的 可以优化dp空间 改成一维数组 

并且判定奇数时 直接返回false 

没什么参考意义 看代码就懂

```java
class Solution {
   public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        double target = sum / 2.0;
        if(target != sum / 2)
            return false;
//        return help(nums,0,sum / 2,0);
        return dp(nums,sum / 2);
    }
    public boolean dp(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i][dp[i].length - 1] = true;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j < dp[i].length - 1; j++)
                dp[i][j] = dp[i + 1][j] || (j + nums[i] > target ? false : dp[i + 1][j + nums[i]]);
        return dp[0][0];
    }
}
```

### 11月12日

> #### [629. K个逆序对数组](https://leetcode-cn.com/problems/k-inverse-pairs-array/)

首先必须对这道题的题目做一个更清晰的说明 **数组必须是刚好由1到n组成 且每个数组只出现一次**

怎样来更好的理解这道题的动态规划呢？

直接举例子吧。。。

假设 现在已经有 1 到 2 生成的所有排列数组 现在给了你一个数字3 你要把3插入到之前生成好的所有数组中的任意位置 对于之前生成的任何一个子数组 你把3放在第一个位置那么就**多构成了**2个逆序对 你把3放在最后一个位置那么就**多构成了0**个逆序对 

总结：对于新来的数字i 对于之前的任意子数组 最多可以多（就是新增）构成i - 1个 逆序对（即放在任何一个子数组的头部） 最少可以多构成0个逆序对 

所以如果我们构成k个逆序对 现在又新来了一个数字 要让构成的逆序对为k 意思就是 **新构成的逆序对 加上 前面数字构成的逆序对 = k**

假如新成的逆序对为x 那么要让心形成的为k 就要加上之前为k- x 的 为x - 1 就要加上之前为 k - (x - 1)

注意有可能无法搭配 比如说我们要2个逆序对 但是现在来到了数字4 可以最多新构成3个逆序对 那么总不能直接添加3个逆序对再去拿上一个为-1 的吧 怎么可能是负数呀 所以对于上一个子 **最少取其构成0个逆序对的情况**

注意基本case 0个数字 **构成 0个逆序对 有几种组合 答案是1 种** 所以dp[0] [0] = 1 i代表第几个数字 j代表几个逆序对

以下代码分别对应暴力方程 省空间 以及 推出更优化的方程

```java
//二维数组版的动态规划 纯粹暴力 尝试转移方程
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int mod = 1000000007;
        dp[0][0] = 1;
        for(int i = 1; i < dp.length; i++)
            for(int j = dp[i].length - 1; j >= 0; j--){
                for(int t = j; t >= Math.max(0,j - (i - 1)); t--)
                    dp[i][j] = (dp[i][j] + (dp[i - 1][t])) % mod;

            }
        return dp[n][k];
    }
    //二维压缩成一唯空间 时间并没有提升多少
    public int getBetter(int n, int k){
        int[] temp = new int[k + 1];
        temp[0] = 1;
        int mod = 1000000007;
        for(int i = 1; i < n + 1; i++)
        {
            int[] dp = new int[k + 1];
            for(int j = k; j >= 0; j--)
                for(int t = j; t >= Math.max(0,j - (i - 1)); t--)
                    dp[j] = (dp[j] + temp[t]) % mod;
            temp = dp;
        }
        return temp[k];
    }
    public int best(int n, int k){
        int[] temp = new int[k + 1];
        temp[0] = 1;
        int mod = 1000000007;
        for(int i = 1; i < n + 1; i++)
        {
            int[] dp = new int[k + 1];
            dp[0] = 1;
            for(int j = 1; j <= k; j++)
              {  dp[j] = ((dp[j - 1]+ temp[j]) % mod - (j - i >= 0 ? temp[j - i] : 0));
                 if(dp[j] < 0)
                     dp[j] += mod;
                 dp[j] = dp[j] % mod;
              }
            temp = dp;
        }
        return temp[k];
    }
```

> #### [375. 猜数字大小 II](https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/)

这道题怎么说呢 其实自己做出来也不是很理解

首先不能用二分法 看到一个很好的解释是说二分法只能求猜对的最小次数 但是这个是猜对的最小代价 

反正意思都是给定一个数字 不断缩小其区间直到你猜到它

对于1个数字 你不用猜 代价为0 

对于n个数字 你依次随便选一个数字 i 那么代价就是 i + max(左边剩下区间的最小值,右边区间的最小值) **因为你要确定你两边都玩得起 所以要将就大的那一个** 

```java
public int getMoneyAmount(int n) {
        return help(1,n);
    }
    public int help(int left, int right){
        if(left >= right)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = left; i < right; i++){ //i < right 那么i = right - 1时 i+ 1 道right 就是right 到right
            int cost = i + Math.max(help(left,i - 1),help(i + 1,right));
            ans = Math.min(ans,cost);
        }
        return ans;
    }
    public int dp(int n){
        int[][] dp = new int[n + 1][n + 1];
        for(int left = dp.length - 2; left >= 1; left--)
            for(int right = left + 1; right < dp[left].length; right++){
                dp[left][right] = Integer.MAX_VALUE;
                for(int i = left; i < right; i++){
                    int cost = i + Math.max(dp[left][i - 1],dp[i + 1][right]);
                    dp[left][right] = Math.min(dp[left][right],cost);
                }
            }
        return dp[1][n];
    }
```

> #### [128. 最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence/)

这道题可以随意用数字 不是子序列噢 第一种方法可以先想到排序 然后逐一递增比较 但是这样复杂度较高

所以要用空间换时间 用哈希表 用哈希集合存储每一个数字

再依次遍历数组 如果一个数字减一后 没有存储在哈希集合里 我们就去遍历哈希表 求它的最长区间

比如说 1 2 3 我们只求1 2 3 的最长长度 而不去遍历 2 和 3

为什么下面的代码是 On 因为其实是2 n 省略系数就是n

```java
public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) { //这里肯定执行n次
            if(!set.contains(nums[i] - 1)){ //只有连续的最小的那个 以及没有连续的 数字才进入这个 所以这里面的循环也是执行n次 
                int count = 1;
                int curVal = nums[i];
                while (set.contains(curVal + 1)){//连续最小的执行最长长度 加上 没有连续的 执行 1 次
                    count++;
                    curVal++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
```

> #### [229. 求众数 II](https://leetcode-cn.com/problems/majority-element-ii/)

排序后 哈希集合记录

```java
public List<Integer> majorityElement(int[] nums) {
        int minTime = nums.length / 3;
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums);
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            if(count > minTime)
                res.add(nums[i]);
            if(i + 1 < nums.length && nums[i + 1] == nums[i])
                count++;
            else
                count = 1;
        }
        return new ArrayList<>(res);
    }
```

摩尔投票法

```java
int canA = 0, canB = 0, hpA = 0, hpB = 0;
        for(int i = 0; i < nums.length; i++){
            if(hpA == 0 && nums[i] != canB) //因为有可能a被减空了然后现在来了个b 没有不等于的话 把两个候选人都一样了
            {
                canA = nums[i];
                hpA++;
            }
            else if(canA == nums[i])
                hpA++;
            else if(hpB == 0)
            {
                canB = nums[i];
                hpB++;
            }
            else if(canB == nums[i])
                hpB++;
            else{
                hpA--;
                hpB--;
            }
        }
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < nums.length; i++){
            if(hpA != 0 && nums[i] == canA)
                countA++;
            if(hpB != 0 && nums[i] == canB)
                countB++;
        }
        List<Integer> res = new ArrayList<>();
        if(countA > nums.length / 3 )
            res.add(canA);
        if(countB > nums.length / 3)
            res.add(canB);
        return res;
```

> #### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

这道题不难主要是 代码不是那么常见 以及java中优先级队列的使用 忘了的话 来看看这里

首先统计所有字符出现的次数 然后声明一个最小堆 堆的大小为k **最后堆里剩下的元素就是出现次数前k高的**

首先为什么是 最小堆呢？？ 考虑堆满的情况 如果又来了一个新的元素 它去和堆顶元素比较 如果出现次数比堆顶元素小 则不管 比最小都小 为什么要管啊！！

比堆顶大的话 那么就是移除堆顶元素 再加进去！！

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b); //生明一个最小堆 注意比较器
            }
        });
        for (Integer temp : map.keySet()) {
            if(heap.size() < k)
                heap.add(temp);  //加到堆里
            else{
                if(map.get(temp) > map.get(heap.peek())){ //看一下堆顶元素
                    heap.remove(); //移除堆顶元素
                    heap.add(temp);
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = heap.remove();
        }
        return ans;
    }
}
```

### 11月15日

> #### [面试题 16.24. 数对和](https://leetcode-cn.com/problems/pairs-with-sum-lcci/)

双指针模拟不解释 太简单了

> #### [2054. 两个最好的不重叠活动](https://leetcode-cn.com/problems/two-best-non-overlapping-events/)

预处理 + 排序 + 二分法

首先这道题是我们只能选两个任务 而不是说满足时间理论顺序的所有任务。**所以这就是这道题和 1235规划兼职工作的区别**

我们按照每个项目的结束时间从小到大排序 然后从头遍历数组 对于数组中的每一个元素 肯定都对应其一个最优组合 即位**当前元素 + 最大价值的那个结束时间小于当前项目开始时间的项目**

只要我们枚举出每一个元素的组合 那么答案就肯定在里面

所以问题就是寻找当前元素的另一半！！ 由于**另一半的元素的结束时间必须小于当前元素的开始时间** 我们数组的结束时间又是按结束时间从小到大排序的 所以可以用刚刚学的二分去查找**有序数组中最后一个小于target**的下标 假设其下标为index 那么对于 [0,index] 里的项目都满足我们组合的要求 我们要找出这个区间里最大的价值。一个朴素的做法当然是从0到index求最大值

但是超时，所以我们需要预处理。

新开辟一个数组用于存放 **结束时间小于等于项目结束时间的最大价值** 滚动记录即可。看代码就懂了

然后每次二分查找到最后一个小于当前项目的开始时间的下标 获得预处理数组的值就找到了最大的组合

```java
class Solution {
     public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        int[] help = new int[events.length];
        int temp = Integer.MIN_VALUE;
        for(int i = 0; i < help.length; i++){
            help[i] = Math.max(events[i][2],temp);
            temp = help[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < events.length; i++){
            int index = findLastLessTarget(events,events[i][0]);
            if(index == -1)
                ans = Math.max(events[i][2],ans);
            else{
                ans = Math.max(events[i][2] + help[index],ans);
            }
        }
        return ans;
    }
    public int findLastLessTarget(int[][] events, int target){
        int index = -1;
        int l = 0, r = events.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(events[mid][1] < target){
                index = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return index;
    }
}

```

> #### [剑指 Offer 51. 数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)

  这道题不能用动态规划 动不起来的 

应该用归并排序时 合并左边数组和右边数组的时候 一边合并一边统计 由于左边的数组原本应该要放在左边的 产生逆序对就是因为左边有比右边大的。所以左边如果有一个比当前j大 那么左边的位置到左边数组结尾的元素都会比当前j大 因为归并排序合并时是左右两边各自都是有序数组。

```java
class Solution {
    public int reversePairs(int[] nums, int left, int right) {
        if(left >= right)
            return 0;
        int mid = (left + right) / 2;
        int res = reversePairs(nums,left,mid) + reversePairs(nums,mid + 1,right);
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right){
            if(nums[i] > nums[j])
                {
                    temp[index] = nums[j];
                    res += (mid - i + 1);
                    j++;
                }
            else
                {
                    temp[index] = nums[i];
                    i++;
                }
            index++;
        }
        while (j <= right){
            temp[index] = nums[j];
            j++;
            index++;
        }
        while (i <= mid){
            temp[index] = nums[i];
            i++;
            index++;
        }
        for(int p = left,k = 0; p <= right; p++,k++)
            nums[p] = temp[k];
        return res;
    }
    public int reversePairs(int[] nums) {
        return reversePairs(nums,0,nums.length - 1);
    }
}
```

### 11月16日

> #### [391. 完美矩形](https://leetcode-cn.com/problems/perfect-rectangle/)

这道题怎么说呢 其实挺无聊的 没啥借鉴意义 唯一的借鉴意义就是对hashmap中**唯一对象的判定有了更深的理解**

首先一个完美矩形 **其面积互相不覆盖 而且刚好组成一个完整的矩形** 

对于组成的矩形而言 四个顶点只会出现一次 其中间的顶点**要么出现2次 要么出现4次** 不是偶数次 是只有这两种选择

所以我们算法的思路是遍历给定的数组 计算出分别的顶点 统计其出现的次数 

然后这样一个统计自然会想到用哈希表，但是我们日常使用哈希表都是统一单一的数字，这里一个点是两个值，很自然把它想成一个对象来统计。 所以我们新建一个对象用来存储点，但是我们你知道的每一次新建一个对象他的内存地址都不一样，添加到哈希表里，即使两个点的纵坐标和横坐标都是相等的，也是会判定成不一样的两个点，所以需要修改这个类的euqal方法和hashcode

其余的都是日常操作了 注意一个坑是，我们在算大矩形的四个点时，有可能这个点不在哈希表里，因为我们只会算左下角和右上角 所以要特别判断一下。

```java
 public boolean isRectangleCover(int[][] rectangles) {
        //记录大矩形的左下角和右上角
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE; //左下角
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE; //右上角
        int tempArea = 0; //累加小矩形的面积
        HashMap<Point,Integer> map = new HashMap<>();
        for(int i = 0; i < rectangles.length; i++){
            int a1 = rectangles[i][0], b1 = rectangles[i][1], a2 = rectangles[i][2], b2 = rectangles[i][3];
            //更新大矩形的左下角和右上角
            if(a1 < x1 || b1 < y1){
                x1 = a1;
                y1 = b1;
            }
            if(a2 > x2 || b2 > y2){
                x2 = a2;
                y2 = b2;
            }
            tempArea += ((a2 - a1) * (b2 - b1));
            Point pointLeftDown = new Point(a1,b1);
            Point pointRightTop = new Point(a2,b2);
            Point pointLeftTop = new Point(a1,b2);
            Point pointRightDown = new Point(a2,b1);
            map.put(pointLeftDown,map.getOrDefault(pointLeftDown,0) + 1);
            map.put(pointRightTop,map.getOrDefault(pointRightTop,0) + 1);
            map.put(pointLeftTop,map.getOrDefault(pointLeftTop,0) + 1);
            map.put(pointRightDown,map.getOrDefault(pointRightDown,0) + 1);
        }
         Point ld = new Point(x1,y1);
        Point lt = new Point(x1,y2);
        Point rd = new Point(x2,y2);
        Point rt = new Point(x2,y1);
         if(tempArea != ((x2 - x1) * (y2 - y1)) || map.getOrDefault(ld,0) != 1 || map.getOrDefault(lt,0) != 1 || map.getOrDefault(rd,0) != 1 || map.getOrDefault(rt,0) != 1)
            return false;
        map.remove(ld);
        map.remove(lt);
        map.remove(rd);
        map.remove(rt);
        for (Map.Entry<Point, Integer> entry : map.entrySet()) {
            Point point = entry.getKey();
            int value = entry.getValue();
            if(value != 2 && value != 4)
                return false;
        }
        return true;
    }
}
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public boolean equals(Object obj) { //学着点
        if (obj instanceof Point) {
            Point point2 = (Point) obj;
            return this.x == point2.x && this.y == point2.y;
        }
        return false;
    }
```

### 11月17日

> [318. 最大单词长度乘积](https://leetcode-cn.com/problems/maximum-product-of-word-lengths/)

这道题判断结果还是得用暴力，即字符串数组中两个字符串两两互相比较，但是问题和这道题的精髓就在于如何在o1的复杂度中判断两个字符串中是否有重复字母

首先朴素的做法就是两个字符串从头到尾比较 但是学到了用掩码的方式存储。

首先全部是小写字母，故对于每一个字符串我们要记录其26个字母的出现与否 想想一个int的数字 其为32位 如果每一位都对应其相应字母就好了

比如现在来了个b 我们计算其到a的距离 然后让1左移那么多位 **就是将相应位标记了出现过 然后和记录总的进行或运算 只要出现过 对应的就是1**

然后将不同的字符串进行与运算 如果结果为0代表没有其共同的字母 因为只要有一个字母是共同出现过的 结果至少有一位是1

```java
 public int maxProduct(String[] words) {
        int[] map = new int[words.length];
        for(int i = 0; i < words.length; i++)
            for(int j = 0; j < words[i].length(); j++)
                map[i] = map[i] | (1 << (words[i].charAt(j) - 'a'));
        int ans = 0;
        for(int i = 0; i < words.length; i++)
            for(int j = i + 1; j < words.length; j++){
                if((map[i] & map[j]) == 0)
                    ans = Math.max(ans,words[i].length() & words[j].length());
            }
        return ans;
    }
```

> #### [795. 区间子数组个数](https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/)

动态规划

动态规划的每一项表示的是以**当前元素结尾的满足条件的子数组个数是多少**

- 如果当前元素比left和right都小 **那么前面个元素组成的子数组都能带上它** 即dp[i] = dp[i - 1]
- 如果当前元素比right都大 那么以他为结尾的肯定为0 并且记录当前位置为断开的位置
- 如果当前元素在left和right之间 **那么代表其随便带上一个不超过范围的元素**都能形成满足条件的子数组（这个思想很重要） 那么由于数组是要连续的 他能带上的区间肯定是在上一个断开的区间那里到它为止 即i - lastbreak

```java
public int numSubarrayBoundedMax(int[] nums, int left, int right) {
 int ans = 0;
         int preSum = 0;
         int preBreak = -1;
         for(int i = 0; i < nums.length; i++){
             if(nums[i] >= left && nums[i] <= right){
                 preSum = i - preBreak;
                 ans += preSum;
             }
             else if(nums[i] < left)
                 ans += preSum;
             else if(nums[i] > right)
                 {preBreak = i;
                    preSum = 0;
                 }
         }
         return ans;
    }
```

> #### [713. 乘积小于K的子数组](https://leetcode-cn.com/problems/subarray-product-less-than-k/)

感觉对于子数组这种问题 都是有点类似于动态规划的思想 **以考虑数组中每个元素结尾的时候 满足条件的子数组个数是多少**

*首先引出一个大问题 如何求数组中所有子数组的个数？*

一个朴素的思想是求出第一个元素结尾的子数组 + 第二个元素结尾的子数组 + 第三个元素结尾的子数组+……+最后一个元素结尾的子数组

**对于每一个元素结尾的子数组个数 都是其下标 i + 1** 也可以理解为（i - 0 + 1）

对于这道题 也同样适用 由于数组中的数字全部都是正数 所以我们很容易一边求前面的乘积以及统计

我们用滑动窗口的思想 每次扩大其右边的指针（即计算以右边指针结尾的时候 形成的满足条件的子数组是多少）

只要我们求出以当前元素为结尾的时候 往前最大的区间连续相乘都满足小于k 那么代表 如果当前窗口的乘积都满足小于k 那么能以右边元素结尾的子数组个数为（l - r + 1）

如果不满足 就把左指针往前移动 窗口缩小 除去左边的元素 找到满足乘积小于k的最大区间 直到满足 且左指针最多和右指针重合

```java
public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int l = 0, r = 0, preCount = 1;
        while (r < nums.length && l < nums.length){
            preCount *= nums[r];
            while (preCount >= k && l <= r){
                preCount = preCount / nums[l];
                l++;
            }
            ans += (r - l + 1);
            r++;

        }
        return ans;
    }
```

> #### [1524. 和为奇数的子数组数目](https://leetcode-cn.com/problems/number-of-sub-arrays-with-odd-sum/)

对于这道题 又不能单独的以当前元素结尾 来 计算能形容多少子数组来考虑 

这道题要用前缀和来考虑 

假设现在到了数组下标i 其第一个元素到这里为止的和为 偶数 **求以当前元素结尾的奇数的子数组的数量是多少** 很明显这样的意思是[0,i] 的和是偶数 所以只要在i前面存在一个j **使得[0,j]的和是奇数** 那么[j,i]的的和一定是奇数 奇数偶数相加减的原理啦 自己举个例子就知道啦 那么前面一共有多少个这样的j满足呢？ 意思就是求前面有多少个前缀和为奇数呢？ 所以我们一边求前缀和一边记录， 对于奇数，刚好反过来

只是一开始时，**我们设置前缀和为偶数的数量为1 因为0是偶数。** 

```java
  public int numOfSubarrays(int[] arr) {
       int countOdd = 0; //统计奇数的数目
       int countEven = 1; //统计偶数的数目
       int preSum = 0;
       int ans = 0;
       int mod = 1000000007;
       for(int i = 0; i < arr.length; i++){
           preSum += arr[i];
           if(preSum % 2 == 0){
               countEven++;
               ans = (ans + countOdd) % mod;
           }
           else{
               countOdd++;
               ans = (ans + countEven) % mod;
           }
       }
       return ans;
    }
```

> #### [1774. 最接近目标价格的甜点成本](https://leetcode-cn.com/problems/closest-dessert-cost/)

无聊的题目 暴力递归即可 好久没有写递归暴力回溯了 竟然有点生疏 全部按照题目给定的条件来说就好啦

```java
class Solution {
    int ans = 100000;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int i = 0; i < baseCosts.length; i++)
            help(toppingCosts,target,0,2,baseCosts[i]);
        return ans;
    }
    public void help(int[] toppingCosts, int target, int index, int time, int tempValue){
        if(index == toppingCosts.length)
        {
            if(Math.abs(tempValue - target) == Math.abs(ans - target))
                ans = Math.min(tempValue,ans);
            else if(Math.abs(tempValue - target) < Math.abs(ans - target))
                ans = tempValue;
            return;
        }
       help(toppingCosts,target,index + 1,time,tempValue);
    help(toppingCosts,target,index + 1,time - 1,tempValue + toppingCosts[index]);
     
    help(toppingCosts,target,index + 1,time - 2,tempValue + 2 * toppingCosts[index]);
    }
}
```

### 11月21日

> #### [594. 最长和谐子序列](https://leetcode-cn.com/problems/longest-harmonious-subsequence/)

不就是求数组中组成的元素相差不能为1 吗

我们考虑这样的暴力接发 以数组中的每个数字为数组中较小的那个 能够组成多长的子序列？

假设当前数字是x 那么求数组中是x 和 x + 1 **的数字有多少个 加起来就是我们的答案了 ** 因为是序列 你怎么出现都满足的

所以这里当然可以用哈希表 但是空间开销有点大 

**所以采用一种一边遍历一边记录的方式** 

我们先将数组排序 **满足条件的子序列一定出现在相邻两个差值为1的数字上**

为什么排序后 也能正确求出子序列 这是因为我们其实在算法他出现的次数 哪个先出现 哪个后出现其实不影响的

所以就是在排序数组中 **求相邻两个元素差为1 时 这两个元素有多少个**

有点像双指针的感觉 首先找到同为i的结尾的位置 然后判断下一个是不是比自己大1 如果是的话 再找到他重复结束的位置 两个位置相减即可

注意这里如果真的下一个元素比自己大一 你的i走到后面 要变回来 因为要考虑每一个为起始的办法

```java
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        while (i < nums.length){
            int start = i;
            while (i < nums.length && nums[i] == nums[start])
                i++;
            if(i == nums.length)
                break;
            int end = i;
            if(nums[i] - nums[start] == 1)
                {
                    while (i < nums.length && nums[i] == nums[end])
                        i++;
                    ans = Math.max(ans,i - start); 
                }   
            i = end; //i 要变回来哦
        }
        return ans;
    }
}
```

> #### [137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii/)

哈希表 排序那些就不用说了

介绍一种新的二进制运算的方法 我们依次统计只出现一次的数字它的0到31位 是是什么

如果将数组中每一个数字的第i位的数字加起来（这里是说二进制的） 将他们模以3 就是答案对应的那位的数字（1 或者 0 ）

为什么加起来模以3就好啦啊？

因为如果不包含最后那个数字 那么这一位的和一定是3的倍数(0,3,6) 如果答案那一位是1 模运算就会是1 否则是0

所以我们从0到32位依次统计 赋值即可。

两个问题

*如何求出某个数字在第i位上是0还是1* 

将这个数字右移i位后 去和 1 做 & 运算 由于1的左边全是0 所以左边结果都位0 那么第一位如果是1 答案就是1

*如何将某个数字的第i位变成1*

将1左移i位后 去和要改变的数字做｜运算

```java
  public int singleNumber(int[] nums) {
int ans = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                count +=( (nums[j] >> i) & 1);
            }
            if(count % 3 == 1)
                ans = ans | (1 << i);
        }
        return ans;
    }
```

### 11月22日

> #### [384. 打乱数组](https://leetcode-cn.com/problems/shuffle-an-array/)

题没什么好说的 记住system arraycopy就好啦 

主要是洗牌算法 依次遍历数组的每一个元素 对于每一个元素 都依次和其后面的元素随便选一个交换

比如现在到了i 那么就和 i + 1 到length - 1 的下标随机选一个交换

用random类随机生成一个不大于length - i的随机数 再加上 i

```java
class Solution {
int[] data;
    int[] origin;
    public Solution(int[] nums) {
        data = new int[nums.length];
        origin = new int[nums.length];
        System.arraycopy(nums,0,data,0,nums.length);
        System.arraycopy(nums,0,origin,0,nums.length);
    }

    public int[] reset() {
        System.arraycopy(origin,0,data,0,data.length);
        return data;
    }

    public int[] shuffle() {
        for(int i = 0; i < data.length; i++){
            Random random = new Random();
            int j = random.nextInt(data.length - i) + i;
            swap(data,i,j);
        }
        return data;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### 11月23日

> #### [859. 亲密字符串](https://leetcode-cn.com/problems/buddy-strings/)

两个字符串首先要词频相同 并且不同的位置不能大于2 只能是2 或者 0 

如果两个字符串词频相同 并且不同的位置只有0个

那么这道题要求必须交换 所以看s串中有没有至少一个字符出现过两次的 这样才可以交换达到原串

```java
class Solution {
    public boolean buddyStrings(String s, String goal) {
 if(s.length() != goal.length())
            return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[goal.charAt(i) - 'a']++;
            if(s.charAt(i) != goal.charAt(i))
                count++;
        }
        if(count > 2)
            return false;
        boolean isOverTwo = false;
        for(int i = 0; i < cnt1.length; i++)
        {
            if(cnt1[i] != cnt2[i])
                return false;
            if(cnt1[i] > 1)
                isOverTwo = true;
        }
        if(count == 2)
            return true;
        if(count == 0 && isOverTwo)
            return true;
        return false;
    }
}
```

### 未解决的问题

> #### [519. 随机翻转矩阵](https://leetcode-cn.com/problems/random-flip-matrix/)

> #### [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)



### 11月29日 可优化

> #### [786. 第 K 个最小的素数分数](https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/)

虽然不知道其他的解法 但是不妨去模拟出所有的素数分数 然后去自定义排序

如何自定义排序呢 排序的规则是分数比较 如果直接相除需要处理非常多的问题 浮点数计算以及可能精度不够 所以分子分母移项去排序

```java
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
List<int[]> temp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
            for(int j = i + 1; j < arr.length; j++)
                temp.add(new int[]{arr[i],arr[j]});
        Collections.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
               return t1[0] * t2[1] - t1[1] * t2[0];
            }
        });
        return temp.get(k - 1);
    }
}
```

### 11月30日

> #### [400. 第 N 位数字](https://leetcode-cn.com/problems/nth-digit/)

首先这道题学到了很多 分为3部分来说吧 

如果序列是从1开始的 那么对于位数位x的数字 他的起始数字是 **10的n - 1 次方** 记录为l 它的结束数字是 **10的n次方- 1** 记录位 r 那么这个区间的数字个数位**l -r + 1** 这个区间的长度为**(l - r + 1) * x**

化简后对于x位数的数字 其区间里的长度加起来为 **9 * 10的n - 1 次方**

所以题目给定第n位数字 我们不断递减其上述的公式长度 得到第n位数字他自己所在的位数是多少

通过递减后 我们知道要求的数字是几位数 以及在位数区间里是第几个数字

如果剩下的n % 位数 == 0 代表要求的数字正好是该数字的最后一位 我们用n / 位数长度 得到其是第几个数字 加上 start - 1 再模10 就得到了最后一位数字

如果不能除尽 就求出该数字是多少 然后留下的模就是要求该数字的第几位 通过相除 和 模即可

 ```java
 public int findNthDigit(int n) {
         int w = 1; //表示几位数 1代表1位数
         while (n > (9 * Math.pow(10,w - 1)) * w){
             n -= (9 * Math.pow(10,w - 1)) * w;
             w++;
         }
         int start = (int)Math.pow(10,w - 1);
         int mod = n % w;
         if(mod == 0)
             return (start + (n / w) - 1) % 10;
 
         start +=  (n / w);
         for(int i = 0; i < w - mod; i++)
             start = start / 10;
         return start % 10;
     }
 ```

### 12月1日

> #### [1446. 连续字符](https://leetcode-cn.com/problems/consecutive-characters/)

太简单了 不想说了 一次遍历 更改变量就好啦 

> #### [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

题目不难 主要是看看哈希表不一定要用hashmap的结构 直接用数组都可以 如果字符1没有的字符 那么就是0 相减就会是负数

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i) - 'a']--;
            if(count[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
```

> #### [791. 自定义字符串排序](https://leetcode-cn.com/problems/custom-sort-string/)

不难 当然是看了题解后 就是先统计要被排序的字符各个的个数

然后按照order的字符串去拼凑它 然后将不是order里的字符串随便加到后面就好啦

```java
class Solution {
    public String customSortString(String order, String s) {
int[] count = new int[26];
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char temp = order.charAt(i);
            for(int j = 0; j < count[temp - 'a']; j++)
                sb.append(temp);
            count[temp - 'a'] = 0;
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0)
                for(int j = 0; j < count[i]; j++)
                    sb.append((char)(i + 'a'));
        }
        return sb.toString();
    }
}
```

> #### [1003. 检查替换后的词是否有效](https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/)

不要想着去递归 回溯什么的 这道题用栈 + 贪心 

类似于消消乐的感觉 遇到abc连续的 立马消掉 换成栈的思想就是 如果当前字符是a或者b 直接入栈 如果是c 看看前两个栈顶元素是不是b 和 a 是的话两个都弹出来

一次遍历后 看看栈是不是为空 就知道是不是完全匹配了

```java
class Solution {
    public boolean isValid(String s) {
Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == 'a' || temp == 'b')
                stack.push(temp);
            if(temp == 'c'){
                if(stack.isEmpty() || stack.peek() != 'b')
                    return false;
                stack.pop();
                if(stack.isEmpty() || stack.peek() != 'a')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
```

### 12月3日

> #### [1005. K 次取反后最大化的数组和](https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/)

第一种方法 直接模拟 假如要修改k次 那么先把所有负数都变成正数 然后其对应的的和 如果所有负数都变成正数了 

但是k还有剩余 那么如果剩下的k是偶数 那么直接返回 因为偶数变来变去都一样的啦。 如果剩下的k是奇数 那么就把**最小的那个非负数变成负数** 减去2倍它就好

注意这里最小的非负数 可能是由负数变成正数的 可能是数组里有0。也有可能本身的正数就是很小



第二种方法 优先级队列 先求数组的累加和 每次取出优先级队列中最小的元素 如果是负数 变成正数 加2个 如果是正数 变成负数 -2个 再改变正负号压回去

```java
public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        int ans = Arrays.stream(nums).sum();
        int min = Integer.MAX_VALUE;
        while (index < nums.length && nums[index] < 0 && k > 0){
            ans += Math.abs(nums[index]) * 2;
            min = Math.min(Math.abs(nums[index]),min);
            k--;
            index++;
        }
        if(k < 0 || (index < nums.length && nums[index] == 0) || k % 2 == 0)
            return ans;
        return index < nums.length ? ans - 2 * Math.min(nums[index],min) : ans - 2 * min;
    }
    public int better(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int ans = Arrays.stream(nums).sum();
        while (k > 0){
            int temp = queue.poll();
            if(temp < 0)
                ans += 2 * Math.abs(temp);
            else
                ans -= 2 * temp;
            queue.add(-temp);
            k--;
        }
        return ans;
    }
```



### 12月5日

> #### [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

双指针 一个从头部开始 一个从尾部开始 头指针保证自己和自己左边的都是奇数 去找下一个偶数 同尾部交换 

```java
 public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            while (i < nums.length && nums[i] % 2 != 0)
                i++;
            while (j >= 0 && nums[j] % 2 == 0)
                j--;
            if(i >= j)
                break;
            swap(nums,i,j);
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
```

> #### [剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)

本质上是一道排序 排序的原理是 假如数组中两个数字 x y 如果x + y 比 y + x 大 那么就交换 所以就变成了冒泡排序

怎么来快速来比较这样一个拼接的大小呢 答案是吧他们转换成字符串比较。即可

```java
class Solution {
    public String minNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        for(int i = 0; i < nums.length - 1; i++)
            for(int j = 0; j < nums.length - 1 - i; j++){
                if((strs[j] + strs[j + 1]).compareTo(strs[j + 1] + strs[j]) > 0)
                    swap(strs,j,j + 1);
            }
        for(int i = 0; i < nums.length; i++)
            sb.append(strs[i]);
        return sb.toString();
    }
    public void swap(String[] nums, int i, int j){
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### 12月8日

> #### [689. 三个无重叠子数组的最大和](https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/)

首先这道题是关于滑动窗口很好的练习题 滑动窗口一直是我想学习的技巧 我们首先抛出如下问题：

**如何求数组中长度为k的子数组的最大和**

这种问题怎么说呢 说简单也简单 你可以穷举所有以数组中每个元素为起始位置 往后数k个 那么答案肯定在其中 代价为kn

*其实这些思想不难 主要是感受出滑动窗口的感觉 并且加深记忆以后可以运用*

考虑这样一种滑动窗口思想 我们框定一个长度为k的窗口 每次都往右边移动 **每次向右走一次 都减去最左边的元素 加上 新添加的元素**

这种抽象思想很简单 但是具体到代码边界条件可能得想一下  很明显我们得用循环 对于起始的时候 如果窗口里的元素没有达到k个 那么我们直接累加就好

当来到k - 1位置 刚好k个元素了 开始记录比较的答案 然后最左边的元素是`i - k + 1`

注意这里的i为什么不会越界 为什么不会去考虑什么`i + k` 是否会越界的情况 **是因为我们这里的i代表的是窗口的右边的边界**

```java
public int findMaxSumByWindowOne(int[] nums, int k){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){ //写笔记时记录下这里是否会越界
            sum += nums[i];
            if(i >= k - 1){
                maxSum = Math.max(sum,maxSum);
                sum -= nums[i - k + 1];
            }
        }
        return maxSum;
    }
```

**如何求数组中长度为k的两个子数组的最大和**

我们声明两个窗口第一个窗口起始位置到终点位置是`[0,k - 1]` 第二个窗口的起始位置和终点位置是`[k，2 * k - 1]` 两个窗口同时向右滑动 我们记录第一个窗口的最大值 以及当`第一个窗口的最大值 + 第二个窗口的值 ` 大于答案时，更新答案。

为什么这个策略是对的 且不重叠。 因为第一个窗口的最大值 加上 第二个窗口的值的时候 *代表第一个窗口的最大值永远都在第二个窗口的值的前面*

```java
public int findMaxSumByWindowTwo(int[] nums, int k){
    int ans = Integer.MIN_VALUE;
    int maxSumFirst = Integer.MIN_VALUE;
    int sumFirst = 0;
    int maxSumFirstIndex = -1;
    int a = -1, b = -1;
    int sumSecond = 0;
    for(int i = k; i < nums.length; i++){ //注意这里的起始位置开始非常巧妙 
        sumFirst += nums[i - k]; //当两个窗口的值都没有达到k时 注意这里下标的变换 非常好
        sumSecond += nums[k];
        if(i >= (2 * k - 1)){
            if(sumFirst > maxSumFirst){
                maxSumFirst = sumFirst;
                maxSumFirstIndex = i - 2 * k + 1; //这些下标-1 自己想想
            }
            if(maxSumFirst + sumSecond > ans){ 
                ans = maxSumFirst + sumSecond;
                a = maxSumFirstIndex; //注意这里第一个的起始下标不能是 直接 i - 2 * k + 1 因为最大的前一个可能不是刚好挨着的 而是之前记录的
                b = i - k + 1;
            }
            sumFirst -= nums[i - k * 2 + 1];
            sumSecond -= nums[i - k + 1];
        }
    }
    System.out.println(a + " " + b);
    return ans;
}
```

对于这道题就是三个了 就是记录前两个最大值 然后前两个加上第三个是否第三个大更新答案

```java
public int[] findMaxSumByWindowThree(int[] nums, int k){
        int ans = Integer.MIN_VALUE;
        int maxSumFirst = Integer.MIN_VALUE;
        int maxSumSecond = Integer.MIN_VALUE;
        int sumFirst = 0, sumSecond = 0, sumThird = 0;
        int maxFirstIndex = -1, maxSecondIndexA = -1,maxSecondIndexB = -1;
        int[] res = new int[3];
        for(int i = 2 * k; i < nums.length; i++){ //以第三个窗口的开始位置开始走
            sumFirst += nums[i -  2 * k];
            sumSecond += nums[i - k];
            sumThird += nums[i];
            if(i >= 3 * k - 1){
                if(sumFirst > maxSumFirst){
                    maxSumFirst = sumFirst;
                    maxFirstIndex = i - 3 * k + 1;
                }
                if(maxSumFirst + sumSecond > maxSumSecond){
                    maxSumSecond = maxSumFirst + sumSecond;
                    maxSecondIndexA = maxFirstIndex; //因为后面第一个数组的最大值可能改变 但是两个数组的值不一定变
                    maxSecondIndexB = i - 2 * k + 1;
                }
                if(maxSumSecond + sumThird > ans){
                    ans = maxSumSecond + sumThird;
                    res[0] = maxSecondIndexA;
                    res[1] = maxSecondIndexB;
                    res[2] = i - k + 1;
                }
                sumFirst -= nums[i - 3 * k + 1];
                sumSecond -= nums[i - 2 * k + 1];
                sumThird -= nums[i - k + 1];
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
```

> #### [794. 有效的井字游戏](https://leetcode-cn.com/problems/valid-tic-tac-toe-state/)

题目不难 主要是一些边界情况难讨论 首先最主要的就是比较两个字母的个数

```java
class Solution {
public boolean validTicTacToe(String[] board) {
         int countX = 0;
        int countO = 0;
        boolean flagX = isWin(board,'X');
        boolean flagO = isWin(board,'O');
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'X')
                    countX++;
                else if(board[i].charAt(j) == 'O')
                    countO++;
            }
        if(countO != countX && countX - countO != 1) //x 和 o 要么相等 要么x 比 o 多一个 因为 x先下
            return false;
        if(flagX)
               return countX - countO == 1 && !flagO; //如果x赢了 代表x比o 多走一步 所以要比他多一个 并且o没有赢的情况
        if(flagO) //如果o赢了 他最多只能和x一样多 并且x没有连成一盘的情况
            return countX == countO && !flagX;
        return true; //x和o 都没有赢 并且个数也匹配就是真的
    }
    public boolean isWin(String[] board, char c){
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)
                return true;
            if(board[0].charAt(i) == c && board[1].charAt(i) == c &&  board[2].charAt(i) == c)
                return true;
        }
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c)
            return true;
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c)
            return true;
        return false;
    }
}
```

### 12月9日

> #### [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

这道题应该有很多解法 属于我对滑动窗口的新理解后的尝试 不得不感叹一年前的我只会链表 学什么都慢 **现在随便看个算法都好快了**

这道题因为考察的面不少： 堆。队列。 滑动窗口

- 方法一： `优先级队列维护最大值 其实 就是堆的意思`

​		首先这样一个滑动过程 其实算什么最大值是很容易的 都是正向操作的 关键是对于滑动窗口里的最大值 如果我们维护一个优先级队列（大顶堆），记录我们的最大值，每次我们要取最大值的时候，**我们的最大值可以通过堆顶获得**， 但是堆顶的元素不一定在我们的窗口里，即我们需要知道**堆顶元素的下标是不是在我们窗口的范围里**。 所以很自然的引出一种方法：在`记录元素的值的时候 也去记录他的下标`, 这样的话每次拿到堆顶元素的时候，判断其下标在不在，不在的话，一直删除堆顶元素，直到在我们的堆顶元素在里面。 所以很明显：**堆里面的元素可能比我们窗口大小的元素多**

但是注意数组里肯定会存在两个元素相等的情况，**这种情况我们要让后面个元素即index大的在堆的顶端。** 想一下这种情况2 3 3 4 在这之中3 3 都在堆里面 但是我们窗口向后走后 肯定要后面个3在前面 但是其实不影响

因为我们每次取的时候 **都会判断是不是会在窗口的范围里面**

```java
public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[0] != t1[0] ? t2[0] - t1[0] : t2[1] - t1[1]; //这样也可以 直接返回值的大小排序也可以啦
            }
        });
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            queue.add(new int[]{nums[i],i});
            if(i >= k - 1){
                while (queue.peek()[1] < (i - k + 1))
                    queue.poll();
                res[j] = queue.peek()[0];
                j++;
            }
        }
        return res;
    }
```

- 方法二： `单调队列维护最大值的下标`

​	我们考虑这样一个过程 用一个双端队列存放数组元素的下标，**从左至右下标所指向的元素在数组中是单调递减的 意思就是最大的肯定在队头**

​	所以我们每次要记录答案的时候直接去取队头元素就好了 但是队头元素可能不在我们的窗口范围里 所以判定一下 如果不在则将队头元素弹出去 

​	*关键是我们怎么维护队列里的元素是单调递减的*

​	一个最简单的方法就是添加的时候调整一下策略 对于添加的时候 我们从队尾开始 从最后一个元素向前比较 如果队尾的元素比新来的元素小 就直接把队尾弹出去 **直到找到一个不小于新元素的位置**

​	这样做是否会错过我们的答案？

1. 如果新的元素是最大的 那么他就将其他元素都弹出去 那么他自己就是答案 所以不会
2. 如果之前的元素是最大的 那么新来的元素并不会把他们弹出去 所以答案一定在队列中 我们去判断是否符合下标就好了

```java
public int[] better(int[] nums, int k){
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            if(i >= k - 1){
                while (deque.peekFirst() < (i - k + 1))
                    deque.pollFirst();
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
```

### 12月10日

> #### [1695. 删除子数组的最大得分](https://leetcode-cn.com/problems/maximum-erasure-value/)

滑动窗口真的太好玩了 这道题意思就是**不控制滑动窗口的大小 求的子数组的累加和最大 并且子数组中每个元素都必须不一样**

所以我们的思想就是 `在满足都不一样的情况下 不断扩充右指针的大小 扩大窗口的大小`

所以我们每次添加累加和时候也要 需要一个set来记录是否有重复元素之前

如果我们之前有 就从窗口的左边开始 一直删除 直到把重复的元素删除了为止 为什么要从左边删除

因为子数组必须是连续的 只有把它删了才可以呀

```java
public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int j = 0; //左指针
        for(int i = 0; i < nums.length; i++){
            while (set.contains(nums[i]))
                {
                    sum -= nums[j];
                    set.remove(nums[j]);
                    j++;
                }
            sum += nums[i];
            set.add(nums[i]);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
```

> #### [1493. 删掉一个元素以后全为 1 的最长子数组](https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element/)

`今天这道题的思想都是用滑动窗口的思想来说都是 对于一个子数组你可以任意选定子数组（滑动窗口）的大小 前提是滑动窗口里的元素必须满足条件 答案的解一定是其中之一` 

和上面道题很像 我们也是可以无限制的扩充我们窗口的大小 前提是`窗口里必须只有一个0` 所以我们需要一个布尔变量来记录是否已经有0了

所以我们每次添加之前 判断下当前元素是不是0 并且 是否之前已经有0了 如果都满足的话 我们则从左边界开始删除那个0 并且左边界来到下一个位置

如果当前元素是0 则记录有

```java
class Solution {
    public int longestSubarray(int[] nums) {
 int ans = 0;
        boolean flag = false;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(flag && nums[i] == 0){
                while (nums[j] != 0)
                    j++;
                j++;
                flag = false;
            }
            if(nums[i] == 0)
                flag = true;
            ans = Math.max(i - j, ans);
        }
        return ans;
    }
}
```

> #### [1004. 最大连续1的个数 III](https://leetcode-cn.com/problems/max-consecutive-ones-iii/)

不说了 模版题

```java
public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && k == 0){
                while (nums[j] == 1)
                    j++;
                j++;
                k++;
            }
            if(nums[i] == 0)
                k--;
            ans = Math.max(i - j + 1,ans);
        }
        return ans;
    }
```

### 12月11日

> #### [911. 在线选举](https://leetcode-cn.com/problems/online-election/)

题目还好 主要是理解题意……我们利用预处理的技巧 由于times**数组是按时间顺序排列的 所以people数组中也是按投票的顺序排序的**

所以我们单独考虑people数组 去提前记录对于每一次投票的领先的人数是多少即可 这样当然是哈希表的结构呀

我们遍历第一个元素的时候 假设其为最领先的 因为只有他自己呀 然后用top变量记录一下 所以后面每次记录新的投票 都更新一下top 如果比他大的话 

并且将每次的top加到列表中，代表第几次投票后 领先的人是谁

对于查找时间为t的领先的人 相当于在视奸列表中查找第一个小于或者等于当前时间的元素的下标 然后去我们预处理的数组里面拿就好了！ 简单

```java
class TopVotedCandidate {
 HashMap<Integer,Integer> map = new HashMap<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    int[] persons;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        int top = -1;
        for(int i = 0; i < persons.length; i++){
            map.put(persons[i],map.getOrDefault(persons[i],0) + 1);
            if(top == -1 || map.get(persons[i]) >= map.get(top))
                top = persons[i];
            arrayList.add(top);
        }
    }
    public int getIndex(int target){
       int l = 0;
        int r = times.length - 1;
        int ans = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (times[mid] <= target){
                ans = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
    public int q(int t) {
        return arrayList.get(getIndex(t));
    }
}

```

> #### [930. 和相同的二元子数组](https://leetcode-cn.com/problems/binary-subarrays-with-sum/)

具体地，我们用哈希表记录每一种前缀和出现的次数，假设我们当前枚举到元素 \textit{nums}[j]nums[j]，我们只需要查询哈希表中元素 \textit{sum}[j]-\textit{goal}sum[j]−goal 的数量即可，这些元素的数量即对应了以当前 jj 值为右边界的满足条件的子数组的数量。最后这些元素的总数量即为所有和为 \textit{goal}goal 的子数组数量。

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
 HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int num : nums) {
            map.put(sum,map.getOrDefault(sum,0) + 1);
            sum += num;
            ans += map.getOrDefault(sum - goal,0);
        }
        return ans;
    }
}
```

### 12月13日

> #### [1477. 找两个和为目标值且不重叠的子数组](https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)

首先并没有规定两个子数组的长度 所以不能用之前学到的两个窗口一起走

首先我们要弄清楚如何利用**滑动窗口求数组中所有子数组和等于target的结果** 虽然很简单但是跟定长的滑动窗口还是不一样 就是以前的判定条件是根绝滑动窗口的窗口大小 现在是根据里面的和来判断

然后我们定义一个这样的动态规划 每一个元素表示为dp(i)：`0到i结尾的数组中 子数组和等于target的最小长度`

我们的滑动窗口**每次扩充右边界的时候，就同时也是在模拟dp数组的往后走**

如果当前滑动窗口里的值不等于target，那么直接就等于dp(i - 1),因为前面就是它的子数组。特别的当i - 1 < 0 时，有无效值

如果当前滑动窗口里的值满足刚好等于target，那么我们就在`0到右边界`的数组中找到一个满足条件的子数组，但是它可能并不是最短的，因为可能前面也有， 所以去和dp(i - 1)比较

对于答案的话，我们就是找到一个等于target的窗口后，去看窗口左边界的前一个元素等于target的最小值 即动态规划里面取

```java
public getAll(int[] arr, int target){
  int ans = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;
        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            while (sum > target){
                sum -= arr[j];
                j++;
            }
            if(sum == target){
                int length = i - j + 1;
                dp[i] = Math.min(length,i - 1 >= 0 ? dp[i - 1] : Integer.MAX_VALUE);
                if(j - 1 >= 0 && dp[j - 1] != Integer.MAX_VALUE)
                    ans = Math.min(length + dp[j - 1],ans);
            }
            else{
                dp[i] = i - 1 >= 0 ? dp[i - 1] : Integer.MAX_VALUE;
            }

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
}
```

### 12月20日

> #### [1052. 爱生气的书店老板](https://leetcode-cn.com/problems/grumpy-bookstore-owner/)

首先我们分析下题 其实不管你把技能用在哪段连续的子数组上，**我们老板不生气对应的下标的元素都会让我们获得分数。** 所以我嗯先把数组中对应不生气的元素都加到答案中，并且将其元素变为0.

剩下的数组中不为0的因素就是老板会生气的地方，我们用滑动窗口的思想，求`长度为x的连续子数组最大和`就可以得到用技能后的答案，再将其之前的答案相加，就得到了答案。

```java
 public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
int ans = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] != 1)
               { ans += customers[i];
                 customers[i] = 0;
               }
        }
        int windowsAns = 0;
        int sum = 0;
        for(int i = 0; i < customers.length; i++){
            sum += customers[i];
            if(i >= minutes - 1){
                windowsAns = Math.max(windowsAns,sum);
                sum -= customers[i - minutes + 1];
            }
        }
        return ans + windowsAns;
    }
```

> #### [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

再看二分查找 对于二分查找不仅是真的只对于查找第一个出现的位置 去做减法 而是可以用三种判断

只是等于时纪念位置 并且根据情况去看左边界还是右边界

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums,target);
        return res;
    }
    public int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                ans = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if(ans == -1 || nums[ans] != target)
            return -1;
        return ans;
    }
    public int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
           if(nums[mid] == target){
               ans = mid;
               left = mid + 1;
           }
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return ans;
    }
}
```

### 1月8日

> #### [89. 格雷编码](https://leetcode-cn.com/problems/gray-code/)

必须说这是一道无聊的题

有两种思路

- 通过手写所有格雷编码找出规律

​		因为n位格雷编码有2的n次方个元素所以 **第n位格雷编码 一定是 n-1 位格雷编码的两倍**

​		n位格雷编码的前半部分等于n-1位格雷编码（其实是前面加了一个二进制的0）

​		n位格雷编码的后半部分**等于n-1位格雷编码逆序后最高位加了1**

​		n位格雷编码 二进制有n位

   ```java
   public List<Integer> grayCode(int n) {
           List<Integer> res = new ArrayList<>();
           res.add(0);
           if(n == 0)
               return res;
           int first = 1;
           for(int i = 0; i < n; i++)
               {
                   for(int j = res.size() - 1; j >= 0; j--)
                       res.add(first + res.get(i)); //直接加入后半部分就好了
                   first = first << 1;
               }
           return res;
       }
   ```

- 通过二进制相互转换

​	这里的转换是指将格雷编码的每一个元素的二进制表示进行转换

​	比如我们已经知道n位格雷编码有2的n次方个元素

​	那么第n个元素等于 `n的二进制表示 和 n的二进制表示向右移动一位 的 异或运算`

```java
 public List<Integer> better(int n){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < 1 << n; i++) //2的n次方
            res.add(i ^ (i >> 1));
        return res;
    }
```

> #### [71. 简化路径](https://leetcode-cn.com/problems/simplify-path/)

这道题不难 主要是半个月没做了 回来练练思路 练练手！



方法一： 模拟

怎么模拟呢？ 无非也是一个指针从头走到尾部 遇到`/`直接指针往后走 

为什么呢？ 因为`/`并不会控制目录的跳转 只是分隔而已 所以哪怕多个连续的`/`也不会影响 

真正影响目录跳转的其实是`..` 

所以遇到不是`/`的时候 我们去截取 **当前位置到下一个`/`**的字符串 如果这个字符串等于`..`就去把当前记录目录顺序的数据结构移除第一个（当前要判断当前结构不为空）

如果当前截取的字符串既不是`.`也不是`..`表示当前字符串是一个合法目录 我们添加到记录的数据结构中 

遍历完后 再去拼接字符串即可得到答案

```java
public String simplifyPath(String path) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < path.length()){
            if(path.charAt(index) == '/') //什么也不做
                index++;
            else{
                int i = index;
                while (index < path.length() && path.charAt(index) != '/')
                    index++;
                String temp = path.substring(i,index);
                if(temp.equals("..") && res.size() != 0)
                    res.remove(res.size() - 1);
                if(!temp.equals("..") && !temp.equals("."))
                    res.add(temp);
            }
        }
        if(res.size() == 0)
            return "/";
        StringBuffer ans = new StringBuffer();
        for (String re : res) {
            ans.append("/" + re);
        }
        return ans.toString();
    }
```

方法二：分割

首先思路也不难 主要是思考为什么要用双端队列？ 其实这里的话双端队列也好 栈也好 **都是一种控制内存的容器** 怎么能得到我们想要的效果就行。

如果用栈的话 由于我们是从前往后遍历的 所以最后的路径一定是在最后面 但是答案肯定是要顺序返回 所以要多导出一次 但是双端队列两边都可以取 就可以了。

下面谈一下整个算法的思路：

1.我们将整个字符串按照`/`分割成数组

2.依次遍历数组 如果当前元素是`.`或者空 就什么也不做

- ​	`.`不做 是因为表示其当前目录
-  空 什么也不做代表这是连续的`/`导致的 也是什么也不做

3.如果是`..`那很简单 代表回退嘛 判断队列不为空的话 就把最后的元素剔除掉 代表回到上一级了

4.代表合法目录 那么加到队列的末尾

5.拼接字符串

```java
public String better(String path){
    String[] split = path.split("/");
    Deque<String> deque = new LinkedList<>();
    for (String s : split) {
        if(s.equals(".") || s.equals(""))
            continue;
        else if(s.equals(".."))
            {
                if(!deque.isEmpty())
                    deque.pollLast();
            }
        else
            deque.addLast(s);
    }
    StringBuilder sb = new StringBuilder();
    if(deque.isEmpty())
        return "/";
    while (!deque.isEmpty())
        sb.append("/" + deque.pollFirst());
    return sb.toString();
}
```

> #### [1576. 替换所有的问号](https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/)

题目不难 主要是找手感!! 要让没有重复的 **其实三个字符就好了** 就把a  b c 当集合就好了

就从前往后模拟 遇到？ 那么就从 a b c当前选 满足左右不重复就好了 

注意边界条件的判断

```java
 public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '?')
            {
                for(char c = 'a'; c <= 'c'; c++)
                    if((i == 0 || sb.charAt(sb.length() - 1) != c) && (i + 1 == s.length() || c != s.charAt(i + 1))) //注意边界的判断 这里写的很漂亮
                    {
                        temp = c;
                        break;
                    }
            }
            sb.append(temp);
        }
        return sb.toString();
    }
```

> #### [1185. 一周中的第几天](https://leetcode-cn.com/problems/day-of-the-week/)

这种题其实不难 以前可能比较恐惧吧 但是现在主要是搞清楚是什么计算的就好了

首先 **1970年12月31日是周四** 我们先算这个日期到我们的目标日期有多少天 再进行模运算即可

首先按照年算 每隔一年加对应的天数（闰年判断）

然后写出12个月的天数表 如果是闰年且包含2月 多加一天

最后模运算7 得到离周四有多少天 

闰年的判断：`是4的倍数但不是100的倍数 或者直接是400的倍数`就是闰年

```java
 public String dayOfTheWeek(int day, int month, int year) {
        int sum = 0;
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] ans = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        for(int i = 1971; i < year; i++)
            if(isRun(i))
                sum += 366;
            else
                sum += 365;
        for(int i = 0; i < month - 1; i++)
            sum += monthDays[i];
        sum += day;
        if(month > 2 && isRun(year))
            sum++; //如果前一个月都包涵2月 且是闰年那么多加一天
        sum = sum % 7;
        if(sum <= 3)
            return ans[3 + sum];
        return ans[sum - 4]; //这里好好想想
    }
    public boolean isRun(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        return false;
    }
```

### 1月9日

> #### [316. 去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters/)
>
> #### [1081. 不同字符的最小子序列](https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/)



这篇题解写的真的太好了

https://leetcode-cn.com/problems/remove-duplicate-letters/solution/you-qian-ru-shen-dan-diao-zhan-si-lu-qu-chu-zhong-/



首先我们实现第一步 和 第二步 即将字符串去重 且不打乱相对顺序

即 **用栈和数组的结构将字符串去重 且保证每个字符的相对顺序**

- 开辟一个记录数组 记录结果中是否出现了当前要遍历的字符
- 依次遍历字符串 如果记录数组中没有出现过当前字符就压入栈中 如果出现过 那么就不操作

然后我们考虑一下 这样的情况 我们要保证字典序最小 那么我们一定要 **遍历到当前字符时 一定要将它插到比他大的字符前面**

举个例子 现在有`b c` 现在我们来了一个新的`a` 很明显为了让字符序列最小 要尽可能地把`a` 送到 `b c`的前面 即让b c 出栈 

但是 `b c` 并不能随便出栈 因为我们目的是去重 *如果后面没有了 我们没有了这个字符 我们把它弹出去 我们就永远地失去了这个字符* 那什么时候才可以让b c出栈呢？

即 **b c 在后面依然还有的情况下  反正后面还有嘛 先弹出去 再把后面的压进来刚好符合整个的字典序**

```java
 public String removeDuplicateLetters(String s) {
   int[] count = new int[26];
   boolean[] flags = new flags[26];
   Stack<Character> stack = new Stack<>();
   for(int i = 0; i < s.length(); i++)
     count[s.charAt(i) - 'a']++; //与其说是计数 不如说是后面还剩多少个字符
   for(int i = 0; i < s.length(); i++){
     char c = s.charAt(i);
     count[c - 'a']--;
     if(flags[c - 'a']) //如果当前栈中存在了当前字符 那就不用管了 直接跳过
       continue;
     while (!stack.isEmpty() && stack.peek() > c){
       if(count[stack.peek() - 'a'] == 0) //就是说后面已经没有当前字符了 那就不能再弹出去了 哪怕它弹出去会让字典序列变小
         break;
       flags[stack.pop() - 'a'] = false; //那就把它弹出去 并且记录前面没有出现过
     }
     stack.push(c);
     flags[c - 'a'] = true;
   }
     while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
 }
```

> #### [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)

典型的滑动窗口题目 只需要弄懂题意 后面直接滑动窗口直接套

一个字符串的排列 代表其 **长度与原字符串相同 且字母出现的次数相同 但是可能顺序不同**

所以我们统计出s1各个字符串出现的次数 再去s2中框定长度为s1长度的窗口 并且该窗口中各个出现字符的次数都与s1相同 则代表有解

```java
public boolean checkInclusion(String s1, String s2) {
    int n = s1.length(), m = s2.length();
    if(n > m)
        return false;
    int[] cnt1 = new int[26];
    int[] cnt2 = new int[26];
    for(int i = 0; i < n; i++)
        cnt1[s1.charAt(i) - 'a']++;
    int index = 0, j = 0;
    while (index < m){
        cnt2[s2.charAt(index) - 'a']++;
        if(index >= n - 1){
            if(Arrays.equals(cnt1,cnt2))
                return true;
            cnt2[s2.charAt(j) - 'a']--;
            j++;
        }
        index++;
    }
    return false;
}
```

> #### [1041. 困于环中的机器人](https://leetcode-cn.com/problems/robot-bounded-in-circle/)

题目不难 关键是拿捏出 什么情况下会形成环？ 以下两种情况：

- 经过一轮指令后 机器人回到了原点 很明显这能形成环
- 经过一轮指令后 机器人没有回到原点但是改变了方向 因为如果刚好是改变了180度方向 那么下一次肯定走回来 如果改变了90度 那么肯定4次能改回来

然后就去模拟了 模拟整个指令 得出上述两个结果

```java
public boolean isRobotBounded(String instructions) {
    int x = 0, y = 0;
    int[] directions = {1,-1,-1,1}; //北 西 南 东
    int directionIndex = 0;
    for (char c : instructions.toCharArray()) {
        if(c == 'G'){
            if(directionIndex == 0 || directionIndex == 2) //利用方向模拟步数
                y += directions[directionIndex];
            else
                x += directions[directionIndex];
        }
        else if(c == 'L')
            directionIndex = (directionIndex + 1) % 4;
        else
            directionIndex = (directionIndex + 3) % 4; //这里模拟退一步
    }
    if((x == 0 && y == 0) || directionIndex != 0)
        return true;
    return false;
}
```

### 1月10日

> #### [415. 字符串相加](https://leetcode-cn.com/problems/add-strings/)

模拟竖式相加法 直接从最低位相加 依次取出对应位置的数值 然后双指针从后往前走

1. 如果加出来大于10 则得到进位
2. 否则直接加到答案后面
3. 更新add
4. 只有当当前指针没有走到尽头才去取出来

```java
public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = x + y + add;
            sb.append(temp % 10);
            add = temp / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
```

> #### [306. 累加数](https://leetcode-cn.com/problems/additive-number/)

题目可能很好理解但是挺繁琐的过程还是挺繁琐的

我们循环地去确定数列的第一位和第二位 **如果第一位和第二位确定下来了 那么整个满足真值的数列肯定是唯一的**

首先我们用上面那道题的方法判断两个字符串相加是否相等 剩下的就是不断模拟下标移动去判断是否存在这样一种情况。

注意设置数列第一位和第二位的时候 如果第一位和第二位长度超过1 那么它绝对不可以有前导0  即第一位不能是0

```java
 public boolean isAdditiveNumber(String num) {
        for(int i = 0; i < num.length(); i++){
            for(int j = i + 1; j < num.length(); j++){
                String s1 = num.substring(0,i + 1);
                if(s1.length() > 1 && s1.charAt(0) == '0')
                    break;
                String s2 = num.substring(i + 1,j + 1);
                if(s2.length() > 1 && s2.charAt(0) == '0')
                    break;
              //if(check(num.substring(j + 1, num.length()),s1,s2))
                    //return true; 递归写法
                String res = addTwoString(s1,s2);
                int start = j + 1;
                while (start + res.length() <= num.length()){
                    String temp = num.substring(start, start + res.length());
                    if(temp.equals(res) && start + temp.length() == num.length())
                        return true;
                    if(!temp.equals(res))
                        break;
                    start = start + temp.length();
                    s1 = s2;
                    s2 = temp;
                    res = addTwoString(s1,s2);

                }
            }
        }
        return false;
    }
    public String addTwoString(String s1, String s2){
        StringBuilder res = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? s1.charAt(i) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j) - '0' : 0;
            res.append((x + y + add) % 10);
            add = (x + y + add) / 10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }
public boolean check(String temp, String s1, String s2){
        String res = addTwoString(s1,s2);
        if(temp.equals(res))
            return true;
        if(temp.length() < res.length() || !temp.substring(0,res.length()).equals(res))
            return false;
        return check(temp.substring(res.length(),temp.length()),s2,res);
    }
```

> #### [424. 替换后的最长重复字符](https://leetcode-cn.com/problems/longest-repeating-character-replacement/)

滑动窗口新题

既然都是滑动窗口了 最关键的是弄懂**如何让窗口变大和变小的条件**

对于这道题 求一个替换后连续相同的字串的长度是多少 `总结一下对于一个子串如果该串中出现次数最多的字符 加上 k 大于等于 该串的长度` 那么该串就是符合条件的

所以如何找出这样的子串呢 就是滑动窗口走 当满足这样一个条件的时候 一直往左边扩大 一旦发现最大的字符的个数 加上 k 小于了 窗口的长度

那么就左指针往前走 首先为什么往左后 

这道题 放弃 反正就是第一次找到maxcount 后 答案一定是以他为核心的合法序列 不可能比这个小啦

```java
 public int characterReplacement(String s, int k) {
int[] count = new int[26];
        int j = 0;
        int maxIndex = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'A';
            count[index]++;
            if(count[index] > count[maxIndex])
                maxIndex = index;
            if(count[maxIndex] + k >= (i - j + 1))
                res = Math.max(res,i - j + 1);
            else{
                count[s.charAt(j) - 'A']--;
                j++;
            }
        }
        return res;
    }
```

### 1月12日

> #### [334. 递增的三元子序列](https://leetcode-cn.com/problems/increasing-triplet-subsequence/)

首先当然可以用计算最长递增子序列的方法去计算 就是计算每个字符结尾的最长递增子序列 然后看等不等于3 就返回true 很明显超时 且大材小用

既然都是三元序列了 应该很明显去想到利用大于 小于的关系 以及多的数字来减少复杂度

考虑这样一个关系：

对于数组中的第一个数字 我们假设位最小值 并且假设最大值为正无穷

从数组下标的第一个位置开始遍历：

- 如果当前数字比最大值大 那么它肯比最小值还大 那么代表肯定有这样的三个数字 那么直接返回true
- 如果当前只比最小值大 那么`将最大值变成当前数字 ` 很明显真正的最大值肯定不是当前数字 我们只是为了去保证这样一个相对顺序 即`最小值永远出现在最大值的左边`

​		这样不会错过答案 例如 3 7 5 11 很明显 3 7 11 是答案 根据我们的算法我们找到的是 3 5 11

- 如果当前值比最小值还要小 最小值等于当前值

```java
public boolean better(int[] nums){
    if(nums.length < 3)
        return false;
    int min = nums[0];
    int max = Integer.MAX_VALUE;
    for(int i = 1; i < nums.length; i++)
        if(nums[i] > max)
            return true;
        else if(nums[i] > min)
            max = nums[i];
        else
            min = nums[i];
    return false;
}
```

> #### [19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

第一种方法 一年前的我 数出来链表有多少个节点 然后去正向删除

第二种方法 将链表存在栈里面 取出来的时候 第n个直接不要

第三种方法 快慢指针法 快指针先走n步 然后慢指针走 当快指针走不动的时候 慢指针刚好来到倒数第n个节点

但是由于删除链表需要前一个节点 所有我们将 **慢指针放在呀节点开始**

```java
 public ListNode removeNthFromEnd(ListNode head, int n) {
if(head == null)
            return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode first = head;
        for(int i = 0; i < n; i++)
            first = first.next;
        while (first != null){
            slow = slow.next;
            first = first.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
```

### 1月13日

> #### [747. 至少是其他数字两倍的最大数](https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/)

最笨的方法遍历一次找到最大值 再遍历一遍依次判断

聪明的方法： 遍历一次找到最大值 和 次最大值 如果最大值是次大值的两倍 那么肯定是其他的两倍有余 

```java
  public int dominantIndex(int[] nums) {
int first = -1;
        int second = -1;
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > first){
                second = first;
                first = nums[i];
                index = i;
            }
            else if(nums[i] > second)
                second = nums[i];
        }
        if(first >= 2 * second)
            return index;
        return -1;
    }
```

> #### [1027. 最长等差数列](https://leetcode-cn.com/problems/longest-arithmetic-subsequence/)

这道题跟最长递增子序列很像 **唯一的区别就是我们需要去规定递增的长度**

首先数据的大小在0到500之间 所以公差的范围就在-500 到 500 之间

所以公差的可能性有1001种 包括0啦

最简单的方法（超时）枚举所有公差

然后遍历到每个数字的时候 再从0位置新起来一个指针开始遍历 如果当前差值满足公差 那么**以当前元素结尾 公差为d的长度就找到了** 为找到的那个元素 公差为d 的 加1

注意数组下标不能为负数 所以移动一下

```java
public int longestArithSeqLength(int[] nums) {
    int[][] dp = new int[nums.length][1001];
    int res = 0;
    for(int i = 0; i <= 1000; i++){
        int diff = i - 500; //转换一下
        for(int j = 0; j < nums.length; j++){
            {
                dp[j][i] = 1; //最少就是它自己 就是1
                for(int k = 0; k < j; k++)
                    if(nums[k] + diff == nums[j]) 
                        dp[j][i] = Math.max(dp[j][i],dp[k][i] + 1); 
            }
        res = Math.max(res,dp[j][i]);
        }
    }
    return res;
}
```

更好的方法 不用枚举所有的公差 因为公差不可能都出现 是根据数据来出现的

我们内循环和外面的值找到公差后

当前值以公差d为结尾的长度就是 找到的前一个值的公差为d 的长度 加一

由于数组每个元素初始化应该为1 所以返回时 加一个1即可

```java
int[][] dp = new int[nums.length][1001];
int res = 0;
for(int i = 0; i < nums.length; i++)
    for(int j = 0; j < i; j++){
        int diff = nums[i] - nums[j] + 500;
        dp[i][diff] = dp[j][diff] + 1;
        res = Math.max(dp[i][diff],res);
    }
return res + 1;
```

### 1月14日

> #### [264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/)

首先丑数的起始数字是1 然后每一个丑数都是通过原有的丑数乘以`2 3 5`到达的 所以我们就从1构建 将每次构建的丑数加入到最小堆中 每次取堆顶元素来构建

但是要知道这样构建可能会造成重复数字 例如2 * 3 和 3 * 2 所以借助set来记录下 所以这样空间复杂度有点大

```java
 public int nthUglyNumberBetter(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        priorityQueue.add(1l);
        while (n-- > 1){
            Long temp = priorityQueue.poll();
            if(set.add(temp * 2))
                priorityQueue.add(temp * 2);
            if(set.add(temp * 3))
                priorityQueue.add(temp * 3);
            if(set.add(temp * 5))
                priorityQueue.add(temp * 5);
        }
        return Math.toIntExact(priorityQueue.poll());
    }
```

动态规划法 还是去从一个一个的数字慢慢构建 对于一个数字 我们可以乘以 2 3 5

每一个数字都要进行三种这样的运算  每次取最小的那个 

注意值相同时 指针也要移动 **这样可以排除重复元素**

```java
 public int nthUglyNumber(int n) {
int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for(int i = 1; i < dp.length; i++){
            int x = dp[p1] * 2;
            int y = dp[p2] * 3;
            int z = dp[p3] * 5;
            dp[i] = Math.min(x,Math.min(y,z));
            if(dp[i] == x)
                p1++;
            if(dp[i] == y)
                p2++;
            if(dp[i] == z)
                p3++;
        }
        return dp[n - 1];
    }
```

### 1月17日

> #### [1220. 统计元音字母序列的数目](https://leetcode-cn.com/problems/count-vowels-permutation/)

很简单的递归改出动态规划 不觉得是困难题。。。 没啥好说的 常规练手感罢了

或许有时候取模 只需要把int数组换成long数组 然后在最后的时候取模就好啦 一般难

```java
public int countVowelPermutation(int n) {
 long[][] dp = new long[n + 1][6];
        int mod = 1000000007;
        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = 1;
        for(int i = 1; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++){
                long ans = 0;
                if(j == 0)
                    ans = dp[i - 1][1];
                else if(j == 1)
                    ans = dp[i - 1][0] + dp[i - 1][2];
                else if(j == 2)
                    ans = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4];
                else if(j == 3)
                    ans = dp[i - 1][2] + dp[i - 1][4];
                else if(j == 4)
                    ans = dp[i - 1][0];
                else{
                    for(int k = 0; k <= 4; k++)
                        ans += dp[i - 1][k];
                }
                dp[i][j] = ans % mod;
            }
        return (int) dp[n][5];
    }
```

> #### [378. 有序矩阵中第 K 小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/)
>
> #### [373. 查找和最小的 K 对数字](https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/)

首先对于矩阵中查找 最小值肯定在第一列中 我们用堆的性质 每次弹出的肯定是最小的去帮我们记录这个过程 最笨的方法当然是把所有元素都压入堆中 再慢慢弹出来 这样明显不太优秀 

我们把第一列元素压进去之后 然后弹出来后 下一个最小的元素肯定是在其 **下面一个元素 或者 右边一个元素** 所以我们记录元素的坐标而不是单独的值 所以我们将右边的元素压进去即可 

为什么下面的那个元素不用我们去压进去？ 因为一开始我们把第一列压进去后， 后面比较的时候 如果它小 它会把右边的元素压进去

```java
 public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
 List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return nums1[t1[0]] + nums2[t1[1]] - nums1[t2[0]] - nums2[t2[1]];
            }
        });
        for(int i = 0; i < nums1.length; i++)
            priorityQueue.add(new int[]{i,0});
        while (!priorityQueue.isEmpty() && k-- > 0){
            int[] temp = priorityQueue.poll();
            ans.add(Arrays.asList(nums1[temp[0]],nums2[temp[1]]));
            if(temp[1] + 1 < nums2.length)
                priorityQueue.add(new int[]{temp[0],temp[1] + 1});
        }
        return ans;
    }

```

对于最小的k对 思路大概也是 最小的元素肯定是两个数组的起始位置组成的数字对 然后我们将`num1` 中的每个元素 和 `num2`的第一个元素组成的数字对 全部压入堆中

在弹出来的时候 去把当前元素指向的num2的下一个位置 也压进去

```java
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return nums1[t1[0]] + nums2[t1[1]] - nums1[t2[0]] - nums2[t2[1]];
            }
        });
        for(int i = 0; i < nums1.length; i++)
            priorityQueue.add(new int[]{i,0});
        while (!priorityQueue.isEmpty() && k-- > 0){
            int[] temp = priorityQueue.poll();
            ans.add(Arrays.asList(nums1[temp[0]],nums2[temp[1]]));
            if(temp[1] + 1 < nums2.length)
                priorityQueue.add(new int[]{temp[0],temp[1] + 1});
        }
        return ans;
    }
```

> #### [面试题 17.18. 最短超串](https://leetcode-cn.com/problems/shortest-supersequence-lcci/)

 这道题也是滑动窗口的思想 用hashmap 记录需要的字母的出现次数

所以当hashmap 的 大小满足需要的字符的数量后 左指针回退 直到回退到size - 1 就可以了

利用set判断是否是需要的字符

```java
 public int[] shortestSeq(int[] big, int[] small) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        int[] ans = new int[2];
        int j = 0;
        boolean flag = false;
        for(int i = 0; i < small.length; i++)
            set.add(small[i]);
        for(int i = 0; i < big.length; i++){
            if(set.contains(big[i]))
                map.put(big[i],map.getOrDefault(big[i],0) + 1);
            while (map.size() == small.length){
                flag = true;
                if(i - j < res){
                    res = i - j;
                    ans[0] = j;
                    ans[1] = i;
                }
                if(map.containsKey(big[j])){
                    if(map.get(big[j]) > 1)
                        map.put(big[j],map.get(big[j]) - 1);
                    else
                        map.remove(big[j]);
                }
                j++;
            }
        }
        return flag ? ans : new int[0];
    }

```

### 1月18日

> #### [539. 最小时间差](https://leetcode-cn.com/problems/minimum-time-difference/)

题目不难 不用去想太多 对字符串直接进行排序后 对于每一个字符串利用提取转换为int 算出分钟值 再两两相减

最主要的是 如何判断`23:59` 和 `00:00` 的差值 答案是 `00:00 - 23:59`的分钟数 加上 `1440`

类似于求模8中 `0 和 7`距离 为`0 - 7 + 8 = 1`

```java
public int findMinDifference(List<String> timePoints) {
    Collections.sort(timePoints);
    int ans = Integer.MAX_VALUE;
    for(int i = 1; i < timePoints.size(); i++){
        ans = Math.min(getMinutes(timePoints.get(i)) - getMinutes(timePoints.get(i - 1)), ans);
    }
    int first = getMinutes(timePoints.get(0));
    int last = getMinutes(timePoints.get(timePoints.size() - 1));
    ans = Math.min(ans,first - last + 1440);
    return ans;
}
public int getMinutes(String time){
    int hour = Integer.parseInt(time.substring(0,2));
    int minute = Integer.parseInt(time.substring(3,5));
    return hour * 60 + minute;
}
```

> #### [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)

同上面的最短超串差不多 区别在于这道题在于`控制匹配串中也要有相等的字符`

滑动窗口无外乎就两个主要的点：

- 什么时候满足题目的条件 即什么时候窗口里的条件是我们想要的
- 当满足条件后 我们该怎么回退窗口

1.如何判断满足条件？

整体也是滑动窗口和哈希表的思想 我们如何判断滑动窗口已经含有和`t中相同种类的字符并且字符的数量也是一样的`？

我们用一个success变量初始等于t的哈希表长度 每当我们更新一个字符并且他在t中 我们看看`s的数量是否等于t的数量` 如果相等代表满足了一种 所以`success--` 当`success == 0`的时候代表滑动窗口已经满足条件了！

2.如何回退窗口

当我们左指针回退的时候 如果`当前回退的字符在s中出现的次数 == 在t中出现的次数` 那么我们把`success++` 首先不可能s中的数量不可能小于t中的数量 因为如果这样success不可能等于0

所以`s中的数量只可能是大于等于t中的数量` 如果大于的话 那么代表这个字符是多余的 我们不要它也能满足条件 最短的字符串肯定在右边 

所以如果等于的话 回退后就直接把在`s中的数量 - 1` 不用考虑移除对象什么的 因为没必要 它最小只会等于0 不会为负数 不会影响我们的答案

**注意题目的数据太大 hash表存的是Integer对象 所以不能简单的相等比较 用equal！！！！！**

```java
 public String minWindow(String s, String t) {
 int success = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++)
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        success = map.size();
        HashMap<Character,Integer> window = new HashMap<>();
        int j = 0;
        int length = Integer.MAX_VALUE;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            window.put(temp,window.getOrDefault(temp,0) + 1);
            if(window.get(temp).equals(map.get(temp)))
                success--;
            while (success == 0){
                if(i - j < length)
                {
                    length = i - j + 1;
                    start = j;
                }
                char left = s.charAt(j);
                if(window.get(left).equals(map.get(left)))
                    success++;
                window.put(left,window.get(left) - 1);
                j++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start,start + length);
    }
```

### 1月19日

> #### [1029. 两地调度](https://leetcode-cn.com/problems/two-city-scheduling/)

贪心算法 首先假设全部2n个人都飞往一个地方 那么我们得到一个sum的代价 然后再选n个人飞往另一个地方 那么减少或增加的代价就是`b - a` 所以表达式为`sum + n(b - a) ` sum和 n都是固定的

所以对数组按照b - a排序 先得到排序前的累加和 最后选前n个飞向另一个地方就好啦

```java
public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        for(int i = 0; i < costs.length; i++)
            sum += costs[i][0];
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return (t1[1] - t1[0]) - (t2[1] - t2[0]);
            }
        });
        for(int i = 0; i < costs.length / 2; i++)
            sum += (costs[i][1] - costs[i][0]);
        return sum;
    }
```

> #### [221. 最大正方形](https://leetcode-cn.com/problems/maximal-square/)

首先这道题肯定是动态规划 动态规划的思想是去计算每个以`matrix[i][j]`为右下角结尾的正方形的边长 

1. 对于`matrix[i][j] == 0`的情况 那么此边长肯定为0

2. 对于`matrix[i][j] == 1`的情况 第一行 第一列肯定都为1 因为第一行第一列最多只能跟自己形成正方形

   其余正常情况下 为左边 上面 左上角的最小值

记录的最大边长即可。

```java
 int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++){
                if(matrix[i][j] == '0')
                    dp[i][j] = 0;
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    if(i - 1 < 0)
                        dp[i][j] = 1;
                    else if(j - 1 < 0)
                        dp[i][j] = 1;
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
        return res * res;
```

> #### [统计全为 1 的正方形子矩阵](https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/)

同上道题那样 动态规划都一样

对于`每一个元素求得以他结尾的最大边长后 那么以她为右下角结尾的正方形的个数 都是她边长的长度` 直接相加就好啦

```java
int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0)
                    continue;
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i - 1][j - 1]),dp[i][j - 1]) + 1;
                ans += dp[i][j];
            }
        return ans;
```

### 1月20日

> #### [435. 无重叠区间](https://leetcode-cn.com/problems/non-overlapping-intervals/)

这道题最直接的方法当然是动态规划了 先`按照左边的起始位置排序`排序 那么答案一定是在其中的序列里面 然后根据最长公共子序列的问题一样 去向前查找 超时

```java
public int dp(int[][] intervals){
    Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] t1, int[] t2) {
            return t1[0] - t2[0];
        }
    });
    int ans = Integer.MAX_VALUE;
    int[] dp = new int[intervals.length];
    for(int i = 0; i < dp.length; i++)
        {
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(intervals[j][1] <= intervals[i][0])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            ans = Math.min(ans, intervals.length - dp[i]);
        }
    return ans;
}
```

今天学到一个新的方法 那就是贪心 贪心策略为: `优先选择早点结束的区间 那么剩下的时间就更多 那么就可以做其他更多的事情 每一次都选择最先结束的 那么就是局部最优解 可以推出全局最优解`

所以按照右边的结束位置排序 第一个最早结束那么肯定选它 就跟你拿钱一样 首先选最大的钱 如果后面有交叉的区间 那么直接不要它 因为如果要那个交叉的区间 肯定不如前面个最优的选择来的多

```java
public int greedy(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        int preEnd = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] >= preEnd){
                count++;
                preEnd = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
```

> #### [452. 用最少数量的箭引爆气球](https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/)

贪心算法 首先按照结束区间从小到大的排序 如果后面一个的起始在前一个的结束位置之中 那么就一只弓箭就好啦 

否则更新preend 并且共弓箭加一

```java
 public int findMinArrowShots(int[][] points) {
Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return Integer.compare(t1[1], t2[1]);
            }
        });
        int count = 0;
        long preEnd = Long.MIN_VALUE;
        for(int i = 0; i < points.length; i++){
            if(points[i][0] > preEnd){
                count++;
                preEnd = points[i][1];
            }
        }
        return count;
    }
```

### 1月24日

> #### [2034. 股票价格波动](https://leetcode-cn.com/problems/stock-price-fluctuation/)

最新的股票当然通过一个变量去记录 但是最大值和最小值是不不可以的 必入我把 **原本是最大值的股票更新了一个数值 那么最大值到底是多少**？

所以我们需要一个有序集合 去记录我们的最大值和最小值 所以就用到了`红黑树 TreeMap`

`firstKey 返回key的最小值 lastKey返回key的最大值` value 存储 `key出现的次数`

每次更新时 我们也去更新红黑树里次数出现的关系 

例如 如果更新当前时间戳的股票 我们也要去同步更新以前记录当前时间戳股票价格的记录 如果之前有当前时间戳的记录 我们要将那个时间记录下的股票价格出现次数 - 1 如果是1 直接移除

```java
class StockPrice { 

   HashMap<Integer,Integer> map;
    TreeMap<Integer, Integer> treeMap;
    int curTime;
    public StockPrice() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
        curTime = -1;
    }

    public void update(int timestamp, int price) {
        curTime =  Math.max(curTime,timestamp);
        int oldPrice = map.getOrDefault(timestamp,0);
        map.put(timestamp,price);
        if(oldPrice != 0){
            if(treeMap.get(oldPrice) == 1)
                treeMap.remove(oldPrice);
            else
                treeMap.put(oldPrice,treeMap.get(oldPrice) - 1);
        }
        treeMap.put(price,treeMap.getOrDefault(price,0) + 1);
    }

    public int current() {
        return map.get(curTime);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}
```

> #### [36. 有效的数独](https://leetcode-cn.com/problems/valid-sudoku/)

这道题没有想象中那么困难 当然自己最直观的解法是挨次判断

- 每一行有无重复的数字 循环9次
- 每一列有无重复的数字 循环9次
- 每一个三角区域有无重复的数字 重复9 * 9 = 81次

但是看了官方题解后 其实可以通过一次遍历 就可以判断出来 每次遍历到一个字符不用那么着急去判断整行整列整个小方块是否满足 只是判断目前是否满足

所以开辟两个数组 存放 每一行 每一列 字符的对应关系 关键是如何存储9个小方块的关系？

这里用 **坐标映射** 比如左上角的方块的横坐标和纵坐标都除以3 都是 0 和 0 所以用一个三维数组 来存储对应关系

```java
public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9]; //用于记录每一行 9个字符出现的次数
        int[][] col = new int[9][9]; //用于记录没一列 9个字符出现的次数
        int[][][] square = new int[3][3][9]; //用于记录每一个方块 9个字符出现的次数
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++){
                char temp = board[i][j];
                if(temp != '.'){
                    int index = temp - '1';
                    row[i][index]++;
                    col[j][index]++;
                    square[i / 3][j / 3][index]++;
                    if(row[i][index] > 1 || col[j][index] > 1 || square[i / 3][j / 3][index] > 1) //只判断目前所在的行和列 以及 小方块是否满足
                        return false;
                }
            }
        return true;
     }
```

> #### [37. 解数独](https://leetcode-cn.com/problems/sudoku-solver/)

关键还是 递归回溯 + 上面道题关于 是否满足条件的判断

核心思想是：

1. 先计算起始棋盘各位置字符的统计次数 
2. 从左上角依次往下遍历 碰到非`.` 就往后面走 直到找到我们可以填充的空格位置
3. 在空格位置依次尝试9个字符 并且递归下去 直到递归返回true位置 返回false的话 记得修改全局状态 进行下一次递归

整体来说不难 跟八皇后很像 以我现在的递归功底来说的话 很快就能秒了

核心是i j 指针怎么加减的

```java
public class Solution {
    int[][] row = new int[9][9];
    int[][] col = new int[9][9];
    int[][][] square = new int[3][3][9];
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.'){
                    int index = board[i][j] - '1';
                    row[i][index]++;
                    col[j][index]++;
                    square[i / 3][j / 3][index]++;
                }
        dfs(board,0,0);
    }
    public boolean dfs(char[][] board, int i, int j){
        while (board[i][j] != '.'){
            j++;
            if(j == 9){
                i++;
                j = 0;
            }
            if(i == 9)
                return true;
        }

            for(char num = '1'; num <= '9'; num++){
                int index = num - '1';
                if(row[i][index] == 0 && col[j][index] == 0 && square[i / 3][j / 3][index] == 0){
                    row[i][index]++;
                    col[j][index]++;
                    square[i / 3][j / 3][index]++;
                    board[i][j] = num;
                    if(dfs(board, i , j))
                        return true;
                    else{
                        board[i][j] = '.';
                        row[i][index]--;
                        col[j][index]--;
                        square[i / 3][j / 3][index]--;
                    }
                }
            }

        return false;
    }
}
```

> #### [2109. 向字符串添加空格](https://leetcode-cn.com/problems/adding-spaces-to-a-string/)

题目很简单 但是可以用数组赋值的方法 模拟两个字符串拼接

注意双指针移动 即可。

```java
public String addSpaces(String s, int[] spaces) {
char[] res = new char[s.length() + spaces.length];
        int left = 0;
        int right = 0;
        for(int i = 0; i < res.length; i++){
            if(right < spaces.length && left == spaces[right]){
                res[i] = ' ';
                right++;
            }
            else{
                res[i] = s.charAt(left);
                left++;
            }
        }
        return String.valueOf(res);
    }
```

> #### [1638. 统计只差一个字符的子串数目](https://leetcode-cn.com/problems/count-substrings-that-differ-by-one-character/)

 没有什么大神解法 没有什么动态规划递归 只是暴力枚举！！！

不停改变 a 串 和 b串的起始位置 以及子串的长度 然后往后面比较

如果不一样diff++ 

```java
public int countSubstrings(String s, String t) {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
            for(int j = 0; j < t.length(); j++){
                int diff = 0;
                for(int k = 0; k + i < s.length() && k + j < t.length(); k++){
                    if(s.charAt(i + k) != t.charAt(j + k))
                        diff++;
                    if(diff > 1)
                        break;
                    if(diff == 1)
                        count++;
                }
            }
        return count;
    }
```

### 1月26日

> #### [2013. 检测正方形](https://leetcode-cn.com/problems/detect-squares/)

其实这道题挺无聊的 我们开辟一个hash表 key为x坐标 value 为 hash表 value的key为y坐标 value的 value 为出现的次数

每次加进去时更新此数据结构 当要计算时 我们去枚举同一个纵坐标的点数 

然后去计算边长 然后去求另外两个点 将三个点出现的次数相乘得到对应的答案。

```java
public class DetectSquares {
    HashMap<Integer,HashMap<Integer,Integer>> map;
    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        HashMap<Integer, Integer> orDefault = map.getOrDefault(x, new HashMap<>());
        orDefault.put(y,orDefault.getOrDefault(y,0) + 1);
        map.put(x,orDefault);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int count = 0;
        HashMap<Integer, Integer> col = map.getOrDefault(x, new HashMap<>());
        for (Integer y1 : col.keySet()) {
            if(y1 == y)
                continue;
            int len = Math.abs(y1 - y);
            //先求右面的
            int a = x + len;
            //求出右边正方形的边
            HashMap<Integer, Integer> temp = map.getOrDefault(a, new HashMap<>());
            int count1 = temp.getOrDefault(y,0) * temp.getOrDefault(y1,0) * col.get(y1);
            //求左边的
            a = x - len;
            temp = map.getOrDefault(a, new HashMap<>());
            int count2 = (temp.getOrDefault(y,0) * temp.getOrDefault(y1,0)* col.get(y1));
            count += (count1 + count2);
        }
        return count;
    }}
```

### 1月27日

> #### [2047. 句子中的有效单词数](https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/)

无脑模拟即可 学到的一点 判断是否是小写字母 是否是数字 

用自带的方法`Character.isLetter()`

```java
class Solution {
    public int countValidWords(String sentence) {
 String[] split = sentence.split(" ");
        int count = 0;
        for(int i = 0; i < split.length; i++){
            String temp = split[i];
            if(temp.equals(""))
                continue;
            boolean flag = true;
            int countLian = 0;
            for(int j = 0; j < temp.length(); j++){
                if(Character.isDigit(temp.charAt(j))){
                    flag = false;
                    break;
                }
                if(temp.charAt(j) == '-'){
                    countLian++;
                    if(countLian > 1 || j == 0 || j == temp.length() - 1 || !Character.isLetter(temp.charAt(j - 1)) || !Character.isLetter(temp.charAt(j + 1))){
                        flag = false;
                        break;
                    }
                }
                if(temp.charAt(j) == '.' || temp.charAt(j) == '!' || temp.charAt(j) == ','){
                    if(j != temp.length() - 1){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                count++;
        }
        return count;
    }
}
```

### 2月7日

> #### [1405. 最长快乐字符串](https://leetcode-cn.com/problems/longest-happy-string/)

每次选取剩余次数最多的字符加到字符串的后面 当然要满足不能出现三个连续一样的 因为剩余的同一种字符越多 **越不能满足条件越容易出现字符相同的情况**

依次从当前数量最多的字母开始尝试，如果发现加入当前字母会导致出现三个连续相同字母，则跳过当前字母，直到我们找到可以添加的字母为止。**实际上每次只会在数量最多和次多的字母中选择一个。**

如果尝试所有的字母都无法添加，则直接退出，此时构成的字符串即为最长的快乐字符串。

具体的模拟次数用大根堆即可。

```java
public String longestDiverseString(int a, int b, int c) {
        //大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[0] - t1[0];
            }
        });
        if(a > 0)
            queue.add(new int[]{a,0});
        if(b > 0)
            queue.add(new int[]{b,1});
        if(c > 0)
            queue.add(new int[]{c,2});
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int len = sb.length();
            if(len >= 2 && sb.charAt(len - 1) - 'a' == cur[1] && sb.charAt(len - 2) - 'a' == cur[1]){
                if(queue.isEmpty())
                    break;
                int[] temp = queue.poll();
                sb.append((char)('a' + temp[1]));
                if(--temp[0] > 0)
                    queue.add(temp);
                queue.add(cur);
            }
            else{
                sb.append((char)('a' + cur[1]));
                if(--cur[0] > 0)
                    queue.add(cur);
            }
        }
        return sb.toString();
    }
```

> #### [611. 有效三角形的个数](https://leetcode-cn.com/problems/valid-triangle-number/)

我们首先将数组排序 依次用两重循环去固定三角形的两条边 那么第三条边一定在这两条边的后面 因为 第一条边加上第三条边一定大于第二条边 第二条边加上第三条边一定大于第二条边

问题是如何找到第一条边 + 第二条边  > 第三条边 即 在 第二条边的后面找到**最后一个小于 `a + b`的下标** 那么在这区间里 都是满足的 方法：二分查找！

```java
public int triangleNumber(int[] nums) {
    int count = 0;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i++){
        if(nums[i] == 0)
            continue;
        for(int j = i + 1; j < nums.length; j++){
            int c = nums[i] + nums[j];
            //去寻找最后一个不大于c的下标 因为第三条边 不能大于两边之和
            int left = j + 1;
            int right = nums.length - 1;
            int index = -1;
            while (left <= right){
                int middle = left + (right - left) / 2;
                if(nums[middle] < c){
                    index = middle;
                    left = middle + 1;
                }
                else
                    right = middle - 1;
            }
            if(index != -1){
                count += (index - j);
            }
        }
    }
    return count;
}
```

上述方法 好是好 但是每次枚举第二条边时 又是重新查找了一遍第三条边 但是比如说这样呢 在上一轮j中 已经找到k的下标 那么新的一轮中 这个k肯定是往后移动的 因为第二条边的值增加了 那么c也可以增加

所以我们不用二分查找 每一次不重新设置k的值就好

```java
public int better(int[] nums){
    int count = 0;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i++){
        if(nums[i] == 0)
            continue;
        int k = i;
        for(int j = i + 1; j < nums.length; j++){ //每次更改第二条边时 第三条边的下标都用的是上一次最后的那个k
            int c = nums[i] + nums[j];
            while (k < nums.length && nums[k] < c)
                k++;
            count += (k - 1 - j);
        }
    }
    return count;
}
```

> #### [738. 单调递增的数字](https://leetcode-cn.com/problems/monotone-increasing-digits/)

从左往右依次扫描数字 如果出现递减那么就把当前数字 - 1 后面的数字全部是9

如果是 133222 则需要把第一个3➖ 1 后面全部加上 9

```java
public int monotoneIncreasingDigits(int n) {
char[] arr = Integer.toString(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int i = 0;
        while (i < arr.length){
            if(flag)
                sb.append('9');
            else{
                if(i + 1 < arr.length && arr[i + 1] < arr[i]) {
                    flag = true;
                    int j = i;
                    while (j - 1 >= 0 && arr[j - 1] == arr[i])
                        {
                            sb.deleteCharAt(sb.length() - 1);
                            j--;
                        }

                    i = j;
                    sb.append((arr[i] - '1'));
                }
                else
                    sb.append(arr[i]);
            }
            i++;
        }
        return Integer.parseInt(sb.toString());
    }
```

### 2月9日

> #### [904. 水果成篮](https://leetcode-cn.com/problems/fruit-into-baskets/)

经典的滑动窗口模版题 用哈希表表示长度和次数 注意每次回退时的条件即可。

```java
class Solution {
    public int totalFruit(int[] fruits) {
int max = Integer.MIN_VALUE;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < fruits.length; i++){
            int temp = fruits[i];
            map.put(temp,map.getOrDefault(temp,0) + 1);
            count++;
            while (map.size() > 2){
                int left = fruits[j];
                map.put(left,map.get(left) - 1);
                if(map.get(left) == 0)
                    map.remove(left);
                count--;
                j++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
```

### 2月11日

> #### [2165. 重排数字的最小值](https://leetcode-cn.com/problems/smallest-value-of-the-rearranged-number/)

对于0 直接返回0 

对于负数 将数字的每个数字从大到小排序 然后组成的新数字 加一个负号即可。

对于正数 将数字的每个数字从小到大排序 然后很有可能会有前导0 向后查找第一个不等于0的数字 与 他交换 即可。

java可以直接对char排序 对基本数据类型排序时 如果逆序的话 需要手写接口。

```java
public long smallestNumber(long num) {
    if(num == 0)
        return 0;
    if(num < 0){
        String str = String.valueOf(num);
        char[] chars = str.substring(1, str.length()).toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        String temp = sb.reverse().toString();
        long res = Long.parseLong(temp);
        return -res;
    }
    else{
        char[] str = String.valueOf(num).toCharArray();
        Arrays.sort(str);
        int index = 0;
        while (str[index] == '0')
            index++;
        if(index != 0){
            char temp = str[0];
            str[0] = str[index];
            str[index] = temp;
        }
        return Long.parseLong(String.valueOf(str));
    }
}
```

### 2月12日

> #### [1020. 飞地的数量](https://leetcode-cn.com/problems/number-of-enclaves/)

和岛屿问题一样 都是递归感染 从矩形的四条边感染着走 被感染的修改成2 最后统计下剩下多少个1 就是飞地的数量。

```java
 public int numEnclaves(int[][] grid) {
        int count = 0;
        for(int j = 0; j < grid[0].length; j++){
            dfs(grid,0,j);
            dfs(grid,grid.length - 1,j);
        }
        for(int i = 0; i < grid.length; i++){
            dfs(grid,i,0);
            dfs(grid,i,grid[0].length - 1);
        }
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                if(grid[i][j] == 1)
                    count++;
        return count;     
    }
    public void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || grid[i][j] == 2)
            return;
        grid[i][j] = 2;
        dfs(grid,i - 1, j);
        dfs(grid,i + 1, j);
        dfs(grid,i, j - 1);
        dfs(grid,i , j + 1);
    }
```

### 2月14日

> #### [1380. 矩阵中的幸运数](https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/)

预处理获得最大值和最小值 

```java
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
List<Integer> res = new ArrayList<>();
        int[] minRow = new int[matrix.length];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++){
                minRow[i] = Math.min(minRow[i],matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j],matrix[i][j]);
            }
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(minRow[i] == matrix[i][j] && maxCol[j] == matrix[i][j])
                    res.add(matrix[i][j]);
        return res;       
    }
}
```

> #### [1438. 绝对差不超过限制的最长连续子数组](https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)

经典的滑动窗口 竟然是绝对差 那么只考虑滑动窗口中最大值和最小值的差值是否满足限制即可。 **问题就是如何记录滑动窗口中最大值和最小值？**

不能简单的去声明变量最大值和最小值 因为我们只会便利一次 所以用红黑树！！！！

每次记录每个元素的个数 再说一遍 fisrtKey是指存储的key中最小的 lastKey是指最大的

```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
int res = 0;
        int j = 0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit){
                if(treeMap.get(nums[j]) == 1)
                    treeMap.remove(nums[j]);
                else
                    treeMap.put(nums[j],treeMap.get(nums[j]) - 1);
                j++;
            }
            res = Math.max(i - j + 1, res);
        }
        return res;
    }
}
```

### 2月16日

> #### [1248. 统计「优美子数组」](https://leetcode-cn.com/problems/count-number-of-nice-subarrays/)

这道题当然滑动窗口啦 但是题目说要我们获得子数组的个数 请注意满足条件的数组中 可以形成多个子数组

比如 0 1 3 4 当走到4 时 很明显会有 0 13 4 或者1 34都满足

所以用到前缀统计预处理 我们统计 **每个以当前下标结尾的时候 有多少个奇数** 

统计完成后 我们再遍历一遍数组的元素 如果当前元素有x个奇数（如果x直接满足条件那么直接加1） 那么我们再内循环 从当前元素后面一个位置找到满足 y  - x = k 的位置 有多少个这样的位置就代表 i + 1和 j能形成满足条件的子数组

但是这样会超时 因为复杂度是平方 所以用哈希表

 可以一次遍历 一边记录答案 我们存储  奇数的个数和出现这么多个奇数的个数的次数 当遍历到i位置假设当前i位置有x个奇数 要满足k个奇数 那么就要看前面是否有 x - k的奇数的j位置 如果有加上出现次数

这里必须说明这样的记录方法 永远都是 [j + 1,i]构成子数组 即永远不会包含数组的第一个位置 所以当x直接满足的话 直接加1

```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
HashMap<Integer,Integer> map = new HashMap<>(); //n个奇数出现了n次
        int temp = 0;
        int ans = 0;
        //map.put(0,1); 可以手动添加一个辅助 这样每次计算的时候 会包含全部数组的情况
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0)
                temp++;
            map.put(temp,map.getOrDefault(temp,0) + 1);
             if(temp == k) //这里是说当前遍历到当前元素直接满足条件 那么直接添加
                ans++;
            if(temp >= k) //这里为什么还要来一遍等于呢？ 因为前面可能会出现0个奇数的情况 比如前面一直是 2 2 2 但是算上这些2 也可以当成子数组
                ans += map.getOrDefault(temp - k,0);
        }
        return ans;
    }
}
```

### 2月17日

> #### [2024. 考试的最大困扰度](https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/)

滑动窗口模版题 滑动窗口里的字符串为什么 t 和 f都不能超过k 呢 即为什么要满足这个条件呢？

因为满足这个条件的话 不管是以t为标准还是f 为标准 都可以进行互相转换 一旦窗口里有的值超过了k 就不能转换了。

 ```java
 public int maxConsecutiveAnswers(String answerKey, int k) {
 int countT = 0;
         int countF = 0;
         int j = 0;
         int ans = 0;
         for(int i = 0; i < answerKey.length(); i++)
         {
             if(answerKey.charAt(i) == 'T')
                 countT++;
             else 
                 countF++;
             while (countF > k && countT > k){
                 if(answerKey.charAt(j) == 'T')
                     countT--;
                 else
                     countF--;
                 j++;    
             }
             ans = Math.max(ans,i - j + 1);
         }
         return ans;
     }
 ```

### 2月19日

> #### [2160. 拆分数位后四位数字的最小和](https://leetcode-cn.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/)

题目写死了的是四位数 所以四位数拆分的话 肯定是两个两位数加在一起最小 

每次选最小的数字作为十位数的位置 然后剩下的随便组合 所以要排序。

```java
class Solution {
    public int minimumSum(int num) {
 List<Integer> temp = new ArrayList<>();
        while (num != 0){
            temp.add(num % 10);
            num /= 10;
        }
        Collections.sort(temp);
        return temp.get(0) * 10 + temp.get(2) + temp.get(1) * 10 + temp.get(3);
    }
}
```

> #### [2161. 根据给定数字划分数组](https://leetcode-cn.com/problems/partition-array-according-to-given-pivot/)

题目很简单暴力的方法 新建三个列表 把小的 等于 大于的归一类

学到一种新方法：

我们新建一个答案数组 小于指针放在左边 大于指针放在答案数组的末尾 在遍历原来的数组的时候遇到小于的则放到答案数组的小于那边 

大于的放到右边 所以遍历完后 中间没有放的位置就是等于的！！ 但是大于的是逆序的 所以转换下。

```java
 public int[] pivotArray(int[] nums, int pivot) {
int[] res = new int[nums.length];
        Arrays.fill(res,pivot);
        int left = 0;
        int right = res.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot)
                res[left++] = nums[i];
            else if(nums[i] > pivot)
                res[right--] = nums[i];
        }
        int k = nums.length - 1;
        right++;
        while (right < k){
             int temp = res[right];
            res[right] = res[k];
            res[k] = temp;
            k--;
            right++;
        }
        return res;
    }
```

> #### [969. 煎饼排序](https://leetcode-cn.com/problems/pancake-sorting/)

讲真这道题挺无聊的 想一下选择排序的思路

我们每次从开始位置到处理好的边界的位置 找到最大值 然后把他换到最前面 再把他换到最后面 换采用 逆序即可。 只是一些边界很难处理。

```java
 public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int index = arr.length;
        while (index != 0)
        {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for(int i = 0; i < index; i++){
                if(arr[i] > max){
                    max = arr[i];
                    maxIndex = i;
                }
            }
            if(maxIndex == index - 1){
                index--;
                continue;
            }
            res.add(maxIndex + 1);
            reverseArr(arr,0,maxIndex);
            res.add(index);
            reverseArr(arr,0,index - 1);
            index--;
        }
        return res;
    }
    public void reverseArr(int[] arr, int i, int j){
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
```

> #### [717. 1比特与2比特字符](https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/)

首先我们明确一个道理 这样一个字符数组 形成的编码序列是没有异议的 即编码方式是唯一的 自己想想吧

所以我们从头到后面遍历 如果遇到0 直接跳到下一个位置 如果遇到是1 我们不用管他是10 还是11 编码 反正跳到后面2 个位置

为什么循环是小于 n - 1呢 而不是 正常的n 呢？ 如果他刚好跳到n - 1 那么由于最后一位是0 所以满足 

如果他跳过了代表他前面是两个字符的编码 而不是一个 所以返回false

```java
 public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length - 1)
            if(bits[i] == 1)
                i += 2;
            else
                i += 1;
        return i == bits.length - 1;            
    }
```

### 2月21日

> #### [838. 推多米诺](https://leetcode-cn.com/problems/push-dominoes/)

这道题最主要是看清楚几点：

- 如果起始字符串已经有方向了 那就是结果 比如一开始某一处位置是 'L' 那么结果他就是'L' 不管左边右边是什么 能不能倒向它 都不会改变它 题目有说明 所以这道题的本质就是 `对没有倒向的位置进行修改`
- 对于没有方向的位置怎么修改它呢？ 我们去找到连续的`.`区间 看区间左边右边的情况
  - 如果区间左边和右边的方向相同 那么此区间都是这个方向
  - 如果区间左边界 往左走 右区间往右走 即方向是背向的 那么此区间不会被修改
  - 如果区间两个方向互相对冲 那么从左边和右边同时往中间倒 即双指针同时修改 直到两个指针重叠为止
- 具体地 为了排除一些边界情况 即左区间或者右面区间越界 我们人为地在左边和右边加上 'L' 和 'R' 即可涵盖所有边界条件 并且不影响结果。

```java
public String pushDominoesBetter(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        char[] res = dominoes.toCharArray();
        int i = 1;
        while (i < dominoes.length() - 1){
            if (dominoes.charAt(i) != '.')
                i++;
            int j = i;
            while (j < dominoes.length() && dominoes.charAt(j) == '.')
                j++;
            betterReplace(res,i,j - 1);
            i = j;
        }
        return String.valueOf(res).substring(1,res.length - 1);
    }

    public void betterReplace(char[] res, int start, int end){
        if(res[start - 1] == 'L' && res[end + 1] == 'R')
            return;
        else if(res[start - 1] == res[end + 1])
            for(int i = start; i <= end; i++)
                res[i] = res[start - 1];
        else{
            int i = start;
            int j = end;
            while (i < j){
                res[i] = res[start - 1];
                res[j] = res[end + 1];
                i++;
                j--;
            }
        }
    }
```

> #### [1395. 统计作战单位数](https://leetcode-cn.com/problems/count-number-of-teams/)

最笨的方法枚举三元组 很明显复杂度是立方项 肯定超时

好的方法以数组中每一个元素作为中间个士兵 我们做下面的事情：

- 统计左边比他小的个数 以及比他大的个数
- 统计右边比他小的个数 以及比他大的个数

那么以当前士兵为中心能组成的作战单位就是 **左边比它小的 * 右边它大的 （升序） + 左边比它大的 * 右边比它小的（降序）**

```java
public int numTeams(int[] rating) {
         int res = 0;
        for(int i = 0; i < rating.length; i++){
            int temp = rating[i];
            int leftLess = 0;
            int leftGreater = 0;
            int rightLess = 0;
            int rightGreater = 0;
            for(int j = i - 1; j >= 0; j--){
                if(rating[j] > temp)
                    leftGreater++;
                if(rating[j] < temp)
                    leftLess++;
            }
            for(int j = i + 1; j < rating.length; j++){
                if(rating[j] > temp)
                    rightGreater++;
                if(rating[j] < temp)
                    rightLess++;
            }
            res += (leftLess * rightGreater);
            res += (leftGreater * rightLess);
        }
        return res;
    }
```

### 2月22日

> #### [2155. 分组得分最高的所有下标](https://leetcode-cn.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/)

前缀和模拟即可。

```java
  public List<Integer> maxScoreIndices(int[] nums) {
List<Integer> res = new ArrayList<>();
        int[] countOne = new int[nums.length];
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] == 1)
                    count++;
                countOne[i] = count;
            }
        int max = 0;
        //左边0的个数 和右边1的个数
        for(int i = 0; i <= nums.length; i++){
            int left = 0;
            int right = 0;
            if(i == 0)
                right = countOne[nums.length - 1];
            else if(i == nums.length)
                left = nums.length - countOne[nums.length - 1];
            else{
                left = i - countOne[i - 1];
                right = countOne[nums.length - 1] - countOne[i - 1];
            }
            int temp = left + right;
            if(temp < max)
                continue;
            if(temp > max)
                {
                    max = temp;
                    res.clear();
                }
            res.add(i);
        }
        return res;
    }
```

### 2月23日

> #### [837. 新 21 点](https://leetcode-cn.com/problems/new-21-game/)

粗看很简单的递归改动态规划的版本 其实事实也是 无非就是向前枚举递归 改成动态规划还是一维的 但是卡时间 超时

首先这个人能到达的最大点数肯定是 **k - 1 + maxPts** 因为只有k - 1时选择最大才能走到最大 所以声明 **k + maxPts** 长的数组 因为下标从0开始

然后当数字大于等于k时 由于不能再走了 所以概率要么是 0 或者 1 然后向左递推   

所以看了下别人题解 其实可以用到滑动窗口的思想来给动态规划数组赋值 当数字小于k时 每一次能到达的位置都是最右边减去一个 和 左边加上一个

```java
 public double new21Game(int n, int k, int maxPts) {
        return help(n, k, maxPts, 0);
    }
    public double help(int n, int k, int maxPts, int temp){
        if(temp >= k){
            if(temp <= n)
                return 1;
            return 0;
        }
        double res = 0;
        for(int i = 1; i <= maxPts; i++)
            res += help(n,k,maxPts,temp + i);
        return  res / maxPts;
    }
    public double dp(int n, int k, int maxPts){
        double[] dp = new double[k + 1];
        if(dp.length - 1 <= n)
            dp[dp.length - 1] = 1;
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = 1; j <= maxPts; j++){
                if(i + j >= dp.length){
                    if(i + j <= n)
                        dp[i] += 1;
                }
                else
                    dp[i] += dp[i + j];
            }
            dp[i] /= maxPts;
        }
        return dp[0];
    }
    public double dpBetter(int n, int k, int maxPts){
        double[] dp = new double[k + maxPts];
        double window = 0;
        for(int i = dp.length - 1; i >= 0; i--){
            if(i >= k){
                if(i <= n)
                    dp[i] = 1;
                window += dp[i];
            }
            else{
                dp[i] = window / maxPts;
                window = window + dp[i] - dp[i + maxPts];
            }
        }
        return dp[0];
    }
```

> #### [1297. 子串的最大出现次数](https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring/)

如果maxSize 满足 那么minSize 一定满足 因为 **maxSize 里的子串一定满足** 所以满足最终条件的一定是或者含有minsize 的字符串

所以我们就可以用固定窗口大小的滑动窗口去扫面整个字符串 并且记录满足条件的字符串即可。 

```java
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {int max = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Character,Integer> time = new HashMap<>(); //用于记录窗口中字符的出现次数
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            time.put(s.charAt(i),time.getOrDefault(s.charAt(i),0) + 1);
            if(i >= minSize - 1){
                if(time.size() <= maxLetters){
                    String temp = s.substring(j,j + minSize);
                    map.put(temp,map.getOrDefault(temp,0) + 1);
                    max = Math.max(max,map.get(temp));
                }
                if(time.get(s.charAt(j)) == 1)
                    time.remove(s.charAt(j));
                else
                    time.put(s.charAt(j),time.get(s.charAt(j)) - 1);
                j++;
            }
        }
        return max;

    }
}
```

> #### [1234. 替换子串得到平衡字符串](https://leetcode-cn.com/problems/replace-the-substring-for-balanced-string/)

这竟然是一道没有想过的滑动窗口题 反向滑动窗口

我们每次关心的不是滑动窗口里面的情况 而是滑动窗口外面的情况 

首先我们统计这四个字母的出现次数如果刚刚满足长度的四分之一 那么直接返回0 

然后我们不断枚举滑动窗口的右端点 然后看看窗口外的四个字符是否满足都小于等于四分之一 如果都小于等于4分之一 那么代表 **窗口里的数字肯定都可以变成对应差多少到四分之一的数字 ** 所以我们不断收紧窗口的左边界看是否满足 并且统计长度

当然如果外面的数字统计不满足 那么代表要把他收入窗口里面 所以直接到下一步就好了

```java
 public int balancedString(String s) {
        int res = s.length();
        int n = s.length() / 4;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'A']++;
        if(count['Q' - 'A'] == n && count['W' - 'A'] == n && count['E' - 'A'] == n && count['R' - 'A'] == n)
            return 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            int temp = s.charAt(i) - 'A';
            count[temp]--;
            //窗口外的统计
            while (j <= i && count['Q' - 'A'] <= n && count['W' - 'A'] <= n && count['E' - 'A'] <= n && count['R' - 'A'] <= n ){
                res = Math.min(res, i - j + 1);
                count[s.charAt(j) - 'A']++;
                j++;
            }
        }
        return res;
    }
```

### 2月25日

> #### [537. 复数乘法](https://leetcode-cn.com/problems/complex-number-multiplication/)

直接模拟即可 根据复数乘法的展开提取公因式 然后学到了 根据字符串的 + 号分割数组时 需要加上两个转义字符 

```java
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
String[] s1 = num1.split("\\+");
        String[] s2 = num2.split("\\+");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1].substring(0,s1[1].length() - 1));
        int c = Integer.parseInt(s2[0]);
        int d = Integer.parseInt(s2[1].substring(0,s2[1].length() - 1));
        return (a * c - b * d) + "+" + (a * d + b * c) + "i";
    }
}
```

> #### [2134. 最少交换次数来组合所有的 1 II](https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together-ii/)

虽然是滑动窗口 但是也不能算是滑动窗口模版题 因为它的 右边界可以取模 
所以大致思路是 我们要让1连续 很明显我们只需要 事先算出数组里有多少个1 然后以这么长的窗口 去让数组中每个位置都作为起始位置 看看窗口里差多少个1 就代表要交换多少次

很明显我们不用真真正正的去交换数字 **注意一点 当右边界因为环形数组要走到数组的前面时 我们只需要判断 i < j 也可以让程序一直进行**

循环截止的条件是所有数组中的元素都当过起始位置了 即左边界小于长度

```java
public int minSwaps(int[] nums) {
        int countOne = 0;
        for (int num : nums)
            if(num == 1)
                countOne++;
        int temp = 0;
        int res = Integer.MAX_VALUE;
        int j = 0, i = 0;
        while (j < nums.length){
            if(nums[i] == 1)
                temp++;
            if(i >= countOne - 1 || j > i){
                res = Math.min(res,countOne - temp);
                if(res == 0)
                    return res;
                if(nums[j] == 1)
                    temp--;
                j++;
            }
            i = (i + 1) % nums.length;
        }
        return res;

    }
```

如果不是环形数组那么就是滑动窗口模版题了 和环形数组的本质区别是：
**如果不是环形数组 那么不是数组中每个元素都有机会当起始位置 所以枚举末尾就好了 **

```java
class Solution {
    public int minSwaps(int[] data) {
        int count = 0;
        for(int i = 0; i < data.length; i++)
            if(data[i] == 1)
                count++;
        int j = 0;
        int temp = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++){
            if(data[i] == 1)
                temp++;
            if(i >= count - 1){
                ans = Math.min(ans,count - temp);
                if(ans == 0)
                    return ans;
                if(data[j] == 1)
                    temp--;
                j++;        
            }    
        }
        return ans;        
    }
}
```

### 2月26日

> #### [1918. 第 K 小的子数组和·](https://leetcode-cn.com/problems/kth-smallest-subarray-sum/)

首先我们知道整个子数组中最大的和肯定是所有数组元素加起来我们记为max 最小的和为数组中最小的那个元素我们记为min

那么所有子数组中的和肯定在 **[min,max]** 之间 且这个区间的值应该是 **离散的**

首先我们来看如何利用滑动窗口求小于等于target的子数组个数？

原理不难 都是滑动窗口模板题 问题是满足条件时如何计数？ 其实满足条件时 代表 **此滑动窗口拥有了新的右边界 那么我们就统计以当前右边界结尾的满足条件的子数组有多少个 自己数一数知道就是 右边界 - 左边界 + 1** 

再回到问题本身 我们利用二分查找的性质去查找小于等于 [min, max]这个区间 返回的子数组的个数 与 目标k 的关系 来求的第k小的子数组 很明显当传入的值越大时 返回的子数组个数越多 因为它是最大 都小于它

如果传入的当前值我们记为mid 刚好返回小于等于mid的有k个元素 那么是否能说明mid就是答案？ 不一定

因为可能是小于它的有k个 那么它自身就是 k + 1 个 而且对于像 [2,9,2,10,7] 这种你求第一大的子数组和 你根本求不出来 因为小于等于2的子数组有两个 比k大 所以答案不对

所以哪怕我们返回的是k 我们也要看最左边那个值域也能满足k的那个值 才是子数组的和？

为什么呢 因为这是离散的 比如数组中我们传入17 和 传入 14 返回的子数组的个数都是一样的 但是现实情况下只有14这个子数组的和 如果我们返回17不对 我们应该向左找到14才行。



注意这道题不能用小于！！ 不能根绝小于target的数组等于k - 1 来完成因为值可能有重复 [1,2,2,2,3,3] 第三大元素是3！ 

```java
 public int kthSmallestSubarraySum(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max += num;
            min = Math.min(min,num);
        }
        int i = min, j = max;
        int ans = -1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            System.out.println(mid);
            int temp = getLessAndEqualNumber(mid, nums);
            if(temp < k)
                i = mid + 1;
            else{
                j = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
    public int getLessAndEqualNumber(int target, int[] nums){
        int count = 0;
        int sum = 0, j = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum > target){
                sum -= nums[j];
                j++;
            }
            if(sum <= target)
                count += (i - j + 1);
        }
        return count;
    }

```

### 2月28日

> **BM2** **链表内指定区间反转**

慢慢试一下牛客网的界面了 题目不难但是考验基本功和边界条件的控制 算法的核心思想是找到第m个节点的前一个节点 然后翻转后面 n - m + 1个节点 **注意一定要记录反转的第一个节点 因为要和最后一个反转的节点的后面链接起来**

```java
public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
       ListNode newHead = new ListNode(-1);
       newHead.next = head;
       ListNode temp = newHead;
        //find the node of m 
       for(int i = m; i > 1; i--)
           temp = temp.next;
       ListNode cur = temp.next;
       ListNode last = cur; 
       for(int i = 0; i < n - m + 1; i++){
           ListNode next = cur.next;
           cur.next = temp.next;
           temp.next = cur;
           cur = next;
       } 
        last.next = cur;
       return newHead.next;
    }
```

> #### [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

首先如何控制边界条件 如何让头节点和不满足长度的组都能用同一个算法？

给链表添加头节点 并且先计算出链表的长度 然后 除以 k 就只能能分多少组了

后面都是边界条件处理 需要注意的是 反转的话 一定要找到 **反转的前一个节点 和反转后的尾节点 对于尾部的节点就是反转的第一个节点**

```java
public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int num = getLengthOfList(head) / k;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode temp = newHead;
        for(int i = 0; i < num; i++){
            ListNode cur = temp.next;
            ListNode last = temp.next;
            for(int j = 0; j < k; j++){
                ListNode next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                cur = next;
            }
            temp = last;
            temp.next = cur;
        }
        return newHead.next;
    }
    public int getLengthOfList(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
```

### 3月13日

> #### [5227. K 次操作后最大化顶端元素](https://leetcode-cn.com/problems/maximize-the-topmost-element-after-k-moves/)

如果数组长度为1 那么当k为奇数数的时候 怎么栈里都不会有元素 **因为偶数代表一来一回 奇数代表拿出去**

当数组长度大于1 k次操作的最大元素只能是 `前k - 1 个元素中的最大值 和第k + 1 个元素（如果有的话）`

 ```java
     public int maximumTop(int[] nums, int k) {
    if(nums.length == 1){
             if(k % 2 != 0)
                 return -1;
             return nums[0];
         }
         int max = Integer.MIN_VALUE;
       //这里只能取到k - 2 就是第k -1  
       for(int i = 0; i < Math.min(nums.length,k - 1); i++)
             max = Math.max(nums[i],max);
         if(k < nums.length) //取第k 就是k + 1
             max = Math.max(nums[k],max);
         return max;
     }
 ```

### 3月14日

> #### [2044. 统计按位或能得到最大值的子集数目](https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/)

> #### [2055. 蜡烛之间的盘子](https://leetcode-cn.com/problems/plates-between-candles/)

### 3月21日

> #### [720. 词典中最长的单词](https://leetcode-cn.com/problems/longest-word-in-dictionary/)

这虽然是一道非常简单的题 但是可能很久没做了 居然有点茫然

首先我知道肯定要排序 但是排序为么需要比较长度 长度长的放在后面 长度不想等的字典序列小的在前面

排序后 我们依次看 **当前字符串前n - 1个字符组成的子串** 是否在hashset中 如果在代表当前字符串肯定是目前遍历到的位置中最长的 原因如下

- 长度最长的放在后面
- 如果他的前n - 1个在 对于这个n- 1 我们之前处理过 他的前n - 1 也在

```java
class Solution {
    public String longestWord(String[] words) {
  Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() != s2.length())
                    return s1.length() - s2.length();
                return s2.compareTo(s1);
            }
        });
        String ans = "";
        HashSet<String> set= new HashSet<>();
        set.add("");
        for(int i = 0; i < words.length; i++){
            if(set.contains(words[i].substring(0,words[i].length()- 1))){
                ans = words[i];
                set.add(words[i]);
            }
        }
        return ans;
    }
}
```

### 3月27日

> #### [2028. 找出缺失的观测数据](https://leetcode-cn.com/problems/find-missing-observations/)

其实就是正常的模拟 主要是我们求的剩下的n个数字的总和后如何分配给n个数字。

假设剩下的总和为sum 首先sum / n 为每个数字的基本值 再把remider依次分一个给前面的数字 直到分完。

所以要判断剩下的和是否满足在全部为6的范围里面 以及是否至少比n大（所有数字都为1）

```java
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
  int total = (rolls.length + n) * mean;
        int tempSum = 0;
        for (int roll : rolls) {
            tempSum += roll;
        }
        if((total - tempSum) > 6 * n || (total - tempSum) < n)
            return new int[]{};
        total -= tempSum;
        int val = total / n;
        int reminder = total % n;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = val + (i < reminder ? 1 : 0);
        }
        return res;
    }
}
```

### 4月1日

> #### [954. 二倍数对数组](https://leetcode-cn.com/problems/array-of-doubled-pairs/)

题目的意思翻译一下就是 数组首先是偶数长度的 那么必然可以两两分为一组

对于每组数字 这两个数字必须成两倍的数值关系

所以我们先统计数组中各个数字出现的个数

如果出现0的次数为奇数 那么直接返回false

**因为0的两倍还是0 所以0出现的话必须要偶数**

然后我们将map的建根据绝对值排序 然后再遍历 

设当前值为x 遍历的时候看看哈希表中值为2x的个数 是否不小于x的个数 

即必须至少要有相同的个数和小的那个匹配 如果没有false

如果有的话 再更改2x的个数 减去 x的个数 剩下的2x的个数去跟后面进行组合。

所有当哈希表中某个值的个数为0 的时候 一定是由于前面相减造成的 直接continue 

如果遍历完后 都满足以上情况那么就true

**为什么从绝对值最小开始看？**

因为负数的两倍只能更小 所以不能从最小值开始判断 

比如-16 和 -32 如果从-32开始会去看-64 很明显不符合逻辑

```java
class Solution {
    public boolean canReorderDoubled(int[] A) {
HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        if(map.getOrDefault(0,0) % 2 != 0)
            return false;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            arrayList.add(key);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Math.abs(a) - Math.abs(b);
            }
        });
        for (Integer key : arrayList) {
            if(map.get(key) == 0)
                continue;
            if(map.get(key) > map.getOrDefault(2 * key, 0))
                return false;
            map.put(2 * key, map.get(2 * key) - map.get(key));
        }
        return true;
    }
}
```

### 4月14日

> #### [799. 香槟塔](https://leetcode-cn.com/problems/champagne-tower/)

首先这个动态规划非常的明显 甚至不需要递归去推导

当前第i杯中水的数量 = 上一层第i杯溢出来的数量 / 2 + 上一层第i + 1杯溢出来的数量 / 2

```java
public double champagneTower(int poured, int query_row, int query_glass) {
        List<Double> list = new ArrayList<>();
        list.add((double) poured);
        int cup = 2;
        for(int i = 1; i <= query_row; i++){
            List<Double> temp = new ArrayList<>();
            for(int j = 0; j < cup; j++)
                temp.add(getValue(list,j - 1) / 2 + getValue(list,j) / 2);
            cup++;
            list = temp;
        }
        return list.get(query_glass) >= 1 ? 1 : list.get(query_glass);
    }
    public double getValue(List<Double> list, int index){
        if(index < 0 || index >= list.size())
            return 0;
        if(list.get(index) > 1)
            return list.get(index) - 1;
        return 0;
    }
```

### 4月17日

> 复习快速排序

```java
public void quickSort(int[] arr, int left, int right){
  if(left >= right)
    return;
  int base = arr[left];
  int i = left;
  int j = right;
  while(left < right){
    while(left < right && arr[right] >= base)
      right--;
    while(left <right && arr[left] <= base)
      left++;
    swap(arr,left,right);
  }
  swap(arr,i,left);
  quickSort(arr,i,left - 1);
  quickSort(arr,left + 1,j);
}
public void swap(int[] arr, int i, int j){
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}
```

