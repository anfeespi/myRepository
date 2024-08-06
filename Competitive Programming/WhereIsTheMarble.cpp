#include<bits/stdc++.h>

using namespace std;

int main(){
    int n, q;

    int casen = 1;
    while(cin>>n>>q && n != 0 && q != 0){
        cout<<"CASE# "<<casen<<":"<<endl;
        int uebfa[n];
        for(int i = 0; i < n; i++){
            cin>>uebfa[i];
        }
        sort(uebfa, uebfa + n);
        int anfeespi;
        for(int i = 0; i < q; i++){
            cin>>anfeespi;
            bool flag = true;
            for(int j = 0; j < n; j++){
                if(uebfa[j] == anfeespi){
                    cout<<anfeespi<<" found at "<<(j+1)<<endl;
                    flag = false;
                    break;
                }
            }
            if(flag) cout<<anfeespi<<" not found "<<endl;
        }
        casen++;
    }
}
