package com.mycompany.vantastival;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import android.widget.Toast;

// import com.mycompany.vantastival.db.AssignmentTracker;
import com.mycompany.vantastival.db.DBAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ListView mainMenu;

    DBAdapter db = new DBAdapter(this);
    public static String PACKAGE_NAME;

    // Data source in a string based array
    String[] menuItems = {"Stages", "Bands", "Info", "Map", "Music"};

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






        PACKAGE_NAME = getPackageName();


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
        db.open();
 if(db.isPopulated()){}
       else {




    // Param (Band Name, Stage, Day, Time, Description)
    long id = db.insertRecord("Delorentos", "main", "fri", "10:20", "Mop Top");
    id = db.insertRecord("Goldie Looking Chain", "main", "sat", "12:20", "Bonos on the edge");
    id = db.insertRecord("Jinx Lennon", "van", "sat", "13:20", "Whole lotta Vans");
    id = db.insertRecord("R.S.A.G.", "van", "sat", "14:20", "Hotel Talifornia");
    id = db.insertRecord("King Kong Company", "main", "sat", "15:20", "Which ones pink?");
    id = db.insertRecord("Rackhouse Pilfer", "main", "sun", "16:20", "The airbourne tribute act");
    id = db.insertRecord("The Flaws", "van", "sat", "17:20", "Bonos on the edge");
    id = db.insertRecord("Cry Monster Cry", "main", "fri", "18:20", "The bands named queen. . . . . Were you really surprised");
    id = db.insertRecord("Bunoscionn", "main", "sat", "17:20", "Bonos on the edge");
    id = db.insertRecord("The Crayon Set", "van", "sun", "19:20", "Swedish and bad");
    id = db.insertRecord("New Secret Weapon", "main", "sun", "10:20", "Mop Top");
     id = db.insertRecord("Eoin Dillon", "main", "sat", "12:20", "Bonos on the edge");
     id = db.insertRecord("I\'m Your Vinyl", "van", "sun", "13:20", "Whole lotta Vans");
     id = db.insertRecord("Tecimerico", "van", "sat", "14:20", "Hotel Talifornia");
     id = db.insertRecord("Corner Boy", "main", "sat", "15:20", "Which ones pink?");
     id = db.insertRecord("Black Svan", "main", "fri", "16:20", "The airbourne tribute act");
     id = db.insertRecord("Fierce Mild", "van", "sat", "17:20", "Bonos on the edge");
     id = db.insertRecord("Rudy Trixx", "main", "sun", "18:20", "The bands named queen. . . . . Were you really surprised");
     id = db.insertRecord("The Bonny Men", "main", "sun", "17:20", "Bonos on the edge");
     id = db.insertRecord("The Bionic Rats", "van", "sun", "19:20", "Swedish and bad");
     id = db.insertRecord("Plutonic Dust", "main", "fri", "10:20", "Mop Top");
     id = db.insertRecord("Temper-Mental Misselayneous", "main", "sat", "12:20", "Bonos on the edge");
     id = db.insertRecord("Tell No Foxx", "van", "sat", "13:20", "Whole lotta Vans");
     id = db.insertRecord("Elephant", "van", "sat", "14:20", "Hotel Talifornia");
     id = db.insertRecord("Grouse", "main", "sat", "15:20", "Which ones pink?");
     id = db.insertRecord("The Blood Red Mountain Band", "main", "sun", "16:20", "The airbourne tribute act");
     id = db.insertRecord("Silence Noise Parade", "van", "sat", "17:20", "Bonos on the edge");
     id = db.insertRecord("Cfit", "main", "fri", "18:20", "The bands named queen. . . . . Were you really surprised");
     id = db.insertRecord("Decomposing In Paris", "main", "sun", "17:20", "Bonos on the edge");
     id = db.insertRecord("The Hardchargers", "van", "fri", "19:20", "Swedish and bad");
     id = db.insertRecord("We Raised Bears", "main", "fri", "18:20", "The bands named queen. . . . . Were you really surprised");
     id = db.insertRecord("Let\'s Set Sail", "main", "sun", "17:20", "Bonos on the edge");
     id = db.insertRecord("The Wood Burning Savages", "van", "sat", "19:20", "Swedish and bad");

 }

    db.close();



        //DBAdapter db = new DBAdapter(this);


        //---add an assignment---

















        //---get all Records---
/*
        db.open();
        Cursor c = db.getAllRecords();
        if (c.moveToFirst())
        {
            do {
                DisplayRecord(c);
            } while (c.moveToNext());
        }
        db.close();

*/


        /*
        //---get a Record---
        db.open();
        Cursor c = db.getRecord(2);
        if (c.moveToFirst())
            DisplayRecord(c);
        else
            Toast.makeText(this, "No Assignments found", Toast.LENGTH_LONG).show();
        db.close();
        */


        //---update Record---
        /*
        db.open();
        if (db.updateRecord(1, "Hello Android", "2/19/2012", "DPR 224", "First Android Project"))
            Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
        db.close();
        */

        /*
        //---delete a Record---
        db.open();
        if (db.deleteRecord(1))
            Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
        db.close();
        */


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
        } // end of switch
        startActivity(menuClicked);
    } // end of "onItemClick()" method



    //  SGLite Methods


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

    public void DisplayRecord(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Band Name: " + c.getString(1) + "\n" +
                        "Stage:  " + c.getString(2),
                Toast.LENGTH_SHORT).show();
    }

    public void addAssignment(View view)
    {

        Intent i = new Intent("com.pinchtapzoom.addassignment");
        startActivity(i);
        Log.d("TAG", "Clicked");
    }


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

