package local.iskou9821.webformtestapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Connection;

import local.iskou9821.webformtestapplication.component.webview.MainActivityWebViewClient;
import local.iskou9821.webformtestapplication.component.webview.WebViewHtmlTokenExtractor;

public class MainActivity extends AppCompatActivity {
    private WebView webview;
    private EditText userInput;
    private EditText pwdInput;
    private Button sendButton;
    private TextView resultText;

    private static final String FORM_URL = "http://crmtest.hrog.net/android-test/form.php";
    private static final String AUTH_URL = "http://crmtest.hrog.net/android-test/form_process.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView)this.findViewById(R.id.main_web_view);
        userInput = (EditText)this.findViewById(R.id.input_name);
        pwdInput = (EditText)this.findViewById(R.id.input_pwd);
        sendButton = (Button)this.findViewById(R.id.send_btn);
        resultText = (TextView)this.findViewById(R.id.result_text);

        //WebViewにロードされたhtmlをJavaのコードから読み取るための準備
        webview.getSettings().setJavaScriptEnabled(true); //JavaScriptを有効にする
        webview.addJavascriptInterface(new WebViewHtmlTokenExtractor(this), "GET_AUTH_TOKEN");

        //WebViewにコンテンツがロードされた時にイベントを起こすための準備
        webview.setWebViewClient(new MainActivityWebViewClient(this));

        webview.loadUrl(FORM_URL);
        resultText.setText("Result");
    }

    public void onClickSendButton(View view) {
        String uid = userInput.getText().toString();
        String pwd = pwdInput.getText().toString();

        //パラメータを指定してWebViewに対してPOSTでURLを開くように指示する
        String params = "user_id=" + uid + "&password=" + pwd;
        webview.postUrl(AUTH_URL, Base64.encode(params.getBytes(), Base64.DEFAULT));
    }

    public void addResultText(String text) {
        String str = resultText.getText().toString();
        resultText.setText(str + "\n" + text);
    }
}
