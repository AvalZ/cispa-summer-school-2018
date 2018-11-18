package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.h.r;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class am {
    static final Property<View, Float> a = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(am.c(view));
        }

        /* renamed from: a */
        public void set(View view, Float f) {
            am.a(view, f.floatValue());
        }
    };
    static final Property<View, Rect> b = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return r.w(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            r.a(view, rect);
        }
    };
    private static final as c;
    private static Field d;
    private static boolean e;

    static {
        as arVar = VERSION.SDK_INT >= 22 ? new ar() : VERSION.SDK_INT >= 21 ? new aq() : VERSION.SDK_INT >= 19 ? new ap() : VERSION.SDK_INT >= 18 ? new ao() : new an();
        c = arVar;
    }

    static al a(View view) {
        return c.a(view);
    }

    private static void a() {
        if (!e) {
            try {
                d = View.class.getDeclaredField("mViewFlags");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            e = true;
        }
    }

    static void a(View view, float f) {
        c.a(view, f);
    }

    static void a(View view, int i) {
        a();
        if (d != null) {
            try {
                d.setInt(view, i | (d.getInt(view) & -13));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    static void a(View view, int i, int i2, int i3, int i4) {
        c.a(view, i, i2, i3, i4);
    }

    static void a(View view, Matrix matrix) {
        c.a(view, matrix);
    }

    static aw b(View view) {
        return c.b(view);
    }

    static void b(View view, Matrix matrix) {
        c.b(view, matrix);
    }

    static float c(View view) {
        return c.c(view);
    }

    static void d(View view) {
        c.d(view);
    }

    static void e(View view) {
        c.e(view);
    }
}
