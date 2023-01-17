package 周赛.第88场双周赛.最长上传前缀;

public class LUPrefix {
    int[] arr;
    int index = 0;
    public LUPrefix(int n) {
        arr = new int[n];
    }

    public void upload(int video) {
        arr[video - 1] = 1;
    }

    public int longest() {
        for(int i = index; i < arr.length; i++){
            if(arr[i] == 0)
                break;
            index++;
        }
        return index;
    }
}
