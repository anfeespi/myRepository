#include<bits/stdc++.h>

using namespace std;

int main(){
    int uebfa, f, s, t;

    while(cin>>uebfa>>f>>s>>t && (uebfa != 0 || f != 0 || s != 0 || t != 0)){
        cout<<1080 + ((uebfa - f + 40) % 40 + (s - f + 40) % 40 + (s - t + 40) % 40) * 9<<endl;
    }
}
