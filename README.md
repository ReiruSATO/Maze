# 3DMaze
Javaのswingを用いた擬似的な3D迷路ゲーム
## 主要ファイルの簡単な説明
- [3D迷路.pdf](3D迷路.pdf)  
    授業内の発表で使ったスライド

- [Top.java](Top.java)  
    ゲームのトップ画面。最初にこのファイルを実行することでゲームを起動できる。
- [Player.java](Player/Player.java)  
    プレイヤーの挙動の制御。向いている方向と押されたキーから次の行動を決定。
- [MazeView.java](View/MazeView.java)  
    プレイ画面の制御を行う。プレイヤーの座標から前方周辺のマップデータから描画データを決定。
- [End.java](End/End.java)  
    ゲームクリア時に表示されるウィンドウ。