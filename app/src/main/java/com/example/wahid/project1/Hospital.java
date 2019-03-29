package com.example.wahid.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wahid.project1.Adapter.CustomAdapter;
import com.example.wahid.project1.Model.Hospital_HelpLine;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Hospital extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listView;
    private List<Hospital_HelpLine> hospital_helpLineList;
    public CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        databaseReference = FirebaseDatabase.getInstance().getReference("hospitalHelpLine");
        hospital_helpLineList = new ArrayList<>();
        customAdapter = new CustomAdapter(Hospital.this,hospital_helpLineList);
        listView = findViewById(R.id.listViewId);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                hospital_helpLineList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    Hospital_HelpLine hospital_helpLine = dataSnapshot1.getValue(Hospital_HelpLine.class);
                    hospital_helpLineList.add(hospital_helpLine);
                }

                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
