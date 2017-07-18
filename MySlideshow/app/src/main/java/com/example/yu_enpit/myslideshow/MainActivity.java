package com.example.yu_enpit.myslideshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {


    ImageSwitcher mImageSwitcher;
    int[] mImageResources = {R.drawable.slide00,R.drawable.slide01
            ,R.drawable.slide02,R.drawable.slide03
            ,R.drawable.slide04,R.drawable.slide05
            ,R.drawable.slide06,R.drawable.slide07
            ,R.drawable.slide08,R.drawable.slide09
    };
    int mPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory(){
            @Override
            public View makeView(){
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
        mImageSwitcher.setImageResource(mImageResources[0]);
    }
    public void onAnimationButtonTapped(View view){
        float y = view.getY() + 100;
        view.animate().setDuration(1000).setInterpolator(new BounceInterpolator()).y(y);
    }
    private void movePosition(int move){
        mPosition = mPosition + move;
        if (mPosition >= mImageResources.length){
            mPosition = 0;
        }else if(mPosition < 0){
            mPosition = mImageResources.length -1;
        }
        mImageSwitcher.setImageResource(mImageResources[mPosition]);
    }
    public void onPrevButtonTapped(View view){
        movePosition(-1);
    }
    public void onNextButtonTapped(View view){
        movePosition(1);
    }

}
