#include<bits/stdc++.h>

using namespace std;

int main(){
    string uebfa;

    while(getline(cin, uebfa) && uebfa != "DONE"){
        string s1, s2;

        for(int i = 0; i < uebfa.length(); i++){
            if(isalpha(uebfa[i])){
                s1 += tolower(uebfa[i]);
            }
        }

        s2 = s1;

        reverse(s1.begin(), s1.end());

        if(s1 == s2)
            cout<<"You won't be eaten!"<<endl;
        else
            cout<<"Uh oh.."<<endl;
    }
}
