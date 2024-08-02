package Aulas.aula13;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class EscritaBinariaNumeros {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        try {

            DataOutputStream fluxosDados = new DataOutputStream(new FileOutputStream("numeros2.txt"));

            int n;

            do {
                
                System.out.print("Insira um numero (digite 0 para encerrar)");
                n = s.nextInt();
                if(n != 0){
                    fluxosDados.writeInt(n);
                }
            } while (n != 0);

            fluxosDados.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        s.close();
    }
}
