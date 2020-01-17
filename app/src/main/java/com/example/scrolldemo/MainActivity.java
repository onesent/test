package com.example.scrolldemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScrollView sv = findViewById(R.id.scroll_info);

        SquareUiActivity sua = new SquareUiActivity(this);
        sua.showSquareUi();

    }


}

