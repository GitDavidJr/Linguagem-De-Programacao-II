package Aulas.aula05;

public class ListagemArrayGenericoErro {

	// listagem de elementos de um array de qualquer tipo
	public static <T> void listarArrayGenerico(T[] array) {
		// bloco de acesso aos elementos do array
		for (int i = 0; i < array.length; i++) {
			if (i > 0)						// se enésimo elemento não for o primeiro elemento...
				System.out.print(", ");		// listagem de caractere de vírgula para separação entre elementos listados...
				
			System.out.print(array[i]);		// listagem de enésimo elemento
		}
		
		// listagem de quebra de linha após listagem de todos os elementos
		System.out.println();
	}
	
	public static void main(String[] args) {
		// instanciação de arrays de tipos primitivos diferentes
		Integer[] arrayInt = {7, 2, 9, 1, 4};
		Double[] arrayDouble = {8.9, 1.4, 2.3};
		Character[] arrayChar = {'a', 'l', 'e', 'x', 'a', 'n', 'd', 'r', 'o'};
		
		// invocação de método estático genérico de listagem de elementos para cada array de tipo primitivo (ERRO DE COMPILAÇÃO)
		System.out.print("Números Inteiros: ");
		listarArrayGenerico(arrayInt);
		
		System.out.print("Números de Ponto Flutuante: ");
		listarArrayGenerico(arrayDouble);

		System.out.print("Caracteres: ");
		listarArrayGenerico(arrayChar);
	}

}
