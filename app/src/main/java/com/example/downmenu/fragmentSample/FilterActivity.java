package com.example.downmenu.fragmentSample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class FilterActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new FilterFragment(), FilterFragment.class.getCanonicalName())
                .commitAllowingStateLoss();
    }

}
