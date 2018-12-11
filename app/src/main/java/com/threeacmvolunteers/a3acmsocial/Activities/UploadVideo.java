package com.threeacmvolunteers.a3acmsocial.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.threeacmvolunteers.a3acmsocial.R;

import java.io.File;

public class UploadVideo extends AppCompatActivity {

    VideoView mVideoView;
    MediaController mdc;
    EditText vName, vtitle, vTags, vDiscription;
    Button uploadButton, playButton;
    Uri videoUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_status_layout);
        mVideoView = (VideoView) findViewById(R.id.video_player_upload);
        mdc = new MediaController(this);
        mVideoView.setMediaController(mdc);


        //objects Declaration
        vName = (EditText) findViewById(R.id.id_uploadpage_etext_name);
        vtitle = (EditText) findViewById(R.id.id_uploadpage_etext_title);
        vTags = (EditText) findViewById(R.id.id_uploadpage_etext_tags);
        vDiscription = (EditText) findViewById(R.id.id_uploadpage_etext_discription);
        uploadButton = (Button) findViewById(R.id.id_uploadpage_button_upload);
        playButton = (Button) findViewById(R.id.id_upload_video_button_play);


        //listener declaration::
        playButton.setOnClickListener(playRecorded);
        uploadButton.setOnClickListener(uploadFile);


        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            videoUri = intent.getData();
            mVideoView.setVideoURI(videoUri);
            mVideoView.setOnCompletionListener(myVideoViewCompletionListener);
            mVideoView.setOnPreparedListener(MyVideoViewPreparedListener);
            mVideoView.requestFocus();
            //   mVideoView.start();
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
                    //  Toast.makeText(MainActivity.this, "Duration: " + duration + " (ms)", Toast.LENGTH_LONG).show();

                }
            };

    View.OnClickListener playRecorded = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            playButton.setVisibility(View.GONE);
            mVideoView.start();
        }
    };

    View.OnClickListener uploadFile = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Storing in firebase and getting download address

            FirebaseStorage storage = FirebaseStorage.getInstance();
            final StorageReference storageRef = storage.getReferenceFromUrl("gs://acmsocial2.appspot.com");

            //  Uri file = Uri.fromFile(new File("data/data/file-path/file-name"));
            Log.d("file", videoUri.getPath());


            final StorageReference riversRef = storageRef.child("TempVideos/tempvieo.mp4");
            UploadTask uploadTask = riversRef.putFile(videoUri);

            // Register observers to listen for when the download is done or if it fails
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                    Log.d("uploadFail", "" + exception);
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    taskSnapshot.getMetadata();
                    riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Log.d("XXXXXX", "onSuccess: uri= " + uri.toString());
                        }
                    });
                }
            });
        }
    };
}