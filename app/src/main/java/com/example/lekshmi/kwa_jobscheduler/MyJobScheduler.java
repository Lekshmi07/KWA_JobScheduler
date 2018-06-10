package com.example.lekshmi.kwa_jobscheduler;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


public class MyJobScheduler extends AppCompatActivity {

    public void makeCall()
    {
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8943444242"));

        //  startActivity(i);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
            }
            else
            {
                startActivity(i);
            }
        }
        else
        {
            startActivity(i);
        }
    }
}
