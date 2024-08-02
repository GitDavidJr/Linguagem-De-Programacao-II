package Listas.Lista6;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LerPessoas {
    
    public static void main(String[] args) {
        
        try {
            
            ObjectInputStream fluxo = new ObjectInputStream(new FileInputStream("pessoas.obj"));

            @SuppressWarnings("unchecked")
            List<Pessoa> pessoas = (ArrayList<Pessoa>)fluxo.readObject();

            fluxo.close();

            Iterator<Pessoa> it = pessoas.iterator();

            Double soma = 0.0;
            int qnt = 0;

            while (it.hasNext()) {
                int idade = ((Pessoa)it.next()).getIdade();
                qnt++;
                System.out.println("Idade da "+ qnt +"° pessoa: " + idade);
                soma += idade;
            }
            System.out.println("\nMedia das idades: " + (soma/qnt));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
