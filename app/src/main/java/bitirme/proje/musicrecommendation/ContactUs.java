package bitirme.proje.musicrecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ContactUs extends AppCompatActivity {
    EditText SubjectEdit,message;
    Button SendEmail;
    TextView toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        toEdit=findViewById(R.id.toEdit);
        SubjectEdit=findViewById(R.id.SubjectEdit);
        message=findViewById(R.id.sendMessage);
        SendEmail=findViewById(R.id.SendEmail);


        SendEmail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sendEmail();
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
                startActivity(new Intent(ContactUs.this,SettingsProfile.class));
                return true;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ContactUs.this,MainActivity.class));
                return true;
            case R.id.help:
                startActivity(new Intent(ContactUs.this,Help.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void sendEmail() {


        String subject=SubjectEdit.getText().toString();
        String msg=message.getText().toString();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"eloedoel@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,msg);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));


    }
}