package com.example.henryzheng.avtivitysourcetest.ipc.messenager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

import com.example.henryzheng.avtivitysourcetest.R;

import utils.CCLog;

public class MessengerActivity extends AppCompatActivity {
    Messenger mMessenger;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MessengerService.MSG_FROMCLIENT:
                    CCLog.print("收到服务端信息-------" + msg.getData().get("rep"));
                    break;
            }
        }
    };
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMessenger=new Messenger(service);
            Message mMessage=Message.obtain(null,MessengerService.MSG_FROMCLIENT);
            Bundle mBundle=new Bundle();
            mBundle.putString("msg","这里是客户端，收到了嘛服务端");
            mMessage.setData(mBundle);
           mMessage.replyTo=new Messenger(mHandler);
            try {
                mMessenger.send(mMessage);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        Intent intent = new Intent(MessengerActivity.this, MessengerService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }
}
