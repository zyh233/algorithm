/*

题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

*/
import java.util.*;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      int len1 = pushA.length;
      int len2 = popA.length;
      if(len1 != len2) return false;
      int[] arr1 = Arrays.copyOf(pushA, len1);
      int[] arr2 = Arrays.copyOf(popA, len2);
      Arrays.sort(arr1);
      Arrays.sort(arr2);
      for(int i = 0; i < len1; i++){
          if(arr1[i] != arr2[i]) return false;
      }
      Stack<Integer> temp = new Stack<Integer>();
      for(int i = 0, j = 0; i < len1; i++){
          temp.push(pushA[i]);
          while(!temp.empty() && temp.peek() == popA[j]){
              temp.pop();
              j++;
          }
      }
      return temp.empty();
      
    }
}