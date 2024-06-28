package Aulas.aula02;
public interface ContaCorrenteInterface {

	// operação de depósito com consequente atualização de saldo corrente da conta
	public boolean registrarDeposito(double valor);

	// operação de saque com consequente atualização de saldo corrente da conta
	public boolean registrarSaque(double valor);	
	
}