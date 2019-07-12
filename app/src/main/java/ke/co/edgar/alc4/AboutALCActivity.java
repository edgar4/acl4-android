package ke.co.edgar.alc4;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutALCActivity extends AppCompatActivity {

    private WebView alcWebView;
    private ProgressBar pBar;
    private String TAG = AboutALCActivity.class.getSimpleName();
    private TextView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pBar = findViewById(R.id.pBar);
        loading = findViewById(R.id.alc_loading);

        alcWebView = findViewById(R.id.acl_webview);
        alcWebView.getSettings().setJavaScriptEnabled(true);
        alcWebView.getSettings().setLoadWithOverviewMode(true);
        alcWebView.getSettings().setUseWideViewPort(true);
        alcWebView.getSettings().setSupportZoom(true);
        alcWebView.getSettings().setDisplayZoomControls(false);
        alcWebView.getSettings().setBuiltInZoomControls(true);
        alcWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        alcWebView.setScrollbarFadingEnabled(false);
        alcWebView.loadUrl(getResources().getString(R.string.alc_link));

        alcWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                alcWebView.setVisibility(View.GONE);
                pBar.setVisibility(View.VISIBLE);
                loading.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {

                alcWebView.setVisibility(View.VISIBLE);
                pBar.setVisibility(View.GONE);
                loading.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                //super.onReceivedSslError(view, handler, error);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
