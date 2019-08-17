package com.example.hp.oouattendance;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main_menu extends AppCompatActivity {

    boolean isPressed = false;
    ImageView userImage;
    CardView attendance, students, courses, statistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        getSupportActionBar();
        Toolbar toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);


        userImage = findViewById(R.id.user_image);
        attendance = findViewById(R.id.attendance);
        students = findViewById(R.id.students);
        courses = findViewById(R.id.courses);
        statistics = findViewById(R.id.statistics);

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Attendance", Toast.LENGTH_SHORT).show();
            }
        });

        students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Students", Toast.LENGTH_SHORT).show();
            }
        });

        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Courses", Toast.LENGTH_SHORT).show();
            }
        });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "statistics", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(isPressed) {
            super.onBackPressed();
        }
        this.isPressed = true;
        Toast.makeText(getApplicationContext(), "press again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isPressed = false;
            }
        }, 2000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.log_out:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(), "Logout successful", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                return true;
            case R.id.main_menu_about:
                Toast.makeText(getApplicationContext(), "Alex and Felix made this", Toast.LENGTH_SHORT).show();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
