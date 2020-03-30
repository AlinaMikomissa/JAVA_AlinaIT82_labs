import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
String Read = "src/main/java/Read.txt";
String Write = "src/main/java/Write.txt";
    @Test
    void encrypt() throws IOException {
        Worker w = new Worker();
        w.ReWriteFile(Read, "Hello world! I want to see you!");
        w.Encrypt(Read, Write);
        ArrayList<String> actual = w.ReadFromFileByLines(Write);
        ArrayList<String> expected = new ArrayList<>(); expected.add("Khoor#zruog$#L#zdqw#wr#vhh#|rx$");
        Assert.assertEquals(expected, actual);
    }

    @Test
    void decrypt() throws IOException {
        Worker w = new Worker();
        w.ReWriteFile(Read, "Khoor#zruog$#L#zdqw#wr#vhh#|rx$");
        w.Decrypt(Read, Write);
        ArrayList<String> actual = w.ReadFromFileByLines(Write);
        ArrayList<String> expected = new ArrayList<>(); expected.add("Hello world! I want to see you!");
        Assert.assertEquals(expected, actual);
    }
}