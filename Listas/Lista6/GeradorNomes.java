package Listas.Lista6;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeradorNomes {

    
    public static void main(String[] args) {

        String[] pessoas = new String[10];

        for(int i = 0; i < 10;i++){
            pessoas[i] = novaPessoa();
        }

        sort(pessoas);


        escrever(new ArrayList<>(Arrays.asList(pessoas)));



    }

    public static List<String> ler(String caminho){

        List<String> lista = new ArrayList<>();
        try {
            
            Scanner fluxo = new Scanner(new FileReader(caminho));

            while (fluxo.hasNext()) {
                lista.add(fluxo.next());
            }

            fluxo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static String randomizarArray(List<String> lista){

        Random gerador = new Random();                

        int n = gerador.nextInt(lista.size());

        Iterator<String> it = lista.iterator();

        for(int i = 0; i < n;i++){
            it.next();
        }

        return it.next();
    }

    public static int idadeAleatoria(){
        Random gerador = new Random();
        return gerador.nextInt(100);
    }

    public static void escrever(ArrayList<String> lista){

        try {
            
            PrintWriter fluxo = new PrintWriter(new FileWriter("nomesCompletos.txt"));

            Iterator<String> it = lista.iterator();

            while (it.hasNext()) {
                fluxo.println(it.next());
            }

            fluxo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sort(String[] pessoas){

        // ordenação por inserção dos nomes
        for (int i = 1; i < pessoas.length; i++) {
            String pessoaTemp = pessoas[i];         // enésimo nome

            int j = i - 1;                      // índice de nome anterior ao enésimo nome em comparação

            /* realocação de nomes anteriores para índices imediatamente subsequentes até que seja encontrado nome em ordem alfabética anterior ao enésimo nome */
            while (j >= 0 && pessoas[j].compareTo(pessoaTemp) > 0) {
                pessoas[j + 1] = pessoas[j];
                j--;
            }
    
            /* atribuição de enésimo nome em índice de acordo com sua posição em relação aos nomes anteriores comparados */
            pessoas[j + 1] = pessoaTemp;
        }

    }

    public static String novaPessoa(){
        return (randomizarArray(ler("nomes.txt")) + " " + randomizarArray(ler("sobrenomes.txt")) + "," + idadeAleatoria());
    }
}
