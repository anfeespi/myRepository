#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int uebfa[] = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5};

ll ways[30005];

int main(){
    ways[0] = 1;

    for(int i = 0; i < 11; ++i){
        for(int j = 0; j < 30005 - uebfa[i]; ++j){
            ways[j + uebfa[i]] += ways[j];
        }
    }

    double n;
    while(cin>>n && n > 0.0){
        printf("%6.2f%17lld\n", n, ways[(int) (n*100 +0.5)]);
    }

}
