package com.doomonafireball.ermahgerd.sample.activity;

import com.doomonafireball.ermahgerd.Ermahgerd;
import com.doomonafireball.ermahgerd.sample.R;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * User: derek Date: 3/17/13 Time: 3:59 PM
 */
public class SampleActivity extends BaseSampleActivity {

    private EditText input;
    private EditText result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);

        input = (EditText) findViewById(R.id.input);
        result = (EditText) findViewById(R.id.result);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                result.setText(Ermahgerd.translate(s.toString()));
            }
        });

        result.setText(Ermahgerd.translate(""));
        input.requestFocus();
    }
}
