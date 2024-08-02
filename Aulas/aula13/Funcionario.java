package Aulas.aula13;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class Funcionario {
   
   private String nome;
   private double salario;
   private GregorianCalendar dataAdmissao;
   public Funcionario(String n, double s, int anoAdmissao, int mesAdmissao, int diaAdmissao) {
      nome = n;
      salario = s;
      dataAdmissao = new GregorianCalendar(anoAdmissao, mesAdmissao - 1, diaAdmissao);
   }
   
   public String getNome() {
      return nome;
   }

   public double getSalario() {
    return salario;
}
 
 public GregorianCalendar getDataAdmissao() {
    return dataAdmissao;
 }
 public void reajustarSalario(double percentual) {   // reajuste de salário com base em percentual
    if (percentual > 0) {                            // se percentual de reajuste válido...
       double reajuste = salario * percentual / 100; // cálculo de reajuste
       salario += reajuste;                          // incorporação de reajuste ao salário (atualização)
    }
 }
 public String toString() {
    return "[Nome: " + nome + "," + 
           " Salário: " + salario + "," + 
           " Admissão: " + new SimpleDateFormat("dd/MM/yyyy").format(dataAdmissao.getTime()) + "]";
 }
       
}
