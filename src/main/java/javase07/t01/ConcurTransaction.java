package javase07.t01;

public class ConcurTransaction {
    private ConcurAccount transmitter;
    private ConcurAccount receiver;
    private int amount;

    public ConcurTransaction(ConcurAccount transmitter, ConcurAccount receiver, int amount) {
        this.transmitter = transmitter;
        this.receiver = receiver;
        this.amount = amount;
    }

    public void run() {
        doTransaction();
    }

    @SuppressWarnings("Duplicates")
    private void doTransaction() {
        while (true) {
            if (transmitter.lock.tryLock()) {
                if (receiver.lock.tryLock()) {
                    if (transmitter.getAccountBalance() >= amount) {
                        transmitter.withdraw(amount);
                        receiver.toDeposit(amount);
                        System.out.println(transmitter.getId() + " -> " + receiver.getId() + " : " + amount);
                    } else throw new OutOfBalanceException();
                } else transmitter.lock.unlock();
            }
        }
    }
}
