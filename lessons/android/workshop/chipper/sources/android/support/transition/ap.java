package android.support.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ap extends ao {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    ap() {
    }

    private void a() {
        if (!b) {
            try {
                a = View.class.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
            }
            b = true;
        }
    }

    private void b() {
        if (!d) {
            try {
                c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
            }
            d = true;
        }
    }

    public void a(View view, float f) {
        a();
        if (a != null) {
            try {
                a.invoke(view, new Object[]{Float.valueOf(f)});
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        view.setAlpha(f);
    }

    public float c(View view) {
        b();
        if (c != null) {
            try {
                return ((Float) c.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
                return super.c(view);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void d(View view) {
    }

    public void e(View view) {
    }
}
