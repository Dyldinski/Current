package com.current.android.current;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by duboi on 2/4/2018.
 */

public class EventPost{
    public String eventName;
    public String eventDescription;
    public String author;
    //private LatLng location;
    public String eventType;
    //private float eventRatings = 0, numberOfVotes = 0;
    public double latitude = 0, longitude = 0;
    public long timePosted;


    public EventPost(String eventName, String eventDescription, String author, LatLng location, String type, long time) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.author = author;
        latitude = location.latitude;
        longitude = location.longitude;
        this.eventType = type;
        timePosted = time;
    }

    public EventPost(){

    }

    @Override
    public boolean equals(Object object){
            return object instanceof EventPost && this.getEventName().equals(((EventPost) object).getEventName());
    }


    public static void placeSingleMarker(GoogleMap map, EventPost event){
        map.addMarker(new MarkerOptions().
                position(new LatLng(event.getLatitude(), event.getLongitude())).
                title(event.getEventName()).icon(MapsActivity.markerColors.get(event.getEventType())))
                .setTag(event);
    }


    public String getEventType() {
        return eventType;
    }


    public String getEventName() {
        return eventName;
    }


    public String getEventDescription() {
        return eventDescription;
    }

    public String getAuthor() {
        return author;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public long getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(long timePosted) {
        this.timePosted = timePosted;
    }
}
