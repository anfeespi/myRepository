#include<bits/stdc++.h>

using namespace std;

bool marked[1000000] = {false};
vector<int> primes;

void uebfa(){
    for(int i = 3; i < 1000000; i += 2){
        if(!marked[i]){
            primes.push_back(i);
            for(int j = 3; i*j < 1000000; j += 2)
                marked[i*j] = true;
        }
    }
}

int main(){
    uebfa();

    int n;
    while(cin>>n && n != 0){
        int x, y;
        bool flag = false;
        for(int i = 0; i < primes.size(); i++){
            x = primes[i];
            y = n - x;

            if(x > y)
                break;

            if(!marked[x] && !marked[y]){
                cout<<n<<" = "<<x<<" + "<<y<<endl;
                flag = true;
                break;
            }
        }

        if(!flag)
            cout<<"Goldbach's conjecture is wrong."<<endl;
    }
}
