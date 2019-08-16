package avishkaar.com.universallogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WebView webView = findViewById(R.id.webView);
        WebViewClient webViewClient = new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                webView.loadUrl("javascript:HtmlViewer.showString" +
                        "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
            }
        };
        WebInterface webInterface = new WebInterface(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://cloud.avishkaar.cc/api/auth/facebook/app");
        webView.addJavascriptInterface(webInterface,"HtmlViewer");
        webView.setWebViewClient(webViewClient);


    }
}
