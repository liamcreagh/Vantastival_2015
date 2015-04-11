package com.mycompany.vantastival;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.mycompany.vantastival.db.DBAdapter;
import com.mycompany.vantastival.db.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;




public class StagesMain extends ActionBarActivity {


    DBAdapter db = new DBAdapter(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages_main);



        try {
            String destPath = "/data/data/" + getPackageName() + "/databases/AssignmentDB";
            File f = new File(destPath);
            if (!f.exists()) {
                CopyDB(getBaseContext().getAssets().open("db"),
                        new FileOutputStream(destPath));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }








        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(0xff2196F3));

  


       /*

Cursor c = db.getRecordStage("main");
        if (c.moveToFirst())
            DisplayRecord(c);
        else
            Toast.makeText(this, "No Assignments found", Toast.LENGTH_LONG).show();
            */










    }




    public void getMainStage(View view) {
        Intent intent = new Intent(this, StagesMainstage.class);
        startActivity(intent);

    }

    public void getVanhallaStage(View view) {
        Intent intent = new Intent(this, StagesVanhalla.class);
        startActivity(intent);
    }
    public void getMusicmakerStage(View view) {
        Intent intent = new Intent(this, StagesMusicmaker.class);
        startActivity(intent);
    }
    public void getUnpluggedStage(View view) {
        Intent intent = new Intent(this, StagesUnplugged.class);
        startActivity(intent);
    }
    public void getMelomaniaStage(View view) {
        Intent intent = new Intent(this, StagesMelomania.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stages_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_back) {

            Intent contact = new Intent(this, MainActivity.class);
            startActivity(contact);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    public void CopyDB(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        //---copy 1K bytes at a time---
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    public void DisplayRecord(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Band Name: " + c.getString(1) + "\n" +
                        "Stage:  " + c.getString(2),
                Toast.LENGTH_SHORT).show();
    }



    public void populate(){

       /*
        db.open();


        Cursor cursor = db.getStageDay("main", "sat");



        // THE DESIRED COLUMNS TO BE BOUND
        String[] columns = new String[] {DBAdapter.KEY_BANDNAME, DBAdapter.KEY_TIME };
        // THE XML DEFINED VIEWS WHICH THE DATA WILL BE BOUND TO
        int[] to = new int[] { R.id.bandNames, R.id.stageTimes};

        // CREATE THE ADAPTER USING THE CURSOR POINTING TO THE DESIRED DATA AS WELL AS THE LAYOUT INFORMATION
        SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.listview_item_stages, cursor, columns, to);

        ListView myList = (ListView) findViewById(R.id.listViewMainStage);
        myList.setAdapter(myAdapter);
        db.close(); */


    }

}
