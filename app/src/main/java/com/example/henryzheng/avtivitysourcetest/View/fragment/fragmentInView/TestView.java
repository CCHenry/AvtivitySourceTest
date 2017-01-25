package com.example.henryzheng.avtivitysourcetest.View.fragment.fragmentInView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.henryzheng.avtivitysourcetest.R;

/**
 * Created by henryzheng on 2017/1/25.
 */
public class TestView extends LinearLayout {
    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TestView(Context context) {
        super(context);
        initView(context);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_fragment_test, null);
        addView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT));
    }
}
