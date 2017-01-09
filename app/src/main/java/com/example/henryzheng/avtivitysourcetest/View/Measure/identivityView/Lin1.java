package com.example.henryzheng.avtivitysourcetest.View.Measure.identivityView;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by henryzheng on 2016/11/30.
 */
public class Lin1 extends BaseLinearLayout {
    public Lin1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure( MeasureSpec.EXACTLY,  MeasureSpec.EXACTLY);
    }
}
