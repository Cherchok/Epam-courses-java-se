package javase02.t01;

public class Pen {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

   @Override
    public boolean equals(Object object) {
       if (object == null) {
           return false;
       }
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }

        Pen pen = (Pen) object;
        return this.getId()==pen.getId();
    }

    @Override
    public int hashCode() {
        return 15 + 31 * id;
    }

    @Override
    public String toString() {
        return "The object id is: " + id + " end hashCode is: " + hashCode();
    }
}
