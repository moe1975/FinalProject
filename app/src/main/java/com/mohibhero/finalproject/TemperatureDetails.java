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
 * TemperatureDetails class is simple one. It runs the TemperatureFragment's operation but in a new Activity. It is used when the
 * layout is in phone mode
 * @author MohibHero
 */
public class TemperatureDetails extends AppCompatActivity {

    /**
     * onCreate function used to create this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); //calling the superclass constructor.

        setContentView(R.layout.activity_temperature_details); //setting the Content View.

        Bundle data = this.getIntent().getExtras(); //making the Bundle.

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //begin the Fragment Transaction.

        TemperatureFragment f = new TemperatureFragment(); //instantiating a new TemperatureFragment object.

        f.setArguments(data); //passing the data.

        ft.replace(R.id.emptyFrame, f); //replacing the FrameLayout with activity launched.

        ft.commit(); //commit the fragment transaction.

    }


}
