/*
��Ŀ����
��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��

ע�����Ҫע��""," ", "array ","  ",���ַ�������ʽ�����Բ�����split����ֱ�ӷָ
����ʹ��replace()����
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