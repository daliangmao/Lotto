package com.devappcenter.lotto;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.devappcenter.lotto.Auth.Login;

import com.devappcenter.template.Helper.DialogActivity;

/**
 * Created by Andy on 2/14/15 AD.
 */
public class LoginActivity extends DialogActivity {

    protected void getViewDialog(LayoutInflater inflater, FrameLayout containner) {
        Login login = new Login(this);
        login.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean verify = true;
                Intent resIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("message", verify?"Ok":"Try Again");
                resIntent.putExtras(bundle);
                setResult(verify?1:0, resIntent);
                finish();
            }
        });
        containner.addView(login);
    }

}
