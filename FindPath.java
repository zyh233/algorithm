/*
��Ŀ����
����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)

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