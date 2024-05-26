#include<bits/stdc++.h>

using namespace std;

int main(){
	int t;
	cin>>t;
	int casen = 1;
	while(t--){
		int t1, t2, f, a, ts1, ts2, ts3, sum = 0;
		cin>>t1>>t2>>f>>a>>ts1>>ts2>>ts3;
		sum += t1 + t2 + f + a;
		if(ts1 < ts2 && ts1 < ts3){
			sum += (ts2 + ts3)/2;
		}else if(ts2 < ts1 && ts2 < ts3){
			sum += (ts1 + ts3)/2;
		}else{
			sum += (ts1 + ts2)/2;
		}
		
		string pr = "";
		
		if(sum >= 90) pr = "A";
		else if(sum >= 80) pr = "B";
		else if(sum >= 70) pr = "C";
		else if(sum >= 60) pr = "D";
		else pr = "F";
		
		cout<<"Case "<<casen<<": "<<pr<<endl;
		casen++;
	}
}
