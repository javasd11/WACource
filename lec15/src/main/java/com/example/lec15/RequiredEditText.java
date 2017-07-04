package com.example.lec15;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

import com.vados.wacource.lec15.R;

/**
 * Created by vadim on 04.07.2017.
 */

public class RequiredEditText extends android.support.v7.widget.AppCompatEditText {

    private boolean mRequired = false;

    public RequiredEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RequiredEditText, 0, 0);
        this.mRequired = a.getBoolean(R.styleable.RequiredEditText_requirde, false);

        a.recycle();
    }

    public boolean getRequired() {
        return this.mRequired;
    }

    public void setRequired(boolean required) {
        this.mRequired = required;
    }

    public boolean validate() {
        if (mRequired && getText().toString().length() == 0) {
            setError("Field is required");
            return false;
        }

        return true;
    }
}
