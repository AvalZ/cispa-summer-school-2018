package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.g.i;
import android.support.v4.h.n;
import android.support.v4.h.o;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v4.h.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements n {
    static final String a;
    static final Class<?>[] b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<b>>> c = new ThreadLocal();
    static final Comparator<View> d;
    private static final android.support.v4.g.j.a<Rect> f = new android.support.v4.g.j.c(12);
    OnHierarchyChangeListener e;
    private final List<View> g;
    private final android.support.v4.widget.f<View> h;
    private final List<View> i;
    private final List<View> j;
    private final int[] k;
    private Paint l;
    private boolean m;
    private boolean n;
    private int[] o;
    private View p;
    private View q;
    private f r;
    private boolean s;
    private z t;
    private boolean u;
    private Drawable v;
    private p w;
    private final o x;

    public interface a {
        b a();
    }

    public static abstract class b<V extends View> {
        public b(Context context, AttributeSet attributeSet) {
        }

        public z a(CoordinatorLayout coordinatorLayout, V v, z zVar) {
            return zVar;
        }

        public void a(e eVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                c(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, (View) v, view, i, i2, i3, i4);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, (View) v, view, i, i2, iArr);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        @Deprecated
        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            return i2 == 0 ? a(coordinatorLayout, (View) v, view, view2, i) : false;
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                b(coordinatorLayout, v, view, view2, i);
            }
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public void c() {
        }

        @Deprecated
        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public float d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v) {
            return d(coordinatorLayout, v) > 0.0f;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class<? extends b> a();
    }

    private class d implements OnHierarchyChangeListener {
        d() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.e != null) {
                CoordinatorLayout.this.e.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            if (CoordinatorLayout.this.e != null) {
                CoordinatorLayout.this.e.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class e extends MarginLayoutParams {
        b a;
        boolean b = false;
        public int c = 0;
        public int d = 0;
        public int e = -1;
        int f = -1;
        public int g = 0;
        public int h = 0;
        int i;
        int j;
        View k;
        View l;
        final Rect m = new Rect();
        Object n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;

        public e(int i, int i2) {
            super(i, i2);
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.b.a.c.CoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(android.support.b.a.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = obtainStyledAttributes.getResourceId(android.support.b.a.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = obtainStyledAttributes.getInteger(android.support.b.a.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = obtainStyledAttributes.getInteger(android.support.b.a.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = obtainStyledAttributes.getInt(android.support.b.a.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(android.support.b.a.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.b = obtainStyledAttributes.hasValue(android.support.b.a.c.CoordinatorLayout_Layout_layout_behavior);
            if (this.b) {
                this.a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(android.support.b.a.c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.a != null) {
                this.a.a(this);
            }
        }

        public e(e eVar) {
            super(eVar);
        }

        public e(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f);
            if (this.k != null) {
                if (this.k != coordinatorLayout) {
                    View view2 = this.k;
                    View parent = this.k.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.l = view2;
                    return;
                } else if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
                stringBuilder.append(coordinatorLayout.getResources().getResourceName(this.f));
                stringBuilder.append(" to anchor view ");
                stringBuilder.append(view);
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.l = null;
            this.k = null;
        }

        private boolean a(View view, int i) {
            int a = android.support.v4.h.d.a(((e) view.getLayoutParams()).g, i);
            return a != 0 && (android.support.v4.h.d.a(this.h, i) & a) == a;
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            View parent = this.k.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.l = view2;
            return true;
        }

        public int a() {
            return this.f;
        }

        void a(int i) {
            a(i, false);
        }

        void a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.p = z;
                    return;
                case 1:
                    this.q = z;
                    return;
                default:
                    return;
            }
        }

        void a(Rect rect) {
            this.m.set(rect);
        }

        public void a(b bVar) {
            if (this.a != bVar) {
                if (this.a != null) {
                    this.a.c();
                }
                this.a = bVar;
                this.n = null;
                this.b = true;
                if (bVar != null) {
                    bVar.a(this);
                }
            }
        }

        void a(boolean z) {
            this.r = z;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.o) {
                return true;
            }
            boolean e = (this.a != null ? this.a.e(coordinatorLayout, view) : 0) | this.o;
            this.o = e;
            return e;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.l || a(view2, r.e(coordinatorLayout)) || (this.a != null && this.a.a(coordinatorLayout, view, view2));
        }

        public b b() {
            return this.a;
        }

        View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        boolean b(int i) {
            switch (i) {
                case 0:
                    return this.p;
                case 1:
                    return this.q;
                default:
                    return false;
            }
        }

        Rect c() {
            return this.m;
        }

        boolean d() {
            return this.k == null && this.f != -1;
        }

        boolean e() {
            if (this.a == null) {
                this.o = false;
            }
            return this.o;
        }

        void f() {
            this.o = false;
        }

        boolean g() {
            return this.r;
        }

        void h() {
            this.r = false;
        }
    }

    class f implements OnPreDrawListener {
        f() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    static class h implements Comparator<View> {
        h() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float v = r.v(view);
            float v2 = r.v(view2);
            return v > v2 ? -1 : v < v2 ? 1 : 0;
        }
    }

    protected static class g extends android.support.v4.h.a {
        public static final Creator<g> CREATOR = new ClassLoaderCreator<g>() {
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            /* renamed from: a */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            /* renamed from: a */
            public g[] newArray(int i) {
                return new g[i];
            }
        };
        SparseArray<Parcelable> a;

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int i2 = 0;
            int size = this.a != null ? this.a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            d = new h();
        } else {
            d = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.b.a.a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new ArrayList();
        this.h = new android.support.v4.widget.f();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new int[2];
        this.x = new o(this);
        int i2 = 0;
        TypedArray obtainStyledAttributes = i == 0 ? context.obtainStyledAttributes(attributeSet, android.support.b.a.c.CoordinatorLayout, 0, android.support.b.a.b.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, android.support.b.a.c.CoordinatorLayout, i, 0);
        i = obtainStyledAttributes.getResourceId(android.support.b.a.c.CoordinatorLayout_keylines, 0);
        if (i != 0) {
            Resources resources = context.getResources();
            this.o = resources.getIntArray(i);
            float f = resources.getDisplayMetrics().density;
            i = this.o.length;
            while (i2 < i) {
                this.o[i2] = (int) (((float) this.o[i2]) * f);
                i2++;
            }
        }
        this.v = obtainStyledAttributes.getDrawable(android.support.b.a.c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        g();
        super.setOnHierarchyChangeListener(new d());
    }

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    static b a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder;
        if (str.startsWith(".")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(str);
            str = stringBuilder.toString();
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(a)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append('.');
            stringBuilder2.append(str);
            str = stringBuilder2.toString();
        }
        try {
            Map map = (Map) c.get();
            if (map == null) {
                map = new HashMap();
                c.set(map);
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not inflate Behavior subclass ");
            stringBuilder.append(str);
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f.a(rect);
    }

    private void a(e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - eVar.rightMargin));
        int max = Math.max(getPaddingTop() + eVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - eVar.bottomMargin));
        rect.set(width, max, i + width, i2 + max);
    }

    private void a(View view, int i, Rect rect, Rect rect2, e eVar, int i2, int i3) {
        int a = android.support.v4.h.d.a(e(eVar.c), i);
        int a2 = android.support.v4.h.d.a(c(eVar.d), i);
        i = a & 7;
        a &= 112;
        int i4 = a2 & 7;
        a2 &= 112;
        i4 = i4 != 1 ? i4 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        a2 = a2 != 16 ? a2 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i == 1) {
            i4 -= i2 / 2;
        } else if (i != 5) {
            i4 -= i2;
        }
        if (a == 16) {
            a2 -= i3 / 2;
        } else if (a != 80) {
            a2 -= i3;
        }
        rect2.set(i4, a2, i2 + i4, i3 + a2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fc  */
    private void a(android.view.View r9, android.graphics.Rect r10, int r11) {
        /*
        r8 = this;
        r0 = android.support.v4.h.r.u(r9);
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r9.getWidth();
        if (r0 <= 0) goto L_0x0102;
    L_0x000d:
        r0 = r9.getHeight();
        if (r0 > 0) goto L_0x0014;
    L_0x0013:
        return;
    L_0x0014:
        r0 = r9.getLayoutParams();
        r0 = (android.support.design.widget.CoordinatorLayout.e) r0;
        r1 = r0.b();
        r2 = e();
        r3 = e();
        r4 = r9.getLeft();
        r5 = r9.getTop();
        r6 = r9.getRight();
        r7 = r9.getBottom();
        r3.set(r4, r5, r6, r7);
        if (r1 == 0) goto L_0x006e;
    L_0x003b:
        r1 = r1.a(r8, r9, r2);
        if (r1 == 0) goto L_0x006e;
    L_0x0041:
        r1 = r3.contains(r2);
        if (r1 != 0) goto L_0x0071;
    L_0x0047:
        r8 = new java.lang.IllegalArgumentException;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "Rect should be within the child's bounds. Rect:";
        r9.append(r10);
        r10 = r2.toShortString();
        r9.append(r10);
        r10 = " | Bounds:";
        r9.append(r10);
        r10 = r3.toShortString();
        r9.append(r10);
        r9 = r9.toString();
        r8.<init>(r9);
        throw r8;
    L_0x006e:
        r2.set(r3);
    L_0x0071:
        a(r3);
        r1 = r2.isEmpty();
        if (r1 == 0) goto L_0x007e;
    L_0x007a:
        a(r2);
        return;
    L_0x007e:
        r1 = r0.h;
        r11 = android.support.v4.h.d.a(r1, r11);
        r1 = r11 & 48;
        r3 = 48;
        r4 = 1;
        r5 = 0;
        if (r1 != r3) goto L_0x00a0;
    L_0x008c:
        r1 = r2.top;
        r3 = r0.topMargin;
        r1 = r1 - r3;
        r3 = r0.j;
        r1 = r1 - r3;
        r3 = r10.top;
        if (r1 >= r3) goto L_0x00a0;
    L_0x0098:
        r3 = r10.top;
        r3 = r3 - r1;
        r8.f(r9, r3);
        r1 = r4;
        goto L_0x00a1;
    L_0x00a0:
        r1 = r5;
    L_0x00a1:
        r3 = r11 & 80;
        r6 = 80;
        if (r3 != r6) goto L_0x00bf;
    L_0x00a7:
        r3 = r8.getHeight();
        r6 = r2.bottom;
        r3 = r3 - r6;
        r6 = r0.bottomMargin;
        r3 = r3 - r6;
        r6 = r0.j;
        r3 = r3 + r6;
        r6 = r10.bottom;
        if (r3 >= r6) goto L_0x00bf;
    L_0x00b8:
        r1 = r10.bottom;
        r3 = r3 - r1;
        r8.f(r9, r3);
        r1 = r4;
    L_0x00bf:
        if (r1 != 0) goto L_0x00c4;
    L_0x00c1:
        r8.f(r9, r5);
    L_0x00c4:
        r1 = r11 & 3;
        r3 = 3;
        if (r1 != r3) goto L_0x00dd;
    L_0x00c9:
        r1 = r2.left;
        r3 = r0.leftMargin;
        r1 = r1 - r3;
        r3 = r0.i;
        r1 = r1 - r3;
        r3 = r10.left;
        if (r1 >= r3) goto L_0x00dd;
    L_0x00d5:
        r3 = r10.left;
        r3 = r3 - r1;
        r8.e(r9, r3);
        r1 = r4;
        goto L_0x00de;
    L_0x00dd:
        r1 = r5;
    L_0x00de:
        r3 = 5;
        r11 = r11 & r3;
        if (r11 != r3) goto L_0x00fa;
    L_0x00e2:
        r11 = r8.getWidth();
        r3 = r2.right;
        r11 = r11 - r3;
        r3 = r0.rightMargin;
        r11 = r11 - r3;
        r0 = r0.i;
        r11 = r11 + r0;
        r0 = r10.right;
        if (r11 >= r0) goto L_0x00fa;
    L_0x00f3:
        r10 = r10.right;
        r11 = r11 - r10;
        r8.e(r9, r11);
        r1 = r4;
    L_0x00fa:
        if (r1 != 0) goto L_0x00ff;
    L_0x00fc:
        r8.e(r9, r5);
    L_0x00ff:
        a(r2);
    L_0x0102:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.a(android.view.View, android.graphics.Rect, int):void");
    }

    private void a(View view, View view2, int i) {
        Rect e = e();
        Rect e2 = e();
        try {
            a(view2, e);
            a(view, i, e, e2);
            view.layout(e2.left, e2.top, e2.right, e2.bottom);
        } finally {
            a(e);
            a(e2);
        }
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (d != null) {
            Collections.sort(list, d);
        }
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            b b = ((e) childAt.getLayoutParams()).b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    b.a(this, childAt, obtain);
                } else {
                    b.b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((e) getChildAt(i2).getLayoutParams()).f();
        }
        this.p = null;
        this.m = false;
    }

    private boolean a(MotionEvent motionEvent, int i) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.i;
        a(list);
        int size = list.size();
        boolean z = false;
        boolean z2 = z;
        MotionEvent motionEvent3 = null;
        for (int i2 = z2; i2 < size; i2++) {
            View view = (View) list.get(i2);
            e eVar = (e) view.getLayoutParams();
            b b = eVar.b();
            if ((z || z2) && actionMasked != 0) {
                if (b != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    switch (i) {
                        case 0:
                            b.a(this, view, motionEvent3);
                            break;
                        case 1:
                            b.b(this, view, motionEvent3);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                if (!(z || b == null)) {
                    switch (i) {
                        case 0:
                            z = b.a(this, view, motionEvent2);
                            break;
                        case 1:
                            z = b.b(this, view, motionEvent2);
                            break;
                    }
                    if (z) {
                        this.p = view;
                    }
                }
                z2 = eVar.e();
                boolean a = eVar.a(this, view);
                z2 = a && !z2;
                if (a && !z2) {
                    list.clear();
                    return z;
                }
            }
        }
        list.clear();
        return z;
    }

    private int b(int i) {
        String str;
        StringBuilder stringBuilder;
        if (this.o == null) {
            str = "CoordinatorLayout";
            stringBuilder = new StringBuilder();
            stringBuilder.append("No keylines defined for ");
            stringBuilder.append(this);
            stringBuilder.append(" - attempted index lookup ");
            stringBuilder.append(i);
        } else if (i >= 0 && i < this.o.length) {
            return this.o[i];
        } else {
            str = "CoordinatorLayout";
            stringBuilder = new StringBuilder();
            stringBuilder.append("Keyline index ");
            stringBuilder.append(i);
            stringBuilder.append(" out of range for ");
            stringBuilder.append(this);
        }
        Log.e(str, stringBuilder.toString());
        return 0;
    }

    private z b(z zVar) {
        if (zVar.e()) {
            return zVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (r.n(childAt)) {
                b b = ((e) childAt.getLayoutParams()).b();
                if (b != null) {
                    zVar = b.a(this, childAt, zVar);
                    if (zVar.e()) {
                        return zVar;
                    }
                } else {
                    continue;
                }
            }
        }
        return zVar;
    }

    private void b(View view, int i, int i2) {
        e eVar = (e) view.getLayoutParams();
        int a = android.support.v4.h.d.a(d(eVar.c), i2);
        int i3 = a & 7;
        a &= 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        i = b(i) - measuredWidth;
        i2 = 0;
        if (i3 == 1) {
            i += measuredWidth / 2;
        } else if (i3 == 5) {
            i += measuredWidth;
        }
        if (a == 16) {
            i2 = 0 + (measuredHeight / 2);
        } else if (a == 80) {
            i2 = measuredHeight + 0;
        }
        i = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(i, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int max = Math.max(getPaddingTop() + eVar.topMargin, Math.min(i2, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        view.layout(i, max, measuredWidth + i, measuredHeight + max);
    }

    private static int c(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int d(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void d(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        Rect e = e();
        e.set(getPaddingLeft() + eVar.leftMargin, getPaddingTop() + eVar.topMargin, (getWidth() - getPaddingRight()) - eVar.rightMargin, (getHeight() - getPaddingBottom()) - eVar.bottomMargin);
        if (!(this.t == null || !r.n(this) || r.n(view))) {
            e.left += this.t.a();
            e.top += this.t.b();
            e.right -= this.t.c();
            e.bottom -= this.t.d();
        }
        Rect e2 = e();
        android.support.v4.h.d.a(c(eVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), e, e2, i);
        view.layout(e2.left, e2.top, e2.right, e2.bottom);
        a(e);
        a(e2);
    }

    private static int e(int i) {
        return i == 0 ? 17 : i;
    }

    private static Rect e() {
        Rect rect = (Rect) f.a();
        return rect == null ? new Rect() : rect;
    }

    private void e(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.i != i) {
            r.d(view, i - eVar.i);
            eVar.i = i;
        }
    }

    private boolean e(View view) {
        return this.h.e(view);
    }

    private void f() {
        this.g.clear();
        this.h.a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childAt = getChildAt(i);
            e a = a((View) childAt);
            a.b(this, (View) childAt);
            this.h.a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    Object childAt2 = getChildAt(i2);
                    if (a.a(this, childAt, childAt2)) {
                        if (!this.h.b(childAt2)) {
                            this.h.a(childAt2);
                        }
                        this.h.a(childAt2, childAt);
                    }
                }
            }
        }
        this.g.addAll(this.h.b());
        Collections.reverse(this.g);
    }

    private void f(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.j != i) {
            r.c(view, i - eVar.j);
            eVar.j = i;
        }
    }

    private void g() {
        if (VERSION.SDK_INT >= 21) {
            if (r.n(this)) {
                if (this.w == null) {
                    this.w = new p() {
                        public z a(View view, z zVar) {
                            return CoordinatorLayout.this.a(zVar);
                        }
                    };
                }
                r.a((View) this, this.w);
                setSystemUiVisibility(1280);
                return;
            }
            r.a((View) this, null);
        }
    }

    /* renamed from: a */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    e a(View view) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.b) {
            return eVar;
        }
        if (view instanceof a) {
            b a = ((a) view).a();
            if (a == null) {
                Log.e("CoordinatorLayout", "Attached behavior class is null");
            }
            eVar.a(a);
        } else {
            c cVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                cVar = (c) cls.getAnnotation(c.class);
                if (cVar != null) {
                    break;
                }
            }
            if (cVar != null) {
                try {
                    eVar.a((b) cVar.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Default behavior class ");
                    stringBuilder.append(cVar.a().getName());
                    stringBuilder.append(" could not be instantiated. Did you forget");
                    stringBuilder.append(" a default constructor?");
                    Log.e("CoordinatorLayout", stringBuilder.toString(), e);
                }
            }
        }
        eVar.b = true;
        return eVar;
    }

    /* renamed from: a */
    protected e generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof MarginLayoutParams ? new e((MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    final z a(z zVar) {
        if (i.a(this.t, zVar)) {
            return zVar;
        }
        this.t = zVar;
        boolean z = false;
        boolean z2 = zVar != null && zVar.b() > 0;
        this.u = z2;
        if (!this.u && getBackground() == null) {
            z = true;
        }
        setWillNotDraw(z);
        zVar = b(zVar);
        requestLayout();
        return zVar;
    }

    void a() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z != this.s) {
            if (z) {
                b();
                return;
            }
            c();
        }
    }

    final void a(int i) {
        int i2 = i;
        int e = r.e(this);
        int size = this.g.size();
        Rect e2 = e();
        Rect e3 = e();
        Rect e4 = e();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.g.get(i3);
            e eVar = (e) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                int a;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (eVar.l == ((View) this.g.get(i4))) {
                        b(view, e);
                    }
                }
                a(view, true, e3);
                if (!(eVar.g == 0 || e3.isEmpty())) {
                    a = android.support.v4.h.d.a(eVar.g, e);
                    int i5 = a & 112;
                    if (i5 == 48) {
                        e2.top = Math.max(e2.top, e3.bottom);
                    } else if (i5 == 80) {
                        e2.bottom = Math.max(e2.bottom, getHeight() - e3.top);
                    }
                    a &= 7;
                    if (a == 3) {
                        e2.left = Math.max(e2.left, e3.right);
                    } else if (a == 5) {
                        e2.right = Math.max(e2.right, getWidth() - e3.left);
                    }
                }
                if (eVar.h != 0 && view.getVisibility() == 0) {
                    a(view, e2, e);
                }
                if (i2 != 2) {
                    c(view, e4);
                    if (!e4.equals(e3)) {
                        b(view, e3);
                    }
                }
                for (a = i3 + 1; a < size; a++) {
                    View view2 = (View) this.g.get(a);
                    e eVar2 = (e) view2.getLayoutParams();
                    b b = eVar2.b();
                    if (b != null && b.a(this, view2, view)) {
                        if (i2 == 0 && eVar2.g()) {
                            eVar2.h();
                        } else {
                            boolean b2;
                            if (i2 != 2) {
                                b2 = b.b(this, view2, view);
                            } else {
                                b.d(this, view2, view);
                                b2 = true;
                            }
                            if (i2 == 1) {
                                eVar2.a(b2);
                            }
                        }
                    }
                }
            }
        }
        a(e2);
        a(e3);
        a(e4);
    }

    public void a(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (eVar.k != null) {
            a(view, eVar.k, i);
        } else if (eVar.e >= 0) {
            b(view, eVar.e, i);
        } else {
            d(view, i);
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    public void a(View view, int i, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int i8;
            if (childAt.getVisibility() == 8) {
                i8 = i5;
            } else {
                e eVar = (e) childAt.getLayoutParams();
                i8 = i5;
                if (eVar.b(i8)) {
                    b b = eVar.b();
                    if (b != null) {
                        b.a(this, childAt, view, i, i2, i3, i4, i8);
                        i6 = 1;
                    }
                }
            }
        }
        if (i6 != 0) {
            a(1);
        }
    }

    public void a(View view, int i, int i2, int[] iArr, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = i4;
        int i6 = i5;
        int i7 = i6;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(i3)) {
                    b b = eVar.b();
                    if (b != null) {
                        int[] iArr2 = this.k;
                        this.k[1] = 0;
                        iArr2[0] = 0;
                        b.a(this, childAt, view, i, i2, this.k, i3);
                        i6 = i > 0 ? Math.max(i6, this.k[0]) : Math.min(i6, this.k[0]);
                        i7 = i2 > 0 ? Math.max(i7, this.k[1]) : Math.min(i7, this.k[1]);
                        i4 = 1;
                    }
                }
            }
            i5++;
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (i4 != 0) {
            a(1);
        }
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i, rect, rect2, eVar, measuredWidth, measuredHeight);
        a(eVar, rect2, measuredWidth, measuredHeight);
    }

    void a(View view, Rect rect) {
        android.support.v4.widget.r.b(this, view, rect);
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean a(View view, int i, int i2) {
        Rect e = e();
        a(view, e);
        try {
            boolean contains = e.contains(i, i2);
            return contains;
        } finally {
            a(e);
        }
    }

    public boolean a(View view, View view2, int i, int i2) {
        int i3 = i2;
        int childCount = getChildCount();
        int i4 = 0;
        boolean z = i4;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b b = eVar.b();
                if (b != null) {
                    boolean a = b.a(this, childAt, view, view2, i, i3);
                    boolean z2 = z | a;
                    eVar.a(i3, a);
                    z = z2;
                } else {
                    eVar.a(i3, false);
                }
            }
            i4++;
        }
        return z;
    }

    void b() {
        if (this.n) {
            if (this.r == null) {
                this.r = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        this.s = true;
    }

    public void b(View view) {
        List c = this.h.c(view);
        if (c != null && !c.isEmpty()) {
            for (int i = 0; i < c.size(); i++) {
                View view2 = (View) c.get(i);
                b b = ((e) view2.getLayoutParams()).b();
                if (b != null) {
                    b.b(this, view2, view);
                }
            }
        }
    }

    void b(View view, int i) {
        View view2 = view;
        e eVar = (e) view.getLayoutParams();
        if (eVar.k != null) {
            Rect e = e();
            Rect e2 = e();
            Rect e3 = e();
            a(eVar.k, e);
            boolean z = false;
            a(view2, false, e2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i2 = measuredHeight;
            a(view2, i, e, e3, eVar, measuredWidth, measuredHeight);
            if (!(e3.left == e2.left && e3.top == e2.top)) {
                z = true;
            }
            a(eVar, e3, measuredWidth, i2);
            int i3 = e3.left - e2.left;
            int i4 = e3.top - e2.top;
            if (i3 != 0) {
                r.d(view2, i3);
            }
            if (i4 != 0) {
                r.c(view2, i4);
            }
            if (z) {
                b b = eVar.b();
                if (b != null) {
                    b.b(this, view2, eVar.k);
                }
            }
            a(e);
            a(e2);
            a(e3);
        }
    }

    void b(View view, Rect rect) {
        ((e) view.getLayoutParams()).a(rect);
    }

    public void b(View view, View view2, int i, int i2) {
        this.x.a(view, view2, i, i2);
        this.q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.b(i2)) {
                b b = eVar.b();
                if (b != null) {
                    b.b(this, childAt, view, view2, i, i2);
                }
            }
        }
    }

    public List<View> c(View view) {
        Collection d = this.h.d(view);
        this.j.clear();
        if (d != null) {
            this.j.addAll(d);
        }
        return this.j;
    }

    void c() {
        if (this.n && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        this.s = false;
    }

    public void c(View view, int i) {
        this.x.a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.b(i)) {
                b b = eVar.b();
                if (b != null) {
                    b.a(this, childAt, view, i);
                }
                eVar.a(i);
                eVar.h();
            }
        }
        this.q = null;
    }

    void c(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    /* renamed from: d */
    protected e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    public List<View> d(View view) {
        Collection c = this.h.c(view);
        this.j.clear();
        if (c != null) {
            this.j.addAll(c);
        }
        return this.j;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.a != null) {
            float d = eVar.a.d(this, view);
            if (d > 0.0f) {
                if (this.l == null) {
                    this.l = new Paint();
                }
                this.l.setColor(eVar.a.c(this, view));
                this.l.setAlpha(a(Math.round(d * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.v;
        int i = 0;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    final List<View> getDependencySortedChildren() {
        f();
        return Collections.unmodifiableList(this.g);
    }

    public final z getLastWindowInsets() {
        return this.t;
    }

    public int getNestedScrollAxes() {
        return this.x.a();
    }

    public Drawable getStatusBarBackground() {
        return this.v;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.s) {
            if (this.r == null) {
                this.r = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        if (this.t == null && r.n(this)) {
            r.m(this);
        }
        this.n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.s && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        if (this.q != null) {
            onStopNestedScroll(this.q);
        }
        this.n = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.u && this.v != null) {
            int b = this.t != null ? this.t.b() : 0;
            if (b > 0) {
                this.v.setBounds(0, 0, getWidth(), b);
                this.v.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int e = r.e(this);
        i = this.g.size();
        for (i2 = 0; i2 < i; i2++) {
            View view = (View) this.g.get(i2);
            if (view.getVisibility() != 8) {
                b b = ((e) view.getLayoutParams()).b();
                if (b == null || !b.a(this, view, e)) {
                    a(view, e);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0126  */
    /* JADX WARNING: Missing block: B:41:0x0120, code:
            if (r0.a(r7, r3, r23, r20, r25, 0) == false) goto L_0x0134;
     */
    protected void onMeasure(int r32, int r33) {
        /*
        r31 = this;
        r7 = r31;
        r31.f();
        r31.a();
        r8 = r31.getPaddingLeft();
        r0 = r31.getPaddingTop();
        r9 = r31.getPaddingRight();
        r1 = r31.getPaddingBottom();
        r10 = android.support.v4.h.r.e(r31);
        r2 = 1;
        if (r10 != r2) goto L_0x0021;
    L_0x001f:
        r12 = r2;
        goto L_0x0022;
    L_0x0021:
        r12 = 0;
    L_0x0022:
        r13 = android.view.View.MeasureSpec.getMode(r32);
        r14 = android.view.View.MeasureSpec.getSize(r32);
        r15 = android.view.View.MeasureSpec.getMode(r33);
        r16 = android.view.View.MeasureSpec.getSize(r33);
        r17 = r8 + r9;
        r18 = r0 + r1;
        r0 = r31.getSuggestedMinimumWidth();
        r1 = r31.getSuggestedMinimumHeight();
        r3 = r7.t;
        if (r3 == 0) goto L_0x004b;
    L_0x0042:
        r3 = android.support.v4.h.r.n(r31);
        if (r3 == 0) goto L_0x004b;
    L_0x0048:
        r19 = r2;
        goto L_0x004d;
    L_0x004b:
        r19 = 0;
    L_0x004d:
        r2 = r7.g;
        r6 = r2.size();
        r4 = r0;
        r2 = r1;
        r3 = 0;
        r5 = 0;
    L_0x0057:
        if (r5 >= r6) goto L_0x0178;
    L_0x0059:
        r0 = r7.g;
        r0 = r0.get(r5);
        r1 = r0;
        r1 = (android.view.View) r1;
        r0 = r1.getVisibility();
        r11 = 8;
        if (r0 != r11) goto L_0x0072;
    L_0x006a:
        r22 = r5;
        r24 = r6;
        r21 = 0;
        goto L_0x0172;
    L_0x0072:
        r0 = r1.getLayoutParams();
        r11 = r0;
        r11 = (android.support.design.widget.CoordinatorLayout.e) r11;
        r0 = r11.e;
        if (r0 < 0) goto L_0x00bd;
    L_0x007d:
        if (r13 == 0) goto L_0x00bd;
    L_0x007f:
        r0 = r11.e;
        r0 = r7.b(r0);
        r21 = r2;
        r2 = r11.c;
        r2 = d(r2);
        r2 = android.support.v4.h.d.a(r2, r10);
        r2 = r2 & 7;
        r22 = r3;
        r3 = 3;
        if (r2 != r3) goto L_0x009a;
    L_0x0098:
        if (r12 == 0) goto L_0x009f;
    L_0x009a:
        r3 = 5;
        if (r2 != r3) goto L_0x00ab;
    L_0x009d:
        if (r12 == 0) goto L_0x00ab;
    L_0x009f:
        r2 = r14 - r9;
        r2 = r2 - r0;
        r0 = 0;
        r2 = java.lang.Math.max(r0, r2);
        r3 = r0;
        r20 = r2;
        goto L_0x00c4;
    L_0x00ab:
        if (r2 != r3) goto L_0x00af;
    L_0x00ad:
        if (r12 == 0) goto L_0x00b4;
    L_0x00af:
        r3 = 3;
        if (r2 != r3) goto L_0x00c1;
    L_0x00b2:
        if (r12 == 0) goto L_0x00c1;
    L_0x00b4:
        r0 = r0 - r8;
        r3 = 0;
        r0 = java.lang.Math.max(r3, r0);
        r20 = r0;
        goto L_0x00c4;
    L_0x00bd:
        r21 = r2;
        r22 = r3;
    L_0x00c1:
        r3 = 0;
        r20 = r3;
    L_0x00c4:
        if (r19 == 0) goto L_0x00f7;
    L_0x00c6:
        r0 = android.support.v4.h.r.n(r1);
        if (r0 != 0) goto L_0x00f7;
    L_0x00cc:
        r0 = r7.t;
        r0 = r0.a();
        r2 = r7.t;
        r2 = r2.c();
        r0 = r0 + r2;
        r2 = r7.t;
        r2 = r2.b();
        r3 = r7.t;
        r3 = r3.d();
        r2 = r2 + r3;
        r0 = r14 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13);
        r2 = r16 - r2;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15);
        r23 = r0;
        r25 = r2;
        goto L_0x00fb;
    L_0x00f7:
        r23 = r32;
        r25 = r33;
    L_0x00fb:
        r0 = r11.b();
        if (r0 == 0) goto L_0x0126;
    L_0x0101:
        r26 = 0;
        r3 = r1;
        r1 = r7;
        r27 = r21;
        r2 = r3;
        r28 = r3;
        r29 = r22;
        r21 = 0;
        r3 = r23;
        r30 = r4;
        r4 = r20;
        r22 = r5;
        r5 = r25;
        r24 = r6;
        r6 = r26;
        r0 = r0.a(r1, r2, r3, r4, r5, r6);
        if (r0 != 0) goto L_0x0123;
    L_0x0122:
        goto L_0x0134;
    L_0x0123:
        r0 = r28;
        goto L_0x0142;
    L_0x0126:
        r28 = r1;
        r30 = r4;
        r24 = r6;
        r27 = r21;
        r29 = r22;
        r21 = 0;
        r22 = r5;
    L_0x0134:
        r5 = 0;
        r0 = r7;
        r1 = r28;
        r2 = r23;
        r3 = r20;
        r4 = r25;
        r0.a(r1, r2, r3, r4, r5);
        goto L_0x0123;
    L_0x0142:
        r1 = r0.getMeasuredWidth();
        r1 = r17 + r1;
        r2 = r11.leftMargin;
        r1 = r1 + r2;
        r2 = r11.rightMargin;
        r1 = r1 + r2;
        r2 = r30;
        r1 = java.lang.Math.max(r2, r1);
        r2 = r0.getMeasuredHeight();
        r2 = r18 + r2;
        r3 = r11.topMargin;
        r2 = r2 + r3;
        r3 = r11.bottomMargin;
        r2 = r2 + r3;
        r3 = r27;
        r2 = java.lang.Math.max(r3, r2);
        r0 = r0.getMeasuredState();
        r11 = r29;
        r0 = android.view.View.combineMeasuredStates(r11, r0);
        r3 = r0;
        r4 = r1;
    L_0x0172:
        r5 = r22 + 1;
        r6 = r24;
        goto L_0x0057;
    L_0x0178:
        r11 = r3;
        r3 = r2;
        r2 = r4;
        r0 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r0 = r0 & r11;
        r1 = r32;
        r0 = android.view.View.resolveSizeAndState(r2, r1, r0);
        r1 = r11 << 16;
        r2 = r33;
        r1 = android.view.View.resolveSizeAndState(r3, r2, r1);
        r7.setMeasuredDimension(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(0)) {
                    b b = eVar.b();
                    if (b != null) {
                        z2 |= b.a(this, childAt, view, f, f2, z);
                    }
                }
            }
            i++;
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(0)) {
                    b b = eVar.b();
                    if (b != null) {
                        z |= b.a(this, childAt, view, f, f2);
                    }
                }
            }
            i++;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        b(view, view2, i, 0);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof g) {
            g gVar = (g) parcelable;
            super.onRestoreInstanceState(gVar.a());
            SparseArray sparseArray = gVar.a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                b b = a(childAt).b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable gVar = new g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b b = ((e) childAt.getLayoutParams()).b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        gVar.a = sparseArray;
        return gVar;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return a(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        c(view, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Missing block: B:3:0x0012, code:
            if (r3 != false) goto L_0x0018;
     */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r18.getActionMasked();
        r3 = r0.p;
        r4 = 1;
        r5 = 0;
        if (r3 != 0) goto L_0x0017;
    L_0x000e:
        r3 = r0.a(r1, r4);
        if (r3 == 0) goto L_0x0015;
    L_0x0014:
        goto L_0x0018;
    L_0x0015:
        r6 = r5;
        goto L_0x002c;
    L_0x0017:
        r3 = r5;
    L_0x0018:
        r6 = r0.p;
        r6 = r6.getLayoutParams();
        r6 = (android.support.design.widget.CoordinatorLayout.e) r6;
        r6 = r6.b();
        if (r6 == 0) goto L_0x0015;
    L_0x0026:
        r7 = r0.p;
        r6 = r6.b(r0, r7, r1);
    L_0x002c:
        r7 = r0.p;
        r8 = 0;
        if (r7 != 0) goto L_0x0037;
    L_0x0031:
        r1 = super.onTouchEvent(r18);
        r6 = r6 | r1;
        goto L_0x004a;
    L_0x0037:
        if (r3 == 0) goto L_0x004a;
    L_0x0039:
        r11 = android.os.SystemClock.uptimeMillis();
        r13 = 3;
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r9 = r11;
        r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16);
        super.onTouchEvent(r8);
    L_0x004a:
        if (r8 == 0) goto L_0x004f;
    L_0x004c:
        r8.recycle();
    L_0x004f:
        if (r2 == r4) goto L_0x0054;
    L_0x0051:
        r1 = 3;
        if (r2 != r1) goto L_0x0057;
    L_0x0054:
        r0.a(r5);
    L_0x0057:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        b b = ((e) view.getLayoutParams()).b();
        return (b == null || !b.a(this, view, rect, z)) ? super.requestChildRectangleOnScreen(view, rect, z) : true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.m) {
            a(false);
            this.m = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        g();
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.e = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.v != drawable) {
            Drawable drawable2 = null;
            if (this.v != null) {
                this.v.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.v = drawable2;
            if (this.v != null) {
                if (this.v.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                android.support.v4.graphics.drawable.a.b(this.v, r.e(this));
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            r.c(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? android.support.v4.a.a.a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.v != null && this.v.isVisible() != z) {
            this.v.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }
}
