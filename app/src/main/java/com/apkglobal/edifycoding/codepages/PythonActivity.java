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
import com.apkglobal.edifycoding.pythonpages.notespythonActivity;
import com.apkglobal.edifycoding.pythonpages.overviewpythonActivity;
import com.apkglobal.edifycoding.pythonpages.projectpythonActivity;
import com.apkglobal.edifycoding.pythonpages.tutorialpythonActivity;
import com.google.firebase.auth.FirebaseAuth;

public class PythonActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_pythoncode,btn_pythonnotes,btn_tutpython,btn_projectpython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);

        btn_pythoncode=(Button)findViewById(R.id.btn_pythoncode);
        btn_pythonnotes=(Button)findViewById(R.id.btn_pythonnotes);
        btn_tutpython=(Button)findViewById(R.id.btn_tutpython);
        btn_projectpython=(Button)findViewById(R.id.btn_projectpython);

        btn_pythoncode.setOnClickListener(this);
        btn_pythonnotes.setOnClickListener(this);
        btn_tutpython.setOnClickListener(this);
        btn_projectpython.setOnClickListener(this);


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
            case R.id.btn_pythoncode:
                Intent overviewandroid=new Intent(PythonActivity.this,overviewpythonActivity.class);
                startActivity(overviewandroid);
                break;
            case R.id.btn_pythonnotes:
                Intent androidnotes=new Intent(PythonActivity.this,notespythonActivity.class);
                startActivity(androidnotes);
                break;
            case R.id.btn_tutpython:
                Intent tutandroid=new Intent(PythonActivity.this,tutorialpythonActivity.class);
                startActivity(tutandroid);
                break;
            case R.id.btn_projectpython:
                Intent projectand=new Intent(PythonActivity.this,projectpythonActivity.class);
                startActivity(projectand);
                break;
        }
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(PythonActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
