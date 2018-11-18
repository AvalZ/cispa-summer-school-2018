package android.support.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ar extends aq {
    private static Method a;
    private static boolean b;

    ar() {
    }

    @SuppressLint({"PrivateApi"})
    private void a() {
        if (!b) {
            try {
                a = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
            }
            b = true;
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        a();
        if (a != null) {
            try {
                a.invoke(view, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}
