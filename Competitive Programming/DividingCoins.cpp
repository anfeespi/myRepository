#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int coins[101];
int dyna[30000];

int uebfa(int n, int total){
    for(int i = 0; i <= total; i++)
        dyna[i] = 0;

    for(int i = 1; i <= n; i++){
        for(int j = total; j > 0; j--){
            if(coins[i] <= j){
                dyna[j] = max(dyna[j], coins[i] + dyna[j - coins[i]]);
            }
        }
    }

    return dyna[total];

}


int main(){
    int n;
    cin>>n;

    while(n--){
        int m;
        cin>>m;

        int total = 0;

        for(int i = 1; i <= m; i++){
            cin>>coins[i];
            total += coins[i];
        }

        cout<<total - 2*uebfa(m, total/2)<<endl;

    }

}
