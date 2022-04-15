package 剑指offer.数组中重复的数字;

public class FindRepeatNumber {

    //暴力指针扫描法
    public void function1()
    {
        int[] arr = {2,3,1,2,5,5,4,3};
        //先排序
        int i = 0;
        int j = 0;
        for(i = 0; i < arr.length - 1; i++)
            for(j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        i = 0;
        j = 0;
        boolean flag;
        while (i < arr.length)
        {
            flag = false;
            j = i + 1;
            while (j < arr.length && arr[j] == arr[i]){
                j = j + 1;
                flag = true;
            }
            if(flag)
                System.out.println(arr[i]);
            i = j;
        }
    }
    //集合法
    
}
