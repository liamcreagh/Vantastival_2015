package com.mycompany.vantastival;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;

import com.mycompany.vantastival.db.DBAdapter;
import com.mycompany.vantastival.tabs.BallFragmentPagerAdapter;
import com.mycompany.vantastival.tabs.SlidingTabLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class StagesBall extends ActionBarActivity {

    DBAdapter db = new DBAdapter(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages_ball);

        // Programmatically styles Action Bar as Class Extends ActionbarActivity
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff2196F3));

        ViewPager viewPager = (ViewPager) findViewById(R.id.musicmakerViewPager);
        viewPager.setAdapter(new BallFragmentPagerAdapter(getSupportFragmentManager(), StagesBall.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.musicmakerTabs);
        slidingTabLayout.setViewPager(viewPager);

        // Stops onDestroy Method being Called
        viewPager.setOffscreenPageLimit(3);

        // Gets SQLite DB
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

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stages_ball, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_back) {

            Intent contact = new Intent(this, StagesMain.class);
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



    public SimpleCursorAdapter populate(String stage, String day){
        db.open();

        Cursor cursor = db.getStageDay(stage, day);


        // THE DESIRED COLUMNS TO BE BOUND
        String[] columns = new String[] {DBAdapter.KEY_BANDNAME, DBAdapter.KEY_TIME };
        // THE XML DEFINED VIEWS WHICH THE DATA WILL BE BOUND TO
        int[] to = new int[] { R.id.bandNames, R.id.stageTimes};

        // CREATE THE ADAPTER USING THE CURSOR POINTING TO THE DESIRED DATA AS WELL AS THE LAYOUT INFORMATION
        SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.listview_item_stages, cursor, columns, to);

        return myAdapter;


    }




}
