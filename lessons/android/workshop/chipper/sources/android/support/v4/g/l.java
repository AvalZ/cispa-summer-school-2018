package android.support.v4.g;

import java.util.ConcurrentModificationException;

public class l<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public l() {
        this.f = c.a;
        this.g = c.c;
        this.h = 0;
    }

    public l(int i) {
        if (i == 0) {
            this.f = c.a;
            this.g = c.c;
        } else {
            e(i);
        }
        this.h = 0;
    }

    public l(l<K, V> lVar) {
        this();
        if (lVar != null) {
            a((l) lVar);
        }
    }

    private static int a(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (c < 10) {
                    objArr[0] = b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    b = objArr;
                    c++;
                }
            }
        }
    }

    private void e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (a.class) {
                if (d != null) {
                    objArr = d;
                    this.g = objArr;
                    d = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (b != null) {
                    objArr = b;
                    this.g = objArr;
                    b = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[(i << 1)];
    }

    int a() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int a = a(this.f, i, 0);
        if (a < 0 || this.g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f[i2] == 0) {
            if (this.g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f[a] == 0) {
            if (this.g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return ~i2;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    int a(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a = a(this.f, i2, i);
        if (a < 0 || obj.equals(this.g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f[i3] == i) {
            if (obj.equals(this.g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f[a] == i) {
            if (obj.equals(this.g[a << 1])) {
                return a;
            }
            a--;
        }
        return ~i3;
    }

    public V a(int i, V v) {
        i = (i << 1) + 1;
        V v2 = this.g[i];
        this.g[i] = v;
        return v2;
    }

    public void a(int i) {
        int i2 = this.h;
        if (this.f.length < i) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            e(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void a(l<? extends K, ? extends V> lVar) {
        int i = lVar.h;
        a(this.h + i);
        int i2 = 0;
        if (this.h != 0) {
            while (i2 < i) {
                put(lVar.b(i2), lVar.c(i2));
                i2++;
            }
        } else if (i > 0) {
            System.arraycopy(lVar.f, 0, this.f, 0, i);
            System.arraycopy(lVar.g, 0, this.g, 0, i << 1);
            this.h = i;
        }
    }

    int b(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
        } else {
            for (int i3 = 1; i3 < i; i3 += 2) {
                if (obj.equals(objArr[i3])) {
                    return i3 >> 1;
                }
            }
        }
        return -1;
    }

    public K b(int i) {
        return this.g[i << 1];
    }

    public V c(int i) {
        return this.g[(i << 1) + 1];
    }

    public void clear() {
        if (this.h > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            int i = this.h;
            this.f = c.a;
            this.g = c.c;
            this.h = 0;
            a(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i) {
        int i2 = i << 1;
        V v = this.g[i2 + 1];
        int i3 = this.h;
        int i4 = 0;
        if (i3 <= 1) {
            a(this.f, this.g, i3);
            this.f = c.a;
            this.g = c.c;
        } else {
            int i5 = i3 - 1;
            int i6 = 8;
            if (this.f.length <= 8 || this.h >= this.f.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(this.f, i7, this.f, i, i8);
                    System.arraycopy(this.g, i7 << 1, this.g, i2, i8 << 1);
                }
                i2 = i5 << 1;
                this.g[i2] = null;
                this.g[i2 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                Object obj = this.f;
                Object obj2 = this.g;
                e(i6);
                if (i3 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(obj, 0, this.f, 0, i);
                    System.arraycopy(obj2, 0, this.g, 0, i2);
                }
                if (i < i5) {
                    i4 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(obj, i4, this.f, i, i9);
                    System.arraycopy(obj2, i4 << 1, this.g, i2, i9 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.h) {
            throw new ConcurrentModificationException();
        }
        this.h = i4;
        return v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A:{RETURN, ExcHandler: java.lang.NullPointerException (unused java.lang.NullPointerException), Splitter: B:9:0x0017} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0076 A:{RETURN, ExcHandler: java.lang.NullPointerException (unused java.lang.NullPointerException), Splitter: B:30:0x0050} */
    /* JADX WARNING: Missing block: B:23:0x003d, code:
            return false;
     */
    /* JADX WARNING: Missing block: B:44:0x0076, code:
            return false;
     */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r7 instanceof android.support.v4.g.l;
        r2 = 0;
        if (r1 == 0) goto L_0x003e;
    L_0x0009:
        r7 = (android.support.v4.g.l) r7;
        r1 = r6.size();
        r3 = r7.size();
        if (r1 == r3) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r2;
    L_0x0017:
        r3 = r6.h;	 Catch:{ NullPointerException -> 0x003d, NullPointerException -> 0x003d }
        if (r1 >= r3) goto L_0x003c;
    L_0x001b:
        r3 = r6.b(r1);	 Catch:{ NullPointerException -> 0x003d, NullPointerException -> 0x003d }
        r4 = r6.c(r1);	 Catch:{ NullPointerException -> 0x003d, NullPointerException -> 0x003d }
        r5 = r7.get(r3);	 Catch:{ NullPointerException -> 0x003d, NullPointerException -> 0x003d }
        if (r4 != 0) goto L_0x0032;
    L_0x0029:
        if (r5 != 0) goto L_0x0031;
    L_0x002b:
        r3 = r7.containsKey(r3);	 Catch:{ NullPointerException -> 0x003d, NullPointerException -> 0x003d }
        if (r3 != 0) goto L_0x0039;
    L_0x0031:
        return r2;
    L_0x0032:
        r3 = r4.equals(r5);	 Catch:{ NullPointerException -> 0x003d, NullPointerException -> 0x003d }
        if (r3 != 0) goto L_0x0039;
    L_0x0038:
        return r2;
    L_0x0039:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x003c:
        return r0;
    L_0x003d:
        return r2;
    L_0x003e:
        r1 = r7 instanceof java.util.Map;
        if (r1 == 0) goto L_0x0076;
    L_0x0042:
        r7 = (java.util.Map) r7;
        r1 = r6.size();
        r3 = r7.size();
        if (r1 == r3) goto L_0x004f;
    L_0x004e:
        return r2;
    L_0x004f:
        r1 = r2;
    L_0x0050:
        r3 = r6.h;	 Catch:{ NullPointerException -> 0x0076, NullPointerException -> 0x0076 }
        if (r1 >= r3) goto L_0x0075;
    L_0x0054:
        r3 = r6.b(r1);	 Catch:{ NullPointerException -> 0x0076, NullPointerException -> 0x0076 }
        r4 = r6.c(r1);	 Catch:{ NullPointerException -> 0x0076, NullPointerException -> 0x0076 }
        r5 = r7.get(r3);	 Catch:{ NullPointerException -> 0x0076, NullPointerException -> 0x0076 }
        if (r4 != 0) goto L_0x006b;
    L_0x0062:
        if (r5 != 0) goto L_0x006a;
    L_0x0064:
        r3 = r7.containsKey(r3);	 Catch:{ NullPointerException -> 0x0076, NullPointerException -> 0x0076 }
        if (r3 != 0) goto L_0x0072;
    L_0x006a:
        return r2;
    L_0x006b:
        r3 = r4.equals(r5);	 Catch:{ NullPointerException -> 0x0076, NullPointerException -> 0x0076 }
        if (r3 != 0) goto L_0x0072;
    L_0x0071:
        return r2;
    L_0x0072:
        r1 = r1 + 1;
        goto L_0x0050;
    L_0x0075:
        return r0;
    L_0x0076:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.l.equals(java.lang.Object):boolean");
    }

    public V get(Object obj) {
        int a = a(obj);
        return a >= 0 ? this.g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 1;
        int i3 = 0;
        int i4 = i3;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = this.h;
        if (k == null) {
            a = a();
            i = 0;
        } else {
            a = k.hashCode();
            i = a;
            a = a((Object) k, a);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.g[i3];
            this.g[i3] = v;
            return v2;
        }
        a = ~a;
        if (i2 >= this.f.length) {
            int i4 = 4;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i4 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr = this.g;
            e(i4);
            if (i2 != this.h) {
                throw new ConcurrentModificationException();
            }
            if (this.f.length > 0) {
                System.arraycopy(iArr, 0, this.f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.g, 0, objArr.length);
            }
            a(iArr, objArr, i2);
        }
        if (a < i2) {
            int i5 = a + 1;
            System.arraycopy(this.f, a, this.f, i5, i2 - a);
            System.arraycopy(this.g, a << 1, this.g, i5 << 1, (this.h - a) << 1);
        }
        if (i2 != this.h || a >= this.f.length) {
            throw new ConcurrentModificationException();
        }
        this.f[a] = i;
        int i6 = a << 1;
        this.g[i6] = k;
        this.g[i6 + 1] = v;
        this.h++;
        return null;
    }

    public V remove(Object obj) {
        int a = a(obj);
        return a >= 0 ? d(a) : null;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            l b = b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
