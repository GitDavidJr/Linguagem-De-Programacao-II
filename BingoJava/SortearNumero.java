

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SortearNumero {
    private int numero = 0;
    List<Integer> numerosSorteados = new ArrayList<Integer>();
    Random r = new Random();

    public void sortearNumero() {
        int numeroAleatorio;
        do {
            numeroAleatorio = r.nextInt(1,100);
        } while (jaFoiSorteado(numeroAleatorio));

        numero = numeroAleatorio;
        numerosSorteados.add(numero);
    }

    private boolean jaFoiSorteado(int numero){
        return numerosSorteados.contains(numero);
    }

    public int getNumero() {
        return numero;
    }

    public List getNumerosSorteados(){
        return numerosSorteados;
    }


}
