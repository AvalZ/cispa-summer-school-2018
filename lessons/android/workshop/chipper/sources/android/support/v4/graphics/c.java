package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.a.a.c.a;
import android.support.v4.a.a.c.d;
import android.support.v4.a.a.f;
import android.support.v4.e.b.b;
import android.support.v4.g.g;

public class c {
    private static final h a;
    private static final g<String, Typeface> b = new g(16);

    static {
        h gVar = VERSION.SDK_INT >= 28 ? new g() : VERSION.SDK_INT >= 26 ? new f() : (VERSION.SDK_INT < 24 || !e.a()) ? VERSION.SDK_INT >= 21 ? new d() : new h() : new e();
        a = gVar;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a = a.a(context, resources, i, str, i2);
        if (a != null) {
            b.a(b(resources, i, i2), a);
        }
        return a;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr, int i) {
        return a.a(context, cancellationSignal, bVarArr, i);
    }

    public static Typeface a(Context context, a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface a;
        if (aVar instanceof d) {
            d dVar = (d) aVar;
            boolean z2 = false;
            if (z ? dVar.b() != 0 : aVar2 != null) {
                z2 = true;
            }
            a = android.support.v4.e.b.a(context, dVar.a(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a = a.a(context, (android.support.v4.a.a.c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a != null) {
                    aVar2.a(a, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a != null) {
            b.a(b(resources, i, i2), a);
        }
        return a;
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return (Typeface) b.a(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(i));
        stringBuilder.append("-");
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }
}
