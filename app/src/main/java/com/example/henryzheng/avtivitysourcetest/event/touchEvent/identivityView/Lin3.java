package com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import utils.utils.CCLog;

/**
 * Created by henryzheng on 2016/11/24.
 */
public class Lin3 extends BaseLinearLayout {
    public Lin3(Context context) {
        super(context, null);

    }

    public Lin3(Context context, AttributeSet attrs) {
        super(context, attrs, 0);

    }

    public Lin3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        CCLog.print(getClassName() + ":dispatchTouchEvent  ");
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        CCLog.print(getClassName() + ":onInterceptTouchEvent  ");
        return false;
    }
}
