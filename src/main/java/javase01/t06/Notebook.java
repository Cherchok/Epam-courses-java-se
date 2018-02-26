package javase01.t06;

/**
 * This class is array, which consist of <b>Note</b> Objects.
 *
 * @author Viktor Yurzanov
 * @since 1.0
 */
public class Notebook {

    /**
     * Property for calculating number of notes in <b>notebook</b>
     */
    private int numberOfNotes;

    /**
     * This property is array, consisted of <b>Note</b> types data
     */
    private Note[] notebook;

    /**
     * Constructor with params
     *
     * @param size transfer the size of <>notebook</> at the time of initialization
     */
    Notebook(int size) {
        notebook = new Note[size];
    }

    /**
     * The method for adding <>note</> to <>notebook</>
     *
     * @param note new <>note</>
     */
    public void addNote(String note) {
        spaceCheck();
        notebook[numberOfNotes++] = new Note(note);
    }

    /**
     * The method removes <b>note</b> by index then decrease <b>notebook</b> by 1 position
     *
     * @param index index of deleting <b>note</b>
     */
    public void deleteNote(int index) {
        System.arraycopy(notebook, index + 1, notebook, index, notebook.length - 1 - index);
        Note[] decreaseNote = new Note[notebook.length - 1];
        System.arraycopy(notebook, 0, decreaseNote, 0, notebook.length - 1);
        notebook = decreaseNote;
        numberOfNotes--;
    }

    /**
     * The method for rewrite current <b>note</b> by index
     *
     * @param index the index of <b>note</b> which need to rewrite
     * @param note  rewritable note
     */
    public void editNote(int index, String note) {
        notebook[index].setNote(note);
    }

    /**
     * The method displays in console all <b>note</b> of <b>notebook</b>
     */
    public void displayAllNotes() {
        for (Note note : notebook) {
            if (note != null) {
                String st = note.getNote();
                System.out.println(st);
            }
        }
    }

    /**
     * This method checks the capacity of array <b>notebook</b>. If array filled, the method rewrite and
     * increase <b>notebook</b> by 1 position
     */
    private void spaceCheck() {
        if (numberOfNotes >= notebook.length) {
            Note[] biggerNotebook = new Note[notebook.length + 1];
            System.arraycopy(notebook, 0, biggerNotebook, 0, notebook.length);
            notebook = biggerNotebook;
        }
    }
}
