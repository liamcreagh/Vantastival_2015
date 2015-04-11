package com.mycompany.vantastival;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class InfoMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(0xff2196F3));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_main, menu);
        return true;
    }


    public void getFestivalInfo(View view) {
        Intent intent = new Intent(this, InfoFestival.class);
startActivity(intent);

    }
    public void getTicketsInfo(View view) {
        Intent intent = new Intent(this, InfoTickets.class);
        startActivity(intent);
    }
    public void getVenueInfo(View view) {
        Intent intent = new Intent(this, InfoVenue.class);
        startActivity(intent);
    }
    public void getCampingInfo(View view) {
        Intent intent = new Intent(this, InfoCamping.class);
        startActivity(intent);
    }

    public void getCheckoutInfo(View view) {
        Intent intent = new Intent(this, InfoCheckout.class);
        startActivity(intent);
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


    public void getFacebook(){
        Uri uri = Uri.parse("https://www.facebook.com/Vantastivalfestival");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}
