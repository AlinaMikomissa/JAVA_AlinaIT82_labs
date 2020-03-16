public class Cage_m_ungulates <T extends Ungulate> extends Cage_mammals<T> {
   public Cage_m_ungulates(int MaxAnimals) {
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
