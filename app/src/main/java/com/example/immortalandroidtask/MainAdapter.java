package com.example.immortalandroidtask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.immortalandroidtask.Model.MainModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<MainModel> mianModels;
    Context context;

    public MainAdapter(Context context, ArrayList<MainModel> mianModels) {
        this.context = context;
        this.mianModels = mianModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(mianModels.get(position).getLanLogo());
        holder.textView.setText(mianModels.get(position).getLangName());
        holder.textview2.setText(mianModels.get(position).getLangName2());

        if (position == 0) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#f0806d"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ebcbc5"));
        }


    }

    @Override
    public int getItemCount() {
        return mianModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, textview2;
        RelativeLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
            textview2 = itemView.findViewById(R.id.textview2);
            linearLayout = itemView.findViewById(R.id.linearlayoutrecycle);
        }
    }
}
