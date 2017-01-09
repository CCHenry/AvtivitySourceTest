package com.example.henryzheng.avtivitysourcetest.Web.webView;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.henryzheng.avtivitysourcetest.R;

import Base.BaseActivity;

public class WebViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webView= (WebView) findViewById(R.id.web_view);
        WebSettings webSettings = webView.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webView.loadUrl("http://blog.csdn.net/qq_35101189/article/details/54018093");
        //设置Web视图
        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("http://geek.csdn.net/news/detail/132586");
    }
}
