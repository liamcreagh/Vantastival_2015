package com.mycompany.vantastival;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mycompany.vantastival.db.AssignmentTracker;
import com.mycompany.vantastival.db.addassignment;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ListView mainMenu;

    // Data source in a string based array
    String[] menuItems = {"Stages", "Bands", "Info", "News", "Map", "Music"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Creating a List View
        // Get the ListView From the xml layout via its ID
        mainMenu = (ListView) findViewById(R.id.mainMenulistView);

        // Create an adapter 3 parameters - (this, layout, dataset)


        ArrayAdapter<String> adaptedArray = new ArrayAdapter<String>(this, R.layout.mainmenu_listview, R.id.mainMenuItem,  menuItems);

       // ArrayAdapter<String> adaptedArray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  menuItems);

        mainMenu.setAdapter(adaptedArray);

        // error shows - implement "AdapterView.OnItemClickListener" interface
        mainMenu.setOnItemClickListener(this);





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
                menuClicked = new Intent(this, PopupInfo.class);
                break;
            case 2:
                menuClicked = new Intent(this, InfoMain.class);
                break;
            case 3:
                menuClicked = new Intent(this, AssignmentTracker.class);
                break;
            case 4:
                menuClicked = new Intent(this, addassignment.class);
                break;
            case 5:
                menuClicked = new Intent(this, MusicMain.class);
                break;
        } // end of switch
        startActivity(menuClicked);
    } // end of "onItemClick()" method



} // end of public class "MainActivity" class

