package com.example.henryzheng.avtivitysourcetest.View.scrollViewTest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.Random;

import utils.utils.ScreenUtils;

/**
 * Created by henryzheng on 2017/3/31.
 */

public class TransFormView extends LinearLayout {
    private  int scrrenWidth=0;
    static int i=0;
    int[] arr=new int[]{0xffffff00,0xff00ff55,0xff3344bb,0xff334455,0xff992211,0xff0033ff};
    public TransFormView(Context context) {
        super(context,null);
    }
    public TransFormView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }
    public TransFormView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }





    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        scrrenWidth= ScreenUtils.getScreenWidth(getContext());
        getLayoutParams().width=100;
        getLayoutParams().height=100;

        setBackgroundColor(getRandomInt());
    }
int getRandomInt(){
    int  max=6;
    int min=0;
    Random random = new Random();

    int s = random.nextInt(max)%(max-min+1) + min;
    i++;
    return arr[i>5?i=0:i++];
}


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
