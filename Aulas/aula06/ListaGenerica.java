package Aulas.aula06;

import java.util.Scanner;

public class ListaGenerica <T> {

	public static final int TAM = 10;
	private T[] valores;
	private int qtd;
	
	public ListaGenerica() {
		qtd = 0;
		valores = (T[])new Object[TAM];
	}
	
	public boolean adicionar(T elemento) {
		if (qtd == TAM)
			return false;
		else {
			valores[qtd++] = elemento;
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
		ListaGenerica<String> lista = new ListaGenerica<String>();
		Scanner scanner = new Scanner(System.in);
		String resp;
		do {
			System.out.print("Inserir ou Encerrar (I/E)? ");
			resp = scanner.nextLine();
			
			if (resp.equalsIgnoreCase("I")) {
				System.out.print("Digite um nome: ");
				String nome = scanner.nextLine();
				lista.adicionar(nome);
				System.out.println("Lista após tentativa de adicionar: " + lista);
			}
		} while (!resp.equalsIgnoreCase("E"));
	}

}
