/*
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

注意事项：要注意""," ", "array ","  ",等字符串的形式，所以不能用split函数直接分割。
可以使用replace()函数
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	String text = str.toString();
        if (text.equals("")) return "";
        char[] array = text.toCharArray();
        int len = array.length;

        String s = "";
        for(int i = 0; i < len; i++){
            if(array[i] == ' '){
                s += "%20";
            }else{
                s += array[i];
            }
        }
        return s;
    }
}