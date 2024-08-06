#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main(){
    ll uebfa[51];

    uebfa[1] = 1;
    uebfa[2] = 2;

    for(int i = 3; i <= 50; i++)
        uebfa[i] = uebfa[i - 1] + uebfa[i - 2];

    int n;
    while(cin>>n && n != 0)
        cout<<uebfa[n]<<endl;
}
