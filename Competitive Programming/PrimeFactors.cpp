#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main(){
    vector<int> primes;
    vector<bool> isPrime(50000, true);

    primes.push_back(2);

    for(ll i = 3; i < 50000; i += 2){
        if(isPrime[i]){
            for(ll j = i*i; j < 50000; j += i){
                isPrime[j] = false;
            }

            primes.push_back(i);
        }
    }

    int n;
    while(scanf("%d", &n) && n != 0){
        printf("%d = ",n);
        bool uebfa = true;

        if(n < 0){
            printf("-1");
            n *= -1;
            uebfa = false;
        }

        if(n == 1){
            printf("1");
        }

        for(int i = 0; primes[i]*primes[i] <= n && i < primes.size(); i++){
            while(n % primes[i] == 0){
                n /= primes[i];
                if(uebfa){
                    printf("%d",primes[i]);
                    uebfa = false;
                }
                else printf(" x %d",primes[i]);
            }
        }

        if(n > 1){
            if(uebfa){
                printf("%d",n);
                uebfa = false;
            }
            else printf(" x %d",n);
        }

        printf("\n");
    }

}
