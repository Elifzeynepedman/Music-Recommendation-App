package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.HomeImg:
                startActivity(new Intent(this, ForgotPassword.class));
                break;
            case R.id.CamImg:
                startActivity(new Intent(this, CameraFragment.class));
                break;
            case R.id.LibraryDirect:
                break;

        }

    }
}