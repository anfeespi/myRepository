#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main(){
    ll uebfa;
    while(cin>>uebfa){
        uebfa /= 2;
        uebfa++;

        uebfa *= uebfa;

        cout<<6 * uebfa - 9<<endl;
    }
}
