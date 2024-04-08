package lingprog2.lista02.questao05;

import java.util.Scanner;

public class ContadorRegressivoUtil {

	public static void main(String[] args) {
		final int PAUSAT = 1000;
		long c1, c2, c3;
		char resp;
		ContadorRegressivo t1, t2, t3;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1ª Contagem Regressiva..............: ");		
		c1 = scanner.nextLong();
		System.out.print("Pausa P/1ª Contagem Regressiva (S/N)? ");		
		resp = scanner.next().charAt(0);
		t1 = new ContadorRegressivo(c1, resp == 'S' || resp == 's' ? PAUSAT : 0);		
		
		System.out.print("2ª Contagem Regressiva..............: ");		
		c2 = scanner.nextLong();
		System.out.print("Pausa P/2ª Contagem Regressiva (S/N)? ");		
		resp = scanner.next().charAt(0);
		t2 = new ContadorRegressivo(c2, resp == 'S' || resp == 's' ? PAUSAT : 0);		

		System.out.print("3ª Contagem Regressiva..............: ");		
		c3 = scanner.nextLong();
		System.out.print("Pausa P/3ª Contagem Regressiva (S/N)? ");		
		resp = scanner.next().charAt(0);
		t3 = new ContadorRegressivo(c3, resp == 'S' || resp == 's' ? PAUSAT : 0);		
				
		t1.start();
		t2.start();
		t3.start();
		
		do {
			System.out.print("\nConsultar Contador Regressivo (1/2/3) ou Encerrar (F)? ");
			resp = scanner.next().charAt(0);
			
			switch(resp) {
				case '1': System.out.println("Contagem Atual de Contador 1 -> " + t1.getContagemAtual() + " " + (t1.isAlive() ? "(em atividade)" : "(encerrada)")); break;
				case '2': System.out.println("Contagem Atual de Contador 2 -> " + t2.getContagemAtual() + " " + (t2.isAlive() ? "(em atividade)" : "(encerrada)")); break;
				case '3': System.out.println("Contagem Atual de Contador 3 -> " + t3.getContagemAtual() + " " + (t3.isAlive() ? "(em atividade)" : "(encerrada)")); break;
			}
		} while (resp != 'F' && resp != 'f');
		
		scanner.close();	
	}

}
