import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Q1_2{
    public static void main(String[] args) {
        
        List<Integer> triangulares = new ArrayList<>();

        try {
            
            Scanner flux = new Scanner(new FileReader("numeros.txt"));

            while (flux.hasNext()) {
                int numero = Integer.parseInt(flux.next());

                int controle = 0;
                int count = 0;
                while (controle < numero) {
                    controle += count++;
                    
                }

                if(controle == numero && numero != 0){
                    triangulares.add(numero);
                }
            }

            flux.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Numeros triangulares: " + triangulares);

        try {

            PrintWriter flux = new PrintWriter(new FileWriter("trinangulares.txt"));

            Iterator<Integer> it = triangulares.iterator();

            while (it.hasNext()) {
                flux.println(it.next());
            }

            flux.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        
    }
}