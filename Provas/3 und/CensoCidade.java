import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CensoCidade implements Serializable {

    private String nome;
    private int codigo;
    private String siglaEstado;
    private int habitantes2010;
    private int habitantes2022;

    public CensoCidade(String nome, int codigo, String siglaEstado, int habitantes2010, int habitantes2022){
        super();
        this.nome = nome;
        this.codigo = codigo;
        this.siglaEstado = siglaEstado;
        this.habitantes2010 = habitantes2010;
        this.habitantes2022 = habitantes2022;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public int getHabitantes2010() {
        return habitantes2010;
    }

    public void setHabitantes2010(int habitantes2010) {
        this.habitantes2010 = habitantes2010;
    }

    public int getHabitantes2022() {
        return habitantes2022;
    }

    public void setHabitantes2022(int habitantes2022) {
        this.habitantes2022 = habitantes2022;
    }

    public boolean isAumentoPopulacinal(){
        return habitantes2010 < habitantes2022;
    }

    public double getPercentualAumentoReducao(){
        
        double aumentoRedecao = habitantes2022 - habitantes2010;

        return aumentoRedecao/habitantes2010 * 100;
    }

    public List<Integer> previsao10(){
        List<Integer> privisoes = new ArrayList<>(10);

        int populacaoAux = habitantes2022;

        for(int i = 0; i < 10; i++){
            populacaoAux += populacaoAux*(getPercentualAumentoReducao()/100);

            privisoes.add(populacaoAux);
        }

        return privisoes;
     }
}