package com.mycompany.vantastival;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mycompany.vantastival.rss.ListListener;
import com.mycompany.vantastival.rss.RssItem;
import com.mycompany.vantastival.rss.RssReader;
import com.mycompany.vantastival.stab.NewsFragmentPagerAdapter;
import com.mycompany.vantastival.stab.SlidingTabLayout;


public class NewsMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);



        ViewPager viewPager = (ViewPager) findViewById(R.id.newsViewPager);
        viewPager.setAdapter(new NewsFragmentPagerAdapter(getSupportFragmentManager(), NewsMain.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.newsTabs);
        slidingTabLayout.setViewPager(viewPager);



        try {
            // Create RSS reader
            RssReader rssReader = new RssReader("http://www.itcuties.com/feed/");
            // Get a ListView from main view
            ListView itcItems = (ListView) findViewById(R.id.listViewTwitter);
            // Create a list adapter
            ArrayAdapter adapter = new ArrayAdapter<RssItem>(this,android.R.layout.simple_list_item_1, rssReader.getItems());
            // Set list adapter for the ListView
            itcItems.setAdapter(adapter);
            // Set list view item click listener
            itcItems.setOnItemClickListener(new ListListener(rssReader.getItems(), this));
        } catch (Exception e) {
            Log.e("ITCRssReader", e.getMessage());
        }


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

        if (id == R.id.action_back) {

            Intent contact = new Intent(this, MainActivity.class);
            startActivity(contact);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
