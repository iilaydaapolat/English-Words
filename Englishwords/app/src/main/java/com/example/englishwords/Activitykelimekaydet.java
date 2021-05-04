package com.example.englishwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activitykelimekaydet extends AppCompatActivity {

EditText turkce,ingilizce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitykelimekaydet);

       turkce = findViewById(R.id.turkce);
        ingilizce = findViewById(R.id.ingilizce);
    }
            public void button (View view){


                String word1 = ingilizce.getText().toString();
                String word2 = turkce.getText().toString();
                Intent intent = new Intent(Activitykelimekaydet.this,ActivityKelimeDefteri.class);
                startActivity(intent);
                try {
                    SQLiteDatabase database = this.openOrCreateDatabase("words",MODE_PRIVATE,null);
                    database.execSQL("CREATE TABLE IF NOT EXISTS words(word1 VARCHAR,word2 VARCHAR)");
                    String sqlString ="INSERT INTO  words (word1,word2) VALUES(?,?)";
                    SQLiteStatement sqLiteStatement =database.compileStatement(sqlString);
                    sqLiteStatement.bindString(1,word1);
                    sqLiteStatement.bindString(2,word2);
                    sqLiteStatement.execute();




                }

catch(Exception e ){
                    e.printStackTrace();
                }

    }
}