package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Entry<K, V>> {
    private c<K, V> a;
    private c<K, V> b;
    private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap();
    private int d = 0;

    static class c<K, V> implements Entry<K, V> {
        final K a;
        final V b;
        c<K, V> c;
        c<K, V> d;

        c(K k, V v) {
            this.a = k;
            this.b = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.b.equals(cVar.b);
        }

        public K getKey() {
            return this.a;
        }

        public V getValue() {
            return this.b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("=");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }
    }

    interface f<K, V> {
        void a_(c<K, V> cVar);
    }

    private class d implements f<K, V>, Iterator<Entry<K, V>> {
        private c<K, V> b;
        private boolean c;

        private d() {
            this.c = true;
        }

        /* renamed from: a */
        public Entry<K, V> next() {
            c a;
            if (this.c) {
                this.c = false;
                a = b.this.a;
            } else {
                a = this.b != null ? this.b.c : null;
            }
            this.b = a;
            return this.b;
        }

        public void a_(c<K, V> cVar) {
            if (cVar == this.b) {
                this.b = this.b.d;
                this.c = this.b == null;
            }
        }

        public boolean hasNext() {
            boolean z = false;
            if (this.c) {
                if (b.this.a != null) {
                    z = true;
                }
                return z;
            }
            if (!(this.b == null || this.b.c == null)) {
                z = true;
            }
            return z;
        }
    }

    private static abstract class e<K, V> implements f<K, V>, Iterator<Entry<K, V>> {
        c<K, V> a;
        c<K, V> b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        private c<K, V> b() {
            return (this.b == this.a || this.a == null) ? null : a(this.b);
        }

        abstract c<K, V> a(c<K, V> cVar);

        /* renamed from: a */
        public Entry<K, V> next() {
            Entry entry = this.b;
            this.b = b();
            return entry;
        }

        public void a_(c<K, V> cVar) {
            if (this.a == cVar && cVar == this.b) {
                this.b = null;
                this.a = null;
            }
            if (this.a == cVar) {
                this.a = b(this.a);
            }
            if (this.b == cVar) {
                this.b = b();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        public boolean hasNext() {
            return this.b != null;
        }
    }

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        c<K, V> a(c<K, V> cVar) {
            return cVar.c;
        }

        c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }
    }

    private static class b<K, V> extends e<K, V> {
        b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        c<K, V> a(c<K, V> cVar) {
            return cVar.d;
        }

        c<K, V> b(c<K, V> cVar) {
            return cVar.c;
        }
    }

    public int a() {
        return this.d;
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.a;
        while (cVar != null && !cVar.a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public V a(K k, V v) {
        c a = a((Object) k);
        if (a != null) {
            return a.b;
        }
        b(k, v);
        return null;
    }

    protected c<K, V> b(K k, V v) {
        c<K, V> cVar = new c(k, v);
        this.d++;
        if (this.b == null) {
            this.a = cVar;
            this.b = this.a;
            return cVar;
        }
        this.b.c = cVar;
        cVar.d = this.b;
        this.b = cVar;
        return cVar;
    }

    public V b(K k) {
        c a = a((Object) k);
        if (a == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            for (f a_ : this.c.keySet()) {
                a_.a_(a);
            }
        }
        if (a.d != null) {
            a.d.c = a.c;
        } else {
            this.a = a.c;
        }
        if (a.c != null) {
            a.c.d = a.d;
        } else {
            this.b = a.d;
        }
        a.c = null;
        a.d = null;
        return a.b;
    }

    public Iterator<Entry<K, V>> b() {
        Iterator bVar = new b(this.b, this.a);
        this.c.put(bVar, Boolean.valueOf(false));
        return bVar;
    }

    public d c() {
        d dVar = new d();
        this.c.put(dVar, Boolean.valueOf(false));
        return dVar;
    }

    public Entry<K, V> d() {
        return this.a;
    }

    public Entry<K, V> e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != bVar.a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Iterator<Entry<K, V>> iterator() {
        Iterator aVar = new a(this.a, this.b);
        this.c.put(aVar, Boolean.valueOf(false));
        return aVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
