package com.example.aaaa;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TabFragment1 extends Fragment {


    public TabFragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView namee=(TextView) getActivity().findViewById(R.id.mstudio);
        TextView rev=(TextView) getActivity().findViewById(R.id.studioReviews);
        TextView cap=(TextView) getActivity().findViewById(R.id.caption);
        TextView prof=(TextView) getActivity().findViewById(R.id.profile);
        ImageView instapost = (ImageView)getActivity().findViewById(R.id.picture2);

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        String r=getActivity().getIntent().getStringExtra(Studio.REVIEWS_KEY);
        String c=getActivity().getIntent().getStringExtra(Studio.DESC_KEY);
        String n=getActivity().getIntent().getStringExtra(Studio.NAME_KEY);
        String in=getActivity().getIntent().getStringExtra(Studio.INSTAN_KEY);
        Drawable drawable = ContextCompat.getDrawable(getContext(),getActivity().getIntent().getIntExtra(Studio.IMAGE_KEY, 0));

        namee.setText(n);
        rev.setText(r);
        cap.setText(c);
        prof.setText(in);
        Glide.with(getContext()).load(getActivity().getIntent().getIntExtra(Studio.IMAGE_KEY,0)).placeholder(gradientDrawable).into(instapost);
    }
}