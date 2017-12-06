package com.apkglobal.edifycoding.javatext;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.apkglobal.edifycoding.R;

public class Javatext1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javatext1);

        TextView myTextView=(TextView)findViewById(R.id.title);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"font/fontastique.ttf");
        myTextView.setTypeface(typeFace);

    }
}
