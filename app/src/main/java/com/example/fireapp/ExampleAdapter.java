package com.example.fireapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> exampleItemList;
    private ArrayList<Movie> movieLists;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mViewImage;
        public TextView mTextView1;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mViewImage = itemView.findViewById(R.id.image_view);
            mTextView1 = itemView.findViewById(R.id.text1);
        }
    }

//    public ExampleAdapter(ArrayList<ExampleItem> exampleItems){
//        exampleItemList= exampleItems;
//    }

    public ExampleAdapter(ArrayList<Movie> movieList){
        this.movieLists = movieList;
    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
            //ExampleItem currentItem = exampleItemList.get(position);
            Movie currentMovie = movieLists.get(position);
            //holder.mViewImage.setImageResource(currentMovie.getPosterLink());
            //holder.mTextView1.setText(currentMovie.getMovieId());
           // holder.mTextView2.setText(currentMovie.getGenre());
             Picasso.get()
                     .load("https://lh3.googleusercontent.com/proxy/z_p1A2Sd-qPMCGQRtyXLKPQM8KZ1yOYxXybWDrUHe4429BElFQ2OEAATccnkV0Ps86OA8GqQSC58f-xxPZdAEcrOHNhPpg-YTY8").placeholder(R.drawable.ic_android).error(R.drawable.ic_assistant)
                     .fit().centerCrop().into(holder.mViewImage);

    }

    @Override
    public int getItemCount() {

       // return exampleItemList.size();
        return movieLists.size();

    }

    public void filterList(ArrayList<ExampleItem> filteredList){
        exampleItemList=filteredList;
        notifyDataSetChanged();
    }
}