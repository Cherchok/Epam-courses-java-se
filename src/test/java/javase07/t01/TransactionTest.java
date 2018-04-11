package javase07.t01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void run() throws IOException, InterruptedException {

        Map<String, Account> accounts = new HashMap<>();
        accounts.put("1", new Account("1", 100));
        accounts.put("2", new Account("2", 500));
        accounts.put("3", new Account("3", 700));
        accounts.put("4", new Account("4", 1000));

        BufferedReader br = new BufferedReader(
                new FileReader("/Users/cherchok/IdeaProjects/se01/src/main/resources/m7t1/TransactionBook.txt"));

        while (br.ready()) {
            String[] strings = br.readLine().split("\\D*\\s");
            Thread thread = new Thread(new Transaction(accounts.get(strings[0]), accounts.get(strings[1]),
                    Integer.parseInt(strings[2])));
            thread.start();
            thread.join();
        }
        assertEquals(300, accounts.get("2").getAccountBalance());


    }
}