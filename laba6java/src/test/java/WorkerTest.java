import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
String Read = "src/main/java/Read.txt";
String Write = "src/main/java/Write.txt";
// тести на шифрування рядків
    ///рядки перетворюються на ліст байтів для шифрування, тому що метод, який шифрує, використовується при шифруванні файлів, з яких дані зчитуються в ліст файлів
    @Test
    void encrypt(){
        Worker w = new Worker();
        String in = "Hello world! I want to see you!";
        String expected = "Khoor#zruog$#L#zdqw#wr#vhh#|rx$";
        String actual = w.ListOfBytesToString(w.Encrypt(w.StringToListOfBytes(in)));
        Assert.assertEquals(expected, actual);
    }
    @Test
    void decrypt(){
        Worker w = new Worker();
        String in = "Khoor#zruog$#L#zdqw#wr#vhh#|rx$";
        String expected = "Hello world! I want to see you!";
        String actual = w.ListOfBytesToString(w.Decrypt(w.StringToListOfBytes(in)));
        Assert.assertEquals(expected, actual);
    }
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

    @Test
    void testSomeStuffAboutStringsAndBytes(){
        Worker w = new Worker();
        String expected = "Hello you!";
        String actual = w.ListOfBytesToString(w.StringToListOfBytes(expected));
        Assert.assertEquals(expected, actual);
    }
}