package Aulas.aula04;

import java.util.Scanner;

public class ContadorCustomizadoThreadUtil {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String resp;
		
		System.out.print("Digite tempo de pausa em segundos: ");
		int pausa = scanner.nextInt();
		System.out.print("Digite limite de contagem: ");
		int limite = scanner.nextInt();
		
		
		ContadorCustomizadoThread c = new ContadorCustomizadoThread(pausa, limite);
		c.start();
		
		scanner.nextLine();
		
		do {
			System.out.print("Mostrar Contagem Atual ou Encerrar Programa (M/E)? ");
			resp = scanner.nextLine();
			
			if (!c.isAlive()) {
				System.out.println("Contagem Encerrada!");				
			}
			else if (resp.equalsIgnoreCase("M")) {
				System.out.println("Contagem Atual: " + c.getContagemAtual());
			}
				
		} while (!resp.equalsIgnoreCase("E"));
		
		scanner.close();
	}

}
