package javase07.t01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ConcurTransactionTest {

    @Test
    void runTest() throws IOException, InterruptedException {

        Map<String, ConcurAccount> accounts = new HashMap<>();
        accounts.put("1", new ConcurAccount("1", 100));
        accounts.put("2", new ConcurAccount("2", 500));
        accounts.put("3", new ConcurAccount("3", 700));
        accounts.put("4", new ConcurAccount("4", 1000));

        BufferedReader br = new BufferedReader(
                new FileReader("/Users/cherchok/IdeaProjects/se01/src/main/resources/m7t1/TransactionBook.txt"));
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (br.ready()) {
            String[] strings = br.readLine().split("\\D*\\s");
            executorService.execute(new Transaction(accounts.get(strings[0]), accounts.get(strings[1]),
                    Integer.parseInt(strings[2])));

        }
       // Thread.sleep(100);
        assertEquals(300, accounts.get("2").getAccountBalance());
    }
}