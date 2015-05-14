package com.github.florent37.materialimageanimation.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.github.florent37.materialimageanimation.R;
import com.github.florent37.materialimageloading.MaterialImageLoading;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Random;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    ImageView imageView;
    Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(this);

        loadImage();
    }

    private int getRandomNumber(){
        return ran.nextInt(10) + 600;
    }

    private void loadImage(){
        String url = "http://lorempixel.com/"+getRandomNumber()+"/"+getRandomNumber()+"/";
        Picasso.with(this).load(url).fit().centerCrop().into(imageView, new Callback() {

            @Override
            public void onSuccess() {
                MaterialImageLoading.animate(imageView).start();
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        loadImage();
    }


}
