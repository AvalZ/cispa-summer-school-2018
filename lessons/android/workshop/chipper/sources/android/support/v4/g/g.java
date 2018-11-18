package android.support.v4.g;

import java.util.LinkedHashMap;
import java.util.Locale;

public class g<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }

    private int c(K k, V v) {
        int b = b(k, v);
        if (b >= 0) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(k);
        stringBuilder.append("=");
        stringBuilder.append(v);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* JADX WARNING: Missing block: B:12:0x0022, code:
            r0 = b(r5);
     */
    /* JADX WARNING: Missing block: B:13:0x0026, code:
            if (r0 != null) goto L_0x002a;
     */
    /* JADX WARNING: Missing block: B:15:0x0029, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:16:0x002a, code:
            monitor-enter(r4);
     */
    /* JADX WARNING: Missing block: B:18:?, code:
            r4.e++;
            r1 = r4.a.put(r5, r0);
     */
    /* JADX WARNING: Missing block: B:19:0x0037, code:
            if (r1 == null) goto L_0x003f;
     */
    /* JADX WARNING: Missing block: B:20:0x0039, code:
            r4.a.put(r5, r1);
     */
    /* JADX WARNING: Missing block: B:21:0x003f, code:
            r4.b += c(r5, r0);
     */
    /* JADX WARNING: Missing block: B:22:0x0048, code:
            monitor-exit(r4);
     */
    /* JADX WARNING: Missing block: B:23:0x0049, code:
            if (r1 == null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:24:0x004b, code:
            a(false, r5, r0, r1);
     */
    /* JADX WARNING: Missing block: B:25:0x004f, code:
            return r1;
     */
    /* JADX WARNING: Missing block: B:26:0x0050, code:
            a(r4.c);
     */
    /* JADX WARNING: Missing block: B:27:0x0055, code:
            return r0;
     */
    public final V a(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r4 = new java.lang.NullPointerException;
        r5 = "key == null";
        r4.<init>(r5);
        throw r4;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.a;	 Catch:{ all -> 0x0059 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r5 = r4.g;	 Catch:{ all -> 0x0059 }
        r5 = r5 + 1;
        r4.g = r5;	 Catch:{ all -> 0x0059 }
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        return r0;
    L_0x001b:
        r0 = r4.h;	 Catch:{ all -> 0x0059 }
        r0 = r0 + 1;
        r4.h = r0;	 Catch:{ all -> 0x0059 }
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        r0 = r4.b(r5);
        if (r0 != 0) goto L_0x002a;
    L_0x0028:
        r4 = 0;
        return r4;
    L_0x002a:
        monitor-enter(r4);
        r1 = r4.e;	 Catch:{ all -> 0x0056 }
        r1 = r1 + 1;
        r4.e = r1;	 Catch:{ all -> 0x0056 }
        r1 = r4.a;	 Catch:{ all -> 0x0056 }
        r1 = r1.put(r5, r0);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x003f;
    L_0x0039:
        r2 = r4.a;	 Catch:{ all -> 0x0056 }
        r2.put(r5, r1);	 Catch:{ all -> 0x0056 }
        goto L_0x0048;
    L_0x003f:
        r2 = r4.b;	 Catch:{ all -> 0x0056 }
        r3 = r4.c(r5, r0);	 Catch:{ all -> 0x0056 }
        r2 = r2 + r3;
        r4.b = r2;	 Catch:{ all -> 0x0056 }
    L_0x0048:
        monitor-exit(r4);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0050;
    L_0x004b:
        r2 = 0;
        r4.a(r2, r5, r0, r1);
        return r1;
    L_0x0050:
        r5 = r4.c;
        r4.a(r5);
        return r0;
    L_0x0056:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0056 }
        throw r5;
    L_0x0059:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.g.a(java.lang.Object):V");
    }

    public final V a(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            put = this.a.put(k, v);
            if (put != null) {
                this.b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        a(this.c);
        return put;
    }

    /* JADX WARNING: Missing block: B:17:0x0052, code:
            return;
     */
    public void a(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.b;	 Catch:{ all -> 0x0072 }
        if (r0 < 0) goto L_0x0053;
    L_0x0005:
        r0 = r4.a;	 Catch:{ all -> 0x0072 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r4.b;	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0053;
    L_0x0012:
        r0 = r4.b;	 Catch:{ all -> 0x0072 }
        if (r0 <= r5) goto L_0x0051;
    L_0x0016:
        r0 = r4.a;	 Catch:{ all -> 0x0072 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0051;
    L_0x001f:
        r0 = r4.a;	 Catch:{ all -> 0x0072 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0072 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0072 }
        r0 = r0.next();	 Catch:{ all -> 0x0072 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0072 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0072 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0072 }
        r2 = r4.a;	 Catch:{ all -> 0x0072 }
        r2.remove(r1);	 Catch:{ all -> 0x0072 }
        r2 = r4.b;	 Catch:{ all -> 0x0072 }
        r3 = r4.c(r1, r0);	 Catch:{ all -> 0x0072 }
        r2 = r2 - r3;
        r4.b = r2;	 Catch:{ all -> 0x0072 }
        r2 = r4.f;	 Catch:{ all -> 0x0072 }
        r3 = 1;
        r2 = r2 + r3;
        r4.f = r2;	 Catch:{ all -> 0x0072 }
        monitor-exit(r4);	 Catch:{ all -> 0x0072 }
        r2 = 0;
        r4.a(r3, r1, r0, r2);
        goto L_0x0000;
    L_0x0051:
        monitor-exit(r4);	 Catch:{ all -> 0x0072 }
        return;
    L_0x0053:
        r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0072 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0072 }
        r0.<init>();	 Catch:{ all -> 0x0072 }
        r1 = r4.getClass();	 Catch:{ all -> 0x0072 }
        r1 = r1.getName();	 Catch:{ all -> 0x0072 }
        r0.append(r1);	 Catch:{ all -> 0x0072 }
        r1 = ".sizeOf() is reporting inconsistent results!";
        r0.append(r1);	 Catch:{ all -> 0x0072 }
        r0 = r0.toString();	 Catch:{ all -> 0x0072 }
        r5.<init>(r0);	 Catch:{ all -> 0x0072 }
        throw r5;	 Catch:{ all -> 0x0072 }
    L_0x0072:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0072 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.g.a(int):void");
    }

    protected void a(boolean z, K k, V v, V v2) {
    }

    protected int b(K k, V v) {
        return 1;
    }

    protected V b(K k) {
        return null;
    }

    public final synchronized String toString() {
        int i;
        i = this.g + this.h;
        i = i != 0 ? (this.g * 100) / i : 0;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i)});
    }
}
