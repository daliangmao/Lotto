package com.devappcenter.template.Helper;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by APPLE on 1/10/14.
 */
public class FeedAdapter extends Adapter {

    private LayoutInflater mInflater;
    public String url;
    public AdapterDelegate delegate = null;

    public enum RowType {
        LIST_ITEM, HEADER_ITEM, LOADING, SECTION
    }

    public FeedAdapter(Activity ctx, int resource, ArrayList objects){
        super(ctx, resource, objects);
        mInflater = LayoutInflater.from(ctx);
    }

    public void UpdateTaskFinished(){
        if (delegate != null)
            delegate.onTaskFinished();
    }

    @Override
    public int getViewTypeCount() {
        return RowType.values().length;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(mInflater, convertView);
    }

    public interface AdapterDelegate{
        public void onTaskFinished();
    }
}
