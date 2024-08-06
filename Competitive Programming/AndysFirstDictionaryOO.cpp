#include<bits/stdc++.h>

using namespace std;

int main(){
    string s;
    set<string> uebfa;

    while(cin>>s){
        int sz = s.size();

        string anfeespi = "";

        for(int i = 0; i < sz; i++){
            char aux = tolower(s[i]);

            if(aux >= 'a' && aux <= 'z')
                anfeespi += aux;

            else if(anfeespi != ""){
                uebfa.insert(anfeespi);
                anfeespi = "";
            }

        }

        if(anfeespi != "")
           uebfa.insert(anfeespi);
    }

    for(set<string>::iterator iter = uebfa.begin(); iter != uebfa.end(); iter++){
        cout<<*iter<<endl;
    }
}
