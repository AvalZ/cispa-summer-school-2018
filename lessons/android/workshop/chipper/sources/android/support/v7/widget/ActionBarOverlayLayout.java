package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.h.m;
import android.support.v4.h.o;
import android.support.v4.h.r;
import android.support.v7.a.a.f;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout extends ViewGroup implements m, ad {
    static final int[] e = new int[]{android.support.v7.a.a.a.actionBarSize, 16842841};
    private final Runnable A;
    private final o B;
    ActionBarContainer a;
    boolean b;
    ViewPropertyAnimator c;
    final AnimatorListenerAdapter d;
    private int f;
    private int g;
    private ContentFrameLayout h;
    private ae i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private a x;
    private OverScroller y;
    private final Runnable z;

    public interface a {
        void a(int i);

        void g(boolean z);

        void j();

        void k();

        void l();

        void m();
    }

    public static class b extends MarginLayoutParams {
        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.d = new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.c = null;
                ActionBarOverlayLayout.this.b = false;
            }

            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.c = null;
                ActionBarOverlayLayout.this.b = false;
            }
        };
        this.z = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.d);
            }
        };
        this.A = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY((float) (-ActionBarOverlayLayout.this.a.getHeight())).setListener(ActionBarOverlayLayout.this.d);
            }
        };
        a(context);
        this.B = new o(this);
    }

    private ae a(View view) {
        if (view instanceof ae) {
            return (ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        stringBuilder.append(view.getClass().getSimpleName());
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(e);
        boolean z = false;
        this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.k = z;
        this.y = new OverScroller(context);
    }

    private boolean a(float f, float f2) {
        this.y.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.y.getFinalY() > this.a.getHeight();
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        b bVar = (b) view.getLayoutParams();
        if (!z || bVar.leftMargin == rect.left) {
            z = false;
        } else {
            bVar.leftMargin = rect.left;
            z = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    private void l() {
        d();
        postDelayed(this.z, 600);
    }

    private void m() {
        d();
        postDelayed(this.A, 600);
    }

    private void n() {
        d();
        this.z.run();
    }

    private void o() {
        d();
        this.A.run();
    }

    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public void a(int i) {
        c();
        if (i == 2) {
            this.i.f();
        } else if (i == 5) {
            this.i.g();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public void a(Menu menu, android.support.v7.view.menu.o.a aVar) {
        c();
        this.i.a(menu, aVar);
    }

    public boolean a() {
        return this.l;
    }

    /* renamed from: b */
    protected b generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    void c() {
        if (this.h == null) {
            this.h = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.a = (ActionBarContainer) findViewById(f.action_bar_container);
            this.i = a(findViewById(f.action_bar));
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    void d() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        if (this.c != null) {
            this.c.cancel();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j != null && !this.k) {
            int bottom = this.a.getVisibility() == 0 ? (int) ((((float) this.a.getBottom()) + this.a.getTranslationY()) + 0.5f) : 0;
            this.j.setBounds(0, bottom, getWidth(), this.j.getIntrinsicHeight() + bottom);
            this.j.draw(canvas);
        }
    }

    public boolean e() {
        c();
        return this.i.h();
    }

    public boolean f() {
        c();
        return this.i.i();
    }

    protected boolean fitSystemWindows(Rect rect) {
        c();
        int l = r.l(this) & 256;
        boolean a = a(this.a, rect, true, true, false, true);
        this.t.set(rect);
        bo.a(this, this.t, this.q);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            a = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        c();
        return this.i.j();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.a != null ? -((int) this.a.getTranslationY()) : 0;
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        c();
        return this.i.e();
    }

    public boolean h() {
        c();
        return this.i.k();
    }

    public boolean i() {
        c();
        return this.i.l();
    }

    public void j() {
        c();
        this.i.m();
    }

    public void k() {
        c();
        this.i.n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        r.m(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        i = getPaddingLeft();
        getPaddingRight();
        i2 = getPaddingTop();
        getPaddingBottom();
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int i5 = bVar.leftMargin + i;
                int i6 = bVar.topMargin + i2;
                childAt.layout(i5, i6, childAt.getMeasuredWidth() + i5, childAt.getMeasuredHeight() + i6);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        c();
        measureChildWithMargins(this.a, i, 0, i2, 0);
        b bVar = (b) this.a.getLayoutParams();
        int max = Math.max(0, (this.a.getMeasuredWidth() + bVar.leftMargin) + bVar.rightMargin);
        int max2 = Math.max(0, (this.a.getMeasuredHeight() + bVar.topMargin) + bVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.a.getMeasuredState());
        int i4 = (r.l(this) & 256) != 0 ? 1 : 0;
        if (i4 != 0) {
            i3 = this.f;
            if (this.m && this.a.getTabContainer() != null) {
                i3 += this.f;
            }
        } else {
            i3 = this.a.getVisibility() != 8 ? this.a.getMeasuredHeight() : 0;
        }
        this.s.set(this.q);
        this.v.set(this.t);
        Rect rect;
        if (this.l || i4 != 0) {
            rect = this.v;
            rect.top += i3;
            rect = this.v;
        } else {
            rect = this.s;
            rect.top += i3;
            rect = this.s;
        }
        r4.bottom += 0;
        a(this.h, this.s, true, true, true, true);
        if (!this.w.equals(this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }
        measureChildWithMargins(this.h, i, 0, i2, 0);
        b bVar2 = (b) this.h.getLayoutParams();
        max = Math.max(max, (this.h.getMeasuredWidth() + bVar2.leftMargin) + bVar2.rightMargin);
        max2 = Math.max(max2, (this.h.getMeasuredHeight() + bVar2.topMargin) + bVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.n || !z) {
            return false;
        }
        if (a(f, f2)) {
            o();
        } else {
            n();
        }
        this.b = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.o += i2;
        setActionBarHideOffset(this.o);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.B.a(view, view2, i);
        this.o = getActionBarHideOffset();
        d();
        if (this.x != null) {
            this.x.l();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.a.getVisibility() != 0) ? false : this.n;
    }

    public void onStopNestedScroll(View view) {
        if (this.n && !this.b) {
            if (this.o <= this.a.getHeight()) {
                l();
            } else {
                m();
            }
        }
        if (this.x != null) {
            this.x.m();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.p ^ i;
        this.p = i;
        int i3 = 0;
        int i4 = (i & 4) == 0 ? 1 : 0;
        if ((i & 256) != 0) {
            i3 = 1;
        }
        if (this.x != null) {
            this.x.g(i3 ^ 1);
            if (i4 != 0 || i3 == 0) {
                this.x.j();
            } else {
                this.x.k();
            }
        }
        if ((i2 & 256) != 0 && this.x != null) {
            r.m(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.g = i;
        if (this.x != null) {
            this.x.a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        d();
        this.a.setTranslationY((float) (-Math.max(0, Math.min(i, this.a.getHeight()))));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.x = aVar;
        if (getWindowToken() != null) {
            this.x.a(this.g);
            if (this.p != 0) {
                onWindowSystemUiVisibilityChanged(this.p);
                r.m(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.m = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.n) {
            this.n = z;
            if (!z) {
                d();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        c();
        this.i.a(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.i.a(drawable);
    }

    public void setLogo(int i) {
        c();
        this.i.b(i);
    }

    public void setOverlayMode(boolean z) {
        this.l = z;
        z = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.k = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        c();
        this.i.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.i.a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
