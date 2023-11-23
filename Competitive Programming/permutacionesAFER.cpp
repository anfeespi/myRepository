#include <iostream>
#include <vector>

using namespace std;

void generarPermutaciones(std::vector<int>& conjunto, std::vector<int>& permutacionActual, std::vector<bool>& utilizado) {
    if (permutacionActual.size() == conjunto.size()) {
        for (int num : permutacionActual) {
            cout << num << " ";
        }
        cout << endl;
        return;
    }

    for (int i = 0; i < conjunto.size(); ++i) {
        if (!utilizado[i]) {
            permutacionActual.push_back(conjunto[i]);
            utilizado[i] = true;
            
            generarPermutaciones(conjunto, permutacionActual, utilizado);
            
            permutacionActual.pop_back();
            utilizado[i] = false;
        }
    }
}

int main() {
    vector<int> conjunto = {1, 2, 3};
    vector<int> permutacionActual;
    vector<bool> utilizado(conjunto.size(), false);

    generarPermutaciones(conjunto, permutacionActual, utilizado);

    return 0;
}
