import java.util.ArrayList;
import java.util.Scanner;

public class Animais5{

    final static ArrayList<String> listaMenor = new ArrayList<String>(10);
    final static ArrayList<String> listaMaior = new ArrayList<String>(10);
    
    public static void main(String[] args) {
        
        inserirAnimais();
        redistribuir();
        System.out.println("Lista menor: " + listaMenor);
        System.out.println("Lista maior: " + listaMaior);
    }

    public static void inserirAnimais(){

        Scanner s = new Scanner(System.in);
    
        
        for(int i = 0; i < 10; i++){

            String entrada = "";
        
            boolean completo = false;

            while (!completo) {
                try{
                    System.out.print("Digite um nome do " + (i+1) + "° animal: ");
                    entrada = s.nextLine();

                    for(int f = 0; f < i; f++){
                        if (listaMenor.get(f).equalsIgnoreCase(entrada)) {
                            throw new Exception("Animal ja inserido!");
                        }
                    }

                    if(entrada == ""){
                        throw new Exception("Nome Vazio");
                    }
                    
                    completo = true;
                } catch(Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }

            }

            listaMenor.add(entrada);

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