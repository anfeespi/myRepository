#include<bits/stdc++.h>

using namespace std;

int main(){
    int n, x;
    queue<int> uebfa;


    while(cin>>n && n != 0){
        for(int i = 1; i <= n; i++){
            uebfa.push(i);
        }

        cout<<"Discarded cards:";

        while(uebfa.size() > 1){
            cout<<" "<<uebfa.front();
            uebfa.pop();
            x = uebfa.front();
            uebfa.pop();

            if(!uebfa.empty())
                cout<<",";

            uebfa.push(x);
        }

        cout<<endl<<"Remaining card: "<<uebfa.front()<<endl;

        uebfa.pop();
    }
}
