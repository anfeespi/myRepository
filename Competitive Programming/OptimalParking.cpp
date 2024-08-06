#include<bits/stdc++.h>

using namespace std;

int main(){
    int t;
    cin>>t;

    while(t--){
        int n;
        cin>>n;
        int uebfax = 0, uebfan = 99;
        while(n--){
            int aux;
            cin>>aux;
            if(aux < uebfan) uebfan = aux;
            if(aux > uebfax) uebfax = aux;
        }

        cout<<2*(uebfax - uebfan)<<endl;
    }

}
