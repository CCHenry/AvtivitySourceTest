package com.example.henryzheng.avtivitysourcetest.View.identityView.viewPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.henryzheng.avtivitysourcetest.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.CCLog;

public class ViewPageActivity extends AppCompatActivity {
    ViewPager mViewPager;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        mViewPager= (ViewPager) findViewById(R.id.view_page);
        list.add(new Fragment1("1"));
        list.add(new Fragment1("2"));
        list.add(new Fragment1("3"));
        list.add(new Fragment1("4"));

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
    }
    class MyFragmentPagerAdapt extends FragmentPagerAdapter{

        public MyFragmentPagerAdapt(FragmentManager fm,List<Fragment> list) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
