/**
简单题
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
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


/**垃圾代码，我选择go die
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