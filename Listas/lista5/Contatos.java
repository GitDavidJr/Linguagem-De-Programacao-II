/*  
a)   inserção   de   novo   contato   telefônico;   
b)   listagem   de   contatos   telefônicos   de determinado país considerando-se código telefônico daquele país a ser fornecido pelo usuário; 
c) listagem de percentuais de contatos telefônicos por categoria; 
d) encerramento do programa. 
Observação: quando da inserção de novo contato telefônico, certifique-se da impossibilidade de estarem inseridos na lista 2 (dois) ou mais contatos com mesmo nome, sobrenome, código de país e número telefônico.zz */

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Contatos {
    
    final static List<ContatoTelefonico> contatos = new LinkedList<ContatoTelefonico>();
    final static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        
    }

    public static void option(){
        System.out.println("**********************************************");
        System.out.println("* 1 - Inserir contato                        *");
        System.out.println("* 2 - Lista de contatos por país             *");
        System.out.println("* 3 - Distribuição de contatos por categoria *");
        System.out.println("* 4 - Encerrar programa                      *");
        System.out.println("**********************************************");
    }

    public static void inserir(){
        
        String nome;         // primeiro nome
        String sobrenome;    // sobrenome
        String email;        // endereço de e-mail
        int codigoPais = 0;      // código telefônico de país
        String telefone;     // número telefônico
        int categoria = 0;       // categoria (familiar, profissional ou outros)

        boolean entradaDado = true;

        System.out.print("* Insira o nome: ");
        nome = s.nextLine();
        System.out.print("* Insira o sobrenome: ");
        sobrenome = s.nextLine();
        System.out.print("* Insira o Email: ");
        email = s.nextLine();
        System.out.print("* Código telefônico de país: ");
        while (entradaDado) {
            try {
                codigoPais = s.nextInt();
                entradaDado = false;
            } catch (InputMismatchException e) {
                System.out.println("Insira um numero valido!");
            }
        }
        System.out.print("* Insira o número telefônico: ");
        telefone = s.nextLine();
        System.out.print("* 0 - Familiar | 1 - Profissional | 2 - Outros * \n * Insira o numero da caretoria: ");
        while (entradaDado) {
            try {
                categoria = s.nextInt();
                if(categoria < 0 || categoria > 2){
                    throw new Exception("Insira um numero valido!");
                }
                entradaDado = false;
            } catch (InputMismatchException e) {
                System.out.println("Insira um numero valido!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        s.nextLine();

        contatos.add(new ContatoTelefonico(nome, sobrenome, email, codigoPais, telefone, categoria));
    }

    public static void contatoPais(){

        boolean entradaDado = true;
        int codigoPais = 0;

        System.out.print("* Código telefônico de país: ");
        while (entradaDado) {
            try {
                codigoPais = s.nextInt();
                entradaDado = false;
            } catch (InputMismatchException e) {
                System.out.println("Insira um numero valido!");
            }
        }

        Iterator<ContatoTelefonico> it = contatos.iterator();

        List<ContatoTelefonico> contatosAux = new LinkedList<>();
        
        while(it.hasNext()){
            ContatoTelefonico cttAux = it.next();
            if(cttAux.getCodigoPais() == codigoPais){
                contatosAux.add(cttAux);
            }
        }

        it = contatosAux.iterator();

        while (it.hasNext()) {
            ContatoTelefonico cttAux = it.next();
            System.out.println(cttAux);
        }

    }

    public static void porcCategoria(){
        int familiar = 0;
        int profissional = 0;
        int outros = 0;

        Iterator<ContatoTelefonico> it = contatos.iterator();

        while (it.hasNext()) {
            ContatoTelefonico cttAux = it.next();
            if (cttAux.getCategoria() == 0) {
                familiar++;
            }
            if (cttAux.getCategoria() == 1) {
                profissional++;
            }
            if(cttAux.getCategoria() == 2){
                outros++;
            }
        }

        int total = familiar + profissional + outros;
        familiar = (100/total)*familiar;
        profissional = (100/total)*profissional;
        outros = (100/total)*outros;

        System.out.println("     |Contatos|     ");
        System.out.println("********************");
        System.out.println("* "+ familiar+"% Familiar     *");
        System.out.println("* "+ profissional+"% Profissional *");
        System.out.println("* "+ outros +"% Outross      *");
        System.out.println("********************");
    }

    
}
