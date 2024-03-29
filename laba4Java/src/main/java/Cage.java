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
    boolean  PutInCage(T animal) { //обробка виключення на відсутність місця в вольєрі

        if (animalsIn.size() >= maxAnimals) {
            throw new CustomException("Помилка: У вольєрі недостатньо місця");
        }
        animalsIn.add(animal);
        System.out.println("Тварину поселено в клітку");
        return true;


    }
    public void GetFromCage(T animal){ //обробка виключення на відсутність тварини в вольєрі

        if(animalsIn.contains(animal)){
            animalsIn.remove(animal);
            System.out.println("Тварину забрано з вольєру");
        }
        else {
            throw new CustomException("Помилка: Обраної тварини немає в вольєрі");

        }

    }


    public int getMaxAnimals() {
        return maxAnimals;
    }
    public void setMaxAnimals(int maxAnimals) {
        this.maxAnimals = maxAnimals;
    }
}
