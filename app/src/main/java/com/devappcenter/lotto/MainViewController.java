package com.devappcenter.lotto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devappcenter.template.Header.MyActionBarView;

import java.util.zip.Inflater;

/**
 * Created by Andy on 2/14/15 AD.
 */
public class MainViewController extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("Main");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Fragment fragment = new DetailViewController();
                fragmentManager.beginTransaction().replace(R.id.frame_content, fragment, "DETAIL").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
            }
        });
        MyActionBarView header = (MyActionBarView) getActivity().findViewById(R.id.lay_header);
        header.SetModeUser();

        return  textView;
    }
}
