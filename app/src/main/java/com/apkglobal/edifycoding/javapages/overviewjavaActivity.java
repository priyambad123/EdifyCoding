package com.apkglobal.edifycoding.javapages;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apkglobal.edifycoding.R;
import com.apkglobal.edifycoding.authentication.LoginActivity;
import com.apkglobal.edifycoding.javatext.Javatext1Activity;
import com.apkglobal.edifycoding.javatext.Javatext2Activity;
import com.apkglobal.edifycoding.javatext.Javatext3Activity;
import com.google.firebase.auth.FirebaseAuth;



public class overviewjavaActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_javaoverview1,btn_javaoverview2,btn_javaoverview4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overviewjava);
        btn_javaoverview1=(Button)findViewById(R.id.btn_javaoverview1);
        btn_javaoverview2=(Button)findViewById(R.id.btn_javaoverview2);
        btn_javaoverview4=(Button)findViewById(R.id.btn_javaoverview4);

        btn_javaoverview1.setOnClickListener(this);
        btn_javaoverview2.setOnClickListener(this);
        btn_javaoverview4.setOnClickListener(this);


        TextView myTextView=(TextView)findViewById(R.id.javaoverviewtitle);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"font/chalk.ttf");
        myTextView.setTypeface(typeFace);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_share:
                Intent share=new Intent(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,"Only App that has tutorial for five Languages download for further Info "+"https://play.google.com/store/apps/details?id=com.apkglobal.edifycoding");
                share.setType("text/plain");
                startActivity(Intent.createChooser(share,"Share App via:"));
                break;
            case R.id.item_rateus:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.apkglobal.edifycoding")));
                break;
            case R.id.item_logout:
                logout();
                break;
            case R.id.item_search:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(overviewjavaActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.btn_javaoverview1:
                Intent jov1=new Intent(overviewjavaActivity.this, Javatext1Activity.class);
                startActivity(jov1);
                break;
            case R.id.btn_javaoverview2:
                Intent jov2=new Intent(overviewjavaActivity.this, Javatext2Activity.class);
                startActivity(jov2);
                break;
            case R.id.btn_javaoverview4:
                Intent jov4=new Intent(overviewjavaActivity.this, Javatext3Activity.class);
                startActivity(jov4);
                break;


        }
    }
}
