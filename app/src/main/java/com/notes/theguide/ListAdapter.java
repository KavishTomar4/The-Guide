package com.notes.theguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import static android.content.Context.VIBRATOR_SERVICE;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
   ArrayList<Drama> dramaList = new ArrayList<>();

   public static final String DRAMA_ID = "dramaName";

   Context context;

   Vibrator vibrator;



   public ListAdapter(Context context)
   {
       this.context = context;
       vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);

   }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout , parent , false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

       holder.bookName.setText(dramaList.get(position).getName());

        Glide.with(context).asBitmap().load(dramaList.get(position).getImgUrl()).into(holder.cover);

        holder.description.setText(dramaList.get(position).getShortDes());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




              Intent intent = new Intent(context , ActsAcitivity.class);
              intent.putExtra(DRAMA_ID , dramaList.get(position).getName());
              vibrator.vibrate(50);
              context.startActivity(intent);


            }
        });




        if (dramaList.get(position).isExtended())
        {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.downArrow.setVisibility(View.GONE);
            holder.bottomRel.setVisibility(View.VISIBLE);


        }else{

            TransitionManager.beginDelayedTransition(holder.parent);
            holder.downArrow.setVisibility(View.VISIBLE);
            holder.bottomRel.setVisibility(View.GONE);


        }



    }

    @Override
    public int getItemCount() {
        return dramaList.size();
    }


    public ArrayList<Drama> getDramaList() {
        return dramaList;
    }

    public void setDramaList(ArrayList<Drama> dramaList) {
        this.dramaList = dramaList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
         //Variables
         RelativeLayout parent;
         RelativeLayout upperRel;
         RelativeLayout bottomRel;
         TextView description;
         ImageView cover;
         TextView bookName;
         ImageView upArrow;
         ImageView downArrow;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Initialization
            parent = itemView.findViewById(R.id.parentRel);
            upperRel = itemView.findViewById(R.id.upperRel);
            cover = itemView.findViewById(R.id.cover);
            bookName = itemView.findViewById(R.id.bookName);
            bottomRel = itemView.findViewById(R.id.bottomRel);
            upArrow = itemView.findViewById(R.id.upArrow);
            downArrow = itemView.findViewById(R.id.downArrow);
            description = itemView.findViewById(R.id.description);


            //Up Arrow and Down Arrow functionality
            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Drama drama = dramaList.get(getAdapterPosition());
                    drama.setExtended(true);
                    notifyItemChanged(getAdapterPosition());


                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   Drama drama = dramaList.get(getAdapterPosition());
                   drama.setExtended(false);
                    notifyItemChanged(getAdapterPosition());



                }
            });










        }
    }

}
