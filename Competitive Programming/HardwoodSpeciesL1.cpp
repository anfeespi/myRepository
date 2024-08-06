#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;
    map<string, int> uebfa;
    string name;

    scanf("%d\n\n", &n);

    while(n--){
        int total = 0;

        while(getline(cin, name)){
            if(name.length() == 0){
                break;
            }

            if(uebfa.count(string(name)) == 0){
                uebfa[string(name)] = 1;
            }else{
                uebfa[string(name)] = uebfa[string(name)] + 1;
            }

            total++;
        }
        map<string, int>::iterator it;

        for(it = uebfa.begin(); it != uebfa.end(); it++){
            printf("%s %.4lf\n",(*it).first.data(),(double) (*it).second / (double) total * 100.0);
        }
        if(n > 0){
            cout<<endl;
            uebfa.clear();
        }
    }
    cout<<endl;
}
