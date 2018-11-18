package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.c;

public class ag {
    public static final Rect a = new Rect();
    private static Class<?> b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static Mode a(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    static void a(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    public static boolean b(Drawable drawable) {
        if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable b : ((DrawableContainerState) constantState).getChildren()) {
                    if (!b(b)) {
                        return false;
                    }
                }
            }
        } else {
            if (drawable instanceof c) {
                drawable = ((c) drawable).a();
            } else if (drawable instanceof android.support.v7.c.a.c) {
                drawable = ((android.support.v7.c.a.c) drawable).b();
            } else if (drawable instanceof ScaleDrawable) {
                drawable = ((ScaleDrawable) drawable).getDrawable();
            }
            return b(drawable);
        }
        return true;
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        int[] iArr = (state == null || state.length == 0) ? bb.e : bb.h;
        drawable.setState(iArr);
        drawable.setState(state);
    }
}
