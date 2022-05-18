package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView HomeImg,CamImg,LibImg,imagePlayPause;
    private TextView HomeText,CamText,LibText;
    private TextView songArtist,songName;

    //YİĞİT TARAFINDAN EKLENENLER
    private final Handler handler = new Handler();
    private MediaPlayer mediaPlayer;
    private TextView textTotalDuration, textCurrentTime;
    private ImageView songArt;
    private SeekBar playSeekBar;
    FirebaseDatabase firebaseDatabase;
    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;
    private Song song = new Song();
    private ImageView nextBtn, prevBtn;
    //---------------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        HomeImg=(ImageView) findViewById(R.id.HomeImg);
        CamImg=(ImageView) findViewById(R.id.CamImg);
        LibImg=(ImageView) findViewById(R.id.LibImg);
        HomeText=(TextView) findViewById(R.id.HomepageDirect);
        CamText=(TextView) findViewById(R.id.OpenCameraDirect);
        LibText=(TextView) findViewById(R.id.LibraryDirect);
        imagePlayPause=(ImageView) findViewById(R.id.playPauseImg);

        HomeImg.setOnClickListener(this);
        CamImg.setOnClickListener(this);
        LibImg.setOnClickListener(this);

        //YİĞİT TARAFINDAN EKLENENLER
        mediaPlayer = new MediaPlayer();
        textCurrentTime=(TextView) findViewById(R.id.startTime);
        textTotalDuration=(TextView) findViewById(R.id.endTime);
        playSeekBar = (SeekBar) findViewById(R.id.playSeekBar);
        songArt = (ImageView) findViewById(R.id.songImage);
        songName = (TextView) findViewById(R.id.songName);
        songArtist = (TextView) findViewById(R.id.songArtist);
        nextBtn = (ImageView) findViewById(R.id.nextBtn);
        prevBtn = (ImageView) findViewById(R.id.previousBtn);

        //---------------

        imagePlayPause.setOnClickListener(view -> {
            //prepareMediaPlayer();
            if(mediaPlayer.isPlaying()){                                //eğer şarkı çalıyosa
                handler.removeCallbacks(updateSeekBar);                 //update seek bar
                mediaPlayer.pause();                                    //durdur
                imagePlayPause.setImageResource(R.drawable.play_icon);  //play resmi göster
            }else{                                                      //eğer şarkı çalmıyosa
                imagePlayPause.setImageResource(R.drawable.ic_pause);   //durdur resmi göster
                if(mediaPlayer.getCurrentPosition()>0){                 //eğer şarkı ilk defa açılmadıysa
                    mediaPlayer.start();                                //devam ettir
                    handler.postDelayed(updateSeekBar, 15);    //update seek bar
                }else{                                                   //eğer şarkı ilk defa açılıyosa
                    play_song(false, false);
                }
            }
        });

        prevBtn.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                mediaPlayer.reset();
                play_song(false,false);
                imagePlayPause.setImageResource(R.drawable.ic_pause);
            }else{
                mediaPlayer.pause();
                mediaPlayer.reset();
                play_song(true,false);
                imagePlayPause.setImageResource(R.drawable.ic_pause);
            }
        });
        nextBtn.setOnClickListener(view -> {
            mediaPlayer.pause();
            mediaPlayer.reset();
            play_song(false,true);
            imagePlayPause.setImageResource(R.drawable.ic_pause);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch(item.getItemId()){
                case R.id.profile:
                    startActivity(new Intent(ProfileActivity.this,SettingsProfile.class));
                    return true;
                case R.id.logout:
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.HomeImg:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.CamImg:
                startActivity(new Intent(this, CameraFragment.class));
                break;
            case R.id.LibImg:
                startActivity(new Intent(this, Library.class));
                break;
        }
    }

    private Runnable updateSeekBar = new Runnable() {
        public void run() {
            long totalDuration = mediaPlayer.getDuration();
            long currentDuration = mediaPlayer.getCurrentPosition();

            textTotalDuration.setText(""+ milliSecondsToTimer(totalDuration));      // Displays Total Duration
            textCurrentTime.setText(""+ milliSecondsToTimer(currentDuration));      // Displays Current Duration

            playSeekBar.setProgress((int)currentDuration);                          // Updates progress bar

            handler.postDelayed(this, 15);                              // calls this after 15 milliseconds
        }
    };


    public String milliSecondsToTimer(long milliseconds){               //Converts milliseconds into mm:ss format
        String finalTimerString = "";
        String secondsString = "";

        int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
        if(seconds < 10) {
            secondsString = "0" + seconds;
        }else{
            secondsString = "" + seconds;
        }
        finalTimerString = finalTimerString + minutes + ":" + secondsString;
        return finalTimerString;
    }

    int songNo = 3;

    public void play_song(boolean prev, boolean next){
        try {

            Random songRandomizer = new Random();
            int randomNumber = songRandomizer.nextInt(5);
            if(prev){
                //randomNumber--;
                songNo--;
            }else if(next){
                //randomNumber++;
                songNo++;
            }
            setSongInformation(songNo);           //SIKINTI YARATABİLİR


            String chosenSong = song.getSongURL(songNo);           //SIKINTI YARATABİLİR
            //String chosenSong = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FCAN'T%20STOP%20THE%20FEELING!%20-%20Justin%20Timberlake%20(Lyrics)%20.mp3?alt=media&token=7240c4cc-152d-4c23-85eb-157eb67a1628";
            mediaPlayer.setDataSource(chosenSong);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try{
                        mediaPlayer.start();
                        playSeekBar.setProgress(0);
                        playSeekBar.setMax(mediaPlayer.getDuration());

                        // Updating progress bar
                        handler.postDelayed(updateSeekBar, 15);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            });

            mediaPlayer.prepare();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setSongInformation(int i){
        String songPath = song.getSongImage(i);
        Picasso.get().load(songPath).into(songArt);      //displays the song art
        songName.setText(song.getSongNames(i));         //displays the song name
        songArtist.setText(song.getSongArtist(i));      //displays the song artist
    }



}