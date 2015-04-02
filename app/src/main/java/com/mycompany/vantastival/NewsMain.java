package com.mycompany.vantastival;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.mycompany.vantastival.stab.NewsFragmentPagerAdapter;
import com.mycompany.vantastival.stab.SlidingTabLayout;


public class NewsMain extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);



        ViewPager viewPager = (ViewPager) findViewById(R.id.newsViewPager);
        viewPager.setAdapter(new NewsFragmentPagerAdapter(getSupportFragmentManager(), NewsMain.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.newsTabs);
        slidingTabLayout.setViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
