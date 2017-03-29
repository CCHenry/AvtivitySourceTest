package com.example.henryzheng.avtivitysourcetest.View.viewMove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.henryzheng.avtivitysourcetest.R;

public class TouchMoveSelfViewActivity extends AppCompatActivity {
    MoveSelfView moveSelfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_move_self_view);
    moveSelfView= (MoveSelfView) findViewById(R.id.move_set_view);
    }

    public void setLayoutMoveUp(View v){
        moveSelfView.startLayoutMoveUp();
    }
    public void setLayoutMoveDown(View v){
        moveSelfView.startLayoutMoveDown();
    }
}
