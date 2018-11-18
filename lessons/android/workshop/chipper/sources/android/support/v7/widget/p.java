package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.h;
import android.support.v7.a.a.j;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.widget.ImageView;

public class p {
    private final ImageView a;
    private be b;
    private be c;
    private be d;

    public p(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new be();
        }
        be beVar = this.d;
        beVar.a();
        ColorStateList a = h.a(this.a);
        if (a != null) {
            beVar.d = true;
            beVar.a = a;
        }
        Mode b = h.b(this.a);
        if (b != null) {
            beVar.c = true;
            beVar.b = b;
        }
        if (!beVar.d && !beVar.c) {
            return false;
        }
        l.a(drawable, beVar, this.a.getDrawableState());
        return true;
    }

    private boolean e() {
        int i = VERSION.SDK_INT;
        boolean z = false;
        if (i <= 21) {
            return i == 21;
        } else {
            if (this.b != null) {
                z = true;
            }
            return z;
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = a.b(this.a.getContext(), i);
            if (b != null) {
                ag.a(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable(null);
        }
        d();
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new be();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        d();
    }

    void a(Mode mode) {
        if (this.c == null) {
            this.c = new be();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i) {
        bg a = bg.a(this.a.getContext(), attributeSet, j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null) {
                int g = a.g(j.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    drawable = a.b(this.a.getContext(), g);
                    if (drawable != null) {
                        this.a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                ag.a(drawable);
            }
            if (a.g(j.AppCompatImageView_tint)) {
                h.a(this.a, a.e(j.AppCompatImageView_tint));
            }
            if (a.g(j.AppCompatImageView_tintMode)) {
                h.a(this.a, ag.a(a.a(j.AppCompatImageView_tintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    boolean a() {
        return VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    ColorStateList b() {
        return this.c != null ? this.c.a : null;
    }

    Mode c() {
        return this.c != null ? this.c.b : null;
    }

    void d() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            ag.a(drawable);
        }
        if (drawable != null && (!e() || !a(drawable))) {
            be beVar;
            if (this.c != null) {
                beVar = this.c;
            } else {
                if (this.b != null) {
                    beVar = this.b;
                }
                return;
            }
            l.a(drawable, beVar, this.a.getDrawableState());
        }
    }
}
