package com.mycompany.vantastival.db;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;


// All instance variable to be used in creation of SQLite DB defined

public class DBAdapter {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_BANDNAME = "bandname";
    public static final String KEY_STAGE = "stage";
    public static final String KEY_DAY = "day";
    public static final String KEY_TIME = "time";
    public static final String KEY_SITE = "site";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "BandsDB";
    private static final String DATABASE_TABLE = "bands";
    private static final int DATABASE_VERSION = 2;



    // Table of bands is Created consisting of: Band Name / Stage they will Playing / Day they will play / Time they will play / their personal website
    private static final String DATABASE_CREATE =
            "create table if not exists bands (_id integer primary key autoincrement, "
                    + "bandname VARCHAR not null, stage VARCHAR, day VARCHAR, time time, site VARCHAR );";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }



        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

    //---opens the database---
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() {
        DBHelper.close();
    }

    //---insert a record into the database---
    public long insertRecord(String bandname, String stage, String day, String time, String description) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_BANDNAME, bandname);
        initialValues.put(KEY_STAGE, stage);
        initialValues.put(KEY_DAY, day);
        initialValues.put(KEY_TIME, time);
        initialValues.put(KEY_SITE, description);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular record---
    public boolean deleteContact(long rowId) {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---retrieves all the records---
    public Cursor getAllRecords() {
        return db.query(DATABASE_TABLE, new String[]{KEY_ROWID, KEY_BANDNAME,
                KEY_STAGE, KEY_DAY, KEY_TIME, KEY_SITE}, null, null, null, null, null, null);


    }

    // Method getStageDay(stage, day) takes in a string of stage and day and returns a Cursor of all bands playing on that stage that day
    // This method is called throughout stages package

    public Cursor getStageDay(String stage, String day) {


        String[] columns = {KEY_BANDNAME, KEY_TIME};
        Cursor mCursor = db.rawQuery("SELECT * FROM bands WHERE stage='" + stage + "' AND day='" + day + "' Order By CASE WHEN time LIKE '00%' or time LIKE '01%' THEN bandname else time end   \n" +

                "\n", null);


        return mCursor;


    }

    // Method getAtoj() returns a Cursor of all bands starting fom A to J
    // This method is called in BandsAtoj Fragment Class

    public Cursor getAtoj() {

        Cursor mCursor = db.rawQuery("SELECT * FROM bands WHERE (\n" +
                "         bandname like 'a%' " +
                "      OR bandname like 'b%' " +
                "      OR bandname like 'c%' " +
                "      OR bandname like 'd%' " +
                "      OR bandname like 'e%' " +
                "      OR bandname like 'f%' " +
                "      OR bandname like 'g%' " +
                "      OR bandname like 'h%' " +
                "      OR bandname like 'i%' " +
                "      OR bandname like 'j%' )" +
                "ORDER BY bandname asc"
                , null);


        return mCursor;

    }

    // Method getKtos() returns a Cursor of all bands starting fom K to S
    // This method is called in BandsKtos Fragment Class

    public Cursor getKtos() {


        Cursor mCursor = db.rawQuery("SELECT * FROM bands WHERE (\n" +
                "         bandname like 'k%' " +
                "      OR bandname like 'l%' " +
                "      OR bandname like 'm%' " +
                "      OR bandname like 'n%' " +
                "      OR bandname like 'o%' " +
                "      OR bandname like 'p%' " +
                "      OR bandname like 'q%' " +
                "      OR bandname like 'r%' " +
                "      OR bandname like 's%' )" +
                "ORDER BY bandname asc"
                , null);


        return mCursor;
    }


    // Method getTtoz() returns a Cursor of all bands starting fom T to Z
    // This method is called in BandsTtoz Fragment Class

    public Cursor getTtoz() {
        Cursor mCursor = db.rawQuery("SELECT * FROM bands WHERE (\n" +
                "         bandname like 't%' " +
                "      OR bandname like 'u%' " +
                "      OR bandname like 'v%' " +
                "      OR bandname like 'w%' " +
                "      OR bandname like 'x%' " +
                "      OR bandname like 'y%' " +
                "      OR bandname like 'z%' )" +
                "ORDER BY bandname asc"
                , null);

        return mCursor;
    }


    //---retrieves a particular record---
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public Cursor getRecord(long rowId) throws SQLException


    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{KEY_ROWID,
                                KEY_BANDNAME, KEY_STAGE, KEY_DAY, KEY_TIME, KEY_SITE},
                        KEY_ROWID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }


        return mCursor;
    }

    //---updates a record---
    public boolean updateRecord(long rowId, String bandname, String stage, String day, String time, String description) {
        ContentValues args = new ContentValues();
        args.put(KEY_BANDNAME, bandname);
        args.put(KEY_STAGE, stage);
        args.put(KEY_STAGE, day);
        args.put(KEY_TIME, time);
        args.put(KEY_SITE, description);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }


    public boolean isPopulated() {
        Cursor cur = db.query(DATABASE_TABLE, new String[]{KEY_ROWID, KEY_BANDNAME,
                KEY_STAGE, KEY_DAY, KEY_TIME, KEY_SITE}, null, null, null, null, null, null);

        cur.moveToLast();
        int size = cur.getCount();
        if (size > 1) return true;
        else return false;

    }


}
