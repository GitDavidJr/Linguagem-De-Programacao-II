package Aulas.aula13;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class RegistroFuncionario {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      // entrada de nome e salário de funcionário
      System.out.println("Dados de Funcionário");
      System.out.print("Nome...: ");
      String nome = scanner.nextLine();
      System.out.print("Salário: ");
      double salario = scanner.nextDouble();
      
      try {
         FileWriter fluxoArquivo = new FileWriter("funcionario.txt", true);
         
         fluxoArquivo.write(nome + ' ' + salario + System.lineSeparator());
         
         fluxoArquivo.close();
         System.out.println("Gravação de dados em arquivo concluída!");
        }
        catch (IOException e) { 
           e.printStackTrace();
        }
        
        scanner.close();
     }
  }
