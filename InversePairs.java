package svd;
/*
 * 
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 
 * 即输出P%1000000007
 * 
 */
public class InversePairs {

	public static int merge(int[] arr, int start, int mid, int end){
        if(end - start == 1){
            if(arr[start] > arr[end]){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                return 1;
            }
            return 0;
        }
        
        int[] copyArr = new int[end - start + 1];
        int p1 = mid, p2 = end;
        int pos = end - start;
        int count = 0;
        while(p1 >= start && p2 > mid) {
            if(arr[p1] > arr[p2]){
                count += (p2 - mid);
                copyArr[pos] = arr[p1];
                p1--;
                pos--;
                if(count > 1000000007) //不能删除，删除后超时
                	count %= 1000000007;
            }else{
                copyArr[pos] = arr[p2];
                p2--;
                pos--;
            }
        }
        while(p1 >= start) copyArr[pos--] = arr[p1--];
        while(p2 > mid) copyArr[pos--] = arr[p2--];
        for(int i = 0; i <= end-start; i++){
            arr[start + i] = copyArr[i];
        }
        return count;
    }
	
	public static int sortMerge(int[] arr, int start, int end){
        if(start == end) return 0;
        int mid = (start + end)/2;
        int left = sortMerge(arr, start, mid);
        int right = sortMerge(arr, mid + 1, end);
        return (left + right + merge(arr, start, mid, end))%1000000007;
    }
	
	public static int InversePairs1(int [] array) {
        int len = array.length;
        if(len <= 1) return 0;
        int start = 0, end = len-1;
        return sortMerge(array, start, end);
    }
	public static void main(String[] args) {
		int[] arr = new int[] {364,637,341,406,747,995,234,971,571,
				219,993,407,416,366,315,301,601,650,418,355,460,505,
				360,965,516,648,727,667,465,849,455,181,486,149,588,233,
				144,174,557,67,746,550,474,162,268,142,463,221,882,576,
				604,739,288,569,256,936,275,401,497,82,935,983,583,523,
				697,478,147,795,380,973,958,115,773,870,259,655,446,863,
				735,784,3,671,433,630,425,930,64,266,235,187,284,665,
				874,80,45,848,38,811,267,575};
		int count = InversePairs1(arr);
		System.out.println(count);
	}

}
