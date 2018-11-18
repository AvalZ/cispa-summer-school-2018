package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.h.r;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.View;

class g {
    private final View a;
    private final l b;
    private int c = -1;
    private be d;
    private be e;
    private be f;

    g(View view) {
        this.a = view;
        this.b = l.a();
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new be();
        }
        be beVar = this.f;
        beVar.a();
        ColorStateList q = r.q(this.a);
        if (q != null) {
            beVar.d = true;
            beVar.a = q;
        }
        Mode r = r.r(this.a);
        if (r != null) {
            beVar.c = true;
            beVar.b = r;
        }
        if (!beVar.d && !beVar.c) {
            return false;
        }
        l.a(drawable, beVar, this.a.getDrawableState());
        return true;
    }

    private boolean d() {
        int i = VERSION.SDK_INT;
        boolean z = false;
        if (i <= 21) {
            return i == 21;
        } else {
            if (this.d != null) {
                z = true;
            }
            return z;
        }
    }

    ColorStateList a() {
        return this.e != null ? this.e.a : null;
    }

    void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
        c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new be();
        }
        this.e.a = colorStateList;
        this.e.d = true;
        c();
    }

    void a(Mode mode) {
        if (this.e == null) {
            this.e = new be();
        }
        this.e.b = mode;
        this.e.c = true;
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b(null);
        c();
    }

    void a(AttributeSet attributeSet, int i) {
        bg a = bg.a(this.a.getContext(), attributeSet, j.ViewBackgroundHelper, i, 0);
        try {
            if (a.g(j.ViewBackgroundHelper_android_background)) {
                this.c = a.g(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.a.getContext(), this.c);
                if (b != null) {
                    b(b);
                }
            }
            if (a.g(j.ViewBackgroundHelper_backgroundTint)) {
                r.a(this.a, a.e(j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.g(j.ViewBackgroundHelper_backgroundTintMode)) {
                r.a(this.a, ag.a(a.a(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    Mode b() {
        return this.e != null ? this.e.b : null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new be();
            }
            this.d.a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    void c() {
        Drawable background = this.a.getBackground();
        if (background != null && (!d() || !b(background))) {
            be beVar;
            if (this.e != null) {
                beVar = this.e;
            } else {
                if (this.d != null) {
                    beVar = this.d;
                }
                return;
            }
            l.a(background, beVar, this.a.getDrawableState());
        }
    }
}
