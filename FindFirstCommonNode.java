/*

题目描述
输入两个链表，找出它们的第一个公共结点。

*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int count1 = 0, count2 = 0;
        while(p1 != null){
            count1++;
            p1 = p1.next;
        }
        while(p2 != null){
            count2++;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        int dis;
        if(count1 >= count2){
            dis = count1 - count2;
            while(dis-- > 0)
                p1 = p1.next;
        } else {
            dis = count2 - count1;
            while(dis-- > 0)
                p2 = p2.next;
        }
        while(p1 != null && p2 != null) {
            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}