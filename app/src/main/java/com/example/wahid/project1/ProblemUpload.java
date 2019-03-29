package com.example.wahid.project1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wahid.project1.Model.UploadProblem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProblemUpload extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseUser user;
    ProgressDialog progressDialog;
    int PIC_IMAGE_REQUEST = 1;
    Bitmap bitmap;

    EditText mTypeProblem,mProblemDis,mProblemLoca;
    ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_upload);

        mTypeProblem = findViewById(R.id.typeOfProblemId);
        mProblemDis = findViewById(R.id.problemDiscreptionId);
        mProblemLoca = findViewById(R.id.problemLocationId);
        mImage = findViewById(R.id.uploadProblemImageId);

        user = FirebaseAuth.getInstance().getCurrentUser();
        progressDialog = new ProgressDialog(this);

        if (user.getUid() == null)
        {
            Toast.makeText(ProblemUpload.this,"Please Login",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProblemUpload.this,Login.class);
            startActivity(intent);
            finish();
        }
    }


    public void uploadProblem(View view) {

        uploadData();
    }

   void uploadData(){

       progressDialog.setMessage("Uploading your Problem");
       progressDialog.setTitle("Processing...");
       progressDialog.show();

        String typeProblem = mTypeProblem.getText().toString();
        String problemDescription = mProblemDis.getText().toString();
        String problemLocation = mProblemLoca.getText().toString();
        String image = imageToString(bitmap);

        databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid()).child("UploadProblem").push();
        UploadProblem uploadProblem = new UploadProblem(typeProblem,problemDescription,problemLocation,image);
        databaseReference.setValue(uploadProblem);
        progressDialog.dismiss();

       Toast.makeText(ProblemUpload.this,"Upload Successfully",Toast.LENGTH_SHORT).show();
       Intent intent = new Intent(ProblemUpload.this,MainActivity.class);
       startActivity(intent);
   }

    public void uploadByGallery(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PIC_IMAGE_REQUEST);
    }

    public String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        byte[] imgbyte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgbyte, Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PIC_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {

            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                mImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadByCamera(View view) {

    }
}
