#include<bits/stdc++.h>

using namespace std;

int dx[] = {1, 1, -1, -1, 2, 2, -2, -2};
int dy[] = {2, -2, 2, -2, 1, -1, 1, -1};

struct node{
    int idx1;
    int idx2;
    int weight;

    node(int a, int b, int c){
        idx1 = a;
        idx2 = b;
        weight = c;
    }
};

int uebfa(int a, int b, int m, int n){
    queue<node> q;
    q.push(node(a,b,0));

    while(!q.empty()){
        node aux = q.front();
        q.pop();

        if(aux.idx1 == m && aux.idx2 == n)
            return aux.weight;

        for(int i = 0; i < 8; i++){
            int x = aux.idx1 + dx[i];
            int y = aux.idx2 + dy[i];
            if(x >= 1 && y >= 1 && x <= 8 && y <= 8)
                q.push(node(x,y,aux.weight+1));
        }
    }
}

int main(){
    string s1, s2;
    int x1, y1, x2, y2;
    while(cin>>s1>>s2){
        x1 = s1[0] - 'a' + 1;
        y1 = s1[1] - '0';

        x2 = s2[0] - 'a' + 1;
        y2 = s2[1] - '0';

        cout<<"To get from "<<s1<<" to "<<s2<<" takes "<<uebfa(x1,y1,x2,y2)<<" knight moves."<<endl;
    }
}
