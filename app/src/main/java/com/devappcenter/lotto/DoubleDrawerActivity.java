package com.devappcenter.lotto;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

import com.devappcenter.template.Helper.DrawerContainer;
import com.devappcenter.template.Helper.LeftDrawerMenu;
import com.devappcenter.template.Helper.NetworkState;

/**
 * Created by Andy on 8/17/14 AD.
 */
public class DoubleDrawerActivity extends FragmentActivity {

    protected DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    protected LeftDrawerMenu mLeftDrawerView;
    protected DrawerContainer mRightDrawerView;
    protected FrameLayout frame;
    private float lastTranslate = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_drawer_main);
        frame = (FrameLayout) findViewById(R.id.content_frame);
        mLeftDrawerView = (LeftDrawerMenu) findViewById(R.id.left_view_drawer);
        mRightDrawerView = (DrawerContainer) findViewById(R.id.right_view_drawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, mRightDrawerView);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View drawerView) {
                if (drawerView.equals(mLeftDrawerView)) {
                    //supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                    mDrawerToggle.syncState();
                }
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                if (drawerView.equals(mLeftDrawerView)) {
                    //supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                    mDrawerToggle.syncState();
                }
                else {

                }
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Avoid normal indicator glyph behaviour. This is to avoid glyph movement when opening the right drawer
                //super.onDrawerSlide(drawerView, slideOffset);
                int index = drawerView.getId();
                float moveFactor = (drawerView.getWidth() * slideOffset) * (drawerView.getId()==R.id.left_view_drawer?1:-1);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                {
                    if (!getResources().getString(R.string.screen_type).equals("phone"))
                        frame.setTranslationX(moveFactor);
                }
                else
                {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    frame.startAnimation(anim);

                    lastTranslate = moveFactor;
                }
            }
            /*
            */
        };
        /*
        if (savedInstanceState == null)
            ((LeftDrawerMenu)mLeftDrawerView).setSelectItem(NetworkState.isOnline(this)?2:1);
        else
            ((LeftDrawerMenu)mLeftDrawerView).setSelectItem(savedInstanceState.getInt("menu"));
        */
        mDrawerLayout.setDrawerListener(mDrawerToggle); // Set the drawer toggle as the DrawerListener
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("menu", ((LeftDrawerMenu)mLeftDrawerView).getSelectItem());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        // If the nav drawer is open, hide action items related to the content view
        for (int i = 0; i < menu.size(); i++)
            menu.getItem(i).setVisible(!mDrawerLayout.isDrawerOpen(mLeftDrawerView));

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerToggle.onOptionsItemSelected(item);

                if (mDrawerLayout.isDrawerOpen(mRightDrawerView))
                    mDrawerLayout.closeDrawer(mRightDrawerView);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
