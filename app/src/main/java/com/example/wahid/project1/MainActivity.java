package com.example.wahid.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gotoUploadYoutProblem(View view) {
        Intent intent = new Intent(MainActivity.this, ProblemUpload.class);
        startActivity(intent);
    }

    public void gotoHelpLine(View view) {
        Intent intent = new Intent(MainActivity.this, HelpLine.class);
        startActivity(intent);
    }

    public void gotoPoliceActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Police.class);
        startActivity(intent);
    }

    public void gotoHospitalInfirmation(View view) {
        Intent intent = new Intent(MainActivity.this, Hospital.class);
        startActivity(intent);
    }

    public void goToUserProfile(View view) {
        Intent intent = new Intent(MainActivity.this, UserProfile.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login_logout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.loginId:
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);

            case R.id.logOutId:
                Toast.makeText(MainActivity.this, "LogOut button", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
