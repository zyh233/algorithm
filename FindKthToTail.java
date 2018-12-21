/*
��Ŀ����
����һ����������������е�����k�����
*/

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) return null;
        ListNode first = head;
        for(int i = 1; i < k; i++){
            first = first.next;
            if(first == null) return null;
        }
        ListNode second = head;
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}