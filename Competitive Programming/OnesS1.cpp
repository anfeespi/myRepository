#include<bits/stdc++.h>

using namespace std;

int main(){
    int n, uebfa, c;

    while(cin>>n){
        int uebfa = 0, c = 0;
        do{
            c = (c * 10 + 1)%n;
            uebfa++;
        }while(c != 0);

        cout<<uebfa<<endl;
    }
}
