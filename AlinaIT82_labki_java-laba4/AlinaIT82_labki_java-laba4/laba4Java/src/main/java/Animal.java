abstract class Animal {
    String name;
    int age;
    public Animal( String Name, int Age){
        name = Name;
        age = Age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
