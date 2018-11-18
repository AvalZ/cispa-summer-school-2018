package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class i {
    private final j<?> a;

    private i(j<?> jVar) {
        this.a = jVar;
    }

    public static i a(j<?> jVar) {
        return new i(jVar);
    }

    public f a(String str) {
        return this.a.b.b(str);
    }

    public k a() {
        return this.a.i();
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.b.onCreateView(view, str, context, attributeSet);
    }

    public void a(Configuration configuration) {
        this.a.b.a(configuration);
    }

    public void a(Parcelable parcelable, m mVar) {
        this.a.b.a(parcelable, mVar);
    }

    public void a(f fVar) {
        this.a.b.a(this.a, this.a, fVar);
    }

    public void a(boolean z) {
        this.a.b.a(z);
    }

    public boolean a(Menu menu) {
        return this.a.b.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.b.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.b.a(menuItem);
    }

    public void b() {
        this.a.b.l();
    }

    public void b(Menu menu) {
        this.a.b.b(menu);
    }

    public void b(boolean z) {
        this.a.b.b(z);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.b.b(menuItem);
    }

    public Parcelable c() {
        return this.a.b.k();
    }

    public m d() {
        return this.a.b.i();
    }

    public void e() {
        this.a.b.m();
    }

    public void f() {
        this.a.b.n();
    }

    public void g() {
        this.a.b.o();
    }

    public void h() {
        this.a.b.p();
    }

    public void i() {
        this.a.b.q();
    }

    public void j() {
        this.a.b.r();
    }

    public void k() {
        this.a.b.t();
    }

    public void l() {
        this.a.b.u();
    }

    public boolean m() {
        return this.a.b.f();
    }
}
