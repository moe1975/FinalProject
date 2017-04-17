/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * import statements
 */
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.moe.finalproject.R;

/**
 * GarageDetails class is simple one. It runs the GarageFragment's operation but in a new Activity. It is used when the
 * layout is in phone mode. An extra for this layout and class only is the toolbar created which asks the user to exit
 * out of app.
 * @author MohibHero
 */
public class GarageDetails extends AppCompatActivity {

    /**
     * onCreate function used to create this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calling the superclass constructor.
        setContentView(R.layout.activity_garage_details); //setting the Content View.

        Bundle data = this.getIntent().getExtras(); //making the Bundle.

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //begin the Fragment Transaction.
        GarageFragment f = new GarageFragment(); //instantiating a new GarageFragment object.
        f.setArguments(data); //passing the data.

        ft.replace(R.id.garageFrame, f); //replacing the FrameLayout with activity launched.
        ft.commit(); //commit the fragment transaction.
    }

    /**
     * A method used by toolbar to inflate the menu with the menu we created for the activity.
     * @param m
     * @return
     */
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.toolbar_garage, m); //inflating the menu
        return true;

    }

    /**
     * A method used by toolbar to give each item on the toolbar a specific function to execute when it is clicked.
     * @param mi
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem mi) {
        int id = mi.getItemId(); //getting the id of the item in an int.
        switch (id) { //using the switch statement
            case R.id.garage_goback: //this id for the item.



                AlertDialog.Builder builder = new AlertDialog.Builder( this ); //creating a new Dialog box.

                builder.setTitle("Do you want to go House Settings Menu?"); //setting the title.

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {  //setting the positive button operation.

                        finish(); //finish the activity and go back.
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) { //setting the negative button operation

                        dialog.cancel(); //cancel the dialog box and stay in the same activity.

                    }
                });

                AlertDialog dialog = builder.create(); //create the dialog box.
                dialog.show(); //show the dialog box.

                break; //break statement.
        }
        return true; //returns true.
    }

}
