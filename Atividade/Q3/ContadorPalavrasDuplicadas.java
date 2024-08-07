package Q3;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ContadorPalavrasDuplicadas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma sentença: ");
        String sentenca = scanner.nextLine(); // entrada de sequência de texto

        // Inicialização de separador de sentença (com indicação de caracteres delimitadores)
        StringTokenizer separador = new StringTokenizer(sentenca, " \t\n\r\f,.:;?![]()'");

        // Mapa para contar a ocorrência de cada palavra
        Map<String, Integer> mapaPalavras = new HashMap<>();

        // Iteração entre as palavras separadas por símbolos de pontuação (tokens)
        while (separador.hasMoreTokens()) {
            String palavra = separador.nextToken().toLowerCase(Locale.ROOT); // Convertendo para minúsculas
            if (mapaPalavras.containsKey(palavra)) {
                mapaPalavras.put(palavra, mapaPalavras.get(palavra) + 1);
            } else {
                mapaPalavras.put(palavra, 1);
            }
        }

        // Contagem de palavras duplicadas
        int contagemDuplicadas = 0;
        for (int contagem : mapaPalavras.values()) {
            if (contagem > 1) {
                contagemDuplicadas++;
            }
        }

        System.out.println("Número de palavras duplicadas: " + contagemDuplicadas);
        
        scanner.close();
    }
}