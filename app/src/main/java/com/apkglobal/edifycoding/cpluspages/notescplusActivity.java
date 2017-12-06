package com.apkglobal.edifycoding.cpluspages;

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

public class notescplusActivity extends AppCompatActivity {
    TextView cpluspdfbooklink1,cpluspdfbooklink2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notescplus);
        cpluspdfbooklink1 = (TextView) findViewById(R.id.cpluspdfbooklink1);
        cpluspdfbooklink2=(TextView) findViewById(R.id.cpluspdfbooklink2);
        cpluspdfbooklink1.setText("http://www.stroustrup.com/4th.html");
        cpluspdfbooklink2.setText("http://irpp.org/wp-content/uploads/sites/2/2014/04/Andrew-Koening-and-Barbara-E.-Moo-Accelerated-C++.pdf");
        Linkify.addLinks(cpluspdfbooklink1, Linkify.WEB_URLS);
        Linkify.addLinks(cpluspdfbooklink2,Linkify.WEB_URLS);

        TextView myTextView=(TextView)findViewById(R.id.cplusnotestitle);
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
        Intent intent = new Intent(notescplusActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
