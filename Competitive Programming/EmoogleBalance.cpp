#include<bits/stdc++.h>

using namespace std;

int main(){
    int n, casen = 1;

    while(cin>>n && n != 0){
        int uebfa = 0;
        int aux;
        while(n--){
            cin>>aux;
            if(aux)
                uebfa++;
            else
                uebfa--;
        }

        cout<<"Case "<<casen++<<": "<<uebfa<<endl;
    }

}
