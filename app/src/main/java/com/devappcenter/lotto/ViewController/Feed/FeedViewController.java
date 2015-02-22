package com.devappcenter.lotto.ViewController.Feed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.devappcenter.lotto.R;
import com.devappcenter.template.Helper.Adapter;
import com.devappcenter.template.Helper.UrlLoadAsync;
import com.devappcenter.template.Helper.ViewCell;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

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
    protected String hostname;
    public abstract String getUrl();
    public abstract ViewCell cellForItemAtIndex(JSONObject obj, Integer position);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            preload = getArguments().getString("data");
        }
        adapter = new Adapter(getActivity(), android.R.layout.simple_list_item_1, new ArrayList());
        hostname = getResources().getString(R.string.host_name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        listMenu = (ListView) view.findViewById(R.id.list_menu);
        listMenu.setAdapter(adapter);
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
