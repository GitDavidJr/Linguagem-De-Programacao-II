import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        String nome = "";

        nome = s.nextLine();
        System.out.println(nome.equalsIgnoreCase(""));

        s.close();
    }
}
