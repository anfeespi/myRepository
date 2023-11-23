import pandas as pd
import networkx as nx
import matplotlib.pyplot as plt

def read_csv(path):
    df = pd.read_csv(path)
    return df

def crear_edges(df):
    edges = []
    for i in range(len(df)):
        edges.append((df['Source'][i], df['Target'][i]))
    return edges

def graficar_grafo(G: nx.Graph):
    # Dibujar el grafo
    pos = nx.spring_layout(G)  # Calcular las posiciones de los nodos
    nx.draw(G, pos, with_labels=True, node_size=500, node_color='skyblue', font_size=12)
    # Mostrar el gráfico
    plt.show()

def graficar_medidas_de_centralidad(tipo, medidas):
    print("\n","*"*5,tipo.upper(),"*"*5, "\n")
    for (nodo, medida) in medidas:
        print(nodo," - ", medida)

# se leen los datos
nodos = read_csv("data/Nodes_GOT.csv")
edges = crear_edges(read_csv("data/Edges_GOT.csv"))

# se crea el grafo
G = nx.Graph()
G.add_nodes_from(nodos['Id'])
G.add_edges_from(edges)

# se calcula el grado de centralidad
centralidad = nx.degree_centrality(G)
print(graficar_medidas_de_centralidad("Centralidad", centralidad.items()))
# se calcula el grado de cercania
cercania = nx.closeness_centrality(G)
print(graficar_medidas_de_centralidad("Cercania", cercania.items()))
# se calcula el grado de intermediacion
print(graficar_medidas_de_centralidad("Intermediacion", nx.betweenness_centrality(G).items()))
# se calcula el grado promedio de centralidad
print("Grado promedio de centralidad: ", nx.average_degree_connectivity(G))


# se grafica el grafo
graficar_grafo(G)







