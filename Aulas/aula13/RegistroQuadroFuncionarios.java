package Aulas.aula13;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class RegistroQuadroFuncionarios {
    

    public static void main(String[] args) {
        
        try {
        
            PrintWriter fluxo = new PrintWriter("quadro-funcionarios.txt");

            List<Funcionario> quadroFunc = new ArrayList<Funcionario>();

            quadroFunc.add(new Funcionario("David", 1200, 2024, 07, 20));
            quadroFunc.add(new Funcionario("Inacio", 1500, 2023, 02, 13));
            quadroFunc.add(new Funcionario("Ferreira", 2000, 2012, 12, 05));
    
            Iterator<Funcionario> it = quadroFunc.iterator();
    
            while (it.hasNext()) {
                
                Funcionario func = it.next();
    
                int diaAdmissao = func.getDataAdmissao().get(Calendar.DAY_OF_MONTH);
                int mesAdmissao = func.getDataAdmissao().get(Calendar.MONTH);
                int anoAdmissao = func.getDataAdmissao().get(Calendar.YEAR);
    
                fluxo.println(func.getNome() + "|" + func.getSalario() + "|" + diaAdmissao + "-" + mesAdmissao + "-" + anoAdmissao);
            }

            fluxo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Finalizado");
        
    }
}
