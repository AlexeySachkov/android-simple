package alexeysachkov.androidsimple;

/**
 * Created by asachkov on 20.03.2016.
 */
public class Note {

    public static final String TABLE_NAME = "notes";
    public static final String NOTE_ID_COLUMN = "_ID";
    public static final String NOTE_TEXT_COLUMN = "note_text";
    public static final String NOTE_TITLE_COLUMN = "title";
    public static final String NOTE_PRIORITY_COLUMN = "priority";

    public static String getCreateTableSQL() {
        return "CREATE TABLE " + TABLE_NAME + " (" +
                NOTE_ID_COLUMN + " INTEGER PRIMARY_KEY, " +
                NOTE_TITLE_COLUMN + " VARCHAR(255), " +
                NOTE_TEXT_COLUMN + "TEXT, " +
                NOTE_PRIORITY_COLUMN + " INTEGER" +
                ")";
    }
}
