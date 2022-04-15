package 左神.树专题.视频.消息体处理.求二叉树的最大活跃度;
import java.util.List;
public class MaxEnergy {
    public int getMaxEnergy(Node node){
        ReturnData data = process(node);
        return Math.max(data.come,data.notCome);
    }
    public ReturnData process(Node node){
        int come = node.val;
        int notCome = 0;
        for (int i = 0; i < node.next.size(); i++) {
            ReturnData nextData = process(node.next.get(i));
            come += nextData.notCome;
            notCome += nextData.come;
        }
        return new ReturnData(come,notCome);
    }
}
class ReturnData{
    public ReturnData(int come, int notCome) {
        this.come = come;
        this.notCome = notCome;

    }

    int come; //表示当前节点来的话 最大的活跃值
    int notCome; //表示不来。。。
}
class Node{
   int val;
   List<Node> next;
}
