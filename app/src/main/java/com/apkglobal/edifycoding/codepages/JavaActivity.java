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
import com.apkglobal.edifycoding.javapages.notesjavaActivity;
import com.apkglobal.edifycoding.javapages.overviewjavaActivity;
import com.apkglobal.edifycoding.javapages.projectjavaActivity;
import com.apkglobal.edifycoding.javapages.tutorialjavaActivity;
import com.google.firebase.auth.FirebaseAuth;

public class JavaActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_javacode,btn_javanotes,btn_tutjava,btn_projectjava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        btn_javacode=(Button)findViewById(R.id.btn_javacode);
        btn_javanotes=(Button)findViewById(R.id.btn_javanotes);
        btn_tutjava=(Button)findViewById(R.id.btn_tutjava);
        btn_projectjava=(Button)findViewById(R.id.btn_projectjava);


        btn_javacode.setOnClickListener(this);
        btn_javanotes.setOnClickListener(this);
        btn_tutjava.setOnClickListener(this);
        btn_projectjava.setOnClickListener(this);


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
            case R.id.btn_javacode:
                Intent overviewjava=new Intent(JavaActivity.this,overviewjavaActivity.class);
                startActivity(overviewjava);
                break;
            case R.id.btn_javanotes:
                Intent javanotes=new Intent(JavaActivity.this,notesjavaActivity.class);
                startActivity(javanotes);
                break;
            case R.id.btn_tutjava:
                Intent tutjava=new Intent(JavaActivity.this,tutorialjavaActivity.class);
                startActivity(tutjava);
                break;
            case R.id.btn_projectjava:
                Intent projectjava=new Intent(JavaActivity.this,projectjavaActivity.class);
                startActivity(projectjava);
                break;
        }
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(JavaActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
