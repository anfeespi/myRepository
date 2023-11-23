#include <iostream>
#include <fstream>
#include <math.h>
using namespace std;

bool isPrime(int p){
	if (p==1) return false;
	
	if (p==2) return true;
	
	if (p%2==0) return false;
	
	for (int i=3; i*i<=p; i+=2){
		if(p%i == 0) return false;
	}
	
	return true;
}

int main(int argc, char *argv[]) {
	string file_name = "salida3.out";
	
	ofstream file;
	
	file.open(file_name.c_str(), fstream::out);
	
	for(int i=0; i<pow(10, 9); i++){
		if(isPrime(i)){
			file<<i<<endl;
		}
	}
	
	file.close();
	
	return 0;
}

