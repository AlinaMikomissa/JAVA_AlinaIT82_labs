import java.io.FileNotFoundException;
public class Program {


    public static void main(String[] args) throws FileNotFoundException {
    SmallFinder small = new SmallFinder();
    small.FindTheShortestAndWrite("src/main/java/ReadFrom.txt", "src/main/java/WriteTo.txt");

    }
}


