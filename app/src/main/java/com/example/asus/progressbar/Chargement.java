package com.example.asus.progressbar;

import android.app.ProgressDialog;
import android.os.Handler;

/**
 * Created by user_mr on 26/07/2015.
 */
public class Chargement extends Thread {
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;
    public Chargement(ProgressDialog pd)
    {
        progressBar=pd;
        progressBar.setCancelable(false);
        progressBar.setMessage("File downloading ...wait!");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        progressBarStatus = 0;
        fileSize = 0;
    }
    public void run(){
        while (progressBarStatus < 100) {
            progressBarStatus = Avance();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progressBarHandler.post(new Runnable() {
                public void run() {
                    progressBar.setProgress(progressBarStatus);
                }
            });
        }
        if (progressBarStatus >= 100) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progressBar.dismiss();
        }
}


    public int Avance() {

        while (fileSize <= 1000000) {

            fileSize++;

            if (fileSize == 100000) {
                return 10;
            } else if (fileSize == 200000) {
                return 20;
            } else if (fileSize == 300000) {
                return 30;
            }
        }
        return 100;
    }
}
