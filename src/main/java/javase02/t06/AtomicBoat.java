package javase02.t06;

import javase02.t07.BoatDiscription;

@BoatDiscription(name = "Titan",model = 123986,nuclearWeapon = true)
public class AtomicBoat {
    private Engine engine;
    private boolean oilChecked;
    private boolean fuelChecked;

    AtomicBoat() {
        engine = new Engine();
    }

    public boolean runIntoSwimming() {
        if (engine.startEngine()) {
            System.out.println("I'm flying Jack!!!!");
            return true;
        }
        System.out.println("First, start engine, you donkey!!!!!");
        return false;
    }

    public void readyToGo() {
        engine.fuelCheck();
        engine.oilCheck();
    }

    class Engine {
        void oilCheck() {
            System.out.println("Oil checked");
            oilChecked = true;
        }

        void fuelCheck() {
            System.out.println("Fuel checked");
            fuelChecked = true;
        }

        boolean startEngine() {
            if (oilChecked && fuelChecked) {
                return true;
            }
            System.out.println("First check oil and fuel");
            return false;
        }

    }
}


