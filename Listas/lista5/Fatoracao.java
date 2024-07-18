import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Fatoracao {
    
    final static Queue<Integer> fatoracaoPrima = new ArrayDeque<Integer>(); 

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Insira um numero: ");
        fatoracao(s.nextInt());
        System.out.println(fatoracaoPrima);

        s.close();
    }

    public static void fatoracao(int numero){
        
        int numAux = numero;
        int divisor = 2;

        while (numAux != 1) {
            while ((numAux%divisor) == 0) {
                fatoracaoPrima.add(divisor);
                numAux = numAux/divisor;
            }
            divisor++;
        }
    }
}
