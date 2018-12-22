/*

��Ŀ����
����һ��������ת��������������ı�ͷ��

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
import java.util.*;
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        Stack<ListNode> nodes = new Stack<ListNode>();
        while(head != null){
            ListNode node = new ListNode(head.val);
            nodes.push(node);
            head = head.next;
        }
        ListNode root = nodes.pop();
        head = root;
        while(!nodes.empty()){
            ListNode node = nodes.pop();
            root.next = node;
            root = root.next;
        }
        return head;
    }
}