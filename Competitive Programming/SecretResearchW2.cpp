#include <bits/stdc++.h>

using namespace std;

int main(){
	int uebfa;
	cin>>uebfa;

	while(uebfa--){
		string s;
		cin>>s;
		int length = s.length();

		if(length == 1 || (length == 2 && s == "78"))
			cout<<"+"<<endl;
		else if(s[0] == '9' && s[length - 1] == '4')
			cout << "*"<<endl;
		else if(s[length - 2] == '3' && s[length - 1] == '5')
			cout << "-"<<endl;
		else
			cout << "?"<<endl;
	}
}