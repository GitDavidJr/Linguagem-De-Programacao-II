package lingprog2.aula04;

public class ContadorThreadUtil {

	public static void main(String[] args) {
		ContadorThread c1 = new ContadorThread(10);
		ContadorThread c2 = new ContadorThread(50);
		
		c1.start();
		c2.start();
	}

}
