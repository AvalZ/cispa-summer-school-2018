package android.support.v4.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class c {

    public interface a {
    }

    public static final class c {
        private final String a;
        private int b;
        private boolean c;
        private String d;
        private int e;
        private int f;

        public c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = str2;
            this.e = i2;
            this.f = i3;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }
    }

    public static final class b implements a {
        private final c[] a;

        public b(c[] cVarArr) {
            this.a = cVarArr;
        }

        public c[] a() {
            return this.a;
        }
    }

    public static final class d implements a {
        private final android.support.v4.e.a a;
        private final int b;
        private final int c;

        public d(android.support.v4.e.a aVar, int i, int i2) {
            this.a = aVar;
            this.c = i;
            this.b = i2;
        }

        public android.support.v4.e.a a() {
            return this.a;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        if (VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000d  */
    public static android.support.v4.a.a.c.a a(org.xmlpull.v1.XmlPullParser r3, android.content.res.Resources r4) {
        /*
    L_0x0000:
        r0 = r3.next();
        r1 = 2;
        if (r0 == r1) goto L_0x000b;
    L_0x0007:
        r2 = 1;
        if (r0 == r2) goto L_0x000b;
    L_0x000a:
        goto L_0x0000;
    L_0x000b:
        if (r0 == r1) goto L_0x0015;
    L_0x000d:
        r3 = new org.xmlpull.v1.XmlPullParserException;
        r4 = "No start tag found";
        r3.<init>(r4);
        throw r3;
    L_0x0015:
        r3 = b(r3, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.a.c.a(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):android.support.v4.a.a.c$a");
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                List<List<byte[]>> emptyList = Collections.emptyList();
                return emptyList;
            }
            List<List<byte[]>> arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (i = 0; i < obtainTypedArray.length(); i++) {
                    int resourceId = obtainTypedArray.getResourceId(i, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        List<byte[]> arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), android.support.a.a.c.FontFamily);
        String string = obtainAttributes.getString(android.support.a.a.c.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(android.support.a.a.c.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(android.support.a.a.c.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(android.support.a.a.c.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(android.support.a.a.c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(android.support.a.a.c.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            List arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(d(xmlPullParser, resources));
                    } else {
                        a(xmlPullParser);
                    }
                }
            }
            return arrayList.isEmpty() ? null : new b((c[]) arrayList.toArray(new c[arrayList.size()]));
        } else {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new android.support.v4.e.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
    }

    private static c d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), android.support.a.a.c.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(android.support.a.a.c.FontFamilyFont_fontWeight) ? android.support.a.a.c.FontFamilyFont_fontWeight : android.support.a.a.c.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(android.support.a.a.c.FontFamilyFont_fontStyle) ? android.support.a.a.c.FontFamilyFont_fontStyle : android.support.a.a.c.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(android.support.a.a.c.FontFamilyFont_ttcIndex) ? android.support.a.a.c.FontFamilyFont_ttcIndex : android.support.a.a.c.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(android.support.a.a.c.FontFamilyFont_fontVariationSettings) ? android.support.a.a.c.FontFamilyFont_fontVariationSettings : android.support.a.a.c.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        i2 = obtainAttributes.hasValue(android.support.a.a.c.FontFamilyFont_font) ? android.support.a.a.c.FontFamilyFont_font : android.support.a.a.c.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i2, 0);
        String string2 = obtainAttributes.getString(i2);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new c(string2, i, z, string, i3, resourceId);
    }
}
