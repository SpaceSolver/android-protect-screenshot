# スクリーンショット操作を防止する

# APIの使い方

* Activity毎に調整ができるもので動的に変更可能。
   * 子Fragmentを持つようなものはそれら全域で設定が反映される
* 許可: flag(第一引数)のmask(第二引数)をクリアする
   * activity.getWindow.setFlags(WindowManager.LayoutParams.FLAG_SECURE, 0);
* 非許可: flag(第一引数)にmask(第二引数)をsetする
   * activity.getWindow.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
* 参考:
   * https://stackoverflow.com/questions/28606689/how-to-prevent-screen-capture-in-android/31406316

# Fragment毎に許可/非許可を変えたい

* 現在の本アプリはその状態になっている
* つまるところ「各Fragmentの状態ハンドラで↑の処理を呼ぶ」ことになる
* 参考:
   * https://stackoverflow.com/questions/32573371/how-to-disable-screen-capture-in-android-fragment
* 対象コード抜粋
   > @Override <br>
   > public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { <br>
   >     // Inflate the layout for this fragment <br>
   >     // to protect screen shot, set FLAG_SECURE to "mask" parameter. <br>
   >     getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE); <br>
   >     return inflater.inflate(R.layout.fragment_protected, container, false); <br>
   > } <br>
* ちなみにFactoryメソッド内での設定が必要かと思ったのでテンプレートのFragment実装を自前の物に置き換えはしたが、結局不要だった

# 補足

* ぱっとググると出てくる議論だが「**root端末や動画キャプチャまでは防げない**」様である
* また「**別端末でカメラで撮った**」とかまで考慮すると、「防げない」と思っておくべきである
* ⇒ 「困らないものだけ出す」「許容する」といった判断が必要になるものと思われる
