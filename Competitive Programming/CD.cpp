#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int tracks[21];
ll n, nt, imp;
bool t[21], c[21];

void uebfa(int x){
    if(x == nt){
        ll aux = 0;
        for(int i = 0; i < nt; i++){
            if(t[i])
                aux += tracks[i];
        }

        if(aux <= n){
            if(imp < aux){
                imp = max(imp, aux);
                for(int i = 0; i < nt; i++){
                    c[i] = t[i];
                }
            }
        }
            return;
    }

        t[x] = 1;
        uebfa(x+1);
        t[x] = 0;
        uebfa(x+1);
}


int main(){
    while(cin>>n>>nt){
        for(int i = 0; i < nt; i++)
            cin>>tracks[i];
        imp = 0;

        for(int i = 0; i < nt; i++)
            c[i] = false;

        uebfa(0);

        for(int i = 0; i < nt; i++){
            if(c[i])
                cout<<tracks[i]<<" ";
        }

        cout<<"sum:"<<imp<<endl;
    }
}
