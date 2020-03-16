import org.junit.Assert;
import org.junit.Rule;
//import org.junit.jupiter;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class Cage_mammalsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test(expected = CustomException.class)
    public void ShouldThrowExceptionWhenItIsNoPlace_PutAnimalInCage(){
        System.out.println("--------------------");
        Cage_mammals cageM = new Cage_mammals(1);
        Zebra zb1 = new Zebra("Deli", 4);
        Zebra zb2 = new Zebra("Vinki", 5);
        cageM.PutInCage(zb1);
        cageM.PutInCage(zb2);

    }
    @Test
    public void AllShouldBeOK_PutAnimalInCage() {
        System.out.println("--------------------");
        Cage_mammals cageM = new Cage_mammals(2);
        Zebra zb1 = new Zebra("Deli", 4);
        Zebra zb2 = new Zebra("Vinki", 5);
        cageM.PutInCage(zb1);
        cageM.PutInCage(zb2);

    }
    @Test
    public void AllShouldBeOK_GetAnimalFromCage(){
        System.out.println("--------------------");
        Cage_mammals cageM = new Cage_mammals(2);
        Zebra zb1 = new Zebra("Deli", 4);
        cageM.PutInCage(zb1);
        cageM.GetFromCage(zb1);


    }
    @Test(expected = CustomException.class)
    public void ShouldThrowExceptionWhenThereIsNotThatAnimalInCage_GetAnimalFromCage(){
        System.out.println("--------------------");
        Cage_mammals cageM = new Cage_mammals(2);
        Zebra zb1 = new Zebra("Deli", 4);
        cageM.PutInCage(zb1); cageM.GetFromCage(zb1);
        cageM.GetFromCage(zb1);

    }
//Errors/////Errors/////////ERRORS////////////////////////////////////////
    /*@Test
    void putInCage_Zebra_and_Bird() {
        Cage_mammals cageM = new Cage_mammals(2);
        Zebra zb1 = new Zebra("Deli", 4);
        Parrot gosha = new Parrot("Gosha", 5);
        cageM.PutInCage(zb1);
        boolean actual = cageM.PutInCage(gosha) ;
        Assert.assertEquals(false, actual);
    }*/
   /* @Test
    void putInCage_Zebra_and_Tiger() {
        Cage_m_ungulates cageM = new Cage_m_ungulates(2);
        Zebra zb1 = new Zebra("Deli", 4);
        Tiger tg = new Tiger("Vinki", 5);
        cageM.PutInCage(zb1);
        boolean actual = cageM.PutInCage(tg) ;
        Assert.assertEquals(false, actual);
    }*/

}