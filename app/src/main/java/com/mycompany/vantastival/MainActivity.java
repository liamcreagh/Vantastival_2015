package com.mycompany.vantastival;

import android.app.Activity;
import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

// import com.mycompany.vantastival.db.AssignmentTracker;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    ListView mainMenu;




    // Data source in a string based array
    String[] menuItems = {"Stages", "Bands", "Info", "Map", "Music", "Location"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        // Creating a List View
        // Get the ListView From the xml layout via its ID
        mainMenu = (ListView) findViewById(R.id.mainMenulistView);

        // Create an adapter 3 parameters - (this, layout, dataset)


        ArrayAdapter<String> adaptedArray = new ArrayAdapter<String>(this, R.layout.listview_mainmenu, R.id.mainMenuItem,  menuItems);



        mainMenu.setAdapter(adaptedArray);

        // error shows - implement "AdapterView.OnItemClickListener" interface
        mainMenu.setOnItemClickListener(this);


























        class DBAdapter extends BaseAdapter {
            private LayoutInflater mInflater;


            //private ArrayList<>

            @Override
            public int getCount() {




                return 0;
            }

            @Override
            public Object getItem(int arg0) {

                return null;
            }

            @Override
            public long getItemId(int arg0) {

                return 0;
            }

            @Override
            public View getView(int arg0, View arg1, ViewGroup arg2) {

                return null;
            }

        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_back) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    // what happens when Item in the list is clicked
    // 4 parameters to be filled onItemClick()
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //TextView temp = (TextView) view;
        //Toast.makeText(this, temp.getText() + " ", Toast.LENGTH_SHORT).show();

        Intent menuClicked;
        menuClicked = new Intent(this, MainActivity.class);

        switch (position) {
            case 0:
                menuClicked = new Intent(this, StagesMain.class);
                break;
            case 1:
                menuClicked = new Intent(this, BandMain.class);
                break;
            case 2:
                menuClicked = new Intent(this, InfoMain.class);
                break;
            case 3:
                menuClicked = new Intent(this, MapMain.class);
                break;
            case 4:
                menuClicked = new Intent(this, MusicMain.class);
                break;
            case 5:
                menuClicked = new Intent(this, LocationActivity.class);
                break;
        } // end of switch
        startActivity(menuClicked);
    } // end of "onItemClick()" method



    //  SGLite Methods







    public void getFacebook(View view){
        Uri uri = Uri.parse("https://www.facebook.com/Vantastivalfestival");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }



    public void getTwitter(View view){
        Uri uri = Uri.parse("https://twitter.com/vantastival");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    // end of methods



} // end of public class "MainActivity" class

