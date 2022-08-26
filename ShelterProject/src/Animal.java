import java.util.Arrays;

public class Animal<T>{
    private String name;
    private double age;
    private double[] foodHistory;
    private boolean isHungry;
    private boolean isThirsty;

    public Animal(String name, double age) {
        this.name = name;
        this.age = age;
        this.foodHistory = new double[20];
        this.isHungry = false;
        this.isThirsty = false;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public double[] getFoodHistory() {
        return foodHistory;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public boolean isThirsty() {
        return isThirsty;
    }

    @Override
    public boolean equals(Object obj) {
        return this.age == ((Animal)obj).age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", foodHistory=" + Arrays.toString(foodHistory) +
                ", isHungry=" + isHungry +
                ", isThirsty=" + isThirsty +
                '}';
    }
}
