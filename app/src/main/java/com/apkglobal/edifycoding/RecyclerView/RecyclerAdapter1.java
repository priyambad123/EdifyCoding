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
public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.VideoInfoHolder> {

    //these ids are the unique id for each video
    String[] VideoID = {"2NWeucMKrLI", "3DeLiClDd04", "iWx3yyFMWQA","oSpmApiUsHw","oX2FpFYXE38","To7WA4ijQQ0","k1ur8rX-DQQ","LEHaSSYreeo",
    "7F-Q2oVBYKk","1EeetMPACMI","hSHFjPvqFjw","T3sj5iTK_0M","rubhV7Bu34E","cgkGwRonMU4","_oqmPcqWHlE","ohVRskLlHqM","PXwWoL0IG5A",
    "FtZ1YgSFqs0","KgVzRmUPsdo","DZ0ZXipUx-A","PO3BibcbkK8","brC8O7AeCFA","pze0PKwdfl0","nNSn1uVNyiU","7pAXm7WEA2I","eU6no0EEJM0",
    "FPjLbPu5BsQ","Y17-tKQXrxs","JKVc02-GmGs","4XaaIGBdhaw","qZRP5hKGHrs","IJp4KU7SiuQ","PVTDEOeSP88","-SSsm0gVu3o","yvpCxgV3AZo",
    "XxwGqFaxJK0","VcEHkVStszM","QCe2ks9b8YI","IPYA3b3_nyk","_LDN79j5H5s","6qiNJWw5aLI","5BpYD7TxvKU","vjq-13YADeI","sq6n8dL117c",
    "-9fqo94G6YU","Y7R8m-10GJc","Buq071iqYAM","gWppLYaCICM","VMFKz7Klx7I","38I_AUMpKpQ","8nIilb2kiSU","Hxhbp1WSDJA","yPYrxbkY2rk",
    "lv5IDF7dmBk","sAj_Jrqrg5g","_oyuKw3vBf8","ye2tvFir65g","wAmq8eIkdI8"};
    String[] Title={"Introduction","Setting Up Code Blocks","How Computer Programs Work","Print Text on the Screen","Comments",
    "Conversion Characters","Variables","String Terminator","I Need Arrays","Creating a Header File","Getting Input with scanf",
    "Math Operators","Cats Love Bagels","Calculating the Average Age","How to Calculate Interest","Typecasting","Making Decisions Using if Statements",
    "Nesting if Statements","if else","What about more than two choices?","Dont Beat Up Little Kids","or","Shorthand if else",
    "Increment Operator","while Loops","do while Loops","for Loop","How to Make a Table","break","continue","switch","A Few Cool Character Functions",
    "isupper and Challenge #1!","strcat and strcpy","puts and gets","Rounding Numbers","Absolute Value with abs","Random Number Generator with rand",
    "int and float Arrays","Why I am Banned from Fantasy Hockey","Sorting Arrays","Pointers","Dereference Pointer","Arrays and Pointers",
    "Strings and Pointers","Problems with String Lengths","The Heap","Creating an Expandable Program using the Heap","Structures",
    "Writing Files in C","How to Read Files","Append to File","Random File Access","Functions","Global vs Local Variables","Passing Arguments to Functions",
    "Return Values","Pass by Reference vs Pass by Value"};
    Context ctx;

    public RecyclerAdapter1(Context context) {
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