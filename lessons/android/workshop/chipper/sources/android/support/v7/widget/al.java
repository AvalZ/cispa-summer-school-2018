package android.support.v7.widget;

import android.support.v4.d.c;
import android.support.v7.widget.at.i;
import android.support.v7.widget.at.p;
import android.support.v7.widget.at.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class al implements Runnable {
    static final ThreadLocal<al> a = new ThreadLocal();
    static Comparator<b> e = new Comparator<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            int i = 1;
            if ((bVar.d == null ? 1 : 0) != (bVar2.d == null ? 1 : 0)) {
                return bVar.d == null ? 1 : -1;
            } else {
                if (bVar.a != bVar2.a) {
                    if (bVar.a) {
                        i = -1;
                    }
                    return i;
                }
                int i2 = bVar2.b - bVar.b;
                if (i2 != 0) {
                    return i2;
                }
                i2 = bVar.c - bVar2.c;
                return i2 != 0 ? i2 : 0;
            }
        }
    };
    ArrayList<at> b = new ArrayList();
    long c;
    long d;
    private ArrayList<b> f = new ArrayList();

    static class b {
        public boolean a;
        public int b;
        public int c;
        public at d;
        public int e;

        b() {
        }

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    static class a implements android.support.v7.widget.at.i.a {
        int a;
        int b;
        int[] c;
        int d;

        a() {
        }

        void a() {
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            this.d = 0;
        }

        void a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        void a(at atVar, boolean z) {
            this.d = 0;
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            i iVar = atVar.m;
            if (atVar.l != null && iVar != null && iVar.p()) {
                if (z) {
                    if (!atVar.e.d()) {
                        iVar.a(atVar.l.a(), (android.support.v7.widget.at.i.a) this);
                    }
                } else if (!atVar.v()) {
                    iVar.a(this.a, this.b, atVar.C, (android.support.v7.widget.at.i.a) this);
                }
                if (this.d > iVar.x) {
                    iVar.x = this.d;
                    iVar.y = z;
                    atVar.d.b();
                }
            }
        }

        boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            } else {
                int i3 = this.d * 2;
                if (this.c == null) {
                    this.c = new int[4];
                    Arrays.fill(this.c, -1);
                } else if (i3 >= this.c.length) {
                    Object obj = this.c;
                    this.c = new int[(i3 * 2)];
                    System.arraycopy(obj, 0, this.c, 0, obj.length);
                }
                this.c[i3] = i;
                this.c[i3 + 1] = i2;
                this.d++;
            }
        }
    }

    al() {
    }

    private x a(at atVar, int i, long j) {
        if (a(atVar, i)) {
            return null;
        }
        p pVar = atVar.d;
        try {
            atVar.l();
            x a = pVar.a(i, false, j);
            if (a != null) {
                if (!a.p() || a.n()) {
                    pVar.a(a, false);
                } else {
                    pVar.a(a.a);
                }
            }
            atVar.b(false);
            return a;
        } catch (Throwable th) {
            atVar.b(false);
        }
    }

    private void a() {
        at atVar;
        int size = this.b.size();
        int i = 0;
        int i2 = i;
        while (i < size) {
            atVar = (at) this.b.get(i);
            if (atVar.getWindowVisibility() == 0) {
                atVar.B.a(atVar, false);
                i2 += atVar.B.d;
            }
            i++;
        }
        this.f.ensureCapacity(i2);
        i = 0;
        i2 = i;
        while (i < size) {
            atVar = (at) this.b.get(i);
            if (atVar.getWindowVisibility() == 0) {
                a aVar = atVar.B;
                int abs = Math.abs(aVar.a) + Math.abs(aVar.b);
                int i3 = i2;
                for (i2 = 0; i2 < aVar.d * 2; i2 += 2) {
                    b bVar;
                    if (i3 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = (b) this.f.get(i3);
                    }
                    int i4 = aVar.c[i2 + 1];
                    bVar.a = i4 <= abs;
                    bVar.b = abs;
                    bVar.c = i4;
                    bVar.d = atVar;
                    bVar.e = aVar.c[i2];
                    i3++;
                }
                i2 = i3;
            }
            i++;
        }
        Collections.sort(this.f, e);
    }

    private void a(b bVar, long j) {
        x a = a(bVar.d, bVar.e, bVar.a ? Long.MAX_VALUE : j);
        if (a != null && a.b != null && a.p() && !a.n()) {
            a((at) a.b.get(), j);
        }
    }

    private void a(at atVar, long j) {
        if (atVar != null) {
            if (atVar.w && atVar.f.c() != 0) {
                atVar.c();
            }
            a aVar = atVar.B;
            aVar.a(atVar, true);
            if (aVar.d != 0) {
                try {
                    c.a("RV Nested Prefetch");
                    atVar.C.a(atVar.l);
                    for (int i = 0; i < aVar.d * 2; i += 2) {
                        a(atVar, aVar.c[i], j);
                    }
                } finally {
                    c.a();
                }
            }
        }
    }

    static boolean a(at atVar, int i) {
        int c = atVar.f.c();
        for (int i2 = 0; i2 < c; i2++) {
            x e = at.e(atVar.f.d(i2));
            if (e.c == i && !e.n()) {
                return true;
            }
        }
        return false;
    }

    private void b(long j) {
        int i = 0;
        while (i < this.f.size()) {
            b bVar = (b) this.f.get(i);
            if (bVar.d != null) {
                a(bVar, j);
                bVar.a();
                i++;
            } else {
                return;
            }
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    public void a(at atVar) {
        this.b.add(atVar);
    }

    void a(at atVar, int i, int i2) {
        if (atVar.isAttachedToWindow() && this.c == 0) {
            this.c = atVar.getNanoTime();
            atVar.post(this);
        }
        atVar.B.a(i, i2);
    }

    public void b(at atVar) {
        this.b.remove(atVar);
    }

    public void run() {
        try {
            c.a("RV Prefetch");
            if (!this.b.isEmpty()) {
                int size = this.b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    at atVar = (at) this.b.get(i);
                    if (atVar.getWindowVisibility() == 0) {
                        j = Math.max(atVar.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
                    this.c = 0;
                    c.a();
                    return;
                }
            }
            this.c = 0;
            c.a();
        } catch (Throwable th) {
            this.c = 0;
            c.a();
        }
    }
}
