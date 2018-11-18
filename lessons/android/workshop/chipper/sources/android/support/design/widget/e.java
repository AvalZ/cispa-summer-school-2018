package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.c.a;
import android.support.v4.f.d;
import android.support.v4.h.r;
import android.support.v7.a.a.j;
import android.support.v7.widget.bg;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class e {
    private static final boolean a = (VERSION.SDK_INT < 18);
    private static final Paint b = null;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private final TextPaint J;
    private Interpolator K;
    private Interpolator L;
    private float M;
    private float N;
    private float O;
    private int P;
    private float Q;
    private float R;
    private float S;
    private int T;
    private final View c;
    private boolean d;
    private float e;
    private final Rect f;
    private final Rect g;
    private final RectF h;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private ColorStateList m;
    private ColorStateList n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    static {
        if (b != null) {
            b.setAntiAlias(true);
            b.setColor(-65281);
        }
    }

    public e(View view) {
        this.c = view;
        this.J = new TextPaint(129);
        this.g = new Rect();
        this.f = new Rect();
        this.h = new RectF();
    }

    private static float a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return a.a(f, f2, f3);
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    private static boolean a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private boolean a(Typeface typeface, Typeface typeface2) {
        return !(typeface == null || typeface.equals(typeface2)) || (typeface == null && typeface2 != null);
    }

    private boolean b(CharSequence charSequence) {
        int i = 1;
        if (r.e(this.c) != 1) {
            i = 0;
        }
        return (i != 0 ? d.d : d.c).a(charSequence, 0, charSequence.length());
    }

    private void c(float f) {
        TextPaint textPaint;
        int a;
        d(f);
        this.s = a(this.q, this.r, f, this.K);
        this.t = a(this.o, this.p, f, this.K);
        e(a(this.k, this.l, f, this.L));
        if (this.n != this.m) {
            textPaint = this.J;
            a = a(j(), k(), f);
        } else {
            textPaint = this.J;
            a = k();
        }
        textPaint.setColor(a);
        this.J.setShadowLayer(a(this.Q, this.M, f, null), a(this.R, this.N, f, null), a(this.S, this.O, f, null), a(this.T, this.P, f));
        r.c(this.c);
    }

    private Typeface d(int i) {
        TypedArray obtainStyledAttributes = this.c.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void d(float f) {
        this.h.left = a((float) this.f.left, (float) this.g.left, f, this.K);
        this.h.top = a(this.o, this.p, f, this.K);
        this.h.right = a((float) this.f.right, (float) this.g.right, f, this.K);
        this.h.bottom = a((float) this.f.bottom, (float) this.g.bottom, f, this.K);
    }

    private void e(float f) {
        f(f);
        boolean z = a && this.F != 1.0f;
        this.A = z;
        if (this.A) {
            m();
        }
        r.c(this.c);
    }

    private void f(float f) {
        if (this.x != null) {
            float f2;
            boolean z;
            float width = (float) this.g.width();
            float width2 = (float) this.f.width();
            boolean z2 = true;
            if (a(f, this.l)) {
                boolean z3;
                f = this.l;
                this.F = 1.0f;
                if (a(this.w, this.u)) {
                    this.w = this.u;
                    z3 = true;
                } else {
                    z3 = false;
                }
                f2 = f;
                z = z3;
            } else {
                f2 = this.k;
                if (a(this.w, this.v)) {
                    this.w = this.v;
                    z = true;
                } else {
                    z = false;
                }
                if (a(f, this.k)) {
                    this.F = 1.0f;
                } else {
                    this.F = f / this.k;
                }
                f = this.l / this.k;
                width = width2 * f > width ? Math.min(width / f, width2) : width2;
            }
            if (width > 0.0f) {
                z = this.G != f2 || this.I || z;
                this.G = f2;
                this.I = false;
            }
            if (this.y == null || r6) {
                this.J.setTextSize(this.G);
                this.J.setTypeface(this.w);
                TextPaint textPaint = this.J;
                if (this.F == 1.0f) {
                    z2 = false;
                }
                textPaint.setLinearText(z2);
                CharSequence ellipsize = TextUtils.ellipsize(this.x, this.J, width, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.y)) {
                    this.y = ellipsize;
                    this.z = b(this.y);
                }
            }
        }
    }

    private void i() {
        c(this.e);
    }

    private int j() {
        return this.H != null ? this.m.getColorForState(this.H, 0) : this.m.getDefaultColor();
    }

    private int k() {
        return this.H != null ? this.n.getColorForState(this.H, 0) : this.n.getDefaultColor();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4  */
    private void l() {
        /*
        r11 = this;
        r0 = r11.G;
        r1 = r11.l;
        r11.f(r1);
        r1 = r11.y;
        r2 = 0;
        r3 = 0;
        if (r1 == 0) goto L_0x001c;
    L_0x000d:
        r1 = r11.J;
        r4 = r11.y;
        r5 = r11.y;
        r5 = r5.length();
        r1 = r1.measureText(r4, r3, r5);
        goto L_0x001d;
    L_0x001c:
        r1 = r2;
    L_0x001d:
        r4 = r11.j;
        r5 = r11.z;
        r4 = android.support.v4.h.d.a(r4, r5);
        r5 = r4 & 112;
        r6 = 80;
        r7 = 48;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r5 == r7) goto L_0x0057;
    L_0x002f:
        if (r5 == r6) goto L_0x0051;
    L_0x0031:
        r5 = r11.J;
        r5 = r5.descent();
        r9 = r11.J;
        r9 = r9.ascent();
        r5 = r5 - r9;
        r5 = r5 / r8;
        r9 = r11.J;
        r9 = r9.descent();
        r5 = r5 - r9;
        r9 = r11.g;
        r9 = r9.centerY();
        r9 = (float) r9;
        r9 = r9 + r5;
        r11.p = r9;
        goto L_0x0065;
    L_0x0051:
        r5 = r11.g;
        r5 = r5.bottom;
        r5 = (float) r5;
        goto L_0x0063;
    L_0x0057:
        r5 = r11.g;
        r5 = r5.top;
        r5 = (float) r5;
        r9 = r11.J;
        r9 = r9.ascent();
        r5 = r5 - r9;
    L_0x0063:
        r11.p = r5;
    L_0x0065:
        r5 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r4 = r4 & r5;
        r9 = 5;
        r10 = 1;
        if (r4 == r10) goto L_0x007d;
    L_0x006d:
        if (r4 == r9) goto L_0x0077;
    L_0x006f:
        r1 = r11.g;
        r1 = r1.left;
        r1 = (float) r1;
        r11.r = r1;
        goto L_0x0088;
    L_0x0077:
        r4 = r11.g;
        r4 = r4.right;
        r4 = (float) r4;
        goto L_0x0085;
    L_0x007d:
        r4 = r11.g;
        r4 = r4.centerX();
        r4 = (float) r4;
        r1 = r1 / r8;
    L_0x0085:
        r4 = r4 - r1;
        r11.r = r4;
    L_0x0088:
        r1 = r11.k;
        r11.f(r1);
        r1 = r11.y;
        if (r1 == 0) goto L_0x009f;
    L_0x0091:
        r1 = r11.J;
        r2 = r11.y;
        r4 = r11.y;
        r4 = r4.length();
        r2 = r1.measureText(r2, r3, r4);
    L_0x009f:
        r1 = r11.i;
        r3 = r11.z;
        r1 = android.support.v4.h.d.a(r1, r3);
        r3 = r1 & 112;
        if (r3 == r7) goto L_0x00d3;
    L_0x00ab:
        if (r3 == r6) goto L_0x00cd;
    L_0x00ad:
        r3 = r11.J;
        r3 = r3.descent();
        r4 = r11.J;
        r4 = r4.ascent();
        r3 = r3 - r4;
        r3 = r3 / r8;
        r4 = r11.J;
        r4 = r4.descent();
        r3 = r3 - r4;
        r4 = r11.f;
        r4 = r4.centerY();
        r4 = (float) r4;
        r4 = r4 + r3;
        r11.o = r4;
        goto L_0x00e1;
    L_0x00cd:
        r3 = r11.f;
        r3 = r3.bottom;
        r3 = (float) r3;
        goto L_0x00df;
    L_0x00d3:
        r3 = r11.f;
        r3 = r3.top;
        r3 = (float) r3;
        r4 = r11.J;
        r4 = r4.ascent();
        r3 = r3 - r4;
    L_0x00df:
        r11.o = r3;
    L_0x00e1:
        r1 = r1 & r5;
        if (r1 == r10) goto L_0x00f4;
    L_0x00e4:
        if (r1 == r9) goto L_0x00ee;
    L_0x00e6:
        r1 = r11.f;
        r1 = r1.left;
        r1 = (float) r1;
    L_0x00eb:
        r11.q = r1;
        goto L_0x00fe;
    L_0x00ee:
        r1 = r11.f;
        r1 = r1.right;
        r1 = (float) r1;
        goto L_0x00fc;
    L_0x00f4:
        r1 = r11.f;
        r1 = r1.centerX();
        r1 = (float) r1;
        r2 = r2 / r8;
    L_0x00fc:
        r1 = r1 - r2;
        goto L_0x00eb;
    L_0x00fe:
        r11.n();
        r11.e(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.e.l():void");
    }

    private void m() {
        if (this.B == null && !this.f.isEmpty() && !TextUtils.isEmpty(this.y)) {
            c(0.0f);
            this.D = this.J.ascent();
            this.E = this.J.descent();
            int round = Math.round(this.J.measureText(this.y, 0, this.y.length()));
            int round2 = Math.round(this.E - this.D);
            if (round > 0 && round2 > 0) {
                this.B = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.B).drawText(this.y, 0, this.y.length(), 0.0f, ((float) round2) - this.J.descent(), this.J);
                if (this.C == null) {
                    this.C = new Paint(3);
                }
            }
        }
    }

    private void n() {
        if (this.B != null) {
            this.B.recycle();
            this.B = null;
        }
    }

    void a() {
        boolean z = this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0;
        this.d = z;
    }

    void a(float f) {
        if (this.k != f) {
            this.k = f;
            f();
        }
    }

    void a(int i) {
        if (this.i != i) {
            this.i = i;
            f();
        }
    }

    void a(int i, int i2, int i3, int i4) {
        if (!a(this.f, i, i2, i3, i4)) {
            this.f.set(i, i2, i3, i4);
            this.I = true;
            a();
        }
    }

    void a(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            f();
        }
    }

    public void a(Canvas canvas) {
        int save = canvas.save();
        if (this.y != null && this.d) {
            float f;
            float f2;
            float f3 = this.s;
            float f4 = this.t;
            Object obj = (!this.A || this.B == null) ? null : 1;
            if (obj != null) {
                f = this.D * this.F;
                f2 = this.E;
            } else {
                f = this.J.ascent() * this.F;
                this.J.descent();
            }
            f2 = this.F;
            if (obj != null) {
                f4 += f;
            }
            float f5 = f4;
            if (this.F != 1.0f) {
                canvas.scale(this.F, this.F, f3, f5);
            }
            if (obj != null) {
                canvas.drawBitmap(this.B, f3, f5, this.C);
            } else {
                canvas.drawText(this.y, 0, this.y.length(), f3, f5, this.J);
            }
        }
        canvas.restoreToCount(save);
    }

    void a(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        f();
    }

    void a(Interpolator interpolator) {
        this.L = interpolator;
        f();
    }

    void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.x)) {
            this.x = charSequence;
            this.y = null;
            n();
            f();
        }
    }

    final boolean a(int[] iArr) {
        this.H = iArr;
        if (!c()) {
            return false;
        }
        f();
        return true;
    }

    Typeface b() {
        return this.u != null ? this.u : Typeface.DEFAULT;
    }

    void b(float f) {
        f = a.a(f, 0.0f, 1.0f);
        if (f != this.e) {
            this.e = f;
            i();
        }
    }

    void b(int i) {
        if (this.j != i) {
            this.j = i;
            f();
        }
    }

    void b(int i, int i2, int i3, int i4) {
        if (!a(this.g, i, i2, i3, i4)) {
            this.g.set(i, i2, i3, i4);
            this.I = true;
            a();
        }
    }

    void b(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            f();
        }
    }

    void b(Interpolator interpolator) {
        this.K = interpolator;
        f();
    }

    void c(int i) {
        bg a = bg.a(this.c.getContext(), i, j.TextAppearance);
        if (a.g(j.TextAppearance_android_textColor)) {
            this.n = a.e(j.TextAppearance_android_textColor);
        }
        if (a.g(j.TextAppearance_android_textSize)) {
            this.l = (float) a.e(j.TextAppearance_android_textSize, (int) this.l);
        }
        this.P = a.a(j.TextAppearance_android_shadowColor, 0);
        this.N = a.a(j.TextAppearance_android_shadowDx, 0.0f);
        this.O = a.a(j.TextAppearance_android_shadowDy, 0.0f);
        this.M = a.a(j.TextAppearance_android_shadowRadius, 0.0f);
        a.a();
        if (VERSION.SDK_INT >= 16) {
            this.u = d(i);
        }
        f();
    }

    final boolean c() {
        return (this.n != null && this.n.isStateful()) || (this.m != null && this.m.isStateful());
    }

    float d() {
        return this.e;
    }

    float e() {
        return this.l;
    }

    public void f() {
        if (this.c.getHeight() > 0 && this.c.getWidth() > 0) {
            l();
            i();
        }
    }

    CharSequence g() {
        return this.x;
    }

    ColorStateList h() {
        return this.n;
    }
}
