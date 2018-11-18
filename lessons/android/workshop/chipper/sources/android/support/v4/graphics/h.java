package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.a.a.c.b;
import android.support.v4.a.a.c.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class h {

    private interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    h() {
    }

    private c a(b bVar, int i) {
        return (c) a(bVar.a(), i, new a<c>() {
            /* renamed from: a */
            public int b(c cVar) {
                return cVar.b();
            }

            /* renamed from: b */
            public boolean a(c cVar) {
                return cVar.c();
            }
        });
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        T t = null;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.b(t2) - i2) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a = i.a(context);
        if (a == null) {
            return null;
        }
        try {
            if (i.a(a, resources, i)) {
                Typeface createFromFile = Typeface.createFromFile(a.getPath());
                a.delete();
                return createFromFile;
            }
            a.delete();
            return null;
        } catch (RuntimeException unused) {
            a.delete();
            return null;
        } catch (Throwable th) {
            a.delete();
            throw th;
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, android.support.v4.e.b.b[] bVarArr, int i) {
        Throwable th;
        Closeable closeable = null;
        if (bVarArr.length < 1) {
            return null;
        }
        Closeable openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(a(bVarArr, i).a());
            try {
                Typeface a = a(context, (InputStream) openInputStream);
                i.a(openInputStream);
                return a;
            } catch (IOException unused) {
                i.a(openInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                closeable = openInputStream;
                i.a(closeable);
                throw th;
            }
        } catch (IOException unused2) {
            openInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            i.a(closeable);
            throw th;
        }
    }

    public Typeface a(Context context, b bVar, Resources resources, int i) {
        c a = a(bVar, i);
        return a == null ? null : c.a(context, resources, a.f(), a.a(), i);
    }

    protected Typeface a(Context context, InputStream inputStream) {
        File a = i.a(context);
        if (a == null) {
            return null;
        }
        try {
            if (i.a(a, inputStream)) {
                Typeface createFromFile = Typeface.createFromFile(a.getPath());
                a.delete();
                return createFromFile;
            }
            a.delete();
            return null;
        } catch (RuntimeException unused) {
            a.delete();
            return null;
        } catch (Throwable th) {
            a.delete();
            throw th;
        }
    }

    protected android.support.v4.e.b.b a(android.support.v4.e.b.b[] bVarArr, int i) {
        return (android.support.v4.e.b.b) a(bVarArr, i, new a<android.support.v4.e.b.b>() {
            /* renamed from: a */
            public int b(android.support.v4.e.b.b bVar) {
                return bVar.c();
            }

            /* renamed from: b */
            public boolean a(android.support.v4.e.b.b bVar) {
                return bVar.d();
            }
        });
    }
}
