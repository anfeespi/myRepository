#include<bits/stdc++.h>

using namespace std;

int main(){
    int uebfa, n, m;

    while(cin>>uebfa && uebfa != 0){
        cin>>n>>m;
        int x, y;
        while(uebfa--){
            cin>>x>>y;

            if(n == x || m == y)
                cout<<"divisa";

            else if(x > n && y > m)
                cout<<"NE";

            else if(x < n && y > m)
                cout<<"NO";

            else if(x < n && y < m)
                cout<<"SO";

            else
                cout<<"SE";

            cout<<endl;
        }
    }

}
