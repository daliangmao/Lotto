package com.devappcenter.template.Header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devappcenter.mylibrary.R;


/**
 * Created by Andy on 8/16/14 AD.
 */
public class CenterPannel extends RelativeLayout {//implements  RadioGroup.OnCheckedChangeListener {

    TextView txtTitle;
    protected String screen_type;
    protected int screen_orientation;

    public CenterPannel(Context context) {
        super(context);
        screen_type = getResources().getString(R.string.screen_type);
        initViews();
    }

    public CenterPannel(Context context, AttributeSet attrs) {
        super(context, attrs);
        screen_type = getResources().getString(R.string.screen_type);
        initViews();
    }

    public CenterPannel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        screen_type = getResources().getString(R.string.screen_type);
        initViews();
    }

    void initViews() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.center_pannel, this, true);
        txtTitle = (TextView) v.findViewById(R.id.txtActionbarTitle);
    }

    public void SetTitle(String text) {
        txtTitle.setText(text);
        txtTitle.setVisibility(View.VISIBLE);
    }
}
