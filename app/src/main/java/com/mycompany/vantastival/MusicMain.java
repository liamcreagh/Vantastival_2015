package com.mycompany.vantastival;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.logging.Handler;


public class MusicMain extends ActionBarActivity implements AdapterView.OnItemClickListener{



    int[] tracks = new int[8];
    ListView listViewMP;
    int currentTrack = 0;

    String items;
    String[] nameArtist = {"Fight Fire with Fire By Metallica", "Ride the Lightning by Metallica", "For whom the bell tolls by Metallica", "Fade to Black By Metallica", "Escape by Metallica", "Trapped Under Ice by Metallica", "Creeping Death By Metallica", "Call of Ktulu by Metallica"};
    MediaPlayer mediaPlayer = null;
    int currentPost = 0;

    SeekBar seekBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_main);

        findSongs();

        /*
        for(int i = 0; i < mySongs.length; i++){
            toast(mySongs[1].toString());
        }
        */


        listViewMP = (ListView) findViewById(R.id.listViewMusicPlayer);
        listViewMP.setSelector(R.drawable.listselector);
        ArrayAdapter<String> adaptedArray = new ArrayAdapter<String>(this, R.layout.listview_music, R.id.textViewSong,  nameArtist);
        listViewMP.setAdapter(adaptedArray);

        // error shows - implement "AdapterView.OnItemClickListener" interface
        listViewMP.setOnItemClickListener(this);

        seekBar = (SeekBar) findViewById(R.id.seekBar);




    }


    public void findSongs(){




        // MediaPlayer song1 = MediaPlayer.create(this, R.raw.fire);
        // MediaPlayer song2 = MediaPlayer.create(this, R.raw.lightning);
        // MediaPlayer song3 = MediaPlayer.create(this, R.raw.bells);


        tracks[0] = R.raw.fire;
        tracks[1] = R.raw.lightning;
        tracks[2] = R.raw.bells;
        tracks[3] = R.raw.fade;
        tracks[4] = R.raw.escape;
        tracks[5] = R.raw.trapped;
        tracks[6] = R.raw.creeping;
        tracks[7] = R.raw.ktulu;



        mediaPlayer = MediaPlayer.create(this, tracks[currentTrack]);




        // return mediaPlayer;
    }








/*
    public void playPauseMusic(int i) {



        if(mediaPlayer.isPlaying()){
           // mySongs.selectTrack(i);
            mediaPlayer.pause();

            // imgButton.setImageResource(R.drawable.pause);
        } else {
            mediaPlayer = MediaPlayer.create(this, tracks[i]);
            // mySongs.selectTrack(i);
            mediaPlayer.start();
            // imgButton.setImageResource(R.drawable.play);
        }

    }

    */










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_music_main, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        currentPost = position;

        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, tracks[position]);
        mediaPlayer.start();


    }


    public void onPlayPause(View view){

        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        } else {
          //   mediaPlayer.reset();
         //    mediaPlayer = MediaPlayer.create(this, tracks[currentPost]);
            mediaPlayer.start();
        };


    }
    public void onBack(View view){



        if(!(currentPost == 0)){currentPost--;}


        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, tracks[currentPost]);
        mediaPlayer.start();};



    public void onForward(View view){
        if(!(currentPost == 7)){currentPost++;}

        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, tracks[currentPost]);
        mediaPlayer.start();


    }






    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }


}
