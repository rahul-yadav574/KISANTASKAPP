package in.evolve.kisantaskapp.Db;

/**
 * Created by Brekkishhh .
 */
public class DbUtils {

    private static final String COMMA_SEP = ",";
    private static final String TYPE_TEXT = " TEXT";

    public static final String CREATE_TABLE = "CREATE TABLE "+ Schema.DbEntry.TABLE_NAME+" ("+ Schema.DbEntry._ID+" INTEGER PRIMARY KEY,"
            + Schema.DbEntry.COLUMN_NAME+TYPE_TEXT+COMMA_SEP+ Schema.DbEntry.COLUMN_TIME + TYPE_TEXT +
            COMMA_SEP+ Schema.DbEntry.COLUMN_OTP + TYPE_TEXT +" )";


    public static final String CREATE_TASK_TABLE = "CREATE TABLE "+ Schema.DbEntry.TABLE_TASK+" ("+ Schema.DbEntry._ID+" INTEGER PRIMARY KEY,"
            + Schema.DbEntry.COLUMN_TASK_NAME+TYPE_TEXT+COMMA_SEP+ Schema.DbEntry.COLUMN_TASK_STATUS + TYPE_TEXT + " )";
}
