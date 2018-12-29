/**

给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:
输入: [3,2,3]
输出: 3

示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2

解法：摩尔投票法---抵消法 时间复杂度为O(n)
*/

class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        
        int count = 1;
        int val = nums[0];
        for(int i = 1; i < len; i++){
            if(val == nums[i]) count++;
            else{
                count--;
                if(count == 0){
                    val = nums[i+1];
                    count = 0;
                }
            }
        }
        return val;
    }
}
