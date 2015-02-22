package com.devappcenter.lotto;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.devappcenter.template.Helper.CellItem;

/**
 * Created by Andy on 2/22/15 AD.
 */
public class SidebarMenuItem extends CellItem {

    private CheckBox chkSelect;
    private SidebarCheckListener myListener;
    private CompoundButton.OnCheckedChangeListener checkedChangeListener;

    public SidebarMenuItem(String title, int imageResource, int tag) {
        super(title, imageResource, tag);
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.sidebar_menu_item, null);
        }
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        ImageView imgMenu = (ImageView) view.findViewById(R.id.imgMenu);
        chkSelect = (CheckBox) view.findViewById(R.id.check_delete);
        chkSelect.setOnCheckedChangeListener(checkedChangeListener);
        chkSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (myListener != null)
                    myListener.onSidebarCheck(isChecked);
            }
        });
        /*
        */
        txtTitle.setText(mTitle);
        imgMenu.setImageResource(mImage);
        txtTitle.setTextColor(selected? Color.WHITE: Color.parseColor("#808080"));
        view.setBackgroundColor(selected? Color.parseColor("#FFEE99B9"): Color.TRANSPARENT);
        return view;
    }

    public void setOnCheckListener(CompoundButton.OnCheckedChangeListener listener) {
        checkedChangeListener = listener;
    }

    public SidebarMenuItem setSidebarCheckChangeListener(SidebarCheckListener listener) {
        myListener = listener;
        return this;
    }
}

interface SidebarCheckListener {
    void onSidebarCheck(boolean check);
}