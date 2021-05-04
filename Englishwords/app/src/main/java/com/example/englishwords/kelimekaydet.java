package com.example.englishwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;

public class kelimekaydet extends AppCompatActivity {
    EditText ingilizce,turkce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimekaydet);
        ingilizce = findViewById(R.id.ingilizce);
        turkce = findViewById(R.id.turkce);
    }

