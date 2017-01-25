package com.example.henryzheng.avtivitysourcetest.View.fragment.fragmentInView;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.henryzheng.avtivitysourcetest.R;

public class TestFragmentInViewOnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment_in_view_on);
        TestView view0= (TestView) findViewById(R.id.view0);

        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat(View.SCALE_X,1,
                0,1);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1,
                0,1);
        ObjectAnimator.ofPropertyValuesHolder(view0,pvhX,pvhY).setDuration(3000).start();
    }
}
