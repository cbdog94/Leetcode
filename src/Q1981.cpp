#include <bitset>
#include <vector>
#include <iostream>

using namespace std;

int minimizeTheDifference(vector< vector<int> >& mat, int target) {
    bitset<5000> sum(1);
    for(vector<int>& r : mat){
        bitset<5000> tmp(0);
        for(int c : r){
            tmp=tmp|(sum<<c);
        }
        swap(sum,tmp);
    }
    int res=10000;
    for(int i=0;i<5000;i++){
        if(sum[i]){
            res=min(res,abs(target-i));
        }
    }
    return res;
}

int main ()
{
    vector< vector<int> > sample={{1,2,3},{4,5,6},{7,8,9}};
    cout<< minimizeTheDifference(sample,13)<<endl;
}


