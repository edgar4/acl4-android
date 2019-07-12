package ke.co.edgar.alc4;

import android.os.Bundle;
import android.webkit.WebView;

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

    }

}
