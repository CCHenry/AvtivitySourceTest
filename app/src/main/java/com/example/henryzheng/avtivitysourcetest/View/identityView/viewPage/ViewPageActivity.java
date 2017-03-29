package com.example.henryzheng.avtivitysourcetest.View.identityView.viewPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.example.henryzheng.avtivitysourcetest.R;
import com.example.henryzheng.avtivitysourcetest.View.identityView.viewPage.PageTransformer
        .DepthPageTransformer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.utils.CCLog;

public class ViewPageActivity extends AppCompatActivity {
    ViewPager mViewPager;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        mViewPager= (ViewPager) findViewById(R.id.view_page);
        list.add(new Fragment1("1",0xff002200));
        list.add(new Fragment1("2",0xff300490));
        list.add(new Fragment1("3",0xff992432));
        list.add(new Fragment1("4",0xff039932));

        mViewPager.setAdapter(new MyFragmentPagerAdapt(getSupportFragmentManager(),list));
        Iterator<Fragment> iterator=list.iterator();
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                CCLog.print("onPageScrolled position:"+position+",positionOffset:"+positionOffset+",positionOffsetPixels:"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                CCLog.print("onPageSelected position"+position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                CCLog.print("onPageScrollStateChanged state"+state);

            }
        });
        mViewPager.setPageTransformer(true,new DepthPageTransformer());
    }
    class MyFragmentPagerAdapt extends FragmentPagerAdapter{
        List<Fragment> list;
        public MyFragmentPagerAdapt(FragmentManager fm,List<Fragment> list) {
            super(fm);
            this.list=list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//
//            return super.instantiateItem(container, position);
//        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }
}
