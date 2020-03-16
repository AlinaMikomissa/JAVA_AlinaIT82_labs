import java.util.ArrayList;
import java.util.List;

public abstract class Cage<T extends Animal> {
    int maxAnimals;
    protected ArrayList<T> animalsIn = new ArrayList<>();
    public Cage(int MaxAnimals)
    {
        maxAnimals = MaxAnimals;
    }

    public int getFreePlaces() {
        return maxAnimals - animalsIn.size();
    }
    public int getNumberAnimalsIn(){
        return animalsIn.size();
    }



    public int getMaxAnimals() {
        return maxAnimals;
    }
    public void setMaxAnimals(int maxAnimals) {
        this.maxAnimals = maxAnimals;
    }
}
