package com.mycompany.vantastival;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.mycompany.vantastival.db.DBAdapter;

import com.mycompany.vantastival.stab.MainstageFragmentPagerAdapter;
import com.mycompany.vantastival.stab.SlidingTabLayout;


public class StagesMainstage extends ActionBarActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stages_mainstage);


        ViewPager viewPager = (ViewPager) findViewById(R.id.mainstageViewPager);
        viewPager.setAdapter(new MainstageFragmentPagerAdapter(getSupportFragmentManager(), StagesMainstage.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.mainstageTabs);
        slidingTabLayout.setViewPager(viewPager);







    }



















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stages_mainstage, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back) {

            Intent contact = new Intent(this, StagesMain.class);
            startActivity(contact);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
