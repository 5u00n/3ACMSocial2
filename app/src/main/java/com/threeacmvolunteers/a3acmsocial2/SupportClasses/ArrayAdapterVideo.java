package com.threeacmvolunteers.a3acmsocial2.SupportClasses;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.threeacmvolunteers.a3acmsocial2.R;

import java.util.List;

import static java.security.AccessController.getContext;

public class ArrayAdapterVideo  extends ArrayAdapter<VideoStrings>
{
    private Activity context;
    private List<VideoStrings> lists;


    public ArrayAdapterVideo(@NonNull Activity context, List<VideoStrings>lists) {
        super(context, R.layout.video_view_layout,lists);
        this.context=context;
        this.lists=lists;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inf = context.getLayoutInflater();
        View vw =inf.inflate(R.layout.video_view_layout,null,true);
        //TextView nm = (TextView) vw.findViewById(R.id.name_video);
       // TextView url = (TextView) vw.findViewById(R.id.list_view_url);
       // ImageView im=(ImageView) vw.findViewById(R.id.thumbnail_list_style);
       // VidStr v1 = lists.get(position);
       // nm.setText(v1.name);
       // url.setText(v1.url);
       // Uri ur= Uri.parse(v1.url);

      //  String url1 = v1.getUrl();

      /*  RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_launcher_background);
        requestOptions.error(R.drawable.ic_launcher_foreground);


        Glide.with(getContext())
                .load(url1)
                .apply(requestOptions)
                .thumbnail(Glide.with(getContext()).load(url1))
                .into(im);*/


        return  vw;
    }



    /*public static Bitmap retriveVideoFrameFromVideo(String videoPath)throws Throwable
    {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try
        {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 14)
                mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
            else
                mediaMetadataRetriever.setDataSource(videoPath);
            //   mediaMetadataRetriever.setDataSource(videoPath);
            bitmap = mediaMetadataRetriever.getFrameAtTime(1, MediaMetadataRetriever.OPTION_CLOSEST);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Throwable("Exception in retriveVideoFrameFromVideo(String videoPath)"+ e.getMessage());
        }
        finally
        {
            if (mediaMetadataRetriever != null)
            {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }*/
}
