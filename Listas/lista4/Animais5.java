import java.util.ArrayList;
import java.util.Scanner;

public class Animais5{

    final static ArrayList<String> listaMenor = new ArrayList(10);
    final static ArrayList<String> listaMaior = new ArrayList(10);
    
    public static void main(String[] args) {
        
        inserirAnimais();
        redistribuir();
        System.out.println("Lista menor: " + listaMenor);
        System.out.println("Lista maior: " + listaMaior);

        
    }

    public static void inserirAnimais(){

        Scanner s = new Scanner(System.in);
     
        for(int i = 0; i < 10; i++){
            System.out.print("Digite um nome do " + (i+1) + "° animal: ");
            String animal = s.nextLine();
            listaMenor.add(animal);

        }

        s.close();
    }

    public static void redistribuir(){
    
        int qnt = 10;
        for(int i = 0; i < qnt; i++){

            if(listaMenor.get(i).length() >= 5){
                listaMaior.add(listaMenor.get(i));
                listaMenor.remove(i);
                i--;
                qnt--;
            }

        }
    }
}