package com.os.operando.arraymapsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends Activity {

    private static final int SIZE = 100000;

    @InjectView(R.id.text_hashmap)
    TextView hashMapTime;

    @InjectView(R.id.text_arraymap)
    TextView arrayMapTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.button_arraymap)
    public void onArrayMap(View v) {
        long s = System.currentTimeMillis();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < SIZE; i++) {
            map.put(Integer.toString(i), i);
        }
        long e = System.currentTimeMillis();
        arrayMapTime.setText("Time : " + (e - s) + "ms");
    }

    @OnClick(R.id.button_hasumap)
    public void onHashyMap(View v) {
        long s = System.currentTimeMillis();
        ArrayMap<String, Integer> map = new ArrayMap<String, Integer>();
        for (int i = 0; i < SIZE; i++) {
            map.put(Integer.toString(i), i);
        }
        long e = System.currentTimeMillis();
        hashMapTime.setText("Time : " + (e - s) + "ms");
    }
}
