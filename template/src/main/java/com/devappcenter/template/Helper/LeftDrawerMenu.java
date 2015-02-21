package com.devappcenter.template.Helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.devappcenter.mylibrary.R;

/**
 * Created by Andy on 8/18/14 AD.
 */
public class LeftDrawerMenu extends DrawerContainer {

    private ListMenu mMenu;
    private ListView mDrawerList;
    private Adapter AdapterSetting;
    private MenuDelegate delegate;
    private CellItem selectItem;

    public LeftDrawerMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        delegate = (MenuDelegate)context;
    }

    @Override
    protected void initViews() {
        super.initViews();
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.main_menu, this, true);
        mDrawerList = (ListView) v.findViewById(R.id.listViewMenu);
        mMenu = new ListMenu(getContext());
        AdapterSetting = new Adapter((android.app.Activity) getContext(), android.R.layout.simple_list_item_activated_1, mMenu);
        mDrawerList.setAdapter(AdapterSetting);
        mDrawerList.setSelection(2);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    selectItem.selected = false;
                    selectItem = (CellItem) mMenu.get(position);
                    selectItem.selected = true;
                    AdapterSetting.notifyDataSetChanged();
                }
                else {

                }
                delegate.didMenuSelectItem(position);
            }
        });
    }

    public void addMenuItem() {

    }

    public void setSelectItem(int index) {
        selectItem = (CellItem) mMenu.get(index);
        selectItem.selected = true;
    }

    public int getSelectItem() {
        return selectItem.getTag();
    }

    public void Reload() {
        //mMenu.ReloadUserProfile();
        AdapterSetting.setNotifyOnChange(true);
    }

    public interface MenuDelegate {
        void didMenuSelectItem(Integer index);
    }
}
