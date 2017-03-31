package com.example.henryzheng.avtivitysourcetest.View.scrollViewTest;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import utils.utils.CCLog;

/**
 * Created by henryzheng on 2017/3/31.
 */

public class TestScrollView extends HorizontalScrollView {
    private int scrrenWidth;
    private ViewGroup viewGroup;
    private int actionUp = 0;
    private int actionFlingNoTouch = 1;

    private int beforeX;

    public TestScrollView(Context context) {
        super(context, null);
    }

    public TestScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public TestScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        scrrenWidth = getWidth();
        viewGroup = (ViewGroup) getChildAt(0);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.width = (int) (getWidth() * 0.3f);
            params.height = (int) (getWidth() * 0.3f);

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            if (view.getVisibility() == View.VISIBLE) {
                int[] location = new int[2];
                view.getLocationOnScreen(location);
                float x = location[0] + view.getWidth() / 2;
                if (view.getTranslationX() <= scrrenWidth && x >= 0) {
                    float value = 1 - Math.abs((scrrenWidth / 2 - x) / scrrenWidth / 2);
//                view.setScaleX(1+value*3);
//                view.setScaleY(1+value*3);
                    view.setScaleX(value);
                    view.setScaleY(value);
                    CCLog.print("view:" + i + ",x:" + x + ",scrrenWidth:" + scrrenWidth + "," +
                            "value=" + value);
                }
            }
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == actionUp)
            {//松手的时候，记录beforeX的值，调自身的handler，传递消息的what的值为actionFlingNoTouch
                beforeX = getScrollX();
                Message msg2 = handler.obtainMessage();
                msg2.what = actionFlingNoTouch;
                handler.sendMessageDelayed(msg2, 1000);
            } else if (msg.what == actionFlingNoTouch) {//进入滚动，没有触摸的情况
                if (beforeX == getScrollX()) {//如果beforeX==getScrollX()，即无滚动
                    test();
                    return;
                } else {//否则，还在滚动的过程中，更新此时的beforeX的值，再发送一次
                    beforeX = getScrollX();
                    Message msg2 = handler.obtainMessage();
                    msg2.what = actionFlingNoTouch;
                    handler.sendMessageDelayed(msg2, 500);
                }
            }
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                Message msg = handler.obtainMessage();
                msg.what = actionUp;
                handler.sendMessageDelayed(msg, 0);
                break;
//            case  MotionEvent.ACTION_UP:
//
//                View centerView = null;
//                for (int i=0;i<viewGroup.getChildCount();i++){
//                    if (i==0){
//                        centerView=viewGroup.getChildAt(i);
//                    }else{
//                        View viewI=viewGroup.getChildAt(i);
//                        int viewIX= (int) (viewI.getX()+ viewI.getWidth()/2);
//                        int centerViewX=(int) (centerView.getX()+ centerView.getWidth()/2);
//                        if (Math.abs(viewIX-getWidth()/2)<Math.abs(centerViewX-getWidth()/2)){
//                            centerView=viewI;
//                        }
//                    }
//                    }
//                CCLog.print("centerView x="+centerView.getX()+centerView.getWidth()
// /2+"getWidth:"+getWidth());
//                break;

        }
        return super.onTouchEvent(ev);
    }

    private void test() {
        View centerView = null;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (i == 0) {
                centerView = viewGroup.getChildAt(i);
            } else {
                View viewI = viewGroup.getChildAt(i);
                int[] location1 = new int[2];
                viewI.getLocationOnScreen(location1);
                int[] location2 = new int[2];
                centerView.getLocationOnScreen(location2);

                int viewIX = (int) (location1[0] + viewI.getWidth() / 2);
                int centerViewX = (int) (location2[0]  + centerView.getWidth() / 2);
                if (Math.abs(viewIX - getWidth() / 2) < Math.abs(centerViewX - getWidth() / 2)) {
                    centerView = viewI;
                }
            }
        }
        int[] location3 = new int[2];
        centerView.getLocationOnScreen(location3);
        int distanceToMiddler=getWidth()/2-(location3[0]+ centerView.getWidth() / 2);
        smoothScrollBy(-distanceToMiddler,getScrollY());
        CCLog.print("distanceToMiddler=" + distanceToMiddler + ",getWidth:" + getWidth());
    }

}
