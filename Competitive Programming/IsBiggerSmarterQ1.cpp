#include<bits/stdc++.h>

using namespace std;

vector<vector<int>> dat;

int elephants[1000];
int n;

int uebfa(int u){
    int &aux = elephants[u];

    if(aux != -1)
        return aux;

    aux = 1;

    for(int i = u + 1; i < n; i++){
        if(dat[i][0] > dat[u][0] && dat[i][1] < dat[u][1])
            aux = max(aux, 1 + uebfa(i));
    }

    return aux;
}

void anfeespi(int u, int x){
    cout<<dat[u][2]<<endl;

    for(int i = u + 1; i < n; i++){
        if(elephants[i] == x){
            anfeespi(i, x - 1);
            return;
        }
    }
}

int main(){
    int c = 1;
    vector<int> t(3);

    while(cin>>t[0]>>t[1]){
        t[2] = c++;
        dat.push_back(t);
    }

    n = dat.size();

    sort(dat.begin(), dat.end());

    memset(elephants, -1, sizeof elephants);

    int total = 0;

    for(int i = 0; i < n; i++){
        total = max(total, uebfa(i));
    }

    cout<<total<<endl;

    for(int i = 0; i < n; i++){
        if(elephants[i] == total){
            anfeespi(i, total-1);
            return 0;
        }
    }
}
