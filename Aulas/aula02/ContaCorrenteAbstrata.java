package Aulas.aula02;
public abstract class ContaCorrenteAbstrata {

	protected double saldo;			// saldo corrente da conta
	
	// obtenção de saldo corrente da conta
	public double getSaldo() {
		return saldo;
	}
	
	// operação de depósito com consequente atualização de saldo corrente da conta
	public abstract boolean registrarDeposito(double valor);

	// operação de saque com consequente atualização de saldo corrente da conta
	public abstract boolean registrarSaque(double valor);	
	
}