#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin>>n;

    string s;
    cin>>s;

    string pr = "";
    for(int i = 0; i < n; i++){
        if(s[i] == '(' && s[i+1] == ')') pr += "(1";
        else if(s[i] == ')' && s[i+1] == '(') pr += ")*";
        else if(s[i] == ')' && s[i+1] == ')') pr += ")+1";
        else pr += s[i];
    }

    cout<<resolverEcuacion(pr)<<endl;
}
