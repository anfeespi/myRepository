#include<bits/stdc++.h>

using namespace std;

double g[100][2];
int n;
double sum;

void uebfa(){
    double ax, mn;
    double dist[100];
    bool intree[100];

    memset(intree, 0, sizeof intree);

    for(int i = 0; i < 100; i++)
        dist[i]=1000000.0;

    int v = 0;
    dist[0] = 0;
    sum = 0;

    while(!intree[v]){
        intree[v] = true;
        sum += dist[v];

        for(int i = 0; i < n; i++){
            if(!intree[i]){
                ax = sqrt(pow(g[v][0]-g[i][0],2) + pow(g[v][1]-g[i][1],2));
                if(ax < dist[i])
                    dist[i] = ax;
            }
        }

        v = 0;
        mn = 1000000.0;

        for(int i = 0; i < n; i++){
            if(!intree[i]){
                if(dist[i] < mn){
                    v = i;
                    mn = dist[i];
                }
            }
        }

    }

    printf("%.2f\n", sum);
}

int main(){
    int t;

    double a,b;

    cin>>t;

    for(int i = 0; i < t; i++){
        cin>>n;

        for(int j = 0; j < n; j++){
            cin>>a>>b;
            g[j][0]=a;
            g[j][1]=b;
        }

        uebfa();
        if(i != t-1) cout<<endl;
    }

    return 0;
}
