package Aulas.aula13;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeituraListaObjetos {
    
    public static void main(String[] args) {

        
        
        try {
            ObjectInputStream fluxo = new ObjectInputStream(new FileInputStream("quadro-funcionarios2.obj"));

            @SuppressWarnings("unchecked")
            List<Funcionario> quadroFunc = (ArrayList<Funcionario>)fluxo.readObject();

            Iterator<Funcionario> it = quadroFunc.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }
            

            fluxo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
}
