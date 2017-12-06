package com.apkglobal.edifycoding.codepages;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.apkglobal.edifycoding.R;
import com.apkglobal.edifycoding.androidpages.notesandroidActivity;
import com.apkglobal.edifycoding.androidpages.overviewandroidActivity;
import com.apkglobal.edifycoding.androidpages.projectandroidActivity;
import com.apkglobal.edifycoding.androidpages.tutorialsandroidActivity;
import com.apkglobal.edifycoding.authentication.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class AndroidActivity extends AppCompatActivity implements View.OnClickListener {

Button btn_android,btn_androidnotes,btn_tutandroid,btn_projectand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);

        btn_android=(Button)findViewById(R.id.btn_android);
        btn_androidnotes=(Button)findViewById(R.id.btn_androidnotes);
        btn_tutandroid=(Button)findViewById(R.id.btn_tutandroid);
        btn_projectand=(Button)findViewById(R.id.btn_projectand);


        btn_android.setOnClickListener(this);
        btn_androidnotes.setOnClickListener(this);
        btn_tutandroid.setOnClickListener(this);
        btn_projectand.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.btn_android:
                Intent overviewandroid=new Intent(AndroidActivity.this,overviewandroidActivity.class);
                startActivity(overviewandroid);
                break;
            case R.id.btn_androidnotes:
                Intent androidnotes=new Intent(AndroidActivity.this,notesandroidActivity.class);
                startActivity(androidnotes);
                break;
            case R.id.btn_tutandroid:
                Intent tutandroid=new Intent(AndroidActivity.this,tutorialsandroidActivity.class);
                startActivity(tutandroid);
                break;
            case R.id.btn_projectand:
                Intent projectand=new Intent(AndroidActivity.this,projectandroidActivity.class);
                startActivity(projectand);
                break;
        }

    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(AndroidActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
