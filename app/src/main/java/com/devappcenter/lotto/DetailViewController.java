package com.devappcenter.lotto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devappcenter.template.Header.MyActionBarView;

/**
 * Created by Andy on 2/14/15 AD.
 */
public class DetailViewController extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("Detail");

        MyActionBarView header = (MyActionBarView) getActivity().findViewById(R.id.lay_header);
        header.SetModeBack();

        return  textView;
    }
}
