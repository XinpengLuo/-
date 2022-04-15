package 左神.树专题.视频.树的判断.平衡二叉树;

import 左神.树专题.公共节点.Node;

public class AverageTree {
    public ReturnData isAverageTree(Node head){
        if(head == null)
            return new ReturnData(true, 0);
        ReturnData leftResult = isAverageTree(head.getLeft());
        if(!leftResult.isBalance)
            return new ReturnData(false,0);
        ReturnData rightResult = isAverageTree(head.getRight());
        if(!rightResult.isBalance)
            return new ReturnData(false,0);
        if(Math.abs(rightResult.height - leftResult.height) > 1)
            return new ReturnData(false, 0);
        return new ReturnData(true,Math.max(rightResult.height,leftResult.height) + 1);
    }
}
class ReturnData{
    boolean isBalance;
    int height;
    public ReturnData(boolean isB, int height){
        this.isBalance = isB;
        this.height = height;
    }
}

