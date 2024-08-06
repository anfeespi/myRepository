#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int uebfa[] = {50, 25, 10, 5, 1};

ll ways[30001];

int main(){
    ways[0] = 1;

    for(int i = 0; i < 5; ++i){
        for(int j = 0; j < 30001 - uebfa[i]; ++j){
            ways[j + uebfa[i]] += ways[j];
        }
    }

    int n;
    while(cin>>n && n > 0.0){
        if(ways[n] == 1){
            printf("There is only 1 way to produce %d cents change.\n", n);
        }else{
            printf("There are %lld ways to produce %d cents change.\n", ways[n], n);
        }
    }

}
