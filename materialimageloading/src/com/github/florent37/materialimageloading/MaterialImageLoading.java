package com.github.florent37.materialimageloading;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class MaterialImageLoading {

    private static final int DEFAULT_DURATION = 3000;
    final ImageView imageView;
    final Drawable drawable;
    int duration = DEFAULT_DURATION;
    float saturation;
    ValueAnimator animationSaturation;
    ValueAnimator animationContrast;
    ObjectAnimator animationAlpha;

    private MaterialImageLoading(ImageView imageView) {
        this.imageView = imageView;
        this.drawable = imageView.getDrawable();
    }

    public static MaterialImageLoading animate(ImageView imageView) {
        return new MaterialImageLoading(imageView);
    }

    public int getDuration() {
        return duration;
    }

    public MaterialImageLoading setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public void start() {
        setup(duration);

        animationSaturation.start();
        animationContrast.start();
        animationAlpha.start();
    }

    public void cancel() {
        animationSaturation.cancel();
        animationContrast.cancel();
        animationAlpha.cancel();
    }

    private ColorMatrix setContrast(float contrast) {
        float scale = contrast + 1.f;
        float translate = (-.5f * scale + .5f) * 255.f;
        float[] array = new float[]{
            scale, 0, 0, 0, translate,
            0, scale, 0, 0, translate,
            0, 0, scale, 0, translate,
            0, 0, 0, 1, 0};
        return new ColorMatrix(array);
    }

    private void setup(int duration) {
        //region saturation
        animationSaturation = ValueAnimator.ofFloat(0.2f, 1f);
        animationSaturation.setDuration(duration);
        animationSaturation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                saturation = animation.getAnimatedFraction();
            }
        });
        //endregion

        //region contrast
        animationContrast = ValueAnimator.ofFloat(0f, 1f);
        animationContrast.setDuration((long) (duration * 3f / 4f));
        animationContrast.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ColorMatrix colorMatrix = setContrast(animation.getAnimatedFraction());
                colorMatrix.setSaturation(saturation);
                ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                drawable.setColorFilter(colorFilter);
            }
        });
        //endregion

        //region alpha
        animationAlpha = ObjectAnimator.ofFloat(imageView, View.ALPHA, 0f, 1f);
        animationAlpha.setDuration((long) (duration / 2f));
        //endregion
    }

}
