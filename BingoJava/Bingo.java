
import java.util.*;

public class Bingo{

    List<Cartela> cartelas = new ArrayList<>();
    private int tamanho;
    String vencedores = "";

    public Bingo(int tamanho){
        this.tamanho = tamanho;
    }

    //Recebe uma cartela e verifica se ela é igual a alguma outra cartela do array,
    // caso seja diferente, insere a cartela no final do array e retorna true,
    // caso contrario retorna false
    public void incluirCartela(Cartela cartela){
        if(cartelas.contains(cartela)){
            System.out.println("Ja existe essa cartela");
        } else {
            cartelas.add(cartela);
            System.out.println("Cartela adicionada com sucesso!");
        }
    }

    //Recebe o nome do jogador, localiza sua cartela e muda seu nome.
    // Caso o processo seja executado com sucesso retorna true,
    // caso contrario retorna false
    public boolean alterarJogador (String jogadorAntigo, String jogadorNovo){
        Iterator<Cartela> it = cartelas.iterator();
        boolean trocaDeNome = false;
        while(it.hasNext()){
            Cartela cartela = it.next();
            if(cartela.getJogador().equalsIgnoreCase(jogadorAntigo)){
                cartela.setNome(jogadorNovo);
                trocaDeNome = true;
                System.out.println("Nome alterado com sucesso!");
            }
        }
        return trocaDeNome;
    }

    //Recebe o nome do jogador e localiza sua cartela, caso consiga localizar
    // a cartela, ela é excluida.
    public void excluirCartela (String jogador ){
        Iterator<Cartela> it = cartelas.iterator();
        while(it.hasNext()){
            Cartela cartela = it.next();
            if(cartela.getJogador().equalsIgnoreCase(jogador)){
                it.remove();
            }
        }
    }

    //Cria um array de String com os nomes dos jogadores que possuem o numero
    // sorteado na cartela
    public void verificarJogadoresSorteio (int numeroSorteado){
        Iterator<Cartela> it = cartelas.iterator();
        while(it.hasNext()){
            Cartela cartela = it.next();
            if(cartela.getNumeros().contains(numeroSorteado))
                System.out.println(cartela.getJogador() + "\n");
        }
    }

    public Boolean verificarVencedores () {
        var temVencedores = false;
        Iterator<Cartela> it = cartelas.iterator();
        while(it.hasNext()){
            Cartela cartela = it.next();
            if(cartela.getPontos() == 25){
                temVencedores = true;
                vencedores += cartela.getJogador() + "\n";
            }
        }
        return temVencedores;
    }

    //retorna o array com nome dos jogadores e suas cartelas na ordem em que
    // foram inseridos
    public void consultarJogadores() {
        //for (Cartela cartela: cartelas) {
        for (int i = 0; i < cartelas.size(); i++) {
            System.out.println("Jogador " + (i + 1) + " = " + cartelas.get(i).getJogador() + "\n" + cartelas.get(i).imprimir());
        }
        //}
    }

    //numeros na ordem que foram sorteados
    public void consultarNumSorteados(SortearNumero sorteio){  //igual getNumerosSorteados
        System.out.println( "Numeros sorteados ate o momento: ");
        System.out.println(sorteio.getNumerosSorteados());
    }

    //numeros em ordem crescente
    public void consultarNumOrdemCrescente(SortearNumero sorteio){
        System.out.println("Numeros sorteados em ordem crescente: " );
        Collections.sort(sorteio.numerosSorteados);
        System.out.println(sorteio.numerosSorteados);
    }

    //ordena as cartelas em quantidade de numeros sorteados em ordem decrescente e
    // retorna o nome do jogador e a quantidade de numeros sorteados dele
    public void consultarQtdNumSorteados(){
        cartelas.sort(Comparator.comparing(Cartela::getPontos));
        cartelas.reversed();
        System.out.println("Ordem de jogadores em números sorteados:");
        for (Cartela cartela : cartelas) {
            System.out.println("Jogador " + cartela.getJogador() + ": " + cartela.getPontos() + " pontos até o " +
                    "momento");
        }
    }


    //retorna os numeros nao sorteados da cartela de cada jogador
    public void consultarNumNaoSorteados (SortearNumero sorteio){
        cartelas.sort(Comparator.comparing(Cartela::getPontos));
        cartelas.reversed();
        for (Cartela cartela: cartelas) {
            System.out.println(cartela.getJogador() + " possui " + ((25) - cartela.getPontos() +
                    " números não sorteados até o momento"));
        }
    }

    public void sortear(SortearNumero sorteio){
        sorteio.sortearNumero();
        Iterator<Cartela> it = cartelas.iterator();
        while (it.hasNext()){
            Cartela cartela = it.next();
            if(cartela.contemNumero(sorteio.getNumero())){
                cartela.setPontos(cartela.getPontos() + 1);
            }
        }
        if (verificarVencedores()) {
            System.out.println(vencedores);
        }
    }

}