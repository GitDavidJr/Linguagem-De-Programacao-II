package Aulas.aula13;

import java.io.FileInputStream;
import java.io.IOException;
public class LeituraBytes {
   public static void main(String[] args) {
      try {
         FileInputStream fluxo = new FileInputStream("arquivo.bin");
         byte byteLido;
         
         // leitura de bytes enquanto não se alcançar final do arquivo
         do {
            byteLido = (byte)fluxo.read();
            if (byteLido != -1)                    // se byte tiver sido lido...
               System.out.print((char)byteLido);   // listagem de enésimo byte como caractere
         } while (byteLido != -1);
         
         fluxo.close();
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
}
//abertura de fluxo de entrada a partir de invocação de construtor com indicação de nome de arquivo a ser lido fechamento de fluxo de entrada leitura de byte
