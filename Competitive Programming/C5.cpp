#include<bits/stdc++.h>

using namespace std;

int primes[1001] = {1};

int uebfa(){
    int aux = 1;
    for(int i = 2; i < 1001; i++){
        int flag = 0;
        for(int j = 2; j*j <= i; j++){
            if(i%j == 0){
                flag = 1;
                break;
            }
        }
        if(!flag){
            primes[aux++] = i;
        }
    }
    return aux;
}

int main(){
    int a = uebfa();

    int n, c;
    while(cin>>n>>c){
        cout<<n<<" "<<c<<":";

        int l[1001];
        int aux = 0;

        for(int i = 0; i < a; i++){
            if(primes[i] <= n)
                l[aux++] = primes[i];
            else
                break;
        }

        if(aux&1)
            c = c * 2 - 1;
        else
            c = c * 2;

        if(c > aux)
            c = aux;

        for(int i = aux/2 - c/2, j = 0; j < c; j++, i++)
            cout<<" "<<l[i];
        cout<<endl;
    }

}
