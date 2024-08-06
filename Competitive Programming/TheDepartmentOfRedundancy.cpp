#include<bits/stdc++.h>

using namespace std;

map<int, int> uebfa;
vector<int> inorder;

int main(){
    int n;

    while(cin>>n){

        if(uebfa.count(n)){
            uebfa[n] = uebfa[n] + 1;
        }else{
            uebfa[n] = 1;
            inorder.push_back(n);
        }

    }
    for(int i : inorder){
        cout<<i<<" "<<uebfa[i]<<endl;
    }
}
