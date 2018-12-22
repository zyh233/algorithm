/*

题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        int start = 0;
        if(list1.val <= list2.val){
            start = list1.val;
            pointer1 = pointer1.next;
        }else{
            start = list2.val;
            pointer2 = pointer2.next;
        }
        ListNode root = new ListNode(start);
        ListNode head =root;
        while(pointer1 != null && pointer2 != null){
            if(pointer1.val <= pointer2.val){
                ListNode node = new ListNode(pointer1.val);
                root.next = node;
                root = root.next;
                pointer1 = pointer1.next;
            }else{
                ListNode node = new ListNode(pointer2.val);
                root.next = node;
                root = root.next;
                pointer2 = pointer2.next;
            }
        }
        if(pointer1 != null) root.next = pointer1;
        if(pointer2 != null) root.next = pointer2;
        return head;
    }
}