package com.devappcenter.template.Helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.devappcenter.mylibrary.R;
import com.devappcenter.template.Helper.TwoWayGridView.TwoWayAdapterView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andy on 2/22/15 AD.
 */
public abstract class FeedViewController extends Fragment {

    private ListView listMenu;
    private Integer page;
    private Adapter adapter;
    private String preload;
    public abstract String getUrl();
    public abstract ViewCell cellForItemAtIndex(JSONObject obj, Integer position);
    public abstract void OnItemClick(Integer position);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            preload = getArguments().getString("data");
        }
        adapter = new Adapter(getActivity(), android.R.layout.simple_list_item_1, new ArrayList());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_fragment, container, false);
        listMenu = (ListView) view.findViewById(R.id.list_feed_item);
        listMenu.setAdapter(adapter);
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OnItemClick(position);
            }
        });
        if (preload == null) {
            Feed(0);
        }
        return  view;
    }

    protected void addItem(JSONArray jsonArray) throws JSONException {
        for (int i=0; i<jsonArray.length(); i++){
            JSONObject d = jsonArray.getJSONObject(i);
            adapter.add(cellForItemAtIndex(d, i));
        }
    }

    protected List<NameValuePair> getPostValue() {
        List<NameValuePair> postValue = new ArrayList<NameValuePair>(2);
        postValue.add(new BasicNameValuePair("page", String.valueOf(page)));
        postValue.add(new BasicNameValuePair("platform", "android"));
        return postValue;
    }

    public void Feed(Integer page) {
        this.page = page;
        Map<String, String> mapUrl = new HashMap<String, String>();
        Map<String, List<NameValuePair>> mapPost = new HashMap<String, List<NameValuePair>>();
        mapPost.put("post", getPostValue());
        mapUrl.put("url", getUrl());
        new Fetch().execute(mapUrl, mapPost, null);
    }

    private class Fetch extends UrlLoadAsync {

        @Override
        protected void onPostExecute(String result)
        {
            if (result != null){
                try {
                    JSONArray jsonObject = new JSONArray(result).getJSONArray(0);
                    addItem(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            adapter.setNotifyOnChange(true);
        }
    }

}
