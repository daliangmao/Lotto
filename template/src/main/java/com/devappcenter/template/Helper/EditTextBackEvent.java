package com.devappcenter.template.Helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

/**
 * Created by Andy on 2/13/15 AD.
 */
public class EditTextBackEvent extends EditText {

    private EditTextImeBackListener mOnImeBack;

    public EditTextBackEvent(Context context) {
        super(context);
    }

    public EditTextBackEvent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextBackEvent(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            if (mOnImeBack != null)
                mOnImeBack.onBack();
                //mOnImeBack.onImeBack(this, this.getText().toString());
        }
        return super.dispatchKeyEvent(event);
    }

    public void setOnEditTextImeBackListener(EditTextImeBackListener listener) {
        mOnImeBack = listener;
    }
}

