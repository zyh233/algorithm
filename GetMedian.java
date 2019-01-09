package cn.sysu.edu.algorithm;

/*
 * 
 * ��Ŀ����
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 */
import java.util.ArrayList;

public class GetMedian {
	
	 static ArrayList<Integer> arr = new ArrayList<>();
	    public static void Insert(Integer num) {
	        int len = arr.size();
	        if(arr.size() == 0)
	            arr.add(num);
	        else{
	            if(num > arr.get(len-1)){
	                arr.add(num);
	                return;
	            }
	            for(int i = 0; i < len; i++) {
	                if(num < arr.get(i)) {
	                	arr.add(i,num);
	                	break;
	                }
	                    
	            }
	        }
	    }
	    
	    public static Double GetMedian1() {
	        int len = arr.size();
	        if(len % 2 != 0)
	            return (double)arr.get(len/2);
	        else{
	            return (double)(arr.get(len/2 - 1) + arr.get(len/2))/2.0;
	        }
	    }

	public static void main(String[] args) {
		
		int[] nums = {5,2,3,4,1,6,7,0,8};
		for (int i : nums) {
			Insert(i);
			System.out.println(GetMedian1());
		}
		

	}

}
