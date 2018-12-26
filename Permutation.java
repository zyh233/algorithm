/*

题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
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
	//全排列
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
	   //去重
       Set<String> set = new HashSet<String>(list);
   	   list = new ArrayList<>(set);
	   //排序
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