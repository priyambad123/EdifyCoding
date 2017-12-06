package com.apkglobal.edifycoding.RecyclerView;

/**
 * Created by abhisharma on 11-08-2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.apkglobal.edifycoding.R;
import com.apkglobal.edifycoding.helper.Configure;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

/**
 * Created by ofaroque on 8/13/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VideoInfoHolder> {

    //these ids are the unique id for each video
    String[] VideoID = {"Z98hXV9GmzY", "YwDoIiNS2k4","NM-99phR56c","MWZ2rVFOQWw","myjSxtAk9XM","odqACn2Vgic","7OQJIaXNmT4","V7HPQ6DVvug",
    "HO7CsnUEJAs","cTlWwuAvRpE","0MrPs4yk9pU","oqEXYBepqus","3f0NAn5xFy4","xRXg7RaXG64","PQqEKrr8KSQ","ihHdHra7zF8","IgbGeOIPu8w",
    "DmPO6ZWF8-s","l5FrTkGoeX8","nB-relROsrY","L27EhVTLcng","mcF28h9WiGQ","FF-e6CnBwYY","JpgYAoHXuBk","yTjLqTFtjOw","GDAjPcXRZho",
    "czKLAx750N0","GQPyXkbikXw","o4WeEitmF9E","SF3Hh31clqQ","m7BWTh6xPsw","uAZn1M9v06E","L29UVUm8aro","c7kjSs2l7iM","p3RHxwA2-8A",
    "cJsqMisTaa8","x0UkbmhxT6c","E-wJJQFlQBs","_15mKw--RG0","HK515-8-Q_w","HK515-8-Q_w","UqY4DY2rHOs","age2l7Rrwtc"};




    String[] Title={"Getting Started","First Small App","Android Studio GUI","How to Install Genymotion","Basic Overview","Android Activity Lifecycle"
    ,"Adding two Numbers","Desigining UI","CheckBox Basics","RadioButton Basics","Rating Bar Basics","Alert Dialog Box","Button Click via Intent",
    "Analog Clock @ Digital Clock","Android Login Screen","Login Screen 2","Image View Example","ListView Example","SeekBar Example",
    "WebView","Android Gestures","Fragments","Fragments 2","Auto-Complete TextView","Time Picker","Time Picker Dialog","Date Picker Dialog",
            "Showing Notification","Actionbar","OverFlow Menu Items","Add Up Buttonfor Lower Activities","Implicit and Explicit intent","Intro to Services",
    "service and Thread","Creating service using intent service","Bound Service","Applying Styles","Style Inheritance","Save File in Internal Memory",
    "Creating Database and writing PHP","Login with PHP MySql","Connecting App to Online MySql DB","Insert DB in MySql DB"};
    Context ctx;

    public RecyclerAdapter(Context context) {
        this.ctx = context;
    }

    @Override
    public VideoInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new VideoInfoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VideoInfoHolder holder, final int position) {


        holder.playButton.setText( Title[position]);

        final YouTubeThumbnailLoader.OnThumbnailLoadedListener  onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.relativeLayoutOverYouTubeThumbnailView.setVisibility(View.VISIBLE);
            }
        };

        holder.youTubeThumbnailView.initialize(Configure.Apikey, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(VideoID[position]);
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
            }
        });
    }

    @Override
    public int getItemCount() {
        return VideoID.length;
    }

    public class VideoInfoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        YouTubeThumbnailView youTubeThumbnailView;
        protected TextView playButton;

        public VideoInfoHolder(View itemView) {
            super(itemView);
            playButton=(TextView)itemView.findViewById(R.id.btnYoutube_player);
            // playButton.setOnClickListener(this);
            relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.youtube_thumbnail);
            youTubeThumbnailView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) ctx, Configure.Apikey, VideoID[getLayoutPosition()]);
            ctx.startActivity(intent);
        }
    }
}