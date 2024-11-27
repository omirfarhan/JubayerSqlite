package com.example.jubayersqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchView searchView;
    Adapter adapter;
    List<Datalist>datalists;

    Sqlitedatabaseclass sqlitedatabaseclass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        recyclerView=findViewById(R.id.recyclearview);
        searchView=findViewById(R.id.searchview);
        sqlitedatabaseclass=new Sqlitedatabaseclass(this);

        searchView.clearFocus();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Cursor cursor=sqlitedatabaseclass.searchUser(query);
                datalists.clear();
                while (cursor.moveToNext()){

                  String reason=  cursor.getString(2);
                   Double expensesss= cursor.getDouble(1);
                   int id= cursor.getInt(0);
                    datalists.add(new Datalist(expensesss,reason,id));

                }
                adapter.notifyDataSetChanged();
                return true;


                // ইউজার যখন সার্চ সাবমিট করবে
                /*Cursor cursor=sqlitedatabaseclass.searchdata(query);
                datalists.clear();
                while (cursor.moveToNext()){
                    dept=cursor.getString(1);
                    versity=cursor.getString(2);
                    id=cursor.getInt(0);
                    datalists.add(new Datalist(dept,versity,id));
                }
                adapter.notifyDataSetChanged();
                return true;

                 */
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // ইউজার যখন টাইপ করবে
                Cursor cursor=sqlitedatabaseclass.searchUser(newText);
                datalists.clear();
                while (cursor.moveToNext()){

                    String reason=  cursor.getString(2);
                    Double expensesss= cursor.getDouble(1);
                    int id= cursor.getInt(0);
                    datalists.add(new Datalist(expensesss,reason,id));

                }
                adapter.notifyDataSetChanged();
                return true;
            }
        });



        datalists=new ArrayList<>();




        Cursor cursor=sqlitedatabaseclass.getseedata();

        if (cursor!=null && cursor.getCount()>0){

            while (cursor.moveToNext()){
                Double amount=cursor.getDouble(1);
                String reason=cursor.getString(2);
                int id=cursor.getInt(0);
                datalists.add(new Datalist(amount,reason,id));
            }


        }


        sqlitedatabaseclass.getseedata();





        adapter=new Adapter(this,datalists);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}