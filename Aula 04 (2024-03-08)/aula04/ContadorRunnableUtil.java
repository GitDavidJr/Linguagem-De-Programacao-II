package lingprog2.aula04;

public class ContadorRunnableUtil {

	public static void main(String[] args) {
		ContadorRunnable c1 = new ContadorRunnable(10);
		ContadorRunnable c2 = new ContadorRunnable(50);
		
		Thread t1 = new Thread(c1); 
		Thread t2 = new Thread(c2); 
		
		t1.start();
		t2.start();
	}

}
