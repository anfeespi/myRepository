#include<bits/stdc++.h>

using namespace std;

int main(){
    int h, m;
    char aux;
    while(cin>>h>>aux>>m && !(h == 0 && m == 0)){
        double uebfa = abs(30 * h - 5.5 * m);

        uebfa = min(uebfa, 360 - uebfa);

        cout<<setprecision(3)<<fixed<<uebfa<<endl;
    }
}
