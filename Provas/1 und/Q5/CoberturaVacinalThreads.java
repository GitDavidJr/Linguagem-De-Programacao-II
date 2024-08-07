package Q5;

import java.util.Scanner;

import Q1.CoberturaVacinal;

class CoberturaVacinalThreads {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Controle de cidades
        int qntCidades = 5;

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

            for(int q = 0; q < 5; q++){
                coberturaVacinal[q].start();
            }

            do{
        System.out.println("2 - Encerrar programa");
        System.out.print("Insira nome da cidade:");
        option = s.nextInt();
        for(int q = 0; q<5;q++ ){
            if (coberturaVacinal[q].getMunicipio()==municipio) {
                    System.out.println("---------------");
                    System.out.println("População " +coberturaVacinal[q].getMunicipio() + "(" + coberturaVacinal[q].getEstado() + "): " + coberturaVacinal[q].getHabitantes());
                    System.out.println("População vacinada " +coberturaVacinal[q].getMunicipio() + "(" + coberturaVacinal[q].getEstado() + "): " + coberturaVacinal[q].getHabitantesImunizados());
                    System.out.println("---------------");
                    System.out.println();
            }
        }

            }while(option != 2);
        }
    }
    
}