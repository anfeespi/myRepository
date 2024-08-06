#include<bits/stdc++.h>

using namespace std;

int main(){
    string uebfa;
    while(true){
        cin>>uebfa;
        if(uebfa[0] == '0' && uebfa.length() == 1)
            break;

        int c = 0;
        for(int i = 0; i < uebfa.length(); i++){
            int aux = c * 10 + (uebfa[i]-48);
            c = aux%11;
        }

        cout<<uebfa;
        if(c == 0)
            cout<<" is a multiple of 11.";
        else
            cout<<" is not a multiple of 11.";

        cout<<endl;
    }
}
