package com.example.henryzheng.avtivitysourcetest.View.identityView.viewPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.henryzheng.avtivitysourcetest.R;

public class Fragment1 extends Fragment {
    String text="";
    TextView tv;
    public Fragment1(String text){
        this.text=text;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout  frameLayout= (FrameLayout) inflater.inflate(R.layout.fragment_fragment1, container, false);
        tv= (TextView) frameLayout.findViewById(R.id.tv);
        tv.setText(text);
        return frameLayout;
    }


}
