package com.example.wahid.project1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.wahid.project1.Model.UserInformation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import id.zelory.compressor.Compressor;

public class UploadInformation extends AppCompatActivity {
    private int PIC_IMAGE_REQUEST = 1;
    private Bitmap bitmap;
    Compressor compressedImage;

    DatabaseReference databaseReference;
    FirebaseUser user;
    ProgressDialog progressDialog;

    private ImageView mImage;
    private EditText mUserNmae, mPhone, mNID, mDateOfBirth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_information);

        mImage = findViewById(R.id.imageId);
        mUserNmae = findViewById(R.id.input_userName_id_SingUp);
        mPhone = findViewById(R.id.input_phone_Id_SingUp);
        mNID = findViewById(R.id.input_NID_Id_SingUp);
        mDateOfBirth = findViewById(R.id.input_dateOfBirth_Id_SingUp);
        user = FirebaseAuth.getInstance().getCurrentUser();
        progressDialog = new ProgressDialog(this);
    }

    public void registration(View view) {


        progressDialog.setMessage("Profile Update");
        progressDialog.setTitle("Processing...");
        progressDialog.show();
        uploadInformation();
        Intent intent = new Intent(UploadInformation.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    void uploadInformation() {
        String email = user.getEmail();
        String image = imageToString(bitmap);
        String userName = mUserNmae.getText().toString().trim();
        String phone = mPhone.getText().toString().trim();
        String NID = mNID.getText().toString().trim();
        String dateOfBirth = mDateOfBirth.getText().toString().trim();
        databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());
        UserInformation userInformation = new UserInformation(email, NID, phone, userName, image, dateOfBirth);
        databaseReference.setValue(userInformation);
        progressDialog.dismiss();
    }




    public void GalleryFunction(View view) {
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

}
