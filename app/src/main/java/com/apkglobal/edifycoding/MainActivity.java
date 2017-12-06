package com.apkglobal.edifycoding;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.apkglobal.edifycoding.authentication.LoginActivity;
import com.apkglobal.edifycoding.codepages.AndroidActivity;
import com.apkglobal.edifycoding.codepages.CActivity;
import com.apkglobal.edifycoding.codepages.CplusActivity;
import com.apkglobal.edifycoding.codepages.JavaActivity;
import com.apkglobal.edifycoding.codepages.ProjectActivity;
import com.apkglobal.edifycoding.codepages.PythonActivity;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;

import static com.apkglobal.edifycoding.R.id.item_logout;
import static com.apkglobal.edifycoding.R.menu.main;


public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {

    SliderLayout sliderLayout;
    private Toolbar toolbar;
    HashMap<String,String> Hash_file_maps ;
    Button btn_android,btn_java,btn_python,btn_c,btn_cplus,btn_project,btn_contact_us,btn_more_info,btn_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView myTextView=(TextView)findViewById(R.id.head_main);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"font/chalk.ttf");
        myTextView.setTypeface(typeFace);

        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout)findViewById(R.id.slider);

        Hash_file_maps.put("Learn Coding", "http://www.actuallywecreate.com/wp-content/uploads/2013/09/learn-to-code-banner-final-670x257.jpg");
        Hash_file_maps.put("Video Tutorials", "http://file.mockupplus.com/image/2016/11/e3773f92-d3a8-4753-8696-84ddd8fd4465.png");
        Hash_file_maps.put("Best Books Links", "https://coderseye.com/wp-content/uploads/Best-Computer-Coding-Books-for-beginners.jpg");
        Hash_file_maps.put("Learn Android Development", "https://i2.wp.com/techlog360.com/wp-content/uploads/2016/10/Learn-Android-App-Development-From-These-7-Free-Tutorial-Websites.jpg?fit=800%2C400&ssl=1");
        Hash_file_maps.put("Learn with Edify", "http://www.imbuesoft.com/ists/images/overview-banner.jpg");

        btn_android=(Button)findViewById(R.id.btn_android);
        btn_java=(Button)findViewById(R.id.btn_java);
        btn_python=(Button)findViewById(R.id.btn_python);
        btn_c=(Button)findViewById(R.id.btn_c);
        btn_cplus=(Button)findViewById(R.id.btn_cplus);
        btn_project=(Button)findViewById(R.id.btn_project);
        btn_contact_us=(Button)findViewById(R.id.btn_contact_us);
        btn_more_info=(Button)findViewById(R.id.btn_more_info);
        btn_about=(Button)findViewById(R.id.btn_about);

        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);


        btn_android.setOnClickListener(this);
        btn_java.setOnClickListener(this);
        btn_python.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_cplus.setOnClickListener(this);
        btn_project.setOnClickListener(this);
        btn_about.setOnClickListener(this);
        btn_more_info.setOnClickListener(this);
        btn_contact_us.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(main,menu);
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
            case item_logout:
                    logout();
                break;
            case R.id.item_search:



                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.mipmap.icbc_launcher);
        builder.setTitle("Exit Application");
        builder.setMessage("Do you want to exit this Application?");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create();
        builder.show();
    }

    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onClick(View view) {
        int id=view.getId();

        switch (id){
            case R.id.btn_android:
                Intent android=new Intent(MainActivity.this,AndroidActivity.class);
                startActivity(android);
                break;
            case R.id.btn_java:
                Intent java=new Intent(MainActivity.this,JavaActivity.class);
                startActivity(java);
                break;
            case R.id.btn_python:
                Intent python=new Intent(MainActivity.this,PythonActivity.class);
                startActivity(python);
                break;
            case R.id.btn_c:
                Intent c=new Intent(MainActivity.this,CActivity.class);
                startActivity(c);
                break;
            case R.id.btn_cplus:
                Intent cplus=new Intent(MainActivity.this,CplusActivity.class);
                startActivity(cplus);
                break;
            case R.id.btn_project:
                Intent project=new Intent(MainActivity.this,ProjectActivity.class);
                startActivity(project);
                break;
            case R.id.btn_contact_us:
                Intent contact_us=new Intent(MainActivity.this,contact_us.class);
                startActivity(contact_us);
                break;
            case R.id.btn_about:
                Intent about=new Intent(MainActivity.this,about.class);
                startActivity(about);
                break;
            case R.id.btn_more_info:
                Intent moreinfo=new Intent(MainActivity.this,more_info.class);
                startActivity(moreinfo);
                break;
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}