package com.widiaadheokpianto.library;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class fragment1 extends Fragment
{
    private WebView mWebView;
    private ProgressBar loading;

    private String URL = "https://www.dinus.ac.id";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view_frag1 = inflater.inflate(R.layout.fragment1, container, false);

        mWebView = view_frag1.findViewById(R.id.webview);
        loading = view_frag1.findViewById(R.id.progress);
        settings();
        load_website();
//
//        mWebView = view_frag1.findViewById(R.id.webview);
//
//        WebSettings webSettings = mWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        mWebView.loadUrl("https://www.google.com");

        return view_frag1;
    }

    private void settings()
    {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setEnableSmoothTransition(true);
        webSettings.setDomStorageEnabled(true);

    }

    private void load_website()
    {
        if (Build.VERSION.SDK_INT >= 19)
        {
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        }
        else
        {
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        }

        mWebView.setWebChromeClient(new WebChromeClient()
        {
            public void onProgressChanged(WebView view, int newProgress)
            {
                loading.setVisibility(View.VISIBLE);
                loading.setProgress(newProgress);
                if (newProgress == 100)
                {
                    loading.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        mWebView.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            {
                view.loadUrl(request.toString());
                return true;
            }

            public void onPageFinished(WebView view, String url)
            {
                super.onPageFinished(view, url);
                loading.setVisibility(View.GONE);
            }
        });

        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.loadUrl(URL);
    }


}
