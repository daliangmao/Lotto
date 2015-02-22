package com.devappcenter.lotto.ViewController.Feed;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devappcenter.lotto.R;
import com.devappcenter.template.Header.MyActionBarView;
import com.devappcenter.template.Helper.Adapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Andy on 2/22/15 AD.
 */
public class DetailViewController extends Fragment {

    private JSONObject jsonData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String strData = "";
        if (getArguments() != null) {
            strData = getArguments().getString("data");
        }
        if (!strData.equals("")) {
            try {
                jsonData = new JSONObject(strData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        MyActionBarView header = MyActionBarView.getInstance();
        TextView txtTitle = (TextView) view.findViewById(R.id.txtDetailTitle);
        try {
            txtTitle.setText(jsonData.getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        header.SetModeBack();
        return view;
    }
}
