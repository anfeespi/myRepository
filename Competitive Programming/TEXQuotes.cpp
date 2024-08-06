#include<bits/stdc++.h>

using namespace std;

int main(){
    string aux;

    bool uebfa = true;

    while(cin>>aux){
        char s[aux.length()];
        strcpy(s, aux.c_str());
        for(int i = 0; i < strlen(s); i++){
            if(s[i] == '"'){
                if(uebfa)
                    cout<<"``";
                else
                    cout<<"''";

                uebfa = !uebfa;
            }else{
                cout<<s[i];
            }
        }
        cout<<endl;
    }

}
