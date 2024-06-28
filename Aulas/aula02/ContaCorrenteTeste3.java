package Aulas.aula02;
public class ContaCorrenteTeste3 {

	public static void main(String[] args) {
		ContaCorrenteImpl c;
		c = new ContaCorrenteImpl();
		c.registrarDeposito(100);
		c.registrarSaque(50);
		System.out.println(c.getSaldo());
	}

}
