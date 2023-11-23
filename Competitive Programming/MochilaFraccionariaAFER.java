import java.util.Arrays;
import java.util.Comparator;

class Objeto {
    int peso, valor;

    Objeto(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }
}

public class MochilaFraccionariaAFER {

    static double obtenerValorMaximo(Objeto[] objetos, int capacidad) {
        Arrays.sort(objetos, Comparator.comparingDouble(o -> (double) o.valor / o.peso).reversed());

        double valorTotal = 0.0;
        int espacioRestante = capacidad;

        for (Objeto objeto : objetos) {
            if (espacioRestante >= objeto.peso) {
                valorTotal += objeto.valor;
                espacioRestante -= objeto.peso;
            } else {
                valorTotal += (double) objeto.valor / objeto.peso * espacioRestante;
                break;
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        Objeto[] objetos = {
                new Objeto(10, 60),
                new Objeto(20, 100),
                new Objeto(30, 120)
        };

        int capacidadMochila = 50;

        double valorMaximo = obtenerValorMaximo(objetos, capacidadMochila);
        System.out.println("Valor máximo en la mochila: " + valorMaximo);
    }
}