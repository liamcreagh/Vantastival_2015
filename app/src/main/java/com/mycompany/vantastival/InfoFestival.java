package com.mycompany.vantastival;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mycompany.vantastival.tabs.FestivalFragmentPagerAdapter;

import com.mycompany.vantastival.tabs.SlidingTabLayout;


public class InfoFestival extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_festival);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(0xff2196F3));


        ViewPager viewPager = (ViewPager) findViewById(R.id.festivalViewPager);
        viewPager.setAdapter(new FestivalFragmentPagerAdapter(getSupportFragmentManager(), InfoFestival.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.festivalTabs);
        slidingTabLayout.setViewPager(viewPager);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_festival, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_back) {

            Intent contact = new Intent(this, InfoMain.class);
            startActivity(contact);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}