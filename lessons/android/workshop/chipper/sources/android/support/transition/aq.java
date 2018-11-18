package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class aq extends ap {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    aq() {
    }

    private void a() {
        if (!b) {
            try {
                a = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
            }
            b = true;
        }
    }

    private void b() {
        if (!d) {
            try {
                c = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
            }
            d = true;
        }
    }

    public void a(View view, Matrix matrix) {
        a();
        if (a != null) {
            try {
                a.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void b(View view, Matrix matrix) {
        b();
        if (c != null) {
            try {
                c.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}
