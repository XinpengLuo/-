package 主要练习.暴力递归和动态规划.递归和回溯.数组累加;

public class IsSum {
    String num = " 1";
    public boolean findIsSum(int[] arr, int target){
        return findIsSum(arr,target,0,0,"");
    }
    public boolean findIsSumZuo(int[] arr, int target, int index, int tempSum){
        if(index == arr.length)
            return target == tempSum;
        return findIsSumZuo(arr,target,index + 1,tempSum + arr[index]) ||
                findIsSumZuo(arr,target,index + 1,tempSum);
    }
    public boolean findIsSum(int[] arr, int target, int index, int tempSum,String num){
        if(index < arr.length){
            index = index + 1;
            if(tempSum + arr[index] == target)
                {
                    num = num + arr[index];
                    System.out.println(num);
                    return true;
                }
            else
                return findIsSum(arr,target,index,tempSum + arr[index],num + arr[index])
                        ||
                        findIsSum(arr,target,index,tempSum,num);
        }
        else
            return false;
    }
    public void findIsSumAll(int[] arr, int target, int index, int tempSum,String num){
        if(index + 1 < arr.length){
            index = index + 1;
            if(tempSum + arr[index] == target)
            {
                num = num + arr[index];
                System.out.println(num);
            }
            else if(tempSum + arr[index] > target)
                return;
            else{
                findIsSumAll(arr,target,index,tempSum + arr[index],num + arr[index]);
                findIsSumAll(arr,target,index,tempSum,num);
            }
        }
        else
            return;
    }


    public static void main(String[] args) {
        int[] test = {3,2,3,4,5,6};
        IsSum isSum = new IsSum();
        isSum.findIsSumAll(test,9,-1,0,"");
        System.out.println("---------");
        if (isSum.findIsSum(test,9)) {
            System.out.println(1);
        }else System.out.println(0);


        if (isSum.findIsSumZuo(test,9,0,0)) {
            System.out.println("z");
        }else System.out.println(0);
    }
}
