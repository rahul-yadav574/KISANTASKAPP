package in.evolve.kisantaskapp.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

import in.evolve.kisantaskapp.Models.Message;
import in.evolve.kisantaskapp.Models.Task;

/**
 * Created by Brekkishhh
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "OtpRecords.db";
    private static final String TAG  = "DbHelper";
    private SQLiteDatabase db;

    public DbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        db.execSQL(DbUtils.CREATE_TASK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addEntryToDb(String time,String name,String otp){

        SQLiteDatabase db =  getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Schema.DbEntry.COLUMN_TIME,time);
        values.put(Schema.DbEntry.COLUMN_NAME,name);
        values.put(Schema.DbEntry.COLUMN_OTP,otp);
        db.insert(Schema.DbEntry.TABLE_NAME,null,values);
    }


    public void addNewTaskToDb(String taskName){
        SQLiteDatabase db =  getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Schema.DbEntry.COLUMN_TASK_NAME,taskName);
        values.put(Schema.DbEntry.COLUMN_TASK_STATUS,"0");

        db.insert(Schema.DbEntry.TABLE_TASK,null,values);
    }


    public List<Task> retrieveListFromDb(){

        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {Schema.DbEntry._ID,Schema.DbEntry.COLUMN_TASK_NAME, Schema.DbEntry.COLUMN_TASK_STATUS};

        Cursor readCursor = db.query(Schema.DbEntry.TABLE_TASK,
                projection,null,null,null,null,null);

        readCursor.moveToFirst();        //now the cursor points to the first row


        int totalRows = readCursor.getCount();

        List<Task> results = new ArrayList<>();

        while (totalRows>0){
            totalRows--;
            int _id = readCursor.getInt(readCursor.getColumnIndexOrThrow(Schema.DbEntry._ID));
            String taskName = readCursor.getString(readCursor.getColumnIndexOrThrow(Schema.DbEntry.COLUMN_TASK_NAME));

            String status = readCursor.getString(readCursor.getColumnIndexOrThrow(Schema.DbEntry.COLUMN_TASK_STATUS));

            results.add(new Task(taskName,status,_id));
            readCursor.moveToNext();
        }

        readCursor.close();

        return results;

    }

    public void updateStatus(String taskName,int id){
        SQLiteDatabase db =  getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Schema.DbEntry.COLUMN_TASK_NAME,taskName);
        values.put(Schema.DbEntry.COLUMN_TASK_STATUS,"1");


    }


}
