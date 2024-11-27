package com.example.jubayersqlite;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    List<Datalist>datalisst;
    Sqlitedatabaseclass sqlitedatabaseclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainrecyclear), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView=findViewById(R.id.mainrecyclear);
        sqlitedatabaseclass=new Sqlitedatabaseclass(this);

        datalisst=new ArrayList<>();

        Cursor cursor=sqlitedatabaseclass.insertseedata();

        if (cursor!=null && cursor.getCount()>0){

            while (cursor.moveToNext()){

            int id=cursor.getInt(0);
            Double amount =cursor.getDouble(1);
            String reason =cursor.getString(2);
            datalisst.add(new Datalist(amount,reason,id));

            }


        }

        adapter=new Adapter(MainActivity4.this,datalisst);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);




    }



}