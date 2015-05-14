package com.github.florent37.materialimageloading;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by florentchampigny on 13/05/15.
 */
public class MaterialImageLoading {

    public static MaterialImageLoading animate(ImageView imageView) {
        MaterialImageLoading materialImageLoading = new MaterialImageLoading(imageView);
        materialImageLoading.animate();
        return materialImageLoading;
    }

    private MaterialImageLoading(ImageView imageView) {
        this.imageView = imageView;
        this.drawable = imageView.getDrawable();
    }

    final ImageView imageView;
    final Drawable drawable;

    float saturation;
    int duration = 3000;

    public ColorMatrix setContrast(float contrast) {
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

    public void animate() {
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

    public void start(){
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
