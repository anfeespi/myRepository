#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int GCD(int a, int b) {
    return b == 0 ? a : GCD(b, a % b);
}

int main(){
    int values[500];
    for(int v = 1; v < 500; v++){
        ll g = 0;
        for (int i = 1; i < v+1; i++){
            for (int j = i+1; j <= v+1; j++){
                g += GCD(i, j);
            }
        }
        values[v] = g;
    }

    ll n;
    while(cin>>n && n!=0){
        cout<<values[n-1]<<endl;
    }
}
