/*
leetCode ����

����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 ������  "one 1"  ("һ��һ") , �� 11��
11 ������ "two 1s" ("����һ"��, �� 21��
21 ������ "one 2",  "one 1" ��"һ����" ,  "һ��һ") , �� 1211��

����һ�������� n��1 �� n �� 30��������������еĵ� n �

ע�⣺����˳�򽫱�ʾΪһ���ַ�����


��Ŀ���⣺����һ����ʼ�ַ���"1"���������¹��������ַ�����
���һ���ַ�s[i]��s[i-1]��s[i+1]��ͬ����ô������"1"+s[i]���ַ�����
�������n���ַ�����ͬ����ô������"n"+s[i]���ַ�����
�����ַ���"1"������"11"����"11"������"21"��"21"�ֻ�����"1211"���Դ�����

*/

class Solution {
    
    public String replace(String s){
        s += "e";//��ֹ����Խ��
        int len = s.length()-1;
        String result = "";
        int i = 0;
        int p;
        char c;
        while(i < len) {
            c = s.charAt(i);
            p = i;
            while(c == s.charAt(++i));
            if(i - p == 1) result += ("1"+c);
            else{
                result += (i-p);
                result += c;
            }
        }
        return result;
    }
    public String countAndSay(int n) {
        
        String start = "1";
        
        if(n == 1) return start;
        
        for(int i = 2; i <= n; i++){
            start = replace(start);
        }
        return start;
    }
}