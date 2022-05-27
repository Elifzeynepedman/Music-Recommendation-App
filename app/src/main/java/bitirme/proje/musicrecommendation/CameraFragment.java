package bitirme.proje.musicrecommendation;
/*
import static org.bytedeco.javacpp.opencv_highgui.imread;
import static org.bytedeco.javacpp.opencv_highgui.imwrite;
import static org.bytedeco.javacpp.opencv_imgproc.GaussianBlur;
*/
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import org.bytedeco.opencv;
//import org.bytedeco.javacpp.opencv_core;

/*
import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import static org.bytedeco.opencv.global.opencv_core.BORDER_DEFAULT;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgproc.Laplacian;
*/


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.google.firebase.auth.FirebaseAuth;

public class CameraFragment extends AppCompatActivity {

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    Button cameraBtn,useImage;
    TextView goBack;
    ImageView cameraImg;

    Python py = Python.getInstance();
    final PyObject pyobj = py.getModule("yuz_tanima"); //here we will give name of our python file


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
                startActivity(new Intent(CameraFragment.this,SettingsProfile.class));
                return true;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(CameraFragment.this,MainActivity.class));
                return true;
            case R.id.help:
                startActivity(new Intent(CameraFragment.this,Help.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);


        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));





        cameraBtn=(Button)findViewById(R.id.cameraBtn);
        goBack=(TextView)findViewById(R.id.GoBack);
        useImage=(Button) findViewById(R.id.useImg);
        cameraImg=(ImageView) findViewById(R.id.cameraImg);

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Asks the user if the program can use their camera
                askCameraPermissions();

            }
        });

        useImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Replaces the fragment with camera
                replaceFragment(new mood_Recognition());

            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Goes back to the home page
                startActivity(new Intent(CameraFragment.this,ProfileActivity.class));

            }
        });
    }
//Function to replace the fragment for camera
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentmanager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentmanager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
   }

    private void askCameraPermissions() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }
        else{
            openCamera();

        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==CAMERA_PERM_CODE){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                openCamera();
            }
            else {
                Toast.makeText(this,"Camera permission is needed",Toast.LENGTH_LONG).show();
            }
        }


    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            cameraImg.setImageBitmap(bitmap);

            PyObject obj = null;

            //obj = pyobj.callAttr()







        }
    }
    private void openCamera() {
        Intent camera= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA_REQUEST_CODE);


    }
/*
    public static void smooth(String filename) {
        opencv_core.Mat image = imread(filename);
        if (image != null) {
            GaussianBlur(image, image, new opencv_core.Size(3, 3), 0);
            imwrite(filename, image);
        }
    }
    */


}
