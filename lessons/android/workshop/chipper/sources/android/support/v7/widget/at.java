package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class at extends ViewGroup implements android.support.v4.h.k {
    static final Interpolator I = new Interpolator() {
        public float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }
    };
    private static final int[] J = new int[]{16843830};
    private static final int[] K = new int[]{16842987};
    private static final boolean L = (VERSION.SDK_INT >= 21);
    private static final boolean M = (VERSION.SDK_INT <= 15);
    private static final boolean N = (VERSION.SDK_INT <= 15);
    private static final Class<?>[] O = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final boolean a;
    static final boolean b = (VERSION.SDK_INT >= 23);
    static final boolean c = (VERSION.SDK_INT >= 16);
    al A;
    a B;
    final u C;
    boolean D;
    boolean E;
    boolean F;
    au G;
    final List<x> H;
    private final r P;
    private s Q;
    private final Rect R;
    private final ArrayList<m> S;
    private m T;
    private int U;
    private boolean V;
    private int W;
    private d aA;
    private final int[] aB;
    private android.support.v4.h.l aC;
    private final int[] aD;
    private final int[] aE;
    private final int[] aF;
    private Runnable aG;
    private final b aH;
    private final AccessibilityManager aa;
    private List<k> ab;
    private int ac;
    private int ad;
    private e ae;
    private EdgeEffect af;
    private EdgeEffect ag;
    private EdgeEffect ah;
    private EdgeEffect ai;
    private int aj;
    private int ak;
    private VelocityTracker al;
    private int am;
    private int an;
    private int ao;
    private int ap;
    private int aq;
    private l ar;
    private final int as;
    private final int at;
    private float au;
    private float av;
    private boolean aw;
    private n ax;
    private List<n> ay;
    private b az;
    final p d;
    e e;
    ac f;
    final bn g;
    boolean h;
    final Runnable i;
    final Rect j;
    final RectF k;
    a l;
    i m;
    q n;
    final ArrayList<h> o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    f y;
    final w z;

    public static abstract class a<VH extends x> {
        private final b a;
        private boolean b;

        public abstract int a();

        public int a(int i) {
            return 0;
        }

        public abstract VH a(ViewGroup viewGroup, int i);

        public void a(c cVar) {
            this.a.registerObserver(cVar);
        }

        public void a(VH vh) {
        }

        public abstract void a(VH vh, int i);

        public void a(VH vh, int i, List<Object> list) {
            a((x) vh, i);
        }

        public void a(at atVar) {
        }

        public long b(int i) {
            return -1;
        }

        public final VH b(ViewGroup viewGroup, int i) {
            try {
                android.support.v4.d.c.a("RV CreateView");
                VH a = a(viewGroup, i);
                if (a.a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                a.f = i;
                return a;
            } finally {
                android.support.v4.d.c.a();
            }
        }

        public void b(c cVar) {
            this.a.unregisterObserver(cVar);
        }

        public final void b(VH vh, int i) {
            vh.c = i;
            if (b()) {
                vh.e = b(i);
            }
            vh.a(1, 519);
            android.support.v4.d.c.a("RV OnBindView");
            a(vh, i, vh.u());
            vh.t();
            LayoutParams layoutParams = vh.a.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).e = true;
            }
            android.support.v4.d.c.a();
        }

        public void b(at atVar) {
        }

        public final boolean b() {
            return this.b;
        }

        public boolean b(VH vh) {
            return false;
        }

        public void c(VH vh) {
        }

        public void d(VH vh) {
        }
    }

    static class b extends Observable<c> {
    }

    public static abstract class c {
    }

    public interface d {
        int a(int i, int i2);
    }

    public static class e {
        protected EdgeEffect a(at atVar, int i) {
            return new EdgeEffect(atVar.getContext());
        }
    }

    public static abstract class f {
        private b a = null;
        private ArrayList<a> b = new ArrayList();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(x xVar);
        }

        public static class c {
            public int a;
            public int b;
            public int c;
            public int d;

            public c a(x xVar) {
                return a(xVar, 0);
            }

            public c a(x xVar, int i) {
                View view = xVar.a;
                this.a = view.getLeft();
                this.b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        static int e(x xVar) {
            int d = xVar.n & 14;
            if (xVar.n()) {
                return 4;
            }
            if ((d & 4) == 0) {
                int f = xVar.f();
                int e = xVar.e();
                if (!(f == -1 || e == -1 || f == e)) {
                    d |= 2048;
                }
            }
            return d;
        }

        public c a(u uVar, x xVar) {
            return j().a(xVar);
        }

        public c a(u uVar, x xVar, int i, List<Object> list) {
            return j().a(xVar);
        }

        public abstract void a();

        void a(b bVar) {
            this.a = bVar;
        }

        public abstract boolean a(x xVar, c cVar, c cVar2);

        public abstract boolean a(x xVar, x xVar2, c cVar, c cVar2);

        public boolean a(x xVar, List<Object> list) {
            return h(xVar);
        }

        public abstract boolean b();

        public abstract boolean b(x xVar, c cVar, c cVar2);

        public abstract boolean c(x xVar, c cVar, c cVar2);

        public abstract void d();

        public abstract void d(x xVar);

        public long e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }

        public final void f(x xVar) {
            g(xVar);
            if (this.a != null) {
                this.a.a(xVar);
            }
        }

        public long g() {
            return this.d;
        }

        public void g(x xVar) {
        }

        public long h() {
            return this.f;
        }

        public boolean h(x xVar) {
            return true;
        }

        public final void i() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((a) this.b.get(i)).a();
            }
            this.b.clear();
        }

        public c j() {
            return new c();
        }
    }

    public static abstract class h {
        @Deprecated
        public void a(Canvas canvas, at atVar) {
        }

        public void a(Canvas canvas, at atVar, u uVar) {
            b(canvas, atVar);
        }

        @Deprecated
        public void a(Rect rect, int i, at atVar) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, at atVar, u uVar) {
            a(rect, ((j) view.getLayoutParams()).f(), atVar);
        }

        @Deprecated
        public void b(Canvas canvas, at atVar) {
        }

        public void b(Canvas canvas, at atVar, u uVar) {
            a(canvas, atVar);
        }
    }

    public static abstract class i {
        private final b a = new b() {
            public int a() {
                return i.this.A();
            }

            public int a(View view) {
                return i.this.h(view) - ((j) view.getLayoutParams()).leftMargin;
            }

            public View a(int i) {
                return i.this.h(i);
            }

            public int b() {
                return i.this.y() - i.this.C();
            }

            public int b(View view) {
                return i.this.j(view) + ((j) view.getLayoutParams()).rightMargin;
            }
        };
        private final b b = new b() {
            public int a() {
                return i.this.B();
            }

            public int a(View view) {
                return i.this.i(view) - ((j) view.getLayoutParams()).topMargin;
            }

            public View a(int i) {
                return i.this.h(i);
            }

            public int b() {
                return i.this.z() - i.this.D();
            }

            public int b(View view) {
                return i.this.k(view) + ((j) view.getLayoutParams()).bottomMargin;
            }
        };
        private boolean c = true;
        private boolean d = true;
        private int e;
        private int f;
        private int g;
        private int h;
        ac p;
        at q;
        bm r = new bm(this.a);
        bm s = new bm(this.b);
        t t;
        boolean u = false;
        boolean v = false;
        boolean w = false;
        int x;
        boolean y;

        public interface a {
            void b(int i, int i2);
        }

        public static class b {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public static int a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            i = MeasureSpec.getSize(i);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i, Math.max(i2, i3));
            }
            if (mode != 1073741824) {
                i = Math.max(i2, i3);
            }
            return i;
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            i -= i3;
            i3 = 0;
            i = Math.max(0, i);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i4 = i;
                        } else {
                            i2 = 0;
                            i4 = i2;
                        }
                        i3 = i2;
                        i = i4;
                        return MeasureSpec.makeMeasureSpec(i, i3);
                    }
                    i = 0;
                    return MeasureSpec.makeMeasureSpec(i, i3);
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i3 = i2;
                } else {
                    if (i4 == -2) {
                        if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                            i3 = Integer.MIN_VALUE;
                        }
                    }
                    i = 0;
                }
                return MeasureSpec.makeMeasureSpec(i, i3);
            }
            i = i4;
            i3 = 1073741824;
            return MeasureSpec.makeMeasureSpec(i, i3);
        }

        public static b a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.d.a.b.RecyclerView, i, i2);
            bVar.a = obtainStyledAttributes.getInt(android.support.v7.d.a.b.RecyclerView_android_orientation, 1);
            bVar.b = obtainStyledAttributes.getInt(android.support.v7.d.a.b.RecyclerView_spanCount, 1);
            bVar.c = obtainStyledAttributes.getBoolean(android.support.v7.d.a.b.RecyclerView_reverseLayout, false);
            bVar.d = obtainStyledAttributes.getBoolean(android.support.v7.d.a.b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        private void a(int i, View view) {
            this.p.e(i);
        }

        private void a(p pVar, int i, View view) {
            x e = at.e(view);
            if (!e.c()) {
                if (!e.n() || e.q() || this.q.l.b()) {
                    g(i);
                    pVar.c(view);
                    this.q.g.h(e);
                    return;
                }
                f(i);
                pVar.b(e);
            }
        }

        private void a(t tVar) {
            if (this.t == tVar) {
                this.t = null;
            }
        }

        private void a(View view, int i, boolean z) {
            x e = at.e(view);
            if (z || e.q()) {
                this.q.g.e(e);
            } else {
                this.q.g.f(e);
            }
            j jVar = (j) view.getLayoutParams();
            if (e.k() || e.i()) {
                if (e.i()) {
                    e.j();
                } else {
                    e.l();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int b = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (b == -1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    stringBuilder.append(this.q.indexOfChild(view));
                    stringBuilder.append(this.q.a());
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (b != i) {
                    this.q.m.e(b, i);
                }
            } else {
                this.p.a(view, i, false);
                jVar.e = true;
                if (this.t != null && this.t.c()) {
                    this.t.b(view);
                }
            }
            if (jVar.f) {
                e.a.invalidate();
                jVar.f = false;
            }
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            i2 = MeasureSpec.getSize(i2);
            boolean z = false;
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                if (i2 >= i) {
                    z = true;
                }
                return z;
            } else if (mode == 0) {
                return true;
            } else {
                if (mode != 1073741824) {
                    return false;
                }
                if (i2 == i) {
                    z = true;
                }
                return z;
            }
        }

        private int[] b(at atVar, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int A = A();
            int B = B();
            int y = y() - C();
            int z2 = z() - D();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            left -= A;
            int min = Math.min(0, left);
            top -= B;
            B = Math.min(0, top);
            width -= y;
            y = Math.max(0, width);
            height = Math.max(0, height - z2);
            if (t() != 1) {
                if (min == 0) {
                    min = Math.min(left, y);
                }
                y = min;
            } else if (y == 0) {
                y = Math.max(min, width);
            }
            if (B == 0) {
                B = Math.min(top, height);
            }
            iArr[0] = y;
            iArr[1] = B;
            return iArr;
        }

        /* JADX WARNING: Missing block: B:14:0x0040, code:
            return false;
     */
        private boolean d(android.support.v7.widget.at r7, int r8, int r9) {
            /*
            r6 = this;
            r7 = r7.getFocusedChild();
            r0 = 0;
            if (r7 != 0) goto L_0x0008;
        L_0x0007:
            return r0;
        L_0x0008:
            r1 = r6.A();
            r2 = r6.B();
            r3 = r6.y();
            r4 = r6.C();
            r3 = r3 - r4;
            r4 = r6.z();
            r5 = r6.D();
            r4 = r4 - r5;
            r5 = r6.q;
            r5 = r5.j;
            r6.a(r7, r5);
            r6 = r5.left;
            r6 = r6 - r8;
            if (r6 >= r3) goto L_0x0040;
        L_0x002e:
            r6 = r5.right;
            r6 = r6 - r8;
            if (r6 <= r1) goto L_0x0040;
        L_0x0033:
            r6 = r5.top;
            r6 = r6 - r9;
            if (r6 >= r4) goto L_0x0040;
        L_0x0038:
            r6 = r5.bottom;
            r6 = r6 - r9;
            if (r6 > r2) goto L_0x003e;
        L_0x003d:
            return r0;
        L_0x003e:
            r6 = 1;
            return r6;
        L_0x0040:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.i.d(android.support.v7.widget.at, int, int):boolean");
        }

        public int A() {
            return this.q != null ? this.q.getPaddingLeft() : 0;
        }

        public int B() {
            return this.q != null ? this.q.getPaddingTop() : 0;
        }

        public int C() {
            return this.q != null ? this.q.getPaddingRight() : 0;
        }

        public int D() {
            return this.q != null ? this.q.getPaddingBottom() : 0;
        }

        public View E() {
            if (this.q == null) {
                return null;
            }
            View focusedChild = this.q.getFocusedChild();
            return (focusedChild == null || this.p.c(focusedChild)) ? null : focusedChild;
        }

        public int F() {
            return android.support.v4.h.r.h(this.q);
        }

        public int G() {
            return android.support.v4.h.r.i(this.q);
        }

        void H() {
            if (this.t != null) {
                this.t.a();
            }
        }

        public void I() {
            this.u = true;
        }

        boolean J() {
            int v = v();
            for (int i = 0; i < v; i++) {
                LayoutParams layoutParams = h(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int a(int i, p pVar, u uVar) {
            return 0;
        }

        public int a(p pVar, u uVar) {
            int i = 1;
            if (this.q != null) {
                if (this.q.l == null) {
                    return 1;
                }
                if (f()) {
                    i = this.q.l.a();
                }
            }
            return i;
        }

        public abstract j a();

        public j a(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public j a(LayoutParams layoutParams) {
            return layoutParams instanceof j ? new j((j) layoutParams) : layoutParams instanceof MarginLayoutParams ? new j((MarginLayoutParams) layoutParams) : new j(layoutParams);
        }

        public View a(View view, int i, p pVar, u uVar) {
            return null;
        }

        public void a(int i, int i2, u uVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(int i, p pVar) {
            View h = h(i);
            f(i);
            pVar.a(h);
        }

        public void a(Rect rect, int i, int i2) {
            f(a(i, (rect.width() + A()) + C(), F()), a(i2, (rect.height() + B()) + D(), G()));
        }

        public void a(Parcelable parcelable) {
        }

        void a(android.support.v4.h.a.b bVar) {
            a(this.q.d, this.q.C, bVar);
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(p pVar) {
            for (int v = v() - 1; v >= 0; v--) {
                a(pVar, v, h(v));
            }
        }

        public void a(p pVar, u uVar, int i, int i2) {
            this.q.e(i, i2);
        }

        public void a(p pVar, u uVar, android.support.v4.h.a.b bVar) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                bVar.a(8192);
                bVar.c(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                bVar.a(4096);
                bVar.c(true);
            }
            bVar.a(android.support.v4.h.a.b.a.a(a(pVar, uVar), b(pVar, uVar), e(pVar, uVar), d(pVar, uVar)));
        }

        public void a(p pVar, u uVar, View view, android.support.v4.h.a.b bVar) {
            int i = 0;
            int d = f() ? d(view) : 0;
            if (e()) {
                i = d(view);
            }
            bVar.b(android.support.v4.h.a.b.b.a(d, 1, i, 1, false, false));
        }

        public void a(p pVar, u uVar, AccessibilityEvent accessibilityEvent) {
            if (this.q != null && accessibilityEvent != null) {
                boolean z = true;
                if (!(this.q.canScrollVertically(1) || this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1) || this.q.canScrollHorizontally(1))) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.q.l != null) {
                    accessibilityEvent.setItemCount(this.q.l.a());
                }
            }
        }

        public void a(u uVar) {
        }

        public void a(at atVar) {
        }

        public void a(at atVar, int i, int i2) {
        }

        public void a(at atVar, int i, int i2, int i3) {
        }

        public void a(at atVar, int i, int i2, Object obj) {
            c(atVar, i, i2);
        }

        public void a(at atVar, p pVar) {
            e(atVar);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void a(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect i3 = this.q.i(view);
            i2 += i3.top + i3.bottom;
            i = a(y(), w(), (((A() + C()) + jVar.leftMargin) + jVar.rightMargin) + (i + (i3.left + i3.right)), jVar.width, e());
            i2 = a(z(), x(), (((B() + D()) + jVar.topMargin) + jVar.bottomMargin) + i2, jVar.height, f());
            if (b(view, i, i2, jVar)) {
                view.measure(i, i2);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.d;
            view.layout((i + rect.left) + jVar.leftMargin, (i2 + rect.top) + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public void a(View view, int i, j jVar) {
            x e = at.e(view);
            if (e.q()) {
                this.q.g.e(e);
            } else {
                this.q.g.f(e);
            }
            this.p.a(view, i, jVar, e.q());
        }

        public void a(View view, Rect rect) {
            at.a(view, rect);
        }

        void a(View view, android.support.v4.h.a.b bVar) {
            x e = at.e(view);
            if (e != null && !e.q() && !this.p.c(e.a)) {
                a(this.q.d, this.q.C, view, bVar);
            }
        }

        public void a(View view, p pVar) {
            c(view);
            pVar.a(view);
        }

        public void a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((j) view.getLayoutParams()).d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null) {
                Matrix matrix = view.getMatrix();
                if (!(matrix == null || matrix.isIdentity())) {
                    RectF rectF = this.q.k;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.d, this.q.C, accessibilityEvent);
        }

        public void a(String str) {
            if (this.q != null) {
                this.q.a(str);
            }
        }

        boolean a(int i, Bundle bundle) {
            return a(this.q.d, this.q.C, i, bundle);
        }

        public boolean a(j jVar) {
            return jVar != null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0076 A:{SKIP} */
        public boolean a(android.support.v7.widget.at.p r2, android.support.v7.widget.at.u r3, int r4, android.os.Bundle r5) {
            /*
            r1 = this;
            r2 = r1.q;
            r3 = 0;
            if (r2 != 0) goto L_0x0006;
        L_0x0005:
            return r3;
        L_0x0006:
            r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            r5 = 1;
            if (r4 == r2) goto L_0x0044;
        L_0x000b:
            r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            if (r4 == r2) goto L_0x0012;
        L_0x000f:
            r2 = r3;
            r4 = r2;
            goto L_0x0074;
        L_0x0012:
            r2 = r1.q;
            r4 = -1;
            r2 = r2.canScrollVertically(r4);
            if (r2 == 0) goto L_0x002b;
        L_0x001b:
            r2 = r1.z();
            r0 = r1.B();
            r2 = r2 - r0;
            r0 = r1.D();
            r2 = r2 - r0;
            r2 = -r2;
            goto L_0x002c;
        L_0x002b:
            r2 = r3;
        L_0x002c:
            r0 = r1.q;
            r4 = r0.canScrollHorizontally(r4);
            if (r4 == 0) goto L_0x0073;
        L_0x0034:
            r4 = r1.y();
            r0 = r1.A();
            r4 = r4 - r0;
            r0 = r1.C();
            r4 = r4 - r0;
            r4 = -r4;
            goto L_0x0074;
        L_0x0044:
            r2 = r1.q;
            r2 = r2.canScrollVertically(r5);
            if (r2 == 0) goto L_0x005b;
        L_0x004c:
            r2 = r1.z();
            r4 = r1.B();
            r2 = r2 - r4;
            r4 = r1.D();
            r2 = r2 - r4;
            goto L_0x005c;
        L_0x005b:
            r2 = r3;
        L_0x005c:
            r4 = r1.q;
            r4 = r4.canScrollHorizontally(r5);
            if (r4 == 0) goto L_0x0073;
        L_0x0064:
            r4 = r1.y();
            r0 = r1.A();
            r4 = r4 - r0;
            r0 = r1.C();
            r4 = r4 - r0;
            goto L_0x0074;
        L_0x0073:
            r4 = r3;
        L_0x0074:
            if (r2 != 0) goto L_0x0079;
        L_0x0076:
            if (r4 != 0) goto L_0x0079;
        L_0x0078:
            return r3;
        L_0x0079:
            r1 = r1.q;
            r1.scrollBy(r4, r2);
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.i.a(android.support.v7.widget.at$p, android.support.v7.widget.at$u, int, android.os.Bundle):boolean");
        }

        public boolean a(p pVar, u uVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(at atVar, u uVar, View view, View view2) {
            return a(atVar, view, view2);
        }

        public boolean a(at atVar, View view, Rect rect, boolean z) {
            return a(atVar, view, rect, z, false);
        }

        public boolean a(at atVar, View view, Rect rect, boolean z, boolean z2) {
            int[] b = b(atVar, view, rect, z);
            int i = b[0];
            int i2 = b[1];
            if ((z2 && !d(atVar, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                atVar.scrollBy(i, i2);
                return true;
            }
            atVar.a(i, i2);
            return true;
        }

        @Deprecated
        public boolean a(at atVar, View view, View view2) {
            return s() || atVar.o();
        }

        public boolean a(at atVar, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        boolean a(View view, int i, int i2, j jVar) {
            return (this.c && b(view.getMeasuredWidth(), i, jVar.width) && b(view.getMeasuredHeight(), i2, jVar.height)) ? false : true;
        }

        boolean a(View view, int i, Bundle bundle) {
            return a(this.q.d, this.q.C, view, i, bundle);
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.r.a(view, 24579) && this.s.a(view, 24579);
            return z ? z3 : z3 ^ true;
        }

        public boolean a(Runnable runnable) {
            return this.q != null ? this.q.removeCallbacks(runnable) : false;
        }

        public int b(int i, p pVar, u uVar) {
            return 0;
        }

        public int b(p pVar, u uVar) {
            int i = 1;
            if (this.q != null) {
                if (this.q.l == null) {
                    return 1;
                }
                if (e()) {
                    i = this.q.l.a();
                }
            }
            return i;
        }

        void b(p pVar) {
            int e = pVar.e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = pVar.e(i);
                x e3 = at.e(e2);
                if (!e3.c()) {
                    e3.a(false);
                    if (e3.r()) {
                        this.q.removeDetachedView(e2, false);
                    }
                    if (this.q.y != null) {
                        this.q.y.d(e3);
                    }
                    e3.a(true);
                    pVar.b(e2);
                }
            }
            pVar.f();
            if (e > 0) {
                this.q.invalidate();
            }
        }

        void b(at atVar) {
            int i;
            if (atVar == null) {
                this.q = null;
                this.p = null;
                i = 0;
                this.g = 0;
            } else {
                this.q = atVar;
                this.p = atVar.f;
                this.g = atVar.getWidth();
                i = atVar.getHeight();
            }
            this.h = i;
            this.e = 1073741824;
            this.f = 1073741824;
        }

        public void b(at atVar, int i, int i2) {
        }

        void b(at atVar, p pVar) {
            this.v = false;
            a(atVar, pVar);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        public void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.i(view));
            }
        }

        public boolean b() {
            return false;
        }

        boolean b(View view, int i, int i2, j jVar) {
            return (!view.isLayoutRequested() && this.c && b(view.getWidth(), i, jVar.width) && b(view.getHeight(), i2, jVar.height)) ? false : true;
        }

        public int c(u uVar) {
            return 0;
        }

        public View c(int i) {
            int v = v();
            for (int i2 = 0; i2 < v; i2++) {
                View h = h(i2);
                x e = at.e(h);
                if (e != null && e.d() == i && !e.c() && (this.q.C.a() || !e.q())) {
                    return h;
                }
            }
            return null;
        }

        void c(int i, int i2) {
            this.g = MeasureSpec.getSize(i);
            this.e = MeasureSpec.getMode(i);
            if (this.e == 0 && !at.b) {
                this.g = 0;
            }
            this.h = MeasureSpec.getSize(i2);
            this.f = MeasureSpec.getMode(i2);
            if (this.f == 0 && !at.b) {
                this.h = 0;
            }
        }

        public void c(p pVar) {
            for (int v = v() - 1; v >= 0; v--) {
                if (!at.e(h(v)).c()) {
                    a(v, pVar);
                }
            }
        }

        public void c(p pVar, u uVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void c(at atVar) {
            this.v = true;
            d(atVar);
        }

        public void c(at atVar, int i, int i2) {
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void c(View view, int i) {
            a(view, i, (j) view.getLayoutParams());
        }

        public boolean c() {
            return this.w;
        }

        public int d(p pVar, u uVar) {
            return 0;
        }

        public int d(u uVar) {
            return 0;
        }

        public int d(View view) {
            return ((j) view.getLayoutParams()).f();
        }

        public Parcelable d() {
            return null;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(int i) {
        }

        void d(int i, int i2) {
            int v = v();
            if (v == 0) {
                this.q.e(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = i4;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < v; i7++) {
                View h = h(i7);
                Rect rect = this.q.j;
                a(h, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i4) {
                    i4 = rect.right;
                }
                if (rect.top < i6) {
                    i6 = rect.top;
                }
                if (rect.bottom > i5) {
                    i5 = rect.bottom;
                }
            }
            this.q.j.set(i3, i6, i4, i5);
            a(this.q.j, i, i2);
        }

        public void d(at atVar) {
        }

        public int e(u uVar) {
            return 0;
        }

        public View e(View view) {
            if (this.q == null) {
                return null;
            }
            view = this.q.c(view);
            return (view == null || this.p.c(view)) ? null : view;
        }

        public void e(int i, int i2) {
            View h = h(i);
            if (h == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot move a child from non-existing index:");
                stringBuilder.append(i);
                stringBuilder.append(this.q.toString());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            g(i);
            c(h, i2);
        }

        @Deprecated
        public void e(at atVar) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(p pVar, u uVar) {
            return false;
        }

        public int f(u uVar) {
            return 0;
        }

        public int f(View view) {
            Rect rect = ((j) view.getLayoutParams()).d;
            return (view.getMeasuredWidth() + rect.left) + rect.right;
        }

        public void f(int i) {
            if (h(i) != null) {
                this.p.a(i);
            }
        }

        public void f(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        void f(at atVar) {
            c(MeasureSpec.makeMeasureSpec(atVar.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(atVar.getHeight(), 1073741824));
        }

        public boolean f() {
            return false;
        }

        public int g(u uVar) {
            return 0;
        }

        public int g(View view) {
            Rect rect = ((j) view.getLayoutParams()).d;
            return (view.getMeasuredHeight() + rect.top) + rect.bottom;
        }

        public void g(int i) {
            a(i, h(i));
        }

        public int h(u uVar) {
            return 0;
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public View h(int i) {
            return this.p != null ? this.p.b(i) : null;
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public void i(int i) {
            if (this.q != null) {
                this.q.d(i);
            }
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public void j(int i) {
            if (this.q != null) {
                this.q.c(i);
            }
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void k(int i) {
        }

        public int l(View view) {
            return ((j) view.getLayoutParams()).d.top;
        }

        boolean l() {
            return false;
        }

        public int m(View view) {
            return ((j) view.getLayoutParams()).d.bottom;
        }

        public int n(View view) {
            return ((j) view.getLayoutParams()).d.left;
        }

        public int o(View view) {
            return ((j) view.getLayoutParams()).d.right;
        }

        public void o() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public final boolean p() {
            return this.d;
        }

        public boolean q() {
            return this.v;
        }

        public boolean r() {
            return this.q != null && this.q.h;
        }

        public boolean s() {
            return this.t != null && this.t.c();
        }

        public int t() {
            return android.support.v4.h.r.e(this.q);
        }

        public int u() {
            return -1;
        }

        public int v() {
            return this.p != null ? this.p.b() : 0;
        }

        public int w() {
            return this.e;
        }

        public int x() {
            return this.f;
        }

        public int y() {
            return this.g;
        }

        public int z() {
            return this.h;
        }
    }

    public static class j extends MarginLayoutParams {
        x c;
        final Rect d = new Rect();
        boolean e = true;
        boolean f = false;

        public j(int i, int i2) {
            super(i, i2);
        }

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public j(j jVar) {
            super(jVar);
        }

        public j(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public j(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean c() {
            return this.c.n();
        }

        public boolean d() {
            return this.c.q();
        }

        public boolean e() {
            return this.c.x();
        }

        public int f() {
            return this.c.d();
        }
    }

    public interface k {
        void a(View view);

        void b(View view);
    }

    public static abstract class l {
        public abstract boolean a(int i, int i2);
    }

    public interface m {
        void a(boolean z);

        boolean a(at atVar, MotionEvent motionEvent);

        void b(at atVar, MotionEvent motionEvent);
    }

    public static abstract class n {
        public void a(at atVar, int i) {
        }

        public void a(at atVar, int i, int i2) {
        }
    }

    public static class o {
        SparseArray<a> a = new SparseArray();
        private int b = 0;

        static class a {
            final ArrayList<x> a = new ArrayList();
            int b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        private a b(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            aVar = new a();
            this.a.put(i, aVar);
            return aVar;
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public x a(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.a;
            return (x) arrayList.remove(arrayList.size() - 1);
        }

        public void a() {
            for (int i = 0; i < this.a.size(); i++) {
                ((a) this.a.valueAt(i)).a.clear();
            }
        }

        void a(int i, long j) {
            a b = b(i);
            b.c = a(b.c, j);
        }

        void a(a aVar) {
            this.b++;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                b();
            }
            if (!z && this.b == 0) {
                a();
            }
            if (aVar2 != null) {
                a(aVar2);
            }
        }

        public void a(x xVar) {
            int h = xVar.h();
            ArrayList arrayList = b(h).a;
            if (((a) this.a.get(h)).b > arrayList.size()) {
                xVar.v();
                arrayList.add(xVar);
            }
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        void b() {
            this.b--;
        }

        void b(int i, long j) {
            a b = b(i);
            b.d = a(b.d, j);
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j + j3 < j2;
        }
    }

    public final class p {
        final ArrayList<x> a = new ArrayList();
        ArrayList<x> b = null;
        final ArrayList<x> c = new ArrayList();
        int d = 2;
        o e;
        private final List<x> g = Collections.unmodifiableList(this.a);
        private int h = 2;
        private v i;

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        private boolean a(x xVar, int i, int i2, long j) {
            xVar.m = at.this;
            int h = xVar.h();
            long nanoTime = at.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.e.b(h, nanoTime, j)) {
                return false;
            }
            at.this.l.b(xVar, i);
            this.e.b(xVar.h(), at.this.getNanoTime() - nanoTime);
            e(xVar);
            if (at.this.C.a()) {
                xVar.g = i2;
            }
            return true;
        }

        private void e(x xVar) {
            if (at.this.n()) {
                View view = xVar.a;
                if (android.support.v4.h.r.d(view) == 0) {
                    android.support.v4.h.r.a(view, 1);
                }
                if (!android.support.v4.h.r.a(view)) {
                    xVar.b(16384);
                    android.support.v4.h.r.a(view, at.this.G.c());
                }
            }
        }

        private void f(x xVar) {
            if (xVar.a instanceof ViewGroup) {
                a((ViewGroup) xVar.a, false);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:96:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x020a  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01af  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x020a  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01af  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01d4  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x020a  */
        android.support.v7.widget.at.x a(int r18, boolean r19, long r20) {
            /*
            r17 = this;
            r6 = r17;
            r3 = r18;
            r0 = r19;
            if (r3 < 0) goto L_0x0234;
        L_0x0008:
            r1 = android.support.v7.widget.at.this;
            r1 = r1.C;
            r1 = r1.e();
            if (r3 < r1) goto L_0x0014;
        L_0x0012:
            goto L_0x0234;
        L_0x0014:
            r1 = android.support.v7.widget.at.this;
            r1 = r1.C;
            r1 = r1.a();
            r2 = 0;
            r7 = 1;
            r8 = 0;
            if (r1 == 0) goto L_0x0029;
        L_0x0021:
            r1 = r17.f(r18);
            if (r1 == 0) goto L_0x002a;
        L_0x0027:
            r4 = r7;
            goto L_0x002b;
        L_0x0029:
            r1 = r2;
        L_0x002a:
            r4 = r8;
        L_0x002b:
            if (r1 != 0) goto L_0x005f;
        L_0x002d:
            r1 = r17.b(r18, r19);
            if (r1 == 0) goto L_0x005f;
        L_0x0033:
            r5 = r6.a(r1);
            if (r5 != 0) goto L_0x005e;
        L_0x0039:
            if (r0 != 0) goto L_0x005c;
        L_0x003b:
            r5 = 4;
            r1.b(r5);
            r5 = r1.i();
            if (r5 == 0) goto L_0x0050;
        L_0x0045:
            r5 = android.support.v7.widget.at.this;
            r9 = r1.a;
            r5.removeDetachedView(r9, r8);
            r1.j();
            goto L_0x0059;
        L_0x0050:
            r5 = r1.k();
            if (r5 == 0) goto L_0x0059;
        L_0x0056:
            r1.l();
        L_0x0059:
            r6.b(r1);
        L_0x005c:
            r1 = r2;
            goto L_0x005f;
        L_0x005e:
            r4 = r7;
        L_0x005f:
            if (r1 != 0) goto L_0x018e;
        L_0x0061:
            r5 = android.support.v7.widget.at.this;
            r5 = r5.e;
            r5 = r5.b(r3);
            if (r5 < 0) goto L_0x0151;
        L_0x006b:
            r9 = android.support.v7.widget.at.this;
            r9 = r9.l;
            r9 = r9.a();
            if (r5 < r9) goto L_0x0077;
        L_0x0075:
            goto L_0x0151;
        L_0x0077:
            r9 = android.support.v7.widget.at.this;
            r9 = r9.l;
            r9 = r9.a(r5);
            r10 = android.support.v7.widget.at.this;
            r10 = r10.l;
            r10 = r10.b();
            if (r10 == 0) goto L_0x009a;
        L_0x0089:
            r1 = android.support.v7.widget.at.this;
            r1 = r1.l;
            r10 = r1.b(r5);
            r1 = r6.a(r10, r9, r0);
            if (r1 == 0) goto L_0x009a;
        L_0x0097:
            r1.c = r5;
            r4 = r7;
        L_0x009a:
            if (r1 != 0) goto L_0x00f0;
        L_0x009c:
            r0 = r6.i;
            if (r0 == 0) goto L_0x00f0;
        L_0x00a0:
            r0 = r6.i;
            r0 = r0.a(r6, r3, r9);
            if (r0 == 0) goto L_0x00f0;
        L_0x00a8:
            r1 = android.support.v7.widget.at.this;
            r1 = r1.b(r0);
            if (r1 != 0) goto L_0x00cd;
        L_0x00b0:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder";
            r1.append(r2);
            r2 = android.support.v7.widget.at.this;
            r2 = r2.a();
            r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
        L_0x00cd:
            r0 = r1.c();
            if (r0 == 0) goto L_0x00f0;
        L_0x00d3:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.";
            r1.append(r2);
            r2 = android.support.v7.widget.at.this;
            r2 = r2.a();
            r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
        L_0x00f0:
            if (r1 != 0) goto L_0x0106;
        L_0x00f2:
            r0 = r17.g();
            r1 = r0.a(r9);
            if (r1 == 0) goto L_0x0106;
        L_0x00fc:
            r1.v();
            r0 = android.support.v7.widget.at.a;
            if (r0 == 0) goto L_0x0106;
        L_0x0103:
            r6.f(r1);
        L_0x0106:
            if (r1 != 0) goto L_0x018e;
        L_0x0108:
            r0 = android.support.v7.widget.at.this;
            r0 = r0.getNanoTime();
            r10 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r5 = (r20 > r10 ? 1 : (r20 == r10 ? 0 : -1));
            if (r5 == 0) goto L_0x0124;
        L_0x0117:
            r10 = r6.e;
            r11 = r9;
            r12 = r0;
            r14 = r20;
            r5 = r10.a(r11, r12, r14);
            if (r5 != 0) goto L_0x0124;
        L_0x0123:
            return r2;
        L_0x0124:
            r2 = android.support.v7.widget.at.this;
            r2 = r2.l;
            r5 = android.support.v7.widget.at.this;
            r2 = r2.b(r5, r9);
            r5 = android.support.v7.widget.at.L;
            if (r5 == 0) goto L_0x0143;
        L_0x0134:
            r5 = r2.a;
            r5 = android.support.v7.widget.at.j(r5);
            if (r5 == 0) goto L_0x0143;
        L_0x013c:
            r10 = new java.lang.ref.WeakReference;
            r10.<init>(r5);
            r2.b = r10;
        L_0x0143:
            r5 = android.support.v7.widget.at.this;
            r10 = r5.getNanoTime();
            r5 = r6.e;
            r10 = r10 - r0;
            r5.a(r9, r10);
            r10 = r2;
            goto L_0x018f;
        L_0x0151:
            r0 = new java.lang.IndexOutOfBoundsException;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Inconsistency detected. Invalid item position ";
            r1.append(r2);
            r1.append(r3);
            r2 = "(offset:";
            r1.append(r2);
            r1.append(r5);
            r2 = ").";
            r1.append(r2);
            r2 = "state:";
            r1.append(r2);
            r2 = android.support.v7.widget.at.this;
            r2 = r2.C;
            r2 = r2.e();
            r1.append(r2);
            r2 = android.support.v7.widget.at.this;
            r2 = r2.a();
            r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
        L_0x018e:
            r10 = r1;
        L_0x018f:
            r9 = r4;
            if (r9 == 0) goto L_0x01ca;
        L_0x0192:
            r0 = android.support.v7.widget.at.this;
            r0 = r0.C;
            r0 = r0.a();
            if (r0 != 0) goto L_0x01ca;
        L_0x019c:
            r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r1 = r10.a(r0);
            if (r1 == 0) goto L_0x01ca;
        L_0x01a4:
            r10.a(r8, r0);
            r0 = android.support.v7.widget.at.this;
            r0 = r0.C;
            r0 = r0.i;
            if (r0 == 0) goto L_0x01ca;
        L_0x01af:
            r0 = android.support.v7.widget.at.f.e(r10);
            r0 = r0 | 4096;
            r1 = android.support.v7.widget.at.this;
            r1 = r1.y;
            r2 = android.support.v7.widget.at.this;
            r2 = r2.C;
            r4 = r10.u();
            r0 = r1.a(r2, r10, r0, r4);
            r1 = android.support.v7.widget.at.this;
            r1.a(r10, r0);
        L_0x01ca:
            r0 = android.support.v7.widget.at.this;
            r0 = r0.C;
            r0 = r0.a();
            if (r0 == 0) goto L_0x01dd;
        L_0x01d4:
            r0 = r10.p();
            if (r0 == 0) goto L_0x01dd;
        L_0x01da:
            r10.g = r3;
            goto L_0x01f0;
        L_0x01dd:
            r0 = r10.p();
            if (r0 == 0) goto L_0x01f2;
        L_0x01e3:
            r0 = r10.o();
            if (r0 != 0) goto L_0x01f2;
        L_0x01e9:
            r0 = r10.n();
            if (r0 == 0) goto L_0x01f0;
        L_0x01ef:
            goto L_0x01f2;
        L_0x01f0:
            r0 = r8;
            goto L_0x0202;
        L_0x01f2:
            r0 = android.support.v7.widget.at.this;
            r0 = r0.e;
            r2 = r0.b(r3);
            r0 = r6;
            r1 = r10;
            r4 = r20;
            r0 = r0.a(r1, r2, r3, r4);
        L_0x0202:
            r1 = r10.a;
            r1 = r1.getLayoutParams();
            if (r1 != 0) goto L_0x0218;
        L_0x020a:
            r1 = android.support.v7.widget.at.this;
            r1 = r1.generateDefaultLayoutParams();
        L_0x0210:
            r1 = (android.support.v7.widget.at.j) r1;
            r2 = r10.a;
            r2.setLayoutParams(r1);
            goto L_0x0229;
        L_0x0218:
            r2 = android.support.v7.widget.at.this;
            r2 = r2.checkLayoutParams(r1);
            if (r2 != 0) goto L_0x0227;
        L_0x0220:
            r2 = android.support.v7.widget.at.this;
            r1 = r2.generateLayoutParams(r1);
            goto L_0x0210;
        L_0x0227:
            r1 = (android.support.v7.widget.at.j) r1;
        L_0x0229:
            r1.c = r10;
            if (r9 == 0) goto L_0x0230;
        L_0x022d:
            if (r0 == 0) goto L_0x0230;
        L_0x022f:
            goto L_0x0231;
        L_0x0230:
            r7 = r8;
        L_0x0231:
            r1.f = r7;
            return r10;
        L_0x0234:
            r0 = new java.lang.IndexOutOfBoundsException;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Invalid item position ";
            r1.append(r2);
            r1.append(r3);
            r2 = "(";
            r1.append(r2);
            r1.append(r3);
            r2 = "). Item count:";
            r1.append(r2);
            r2 = android.support.v7.widget.at.this;
            r2 = r2.C;
            r2 = r2.e();
            r1.append(r2);
            r2 = android.support.v7.widget.at.this;
            r2 = r2.a();
            r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.p.a(int, boolean, long):android.support.v7.widget.at$x");
        }

        x a(long j, int i, boolean z) {
            int size;
            for (size = this.a.size() - 1; size >= 0; size--) {
                x xVar = (x) this.a.get(size);
                if (xVar.g() == j && !xVar.k()) {
                    if (i == xVar.h()) {
                        xVar.b(32);
                        if (xVar.q() && !at.this.C.a()) {
                            xVar.a(2, 14);
                        }
                        return xVar;
                    } else if (!z) {
                        this.a.remove(size);
                        at.this.removeDetachedView(xVar.a, false);
                        b(xVar.a);
                    }
                }
            }
            size = this.c.size();
            while (true) {
                size--;
                if (size < 0) {
                    return null;
                }
                x xVar2 = (x) this.c.get(size);
                if (xVar2.g() == j) {
                    if (i == xVar2.h()) {
                        if (!z) {
                            this.c.remove(size);
                        }
                        return xVar2;
                    } else if (!z) {
                        d(size);
                        return null;
                    }
                }
            }
        }

        View a(int i, boolean z) {
            return a(i, z, Long.MAX_VALUE).a;
        }

        public void a() {
            this.a.clear();
            d();
        }

        public void a(int i) {
            this.h = i;
            b();
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i4 = i2;
                i3 = -1;
                i5 = i;
            } else {
                i4 = i;
                i3 = 1;
                i5 = i2;
            }
            int size = this.c.size();
            for (int i6 = 0; i6 < size; i6++) {
                x xVar = (x) this.c.get(i6);
                if (xVar != null && xVar.c >= i5 && xVar.c <= i4) {
                    if (xVar.c == i) {
                        xVar.a(i2 - i, false);
                    } else {
                        xVar.a(i3, false);
                    }
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                x xVar = (x) this.c.get(size);
                if (xVar != null) {
                    if (xVar.c >= i3) {
                        xVar.a(-i2, z);
                    } else if (xVar.c >= i) {
                        xVar.b(8);
                        d(size);
                    }
                }
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            g().a(aVar, aVar2, z);
        }

        void a(o oVar) {
            if (this.e != null) {
                this.e.b();
            }
            this.e = oVar;
            if (oVar != null) {
                this.e.a(at.this.getAdapter());
            }
        }

        void a(v vVar) {
            this.i = vVar;
        }

        void a(x xVar, boolean z) {
            at.c(xVar);
            if (xVar.a(16384)) {
                xVar.a(0, 16384);
                android.support.v4.h.r.a(xVar.a, null);
            }
            if (z) {
                d(xVar);
            }
            xVar.m = null;
            g().a(xVar);
        }

        public void a(View view) {
            x e = at.e(view);
            if (e.r()) {
                at.this.removeDetachedView(view, false);
            }
            if (e.i()) {
                e.j();
            } else if (e.k()) {
                e.l();
            }
            b(e);
        }

        boolean a(x xVar) {
            if (xVar.q()) {
                return at.this.C.a();
            }
            if (xVar.c < 0 || xVar.c >= at.this.l.a()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
                stringBuilder.append(xVar);
                stringBuilder.append(at.this.a());
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            boolean z = false;
            if (!at.this.C.a() && at.this.l.a(xVar.c) != xVar.h()) {
                return false;
            }
            if (!at.this.l.b()) {
                return true;
            }
            if (xVar.g() == at.this.l.b(xVar.c)) {
                z = true;
            }
            return z;
        }

        public int b(int i) {
            if (i >= 0 && i < at.this.C.e()) {
                return !at.this.C.a() ? i : at.this.e.b(i);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("invalid position ");
                stringBuilder.append(i);
                stringBuilder.append(". State ");
                stringBuilder.append("item count is ");
                stringBuilder.append(at.this.C.e());
                stringBuilder.append(at.this.a());
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
        }

        x b(int i, boolean z) {
            int size = this.a.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                x xVar = (x) this.a.get(i3);
                if (xVar.k() || xVar.d() != i || xVar.n() || (!at.this.C.f && xVar.q())) {
                    i3++;
                } else {
                    xVar.b(32);
                    return xVar;
                }
            }
            if (!z) {
                View c = at.this.f.c(i);
                if (c != null) {
                    x e = at.e(c);
                    at.this.f.e(c);
                    int b = at.this.f.b(c);
                    if (b == -1) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("layout index should not be -1 after unhiding a view:");
                        stringBuilder.append(e);
                        stringBuilder.append(at.this.a());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    at.this.f.e(b);
                    c(c);
                    e.b(8224);
                    return e;
                }
            }
            size = this.c.size();
            while (i2 < size) {
                x xVar2 = (x) this.c.get(i2);
                if (xVar2.n() || xVar2.d() != i) {
                    i2++;
                } else {
                    if (!z) {
                        this.c.remove(i2);
                    }
                    return xVar2;
                }
            }
            return null;
        }

        void b() {
            this.d = this.h + (at.this.m != null ? at.this.m.x : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.d; size--) {
                d(size);
            }
        }

        void b(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                x xVar = (x) this.c.get(i3);
                if (xVar != null && xVar.c >= i) {
                    xVar.a(i2, true);
                }
            }
        }

        void b(x xVar) {
            boolean z = false;
            if (xVar.i() || xVar.a.getParent() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Scrapped or attached views may not be recycled. isScrap:");
                stringBuilder.append(xVar.i());
                stringBuilder.append(" isAttached:");
                if (xVar.a.getParent() != null) {
                    z = true;
                }
                stringBuilder.append(z);
                stringBuilder.append(at.this.a());
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (xVar.r()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                stringBuilder2.append(xVar);
                stringBuilder2.append(at.this.a());
                throw new IllegalArgumentException(stringBuilder2.toString());
            } else if (xVar.c()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                stringBuilder3.append(at.this.a());
                throw new IllegalArgumentException(stringBuilder3.toString());
            } else {
                boolean a = xVar.A();
                boolean z2 = at.this.l != null && a && at.this.l.b(xVar);
                if (z2 || xVar.w()) {
                    if (this.d <= 0 || xVar.a(526)) {
                        z2 = false;
                    } else {
                        int size = this.c.size();
                        if (size >= this.d && size > 0) {
                            d(0);
                            size--;
                        }
                        if (at.L && size > 0 && !at.this.B.a(xVar.c)) {
                            size--;
                            while (size >= 0) {
                                if (!at.this.B.a(((x) this.c.get(size)).c)) {
                                    break;
                                }
                                size--;
                            }
                            size++;
                        }
                        this.c.add(size, xVar);
                        z2 = true;
                    }
                    if (!z2) {
                        a(xVar, true);
                        z = true;
                    }
                } else {
                    z2 = false;
                }
                at.this.g.g(xVar);
                if (!z2 && !r1 && a) {
                    xVar.m = null;
                }
            }
        }

        void b(View view) {
            x e = at.e(view);
            e.q = null;
            e.r = false;
            e.l();
            b(e);
        }

        public View c(int i) {
            return a(i, false);
        }

        public List<x> c() {
            return this.g;
        }

        void c(int i, int i2) {
            i2 += i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                x xVar = (x) this.c.get(size);
                if (xVar != null) {
                    int i3 = xVar.c;
                    if (i3 >= i && i3 < i2) {
                        xVar.b(2);
                        d(size);
                    }
                }
            }
        }

        void c(x xVar) {
            (xVar.r ? this.b : this.a).remove(xVar);
            xVar.q = null;
            xVar.r = false;
            xVar.l();
        }

        void c(View view) {
            ArrayList arrayList;
            x e = at.e(view);
            if (!e.a(12) && e.x() && !at.this.b(e)) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                e.a(this, true);
                arrayList = this.b;
            } else if (!e.n() || e.q() || at.this.l.b()) {
                e.a(this, false);
                arrayList = this.a;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                stringBuilder.append(at.this.a());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            arrayList.add(e);
        }

        void d() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.c.clear();
            if (at.L) {
                at.this.B.a();
            }
        }

        void d(int i) {
            a((x) this.c.get(i), true);
            this.c.remove(i);
        }

        void d(x xVar) {
            if (at.this.n != null) {
                at.this.n.a(xVar);
            }
            if (at.this.l != null) {
                at.this.l.a(xVar);
            }
            if (at.this.C != null) {
                at.this.g.g(xVar);
            }
        }

        int e() {
            return this.a.size();
        }

        View e(int i) {
            return ((x) this.a.get(i)).a;
        }

        x f(int i) {
            if (this.b != null) {
                int size = this.b.size();
                if (size == 0) {
                    return null;
                }
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    x xVar = (x) this.b.get(i3);
                    if (xVar.k() || xVar.d() != i) {
                        i3++;
                    } else {
                        xVar.b(32);
                        return xVar;
                    }
                }
                if (at.this.l.b()) {
                    i = at.this.e.b(i);
                    if (i > 0 && i < at.this.l.a()) {
                        long b = at.this.l.b(i);
                        while (i2 < size) {
                            x xVar2 = (x) this.b.get(i2);
                            if (xVar2.k() || xVar2.g() != b) {
                                i2++;
                            } else {
                                xVar2.b(32);
                                return xVar2;
                            }
                        }
                    }
                }
            }
            return null;
        }

        void f() {
            this.a.clear();
            if (this.b != null) {
                this.b.clear();
            }
        }

        o g() {
            if (this.e == null) {
                this.e = new o();
            }
            return this.e;
        }

        void h() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                x xVar = (x) this.c.get(i);
                if (xVar != null) {
                    xVar.b(6);
                    xVar.a(null);
                }
            }
            if (at.this.l == null || !at.this.l.b()) {
                d();
            }
        }

        void i() {
            int i;
            int size = this.c.size();
            int i2 = 0;
            for (i = 0; i < size; i++) {
                ((x) this.c.get(i)).a();
            }
            size = this.a.size();
            for (i = 0; i < size; i++) {
                ((x) this.a.get(i)).a();
            }
            if (this.b != null) {
                size = this.b.size();
                while (i2 < size) {
                    ((x) this.b.get(i2)).a();
                    i2++;
                }
            }
        }

        void j() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                j jVar = (j) ((x) this.c.get(i)).a.getLayoutParams();
                if (jVar != null) {
                    jVar.e = true;
                }
            }
        }
    }

    public interface q {
        void a(x xVar);
    }

    public static abstract class t {
        private int a;
        private at b;
        private i c;
        private boolean d;
        private boolean e;
        private View f;
        private final a g;

        public static class a {
            private int a;
            private int b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            private void b() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            void a(at atVar) {
                if (this.d >= 0) {
                    int i = this.d;
                    this.d = -1;
                    atVar.a(i);
                    this.f = false;
                } else if (this.f) {
                    b();
                    if (this.e != null) {
                        atVar.z.a(this.a, this.b, this.c, this.e);
                    } else if (this.c == Integer.MIN_VALUE) {
                        atVar.z.b(this.a, this.b);
                    } else {
                        atVar.z.a(this.a, this.b, this.c);
                    }
                    this.g++;
                    if (this.g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                } else {
                    this.g = 0;
                }
            }

            boolean a() {
                return this.d >= 0;
            }
        }

        private void a(int i, int i2) {
            at atVar = this.b;
            if (!this.e || this.a == -1 || atVar == null) {
                a();
            }
            this.d = false;
            if (this.f != null) {
                if (a(this.f) == this.a) {
                    a(this.f, atVar.C, this.g);
                    this.g.a(atVar);
                    a();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a(i, i2, atVar.C, this.g);
                boolean a = this.g.a();
                this.g.a(atVar);
                if (a) {
                    if (this.e) {
                        this.d = true;
                        atVar.z.a();
                        return;
                    }
                    a();
                }
            }
        }

        public int a(View view) {
            return this.b.f(view);
        }

        protected final void a() {
            if (this.e) {
                this.e = false;
                e();
                this.b.C.p = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.c.a(this);
                this.c = null;
                this.b = null;
            }
        }

        public void a(int i) {
            this.a = i;
        }

        protected abstract void a(int i, int i2, u uVar, a aVar);

        protected abstract void a(View view, u uVar, a aVar);

        protected void b(View view) {
            if (a(view) == d()) {
                this.f = view;
            }
        }

        public boolean b() {
            return this.d;
        }

        public boolean c() {
            return this.e;
        }

        public int d() {
            return this.a;
        }

        protected abstract void e();
    }

    public static class u {
        int a = 0;
        int b = 0;
        int c = 1;
        int d = 0;
        boolean e = false;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        int k;
        long l;
        int m;
        int n;
        int o;
        private int p = -1;
        private SparseArray<Object> q;

        void a(int i) {
            if ((this.c & i) == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Layout state should be one of ");
                stringBuilder.append(Integer.toBinaryString(i));
                stringBuilder.append(" but it is ");
                stringBuilder.append(Integer.toBinaryString(this.c));
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        void a(a aVar) {
            this.c = 1;
            this.d = aVar.a();
            this.f = false;
            this.g = false;
            this.h = false;
        }

        public boolean a() {
            return this.f;
        }

        public boolean b() {
            return this.j;
        }

        public int c() {
            return this.p;
        }

        public boolean d() {
            return this.p != -1;
        }

        public int e() {
            return this.f ? this.a - this.b : this.d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("State{mTargetPosition=");
            stringBuilder.append(this.p);
            stringBuilder.append(", mData=");
            stringBuilder.append(this.q);
            stringBuilder.append(", mItemCount=");
            stringBuilder.append(this.d);
            stringBuilder.append(", mIsMeasuring=");
            stringBuilder.append(this.h);
            stringBuilder.append(", mPreviousLayoutItemCount=");
            stringBuilder.append(this.a);
            stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            stringBuilder.append(this.b);
            stringBuilder.append(", mStructureChanged=");
            stringBuilder.append(this.e);
            stringBuilder.append(", mInPreLayout=");
            stringBuilder.append(this.f);
            stringBuilder.append(", mRunSimpleAnimations=");
            stringBuilder.append(this.i);
            stringBuilder.append(", mRunPredictiveAnimations=");
            stringBuilder.append(this.j);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static abstract class v {
        public abstract View a(p pVar, int i, int i2);
    }

    class w implements Runnable {
        Interpolator a = at.I;
        private int c;
        private int d;
        private OverScroller e;
        private boolean f = false;
        private boolean g = false;

        w() {
            this.e = new OverScroller(at.this.getContext(), at.I);
        }

        private float a(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        private int b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            i3 = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            i = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            i2 = obj != null ? at.this.getWidth() : at.this.getHeight();
            i4 = i2 / 2;
            float f = (float) i2;
            float f2 = (float) i4;
            f2 += a(Math.min(1.0f, (((float) i) * 1.0f) / f)) * f2;
            if (i3 > 0) {
                round = Math.round(Math.abs(f2 / ((float) i3)) * 1000.0f) * 4;
            } else {
                if (obj == null) {
                    abs = abs2;
                }
                round = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                a();
            }
        }

        void a() {
            if (this.f) {
                this.g = true;
                return;
            }
            at.this.removeCallbacks(this);
            android.support.v4.h.r.a(at.this, (Runnable) this);
        }

        public void a(int i, int i2) {
            at.this.setScrollState(2);
            this.d = 0;
            this.c = 0;
            this.e.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, at.I);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.a != interpolator) {
                this.a = interpolator;
                this.e = new OverScroller(at.this.getContext(), interpolator);
            }
            at.this.setScrollState(2);
            this.d = 0;
            this.c = 0;
            this.e.startScroll(0, 0, i, i2, i3);
            if (VERSION.SDK_INT < 23) {
                this.e.computeScrollOffset();
            }
            a();
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int b = b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = at.I;
            }
            a(i, i2, b, interpolator);
        }

        public void b() {
            at.this.removeCallbacks(this);
            this.e.abortAnimation();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x0138  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0128  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0138  */
        /* JADX WARNING: Missing block: B:52:0x012c, code:
            if (r8 > 0) goto L_0x0130;
     */
        public void run() {
            /*
            r23 = this;
            r0 = r23;
            r1 = android.support.v7.widget.at.this;
            r1 = r1.m;
            if (r1 != 0) goto L_0x000c;
        L_0x0008:
            r23.b();
            return;
        L_0x000c:
            r23.c();
            r1 = android.support.v7.widget.at.this;
            r1.d();
            r1 = r0.e;
            r2 = android.support.v7.widget.at.this;
            r2 = r2.m;
            r2 = r2.t;
            r3 = r1.computeScrollOffset();
            r4 = 0;
            if (r3 == 0) goto L_0x01d4;
        L_0x0023:
            r3 = android.support.v7.widget.at.this;
            r3 = r3.aE;
            r11 = r1.getCurrX();
            r12 = r1.getCurrY();
            r5 = r0.c;
            r13 = r11 - r5;
            r5 = r0.d;
            r14 = r12 - r5;
            r0.c = r11;
            r0.d = r12;
            r5 = android.support.v7.widget.at.this;
            r9 = 0;
            r10 = 1;
            r6 = r13;
            r7 = r14;
            r8 = r3;
            r5 = r5.a(r6, r7, r8, r9, r10);
            r6 = 1;
            if (r5 == 0) goto L_0x0051;
        L_0x004b:
            r5 = r3[r4];
            r13 = r13 - r5;
            r3 = r3[r6];
            r14 = r14 - r3;
        L_0x0051:
            r3 = android.support.v7.widget.at.this;
            r3 = r3.l;
            if (r3 == 0) goto L_0x00dd;
        L_0x0057:
            r3 = android.support.v7.widget.at.this;
            r3.e();
            r3 = android.support.v7.widget.at.this;
            r3.l();
            r3 = "RV Scroll";
            android.support.v4.d.c.a(r3);
            r3 = android.support.v7.widget.at.this;
            r5 = android.support.v7.widget.at.this;
            r5 = r5.C;
            r3.a(r5);
            if (r13 == 0) goto L_0x0084;
        L_0x0071:
            r3 = android.support.v7.widget.at.this;
            r3 = r3.m;
            r5 = android.support.v7.widget.at.this;
            r5 = r5.d;
            r7 = android.support.v7.widget.at.this;
            r7 = r7.C;
            r3 = r3.a(r13, r5, r7);
            r5 = r13 - r3;
            goto L_0x0086;
        L_0x0084:
            r3 = r4;
            r5 = r3;
        L_0x0086:
            if (r14 == 0) goto L_0x009b;
        L_0x0088:
            r7 = android.support.v7.widget.at.this;
            r7 = r7.m;
            r8 = android.support.v7.widget.at.this;
            r8 = r8.d;
            r9 = android.support.v7.widget.at.this;
            r9 = r9.C;
            r7 = r7.b(r14, r8, r9);
            r8 = r14 - r7;
            goto L_0x009d;
        L_0x009b:
            r7 = r4;
            r8 = r7;
        L_0x009d:
            android.support.v4.d.c.a();
            r9 = android.support.v7.widget.at.this;
            r9.w();
            r9 = android.support.v7.widget.at.this;
            r9.m();
            r9 = android.support.v7.widget.at.this;
            r9.a(r4);
            if (r2 == 0) goto L_0x00e1;
        L_0x00b1:
            r9 = r2.b();
            if (r9 != 0) goto L_0x00e1;
        L_0x00b7:
            r9 = r2.c();
            if (r9 == 0) goto L_0x00e1;
        L_0x00bd:
            r9 = android.support.v7.widget.at.this;
            r9 = r9.C;
            r9 = r9.e();
            if (r9 != 0) goto L_0x00cb;
        L_0x00c7:
            r2.a();
            goto L_0x00e1;
        L_0x00cb:
            r10 = r2.d();
            if (r10 < r9) goto L_0x00d5;
        L_0x00d1:
            r9 = r9 - r6;
            r2.a(r9);
        L_0x00d5:
            r9 = r13 - r5;
            r10 = r14 - r8;
            r2.a(r9, r10);
            goto L_0x00e1;
        L_0x00dd:
            r3 = r4;
            r5 = r3;
            r7 = r5;
            r8 = r7;
        L_0x00e1:
            r9 = android.support.v7.widget.at.this;
            r9 = r9.o;
            r9 = r9.isEmpty();
            if (r9 != 0) goto L_0x00f0;
        L_0x00eb:
            r9 = android.support.v7.widget.at.this;
            r9.invalidate();
        L_0x00f0:
            r9 = android.support.v7.widget.at.this;
            r9 = r9.getOverScrollMode();
            r10 = 2;
            if (r9 == r10) goto L_0x00fe;
        L_0x00f9:
            r9 = android.support.v7.widget.at.this;
            r9.c(r13, r14);
        L_0x00fe:
            r15 = android.support.v7.widget.at.this;
            r20 = 0;
            r21 = 1;
            r16 = r3;
            r17 = r7;
            r18 = r5;
            r19 = r8;
            r9 = r15.a(r16, r17, r18, r19, r20, r21);
            if (r9 != 0) goto L_0x0154;
        L_0x0112:
            if (r5 != 0) goto L_0x0116;
        L_0x0114:
            if (r8 == 0) goto L_0x0154;
        L_0x0116:
            r9 = r1.getCurrVelocity();
            r9 = (int) r9;
            if (r5 == r11) goto L_0x0125;
        L_0x011d:
            if (r5 >= 0) goto L_0x0121;
        L_0x011f:
            r15 = -r9;
            goto L_0x0126;
        L_0x0121:
            if (r5 <= 0) goto L_0x0125;
        L_0x0123:
            r15 = r9;
            goto L_0x0126;
        L_0x0125:
            r15 = r4;
        L_0x0126:
            if (r8 == r12) goto L_0x012f;
        L_0x0128:
            if (r8 >= 0) goto L_0x012c;
        L_0x012a:
            r9 = -r9;
            goto L_0x0130;
        L_0x012c:
            if (r8 <= 0) goto L_0x012f;
        L_0x012e:
            goto L_0x0130;
        L_0x012f:
            r9 = r4;
        L_0x0130:
            r4 = android.support.v7.widget.at.this;
            r4 = r4.getOverScrollMode();
            if (r4 == r10) goto L_0x013d;
        L_0x0138:
            r4 = android.support.v7.widget.at.this;
            r4.d(r15, r9);
        L_0x013d:
            if (r15 != 0) goto L_0x0147;
        L_0x013f:
            if (r5 == r11) goto L_0x0147;
        L_0x0141:
            r4 = r1.getFinalX();
            if (r4 != 0) goto L_0x0154;
        L_0x0147:
            if (r9 != 0) goto L_0x0151;
        L_0x0149:
            if (r8 == r12) goto L_0x0151;
        L_0x014b:
            r4 = r1.getFinalY();
            if (r4 != 0) goto L_0x0154;
        L_0x0151:
            r1.abortAnimation();
        L_0x0154:
            if (r3 != 0) goto L_0x0158;
        L_0x0156:
            if (r7 == 0) goto L_0x015d;
        L_0x0158:
            r4 = android.support.v7.widget.at.this;
            r4.i(r3, r7);
        L_0x015d:
            r4 = android.support.v7.widget.at.this;
            r4 = r4.awakenScrollBars();
            if (r4 != 0) goto L_0x016a;
        L_0x0165:
            r4 = android.support.v7.widget.at.this;
            r4.invalidate();
        L_0x016a:
            if (r14 == 0) goto L_0x017a;
        L_0x016c:
            r4 = android.support.v7.widget.at.this;
            r4 = r4.m;
            r4 = r4.f();
            if (r4 == 0) goto L_0x017a;
        L_0x0176:
            if (r7 != r14) goto L_0x017a;
        L_0x0178:
            r4 = r6;
            goto L_0x017b;
        L_0x017a:
            r4 = 0;
        L_0x017b:
            if (r13 == 0) goto L_0x018b;
        L_0x017d:
            r5 = android.support.v7.widget.at.this;
            r5 = r5.m;
            r5 = r5.e();
            if (r5 == 0) goto L_0x018b;
        L_0x0187:
            if (r3 != r13) goto L_0x018b;
        L_0x0189:
            r3 = r6;
            goto L_0x018c;
        L_0x018b:
            r3 = 0;
        L_0x018c:
            if (r13 != 0) goto L_0x0190;
        L_0x018e:
            if (r14 == 0) goto L_0x0197;
        L_0x0190:
            if (r3 != 0) goto L_0x0197;
        L_0x0192:
            if (r4 == 0) goto L_0x0195;
        L_0x0194:
            goto L_0x0197;
        L_0x0195:
            r3 = 0;
            goto L_0x0198;
        L_0x0197:
            r3 = r6;
        L_0x0198:
            r1 = r1.isFinished();
            if (r1 != 0) goto L_0x01bc;
        L_0x019e:
            if (r3 != 0) goto L_0x01a9;
        L_0x01a0:
            r1 = android.support.v7.widget.at.this;
            r1 = r1.h(r6);
            if (r1 != 0) goto L_0x01a9;
        L_0x01a8:
            goto L_0x01bc;
        L_0x01a9:
            r23.a();
            r1 = android.support.v7.widget.at.this;
            r1 = r1.A;
            if (r1 == 0) goto L_0x01d4;
        L_0x01b2:
            r1 = android.support.v7.widget.at.this;
            r1 = r1.A;
            r3 = android.support.v7.widget.at.this;
            r1.a(r3, r13, r14);
            goto L_0x01d4;
        L_0x01bc:
            r1 = android.support.v7.widget.at.this;
            r3 = 0;
            r1.setScrollState(r3);
            r1 = android.support.v7.widget.at.L;
            if (r1 == 0) goto L_0x01cf;
        L_0x01c8:
            r1 = android.support.v7.widget.at.this;
            r1 = r1.B;
            r1.a();
        L_0x01cf:
            r1 = android.support.v7.widget.at.this;
            r1.g(r6);
        L_0x01d4:
            if (r2 == 0) goto L_0x01e7;
        L_0x01d6:
            r1 = r2.b();
            if (r1 == 0) goto L_0x01e0;
        L_0x01dc:
            r1 = 0;
            r2.a(r1, r1);
        L_0x01e0:
            r1 = r0.g;
            if (r1 != 0) goto L_0x01e7;
        L_0x01e4:
            r2.a();
        L_0x01e7:
            r23.d();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.w.run():void");
        }
    }

    public static abstract class x {
        private static final List<Object> o = Collections.EMPTY_LIST;
        public final View a;
        WeakReference<at> b;
        int c;
        int d;
        long e;
        int f;
        int g;
        x h;
        x i;
        List<Object> j;
        List<Object> k;
        int l;
        at m;
        private int n;
        private int p;
        private p q;
        private boolean r;
        private int s;

        private boolean A() {
            return (this.n & 16) == 0 && android.support.v4.h.r.b(this.a);
        }

        private void a(at atVar) {
            this.s = this.l != -1 ? this.l : android.support.v4.h.r.d(this.a);
            atVar.a(this, 4);
        }

        private void b(at atVar) {
            atVar.a(this, this.s);
            this.s = 0;
        }

        private void y() {
            if (this.j == null) {
                this.j = new ArrayList();
                this.k = Collections.unmodifiableList(this.j);
            }
        }

        private boolean z() {
            return (this.n & 16) != 0;
        }

        void a() {
            this.d = -1;
            this.g = -1;
        }

        void a(int i, int i2) {
            this.n = (i & i2) | (this.n & (~i2));
        }

        void a(int i, int i2, boolean z) {
            b(8);
            a(i2, z);
            this.c = i;
        }

        void a(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (z) {
                this.g += i;
            }
            this.c += i;
            if (this.a.getLayoutParams() != null) {
                ((j) this.a.getLayoutParams()).e = true;
            }
        }

        void a(p pVar, boolean z) {
            this.q = pVar;
            this.r = z;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
                return;
            }
            if ((1024 & this.n) == 0) {
                y();
                this.j.add(obj);
            }
        }

        public final void a(boolean z) {
            this.p = z ? this.p - 1 : this.p + 1;
            if (this.p < 0) {
                this.p = 0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                stringBuilder.append(this);
                Log.e("View", stringBuilder.toString());
                return;
            }
            int i;
            if (!z && this.p == 1) {
                i = this.n | 16;
            } else if (z && this.p == 0) {
                i = this.n & -17;
            } else {
                return;
            }
            this.n = i;
        }

        boolean a(int i) {
            return (this.n & i) != 0;
        }

        void b() {
            if (this.d == -1) {
                this.d = this.c;
            }
        }

        void b(int i) {
            this.n = i | this.n;
        }

        boolean c() {
            return (this.n & 128) != 0;
        }

        public final int d() {
            return this.g == -1 ? this.c : this.g;
        }

        public final int e() {
            return this.m == null ? -1 : this.m.d(this);
        }

        public final int f() {
            return this.d;
        }

        public final long g() {
            return this.e;
        }

        public final int h() {
            return this.f;
        }

        boolean i() {
            return this.q != null;
        }

        void j() {
            this.q.c(this);
        }

        boolean k() {
            return (this.n & 32) != 0;
        }

        void l() {
            this.n &= -33;
        }

        void m() {
            this.n &= -257;
        }

        boolean n() {
            return (this.n & 4) != 0;
        }

        boolean o() {
            return (this.n & 2) != 0;
        }

        boolean p() {
            return (this.n & 1) != 0;
        }

        boolean q() {
            return (this.n & 8) != 0;
        }

        boolean r() {
            return (this.n & 256) != 0;
        }

        boolean s() {
            return (this.n & 512) != 0 || n();
        }

        void t() {
            if (this.j != null) {
                this.j.clear();
            }
            this.n &= -1025;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ViewHolder{");
            stringBuilder.append(Integer.toHexString(hashCode()));
            stringBuilder.append(" position=");
            stringBuilder.append(this.c);
            stringBuilder.append(" id=");
            stringBuilder.append(this.e);
            stringBuilder.append(", oldPos=");
            stringBuilder.append(this.d);
            stringBuilder.append(", pLpos:");
            stringBuilder.append(this.g);
            StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
            if (i()) {
                stringBuilder2.append(" scrap ");
                stringBuilder2.append(this.r ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                stringBuilder2.append(" invalid");
            }
            if (!p()) {
                stringBuilder2.append(" unbound");
            }
            if (o()) {
                stringBuilder2.append(" update");
            }
            if (q()) {
                stringBuilder2.append(" removed");
            }
            if (c()) {
                stringBuilder2.append(" ignored");
            }
            if (r()) {
                stringBuilder2.append(" tmpDetached");
            }
            if (!w()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(" not recyclable(");
                stringBuilder.append(this.p);
                stringBuilder.append(")");
                stringBuilder2.append(stringBuilder.toString());
            }
            if (s()) {
                stringBuilder2.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                stringBuilder2.append(" no parent");
            }
            stringBuilder2.append("}");
            return stringBuilder2.toString();
        }

        List<Object> u() {
            return (this.n & 1024) == 0 ? (this.j == null || this.j.size() == 0) ? o : this.k : o;
        }

        void v() {
            this.n = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.g = -1;
            this.p = 0;
            this.h = null;
            this.i = null;
            t();
            this.s = 0;
            this.l = -1;
            at.c(this);
        }

        public final boolean w() {
            return (this.n & 16) == 0 && !android.support.v4.h.r.b(this.a);
        }

        boolean x() {
            return (this.n & 2) != 0;
        }
    }

    private class g implements b {
        g() {
        }

        public void a(x xVar) {
            xVar.a(true);
            if (xVar.h != null && xVar.i == null) {
                xVar.h = null;
            }
            xVar.i = null;
            if (!xVar.z() && !at.this.a(xVar.a) && xVar.r()) {
                at.this.removeDetachedView(xVar.a, false);
            }
        }
    }

    private class r extends c {
        r() {
        }
    }

    public static class s extends android.support.v4.h.a {
        public static final Creator<s> CREATOR = new ClassLoaderCreator<s>() {
            /* renamed from: a */
            public s createFromParcel(Parcel parcel) {
                return new s(parcel, null);
            }

            /* renamed from: a */
            public s createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new s(parcel, classLoader);
            }

            /* renamed from: a */
            public s[] newArray(int i) {
                return new s[i];
            }
        };
        Parcelable a;

        s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = i.class.getClassLoader();
            }
            this.a = parcel.readParcelable(classLoader);
        }

        s(Parcelable parcelable) {
            super(parcelable);
        }

        void a(s sVar) {
            this.a = sVar.a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        a = z;
    }

    public at(Context context) {
        this(context, null);
    }

    public at(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public at(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        super(context, attributeSet, i);
        this.P = new r();
        this.d = new p();
        this.g = new bn();
        this.i = new Runnable() {
            public void run() {
                if (at.this.s && !at.this.isLayoutRequested()) {
                    if (!at.this.p) {
                        at.this.requestLayout();
                    } else if (at.this.u) {
                        at.this.t = true;
                    } else {
                        at.this.d();
                    }
                }
            }
        };
        this.j = new Rect();
        this.R = new Rect();
        this.k = new RectF();
        this.o = new ArrayList();
        this.S = new ArrayList();
        this.U = 0;
        this.w = false;
        this.x = false;
        this.ac = 0;
        this.ad = 0;
        this.ae = new e();
        this.y = new af();
        this.aj = 0;
        this.ak = -1;
        this.au = Float.MIN_VALUE;
        this.av = Float.MIN_VALUE;
        boolean z = true;
        this.aw = true;
        this.z = new w();
        this.B = L ? new a() : null;
        this.C = new u();
        this.D = false;
        this.E = false;
        this.az = new g();
        this.F = false;
        this.aB = new int[2];
        this.aD = new int[2];
        this.aE = new int[2];
        this.aF = new int[2];
        this.H = new ArrayList();
        this.aG = new Runnable() {
            public void run() {
                if (at.this.y != null) {
                    at.this.y.a();
                }
                at.this.F = false;
            }
        };
        this.aH = new b() {
            public void a(x xVar) {
                at.this.m.a(xVar.a, at.this.d);
            }

            public void a(x xVar, c cVar, c cVar2) {
                at.this.d.c(xVar);
                at.this.b(xVar, cVar, cVar2);
            }

            public void b(x xVar, c cVar, c cVar2) {
                at.this.a(xVar, cVar, cVar2);
            }

            public void c(x xVar, c cVar, c cVar2) {
                xVar.a(false);
                if (!at.this.w ? !at.this.y.c(xVar, cVar, cVar2) : !at.this.y.a(xVar, xVar, cVar, cVar2)) {
                    at.this.p();
                }
            }
        };
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K, i, 0);
            this.h = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.h = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.aq = viewConfiguration.getScaledTouchSlop();
        this.au = android.support.v4.h.s.a(viewConfiguration, context);
        this.av = android.support.v4.h.s.b(viewConfiguration, context);
        this.as = viewConfiguration.getScaledMinimumFlingVelocity();
        this.at = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.y.a(this.az);
        b();
        z();
        if (android.support.v4.h.r.d(this) == 0) {
            android.support.v4.h.r.a((View) this, 1);
        }
        this.aa = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new au(this));
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.d.a.b.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(android.support.v7.d.a.b.RecyclerView_layoutManager);
            if (obtainStyledAttributes.getInt(android.support.v7.d.a.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.r = obtainStyledAttributes.getBoolean(android.support.v7.d.a.b.RecyclerView_fastScrollEnabled, false);
            if (this.r) {
                a((StateListDrawable) obtainStyledAttributes.getDrawable(android.support.v7.d.a.b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(android.support.v7.d.a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(android.support.v7.d.a.b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(android.support.v7.d.a.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes.recycle();
            a(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, J, i, 0);
                boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
                obtainStyledAttributes2.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    private boolean A() {
        int b = this.f.b();
        for (int i = 0; i < b; i++) {
            x e = e(this.f.b(i));
            if (e != null && !e.c() && e.x()) {
                return true;
            }
        }
        return false;
    }

    private void B() {
        this.z.b();
        if (this.m != null) {
            this.m.H();
        }
    }

    private void C() {
        int isFinished;
        if (this.af != null) {
            this.af.onRelease();
            isFinished = this.af.isFinished();
        } else {
            isFinished = 0;
        }
        if (this.ag != null) {
            this.ag.onRelease();
            isFinished |= this.ag.isFinished();
        }
        if (this.ah != null) {
            this.ah.onRelease();
            isFinished |= this.ah.isFinished();
        }
        if (this.ai != null) {
            this.ai.onRelease();
            isFinished |= this.ai.isFinished();
        }
        if (isFinished != 0) {
            android.support.v4.h.r.c(this);
        }
    }

    private void D() {
        if (this.al != null) {
            this.al.clear();
        }
        g(0);
        C();
    }

    private void E() {
        D();
        setScrollState(0);
    }

    private void F() {
        int i = this.W;
        this.W = 0;
        if (i != 0 && n()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            android.support.v4.h.a.a.a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private boolean G() {
        return this.y != null && this.m.b();
    }

    private void H() {
        if (this.w) {
            this.e.a();
            if (this.x) {
                this.m.a(this);
            }
        }
        if (G()) {
            this.e.b();
        } else {
            this.e.e();
        }
        boolean z = true;
        boolean z2 = this.D || this.E;
        u uVar = this.C;
        boolean z3 = this.s && this.y != null && ((this.w || z2 || this.m.u) && (!this.w || this.l.b()));
        uVar.i = z3;
        uVar = this.C;
        if (!(this.C.i && z2 && !this.w && G())) {
            z = false;
        }
        uVar.j = z;
    }

    private void I() {
        x xVar = null;
        View focusedChild = (this.aw && hasFocus() && this.l != null) ? getFocusedChild() : null;
        if (focusedChild != null) {
            xVar = d(focusedChild);
        }
        if (xVar == null) {
            J();
            return;
        }
        this.C.l = this.l.b() ? xVar.g() : -1;
        u uVar = this.C;
        int e = this.w ? -1 : xVar.q() ? xVar.d : xVar.e();
        uVar.k = e;
        this.C.m = m(xVar.a);
    }

    private void J() {
        this.C.l = -1;
        this.C.k = -1;
        this.C.m = -1;
    }

    private View K() {
        int i = this.C.k != -1 ? this.C.k : 0;
        int e = this.C.e();
        int i2 = i;
        while (i2 < e) {
            x b = b(i2);
            if (b == null) {
                break;
            } else if (b.a.hasFocusable()) {
                return b.a;
            } else {
                i2++;
            }
        }
        i = Math.min(e, i);
        while (true) {
            i--;
            if (i < 0) {
                return null;
            }
            x b2 = b(i);
            if (b2 == null) {
                return null;
            }
            if (b2.a.hasFocusable()) {
                return b2.a;
            }
        }
    }

    /* JADX WARNING: Missing block: B:49:0x00ae, code:
            if (r6.isFocusable() != false) goto L_0x00b2;
     */
    private void L() {
        /*
        r6 = this;
        r0 = r6.aw;
        if (r0 == 0) goto L_0x00b5;
    L_0x0004:
        r0 = r6.l;
        if (r0 == 0) goto L_0x00b5;
    L_0x0008:
        r0 = r6.hasFocus();
        if (r0 == 0) goto L_0x00b5;
    L_0x000e:
        r0 = r6.getDescendantFocusability();
        r1 = 393216; // 0x60000 float:5.51013E-40 double:1.942745E-318;
        if (r0 == r1) goto L_0x00b5;
    L_0x0016:
        r0 = r6.getDescendantFocusability();
        r1 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        if (r0 != r1) goto L_0x0025;
    L_0x001e:
        r0 = r6.isFocused();
        if (r0 == 0) goto L_0x0025;
    L_0x0024:
        return;
    L_0x0025:
        r0 = r6.isFocused();
        if (r0 != 0) goto L_0x0054;
    L_0x002b:
        r0 = r6.getFocusedChild();
        r1 = N;
        if (r1 == 0) goto L_0x004b;
    L_0x0033:
        r1 = r0.getParent();
        if (r1 == 0) goto L_0x003f;
    L_0x0039:
        r1 = r0.hasFocus();
        if (r1 != 0) goto L_0x004b;
    L_0x003f:
        r0 = r6.f;
        r0 = r0.b();
        if (r0 != 0) goto L_0x0054;
    L_0x0047:
        r6.requestFocus();
        return;
    L_0x004b:
        r1 = r6.f;
        r0 = r1.c(r0);
        if (r0 != 0) goto L_0x0054;
    L_0x0053:
        return;
    L_0x0054:
        r0 = r6.C;
        r0 = r0.l;
        r2 = -1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r1 = 0;
        if (r0 == 0) goto L_0x0070;
    L_0x005f:
        r0 = r6.l;
        r0 = r0.b();
        if (r0 == 0) goto L_0x0070;
    L_0x0067:
        r0 = r6.C;
        r4 = r0.l;
        r0 = r6.a(r4);
        goto L_0x0071;
    L_0x0070:
        r0 = r1;
    L_0x0071:
        if (r0 == 0) goto L_0x0089;
    L_0x0073:
        r4 = r6.f;
        r5 = r0.a;
        r4 = r4.c(r5);
        if (r4 != 0) goto L_0x0089;
    L_0x007d:
        r4 = r0.a;
        r4 = r4.hasFocusable();
        if (r4 != 0) goto L_0x0086;
    L_0x0085:
        goto L_0x0089;
    L_0x0086:
        r1 = r0.a;
        goto L_0x0095;
    L_0x0089:
        r0 = r6.f;
        r0 = r0.b();
        if (r0 <= 0) goto L_0x0095;
    L_0x0091:
        r1 = r6.K();
    L_0x0095:
        if (r1 == 0) goto L_0x00b5;
    L_0x0097:
        r0 = r6.C;
        r0 = r0.m;
        r4 = (long) r0;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x00b1;
    L_0x00a0:
        r6 = r6.C;
        r6 = r6.m;
        r6 = r1.findViewById(r6);
        if (r6 == 0) goto L_0x00b1;
    L_0x00aa:
        r0 = r6.isFocusable();
        if (r0 == 0) goto L_0x00b1;
    L_0x00b0:
        goto L_0x00b2;
    L_0x00b1:
        r6 = r1;
    L_0x00b2:
        r6.requestFocus();
    L_0x00b5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.L():void");
    }

    private void M() {
        int b;
        boolean z = true;
        this.C.a(1);
        a(this.C);
        this.C.h = false;
        e();
        this.g.a();
        l();
        H();
        I();
        u uVar = this.C;
        if (!(this.C.i && this.E)) {
            z = false;
        }
        uVar.g = z;
        this.E = false;
        this.D = false;
        this.C.f = this.C.j;
        this.C.d = this.l.a();
        a(this.aB);
        if (this.C.i) {
            b = this.f.b();
            for (int i = 0; i < b; i++) {
                x e = e(this.f.b(i));
                if (!e.c() && (!e.n() || this.l.b())) {
                    this.g.a(e, this.y.a(this.C, e, f.e(e), e.u()));
                    if (!(!this.C.g || !e.x() || e.q() || e.c() || e.n())) {
                        this.g.a(a(e), e);
                    }
                }
            }
        }
        if (this.C.j) {
            s();
            boolean z2 = this.C.e;
            this.C.e = false;
            this.m.c(this.d, this.C);
            this.C.e = z2;
            for (b = 0; b < this.f.b(); b++) {
                x e2 = e(this.f.b(b));
                if (!(e2.c() || this.g.d(e2))) {
                    int e3 = f.e(e2);
                    boolean a = e2.a(8192);
                    if (!a) {
                        e3 |= 4096;
                    }
                    c a2 = this.y.a(this.C, e2, e3, e2.u());
                    if (a) {
                        a(e2, a2);
                    } else {
                        this.g.b(e2, a2);
                    }
                }
            }
        }
        t();
        m();
        a(false);
        this.C.c = 2;
    }

    private void N() {
        e();
        l();
        this.C.a(6);
        this.e.e();
        this.C.d = this.l.a();
        this.C.b = 0;
        this.C.f = false;
        this.m.c(this.d, this.C);
        this.C.e = false;
        this.Q = null;
        u uVar = this.C;
        boolean z = this.C.i && this.y != null;
        uVar.i = z;
        this.C.c = 4;
        m();
        a(false);
    }

    private void O() {
        this.C.a(4);
        e();
        l();
        this.C.c = 1;
        if (this.C.i) {
            for (int b = this.f.b() - 1; b >= 0; b--) {
                x e = e(this.f.b(b));
                if (!e.c()) {
                    long a = a(e);
                    c a2 = this.y.a(this.C, e);
                    x a3 = this.g.a(a);
                    if (!(a3 == null || a3.c())) {
                        boolean a4 = this.g.a(a3);
                        boolean a5 = this.g.a(e);
                        if (!(a4 && a3 == e)) {
                            c b2 = this.g.b(a3);
                            this.g.c(e, a2);
                            c c = this.g.c(e);
                            if (b2 == null) {
                                a(a, e, a3);
                            } else {
                                a(a3, e, b2, c, a4, a5);
                            }
                        }
                    }
                    this.g.c(e, a2);
                }
            }
            this.g.a(this.aH);
        }
        this.m.b(this.d);
        this.C.a = this.C.d;
        this.w = false;
        this.x = false;
        this.C.i = false;
        this.C.j = false;
        this.m.u = false;
        if (this.d.b != null) {
            this.d.b.clear();
        }
        if (this.m.y) {
            this.m.x = 0;
            this.m.y = false;
            this.d.b();
        }
        this.m.a(this.C);
        m();
        a(false);
        this.g.a();
        if (k(this.aB[0], this.aB[1])) {
            i(0, 0);
        }
        L();
        J();
    }

    private String a(Context context, String str) {
        StringBuilder stringBuilder;
        if (str.charAt(0) == '.') {
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
        } else if (str.contains(".")) {
            return str;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(at.class.getPackage().getName());
            stringBuilder.append('.');
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    private void a(float r7, float r8, float r9, float r10) {
        /*
        r6 = this;
        r0 = 0;
        r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = 1;
        if (r1 >= 0) goto L_0x0021;
    L_0x0008:
        r6.g();
        r1 = r6.af;
        r4 = -r8;
        r5 = r6.getWidth();
        r5 = (float) r5;
        r4 = r4 / r5;
        r5 = r6.getHeight();
        r5 = (float) r5;
        r9 = r9 / r5;
        r9 = r2 - r9;
    L_0x001c:
        android.support.v4.widget.g.a(r1, r4, r9);
        r9 = r3;
        goto L_0x0039;
    L_0x0021:
        r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r1 <= 0) goto L_0x0038;
    L_0x0025:
        r6.h();
        r1 = r6.ah;
        r4 = r6.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r5 = r6.getHeight();
        r5 = (float) r5;
        r9 = r9 / r5;
        goto L_0x001c;
    L_0x0038:
        r9 = 0;
    L_0x0039:
        r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r1 >= 0) goto L_0x0053;
    L_0x003d:
        r6.i();
        r9 = r6.ag;
        r1 = -r10;
        r2 = r6.getHeight();
        r2 = (float) r2;
        r1 = r1 / r2;
        r2 = r6.getWidth();
        r2 = (float) r2;
        r7 = r7 / r2;
        android.support.v4.widget.g.a(r9, r1, r7);
        goto L_0x006f;
    L_0x0053:
        r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r1 <= 0) goto L_0x006e;
    L_0x0057:
        r6.j();
        r9 = r6.ai;
        r1 = r6.getHeight();
        r1 = (float) r1;
        r1 = r10 / r1;
        r4 = r6.getWidth();
        r4 = (float) r4;
        r7 = r7 / r4;
        r2 = r2 - r7;
        android.support.v4.widget.g.a(r9, r1, r2);
        goto L_0x006f;
    L_0x006e:
        r3 = r9;
    L_0x006f:
        if (r3 != 0) goto L_0x0079;
    L_0x0071:
        r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r7 != 0) goto L_0x0079;
    L_0x0075:
        r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r7 == 0) goto L_0x007c;
    L_0x0079:
        android.support.v4.h.r.c(r6);
    L_0x007c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.a(float, float, float, float):void");
    }

    private void a(long j, x xVar, x xVar2) {
        StringBuilder stringBuilder;
        int b = this.f.b();
        int i = 0;
        while (i < b) {
            x e = e(this.f.b(i));
            if (e == xVar || a(e) != j) {
                i++;
            } else if (this.l == null || !this.l.b()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                stringBuilder.append(e);
                stringBuilder.append(" \n View Holder 2:");
                stringBuilder.append(xVar);
                stringBuilder.append(a());
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                stringBuilder.append(e);
                stringBuilder.append(" \n View Holder 2:");
                stringBuilder.append(xVar);
                stringBuilder.append(a());
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        stringBuilder.append(xVar2);
        stringBuilder.append(" cannot be found but it is necessary for ");
        stringBuilder.append(xVar);
        stringBuilder.append(a());
        Log.e("RecyclerView", stringBuilder.toString());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        StringBuilder stringBuilder;
        if (str != null) {
            str = str.trim();
            if (!str.isEmpty()) {
                str = a(context, str);
                try {
                    Constructor constructor;
                    Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(str).asSubclass(i.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(O);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((i) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(attributeSet.getPositionDescription());
                    stringBuilder.append(": Error creating LayoutManager ");
                    stringBuilder.append(str);
                    throw new IllegalStateException(stringBuilder.toString(), e2);
                } catch (Throwable e22) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(attributeSet.getPositionDescription());
                    stringBuilder.append(": Unable to find LayoutManager ");
                    stringBuilder.append(str);
                    throw new IllegalStateException(stringBuilder.toString(), e22);
                } catch (Throwable e222) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(attributeSet.getPositionDescription());
                    stringBuilder.append(": Could not instantiate the LayoutManager: ");
                    stringBuilder.append(str);
                    throw new IllegalStateException(stringBuilder.toString(), e222);
                } catch (Throwable e2222) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(attributeSet.getPositionDescription());
                    stringBuilder.append(": Could not instantiate the LayoutManager: ");
                    stringBuilder.append(str);
                    throw new IllegalStateException(stringBuilder.toString(), e2222);
                } catch (Throwable e22222) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(attributeSet.getPositionDescription());
                    stringBuilder.append(": Cannot access non-public constructor ");
                    stringBuilder.append(str);
                    throw new IllegalStateException(stringBuilder.toString(), e22222);
                } catch (Throwable e222222) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(attributeSet.getPositionDescription());
                    stringBuilder.append(": Class is not a LayoutManager ");
                    stringBuilder.append(str);
                    throw new IllegalStateException(stringBuilder.toString(), e222222);
                }
            }
        }
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (this.l != null) {
            this.l.b(this.P);
            this.l.b(this);
        }
        if (!z || z2) {
            c();
        }
        this.e.a();
        a aVar2 = this.l;
        this.l = aVar;
        if (aVar != null) {
            aVar.a(this.P);
            aVar.a(this);
        }
        if (this.m != null) {
            this.m.a(aVar2, this.l);
        }
        this.d.a(aVar2, this.l, z);
        this.C.e = true;
    }

    private void a(x xVar, x xVar2, c cVar, c cVar2, boolean z, boolean z2) {
        xVar.a(false);
        if (z) {
            e(xVar);
        }
        if (xVar != xVar2) {
            if (z2) {
                e(xVar2);
            }
            xVar.h = xVar2;
            e(xVar);
            this.d.c(xVar);
            xVar2.a(false);
            xVar2.i = xVar;
        }
        if (this.y.a(xVar, xVar2, cVar, cVar2)) {
            p();
        }
    }

    static void a(View view, Rect rect) {
        j jVar = (j) view.getLayoutParams();
        Rect rect2 = jVar.d;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, (view.getRight() + rect2.right) + jVar.rightMargin, (view.getBottom() + rect2.bottom) + jVar.bottomMargin);
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.j.set(0, 0, view3.getWidth(), view3.getHeight());
        LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j) {
            j jVar = (j) layoutParams;
            if (!jVar.e) {
                Rect rect = jVar.d;
                Rect rect2 = this.j;
                rect2.left -= rect.left;
                rect2 = this.j;
                rect2.right += rect.right;
                rect2 = this.j;
                rect2.top -= rect.top;
                rect2 = this.j;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.j);
            offsetRectIntoDescendantCoords(view, this.j);
        }
        this.m.a(this, view, this.j, this.s ^ 1, view2 == null);
    }

    private void a(int[] iArr) {
        int b = this.f.b();
        if (b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < b; i3++) {
            x e = e(this.f.b(i3));
            if (!e.c()) {
                int d = e.d();
                if (d < i2) {
                    i2 = d;
                }
                if (d > i) {
                    i = d;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i;
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.T = null;
        }
        int size = this.S.size();
        int i = 0;
        while (i < size) {
            m mVar = (m) this.S.get(i);
            if (!mVar.a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.T = mVar;
                return true;
            }
        }
        return false;
    }

    private boolean a(View view, View view2, int i) {
        boolean z = false;
        if (view2 != null) {
            if (view2 == this || c(view2) == null) {
                return false;
            }
            if (view == null || c(view) == null) {
                return true;
            }
            this.j.set(0, 0, view.getWidth(), view.getHeight());
            this.R.set(0, 0, view2.getWidth(), view2.getHeight());
            offsetDescendantRectToMyCoords(view, this.j);
            offsetDescendantRectToMyCoords(view2, this.R);
            boolean z2 = true;
            int i2 = this.m.t() == 1 ? -1 : 1;
            int i3 = ((this.j.left < this.R.left || this.j.right <= this.R.left) && this.j.right < this.R.right) ? 1 : ((this.j.right > this.R.right || this.j.left >= this.R.right) && this.j.left > this.R.left) ? -1 : 0;
            if ((this.j.top < this.R.top || this.j.bottom <= this.R.top) && this.j.bottom < this.R.bottom) {
                z2 = true;
            } else if ((this.j.bottom <= this.R.bottom && this.j.top < this.R.bottom) || this.j.top <= this.R.top) {
                z2 = false;
            }
            if (i != 17) {
                if (i == 33) {
                    if (z2 >= false) {
                        z = true;
                    }
                    return z;
                } else if (i == 66) {
                    if (i3 > 0) {
                        z = true;
                    }
                    return z;
                } else if (i != 130) {
                    switch (i) {
                        case 1:
                            if (z2 >= false || (!z2 && i3 * i2 <= 0)) {
                                z = true;
                            }
                            return z;
                        case 2:
                            if (z2 <= false || (!z2 && i3 * i2 >= 0)) {
                                z = true;
                            }
                            return z;
                        default:
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid direction: ");
                            stringBuilder.append(i);
                            stringBuilder.append(a());
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
                } else {
                    if (z2 <= false) {
                        z = true;
                    }
                    return z;
                }
            } else if (i3 < 0) {
                z = true;
            }
        }
        return z;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.T != null) {
            if (action == 0) {
                this.T = null;
            } else {
                this.T.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.T = null;
                }
                return true;
            }
        }
        if (action != 0) {
            action = this.S.size();
            for (int i = 0; i < action; i++) {
                m mVar = (m) this.S.get(i);
                if (mVar.a(this, motionEvent)) {
                    this.T = mVar;
                    return true;
                }
            }
        }
        return false;
    }

    static void c(x xVar) {
        if (xVar.b != null) {
            Object obj = xVar.b.get();
            loop0:
            while (true) {
                View view = (View) obj;
                while (view != null) {
                    if (view != xVar.a) {
                        obj = view.getParent();
                        if (!(obj instanceof View)) {
                            view = null;
                        }
                    } else {
                        return;
                    }
                }
                xVar.b = null;
                break loop0;
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ak) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.ak = motionEvent.getPointerId(actionIndex);
            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.ao = x;
            this.am = x;
            int y = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ap = y;
            this.an = y;
        }
    }

    static x e(View view) {
        return view == null ? null : ((j) view.getLayoutParams()).c;
    }

    private void e(x xVar) {
        View view = xVar.a;
        boolean z = view.getParent() == this;
        this.d.c(b(view));
        if (xVar.r()) {
            this.f.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f.d(view);
        } else {
            this.f.a(view, true);
        }
    }

    private android.support.v4.h.l getScrollingChildHelper() {
        if (this.aC == null) {
            this.aC = new android.support.v4.h.l(this);
        }
        return this.aC;
    }

    static at j(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof at) {
            return (at) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            at j = j(viewGroup.getChildAt(i));
            if (j != null) {
                return j;
            }
        }
        return null;
    }

    private boolean k(int i, int i2) {
        a(this.aB);
        return (this.aB[0] == i && this.aB[1] == i2) ? false : true;
    }

    private int m(View view) {
        int id;
        loop0:
        while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                }
            }
        }
        return id;
    }

    private void z() {
        this.f = new ac(new b() {
            public int a() {
                return at.this.getChildCount();
            }

            public int a(View view) {
                return at.this.indexOfChild(view);
            }

            public void a(int i) {
                View childAt = at.this.getChildAt(i);
                if (childAt != null) {
                    at.this.k(childAt);
                    childAt.clearAnimation();
                }
                at.this.removeViewAt(i);
            }

            public void a(View view, int i) {
                at.this.addView(view, i);
                at.this.l(view);
            }

            public void a(View view, int i, LayoutParams layoutParams) {
                x e = at.e(view);
                if (e != null) {
                    if (e.r() || e.c()) {
                        e.m();
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Called attach on a child which is not detached: ");
                        stringBuilder.append(e);
                        stringBuilder.append(at.this.a());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                at.this.attachViewToParent(view, i, layoutParams);
            }

            public x b(View view) {
                return at.e(view);
            }

            public View b(int i) {
                return at.this.getChildAt(i);
            }

            public void b() {
                int a = a();
                for (int i = 0; i < a; i++) {
                    View b = b(i);
                    at.this.k(b);
                    b.clearAnimation();
                }
                at.this.removeAllViews();
            }

            public void c(int i) {
                View b = b(i);
                if (b != null) {
                    x e = at.e(b);
                    if (e != null) {
                        if (!e.r() || e.c()) {
                            e.b(256);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("called detach on an already detached child ");
                            stringBuilder.append(e);
                            stringBuilder.append(at.this.a());
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                }
                at.this.detachViewFromParent(i);
            }

            public void c(View view) {
                x e = at.e(view);
                if (e != null) {
                    e.a(at.this);
                }
            }

            public void d(View view) {
                x e = at.e(view);
                if (e != null) {
                    e.b(at.this);
                }
            }
        });
    }

    long a(x xVar) {
        return this.l.b() ? xVar.g() : (long) xVar.c;
    }

    x a(int i, boolean z) {
        int c = this.f.c();
        x xVar = null;
        for (int i2 = 0; i2 < c; i2++) {
            x e = e(this.f.d(i2));
            if (!(e == null || e.q())) {
                if (z) {
                    if (e.c != i) {
                        continue;
                    }
                } else if (e.d() != i) {
                    continue;
                }
                if (!this.f.c(e.a)) {
                    return e;
                }
                xVar = e;
            }
        }
        return xVar;
    }

    public x a(long j) {
        x xVar = null;
        if (this.l != null) {
            if (!this.l.b()) {
                return null;
            }
            int c = this.f.c();
            for (int i = 0; i < c; i++) {
                x e = e(this.f.d(i));
                if (!(e == null || e.q() || e.g() != j)) {
                    if (!this.f.c(e.a)) {
                        return e;
                    }
                    xVar = e;
                }
            }
        }
        return xVar;
    }

    String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        stringBuilder.append(super.toString());
        stringBuilder.append(", adapter:");
        stringBuilder.append(this.l);
        stringBuilder.append(", layout:");
        stringBuilder.append(this.m);
        stringBuilder.append(", context:");
        stringBuilder.append(getContext());
        return stringBuilder.toString();
    }

    void a(int i) {
        if (this.m != null) {
            this.m.d(i);
            awakenScrollBars();
        }
    }

    public void a(int i, int i2) {
        a(i, i2, null);
    }

    public void a(int i, int i2, Interpolator interpolator) {
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.u) {
            if (!this.m.e()) {
                i = 0;
            }
            if (!this.m.f()) {
                i2 = 0;
            }
            if (!(i == 0 && i2 == 0)) {
                this.z.a(i, i2, interpolator);
            }
        }
    }

    void a(int i, int i2, Object obj) {
        int c = this.f.c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View d = this.f.d(i4);
            x e = e(d);
            if (e != null && !e.c() && e.c >= i && e.c < i3) {
                e.b(2);
                e.a(obj);
                ((j) d.getLayoutParams()).e = true;
            }
        }
        this.d.c(i, i2);
    }

    void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f.c();
        for (int i4 = 0; i4 < c; i4++) {
            x e = e(this.f.d(i4));
            if (!(e == null || e.c())) {
                if (e.c >= i3) {
                    e.a(-i2, z);
                } else if (e.c >= i) {
                    e.a(i - 1, -i2, z);
                }
                this.C.e = true;
            }
        }
        this.d.a(i, i2, z);
        requestLayout();
    }

    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trying to set fast scroller without both required drawables.");
            stringBuilder.append(a());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Resources resources = getContext().getResources();
        ai aiVar = new ai(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(android.support.v7.d.a.a.fastscroll_default_thickness), resources.getDimensionPixelSize(android.support.v7.d.a.a.fastscroll_minimum_range), resources.getDimensionPixelOffset(android.support.v7.d.a.a.fastscroll_margin));
    }

    public void a(h hVar) {
        a(hVar, -1);
    }

    public void a(h hVar, int i) {
        if (this.m != null) {
            this.m.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.o.add(hVar);
        } else {
            this.o.add(i, hVar);
        }
        r();
        requestLayout();
    }

    public void a(m mVar) {
        this.S.add(mVar);
    }

    public void a(n nVar) {
        if (this.ay == null) {
            this.ay = new ArrayList();
        }
        this.ay.add(nVar);
    }

    final void a(u uVar) {
        if (getScrollState() == 2) {
            OverScroller a = this.z.e;
            uVar.n = a.getFinalX() - a.getCurrX();
            uVar.o = a.getFinalY() - a.getCurrY();
            return;
        }
        uVar.n = 0;
        uVar.o = 0;
    }

    void a(x xVar, c cVar) {
        xVar.a(0, 8192);
        if (this.C.g && xVar.x() && !xVar.q() && !xVar.c()) {
            this.g.a(a(xVar), xVar);
        }
        this.g.a(xVar, cVar);
    }

    void a(x xVar, c cVar, c cVar2) {
        xVar.a(false);
        if (this.y.b(xVar, cVar, cVar2)) {
            p();
        }
    }

    void a(String str) {
        if (o()) {
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                stringBuilder.append(a());
                throw new IllegalStateException(stringBuilder.toString());
            }
            throw new IllegalStateException(str);
        } else if (this.ad > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(a());
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(stringBuilder2.toString()));
        }
    }

    void a(boolean z) {
        if (this.U < 1) {
            this.U = 1;
        }
        if (!(z || this.u)) {
            this.t = false;
        }
        if (this.U == 1) {
            if (!(!z || !this.t || this.u || this.m == null || this.l == null)) {
                q();
            }
            if (!this.u) {
                this.t = false;
            }
        }
        this.U--;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr, i5);
    }

    boolean a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int b;
        int i4;
        d();
        if (this.l != null) {
            e();
            l();
            android.support.v4.d.c.a("RV Scroll");
            a(this.C);
            if (i != 0) {
                a = this.m.a(i, this.d, this.C);
                i3 = i - a;
            } else {
                a = 0;
                i3 = a;
            }
            if (i2 != 0) {
                b = this.m.b(i2, this.d, this.C);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = b;
            }
            android.support.v4.d.c.a();
            w();
            m();
            a(false);
        } else {
            a = 0;
            i3 = a;
            b = i3;
            i4 = b;
        }
        if (!this.o.isEmpty()) {
            invalidate();
        }
        if (a(a, b, i3, i4, this.aD, 0)) {
            this.ao -= this.aD[0];
            this.ap -= this.aD[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.aD[0], (float) this.aD[1]);
            }
            int[] iArr = this.aF;
            iArr[0] = iArr[0] + this.aD[0];
            iArr = this.aF;
            iArr[1] = iArr[1] + this.aD[1];
        } else if (getOverScrollMode() != 2) {
            if (!(motionEvent == null || android.support.v4.h.i.a(motionEvent, 8194))) {
                a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i4);
            }
            c(i, i2);
        }
        if (!(a == 0 && b == 0)) {
            i(a, b);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (a == 0 && b == 0) ? false : true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2, i3);
    }

    boolean a(x xVar, int i) {
        if (o()) {
            xVar.l = i;
            this.H.add(xVar);
            return false;
        }
        android.support.v4.h.r.a(xVar.a, i);
        return true;
    }

    boolean a(View view) {
        e();
        boolean f = this.f.f(view);
        if (f) {
            x e = e(view);
            this.d.c(e);
            this.d.b(e);
        }
        a(f ^ 1);
        return f;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (!o()) {
            return false;
        }
        int a = accessibilityEvent != null ? android.support.v4.h.a.a.a(accessibilityEvent) : 0;
        if (a == 0) {
            a = 0;
        }
        this.W = a | this.W;
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.m == null || !this.m.a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public x b(int i) {
        x xVar = null;
        if (this.w) {
            return null;
        }
        int c = this.f.c();
        for (int i2 = 0; i2 < c; i2++) {
            x e = e(this.f.d(i2));
            if (!(e == null || e.q() || d(e) != i)) {
                if (!this.f.c(e.a)) {
                    return e;
                }
                xVar = e;
            }
        }
        return xVar;
    }

    public x b(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return e(view);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a direct child of ");
        stringBuilder.append(this);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    void b() {
        this.e = new e(new a() {
            public x a(int i) {
                x a = at.this.a(i, true);
                return (a == null || at.this.f.c(a.a)) ? null : a;
            }

            public void a(int i, int i2) {
                at.this.a(i, i2, true);
                at.this.D = true;
                u uVar = at.this.C;
                uVar.b += i2;
            }

            public void a(int i, int i2, Object obj) {
                at.this.a(i, i2, obj);
                at.this.E = true;
            }

            public void a(b bVar) {
                c(bVar);
            }

            public void b(int i, int i2) {
                at.this.a(i, i2, false);
                at.this.D = true;
            }

            public void b(b bVar) {
                c(bVar);
            }

            public void c(int i, int i2) {
                at.this.g(i, i2);
                at.this.D = true;
            }

            void c(b bVar) {
                int i = bVar.a;
                if (i == 4) {
                    at.this.m.a(at.this, bVar.b, bVar.d, bVar.c);
                } else if (i != 8) {
                    switch (i) {
                        case 1:
                            at.this.m.a(at.this, bVar.b, bVar.d);
                            return;
                        case 2:
                            at.this.m.b(at.this, bVar.b, bVar.d);
                            return;
                        default:
                            return;
                    }
                } else {
                    at.this.m.a(at.this, bVar.b, bVar.d, 1);
                }
            }

            public void d(int i, int i2) {
                at.this.f(i, i2);
                at.this.D = true;
            }
        });
    }

    public void b(h hVar) {
        if (this.m != null) {
            this.m.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.o.remove(hVar);
        if (this.o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        r();
        requestLayout();
    }

    public void b(m mVar) {
        this.S.remove(mVar);
        if (this.T == mVar) {
            this.T = null;
        }
    }

    public void b(n nVar) {
        if (this.ay != null) {
            this.ay.remove(nVar);
        }
    }

    void b(x xVar, c cVar, c cVar2) {
        e(xVar);
        xVar.a(false);
        if (this.y.a(xVar, cVar, cVar2)) {
            p();
        }
    }

    void b(boolean z) {
        this.ac--;
        if (this.ac < 1) {
            this.ac = 0;
            if (z) {
                F();
                x();
            }
        }
    }

    public boolean b(int i, int i2) {
        int i3 = 0;
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.u) {
            return false;
        } else {
            boolean e = this.m.e();
            boolean f = this.m.f();
            if (!e || Math.abs(i) < this.as) {
                i = 0;
            }
            if (!f || Math.abs(i2) < this.as) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f2 = (float) i;
            float f3 = (float) i2;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z = e || f;
                dispatchNestedFling(f2, f3, z);
                if (this.ar != null && this.ar.a(i, i2)) {
                    return true;
                }
                if (z) {
                    if (e) {
                        i3 = 1;
                    }
                    if (f) {
                        i3 |= 2;
                    }
                    j(i3, 1);
                    this.z.a(Math.max(-this.at, Math.min(i, this.at)), Math.max(-this.at, Math.min(i2, this.at)));
                    return true;
                }
            }
            return false;
        }
    }

    boolean b(x xVar) {
        return this.y == null || this.y.a(xVar, xVar.u());
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0013  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0012 A:{RETURN} */
    public android.view.View c(android.view.View r3) {
        /*
        r2 = this;
    L_0x0000:
        r0 = r3.getParent();
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        if (r0 == r2) goto L_0x0010;
    L_0x0008:
        r1 = r0 instanceof android.view.View;
        if (r1 == 0) goto L_0x0010;
    L_0x000c:
        r3 = r0;
        r3 = (android.view.View) r3;
        goto L_0x0000;
    L_0x0010:
        if (r0 != r2) goto L_0x0013;
    L_0x0012:
        return r3;
    L_0x0013:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.c(android.view.View):android.view.View");
    }

    void c() {
        if (this.y != null) {
            this.y.d();
        }
        if (this.m != null) {
            this.m.c(this.d);
            this.m.b(this.d);
        }
        this.d.a();
    }

    public void c(int i) {
        int b = this.f.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f.b(i2).offsetTopAndBottom(i);
        }
    }

    void c(int i, int i2) {
        int i3;
        if (this.af == null || this.af.isFinished() || i <= 0) {
            i3 = 0;
        } else {
            this.af.onRelease();
            i3 = this.af.isFinished();
        }
        if (!(this.ah == null || this.ah.isFinished() || i >= 0)) {
            this.ah.onRelease();
            i3 |= this.ah.isFinished();
        }
        if (!(this.ag == null || this.ag.isFinished() || i2 <= 0)) {
            this.ag.onRelease();
            i3 |= this.ag.isFinished();
        }
        if (!(this.ai == null || this.ai.isFinished() || i2 >= 0)) {
            this.ai.onRelease();
            i3 |= this.ai.isFinished();
        }
        if (i3 != 0) {
            android.support.v4.h.r.c(this);
        }
    }

    void c(boolean z) {
        this.x = z | this.x;
        this.w = true;
        u();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof j) && this.m.a((j) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        int i = 0;
        if (this.m == null) {
            return 0;
        }
        if (this.m.e()) {
            i = this.m.e(this.C);
        }
        return i;
    }

    public int computeHorizontalScrollOffset() {
        int i = 0;
        if (this.m == null) {
            return 0;
        }
        if (this.m.e()) {
            i = this.m.c(this.C);
        }
        return i;
    }

    public int computeHorizontalScrollRange() {
        int i = 0;
        if (this.m == null) {
            return 0;
        }
        if (this.m.e()) {
            i = this.m.g(this.C);
        }
        return i;
    }

    public int computeVerticalScrollExtent() {
        int i = 0;
        if (this.m == null) {
            return 0;
        }
        if (this.m.f()) {
            i = this.m.f(this.C);
        }
        return i;
    }

    public int computeVerticalScrollOffset() {
        int i = 0;
        if (this.m == null) {
            return 0;
        }
        if (this.m.f()) {
            i = this.m.d(this.C);
        }
        return i;
    }

    public int computeVerticalScrollRange() {
        int i = 0;
        if (this.m == null) {
            return 0;
        }
        if (this.m.f()) {
            i = this.m.h(this.C);
        }
        return i;
    }

    int d(x xVar) {
        return (xVar.a(524) || !xVar.p()) ? -1 : this.e.c(xVar.c);
    }

    public x d(View view) {
        view = c(view);
        return view == null ? null : b(view);
    }

    void d() {
        if (!this.s || this.w) {
            android.support.v4.d.c.a("RV FullInvalidate");
            q();
            android.support.v4.d.c.a();
        } else if (this.e.d()) {
            if (!this.e.a(4) || this.e.a(11)) {
                if (this.e.d()) {
                    android.support.v4.d.c.a("RV FullInvalidate");
                    q();
                }
            }
            android.support.v4.d.c.a("RV PartialInvalidate");
            e();
            l();
            this.e.b();
            if (!this.t) {
                if (A()) {
                    q();
                } else {
                    this.e.c();
                }
            }
            a(true);
            m();
            android.support.v4.d.c.a();
        }
    }

    public void d(int i) {
        int b = this.f.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f.b(i2).offsetLeftAndRight(i);
        }
    }

    void d(int i, int i2) {
        if (i < 0) {
            g();
            this.af.onAbsorb(-i);
        } else if (i > 0) {
            h();
            this.ah.onAbsorb(i);
        }
        if (i2 < 0) {
            i();
            this.ag.onAbsorb(-i2);
        } else if (i2 > 0) {
            j();
            this.ai.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            android.support.v4.h.r.c(this);
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int paddingTop;
        super.draw(canvas);
        int size = this.o.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ((h) this.o.get(i4)).a(canvas, this, this.C);
        }
        if (this.af == null || this.af.isFinished()) {
            i = 0;
        } else {
            size = canvas.save();
            i = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + i), 0.0f);
            i = (this.af == null || !this.af.draw(canvas)) ? 0 : 1;
            canvas.restoreToCount(size);
        }
        if (!(this.ag == null || this.ag.isFinished())) {
            size = canvas.save();
            if (this.h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i2 = (this.ag == null || !this.ag.draw(canvas)) ? 0 : 1;
            i |= i2;
            canvas.restoreToCount(size);
        }
        if (!(this.ah == null || this.ah.isFinished())) {
            size = canvas.save();
            i2 = getWidth();
            paddingTop = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-i2));
            i2 = (this.ah == null || !this.ah.draw(canvas)) ? 0 : 1;
            i |= i2;
            canvas.restoreToCount(size);
        }
        if (this.ai == null || this.ai.isFinished()) {
            i3 = i;
        } else {
            float paddingRight;
            size = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                paddingRight = (float) ((-getWidth()) + getPaddingRight());
                paddingTop = (-getHeight()) + getPaddingBottom();
            } else {
                paddingRight = (float) (-getWidth());
                paddingTop = -getHeight();
            }
            canvas.translate(paddingRight, (float) paddingTop);
            if (this.ai != null && this.ai.draw(canvas)) {
                i3 = 1;
            }
            i3 |= i;
            canvas.restoreToCount(size);
        }
        if (i3 == 0 && this.y != null && this.o.size() > 0 && this.y.b()) {
            i3 = 1;
        }
        if (i3 != 0) {
            android.support.v4.h.r.c(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    void e() {
        this.U++;
        if (this.U == 1 && !this.u) {
            this.t = false;
        }
    }

    public void e(int i) {
    }

    void e(int i, int i2) {
        setMeasuredDimension(i.a(i, getPaddingLeft() + getPaddingRight(), android.support.v4.h.r.h(this)), i.a(i2, getPaddingTop() + getPaddingBottom(), android.support.v4.h.r.i(this)));
    }

    public int f(View view) {
        x e = e(view);
        return e != null ? e.d() : -1;
    }

    public void f() {
        setScrollState(0);
        B();
    }

    void f(int i) {
        if (this.m != null) {
            this.m.k(i);
        }
        e(i);
        if (this.ax != null) {
            this.ax.a(this, i);
        }
        if (this.ay != null) {
            for (int size = this.ay.size() - 1; size >= 0; size--) {
                ((n) this.ay.get(size)).a(this, i);
            }
        }
    }

    void f(int i, int i2) {
        int i3;
        int c = this.f.c();
        int i4;
        int i5;
        if (i < i2) {
            i4 = i2;
            i3 = -1;
            i5 = i;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i6 = 0; i6 < c; i6++) {
            x e = e(this.f.d(i6));
            if (e != null && e.c >= i5 && e.c <= i4) {
                if (e.c == i) {
                    e.a(i2 - i, false);
                } else {
                    e.a(i3, false);
                }
                this.C.e = true;
            }
        }
        this.d.a(i, i2);
        requestLayout();
    }

    public View focusSearch(View view, int i) {
        View d = this.m.d(view, i);
        if (d != null) {
            return d;
        }
        boolean z = (this.l == null || this.m == null || o() || this.u) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z && (i == 2 || i == 1)) {
            int i2;
            boolean z2;
            if (this.m.f()) {
                i2 = i == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i2) == null;
                if (M) {
                    i = i2;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.m.e()) {
                i2 = ((this.m.t() == 1 ? 1 : 0) ^ (i == 2 ? 1 : 0)) != 0 ? 66 : 17;
                z2 = instance.findNextFocus(this, view, i2) == null;
                if (M) {
                    i = i2;
                }
            }
            if (z2) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                this.m.a(view, i, this.d, this.C);
                a(false);
            }
            d = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                d = this.m.a(view, i, this.d, this.C);
                a(false);
            } else {
                d = findNextFocus;
            }
        }
        if (d == null || d.hasFocusable()) {
            return a(view, d, i) ? d : super.focusSearch(view, i);
        } else {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i);
            }
            a(d, null);
            return view;
        }
    }

    void g() {
        if (this.af == null) {
            this.af = this.ae.a(this, 0);
            if (this.h) {
                this.af.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.af.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void g(int i) {
        getScrollingChildHelper().c(i);
    }

    void g(int i, int i2) {
        int c = this.f.c();
        for (int i3 = 0; i3 < c; i3++) {
            x e = e(this.f.d(i3));
            if (!(e == null || e.c() || e.c < i)) {
                e.a(i2, false);
                this.C.e = true;
            }
        }
        this.d.b(i, i2);
        requestLayout();
    }

    public void g(View view) {
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.m != null) {
            return this.m.a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(a());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.m != null) {
            return this.m.a(getContext(), attributeSet);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(a());
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.m != null) {
            return this.m.a(layoutParams);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(a());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public a getAdapter() {
        return this.l;
    }

    public int getBaseline() {
        return this.m != null ? this.m.u() : super.getBaseline();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.aA == null ? super.getChildDrawingOrder(i, i2) : this.aA.a(i, i2);
    }

    public boolean getClipToPadding() {
        return this.h;
    }

    public au getCompatAccessibilityDelegate() {
        return this.G;
    }

    public e getEdgeEffectFactory() {
        return this.ae;
    }

    public f getItemAnimator() {
        return this.y;
    }

    public int getItemDecorationCount() {
        return this.o.size();
    }

    public i getLayoutManager() {
        return this.m;
    }

    public int getMaxFlingVelocity() {
        return this.at;
    }

    public int getMinFlingVelocity() {
        return this.as;
    }

    long getNanoTime() {
        return L ? System.nanoTime() : 0;
    }

    public l getOnFlingListener() {
        return this.ar;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.aw;
    }

    public o getRecycledViewPool() {
        return this.d.g();
    }

    public int getScrollState() {
        return this.aj;
    }

    void h() {
        if (this.ah == null) {
            this.ah = this.ae.a(this, 2);
            if (this.h) {
                this.ah.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.ah.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void h(int i, int i2) {
    }

    public void h(View view) {
    }

    public boolean h(int i) {
        return getScrollingChildHelper().a(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    Rect i(View view) {
        j jVar = (j) view.getLayoutParams();
        if (!jVar.e) {
            return jVar.d;
        }
        if (this.C.a() && (jVar.e() || jVar.c())) {
            return jVar.d;
        }
        Rect rect = jVar.d;
        rect.set(0, 0, 0, 0);
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            this.j.set(0, 0, 0, 0);
            ((h) this.o.get(i)).a(this.j, view, this, this.C);
            rect.left += this.j.left;
            rect.top += this.j.top;
            rect.right += this.j.right;
            rect.bottom += this.j.bottom;
        }
        jVar.e = false;
        return rect;
    }

    void i() {
        if (this.ag == null) {
            this.ag = this.ae.a(this, 1);
            if (this.h) {
                this.ag.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ag.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void i(int i, int i2) {
        this.ad++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i, i2);
        if (this.ax != null) {
            this.ax.a(this, i, i2);
        }
        if (this.ay != null) {
            for (scrollX = this.ay.size() - 1; scrollX >= 0; scrollX--) {
                ((n) this.ay.get(scrollX)).a(this, i, i2);
            }
        }
        this.ad--;
    }

    public boolean isAttachedToWindow() {
        return this.p;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    void j() {
        if (this.ai == null) {
            this.ai = this.ae.a(this, 3);
            if (this.h) {
                this.ai.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ai.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public boolean j(int i, int i2) {
        return getScrollingChildHelper().a(i, i2);
    }

    void k() {
        this.ai = null;
        this.ag = null;
        this.ah = null;
        this.af = null;
    }

    void k(View view) {
        x e = e(view);
        h(view);
        if (!(this.l == null || e == null)) {
            this.l.d(e);
        }
        if (this.ab != null) {
            for (int size = this.ab.size() - 1; size >= 0; size--) {
                ((k) this.ab.get(size)).b(view);
            }
        }
    }

    void l() {
        this.ac++;
    }

    void l(View view) {
        x e = e(view);
        g(view);
        if (!(this.l == null || e == null)) {
            this.l.c(e);
        }
        if (this.ab != null) {
            for (int size = this.ab.size() - 1; size >= 0; size--) {
                ((k) this.ab.get(size)).a(view);
            }
        }
    }

    void m() {
        b(true);
    }

    boolean n() {
        return this.aa != null && this.aa.isEnabled();
    }

    public boolean o() {
        return this.ac > 0;
    }

    /* JADX WARNING: Missing block: B:16:0x0051, code:
            if (r0 >= 30.0f) goto L_0x0055;
     */
    protected void onAttachedToWindow() {
        /*
        r4 = this;
        super.onAttachedToWindow();
        r0 = 0;
        r4.ac = r0;
        r1 = 1;
        r4.p = r1;
        r2 = r4.s;
        if (r2 == 0) goto L_0x0014;
    L_0x000d:
        r2 = r4.isLayoutRequested();
        if (r2 != 0) goto L_0x0014;
    L_0x0013:
        goto L_0x0015;
    L_0x0014:
        r1 = r0;
    L_0x0015:
        r4.s = r1;
        r1 = r4.m;
        if (r1 == 0) goto L_0x0020;
    L_0x001b:
        r1 = r4.m;
        r1.c(r4);
    L_0x0020:
        r4.F = r0;
        r0 = L;
        if (r0 == 0) goto L_0x006a;
    L_0x0026:
        r0 = android.support.v7.widget.al.a;
        r0 = r0.get();
        r0 = (android.support.v7.widget.al) r0;
        r4.A = r0;
        r0 = r4.A;
        if (r0 != 0) goto L_0x0065;
    L_0x0034:
        r0 = new android.support.v7.widget.al;
        r0.<init>();
        r4.A = r0;
        r0 = android.support.v4.h.r.z(r4);
        r1 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r4.isInEditMode();
        if (r2 != 0) goto L_0x0054;
    L_0x0047:
        if (r0 == 0) goto L_0x0054;
    L_0x0049:
        r0 = r0.getRefreshRate();
        r2 = 1106247680; // 0x41f00000 float:30.0 double:5.465589745E-315;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0054;
    L_0x0053:
        goto L_0x0055;
    L_0x0054:
        r0 = r1;
    L_0x0055:
        r1 = r4.A;
        r2 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
        r2 = r2 / r0;
        r2 = (long) r2;
        r1.d = r2;
        r0 = android.support.v7.widget.al.a;
        r1 = r4.A;
        r0.set(r1);
    L_0x0065:
        r0 = r4.A;
        r0.a(r4);
    L_0x006a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.onAttachedToWindow():void");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.y != null) {
            this.y.d();
        }
        f();
        this.p = false;
        if (this.m != null) {
            this.m.b(this, this.d);
        }
        this.H.clear();
        removeCallbacks(this.aG);
        this.g.b();
        if (L && this.A != null) {
            this.A.b(this);
            this.A = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            ((h) this.o.get(i)).b(canvas, this, this.C);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.m == null || this.u || motionEvent.getAction() != 8)) {
            float f;
            float axisValue;
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.m.f() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.m.e()) {
                    axisValue = motionEvent.getAxisValue(10);
                    if (!(f == 0.0f && axisValue == 0.0f)) {
                        a((int) (axisValue * this.au), (int) (f * this.av), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    f = motionEvent.getAxisValue(26);
                    if (this.m.f()) {
                        f = -f;
                    } else if (this.m.e()) {
                        axisValue = f;
                        f = 0.0f;
                        a((int) (axisValue * this.au), (int) (f * this.av), motionEvent);
                    }
                }
                f = 0.0f;
                axisValue = f;
                a((int) (axisValue * this.au), (int) (f * this.av), motionEvent);
            }
            axisValue = 0.0f;
            a((int) (axisValue * this.au), (int) (f * this.av), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.u) {
            return false;
        }
        if (a(motionEvent)) {
            E();
            return true;
        } else if (this.m == null) {
            return false;
        } else {
            boolean e = this.m.e();
            boolean f = this.m.f();
            if (this.al == null) {
                this.al = VelocityTracker.obtain();
            }
            this.al.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            int y;
            switch (actionMasked) {
                case 0:
                    if (this.V) {
                        this.V = false;
                    }
                    this.ak = motionEvent.getPointerId(0);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.ao = actionMasked;
                    this.am = actionMasked;
                    y = (int) (motionEvent.getY() + 0.5f);
                    this.ap = y;
                    this.an = y;
                    if (this.aj == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.aF;
                    this.aF[1] = 0;
                    iArr[0] = 0;
                    y = e ? 1 : 0;
                    if (f) {
                        y |= 2;
                    }
                    j(y, 0);
                    break;
                case 1:
                    this.al.clear();
                    g(0);
                    break;
                case 2:
                    actionMasked = motionEvent.findPointerIndex(this.ak);
                    if (actionMasked >= 0) {
                        actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                        y = (int) (motionEvent.getY(actionMasked) + 0.5f);
                        if (this.aj != 1) {
                            actionMasked = actionIndex - this.am;
                            int i = y - this.an;
                            if (!e || Math.abs(actionMasked) <= this.aq) {
                                e = false;
                            } else {
                                this.ao = actionIndex;
                                e = true;
                            }
                            if (f && Math.abs(i) > this.aq) {
                                this.ap = y;
                                e = true;
                            }
                            if (e) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error processing scroll; pointer index for id ");
                    stringBuilder.append(this.ak);
                    stringBuilder.append(" not found. Did any MotionEvents get skipped?");
                    Log.e("RecyclerView", stringBuilder.toString());
                    return false;
                    break;
                case 3:
                    E();
                    break;
                case 5:
                    this.ak = motionEvent.getPointerId(actionIndex);
                    int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.ao = x;
                    this.am = x;
                    y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.ap = y;
                    this.an = y;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            if (this.aj == 1) {
                z = true;
            }
            return z;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.support.v4.d.c.a("RV OnLayout");
        q();
        android.support.v4.d.c.a();
        this.s = true;
    }

    protected void onMeasure(int i, int i2) {
        if (this.m == null) {
            e(i, i2);
            return;
        }
        boolean z = false;
        if (this.m.c()) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            this.m.a(this.d, this.C, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.l != null) {
                if (this.C.c == 1) {
                    M();
                }
                this.m.c(i, i2);
                this.C.h = true;
                N();
                this.m.d(i, i2);
                if (this.m.l()) {
                    this.m.c(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.C.h = true;
                    N();
                    this.m.d(i, i2);
                }
            }
        } else if (this.q) {
            this.m.a(this.d, this.C, i, i2);
        } else {
            if (this.v) {
                e();
                l();
                H();
                m();
                if (this.C.j) {
                    this.C.f = true;
                } else {
                    this.e.e();
                    this.C.f = false;
                }
                this.v = false;
                a(false);
            } else if (this.C.j) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.l != null) {
                this.C.d = this.l.a();
            } else {
                this.C.d = 0;
            }
            e();
            this.m.a(this.d, this.C, i, i2);
            a(false);
            this.C.f = false;
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        return o() ? false : super.onRequestFocusInDescendants(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof s) {
            this.Q = (s) parcelable;
            super.onRestoreInstanceState(this.Q.a());
            if (!(this.m == null || this.Q.a == null)) {
                this.m.a(this.Q.a);
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:10:0x0022 in {3, 6, 8, 9} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    protected android.os.Parcelable onSaveInstanceState() {
        /*
        r2 = this;
        r0 = new android.support.v7.widget.at$s;
        r1 = super.onSaveInstanceState();
        r0.<init>(r1);
        r1 = r2.Q;
        if (r1 == 0) goto L_0x0013;
    L_0x000d:
        r2 = r2.Q;
        r0.a(r2);
        return r0;
    L_0x0013:
        r1 = r2.m;
        if (r1 == 0) goto L_0x0020;
    L_0x0017:
        r2 = r2.m;
        r2 = r2.d();
    L_0x001d:
        r0.a = r2;
        return r0;
    L_0x0020:
        r2 = 0;
        goto L_0x001d;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.onSaveInstanceState():android.os.Parcelable");
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            k();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.u || this.V) {
            return false;
        }
        if (b(motionEvent)) {
            E();
            return true;
        } else if (this.m == null) {
            return false;
        } else {
            int[] iArr;
            boolean e = this.m.e();
            boolean f = this.m.f();
            if (this.al == null) {
                this.al = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                iArr = this.aF;
                this.aF[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.aF[0], (float) this.aF[1]);
            int y;
            switch (actionMasked) {
                case 0:
                    this.ak = motionEvent.getPointerId(0);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.ao = actionMasked;
                    this.am = actionMasked;
                    y = (int) (motionEvent.getY() + 0.5f);
                    this.ap = y;
                    this.an = y;
                    y = e ? 1 : 0;
                    if (f) {
                        y |= 2;
                    }
                    j(y, 0);
                    break;
                case 1:
                    this.al.addMovement(obtain);
                    this.al.computeCurrentVelocity(1000, (float) this.at);
                    float f2 = e ? -this.al.getXVelocity(this.ak) : 0.0f;
                    float f3 = f ? -this.al.getYVelocity(this.ak) : 0.0f;
                    if ((f2 == 0.0f && f3 == 0.0f) || !b((int) f2, (int) f3)) {
                        setScrollState(0);
                    }
                    D();
                    z = true;
                    break;
                case 2:
                    actionMasked = motionEvent.findPointerIndex(this.ak);
                    if (actionMasked >= 0) {
                        actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                        y = (int) (motionEvent.getY(actionMasked) + 0.5f);
                        actionMasked = this.ao - actionIndex;
                        int i = this.ap - y;
                        if (a(actionMasked, i, this.aE, this.aD, 0)) {
                            actionMasked -= this.aE[0];
                            i -= this.aE[1];
                            obtain.offsetLocation((float) this.aD[0], (float) this.aD[1]);
                            iArr = this.aF;
                            iArr[0] = iArr[0] + this.aD[0];
                            iArr = this.aF;
                            iArr[1] = iArr[1] + this.aD[1];
                        }
                        if (this.aj != 1) {
                            boolean z2;
                            if (!e || Math.abs(actionMasked) <= this.aq) {
                                z2 = false;
                            } else {
                                actionMasked = actionMasked > 0 ? actionMasked - this.aq : actionMasked + this.aq;
                                z2 = true;
                            }
                            if (f && Math.abs(i) > this.aq) {
                                i = i > 0 ? i - this.aq : i + this.aq;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.aj == 1) {
                            this.ao = actionIndex - this.aD[0];
                            this.ap = y - this.aD[1];
                            if (a(e ? actionMasked : 0, f ? i : 0, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (!(this.A == null || (actionMasked == 0 && i == 0))) {
                                this.A.a(this, actionMasked, i);
                                break;
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error processing scroll; pointer index for id ");
                    stringBuilder.append(this.ak);
                    stringBuilder.append(" not found. Did any MotionEvents get skipped?");
                    Log.e("RecyclerView", stringBuilder.toString());
                    return false;
                    break;
                case 3:
                    E();
                    break;
                case 5:
                    this.ak = motionEvent.getPointerId(actionIndex);
                    int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.ao = x;
                    this.am = x;
                    y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.ap = y;
                    this.an = y;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            if (!z) {
                this.al.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    void p() {
        if (!this.F && this.p) {
            android.support.v4.h.r.a((View) this, this.aG);
            this.F = true;
        }
    }

    void q() {
        String str;
        String str2;
        if (this.l == null) {
            str = "RecyclerView";
            str2 = "No adapter attached; skipping layout";
        } else if (this.m == null) {
            str = "RecyclerView";
            str2 = "No layout manager attached; skipping layout";
        } else {
            this.C.h = false;
            if (this.C.c == 1) {
                M();
            } else if (!this.e.f() && this.m.y() == getWidth() && this.m.z() == getHeight()) {
                this.m.f(this);
                O();
                return;
            }
            this.m.f(this);
            N();
            O();
            return;
        }
        Log.e(str, str2);
    }

    void r() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            ((j) this.f.d(i).getLayoutParams()).e = true;
        }
        this.d.j();
    }

    protected void removeDetachedView(View view, boolean z) {
        x e = e(view);
        if (e != null) {
            if (e.r()) {
                e.m();
            } else if (!e.c()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                stringBuilder.append(e);
                stringBuilder.append(a());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        view.clearAnimation();
        k(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.m.a(this, this.C, view, view2) || view2 == null)) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.m.a(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.S.size();
        for (int i = 0; i < size; i++) {
            ((m) this.S.get(i)).a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.U != 0 || this.u) {
            this.t = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            x e = e(this.f.d(i));
            if (!e.c()) {
                e.b();
            }
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.u) {
            boolean e = this.m.e();
            boolean f = this.m.f();
            if (e || f) {
                if (!e) {
                    i = 0;
                }
                if (!f) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(au auVar) {
        this.G = auVar;
        android.support.v4.h.r.a((View) this, this.G);
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        c(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.aA) {
            this.aA = dVar;
            setChildrenDrawingOrderEnabled(this.aA != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.h) {
            k();
        }
        this.h = z;
        super.setClipToPadding(z);
        if (this.s) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(e eVar) {
        android.support.v4.g.k.a((Object) eVar);
        this.ae = eVar;
        k();
    }

    public void setHasFixedSize(boolean z) {
        this.q = z;
    }

    public void setItemAnimator(f fVar) {
        if (this.y != null) {
            this.y.d();
            this.y.a(null);
        }
        this.y = fVar;
        if (this.y != null) {
            this.y.a(this.az);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.d.a(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.u) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.u = true;
                this.V = true;
                f();
            } else {
                this.u = false;
                if (!(!this.t || this.m == null || this.l == null)) {
                    requestLayout();
                }
                this.t = false;
            }
        }
    }

    public void setLayoutManager(i iVar) {
        if (iVar != this.m) {
            f();
            if (this.m != null) {
                if (this.y != null) {
                    this.y.d();
                }
                this.m.c(this.d);
                this.m.b(this.d);
                this.d.a();
                if (this.p) {
                    this.m.b(this, this.d);
                }
                this.m.b(null);
                this.m = null;
            } else {
                this.d.a();
            }
            this.f.a();
            this.m = iVar;
            if (iVar != null) {
                if (iVar.q != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("LayoutManager ");
                    stringBuilder.append(iVar);
                    stringBuilder.append(" is already attached to a RecyclerView:");
                    stringBuilder.append(iVar.q.a());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                this.m.b(this);
                if (this.p) {
                    this.m.c(this);
                }
            }
            this.d.b();
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    public void setOnFlingListener(l lVar) {
        this.ar = lVar;
    }

    @Deprecated
    public void setOnScrollListener(n nVar) {
        this.ax = nVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.aw = z;
    }

    public void setRecycledViewPool(o oVar) {
        this.d.a(oVar);
    }

    public void setRecyclerListener(q qVar) {
        this.n = qVar;
    }

    void setScrollState(int i) {
        if (i != this.aj) {
            this.aj = i;
            if (i != 2) {
                B();
            }
            f(i);
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                i = viewConfiguration.getScaledPagingTouchSlop();
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
                stringBuilder.append(i);
                stringBuilder.append("; using default value");
                Log.w("RecyclerView", stringBuilder.toString());
                break;
        }
        i = viewConfiguration.getScaledTouchSlop();
        this.aq = i;
    }

    public void setViewCacheExtension(v vVar) {
        this.d.a(vVar);
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().b(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    void t() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            x e = e(this.f.d(i));
            if (!e.c()) {
                e.a();
            }
        }
        this.d.i();
    }

    void u() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            x e = e(this.f.d(i));
            if (!(e == null || e.c())) {
                e.b(6);
            }
        }
        r();
        this.d.h();
    }

    public boolean v() {
        return !this.s || this.w || this.e.d();
    }

    void w() {
        int b = this.f.b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f.b(i);
            x b3 = b(b2);
            if (!(b3 == null || b3.i == null)) {
                View view = b3.i.a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void x() {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            x xVar = (x) this.H.get(size);
            if (xVar.a.getParent() == this && !xVar.c()) {
                int i = xVar.l;
                if (i != -1) {
                    android.support.v4.h.r.a(xVar.a, i);
                    xVar.l = -1;
                }
            }
        }
        this.H.clear();
    }
}
