package com.current.android.current;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by duboi on 3/1/2018.
 */


// sole function (no pun intended) of this class is to spawn a popupwindow when an event is clicked.
public class PopupWindowCreator {

    private static PopupWindow markerPopUp;

    public static void createMarkerPopup(Marker marker, FrameLayout frameLayout, Context context){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customView = inflater.inflate(R.layout.map_popup_window, null);
            markerPopUp = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            markerPopUp.showAtLocation(frameLayout, Gravity.CENTER,0,0);
            markerPopUp.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            markerPopUp.setOutsideTouchable(true);

            Button windowButton = customView.findViewById(R.id.popup_close_button);
            TextView eventNameText = (TextView) customView.findViewById(R.id.eventNameText);
            TextView eventDescriptionText = (TextView) customView.findViewById(R.id.eventDescriptionText);
            TextView eventTypeText = (TextView) customView.findViewById(R.id.eventTypeText);
            TextView authorNameText = (TextView) customView.findViewById(R.id.authorNameText);

            EventPost eventPost = (EventPost) marker.getTag();
            eventNameText.setText("Event Name: \n" + marker.getTitle());
            eventDescriptionText.setText("Description: \n" +eventPost.getEventDescription());
            eventTypeText.setText("Event Type: \n" + eventPost.getEventType());
            long timeDiffInHours = (System.currentTimeMillis() - eventPost.getTimePosted()) / 3600000;
            authorNameText.setText("Posted by " + eventPost.getAuthor()
                    + "\n" + timeDiffInHours +" hours ago");

            windowButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Current", "Popupwindow button pressed!");
                    markerPopUp.dismiss();
                }
            });
        }

    public static void createAvatarPopup(FrameLayout frameLayout, Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.avatar_popup_window, null);
        final PopupWindow avatarPopup = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        avatarPopup.showAtLocation(frameLayout, Gravity.CENTER,0,0);
        avatarPopup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        avatarPopup.setOutsideTouchable(true);

        Button windowButton = customView.findViewById(R.id.popup_close_button);


        windowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Current", "Popupwindow button pressed!");
                avatarPopup.dismiss();
            }
        });
    }
    }

