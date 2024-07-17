import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class ListaContatos{
    
    final static int tamanho = 10;
    final static List<Contato> contatos = new ArrayList<Contato>(tamanho);
    final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("         | LISTA DE CONTATOS |");

        int option = 0;

        do{

            options();
            System.out.print("Insira a ação desejada: ");
            option = s.nextInt();
            s.nextLine();

            switch (option) {

                case 1: inserir(); break;
                case 2: listagemAno(); break;    
                    
            }
        } while(option != 3);

        s.close();
    }

    public static void options(){
        System.out.println("**************************************");
        System.out.println("* 1 - Inserir                        *");
        System.out.println("* 2 - Listagem de contatos por ano   *");
        System.out.println("* 3 - Encerrar programa              *");
        System.out.println("**************************************");
    }

    public static void inserir(){

        String nome;
        Long numero;
        int dia;
        int mes;
        int ano;

        
        System.out.print("Insira o nome: ");
        nome = s.nextLine();
        System.out.print("Insira o numero: ");
        numero = s.nextLong();
        System.out.println("Insira a data de nascimento");
        System.out.print("Dia: ");
        dia = s.nextInt();
        System.out.print("Mês: ");
        mes = s.nextInt();
        System.out.print("Ano: ");
        ano = s.nextInt();
        s.nextLine();

        contatos.add(new Contato(nome, numero, new GregorianCalendar(ano,(mes-1),dia)));

    }

    public static void listagemAno(){

        Iterator<Contato> it = contatos.iterator();
        int rep = 1;
        int ano = 0;
        System.out.print("Insira o ano: ");
        ano = s.nextInt();

        System.out.println("Lista contatos de pessoas nascidas no ano de " + ano);
        while (it.hasNext()) {
            Contato contatoAux = it.next();
            if(contatoAux.getDataNascimento().get(GregorianCalendar.YEAR) == ano){
                System.out.println(rep + "° "+contatoAux);
            }
        }

    }
}