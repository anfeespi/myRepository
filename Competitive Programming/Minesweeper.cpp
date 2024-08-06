#include<bits/stdc++.h>

using namespace std;

int main(){
    int field = 1;
    int n, m;

    while(cin>>m>>n && m != 0 && n != 0){
        string uebfa[m];
        for(int i = 0; i < m; i++){
            cin>>uebfa[i];
        }

        cout<<"Field #"<<field++<<":"<<endl;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(uebfa[i][j] == '*'){
                    cout<<"*";
                }else{
                    int pr = 0;
                    for(int k = i - 1; k <= i + 1; k++){
                        for(int l = j - 1; l <= j + 1; l++){
                            if(k >= 0 && l >= 0 && k < m && l < n && uebfa[k][l] == '*')
                                pr++;
                        }
                    }
                    cout<<pr;
                }
            }
            cout<<endl;
        }
        cout<<endl;
    }

}
