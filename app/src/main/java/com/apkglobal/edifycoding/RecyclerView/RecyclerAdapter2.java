package com.apkglobal.edifycoding.RecyclerView;


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


public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.VideoInfoHolder> {

    //these ids are the unique id for each video
    String[] VideoID = {"tvC1WCdV1XU", "SWZfFNyUsxc", "sPv0HQ8xOaU","QwBSv4-_Lmk","yjucJUsHSqg","3Iq_uFbc4L4","L1z2dpCosXU","yEY8xlnarNo",
    "bsWWHo4KDHE","-87KQS-rZCA","fQ_CBGVfGbM","ABRP_5RYhqU","jTS7JTud1qQ","_b7odUc7lg0","NTip15BHVZc","uYciTJ7CDOY","jK83lln_T1k","KLKhsaOPnLk",
    "GGA0z_6tvOU","791XRPJYdfA","T0kEDZ-tuNw","sBO8yvyyBI0","1S__GRWtyvg","yRdPe2acogw","TNUCZpgPjrw","o78khWdmqIE","naXUIEAIt4U","66zF2rqoKI8",
    "ZwxMlIS6TLM","IAMzWp3kS_k","4agL-MQq05E","1kLw8kZuccQ","Z9Wc8EsGjJY","v2dKtxtWT5o","VnZbghMhfOY","B3iC40frU4M","pAKZp_EucVg","Fa6S8Pz924k",
    "_ja8iizm7nk","_5EEHKkvv1s","dPAbm-3iAN4","2RP4f9beidc","4P4Im0vF_mU","k55CRqm1gzk","53VYYMy-LBo","jn3lT07owCo","jCaxfmcDYjs","WCFGNdXSzus",
    "Fcdkcx4achs","PgGhEovFhd0","q4vZIF-uMzs","gq2Igdc-OSI","DHAAy4GJ684","Z_vJEKU9WTg","R_PPA9eejDw","DudHooleNVg","ndz3EHpFEZc",
    "W0aoAm6eYSk","SeleR7PDs5Q","U2QvTsMvWmM","8kjVFp-Y4GA","mFAaqmj399I","5369xtKS42s","HcONWqVyvlg","qdkabVYgV24","iGWhPwh3n-o",
    "EjJY7yA5SWw","Xb-ae2NEGRs","xpV-Dpflob8","86rBqzYIbjA","dSfjBoip4c0","nkKeA74p3RY","Djc4AScpuf4"};
    String[] Title={"Installing CodeBlocks","Understanding a Simple C++","More on Printing Text","Variables","Creating a Basic Calculator",
    "Variables Memory Concepts","Basic Arithmetic","if Statement","Functions","Creating Functions That Use Parameters","Functions That Use Multiple Parameters",
    "Introduction to Classes and Objects","Using Variables in Classes","Constructors","Placing Classes in Separate Files","if Statement.....again?",
    "if / else Statement","while Loops","Simple Program Using a Loop","Sentinel Controlled Program","Assignment and Increment Operators",
    "for Loops","Making a Stock Market Simulator!","do while Loops","switch","Logical Operators","Random Number Generator","Default Arguments / Parameters",
    "Unary Scope Resolution Operator","Function Overloading","Recursion","Arrays","Create an Array Using Loops","Using Arrays in Calculations",
    "Passing Arrays to Functions","Multidimensional Arrays","How to Print Out Multidimensional Arrays","Introduction to Pointers",
    "Pass by Reference with Pointers","sizeof","Pointers and Math","Arrow Member Selection Operator","Deconstructors","const Objects",
    "Member Initializers","Composition","Composition Part 2","friend","this","Operator Overloading","More on Operator Overloading",
    "Inheritance","protected Members","Derived Class Constructors and Destructors","Introduction to Polymorphism","virtual Functions",
    "Abstract Classes and Pure virtual Functions","function Templates","function Templates with Multiple Parameters","class Templates",
    "Template Specializations","Exceptions","More Exceptions Examples","Working with Files","Tips for File Handling","Writing Custom File Structures",
    "Reading Custom File Structures","Cool Program Working with Files","Finishing the Awesome Program","Reviewing the Final Program",
    "string Class and string Functions","string substrings, swapping, and finding","Final Video for this Series!"};
    Context ctx;

    public RecyclerAdapter2(Context context) {
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