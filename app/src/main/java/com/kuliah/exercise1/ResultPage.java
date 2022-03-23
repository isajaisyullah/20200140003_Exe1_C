package com.kuliah.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    TextView task, jenis, time;

    String htask, hjenis, htime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        task = findViewById(R.id.rsTask);
        jenis = findViewById(R.id.rsJenis);
        time = findViewById(R.id.rsTime);

        Bundle bundle = getIntent().getExtras();

        htask = bundle.getString("task");
        hjenis = bundle.getString("jenis");
        htime = bundle.getString("time");

        task.setText(htask);
        jenis.setText(hjenis);
        time.setText(htime);

    }
}