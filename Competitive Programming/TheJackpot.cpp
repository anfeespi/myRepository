#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main(){
    ll n, uebfa[100000];

    while(cin>>n && n != 0){
        int mx = 0, aux = 0;
        for(int i = 0; i < n; i++){
            cin>>uebfa[i];
            aux += uebfa[i];
            if(aux > mx) mx = aux;
            if(aux < 0) aux = 0;
        }

        if(mx > 0){
            cout<<"The maximum winning streak is "<<mx<<"."<<endl;
        }else{
            cout<<"Losing streak."<<endl;
        }

    }
}
