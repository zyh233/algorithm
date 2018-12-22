/**

��Ŀ����
����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
�����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       int top = 0, left = 0;
       int x = matrix.length, y = matrix[0].length;
       int button = matrix.length - 1;
       int right = matrix[0].length - 1;
       int count = 0;
       ArrayList<Integer> list = new ArrayList<Integer>();
       while(count < x*y){
           for(int i = left; i <= right; i++){
               list.add(matrix[top][i]);
               count++;
           }
           if (count >= x*y) break;
           top++;
           for(int i = top; i <= button; i++){
               list.add(matrix[i][right]);
               count++;
           }
           if (count >= x*y) break;
           right--;
           for(int i = right; i >= left; i--){
               list.add(matrix[button][i]);
               count++;
           }
           if (count >= x*y) break;
           button--;
           for(int i = button; i >= top; i--){
               list.add(matrix[i][left]);
               count++;
           }
           if (count >= x*y) break;
           left++;
       }
        return list;
    }
}