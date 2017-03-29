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
        if (position < -1) { // [-Infinity,-1)
//            view.setAlpha(0);
//            view.setScaleY(1);
//            view.setScaleY(1);
        } else if (position <= 0) { // [-1,0]
            //向左滑动时，position从0到-1进行，左边的view,
            //向左滑动时，position从-1到0进行，左边的view,
//            view.setAlpha(1 + position * (1 - MIN_SCALE));
//            view.setTranslationX(0);
//            view.setTranslationX(-pageWidth*page_ini_location_rate*position );

            view.setScaleX(1 + position * (1-page_ini_location_rate));
            view.setScaleY(1 + position * (1-page_ini_location_rate));
//            view.setAlpha(0);
//            CCLog.print("position<0:position=" + position);
        } else if (position >=0&&position<1) { // (0,1]
            //向左滑动时，position从1到0进行，右边的view
            //向右滑动时，position从0到1进行，右边的view
            view.setTranslationX(-pageWidth*page_ini_location_rate*position );
//            view.setAlpha(0.5F + (1 - position) * ((1 - 0.5F)));
            view.setScaleX(page_ini_location_rate + (1 - position) * (1-page_ini_location_rate));
            view.setScaleY(page_ini_location_rate + (1 - position) * (1-page_ini_location_rate));
            CCLog.print("0<position <= 1:position=" + position);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
//            view.setAlpha(0);
//            view.setScaleY(1);
//            view.setScaleY(1);
        }
    }
}
