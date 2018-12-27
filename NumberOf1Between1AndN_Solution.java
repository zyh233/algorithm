/*

��Ŀ����
���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�
ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������


˼·������n��ÿһλ���Ӹ�λ��ʼ��ֱ�����λ��
����ÿһλ���ֱ������left������(mid)����(right)��Ӧ������ ���� 12306  ����ʮλ���ԣ�
��Ϊ123����Ϊʮλ�ϵ���0����Ϊ6������Ǹ�Ϊ����Ϊ0�����λ����Ϊ0��

������λa�����aΪ0����1�ĸ����ɸ�λ������			 count = left * pow(10, mid-1)
		   ���aΪ1, ��1�ĸ����ɸ�λ�͵�λ��ͬ���� ��count = left * pow(10, mid-1) + right + 1
		   ���a>1 , ��1�ĸ����ɸ�λ������			 count = ��left + 1��* pow(10, mid-1)
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