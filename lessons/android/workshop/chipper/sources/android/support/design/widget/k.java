package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a;
import android.support.v7.c.a.c;

class k extends c {
    static final double a = Math.cos(Math.toRadians(45.0d));
    final Paint b;
    final Paint c;
    final RectF d;
    float e;
    Path f;
    float g;
    float h;
    float i;
    float j;
    private boolean k = true;
    private final int l;
    private final int m;
    private final int n;
    private boolean o = true;
    private float p;
    private boolean q = false;

    public k(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.l = a.c(context, android.support.design.a.c.design_fab_shadow_start_color);
        this.m = a.c(context, android.support.design.a.c.design_fab_shadow_mid_color);
        this.n = a.c(context, android.support.design.a.c.design_fab_shadow_end_color);
        this.b = new Paint(5);
        this.b.setStyle(Style.FILL);
        this.e = (float) Math.round(f);
        this.d = new RectF();
        this.c = new Paint(this.b);
        this.c.setAntiAlias(false);
        a(f2, f3);
    }

    public static float a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - a) * ((double) f2))) : f * 1.5f;
    }

    private void a(Canvas canvas) {
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.p, this.d.centerX(), this.d.centerY());
        float f4 = (-this.e) - this.i;
        float f5 = this.e;
        float f6 = f5 * 2.0f;
        Object obj = this.d.width() - f6 > 0.0f ? 1 : null;
        Object obj2 = this.d.height() - f6 > 0.0f ? 1 : null;
        float f7 = f5 / ((this.j - (this.j * 0.5f)) + f5);
        float f8 = f5 / ((this.j - (this.j * 0.25f)) + f5);
        float f9 = f5 / ((this.j - (this.j * 1.0f)) + f5);
        int save2 = canvas.save();
        canvas2.translate(this.d.left + f5, this.d.top + f5);
        canvas2.scale(f7, f8);
        canvas2.drawPath(this.f, this.b);
        if (obj != null) {
            canvas2.scale(1.0f / f7, 1.0f);
            i = save2;
            f = f9;
            i2 = save;
            f2 = f8;
            canvas2.drawRect(0.0f, f4, this.d.width() - f6, -this.e, this.c);
        } else {
            i = save2;
            f = f9;
            i2 = save;
            f2 = f8;
        }
        canvas2.restoreToCount(i);
        i = canvas.save();
        canvas2.translate(this.d.right - f5, this.d.bottom - f5);
        f8 = f;
        canvas2.scale(f7, f8);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.f, this.b);
        if (obj != null) {
            canvas2.scale(1.0f / f7, 1.0f);
            f3 = f2;
            f2 = f8;
            canvas2.drawRect(0.0f, f4, this.d.width() - f6, (-this.e) + this.i, this.c);
        } else {
            f3 = f2;
            f2 = f8;
        }
        canvas2.restoreToCount(i);
        int save3 = canvas.save();
        canvas2.translate(this.d.left + f5, this.d.bottom - f5);
        canvas2.scale(f7, f2);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.f, this.b);
        if (obj2 != null) {
            canvas2.scale(1.0f / f2, 1.0f);
            canvas2.drawRect(0.0f, f4, this.d.height() - f6, -this.e, this.c);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        canvas2.translate(this.d.right - f5, this.d.top + f5);
        f5 = f3;
        canvas2.scale(f7, f5);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.f, this.b);
        if (obj2 != null) {
            canvas2.scale(1.0f / f5, 1.0f);
            canvas2.drawRect(0.0f, f4, this.d.height() - f6, -this.e, this.c);
        }
        canvas2.restoreToCount(save4);
        canvas2.restoreToCount(i2);
    }

    private void a(Rect rect) {
        float f = this.h * 1.5f;
        this.d.set(((float) rect.left) + this.h, ((float) rect.top) + f, ((float) rect.right) - this.h, ((float) rect.bottom) - f);
        b().setBounds((int) this.d.left, (int) this.d.top, (int) this.d.right, (int) this.d.bottom);
        c();
    }

    public static float b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - a) * ((double) f2))) : f;
    }

    private static int c(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    private void c() {
        RectF rectF = new RectF(-this.e, -this.e, this.e, this.e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.i, -this.i);
        if (this.f == null) {
            this.f = new Path();
        } else {
            this.f.reset();
        }
        this.f.setFillType(FillType.EVEN_ODD);
        this.f.moveTo(-this.e, 0.0f);
        this.f.rLineTo(-this.i, 0.0f);
        this.f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.e / f;
            float f3 = ((1.0f - f2) / 2.0f) + f2;
            Shader shader = r8;
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            Paint paint = this.b;
            Shader radialGradient = new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.l, this.m, this.n}, fArr, TileMode.CLAMP);
            paint.setShader(shader);
        }
        Paint paint2 = this.c;
        float f4 = rectF.top;
        paint2.setShader(new LinearGradient(0.0f, f4, 0.0f, rectF2.top, new int[]{this.l, this.m, this.n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.c.setAntiAlias(false);
    }

    public float a() {
        return this.j;
    }

    final void a(float f) {
        if (this.p != f) {
            this.p = f;
            invalidateSelf();
        }
    }

    void a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        f = (float) c(f);
        f2 = (float) c(f2);
        if (f > f2) {
            if (!this.q) {
                this.q = true;
            }
            f = f2;
        }
        if (this.j != f || this.h != f2) {
            this.j = f;
            this.h = f2;
            this.i = (float) Math.round(f * 1.5f);
            this.g = f2;
            this.k = true;
            invalidateSelf();
        }
    }

    public void a(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    public void b(float f) {
        a(f, this.h);
    }

    public void draw(Canvas canvas) {
        if (this.k) {
            a(getBounds());
            this.k = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.h, this.e, this.o));
        int ceil2 = (int) Math.ceil((double) b(this.h, this.e, this.o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.b.setAlpha(i);
        this.c.setAlpha(i);
    }
}
