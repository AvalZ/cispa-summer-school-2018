package android.support.v4.g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] c = new int[0];
    private static final Object[] d = new Object[0];
    private static Object[] e;
    private static int f;
    private static Object[] g;
    private static int h;
    Object[] a;
    int b;
    private int[] i;
    private h<E, E> j;

    public b() {
        this(0);
    }

    public b(int i) {
        if (i == 0) {
            this.i = c;
            this.a = d;
        } else {
            d(i);
        }
        this.b = 0;
    }

    private int a() {
        int i = this.b;
        if (i == 0) {
            return -1;
        }
        int a = c.a(this.i, i, 0);
        if (a < 0 || this.a[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.i[i2] == 0) {
            if (this.a[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.i[a] == 0) {
            if (this.a[a] == null) {
                return a;
            }
            a--;
        }
        return ~i2;
    }

    private int a(Object obj, int i) {
        int i2 = this.b;
        if (i2 == 0) {
            return -1;
        }
        int a = c.a(this.i, i2, i);
        if (a < 0 || obj.equals(this.a[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.i[i3] == i) {
            if (obj.equals(this.a[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.i[a] == i) {
            if (obj.equals(this.a[a])) {
                return a;
            }
            a--;
        }
        return ~i3;
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (h < 10) {
                    objArr[0] = g;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    g = objArr;
                    h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    e = objArr;
                    f++;
                }
            }
        }
    }

    private h<E, E> b() {
        if (this.j == null) {
            this.j = new h<E, E>() {
                protected int a() {
                    return b.this.b;
                }

                protected int a(Object obj) {
                    return b.this.a(obj);
                }

                protected Object a(int i, int i2) {
                    return b.this.a[i];
                }

                protected E a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                protected void a(int i) {
                    b.this.c(i);
                }

                protected void a(E e, E e2) {
                    b.this.add(e);
                }

                protected int b(Object obj) {
                    return b.this.a(obj);
                }

                protected Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                protected void c() {
                    b.this.clear();
                }
            };
        }
        return this.j;
    }

    private void d(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (b.class) {
                if (g != null) {
                    objArr = g;
                    this.a = objArr;
                    g = (Object[]) objArr[0];
                    this.i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    h--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (b.class) {
                if (e != null) {
                    objArr = e;
                    this.a = objArr;
                    e = (Object[]) objArr[0];
                    this.i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f--;
                    return;
                }
            }
        }
        this.i = new int[i];
        this.a = new Object[i];
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public void a(int i) {
        if (this.i.length < i) {
            Object obj = this.i;
            Object obj2 = this.a;
            d(i);
            if (this.b > 0) {
                System.arraycopy(obj, 0, this.i, 0, this.b);
                System.arraycopy(obj2, 0, this.a, 0, this.b);
            }
            a(obj, obj2, this.b);
        }
    }

    public boolean add(E e) {
        int a;
        boolean z;
        if (e == null) {
            a = a();
            z = false;
        } else {
            boolean hashCode = e.hashCode();
            z = hashCode;
            a = a(e, hashCode);
        }
        if (a >= 0) {
            return false;
        }
        int i;
        a = ~a;
        if (this.b >= this.i.length) {
            i = 4;
            if (this.b >= 8) {
                i = (this.b >> 1) + this.b;
            } else if (this.b >= 4) {
                i = 8;
            }
            Object obj = this.i;
            Object obj2 = this.a;
            d(i);
            if (this.i.length > 0) {
                System.arraycopy(obj, 0, this.i, 0, obj.length);
                System.arraycopy(obj2, 0, this.a, 0, obj2.length);
            }
            a(obj, obj2, this.b);
        }
        if (a < this.b) {
            i = a + 1;
            System.arraycopy(this.i, a, this.i, i, this.b - a);
            System.arraycopy(this.a, a, this.a, i, this.b - a);
        }
        this.i[a] = z;
        this.a[a] = e;
        this.b++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        a(this.b + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public E b(int i) {
        return this.a[i];
    }

    public E c(int i) {
        E e = this.a[i];
        if (this.b <= 1) {
            a(this.i, this.a, this.b);
            this.i = c;
            this.a = d;
            this.b = 0;
            return e;
        }
        int i2 = 8;
        int i3;
        if (this.i.length <= 8 || this.b >= this.i.length / 3) {
            this.b--;
            if (i < this.b) {
                i3 = i + 1;
                System.arraycopy(this.i, i3, this.i, i, this.b - i);
                System.arraycopy(this.a, i3, this.a, i, this.b - i);
            }
            this.a[this.b] = null;
        } else {
            if (this.b > 8) {
                i2 = (this.b >> 1) + this.b;
            }
            Object obj = this.i;
            Object obj2 = this.a;
            d(i2);
            this.b--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.i, 0, i);
                System.arraycopy(obj2, 0, this.a, 0, i);
            }
            if (i < this.b) {
                i3 = i + 1;
                System.arraycopy(obj, i3, this.i, i, this.b - i);
                System.arraycopy(obj2, i3, this.a, i, this.b - i);
                return e;
            }
        }
        return e;
    }

    public void clear() {
        if (this.b != 0) {
            a(this.i, this.a, this.b);
            this.i = c;
            this.a = d;
            this.b = 0;
        }
    }

    public boolean contains(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a A:{RETURN, ExcHandler: java.lang.NullPointerException (unused java.lang.NullPointerException), Splitter: B:9:0x0017} */
    /* JADX WARNING: Missing block: B:17:0x002a, code:
            return false;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x002a;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();
        r3 = r5.size();
        if (r1 == r3) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r2;
    L_0x0017:
        r3 = r4.b;	 Catch:{ NullPointerException -> 0x002a, NullPointerException -> 0x002a }
        if (r1 >= r3) goto L_0x0029;
    L_0x001b:
        r3 = r4.b(r1);	 Catch:{ NullPointerException -> 0x002a, NullPointerException -> 0x002a }
        r3 = r5.contains(r3);	 Catch:{ NullPointerException -> 0x002a, NullPointerException -> 0x002a }
        if (r3 != 0) goto L_0x0026;
    L_0x0025:
        return r2;
    L_0x0026:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x0029:
        return r0;
    L_0x002a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int[] iArr = this.i;
        int i = 0;
        int i2 = 0;
        while (i < this.b) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public boolean isEmpty() {
        return this.b <= 0;
    }

    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    public boolean remove(Object obj) {
        int a = a(obj);
        if (a < 0) {
            return false;
        }
        c(a);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.b - 1; i >= 0; i--) {
            if (!collection.contains(this.a[i])) {
                c(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.b;
    }

    public Object[] toArray() {
        Object obj = new Object[this.b];
        System.arraycopy(this.a, 0, obj, 0, this.b);
        return obj;
    }

    public <T> T[] toArray(T[] tArr) {
        Object tArr2;
        if (tArr2.length < this.b) {
            tArr2 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), this.b);
        }
        System.arraycopy(this.a, 0, tArr2, 0, this.b);
        if (tArr2.length > this.b) {
            tArr2[this.b] = null;
        }
        return tArr2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.b * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.b; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            b b = b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
