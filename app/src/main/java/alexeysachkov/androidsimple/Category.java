package alexeysachkov.androidsimple;

/**
 * Created by asachkov on 20.03.2016.
 */
public class Category {

    public static final String TABLE_NAME = "categories";
    public static final String CATEGORY_ID_COLUMN = "_ID";
    public static final String CATEGORY_NAME_COLUMN = "name";

    public static String getCreateTableSQL() {
        return "CREATE TABLE " + TABLE_NAME + " (" +
                CATEGORY_ID_COLUMN + " INTEGER PRIMARY_KEY, " +
                CATEGORY_NAME_COLUMN + " VARCHAR(255)" +
                ")";
    }
}
