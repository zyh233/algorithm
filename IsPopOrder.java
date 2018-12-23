/*

��Ŀ����
���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�

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