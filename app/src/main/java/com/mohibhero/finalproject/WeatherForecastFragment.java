package com.mohibhero.finalproject;


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



public class WeatherForecastFragment extends Fragment {

    private ForecastQuery forecastQuery;

    private ProgressBar progressWeatherBar;

    private TextView currentTemperature;
    private TextView minimumTemperature;
    private TextView maximumTemperature;

    private ImageView weatherStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_weather_forecast_fragment, container, false);

        Bundle data = this.getArguments();

        progressWeatherBar = (ProgressBar) v.findViewById(R.id.progressWeatherBar);

        currentTemperature = (TextView) v.findViewById(R.id.currentTemperature);
        minimumTemperature = (TextView) v.findViewById(R.id.minimumTemperature);
        maximumTemperature = (TextView) v.findViewById(R.id.maximumTemperature);

        weatherStatus = (ImageView) v.findViewById(R.id.weatherImage);

        forecastQuery = new ForecastQuery();
        forecastQuery.execute();

        return v;
    }

    private class ForecastQuery extends AsyncTask<String, Integer, String> {

        private String currentTemperature2;
        private String minimumTemperature2;
        private String maximumTemperature2;
        private String iconName;
        private String iconFileName;
        private Bitmap weatherImage;

        // private static final String OttawaWeatherURL = "http://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=d99666875e0e51521f0040a3d97d0f6a&mode=xml&units=metric";

        private boolean fileExists(String fileName){
            File file = getActivity().getBaseContext().getFileStreamPath(fileName);
            return file.exists();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            weatherStatus.setImageBitmap(weatherImage);

            String currentText = currentTemperature2 + "\u2103";
            String minimumText = minimumTemperature2 + "\u2103";
            String maximumText = maximumTemperature2 + "\u2103";

            currentTemperature.setText(currentText);
            minimumTemperature.setText(minimumText);
            maximumTemperature.setText(maximumText);

            progressWeatherBar.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressWeatherBar.setVisibility(View.VISIBLE);
            progressWeatherBar.setProgress(values[0]);

            FileInputStream fis;
            Log.i("Info", iconFileName);
            if(fileExists(iconFileName)) {
                Log.i("Info", iconFileName + " was found");
                try {
                    File f = getActivity().getFileStreamPath(iconFileName);
                    fis = new FileInputStream(f);
                    weatherImage = BitmapFactory.decodeStream(fis);
                }
                catch (FileNotFoundException e) {
                    Log.e("Error", "Could not find image " + iconFileName);
                }
            }
        }

        @Override
        protected String doInBackground(String... params) {
            URL url;
            XmlPullParser parser;
            int progress = 0;

            try {
                url = new URL("http://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=d99666875e0e51521f0040a3d97d0f6a&mode=xml&units=metric");
                HttpURLConnection conn;
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();

                parser = Xml.newPullParser();
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                parser.setInput(conn.getInputStream(), null);
                parser.nextTag();

                while (parser.next() != XmlPullParser.END_DOCUMENT) {
                    if (parser.getEventType() != XmlPullParser.START_TAG) {
                        continue;
                    }
                    String name = parser.getName();
                    if (name.equals("temperature")) {
                        currentTemperature2 = parser.getAttributeValue(null, "value");
                        minimumTemperature2 = parser.getAttributeValue(null, "min");
                        maximumTemperature2 = parser.getAttributeValue(null, "max");
                    } else if(name.equals("weather")) {
                        iconName = "11d";//parser.getAttributeValue(null, "icon");
                    }

                    progress += 1;
                    publishProgress(progress);
                }

            } catch (XmlPullParserException | IOException e) {
                e.printStackTrace();
            }

            publishProgress(100);

            String imageUrl = "http://openweathermap.org/img/w/" + iconName + ".png";
            iconFileName =  iconName + ".PNG";

            Bitmap image = HTTPUtils.getImage(imageUrl);
            FileOutputStream outputStream;
            try {
                outputStream = getActivity().openFileOutput( iconFileName, Context.MODE_PRIVATE);
                if(image != null)
                    image.compress(Bitmap.CompressFormat.PNG, 80, outputStream);

                outputStream.flush();
                outputStream.close();
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}


class HTTPUtils {
    public static Bitmap getImage(URL url) {
        HttpURLConnection connectionURL = null;
        try {
            connectionURL = (HttpURLConnection) url.openConnection();
            connectionURL.connect();
            int responseCode = connectionURL.getResponseCode();
            if (responseCode == 200) {
                return BitmapFactory.decodeStream(connectionURL.getInputStream());
            } else
                return null;
        } catch (Exception e) {
            return null;
        } finally {
            if (connectionURL != null) {
                connectionURL.disconnect();
            }
        }
    }
    public static Bitmap getImage(String urlString) {
        try {
            URL url = new URL(urlString);
            return getImage(url);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
