package com.prave.tools.musictest00001;

import android.app.IntentService;
import android.content.Intent;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;


public class MyIntentService2 extends IntentService {
    public MyIntentService2() {
        super("MyIntentService2");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SoundPool sp=new SoundPool.Builder().setMaxStreams(1).build();
        try {
            int pid=sp.load(getAssets().openFd("Selena Gomez  - Wolves.mp3"),0);
            int sid=sp.play(pid,1,1,0,-1,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
