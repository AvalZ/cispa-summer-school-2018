package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class d extends DataSetObservable {
    static final String a = "d";
    private static final Object e = new Object();
    private static final Map<String, d> f = new HashMap();
    final Context b;
    final String c;
    boolean d;
    private final Object g;
    private final List<a> h;
    private final List<c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    public static final class a implements Comparable<a> {
        public final ResolveInfo a;
        public float b;

        public a(ResolveInfo resolveInfo) {
            this.a = resolveInfo;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.b) - Float.floatToIntBits(this.b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.b) == Float.floatToIntBits(((a) obj).b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:");
            stringBuilder.append(this.a.toString());
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal((double) this.b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface b {
        void a(Intent intent, List<a> list, List<c> list2);
    }

    public static final class c {
        public final ComponentName a;
        public final long b;
        public final float c;

        public c(ComponentName componentName, long j, float f) {
            this.a = componentName;
            this.b = j;
            this.c = f;
        }

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.a == null) {
                if (cVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(cVar.a)) {
                return false;
            }
            return this.b == cVar.b && Float.floatToIntBits(this.c) == Float.floatToIntBits(cVar.c);
        }

        public int hashCode() {
            return (((((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:");
            stringBuilder.append(this.a);
            stringBuilder.append("; time:");
            stringBuilder.append(this.b);
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal((double) this.c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface d {
        boolean a(d dVar, Intent intent);
    }

    private final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX WARNING: Missing block: B:10:0x006f, code:
            if (r4 != null) goto L_0x0071;
     */
        /* JADX WARNING: Missing block: B:12:?, code:
            r4.close();
     */
        /* JADX WARNING: Missing block: B:13:0x0074, code:
            return null;
     */
        /* JADX WARNING: Missing block: B:19:0x0096, code:
            if (r4 == null) goto L_0x00dd;
     */
        /* JADX WARNING: Missing block: B:24:0x00b8, code:
            if (r4 == null) goto L_0x00dd;
     */
        /* JADX WARNING: Missing block: B:29:0x00da, code:
            if (r4 == null) goto L_0x00dd;
     */
        /* JADX WARNING: Missing block: B:30:0x00dd, code:
            return null;
     */
        /* renamed from: a */
        public java.lang.Void doInBackground(java.lang.Object... r12) {
            /*
            r11 = this;
            r0 = 0;
            r1 = r12[r0];
            r1 = (java.util.List) r1;
            r2 = 1;
            r12 = r12[r2];
            r12 = (java.lang.String) r12;
            r3 = 0;
            r4 = android.support.v7.widget.d.this;	 Catch:{ FileNotFoundException -> 0x00e8 }
            r4 = r4.b;	 Catch:{ FileNotFoundException -> 0x00e8 }
            r4 = r4.openFileOutput(r12, r0);	 Catch:{ FileNotFoundException -> 0x00e8 }
            r12 = android.util.Xml.newSerializer();
            r12.setOutput(r4, r3);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r5 = "UTF-8";
            r6 = java.lang.Boolean.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.startDocument(r5, r6);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r5 = "historical-records";
            r12.startTag(r3, r5);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r5 = r1.size();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r6 = r0;
        L_0x002d:
            if (r6 >= r5) goto L_0x0063;
        L_0x002f:
            r7 = r1.remove(r0);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r7 = (android.support.v7.widget.d.c) r7;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r8 = "historical-record";
            r12.startTag(r3, r8);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r8 = "activity";
            r9 = r7.a;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r9 = r9.flattenToString();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.attribute(r3, r8, r9);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r8 = "time";
            r9 = r7.b;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r9 = java.lang.String.valueOf(r9);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.attribute(r3, r8, r9);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r8 = "weight";
            r7 = r7.c;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r7 = java.lang.String.valueOf(r7);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.attribute(r3, r8, r7);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r7 = "historical-record";
            r12.endTag(r3, r7);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r6 = r6 + 1;
            goto L_0x002d;
        L_0x0063:
            r0 = "historical-records";
            r12.endTag(r3, r0);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.endDocument();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r11 = android.support.v7.widget.d.this;
            r11.d = r2;
            if (r4 == 0) goto L_0x00dd;
        L_0x0071:
            r4.close();	 Catch:{ IOException -> 0x00dd }
            return r3;
        L_0x0075:
            r12 = move-exception;
            goto L_0x00de;
        L_0x0077:
            r12 = move-exception;
            r0 = android.support.v7.widget.d.a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1.<init>();	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r5 = android.support.v7.widget.d.this;	 Catch:{ all -> 0x0075 }
            r5 = r5.c;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r11 = android.support.v7.widget.d.this;
            r11.d = r2;
            if (r4 == 0) goto L_0x00dd;
        L_0x0098:
            goto L_0x0071;
        L_0x0099:
            r12 = move-exception;
            r0 = android.support.v7.widget.d.a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1.<init>();	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r5 = android.support.v7.widget.d.this;	 Catch:{ all -> 0x0075 }
            r5 = r5.c;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r11 = android.support.v7.widget.d.this;
            r11.d = r2;
            if (r4 == 0) goto L_0x00dd;
        L_0x00ba:
            goto L_0x0071;
        L_0x00bb:
            r12 = move-exception;
            r0 = android.support.v7.widget.d.a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1.<init>();	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r5 = android.support.v7.widget.d.this;	 Catch:{ all -> 0x0075 }
            r5 = r5.c;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r11 = android.support.v7.widget.d.this;
            r11.d = r2;
            if (r4 == 0) goto L_0x00dd;
        L_0x00dc:
            goto L_0x0071;
        L_0x00dd:
            return r3;
        L_0x00de:
            r11 = android.support.v7.widget.d.this;
            r11.d = r2;
            if (r4 == 0) goto L_0x00e7;
        L_0x00e4:
            r4.close();	 Catch:{ IOException -> 0x00e7 }
        L_0x00e7:
            throw r12;
        L_0x00e8:
            r11 = move-exception;
            r0 = android.support.v7.widget.d.a;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Error writing historical record file: ";
            r1.append(r2);
            r1.append(r12);
            r12 = r1.toString();
            android.util.Log.e(r0, r12, r11);
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.d.e.a(java.lang.Object[]):java.lang.Void");
        }
    }

    private boolean a(c cVar) {
        boolean add = this.i.add(cVar);
        if (add) {
            this.n = true;
            h();
            c();
            e();
            notifyChanged();
        }
        return add;
    }

    private void c() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.n) {
            this.n = false;
            if (!TextUtils.isEmpty(this.c)) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.i), this.c});
            }
        }
    }

    private void d() {
        int f = f() | g();
        h();
        if (f != 0) {
            e();
            notifyChanged();
        }
    }

    private boolean e() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean f() {
        int i = 0;
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List queryIntentActivities = this.b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        while (i < size) {
            this.h.add(new a((ResolveInfo) queryIntentActivities.get(i)));
            i++;
        }
        return true;
    }

    private boolean g() {
        if (!this.d || !this.n || TextUtils.isEmpty(this.c)) {
            return false;
        }
        this.d = false;
        this.m = true;
        i();
        return true;
    }

    private void h() {
        int size = this.i.size() - this.l;
        if (size > 0) {
            this.n = true;
            for (int i = 0; i < size; i++) {
                c cVar = (c) this.i.remove(0);
            }
        }
    }

    /* JADX WARNING: Missing block: B:16:0x003c, code:
            if (r0 == null) goto L_0x00bb;
     */
    /* JADX WARNING: Missing block: B:36:0x009c, code:
            if (r0 == null) goto L_0x00bb;
     */
    /* JADX WARNING: Missing block: B:39:0x00b8, code:
            if (r0 == null) goto L_0x00bb;
     */
    private void i() {
        /*
        r9 = this;
        r0 = r9.b;	 Catch:{ FileNotFoundException -> 0x00c2 }
        r1 = r9.c;	 Catch:{ FileNotFoundException -> 0x00c2 }
        r0 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x00c2 }
        r1 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r2 = "UTF-8";
        r1.setInput(r0, r2);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r2 = 0;
    L_0x0012:
        r3 = 1;
        if (r2 == r3) goto L_0x001d;
    L_0x0015:
        r4 = 2;
        if (r2 == r4) goto L_0x001d;
    L_0x0018:
        r2 = r1.next();	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        goto L_0x0012;
    L_0x001d:
        r2 = "historical-records";
        r4 = r1.getName();	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r2 = r2.equals(r4);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        if (r2 != 0) goto L_0x0031;
    L_0x0029:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r2 = "Share records file does not start with historical-records tag.";
        r1.<init>(r2);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        throw r1;	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
    L_0x0031:
        r2 = r9.i;	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r2.clear();	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
    L_0x0036:
        r4 = r1.next();	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        if (r4 != r3) goto L_0x0042;
    L_0x003c:
        if (r0 == 0) goto L_0x00bb;
    L_0x003e:
        r0.close();	 Catch:{ IOException -> 0x00bb }
        return;
    L_0x0042:
        r5 = 3;
        if (r4 == r5) goto L_0x0036;
    L_0x0045:
        r5 = 4;
        if (r4 != r5) goto L_0x0049;
    L_0x0048:
        goto L_0x0036;
    L_0x0049:
        r4 = r1.getName();	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r5 = "historical-record";
        r4 = r5.equals(r4);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        if (r4 != 0) goto L_0x005d;
    L_0x0055:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r2 = "Share records file not well-formed.";
        r1.<init>(r2);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        throw r1;	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
    L_0x005d:
        r4 = "activity";
        r5 = 0;
        r4 = r1.getAttributeValue(r5, r4);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r6 = "time";
        r6 = r1.getAttributeValue(r5, r6);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r6 = java.lang.Long.parseLong(r6);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r8 = "weight";
        r5 = r1.getAttributeValue(r5, r8);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r5 = java.lang.Float.parseFloat(r5);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r8 = new android.support.v7.widget.d$c;	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r8.<init>(r4, r6, r5);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        r2.add(r8);	 Catch:{ XmlPullParserException -> 0x009f, IOException -> 0x0083 }
        goto L_0x0036;
    L_0x0081:
        r9 = move-exception;
        goto L_0x00bc;
    L_0x0083:
        r1 = move-exception;
        r2 = a;	 Catch:{ all -> 0x0081 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r3.<init>();	 Catch:{ all -> 0x0081 }
        r4 = "Error reading historical recrod file: ";
        r3.append(r4);	 Catch:{ all -> 0x0081 }
        r9 = r9.c;	 Catch:{ all -> 0x0081 }
        r3.append(r9);	 Catch:{ all -> 0x0081 }
        r9 = r3.toString();	 Catch:{ all -> 0x0081 }
        android.util.Log.e(r2, r9, r1);	 Catch:{ all -> 0x0081 }
        if (r0 == 0) goto L_0x00bb;
    L_0x009e:
        goto L_0x003e;
    L_0x009f:
        r1 = move-exception;
        r2 = a;	 Catch:{ all -> 0x0081 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r3.<init>();	 Catch:{ all -> 0x0081 }
        r4 = "Error reading historical recrod file: ";
        r3.append(r4);	 Catch:{ all -> 0x0081 }
        r9 = r9.c;	 Catch:{ all -> 0x0081 }
        r3.append(r9);	 Catch:{ all -> 0x0081 }
        r9 = r3.toString();	 Catch:{ all -> 0x0081 }
        android.util.Log.e(r2, r9, r1);	 Catch:{ all -> 0x0081 }
        if (r0 == 0) goto L_0x00bb;
    L_0x00ba:
        goto L_0x003e;
    L_0x00bb:
        return;
    L_0x00bc:
        if (r0 == 0) goto L_0x00c1;
    L_0x00be:
        r0.close();	 Catch:{ IOException -> 0x00c1 }
    L_0x00c1:
        throw r9;
    L_0x00c2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.d.i():void");
    }

    public int a() {
        int size;
        synchronized (this.g) {
            d();
            size = this.h.size();
        }
        return size;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            d();
            List list = this.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            d();
            resolveInfo = ((a) this.h.get(i)).a;
        }
        return resolveInfo;
    }

    public Intent b(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            d();
            a aVar = (a) this.h.get(i);
            ComponentName componentName = new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            d();
            if (this.h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.h.get(0)).a;
            return resolveInfo;
        }
    }

    public void c(int i) {
        synchronized (this.g) {
            d();
            a aVar = (a) this.h.get(i);
            a aVar2 = (a) this.h.get(0);
            a(new c(new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.b - aVar.b) + 5.0f : 1.0f));
        }
    }
}
