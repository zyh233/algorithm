package cn.sysu.edu.algorithm;

/*
 * 
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
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
