#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin>>n;

    cin.ignore();

    int letters[26] = {0};
    int mx = -1;
    char c;

    while(n--){
        string uebfa;
        getline(cin, uebfa);

        for(int i = 0; i < uebfa.length(); i++){
            if(isalpha(uebfa[i])){
                c = tolower(uebfa[i]);
                letters[c-'a']++;
                mx = max(mx, letters[c-'a']);
            }
        }

    }
    for(int i = mx; i > 0; i--){
        for(int j = 0; j < 26; j++){
            if(letters[j] == i){
                c = j+'A';
                cout<<c<<" "<<letters[j]<<endl;
            }
        }
    }
}
