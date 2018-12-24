/*
题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*/
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        RandomListNode head = pHead;
        while(head != null){
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = pHead;
        while(head != null){
            RandomListNode random = head.random;
            if(random == null) {
                head.next.random = null;
            }else{
                head.next.random = random.next;
            }
            head = head.next.next;
        }
        head = pHead;
        RandomListNode result = head.next;
        while(head != null){
            RandomListNode cloneNode = head.next;
            head.next = (cloneNode.next==null)?null:cloneNode.next;
            cloneNode.next = cloneNode.next == null?null:cloneNode.next.next;
            head = head.next;
        }
        return result;
    }
}