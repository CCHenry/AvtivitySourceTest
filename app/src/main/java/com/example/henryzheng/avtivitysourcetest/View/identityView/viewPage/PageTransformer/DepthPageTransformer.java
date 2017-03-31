package com.example.henryzheng.avtivitysourcetest.View.identityView.viewPage.PageTransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

import utils.utils.CCLog;

/**
 * Created by henryzheng on 2016/12/23.
 */
public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float page_ini_location_rate = 0.5f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        if (position < -1) {

        } else if (position>=-1&&position <= 0) { // [-1,0]  控制左边view
            //手指向左滑动时，position从0到-1进行，左边的view,
            //手指向右滑动时，position从-1到0进行，左边的view,
            view.setScaleX(0.5f);
            view.setScaleY(0.5f);

            view.setTranslationX(-pageWidth*0.5f);
            CCLog.print("-1<=position<0:position=" + position);
        } else if (position >=0&&position<1) { // (0,1]   控制右边view
            //手指向左滑动时，position从1到0进行，右边的view
            //手指向右滑动时，position从0到1进行，右边的view
            view.setScaleX(0.5f);
            view.setScaleY(0.5f);

            view.setTranslationX(-pageWidth*0.5f);
            CCLog.print("0<position <= 1:position=" + position);
        } else {

        }
    }
}
