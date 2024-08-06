#include<bits/stdc++.h>

using namespace std;

bool primes[2000];

void uebfa(){
    for(int i = 2; i < 2000; i++){
        if(!primes[i])
            for(int j = 2; i*j < 2000; j++)
                primes[i*j] = true;
    }
}

int main(){
    uebfa();

    string s;

    while(cin>>s){
        int sum = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] >= 'a' && s[i] <= 'z')
                sum += s[i]-'a'+1;
            else
                sum += s[i]-'A'+27;
        }

        if(primes[sum] == 0)
            cout<<"It is a prime word."<<endl;
        else
            cout<<"It is not a prime word."<<endl;
    }
}
