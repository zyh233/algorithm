/*

题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

*/
import java.util.Stack;
import java.util.Arrays;
public class Solution {

    int size = 0;
    int min = Integer.MAX_VALUE;
    int array[] = new int[10];
    Stack<Integer> minVal = new Stack<Integer>();
    void ensureCapacity(int size){
        int len = array.length;
        if(size > len) {
            int newLen = (len*3)/2+1; //每次扩容方式
            array = Arrays.copyOf(array, newLen);
        }
    }
    public void push(int node) {
        ensureCapacity(size+1);
        array[size] = node;
        size++;
        if(node <= min){
            minVal.push(node);
            min = minVal.peek();
        }else{
            minVal.push(min);
        }
    }
    
    public void pop() {
        Integer top = top();
        if(top != null){
            size--;
        }
        minVal.pop();
        min = minVal.peek();
    }
    
    public int top() {
        if(isEmpty()) {
            return (Integer)null;
        }
        return array[size-1];
    }
    boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }
    public int min() {
        return min;
    }
}