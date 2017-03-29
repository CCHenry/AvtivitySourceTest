package com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import utils.utils.CCLog;

/**
 * Created by henryzheng on 2016/11/24.
 */
public class Lin2 extends BaseLinearLayout {
    public Lin2(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        CCLog.print(getClassName() + ":dispatchTouchEvent  ");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        CCLog.print(getClassName() + ":onInterceptTouchEvent  ");
        return super.onInterceptTouchEvent(ev);
    }

    public Lin2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
