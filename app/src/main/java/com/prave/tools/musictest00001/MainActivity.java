package com.prave.tools.musictest00001;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageButton play;
    boolean clicked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final android.support.constraint.ConstraintLayout content = findViewById(R.id.content);
        play=findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!clicked){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MyIntentService.class);
                    startService(intent);
                    clicked=true;
                }
                else{
                    Toast.makeText(MainActivity.this,"已经在播放了",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(!(keyCode==KeyEvent.KEYCODE_BACK))
        return super.onKeyDown(keyCode, event);
        Toast.makeText(MainActivity.this,"不能返回",Toast.LENGTH_LONG).show();
        return true;
    }
}
