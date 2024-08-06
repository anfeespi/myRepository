#include<bits/stdc++.h>

using namespace std;

int main(){
    string uebfa;
    while(cin>>uebfa){
        int a[128] = {}, b[128] = {};

        for(int i = 0; uebfa[i]; i++){
            a[uebfa[i]]++;
        }
        cin>>uebfa;

        for(int i = 0; uebfa[i]; i++){
            b[uebfa[i]]++;
        }

        for(int i = 0; i < 128; i++){
            for(int j = 0; j < a[i] && j < b[i]; j++){
                cout<<(char)i;
            }
        }
        cout<<endl;
    }
}
