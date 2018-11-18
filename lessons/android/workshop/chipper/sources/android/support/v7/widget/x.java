package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.r;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.widget.SeekBar;

class x extends t {
    private final SeekBar a;
    private Drawable b;
    private ColorStateList c = null;
    private Mode d = null;
    private boolean e = false;
    private boolean f = false;

    x(SeekBar seekBar) {
        super(seekBar);
        this.a = seekBar;
    }

    private void d() {
        if (this.b == null) {
            return;
        }
        if (this.e || this.f) {
            this.b = a.g(this.b.mutate());
            if (this.e) {
                a.a(this.b, this.c);
            }
            if (this.f) {
                a.a(this.b, this.d);
            }
            if (this.b.isStateful()) {
                this.b.setState(this.a.getDrawableState());
            }
        }
    }

    void a(Canvas canvas) {
        if (this.b != null) {
            int max = this.a.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.b.getIntrinsicWidth();
                int intrinsicHeight = this.b.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.b.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight())) / ((float) max);
                intrinsicWidth = canvas.save();
                canvas.translate((float) this.a.getPaddingLeft(), (float) (this.a.getHeight() / 2));
                for (intrinsicHeight = 0; intrinsicHeight <= max; intrinsicHeight++) {
                    this.b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicWidth);
            }
        }
    }

    void a(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.a);
            a.b(drawable, r.e(this.a));
            if (drawable.isStateful()) {
                drawable.setState(this.a.getDrawableState());
            }
            d();
        }
        this.a.invalidate();
    }

    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        bg a = bg.a(this.a.getContext(), attributeSet, j.AppCompatSeekBar, i, 0);
        Drawable b = a.b(j.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.a.setThumb(b);
        }
        a(a.a(j.AppCompatSeekBar_tickMark));
        if (a.g(j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = ag.a(a.a(j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (a.g(j.AppCompatSeekBar_tickMarkTint)) {
            this.c = a.e(j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        a.a();
        d();
    }

    void b() {
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    void c() {
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.a.getDrawableState())) {
            this.a.invalidateDrawable(drawable);
        }
    }
}
