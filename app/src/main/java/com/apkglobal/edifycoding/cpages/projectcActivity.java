package com.apkglobal.edifycoding.cpages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

import com.apkglobal.edifycoding.R;


public class projectcActivity extends AppCompatActivity {

    WebView webview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectc);
        Toast.makeText(this, "Loading Please Wait", Toast.LENGTH_SHORT).show();

        webview4=(WebView)findViewById(R.id.btn_projectc);
        webview4.loadUrl("https://inettechie.wordpress.com/2012/04/16/projects-in-c-free-download-source-code-c-projects-topics-for-students/");
    }

}
