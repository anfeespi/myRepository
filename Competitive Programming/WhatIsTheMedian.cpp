#include<bits/stdc++.h>

using namespace std;

vector<int> uebfa;

int main(){
    int anfeespi;
    while(scanf("%d", &anfeespi) != EOF){
        uebfa.insert(lower_bound(uebfa.begin(), uebfa.end(), anfeespi), anfeespi);

        if(uebfa.size() % 2 == 0)
            printf("%d\n", (uebfa[uebfa.size()/2] + uebfa[uebfa.size()/2 - 1])/2);
        else
            printf("%d\n", uebfa[uebfa.size()/2]);
    }
}
