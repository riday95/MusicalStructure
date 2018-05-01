package com.example.android.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MusicAdapter extends ArrayAdapter<Music> {
    public MusicAdapter(Activity context, ArrayList<Music> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.library_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Music currentMusic = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_title);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        songNameTextView.setText(currentMusic.getsongName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        artistNameTextView.setText(currentMusic.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.track_image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentMusic.getAlbumart());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
