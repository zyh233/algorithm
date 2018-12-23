/*
��Ŀ����
����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
����������Yes,�������No���������������������������ֶ�������ͬ��
*/
class Solution {
public:
    bool VerifySquenceOfBST(vector<int> sequence) {
        int size = sequence.size();
        if(size == 0) return false;
        if(size == 1 || size == 2) return true;
        int root = sequence[size-1];
        int index = -1;
		//��������
        bool flag = true;
        for(int i = 0; i < size -1; i++){
            if(sequence[i] < sequence[i+1]) continue;
            else {
                flag = false;
                break;
            };
        }
        if(flag) return true;
        
        //�����ݼ�
        flag = true;
        for(int i = 0; i < size -1; i++){
            if(sequence[i] > sequence[i+1]) continue;
            else{
                flag = false;
                break;
            } 
        }
        if(flag) return true;
        //����������
        for(int i = 0; i < size - 1; i++){
            if(root < sequence[i]){
                index = i - 1;
                break;
            }
        }
		//�ж��Ƿ����ڶ���������
        for(int i = index+1; i < size - 1; i++){
            if(root > sequence[i]) return false;
        }
		//�ָ���������
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