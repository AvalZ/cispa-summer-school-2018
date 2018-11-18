package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.at.i;
import android.support.v7.widget.at.j;
import android.view.View;

public abstract class as {
    protected final i a;
    final Rect b;
    private int c;

    private as(i iVar) {
        this.c = Integer.MIN_VALUE;
        this.b = new Rect();
        this.a = iVar;
    }

    /* synthetic */ as(i iVar, AnonymousClass1 anonymousClass1) {
        this(iVar);
    }

    public static as a(i iVar) {
        return new as(iVar) {
            public int a(View view) {
                return this.a.h(view) - ((j) view.getLayoutParams()).leftMargin;
            }

            public void a(int i) {
                this.a.i(i);
            }

            public int b(View view) {
                return this.a.j(view) + ((j) view.getLayoutParams()).rightMargin;
            }

            public int c() {
                return this.a.A();
            }

            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.right;
            }

            public int d() {
                return this.a.y() - this.a.C();
            }

            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.left;
            }

            public int e() {
                return this.a.y();
            }

            public int e(View view) {
                j jVar = (j) view.getLayoutParams();
                return (this.a.f(view) + jVar.leftMargin) + jVar.rightMargin;
            }

            public int f() {
                return (this.a.y() - this.a.A()) - this.a.C();
            }

            public int f(View view) {
                j jVar = (j) view.getLayoutParams();
                return (this.a.g(view) + jVar.topMargin) + jVar.bottomMargin;
            }

            public int g() {
                return this.a.C();
            }

            public int h() {
                return this.a.w();
            }

            public int i() {
                return this.a.x();
            }
        };
    }

    public static as a(i iVar, int i) {
        switch (i) {
            case 0:
                return a(iVar);
            case 1:
                return b(iVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static as b(i iVar) {
        return new as(iVar) {
            public int a(View view) {
                return this.a.i(view) - ((j) view.getLayoutParams()).topMargin;
            }

            public void a(int i) {
                this.a.j(i);
            }

            public int b(View view) {
                return this.a.k(view) + ((j) view.getLayoutParams()).bottomMargin;
            }

            public int c() {
                return this.a.B();
            }

            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.bottom;
            }

            public int d() {
                return this.a.z() - this.a.D();
            }

            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.top;
            }

            public int e() {
                return this.a.z();
            }

            public int e(View view) {
                j jVar = (j) view.getLayoutParams();
                return (this.a.g(view) + jVar.topMargin) + jVar.bottomMargin;
            }

            public int f() {
                return (this.a.z() - this.a.B()) - this.a.D();
            }

            public int f(View view) {
                j jVar = (j) view.getLayoutParams();
                return (this.a.f(view) + jVar.leftMargin) + jVar.rightMargin;
            }

            public int g() {
                return this.a.D();
            }

            public int h() {
                return this.a.x();
            }

            public int i() {
                return this.a.w();
            }
        };
    }

    public abstract int a(View view);

    public void a() {
        this.c = f();
    }

    public abstract void a(int i);

    public int b() {
        return Integer.MIN_VALUE == this.c ? 0 : f() - this.c;
    }

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();
}
