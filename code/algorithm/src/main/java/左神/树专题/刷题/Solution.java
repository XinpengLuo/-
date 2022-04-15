package 左神.树专题.刷题;

import 左神.树专题.公共节点.力扣.TreeNode;

import javax.print.attribute.standard.NumberUp;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

import static 生成器.GenerateClass.generateTree;

public class Solution {
    //是否是镜像二叉树
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return true;
        ArrayList<Integer> list = new ArrayList<>();
        addNode(root,list);
        for (Integer integer : list) {
            if(integer != list.get(0))
                return false;
        }
        return true;
    }

    //最大二叉树
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
       return constructProcess(nums,0,nums.length - 1);
    }
    public static TreeNode constructProcess(int[] nums,int start, int end){
        int maxIndex = findMaxIndex(nums,start,end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maxIndex == start ? null : constructProcess(nums,start,maxIndex - 1);
        root.right = maxIndex == end ? null : constructProcess(nums,maxIndex + 1,end);
        return root;
    }
    public static int findMaxIndex(int[] nums, int start, int end){
        int maxIndex = start;
        while (start <= end){
            if(nums[start] > nums[maxIndex])
                maxIndex = start;
            start++;
        }
        return maxIndex;
    }

    //二叉搜索树的范围和
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        if(root.val < low)
            return rangeSumBST(root.right,low,high);
        if(root.val > high)
            return rangeSumBST(root.left,low,high);
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right, low, high);
    }
    public void addNode(TreeNode root, ArrayList<Integer> list){
        if(root != null){
            list.add(root.val);
            addNode(root.left,list);
            addNode(root.right,list);
        }
    }


    //二叉树的坡度
    public int findSum(TreeNode root){
        if(root == null)
            return 0;
        return root.val + findSum(root.left) + findSum(root.right);
    }
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        return Math.abs(findSum(root.left) - findSum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    //二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }

    //二叉搜索树节点最小距离
    Integer prev, ans;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (prev != null)
            ans = Math.min(ans, node.val - prev);
        prev = node.val;
        dfs(node.right);
    }

    //递增顺序查找树
    TreeNode tempPre;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode temp = getMaxLeft(root);
        increasingBSTPro(root);
        return temp;
    }
    public TreeNode increasingBSTPro(TreeNode root) {
        if(root == null)
            return null;
        increasingBSTPro(root.left);
        root.left = null;
        if(tempPre != null)
        {
            tempPre.right = root;
        }
        tempPre = root;
        increasingBSTPro(root.right);
        return root;
    }
    public TreeNode getMaxLeft(TreeNode root){
        while (root.left != null)
            root = root.left;
        return root;
    }



    //二叉搜索树的第k大节点
    int index = 0 , result;
    public int kthLargest(TreeNode root, int k) {
        kthLargestInOrder(root,k);
        return result;
    }
    public void kthLargestInOrder(TreeNode root, int k){
        if(root == null)
            return;
        kthLargestInOrder(root.right,k);
        index++;
        if(k == index)
        {
            result = root.val;
            return;
        }
        kthLargestInOrder(root.left,k);
    }

    //路径总和
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        return hasPathSumPro(root,targetSum);
    }
    public boolean hasPathSumPro(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null)
            return targetSum == 0;
        return (hasPathSumPro(root.left,targetSum) || hasPathSumPro(root.right,targetSum));
    }
    //路径总和2
    public List<List<Integer>> pathSumTwo(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumTwoPro(root,targetSum,result,path);
        return result;
    }
    public void pathSumTwoPro(TreeNode root, int targetSum, List<List<Integer>> result,List<Integer> path){
        if(root == null)
            return;
        targetSum -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0)
                result.add(new ArrayList<>(path));
        pathSumTwoPro(root.left,targetSum,result,path);
        pathSumTwoPro(root.right,targetSum,result,path);
        path.remove(path.size() - 1);
    }

    //路径总和3
    int pathSumCount = 0;
    public int pathSumThree(TreeNode root, int sum) {
        if(root == null)
            return 0;
        pathSumThreePro(root,sum);
        pathSumThree(root.left,sum);
        pathSumThree(root.right,sum);
        return pathSumCount;
    }
    public void pathSumThreePro(TreeNode root, int sum){
        if(root == null)
            return;
        sum -= root.val;
        if(sum == 0)
            pathSumCount++;
        pathSumThreePro(root.left,sum);
        pathSumThreePro(root.right,sum);
    }


    //判断二叉搜索树
    TreeNode preBst;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return false;
        return isValidBSTPro(root);
    }
    public boolean isValidBSTPro(TreeNode root) {
        if(root.left != null && !isValidBSTPro(root.left))
            return false;
        if(preBst != null && preBst.val > root.val)
            return false;
        preBst = root;
        if(root.right != null && !isValidBSTPro(root.right))
            return false;
        return true;
    }

    //求和路径 返回所有组合的数量
    public int pathSum(TreeNode root, int sum) {
        return pathSumPro(root,sum,0);
    }
    public int pathSumPro(TreeNode root, int sum, int count){
        if(root.left != null)
            count += pathSumPro(root.left,sum,0);
        count += pathSum(root,sum,0,0);
        if(root.right != null)
            count += pathSumPro(root.right,sum,0);
        return count;
    }
    public int pathSum(TreeNode root, int sum, int tempSum, int count){
        if(root == null)
            return count;
        tempSum = root.val + tempSum;
        if(tempSum == sum)
            count = count + 1;
        int temp = count;
        count = pathSum(root.left,sum,tempSum,count) + pathSum(root.right,sum,tempSum,count) - temp;
        return count;
    }

    //树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null)
            return false;
        if(isSubStructurePro(A,B))
            return true;
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public boolean isSubStructurePro(TreeNode A, TreeNode B) {
        if((A == null) && (B == null) || (A != null && B == null))
            return true;
        if((A == null && B != null) ||  A.val != B.val)
            return false;
        if(isSubStructurePro(A.left,B.left) && isSubStructurePro(A.right,B.right))
            return true;
        return false;
    }
    //镜像二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

    //把二叉搜索树转换为累加树
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        if(root != null){
            bstToGst(root.right);
            sum = sum + root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
    //二叉树层次 遍历转数组
    public ListNode[] listOfDepth(TreeNode tree) {
        ListNode[] nodes = new ListNode[maxDepth(tree)];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int index = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            while (size != 0){
                TreeNode cur = queue.poll();
                ListNode node = new ListNode(cur.val);
                temp.next = node;
                temp = temp.next;
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
                size--;
            }
            nodes[index] = head.next;
            index++;
        }
        return nodes;
    }

    //从上到下打印二叉树 II
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- != 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(list);
        }
        return result;
    }

    //二叉树的右视图 为每一层的最后一个元素
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
                if(i == size - 1)
                    result.add(temp.val);
            }
        }
        return result;
    }
    // 二叉树展开为链表
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root,list);
        for (int i = 0; i < list.size(); i++) {
            TreeNode temp = list.get(i);
            temp.left = null;
            temp.right = i + 1 < list.size() ? list.get(i + 1) : null;
        }
    }
    public void preOrder(TreeNode root, List<TreeNode> list){
        if(root == null)
            return;
        list.add(root);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
    //之字型打印二叉树
    public List<List<Integer>> levelOrderThree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            while (size-- > 0){
                TreeNode temp = queue.poll();
                if(flag)
                    cur.add(stack.pop().val);
                else
                    stack.push(temp);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            while (!flag && !stack.isEmpty()){
                cur.add(stack.pop().val);
            }
            flag = !flag;
            result.add(cur);
        }
        return result;
    }
    //二叉树中和为某一值的路径
    public List<List<Integer>> pathSumJ(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumRecur(root,sum,path,result);
        return result;
    }
    public void pathSumRecur(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
        if(root == null)
            return;
        path.add(root.val);
        if(root.left == null && root.right == null && sum == root.val)
            result.add(new ArrayList<>(path));
        pathSumRecur(root.left, sum - root.val, path, result);
        pathSumRecur(root.right, sum - root.val, path, result);
        path.remove(path.size() - 1);
    }
    //左叶子之和
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeavesPro(root);
        return sumPro;
    }
    int sumPro = 0;
    public void sumOfLeftLeavesPro(TreeNode root) {
        if(root == null)
            return;
        sumOfLeftLeavesPro(root.left);
        if(root.left != null && root.left.left == null && root.left.right == null)
            sumPro += root.left.val;
        sumOfLeftLeavesPro(root.right);
    }
    //最大二叉树2
    public TreeNode insertIntoMaxTree(TreeNode root, int val){
        TreeNode treeNode = new TreeNode(val);
        if(root == null)
            return treeNode;
        if(root.val < val){
            treeNode.left = root;
            return treeNode;
        }
        else
            root.right = insertIntoMaxTree(root.right,val);
        return root;
    }
    //奇偶树
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //真代表层数为偶数 数字要为奇数
        boolean flag = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            int preMin = Integer.MIN_VALUE;
            int preMax = Integer.MAX_VALUE;
            while (size-- > 0){
                TreeNode temp = queue.poll();
                if(flag){
                    if(temp.val % 2 == 0 || temp.val < preMin)
                        return false;
                    preMin = temp.val;
                }else{
                    if(temp.val % 2 != 0 || temp.val > preMax)
                        return false;
                    preMax = temp.val;
                }
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            flag = !flag;
        }
        return true;
    }
    //n叉树的层次遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0)
                {
                    Node temp = queue.poll();
                    list.add(temp.val);
                    for (int i = 0; i < temp.children.size(); i++) {
                        if(temp.children.get(i) != null)
                            queue.add(temp.children.get(i));
                    }
                }
            result.add(list);
        }
        return result;
    }

    //寻找重复的子树
    List<TreeNode> subTreeResult;
    HashMap<String,Integer> subTreeMap;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subTreeResult = new ArrayList<>();
        subTreeMap = new HashMap<>();
        findDuplicateSubtreesPro(root);
        return subTreeResult;
    }
    public String findDuplicateSubtreesPro(TreeNode root){
        if(root == null)
            return "#_";
        String result = root.val + "_" + findDuplicateSubtreesPro(root.left) + findDuplicateSubtreesPro(root.right);
        subTreeMap.put(result,subTreeMap.getOrDefault(result,0) + 1);
        if(subTreeMap.get(result) == 2)
            subTreeResult.add(root);
        return result;
    }

    //求根到叶子节点数字之和
    int sumAllPath = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root,0);
        return sumAllPath;
    }
    public void sumNumbers(TreeNode root,int tempSum) {
        if(root == null)
            return;
        tempSum = tempSum * 10 + root.val;
        if(root.left == null && root.right == null)
            sumAllPath += tempSum;
        sumNumbers(root.left,tempSum);
        sumNumbers(root.right,tempSum);
    }

    //出现次数最多的子树元素和
    HashMap<Integer,Integer> countTimeMap; //key代表子树的和 value代表出现的次数
    int maxTime = 0; //这个max代表 出现次数最多的子树和 和可以不一样 但是次数可能一样
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];
        countTimeMap = new HashMap<>();
        findFrequentTreeSumPro(root);
        List<Integer> list = new ArrayList<>();
        for (Integer integer : countTimeMap.keySet()) {
            if(countTimeMap.get(integer) == maxTime)
                list.add(integer);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    public int findFrequentTreeSumPro(TreeNode root){
        if(root == null)
            return 0;
        int result = root.val + findFrequentTreeSumPro(root.left) + findFrequentTreeSumPro(root.right);
        countTimeMap.put(result,countTimeMap.getOrDefault(result,0) + 1);
        maxTime = Math.max(maxTime,countTimeMap.get(result));
        return result;
    }

    //在每个树行中找最大值
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0){
                TreeNode temp = queue.poll();
                max = Math.max(temp.val,max);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(max);
        }
        return result;
    }

    //二叉树的锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        //true代表正序
        boolean flag = true;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            if(!flag)
                Collections.reverse(list);
            result.add(list);
            flag = !flag;
        }
        return result;
    }

    //根据二叉树创建字符串
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        return tree2strHelp(t);
    }
    public String tree2strHelp(TreeNode t){
        String result = t.val + "(";
        if(t.left == null && t.right != null)
            result = result + ")(" + tree2strHelp(t.right);
        else if(t.left != null && t.right == null)
            result = result + tree2strHelp(t.left);
        else if(t.left != null && t.right != null)
        {
            result += tree2strHelp(t.left);
            result += ")" + "(";
            result += tree2strHelp(t.right);
        }
        result += ")";
        if(t.left == null && t.right == null)
            result = result.substring(0,result.length() - 2);
        return result;
    }

    //从根到叶的二进制数之和
    int sumOfLeaves = 0;
    public int sumRootToLeaf(TreeNode root) {
       sumRootToLeaf(root,0);
       return sumOfLeaves;
    }
    public void sumRootToLeaf(TreeNode root, int sum) {
        if(root == null)
            return;
        sum = sum << 1;
        sum += root.val;
        if(root.left == null && root.right == null)
            sumOfLeaves += sum;
        sumRootToLeaf(root.left,sum);
        sumRootToLeaf(root.right,sum);
    }

    //二叉树中的伪回文路径
    int countPath = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] countArr = new int[9];

        pseudoPalindromicPaths(root,countArr);
        return countPath;
    }
    public void pseudoPalindromicPaths (TreeNode root, int[] countArr) {
        if(root == null)
            return;
        countArr[root.val - 1]++;
        if(root.left == null && root.right == null){
            if (isPa(countArr))
                countPath++;
            countArr[root.val - 1]--;
            return;
        }
        pseudoPalindromicPaths(root.left,countArr);
        pseudoPalindromicPaths(root.right,countArr);
        countArr[root.val - 1]--;
    }
    public boolean isPa(int[] arr){
        int countOs = 0;
        for (int i : arr) {
            if(i % 2 != 0)
                countOs++;
        }
        if(countOs == 0 || countOs == 1)
            return true;
        return false;
    }

    //找树左下角的值
    int maxLevel = Integer.MIN_VALUE;
    int leftValue;
    public int findBottomLeftValue(TreeNode root) {
        findLeftValueHelp(root,0);
        return leftValue;
    }
    public void findLeftValueHelp(TreeNode root, int level){
        if(root == null)
            return;
        level = level + 1;
        if(root.left == null && root.right == null){
            if(level > maxLevel){
                maxLevel = level;
                leftValue = root.val;
            }
        }
        findLeftValueHelp(root.left,level);
        findLeftValueHelp(root.right,level);
    }


    // 删除给定值的叶子节点
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        if(root.left == null && root.right == null && root.val == target)
            return null;
        return root;
    }

    //107. 二叉树的层序遍历 II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
    //最大层内元素和
    public int maxLevelSum(TreeNode root) {
        int maxValue = Integer.MIN_VALUE;
        int level = 0;
        int maxLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            int tempSum = 0;
            while (size-- > 0){
                TreeNode temp = queue.poll();
                tempSum += temp.val;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            if(tempSum > maxValue){
                maxValue = tempSum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }

    //检查平衡性
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1);
    }

    //二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePathsHelp(root,"",result);
        return result;
    }
    public void binaryTreePathsHelp(TreeNode root,String temp,List<String> result){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            temp = temp + root.val;
            result.add(temp);
            return;
        }
        temp = temp + root.val + "->";
        binaryTreePathsHelp(root.left,temp,result);
        binaryTreePathsHelp(root.right,temp,result);
    }
    // 二叉搜索树中的插入操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);

        if(root == null)
            return temp;

        if(root.val < val){
            temp.right = root.right;
            root.right = temp;
            insertIntoBST(root.right,val);
        }
        else {
            temp.left = root.left;
            root.left = temp;
            insertIntoBST(root.left,val);
        }
        return root;
    }

    //层数最深叶子节点的和
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            while (size-- > 0){
                TreeNode temp = queue.poll();
                sum += temp.val;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            if(queue.size() == 0)
                break;
        }
        return sum;
    }
    public static boolean isValidBSTMorris(TreeNode root) {
        if(root == null)
            return true;
        TreeNode cur = root;
        TreeNode mostRight = null;
        Long preVal = Long.MIN_VALUE;//long的最小值和 int的最小值是不一样的
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else
                    mostRight.right = null;
            }
            if(cur.val <= preVal)
                return false;
            preVal = Long.valueOf(cur.val);
            cur = cur.right;
        }
        return true;
    }
    //不同的二叉搜索树
    HashMap<Integer,Integer> treeMap = new HashMap<>(); //key是 n value 是有多少种
    public int numTrees(int n) {
        if(n <= 2)
            return n;
        if(treeMap.containsKey(n))
            return treeMap.get(n);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int left = 0;
            int right = 0;
            if(treeMap.containsKey(i - 1))
                left = treeMap.get(i - 1);
            else
                {
                    left = numTrees(i - 1) == 0 ? 1 : numTrees(i - 1);
                    treeMap.put(i - 1,left);
                }
            if(treeMap.containsKey(n - i))
                right = treeMap.get(n - i);
            else{
                right = numTrees(n - i) == 0 ? 1 : numTrees(n - i);
                treeMap.put(n - i,right);
            }
            count = count + left * right;
        }
        treeMap.put(n,count);
        return count;
    }
    //两棵二叉搜索树中的所有元素
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        getAllEleHelp(root1,list);
        getAllEleHelp(root2,list);
        Collections.sort(list);
        return list;
    }

    public void getAllEleHelp(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        getAllEleHelp(root.left,list);
        getAllEleHelp(root.right,list);
    }


    //二叉树中所有距离为 K 的结点
    List<Integer> distanceRes = new ArrayList<>();
    HashMap<TreeNode,TreeNode> map = new HashMap<>(); //key son value father
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        addParents(root,null);
        countDistance(target,K,target);
        return distanceRes;
    }
    public void addParents(TreeNode son, TreeNode father){
        if(son == null)
            return;
        map.put(son,father);
        addParents(son.left,son);
        addParents(son.right,son);
    }
    public void countDistance(TreeNode target, int K, TreeNode root){
        if(target == null)
            return;
        if(K == 0){
            distanceRes.add(root.val);
            return;
        }
        if(root.left != target)
            countDistance(root, K - 1,root.left);
        if(root.right != target)
            countDistance(root, K - 1,root.right);
        if(map.get(root) != target)
            countDistance(root, K - 1,map.get(root));
    }


    //二叉树的最小深度
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        minDepthHelp(root,1);
        return minDepth;
    }
    public void minDepthHelp(TreeNode root, int count){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth,count);
        }
        minDepthHelp(root.left,count + 1);
        minDepthHelp(root.right,count + 1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(10));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
