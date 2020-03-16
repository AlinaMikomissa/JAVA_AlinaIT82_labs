import java.util.ArrayList;
import java.util.List;

public class Cage_birds <T extends Bird> extends  Cage<T> {
   public Cage_birds(int MaxAnimals) {
        super(MaxAnimals);
            }
    @Override
    public boolean PutInCage(T animal) {
        return super.PutInCage(animal);
    }
    @Override
    public void GetFromCage(T animal) {
         super.GetFromCage(animal);
    }
}
