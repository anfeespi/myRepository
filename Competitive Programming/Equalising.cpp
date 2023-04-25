#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;
    double x;
    cin>>n>>x;
    double a[n], sum = 0.000000000;
    for(int i=0; i<n; i++){
        cin>>a[i];
        sum+=a[i]*a[i];
    }
    sum /= n;

    sum = x/sum;

    for(int i=0; i<n; i++){
        cout<<setprecision(10);
        cout<<a[i]*sqrt(sum);
        if(i!=n-1) cout<<" ";
    }
    return 0;
}
