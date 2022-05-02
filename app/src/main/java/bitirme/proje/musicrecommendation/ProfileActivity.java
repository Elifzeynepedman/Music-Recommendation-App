package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView HomeImg,CamImg,LibImg;
    private TextView HomeText,CamText,LibText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        HomeImg=(ImageView) findViewById(R.id.HomeImg);
        CamImg=(ImageView) findViewById(R.id.CamImg);
        LibImg=(ImageView) findViewById(R.id.LibImg);
        HomeText=(TextView) findViewById(R.id.HomepageDirect);
        CamText=(TextView) findViewById(R.id.OpenCameraDirect);
        LibText=(TextView) findViewById(R.id.LibraryDirect);

        HomeImg.setOnClickListener(this);
        CamImg.setOnClickListener(this);
        LibImg.setOnClickListener(this);




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
            case R.id.LibraryDirect:
                break;

        }

    }
}