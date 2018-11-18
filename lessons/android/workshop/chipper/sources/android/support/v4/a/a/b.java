package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Shader;
import android.util.Log;

public final class b {
    private final Shader a;
    private final ColorStateList b;
    private int c;

    private b(Shader shader, ColorStateList colorStateList, int i) {
        this.a = shader;
        this.b = colorStateList;
        this.c = i;
    }

    static b a(int i) {
        return new b(null, null, i);
    }

    static b a(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static b a(Resources resources, int i, Theme theme) {
        try {
            return b(resources, i, theme);
        } catch (Throwable e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    static b a(Shader shader) {
        return new b(shader, null, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* JADX WARNING: Missing block: B:16:0x0041, code:
            if (r1.equals("gradient") != false) goto L_0x0045;
     */
    private static android.support.v4.a.a.b b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
        r7 = r6.getXml(r7);
        r0 = android.util.Xml.asAttributeSet(r7);
    L_0x0008:
        r1 = r7.next();
        r2 = 1;
        r3 = 2;
        if (r1 == r3) goto L_0x0013;
    L_0x0010:
        if (r1 == r2) goto L_0x0013;
    L_0x0012:
        goto L_0x0008;
    L_0x0013:
        if (r1 == r3) goto L_0x001d;
    L_0x0015:
        r6 = new org.xmlpull.v1.XmlPullParserException;
        r7 = "No start tag found";
        r6.<init>(r7);
        throw r6;
    L_0x001d:
        r1 = r7.getName();
        r3 = -1;
        r4 = r1.hashCode();
        r5 = 89650992; // 0x557f730 float:1.01546526E-35 double:4.42934753E-316;
        if (r4 == r5) goto L_0x003b;
    L_0x002b:
        r2 = 1191572447; // 0x4705f3df float:34291.87 double:5.887150106E-315;
        if (r4 == r2) goto L_0x0031;
    L_0x0030:
        goto L_0x0044;
    L_0x0031:
        r2 = "selector";
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x0044;
    L_0x0039:
        r2 = 0;
        goto L_0x0045;
    L_0x003b:
        r4 = "gradient";
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x0044;
    L_0x0043:
        goto L_0x0045;
    L_0x0044:
        r2 = r3;
    L_0x0045:
        switch(r2) {
            case 0: goto L_0x006f;
            case 1: goto L_0x0066;
            default: goto L_0x0048;
        };
    L_0x0048:
        r6 = new org.xmlpull.v1.XmlPullParserException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r7 = r7.getPositionDescription();
        r8.append(r7);
        r7 = ": unsupported complex color tag ";
        r8.append(r7);
        r8.append(r1);
        r7 = r8.toString();
        r6.<init>(r7);
        throw r6;
    L_0x0066:
        r6 = android.support.v4.a.a.d.a(r6, r7, r0, r8);
        r6 = a(r6);
        return r6;
    L_0x006f:
        r6 = android.support.v4.a.a.a.a(r6, r7, r0, r8);
        r6 = a(r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.a.b.b(android.content.res.Resources, int, android.content.res.Resources$Theme):android.support.v4.a.a.b");
    }

    public Shader a() {
        return this.a;
    }

    public boolean a(int[] iArr) {
        if (d()) {
            int colorForState = this.b.getColorForState(iArr, this.b.getDefaultColor());
            if (colorForState != this.c) {
                this.c = colorForState;
                return true;
            }
        }
        return false;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public boolean c() {
        return this.a != null;
    }

    public boolean d() {
        return this.a == null && this.b != null && this.b.isStateful();
    }

    public boolean e() {
        return c() || this.c != 0;
    }
}
