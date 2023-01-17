package 主要练习.字符串.子域名访问计数;

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String c : cpdomains){
            String[] temp = c.split(" ");
            int count = Integer.parseInt(temp[0]);
            String[] ips = temp[1].split("\\.");
            String pre = "";
            for(int i = ips.length - 1; i >= 0; i--){
                String url = ips[i] + pre;
                map.put(url, map.getOrDefault(url,0) + count);
                pre = "." + url;
            }
        }
        List<String> res = new ArrayList<>();
        for(String url : map.keySet()){
            String s = map.get(url) + " " + url;
            res.add(s);
        }
        return res;
    }

    public void mergeSort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1, right);
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid || j <= right){
            int a = i <= mid ? arr[i] : Integer.MAX_VALUE;
            int b = j <= right ? arr[j] : Integer.MAX_VALUE;
            if(a < b){
                temp[index] = a;
                i++;
            }
            else{
                temp[index] = b;
                j++;
            }
            index++;
        }
        for(int k = left; k <= right; k++)
            arr[k] = temp[k - left];
    }

    public void quickSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int left = i;
        int right = j;
        int target = arr[i];
        while (left < right){
            while (left < right && arr[right] >= target)
                right--;
            while (left < right && arr[left] <= target)
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


    public void heapInsert(int[] arr, int i){
        int parentIndex = (i - 1) / 2;
        while (arr[i] > arr[parentIndex]){
            swap(arr,i,parentIndex);
            i = parentIndex;
            parentIndex = (i - 1) / 2;
        }
    }

    public void heapFy(int[] arr, int size){
        int index = 0, leftIndex = index * 2 + 1;
        while (leftIndex <= size){
            int largerIndex = leftIndex + 1 <= size && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
            largerIndex = arr[index] > arr[largerIndex] ? index : largerIndex;
            if(largerIndex == index)
                break;
            swap(arr,index,largerIndex);
            index = largerIndex;
            leftIndex = index * 2 + 1;
        }
    }
    public void heapSort(int[] arr){
        for(int i = 0; i < arr.length; i++)
            heapInsert(arr,i);
        int size = arr.length - 1;
        while (size > 0){
            swap(arr,0,size);
            size--;
            heapFy(arr,size);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] arr = {"9001 discuss.leetcode.com"};
//        System.out.println(solution.subdomainVisits(arr));
        int[] arr = {3,2,45,1,3,2,6,4,3};
        solution.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}