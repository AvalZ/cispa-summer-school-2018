package android.support.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ah extends ag {
    private static Method a;
    private static boolean b;

    ah() {
    }

    private void a() {
        if (!b) {
            try {
                a = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
            }
            b = true;
        }
    }

    public ae a(ViewGroup viewGroup) {
        return new ad(viewGroup);
    }

    public void a(ViewGroup viewGroup, boolean z) {
        Throwable e;
        String str;
        String str2;
        a();
        if (a != null) {
            try {
                a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e2) {
                e = e2;
                str = "ViewUtilsApi18";
                str2 = "Failed to invoke suppressLayout method";
                Log.i(str, str2, e);
            } catch (InvocationTargetException e3) {
                e = e3;
                str = "ViewUtilsApi18";
                str2 = "Error invoking suppressLayout method";
                Log.i(str, str2, e);
            }
        }
    }
}
