package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.h.r;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

public class bo {
    private static Method a;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                a = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                if (!a.isAccessible()) {
                    a.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (a != null) {
            try {
                a.invoke(view, new Object[]{rect, rect2});
            } catch (Throwable e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static boolean a(View view) {
        return r.e(view) == 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023 A:{ExcHandler: java.lang.reflect.InvocationTargetException (r4_1 'e' java.lang.Throwable), Splitter: B:2:0x0006} */
    /* JADX WARNING: Missing block: B:8:0x0023, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:9:0x0024, code:
            android.util.Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", r4);
     */
    /* JADX WARNING: Missing block: B:10:0x002b, code:
            return;
     */
    public static void b(android.view.View r4) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x0033;
    L_0x0006:
        r0 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x0023, InvocationTargetException -> 0x0023 }
        r1 = "makeOptionalFitsSystemWindows";
        r2 = 0;
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x0023, InvocationTargetException -> 0x0023 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x0023, InvocationTargetException -> 0x0023 }
        r1 = r0.isAccessible();	 Catch:{ NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x0023, InvocationTargetException -> 0x0023 }
        if (r1 != 0) goto L_0x001d;
    L_0x0019:
        r1 = 1;
        r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x0023, InvocationTargetException -> 0x0023 }
    L_0x001d:
        r1 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x0023, InvocationTargetException -> 0x0023 }
        r0.invoke(r4, r1);	 Catch:{ NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x0023, InvocationTargetException -> 0x0023 }
        return;
    L_0x0023:
        r4 = move-exception;
        r0 = "ViewUtils";
        r1 = "Could not invoke makeOptionalFitsSystemWindows";
        android.util.Log.d(r0, r1, r4);
        return;
    L_0x002c:
        r4 = "ViewUtils";
        r0 = "Could not find method makeOptionalFitsSystemWindows. Oh well...";
        android.util.Log.d(r4, r0);
    L_0x0033:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.bo.b(android.view.View):void");
    }
}
