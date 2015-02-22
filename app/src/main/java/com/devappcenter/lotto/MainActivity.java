package com.devappcenter.lotto;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.devappcenter.lotto.ViewController.Feed.DiscoverViewController;
import com.devappcenter.lotto.ViewController.MainViewController;
import com.devappcenter.lotto.ViewController.Menu.ListViewController;
import com.devappcenter.template.Header.LeftPannel;
import com.devappcenter.template.Header.MyActionBarView;
import com.devappcenter.template.Header.RightPannel;


public class MainActivity extends DoubleDrawerActivity implements LeftPannel.LeftPannelDelegate, RightPannel.RightPannelDelegate, MyActionBarView.HeaderDelegate {

    private static final int LOGIN_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //int imgDiscover = getResources().getIdentifier("ic_list_book", "drawable", getPackageName());
        //mLeftDrawerView.addMenuItem(new CellItem("ชั้นหนังสือ", imgDiscover, 1));
        mLeftDrawerView.setMenu(new SidebarMenu(this), 0);
        if (savedInstanceState == null) {
            didMenuSelectItem(0);
             /*
            MainViewController fragment = new MainViewController();
            fragment.delegate = this;
            fragmentManager.beginTransaction().replace(R.id.frame_content, fragment, "DISCOVER").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
            FragmentManager fragmentManager = getSupportFragmentManager();
            ListViewController menuViewController = new ListViewController();
            fragmentManager.beginTransaction().replace(R.id.content_frame, menuViewController, "DISCOVER").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
            */
        }
    }

    @Override
    public void didMenuSelectItem(Integer index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment viewController = null;
        switch (index) {
            case 0:
                viewController = new MainViewController();
                break;
            case 1:
                viewController = new ListViewController();
                break;
            case 2:
                viewController = new DiscoverViewController();
                break;
            default:
                break;
        }
        fragmentManager.beginTransaction().replace(R.id.content_frame, viewController, viewController.getClass().getSimpleName()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOGIN_REQUEST_CODE) {
            Bundle bundle = data.getExtras();
            String message = bundle.getString("message");
            if (resultCode == 1) {

            }
            else {

            }
        }
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
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
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
