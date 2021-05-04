package com.example.englishwords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class ActivityKelimeDefteri extends AppCompatActivity {

    rvadapterr rvadapter;
    ArrayList <String> arrayword1;
    ArrayList <String> arrayword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_defteri);

        arrayword1 = new ArrayList<String>();
        arrayword2 = new ArrayList<String>();
        RecyclerView recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(this,2));



        rvadapter  = new rvadapterr(arrayword1,arrayword2);
        recyclerview.setAdapter(rvadapter);
getData();
    }
    public void getData(){
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("words", MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT * FROM words ", null);
            int word1Ix = cursor.getColumnIndex("word1");
            int word2Ix = cursor.getColumnIndex("word2");

            while (cursor.moveToNext()) {
                arrayword1.add(cursor.getString(word1Ix));
                arrayword2.add(cursor.getString(word2Ix));
            }
            rvadapter.notifyDataSetChanged();


            cursor.close();
        }catch (Exception e){
            e.printStackTrace();

        }
}}