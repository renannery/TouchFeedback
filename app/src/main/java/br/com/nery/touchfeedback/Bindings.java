package br.com.nery.touchfeedback;

import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


/**
 * Created by renan.souza on 1/11/16.
 */
public class Bindings {

    @BindingAdapter("app:touchFeedback")
    public static void touchFeedback(View view, ColorDrawable color) {

        Drawable colorDrawable;

        ViewGroup parent = (ViewGroup) view.getParent();
        int index = parent.indexOfChild(view);
        parent.removeView(view);
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        frameLayout.setLayoutParams(view.getLayoutParams());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RippleDrawable rippleDrawable = new RippleDrawable(ColorStateList.valueOf(color.getColor()), null, null);
            colorDrawable = rippleDrawable;
        } else {
            color.setColor(getColorWithAlpha(color.getColor(), 0.75f));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.setEnterFadeDuration(200);
            stateListDrawable.setExitFadeDuration(200);
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, color);
            colorDrawable = stateListDrawable;
        }

        frameLayout.setForeground(colorDrawable);

        RelativeLayout.LayoutParams childParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(childParams);

        frameLayout.setClickable(true);
        frameLayout.addView(view);
        parent.addView(frameLayout, index);
        parent.invalidate();

    }

    public static int getColorWithAlpha(int color, float ratio) {
        int newColor;
        int alpha = Math.round(Color.alpha(color) * ratio);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        newColor = Color.argb(alpha, r, g, b);
        return newColor;
    }
}
