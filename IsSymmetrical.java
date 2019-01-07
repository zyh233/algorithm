/*
题目描述
请实现一个函数，用来判断一颗二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

解题思路
先将左子树或者右子树的左右子树翻转，再判断左右子树是否一致
(只依靠中序遍历是不够的)
*/

import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
	/*
    ArrayList<Integer> inorder = new ArrayList<Integer>();
    void inOrder(TreeNode root) {
        if(root == null){
            inorder.add(0);
            return;
        }
        inOrder(root.left);
        inorder.add(root.val);
        inOrder(root.right);
        
    }
	*/
    void exchange(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        exchange(left);
        exchange(right);
    }
    boolean isSame(TreeNode lRoot, TreeNode rRoot) {
        if(lRoot == null && rRoot == null) return true;
        if(lRoot == null && rRoot != null ||
           lRoot != null && rRoot == null)
            return false;
        if(lRoot.val == rRoot.val) {
            return isSame(lRoot.left, rRoot.left) && 
                isSame(lRoot.right, rRoot.right);
        }
        return false;
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        exchange(right);
        /*
        inOrder(pRoot);
        int len = inorder.size();
        for(int i = 0; i < len; i++) {
            if(inorder.get(i) != inorder.get(len - 1 - i))
                return false;
        }*/
        return isSame(left, right);
    }
}