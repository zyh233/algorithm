/*
*题目描述
*用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
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