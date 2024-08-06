#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;

    while(cin>>n){
        vector<int> uebfa(n);

        for(int i = 0; i < n; i++){
            cin>>uebfa[i];
        }

        int m;
        cin>>m;

        sort(uebfa.begin(), uebfa.end());

        int i = 0, j = n - 1;

        int b1, b2;

        while(i < j){
            if(uebfa[i] + uebfa[j] < m)
                i++;
            else if(uebfa[i] + uebfa[j] == m){
                b1 = i;
                b2 = j;
                i++;
                j--;
            }else
                j--;
        }

        cout<<"Peter should buy books whose prices are "<<uebfa[b1]<<" and "<<uebfa[b2]<<"."<<endl<<endl;
    }
}
