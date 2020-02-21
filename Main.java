import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while ((str = reader.readLine()) != null) {
                    System.out.println(str);
            }
        } catch (IOException io) {
                io.printStackTrace();
        }  
    }
}