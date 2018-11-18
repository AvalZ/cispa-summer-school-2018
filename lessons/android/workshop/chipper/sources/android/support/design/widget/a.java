package android.support.design.widget;

import android.support.v4.h.b.b;
import android.support.v4.h.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class a {
    static final Interpolator a = new LinearInterpolator();
    static final Interpolator b = new b();
    static final Interpolator c = new android.support.v4.h.b.a();
    static final Interpolator d = new c();
    static final Interpolator e = new DecelerateInterpolator();

    static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
