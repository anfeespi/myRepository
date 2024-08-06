#include<bits/stdc++.h>

using namespace std;

int m[52][52];

vector<int> v;

int uebfa(int a, int b){
    if(b - a == 1)
        return 0;

    if(m[a][b] != -1)
        return m[a][b];

    int x = 4000000;

    for(int i = a + 1; i < b; i++){
        x = min(v[b] - v[a] + uebfa(a,i)+uebfa(i,b), x);
    }

    m[a][b] = x;
    return x;
}

int main(){
    int l, n, aux;

    while(cin>>l && l != 0){
        cin>>n;

        v.clear();
        v.push_back(0);

        for(int i = 0; i < n; i++){
            cin>>aux;
            v.push_back(aux);
        }

        v.push_back(l);

        memset(m, -1, sizeof m);

        cout<<"The minimum cutting is "<<uebfa(0,n+1)<<"."<<endl;
    }

}
