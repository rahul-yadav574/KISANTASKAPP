package in.evolve.kisantaskapp.Db;

import android.provider.BaseColumns;

/**
 * Created by Brekkishhh
 */
public class Schema {

    public Schema() {
    }

    public static abstract class DbEntry implements BaseColumns{

        public static final String TABLE_NAME = "otp_records";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_OTP = "otp";

        public static final String COLUMN_TASK_NAME = "task_name";
        public static final String COLUMN_TASK_STATUS  = "task_status";
        public static final String TABLE_TASK  = "task_table";


    }
}
