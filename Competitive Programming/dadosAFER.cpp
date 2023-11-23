#include <iostream>

using namespace std;

void tiradas(int dados[], int valorSuperar, int suma, int tirada);

int main() {
    int dados[] = {1, 1, 1};
    int valorSuperar = 15;

    tiradas(dados, valorSuperar, 0, 0);

    return 0;
}

void tiradas(int dados[], int valorSuperar, int suma, int tirada) {
    if (tirada == 3 && suma >= valorSuperar) {
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                cout << dados[i] << "=";
            } else {
                cout << dados[i] << "+";
            }
        }
        cout << suma << endl;
    } else if (tirada != 3) {
        for (int i = 1; i <= 6; i++) {
            dados[tirada] = i; 
            suma += i; 
            tiradas(dados, valorSuperar, suma, tirada + 1);
            suma -= i;
        }
    }
}
