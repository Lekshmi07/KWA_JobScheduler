package com.example.lekshmi.kwa_jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MyJobExecuter extends JobService {
    private MJobExecuter mJobExecuter;

    @Override
    public boolean onStartJob(final JobParameters params) {
       mJobExecuter=new MJobExecuter()
       {
           protected void onPostExecute(String e)
           {
               Toast.makeText(MyJobExecuter.this, e, Toast.LENGTH_SHORT).show();
               jobFinished(params,false);
           }
       };
       mJobExecuter.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params)
    {
mJobExecuter.cancel(true);
        return false;
    }
}
