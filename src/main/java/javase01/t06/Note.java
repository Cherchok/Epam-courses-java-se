package javase01.t06;

/**
 * A simple class for making some notes with <b>note</b> property.
 *
 * @author Viktor Yurzanov
 * @since 1.0
 */

public class Note {
    private String note;

    /**
     * Constructor for creating new object with param.
     *
     * @param note - some record
     * @see Note#Note(String)
     */
    Note(String note) {
        this.note = note;
    }

    /**
     * Method for creating new record { @Link Note#note }
     *
     * @param note - new record
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Returns { @Link Note#note }
     *
     * @return current note
     */
    public String getNote() {
        return note;
    }
}
