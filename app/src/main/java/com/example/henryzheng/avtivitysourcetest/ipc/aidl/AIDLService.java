package com.example.henryzheng.avtivitysourcetest.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import utils.utils.CCLog;

public class AIDLService extends Service{
    private CopyOnWriteArrayList<Game> mGameList=new CopyOnWriteArrayList<Game>();
    private Binder mBinder= new IGameManager.Stub() {
        @Override
        public List<Game> getGameList() throws RemoteException {
            CCLog.print("获取GameLis");
            return mGameList;
        }

        @Override
        public void addGame(Game game) throws RemoteException {
            CCLog.print("增加game name="+game.gameName);
            mGameList.add(game);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mGameList.add(new Game("九阴真经ol", "最好玩的武侠网游"));
        mGameList.add(new Game("大航海时代ol","最好玩的航海网游"));

    }
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}