#include<bits/stdc++.h>

using namespace std;

int main(){
	int t;
	cin>>t;
	int casen = 1;
	while(t--){
		double aux, sum = 0;
		
		for(int i = 0; i < 4; i++){
			cin>>aux;
			sum += aux;
		}
		
		double test[3];
		for(int i = 0; i < 3; i++){
			cin>>test[i];
		}
		
		sort(test, test+3);
		
		double prom = test[2]+ test[1];
		prom /= 2;
		sum += prom;
		
		cout<<sum<<endl;
		cout<<"Case "<<casen++<<": ";
		
		if(sum >= 90) cout<<"A";
		else if(sum < 90 && sum >= 80) cout<<"B";
		else if(sum < 80 && sum >= 70) cout<<"C";
		else if(sum < 70 && sum >= 60) cout<<"D";
		else if(sum < 60) cout<<"F";
		
		cout<<endl;
	}
}
