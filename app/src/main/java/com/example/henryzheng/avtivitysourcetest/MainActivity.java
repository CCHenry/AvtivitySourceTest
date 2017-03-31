package com.example.henryzheng.avtivitysourcetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.henryzheng.avtivitysourcetest.View.Measure.MeasureActivity;
import com.example.henryzheng.avtivitysourcetest.View.SurfaceViewTest.SurfaceViewTestActivity;
import com.example.henryzheng.avtivitysourcetest.View.explosion.explosionfield.ExploseViewActivity;
import com.example.henryzheng.avtivitysourcetest.View.fragment.fragmentInView
        .TestFragmentInViewOnActivity;
import com.example.henryzheng.avtivitysourcetest.View.identityView.viewPage.ViewPageActivity;
import com.example.henryzheng.avtivitysourcetest.View.scrollViewTest.ScrollViewActivity;
import com.example.henryzheng.avtivitysourcetest.View.tag.TagTestActivity;
import com.example.henryzheng.avtivitysourcetest.View.viewMove.DragToMoveViewActivity;
import com.example.henryzheng.avtivitysourcetest.View.viewMove.TouchMoveSelfViewActivity;
import com.example.henryzheng.avtivitysourcetest.Web.webView.WebViewActivity;
import com.example.henryzheng.avtivitysourcetest.camera.CustomCameraActivity;
import com.example.henryzheng.avtivitysourcetest.event.touchEvent.TouchEventActivity1;
import com.example.henryzheng.avtivitysourcetest.event.touchEvent.identivityView
        .TouchEventActivity2;
import com.example.henryzheng.avtivitysourcetest.hybrid.HybridActivity;
import com.example.henryzheng.avtivitysourcetest.ipc.aidl.AidlActivity;
import com.example.henryzheng.avtivitysourcetest.ipc.applicationHasRepeat.ServiceTestActivity;
import com.example.henryzheng.avtivitysourcetest.ipc.messenager.MessengerActivity;
import com.example.henryzheng.avtivitysourcetest.ipc.socket.SocketActivity;
import com.example.henryzheng.avtivitysourcetest.loadManager.LoadManagerActivity;
import com.example.henryzheng.avtivitysourcetest.View.percent.PercentActivity;
import com.example.henryzheng.avtivitysourcetest.thread.threadLoaclTest.ThreadLocalActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    ListView mListView;
    List<Map<String, Object>> list;
    public static int height = 0;
    public static int width = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<Map<String, Object>>();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line);
        addItem(list, "触摸事件传递", TouchEventActivity1.class);
        addItem(list, "触摸事件滑动判断", TouchEventActivity2.class);
        addItem(list, "UI绘制测量", MeasureActivity.class);
        addItem(list, "viewPager", ViewPageActivity.class);
        addItem(list, "scrollview", ScrollViewActivity.class);

        addItem(list, "threadLocal", ThreadLocalActivity.class);
        addItem(list, "webview", WebViewActivity.class);
        addItem(list, "surfaceView", SurfaceViewTestActivity.class);
        addItem(list, "testFragmentInView", TestFragmentInViewOnActivity.class);
        addItem(list, " ExploseView",ExploseViewActivity.class);
        addItem(list, "  测试有几个进程，applicaiton会调用几次",ServiceTestActivity.class);
        addItem(list, " 测试进程间通讯",MessengerActivity.class);
        addItem(list, " loadManager",LoadManagerActivity.class);
        addItem(list, " socket",SocketActivity.class);
        addItem(list, " TagTestActivity",TagTestActivity.class);
        addItem(list, " TestMoveView",DragToMoveViewActivity.class);
        addItem(list, " TestMoveSelfView",TouchMoveSelfViewActivity.class);
        addItem(list, " JavascriptInterfaceToConnectActivity",HybridActivity.class);
        addItem(list, " aidl",AidlActivity.class);
        addItem(list, " camera",CustomCameraActivity.class);
        addItem(list, " percent",PercentActivity.class);

        for (int i = 0; i < list.size(); i++) {
            adapter.add(list.get(i).get("name"));
        }
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
        setDM();
    }

    /**
     * 增加键值对到list中
     *
     * @param list
     * @param name
     * @param activity
     */

    private void addItem(List<Map<String, Object>> list, String name,
                         Class<?> activity) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("activity", activity);
        list.add(map);
    }

    /**
     * 从list获取键值对
     *
     * @param list
     * @param index
     * @return
     */
    private Map<String, Object> getItem(List<Map<String, Object>> list,
                                        int index) {
        // TODO Auto-generated method stub
        return list.get(index);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        startActivity(new Intent(this, (Class<?>) getItem(list, position).get(
                "activity")));
    }

    private void setDM() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
    }
}
