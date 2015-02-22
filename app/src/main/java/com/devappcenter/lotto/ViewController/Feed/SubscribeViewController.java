package com.devappcenter.lotto.ViewController.Feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.devappcenter.template.Helper.FeedViewController;
import com.devappcenter.template.Helper.ViewCell;

import org.json.JSONObject;

/**
 * Created by Andy on 2/22/15 AD.
 */
public class SubscribeViewController extends FeedViewController {
    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public ViewCell cellForItemAtIndex(JSONObject obj, Integer position) {
        return null;
    }

    @Override
    public void OnItemClick(Integer position) {

    }

    private class SubscribeView extends ViewCell {

        public SubscribeView(Context context, JSONObject json) {
            super(context, json);
        }

        @Override
        public View getViewItem(LayoutInflater inflater, View convertView) {
            return null;
        }
    }
}
