package com.talal.finalproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AutomobileTemperature extends Adapter {

    private Button AutomobileSaveTemp;
    private TextView AutoTextViewTemp;
    private  TextView AutoTempText;
    private SQLiteDatabase dataB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile_temperature);

        AutoTextViewTemp = (TextView) findViewById(R.id.AutoTempNum);
        AutoTempText = (TextView) findViewById(R.id.AutoTempTextView);

        AutomobileSaveTemp = (Button)findViewById(R.id.AutoTempApply);
        AutomobileSaveTemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AutoTempText.setText("The Temperature is: " + AutoTextViewTemp.getText());
            }
        });
        dataB = getDbHelper().getWritableDatabase();
    }





}
