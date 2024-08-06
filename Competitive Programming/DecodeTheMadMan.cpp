#include<bits/stdc++.h>

using namespace std;

char uebfa[] = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";

int main(){
    char c;

    while(scanf("%c", &c) != EOF){
        c = tolower(c);
        if(!isspace(c)){
            for(int i = 0; uebfa[i]; i++){
                if(c == uebfa[i]){
                    cout<<uebfa[i-2];
                    break;
                }
            }
        }else
            cout<<c;
    }

}
