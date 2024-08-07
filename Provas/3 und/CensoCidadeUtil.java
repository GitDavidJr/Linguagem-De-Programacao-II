import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CensoCidadeUtil {
    
    public static final int tamanho = 10;
    public static List<CensoCidade> censos = new ArrayList<CensoCidade>(tamanho);
    public static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
    
        importCensos();
        
        boolean finish = false;

        do {
            
            switch (options()) {

                case 1: cadastrarCidade(); break;
            
                case 2: listagemEstado(); break;

                case 3: percentualEstado(); break;

                case 0: finish = true; break;
            }
            
        } while (!finish);

        escreverPrev();

        exportCensos();

    }

    public static void escreverPrev(){
        try {
            
            Iterator<CensoCidade> it = censos.iterator();

            while (it.hasNext()) {
                CensoCidade censo = it.next();

                PrintWriter fluxo = new PrintWriter(new FileWriter(("previsao"+ censo.getNome() +".txt")));

                Iterator<Integer> itPrev = censo.previsao10().iterator();

                while (itPrev.hasNext()) {
                    fluxo.println(itPrev.next());
                }

                fluxo.close();

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarCidade(){
        System.out.print("Insira o nome da cidade: ");
        String nome = s.nextLine();
        System.out.print("Insira o codigo IBGE: ");
        int codigo = s.nextInt();
        s.nextLine();
        System.out.print("Insira a sigla do estado: ");
        String sigla = s.nextLine();
        System.out.print("Insira a quantidade de habitantes em 2010: ");
        int habitantes2010 = s.nextInt();
        System.out.print("Insira a quantidade de habitantes em 2022: ");
        int habitantes2022 = s.nextInt();

        censos.add(new CensoCidade(nome, codigo, sigla, habitantes2010, habitantes2022));
    }

    public static void listagemEstado(){
        System.out.print("Insira o estado desejado: ");
        String estado = s.nextLine();

        Iterator<CensoCidade> it = censos.iterator();

        int habitantesEstado = 0;

        while (it.hasNext()) {
            CensoCidade censoAux = it.next();
            if(censoAux.getSiglaEstado().equalsIgnoreCase(estado)){
                habitantesEstado += censoAux.getHabitantes2022();
            }
        }

        System.out.println("O estado " + estado + " possui " + habitantesEstado + " habitantes.");
    }

    public static void percentualEstado(){

        List<String> estados = new ArrayList<>(tamanho);
        int habitantesTotais = 0;
        
        Iterator<CensoCidade> it = censos.iterator();

        while (it.hasNext()) {
            CensoCidade censo = it.next();
            String estado = censo.getSiglaEstado();
            habitantesTotais += censo.getHabitantes2022(); 

            Iterator<String> it2 = estados.iterator();

            boolean repetido = false;

            while (it2.hasNext()) {
                String estado2 = it2.next();
                if(estado.equals(estado2)){
                    repetido = true;
                }
            }

            if(!repetido){
                estados.add(estado);
            }
        }

        System.out.println(estados);

        int[] habitantesEstado = new int[estados.size()];

        it = censos.iterator();

        while (it.hasNext()) {
            CensoCidade censo = it.next();

            Iterator<String> it2 = estados.iterator();

            int count = 0;
            while (it2.hasNext()) {
                String estado = it2.next();

                if (estado.equals(censo.getSiglaEstado())) {
                    habitantesEstado[count] += censo.getHabitantes2022();
                }

                count++;
            }
        }

        Iterator<String> it2 = estados.iterator();


        int count = 0;
        while (it2.hasNext()) {
            System.out.println(it2.next() +": " + ((habitantesEstado[count]*100)/habitantesTotais) + "%");
            count++;
        }

    }

    public static int options(){

        System.out.println("********************************************");
        System.out.println("*1 - Cadastrar cidade                      *");
        System.out.println("*2 - Habitaantes por estado                *");
        System.out.println("*3 - Porcentagens de habitantes por estado *");
        System.out.println("*0 - Encerrar programa                     *");
        System.out.println("********************************************");
        System.out.print("*Insira a opção desejada: ");
        int option = s.nextInt();
        s.nextLine();
        return option;
    }

    @SuppressWarnings("unchecked")
    public static void importCensos(){
        try {
            ObjectInputStream fluxo = new ObjectInputStream(new FileInputStream("censos.obj"));

            censos = (List<CensoCidade>)fluxo.readObject();

            fluxo.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void exportCensos(){
        try {
            ObjectOutputStream fluxo = new ObjectOutputStream(new FileOutputStream("censos.obj"));

            fluxo.writeObject(censos);

            fluxo.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
