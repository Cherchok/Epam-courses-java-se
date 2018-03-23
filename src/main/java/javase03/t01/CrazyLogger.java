package javase03.t01;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CrazyLogger {
    private StringBuffer log;
    private final static String DATA_TIME_PATTERN = "dd.MM.YYYY - hh:mm:ss";
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATA_TIME_PATTERN);

    CrazyLogger() {
        log = new StringBuffer();
    }

    public void addMessage(String massage) {
        log.append(LocalDateTime.now()
                .format(dateTimeFormatter))
                .append(" - ")
                .append(massage)
                .append("; ");
    }

    public String getFirstMessage(String message) {
        return getRecord(log.indexOf(message));
    }

    public String getLastMessage(String message) {
        return getRecord(log.lastIndexOf(message));
    }

    public void getAllMessage() {
        String regEx = "; ";
        String[] logs = log.toString().split(regEx);
        Arrays.stream(logs).forEach(System.out::println);
    }

    private String getRecord(int messageStartPoint) {
        int recordStartPoint = log.substring(0, messageStartPoint).lastIndexOf(";");
        return log.substring(recordStartPoint + 1, log.indexOf(";", messageStartPoint));
    }

    @Override
    public String toString() {
        return log.toString();
    }
}
