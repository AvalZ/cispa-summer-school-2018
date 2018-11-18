package android.support.v4.g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends l<K, V> implements Map<K, V> {
    h<K, V> a;

    public a(int i) {
        super(i);
    }

    public a(l lVar) {
        super(lVar);
    }

    private h<K, V> b() {
        if (this.a == null) {
            this.a = new h<K, V>() {
                protected int a() {
                    return a.this.h;
                }

                protected int a(Object obj) {
                    return a.this.a(obj);
                }

                protected Object a(int i, int i2) {
                    return a.this.g[(i << 1) + i2];
                }

                protected V a(int i, V v) {
                    return a.this.a(i, (Object) v);
                }

                protected void a(int i) {
                    a.this.d(i);
                }

                protected void a(K k, V v) {
                    a.this.put(k, v);
                }

                protected int b(Object obj) {
                    return a.this.b(obj);
                }

                protected Map<K, V> b() {
                    return a.this;
                }

                protected void c() {
                    a.this.clear();
                }
            };
        }
        return this.a;
    }

    public boolean a(Collection<?> collection) {
        return h.c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return b().d();
    }

    public Set<K> keySet() {
        return b().e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return b().f();
    }
}
