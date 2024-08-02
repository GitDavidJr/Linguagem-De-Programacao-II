import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CadernetaPoupancaUtil {

    final static List<CadernetaPoupanca> cadernetas = new ArrayList<CadernetaPoupanca>(7);
    final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        

        boolean encerrar = true;

        while (encerrar) {
    
            int optionSelect = option();
            
            switch (optionSelect) {
                case 1: inserir(); break;
                case 2: atualizacaoRendimento(); break;
                case 3: listagemAniversario(); break;
                case 4: listagemTitular(); break;
                case 5: encerrar(encerrar); break;
            
            }
        }
        
        s.close();
    }

    public static int option(){
        int option = 0;
        System.out.println("                  |Poupança|                 ");
        System.out.println("*********************************************");
        System.out.println("* 1 - Inserir caderneta                     *");
        System.out.println("* 2 - Atualização de rendimento             *");
        System.out.println("* 3 - Listagem de caderneta por aniversario *");
        System.out.println("* 4 - Listagem de cadernetas por titular    *");
        System.out.println("* 5 - Encerrar programa                     *");
        System.out.println("*********************************************");
        System.out.print("* Selecione uma opção: ");

        boolean valido = true;

        while (valido) {
            try{
                option = s.nextInt();
                valido = false;
            }catch(InputMismatchException e){
                System.out.println("* Valor invalido!");
            }
        }
        s.nextLine();

        return option;
    }

    public static void inserir(){
        
        String titular;
        Integer diaAniversario = null;
        Double depositoInicial = null;

        System.out.print("* Insira o nome do titular: ");
        titular = s.nextLine();
        System.out.print("* Insira o dia de deposito: ");
        boolean valido = true;
        while (valido) {
            try{
                diaAniversario = s.nextInt();
                valido = false;
            }catch(InputMismatchException e){
                System.out.println("* Valor invalido!");
            }
        }
        System.out.print("* Insira o valor depositado: ");
        valido = true;
        while (valido) {
            try{
                depositoInicial = s.nextDouble();
                valido = false;
            }catch(InputMismatchException e){
                System.out.println("* Valor invalido!");
            }
        }
        s.nextLine();

        cadernetas.add(new CadernetaPoupanca(titular, diaAniversario, depositoInicial));
    }

    public static void listagemAniversario(){

        Integer aniversario = null;

        System.out.print("* Insira uma dia de aniversario: ");
        boolean valido = true;
        while (valido) {
            try{
                aniversario = s.nextInt();
                valido = false;
            }catch(InputMismatchException e){
                System.out.println("* Valor invalido!");
            }
        }
        s.nextLine();

        Iterator<CadernetaPoupanca> it = cadernetas.iterator();

        while (it.hasNext()) {
            CadernetaPoupanca cadernetaAux = it.next();

            if(cadernetaAux.getDiaAniversario() == aniversario){
                boolean first = true;
                if (first) {
                    System.out.println("         |Cadernetas do aniversario dia: "+ aniversario +"|");
                    first = false;
                }
                System.out.println("* Titular: "+ cadernetaAux.getTitular() + "\n* Saldo: " +cadernetaAux.getSaldo());
            }
        }
    }

    public static void listagemTitular(){

        String titular = null;

        System.out.print("* Insira o nome do titular: ");
        titular = s.nextLine();

        Iterator<CadernetaPoupanca> it = cadernetas.iterator();

        int count = 1;

        while (it.hasNext()) {
            CadernetaPoupanca cadernetaAux = it.next();

            if(cadernetaAux.getTitular().equalsIgnoreCase(titular)){
                System.out.println("* Cartela: " + count);
                count++;
                System.out.println("* Deposito inicial: " + cadernetaAux.getDepositoInicial() + "\n* Aniversario: " + cadernetaAux.getDiaAniversario() + "\n* Saldo: " + cadernetaAux.getSaldo() +"\n");
            }
        }
    }

    public static void atualizacaoRendimento(){
        
        String titular = null;
        Double taxaRendimento = null;

        System.out.print("* Insira o nome do titular: ");
        titular = s.nextLine();
        
        boolean valido = true;
        while (valido) {
            try{
                System.out.print("* Insira taxa de rendimento: ");
                taxaRendimento = s.nextDouble();
                valido = false;
            }catch(InputMismatchException e){
                System.out.println("* Valor invalido!");
            }
        }
        s.nextLine();

        Iterator<CadernetaPoupanca> it = cadernetas.iterator();

        int indice = 0;
        int cont = 1;

        while (it.hasNext()) {
            CadernetaPoupanca cadernetaAux = it.next();

            if(cadernetaAux.getTitular().equalsIgnoreCase(titular)){
                System.out.println("              |"+ cont +"° Cartela de "+ titular +"|");
                System.out.println("* Saldo da cartela antes da atualização: " + cadernetaAux.getSaldo());
                cadernetas.get(indice).atualizarRendimento(taxaRendimento);
                System.out.println("* Saldo da cartela depois da atualização: " + cadernetaAux.getSaldo());
                cont++;
            }
            indice++;
        }
    }

    public static void encerramentoAniversario(){

        Set<Integer> aniversarios = new HashSet<>(31);
        Iterator<CadernetaPoupanca> it = cadernetas.iterator();
        CadernetaPoupanca cadernetaAux = null;

        while (it.hasNext()) {
            cadernetaAux = it.next();
            if (!aniversarios.contains(cadernetaAux.getDiaAniversario())){
                aniversarios.add(cadernetaAux.getDiaAniversario());
            }
        }

        System.out.println("* Diferentes dias de aniversarios: " + aniversarios.size());   
    }

    public static void encerramentoTitular(){

        Queue<String> nomes = new ArrayDeque<>(7);

        Iterator<CadernetaPoupanca> it = cadernetas.iterator();

        while (it.hasNext()) {
            nomes.add(it.next().getTitular());
        }

        Iterator<String> itN = nomes.iterator();

        System.out.println("       |Titulares cadastrados|");
        System.out.println();
        while (itN.hasNext()) {
            System.out.println("* " + nomes.remove());
        }
    }

    public static void encerrar(boolean encerramento){
        encerramentoAniversario();
        encerramentoTitular();
        encerramento = false;
    }
}
