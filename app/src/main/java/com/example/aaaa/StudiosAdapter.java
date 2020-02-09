package com.example.aaaa;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StudiosAdapter extends RecyclerView.Adapter<StudiosAdapter.StudiosViewHolder> {

    private GradientDrawable mGradientDrawable;
    private ArrayList<Studio> mStudiosData;
    private Context mContext;

    StudiosAdapter(Context context, ArrayList<Studio> studiosData) {
        this.mStudiosData = studiosData;
        this.mContext = context;

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);
    }
    @Override
    public StudiosAdapter.StudiosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StudiosAdapter.StudiosViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(StudiosAdapter.StudiosViewHolder holder, int position) {
        Studio currentStudio = mStudiosData.get(position);
        holder.bindTo(currentStudio);
    }

    @Override
    public int getItemCount() {
        return mStudiosData.size();
    }

    static class StudiosViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mStudioName;
        private ImageView mStudioImage;
        private Context mContext;
        private Studio mCurrentStudio;
        private GradientDrawable mGradientDrawable;

        StudiosViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            mStudioName = (TextView)itemView.findViewById(R.id.studioName);
            mStudioImage = (ImageView)itemView.findViewById(R.id.picture1);
            mContext = context;
            mGradientDrawable = gradientDrawable;

            itemView.setOnClickListener(this);
        }

        void bindTo(Studio currentStudio){
            mStudioName.setText(currentStudio.getName());
            mCurrentStudio = currentStudio;
            Glide.with(mContext).load(currentStudio.
                    getImage1()).placeholder(mGradientDrawable).into(mStudioImage);
        }

        @Override
        public void onClick(View view) {
            Intent detailIntent = Studio.starter(mContext, mCurrentStudio);
            mContext.startActivity(detailIntent);
        }
    }
}