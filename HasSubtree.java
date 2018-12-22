/**

��Ŀ����
�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��

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
    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root2 == null) return true;//���ɻ���
        if(root1 == null) return false;//���ɻ���
        if (root1.val == root2.val){
            return (isSubTree(root1.left, root2.left)
                    && isSubTree(root1.right, root2.right));
        }else return false;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return (isSubTree(root1, root2) || 
                HasSubtree(root1.left, root2) || 
                HasSubtree(root1.right, root2));
    }
}