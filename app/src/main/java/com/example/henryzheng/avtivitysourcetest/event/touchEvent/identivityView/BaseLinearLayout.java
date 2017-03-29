package com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import utils.utils.CCLog;

/**
 * onInterceptTouchEvent >>false>>  dispatchTouchEvent  >>true>>  onTouchEvent >>true>> (super)onTouchEvent
 * onInterceptTouchEvent >>false>>  dispatchTouchEvent  >>false>>  （childLayout）onInterceptTouchEvent  >>false>>  dispatchTouchEvent  >>false>>
 * Created by henryzheng on 2016/11/24.
 */
public class BaseLinearLayout extends LinearLayout {
    String className = "";
    public BaseLinearLayout(Context context) {
        super(context,null);
    }

    public BaseLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String getClassName() {
        String[] classNames = this.getClass().getName().split("\\.");
        className = classNames[classNames.length-1];
        return ">>> "+className;
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        CCLog.print(getClassName() + ":onInterceptTouchEvent  ");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        CCLog.print(getClassName() + ":dispatchTouchEvent  ");
        return super.dispatchTouchEvent(event);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        CCLog.print(getClassName() + ":onTouchEvent  ");
        return super.onTouchEvent(event);
    }

}
