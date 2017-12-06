package com.apkglobal.edifycoding.pythonpages;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import com.apkglobal.edifycoding.R;
import com.apkglobal.edifycoding.authentication.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class notespythonActivity extends AppCompatActivity {
TextView pythonpdfbooklink1, pythonpdfbooklink2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notespython);
        pythonpdfbooklink1 = (TextView) findViewById(R.id.pythonpdfbooklink1);
        pythonpdfbooklink2=(TextView) findViewById(R.id.pythonpdfbooklink2);
        pythonpdfbooklink1.setText("http://alvand.basu.ac.ir/~dezfoulian/files/Programming/Prentice%20Hall%20-%20The%20C%20Programming%20Language-%20Brian%20W.%20Kernighan,%20Dennis%20M.%20Ritchie,%202nd%20ed.,%20ISBN%20.pdf");
        pythonpdfbooklink2.setText("https://www.slideshare.net/faniamjad/cfakepathlet-us-c-yashwant-kanetkar");
        Linkify.addLinks(pythonpdfbooklink1, Linkify.WEB_URLS);
        Linkify.addLinks(pythonpdfbooklink2,Linkify.WEB_URLS);

        TextView myTextView=(TextView)findViewById(R.id.pythonnotestitle);
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
        Intent intent = new Intent(notespythonActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
