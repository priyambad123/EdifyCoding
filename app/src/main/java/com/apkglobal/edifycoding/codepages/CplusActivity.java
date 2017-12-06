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
import com.apkglobal.edifycoding.cpluspages.notescplusActivity;
import com.apkglobal.edifycoding.cpluspages.overviewcplusActivity;
import com.apkglobal.edifycoding.cpluspages.projectcplusActivity;
import com.apkglobal.edifycoding.cpluspages.tutorialcplusActivity;
import com.google.firebase.auth.FirebaseAuth;

public class CplusActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_cpp,btn_cppnotes,btn_tutcpp,btn_projectcpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus);

        btn_cpp=(Button)findViewById(R.id.btn_cpp);
        btn_cppnotes=(Button)findViewById(R.id.btn_cppnotes);
        btn_tutcpp=(Button)findViewById(R.id.btn_tutcpp);
        btn_projectcpp=(Button)findViewById(R.id.btn_projectcpp);

        btn_cpp.setOnClickListener(this);
        btn_cppnotes.setOnClickListener(this);
        btn_tutcpp.setOnClickListener(this);
        btn_projectcpp.setOnClickListener(this);

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
            case R.id.btn_cpp:
                Intent overviewcpp=new Intent(CplusActivity.this,overviewcplusActivity.class);
                startActivity(overviewcpp);
                break;
            case R.id.btn_cppnotes:
                Intent cppnotes=new Intent(CplusActivity.this,notescplusActivity.class);
                startActivity(cppnotes);
                break;
            case R.id.btn_tutcpp:
                Intent tutcpp=new Intent(CplusActivity.this,tutorialcplusActivity.class);
                startActivity(tutcpp);
                break;
            case R.id.btn_projectcpp:
                Intent projectcpp=new Intent(CplusActivity.this,projectcplusActivity.class);
                startActivity(projectcpp);
                break;
        }
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(CplusActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
