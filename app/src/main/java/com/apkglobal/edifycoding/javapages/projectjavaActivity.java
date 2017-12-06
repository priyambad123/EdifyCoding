package com.apkglobal.edifycoding.javapages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

import com.apkglobal.edifycoding.R;


public class projectjavaActivity extends AppCompatActivity {
    WebView webview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectjava);
        Toast.makeText(this, "Loading Please Wait", Toast.LENGTH_SHORT).show();

        webview1=(WebView)findViewById(R.id.btn_projectjava);
        webview1.loadUrl("http://www.enggroom.com/java.aspx");


    }
}
