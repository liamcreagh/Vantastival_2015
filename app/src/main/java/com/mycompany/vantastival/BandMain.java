package com.mycompany.vantastival;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mycompany.vantastival.stab.BandsFragmentPagerAdapter;
import com.mycompany.vantastival.stab.NewsFragmentPagerAdapter;
import com.mycompany.vantastival.stab.SlidingTabLayout;


public class BandMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bands_main);



        ViewPager viewPager = (ViewPager) findViewById(R.id.bandsViewPager);
        viewPager.setAdapter(new BandsFragmentPagerAdapter(getSupportFragmentManager(), BandMain.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.bandsTabs);
        slidingTabLayout.setViewPager(viewPager);

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
}