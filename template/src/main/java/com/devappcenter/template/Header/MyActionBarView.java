package com.devappcenter.template.Header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.devappcenter.mylibrary.R;

/**
 * Created by Andy on 8/15/14 AD.
 */
public class MyActionBarView extends RelativeLayout {

    private static MyActionBarView instance = null;
    public LeftPannel leftPannel;
    public RightPannel rightPannel;
    public CenterPannel centerPannel;
    private HeaderDelegate delegate;

    public MyActionBarView(Context context) {
        super(context);
        initViews();
        delegate = (HeaderDelegate) context;
    }

    public MyActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
        delegate = (HeaderDelegate) context;
    }

    public static MyActionBarView getInstance(Context context) {
        instance = new MyActionBarView(context);
        return instance;
    }

    public static MyActionBarView getInstance() {
        return instance;
    }

    void initViews()
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.actionbar, this, true);
        leftPannel = (LeftPannel) v.findViewById(R.id.leftPannel);
        rightPannel = (RightPannel) v.findViewById(R.id.rightPannel);
        centerPannel = (CenterPannel) v.findViewById(R.id.centerPannel);
        /*
        leftPannel.btnSetting.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                delegate.LeftDrawerOpen(true);
            }
        });
        */
    }

    public void SetModeAuth() {
        if (getResources().getString(R.string.screen_type).equals("phone")) {
            centerPannel.setVisibility(GONE);
            centerPannel.SetTitle("");
        }
        leftPannel.SetModeAuth();
    }

    public void SetModeUser() {
        leftPannel.SetModeUser();
        centerPannel.setVisibility(VISIBLE);
    }

    public void SetModeBack() {
        leftPannel.SetModeBack();
        centerPannel.setVisibility(VISIBLE);
    }

    public void SetModeTitle(String title) {
        //centerPannel.setVisibility(VISIBLE);
        leftPannel.SetTitle(title);
    }

    public void SetHiddenCenterPannel(boolean hide) {
        centerPannel.setVisibility(hide?GONE:VISIBLE);
    }

    public void LockMenu(Boolean lock) {
        delegate.LeftDrawerLock(lock);
    }

    public interface HeaderDelegate {
        void LeftDrawerLock(Boolean lock);
        void LeftDrawerOpen(boolean open);
    }
}
