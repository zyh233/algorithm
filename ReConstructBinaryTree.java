/**
 * 题目描述
 *	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *	假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *	例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
import java.util.Arrays;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}
public class ReConstructBinaryTree {
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int len1 = pre.length;
        int len2 = in.length;
        if(len1 == 0 || len2 == 0) return null;
        int i = pre[0];
        TreeNode node = new TreeNode(i);
        if(len1 == 1) {
            return node; 
        }
        int index = 0;
        for(int j = 0; j < len2; j++){
            if(i == in[j]){
                index = j;
                break;
            }
        }
        int[] lp = Arrays.copyOfRange(pre, 1, index+1);
        int[] ln = Arrays.copyOfRange(in, 0, index);
        node.left = reConstructBinaryTree(lp,ln);
        int[] rp = Arrays.copyOfRange(pre, index+1, len1);
        int[] rn = Arrays.copyOfRange(in, index+1, len2);
        node.right = reConstructBinaryTree(rp,rn);
        return node;
    }
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		TreeNode root = reConstructBinaryTree(pre, in);
		System.out.println(root.val);
	}
}
