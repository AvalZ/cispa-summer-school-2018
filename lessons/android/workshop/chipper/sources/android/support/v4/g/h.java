package android.support.v4.g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class h<K, V> {
    b b;
    c c;
    e d;

    final class a<T> implements Iterator<T> {
        final int a;
        int b;
        int c;
        boolean d = false;

        a(int i) {
            this.a = i;
            this.b = h.this.a();
        }

        public boolean hasNext() {
            return this.c < this.b;
        }

        public T next() {
            if (hasNext()) {
                T a = h.this.a(this.c, this.a);
                this.c++;
                this.d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.d) {
                this.c--;
                this.b--;
                this.d = false;
                h.this.a(this.c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        b() {
        }

        /* renamed from: a */
        public boolean add(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = h.this.a();
            for (Entry entry : collection) {
                h.this.a(entry.getKey(), entry.getValue());
            }
            return a != h.this.a();
        }

        public void clear() {
            h.this.c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = h.this.a(entry.getKey());
            return a < 0 ? false : c.a(h.this.a(a, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = h.this.a() - 1; a >= 0; a--) {
                Object a2 = h.this.a(a, 0);
                Object a3 = h.this.a(a, 1);
                i += (a2 == null ? 0 : a2.hashCode()) ^ (a3 == null ? 0 : a3.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return h.this.a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return h.this.a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            h.this.c();
        }

        public boolean contains(Object obj) {
            return h.this.a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return h.a(h.this.b(), (Collection) collection);
        }

        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = h.this.a() - 1; a >= 0; a--) {
                Object a2 = h.this.a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return h.this.a() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int a = h.this.a(obj);
            if (a < 0) {
                return false;
            }
            h.this.a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return h.b(h.this.b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return h.c(h.this.b(), collection);
        }

        public int size() {
            return h.this.a();
        }

        public Object[] toArray() {
            return h.this.b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return h.this.a((Object[]) tArr, 0);
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int a;
        int b;
        boolean c = false;

        d() {
            this.a = h.this.a() - 1;
            this.b = -1;
        }

        /* renamed from: a */
        public Entry<K, V> next() {
            if (hasNext()) {
                this.b++;
                this.c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (this.c) {
                boolean z = false;
                if (!(obj instanceof Entry)) {
                    return false;
                }
                Entry entry = (Entry) obj;
                if (c.a(entry.getKey(), h.this.a(this.b, 0)) && c.a(entry.getValue(), h.this.a(this.b, 1))) {
                    z = true;
                }
                return z;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public K getKey() {
            if (this.c) {
                return h.this.a(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.c) {
                return h.this.a(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.b < this.a;
        }

        public int hashCode() {
            if (this.c) {
                int i = 0;
                Object a = h.this.a(this.b, 0);
                Object a2 = h.this.a(this.b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return hashCode ^ i;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.c) {
                h.this.a(this.b);
                this.b--;
                this.a--;
                this.c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.c) {
                return h.this.a(this.b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getKey());
            stringBuilder.append("=");
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            h.this.c();
        }

        public boolean contains(Object obj) {
            return h.this.b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return h.this.a() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int b = h.this.b(obj);
            if (b < 0) {
                return false;
            }
            h.this.a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int a = h.this.a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (collection.contains(h.this.a(i, 1))) {
                    h.this.a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int a = h.this.a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (!collection.contains(h.this.a(i, 1))) {
                    h.this.a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return h.this.a();
        }

        public Object[] toArray() {
            return h.this.b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return h.this.a((Object[]) tArr, 1);
        }
    }

    h() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e A:{RETURN, ExcHandler: java.lang.NullPointerException (unused java.lang.NullPointerException), Splitter: B:6:0x000b} */
    /* JADX WARNING: Missing block: B:14:0x001e, code:
            return false;
     */
    public static <T> boolean a(java.util.Set<T> r4, java.lang.Object r5) {
        /*
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x001e;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();	 Catch:{ NullPointerException -> 0x001e, NullPointerException -> 0x001e }
        r3 = r5.size();	 Catch:{ NullPointerException -> 0x001e, NullPointerException -> 0x001e }
        if (r1 != r3) goto L_0x001c;
    L_0x0015:
        r4 = r4.containsAll(r5);	 Catch:{ NullPointerException -> 0x001e, NullPointerException -> 0x001e }
        if (r4 == 0) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        r0 = r2;
        return r0;
    L_0x001e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.h.a(java.util.Set, java.lang.Object):boolean");
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    public <T> T[] a(T[] tArr, int i) {
        int a = a();
        if (tArr.length < a) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > a) {
            tArr[a] = null;
        }
        return tArr;
    }

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    public Object[] b(int i) {
        int a = a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    protected abstract void c();

    public Set<Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new b();
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new c();
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new e();
        }
        return this.d;
    }
}
