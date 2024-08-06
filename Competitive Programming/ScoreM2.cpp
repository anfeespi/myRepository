#include<bits/stdc++.h>

using namespace std;

int main(){
    int t;
    cin>>t;

    while(t--){
        string uebfa;
        cin>>uebfa;

        int c = 0, prev = 0;

        for(int i = 0; i < uebfa.length(); i++){
            if(uebfa[i] == 'O'){
                prev++;
                c += prev;
            }else{
                prev = 0;
            }
        }

        cout<<c<<endl;
    }
}
