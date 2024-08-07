package Q1;
import java.util.random.RandomGenerator;
public class CoberturaVacinal extends Thread{
    RandomGenerator r;

    private String municipio, estado;
    private int habitantes, habitantesImunizados;

    public CoberturaVacinal(String municipio, String estado, int habitantes) throws Exception /*implementação da Q3*/{
        if(municipio == null){
            throw new Exception("Campo vazio, insira um nome!");
        }else this.municipio = municipio;

        if(estado == null){
            throw new Exception("Campo vazio, insira uma Sigla!");
        }else this.estado = estado;

        if(habitantes < 1){
            throw new Exception("Valor invalido, insira um numero maior que 0!");
        }else this.habitantes = habitantes;
        
        habitantesImunizados = 0;
    }

    //Q4
    public void run(){
        do{
            Double porcentagem = r.nextDouble(100.00);
            habitantesImunizados += habitantes*(porcentagem/100);
            try {
                sleep(5000);
            } catch (Exception e) {
            }
        } while (habitantes > habitantesImunizados);
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getEstado() {
        return estado;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public int getHabitantesImunizados(){
        return habitantesImunizados;
    }

    public void atualizarCobertura(int qnt) throws Exception/*implementação da Q3*/{
        if(qnt < 1){
            throw new Exception("Valor invalido, insira um numero maior que 0!");
        } else habitantesImunizados += qnt;     
    }

    public int getHabitatesSemCobertura() {
        return habitantes - habitantesImunizados;
    }

    public Double getPercentualCobertura(){
        
        return (((double)habitantesImunizados*100)/habitantes);
    }



}