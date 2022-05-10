package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView HomeImg,CamImg,LibImg,songImage;
    private TextView HomeText,CamText,LibText;
    private TextView songArtist,songName;
    DatabaseReference mref;
    MediaPlayer mediaPlayer;
    private CardView playPauseCard;

    ArrayList<String> imageurls=new ArrayList<>();
    ArrayList<String> songnames=new ArrayList<>();
    ArrayList<String> songartists=new ArrayList<>();
    ArrayList<String> songurls=new ArrayList<>();

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
        songArtist=(TextView) findViewById(R.id.songArtist);
        songName=(TextView) findViewById(R.id.songName);
        songImage=(ImageView) findViewById(R.id.songImage);
        playPauseCard=(CardView) findViewById(R.id.playPauseCard);

        HomeImg.setOnClickListener(this);
        CamImg.setOnClickListener(this);
        LibImg.setOnClickListener(this);
        playPauseCard.setOnClickListener(this);
        mref= FirebaseDatabase.getInstance().getReference();


        mref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    imageurls.add(ds.child("imageurl").getValue(String.class));
                    songnames.add(ds.child("songname").getValue(String.class));
                    songartists.add(ds.child("songartist").getValue(String.class));
                }
                for(int i=0;i<imageurls.size();i++){

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
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
                case R.id.help:
                    startActivity(new Intent(ProfileActivity.this,Help.class));
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
            case R.id.LibraryDirect:
                break;
            case R.id.playPauseCard:
                break;

        }

    }


/*
    public void init(int currentItem) {

        try {
            if(mediaPlayer.isPlaying())
                mediaPlayer.reset();
        }catch (Exception e){

        }

       songName.setText(songnames.get(currentItem));
        songArtist.setText(songartists.get(currentItem));

        try {
            mediaPlayer=new MediaPlayer();
           mediaPlayer.setDataSource(songurls.get(currentItem));
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }*/

}