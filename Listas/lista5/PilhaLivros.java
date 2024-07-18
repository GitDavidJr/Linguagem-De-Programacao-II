import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;


public class PilhaLivros {

    final static Deque<Livro> livros = new ArrayDeque<Livro>(5);
    final static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
    
        int option = 0;

        do{
           options();
           option = s.nextInt();
           s.nextLine();
           System.out.println();

           switch (option) {
            case 1: inserir(); break;
            case 2: remover(); break;
            case 3: printPilha(); break;
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
        String titulo; // título
        String autores; // lista de autores separados por vírgula
        int edicao; // número de edição (inteiro igual ou superior a 1)
        int ano; // ano de edição (inteiro positivo de 4 dígitos)
        
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

        Iterator<Livro> it = livros.iterator();

        int qnt = 0; 
        while (it.hasNext()) {
            it.next();
            qnt++;
        }

        
        if(qnt == 6){
            Deque<Livro> pilhaAux = new ArrayDeque<Livro>();
            pilhaAux.add(livros.pop());
            pilhaAux.add(livros.pop());
            livros.pop();
            livros.add(pilhaAux.pop());
            livros.add(pilhaAux.pop());
        }

        
        livros.add(new Livro(titulo, autores, edicao, ano));
    }

    public static void remover(){

        if(!livros.isEmpty()){
            System.out.println("Livro " + livros.pop() + " removido!");
        } else{
            System.out.println("Pilha vazia!");
        }
    }

    public static void printPilha(){
        System.out.println(livros);
    }
}
