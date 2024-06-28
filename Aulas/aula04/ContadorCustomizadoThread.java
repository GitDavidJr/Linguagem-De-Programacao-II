package Aulas.aula04;

public class ContadorCustomizadoThread extends Thread {
	
	private int pausa;		// pauta de contagem em segundos
	private int limite;		// limite de contagem
	private int contador;	// valor de contagem
	
	// construtor com inicialização de intervalo de pausa
	public ContadorCustomizadoThread(int pausa, int limite) {
		this.pausa = pausa;
		this.limite = limite;
		this.contador = 0;
	}
	
	// retorno de valor atual de contagem
	public int getContagemAtual() {
		return contador;
	}
	
	public void run() {
		// bloco de repetição de contagem
		for (contador = 0; contador < limite; contador++) {
			try {
				// suspensão planejada da thread
				sleep(pausa * 1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

}