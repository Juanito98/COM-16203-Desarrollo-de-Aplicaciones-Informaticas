package jcsiglerp.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Suggestions extends AppCompatActivity {

    WebView wvSuggestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        wvSuggestions = (WebView) findViewById(R.id.wvSuggestions);
        wvSuggestions.loadUrl("http://www.instyle.com/fashion/clothing");
        wvSuggestions.getSettings().setJavaScriptEnabled(true);
        wvSuggestions.setWebViewClient(new WebViewClient());
    }
}
