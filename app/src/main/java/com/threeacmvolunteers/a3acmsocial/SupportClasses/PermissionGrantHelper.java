package com.threeacmvolunteers.a3acmsocial.SupportClasses;

import android.Manifest;
import android.app.Activity;
import android.content.ContentProvider;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import static android.support.constraint.Constraints.TAG;

public class PermissionGrantHelper  {
    Activity activity;
    public PermissionGrantHelper(Activity activity) {
        this.activity=activity;
    }

    public  static boolean isReadStoragePermissionGranted(Activity act) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(act,Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission Granted for Read Write Storage");
                return true;
            } else {

                Log.v(TAG,"Permission for Read Write is revoked");
                ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission for Read Write Storage is Granted");
            return true;
        }
    }

    public  static boolean isCameraPermissionGranted(Activity act) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(act,Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission for Camera is Granted");
                return true;
            } else {

                Log.v(TAG,"Permission for Camera is Revoked");
                ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.CAMERA}, 3);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission for Camera is Granted");
            return true;
        }
    }

    public  static boolean isRecordAudioPermissionGranted(Activity act) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(act,Manifest.permission.RECORD_AUDIO)== PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission for Recording Audio is Granted");
                return true;
            } else {

                Log.v(TAG,"Permission for Recording Audio is Revoked");
                ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.RECORD_AUDIO}, 3);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission for Recording Audio is Granted");
            return true;
        }
    }


}
