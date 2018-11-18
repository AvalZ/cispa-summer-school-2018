package android.support.v4.f;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a {
    private static Method a;
    private static Method b;

    static {
        if (VERSION.SDK_INT >= 21) {
            try {
                b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
                return;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                a = cls.getMethod("getScript", new Class[]{String.class});
                b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e2) {
            a = null;
            b = null;
            Log.w("ICUCompat", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0014 A:{ExcHandler: java.lang.IllegalAccessException (r3_4 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Missing block: B:6:0x0014, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:0x0015, code:
            android.util.Log.w("ICUCompat", r3);
     */
    private static java.lang.String a(java.lang.String r3) {
        /*
        r0 = 0;
        r1 = a;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        if (r1 == 0) goto L_0x001a;
    L_0x0005:
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r2 = 0;
        r1[r2] = r3;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r3 = a;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r3 = r3.invoke(r0, r1);	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r3 = (java.lang.String) r3;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        return r3;
    L_0x0014:
        r3 = move-exception;
        r1 = "ICUCompat";
        android.util.Log.w(r1, r3);
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.a.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001a A:{ExcHandler: java.lang.reflect.InvocationTargetException (r0_6 'e' java.lang.Throwable), Splitter: B:3:0x0008} */
    /* JADX WARNING: Missing block: B:6:0x001a, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:0x001b, code:
            android.util.Log.w("ICUCompat", r0);
     */
    /* JADX WARNING: Missing block: B:8:0x0024, code:
            return r3.getScript();
     */
    public static java.lang.String a(java.util.Locale r3) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 0;
        r2 = 21;
        if (r0 < r2) goto L_0x0025;
    L_0x0007:
        r0 = 1;
        r0 = new java.lang.Object[r0];	 Catch:{ InvocationTargetException -> 0x001a, InvocationTargetException -> 0x001a }
        r2 = 0;
        r0[r2] = r3;	 Catch:{ InvocationTargetException -> 0x001a, InvocationTargetException -> 0x001a }
        r2 = b;	 Catch:{ InvocationTargetException -> 0x001a, InvocationTargetException -> 0x001a }
        r0 = r2.invoke(r1, r0);	 Catch:{ InvocationTargetException -> 0x001a, InvocationTargetException -> 0x001a }
        r0 = (java.util.Locale) r0;	 Catch:{ InvocationTargetException -> 0x001a, InvocationTargetException -> 0x001a }
        r0 = r0.getScript();	 Catch:{ InvocationTargetException -> 0x001a, InvocationTargetException -> 0x001a }
        return r0;
    L_0x001a:
        r0 = move-exception;
        r1 = "ICUCompat";
        android.util.Log.w(r1, r0);
        r3 = r3.getScript();
        return r3;
    L_0x0025:
        r3 = b(r3);
        if (r3 == 0) goto L_0x0030;
    L_0x002b:
        r3 = a(r3);
        return r3;
    L_0x0030:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.a.a(java.util.Locale):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0018 A:{ExcHandler: java.lang.IllegalAccessException (r0_5 'e' java.lang.Throwable), Splitter: B:1:0x0004} */
    /* JADX WARNING: Missing block: B:6:0x0018, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:0x0019, code:
            android.util.Log.w("ICUCompat", r0);
     */
    private static java.lang.String b(java.util.Locale r3) {
        /*
        r3 = r3.toString();
        r0 = b;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        if (r0 == 0) goto L_0x001e;
    L_0x0008:
        r0 = 1;
        r0 = new java.lang.Object[r0];	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r1 = 0;
        r0[r1] = r3;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r1 = b;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r2 = 0;
        r0 = r1.invoke(r2, r0);	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r0 = (java.lang.String) r0;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        return r0;
    L_0x0018:
        r0 = move-exception;
        r1 = "ICUCompat";
        android.util.Log.w(r1, r0);
    L_0x001e:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.a.b(java.util.Locale):java.lang.String");
    }
}
