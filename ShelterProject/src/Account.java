public class Account {
    private double balance;
    public String name;

    public Account(String name){
        this.balance = 0;
        this.name = name;
    }

    public void deposit(double sum){
        this.balance += sum;
    }

    public void withdraw(double sum) throws NegativeSumException {
        if(balance - sum < 0){
            throw new NegativeSumException();
        }
        this.balance -= sum;
    }

    public double getBalance(){
        return this.balance;
    }
}
