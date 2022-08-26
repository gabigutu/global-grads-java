import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Shelter {
    protected String name;
    protected Account account;
    protected LinkedList<Animal> animals;

    protected TreeSet<Animal> animalTreeSet;
    protected float latitude;
    protected float longitude;
    protected String owner;

    public Shelter(String name) {
        this(name, "");
    }

    public Shelter(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.animals = new LinkedList<>();
        this.animalTreeSet = new TreeSet<>(new AnimalAgeComparator());
    }

    public void showAnimals(){
        System.out.println("Linked list: ");

        for(int i = 0; i<animals.size(); i++){
            System.out.println(animals.get(i) + " ");
        }
        Iterator<Animal> animalIterator = animalTreeSet.iterator();

        System.out.println("Tree set: ");

        while(animalIterator.hasNext()){
            System.out.println(animalIterator.next() + " ");
        }
    }



}
