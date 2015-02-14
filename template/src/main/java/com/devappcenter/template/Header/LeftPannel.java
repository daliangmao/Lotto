package com.devappcenter.template.Header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devappcenter.mylibrary.R;

/**
 * Created by Andy on 8/15/14 AD.
 */
public class LeftPannel extends RelativeLayout {

    private TextView txtTitle;
    ImageButton btnSetting;
    ImageButton btnBack;
    LeftPannelDelegate delegate;

    public LeftPannel(Context context) {
        super(context);
        delegate = (LeftPannelDelegate) context;
        initViews();
    }

    public LeftPannel(Context context, AttributeSet attrs) {
        super(context, attrs);
        delegate = (LeftPannelDelegate) context;
        initViews();
    }

    public LeftPannel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        delegate = (LeftPannelDelegate) context;
        initViews();
    }

    void initViews()
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.left_pannel, this, true);
        txtTitle = (TextView) v.findViewById(R.id.txtActionbarTitle);
        btnSetting = (ImageButton) v.findViewById(R.id.btnSetting);
        btnBack = (ImageButton) v.findViewById(R.id.btnBack);
        btnSetting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.OnSetting();
            }
        });
        btnSetting.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction() & MotionEvent.ACTION_MASK;
                switch (action) {

                    case MotionEvent.ACTION_DOWN: {
                        btnSetting.setAlpha(0.5f);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnSetting.setAlpha(1.0f);
                        break;
                    }
                }
                return false;
            }
        });
        btnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.OnBack();
            }
        });
        btnBack.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction() & MotionEvent.ACTION_MASK;
                switch (action) {

                    case MotionEvent.ACTION_DOWN: {
                        btnBack.setAlpha(0.5f);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnBack.setAlpha(1.0f);
                        break;
                    }
                }
                return false;
            }
        });
    }

    public void SetModeBack() {
        btnSetting.setVisibility(View.GONE);
        btnBack.setVisibility(View.VISIBLE);
    }

    public void SetModeAuth() {
        btnSetting.setVisibility(View.GONE);
        btnBack.setVisibility(View.GONE);
    }

    public void SetModeUser() {
        btnSetting.setVisibility(View.VISIBLE);
        btnBack.setVisibility(View.GONE);
    }

    public void SetTitle(String text) {
        txtTitle.setText(text);
        txtTitle.setVisibility(View.VISIBLE);
    }

    public interface LeftPannelDelegate {
        void OnBack();
        void OnSetting();
    }
}
