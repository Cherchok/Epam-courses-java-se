package javase04.t04;

import java.io.Serializable;

public class Actor implements Serializable {
    private String name;
    private String surname;

    Actor(String name , String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getSurname() {
        return surname;
    }
}
