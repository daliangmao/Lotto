package com.devappcenter.template.Helper;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.devappcenter.mylibrary.R;


/**
 * Created by APPLE on 3/2/14.
 */
public class ClearableEditText extends RelativeLayout {

    LayoutInflater inflater = null;
    public EditText edit_text;
    Button btn_clear;
    int maxWidth;
    private boolean isShrink = true;
    private InputMethodManager inputMethodManager;
    public ClearableEditTextDelegate delegate;

    public ClearableEditText(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        inputMethodManager=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        initViews();
    }

    public ClearableEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        inputMethodManager=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        initViews();

    }

    public ClearableEditText(Context context)
    {
        super(context);
        // TODO Auto-generated constructor stub
        inputMethodManager=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        initViews();
    }

    void initViews()
    {
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.clearable_edit_text, this, true);
        delegate = null;

        edit_text = (EditText) findViewById(R.id.clearable_edit);
        btn_clear = (Button) findViewById(R.id.clearable_button_clear);
        ImageButton magnify = (ImageButton) findViewById((R.id.btnMagnify));
        magnify.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                expand();
            }
        });

        maxWidth = 130;//edit_text.getWidth();
        clearText();
        //showHideClearButton();
        //btn_clear.setVisibility(RelativeLayout.GONE);
        shrink();
    }

    void clearText()
    {
        btn_clear.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                edit_text.setText("");
            }
        });
    }

    void showHideClearButton()
    {
        edit_text.addTextChangedListener(new TextWatcher()
        {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                // TODO Auto-generated method stub
                if (s.length() > 0)
                    btn_clear.setVisibility(RelativeLayout.VISIBLE);
                else
                    btn_clear.setVisibility(isShrink? RelativeLayout.GONE: RelativeLayout.INVISIBLE);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // TODO Auto-generated method stub

            }
        });
    }

    public Editable getText()
    {
        Editable text = edit_text.getText();
        return text;
    }

    public void shrink() {
        this.setActivated(false);
        isShrink = true;
        edit_text.setText("");
        edit_text.setVisibility(GONE);
        btn_clear.setVisibility(GONE);
        edit_text.clearFocus();
        if (delegate != null)
            delegate.OnShrink();
    }

    public void expand() {
        this.setActivated(true);
        isShrink = false;
        btn_clear.setVisibility(INVISIBLE);
        edit_text.setVisibility(VISIBLE);
        edit_text.requestFocus();
        inputMethodManager.toggleSoftInputFromWindow(this.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
        if (delegate != null)
            delegate.OnExpand();
    }

    public interface ClearableEditTextDelegate {
        void OnShrink();
        void OnExpand();
    }
}
