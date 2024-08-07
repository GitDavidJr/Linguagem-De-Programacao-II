import java.io.FileWriter;
import java.io.PrintWriter;

public class EscreverNumeros {
    public static void main(String[] args) {
        
        try {
            
            PrintWriter fluxo = new PrintWriter(new FileWriter("numeros.txt"));

            for(int i = 0; i < 1000; i++){
                fluxo.println(i);
            }

            fluxo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
