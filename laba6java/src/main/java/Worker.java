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


    ArrayList<Byte> ReadFromFileByBytes(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(path);
//        ArrayList<Integer> dataList = new ArrayList<>();
        ArrayList<Byte> dataList = new ArrayList<>();
        while (inputStream.available() > 0) //поки є непрочитанні байти
        {
            //читання байту
//            dataList.add(inputStream.read());
            dataList.add((byte)inputStream.read());
        }
        inputStream.close();
        return dataList;
    }
    void WriteInFileByBytes (String path, ArrayList<Byte> list) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        for (Byte data: list ) {
            outputStream.write(data);
        }
        outputStream.close();
    }
    public void EncryptFile(String pathR, String pathW) throws IOException {
        WriteInFileByBytes(pathW, Encrypt(ReadFromFileByBytes(pathR)));
    }
    public void DecryptFile(String pathR, String pathW) throws IOException {

        WriteInFileByBytes(pathW, Decrypt(ReadFromFileByBytes(pathR)));
    }

    ArrayList<Byte> Encrypt(ArrayList<Byte> input){
        ArrayList<Byte> encList = new ArrayList<>();
        for (Byte data: input) {
            encList.add(Encryption(data));
        }
        return encList;
    }
    ArrayList<Byte> Decrypt(ArrayList<Byte> input){
        ArrayList<Byte> encList = new ArrayList<>();
        for (Byte data: input) {
            encList.add(Decryption(data));
        }
        return encList;
    }
    public ArrayList<Byte> StringToListOfBytes(String str)
    {
        ArrayList<Byte> intList = new ArrayList<>();
        char[] result = str.toCharArray();
        for(char ch : result){
            intList.add((byte)ch);
        }
        return intList;
    }
    public  String ListOfBytesToString(ArrayList<Byte> intList){
        String str ="";
        for (int data: intList ) {
            str += (char)data;
        }
        return str;
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
    Byte Encryption (Byte in)
    {
        /// Шифрування
        int i = in + 3;
        return (byte)i;
    }
    Byte Decryption (Byte in)
    {
        /// Розшифровування
        int i = in - 3;
        return (byte)i;
    }
}
