package com.example.wahid.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wahid.project1.Adapter.CustomAdapter2;
import com.example.wahid.project1.Model.UploadProblem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UploadedYourProblem extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listView2;
    FirebaseUser user;


    private List<UploadProblem> uploadProblemList;
    private CustomAdapter2 customAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploaded_your_problem);
        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid()).child("UploadProblem");
        uploadProblemList = new ArrayList<>();
        customAdapter2 = new CustomAdapter2(UploadedYourProblem.this, uploadProblemList);
        listView2 = findViewById(R.id.listViewIdFormUploadedProblem);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                uploadProblemList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    UploadProblem uploadProblem = dataSnapshot1.getValue(UploadProblem.class);
                    uploadProblemList.add(uploadProblem);

                    listView2.setAdapter(customAdapter2);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
