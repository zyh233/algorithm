/*��Ŀ����
����һ�ö��������������ö���������ת����һ�������˫������
Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
*/
public class Solution {
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        while(p != null && p.right != null){
            p = p.right;
        }
        if(left != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left!=null?left:pRootOfTree;
     
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.right = new TreeNode(10);
		TreeNode left = root.left;
		TreeNode right = root.right;
		left.left = new TreeNode(2);
		left.left.left = new TreeNode(1);
		left.left.right = new TreeNode(3);
		left.right = new TreeNode(6);
		left.right.left = new TreeNode(5);
		left.right.right = new TreeNode(7);
		right.left = new TreeNode(9);
		right.right = new TreeNode(11);
		
		TreeNode convert = Convert(root);
		
		while(convert != null) {
			System.out.print(convert.val + "  ");
			convert = convert.right;
		}
	}
}
