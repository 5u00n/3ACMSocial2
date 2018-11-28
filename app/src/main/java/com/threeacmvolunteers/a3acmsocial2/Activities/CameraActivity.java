package com.threeacmvolunteers.a3acmsocial2.Activities;

import android.content.Intent;
import android.media.MediaPlayer;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

import android.widget.MediaController;
import android.widget.VideoView;

import com.threeacmvolunteers.a3acmsocial2.R;

public class CameraActivity extends AppCompatActivity {
    VideoView mVideoView;
    MediaController mdc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.camera_layout);
        mVideoView = (VideoView) findViewById(R.id.id_video);
        mdc= new MediaController(this);
        mVideoView.setMediaController(mdc);
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, 1);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode ==1 && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
           mVideoView.setVideoURI(videoUri);
         //   mVideoView.setOnCompletionListener(myVideoViewCompletionListener);
         //   mVideoView.setOnPreparedListener(MyVideoViewPreparedListener);

            mVideoView.requestFocus();
            mVideoView.start();
        }
    }

    MediaPlayer.OnCompletionListener myVideoViewCompletionListener =
            new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer arg0) {
                    ///  Toast.makeText(MainActivity.this, "End of Video",Toast.LENGTH_LONG).show();
                }
            };

    MediaPlayer.OnPreparedListener MyVideoViewPreparedListener =
            new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {

                    long duration = mVideoView.getDuration();

                    //in millisecond
                    //  Toast.makeText(MainActivity.this, "Duration: " + duration + " (ms)", Toast.LENGTH_LONG).show();

                }
            };

}