import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SmallFinder {
    private ArrayList<String> theShortest = new ArrayList<>();
    private int shortest = Integer.MAX_VALUE;
////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<String> FindTheShortestAndWrite(String pathRead, String pathWrite) throws FileNotFoundException {
        theShortest.clear();
        ArrayList<String> AllWords ;
        AllWords = ScanFromFileByWords(pathRead);
        theShortest = FindTheShortestAndWrite(AllWords);
        AddListToFile(pathWrite, theShortest);
        return theShortest;
    }
    public ArrayList<String> FindTheShortestAndWrite(ArrayList<String> Allwords)  {
        theShortest.clear();
        for (String str : Allwords) {
            if (str.length() < shortest) {
                shortest = str.length();
                theShortest.clear();
                theShortest.add(str);
            } else if (str.length() == shortest) {
                theShortest.add(str);
            }
        }
        printArray(theShortest);
        return theShortest;    }

    public ArrayList<String> ScanFromFileByWords(String path) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();

        Scanner file = new Scanner(new File(path));
        file.useDelimiter(Pattern.compile("[^A-Za-z]+"));

        while (file.hasNextLine())
            list.add(file.next());
        file.close();
        return list;
    }
  public ArrayList<String> SplitWithSymbol(String delimeter, ArrayList<String> list) {
        ArrayList<String> words = new ArrayList<>();
        for (String str : list) {
            String[] subStr;
            subStr = str.split(delimeter);
            for (int i = 0; i < subStr.length; i++) {
                if(subStr[i]!=" " && subStr[i]!=null && subStr[i]!="\n") words.add(subStr[i].trim());
            }
        }
        return words;
    }
  private void AddListToFile(String path, ArrayList<String> list){
        try (FileWriter writer = new FileWriter(path, false)) {
            for(String word: list){
            writer.write(" " + word );
            writer.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void ReWriteFile(String path, String string){
        try (FileWriter writer = new FileWriter(path, false)) {
                writer.write(string);
                writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
 public void printArray(ArrayList<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}

