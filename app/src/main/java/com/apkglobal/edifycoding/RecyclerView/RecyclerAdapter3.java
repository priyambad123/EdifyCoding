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


public class RecyclerAdapter3 extends RecyclerView.Adapter<RecyclerAdapter3.VideoInfoHolder> {

    //these ids are the unique id for each video
    String[] VideoID = {"Hl-zzrqQoSE", "5u8rFbpdvds", "CE8UIbb_4iM","SHIT5VkNrCg","gtQJXzi3Yns","5DdacOkrTgo","ANuuSFY2BbY","8ZaTSedtf9M",
    "ydcTx6idTs0","iMeaovDbgkQ","PAaqgTr7Cx4","RVRPmeccFT0","8ZuWD2CBjgs","XqTg2buXS5o","7MBgaF8wXls","9t78g0U8VyQ","tPFuVRbUTwA",
    "Y4xFGCyt1ww","C0YRYVn_BeI","Y6NheSwTsDs","KXuQQh6AynQ","rjkYAs6gAkk","T9TcAm9g0mo","nfr52iR0Pyg","JzMdepMLW44","AhwIYAXPASw",
    "L06uGnF4IpY","nTF-RcgsV0E","etyrkipdKvc","pHxtKDENDdE","w41D0V-BnKQ","rzXoz2KOP7E","ctab5xPv-Vk","hbot9MQVHOM","BFL1oWnEO2k",
    "o4Or0PMI_aI","E0BTAqIltFc","csjfLTt6-io","LS7BzkBzn3Y","eqP5X6APc5w","MK2SMJZbUmU","l0N6WvIVoUI","ZBkyPA6NZR8","uFGrL5vyp54",
    "r-_6fJpC-pk","Mhxp5dZOy78","14c1oJjgC8g","Suxdg95FV1w","9JpNY-XAseg","jJjg4JweJZU","jUdIAgJ7JKo","3EE7E3bvfe8","qhYook53olE",
    "M1_-sigEPtE","0xw06loTm1k&t=3s","KKbN5pjBZGM","zN9pKULyoj4","TyPNvt6Zg8c","slY5Ag7IjM0","0--h2x6HENA","6d0m_L8_1XU","6iV-v_m0z0w",
    "3RQOikbGGUM","_UuDuj-RNRg","Y8zKDsenQFA","_d4CU9MveLE","-ptlsT9KsM8","vd-k2oBMXUI","XS4-5GmRnp8","GBlKa8cNROM","aLkkYbHz16E","9z_8yEv7nIc",
    "68X8RUxeXeA","hsHqhX0s7Rs","MpIHF4V3zMc","sdUJR_DSyBU","UuKNGMCfSkQ","7fC9nL3_AQQ","G0DfmD0KKyc","Bws9aQuAcdg","3RNYUKxAgmw",
    "K_-3OLkXkzY","DFQzFJqOSbA","2l5-5PMUc5Y","052U-bWEXrk","OWOeE90ET6w","38UOAo1c_QA"};




    String[] Title={"Installing the JDK","Running a Java Program","Downloading Eclipse","Hello YouTube","Variables","Getting User Input",
    "Building a Basic Calculator","Math Operators","Increment Operators","If Statement","Logical Operators","Switch Statement","While Loop",
    "Using Multiple Classes","Use Methods with Parameters","Many Methods and Instances","Constructors","Nested if Statements",
    "else if Statement","Conditional Operators","Simple Averaging Program","for Loops","Compound Interest Program","do while Loops",
    "Math Class Methods","Random Number Generator","Introduction to Arrays","Creating an Array Table","Summing Elements of Arrays",
    "Array Elements as Counters","Enhanced for Loop","Arrays in Methods","Multidimensional Arrays","Table for Multi Arrays","Variable Length Arguments",
    "Time Class","Display Regular time","Public, Private and this","Multiple Constructors","Set and Get Methods","Building Objects for Constructors",
    "toString","Composition","Enumeration","EnumSet range","Static","More on Static","final","Inheritance","Graphical User Interface GUI",
    "GUI with JFrame","Event Handling","ActionListner","Event Handler Program","Intoduction to Polymorphism","Polymorphic Arguements",
    "Overriding Rules","Abstract and Concrete Classes","Class to Hold Objects","Array Holding Many Objects","Simple Polymorphic Program",
    "JButton","JButton Final Program","JCheckBox","The Final Check Box Program","JRadioButton","JRadioButton Final Program","JComboBox",
    "Drop Down List Program","JList","JList Program","Multiple Selection List","Moving List Items Program","Mouse Events","MouseListener interface",
    "MouseMotionListener interface","Adapter Classes","File Class","Creating Files","Writing to Files","Reading from Files","Exception Handling",
    "FlowLayout","Drawing Graphics","JColorChooser","Drawing More Stuff","Series Finale"};
    Context ctx;

    public RecyclerAdapter3(Context context) {
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