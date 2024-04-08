package lingprog2.aula04;

public class ContadorThread extends Thread {
	
	// pauta de contagem em segundos
	private int pausa;

	// construtor com inicialização de intervalo de pausa
	public ContadorThread(int pausa) {
		this.pausa = pausa;
	}
	
	public void run() {
		// bloco de repetição de contagem
		for (int i = 0; i < 5; i++) {
			try {
				// listagem de valor atual de contagem
				System.out.println("Contagem Atual de " + getName() + ": " + i);
				// suspensão planejada da thread
				sleep(pausa * 1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

}