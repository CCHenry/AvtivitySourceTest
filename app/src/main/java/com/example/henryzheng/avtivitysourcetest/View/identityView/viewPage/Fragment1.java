package com.example.henryzheng.avtivitysourcetest.View.identityView.viewPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.henryzheng.avtivitysourcetest.R;

public class Fragment1 extends Fragment {
    String text="";
    TextView tv;
    int color=0x000001;
    public Fragment1(String text,int color){
        this.text=text;
        this.color=color;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout relativeLayout= (RelativeLayout) inflater.inflate(R.layout.fragment_fragment1, container, false);
        tv= (TextView) relativeLayout.findViewById(R.id.tv);
        tv.setText(text);
        relativeLayout.setBackgroundColor(color);
        return relativeLayout;
    }


}
