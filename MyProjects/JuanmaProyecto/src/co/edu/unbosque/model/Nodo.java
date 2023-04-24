/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.edu.unbosque.model;

public class Nodo {
    // Variable en la cual se va a guardar el valor.
    private Encargo valor;
    // Variable para enlazar los nodos.
    private Nodo siguiente;
    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public void Nodo(){
        this.valor = null;
        this.siguiente = null;
    }
    
    // Métodos get y set para los atributos.
    
    public Encargo getValor() {
        return valor;
    }

    public void setValor(Encargo valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

	@Override
	public String toString() {
		return valor.toString();
	}
    
    
}
