#include<bits/stdc++.h>

using namespace std;

bool marked[50] = {false};
vector<int> primes;
int pr[20] = {1};

void sieve(){
    for(int i = 3; i < 50; i += 2){
        if(!marked[i]){
            primes.push_back(i);
            for(int j = 3; i*j < 50; j += 2)
                marked[i*j] = true;
        }
    }
}

bool isPresent(int n){
    for(int p : primes){
        if(n == p)
            return true;
    }

    return false;
}

void uebfa(int x, bool visited[], int n){
    if(n == x){
        if(!isPresent(pr[n-1] + 1))
            return;

        cout<<"1";
        for(int i = 1; i < n; i++){
            cout<<" "<<pr[i];
        }
        cout<<endl;
        return;
    }

    for(int i = 2; i <= n; i++){
        if(visited[i])
            continue;

        if(isPresent(i + pr[x - 1])){
            visited[i] = true;
            pr[x] = i;

            uebfa(x + 1, visited, n);

            visited[i] = false;
        }
    }
}

int main(){
    sieve();
    int n;
    int casen = 1;
    while(cin>>n){
        cout<<"Case "<<casen++<<":"<<endl;
        bool visited[20] = {false};
        if(n == 1){
            cout<<"1"<<endl;
        }else
            uebfa(1, visited, n);
        cout<<endl;
    }
}
