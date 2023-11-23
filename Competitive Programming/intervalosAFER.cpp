#include <bits/stdc++.h>

using namespace std;

struct Intervalo {
    int inicio, fin;
    
    Intervalo(int i, int f) : inicio(i), fin(f) {}
};

bool compararIntervalos(const Intervalo& a, const Intervalo& b) {
    return a.fin < b.fin;
}

void seleccionarIntervalos(std::vector<Intervalo>& intervalos) {
    sort(intervalos.begin(), intervalos.end(), compararIntervalos);
    
    vector<Intervalo> seleccionados;
    seleccionados.push_back(intervalos[0]);
    
    for (size_t i = 1; i < intervalos.size(); ++i) {
        if (intervalos[i].inicio >= seleccionados.back().fin) {
            seleccionados.push_back(intervalos[i]);
        }
    }
    
    // Mostrar intervalos seleccionados
    cout << "Intervalos seleccionados:\n";
    for (const auto& intervalo : seleccionados) {
        cout << "[" << intervalo.inicio << ", " << intervalo.fin << "] ";
    }
    cout << endl;
}

int main() {
    vector<Intervalo> intervalos = { {1, 3}, {2, 4}, {3, 6}, {5, 7}, {8, 9} };
    
    seleccionarIntervalos(intervalos);
    
    return 0;
}