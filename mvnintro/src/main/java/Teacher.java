import java.util.Date;

@DTO
public class Teacher {
    private String nume;

    @RealDate
    private Date paymentDate;
    private float amount;

    public Teacher(String nume) {
        this(nume, null, -1);
    }

    @RealDate
    public Teacher(String nume, Date paymentDate, float amount) {
        this.nume = nume;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public float getAmount() {
        return amount;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "nume='" + nume + '\'' +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }
}
