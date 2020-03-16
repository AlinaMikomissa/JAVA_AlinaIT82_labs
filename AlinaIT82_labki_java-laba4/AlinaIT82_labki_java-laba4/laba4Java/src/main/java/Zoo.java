import java.util.ArrayList;
import java.util.List;

public class Zoo   {
    String name;
    //public ArrayList<Cage> cages = new ArrayList<>();
    public Zoo(String Name){
        name = Name;
    }

 public int getCountOfAnimals(ArrayList<? extends Animal> cage)
 {
     int sum = 0;
     for (Animal animal : cage) {
         sum++;
     }
     return sum  ;
 }
}
