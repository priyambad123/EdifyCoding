package com.apkglobal.edifycoding.pythonpages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

import com.apkglobal.edifycoding.R;


public class projectpythonActivity extends AppCompatActivity {
     WebView webview3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectpython);

        Toast.makeText(this, "Loading Please Wait", Toast.LENGTH_SHORT).show();

        webview3=(WebView)findViewById(R.id.btn_projectpython);
        webview3.loadUrl("https://www.kashipara.com/project/category/download_python-project-source-code_12");
    }
}
