import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Cartela implements Serializable{
    private String nome;
    private int pontos = 0;
    List<Integer> numerosDaCartela = new ArrayList<>(25);
    private int qtd = 0;
    Random r = new Random();

    public Cartela(String nome){
        this.nome = nome;
    }

    public String getJogador(){
        return nome;
    }

    public int getPontos(){
        return pontos;
    }

    public void setPontos(int pontos){
        this.pontos = pontos;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public List getNumeros(){
        return numerosDaCartela;
    }

    public List gerarNumerosDaCartela(){
        do {
            var rnd = r.nextInt(1, 100);
            if (!numerosDaCartela.contains(rnd)) {
                numerosDaCartela.add(rnd);
            }
        } while (numerosDaCartela.size() < 25);
        return this.numerosDaCartela;
    }

    public boolean contemNumero(int numero){
        return numerosDaCartela.contains(numero);
    }

    public String imprimir() {
        String cart = "";
        for (int i = 0; i < numerosDaCartela.size(); i++) {
            if (numerosDaCartela.get(i) < 10) {
                cart += "0" + numerosDaCartela.get(i) + " | ";
            } else {
                cart += numerosDaCartela.get(i) + " | ";
            }
            if ((i+1) % 5 == 0){
                cart += "\n";
            }
        }
        //println(cart)
        return cart;
    }

}
