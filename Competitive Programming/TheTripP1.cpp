#include<bits/stdc++.h>

using namespace std;

int uebfa[1001];

int main(){
    int n;

    while(cin>>n && n != 0){
        int s = 0;

        for(int i = 0; i < n; i++){
            int d, c;
            char point;

            cin>>d>>point>>c;

            uebfa[i] = d*100 + c;

            s += uebfa[i];
        }

        int la = s / n;
        int ha = la + ((s % n) ? 1 : 0);
        int sum = 0;
        int sum2 = 0;

        for(int i = 0; i < n; i++){
            if(uebfa[i] > ha)
                sum += uebfa[i] - ha;

            if(uebfa[i] < la)
                sum2 += la - uebfa[i];
        }

        int pr = max(sum, sum2);

        cout<<"$"<<(pr/100)<<"."<<setw(2)<<setfill('0')<<pr%100<<endl;

    }
}
