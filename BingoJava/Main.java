/*
 * Alunos:
 * David Inácio
 * João Vitor Lemos
 * Julia
 * Rebeca
 * Luisa
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Cartela> cartelas = new ArrayList<>();
    public static Bingo bingo = new Bingo(6);
    public static SortearNumero sorteio = new SortearNumero();
    public static Scanner scanner = new Scanner(System.in); 
    public static void main(String[] args) {
       
        int op;

        do {
            menu();
            op = scanner.nextInt();
            scanner.nextLine(); 

            switch (op) {
                case 1:
                System.out.print("Digite o nome da cartela:");
                String nomeCartela = scanner.nextLine();
                Cartela novaCartela = new Cartela(nomeCartela);
                novaCartela.gerarNumerosDaCartela(); 
                bingo.incluirCartela(novaCartela); 
                break;
                case 2:
                    sorteio.sortearNumero();
                    System.out.println("Número sorteado: " + sorteio.getNumero());
                    bingo.sortear(sorteio); 
                    break;
                case 3:
                    bingo.consultarJogadores();
                    break;
                case 4:
                    bingo.consultarNumSorteados(sorteio);
                    break;
                case 5:
                    bingo.consultarNumNaoSorteados(sorteio);
                    break;
                case 6:
                    bingo.consultarNumOrdemCrescente(sorteio);
                    break;
                case 7:
                    bingo.consultarQtdNumSorteados();
                    break;
                case 8:
                    System.out.println("Digite o nome da cartela a ser excluída:");
                    String nomeExcluir = scanner.nextLine();
                    bingo.excluirCartela(nomeExcluir);
                    System.out.println("Cartela excluída.");
                    break;

                case 9:
                    importarNumSorteados();
                    importarCartelas();
                    System.out.println("Jogo Anterios carregado!");
                    System.out.println("Jogadores carregador: ");
                    bingo.consultarJogadores();
                    System.out.println();
                    System.out.println("Numeros sorteados: ");
                    bingo.consultarNumSorteados(sorteio);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (op != 0);

        exportarCartelas();
        exportarNumSorteados();

        scanner.close();
    }

    public static void menu() {
        System.out.println("-------------------- MENU --------------------");
        System.out.println("1. Criar nova cartela");
        System.out.println("2. Sortear um novo número");
        System.out.println("3. Listar jogadores e suas cartelas");
        System.out.println("4. Consultar números sorteados");
        System.out.println("5. Consultar números não sorteados");
        System.out.println("6. Consultar números em ordem crescente");
        System.out.println("7. Consultar quantidade de números sorteados");
        System.out.println("8. Excluir cartela");
        System.out.println("9. Continuar jogo anterior");
        System.out.println("0. sair");
        System.out.println("----------------------------------------------");
        System.out.print("Escolha uma opção: ");
    }

    public static void exportarCartelas(){

        try {
            ObjectOutputStream  fluxo = new ObjectOutputStream(new FileOutputStream("Cartelas.obj"));

            fluxo.writeObject(bingo.cartelas);

            fluxo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static void importarCartelas(){

        try {
            ObjectInputStream fluxo = new ObjectInputStream(new FileInputStream("Cartelas.obj"));

            bingo.cartelas = (List<Cartela>)fluxo.readObject();

            fluxo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void exportarNumSorteados(){

        try {
            ObjectOutputStream  fluxo = new ObjectOutputStream(new FileOutputStream("Sorteio.obj"));

            fluxo.writeObject(sorteio.numerosSorteados);

            fluxo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static void importarNumSorteados(){

        try {
            ObjectInputStream fluxo = new ObjectInputStream(new FileInputStream("Sorteio.obj"));

            sorteio.numerosSorteados = (List<Integer>)fluxo.readObject();

            fluxo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
