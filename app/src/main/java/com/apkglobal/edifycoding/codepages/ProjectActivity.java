package com.apkglobal.edifycoding.codepages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.apkglobal.edifycoding.R;


public class ProjectActivity extends AppCompatActivity {
    private ProgressBar progressbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        Toast.makeText(this, "Loading Please Wait", Toast.LENGTH_SHORT).show();

        webView=(WebView)findViewById(R.id.btn_project);
        webView.loadUrl("http://1000projects.org/projects/cse-projects-with-source-code/");
    }

}
