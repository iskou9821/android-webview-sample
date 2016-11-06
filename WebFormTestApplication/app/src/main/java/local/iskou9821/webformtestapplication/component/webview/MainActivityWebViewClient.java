package local.iskou9821.webformtestapplication.component.webview;

import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import local.iskou9821.webformtestapplication.MainActivity;


public class MainActivityWebViewClient extends WebViewClient {
    private MainActivity mainActivity;
    private static final String URL_LOGIN_CONFIRM = "/android-test/form_process.php";

    public MainActivityWebViewClient(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    private String getCookie(String url, String key) {
        String[] cookies = CookieManager.getInstance().getCookie(url).split(";");
        for (String cookie : cookies) {
            String[] keyAndValue = cookie.split("=");
            if (keyAndValue.length > 1) {
                return keyAndValue[1];
            }
        }
        return null;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        //ページ読み込み完了時に処理を実行する
        if (url.contains(URL_LOGIN_CONFIRM)) {
            //WebViewからCookieを読み取る
            String token = getCookie(url, "test_auth_token");
            System.out.println("get token from cookie:" + token);
            mainActivity.addResultText("token from cookie:" + token);

            //WebViewにJavaScriptを差し込んで実行
            // * component.webview.WebViewHtmlTokenExtractor が実行される。
            // * GET_AUTH_TOKENという識別子と、上記のクラスを結びつけている(MainActivityに該当の処理がある)。
            view.loadUrl("javascript:window.GET_AUTH_TOKEN.getToken(document.getElementById('auth-token').innerHTML);");
        }
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }
}
