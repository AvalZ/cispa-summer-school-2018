package android.support.v4.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

public final class f {

    public static abstract class a {
        public abstract void a(int i);

        public final void a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    a.this.a(i);
                }
            });
        }

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    a.this.a(typeface);
                }
            });
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        return context.isRestricted() ? null : a(context, i, typedValue, i2, aVar, null, true);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a = a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a != null || aVar != null) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Font resource ID #0x");
        stringBuilder.append(Integer.toHexString(i));
        stringBuilder.append(" could not be retrieved.");
        throw new NotFoundException(stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    private static android.graphics.Typeface a(android.content.Context r14, android.content.res.Resources r15, android.util.TypedValue r16, int r17, int r18, android.support.v4.a.a.f.a r19, android.os.Handler r20, boolean r21) {
        /*
        r3 = r15;
        r1 = r16;
        r4 = r17;
        r5 = r18;
        r9 = r19;
        r10 = r20;
        r2 = r1.string;
        if (r2 != 0) goto L_0x003e;
    L_0x000f:
        r2 = new android.content.res.Resources$NotFoundException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Resource \"";
        r5.append(r6);
        r3 = r3.getResourceName(r4);
        r5.append(r3);
        r3 = "\" (";
        r5.append(r3);
        r3 = java.lang.Integer.toHexString(r17);
        r5.append(r3);
        r3 = ") is not a Font: ";
        r5.append(r3);
        r5.append(r1);
        r1 = r5.toString();
        r2.<init>(r1);
        throw r2;
    L_0x003e:
        r1 = r1.string;
        r11 = r1.toString();
        r1 = "res/";
        r1 = r11.startsWith(r1);
        r12 = 0;
        r13 = -3;
        if (r1 != 0) goto L_0x0054;
    L_0x004e:
        if (r9 == 0) goto L_0x0053;
    L_0x0050:
        r9.a(r13, r10);
    L_0x0053:
        return r12;
    L_0x0054:
        r1 = android.support.v4.graphics.c.a(r3, r4, r5);
        if (r1 == 0) goto L_0x0060;
    L_0x005a:
        if (r9 == 0) goto L_0x005f;
    L_0x005c:
        r9.a(r1, r10);
    L_0x005f:
        return r1;
    L_0x0060:
        r1 = r11.toLowerCase();	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
        r2 = ".xml";
        r1 = r1.endsWith(r2);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
        if (r1 == 0) goto L_0x008d;
    L_0x006c:
        r1 = r3.getXml(r4);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
        r2 = android.support.v4.a.a.c.a(r1, r3);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
        if (r2 != 0) goto L_0x0083;
    L_0x0076:
        r1 = "ResourcesCompat";
        r2 = "Failed to find font-family tag";
        android.util.Log.e(r1, r2);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
        if (r9 == 0) goto L_0x0082;
    L_0x007f:
        r9.a(r13, r10);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
    L_0x0082:
        return r12;
    L_0x0083:
        r1 = r14;
        r6 = r9;
        r7 = r10;
        r8 = r21;
        r1 = android.support.v4.graphics.c.a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
        return r1;
    L_0x008d:
        r1 = r14;
        r1 = android.support.v4.graphics.c.a(r1, r3, r4, r11, r5);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
        if (r9 == 0) goto L_0x009d;
    L_0x0094:
        if (r1 == 0) goto L_0x009a;
    L_0x0096:
        r9.a(r1, r10);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
        return r1;
    L_0x009a:
        r9.a(r13, r10);	 Catch:{ XmlPullParserException -> 0x00aa, IOException -> 0x009e }
    L_0x009d:
        return r1;
    L_0x009e:
        r0 = move-exception;
        r1 = r0;
        r2 = "ResourcesCompat";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Failed to read xml resource ";
        goto L_0x00b5;
    L_0x00aa:
        r0 = move-exception;
        r1 = r0;
        r2 = "ResourcesCompat";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Failed to parse xml resource ";
    L_0x00b5:
        r3.append(r4);
        r3.append(r11);
        r3 = r3.toString();
        android.util.Log.e(r2, r3, r1);
        if (r9 == 0) goto L_0x00c7;
    L_0x00c4:
        r9.a(r13, r10);
    L_0x00c7:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.a.f.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, android.support.v4.a.a.f$a, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Drawable a(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }
}
