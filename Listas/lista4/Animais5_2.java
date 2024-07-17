import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Iterator;

public class Animais5_2{

    final static Collection<String> listaMenor = new ArrayList<String>(10);
    final static Collection<String> listaMaior = new ArrayList<String>(10);
    
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
            Iterator<String> it; 
            boolean completo = false;

            while (!completo) {
                try{
                    System.out.print("Digite um nome do " + (i+1) + "° animal: ");
                    entrada = s.nextLine();

                    it = listaMenor.iterator();
                    String registrado;
                    while(it.hasNext()){
                        registrado = it.next();
                        if (registrado.equalsIgnoreCase(entrada)) {
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
    
        Iterator<String> it = listaMenor.iterator();
        String dado;

        while(it.hasNext()){
            dado = it.next();
            if(dado.length() >= 5){
                listaMaior.add(dado);
                it.remove();
            }

        }
    }
}