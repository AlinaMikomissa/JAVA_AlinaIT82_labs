import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Worker {

    public ArrayList<String>ReadFromFileByLines(String path) throws IOException {
        ////// Запис усіх рядків файлу в ArrayList /////
        ArrayList<String> list = new ArrayList<>();
        FileReader file= new FileReader(path);
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
            list.add(scan.nextLine());
        file.close();
        return list;
    }
    public void Encrypt(String pathR, String pathW) throws IOException {
       ///// Запис зашифрованого варіанту одного файлу в інший /////
        FileInputStream inputStream = new FileInputStream(pathR); //поток читання байт з файлу
        FileOutputStream outputStream = new FileOutputStream(pathW); //поток запису в файл
        while (inputStream.available() > 0) //поки є непрочитанні байти
        {
            //читання байту, виконання функції шиврування і запис в змінну дата
            int data = Encryption(inputStream.read());
            outputStream.write(data); // запис в другий потік
        }
        inputStream.close(); //закриття обох потоків
        outputStream.close();
    }
    public void Decrypt(String pathR, String pathW) throws IOException {
        ///// Запис розшифрованого варіанту зашифрованого файлу в інший /////
        FileInputStream inputStream = new FileInputStream(pathR);//поток читання байт з файлу
        FileOutputStream outputStream = new FileOutputStream(pathW);//поток запису в файл
        while (inputStream.available() > 0)  //поки є непрочитанні байти
        {
            //читання байту, виконання функції розшиврування і запис в змінну дата
            int data = Decryption(inputStream.read());
            outputStream.write(data); // запис в другий потік
        }
        inputStream.close();//закриття обох потоків
        outputStream.close();
    }
    public void ReWriteFile(String path, String string){
        ////// перезапис файлу ///
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(string);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void printArray(ArrayList<String> list) {
        //// вивід ArrayList в консоль
        for (String str : list) {
            System.out.println(str);
        }
    }
    int Encryption (int in)
    {
        /// Шифрування
        return in + 3 ;
    }
    int Decryption (int in)
    {
        /// Розшифровування
        return in - 3;
    }
}
