#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int dx[] = {1, 1, 1,-1,-1,-1,0, 0};
int dy[] = {1, 0,-1, 1, 0,-1,1,-1};

bool visitados[100][100];

void uebfa(int a, int b,vector<string> entrada, int m, int n){
    visitados[a][b] = true;
    ll x, y;

    for(int i = 0; i < 8; i++){
        x = a + dx[i];
        y = b + dy[i];

        if((x >= 0 && x < m) && (y >= 0 && y < n)){
            if(visitados[x][y] == false){
                visitados[x][y] = true;
                if(entrada[x][y] == '@') uebfa(x,y,entrada, m, n);
            }
        }
    }


}


int main(){
    int m, n;
    while(cin>>m>>n && m != 0 && n != 0){
        vector<string> entrada;
        for(int i = 0; i < m; i++){
            string s;
            cin>>s;
            entrada.push_back(s);
        }
        memset(visitados, false, (sizeof visitados));
        ll imp = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visitados[i][j] == false){
                    visitados[i][j] = true;
                    if(entrada[i][j] == '@'){
                        imp++;
                        uebfa(i,j,entrada,m,n);
                    }
                }
            }
        }
        cout<<imp<<endl;
    }
}
