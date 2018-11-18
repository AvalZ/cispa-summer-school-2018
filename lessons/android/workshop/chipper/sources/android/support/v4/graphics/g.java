package android.support.v4.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class g extends f {
    /* JADX WARNING: Removed duplicated region for block: B:3:0x002d A:{ExcHandler: java.lang.IllegalAccessException (r4_4 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x002d, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0033, code:
            throw new java.lang.RuntimeException(r4);
     */
    protected android.graphics.Typeface a(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = r4.a;	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r1 = 1;
        r0 = java.lang.reflect.Array.newInstance(r0, r1);	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r2 = 0;
        java.lang.reflect.Array.set(r0, r2, r5);	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r4 = r4.g;	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r5 = 0;
        r3 = 4;
        r3 = new java.lang.Object[r3];	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r3[r2] = r0;	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r0 = "sans-serif";
        r3[r1] = r0;	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r0 = 2;
        r1 = -1;
        r2 = java.lang.Integer.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r3[r0] = r2;	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r0 = 3;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r3[r0] = r1;	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r4 = r4.invoke(r5, r3);	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        r4 = (android.graphics.Typeface) r4;	 Catch:{ IllegalAccessException -> 0x002d, IllegalAccessException -> 0x002d }
        return r4;
    L_0x002d:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r5.<init>(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.g.a(java.lang.Object):android.graphics.Typeface");
    }

    protected Method f(Class cls) {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
