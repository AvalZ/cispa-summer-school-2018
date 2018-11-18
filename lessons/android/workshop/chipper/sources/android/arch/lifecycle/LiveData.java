package android.arch.lifecycle;

import android.arch.a.b.b;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T> {
    private static final Object b = new Object();
    private final Object a = new Object();
    private b<k<T>, a> c = new b();
    private int d = 0;
    private volatile Object e = b;
    private volatile Object f = b;
    private int g = -1;
    private boolean h;
    private boolean i;
    private final Runnable j = new Runnable() {
        public void run() {
            Object b;
            synchronized (LiveData.this.a) {
                b = LiveData.this.f;
                LiveData.this.f = LiveData.b;
            }
            LiveData.this.a(b);
        }
    };

    private abstract class a {
        final k<T> c;
        boolean d;
        int e = -1;

        a(k<T> kVar) {
            this.c = kVar;
        }

        void a(boolean z) {
            if (z != this.d) {
                this.d = z;
                int i = 1;
                int i2 = LiveData.this.d == 0 ? 1 : 0;
                LiveData liveData = LiveData.this;
                int c = liveData.d;
                if (!this.d) {
                    i = -1;
                }
                liveData.d = c + i;
                if (i2 != 0 && this.d) {
                    LiveData.this.b();
                }
                if (LiveData.this.d == 0 && !this.d) {
                    LiveData.this.c();
                }
                if (this.d) {
                    LiveData.this.b(this);
                }
            }
        }

        abstract boolean a();

        boolean a(e eVar) {
            return false;
        }

        void b() {
        }
    }

    class LifecycleBoundObserver extends a implements GenericLifecycleObserver {
        final e a;

        LifecycleBoundObserver(e eVar, k<T> kVar) {
            super(kVar);
            this.a = eVar;
        }

        public void a(e eVar, android.arch.lifecycle.c.a aVar) {
            if (this.a.a().a() == c.b.DESTROYED) {
                LiveData.this.a(this.c);
            } else {
                a(a());
            }
        }

        boolean a() {
            return this.a.a().a().a(c.b.STARTED);
        }

        boolean a(e eVar) {
            return this.a == eVar;
        }

        void b() {
            this.a.a().b(this);
        }
    }

    private void a(a aVar) {
        if (!aVar.d) {
            return;
        }
        if (!aVar.a()) {
            aVar.a(false);
        } else if (aVar.e < this.g) {
            aVar.e = this.g;
            aVar.c.a(this.e);
        }
    }

    private static void a(String str) {
        if (!android.arch.a.a.a.a().b()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot invoke ");
            stringBuilder.append(str);
            stringBuilder.append(" on a background");
            stringBuilder.append(" thread");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void b(a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            a aVar2;
            if (aVar2 == null) {
                Iterator c = this.c.c();
                while (c.hasNext()) {
                    a((a) ((Entry) c.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
            a(aVar2);
            aVar2 = null;
        } while (this.i);
        this.h = false;
    }

    public T a() {
        T t = this.e;
        return t != b ? t : null;
    }

    public void a(e eVar, k<T> kVar) {
        if (eVar.a().a() != c.b.DESTROYED) {
            d lifecycleBoundObserver = new LifecycleBoundObserver(eVar, kVar);
            a aVar = (a) this.c.a(kVar, lifecycleBoundObserver);
            if (aVar != null && !aVar.a(eVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (aVar == null) {
                eVar.a().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(k<T> kVar) {
        a("removeObserver");
        a aVar = (a) this.c.b(kVar);
        if (aVar != null) {
            aVar.b();
            aVar.a(false);
        }
    }

    protected void a(T t) {
        a("setValue");
        this.g++;
        this.e = t;
        b(null);
    }

    protected void b() {
    }

    protected void c() {
    }

    public boolean d() {
        return this.d > 0;
    }
}
