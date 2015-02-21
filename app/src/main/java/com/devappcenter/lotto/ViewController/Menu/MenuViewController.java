package com.devappcenter.lotto.ViewController.Menu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devappcenter.lotto.R;
import com.devappcenter.template.Helper.FeedAdapter;
import com.devappcenter.template.Helper.InterfaceItem;
import com.devappcenter.template.Helper.ViewCell;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 2/21/15 AD.
 */
public class MenuViewController extends Fragment {

    private ArrayList<MenuItem> menuItems;
    FeedAdapter adapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuItems = new ArrayList<>();
        JSONObject item1 = new JSONObject();
        JSONObject item2 = new JSONObject();
        try {
            item1.put("title", "Hello");
            item2.put("title", "World");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        menuItems.add(new MenuItem(getActivity(), item1));
        menuItems.add(new MenuItem(getActivity(), item2));
        adapter = new FeedAdapter(getActivity(), android.R.layout.simple_list_item_1, menuItems);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getActivity().getResources().getStringArray(R.array.mymenu));
        ListView listMenu = (ListView) view.findViewById(R.id.list_menu);
        listMenu.setAdapter(adapter);
        return view;
    }

    private class MenuItem extends ViewCell {

        @Override
        public View getViewItem(LayoutInflater inflater, View convertView) {
            return null;
        }

        public MenuItem(Context context, JSONObject json) {
            super(context, json);
        }

    }

    private class HeaderItem extends ViewCell {

        @Override
        public View getViewItem(LayoutInflater inflater, View convertView) {
            return null;
        }

        public HeaderItem(Context context, JSONObject json) {
            super(context, json);
        }
    }
}
