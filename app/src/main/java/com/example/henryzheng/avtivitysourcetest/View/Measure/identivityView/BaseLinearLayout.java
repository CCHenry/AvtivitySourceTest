package com.example.henryzheng.avtivitysourcetest.View.Measure.identivityView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import utils.utils.CCLog;

/**
 * Created by henryzheng on 2016/11/30.
 */
public class BaseLinearLayout extends LinearLayout {
    public BaseLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        CCLog.print(this.getClass().getName() + " widthMeasureSpec:" + widthMeasureSpec + ",heightMeasureSpec:" + heightMeasureSpec);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        CCLog.print(this.getClass().getName() + "changed:" + changed + " l:" + l + ",t:" + t + ",r:" + r + ",b:" + b);
        super.onLayout(changed, l, t, r, b);
    }
}
