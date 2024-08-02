package Aulas.aula13;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscritaNumeros {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            FileWriter fluxoArquivo = new FileWriter("numeros2.txt");
            PrintWriter fluxo = new PrintWriter(fluxoArquivo);

            int i;

            do{
                System.out.print("Insira um numero (para encerrar digite 0): ");
                i = s.nextInt();
                if(i != 0){
                    fluxo.println(i);
                }
            } while(i != 0);

            System.out.println("Numeros digitados registrado!");

            fluxo.close();
            fluxoArquivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        s.close();
    }
}
