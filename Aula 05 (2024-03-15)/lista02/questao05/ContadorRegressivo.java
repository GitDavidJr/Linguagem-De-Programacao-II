package lingprog2.lista02.questao05;

import java.time.LocalTime;

public class ContadorRegressivo extends Thread {

	private long contagemInicial;
	private long contagemAtual;
	private LocalTime horarioTermino;
	private int intervaloPausa;
	
	public ContadorRegressivo(long contagemInicial, int intervaloPausa) {
		this.contagemInicial = contagemInicial;
		this.intervaloPausa = intervaloPausa;
	}

	public long getContagemAtual() {
		return contagemAtual;
	}

	public LocalTime getHorarioTermino() {
		return horarioTermino;
	}

	public void run() {
		contagemAtual = contagemInicial;
		
		while (contagemAtual > 0) {			
			contagemAtual--;
			
			if (intervaloPausa > 0) {
				try {
					sleep(intervaloPausa);					
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		horarioTermino = LocalTime.now();
	}

}
