package Aulas.aula05;

public class BuscaArrayGenerico {

	// listagem de elementos de um array de qualquer tipo
	public static <T extends Comparable> int buscar(T[] array, T elemento) {
		// bloco de acesso aos elementos do array
		for (int i = 0; i < array.length; i++) {
			// se enésimo elemento for igual ao elemento alvo que se pretende localizar no array...
			if (array[i].compareTo(elemento) == 0)
				return i;								// retorno de enésimo índice
		}
		
		// retorno em caso de não localização de elemento alvo no array
		return -1;
	}

}
