/*

��Ŀ����
С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
�������:

������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��


*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       
       ArrayList<ArrayList<Integer> > sumList = new ArrayList<ArrayList<Integer> >();
       if(sum <= 2) return sumList;
       ArrayList list = null;
       int len = (int)Math.sqrt(2*sum);
       for(int i = len; i >= 2; i--) {
           if((i & 1) == 1 && sum%i == 0) {
               list = new ArrayList<Integer>();
               int mid = sum/i;
               for(int j = mid - i/2; j <= mid + i/2; j++){
                   list.add(j);
               }
               sumList.add(list);
           }
           if((i & 1) == 0 && (sum % i) * 2 == i) {
               list = new ArrayList<Integer>();
               int mid = sum / i;
               for(int j = mid - i/2 + 1; j <= mid + i/2; j++) {
                   list.add(j);
               }
               sumList.add(list);
           }
       }
       return sumList;
    }
}