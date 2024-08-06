#include<bits/stdc++.h>

typedef long long int ll;
using namespace std;

int main(){
    int uebfa;
    cin>>uebfa;

    while(uebfa--){
        int n, m;
        cin>>n>>m;

        if(m > n){
            cout<<"impossible"<<endl;
            continue;
        }
        ll x = (n - m)/2;
        ll y = x + m;

        if(x + y == n && abs(x - y) == m)
            cout<<y<<" "<<x<<endl;
        else
            cout<<"impossible"<<endl;

    }
}
