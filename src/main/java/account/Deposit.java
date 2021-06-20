package account;

public class Deposit {
    private int id;
    private String email;
    private int deposit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Deposit: " +
                "deposit id: " + id +
                ", to account email: " + email +
                ", amount: " + deposit;
    }
}
