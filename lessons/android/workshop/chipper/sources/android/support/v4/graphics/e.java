package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.a.a.c;
import android.support.v4.e.b.b;
import android.support.v4.g.l;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

class e extends h {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0045 A:{ExcHandler: java.lang.ClassNotFoundException (r1_2 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Missing block: B:4:0x0045, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0046, code:
            android.util.Log.e("TypefaceCompatApi24Impl", r1.getClass().getName(), r1);
            r1 = null;
            r2 = r1;
            r4 = r2;
     */
    static {
        /*
        r0 = 0;
        r1 = "android.graphics.FontFamily";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r2 = 0;
        r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r3 = r1.getConstructor(r3);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r4 = "addFontWeightStyle";
        r5 = 5;
        r5 = new java.lang.Class[r5];	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = java.nio.ByteBuffer.class;
        r5[r2] = r6;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r7 = 1;
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = 2;
        r8 = java.util.List.class;
        r5[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = 3;
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r5[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = 4;
        r8 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r5[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r4 = r1.getMethod(r4, r5);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r5 = java.lang.reflect.Array.newInstance(r1, r7);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = android.graphics.Typeface.class;
        r8 = "createFromFamiliesWithDefault";
        r7 = new java.lang.Class[r7];	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r5 = r5.getClass();	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r7[r2] = r5;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r2 = r6.getMethod(r8, r7);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r0 = r3;
        goto L_0x0056;
    L_0x0045:
        r1 = move-exception;
        r2 = "TypefaceCompatApi24Impl";
        r3 = r1.getClass();
        r3 = r3.getName();
        android.util.Log.e(r2, r3, r1);
        r1 = r0;
        r2 = r1;
        r4 = r2;
    L_0x0056:
        b = r0;
        a = r1;
        c = r4;
        d = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.e.<clinit>():void");
    }

    e() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0019 A:{ExcHandler: java.lang.IllegalAccessException (r4_4 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x0019, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x001f, code:
            throw new java.lang.RuntimeException(r4);
     */
    private static android.graphics.Typeface a(java.lang.Object r4) {
        /*
        r0 = a;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r1 = 1;
        r0 = java.lang.reflect.Array.newInstance(r0, r1);	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r2 = 0;
        java.lang.reflect.Array.set(r0, r2, r4);	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r4 = d;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r3 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r1[r2] = r0;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r4 = r4.invoke(r3, r1);	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r4 = (android.graphics.Typeface) r4;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        return r4;
    L_0x0019:
        r4 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.e.a(java.lang.Object):android.graphics.Typeface");
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x002c A:{ExcHandler: java.lang.IllegalAccessException (r3_4 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x002c, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0032, code:
            throw new java.lang.RuntimeException(r3);
     */
    private static boolean a(java.lang.Object r3, java.nio.ByteBuffer r4, int r5, int r6, boolean r7) {
        /*
        r0 = c;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1 = 5;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r2 = 0;
        r1[r2] = r4;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 2;
        r5 = 0;
        r1[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 3;
        r5 = java.lang.Integer.valueOf(r6);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 4;
        r5 = java.lang.Boolean.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r3 = r0.invoke(r3, r1);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r3 = (java.lang.Boolean) r3;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r3 = r3.booleanValue();	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        return r3;
    L_0x002c:
        r3 = move-exception;
        r4 = new java.lang.RuntimeException;
        r4.<init>(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.e.a(java.lang.Object, java.nio.ByteBuffer, int, int, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a A:{ExcHandler: java.lang.IllegalAccessException (r0_2 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a A:{ExcHandler: java.lang.IllegalAccessException (r0_2 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x000a, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0010, code:
            throw new java.lang.RuntimeException(r0);
     */
    private static java.lang.Object b() {
        /*
        r0 = b;	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        r0 = r0.newInstance(r1);	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        return r0;
    L_0x000a:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.e.b():java.lang.Object");
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr, int i) {
        Object b = b();
        l lVar = new l();
        for (b bVar : bVarArr) {
            Uri a = bVar.a();
            ByteBuffer byteBuffer = (ByteBuffer) lVar.get(a);
            if (byteBuffer == null) {
                byteBuffer = i.a(context, cancellationSignal, a);
                lVar.put(a, byteBuffer);
            }
            if (!a(b, byteBuffer, bVar.b(), bVar.c(), bVar.d())) {
                return null;
            }
        }
        return Typeface.create(a(b), i);
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        Object b = b();
        for (c.c cVar : bVar.a()) {
            ByteBuffer a = i.a(context, resources, cVar.f());
            if (a == null || !a(b, a, cVar.e(), cVar.b(), cVar.c())) {
                return null;
            }
        }
        return a(b);
    }
}
