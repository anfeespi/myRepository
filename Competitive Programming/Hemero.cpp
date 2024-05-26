#include <numeric>
#include <iostream>
#include <vector>
using namespace std;
typedef long long int ll;

ll calcularDias(const vector<ll>& meses, ll day, ll month, ll year) {
    ll totalDias = day;

    for (ll i = 0; i < month - 1; i++) {
        totalDias += meses[i];
    }

    ll totalDiasAno = (year - 1) * accumulate(meses.begin(), meses.end(), 0);

    totalDias += totalDiasAno;

    return totalDias;
}

int main() {
    ll n;
    cin >> n;
    vector<ll> meses(n);

    for (ll i = 0; i < n; i++) {
        cin >> meses[i];
    }

    ll day1, month1, year1;
    cin >> day1 >> month1 >> year1;

    ll day2, month2, year2;
    cin >> day2 >> month2 >> year2;

    ll totalDiasAntiguos = calcularDias(meses, day1, month1, year1);
    ll totalDiasRecientes = calcularDias(meses, day2, month2, year2);

    cout << (totalDiasRecientes - totalDiasAntiguos) << endl;

    return 0;
}