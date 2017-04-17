package com.moe.finalproject;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moe.finalproject.R;


public class TVFragment extends Fragment {

    private ImageView image;
    private TextView tvText;
    private Button addChannel;
    private Button channel_1_cnn;
    private Button channel_2_BBC;
    private Button channel_3_BEIN;
    private Button channel_4_MBC;
    private Button channel_5_ABC;
    private Button channel_6_XXL;
    private Button volUp;
    private Button volDown;
    private Button channel_Up;
    private Button channel_Down;
    private Button remote_power;
    private Button ok;
    private DatabaseHelper dbHelper;
    private EditText channelData;
    private RelativeLayout tv;
    private Bundle tv_data;
    private int check_channel_name;
    private int channel_number;
    String cnn = "CNN";
    String bbc = "BBC";
    String bein = "BEIN";
    String mbc = "MBC";
    String abc = "ABC";
    String xxl = "XXL";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle data = this.getArguments();

        View v = inflater.inflate(R.layout.activity_tv, container, false);

       // image = (ImageView) v.findViewById(R.id.tvImage);

        dbHelper = new DatabaseHelper(getActivity());
        tv_data = this.getArguments();
        final long device_id = Long.parseLong(tv_data.getString("id"));

        Cursor cursor = dbHelper.getChannelName(channel_number, device_id);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            check_channel_name = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NAME));
            cursor.moveToNext();


        }





//        image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));

        tvText = (TextView) v.findViewById(R.id.tvText);

       // tv = (RelativeLayout) v.findViewById(R.id.activity_tv);

        channel_1_cnn = (Button) v.findViewById(R.id.CH1);


        channel_1_cnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 1;
                tvText.setText("CNN");
                Toast.makeText(getActivity().getApplicationContext(), "Channel 1 Selected", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 1, device_id);
            }


        });

        channel_2_BBC = (Button) v.findViewById(R.id.CH2);


        channel_2_BBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 2;
                tvText.setText("BBC");
                Toast.makeText(getActivity().getApplicationContext(), "Channel 2 Selected", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 2, device_id);

            }

        });

        channel_3_BEIN = (Button) v.findViewById(R.id.CH3);


        channel_3_BEIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 3;
                tvText.setText("BEIN");
                Toast.makeText(getActivity().getApplicationContext(), "Channel 3 Selected", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 3, device_id);

            }

        });

        channel_4_MBC = (Button) v.findViewById(R.id.CH4);


        channel_4_MBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 4;
                tvText.setText("MBC");
                Toast.makeText(getActivity().getApplicationContext(), "Channel 4 Selected", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 4, device_id);

            }

        });

        channel_5_ABC = (Button) v.findViewById(R.id.CH5);


        channel_5_ABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 5;
                tvText.setText("BBC");
                Toast.makeText(getActivity().getApplicationContext(), "Channel 5 Selected", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 5, device_id);

            }

        });

        channel_6_XXL = (Button) v.findViewById(R.id.CH6);


        channel_6_XXL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 6;
                tvText.setText("XXL");
                Toast.makeText(getActivity().getApplicationContext(), "Channel 6 Selected", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 6, device_id);

            }

        });

        volUp = (Button) v.findViewById(R.id.VolUp);


        volUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 7;
                tvText.setText("Volup");
                Toast.makeText(getActivity().getApplicationContext(), "Volume Up", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 7, device_id);

            }

        });


        volDown = (Button) v.findViewById(R.id.VolDown);

        volDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 8;
                tvText.setText("Voldown");
                Toast.makeText(getActivity().getApplicationContext(), "Volume Down", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 8, device_id);

            }

        });

        channel_Down = (Button) v.findViewById(R.id.ChDown);

        channel_Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 9;
                tvText.setText("Channel Down");
                Toast.makeText(getActivity().getApplicationContext(), "Channel Down", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 9, device_id);

            }

        });



        channel_Up = (Button) v.findViewById(R.id.ChUp);

        channel_Up.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            channel_number = 9;
            tvText.setText("Channel Up");
            Toast.makeText(getActivity().getApplicationContext(), "Channel Up", Toast.LENGTH_SHORT).show();
            dbHelper.savetvchannelnumber(channel_number, 9, device_id);

        }

    });

        remote_power = (Button) v.findViewById(R.id.power);

        remote_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 10;
                tvText.setText("Power ON/OFF");
                Toast.makeText(getActivity().getApplicationContext(), "Power ON/OFF", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 10, device_id);

            }

        });

        ok = (Button) v.findViewById(R.id.Enter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channel_number = 11;
                tvText.setText("OK");
                Toast.makeText(getActivity().getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                dbHelper.savetvchannelnumber(channel_number, 11, device_id);

            }

        });

               /* if(channelData.getText().length() != 0) {
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
        });*/



        return v;
    }
}
