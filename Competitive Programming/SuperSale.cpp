#include<bits/stdc++.h>

using namespace std;

int main(){
    int t;
    cin>>t;

    while(t--){
        int n, p, w, g, mw, pr = 0;
        vector<int> uebfa(31, 0);

        cin>>n;
        for(int i = 0; i < n; i++){
            cin>>p>>w;
            for(int j = 30; j >= w; j--){
                if(uebfa[j] < uebfa[j-w]+p){
                    uebfa[j] = uebfa[j-w]+p;
                }
            }
        }
        cin>>g;
        while(g--){
            cin>>mw;
            pr += uebfa[mw];
        }

        cout<<pr<<endl;

    }

}
