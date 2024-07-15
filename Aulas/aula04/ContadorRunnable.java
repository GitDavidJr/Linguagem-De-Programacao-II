package Aulas.aula04;

public class ContadorRunnable implements Runnable {
	
	// pauta de contagem em segundos
	private int pausa;

	// construtor com inicialização de intervalo de pausa
	public ContadorRunnable(int pausa) {
		this.pausa = pausa;
	}
	
	public void run() {
		// bloco de repetição de contagem
		for (int i = 0; i < 5; i++) {
			try {
				Thread threadAtual = Thread.currentThread();
				// listagem de valor atual de contagem
				System.out.println("Contagem Atual de " + 
						threadAtual.getName() + ": " + i);
				// suspensão planejada da thread
				threadAtual.sleep(pausa * 1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

}