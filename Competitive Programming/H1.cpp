#include <bits/stdc++.h>
using namespace std;
#define ll long long int
int main() {
  ll n;
  while(cin>>n) {
    ll uebfa = (n * (n + 1) / 2);
    uebfa = uebfa * uebfa;
    cout << uebfa << '\n';
  }
  return 0;
}