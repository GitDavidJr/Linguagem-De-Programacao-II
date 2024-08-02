package Aulas.aula13;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistroListaObjetos {
    
    public static void main(String[] args) {
        try {

            ObjectOutputStream fluxo = new ObjectOutputStream(new FileOutputStream("quadro-funcionarios2.obj"));

            List<Funcionario> quadroFunc = new ArrayList<Funcionario>();

            quadroFunc.add(new Funcionario("David", 1200, 2024, 07, 20));
            quadroFunc.add(new Funcionario("Inacio", 1500, 2023, 02, 13));
            quadroFunc.add(new Funcionario("Ferreira", 2000, 2012, 12, 05));

            Gerente gerente = new Gerente("Silva", 5000, 2019, 9, 29);

            gerente.setBonus(1000);

            quadroFunc.add(gerente);


            fluxo.writeObject(quadroFunc);

            fluxo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
