package javase07.t01;

public class Transaction implements Runnable {
    private final Account transmitter;
    private final Account receiver;
    private int amount;

    @SuppressWarnings("WeakerAccess")
    public Transaction(Account transmitter, Account receiver, int amount) {
        this.transmitter = transmitter;
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public void run() {
        doTransaction();
    }

    private void doTransaction() {
        if (transmitter.getId().hashCode() > receiver.getId().hashCode()) {
            synchronized (transmitter) {
                synchronized (receiver) {
                    if (transmitter.getAccountBalance() >= amount) {
                        transmitter.withdraw(amount);
                        receiver.toDeposit(amount);
                        System.out.println(transmitter.getId() + " -> " + receiver.getId() + " : " + amount);
                    } else throw new OutOfBalanceException();

                }
            }
        } else {
            synchronized (receiver) {
                synchronized (transmitter) {
                    if (transmitter.getAccountBalance() >= amount) {
                        receiver.toDeposit(amount);
                        transmitter.withdraw(amount);
                        System.out.println(transmitter.getId() + " -> " + receiver.getId() + " : " + amount);
                    } else throw new OutOfBalanceException();

                }
            }
        }
    }
}
