package com.mycompany.vantastival;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import com.mycompany.vantastival.db.DBAdapter;
import com.mycompany.vantastival.stab.BandsFragmentPagerAdapter;
import com.mycompany.vantastival.stab.SlidingTabLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class BandMain extends ActionBarActivity  {

    DBAdapter db = new DBAdapter(this);
    String[] bandSites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bands_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(0xff2196F3));


        ViewPager viewPager = (ViewPager) findViewById(R.id.bandsViewPager);
        viewPager.setAdapter(new BandsFragmentPagerAdapter(getSupportFragmentManager(), BandMain.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.bandsTabs);
        slidingTabLayout.setViewPager(viewPager);



        viewPager.setOffscreenPageLimit(3);


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
        getMenuInflater().inflate(R.menu.menu_bands_main, menu);
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


    public SimpleCursorAdapter atoj(){
        db.open();

        Cursor cursor = db.getAtoj();


        // THE DESIRED COLUMNS TO BE BOUND
        String[] columns = new String[] {DBAdapter.KEY_BANDNAME};
        // THE XML DEFINED VIEWS WHICH THE DATA WILL BE BOUND TO
        int[] to = new int[] { R.id.bandNames};



       bandSites = new String[] {DBAdapter.KEY_DESCRIPTION};
        // CREATE THE ADAPTER USING THE CURSOR POINTING TO THE DESIRED DATA AS WELL AS THE LAYOUT INFORMATION
        SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.listview_item_bands_atoj, cursor, columns, to);

        return myAdapter;


    }
    public SimpleCursorAdapter ktos(){
        db.open();

        Cursor cursor = db.getKtos();


        // THE DESIRED COLUMNS TO BE BOUND
        String[] columns = new String[] {DBAdapter.KEY_BANDNAME};
        // THE XML DEFINED VIEWS WHICH THE DATA WILL BE BOUND TO
        int[] to = new int[] { R.id.bandNames};

        // CREATE THE ADAPTER USING THE CURSOR POINTING TO THE DESIRED DATA AS WELL AS THE LAYOUT INFORMATION
        SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.listview_item_bands_ktos, cursor, columns, to);

        return myAdapter;


    }
    public SimpleCursorAdapter ttoz(){
        db.open();

        Cursor cursor = db.getTtoz();


        // THE DESIRED COLUMNS TO BE BOUND
        String[] columns = new String[] {DBAdapter.KEY_BANDNAME};

        // THE XML DEFINED VIEWS WHICH THE DATA WILL BE BOUND TO
        int[] to = new int[] { R.id.bandNames};

        // CREATE THE ADAPTER USING THE CURSOR POINTING TO THE DESIRED DATA AS WELL AS THE LAYOUT INFORMATION
        SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.listview_item_bands_ttoz, cursor, columns, to);

        return myAdapter;


    }




    public void visitSiteAtoj(View view){

        db.open();

        ListView list = (ListView)findViewById(R.id.listViewBands0);
        int position = list.getPositionForView(view);
        Cursor mCursor = db.getAtoj();
        mCursor.move(position + 1);
        String var = mCursor.getString(5);
        Uri uri = Uri.parse(var);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        db.close();

    }

    public void visitSiteKtos(View view){

        db.open();

        ListView list = (ListView)findViewById(R.id.listViewBands1);
        int position = list.getPositionForView(view);

        Cursor mCursor = db.getKtos();
        mCursor.move(position + 1);

        String var = mCursor.getString(5);


        Uri uri = Uri.parse(var);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        db.close();

    }

    public void visitSiteTtoz(View view){

        db.open();

        ListView list = (ListView)findViewById(R.id.listViewBands2);
        int position = list.getPositionForView(view);
        System.out.println("Current List View Position" + position);
        Cursor mCursor = db.getTtoz();
        mCursor.move(position + 1);

        String var = mCursor.getString(5);

        System.out.println("Current List View Position" + position);
        Uri uri = Uri.parse(var);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        db.close();

    }



}
