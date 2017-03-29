package com.example.henryzheng.avtivitysourcetest.View.viewMove;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by henryzheng on 2017/3/3.
 */

public class MoveSelfView extends RelativeLayout {

    private ValueAnimator mAnimator;

    private long durationTime=1000;

    public MoveSelfView(Context context) {
        super(context,null);
    }

    public MoveSelfView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public MoveSelfView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int
            parentHeightMeasureSpec) {
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
super.onLayout(changed,l,t,r,b);
    }

    public void startLayoutUp(long duration){
        durationTime=duration;
        startLayoutMoveUp();
    }
    public void startLayoutMoveUp(){
         mAnimator = ValueAnimator.ofInt(0,-getTop()-getHeight());
        //2.为目标对象的属性变化设置监听器
        mAnimator.setDuration(durationTime);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 3.为目标对象的属性设置计算好的属性值
                int changeValue= (int) animation.getAnimatedValue();
                if (getLayoutParams() instanceof  RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
                    params.topMargin= changeValue;
                    setLayoutParams(params);
                }
                else if(getLayoutParams() instanceof LinearLayout.LayoutParams){
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
                    params.topMargin= changeValue;
                    setLayoutParams(params);
                }

//                    layout(getLeft(),changeValue,getRight(),getBottom());
//                scrollTo(0,changeValue);
//                getParent().requestLayout();

            }
        });
        mAnimator.setInterpolator(new AnticipateOvershootInterpolator());
        mAnimator.start();
    }
    public void startLayoutMoveDown(){
        if (mAnimator!=null)
                mAnimator.reverse();
    }
}
