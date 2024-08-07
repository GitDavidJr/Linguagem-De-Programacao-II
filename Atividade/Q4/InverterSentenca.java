package Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InverterSentenca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma sentença: ");
        String sentenca = scanner.nextLine(); // entrada de sequência de texto

        // Inicialização de separador de sentença usando-se como delimitador símbolo de espaço
        StringTokenizer separador = new StringTokenizer(sentenca);

        // Lista para armazenar as palavras
        List<String> listaPalavras = new ArrayList<>();

        // Iteração entre as palavras separadas por espaços (tokens)
        while (separador.hasMoreTokens()) {
            listaPalavras.add(separador.nextToken());
        }

        // Exibir as palavras na ordem inversa
        System.out.print("Sentença invertida: ");
        for (int i = listaPalavras.size() - 1; i >= 0; i--) {
            System.out.print(listaPalavras.get(i) + " ");
        }

        scanner.close();
    }
}