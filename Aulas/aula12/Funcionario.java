package lingprog2.aula12;


public class Funcionario {

	private String nome;
	private int matricula;
	private double salario;

	public Funcionario(String n, int m, double s) {
		nome = n;
		matricula = m;
		salario = s;
	}
	
	public String getNome() {
		return nome;
	}
		
	public int getMatricula() {
		return matricula;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		if (salario > 0)								// verificação de novo salário (se positivo)
			this.salario = salario;						// atualização de salário
	}
	
	public void reajustarSalario(double percentual) {	// reajuste de salário com base em percentual
		double reajuste = salario * percentual / 100;	// cálculo de reajuste
		salario += reajuste;							// incorporação de reajuste ao salário (atualização)
	}
	
	public String toString() {
		return "Nome: " + nome + ", Matrícula: " + matricula + ", Salário: " + salario;
	}
	
}