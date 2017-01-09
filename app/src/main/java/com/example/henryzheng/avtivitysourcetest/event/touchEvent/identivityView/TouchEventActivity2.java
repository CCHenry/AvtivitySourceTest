package com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.henryzheng.avtivitysourcetest.R;

public class TouchEventActivity2 extends AppCompatActivity implements View.OnTouchListener {
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event2);
        rl = (RelativeLayout) findViewById(R.id.rl);
        rl.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        float startx = 0;
        float starty = 0;
        float upoffset;
        float offset;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startx = event.getX();
                starty = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                offset = (int) (event.getX() - startx) / 3;
                // Log.e("TAST", offset + "offset");
                if (Math.abs(offset) > 10) {
                    Log.e("TAG", "Left and Right");
                }
                upoffset = event.getY() - starty;
                if (Math.abs(upoffset) > 20) {
                    Log.e("TAG", "UP and Down");
                }

                v.invalidate();

            default:
                break;
        }

        return true;
    }
}
