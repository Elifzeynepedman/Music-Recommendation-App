package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;



public class Library extends AppCompatActivity implements View.OnClickListener {

    private ImageView happyPlaylistImage, sadPlaylistImage, angryPlaylistImage, neutralPlaylistImage, HomeImg, CamImg, LibImg;
    private TextView happyPlaylist, sadPlaylist, angryPlaylist, neutralPlaylist;

    private Playlist playlist = new Playlist();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        happyPlaylistImage = (ImageView) findViewById(R.id.happyPlaylistImage);
        sadPlaylistImage = (ImageView) findViewById(R.id.sadPlaylistImage);
        angryPlaylistImage = (ImageView) findViewById(R.id.angryPlaylistImage);
        neutralPlaylistImage = (ImageView) findViewById(R.id.neutralPlaylistImage);

        HomeImg = (ImageView) findViewById(R.id.HomeImg);
        CamImg = (ImageView) findViewById(R.id.CamImg);
        LibImg = (ImageView) findViewById(R.id.LibImg);

        happyPlaylist = (TextView) findViewById(R.id.happyPlaylist);
        sadPlaylist = (TextView) findViewById(R.id.sadPlaylist);
        angryPlaylist = (TextView) findViewById(R.id.angryPlaylist);
        neutralPlaylist = (TextView) findViewById(R.id.neutralPlaylist);




        happyPlaylistImage.setOnClickListener(this);
        sadPlaylistImage.setOnClickListener(this);
        angryPlaylistImage.setOnClickListener(this);
        neutralPlaylistImage.setOnClickListener(this);

        CamImg.setOnClickListener(this);
        HomeImg.setOnClickListener(this);
        LibImg.setOnClickListener(this);

        happyPlaylist.setOnClickListener(this);
        sadPlaylist.setOnClickListener(this);
        angryPlaylist.setOnClickListener(this);
        neutralPlaylist.setOnClickListener(this);








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
                startActivity(new Intent(Library.this,SettingsProfile.class));
                return true;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Library.this,MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.HomeImg:
                startActivity(new Intent(Library.this, ProfileActivity.class));
                break;
            case R.id.CamImg:
                startActivity(new Intent(Library.this, CameraFragment.class));
                break;
            case R.id.LibImg:
                startActivity(new Intent(Library.this, Library.class));
                break;
            case R.id.happyPlaylistImage:
                String moodH1="happy";
                Intent iH1 = new Intent(Library.this, Playlist.class);
                iH1.putExtra("key", moodH1);
                startActivity(iH1);
                break;
            case R.id.happyPlaylist:
                String moodH2="happy";
                Intent iH2 = new Intent(Library.this, Playlist.class);
                iH2.putExtra("key", moodH2);
                startActivity(iH2);
                break;
            case R.id.sadPlaylistImage:
                String moodS1="sad";
                Intent iS1 = new Intent(Library.this, Playlist.class);
                iS1.putExtra("key", moodS1);
                startActivity(iS1);
                break;
            case R.id.sadPlaylist:
                String moodS2="sad";
                Intent iS2 = new Intent(Library.this, Playlist.class);
                iS2.putExtra("key", moodS2);
                startActivity(iS2);
                break;
            case R.id.angryPlaylistImage:
                String moodA1="angry";
                Intent iA1 = new Intent(Library.this, Playlist.class);
                iA1.putExtra("key", moodA1);
                startActivity(iA1);
                break;
            case R.id.angryPlaylist:
                String moodA2="angry";
                Intent iA2 = new Intent(Library.this, Playlist.class);
                iA2.putExtra("key", moodA2);
                startActivity(iA2);
                break;
            case R.id.neutralPlaylistImage:
                String moodN1="neutral";
                Intent iN1 = new Intent(Library.this, Playlist.class);
                iN1.putExtra("key", moodN1);
                startActivity(iN1);
                break;
            case R.id.neutralPlaylist:
                String moodN2="neutral";
                Intent iN2 = new Intent(Library.this, Playlist.class);
                iN2.putExtra("key", moodN2);
                startActivity(iN2);
                break;
        }
    }


}
