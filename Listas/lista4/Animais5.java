import java.util.ArrayList;
import java.util.Scanner;

public class Animais5{

    final static ArrayList<String> listaMenor = new ArrayList(10);
    ArrayList<String> listaMaior = new ArrayList(10);
    
    public static void main(String[] args) {
        
        inserirAnimais();

        
    }

    public static void inserirAnimais(){

        Scanner s = new Scanner(System.in);
     
        for(int i = 0; i < 10; i++){
            System.out.print("Digite um nome do " + (i+1) + "° animal: ");
            String animal = s.nextLine();
            listaMenor.add(animal);
            s.nextLine();
        }

        s.close();
    }
}