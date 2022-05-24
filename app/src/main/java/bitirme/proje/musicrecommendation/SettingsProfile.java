package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SettingsProfile extends AppCompatActivity implements View.OnClickListener{

    private FirebaseUser user;
    private DatabaseReference reference;
    private ImageView HomeImg,CamImg,LibImg;
    private TextView HomeText,CamText,LibText;

    private String userID;

    public SettingsProfile() {
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
                startActivity(new Intent(SettingsProfile.this,SettingsProfile.class));
                return true;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SettingsProfile.this,MainActivity.class));
                return true;
            case R.id.help:
                startActivity(new Intent(SettingsProfile.this,Help.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_profile);



        HomeImg=(ImageView) findViewById(R.id.HomeImg);
        CamImg=(ImageView) findViewById(R.id.CamImg);
        LibImg=(ImageView) findViewById(R.id.LibImg);
        HomeText=(TextView) findViewById(R.id.HomepageDirect);
        CamText=(TextView) findViewById(R.id.OpenCameraDirect);
        LibText=(TextView) findViewById(R.id.LibraryDirect);

        HomeImg.setOnClickListener(this);
        CamImg.setOnClickListener(this);
        LibImg.setOnClickListener(this);

        user=FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        userID=user.getUid();

        final TextView nameText=(TextView)findViewById(R.id.profileName);
        final TextView lastNameText=(TextView)findViewById(R.id.profileLastName);
        final TextView emailText=(TextView)findViewById(R.id.profileEmail);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile=snapshot.getValue(User.class);
                if(userProfile!= null){
                    String name=userProfile.name;
                    String lastName=userProfile.lastName;
                    String email=userProfile.email;

                    nameText.setText(name);
                    lastNameText.setText(lastName);
                    emailText.setText(email);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SettingsProfile.this,"Something went wrong!", Toast.LENGTH_LONG).show();
            }
        });

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
                startActivity(new Intent(this, Library.class));
                break;

        }

    }
}