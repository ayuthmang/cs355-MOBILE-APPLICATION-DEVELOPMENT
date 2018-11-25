package com.example.ayuth.a09_media;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStartAnimation;
    Button btnStopAnimation;
    ImageView imgAnimationMain;
    AnimationDrawable animationDrawable;
    int x, y;

    final int imagesFrameCount = 24;
    final String imageFramePrefix = "frame_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
    }

    public void initInstances() {
        btnStartAnimation = findViewById(R.id.btnAnimationStart);
        btnStopAnimation = findViewById(R.id.btnAnimationStop);
        imgAnimationMain = findViewById(R.id.imgAnimateMain);
        animationDrawable = new AnimationDrawable();
        this.x = 0;
        this.y = 0;

        btnStartAnimation.setOnClickListener(this);
        btnStopAnimation.setOnClickListener(this);

        BitmapDrawable[] frames = new BitmapDrawable[imagesFrameCount];
        for (int i = 0; i < imagesFrameCount; i++) {
            frames[i] = (BitmapDrawable) getResources().getDrawable(getResources().getIdentifier(imageFramePrefix + i, "drawable", this.getPackageName()));
        }
        int reasonableDuration = 100;
        for (int i = 0; i < imagesFrameCount; i++) {
            animationDrawable.addFrame(frames[i], reasonableDuration);
        }
        imgAnimationMain.setImageDrawable(animationDrawable);
    }


    @Override
    public void onClick(View v) {
        if (v == btnStartAnimation) {
            animationDrawable.start();
            animationDrawable.setOneShot(false);
        } else if (v == btnStopAnimation) {
            animationDrawable.stop();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            TranslateAnimation tAnimation = new TranslateAnimation(x, ((int) event.getX() - ( imgAnimationMain.getWidth() / 2)), y, ((int) event.getY() -  imgAnimationMain.getHeight()));
            x = (int) event.getX() - (imgAnimationMain.getWidth() / 2);
            y = (int) event.getY() - imgAnimationMain.getHeight();
            tAnimation.setDuration(1000);
            tAnimation.setFillAfter(true);
            tAnimation.setRepeatCount(0);
            tAnimation.setRepeatMode(Animation.RESTART);
            imgAnimationMain.startAnimation(tAnimation);
            return true;
        }
        return super.onTouchEvent(event);
    }
}
