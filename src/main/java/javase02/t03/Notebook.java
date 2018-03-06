package javase02.t03;

public class Notebook extends Pen {

    public Notebook(int count) {
        super(count);
    }

    @Override
    public String getItemName() {
        return "Notebook";
    }

    @Override
    public String getBrandName() {
        return "CopyPaper";
    }
}
