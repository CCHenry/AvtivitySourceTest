package com.example.henryzheng.avtivitysourcetest.View.fragment.fragmentInView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.henryzheng.avtivitysourcetest.R;

/**
 * Created by henryzheng on 2017/1/25.
 */
public class TestFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_test,null);


        return view;
    }
}
