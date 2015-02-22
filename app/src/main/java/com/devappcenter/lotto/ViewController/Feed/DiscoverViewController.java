package com.devappcenter.lotto.ViewController.Feed;

import com.devappcenter.lotto.R;
import com.devappcenter.lotto.ViewController.Feed.View.Discover;
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

    }

    @Override
    protected List<NameValuePair> getPostValue() {
        List<NameValuePair> postValue = super.getPostValue();
        postValue.add(new BasicNameValuePair("filter", "new_entry"));
        postValue.add(new BasicNameValuePair("user", ""));
        postValue.add(new BasicNameValuePair("platform", "android"));
        postValue.add(new BasicNameValuePair("page", "0"));
        return postValue;
    }

}
