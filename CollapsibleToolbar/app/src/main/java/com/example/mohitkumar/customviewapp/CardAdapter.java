package com.example.mohitkumar.customviewapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mohitkumar on 20/03/17.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.RecyclerViewHolder> {

    ArrayList<CardData> arrayList;
    Context context;

    public CardAdapter(Context context, ArrayList<CardData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view,arrayList,context);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        CardData cardData = arrayList.get(position);
        holder.textView1.setText(cardData.getNameMark());
        holder.textView2.setText(cardData.getInfo());
        holder.textView3.setText(cardData.getTitle());
//        String namemark = holder.textView2.getText().toString();
//        holder.textView1.setText(namemark.charAt(0));
        int a =cardData.getN();
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("ODK Collect");
                builder.setMessage("Do you want to delete the form?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

            }
        });
        if(a==1) holder.textView4.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ArrayList<CardData> arrayList;
        Context context;
        TextView textView1,textView2,textView3,textView4;
        ImageView imageView;

        public RecyclerViewHolder(View itemView,ArrayList<CardData> arrayList,Context context) {
            super(itemView);
            this.arrayList = arrayList;
            this.context = context;
            imageView = (ImageView) itemView.findViewById(R.id.del_form);
            textView1 = (TextView) itemView.findViewById(R.id.text_1);
            textView2 = (TextView) itemView.findViewById(R.id.small_info);
            textView3 = (TextView)itemView.findViewById(R.id.Form_title);
            textView4 = (TextView)itemView.findViewById(R.id.final_1);
        }
    }
}
