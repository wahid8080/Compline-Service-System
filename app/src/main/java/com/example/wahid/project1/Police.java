package com.example.wahid.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.wahid.project1.Adapter.CustomAdapter;
import com.example.wahid.project1.Adapter.PoliceAdapter;
import com.example.wahid.project1.Model.Hospital_HelpLine;
import com.example.wahid.project1.Model.Police_Helpline;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Police extends AppCompatActivity {

    private DatabaseReference databaseRef;
    private ListView listView2;
    public List<Police_Helpline> police_helplineList;
    public PoliceAdapter policeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

        databaseRef = FirebaseDatabase.getInstance().getReference("policeHelpLine  ");
        police_helplineList = new ArrayList<>();
        policeAdapter = new PoliceAdapter(Police.this,police_helplineList);
        listView2 = findViewById(R.id.thanaInformationViewId);

    }
    @Override
    protected void onStart() {
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                police_helplineList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    Police_Helpline police_Helpline = dataSnapshot1.getValue(Police_Helpline.class);
                    police_helplineList.add(police_Helpline);
                }

                listView2.setAdapter(policeAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
