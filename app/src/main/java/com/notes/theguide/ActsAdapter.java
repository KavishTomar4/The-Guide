package com.notes.theguide;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActsAdapter extends RecyclerView.Adapter<ActsAdapter.ViewHolder>
{
    Context context;



    ArrayList<Act> actList = new ArrayList<>();
    public static final String ACT_NUMBER = "act_num";
    public static final String DRAMA_NAME = "act_name";

    Vibrator vibrator;

    public ActsAdapter(Context context)
    {
        this.context = context;
        vibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);

    }







    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_acts_layout , parent , false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.actName.setText(actList.get(position).getAct());

        holder.actholder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context , SceneActivity.class);
                intent.putExtra(ACT_NUMBER , actList.get(position).getAct());
                intent.putExtra(DRAMA_NAME , actList.get(position).getDramaName());
                vibrator.vibrate(50);
                context.startActivity(intent);



            }

        });



    }

    @Override
    public int getItemCount() {
        return actList.size();
    }

    public void setActList(ArrayList<Act> actList) {
        this.actList = actList;
    }



    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView actName;
        RelativeLayout actholder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            actName = itemView.findViewById(R.id.actName);
            actholder = itemView.findViewById(R.id.actHolder);

        }
    }

}
