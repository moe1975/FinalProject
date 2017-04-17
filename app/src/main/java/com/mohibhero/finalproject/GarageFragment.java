/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * import statements
 */
import android.support.v4.app.Fragment;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.example.moe.finalproject.R;

/**
 * GarageFragment class which is used to show us two toggle buttons for GarageDoor & Lights respectively.
 * When we click on the buttons a ToastBar and in case of Lights a Snackbar appears to indicate that these things work
 * and also tells us the state of them.
 * Some references from author https://github.com/abbysun .All credits.
 * Modified and added some things by the @author MohibHero
 */
public class GarageFragment extends Fragment {

    /**
     * private variable for Two toggle buttons.
     */
    ToggleButton toggleButton1, toggleButton2;

    /**
     * RelativeLayout variable for the garageDoor
     */
    RelativeLayout garageDoor;

    /**
     * ImageView variables for the images of the lightbulb, garagedoor etc.
     */
    ImageView iView, doorView , iViewLight;

    /**
     * A View method which is used to create a view in which we inflate our fragment and insert all our things and
     * program their working. This is important part of the Garage activity as it is also then used in GarageDetails class
     * without explaining everything again for that class hence Code Reuse.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_garage_fragment, container, false);

         doorView = (ImageView) v.findViewById(R.id.doorOpenClosed); //defining the ImageView for the Garage doors.

         iViewLight = (ImageView) v.findViewById(R.id.lightOnOff); //defining the ImageView for the Lights.

         iView = (ImageView) v.findViewById(R.id.lightOnOff); //defining the ImageView for the Lights.

         toggleButton1 = (ToggleButton)v.findViewById(R.id.toggleButton_light); //defining the ToggleButton for the lights.

         toggleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //this is what is executed when the toggleButton for light is clicked.

                lightClick(v); //lightClick method for the Lights is executed and also the View is passed as a parameter.

            }
          });

         toggleButton2 =(ToggleButton)v.findViewById(R.id.toggleButton_door); //defining the ToggleButton for the garage doors.

         toggleButton2.setOnClickListener(new View.OnClickListener() { //this is what is executed when the toggleButton for garagedoor is clicked.
            @Override
            public void onClick(View v) {

                doorClick(v); //doorClick method for the garage door is executed and also the View is passed as a parameter.

              }
         });

         garageDoor = (RelativeLayout) v.findViewById(R.id.activity_garage); //defining the RelativeLayout for the garage activity.

        return v; //returning the view.
    }

    /**
     * This function/method is executed when the toggleButton for the light is clicked. Here it is programmed to show
     * toastbars when the light is on and off and also it changes the image according to the status of the lights.
     * @param view
     */
    public void lightClick(View view) {
        boolean on = ((ToggleButton) view).isChecked(); //defining a boolean to see if the togglebutton is checked.

        if (on) {    //if it is on.
            on = false;
            iView.setImageResource(R.drawable.lighton); //set the image of light on bulb.
            CharSequence text = "Light Bulb is On!"; //this sequence appears in the toast bar.
            int duration = Toast.LENGTH_SHORT; //this is the duration for the ToastBar

            Toast toast = Toast.makeText(getActivity(), text, duration); //creating a toast bar.
            toast.show(); //showing the toast bar.

        } else { //if it is off.
            on = true;
            iView.setImageResource(R.drawable.lightoff); //set the image of light off bulb.
            CharSequence text = "Light Bulb is Off!"; //this sequence appears in the toast bar.
            int duration = Toast.LENGTH_SHORT; //this is the duration for the ToastBar

            Toast toast = Toast.makeText(getActivity(), text, duration); //creating a toast bar.
            toast.show(); //showing the toast bar.
        }

    }

    /**
     * This function/method is executed when the toggleButton for the garage door is clicked. Here it is programmed to show
     * snackbars when the garage door is open and closed and also it changes the image according to the status of the garage door.
     * @param v
     */
    public void doorClick (View v) {
        boolean on = ((ToggleButton) v).isChecked(); //defining a boolean to see if the togglebutton is checked.

        if (on) { //if it is open.

            on = false;

            doorView.setImageResource(R.drawable.dooropen); //set the image of door open.

            iViewLight.setImageResource(R.drawable.lighton); //it also sets the light on.

            CharSequence text = "Garage Door is Open"; //this sequence appears in the snackbar.

            int duration = Snackbar.LENGTH_SHORT; //this is the duration for the SnackBar

            Snackbar snackBar = Snackbar.make(garageDoor, text, duration ); //creating a snack bar.

            snackBar.show(); //showing the snack bar.

        } else { //if it is closed.

            on = true;

            doorView.setImageResource(R.drawable.doorclosed); //set the image of door closed.

            iViewLight.setImageResource(R.drawable.lightoff); //it also sets the light off.

            CharSequence text = "Garage Door is Closed"; //this sequence appears in the snackbar.

            int duration = Snackbar.LENGTH_SHORT; //this is the duration for the SnackBar

            Snackbar snackBar = Snackbar.make(garageDoor, text, duration ); //creating a snack bar.

            snackBar.show(); //showing the snack bar.

        }

    }





}
