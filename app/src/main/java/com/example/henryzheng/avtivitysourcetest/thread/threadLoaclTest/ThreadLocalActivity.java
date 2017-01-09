package com.example.henryzheng.avtivitysourcetest.thread.threadLoaclTest;

import android.os.Bundle;
import android.widget.ListView;

import com.example.henryzheng.avtivitysourcetest.R;
import com.example.henryzheng.avtivitysourcetest.thread.threadLoaclTest.adapt.MyBaseAdapt;
import com.example.henryzheng.avtivitysourcetest.thread.threadLoaclTest.model.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Base.BaseActivity;

public class ThreadLocalActivity extends BaseActivity {
    private ListView lv;
    List<Model> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_local);
        lv = (ListView) findViewById(R.id.lv);
        for (int i = 0; i < 100; i++) {
            Model model = new Model();
            model.setData(i);
            datas.add(model);
        }
        MyBaseAdapt adapt=new MyBaseAdapt( this,datas);
        lv.setAdapter(adapt);
        ThreadLocal<HashMap> threadLocal=new ThreadLocal<HashMap>(){
            @Override
            protected HashMap initialValue() {
                return super.initialValue();
            }
        };
    }
}
