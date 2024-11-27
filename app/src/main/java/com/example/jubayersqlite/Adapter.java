package com.example.jubayersqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Myholder> {
    @NonNull
    Context context;
    List<Datalist>datalist;
    LayoutInflater inflater;
    Sqlitedatabaseclass sqlitedatabaseclass;

    public Adapter(@NonNull Context context, List<Datalist> datalist) {
        this.context = context;
        this.datalist = datalist;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.layout,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {

        holder.departmentname.setText(datalist.get(position).getPurpose());
        holder.versityname.setText(datalist.get(position).getAmount().toString());
        holder.idnumber.setText(String.valueOf(datalist.get(position).getId()));




    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{

        TextView departmentname,versityname,idnumber;
        ImageView deletebutton;

        public Myholder(@NonNull View itemView) {
            super(itemView);


            departmentname=itemView.findViewById(R.id.departmentname);
            versityname=itemView.findViewById(R.id.versityname);
            idnumber=itemView.findViewById(R.id.idnumber);
            


        }
    }
}
