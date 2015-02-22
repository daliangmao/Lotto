package com.devappcenter.lotto;

import android.content.Context;

import com.devappcenter.template.Helper.CellItem;
import com.devappcenter.template.Helper.ListMenu;

/**
 * Created by Andy on 2/22/15 AD.
 */
public class SidebarMenu extends ListMenu {

    public SidebarMenu(Context context) {
        super(context);
        int imgDiscover = context.getResources().getIdentifier("ic_list_book", "drawable", context.getPackageName());
        this.add(new CellItem("ชั้นหนังสือ", imgDiscover, 1));
        this.add(new CellItem("รายการหนังสือ", imgDiscover, 2));
    }
}
