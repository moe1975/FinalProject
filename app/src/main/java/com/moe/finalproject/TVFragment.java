package com.moe.finalproject;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.moe.finalproject.R;


public class TVFragment extends Fragment {

    private ImageView image;
    private TextView tvText;
    private Button addChannel;
    private EditText channelData;
    private RelativeLayout tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle data = this.getArguments();

        View v = inflater.inflate(R.layout.activity_tv, container, false);

        image = (ImageView) v.findViewById(R.id.tvImage);


        image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));

        tvText = (TextView) v.findViewById(R.id.tvText);
        tvText.setText("TV ID: " + data.getString("id") + " Showing No Channel ");
        tv = (RelativeLayout) v.findViewById(R.id.activity_tv);

        channelData = (EditText) v.findViewById(R.id.channelTitle);
        addChannel = (Button) v.findViewById(R.id.addChannel);

        addChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Channel channel = new Channel();


                if(channelData.getText().length() != 0) {
                    channel.setChannelName(channelData.getText().toString());
                    tvText.setText("TVFragment ID: " + data.getString("id") + " Playing " + channel.getChannelName());
                    CharSequence text = "TV is on!";
                    int duration = Snackbar.LENGTH_SHORT;
                    Snackbar snackbar = Snackbar.make(tv, text, duration );
                    snackbar.show();

                }
                else {
                    CharSequence text = "TV is off!";
                    int duration = Snackbar.LENGTH_SHORT;
                    Snackbar snackbar = Snackbar.make(tv, text, duration );
                    snackbar.show();
                }
            }
        });



        return v;
    }
}
