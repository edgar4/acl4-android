package ke.co.edgar.alc4;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutALCActivity extends AppCompatActivity {

    private WebView alcWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

            }

            @Override
            public void onPageFinished(WebView view, String url) {

            }
        });

    }

}
