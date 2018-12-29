/*
leetCode 简单题

报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。


题目大意：给出一个初始字符串"1"，根据以下规则生成字符串。
如果一个字符s[i]与s[i-1]和s[i+1]不同，那么就生成"1"+s[i]的字符串；
如果连续n个字符都相同，那么就生成"n"+s[i]的字符串。
例如字符串"1"会生成"11"，而"11"会生成"21"，"21"又会生成"1211"，以此类推

*/

class Solution {
    
    public String replace(String s){
        s += "e";//防止数组越界
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