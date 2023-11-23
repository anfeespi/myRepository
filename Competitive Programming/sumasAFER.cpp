#include <iostream>
#include <vector>

using namespace std;

void combinacionesSuma(int numero, std::vector<int>& numeros, int suma);

int main() {
    int n = 5;
    vector<int> numeros;
    combinacionesSuma(n, numeros, 0);

    return 0;
}

void combinacionesSuma(int numero, std::vector<int>& numeros, int suma) {
    if (suma == numero) {
        for (int i : numeros) {
            cout << i << ' ';
        }
        cout<<endl;
    } else {
        for (int i = 1; i <= numero; i++) {
            suma += i;
            if (suma <= numero) {
                numeros.push_back(i);
                combinacionesSuma(numero, numeros, suma);
                numeros.pop_back();
            }
            suma -= i;
        }
    }
}
