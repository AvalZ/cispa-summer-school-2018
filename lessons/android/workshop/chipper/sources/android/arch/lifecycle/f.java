package android.arch.lifecycle;

import android.arch.lifecycle.c.b;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class f extends c {
    private android.arch.a.b.a<d, a> a = new android.arch.a.b.a();
    private b b;
    private final WeakReference<e> c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<b> g = new ArrayList();

    static class a {
        b a;
        GenericLifecycleObserver b;

        a(d dVar, b bVar) {
            this.b = h.a((Object) dVar);
            this.a = bVar;
        }

        void a(e eVar, android.arch.lifecycle.c.a aVar) {
            b b = f.b(aVar);
            this.a = f.a(this.a, b);
            this.b.a(eVar, aVar);
            this.a = b;
        }
    }

    public f(e eVar) {
        this.c = new WeakReference(eVar);
        this.b = b.INITIALIZED;
    }

    static b a(b bVar, b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void a(e eVar) {
        Iterator c = this.a.c();
        while (c.hasNext() && !this.f) {
            Entry entry = (Entry) c.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.b) < 0 && !this.f && this.a.c(entry.getKey())) {
                c(aVar.a);
                aVar.a(eVar, e(aVar.a));
                c();
            }
        }
    }

    static b b(android.arch.lifecycle.c.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return b.STARTED;
            case ON_RESUME:
                return b.RESUMED;
            case ON_DESTROY:
                return b.DESTROYED;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected event value ");
                stringBuilder.append(aVar);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private void b(b bVar) {
        if (this.b != bVar) {
            this.b = bVar;
            if (this.e || this.d != 0) {
                this.f = true;
                return;
            }
            this.e = true;
            d();
            this.e = false;
        }
    }

    private void b(e eVar) {
        Iterator b = this.a.b();
        while (b.hasNext() && !this.f) {
            Entry entry = (Entry) b.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.b) > 0 && !this.f && this.a.c(entry.getKey())) {
                android.arch.lifecycle.c.a d = d(aVar.a);
                c(b(d));
                aVar.a(eVar, d);
                c();
            }
        }
    }

    private boolean b() {
        if (this.a.a() == 0) {
            return true;
        }
        b bVar = ((a) this.a.d().getValue()).a;
        b bVar2 = ((a) this.a.e().getValue()).a;
        return bVar == bVar2 && this.b == bVar2;
    }

    private b c(d dVar) {
        Entry d = this.a.d(dVar);
        b bVar = null;
        b bVar2 = d != null ? ((a) d.getValue()).a : null;
        if (!this.g.isEmpty()) {
            bVar = (b) this.g.get(this.g.size() - 1);
        }
        return a(a(this.b, bVar2), bVar);
    }

    private void c() {
        this.g.remove(this.g.size() - 1);
    }

    private void c(b bVar) {
        this.g.add(bVar);
    }

    private static android.arch.lifecycle.c.a d(b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return android.arch.lifecycle.c.a.ON_DESTROY;
            case STARTED:
                return android.arch.lifecycle.c.a.ON_STOP;
            case RESUMED:
                return android.arch.lifecycle.c.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append(bVar);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private void d() {
        e eVar = (e) this.c.get();
        if (eVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.b.compareTo(((a) this.a.d().getValue()).a) < 0) {
                b(eVar);
            }
            Entry e = this.a.e();
            if (!(this.f || e == null || this.b.compareTo(((a) e.getValue()).a) <= 0)) {
                a(eVar);
            }
        }
        this.f = false;
    }

    private static android.arch.lifecycle.c.a e(b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return android.arch.lifecycle.c.a.ON_CREATE;
            case CREATED:
                return android.arch.lifecycle.c.a.ON_START;
            case STARTED:
                return android.arch.lifecycle.c.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append(bVar);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public b a() {
        return this.b;
    }

    public void a(android.arch.lifecycle.c.a aVar) {
        b(b(aVar));
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(d dVar) {
        a aVar = new a(dVar, this.b == b.DESTROYED ? b.DESTROYED : b.INITIALIZED);
        if (((a) this.a.a(dVar, aVar)) == null) {
            e eVar = (e) this.c.get();
            if (eVar != null) {
                int i = (this.d != 0 || this.e) ? 1 : 0;
                Enum c = c(dVar);
                this.d++;
                while (aVar.a.compareTo(c) < 0 && this.a.c(dVar)) {
                    c(aVar.a);
                    aVar.a(eVar, e(aVar.a));
                    c();
                    c = c(dVar);
                }
                if (i == 0) {
                    d();
                }
                this.d--;
            }
        }
    }

    public void b(d dVar) {
        this.a.b(dVar);
    }
}
