#include<bits/stdc++.h>

using namespace std;

int uebfa(string s){
    int sum = 0;
    for(int i = 0; i < s.size(); i++){
        if (s[i] >= 'a' && s[i] <= 'z')
            sum += s[i] - 'a' + 1;
        else if (s[i] >= 'A' && s[i] <= 'Z')
            sum += s[i] - 'A' + 1;
    }

    if(sum % 9 == 0)
        return 9;

    return sum % 9;
}

int main(){
    string s1, s2;

    while(getline(cin, s1) && getline(cin, s2)){
        int a = uebfa(s1);
        int b = uebfa(s2);

        double r = min((double)a/b, (double)b/a);

        cout<<setprecision(2)<<fixed<<r*100.0<<" %"<<endl;
    }
}
