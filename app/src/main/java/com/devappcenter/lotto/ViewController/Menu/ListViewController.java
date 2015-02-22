package com.devappcenter.lotto.ViewController.Menu;

import android.app.Activity;
import android.content.Context;
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
import com.devappcenter.template.Helper.ViewCell;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Andy on 2/21/15 AD.
 */
public class ListViewController extends Fragment {

    private ArrayList<ViewCell> menuItems;
    Adapter adapter;

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
        JSONObject header = new JSONObject();
        try {
            item1.put("title", "Hello");
            item2.put("title", "World");
            header.put("title", "Header");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        menuItems.add(new HeaderItem(getActivity(), header));
        menuItems.add(new MenuItem(getActivity(), item1));
        menuItems.add(new MenuItem(getActivity(), item2));
        adapter = new Adapter(getActivity(), android.R.layout.simple_list_item_1, menuItems);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_fragment, container, false);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getActivity().getResources().getStringArray(R.array.mymenu));
        ListView listMenu = (ListView) view.findViewById(R.id.list_menu);
        listMenu.setAdapter(adapter);
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViewCell viewCell = (ViewCell)adapter.getItem(position);
                if (viewCell.getViewType()==Adapter.RowType.HEADER.ordinal())
                    return;
                Toast.makeText(getActivity(), ((MenuItem)viewCell).title(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private class MenuItem extends ViewCell {

        @Override
        public int getViewType() {
            return Adapter.RowType.ITEM.ordinal();
        }

        @Override
        public View getViewItem(LayoutInflater inflater, View convertView) {
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.menu_item, null);
            }
            TextView lblTitle = (TextView) view.findViewById(R.id.lbl_menu_title);
            try {
                lblTitle.setText(jsonItem.getString("title"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return view;
        }

        public MenuItem(Context context, JSONObject json) {
            super(context, json);
        }

        public String title() {
            String title = "";
            try {
                title = jsonItem.getString("title");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return title;
        }
    }

    private class HeaderItem extends ViewCell {

        @Override
        public int getViewType() {
            return Adapter.RowType.HEADER.ordinal();
        }

        @Override
        public View getViewItem(LayoutInflater inflater, View convertView) {
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.menu_header, null);
            }
            TextView lblTitle = (TextView) view.findViewById(R.id.lbl_menu_header);
            try {
                lblTitle.setText(jsonItem.getString("title"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            return view;
        }

        public HeaderItem(Context context, JSONObject json) {
            super(context, json);
        }
    }
}
