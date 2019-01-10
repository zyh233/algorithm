/*

题目描述
请实现两个函数，分别用来序列化和反序列化二叉树

*/

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
    int index = -1;
    String Serialize(TreeNode root) {
        String str = "";
        if(root == null){
            str += "#,";
            return str;
        }
        str += (root.val + ",");
        str += Serialize(root.left);
        str += Serialize(root.right);
        return str;
  }
    TreeNode Deserialize(String str) {
       index++;
       int len = str.length();
       if(index >= len)
           return null;
       String[] arr = str.split(",");
        TreeNode node = null;
       if(!arr[index].equals("#")) {
           node = new TreeNode(Integer.valueOf(arr[index]));
           node.left = Deserialize(str);
           node.right = Deserialize(str);
       }
        return node;
  }
}