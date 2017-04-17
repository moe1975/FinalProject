/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * import statments.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.example.moe.finalproject.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * WeatherForecastFragment is also an important part of the HouseSetting app as it covers the live update of weather of
 * Ottawa and it is best known to use the AsyncTask in its procedure. This was used in Lab 6 and have been directly used
 * here, ofcourse modified to adjust the app. This app is able to run in Phone layout and tablet (land scape layout) but
 * sometimes the landscape might cause an error. We also use two inner classes called ForecastQuery(Async Task) & HTTPUtils
 * @author MohibHero
 */
public class WeatherForecastFragment extends Fragment {

    /**
     * private variable for ForecastQuery class.
     */
    private ForecastQuery forecastQuery;

    /**
     * private variable for ProgressBar.
     */
    private ProgressBar progressWeatherBar;

    /**
     * private variable for TextView.
     */
    private TextView currentTemperature;

    /**
     * private variable for TextView.
     */
    private TextView minimumTemperature;

    /**
     * private variable for TextView.
     */
    private TextView maximumTemperature;

    /**
     * private variable for ImageView.
     */
    private ImageView weatherStatus;

    /**
     * A View method which is used to create a view in which we inflate our fragment and insert all our things and
     * program their working. This is important part of the WeatherForecast activity as it is also then used in WeatherForecastDetails
     * class without explaining everything again for that class hence Code Reuse.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_weather_forecast_fragment, container, false);

        Bundle data = this.getArguments(); //Bundle data.

        progressWeatherBar = (ProgressBar) v.findViewById(R.id.progressWeatherBar); //defining the progress bar for the app.

        currentTemperature = (TextView) v.findViewById(R.id.currentTemperature); //defining the text view for current temperature

        minimumTemperature = (TextView) v.findViewById(R.id.minimumTemperature); //defining the text view for minimum temperature

        maximumTemperature = (TextView) v.findViewById(R.id.maximumTemperature); //defining the text view for maximum temperature

        weatherStatus = (ImageView) v.findViewById(R.id.weatherImage); //defining the image view for weather image.

        forecastQuery = new ForecastQuery(); //instantiating a new ForecastQuery class object.

        forecastQuery.execute(); //executing the object.

        return v; //returning the view.
    }

    /**
     * This is an important inner class for the Activity as it deals with all the downloading of weather and showing it on screen
     * It is better to do this type of work in the background otherwise the app might crash due to Exceptions for Network. That is
     * why we use Async Task in order for the user experience to be not interrupted.
     */
    private class ForecastQuery extends AsyncTask<String, Integer, String> {

        /**
         * private variable of String
         */
        private String currentTemperature2;

        /**
         * private variable of String
         */
        private String minimumTemperature2;

        /**
         * private variable of String
         */
        private String maximumTemperature2;

        /**
         * private variable of String
         */
        private String iconName;

        /**
         * private variable of String
         */
        private String iconFileName;

        /**
         * private variable of Bitmap
         */
        private Bitmap weatherImage;

        /**
         * A method to check if the file exists from where we are reading.
         * @param fileName
         * @return file.exists()
         */
        private boolean fileExists(String fileName){
            File file = getActivity().getBaseContext().getFileStreamPath(fileName); //checking the fileName.
            return file.exists(); //returning the file exists or no.
        }

        /**
         * onPostExecute is executed mostly when other Async Task processes are done already.
         * Here we are setting the currentTemperature, minimumTemperature & maximumTemperature.
         * We also set the image for the weather and the progress bar so it shows the loading scenario.
         * @param result
         */
        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result); //calling superclass method.

            weatherStatus.setImageBitmap(weatherImage); //setting the weather image

            String currentText = currentTemperature2 + "\u2103"; //String variable for currentTemperature.

            String minimumText = minimumTemperature2 + "\u2103"; //String variable for minimumTemperature.

            String maximumText = maximumTemperature2 + "\u2103"; //String variable for currentTemperature.

            currentTemperature.setText(currentText); //setting the currentTemperature

            minimumTemperature.setText(minimumText); //setting the minimumTemperature

            maximumTemperature.setText(maximumText); //setting the maximumTemperature

            progressWeatherBar.setVisibility(View.INVISIBLE); //setting the progress bar's visibility to Invisible

         }

        /**
         * onProgressUpdate is also an important part of AsyncTask which is executed when the execution of the required task
         * in the background. Here while the weather is downloading we check with the progress bar and also with the weather
         * image.
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {

            super.onProgressUpdate(values); //calling superclass method.

            progressWeatherBar.setVisibility(View.VISIBLE); //setting the Visibility to Visible

            progressWeatherBar.setProgress(values[0]); //setting the progress to value[0].

            FileInputStream fis; //declaring a new FileInputStream variable.

            if(fileExists(iconFileName)) { //using if statement to see if the fileExists.

                try {

                    File f = getActivity().getFileStreamPath(iconFileName); //get the file stream path for the file

                    fis = new FileInputStream(f); //new FileInputStream object instantiated with the File as parameter.

                    weatherImage = BitmapFactory.decodeStream(fis); //decode the Stream for the weather image.

                }

                catch (FileNotFoundException e) { //catch any exceptions.

                    Log.e("Error", "Could not find image " + iconFileName);

                }

            }

        }

        /**
         * doInBackground is one of the most important part of AsyncTask which is as it name says do all the stuff background
         * e.g. processing information or making connections etc.
         * @param params
         * @return
         */
        @Override
        protected String doInBackground(String... params) {

            /**
             * URL variable.
             */
            URL url;

            /**
             * XmlPullParser variable.
             */
            XmlPullParser parser;

            /**
             * instantiating a progress variable of int to be zero.
             */
            int progress = 0;

            try {

                //putting the url for weather forecast for Ottawa.
                url = new URL("http://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=d99666875e0e51521f0040a3d97d0f6a&mode=xml&units=metric");

                HttpURLConnection conn; //HttpURLConnection variable.

                conn = (HttpURLConnection) url.openConnection(); //defining the HttpURLConnection variable to open the connection.

                conn.setReadTimeout(10000 /* milliseconds */); //setting the ReadTimeout for 10000 milliseconds

                conn.setConnectTimeout(15000 /* milliseconds */); //setting the ConnectTimeout for 15000 milliseconds

                conn.setRequestMethod("GET"); //set the Request method to get

                conn.setDoInput(true); //seth the do input to true.

                // Starts the query
                conn.connect();


                parser = Xml.newPullParser(); //use the newPullParser() method.

                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false); //set the feature for XmlPullParser.

                parser.setInput(conn.getInputStream(), null); //set the input for XmlPullParser.

                parser.nextTag(); //use nextTag().

                while (parser.next() != XmlPullParser.END_DOCUMENT) { //while reading next not reaches the end of document.

                    if (parser.getEventType() != XmlPullParser.START_TAG) { //if the Event type for parser is not equal to start tag

                        continue; //continue with reading.

                    }

                    String name = parser.getName(); //new String to get the name for parser.

                    if (name.equals("temperature")) { //if that name attribute is equal to temperature.

                        currentTemperature2 = parser.getAttributeValue(null, "value"); //get the attribute value.

                        minimumTemperature2 = parser.getAttributeValue(null, "min"); //get the attribute value.

                        maximumTemperature2 = parser.getAttributeValue(null, "max"); //get the attribute value.

                    } else if(name.equals("weather")) { //if that name attrivute is equal to weather instead.

                        iconName = "11d";//parser.getAttributeValue(null, "icon"); //set the icon name to 11d.

                    }

                    progress += 1; //counter the progress.

                    publishProgress(progress); //publish the progress.

                }


            } catch (XmlPullParserException | IOException e) { //catch any exceptions.

                e.printStackTrace();

            }

            publishProgress(100); //publish the progress.

            String imageUrl = "http://openweathermap.org/img/w/" + iconName + ".png"; //string for the image url

            iconFileName =  iconName + ".PNG"; //icon name

            Bitmap image = HTTPUtils.getImage(imageUrl); //get the image for image url for bit map.

            FileOutputStream outputStream; //declaring a new FileOutputStream variable.

            try {
                outputStream = getActivity().openFileOutput( iconFileName, Context.MODE_PRIVATE); //open the output file.

                if(image != null) //if the image is not equal to null

                    image.compress(Bitmap.CompressFormat.PNG, 80, outputStream); //use the compress method.

                outputStream.flush(); //flush the outputStream.

                outputStream.close(); //close the outputStream.

            } catch (NullPointerException | IOException e) { //catch any exceptions.

                e.printStackTrace();

            }

            return null;
        }
    }
}

/**
 * A private inner class used for Bitmap. Usually to return the image.
 */
class HTTPUtils {

    /**
     * A static public method for Bitmap to return an image.
     * @param url
     * @return
     */
    public static Bitmap getImage(URL url) {

        HttpURLConnection connectionURL = null; //HttpURLConnection variable.

        try {

            connectionURL = (HttpURLConnection) url.openConnection(); //opening the connection.

            connectionURL.connect(); //connecting.

            int responseCode = connectionURL.getResponseCode(); //get the response code of connection.

            if (responseCode == 200) { //if the code is equal to some value, in this case 200.

                return BitmapFactory.decodeStream(connectionURL.getInputStream()); //return the Input Stream.

            } else

                return null;

        } catch (Exception e) { //catch exceptions.

            return null;

        } finally { //execute this if the first two i.e. try and catch wont be true.

            if (connectionURL != null) {  //if the connection is not equal to null

                connectionURL.disconnect(); //cut the connection i.e. disconnect from it.

            }

        }

    }

    /**
     * Another public static method for Bitmap which returns the image. But this time the parameter is the String.
     * @param urlString
     * @return
     */
    public static Bitmap getImage(String urlString) {

        try {

            URL url = new URL(urlString); //Instantiating a new URL object and passing the urlString.

            return getImage(url); //returning the getImage() with url passed inside it.

        } catch (MalformedURLException e) { //catch any exceptions.

            return null;

        }

    }

}

