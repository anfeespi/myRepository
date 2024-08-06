#include<bits/stdc++.h>

using namespace std;

int main(){
    string s1, s2;

    while(cin>>s1>>s2){
        reverse(s1.begin(), s1.end());
        reverse(s2.begin(), s2.end());

        int uebfa[600];

        memset(uebfa, 0, sizeof uebfa);

        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                uebfa[i + j] += (s1[i]-'0') * (s2[j] - '0');
            }
        }

        for(int i = 0; i < 600 - 1; i++){
            uebfa[i + 1] += uebfa[i] / 10;
            uebfa[i] %= 10;
        }

        int i = 600 - 1;

        while(i > 0 && uebfa[i] == 0)
            i--;

        for(; i >= 0; i--)
            cout<<uebfa[i];

        cout<<endl;
    }
}
