package com.mycompany.vantastival.rss;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mycompany.vantastival.R;

import com.mycompany.vantastival.rss.RssItem;
import com.mycompany.vantastival.rss.ListListener;
import com.mycompany.vantastival.rss.RssReader;


/**
 * Main application activity.
 * @author ITCuties
 */
public class TwitterReaderAppActivity extends Activity {
    /**
     * This method creates main application view
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set view
        setContentView(R.layout.news_twitter);
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
}