package com.devappcenter.lotto.ViewController;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        textView.setText("Login");
        MyActionBarView header = MyActionBarView.getInstance();
        header.SetModeUser();
        return  textView;
    }
}
