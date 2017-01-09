package com.example.henryzheng.avtivitysourcetest.event.touchEvent;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.henryzheng.avtivitysourcetest.R;
import com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView.BaseLinearLayout;
import com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView.Lin1;
import com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView.Lin2;
import com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView.Lin3;

import utils.CCLog;

public class TouchEventActivity1 extends Activity {
    BaseLinearLayout lin1;
    BaseLinearLayout lin2;
    BaseLinearLayout lin3;
    private String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
        lin1 = (Lin1) findViewById(R.id.lin1);
        lin2 = (Lin2) findViewById(R.id.lin2);
        lin3 = (Lin3) findViewById(R.id.lin3);
//        lin3.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                CCLog.print(getClassName() + ":OnTouchListener  ");
//                return true;
//            }
//        });
//        lin1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
//        lin2.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
//    }
    }

    public String getClassName() {
        String[] classNames = this.getClass().getName().split("\\.");
        className = classNames[classNames.length - 1];
        return ">>> " + className;
    }
}
