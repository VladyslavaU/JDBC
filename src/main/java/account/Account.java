package account;

public class Account {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account: " +
                "id: " + id +
                ", firstName: " + firstName + '\'' +
                ", lastName: " + lastName + '\'' +
                ", email: " + email + '\'' +
                ", balance: " + balance;
    }
}
