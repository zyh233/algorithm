/**
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
/*
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();;
        if(listNode == null) return list;
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = list.size()-1; i >= 0; i--){
            result.add(list.get(i));
        }
        return result;
    }
}