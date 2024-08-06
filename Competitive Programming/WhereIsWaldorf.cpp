#include<bits/stdc++.h>

using namespace std;

int directions[][2] = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

void uebfa(string s, string mp[], int n, int m){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            for(int k = 0; k < 8; k++){
                int x = i, y = j, idx = 0;
                while(mp[x][y] == s[idx]){
                    x += directions[k][0];
                    y += directions[k][1];
                    idx++;
                    if(idx >= s.length()){
                        cout<<i+1<<" "<<j+1<<endl;
                        return;
                    }

                    if(x < 0 || y < 0 || x >= n || y >= m)
                        break;
                }
            }
        }
    }
}

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, m;
        cin>>n>>m;
        string mp[60];
        for(int i = 0; i < n; i++){
            cin>>mp[i];
            for(int j = 0; j < m; j++){
                mp[i][j] = tolower(mp[i][j]);
            }
        }

        int k;
        cin>>k;
        string s;
        while(k--){
            cin>>s;
            for(int i = 0; s[i]; i++){
                s[i] = tolower(s[i]);
            }

            uebfa(s, mp, n, m);
        }
        if(t)
            cout<<endl;
    }
}
