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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SceneListAdapter extends RecyclerView.Adapter<SceneListAdapter.ViewHolder>
{
    ArrayList<Scene> scenesList = new ArrayList<>();

    Context context;

    //Keys
    public static final String DRAMA_NAME = "drama";
    public static final String ACT_NUMBER = "actNum";
    public static final String SCENE_NUMBER = "sceneNum";

    Vibrator vibrator;


    public SceneListAdapter(Context context)
    {
        this.context = context;
        vibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_scenes_layout , parent , false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.sceneName.setText(scenesList.get(position).getScene());


        holder.sceneNameHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context , SceneArticleActivity.class);
                intent.putExtra(DRAMA_NAME , scenesList.get(position).getDramaName());
                intent.putExtra(ACT_NUMBER , scenesList.get(position).getActNumber());
                intent.putExtra(SCENE_NUMBER , scenesList.get(position).getScene());
                vibrator.vibrate(50);
                context.startActivity(intent);


            }
        });



    }

    @Override
    public int getItemCount() {
        return scenesList.size();
    }

    public void setScenesList(ArrayList<Scene> scenesList) {
        this.scenesList = scenesList;
    }



    public class ViewHolder extends RecyclerView.ViewHolder
    {
         RelativeLayout sceneNameHolder;
         TextView sceneName;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sceneNameHolder = itemView.findViewById(R.id.sceneNameHolder);
            sceneName = itemView.findViewById(R.id.sceneName);


        }
    }

}
