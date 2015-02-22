package com.devappcenter.lotto.ViewController.Feed.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devappcenter.lotto.R;
import com.devappcenter.template.Helper.ViewCell;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Andy on 2/22/15 AD.
 */
public class Discover extends ViewCell{

    public Discover(Context context, JSONObject json) {
        super(context, json);
    }

    @Override
    public View getViewItem(LayoutInflater inflater, View convertView) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.discover_view, null);
        }
        TextView lblTitle = (TextView) view.findViewById(R.id.lbl_discover_title);
        ImageView imgCover = (ImageView) view.findViewById(R.id.image_discover);
        try {
            lblTitle.setText(jsonItem.getString("title"));
            Ion.with(imgCover).load(jsonItem.getString("thumb"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }
}
