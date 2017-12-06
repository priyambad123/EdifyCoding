package com.apkglobal.edifycoding.cpluspages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

import com.apkglobal.edifycoding.R;


public class projectcplusActivity extends AppCompatActivity {

    WebView webview5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectcplus);
        Toast.makeText(this, "Loading Please Wait", Toast.LENGTH_SHORT).show();

        webview5=(WebView)findViewById(R.id.btn_projectcpp);
        webview5.loadUrl("http://www.enggroom.com/java.aspx");
    }
}
