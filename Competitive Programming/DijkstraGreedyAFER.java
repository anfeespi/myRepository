import java.util.*;

class Grafo {
    private int vertices;
    private List<Map<Integer, Integer>> adyacencias;

    Grafo(int vertices) {
        this.vertices = vertices;
        this.adyacencias = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            this.adyacencias.add(new HashMap<>());
        }
    }

    void agregarArista(int origen, int destino, int peso) {
        adyacencias.get(origen).put(destino, peso);
    }

    void dijkstra(int inicio) {
        PriorityQueue<int[]> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicio] = 0;

        colaPrioridad.add(new int[]{inicio, 0});

        while (!colaPrioridad.isEmpty()) {
            int[] actual = colaPrioridad.poll();
            int nodoActual = actual[0];

            for (Map.Entry<Integer, Integer> vecino : adyacencias.get(nodoActual).entrySet()) {
                int nodoVecino = vecino.getKey();
                int pesoArista = vecino.getValue();

                int distanciaNueva = distancias[nodoActual] + pesoArista;

                if (distanciaNueva < distancias[nodoVecino]) {
                    distancias[nodoVecino] = distanciaNueva;
                    colaPrioridad.add(new int[]{nodoVecino, distanciaNueva});
                }
            }
        }

        System.out.println("Distancias mínimas desde el nodo " + inicio + ": " + Arrays.toString(distancias));
    }
}

public class DijkstraGreedyAFER {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);
        grafo.agregarArista(0, 1, 4);
        grafo.agregarArista(0, 2, 2);
        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(1, 3, 10);
        grafo.agregarArista(2, 3, 3);
        grafo.agregarArista(3, 4, 7);
        grafo.agregarArista(4, 0, 8);
        grafo.agregarArista(4, 5, 1);

        grafo.dijkstra(0);
    }
}