package com.mycompany.vantastival;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mycompany.vantastival.stab.KidsFragmentPagerAdapter;
import com.mycompany.vantastival.stab.SlidingTabLayout;


public class InfoCheckout extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_kids);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(0xff2196F3));

        ViewPager viewPager = (ViewPager) findViewById(R.id.checkoutViewPager);
        viewPager.setAdapter(new KidsFragmentPagerAdapter(getSupportFragmentManager(), InfoCheckout.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.checkoutTabs);
        slidingTabLayout.setViewPager(viewPager);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_checkout, menu);
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
