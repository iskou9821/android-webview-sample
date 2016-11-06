package local.iskou9821.webformtestapplication.component.webview;

import android.os.Handler;
import android.webkit.JavascriptInterface;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import local.iskou9821.webformtestapplication.MainActivity;

public class WebViewHtmlTokenExtractor {
    private MainActivity mainActivity;

    public WebViewHtmlTokenExtractor(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @JavascriptInterface
    public void getToken(String html) {
        System.out.println("target html element: " + html);

        /*
          Documentを解析(Jsoupというライブラリを追加している)
          ライブラリの追加は、メニューの「Project Structure」→「app」→「Dependencies」から。
         */
        Document doc = Jsoup.parse(html);
        final String uid = doc.getElementById("user_name").val();
        final String token = doc.getElementById("user_token").val();

        System.out.println("target uid/token from html:" + uid + " / " + token);

        //mainActivityの表示を更新
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.addResultText("uid form html:" + uid);
                mainActivity.addResultText("token from html:" + token);
            }
        });
    }

}
