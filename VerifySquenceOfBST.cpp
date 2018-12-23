/*
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/
class Solution {
public:
    bool VerifySquenceOfBST(vector<int> sequence) {
        int size = sequence.size();
        if(size == 0) return false;
        if(size == 1 || size == 2) return true;
        int root = sequence[size-1];
        int index = -1;
		//单调递增
        bool flag = true;
        for(int i = 0; i < size -1; i++){
            if(sequence[i] < sequence[i+1]) continue;
            else {
                flag = false;
                break;
            };
        }
        if(flag) return true;
        
        //单调递减
        flag = true;
        for(int i = 0; i < size -1; i++){
            if(sequence[i] > sequence[i+1]) continue;
            else{
                flag = false;
                break;
            } 
        }
        if(flag) return true;
        //找左右子树
        for(int i = 0; i < size - 1; i++){
            if(root < sequence[i]){
                index = i - 1;
                break;
            }
        }
		//判断是否属于二叉搜索树
        for(int i = index+1; i < size - 1; i++){
            if(root > sequence[i]) return false;
        }
		//分割左右子树
        vector<int> left, right;
        for(int i = 0; i <= index; i++){
            left.push_back(sequence[i]);
        }
        for(int i = index+1; i < size - 1; i++){
            right.push_back(sequence[i]);
        }
        return VerifySquenceOfBST(left) && VerifySquenceOfBST(right);
    }
};