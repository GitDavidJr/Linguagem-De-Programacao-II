package Aulas.aula13;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
public class LeituraBinariaNumeros {
   public static void main(String[] args) {
      try {
         FileInputStream fluxoArquivo = new FileInputStream("numeros.bin");
         BufferedInputStream fluxoBuffer = new BufferedInputStream(fluxoArquivo);
         DataInputStream fluxoDados = new DataInputStream(fluxoBuffer);
         boolean finalArquivo = false;
         
         while (!finalArquivo) {
            try {
               int numLido = fluxoDados.readInt();             
               System.out.println(numLido); 
            }
            catch(EOFException e) {
               finalArquivo = true;
               System.out.println("Arquivo totalmente lido!");
            }            
         }
         fluxoDados.close();
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
}

