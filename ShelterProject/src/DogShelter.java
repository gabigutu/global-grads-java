public class DogShelter extends Shelter implements IShelter{
    public DogShelter(String name) {
        super(name);
    }

    public DogShelter(String name, String owner) {
        super(name, owner);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public float getLatitude() {
        return super.latitude;
    }

    @Override
    public float getLongitude() {
        return super.longitude;
    }

    @Override
    public String getOwner() {
        return super.owner;
    }

    @Override
    public void receiveDonation(double amount) {
        this.account.deposit(amount);
    }

    @Override
    public void spend(double amount, String motivation) throws NegativeSumException {
        this.account.withdraw(amount);
    }

    public void addDog(Animal dog){
        super.animals.add(dog);
        super.animalTreeSet.add(dog);
    }
}
