#include<bits/stdc++.h>

using namespace std;

bool uebfa(int n){
    int aux = sqrt(double(n));

    for(int i = 3; i < aux + 1; i += 2)
        if(n % i == 0)
            return false;

    return true;
}

int main(){
    vector<int> primes;

    int n;

    primes.push_back(2);

    for(int i = 3; i < 1<<15; i += 2)
        if(uebfa(i))
            primes.push_back(i);

    while(cin>>n && n != 0){
        int x = 0;
        int c = 0;

        while(primes[x] <= n/2){
            vector<int>::iterator i = find(primes.begin(), primes.end(), n - primes[x]);
            if(i != primes.end())
                c++;
            x++;
        }

        cout<<c<<endl;
    }
}
