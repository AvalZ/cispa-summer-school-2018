package android.support.v4.a.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.support.a.a.c;
import android.util.AttributeSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class d {

    static final class a {
        final int[] a;
        final float[] b;

        a(int i, int i2) {
            this.a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.a[i] = ((Integer) list.get(i)).intValue();
                this.b[i] = ((Float) list2.get(i)).floatValue();
            }
        }
    }

    private static TileMode a(int i) {
        switch (i) {
            case 1:
                return TileMode.REPEAT;
            case 2:
                return TileMode.MIRROR;
            default:
                return TileMode.CLAMP;
        }
    }

    static Shader a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Theme theme2 = theme;
            TypedArray a = g.a(resources, theme2, attributeSet, c.GradientColor);
            float a2 = g.a(a, xmlPullParser2, "startX", c.GradientColor_android_startX, 0.0f);
            float a3 = g.a(a, xmlPullParser2, "startY", c.GradientColor_android_startY, 0.0f);
            float a4 = g.a(a, xmlPullParser2, "endX", c.GradientColor_android_endX, 0.0f);
            float a5 = g.a(a, xmlPullParser2, "endY", c.GradientColor_android_endY, 0.0f);
            float a6 = g.a(a, xmlPullParser2, "centerX", c.GradientColor_android_centerX, 0.0f);
            float a7 = g.a(a, xmlPullParser2, "centerY", c.GradientColor_android_centerY, 0.0f);
            int a8 = g.a(a, xmlPullParser2, "type", c.GradientColor_android_type, 0);
            int b = g.b(a, xmlPullParser2, "startColor", c.GradientColor_android_startColor, 0);
            boolean a9 = g.a(xmlPullParser2, "centerColor");
            float f = a5;
            int b2 = g.b(a, xmlPullParser2, "centerColor", c.GradientColor_android_centerColor, 0);
            float f2 = a4;
            int b3 = g.b(a, xmlPullParser2, "endColor", c.GradientColor_android_endColor, 0);
            float f3 = a3;
            int a10 = g.a(a, xmlPullParser2, "tileMode", c.GradientColor_android_tileMode, 0);
            float f4 = a2;
            float a11 = g.a(a, xmlPullParser2, "gradientRadius", c.GradientColor_android_gradientRadius, 0.0f);
            a.recycle();
            a a12 = a(b(resources, xmlPullParser, attributeSet, theme), b, b3, a9, b2);
            switch (a8) {
                case 1:
                    if (a11 <= 0.0f) {
                        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                    }
                    int[] iArr = a12.a;
                    return new RadialGradient(a6, a7, a11, iArr, a12.b, a(a10));
                case 2:
                    return new SweepGradient(a6, a7, a12.a, a12.b);
                default:
                    return new LinearGradient(f4, f3, f2, f, a12.a, a12.b, a(a10));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid gradient color tag ");
        stringBuilder.append(name);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        return aVar != null ? aVar : z ? new a(i, i3, i2) : new a(i, i2);
    }

    /* JADX WARNING: Missing block: B:19:0x008a, code:
            throw new org.xmlpull.v1.XmlPullParserException(r10.toString());
     */
    private static android.support.v4.a.a.d.a b(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) {
        /*
        r0 = r9.getDepth();
        r1 = 1;
        r0 = r0 + r1;
        r2 = new java.util.ArrayList;
        r3 = 20;
        r2.<init>(r3);
        r4 = new java.util.ArrayList;
        r4.<init>(r3);
    L_0x0012:
        r3 = r9.next();
        if (r3 == r1) goto L_0x008b;
    L_0x0018:
        r5 = r9.getDepth();
        if (r5 >= r0) goto L_0x0021;
    L_0x001e:
        r6 = 3;
        if (r3 == r6) goto L_0x008b;
    L_0x0021:
        r6 = 2;
        if (r3 == r6) goto L_0x0025;
    L_0x0024:
        goto L_0x0012;
    L_0x0025:
        if (r5 > r0) goto L_0x0012;
    L_0x0027:
        r3 = r9.getName();
        r5 = "item";
        r3 = r3.equals(r5);
        if (r3 != 0) goto L_0x0034;
    L_0x0033:
        goto L_0x0012;
    L_0x0034:
        r3 = android.support.a.a.c.GradientColorItem;
        r3 = android.support.v4.a.a.g.a(r8, r11, r10, r3);
        r5 = android.support.a.a.c.GradientColorItem_android_color;
        r5 = r3.hasValue(r5);
        r6 = android.support.a.a.c.GradientColorItem_android_offset;
        r6 = r3.hasValue(r6);
        if (r5 == 0) goto L_0x006b;
    L_0x0048:
        if (r6 != 0) goto L_0x004b;
    L_0x004a:
        goto L_0x006b;
    L_0x004b:
        r5 = android.support.a.a.c.GradientColorItem_android_color;
        r6 = 0;
        r5 = r3.getColor(r5, r6);
        r6 = android.support.a.a.c.GradientColorItem_android_offset;
        r7 = 0;
        r6 = r3.getFloat(r6, r7);
        r3.recycle();
        r3 = java.lang.Integer.valueOf(r5);
        r4.add(r3);
        r3 = java.lang.Float.valueOf(r6);
        r2.add(r3);
        goto L_0x0012;
    L_0x006b:
        r8 = new org.xmlpull.v1.XmlPullParserException;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r9 = r9.getPositionDescription();
        r10.append(r9);
        r9 = ": <item> tag requires a 'color' attribute and a 'offset' ";
        r10.append(r9);
        r9 = "attribute!";
        r10.append(r9);
        r9 = r10.toString();
        r8.<init>(r9);
        throw r8;
    L_0x008b:
        r8 = r4.size();
        if (r8 <= 0) goto L_0x0097;
    L_0x0091:
        r8 = new android.support.v4.a.a.d$a;
        r8.<init>(r4, r2);
        return r8;
    L_0x0097:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.a.d.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.support.v4.a.a.d$a");
    }
}
