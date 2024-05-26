#include <bits/stdc++.h>

using namespace std;

// Función para calcular el máximo común divisor
int gcd(int a, int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

int main() {
    int N;
    cin >> N;

    vector<int> heights(N);
    for (int i = 0; i < N; ++i) {
        cin >> heights[i];
    }

    // Calcula la suma total de gcd cuando cada robot es el capitán
    long long total_strength = 0;
    for (int i = 0; i < N; ++i) {
        int left_gcd = (i == 0) ? heights[N - 1] : heights[i - 1]; // gcd con el robot a la izquierda
        int right_gcd = (i == N - 1) ? heights[0] : heights[i + 1]; // gcd con el robot a la derecha
        total_strength += gcd(heights[i], left_gcd);
        total_strength += gcd(heights[i], right_gcd);
    }

    cout << total_strength << endl;

    return 0;
}
