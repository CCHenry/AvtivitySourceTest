// IGameManager.aidl
package com.example.henryzheng.avtivitysourcetest.ipc.aidl;
import com.example.henryzheng.avtivitysourcetest.ipc.aidl.Game;
// Declare any non-default types here with import statements

interface IGameManager {
  List<Game>getGameList();
  void addGame(in Game game);
}
