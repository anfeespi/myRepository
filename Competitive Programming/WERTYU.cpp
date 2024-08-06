#include<bits/stdc++.h>

using namespace std;

char uebfa[] = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

int main(){
    char c;

    while(scanf("%c", &c) != EOF){
        if(!isspace(c)){
            bool flag = true;
            for(int i = 0; uebfa[i]; i++){
                if(c == uebfa[i]){
                    cout<<uebfa[i-1];
                    flag = false;
                    break;
                }
            }

            if(flag)
                cout<<c;
        }else
            cout<<c;
    }

}
