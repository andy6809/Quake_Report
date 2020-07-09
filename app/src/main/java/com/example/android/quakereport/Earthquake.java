package com.example.android.quakereport;

public class Earthquake {
    // Magnitude of the earthquake
    private double mMagnitude;

    // Location of earthquake
    private String mLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /**
   * Constructs a new Earthquake object.
   * @param magnitude is the strength of the earthquake

   * @param location is the location
   * @param timeInMilliseconds is the time in milliseconds (from the Epoch)
     *  when the earthquake happened
     */


    public Earthquake(double magnitude, String location, long timeInMilliseconds) {

        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    /**
     * Get the magnitude of the earthquake
     */
    public double getMagnitude(){
        return mMagnitude;
    }



    /**
     * Get the location
     */
    public String getLocation(){
        return mLocation;
    }

    /**
     * Get the time of the earthquake
     */

    public long getTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }




}






