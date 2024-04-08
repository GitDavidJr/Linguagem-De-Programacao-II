package lingprog2.aula06;

public class ListagemArray {

	// listagem de números inteiros de um array
	public static void listarArrayInt(int[] array) {
		// bloco de acesso aos números inteiros do array
		for (int i = 0; i < array.length; i++) {
			if (i > 0)						// se enésimo número não for o primeiro número...
				System.out.print(", ");		// listagem de caractere de vírgula para separação entre números listados...
				
			System.out.print(array[i]);		// listagem de enésimo número
		}
		
		// listagem de quebra de linha após listagem de todos os números
		System.out.println();
	}
	
	// listagem de números de ponto flutuante de um array
	public static void listarArrayDouble(double[] array) {
		// bloco de acesso aos números de ponto flutuante do array
		for (int i = 0; i < array.length; i++) {
			if (i > 0)						// se enésimo número não for o primeiro número...
				System.out.print(", ");		// listagem de caractere de vírgula para separação entre números listados...
				
			System.out.print(array[i]);		// listagem de enésimo número
		}
		
		// listagem de quebra de linha após listagem de todos os números
		System.out.println();
	}
	
	// listagem de caracteres de um array
	public static void listarArrayChar(char[] array) {
		// bloco de acesso aos caracteres do array
		for (int i = 0; i < array.length; i++) {
			if (i > 0)						// se enésimo caractere não for o primeiro caractere...
				System.out.print(", ");		// listagem de caractere de vírgula para separação entre caracteres listados...
				
			System.out.print(array[i]);		// listagem de enésimo caractere
		}
		
		// listagem de quebra de linha após listagem de todos os caracteres
		System.out.println();
	}
	
	public static void main(String[] args) {
		// instanciação de arrays de tipos primitivos diferentes
		int[] arrayInt = {7, 2, 9, 1, 4};
		double[] arrayDouble = {8.9, 1.4, 2.3};
		char[] arrayChar = {'a', 'l', 'e', 'x', 'a', 'n', 'd', 'r', 'o'};
		
		// invocação de métodos estáticos de listagem de elementos de array (de acordo com tipo)
		System.out.print("Números Inteiros: ");
		listarArrayInt(arrayInt);
		
		System.out.print("Números de Ponto Flutuante: ");
		listarArrayDouble(arrayDouble);

		System.out.print("Caracteres: ");
		listarArrayChar(arrayChar);
	}

}
