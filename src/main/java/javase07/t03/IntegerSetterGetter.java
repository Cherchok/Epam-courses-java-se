package javase07.t03;

import java.io.PrintStream;
import java.util.Random;

class IntegerSetterGetter extends Thread {
    private static PrintStream printStream = new PrintStream(System.out);
    private final SharedResource resource;
    private boolean run;
    private Random rand = new Random();
    private static volatile Integer setterGetterCounter = 0;
    private static volatile Integer setCounter = 0;
    private static final Object setterGetterLock = new Object();
    private static final Object setterLock = new Object();


    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    @Override
    public synchronized void start() {
        synchronized (setterGetterLock) {
            setterGetterCounter++;
        }
        super.start();
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;
        try {
            while (run && setterGetterCounter > 0) {
                action = rand.nextInt(1000);
                if (action % 2 == 0 && setCounter > 0) {
                    getIntegersFromResource();
                } else {
                    synchronized (setterLock) {
                        setCounter++;
                    }
                    setIntegersIntoResource();
                    synchronized (setterLock) {
                        setCounter--;
                    }
                }
            }
            printStream.println("Поток " + getName() + " завершил работу.");
            synchronized (setterGetterLock) {
                setterGetterCounter--;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;
        synchronized (resource) {
            printStream.println("Поток " + getName() + " хочет извлечь число.");
            number = resource.getELement();
            while (number == null) {
                printStream.println("Поток " + getName() + " ждет пока очередь заполнится.");
                resource.wait();
                printStream.println("Поток " + getName() + " возобновил работу.");
                number = resource.getELement();
            }
            printStream.println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            printStream.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }

}