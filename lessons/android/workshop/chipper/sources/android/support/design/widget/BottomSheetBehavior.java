package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.k;
import android.support.v4.h.r;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends android.support.design.widget.CoordinatorLayout.b<V> {
    int a;
    int b;
    boolean c;
    int d = 4;
    q e;
    int f;
    WeakReference<V> g;
    WeakReference<View> h;
    int i;
    boolean j;
    private float k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private a s;
    private VelocityTracker t;
    private int u;
    private final android.support.v4.widget.q.a v = new android.support.v4.widget.q.a() {
        public int a(View view) {
            return (BottomSheetBehavior.this.c ? BottomSheetBehavior.this.f : BottomSheetBehavior.this.b) - BottomSheetBehavior.this.a;
        }

        public int a(View view, int i, int i2) {
            return android.support.v4.c.a.a(i, BottomSheetBehavior.this.a, BottomSheetBehavior.this.c ? BottomSheetBehavior.this.f : BottomSheetBehavior.this.b);
        }

        public void a(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.b(1);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
        /* JADX WARNING: Missing block: B:11:0x003c, code:
            if (java.lang.Math.abs(r5 - r3.a.a) < java.lang.Math.abs(r5 - r3.a.b)) goto L_0x0007;
     */
        public void a(android.view.View r4, float r5, float r6) {
            /*
            r3 = this;
            r5 = 0;
            r0 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
            r1 = 4;
            r2 = 3;
            if (r0 >= 0) goto L_0x000d;
        L_0x0007:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r5 = r5.a;
            r1 = r2;
            goto L_0x0043;
        L_0x000d:
            r0 = android.support.design.widget.BottomSheetBehavior.this;
            r0 = r0.c;
            if (r0 == 0) goto L_0x0021;
        L_0x0013:
            r0 = android.support.design.widget.BottomSheetBehavior.this;
            r0 = r0.a(r4, r6);
            if (r0 == 0) goto L_0x0021;
        L_0x001b:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r5 = r5.f;
            r1 = 5;
            goto L_0x0043;
        L_0x0021:
            r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
            if (r5 != 0) goto L_0x003f;
        L_0x0025:
            r5 = r4.getTop();
            r6 = android.support.design.widget.BottomSheetBehavior.this;
            r6 = r6.a;
            r6 = r5 - r6;
            r6 = java.lang.Math.abs(r6);
            r0 = android.support.design.widget.BottomSheetBehavior.this;
            r0 = r0.b;
            r5 = r5 - r0;
            r5 = java.lang.Math.abs(r5);
            if (r6 >= r5) goto L_0x003f;
        L_0x003e:
            goto L_0x0007;
        L_0x003f:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r5 = r5.b;
        L_0x0043:
            r6 = android.support.design.widget.BottomSheetBehavior.this;
            r6 = r6.e;
            r0 = r4.getLeft();
            r5 = r6.a(r0, r5);
            if (r5 == 0) goto L_0x0062;
        L_0x0051:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r6 = 2;
            r5.b(r6);
            r5 = new android.support.design.widget.BottomSheetBehavior$c;
            r3 = android.support.design.widget.BottomSheetBehavior.this;
            r5.<init>(r4, r1);
            android.support.v4.h.r.a(r4, r5);
            return;
        L_0x0062:
            r3 = android.support.design.widget.BottomSheetBehavior.this;
            r3.b(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.1.a(android.view.View, float, float):void");
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.c(i2);
        }

        public boolean a(View view, int i) {
            if (BottomSheetBehavior.this.d == 1 || BottomSheetBehavior.this.j) {
                return false;
            }
            if (BottomSheetBehavior.this.d == 3 && BottomSheetBehavior.this.i == i) {
                View view2 = (View) BottomSheetBehavior.this.h.get();
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            return BottomSheetBehavior.this.g != null && BottomSheetBehavior.this.g.get() == view;
        }

        public int b(View view, int i, int i2) {
            return view.getLeft();
        }
    };

    public static abstract class a {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    private class c implements Runnable {
        private final View b;
        private final int c;

        c(View view, int i) {
            this.b = view;
            this.c = i;
        }

        public void run() {
            if (BottomSheetBehavior.this.e == null || !BottomSheetBehavior.this.e.a(true)) {
                BottomSheetBehavior.this.b(this.c);
            } else {
                r.a(this.b, (Runnable) this);
            }
        }
    }

    protected static class b extends android.support.v4.h.a {
        public static final Creator<b> CREATOR = new ClassLoaderCreator<b>() {
            /* renamed from: a */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            /* renamed from: a */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            /* renamed from: a */
            public b[] newArray(int i) {
                return new b[i];
            }
        };
        final int a;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
        }

        public b(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(k.BottomSheetBehavior_Layout_behavior_peekHeight);
        int dimensionPixelSize = (peekValue == null || peekValue.data != -1) ? obtainStyledAttributes.getDimensionPixelSize(k.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : peekValue.data;
        a(dimensionPixelSize);
        a(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_hideable, false));
        b(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.k = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void a() {
        this.i = -1;
        if (this.t != null) {
            this.t.recycle();
            this.t = null;
        }
    }

    private float b() {
        this.t.computeCurrentVelocity(1000, this.k);
        return this.t.getYVelocity(this.i);
    }

    View a(View view) {
        if (r.s(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    public final void a(int r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        r2 = -1;
        if (r4 != r2) goto L_0x000c;
    L_0x0005:
        r4 = r3.m;
        if (r4 != 0) goto L_0x0015;
    L_0x0009:
        r3.m = r0;
        goto L_0x0024;
    L_0x000c:
        r2 = r3.m;
        if (r2 != 0) goto L_0x0017;
    L_0x0010:
        r2 = r3.l;
        if (r2 == r4) goto L_0x0015;
    L_0x0014:
        goto L_0x0017;
    L_0x0015:
        r0 = r1;
        goto L_0x0024;
    L_0x0017:
        r3.m = r1;
        r1 = java.lang.Math.max(r1, r4);
        r3.l = r1;
        r1 = r3.f;
        r1 = r1 - r4;
        r3.b = r1;
    L_0x0024:
        if (r0 == 0) goto L_0x003c;
    L_0x0026:
        r4 = r3.d;
        r0 = 4;
        if (r4 != r0) goto L_0x003c;
    L_0x002b:
        r4 = r3.g;
        if (r4 == 0) goto L_0x003c;
    L_0x002f:
        r3 = r3.g;
        r3 = r3.get();
        r3 = (android.view.View) r3;
        if (r3 == 0) goto L_0x003c;
    L_0x0039:
        r3.requestLayout();
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.a(int):void");
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.a(coordinatorLayout, (View) v, bVar.a());
        int i = (bVar.a == 1 || bVar.a == 2) ? 4 : bVar.a;
        this.d = i;
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.h.get())) {
            int top = v.getTop();
            i = top - i2;
            if (i2 <= 0) {
                if (i2 < 0 && !view.canScrollVertically(-1)) {
                    if (i <= this.b || this.c) {
                        iArr[1] = i2;
                        r.c(v, -i2);
                        b(1);
                    } else {
                        iArr[1] = top - this.b;
                        r.c(v, -iArr[1]);
                        top = 4;
                    }
                }
                c(v.getTop());
                this.q = i2;
                this.r = true;
            } else if (i < this.a) {
                iArr[1] = top - this.a;
                r.c(v, -iArr[1]);
                top = 3;
            } else {
                iArr[1] = i2;
                r.c(v, -i2);
                b(1);
                c(v.getTop());
                this.q = i2;
                this.r = true;
            }
            b(top);
            c(v.getTop());
            this.q = i2;
            this.r = true;
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    public boolean a(android.support.design.widget.CoordinatorLayout r6, V r7, int r8) {
        /*
        r5 = this;
        r0 = android.support.v4.h.r.n(r6);
        r1 = 1;
        if (r0 == 0) goto L_0x0010;
    L_0x0007:
        r0 = android.support.v4.h.r.n(r7);
        if (r0 != 0) goto L_0x0010;
    L_0x000d:
        android.support.v4.h.r.b(r7, r1);
    L_0x0010:
        r0 = r7.getTop();
        r6.a(r7, r8);
        r8 = r6.getHeight();
        r5.f = r8;
        r8 = r5.m;
        if (r8 == 0) goto L_0x0043;
    L_0x0021:
        r8 = r5.n;
        if (r8 != 0) goto L_0x0031;
    L_0x0025:
        r8 = r6.getResources();
        r2 = android.support.design.a.d.design_bottom_sheet_peek_height_min;
        r8 = r8.getDimensionPixelSize(r2);
        r5.n = r8;
    L_0x0031:
        r8 = r5.n;
        r2 = r5.f;
        r3 = r6.getWidth();
        r3 = r3 * 9;
        r3 = r3 / 16;
        r2 = r2 - r3;
        r8 = java.lang.Math.max(r8, r2);
        goto L_0x0045;
    L_0x0043:
        r8 = r5.l;
    L_0x0045:
        r2 = 0;
        r3 = r5.f;
        r4 = r7.getHeight();
        r3 = r3 - r4;
        r2 = java.lang.Math.max(r2, r3);
        r5.a = r2;
        r2 = r5.f;
        r2 = r2 - r8;
        r8 = r5.a;
        r8 = java.lang.Math.max(r2, r8);
        r5.b = r8;
        r8 = r5.d;
        r2 = 3;
        if (r8 != r2) goto L_0x0069;
    L_0x0063:
        r8 = r5.a;
    L_0x0065:
        android.support.v4.h.r.c(r7, r8);
        goto L_0x008e;
    L_0x0069:
        r8 = r5.c;
        if (r8 == 0) goto L_0x0075;
    L_0x006d:
        r8 = r5.d;
        r2 = 5;
        if (r8 != r2) goto L_0x0075;
    L_0x0072:
        r8 = r5.f;
        goto L_0x0065;
    L_0x0075:
        r8 = r5.d;
        r2 = 4;
        if (r8 != r2) goto L_0x007d;
    L_0x007a:
        r8 = r5.b;
        goto L_0x0065;
    L_0x007d:
        r8 = r5.d;
        if (r8 == r1) goto L_0x0086;
    L_0x0081:
        r8 = r5.d;
        r2 = 2;
        if (r8 != r2) goto L_0x008e;
    L_0x0086:
        r8 = r7.getTop();
        r0 = r0 - r8;
        android.support.v4.h.r.c(r7, r0);
    L_0x008e:
        r8 = r5.e;
        if (r8 != 0) goto L_0x009a;
    L_0x0092:
        r8 = r5.v;
        r6 = android.support.v4.widget.q.a(r6, r8);
        r5.e = r6;
    L_0x009a:
        r6 = new java.lang.ref.WeakReference;
        r6.<init>(r7);
        r5.g = r6;
        r6 = new java.lang.ref.WeakReference;
        r7 = r5.a(r7);
        r6.<init>(r7);
        r5.h = r6;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.a(android.support.design.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = false;
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                a();
            }
            if (this.t == null) {
                this.t = VelocityTracker.obtain();
            }
            this.t.addMovement(motionEvent);
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        int x = (int) motionEvent.getX();
                        this.u = (int) motionEvent.getY();
                        View view = this.h != null ? (View) this.h.get() : null;
                        if (view != null && coordinatorLayout.a(view, x, this.u)) {
                            this.i = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.j = true;
                        }
                        boolean z2 = this.i == -1 && !coordinatorLayout.a((View) v, x, this.u);
                        this.p = z2;
                        break;
                    case 1:
                        break;
                }
            }
            this.j = false;
            this.i = -1;
            if (this.p) {
                this.p = false;
                return false;
            }
            if (!this.p && this.e.a(motionEvent)) {
                return true;
            }
            View view2 = (View) this.h.get();
            if (!(actionMasked != 2 || view2 == null || this.p || this.d == 1 || coordinatorLayout.a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.u) - motionEvent.getY()) <= ((float) this.e.a()))) {
                z = true;
            }
            return z;
        }
        this.p = true;
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.h.get() && (this.d != 3 || super.a(coordinatorLayout, (View) v, view, f, f2));
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.q = 0;
        this.r = false;
        return (i & 2) != 0;
    }

    boolean a(View view, float f) {
        return this.o ? true : view.getTop() < this.b ? false : Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.b)) / ((float) this.l) > 0.5f;
    }

    public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new b(super.b(coordinatorLayout, v), this.d);
    }

    void b(int i) {
        if (this.d != i) {
            this.d = i;
            View view = (View) this.g.get();
            if (!(view == null || this.s == null)) {
                this.s.a(view, i);
            }
        }
    }

    public void b(boolean z) {
        this.o = z;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.d == 1 && actionMasked == 0) {
            return true;
        }
        if (this.e != null) {
            this.e.b(motionEvent);
        }
        if (actionMasked == 0) {
            a();
        }
        if (this.t == null) {
            this.t = VelocityTracker.obtain();
        }
        this.t.addMovement(motionEvent);
        if (actionMasked == 2 && !this.p && Math.abs(((float) this.u) - motionEvent.getY()) > ((float) this.e.a())) {
            this.e.a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return this.p ^ true;
    }

    void c(int i) {
        View view = (View) this.g.get();
        if (view != null && this.s != null) {
            a aVar;
            float f;
            int i2;
            int i3;
            if (i > this.b) {
                aVar = this.s;
                f = (float) (this.b - i);
                i2 = this.f;
                i3 = this.b;
            } else {
                aVar = this.s;
                f = (float) (this.b - i);
                i2 = this.b;
                i3 = this.a;
            }
            aVar.a(view, f / ((float) (i2 - i3)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Missing block: B:22:0x004f, code:
            if (java.lang.Math.abs(r4 - r3.a) < java.lang.Math.abs(r4 - r3.b)) goto L_0x0023;
     */
    public void c(android.support.design.widget.CoordinatorLayout r4, V r5, android.view.View r6) {
        /*
        r3 = this;
        r4 = r5.getTop();
        r0 = r3.a;
        r1 = 3;
        if (r4 != r0) goto L_0x000d;
    L_0x0009:
        r3.b(r1);
        return;
    L_0x000d:
        r4 = r3.h;
        if (r4 == 0) goto L_0x0074;
    L_0x0011:
        r4 = r3.h;
        r4 = r4.get();
        if (r6 != r4) goto L_0x0074;
    L_0x0019:
        r4 = r3.r;
        if (r4 != 0) goto L_0x001e;
    L_0x001d:
        return;
    L_0x001e:
        r4 = r3.q;
        r6 = 4;
        if (r4 <= 0) goto L_0x0026;
    L_0x0023:
        r4 = r3.a;
        goto L_0x0055;
    L_0x0026:
        r4 = r3.c;
        if (r4 == 0) goto L_0x0038;
    L_0x002a:
        r4 = r3.b();
        r4 = r3.a(r5, r4);
        if (r4 == 0) goto L_0x0038;
    L_0x0034:
        r4 = r3.f;
        r1 = 5;
        goto L_0x0055;
    L_0x0038:
        r4 = r3.q;
        if (r4 != 0) goto L_0x0052;
    L_0x003c:
        r4 = r5.getTop();
        r0 = r3.a;
        r0 = r4 - r0;
        r0 = java.lang.Math.abs(r0);
        r2 = r3.b;
        r4 = r4 - r2;
        r4 = java.lang.Math.abs(r4);
        if (r0 >= r4) goto L_0x0052;
    L_0x0051:
        goto L_0x0023;
    L_0x0052:
        r4 = r3.b;
        r1 = r6;
    L_0x0055:
        r6 = r3.e;
        r0 = r5.getLeft();
        r4 = r6.a(r5, r0, r4);
        if (r4 == 0) goto L_0x006e;
    L_0x0061:
        r4 = 2;
        r3.b(r4);
        r4 = new android.support.design.widget.BottomSheetBehavior$c;
        r4.<init>(r5, r1);
        android.support.v4.h.r.a(r5, r4);
        goto L_0x0071;
    L_0x006e:
        r3.b(r1);
    L_0x0071:
        r4 = 0;
        r3.r = r4;
    L_0x0074:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.c(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.View):void");
    }
}
