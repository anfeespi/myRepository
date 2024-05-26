#include <iostream>
using namespace std;

typedef long long int ll;

int main() {
    ll n, t = 0, ini = 3, sum = 3, r;

    cin >> n;
    r = n;

    while (r >= 3) {
        while (true) {
            if (r - ini >= 0) {
                t++;
                r -= ini;
                ini += sum;
                sum++;
            } else {
                ini = 3;
                sum = 3;
                break;
            }
        }
    }

    cout << t << " " << r << endl;

    return 0;
}