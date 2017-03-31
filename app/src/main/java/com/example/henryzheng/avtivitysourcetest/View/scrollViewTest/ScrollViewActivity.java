package com.example.henryzheng.avtivitysourcetest.View.scrollViewTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.example.henryzheng.avtivitysourcetest.R;

public class ScrollViewActivity extends AppCompatActivity {
    TestScrollView testScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        testScrollView=(TestScrollView)findViewById(R.id.testScrollView);
        for (int i=0;i<100;i++){
            ((ViewGroup)testScrollView.getChildAt(0)).addView(new TransFormView(this));
        }
    }
}
