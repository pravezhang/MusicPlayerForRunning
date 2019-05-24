package com.prave.tools.musictest00001;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentService");
    }
    MediaPlayer md;
    Timer timer;
    int currentSong=-1;
    public static final String[] songs={"RISE.mp3","MAA.mp3","FADED.mp3","DESP.mp3","ZZZS.mp3","BMWA.mp3","FS.mp3"};
    @Override
    protected void onHandleIntent(Intent intent) {
        timer=new Timer();
        md=new MediaPlayer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!md.isPlaying()){
                    md.release();
                    md=null;
                    md=new MediaPlayer();
                    if(currentSong==6)
                        currentSong=-1;
                    currentSong++;
                    /*
                    *
                    try {
                        md.setDataSource(getAssets().openFd(songs[currentSong]));
                    }catch (Exception e) {
                        md=null;
                        md=new MediaPlayer();
                    }
                    *
                    *
                    * */
                    try{
                        md.setDataSource(getAssets().openFd(songs[currentSong]));
                        md.prepare();
                        md.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        },0,1000);

    }

}
