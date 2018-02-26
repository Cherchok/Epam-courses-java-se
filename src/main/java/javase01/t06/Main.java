package javase01.t06;

public class Main {

    public static void main(String[] args) {

        Notebook notebook = new Notebook(3);

        System.out.println("Добавление записей: ");
        notebook.addNote("Ivan");
        notebook.addNote("Egor");
        notebook.addNote("Vasily");
        notebook.addNote("Oleg");
        notebook.addNote("Viktor");
        notebook.addNote("Peter");
        notebook.displayAllNotes();

        System.out.println();
        System.out.println("Редовкируем запись под индексом [1], заменяем Egor на  Valentin: ");
        notebook.editNote(1, "Valentin");
        notebook.displayAllNotes();

        System.out.println();
        System.out.println("Удаляем запись под индексом [2]:");
        notebook.deleteNote(2);
        notebook.displayAllNotes();

        System.out.println();
        System.out.println("Добавляем новую запись в конец списка: ");
        notebook.addNote("Max");
        notebook.displayAllNotes();
    }
}
