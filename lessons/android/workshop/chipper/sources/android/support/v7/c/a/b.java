package android.support.v7.c.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.SparseArray;

class b extends Drawable implements Callback {
    private b a;
    private Rect b;
    private Drawable c;
    private Drawable d;
    private int e = 255;
    private boolean f;
    private int g = -1;
    private int h = -1;
    private boolean i;
    private Runnable j;
    private long k;
    private long l;
    private a m;

    static class a implements Callback {
        private Callback a;

        a() {
        }

        public Callback a() {
            Callback callback = this.a;
            this.a = null;
            return callback;
        }

        public a a(Callback callback) {
            this.a = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (this.a != null) {
                this.a.scheduleDrawable(drawable, runnable, j);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (this.a != null) {
                this.a.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class b extends ConstantState {
        boolean A;
        int B;
        int C;
        int D;
        boolean E;
        ColorFilter F;
        boolean G;
        ColorStateList H;
        Mode I;
        boolean J;
        boolean K;
        final b c;
        Resources d;
        int e = 160;
        int f;
        int g;
        SparseArray<ConstantState> h;
        Drawable[] i;
        int j;
        boolean k;
        boolean l;
        Rect m;
        boolean n;
        boolean o;
        int p;
        int q;
        int r;
        int s;
        boolean t;
        int u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        boolean z;

        b(b bVar, b bVar2, Resources resources) {
            int i = 0;
            this.k = false;
            this.n = false;
            this.z = true;
            this.C = 0;
            this.D = 0;
            this.c = bVar2;
            Resources resources2 = resources != null ? resources : bVar != null ? bVar.d : null;
            this.d = resources2;
            this.e = b.a(resources, bVar != null ? bVar.e : 0);
            if (bVar != null) {
                this.f = bVar.f;
                this.g = bVar.g;
                this.x = true;
                this.y = true;
                this.k = bVar.k;
                this.n = bVar.n;
                this.z = bVar.z;
                this.A = bVar.A;
                this.B = bVar.B;
                this.C = bVar.C;
                this.D = bVar.D;
                this.E = bVar.E;
                this.F = bVar.F;
                this.G = bVar.G;
                this.H = bVar.H;
                this.I = bVar.I;
                this.J = bVar.J;
                this.K = bVar.K;
                if (bVar.e == this.e) {
                    if (bVar.l) {
                        this.m = new Rect(bVar.m);
                        this.l = true;
                    }
                    if (bVar.o) {
                        this.p = bVar.p;
                        this.q = bVar.q;
                        this.r = bVar.r;
                        this.s = bVar.s;
                        this.o = true;
                    }
                }
                if (bVar.t) {
                    this.u = bVar.u;
                    this.t = true;
                }
                if (bVar.v) {
                    this.w = bVar.w;
                    this.v = true;
                }
                Drawable[] drawableArr = bVar.i;
                this.i = new Drawable[drawableArr.length];
                this.j = bVar.j;
                SparseArray sparseArray = bVar.h;
                this.h = sparseArray != null ? sparseArray.clone() : new SparseArray(this.j);
                int i2 = this.j;
                while (i < i2) {
                    if (drawableArr[i] != null) {
                        ConstantState constantState = drawableArr[i].getConstantState();
                        if (constantState != null) {
                            this.h.put(i, constantState);
                        } else {
                            this.i[i] = drawableArr[i];
                        }
                    }
                    i++;
                }
                return;
            }
            this.i = new Drawable[10];
            this.j = 0;
        }

        private Drawable b(Drawable drawable) {
            if (VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.B);
            }
            drawable = drawable.mutate();
            drawable.setCallback(this.c);
            return drawable;
        }

        private void o() {
            if (this.h != null) {
                int size = this.h.size();
                for (int i = 0; i < size; i++) {
                    this.i[this.h.keyAt(i)] = b(((ConstantState) this.h.valueAt(i)).newDrawable(this.d));
                }
                this.h = null;
            }
        }

        public final int a(Drawable drawable) {
            int i = this.j;
            if (i >= this.i.length) {
                e(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.c);
            this.i[i] = drawable;
            this.j++;
            this.g = drawable.getChangingConfigurations() | this.g;
            b();
            this.m = null;
            this.l = false;
            this.o = false;
            this.x = false;
            return i;
        }

        void a() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.A = true;
        }

        final void a(Theme theme) {
            if (theme != null) {
                o();
                int i = this.j;
                Drawable[] drawableArr = this.i;
                int i2 = 0;
                while (i2 < i) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.g |= drawableArr[i2].getChangingConfigurations();
                    }
                    i2++;
                }
                a(theme.getResources());
            }
        }

        final void a(Resources resources) {
            if (resources != null) {
                this.d = resources;
                int a = b.a(resources, this.e);
                int i = this.e;
                this.e = a;
                if (i != a) {
                    this.o = false;
                    this.l = false;
                }
            }
        }

        public final void a(boolean z) {
            this.k = z;
        }

        public final Drawable b(int i) {
            Drawable drawable = this.i[i];
            if (drawable != null) {
                return drawable;
            }
            if (this.h != null) {
                int indexOfKey = this.h.indexOfKey(i);
                if (indexOfKey >= 0) {
                    Drawable b = b(((ConstantState) this.h.valueAt(indexOfKey)).newDrawable(this.d));
                    this.i[i] = b;
                    this.h.removeAt(indexOfKey);
                    if (this.h.size() == 0) {
                        this.h = null;
                    }
                    return b;
                }
            }
            return null;
        }

        void b() {
            this.t = false;
            this.v = false;
        }

        public final void b(boolean z) {
            this.n = z;
        }

        final int c() {
            return this.i.length;
        }

        public final void c(int i) {
            this.C = i;
        }

        public boolean canApplyTheme() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    ConstantState constantState = (ConstantState) this.h.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public final int d() {
            return this.j;
        }

        public final void d(int i) {
            this.D = i;
        }

        final boolean d(int i, int i2) {
            int i3 = this.j;
            Drawable[] drawableArr = this.i;
            int i4 = 0;
            boolean z = i4;
            while (i4 < i3) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
                i4++;
            }
            this.B = i;
            return z;
        }

        public final Rect e() {
            if (this.k) {
                return null;
            }
            if (this.m != null || this.l) {
                return this.m;
            }
            o();
            Rect rect = new Rect();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            Rect rect2 = null;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.l = true;
            this.m = rect2;
            return rect2;
        }

        public void e(int i, int i2) {
            Object obj = new Drawable[i2];
            System.arraycopy(this.i, 0, obj, 0, i);
            this.i = obj;
        }

        public final boolean f() {
            return this.n;
        }

        public final int g() {
            if (!this.o) {
                k();
            }
            return this.p;
        }

        public int getChangingConfigurations() {
            return this.g | this.f;
        }

        public final int h() {
            if (!this.o) {
                k();
            }
            return this.q;
        }

        public final int i() {
            if (!this.o) {
                k();
            }
            return this.r;
        }

        public final int j() {
            if (!this.o) {
                k();
            }
            return this.s;
        }

        protected void k() {
            this.o = true;
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            this.q = -1;
            this.p = -1;
            int i2 = 0;
            this.s = 0;
            this.r = 0;
            while (i2 < i) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.p) {
                    this.p = intrinsicWidth;
                }
                intrinsicWidth = drawable.getIntrinsicHeight();
                if (intrinsicWidth > this.q) {
                    this.q = intrinsicWidth;
                }
                intrinsicWidth = drawable.getMinimumWidth();
                if (intrinsicWidth > this.r) {
                    this.r = intrinsicWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.s) {
                    this.s = minimumHeight;
                }
                i2++;
            }
        }

        public final int l() {
            if (this.t) {
                return this.u;
            }
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.u = opacity;
            this.t = true;
            return opacity;
        }

        public final boolean m() {
            if (this.v) {
                return this.w;
            }
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                }
            }
            this.w = z;
            this.v = true;
            return z;
        }

        public synchronized boolean n() {
            if (this.x) {
                return this.y;
            }
            o();
            this.x = true;
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.y = false;
                    return false;
                }
            }
            this.y = true;
            return true;
        }
    }

    b() {
    }

    static int a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        return i == 0 ? 160 : i;
    }

    private void a(Drawable drawable) {
        if (this.m == null) {
            this.m = new a();
        }
        drawable.setCallback(this.m.a(drawable.getCallback()));
        try {
            if (this.a.C <= 0 && this.f) {
                drawable.setAlpha(this.e);
            }
            if (this.a.G) {
                drawable.setColorFilter(this.a.F);
            } else {
                if (this.a.J) {
                    android.support.v4.graphics.drawable.a.a(drawable, this.a.H);
                }
                if (this.a.K) {
                    android.support.v4.graphics.drawable.a.a(drawable, this.a.I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.a.z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.a.E);
            }
            Rect rect = this.b;
            if (VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.m.a());
        } catch (Throwable th) {
            drawable.setCallback(this.m.a());
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    private boolean a() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    final void a(Resources resources) {
        this.a.a(resources);
    }

    protected void a(b bVar) {
        this.a = bVar;
        if (this.g >= 0) {
            this.c = bVar.b(this.g);
            if (this.c != null) {
                a(this.c);
            }
        }
        this.h = -1;
        this.d = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A:{SKIP} */
    void a(boolean r12) {
        /*
        r11 = this;
        r0 = 1;
        r11.f = r0;
        r1 = android.os.SystemClock.uptimeMillis();
        r3 = r11.c;
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6 = 0;
        r7 = 0;
        if (r3 == 0) goto L_0x003c;
    L_0x0010:
        r9 = r11.k;
        r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r3 == 0) goto L_0x003e;
    L_0x0016:
        r9 = r11.k;
        r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r3 > 0) goto L_0x0024;
    L_0x001c:
        r3 = r11.c;
        r9 = r11.e;
        r3.setAlpha(r9);
        goto L_0x003c;
    L_0x0024:
        r9 = r11.k;
        r9 = r9 - r1;
        r9 = r9 * r4;
        r3 = (int) r9;
        r9 = r11.a;
        r9 = r9.C;
        r3 = r3 / r9;
        r9 = r11.c;
        r3 = 255 - r3;
        r10 = r11.e;
        r3 = r3 * r10;
        r3 = r3 / 255;
        r9.setAlpha(r3);
        r3 = r0;
        goto L_0x003f;
    L_0x003c:
        r11.k = r7;
    L_0x003e:
        r3 = r6;
    L_0x003f:
        r9 = r11.d;
        if (r9 == 0) goto L_0x0070;
    L_0x0043:
        r9 = r11.l;
        r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r9 == 0) goto L_0x0072;
    L_0x0049:
        r9 = r11.l;
        r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r9 > 0) goto L_0x005b;
    L_0x004f:
        r0 = r11.d;
        r0.setVisible(r6, r6);
        r0 = 0;
        r11.d = r0;
        r0 = -1;
        r11.h = r0;
        goto L_0x0070;
    L_0x005b:
        r6 = r11.l;
        r6 = r6 - r1;
        r6 = r6 * r4;
        r3 = (int) r6;
        r4 = r11.a;
        r4 = r4.D;
        r3 = r3 / r4;
        r4 = r11.d;
        r5 = r11.e;
        r3 = r3 * r5;
        r3 = r3 / 255;
        r4.setAlpha(r3);
        goto L_0x0073;
    L_0x0070:
        r11.l = r7;
    L_0x0072:
        r0 = r3;
    L_0x0073:
        if (r12 == 0) goto L_0x007f;
    L_0x0075:
        if (r0 == 0) goto L_0x007f;
    L_0x0077:
        r12 = r11.j;
        r3 = 16;
        r1 = r1 + r3;
        r11.scheduleSelf(r12, r1);
    L_0x007f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.b.a(boolean):void");
    }

    boolean a(int i) {
        if (i == this.g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.a.D > 0) {
            if (this.d != null) {
                this.d.setVisible(false, false);
            }
            if (this.c != null) {
                this.d = this.c;
                this.h = this.g;
                this.l = ((long) this.a.D) + uptimeMillis;
            } else {
                this.d = null;
                this.h = -1;
                this.l = 0;
            }
        } else if (this.c != null) {
            this.c.setVisible(false, false);
        }
        if (i < 0 || i >= this.a.j) {
            this.c = null;
            this.g = -1;
        } else {
            Drawable b = this.a.b(i);
            this.c = b;
            this.g = i;
            if (b != null) {
                if (this.a.C > 0) {
                    this.k = uptimeMillis + ((long) this.a.C);
                }
                a(b);
            }
        }
        if (!(this.k == 0 && this.l == 0)) {
            if (this.j == null) {
                this.j = new Runnable() {
                    public void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(this.j);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    public void applyTheme(Theme theme) {
        this.a.a(theme);
    }

    b c() {
        return this.a;
    }

    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    int d() {
        return this.g;
    }

    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
        }
        if (this.d != null) {
            this.d.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.e;
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations() | super.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (!this.a.n()) {
            return null;
        }
        this.a.f = getChangingConfigurations();
        return this.a;
    }

    public Drawable getCurrent() {
        return this.c;
    }

    public void getHotspotBounds(Rect rect) {
        if (this.b != null) {
            rect.set(this.b);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        return this.a.f() ? this.a.h() : this.c != null ? this.c.getIntrinsicHeight() : -1;
    }

    public int getIntrinsicWidth() {
        return this.a.f() ? this.a.g() : this.c != null ? this.c.getIntrinsicWidth() : -1;
    }

    public int getMinimumHeight() {
        return this.a.f() ? this.a.j() : this.c != null ? this.c.getMinimumHeight() : 0;
    }

    public int getMinimumWidth() {
        return this.a.f() ? this.a.i() : this.c != null ? this.c.getMinimumWidth() : 0;
    }

    public int getOpacity() {
        return (this.c == null || !this.c.isVisible()) ? -2 : this.a.l();
    }

    public void getOutline(Outline outline) {
        if (this.c != null) {
            this.c.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        Rect e = this.a.e();
        if (e != null) {
            rect.set(e);
            z = (e.right | ((e.left | e.top) | e.bottom)) != 0;
        } else {
            z = this.c != null ? this.c.getPadding(rect) : super.getPadding(rect);
        }
        if (a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return z;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.a != null) {
            this.a.b();
        }
        if (drawable == this.c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.a.E;
    }

    public boolean isStateful() {
        return this.a.m();
    }

    public void jumpToCurrentState() {
        Object obj;
        if (this.d != null) {
            this.d.jumpToCurrentState();
            this.d = null;
            this.h = -1;
            obj = 1;
        } else {
            obj = null;
        }
        if (this.c != null) {
            this.c.jumpToCurrentState();
            if (this.f) {
                this.c.setAlpha(this.e);
            }
        }
        if (this.l != 0) {
            this.l = 0;
            obj = 1;
        }
        if (this.k != 0) {
            this.k = 0;
            obj = 1;
        }
        if (obj != null) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            b c = c();
            c.a();
            a(c);
            this.i = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.d != null) {
            this.d.setBounds(rect);
        }
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        return this.a.d(i, d());
    }

    protected boolean onLevelChange(int i) {
        Drawable drawable;
        if (this.d != null) {
            drawable = this.d;
        } else if (this.c == null) {
            return false;
        } else {
            drawable = this.c;
        }
        return drawable.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        Drawable drawable;
        if (this.d != null) {
            drawable = this.d;
        } else if (this.c == null) {
            return false;
        } else {
            drawable = this.c;
        }
        return drawable.setState(iArr);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == this.c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (!(this.f && this.e == i)) {
            this.f = true;
            this.e = i;
            if (this.c != null) {
                if (this.k == 0) {
                    this.c.setAlpha(i);
                    return;
                }
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.a.E != z) {
            this.a.E = z;
            if (this.c != null) {
                android.support.v4.graphics.drawable.a.a(this.c, this.a.E);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.G = true;
        if (this.a.F != colorFilter) {
            this.a.F = colorFilter;
            if (this.c != null) {
                this.c.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        if (this.a.z != z) {
            this.a.z = z;
            if (this.c != null) {
                this.c.setDither(this.a.z);
            }
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.b == null) {
            this.b = new Rect(i, i2, i3, i4);
        } else {
            this.b.set(i, i2, i3, i4);
        }
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, i, i2, i3, i4);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        this.a.J = true;
        if (this.a.H != colorStateList) {
            this.a.H = colorStateList;
            android.support.v4.graphics.drawable.a.a(this.c, colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        this.a.K = true;
        if (this.a.I != mode) {
            this.a.I = mode;
            android.support.v4.graphics.drawable.a.a(this.c, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.d != null) {
            this.d.setVisible(z, z2);
        }
        if (this.c != null) {
            this.c.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
