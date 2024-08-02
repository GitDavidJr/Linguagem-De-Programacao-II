package Listas.Lista6;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MediaLeitura {

    public final static String caminho = "numerosMedias.txt";
    public final static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Insira o limite da media: ");
        int limine = s.nextInt();

        System.out.println("Media: " + mediaLtd(ler(), limine));

        s.close();
    }

    public static ArrayList<Double> ler(){

        ArrayList<Double> numeros = null;

        try {
            Scanner fluxo = new Scanner(new FileReader(caminho));

            numeros = new ArrayList<Double>();

            while (fluxo.hasNext()) {
                numeros.add(Double.parseDouble(fluxo.next()));
            }

            fluxo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return numeros;
    }

    public static Double media(ArrayList<Double> numeros){
        
        
        Double soma = 0.0;
        int qnt = 0;

        Iterator<Double> it = numeros.iterator();

        while (it.hasNext()) {
            soma += it.next();
            qnt++;
        }

        return soma/qnt;
    }

    public static Double mediaLtd(ArrayList<Double> numeros, int ltd){
        

        Double soma = 0.0;
        int qnt = 0;

        Iterator<Double> it = numeros.iterator();

        
        for(int i = 0; i < ltd; i++){
            try{
                System.out.println(qnt);
                soma += it.next();
                qnt++;
            }catch(Exception e){
                break;
            }
        }
        
        
        return soma/qnt;
    }
}
