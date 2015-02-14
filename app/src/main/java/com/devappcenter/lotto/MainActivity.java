package com.devappcenter.lotto;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.devappcenter.template.Header.LeftPannel;
import com.devappcenter.template.Header.MyActionBarView;
import com.devappcenter.template.Header.RightPannel;


public class MainActivity extends ActionBarActivity implements LeftPannel.LeftPannelDelegate, RightPannel.RightPannelDelegate, MyActionBarView.HeaderDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnBack() {

    }

    @Override
    public void OnSetting() {

    }

    @Override
    public void OnSearch(String keyword) {

    }

    @Override
    public void didSearchViewExpand() {

    }

    @Override
    public void didSearchViewShrink() {

    }

    @Override
    public void LeftDrawerLock(Boolean lock) {

    }

    @Override
    public void LeftDrawerOpen(boolean open) {

    }
}
