package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
    private static int a(int i, float f) {
        return (i & 16777215) | (Math.round(((float) Color.alpha(i)) * f) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0011  */
    public static android.content.res.ColorStateList a(android.content.res.Resources r4, org.xmlpull.v1.XmlPullParser r5, android.content.res.Resources.Theme r6) {
        /*
        r0 = android.util.Xml.asAttributeSet(r5);
    L_0x0004:
        r1 = r5.next();
        r2 = 2;
        if (r1 == r2) goto L_0x000f;
    L_0x000b:
        r3 = 1;
        if (r1 == r3) goto L_0x000f;
    L_0x000e:
        goto L_0x0004;
    L_0x000f:
        if (r1 == r2) goto L_0x0019;
    L_0x0011:
        r4 = new org.xmlpull.v1.XmlPullParserException;
        r5 = "No start tag found";
        r4.<init>(r5);
        throw r4;
    L_0x0019:
        r4 = a(r4, r5, r0, r6);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.a.a.a(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return b(resources, xmlPullParser, attributeSet, theme);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid color state list tag ");
        stringBuilder.append(name);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009c  */
    private static android.content.res.ColorStateList b(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) {
        /*
        r0 = r19;
        r1 = r18.getDepth();
        r2 = 1;
        r1 = r1 + r2;
        r3 = 20;
        r3 = new int[r3][];
        r4 = r3.length;
        r4 = new int[r4];
        r5 = 0;
        r6 = r5;
    L_0x0011:
        r7 = r18.next();
        if (r7 == r2) goto L_0x00b2;
    L_0x0017:
        r8 = r18.getDepth();
        if (r8 >= r1) goto L_0x0020;
    L_0x001d:
        r9 = 3;
        if (r7 == r9) goto L_0x00b2;
    L_0x0020:
        r9 = 2;
        if (r7 != r9) goto L_0x00ab;
    L_0x0023:
        if (r8 > r1) goto L_0x00ab;
    L_0x0025:
        r7 = r18.getName();
        r8 = "item";
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x0033;
    L_0x0031:
        goto L_0x00ab;
    L_0x0033:
        r7 = android.support.a.a.c.ColorStateListItem;
        r8 = r17;
        r9 = r20;
        r7 = a(r8, r9, r0, r7);
        r10 = android.support.a.a.c.ColorStateListItem_android_color;
        r11 = -65281; // 0xffffffffffff00ff float:NaN double:NaN;
        r10 = r7.getColor(r10, r11);
        r11 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r12 = android.support.a.a.c.ColorStateListItem_android_alpha;
        r12 = r7.hasValue(r12);
        if (r12 == 0) goto L_0x0057;
    L_0x0050:
        r12 = android.support.a.a.c.ColorStateListItem_android_alpha;
    L_0x0052:
        r11 = r7.getFloat(r12, r11);
        goto L_0x0062;
    L_0x0057:
        r12 = android.support.a.a.c.ColorStateListItem_alpha;
        r12 = r7.hasValue(r12);
        if (r12 == 0) goto L_0x0062;
    L_0x005f:
        r12 = android.support.a.a.c.ColorStateListItem_alpha;
        goto L_0x0052;
    L_0x0062:
        r7.recycle();
        r7 = r19.getAttributeCount();
        r12 = new int[r7];
        r13 = r5;
        r14 = r13;
    L_0x006d:
        if (r13 >= r7) goto L_0x0092;
    L_0x006f:
        r15 = r0.getAttributeNameResource(r13);
        r2 = 16843173; // 0x10101a5 float:2.3694738E-38 double:8.321633E-317;
        if (r15 == r2) goto L_0x008e;
    L_0x0078:
        r2 = 16843551; // 0x101031f float:2.3695797E-38 double:8.32182E-317;
        if (r15 == r2) goto L_0x008e;
    L_0x007d:
        r2 = android.support.a.a.a.alpha;
        if (r15 == r2) goto L_0x008e;
    L_0x0081:
        r2 = r14 + 1;
        r16 = r0.getAttributeBooleanValue(r13, r5);
        if (r16 == 0) goto L_0x008a;
    L_0x0089:
        goto L_0x008b;
    L_0x008a:
        r15 = -r15;
    L_0x008b:
        r12[r14] = r15;
        r14 = r2;
    L_0x008e:
        r13 = r13 + 1;
        r2 = 1;
        goto L_0x006d;
    L_0x0092:
        r2 = android.util.StateSet.trimStateSet(r12, r14);
        r7 = a(r10, r11);
        if (r6 == 0) goto L_0x009d;
    L_0x009c:
        r10 = r2.length;
    L_0x009d:
        r4 = android.support.v4.a.a.e.a(r4, r6, r7);
        r2 = android.support.v4.a.a.e.a(r3, r6, r2);
        r3 = r2;
        r3 = (int[][]) r3;
        r6 = r6 + 1;
        goto L_0x00af;
    L_0x00ab:
        r8 = r17;
        r9 = r20;
    L_0x00af:
        r2 = 1;
        goto L_0x0011;
    L_0x00b2:
        r0 = new int[r6];
        r1 = new int[r6][];
        java.lang.System.arraycopy(r4, r5, r0, r5, r6);
        java.lang.System.arraycopy(r3, r5, r1, r5, r6);
        r2 = new android.content.res.ColorStateList;
        r2.<init>(r1, r0);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.a.a.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }
}
