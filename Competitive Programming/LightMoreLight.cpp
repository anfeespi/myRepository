#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main(){
    ll uebfa;

    while(cin>>uebfa && uebfa != 0){
        ll anfeespi = sqrt(uebfa);
        if(anfeespi*anfeespi == uebfa){
            cout<<"yes"<<endl;
        }else{
            cout<<"no"<<endl;
        }
    }
}
