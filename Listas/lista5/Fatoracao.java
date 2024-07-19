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
        
        int divisor = 2;

        while (numero != 1) {
            while ((numero%divisor) == 0) {
                fatoracaoPrima.add(divisor);
                numero = numero/divisor;
            }
            divisor++;
        }
    }
}
