#include<bits/stdc++.h>

using namespace std;

int main(){
    string uebfa;

    while(cin>>uebfa){
        int ax1 = -1, ax2;

        for(int i = 0; i < uebfa.size(); i++){
            if(uebfa[i] == 'B' || uebfa[i] == 'F' || uebfa[i] == 'P' || uebfa[i] == 'V')
                ax2 = 1;
            else if(uebfa[i] == 'C' || uebfa[i] == 'G' || uebfa[i] == 'J' || uebfa[i] == 'K' || uebfa[i] == 'Q' || uebfa[i] == 'S' || uebfa[i] == 'X' || uebfa[i] == 'Z')
                ax2 = 2;
            else if(uebfa[i] == 'D' || uebfa[i] == 'T')
                ax2 = 3;
            else if(uebfa[i] == 'L')
                ax2 = 4;
            else if(uebfa[i] == 'M' || uebfa[i] == 'N')
                ax2 = 5;
            else if(uebfa[i] == 'R')
                ax2 = 6;
            else
                ax2 = -1;

            if(ax2 != ax1 && ax2 != -1)
                cout<<ax2;

            ax1 = ax2;
        }
        cout<<endl;
    }
}
