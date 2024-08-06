#include<bits/stdc++.h>

using namespace std;

int main(){
    string uebfa;
    while(cin>>uebfa){
        for(int i = 0; i <= uebfa.size(); i++){
            if(uebfa[i]>='A' && uebfa[i]<='C')cout<<2;
            else if(uebfa[i]>='D' && uebfa[i]<='F')cout<<3;
            else if(uebfa[i]>='G' && uebfa[i]<='I')cout<<4;
            else if(uebfa[i]>='J' && uebfa[i]<='L')cout<<5;
            else if(uebfa[i]>='M' && uebfa[i]<='O')cout<<6;
            else if(uebfa[i]>='P' && uebfa[i]<='S')cout<<7;
            else if(uebfa[i]>='T' && uebfa[i]<='V')cout<<8;
            else if(uebfa[i]>='W' && uebfa[i]<='Z')cout<<9;
            else cout<<uebfa[i];
        }
        cout<<endl;
    }
}
