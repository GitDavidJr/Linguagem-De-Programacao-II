package lingprog2.aula06;

import java.util.Scanner;

// Busca de inteiro em um array de inteiros
public class BuscaArrayIntegerUtil {

	// constante para indicação de tamanho de array
	public static final int TAM = 5;
		
	public static void main(String[] args) {
		// fluxo de entrada padrão
		Scanner scanner = new Scanner(System.in);
		
		// array de inteiros
		Integer[] array = new Integer[TAM];
				
		System.out.printf("Digite %d inteiros separados por espaços: ", TAM);
		
		// entrada de inteiros a serem inseridos em array
		for (int i = 0; i < TAM; i++)
			array[i] = scanner.nextInt();
		
		// entrada de inteiro a ser buscado em array
		System.out.print("Digite inteiro a ser buscado em sequência anterior de inteiros: ");
		int inteiro = scanner.nextInt();
		
		// invocação de método genérico estático
		int indice = BuscaArrayGenerico.buscar(array, inteiro);
		
		if (indice == -1)
			System.out.printf("Inteiro %d não encontrado em sequência!", inteiro);
		else
			System.out.printf("Inteiro %d encontrado em %dª posição da sequência!", inteiro, indice + 1);
		
		// fechamento de fluxo de entrada
		scanner.close();
	}

}
