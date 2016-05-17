package com.github.florent37.materialimageanimation.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.github.florent37.materialimageanimation.R;
import com.github.florent37.materialimageloading.MaterialImageLoading;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    final static int DURATION = 4000;

    @BindView(R.id.image)
    ImageView imageView;

    Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadImage();
    }

    private void loadImage(){
        Picasso.with(this).load(R.drawable.image_sample).fit().centerCrop().into(imageView, new Callback() {

            @Override
            public void onSuccess() {
                MaterialImageLoading.animate(imageView).setDuration(DURATION).start();
            }

            @Override
            public void onError() {

            }
        });
    }

    @OnClick(R.id.image)
    public void onClickImage() {
        loadImage();
    }


}
