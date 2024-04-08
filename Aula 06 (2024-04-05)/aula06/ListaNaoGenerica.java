package lingprog2.aula06;

import java.util.Scanner;

public class ListaNaoGenerica {

	public static final int TAM = 10;
	private Integer[] valores;
	private int qtd;
	
	public ListaNaoGenerica() {
		qtd = 0;
		valores = new Integer[TAM];
	}
	
	public boolean adicionar(Integer n) {
		if (qtd == TAM)
			return false;
		else {
			valores[qtd++] = n;
			return true;
		}			
	}
	
	public String toString() {
		String r = "";
		
		for (int i = 0; i < qtd; i++) {
			if (i > 0)
				r += ", ";
			r += valores[i];
		}
		
		return r;
	}
	
	public static void main(String[] args) {
		ListaNaoGenerica lista = new ListaNaoGenerica();
		Scanner scanner = new Scanner(System.in);
		String resp;
		do {
			System.out.print("Inserir ou Encerrar (I/E)? ");
			resp = scanner.nextLine();
			
			if (resp.equalsIgnoreCase("I")) {
				System.out.print("Digite um inteiro: ");
				Integer n = scanner.nextInt();
				lista.adicionar(n);
				System.out.println("Lista após tentativa de adicionar: " + lista);
				scanner.nextLine();
			}
		} while (!resp.equalsIgnoreCase("E"));
	}

}
