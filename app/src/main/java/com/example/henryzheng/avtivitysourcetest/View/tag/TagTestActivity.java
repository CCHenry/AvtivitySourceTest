package com.example.henryzheng.avtivitysourcetest.View.tag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.henryzheng.avtivitysourcetest.R;

public class TagTestActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_test);
        btn= (Button) findViewById(R.id.btn);
        btn.setTag(1);
        btn.setTag(33554431,"123");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("tag="+btn.getTag()+",tag:key=33554432,value="+btn.getTag(33554431));
            }
        });
    }
    protected void toast(String s){
        Toast.makeText(TagTestActivity.this,s,Toast.LENGTH_SHORT).show();
    }
}
