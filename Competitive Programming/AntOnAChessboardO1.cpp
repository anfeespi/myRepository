#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main(){
    int n;

    while(cin>>n && n > 0){
        int uebfa = ceil(sqrt(n));
        ll l = uebfa * 1LL * uebfa - (uebfa - 1);
        ll d = max((ll)n, l) - min((ll)n, l);

        int y = uebfa - d;

        if((uebfa&1) && n > l)
            swap(uebfa, y);

        else if(!(uebfa&1) && n < l)
            swap(uebfa, y);

        cout<<uebfa<<" "<<y<<endl;

    }
}
