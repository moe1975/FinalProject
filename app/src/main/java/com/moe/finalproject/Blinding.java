package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-27..
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
// yes
import com.example.moe.finalproject.R;


public class Blinding extends Fragment {
    private ImageView image;
    private TextView blindingText;
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle data = this.getArguments();

        View v = inflater.inflate(R.layout.activity_blinding, container, false);


        //getSupportActionBar().setTitle("House Blindings");

//        final Bundle data = this.getIntent().getExtras();

        progressBar = (ProgressBar) v.findViewById(R.id.progressLivingroomBar);
        progressBar.setVisibility(View.VISIBLE);
        image = (ImageView) v.findViewById(R.id.blindingImage);

        image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));

        blindingText = (TextView) v.findViewById(R.id.blindingText);

        blindingText.setText("ID: " + data.getString("id"));

        return v;
    }
}
