package com.example.andrew.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class DataAdapter extends ArrayAdapter {

    List<DataItem> mDataItems;
    LayoutInflater mInflater;


    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public DataAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mDataItems = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_items, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.expandedListItems);


        DataItem item = mDataItems.get(position);

        tvName.setText(item.getX());
        tvName.setText(item.getY());
        tvName.setText(item.getXax());
        tvName.setText(item.getYax());
        tvName.setText(item.getCbt());
        tvName.setText(item.getZbt());
        tvName.setText(item.getTimestamp());


/*
        InputStream inputStream = null;
        try {
            String imageFile = item.getImage();
            // File operations, need to get the image from asset files.
            inputStream = getContext().getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        return convertView;
    }
}