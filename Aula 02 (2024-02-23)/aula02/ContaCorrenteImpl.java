package lingprog2.aula02;

public class ContaCorrenteImpl implements ContaCorrenteInterface {

	private double saldo;
	
	public double getSaldo() {
		return saldo;
	}

	// sobrescrita de operação de saque com consequente atualização de saldo corrente da conta
	public boolean registrarSaque(double valor) {
		if (valor <= 0)				// se valor a sacar não for positivo...
			return false;
		else {						// caso contrário...
			// cálculo de tarifa (0,1% do valor de saque)
			double tarifa = valor * 0.1 / 100;
			
			// verificação de saldo negativo após dedução de saque e tarifa
			if (saldo < valor + tarifa)
				return false;		// não efetivação, neste caso, de saque
			else {
				double saldo = 0;
				
				// atualização de saldo deduzindo-se saque e tarifa
				saldo -= (valor + tarifa);
				return true;				
			}
		}
	}
	
	// operação de depósito com consequente atualização de saldo corrente da conta
	public boolean registrarDeposito(double valor) {
		if (valor <= 0)				// se valor a depositar não for positivo...
			return false;			
		else {						// caso contrário...
			saldo += valor;			// atualização de saldo corrente
			return true;
		}
	}

}
