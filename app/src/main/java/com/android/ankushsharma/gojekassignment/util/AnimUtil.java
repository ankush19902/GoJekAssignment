package com.android.ankushsharma.gojekassignment.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.ankushsharma.gojekassignment.R;


/**
 * @author ankushsharma
 * @date 08/12/17
 */

public class AnimUtil {

    public static void slideUp(View view, Context context) {
        view.setVisibility(View.VISIBLE);
        Animation slideUpAnimation = AnimationUtils.loadAnimation(context,
                R.anim.anim_slide_up);
        view.startAnimation(slideUpAnimation);
    }

    public static void rotate(View view, Context context) {
        view.setVisibility(View.VISIBLE);
        Animation rotation = AnimationUtils.loadAnimation(context, R.anim.anim_rotate);
        view.startAnimation(rotation);

    }

    public static void stopAnimation(View view) {
        view.clearAnimation();
    }
}
