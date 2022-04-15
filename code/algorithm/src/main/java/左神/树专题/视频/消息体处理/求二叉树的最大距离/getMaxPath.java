package 左神.树专题.视频.消息体处理.求二叉树的最大距离;

import 左神.树专题.公共节点.力扣.TreeNode;
import 生成器.GenerateClass;

import javax.lang.model.util.Elements;

public class getMaxPath {
    public static ReturnData getMaxPathPro(TreeNode root){  //此函数表示求某棵树中有最大距离和的头节点以及他的长度 这个头节点可以不是传入的那个
        if(root == null)
            return new ReturnData(0,0);
        ReturnData leftData = getMaxPathPro(root.left);
        ReturnData rightData = getMaxPathPro(root.right);
        int path = Math.max(Math.max(leftData.maxPath,rightData.maxPath),leftData.depth + rightData.depth + 1);
        int depth = Math.max(leftData.depth , rightData.depth) + 1;
        return new ReturnData(path,depth);
    }

    public static void main(String[] args) {
        TreeNode tree = GenerateClass.generateTree("1,2,2,3,null,null,null,4,6,5,null,null,8,null,null,null,null");
        System.out.println(getMaxPathPro(tree).maxPath);
    }
}
class ReturnData{
    int maxPath; //最大距离
    int depth; //深度是啥

    public ReturnData(int maxPath, int depth) {
        this.maxPath = maxPath;
        this.depth = depth;
    }
}