package com.apkglobal.edifycoding.javapages;

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

public class notesjavaActivity extends AppCompatActivity {
TextView javapdfbooklink1,javapdfbooklink2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notesjava);
        javapdfbooklink1 = (TextView) findViewById(R.id.javapdfbooklink1);
        javapdfbooklink2=(TextView) findViewById(R.id.javapdfbooklink2);
        javapdfbooklink1.setText("https://zimslifeintcs.files.wordpress.com/2011/12/head-first-java-2nd-edition.pdf");
        javapdfbooklink2.setText("https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwjh-bXt8_fUAhWMr48KHV8MCRUQFgjTATAA&url=http%3A%2F%2Fiiti.ac.in%2Fpeople%2F~tanimad%2FJavaTheCompleteReference.pdf&usg=AFQjCNFxlO24MSphZbZrglmo7i85eoIt0Q");
        Linkify.addLinks(javapdfbooklink1, Linkify.WEB_URLS);
        Linkify.addLinks(javapdfbooklink2,Linkify.WEB_URLS);

        TextView myTextView=(TextView)findViewById(R.id.javanotestitle);
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
        Intent intent = new Intent(notesjavaActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
