package com.example.lekshmi.kwa_jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int jobid=101;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentName componentName=new ComponentName(this,MyJobExecuter.class);
        JobInfo.Builder builder=new JobInfo.Builder(jobid,componentName);

        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(jobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo=builder.build();

        jobScheduler= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void schedulejob(View view)
    {
        jobScheduler.schedule(jobInfo);
    }

    public void clearjob(View view)
    {
        jobScheduler.cancel(jobid);
        Toast.makeText(this, "Job cancelled", Toast.LENGTH_SHORT).show();
    }
}
