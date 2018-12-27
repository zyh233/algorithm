/*

题目描述
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。


思路：遍历n的每一位，从个位开始，直到最高位。
对于每一位，分别计算左（left）、中(mid)、右(right)对应的数， 例如 12306  对于十位而言，
左为123，中为十位上的数0，右为6（如果是个为，右为0，最高位则左为0）

对于中位a，如果a为0，则1的个数由高位决定：			 count = left * pow(10, mid-1)
		   如果a为1, 则1的个数由高位和低位共同决定 ：count = left * pow(10, mid-1) + right + 1
		   如果a>1 , 则1的个数由高位决定：			 count = （left + 1）* pow(10, mid-1)
*/


public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n == 0) return 0;
        if(n < 10) return 1;
        String str = String.valueOf(n);
        int size = str.length();
        int left = 0;
        int pos = 1;
        int right = 0;
        int count = 0;
        int current = 0;
        while(pos <= size){
            left = n/(int)Math.pow(10,pos);
            right = n%(int)Math.pow(10,pos-1);
            current = n%(int)Math.pow(10,pos)/(int)Math.pow(10,pos-1);
            if(current == 0)
                count += left*(int)Math.pow(10,pos-1);
            else if(current == 1)
                count += (left*(int)Math.pow(10,pos-1) + right + 1);
            else
                count += (left+1)*(int)Math.pow(10,pos-1);
            pos++;
        }
        
        return count;
    }
}