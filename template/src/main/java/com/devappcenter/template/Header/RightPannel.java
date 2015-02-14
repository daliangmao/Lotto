package com.devappcenter.template.Header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.devappcenter.mylibrary.R;
import com.devappcenter.template.Helper.ClearableEditText;

/**
 * Created by Andy on 8/15/14 AD.
 */
public class RightPannel extends RelativeLayout implements ClearableEditText.ClearableEditTextDelegate {

    ClearableEditText txtSearch;
    RightPannelDelegate delegate;
    private FrameLayout frameButtons;
    private String screen;

    public RightPannel(Context context) {
        super(context);
        delegate = (RightPannelDelegate)context;
        initViews(context.getResources().getString(R.string.screen_type).equals("phone"));
    }

    public RightPannel(Context context, AttributeSet attrs) {
        super(context, attrs);
        delegate = (RightPannelDelegate)context;
        initViews(context.getResources().getString(R.string.screen_type).equals("phone"));
    }

    public RightPannel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        delegate = (RightPannelDelegate)context;
        initViews(context.getResources().getString(R.string.screen_type).equals("phone"));
    }

    void initViews(boolean phone_screen)
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.right_pannel, this, true);
        final fyl lfyl = new fyl(getContext());
        frameButtons = (FrameLayout) v.findViewById(R.id.frameButton);
        txtSearch = (ClearableEditText) v.findViewById(R.id.searchView);
        txtSearch.delegate = this;
        txtSearch.edit_text.setTextColor(getResources().getColor(android.R.color.black));
        txtSearch.edit_text.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    String searchKey = txtSearch.getText().toString();
                    delegate.OnSearch(searchKey);
                    lfyl.getInputManager().hideSoftInputFromWindow(txtSearch.getWindowToken(), 0);
                    txtSearch.shrink();
                    return true;
                }
                return false;
            }
        });/**/
    }

    public void SetModeSearch(boolean searchable) {
        txtSearch.setVisibility(searchable?VISIBLE:GONE);
    }

    public void AttatchCustomMenu(RelativeLayout layout) {
        DetatchCustomMenu();
        frameButtons.addView(layout);
    }

    public void DetatchCustomMenu() {
        frameButtons.removeAllViews();
    }

    @Override
    public void OnShrink() {
        delegate.didSearchViewShrink();
    }

    @Override
    public void OnExpand() {
        delegate.didSearchViewExpand();
    }

    public static class fyl {

        Context mContext;

        public fyl(Context mContext){
            this.mContext = mContext;
        }

        public InputMethodManager getInputManager(){
            return  (InputMethodManager)mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        }
    }

    public interface RightPannelDelegate {
        void OnSearch(String keyword);
        void didSearchViewExpand();
        void didSearchViewShrink();
    }
}
