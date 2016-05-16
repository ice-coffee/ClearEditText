package com.view.clear;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ClearEditText extends LinearLayout {
    private final static String NUMBER = "number";
    private EditText mText;
    private ImageView mDelete;

    public ClearEditText(Context context) {
        super(context);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.text);
        String editHint = typedArray.getString(R.styleable.text_hint);
        int inputType = typedArray.getInt(R.styleable.text_inputType, 0);

        View clearEditText = View.inflate(context, R.layout.view_clear_edittext, this);
        mText = (EditText) clearEditText.findViewById(R.id.et_text);
        mDelete = (ImageView) clearEditText.findViewById(R.id.iv_delete_text);

        mText.setHint(editHint);

        if (inputType == 1) {
            mText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }

        if (inputType == 2) {
            mText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

        mText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int textLeng = editable.toString().length();
                if (textLeng > 0) {
                    mDelete.setVisibility(VISIBLE);
                } else {
                    mDelete.setVisibility(INVISIBLE);
                }
            }
        });

        mDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mText.setText("");
            }
        });
    }

    public String getText() {
        return mText.getText().toString();
    }

    public void setText(String text) {
        mText.setText(text);
    }

    public void addTextChangedListener(TextWatcher watcher) {
        mText.addTextChangedListener(watcher);
    }
}
