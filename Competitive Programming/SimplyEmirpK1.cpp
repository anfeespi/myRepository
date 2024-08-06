#include<bits/stdc++.h>

using namespace std;

long int revert(long int n){
    long int r = 0;
    while(n > 0){
        r = (r*10) + (n%10);
        n /= 10;
    }

    return r;
}

bool uebfa(long int n){
    int x = sqrt(n);

    for(int i = 2; i <= x; i++){
        if(n%i == 0)
            return false;
    }

    return true;
}

int main(){
    long int n, rn;
    bool p, ep;

    while(cin>>n){
        p = ep = false;
        p = uebfa(n);
        rn = revert(n);

        if(n != rn) ep = uebfa(rn);

        cout<<n;
        if(ep && p) cout<<" is emirp.";
        else if(p) cout<<" is prime.";
        else cout<<" is not prime.";
        cout<<endl;
    }
}
