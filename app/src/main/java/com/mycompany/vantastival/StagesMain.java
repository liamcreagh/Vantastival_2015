package com.mycompany.vantastival;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class StagesMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages_main);
    }


    public void getMainStage(View view) {
        Intent intent = new Intent(this, StagesMainstage.class);
        startActivity(intent);

    }

    public void getVanhallaStage(View view) {
        Intent intent = new Intent(this, StagesVanhalla.class);
        startActivity(intent);
    }
    public void getMusicmakerStage(View view) {
        Intent intent = new Intent(this, StagesMusicmaker.class);
        startActivity(intent);
    }
    public void getUnpluggedStage(View view) {
        Intent intent = new Intent(this, StagesUnplugged.class);
        startActivity(intent);
    }
    public void getMelomaniaStage(View view) {
        Intent intent = new Intent(this, StagesMelomania.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stages_main, menu);
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
