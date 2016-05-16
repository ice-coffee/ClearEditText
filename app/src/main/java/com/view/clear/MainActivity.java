package com.view.clear;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by ice_coffee on 2016/5/12.
 */
public class MainActivity extends Activity
{
    private ClearEditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
    }

    public void initializeView()
    {
        mEditText = (ClearEditText)findViewById(R.id.et_cleartext);

//        mEditText.addTextChangedListener();
    }
}
