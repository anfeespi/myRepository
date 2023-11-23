#include <bits/stdc++.h>

using namespace std;

void encontrarParticionMinima(vector<int>& conjunto, vector<int>& particionActual, vector<int>& mejorParticion, int sumaActual, int mejorSuma, int indice) {
    int diferencia = abs(2 * sumaActual - mejorSuma);

    if (diferencia < abs(2 * mejorSuma - mejorSuma)) {
        mejorParticion = particionActual;
        mejorSuma = sumaActual;
    }

    for (int i = indice; i < conjunto.size(); ++i) {
        particionActual.push_back(conjunto[i]);
        sumaActual += conjunto[i];

        encontrarParticionMinima(conjunto, particionActual, mejorParticion, sumaActual, mejorSuma, i + 1);

        particionActual.pop_back();
        sumaActual -= conjunto[i];
    }
}

int main() {
    vector<int> conjunto = {1, 2, 3, 4, 5};
    vector<int> particionActual, mejorParticion;
    int sumaActual = 0, mejorSuma = 0;

    mejorParticion = conjunto;
    mejorSuma = accumulate(conjunto.begin(), conjunto.end(), 0);

    encontrarParticionMinima(conjunto, particionActual, mejorParticion, sumaActual, mejorSuma, 0);

    cout << "Mejor Partición: ";
    for (int num : mejorParticion) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}

