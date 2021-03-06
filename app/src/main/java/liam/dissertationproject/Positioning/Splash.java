/*
 * Created by Liam Logan
 * Copyright (c) 2018. All Rights reserved
 *
 *
 */

package liam.dissertationproject.Positioning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Splash extends AppCompatActivity {
    private TextView tv;
    private TextView iv;
    private ProgressBar progressBar;

    private int progressStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar) findViewById(R.id.splash_progress);

        /**
         *  The runnable interface allows us to implement multi-threading other than
         *  extending the Thread class. In the run class we carry out the progressBar Function,
         *  once execute, the activity is changed to the start menu.
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                progressBar();
                startApp();
                finish();
            }
        }).start();
    }

    // Builds up progressBar when loading up splash page
    private void progressBar() {
        while (progressStatus < 100) {
            progressStatus += 10;
            progressBar.setProgress(progressStatus);
            {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // This starts a new activity once the thread time has run out.
    private void startApp() {
        Intent intent = new Intent(Splash.this, StartMenu.class);
        startActivity(intent);
    }

}


