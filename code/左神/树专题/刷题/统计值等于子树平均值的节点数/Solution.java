package 左神.树专题.刷题.统计值等于子树平均值的节点数;

import 左神.树专题.公共节点.力扣.TreeNode;

class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }
    public Result dfs(TreeNode root){
        if(root == null)
            return new Result(0,0);
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        Result result = new Result(left.count + right.count + 1,left.sum + right.sum + root.val);
        if(result.sum / result.count == root.val)
            count++;
        return result;
    }
}
class Result{
    int count;
    int sum;
    public Result(int count, int sum){
        this.count = count;
        this.sum = sum;
    }
}