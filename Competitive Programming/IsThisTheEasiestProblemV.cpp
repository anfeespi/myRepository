#include<bits/stdc++.h>

typedef long long int ll;

using namespace std;

int main(){
    int uebfa, casen = 1;
    cin>>uebfa;
    while(uebfa--){
        ll a, b, c;

        cin>>a>>b>>c;

        cout<<"Case "<<casen++<<": ";

        if(a + b <= c || b + c <= a || c + a <= b)
            cout<<"Invalid";

        else if(a == b && b == c)
            cout<<"Equilateral";

        else if(a == b || b == c || c == a)
            cout<<"Isosceles";

        else
            cout<<"Scalene";

        cout<<endl;


    }
}
