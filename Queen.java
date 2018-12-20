/*
*��Ŀ����
*������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint����
*/
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        //if(stack1.size() == 0) return null;
        while(!stack1.empty()){
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int result = stack2.pop();
        while(!stack2.empty()){
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return result;
    }
}