package android.support.v7.widget;

import android.support.v7.widget.at.f;
import android.support.v7.widget.at.f.c;
import android.support.v7.widget.at.x;
import android.view.View;

public abstract class az extends f {
    boolean h = true;

    public final void a(x xVar, boolean z) {
        d(xVar, z);
        f(xVar);
    }

    public abstract boolean a(x xVar);

    public abstract boolean a(x xVar, int i, int i2, int i3, int i4);

    public boolean a(x xVar, c cVar, c cVar2) {
        int i = cVar.a;
        int i2 = cVar.b;
        View view = xVar.a;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (xVar.q() || (i == left && i2 == top)) {
            return a(xVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(xVar, i, i2, left, top);
    }

    public abstract boolean a(x xVar, x xVar2, int i, int i2, int i3, int i4);

    public boolean a(x xVar, x xVar2, c cVar, c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        if (xVar2.c()) {
            int i5 = cVar.a;
            i = cVar.b;
            i2 = i5;
        } else {
            i2 = cVar2.a;
            i = cVar2.b;
        }
        return a(xVar, xVar2, i3, i4, i2, i);
    }

    public final void b(x xVar, boolean z) {
        c(xVar, z);
    }

    public abstract boolean b(x xVar);

    public boolean b(x xVar, c cVar, c cVar2) {
        if (cVar == null || (cVar.a == cVar2.a && cVar.b == cVar2.b)) {
            return b(xVar);
        }
        return a(xVar, cVar.a, cVar.b, cVar2.a, cVar2.b);
    }

    public void c(x xVar, boolean z) {
    }

    public boolean c(x xVar, c cVar, c cVar2) {
        if (cVar.a == cVar2.a && cVar.b == cVar2.b) {
            j(xVar);
            return false;
        }
        return a(xVar, cVar.a, cVar.b, cVar2.a, cVar2.b);
    }

    public void d(x xVar, boolean z) {
    }

    public boolean h(x xVar) {
        return !this.h || xVar.n();
    }

    public final void i(x xVar) {
        p(xVar);
        f(xVar);
    }

    public final void j(x xVar) {
        t(xVar);
        f(xVar);
    }

    public final void k(x xVar) {
        r(xVar);
        f(xVar);
    }

    public final void l(x xVar) {
        o(xVar);
    }

    public final void m(x xVar) {
        s(xVar);
    }

    public final void n(x xVar) {
        q(xVar);
    }

    public void o(x xVar) {
    }

    public void p(x xVar) {
    }

    public void q(x xVar) {
    }

    public void r(x xVar) {
    }

    public void s(x xVar) {
    }

    public void t(x xVar) {
    }
}
