package android.arch.a.b;

import java.util.HashMap;
import java.util.Map.Entry;

public class a<K, V> extends b<K, V> {
    private HashMap<K, c<K, V>> a = new HashMap();

    protected c<K, V> a(K k) {
        return (c) this.a.get(k);
    }

    public V a(K k, V v) {
        c a = a(k);
        if (a != null) {
            return a.b;
        }
        this.a.put(k, b(k, v));
        return null;
    }

    public V b(K k) {
        V b = super.b(k);
        this.a.remove(k);
        return b;
    }

    public boolean c(K k) {
        return this.a.containsKey(k);
    }

    public Entry<K, V> d(K k) {
        return c(k) ? ((c) this.a.get(k)).d : null;
    }
}
