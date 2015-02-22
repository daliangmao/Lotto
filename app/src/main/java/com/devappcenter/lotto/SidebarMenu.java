package com.devappcenter.lotto;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.devappcenter.template.Helper.CellItem;
import com.devappcenter.template.Helper.ListMenu;

/**
 * Created by Andy on 2/22/15 AD.
 */
public class SidebarMenu extends ListMenu {

    private Integer selected;
    private SidebarCheckListener sidebarListener = new SidebarCheckListener() {
        @Override
        public void onSidebarCheck(boolean check) {
            Select(check);
        }
    };
    private CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Select(isChecked);
        }
    };

    public SidebarMenu(Context context) {
        super(context);
        selected = 0;
        int imgDiscover = context.getResources().getIdentifier("ic_list_book", "drawable", context.getPackageName());
        SidebarMenuItem item1 = new SidebarMenuItem("Fragment", imgDiscover, 1);
        item1.setSidebarCheckChangeListener(sidebarListener);
        this.add(item1);
        this.add(new SidebarMenuItem("Normal List", imgDiscover, 2).setSidebarCheckChangeListener(sidebarListener));
        this.add(new SidebarMenuItem("Load more page", imgDiscover, 3).setSidebarCheckChangeListener(sidebarListener));
    }

    void Select(boolean select) {
        if (select)
            selected++;
        else
            selected--;
        if (selected == 0)
            selected = 0;
    }

    public class MyMenuItem extends CellItem {

        private CheckBox chkSelect;

        public MyMenuItem(String title, int imageResource, int tag) {
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
            chkSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Select(isChecked);
                }
            });
            txtTitle.setText(mTitle);
            imgMenu.setImageResource(mImage);
            txtTitle.setTextColor(selected? Color.WHITE: Color.parseColor("#808080"));
            view.setBackgroundColor(selected? Color.parseColor("#FFEE99B9"): Color.TRANSPARENT);
            return view;
        }
    }
}
