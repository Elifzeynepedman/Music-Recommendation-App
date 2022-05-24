package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;



public class Playlist extends AppCompatActivity implements View.OnClickListener {

    public TextView playlistName, songNameArtistText, duration;
    private ImageView startPlaylist, songImage1, songImage2,  songImage3, songImage4, songImage5, songImage6, songImage7, songImage8, songImage9, songImage10;
    private TextView nameOfSong1, nameOfSong2, nameOfSong3, nameOfSong4, nameOfSong5, nameOfSong6, nameOfSong7, nameOfSong8, nameOfSong9, nameOfSong10;
    private TextView duration1, duration2, duration3, duration4, duration5, duration6, duration7, duration8, duration9, duration10;
    private TextView nameOfArtist1, nameOfArtist2, nameOfArtist3, nameOfArtist4, nameOfArtist5, nameOfArtist6, nameOfArtist7, nameOfArtist8, nameOfArtist9, nameOfArtist10;
    private ImageView HomeImg, CamImg, LibImg;

    private Song song = new Song();

    private int mood=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        playlistName = (TextView) Playlist.this.findViewById(R.id.nameofPlaylist);
        songNameArtistText = (TextView) findViewById(R.id.songNameArtistText);
        duration = (TextView) findViewById(R.id.duration);
        nameOfSong1 = (TextView) findViewById(R.id.nameOfSong1);
        nameOfSong2 = (TextView) findViewById(R.id.nameOfSong2);
        nameOfSong3 = (TextView) findViewById(R.id.nameOfSong3);
        nameOfSong4 = (TextView) findViewById(R.id.nameOfSong4);
        nameOfSong5 = (TextView) findViewById(R.id.nameOfSong5);
        nameOfSong6 = (TextView) findViewById(R.id.nameOfSong6);
        nameOfSong7 = (TextView) findViewById(R.id.nameOfSong7);
        nameOfSong8 = (TextView) findViewById(R.id.nameOfSong8);
        nameOfSong9 = (TextView) findViewById(R.id.nameOfSong9);
        nameOfSong10 = (TextView) findViewById(R.id.nameOfSong10);
        duration1 = (TextView) findViewById(R.id.duration1);
        duration2 = (TextView) findViewById(R.id.duration2);
        duration3 = (TextView) findViewById(R.id.duration3);
        duration4 = (TextView) findViewById(R.id.duration4);
        duration5 = (TextView) findViewById(R.id.duration5);
        duration6 = (TextView) findViewById(R.id.duration6);
        duration7 = (TextView) findViewById(R.id.duration7);
        duration8 = (TextView) findViewById(R.id.duration8);
        duration9 = (TextView) findViewById(R.id.duration9);
        duration10 = (TextView) findViewById(R.id.duration10);
        nameOfArtist1 = (TextView) findViewById(R.id.nameOfArtist1);
        nameOfArtist2 = (TextView) findViewById(R.id.nameOfArtist2);
        nameOfArtist3 = (TextView) findViewById(R.id.nameOfArtist3);
        nameOfArtist4 = (TextView) findViewById(R.id.nameOfArtist4);
        nameOfArtist5 = (TextView) findViewById(R.id.nameOfArtist5);
        nameOfArtist6 = (TextView) findViewById(R.id.nameOfArtist6);
        nameOfArtist7 = (TextView) findViewById(R.id.nameOfArtist7);
        nameOfArtist8 = (TextView) findViewById(R.id.nameOfArtist8);
        nameOfArtist9 = (TextView) findViewById(R.id.nameOfArtist9);
        nameOfArtist10 = (TextView) findViewById(R.id.nameOfArtist10);
        startPlaylist = (ImageView) findViewById(R.id.startPlaylist);
        songImage1 = (ImageView) findViewById(R.id.songImage1);
        songImage2 = (ImageView) findViewById(R.id.songImage2);
        songImage3 = (ImageView) findViewById(R.id.songImage3);
        songImage4 = (ImageView) findViewById(R.id.songImage4);
        songImage5 = (ImageView) findViewById(R.id.songImage5);
        songImage6 = (ImageView) findViewById(R.id.songImage6);
        songImage7 = (ImageView) findViewById(R.id.songImage7);
        songImage8 = (ImageView) findViewById(R.id.songImage8);
        songImage9 = (ImageView) findViewById(R.id.songImage9);
        songImage10 = (ImageView) findViewById(R.id.songImage10);
        HomeImg = (ImageView) findViewById(R.id.HomeImg);
        CamImg = (ImageView) findViewById(R.id.CamImg);
        LibImg = (ImageView) findViewById(R.id.LibImg);

        CamImg.setOnClickListener(this);
        HomeImg.setOnClickListener(this);
        LibImg.setOnClickListener(this);
        startPlaylist.setOnClickListener(this);

        songImage1.setOnClickListener(this);
        songImage2.setOnClickListener(this);
        songImage3.setOnClickListener(this);
        songImage4.setOnClickListener(this);
        songImage5.setOnClickListener(this);
        songImage6.setOnClickListener(this);
        songImage7.setOnClickListener(this);
        songImage8.setOnClickListener(this);
        songImage9.setOnClickListener(this);
        songImage10.setOnClickListener(this);
        nameOfArtist1.setOnClickListener(this);
        nameOfArtist2.setOnClickListener(this);
        nameOfArtist3.setOnClickListener(this);
        nameOfArtist4.setOnClickListener(this);
        nameOfArtist5.setOnClickListener(this);
        nameOfArtist6.setOnClickListener(this);
        nameOfArtist7.setOnClickListener(this);
        nameOfArtist8.setOnClickListener(this);
        nameOfArtist9.setOnClickListener(this);
        nameOfArtist10.setOnClickListener(this);
        nameOfSong1.setOnClickListener(this);
        nameOfSong2.setOnClickListener(this);
        nameOfSong3.setOnClickListener(this);
        nameOfSong4.setOnClickListener(this);
        nameOfSong5.setOnClickListener(this);
        nameOfSong6.setOnClickListener(this);
        nameOfSong7.setOnClickListener(this);
        nameOfSong8.setOnClickListener(this);
        nameOfSong9.setOnClickListener(this);
        nameOfSong10.setOnClickListener(this);


        Log.d("myTag", "initialization done");

        setPlaylist(mood);















    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
/*
    public void setMood(boolean angry, boolean happy, boolean sad, boolean neutral){
        Log.d("myTag", "setMood ilk satır");
        if(angry)
            mood = 1;
        else if(happy)
            mood = 2;
        else if(sad)
            mood = 3;
        else if(neutral)
            mood = 4;
        Log.d("myTag", "setMood setPlaylist öncesi");
        setPlaylist();
        Log.d("myTag", "setMood setPlaylist sonrası");
    }*/

    public void setMood(int moody){
        mood = moody;
        //return mood;
    }

    public void setPlaylist(int mood){
        Log.d("myTag", "setPlaylist içi ilk satır");
        if(mood == 1){          //angry (0-9)
            Log.d("myTag", "setMood mood == 1 içi ilk satır");
            //setting the playlist name
            java.lang.CharSequence charSequence = "Angry Playlist";

            //playlistName.setText(song.getPlaylistName(1));
            playlistName.setText("Angry Playlist");

            //setting the song images
            String songPath = song.getSongImage(0);
            Picasso.get().load(songPath).into(songImage1);
            songPath = song.getSongImage(1);
            Picasso.get().load(songPath).into(songImage2);
            songPath = song.getSongImage(2);
            Picasso.get().load(songPath).into(songImage3);
            songPath = song.getSongImage(3);
            Picasso.get().load(songPath).into(songImage4);
            songPath = song.getSongImage(4);
            Picasso.get().load(songPath).into(songImage5);
            songPath = song.getSongImage(5);
            Picasso.get().load(songPath).into(songImage6);
            songPath = song.getSongImage(6);
            Picasso.get().load(songPath).into(songImage7);
            songPath = song.getSongImage(7);
            Picasso.get().load(songPath).into(songImage8);
            songPath = song.getSongImage(8);
            Picasso.get().load(songPath).into(songImage9);
            songPath = song.getSongImage(9);
            Picasso.get().load(songPath).into(songImage10);

            //setting the song names
            nameOfSong1.setText(song.getSongNames(0));
            nameOfSong2.setText(song.getSongNames(1));
            nameOfSong3.setText(song.getSongNames(2));
            nameOfSong4.setText(song.getSongNames(3));
            nameOfSong5.setText(song.getSongNames(4));
            nameOfSong6.setText(song.getSongNames(5));
            nameOfSong7.setText(song.getSongNames(6));
            nameOfSong8.setText(song.getSongNames(7));
            nameOfSong9.setText(song.getSongNames(8));
            nameOfSong10.setText(song.getSongNames(9));

            //setting the artist names
            nameOfArtist1.setText(song.getSongArtist(0));
            nameOfArtist2.setText(song.getSongArtist(1));
            nameOfArtist3.setText(song.getSongArtist(2));
            nameOfArtist4.setText(song.getSongArtist(3));
            nameOfArtist5.setText(song.getSongArtist(4));
            nameOfArtist6.setText(song.getSongArtist(5));
            nameOfArtist7.setText(song.getSongArtist(6));
            nameOfArtist8.setText(song.getSongArtist(7));
            nameOfArtist9.setText(song.getSongArtist(8));
            nameOfArtist10.setText(song.getSongArtist(9));



            //setting the song durations


        }else if(mood == 2){    //happy (10-19)
            playlistName.setText("Happy Playlist");
        }else if(mood == 3){    //sad (20-29)
            playlistName.setText("Sad Playlist");
        }else if(mood == 4){    //neutral
            playlistName.setText("Neutral Playlist");
        }
    }

    //BURAYA KADAR AAAAAAAAAAA GERİ ALABİLİRSİN AAAAAAAAAAAAAAA

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.profile:
                startActivity(new Intent(Playlist.this,SettingsProfile.class));
                return true;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Playlist.this,MainActivity.class));
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
            case R.id.songImage1:
            case R.id.nameOfArtist1:
            case R.id.nameOfSong1:
                //do something
                break;
            case R.id.songImage2:
            case R.id.nameOfArtist2:
            case R.id.nameOfSong2:
                //do something
                break;
            case R.id.songImage3:
            case R.id.nameOfArtist3:
            case R.id.nameOfSong3:
                //do something
                break;
            case R.id.songImage4:
            case R.id.nameOfArtist4:
            case R.id.nameOfSong4:
                //do something
                break;
            case R.id.songImage5:
            case R.id.nameOfArtist5:
            case R.id.nameOfSong5:
                //do something
                break;
            case R.id.songImage6:
            case R.id.nameOfArtist6:
            case R.id.nameOfSong6:
                //do something
                break;
            case R.id.songImage7:
            case R.id.nameOfArtist7:
            case R.id.nameOfSong7:
                //do something
                break;
            case R.id.songImage8:
            case R.id.nameOfArtist8:
            case R.id.nameOfSong8:
                //do something
                break;
            case R.id.songImage9:
            case R.id.nameOfArtist9:
            case R.id.nameOfSong9:
                //do something
                break;
            case R.id.songImage10:
            case R.id.nameOfArtist10:
            case R.id.nameOfSong10:
                //do something
                break;
            case R.id.startPlaylist:
                //do something
                break;
        }
    }



}
