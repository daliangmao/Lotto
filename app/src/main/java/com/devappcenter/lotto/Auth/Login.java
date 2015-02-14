package com.devappcenter.lotto.Auth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.devappcenter.lotto.R;

/**
 * Created by Andy on 2/14/15 AD.
 */
public class Login extends RelativeLayout {

    public Button btnLogin;

    public Login(Context context) {
        super(context);
        initViews();
    }

    public Login(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initViews() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.login_view, this, true);
        btnLogin = (Button) v.findViewById(R.id.btn_login);

    }
}
