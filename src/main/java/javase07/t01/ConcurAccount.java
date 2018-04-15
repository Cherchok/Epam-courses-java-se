package javase07.t01;

import java.util.concurrent.locks.Lock;

public class ConcurAccount extends Account {
    public  Lock lock;
    public ConcurAccount(String id, int accountBalance) {
        super(id, accountBalance);
    }
}
