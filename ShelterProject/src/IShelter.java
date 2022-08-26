public interface IShelter {
    String getName();
    float getLatitude();
    float getLongitude();
    String getOwner();
    void receiveDonation(double amount);
    void spend(double amount, String motivation) throws NegativeSumException;
}
