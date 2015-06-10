package com.github.florent37.materialimageloading;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by florentchampigny on 13/05/15.
 */
public class MaterialImageLoading {

    private static final int DEFAULT_DURATION = 3000;

    public static MaterialImageLoading animate(ImageView imageView) {
        MaterialImageLoading materialImageLoading = new MaterialImageLoading(imageView);
        return materialImageLoading;
    }

    private MaterialImageLoading(ImageView imageView) {
        this.imageView = imageView;
        this.drawable = imageView.getDrawable();
    }

    final ImageView imageView;
    final Drawable drawable;

    int duration = DEFAULT_DURATION;

    float saturation;

    public int getDuration() {
        return duration;
    }

    public MaterialImageLoading setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    private ColorMatrix setContrast(float contrast) {
        float scale = contrast + 1.f;
        float translate = (-.5f * scale + .5f) * 255.f;
        float[] array = new float[]{
                scale, 0, 0, 0, translate,
                0, scale, 0, 0, translate,
                0, 0, scale, 0, translate,
                0, 0, 0, 1, 0};
        ColorMatrix matrix = new ColorMatrix(array);
        return matrix;
    }

    ValueAnimator animationSaturation;
    ValueAnimator animationContrast;
    ObjectAnimator animationAlpha;

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
        animationContrast = ValueAnimator.ofFloat(0, 1f);
        animationContrast.setDuration(duration * 3 / 4);
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
        animationAlpha = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f);
        animationAlpha.setDuration(duration / 2);
        //endregion
    }

    public void start() {
        setup(duration);

        animationSaturation.start();
        animationContrast.start();
        animationAlpha.start();
    }

    public void cancel(){
        animationSaturation.cancel();
        animationContrast.cancel();
        animationAlpha.cancel();
    }

}
