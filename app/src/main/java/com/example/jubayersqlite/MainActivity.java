package com.example.jubayersqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView totalexpence,viewdata,bdt,addincomes,bdtt,balance,addincometextview;
    Sqlitedatabaseclass sqlitedatabaseclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sqlitedatabaseclass=new Sqlitedatabaseclass(this);

        totalexpence=findViewById(R.id.totalexpence);
        addincomes=findViewById(R.id.addincomes);
        viewdata=findViewById(R.id.viewdata);
        bdt=findViewById(R.id.bdt);
        bdtt=findViewById(R.id.bdtt);
        addincometextview=findViewById(R.id.addincometextview);
        balance=findViewById(R.id.balance);

        totalexpence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity3.expense=true;
                Intent intent=new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });


        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });

        addincometextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);


            }
        });

        addincomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity3.expense=false;
                Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);

            }
        });


        updateUI();


    }

    private void updateUI(){
        bdt.setText("BDT "+sqlitedatabaseclass.datasee());
        bdtt.setText("BDT "+sqlitedatabaseclass.addmethod());
        balance.setText("BDT "+(sqlitedatabaseclass.addmethod()-sqlitedatabaseclass.datasee()));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        updateUI();
    }
}