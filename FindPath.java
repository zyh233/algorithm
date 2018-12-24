/*
题目描述
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)

*/

public class Solution {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null || root.val > target) return lists;
        list.add(root.val);
        if(root.val == target && root.left == null && root.right == null){
            lists.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target-root.val);
        FindPath(root.right, target-root.val);
        list.remove(list.size()-1);
        return lists;
    }
}