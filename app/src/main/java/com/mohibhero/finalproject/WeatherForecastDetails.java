/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * import statements
 */
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.moe.finalproject.R;

/**
 * WeatherForecastDetails class is simple one. It runs the WeatherForecastFragment's operation but in a new Activity.
 * It is used when the layout is in phone mode.
 * @author MohibHero
 */
public class WeatherForecastDetails extends AppCompatActivity {

    /**
     * onCreate function is used to create this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); //calling the superclass constructor.

        setContentView(R.layout.activity_weather_forecast_details); //setting the Content View.

        Bundle data = this.getIntent().getExtras(); //making the Bundle.

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //begin the Fragment Transaction.

        WeatherForecastFragment f = new WeatherForecastFragment(); //instantiating a new WeatherForecastFragment object.

        f.setArguments(data); //passing the data.

        ft.replace(R.id.weatherFrame, f); //replacing the FrameLayout with activity launched.

        ft.commit(); //commit the fragment transaction.

    }


}
