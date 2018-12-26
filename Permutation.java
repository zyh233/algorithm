/*

��Ŀ����
����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��

����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
public class Solution {
    ArrayList<String> list = new ArrayList<String>();
    void swap(char[] arr, int i, int k) {
        char temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
	//ȫ����
    void prime(char[] arr, int k, int m){
        if(k == m) list.add(new String(arr));
        else{
            for(int i = k; i <= m; i++){
                swap(arr, i, k);
                prime(arr, k+1, m);
                swap(arr, i, k);
            }
        }
    }
    public ArrayList<String> Permutation(String str) {
       char[] arr = str.toCharArray();
       int m = arr.length - 1;
       if(m == -1) return list;
       if(m == 0) {
    	   list.add(str);
    	   return list;
       }
       prime(arr, 0, m);
	   //ȥ��
       Set<String> set = new HashSet<String>(list);
   	   list = new ArrayList<>(set);
	   //����
       Collections.sort(list, new Comparator< String >() {
    	   @Override
    	   public int compare(String lhs, String rhs) {
    	       int i = lhs.compareTo(rhs);
    	       if ( i > 0 ) {
    	           return 1;
    	       } else {
    	           return -1;
    	       }
    	  }
    	});
       return list;
    }
}