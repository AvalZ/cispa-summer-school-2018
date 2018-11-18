package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class h {
    private static Field a;
    private static boolean b;
    private static Class c;
    private static boolean d;
    private static Field e;
    private static boolean f;
    private static Field g;
    private static boolean h;

    static void a(Resources resources) {
        if (VERSION.SDK_INT < 28) {
            if (VERSION.SDK_INT >= 24) {
                d(resources);
            } else if (VERSION.SDK_INT >= 23) {
                c(resources);
            } else {
                if (VERSION.SDK_INT >= 21) {
                    b(resources);
                }
            }
        }
    }

    private static void a(Object obj) {
        if (!d) {
            try {
                c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            d = true;
        }
        if (c != null) {
            if (!f) {
                try {
                    e = c.getDeclaredField("mUnthemedEntries");
                    e.setAccessible(true);
                } catch (Throwable e2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                f = true;
            }
            if (e != null) {
                LongSparseArray longSparseArray;
                try {
                    longSparseArray = (LongSparseArray) e.get(obj);
                } catch (Throwable e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    private static void b(Resources resources) {
        if (!b) {
            try {
                a = Resources.class.getDeclaredField("mDrawableCache");
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            b = true;
        }
        if (a != null) {
            Map map;
            try {
                map = (Map) a.get(resources);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036 A:{RETURN} */
    private static void c(android.content.res.Resources r4) {
        /*
        r0 = b;
        if (r0 != 0) goto L_0x001f;
    L_0x0004:
        r0 = 1;
        r1 = android.content.res.Resources.class;
        r2 = "mDrawableCache";
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0015 }
        a = r1;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r1 = a;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0015 }
        goto L_0x001d;
    L_0x0015:
        r1 = move-exception;
        r2 = "ResourcesFlusher";
        r3 = "Could not retrieve Resources#mDrawableCache field";
        android.util.Log.e(r2, r3, r1);
    L_0x001d:
        b = r0;
    L_0x001f:
        r0 = 0;
        r1 = a;
        if (r1 == 0) goto L_0x0033;
    L_0x0024:
        r1 = a;	 Catch:{ IllegalAccessException -> 0x002b }
        r4 = r1.get(r4);	 Catch:{ IllegalAccessException -> 0x002b }
        goto L_0x0034;
    L_0x002b:
        r4 = move-exception;
        r1 = "ResourcesFlusher";
        r2 = "Could not retrieve value from Resources#mDrawableCache";
        android.util.Log.e(r1, r2, r4);
    L_0x0033:
        r4 = r0;
    L_0x0034:
        if (r4 != 0) goto L_0x0037;
    L_0x0036:
        return;
    L_0x0037:
        a(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.h.c(android.content.res.Resources):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
    private static void d(android.content.res.Resources r5) {
        /*
        r0 = h;
        r1 = 1;
        if (r0 != 0) goto L_0x001f;
    L_0x0005:
        r0 = android.content.res.Resources.class;
        r2 = "mResourcesImpl";
        r0 = r0.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0015 }
        g = r0;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r0 = g;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0015 }
        goto L_0x001d;
    L_0x0015:
        r0 = move-exception;
        r2 = "ResourcesFlusher";
        r3 = "Could not retrieve Resources#mResourcesImpl field";
        android.util.Log.e(r2, r3, r0);
    L_0x001d:
        h = r1;
    L_0x001f:
        r0 = g;
        if (r0 != 0) goto L_0x0024;
    L_0x0023:
        return;
    L_0x0024:
        r0 = 0;
        r2 = g;	 Catch:{ IllegalAccessException -> 0x002c }
        r5 = r2.get(r5);	 Catch:{ IllegalAccessException -> 0x002c }
        goto L_0x0035;
    L_0x002c:
        r5 = move-exception;
        r2 = "ResourcesFlusher";
        r3 = "Could not retrieve value from Resources#mResourcesImpl";
        android.util.Log.e(r2, r3, r5);
        r5 = r0;
    L_0x0035:
        if (r5 != 0) goto L_0x0038;
    L_0x0037:
        return;
    L_0x0038:
        r2 = b;
        if (r2 != 0) goto L_0x0058;
    L_0x003c:
        r2 = r5.getClass();	 Catch:{ NoSuchFieldException -> 0x004e }
        r3 = "mDrawableCache";
        r2 = r2.getDeclaredField(r3);	 Catch:{ NoSuchFieldException -> 0x004e }
        a = r2;	 Catch:{ NoSuchFieldException -> 0x004e }
        r2 = a;	 Catch:{ NoSuchFieldException -> 0x004e }
        r2.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x004e }
        goto L_0x0056;
    L_0x004e:
        r2 = move-exception;
        r3 = "ResourcesFlusher";
        r4 = "Could not retrieve ResourcesImpl#mDrawableCache field";
        android.util.Log.e(r3, r4, r2);
    L_0x0056:
        b = r1;
    L_0x0058:
        r1 = a;
        if (r1 == 0) goto L_0x006b;
    L_0x005c:
        r1 = a;	 Catch:{ IllegalAccessException -> 0x0063 }
        r5 = r1.get(r5);	 Catch:{ IllegalAccessException -> 0x0063 }
        goto L_0x006c;
    L_0x0063:
        r5 = move-exception;
        r1 = "ResourcesFlusher";
        r2 = "Could not retrieve value from ResourcesImpl#mDrawableCache";
        android.util.Log.e(r1, r2, r5);
    L_0x006b:
        r5 = r0;
    L_0x006c:
        if (r5 == 0) goto L_0x0071;
    L_0x006e:
        a(r5);
    L_0x0071:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.h.d(android.content.res.Resources):void");
    }
}
