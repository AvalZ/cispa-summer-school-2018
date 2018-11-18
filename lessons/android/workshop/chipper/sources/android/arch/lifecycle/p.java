package android.arch.lifecycle;

import java.util.HashMap;

public class p {
    private final HashMap<String, n> a = new HashMap();

    final n a(String str) {
        return (n) this.a.get(str);
    }

    public final void a() {
        for (n a : this.a.values()) {
            a.a();
        }
        this.a.clear();
    }

    final void a(String str, n nVar) {
        n nVar2 = (n) this.a.put(str, nVar);
        if (nVar2 != null) {
            nVar2.a();
        }
    }
}
