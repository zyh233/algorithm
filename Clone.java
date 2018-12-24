/*
��Ŀ����
����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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