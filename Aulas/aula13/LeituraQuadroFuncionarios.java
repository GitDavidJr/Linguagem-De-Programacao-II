package Aulas.aula13;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LeituraQuadroFuncionarios {
 
    public static void main(String[] args) {

        List<Funcionario> quadroFunc = new ArrayList<Funcionario>();

        try {
            Scanner fluxo = new Scanner(new FileReader("quadro-funcionarios.txt"));

            while (fluxo.hasNext()) {
                
                String[] tokens = fluxo.next().split("\\|");

                String nome = tokens[0];
                double salario = Double.parseDouble(tokens[1]);

                String[] tokensData = tokens[2].split("-");

                int dia = Integer.parseInt(tokensData[0]);
                int mes = Integer.parseInt(tokensData[1]);
                int ano = Integer.parseInt(tokensData[2]);

                quadroFunc.add(new Funcionario(nome, salario, ano, mes, dia));

            }

            fluxo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Iterator it = quadroFunc.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
