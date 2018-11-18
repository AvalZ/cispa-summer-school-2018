package android.support.v7.view;

import android.support.v4.h.v;
import android.support.v4.h.w;
import android.support.v4.h.x;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
    final ArrayList<v> a = new ArrayList();
    w b;
    private long c = -1;
    private Interpolator d;
    private boolean e;
    private final x f = new x() {
        private boolean b = false;
        private int c = 0;

        void a() {
            this.c = 0;
            this.b = false;
            h.this.b();
        }

        public void a(View view) {
            if (!this.b) {
                this.b = true;
                if (h.this.b != null) {
                    h.this.b.a(null);
                }
            }
        }

        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == h.this.a.size()) {
                if (h.this.b != null) {
                    h.this.b.b(null);
                }
                a();
            }
        }
    };

    public h a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public h a(v vVar) {
        if (!this.e) {
            this.a.add(vVar);
        }
        return this;
    }

    public h a(v vVar, v vVar2) {
        this.a.add(vVar);
        vVar2.b(vVar.a());
        this.a.add(vVar2);
        return this;
    }

    public h a(w wVar) {
        if (!this.e) {
            this.b = wVar;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                v vVar = (v) it.next();
                if (this.c >= 0) {
                    vVar.a(this.c);
                }
                if (this.d != null) {
                    vVar.a(this.d);
                }
                if (this.b != null) {
                    vVar.a(this.f);
                }
                vVar.c();
            }
            this.e = true;
        }
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((v) it.next()).b();
            }
            this.e = false;
        }
    }
}
