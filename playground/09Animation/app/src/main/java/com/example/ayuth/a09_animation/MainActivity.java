package com.example.ayuth.a09_animation;

import android.graphics.Interpolator;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    final int allImageCount = 32;
    AnimationDrawable mAnimation;
    ImageView imgMain;
    int x = 0;
    int y = 0;
    Button btnAnimationStart;
    Button btnAnimationStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
    }

    public void initInstances() {
        this.btnAnimationStart = findViewById(R.id.btnAnimationStart);
        this.btnAnimationStop = findViewById(R.id.btnAnimationStop);

        imgMain = findViewById(R.id.imgMain);
        BitmapDrawable[] frame = new BitmapDrawable[allImageCount + 1];
        for (int i = 1; i <= allImageCount; i++) {
            Log.d("BABYBOY", String.format("pic_frame_%02d", i));
            frame[i] = (BitmapDrawable) getResources().getDrawable(
                    getResources().getIdentifier(String.format("pic_frame_%02d", i), "drawable", this.getPackageName())
            );
        }
        int reasonableDuration = 200;
        mAnimation = new AnimationDrawable();
        for (int i = 1; i <= allImageCount; i++) {
            mAnimation.addFrame(frame[i], reasonableDuration);
        }
        imgMain.setImageDrawable(mAnimation);

//        Translate image
//        TranslateAnimation tAnimation = new TranslateAnimation(0, 260, 0, 0);
//        tAnimation.setDuration(10000);
//        tAnimation.setFillAfter(true);
//        tAnimation.setRepeatCount(Animation.INFINITE);
//        tAnimation.setRepeatMode(Animation.START_ON_FIRST_FRAME);
//        imgMain.setAnimation(tAnimation);

//        //  Reverse animation
//        RotateAnimation rotateAnimation = new RotateAnimation(0f, -180f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
////        RotateAnimation rotateAnimation = new RotateAnimation(0f, -180f, RotateAnimation.RELATIVE_TO_SELF, 0.0f, RotateAnimation.RELATIVE_TO_SELF, 0.0f);
//        rotateAnimation.setStartOffset(0);
//        rotateAnimation.setDuration(10000);
//        rotateAnimation.setFillAfter(true);
//        rotateAnimation.setRepeatCount(Animation.INFINITE);
//        rotateAnimation.setRepeatMode(Animation.REVERSE);
//        imgMain.setAnimation(rotateAnimation);

//      Scale animation
        ScaleAnimation sAnimation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sAnimation.setDuration(10000);
        sAnimation.setFillAfter(true);
        sAnimation.setRepeatCount(Animation.INFINITE);
        sAnimation.setRepeatMode(Animation.RESTART);
        imgMain.setAnimation(sAnimation);

        Interpolator intepolator = new Interpolator(10, 1000);
        intepolator.

        this.btnAnimationStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimation.start();
                mAnimation.setOneShot(false);
            }
        });

        this.btnAnimationStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimation.stop();
            }
        });

    }
}
