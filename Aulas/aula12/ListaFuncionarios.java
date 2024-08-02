package lingprog2.aula12;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class ListaFuncionarios {

	final static String caminhoArquivo = "lista-func.txt";
	final static Collection<Funcionario> lista = new ArrayList<Funcionario>();
	final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int op;
		
		do {
			menu();
			
			System.out.print("Digite operação: ");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
				case 1: inserir(); break;
				case 2: reajustar(); break;
				case 3: listar(); break;
			}
			
		} while (op != 4);
		
		escreverArquivo();
		
		scanner.close();
	}

	public static void escreverArquivo() {
		FileWriter fluxoEscrita;
		try {
			fluxoEscrita = new FileWriter(caminhoArquivo);

			Iterator<Funcionario> it = lista.iterator();
			
			while (it.hasNext()) {
				Funcionario f = it.next();
				
				fluxoEscrita.write(f.getNome() + " " + f.getMatricula() +
						" "  + f.getSalario() + "\n");
			}
			
			fluxoEscrita.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() {
		System.out.println("******* OPERAÇÕES *******");
		System.out.println("* 1 - INSERIR           *");
		System.out.println("* 2 - REAJUSTAR SALÁRIO *");
		System.out.println("* 3 - LISTAR            *");
		System.out.println("* 4 - SAIR              *");
		System.out.println("*************************");
	}

	public static void inserir() {
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Matrícula: ");
		int matricula = scanner.nextInt();
		System.out.print("Salário Inicial: ");
		double salario = scanner.nextDouble();
		scanner.nextLine();
		
		Funcionario f = new Funcionario(nome, matricula, salario);
		
		lista.add(f);
	}
	
	public static void reajustar() {
		System.out.print("Percentual de Reajuste: ");
		double percentual = scanner.nextDouble();
		scanner.nextLine();
		
		Iterator<Funcionario> it = lista.iterator();

		while(it.hasNext()) {
			Funcionario f = it.next();
			f.reajustarSalario(percentual);
		}
	}

	public static void listar() {
		Iterator<Funcionario> it = lista.iterator();

		System.out.println("Lista");
		
		for (int i = 1; it.hasNext(); i++) {
			Funcionario f = it.next();
			System.out.println("Func. " + i + ": " + f);
		}
	}

}