/**
����
����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
Ϊʲô������ֵ��������������Ĵ���������?
��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�
���� nums = [0,0,1,1,1,2,2,3,3,4],
����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return 1;
        
        int pos = 0;
        for(int i = 1; i < len; i++){
            if(nums[pos] != nums[i]){
                pos++;
                nums[pos] = nums[i];
            }
        }
        return (pos + 1);
    }
}


/**�������룬��ѡ��go die
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return 1;
        
        
        int pos = 0;
        int pointer = 1;
        for(int i = 0; i < len - 1; i++){
            pointer = i+1;
            while(pointer < len && nums[i] == nums[pointer]){
                pointer++;
            }
            for(int j = i+1; j < len-pointer+1+i; j++){
                nums[j] = nums[j + pointer-i -1];
            }
            if(pointer == len) break;
        }
        for(pos = 0; pos < len-1; pos++){
            if(nums[pos] >= nums[pos+1]) break;
        }
        return (pos + 1);
    }
}
*/