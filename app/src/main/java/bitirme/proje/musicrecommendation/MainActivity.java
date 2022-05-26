package bitirme.proje.musicrecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import bitirme.proje.musicrecommendation.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private TextView register,forgotPassword;
    private EditText editEmail,editPassword;
    private Button signIn;
    private BottomNavigationView bottomNav;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth=FirebaseAuth.getInstance();
        register=(TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        signIn=(Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);
        signIn.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()==keyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    userLogin();
                    return true;
                }
                return false;
            }

        });

        editEmail=(EditText)findViewById(R.id.email);
        editPassword=(EditText)findViewById(R.id.password);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        forgotPassword=(TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);





    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:
                startActivity(new Intent(this,RegisterUser.class));
                break;
            case R.id.signIn:
                userLogin();
                break;
            case R.id.forgotPassword:
                startActivity(new Intent(this,ForgotPassword.class));
                break;

        }
    }
//Logs Users into their account
    private void userLogin() {
        String email=editEmail.getText().toString().trim();
        String password=editPassword.getText().toString().trim();

        if(email.isEmpty()){
            editEmail.setError("Email is required!");
            editEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Please enter a valid Email");
            editEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editPassword.setError("Password is required");
            editPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editPassword.setError("Min password length is 6 characters!");
            editPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                     if(user.isEmailVerified()){
                         startActivity(new Intent(MainActivity.this,Library.class));
                         progressBar.setVisibility(View.GONE);

                     }
                     else {
                         user.sendEmailVerification();
                         Toast.makeText(MainActivity.this,"Check Your Email to verify your account",Toast.LENGTH_LONG).show();
                         progressBar.setVisibility(View.GONE);

                     }
                 }else{
                     Toast.makeText(MainActivity.this,"Failed to Login, check your credentials",Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                 }
            }

        });

    }
}