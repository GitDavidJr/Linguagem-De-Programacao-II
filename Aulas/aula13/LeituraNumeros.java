package Aulas.aula13;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class LeituraNumeros {
    
    public static void main(String[] args) {
        try {
            FileReader fluxoLeitura = new FileReader("LeituraNumeros.txt");
            Scanner fluxo = new Scanner(fluxoLeitura);

            while (fluxo.hasNext()) {
                System.out.println(fluxo.next());
            }

            fluxo.close();
            fluxoLeitura.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
