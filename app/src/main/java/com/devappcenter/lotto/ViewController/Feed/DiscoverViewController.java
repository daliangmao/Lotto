package com.devappcenter.lotto.ViewController.Feed;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import com.devappcenter.lotto.R;
import com.devappcenter.lotto.ViewController.Feed.View.Discover;
import com.devappcenter.template.Header.MyActionBarView;
import com.devappcenter.template.Helper.FeedViewController;
import com.devappcenter.template.Helper.ViewCell;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 2/22/15 AD.
 */
public class DiscoverViewController extends FeedViewController {

    @Override
    public String getUrl() {
        return getResources().getString(R.string.host_name)+"/discover.php";
    }

    @Override
    public ViewCell cellForItemAtIndex(JSONObject obj, Integer position) {
        return new Discover(getActivity(), obj);
    }

    @Override
    public void OnItemClick(Integer position) {
        ViewCell viewCell = (ViewCell)listMenu.getAdapter().getItem(position);
        Bundle bundle = new Bundle();
        bundle.putString("data", viewCell.getContent().toString());
        FragmentManager fragmentManager = getFragmentManager();
        DetailViewController viewController = new DetailViewController();
        viewController.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.content_frame, viewController, "Detail").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
    }

    @Override
    public void OnInitialize() {
        MyActionBarView header = MyActionBarView.getInstance();
        header.SetModeUser();
    }

    @Override
    protected List<NameValuePair> getPostValue() {
        List<NameValuePair> postValue = super.getPostValue();
        postValue.add(new BasicNameValuePair("filter", "new_entry"));
        postValue.add(new BasicNameValuePair("user", ""));
        postValue.add(new BasicNameValuePair("platform", "android"));
        return postValue;
    }

}
