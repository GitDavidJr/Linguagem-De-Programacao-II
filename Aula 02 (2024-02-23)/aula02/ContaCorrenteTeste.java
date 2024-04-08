package lingprog2.aula02;

public class ContaCorrenteTeste {

	public static void main(String[] args) {
		ContaCorrente c;
		c = new ContaCorrente();
		c.registrarDeposito(50);
		c.registrarSaque(50);
		System.out.print("Saldo: " + c.getSaldo());
	}

}
