import org.junit.Assert;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class SmallFinderTest {
    @org.junit.jupiter.api.Test
    void findTheShortestAndWrite_Array_after_finding_the_shortest() {
        SmallFinder small = new SmallFinder();
        ArrayList<String> list = new ArrayList<>(); list.add("sdf");list.add("sdsfdf");list.add("sdsffdsdsf");list.add("safdsadf");list.add("ssfdasddf");list.add("adr");
        ArrayList<String> actual = small.FindTheShortestAndWrite(list);
        ArrayList<String> expected = new ArrayList<>(); expected.add("sdf"); expected.add("adr");
        Assert.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void findTheShortestAndWrite_Array_after_finding_2_the_shortest_IN_FILE() throws FileNotFoundException {
        SmallFinder finder = new SmallFinder();
        String pathR = "src/main/java/ReadFrom.txt"; String pathW = "src/main/java/WriteTo.txt";
        finder.ReWriteFile(pathR, "asdf asdfk dsafjkldasfjkl sdfklafls asfjkfsdkllsjk dkf dfs");
        ArrayList<String> actual = finder.FindTheShortestAndWrite(pathR,pathW);
        ArrayList<String> expected = new ArrayList<>(); expected.add("dkf"); expected.add("dfs");
        Assert.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void findTheShortestAndWrite_File_after_finding_2_and_writing_in_it() throws FileNotFoundException {
        SmallFinder finder = new SmallFinder();
        String pathR = "src/main/java/ReadFrom.txt"; String pathW = "src/main/java/WriteTo.txt";
        finder.ReWriteFile(pathR, "asdf, asdfk dsafjkldasfjkl - sdfklafls asfjkfsdkllsjk dkf dfs");
        finder.FindTheShortestAndWrite(pathR, pathW);

        ArrayList<String> expected = new ArrayList<>(); expected.add("dkf");expected.add("dfs");
        ArrayList<String> result = finder.ScanFromFileByWords(pathW);
        Assert.assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void findTheShortestAndWrite_File_after_finding_1_the_shortest_if_it_is_many_spaces_in_file() throws FileNotFoundException {
        SmallFinder finder = new SmallFinder();
        String pathR = "src/main/java/ReadFrom.txt"; String pathW = "src/main/java/WriteTo.txt";
        finder.ReWriteFile(pathR, "asdf      asdfk    dsafjkldasfjkl      \n       sdfklafls asfjkfsdkllsjk \n dkf");
        finder.FindTheShortestAndWrite(pathR, pathW);
        ArrayList<String> result = finder.ScanFromFileByWords(pathW);
        ArrayList<String> expected = new ArrayList<>(); expected.add("dkf");
        Assert.assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void ScanFromFileByWords_if_it_is_many_spaces_in_file() throws FileNotFoundException {
        SmallFinder finder = new SmallFinder();
        String pathR = "src/main/java/ReadFrom.txt"; //String pathW = "src/main/java/WriteTo.txt";
        finder.ReWriteFile(pathR, "asdf, asdfk  \n             dsafjkldasfjkl,          asfjkfsdkllsjk dkf    xd");
        ArrayList<String> result = finder.ScanFromFileByWords(pathR);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("asdf");expected.add("asdfk");expected.add("dsafjkldasfjkl");expected.add("asfjkfsdkllsjk");expected.add("dkf");expected.add("xd");
        Assert.assertEquals(expected, result);
    }

}