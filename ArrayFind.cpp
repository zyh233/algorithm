/*
��Ŀ����
��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
�����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������

����˼·
�ȴӵ�һ�е����һ������ʼ����target < array[row][col]ʱ��target�� array[row][col]����ߣ�����col-- ;
							��target > array[row][col]ʱ��target�� array[row][col]���±ߣ�����row++ ;
*/
#include <iostream>
#include <vector>
using namespace std;
vector<vector<int> > array;
bool Find(int target, vector<vector<int> > array) {
        int row = 0;
        int col = array[0].size() - 1;
        while(col < array[0].size() && col >= 0 && row >= 0 && row < array.size()){
            if(array[row][col] == target)
                return true;
            if(target > array[row][col]){
                row++;
            }else{
                col--;
            }
        }
        return false;
}
int main(){
	
	for(int i = 0; i < 5; i++){
		vector<int> vec;
		for(int j = 0; j < 5; j++){
			vec.push_back(i*j + 2);
		}
		array.push_back(vec);
	}
	cout << Find(10,array) << endl;;
	
} 
