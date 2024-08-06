#include<bits/stdc++.h>

using namespace std;

int nums[10000][10];

void uebfa() {
	int tn;

	memset(nums, 0, sizeof nums);

	for(int i = 1; i < 10000; i++) {
		memcpy(nums[i], nums[i-1], 40);
		tn = i;
		while(tn){
            nums[i][tn%10]++;
            tn /= 10;
		}
	}
}
int main() {
	uebfa();

	int t, n, i;

	cin>>t;
	while(t--) {
		cin>>n;

		for(i = 0; i < 9; i++)
			cout<<nums[n][i]<<" ";

		cout<<nums[n][i]<<endl;
	}
}
