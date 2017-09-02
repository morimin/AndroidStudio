package com.astar.smin.komca;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView ;
    WebClientClass webViewClient ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = new WebView(this);
        webView.setClickable(true);
        webView.getSettings().setJavaScriptEnabled(true);

        startActivity(new Intent(MainActivity.this, Init.class)); //SplashJava클래스로 액티비티 이동
        initialize();  //시간이 걸리는 작업처리


        webView();

        webViewClient = new WebClientClass();
        webView.setWebViewClient(webViewClient);

        setContentView(webView);

    }

    private void initialize() {  //스플래시 표시하는 것과 초기화를 동시에 진행시키기 위하여 쓰레드 처리
        InitializationRunnable init = new InitializationRunnable();
        new Thread(init).start();
    }
    class InitializationRunnable implements Runnable { //초기화 작업처리
        public void run() {   //null 값 == 초기화작업처리
        }
    }


    private void webView(){
        String url = "https://m.komca.or.kr:8700/CTLJSP";

        webView.loadUrl(url);

    }


    public class WebClientClass extends WebViewClient {
        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            pd = new ProgressDialog(MainActivity.this);
            //pd.setTitle("Please wait");
            pd.setMessage("접속중 입니다.");
            pd.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pd.dismiss();
        }
    }



}
