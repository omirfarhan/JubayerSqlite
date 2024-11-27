package com.example.jubayersqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {


    EditText amount,reason;
    Button button;

    Sqlitedatabaseclass sqlitedatabaseclass;
    public static boolean expense=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    amount=findViewById(R.id.amount);
    reason=findViewById(R.id.purpose);
    button=findViewById(R.id.button);
    sqlitedatabaseclass=new Sqlitedatabaseclass(MainActivity3.this);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String amount1=amount.getText().toString();
            String reason1=reason.getText().toString();
            Double doubless=Double.parseDouble(amount1);

            if (expense==true){
                sqlitedatabaseclass.getdata(String.valueOf(doubless),reason1);
                Toast.makeText(MainActivity3.this, "Add expense method", Toast.LENGTH_SHORT).show();

            }else {
                sqlitedatabaseclass.addincome(String.valueOf(doubless),reason1);
                Toast.makeText(MainActivity3.this, "Add income method", Toast.LENGTH_SHORT).show();
            }


            Toast.makeText(MainActivity3.this, "Data is inserted", Toast.LENGTH_SHORT).show();

        }
    });



    }
}