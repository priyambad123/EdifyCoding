package com.apkglobal.edifycoding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class contact_us extends AppCompatActivity implements View.OnClickListener {
    Button call_dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        call_dev=(Button)findViewById(R.id.call_dev);

        call_dev.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            Intent call=new Intent(Intent.ACTION_CALL);
            call.setData(Uri.parse("tel:9926532842"));
            startActivity(call);


    }
}
