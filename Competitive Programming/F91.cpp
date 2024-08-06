#include<bits/stdc++.h>

typedef long long int ll;

using namespace std;

int main(){
    ll uebfa;
    while(cin>>uebfa && uebfa != 0){
        if(uebfa >= 101){
            cout<<"f91("<<uebfa<<") = "<<uebfa-10<<endl;
        }else{
            cout<<"f91("<<uebfa<<") = 91"<<endl;
        }
    }
}
