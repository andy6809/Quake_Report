package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param earthquakes A List of Earthquake objects to display in a list
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        //Find the TextView with the view ID magnitude
        TextView magnitudeView = listItemView.findViewById(R.id.magnitude);
        //Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(currentEarthquake.getMagnitude());

        //Find the TextView with the view ID location
        TextView locationView = listItemView.findViewById(R.id.location);
        //Display the location of the current earthquake in that TextView
        locationView.setText(currentEarthquake.getLocation());

        //Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        //Find the TextView with the ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        //Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        //Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        //Find the TextView with the ID time
        TextView timeView = listItemView.findViewById(R.id.time);
        //Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        //Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        //Return the list item view that is now showing the appropriate data
        return listItemView;

    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984') from a Date object
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM') from a Date object
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


}

