package Q2;
import Q1.CoberturaVacinal;
import java.util.Scanner;

public class CoberturaVacinalUtil {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Controle de cidades
        int qntCidades = 2;

        //Array CoberturaVacinal
        CoberturaVacinal[] coberturaVacinal = new CoberturaVacinal[qntCidades];
        int qntRegistrados = 0;

        //variaveis do usuario
        String municipio, estado;
        int habitantes, option=0;

        //Adicionar Cidades
        for(int i = 0;i<qntCidades;i++){
            
            System.out.print("Insira nome do municipio: ");
            municipio = s.nextLine();
            System.out.print("Insira a sigla do estado: ");
            estado = s.nextLine();
            System.out.print("Insira quantidade de habitantes: ");
            habitantes = s.nextInt();
            s.nextLine();
            //implementação da Q3
            try{
            coberturaVacinal[qntRegistrados] = new CoberturaVacinal(municipio, estado, habitantes);
            qntRegistrados++;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        do{
        System.out.println("--------------------------------------------");
        System.out.println("1 - Atualizar vacinações");
        System.out.println("2 - Listagem de municipio por estado");
        System.out.println("3 - Listagem municipio manior porcentagem");
        System.out.println("4 - Listagem municipio menor porcentagem");
        System.out.println("5 - Encerrar programa");
        System.out.println("--------------------------------------------");
        System.out.println("Selecione uma opção: ");
        option = s.nextInt();
        s.nextLine();

        switch (option) {

            case 1:
        //Atualizar vacinações
        System.out.print("Insira a cidade: ");
        municipio = s.nextLine();
        boolean validoM = false;
        boolean validoE = false;
        for(int i = 0; i < qntRegistrados;i++){
            if(coberturaVacinal[i].getMunicipio().equals(municipio)){

                validoM = true;

                System.out.print("Insira a sigla do estado: ");
                estado = s.nextLine();
                if(coberturaVacinal[i].getEstado().equals(estado)){

                    validoE = true;

                    System.out.println("---------------");
                    System.out.println("População " +coberturaVacinal[i].getMunicipio() + "(" + coberturaVacinal[i].getEstado() + "): " + coberturaVacinal[i].getHabitantes());
                    System.out.println("População vacinada " +coberturaVacinal[i].getMunicipio() + "(" + coberturaVacinal[i].getEstado() + "): " + coberturaVacinal[i].getHabitantesImunizados());
                    System.out.println("---------------");
                    System.out.println();

                    System.out.print("Insira a quantidade de habitantes vacinados: ");
                    habitantes = s.nextInt();
                    s.nextLine();

                    //implementação da Q3
                    try{
                    coberturaVacinal[i].atualizarCobertura(habitantes);

                    System.out.println();
                    System.out.println("Cobertura atualizada");
                    System.out.println();

                    System.out.println("---------------");
                    System.out.println("População " +coberturaVacinal[i].getMunicipio() + "(" + coberturaVacinal[i].getEstado() + "): " + coberturaVacinal[i].getHabitantes());
                    System.out.println("População vacinada " +coberturaVacinal[i].getMunicipio() + "(" + coberturaVacinal[i].getEstado() + "): " + coberturaVacinal[i].getHabitantesImunizados());
                    System.out.println("---------------");
                    System.out.println();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }                
        }
        if(!validoM)System.out.println("Municipio invalido!");
        if(validoM && !validoE)System.out.println("Estado invalido!");
            break;

            case 2:
        //Listagem de municipios por estado
        System.out.println("Insira a sigla do estado: ");
        estado = s.nextLine();
        for(int i = 0; i <qntRegistrados; i++){
            System.out.println("---------------");
            if(coberturaVacinal[i].getEstado().equals(estado)){
            System.out.println(coberturaVacinal[i].getMunicipio() + "(" + coberturaVacinal[i].getEstado() + ") " + coberturaVacinal[i].getPercentualCobertura() + "% de cobertura vacianal."); 
            }
            System.out.println("---------------");
        }
            break;
        
            case 3:
        //Listagem municipio maior porcentagem
        int maior = 0;
        for(int i = 0;i<qntRegistrados;i++){
            if(coberturaVacinal[i].getPercentualCobertura() > coberturaVacinal[maior].getPercentualCobertura()){
                maior = i;
            }
        }
        System.out.println("---------------");
        System.out.println("Cidade com maior taxa de cobertura vacinal : " + coberturaVacinal[maior].getMunicipio() + "(" + coberturaVacinal[maior].getEstado() + ") " + coberturaVacinal[maior].getPercentualCobertura() + "%");
        System.out.println("---------------");
            break;

            case 4:
        //Listagem municipio menor porcentagem
        int menor = 0;
        for(int i = 0;i<qntRegistrados;i++){
            if(coberturaVacinal[i].getPercentualCobertura() < coberturaVacinal[menor].getPercentualCobertura()){
                menor = i;
            }
        }
        System.out.println("---------------");
        System.out.println("Cidade com menor taxa de cobertura vacinal : " + coberturaVacinal[menor].getMunicipio() + "(" + coberturaVacinal[menor].getEstado() + ") " + coberturaVacinal[menor].getPercentualCobertura() + "%");
        System.out.println("---------------");
            break;

            case 5:
            System.out.println("Programa encerrado!");
            break;

            default:
            System.out.println("Opção invalida!");
            break;

        }
    }while(option != 5);
    }
}
