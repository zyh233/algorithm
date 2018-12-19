/*
题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

解题思路
先从第一行的最后一个数开始，当target < array[row][col]时，target在 array[row][col]的左边，所以col-- ;
							当target > array[row][col]时，target在 array[row][col]的下边，所以row++ ;
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
