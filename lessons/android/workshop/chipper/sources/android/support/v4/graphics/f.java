package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.a.a.c;
import android.support.v4.e.b.b;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class f extends d {
    protected final Class a;
    protected final Constructor b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0022 A:{ExcHandler: java.lang.ClassNotFoundException (r1_1 'e' java.lang.Throwable), Splitter: B:1:0x0004} */
    /* JADX WARNING: Missing block: B:4:0x0022, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0023, code:
            r3 = new java.lang.StringBuilder();
            r3.append("Unable to collect necessary methods for class ");
            r3.append(r1.getClass().getName());
            android.util.Log.e("TypefaceCompatApi26Impl", r3.toString(), r1);
            r2 = null;
            r3 = r2;
            r4 = r3;
            r5 = r4;
            r6 = r5;
            r7 = r6;
     */
    public f() {
        /*
        r8 = this;
        r8.<init>();
        r0 = 0;
        r1 = r8.a();	 Catch:{ ClassNotFoundException -> 0x0022, ClassNotFoundException -> 0x0022 }
        r2 = r8.a(r1);	 Catch:{ ClassNotFoundException -> 0x0022, ClassNotFoundException -> 0x0022 }
        r3 = r8.b(r1);	 Catch:{ ClassNotFoundException -> 0x0022, ClassNotFoundException -> 0x0022 }
        r4 = r8.c(r1);	 Catch:{ ClassNotFoundException -> 0x0022, ClassNotFoundException -> 0x0022 }
        r5 = r8.d(r1);	 Catch:{ ClassNotFoundException -> 0x0022, ClassNotFoundException -> 0x0022 }
        r6 = r8.e(r1);	 Catch:{ ClassNotFoundException -> 0x0022, ClassNotFoundException -> 0x0022 }
        r7 = r8.f(r1);	 Catch:{ ClassNotFoundException -> 0x0022, ClassNotFoundException -> 0x0022 }
        r0 = r1;
        goto L_0x0047;
    L_0x0022:
        r1 = move-exception;
        r2 = "TypefaceCompatApi26Impl";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Unable to collect necessary methods for class ";
        r3.append(r4);
        r4 = r1.getClass();
        r4 = r4.getName();
        r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3, r1);
        r2 = r0;
        r3 = r2;
        r4 = r3;
        r5 = r4;
        r6 = r5;
        r7 = r6;
    L_0x0047:
        r8.a = r0;
        r8.b = r2;
        r8.c = r3;
        r8.d = r4;
        r8.e = r5;
        r8.f = r6;
        r8.g = r7;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.f.<init>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0041 A:{ExcHandler: java.lang.IllegalAccessException (r2_5 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x0041, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0047, code:
            throw new java.lang.RuntimeException(r2);
     */
    private boolean a(android.content.Context r3, java.lang.Object r4, java.lang.String r5, int r6, int r7, int r8, android.graphics.fonts.FontVariationAxis[] r9) {
        /*
        r2 = this;
        r2 = r2.c;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r0 = 8;
        r0 = new java.lang.Object[r0];	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r3 = r3.getAssets();	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r1 = 0;
        r0[r1] = r3;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r3 = 1;
        r0[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r3 = 2;
        r5 = java.lang.Integer.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r0[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r3 = 3;
        r5 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r0[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r3 = 4;
        r5 = java.lang.Integer.valueOf(r6);	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r0[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r3 = 5;
        r5 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r0[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r3 = 6;
        r5 = java.lang.Integer.valueOf(r8);	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r0[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r3 = 7;
        r0[r3] = r9;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r2 = r2.invoke(r4, r0);	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        r2 = r2.booleanValue();	 Catch:{ IllegalAccessException -> 0x0041, IllegalAccessException -> 0x0041 }
        return r2;
    L_0x0041:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.f.a(android.content.Context, java.lang.Object, java.lang.String, int, int, int, android.graphics.fonts.FontVariationAxis[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x002c A:{ExcHandler: java.lang.IllegalAccessException (r2_5 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x002c, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0032, code:
            throw new java.lang.RuntimeException(r2);
     */
    private boolean a(java.lang.Object r3, java.nio.ByteBuffer r4, int r5, int r6, int r7) {
        /*
        r2 = this;
        r2 = r2.d;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r0 = 5;
        r0 = new java.lang.Object[r0];	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1 = 0;
        r0[r1] = r4;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r0[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 2;
        r5 = 0;
        r0[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 3;
        r5 = java.lang.Integer.valueOf(r6);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r0[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 4;
        r5 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r0[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r2 = r2.invoke(r3, r0);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r2 = (java.lang.Boolean) r2;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r2 = r2.booleanValue();	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        return r2;
    L_0x002c:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.f.a(java.lang.Object, java.nio.ByteBuffer, int, int, int):boolean");
    }

    private boolean b() {
        if (this.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010 A:{ExcHandler: java.lang.IllegalAccessException (r1_5 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x0010, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0016, code:
            throw new java.lang.RuntimeException(r1);
     */
    private boolean b(java.lang.Object r2) {
        /*
        r1 = this;
        r1 = r1.e;	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        r0 = 0;
        r0 = new java.lang.Object[r0];	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        r1 = r1.invoke(r2, r0);	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        r1 = r1.booleanValue();	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        return r1;
    L_0x0010:
        r1 = move-exception;
        r2 = new java.lang.RuntimeException;
        r2.<init>(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.f.b(java.lang.Object):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a A:{ExcHandler: java.lang.IllegalAccessException (r1_3 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a A:{ExcHandler: java.lang.IllegalAccessException (r1_3 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x000a, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0010, code:
            throw new java.lang.RuntimeException(r1);
     */
    private java.lang.Object c() {
        /*
        r1 = this;
        r1 = r1.b;	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        r0 = 0;
        r0 = new java.lang.Object[r0];	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        r1 = r1.newInstance(r0);	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        return r1;
    L_0x000a:
        r1 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.f.c():java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0009 A:{ExcHandler: java.lang.IllegalAccessException (r1_2 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x0009, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x000f, code:
            throw new java.lang.RuntimeException(r1);
     */
    private void c(java.lang.Object r2) {
        /*
        r1 = this;
        r1 = r1.f;	 Catch:{ IllegalAccessException -> 0x0009, IllegalAccessException -> 0x0009 }
        r0 = 0;
        r0 = new java.lang.Object[r0];	 Catch:{ IllegalAccessException -> 0x0009, IllegalAccessException -> 0x0009 }
        r1.invoke(r2, r0);	 Catch:{ IllegalAccessException -> 0x0009, IllegalAccessException -> 0x0009 }
        return;
    L_0x0009:
        r1 = move-exception;
        r2 = new java.lang.RuntimeException;
        r2.<init>(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.f.c(java.lang.Object):void");
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object c = c();
        if (a(context, c, str, 0, -1, -1, null)) {
            return !b(c) ? null : a(c);
        } else {
            c(c);
            return null;
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        Throwable th2;
        if (bVarArr.length < 1) {
            return null;
        }
        if (b()) {
            Map a = android.support.v4.e.b.a(context, bVarArr, cancellationSignal);
            Object c = c();
            Object obj = null;
            for (b bVar : bVarArr) {
                ByteBuffer byteBuffer = (ByteBuffer) a.get(bVar.a());
                if (byteBuffer != null) {
                    if (a(c, byteBuffer, bVar.b(), bVar.c(), bVar.d())) {
                        obj = 1;
                    } else {
                        c(c);
                        return null;
                    }
                }
            }
            if (obj != null) {
                return !b(c) ? null : Typeface.create(a(c), i);
            } else {
                c(c);
                return null;
            }
        }
        b a2 = a(bVarArr, i);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.a(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                Typeface build = new Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.c()).setItalic(a2.d()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
        } catch (IOException unused) {
            return null;
        }
        if (openFileDescriptor != null) {
            if (th22 != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th4) {
                    th22.addSuppressed(th4);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th;
        throw th;
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        if (!b()) {
            return super.a(context, bVar, resources, i);
        }
        Object c = c();
        c.c[] a = bVar.a();
        i = a.length;
        int i2 = 0;
        while (i2 < i) {
            c.c cVar = a[i2];
            if (a(context, c, cVar.a(), cVar.e(), cVar.b(), cVar.c(), FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                i2++;
            } else {
                c(c);
                return null;
            }
        }
        return !b(c) ? null : a(c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0028 A:{ExcHandler: java.lang.IllegalAccessException (r4_4 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Missing block: B:3:0x0028, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x002e, code:
            throw new java.lang.RuntimeException(r4);
     */
    protected android.graphics.Typeface a(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = r4.a;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r1 = 1;
        r0 = java.lang.reflect.Array.newInstance(r0, r1);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r2 = 0;
        java.lang.reflect.Array.set(r0, r2, r5);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r4 = r4.g;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r5 = 0;
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r3[r2] = r0;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r0 = -1;
        r2 = java.lang.Integer.valueOf(r0);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r3[r1] = r2;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r1 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r3[r1] = r0;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r4 = r4.invoke(r5, r3);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r4 = (android.graphics.Typeface) r4;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        return r4;
    L_0x0028:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r5.<init>(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.f.a(java.lang.Object):android.graphics.Typeface");
    }

    protected Class a() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor a(Class cls) {
        return cls.getConstructor(new Class[0]);
    }

    protected Method b(Class cls) {
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    protected Method c(Class cls) {
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    protected Method d(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    protected Method e(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method f(Class cls) {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
