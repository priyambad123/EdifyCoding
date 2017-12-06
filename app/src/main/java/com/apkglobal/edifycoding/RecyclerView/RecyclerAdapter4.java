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


public class RecyclerAdapter4 extends RecyclerView.Adapter<RecyclerAdapter4.VideoInfoHolder> {

    //these ids are the unique id for each video
    String[] VideoID = {"HBxCHonP6Ro", "hnxIRVZ0EyU", "nefopNkZmB4","YbipxqSKx-E","1yUn-ydsgKk","-s4wKoLO520","bk22K1m0890","llguiJHU0kk",
    "Neir-vgPyxw","k6rkvgQkW04","68EhtQbgXRc","j2xhtI0WTew","xRIzPZlei9I","mwr1AtpLMpI","f3TVuuhe-fY","DASOXeFFkCg","QSTo9F8E6GE",
    "DJ2HSCT6Z8w","23eY8n08pMc","BSNFRKG1MfE","WN4A6iJOUns","GQiLweAoxgQ","YV6qm6erphk","MjwWzBiAMck","XjNm9bazxn8","sVNJOiTBi_8",
    "pLHejmLB16o","1cCU0owdiR4","POQIIKb1BZA","G8kS24CtfoI","qSDiHI1kP98","oROcVrgz91Y","YCEVvs5BhpY","WaXK8G1hb_Q","ZxiJ92-4Qys",
    "up5Xehmtn2E","E3T5cm0yys0","XhXOsgdC9h0","cTXHmOt7Rwc","Xe1tnfl4jDY","U5I-2UZBOVg","_H9uPRJWMNk","SiOBAhUiNCc","uR50xQX27-g",
    "c6z990uViDE","NSbjuqHLxJA","El0mbC7olFc","-hzbRgRSI_U","PGAtCGqt06U","Z8Cu-8brldc","frwqnS9ICxw","iiQqilwChw4","E1GueQ5ULc8"};
    String[] Title={"Installing Python","Numbers","Strings","Slicing up Strings","Lists","Installing PyCharm","if elif else","for",
    "Range and While","Comments and Break","Continue","Functions","Return Values","Default Values for Arguments","Variable Scope",
    "Keyword Arguments","Flexible Number of Arguments","Unpacking Arguments","My trip to Walmart and Sets","Dictionary","Modules",
    "Download an Image from the Web","How to Read and Write Files","Downloading Files from the Web","How to Build a Web Crawler (1/3)",
    "How to Build a Web Crawler (2/3)","How to Build a Web Crawler (3/3)","You are the only Exception","Classes and Objects","init",
    "Class vs Instance Variables","Inheritance","Multiple Inheritance","threading","Word Frequency Counter (1/3)","Word Frequency Counter (2/3)",
    "Word Frequency Counter (3/3)","Unpack List or Tuples","Zip (and yeast infection story)","Lamdba","Min, Max, and Sorting Dictionaries",
    "Pillow","Cropping Images","Combine Images Together","Getting Individual Channels","Awesome Merge Effect","Basic Transformations",
    "Modes and Filters","struct","map","Bitwise Operators","Finding Largest or Smallest Items","Dictionary Calculations"};
    Context ctx;

    public RecyclerAdapter4(Context context) {
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