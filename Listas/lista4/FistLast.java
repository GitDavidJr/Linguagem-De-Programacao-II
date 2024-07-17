import java.util.ArrayList;
import java.util.Scanner;

public class FistLast{

    final static int tamanho = 10;
    final static ArrayList<Integer> diferentes = new ArrayList<Integer>(tamanho);
    final static ArrayList<Integer> iguais = new ArrayList<Integer>(tamanho);
    
    public static void main(String[] args) {
        
        inserirNumeros();
        redistribuir();
        System.out.println("Lista diferentes: " + diferentes);
        System.out.println("Lista iguais: " + iguais);

    }

    public static void inserirNumeros(){

        Scanner s = new Scanner(System.in);
     
        for(int i = 0; i < tamanho; i++){
            System.out.print("Digite o " + (i+1) + "° numero: ");
            diferentes.add(s.nextInt());
            

        }

        s.close();
    }

    public static void redistribuir(){
    
        int qnt = tamanho;
        for(int i = 0; i < qnt; i++){

            if((diferentes.get(i)%10) == getNumeroReverso(diferentes.get(i))%10){
                iguais.add(diferentes.get(i));
                diferentes.remove(i);
                i--;
                qnt--;
            }

        }
    }

    public static int getNumeroReverso(int n) {
        int ultimoDigito;
        int nReverso = 0;
        
        while (n != 0) {    
            ultimoDigito = n % 10;
            nReverso = nReverso * 10 + ultimoDigito;
            n = n / 10; 
        }
        
        return nReverso;
    }
}