#include<bits/stdc++.h>

using namespace std;

int main(){
    string s;
    while(cin>>s && s != "0"){
        int n = s.length() + 1;

        int uebfa = 0;
        int pos = 0;
        while(n--){
            uebfa += (s[pos] - '0') * (pow(2, n) - 1);

            pos++;
        }

        cout<<uebfa<<endl;
    }

}
