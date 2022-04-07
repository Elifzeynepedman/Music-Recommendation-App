package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private TextView banner,registerUser;
    private EditText editTextName,editTextLastName,editTextAge,editTextEmail,editTextPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        banner=(TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);
        registerUser=(TextView) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editTextName=(EditText) findViewById(R.id.name);
        editTextLastName=(EditText) findViewById(R.id.lastName);

        editTextAge=(EditText) findViewById(R.id.age);
        editTextEmail=(EditText) findViewById(R.id.email);
        editTextPassword =(EditText) findViewById(R.id.password);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }

    }
//Creates a new account
    private void registerUser() {

        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        String name=editTextName.getText().toString().trim();
        String lastName=editTextLastName.getText().toString().trim();
        String age=editTextAge.getText().toString().trim();

        if(name.isEmpty()){
            editTextName.setError("Full name is required!");
            editTextName.requestFocus();
            return;
        }
        if(lastName.isEmpty()){
            editTextLastName.setError("Full name is required!");
            editTextLastName.requestFocus();
            return;
        }

        if(age.isEmpty()){
            editTextAge.setError("Age is required!");
            editTextAge.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid Email");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length()<6){
            editTextPassword.setError("Min password length should be 6 characters!");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user=new User(name,lastName,age,email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterUser.this,"Good",Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        Toast.makeText(RegisterUser.this,"Bad again",Toast.LENGTH_LONG).show();
                                    }

                                }
                            });
                        }
                        else {
                            Toast.makeText(RegisterUser.this,"Fail"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
