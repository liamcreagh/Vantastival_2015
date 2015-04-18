package com.mycompany.vantastival;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;


public class MusicMain extends ActionBarActivity implements AdapterView.OnItemClickListener{


    // Defines all instance variables used in Music Player
    int[] tracks = new int[12];
    ListView listViewMP;
    int currentTrack = 0;


    String items;
    String[] nameArtist = {"Call Me (Blondie Cover) - Kingdom of Crows", "Red Moon Bayonets - Bayonets", "Get Better(remix) - Swedish Railway Orchestra", "Closing Time - Graham Sweeney", "Dig Up - After The Ibis", "All I Want - We Were Giants", "More Than You Can Chew - Featuring X", "Danny Thompson Carry on - The Well Dressed Hobos", "Not Everyone That Wanders Is Lost(live) - Majestic-Bears", "Cooleys - Na Tonnta", "Don't Stand So Close - Beached Whales", "Whole Lotta Foxy Lady (live) - Evil Presidentes"};
    MediaPlayer mediaPlayer = null;
    int currentPost = 0;

    TextView nowPlaying;
    Button playPause;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_main);

        findSongs();
        nowPlaying =(TextView) findViewById(R.id.nowPlaying);
        playPause = (Button) findViewById(R.id.buttonPlayPause);



        // Programmatically styles Action Bar as Class Extends ActionbarActivity
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff2196F3));


        listViewMP = (ListView) findViewById(R.id.listViewMusicPlayer);

        ArrayAdapter<String> adaptedArray = new ArrayAdapter<String>(this, R.layout.listview_music, R.id.textViewSong,  nameArtist);
        listViewMP.setAdapter(adaptedArray);

        // error shows - implement "AdapterView.OnItemClickListener" interface
        listViewMP.setOnItemClickListener(this);






    }


    public void findSongs(){




        // MediaPlayer song1 = MediaPlayer.create(this, R.raw.fire);
        // MediaPlayer song2 = MediaPlayer.create(this, R.raw.lightning);
        // MediaPlayer song3 = MediaPlayer.create(this, R.raw.bells);


        tracks[0] = R.raw.koc;
        tracks[1] = R.raw.bayonets;
        tracks[2] = R.raw.swedish;
        tracks[3] = R.raw.sweeney;
        tracks[4] = R.raw.ibis;
        tracks[5] = R.raw.giants;
        tracks[6] = R.raw.featuring;
        tracks[7] = R.raw.hobos;
        tracks[8] = R.raw.bears;
        tracks[9] = R.raw.tonnta;
        tracks[10] = R.raw.whales;
        tracks[11] = R.raw.evil;



        mediaPlayer = MediaPlayer.create(this, tracks[currentTrack]);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {

                getNextSong();

            }
        });




        // return mediaPlayer;
    }

















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




    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




        currentPost = position;

        playPause.setText("Pause");
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, tracks[position]);
        mediaPlayer.start();
        nowPlaying.setText("Now Playing:\n" + nameArtist[currentPost]);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {

                getNextSong();

            }
        });


    }


    public void onPlayPause(View view){

        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            playPause.setText("Play");
        } else {
        /*    mediaPlayer.reset();
            mediaPlayer = MediaPlayer.create(this, tracks[currentPost]);
            mediaPlayer.start();
            */
            mediaPlayer.start();
            nowPlaying.setText("Now Playing:\n" + nameArtist[currentPost]);
            playPause.setText("Pause");
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {

                    getNextSong();

                }
            });

        }


    }
    public void onBack(View view){



        if(!(currentPost == 0)){currentPost--;}


        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, tracks[currentPost]);
        mediaPlayer.start();
        nowPlaying.setText("Now Playing:\n" + nameArtist[currentPost]);
        playPause.setText("Pause");
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {

                getNextSong();

            }
        });


        }











    public void onForward(View view) throws InterruptedException {
        if(!(currentPost == 11)){currentPost++;}

        mediaPlayer.reset();

        mediaPlayer = MediaPlayer.create(this, tracks[currentPost]);
       // songTime = mediaPlayer.getDuration();
        mediaPlayer.start();
        nowPlaying.setText("Now Playing:\n" + nameArtist[currentPost]);
        //wait(songTime);
        playPause.setText("Pause");
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {

                getNextSong();

            }
        });


    }



public void getNextSong(){
    if(!(currentPost == 11)){currentPost++;}
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, tracks[currentPost]);
        mediaPlayer.start();
    nowPlaying.setText("Now Playing:\n" + nameArtist[currentPost]);
}




    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();

    }


}
