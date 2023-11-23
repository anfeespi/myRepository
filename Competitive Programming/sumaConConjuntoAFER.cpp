#include <iostream>
#include <vector>

using namespace std;

void encontrarCombinacionesConSuma(vector<int>& conjunto, int objetivo, vector<int>& combinacionActual, int indice) {
    if (objetivo == 0) {
        for (int num : combinacionActual) {
            cout << num << " ";
        }
        cout << std::endl;
        return;
    }

    for (int i = indice; i < conjunto.size(); ++i) {
        if (objetivo - conjunto[i] >= 0) {
           
            combinacionActual.push_back(conjunto[i]);
            
           
            encontrarCombinacionesConSuma(conjunto, objetivo - conjunto[i], combinacionActual, i);
            
            combinacionActual.pop_back();
        }
    }
}

int main() {
    vector<int> conjunto = {2, 4, 6, 8};
    int objetivo = 10;
    vector<int> combinacionActual;

    encontrarCombinacionesConSuma(conjunto, objetivo, combinacionActual, 0);

    return 0;
}
