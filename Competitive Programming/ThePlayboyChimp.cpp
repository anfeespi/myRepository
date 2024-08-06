#include<bits/stdc++.h>

using namespace std;

typedef long long int ll;

ll uebfa[50005];

int main(){
    int n;
    cin>>n;

    for(int i = 0; i < n; i++){
        cin>>uebfa[i];
    }

    int q;
    cin>>q;

    while(q--){
        int h;
        cin>>h;

        ll * a = (upper_bound(uebfa, uebfa + n, h));
        ll * b = a;
        b--;

        while(b >= uebfa && *b == h)
            b--;

        if(b >= uebfa)
            cout<<*b<<" ";
        else
            cout<<"X ";

        if(a == uebfa + n)
            cout<<"X"<<endl;
        else
            cout<<*a<<endl;
    }
}
