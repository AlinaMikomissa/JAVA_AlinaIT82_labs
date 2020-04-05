import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {


        public static void main(String[] args) throws IOException {
           Worker w = new Worker();
           w.Encrypt("src/main/java/Read.txt","src/main/java/Write.txt");
           w.printArray(w.ReadFromFileByLines("src/main/java/Write.txt"));
        }



}
