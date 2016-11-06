# 概要
AndroidのWebViewから、セッションなどの情報をネイティブコード側に読み取るサンプル

## 構成
 * for-server: WebViewで表示するコンテンツのサンプル(PHP)
 * WebFormTestApplication: WebViewを表示するAndoridアプリケーションのサンプル
 
## 解説
本プログラムは、以下の3つの動作に関するサンプルとなります。

 1. WebViewからcookieを読み取る
 1. WebViewに表示したhtmlの要素を読み取る
 1. WebViewにPOSTでURLをロードさせる

MainActivity.onCreateにて、WebViewの読み込みが完了した時に独自の処理を実行するように設定しています。

WebViewにコンテンツがロードされると、component.webview.MainActivityWebViewClient.onPageFinishedが呼ばれます。

その中に、WebViewからcookieを読み込む処理、読み込んだhtmlをStringとして取り出す処理が書かれています。

WebViewからhtmlをStringとして取り出した後の処理については、component.webview.WebViewHtmlTokenExtractorに書かれています。

component.webview.WebViewHtmlTokenExtractorをGET_AUTH_TOKENという名前でJSから呼び出せるようにする処理については、MainActivity.onCreateに書かれています。

## 参考
http://qiita.com/datsnet/items/a6881d685e5161005a94

http://qiita.com/karur4n/items/5b439850caa4ae5b05d9

http://stackoverflow.com/questions/2376471/how-do-i-get-the-web-page-contents-from-a-webview

http://qiita.com/datsnet/items/8cb23aa57bab64d38283

http://qiita.com/opengl-8080/items/d4864bbc335d1e99a2d7

https://jsoup.org/apidocs/org/jsoup/nodes/Element.html

http://stackoverflow.com/questions/25610727/adding-external-library-in-android-studio

http://stackoverflow.com/questions/7586564/how-to-send-post-data-with-code-in-an-android-webview

https://developer.android.com/reference/android/util/Base64.html

http://qiita.com/mmusasabi/items/eed1d9d949f9deae9d36

http://cuuma.publog.jp/archives/30332977.html