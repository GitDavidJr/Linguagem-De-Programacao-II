import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class PilhaLivros {

    final static Deque<Livro> livros = new ArrayDeque<Livro>(5);
    final static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
    
        int option = 0;

        do{

            boolean valido = true;

            while(valido){

                options();
                
                try{
                option = s.nextInt();
                valido = false;
                }catch(InputMismatchException e){
                    System.out.println("Opção invalida!");
                }

                s.nextLine();

                System.out.println();
            }

            switch (option) {
                case 1: inserir(); break;
                case 2: remover(); break;
                case 3: printPilha(); break;
                case 4: System.out.println("Programa encerrado!");
                default: System.out.println("Opção invalida!"); break;
           }
           

        }while(option != 4);

        s.close();
    }
    
    public static void options(){
        System.out.println("       | MEUS LIVROS |      ");
        System.out.println("****************************");
        System.out.println("* 1 - Inserir              *");
        System.out.println("* 2 - Remover              *");
        System.out.println("* 3 - Pilha de livros      *");
        System.out.println("* 4 - Encerrar progrograma *");
        System.out.println("****************************");
        System.out.print("Selecione a ação: ");
    }

    public static void inserir(){
        String titulo = ""; // título
        String autores = ""; // lista de autores separados por vírgula
        int edicao = 0; // número de edição (inteiro igual ou superior a 1)
        int ano = 0; // ano de edição (inteiro positivo de 4 dígitos)
        
        boolean valido = true;

        while (valido) {
            try{
                System.out.println("      | INSERIR LIVRO |     ");
                System.out.println("****************************");
                System.out.print("* Titulo: ");
                titulo = s.nextLine();
                System.out.print("* Autores: ");
                autores = s.nextLine();
                System.out.print("* Edição: ");
                edicao = s.nextInt();
                System.out.print("* Ano: ");
                ano = s.nextInt();
                s.nextLine();
                valido = false;
            }catch(InputMismatchException e){
                System.out.println("Digite um valor valido");
            }
        }

        Iterator<Livro> it = livros.iterator();

        int qnt = 0; 
        while (it.hasNext()) {
            it.next();
            qnt++;
        }

        
        if(qnt == 5){
            Deque<Livro> pilhaAux = new ArrayDeque<Livro>();
            pilhaAux.addLast(livros.removeLast());
            pilhaAux.addLast(livros.removeLast());
            livros.removeLast();
            livros.addLast(pilhaAux.pop());
            livros.addLast(pilhaAux.pop());
        }

        
        livros.addLast(new Livro(titulo, autores, edicao, ano));
    }

    public static void remover(){

        try{
            System.out.println(livros.removeLast() + " removido!");
        } catch(NoSuchElementException e){
            System.out.println("Pilha vazia!");
        }
    }

    public static void printPilha(){

        Iterator<Livro> it = livros.iterator();

        System.out.println("                         | MINHA PILHA |");

        int cont = 0;

        System.out.println("***************************************************************");
        while (it.hasNext()) {
            cont++;
            System.out.println("* " + cont+"° " + it.next() + " *"); 
        }
        System.out.println("***************************************************************");
    }
}
