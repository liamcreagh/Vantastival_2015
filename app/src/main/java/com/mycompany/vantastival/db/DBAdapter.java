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

public class DBAdapter {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_BANDNAME = "bandname";
    public static final String KEY_STAGE = "stage";
    public static final String KEY_DAY = "day";
    public static final String KEY_TIME = "time";
    public static final String KEY_DESCRIPTION = "description";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "BandsDB";
    private static final String DATABASE_TABLE = "bands";
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE =
        "create table if not exists bands (_id integer primary key autoincrement, "
        + "bandname VARCHAR not null, stage VARCHAR, day VARCHAR, time time, description VARCHAR );";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
        	try {
        		db.execSQL(DATABASE_CREATE);
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close()
    {
        DBHelper.close();
    }

    //---insert a record into the database---
    public long insertRecord(String bandname, String stage, String day, String time, String description)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_BANDNAME, bandname);
        initialValues.put(KEY_STAGE, stage);
        initialValues.put(KEY_DAY, day);
        initialValues.put(KEY_TIME, time);
        initialValues.put(KEY_DESCRIPTION, description);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular record---
    public boolean deleteContact(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---retrieves all the records---
    public Cursor getAllRecords()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_BANDNAME,
                KEY_STAGE, KEY_DAY, KEY_TIME, KEY_DESCRIPTION}, null, null, null, null, null, null);



    }






    public Cursor getStageDay(String stage, String day)
    {


        String[] columns = {KEY_BANDNAME, KEY_TIME};
        Cursor mCursor =  db.rawQuery("SELECT * FROM bands WHERE stage='" +stage+ "' AND day='" + day + "' ORDER BY time\n" , null);

/*
StringBuffer buffer = new StringBuffer();
        while(mCursor.moveToNext()){
            int index0 = mCursor.getColumnIndex(KEY_ROWID);
            int index1 = mCursor.getColumnIndex(KEY_BANDNAME);
            int index2 = mCursor.getColumnIndex(KEY_TIME);
            String bandName = mCursor.getString(index1);
            String time = mCursor.getString(index2);
            buffer.append(index0 + "    " + bandName + "    " + time + "\n");


        } */

        return mCursor;

        // return mCursor;
    }



    //---retrieves a particular record---
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public Cursor getRecord(long rowId) throws SQLException


    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_BANDNAME, KEY_STAGE, KEY_DAY, KEY_TIME, KEY_DESCRIPTION},
                KEY_ROWID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }



        return mCursor;
    }

    //---updates a record---
    public boolean updateRecord(long rowId, String bandname, String stage, String day, String time, String description)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_BANDNAME, bandname);
        args.put(KEY_STAGE, stage);
        args.put(KEY_STAGE, day);
        args.put(KEY_TIME, time);
        args.put(KEY_DESCRIPTION, description);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }



        public boolean isPopulated(){
           Cursor cur =  db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_BANDNAME,
                   KEY_STAGE, KEY_DAY, KEY_TIME, KEY_DESCRIPTION}, null, null, null, null, null, null);

            cur.moveToLast();
            int size = cur.getCount();
          if(size > 1) return true;
            else return false;

        }








}
