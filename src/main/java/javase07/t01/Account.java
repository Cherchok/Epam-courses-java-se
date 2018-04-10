package javase07.t01;

import java.util.Objects;

public class Account {
    private String id;
    private int accountBalance;

    @SuppressWarnings("WeakerAccess")
    public Account(String id, int accountBalance) {
        this.accountBalance = accountBalance;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void toDeposit(int amount) {
        accountBalance += amount;
    }

    public void withdraw(int amount) {
        accountBalance -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
