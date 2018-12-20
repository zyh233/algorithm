#include <iostream>
#include<math.h>
#include <bitset>
using namespace std; 
int  NumberOf1(int n) {
	if(n == -1) return 32;
         if(n >= 0) {
             bitset<32> b(n);
             return b.count();
         }
         if(n < 0) {
             bitset<32> b(-n);
             int index = 0;
             int count = 0;
             for(int i = 0; i < 32; i++){
                 if(b[i] == 1) index = i;
                 b[i] = 1 - b[i];
             }
             cout << b.to_string() << endl;
             for(int i = 0; i < 32; i++){
                 if(b[i] == 1) count += pow(2,i-1);
             }
             count++;
             bitset<32> b2(count);
             cout << b2.to_string() << endl;
             return b2.count();
         }
}
int main(){
	cout << NumberOf1(-2);
}
