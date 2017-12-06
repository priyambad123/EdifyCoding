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
import com.apkglobal.edifycoding.authentication.LoginActivity;
import com.apkglobal.edifycoding.cpages.notescActivity;
import com.apkglobal.edifycoding.cpages.overviewcActivity;
import com.apkglobal.edifycoding.cpages.projectcActivity;
import com.apkglobal.edifycoding.cpages.tutorialcActivity;
import com.google.firebase.auth.FirebaseAuth;

public class CActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_c, btn_cnotes, btn_tutc, btn_projectc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        btn_c = (Button) findViewById(R.id.btn_c);
        btn_cnotes = (Button) findViewById(R.id.btn_cnotes);
        btn_tutc = (Button) findViewById(R.id.btn_tutc);
        btn_projectc = (Button) findViewById(R.id.btn_projectc);


        btn_c.setOnClickListener(this);
        btn_cnotes.setOnClickListener(this);
        btn_tutc.setOnClickListener(this);
        btn_projectc.setOnClickListener(this);
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
        int id = view.getId();
        switch (id) {
            case R.id.btn_c:
                Intent overviewc = new Intent(CActivity.this, overviewcActivity.class);
                startActivity(overviewc);
                break;
            case R.id.btn_cnotes:
                Intent cnotes = new Intent(CActivity.this, notescActivity.class);
                startActivity(cnotes);
                break;
            case R.id.btn_tutc:
                Intent tutc = new Intent(CActivity.this, tutorialcActivity.class);
                startActivity(tutc);
                break;
            case R.id.btn_projectc:
                Intent projectc = new Intent(CActivity.this, projectcActivity.class);
                startActivity(projectc);
                break;
        }
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(CActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
