import java.util.ArrayList;
import java.util.List;
public class Cage_mammals <T extends Mammal> extends Cage<T> {

    public Cage_mammals(int MaxAnimals) {
        super(MaxAnimals);
    }
    @Override
    public boolean PutInCage(T animal)  {
        return super.PutInCage(animal);
    }

    @Override
    public void GetFromCage(T animal) {
         super.GetFromCage(animal);
    }

}
