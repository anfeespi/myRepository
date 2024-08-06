#include<bits/stdc++.h>

using namespace std;

bool primes[65001];

void uebfa(){
    for(int i = 2; i < 65000; i++){
        if(!primes[i])
            for(int j = 2; i * j < 65000; j++)
                primes[i*j] = true;
    }
}

long long mod(long long x, long long y, long long m){
    long long aux = x, res = 1;

    while(y){
        if(y&1){
            res *= aux;
            res %= m;
        }
        aux = aux*aux;
        aux %= m;
        y >>= 1;
    }

    return res;
}

bool check(int n){
    for(int i = 2; i <= n - 1; i++){
        if(mod(i, n, n) != i)
            return false;
    }
    return true;
}

int main(){
    uebfa();
    int n;

    while(cin>>n && n != 0){
        if(primes[n] && check(n)){
            cout<<"The number "<<n<<" is a Carmichael number."<<endl;
        }else{
            cout<<n<<" is normal."<<endl;
        }
    }
}
