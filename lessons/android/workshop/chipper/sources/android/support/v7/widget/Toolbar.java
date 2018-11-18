package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.h.g;
import android.support.v4.h.r;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.support.v7.widget.ActionMenuView.e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    private final e H;
    private bh I;
    private c J;
    private a K;
    private android.support.v7.view.menu.o.a L;
    private android.support.v7.view.menu.h.a M;
    private boolean N;
    private final Runnable O;
    ImageButton a;
    View b;
    int c;
    c d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private aw u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    public interface c {
        boolean a(MenuItem menuItem);
    }

    private class a implements o {
        h a;
        j b;

        a() {
        }

        public void a(Context context, h hVar) {
            if (!(this.a == null || this.b == null)) {
                this.a.d(this.b);
            }
            this.a = hVar;
        }

        public void a(h hVar, boolean z) {
        }

        public void a(android.support.v7.view.menu.o.a aVar) {
        }

        public boolean a(h hVar, j jVar) {
            Toolbar.this.i();
            ViewParent parent = Toolbar.this.a.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.a);
                }
                Toolbar.this.addView(Toolbar.this.a);
            }
            Toolbar.this.b = jVar.getActionView();
            this.b = jVar;
            parent = Toolbar.this.b.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.b);
                }
                LayoutParams j = Toolbar.this.generateDefaultLayoutParams();
                j.a = 8388611 | (Toolbar.this.c & 112);
                j.b = 2;
                Toolbar.this.b.setLayoutParams(j);
                Toolbar.this.addView(Toolbar.this.b);
            }
            Toolbar.this.k();
            Toolbar.this.requestLayout();
            jVar.e(true);
            if (Toolbar.this.b instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) Toolbar.this.b).a();
            }
            return true;
        }

        public boolean a(u uVar) {
            return false;
        }

        public void b(boolean z) {
            if (this.b != null) {
                Object obj = null;
                if (this.a != null) {
                    int size = this.a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.a.getItem(i) == this.b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    b(this.a, this.b);
                }
            }
        }

        public boolean b() {
            return false;
        }

        public boolean b(h hVar, j jVar) {
            if (Toolbar.this.b instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) Toolbar.this.b).b();
            }
            Toolbar.this.removeView(Toolbar.this.b);
            Toolbar.this.removeView(Toolbar.this.a);
            Toolbar.this.b = null;
            Toolbar.this.l();
            this.b = null;
            Toolbar.this.requestLayout();
            jVar.e(false);
            return true;
        }
    }

    public static class b extends android.support.v7.app.a.a {
        int b;

        public b(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public b(android.support.v7.app.a.a aVar) {
            super(aVar);
            this.b = 0;
        }

        public b(b bVar) {
            super((android.support.v7.app.a.a) bVar);
            this.b = 0;
            this.b = bVar.b;
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        void a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class d extends android.support.v4.h.a {
        public static final Creator<d> CREATOR = new ClassLoaderCreator<d>() {
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            /* renamed from: a */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };
        int a;
        boolean b;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 8388627;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        this.H = new e() {
            public boolean a(MenuItem menuItem) {
                return Toolbar.this.d != null ? Toolbar.this.d.a(menuItem) : false;
            }
        };
        this.O = new Runnable() {
            public void run() {
                Toolbar.this.d();
            }
        };
        bg a = bg.a(getContext(), attributeSet, android.support.v7.a.a.j.Toolbar, i, 0);
        this.n = a.g(android.support.v7.a.a.j.Toolbar_titleTextAppearance, 0);
        this.o = a.g(android.support.v7.a.a.j.Toolbar_subtitleTextAppearance, 0);
        this.x = a.c(android.support.v7.a.a.j.Toolbar_android_gravity, this.x);
        this.c = a.c(android.support.v7.a.a.j.Toolbar_buttonGravity, 48);
        int d = a.d(android.support.v7.a.a.j.Toolbar_titleMargin, 0);
        if (a.g(android.support.v7.a.a.j.Toolbar_titleMargins)) {
            d = a.d(android.support.v7.a.a.j.Toolbar_titleMargins, d);
        }
        this.t = d;
        this.s = d;
        this.r = d;
        this.q = d;
        d = a.d(android.support.v7.a.a.j.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.q = d;
        }
        d = a.d(android.support.v7.a.a.j.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.r = d;
        }
        d = a.d(android.support.v7.a.a.j.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.s = d;
        }
        d = a.d(android.support.v7.a.a.j.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.t = d;
        }
        this.p = a.e(android.support.v7.a.a.j.Toolbar_maxButtonHeight, -1);
        d = a.d(android.support.v7.a.a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.d(android.support.v7.a.a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e = a.e(android.support.v7.a.a.j.Toolbar_contentInsetLeft, 0);
        int e2 = a.e(android.support.v7.a.a.j.Toolbar_contentInsetRight, 0);
        s();
        this.u.b(e, e2);
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.u.a(d, d2);
        }
        this.v = a.d(android.support.v7.a.a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = a.d(android.support.v7.a.a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.j = a.a(android.support.v7.a.a.j.Toolbar_collapseIcon);
        this.k = a.c(android.support.v7.a.a.j.Toolbar_collapseContentDescription);
        CharSequence c = a.c(android.support.v7.a.a.j.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.c(android.support.v7.a.a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.l = getContext();
        setPopupTheme(a.g(android.support.v7.a.a.j.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(android.support.v7.a.a.j.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.c(android.support.v7.a.a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.a(android.support.v7.a.a.j.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.c(android.support.v7.a.a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.g(android.support.v7.a.a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(a.b(android.support.v7.a.a.j.Toolbar_titleTextColor, -1));
        }
        if (a.g(android.support.v7.a.a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.b(android.support.v7.a.a.j.Toolbar_subtitleTextColor, -1));
        }
        a.a();
    }

    private int a(int i) {
        i &= 112;
        return (i == 16 || i == 48 || i == 80) ? i : this.x & 112;
    }

    private int a(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        i = i > 0 ? (measuredHeight - i) / 2 : 0;
        int a = a(bVar.a);
        if (a == 48) {
            return getPaddingTop() - i;
        }
        if (a == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i;
        }
        i = getPaddingTop();
        a = getPaddingBottom();
        int height = getHeight();
        int i2 = (((height - i) - a) - measuredHeight) / 2;
        if (i2 < bVar.topMargin) {
            i2 = bVar.topMargin;
        } else {
            height = (((height - a) - measuredHeight) - i2) - i;
            if (height < bVar.bottomMargin) {
                i2 = Math.max(0, i2 - (bVar.bottomMargin - height));
            }
        }
        return i + i2;
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        i += Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int a = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(i, a, i + measuredWidth, view.getMeasuredHeight() + a);
        return i + (measuredWidth + bVar.rightMargin);
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = i2;
        i2 = i3;
        while (i2 < size) {
            View view = (View) list.get(i2);
            b bVar = (b) view.getLayoutParams();
            int i5 = bVar.leftMargin - i;
            i = bVar.rightMargin - i4;
            i4 = Math.max(0, i5);
            int max = Math.max(0, i);
            i5 = Math.max(0, -i5);
            i3 += (i4 + view.getMeasuredWidth()) + max;
            i2++;
            i4 = Math.max(0, -i);
            i = i5;
        }
        return i3;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        i = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        i2 = MeasureSpec.getMode(childMeasureSpec);
        if (i2 != 1073741824 && i5 >= 0) {
            if (i2 != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec), i5);
            }
            childMeasureSpec = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(i, childMeasureSpec);
    }

    private void a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (b) layoutParams;
        layoutParams.b = 1;
        if (!z || this.b == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.F.add(view);
    }

    private void a(List<View> list, int i) {
        int i2 = 0;
        int i3 = r.e(this) == 1 ? 1 : 0;
        int childCount = getChildCount();
        i = android.support.v4.h.d.a(i, r.e(this));
        list.clear();
        View childAt;
        if (i3 != 0) {
            for (childCount--; childCount >= 0; childCount--) {
                childAt = getChildAt(childCount);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && a(childAt) && b(bVar.a) == i) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i2 < childCount) {
            childAt = getChildAt(i2);
            b bVar2 = (b) childAt.getLayoutParams();
            if (bVar2.b == 0 && a(childAt) && b(bVar2.a) == i) {
                list.add(childAt);
            }
            i2++;
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i) {
        int e = r.e(this);
        i = android.support.v4.h.d.a(i, e) & 7;
        if (i != 1) {
            int i2 = 3;
            if (!(i == 3 || i == 5)) {
                if (e == 1) {
                    i2 = 5;
                }
                return i2;
            }
        }
        return i;
    }

    private int b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return g.a(marginLayoutParams) + g.b(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        i -= Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(i - measuredWidth, a, i, view.getMeasuredHeight() + a);
        return i - (measuredWidth + bVar.leftMargin);
    }

    private int c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new android.support.v7.view.g(getContext());
    }

    private void m() {
        if (this.i == null) {
            this.i = new q(getContext());
        }
    }

    private void n() {
        o();
        if (this.e.d() == null) {
            h hVar = (h) this.e.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.e.setExpandedActionViewsExclusive(true);
            hVar.a(this.K, this.l);
        }
    }

    private void o() {
        if (this.e == null) {
            this.e = new ActionMenuView(getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            LayoutParams j = generateDefaultLayoutParams();
            j.a = 8388613 | (this.c & 112);
            this.e.setLayoutParams(j);
            a(this.e, false);
        }
    }

    private void p() {
        if (this.h == null) {
            this.h = new o(getContext(), null, android.support.v7.a.a.a.toolbarNavigationButtonStyle);
            LayoutParams j = generateDefaultLayoutParams();
            j.a = 8388611 | (this.c & 112);
            this.h.setLayoutParams(j);
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean r() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.u == null) {
            this.u = new aw();
        }
    }

    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected b generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof b ? new b((b) layoutParams) : layoutParams instanceof android.support.v7.app.a.a ? new b((android.support.v7.app.a.a) layoutParams) : layoutParams instanceof MarginLayoutParams ? new b((MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(int i, int i2) {
        s();
        this.u.a(i, i2);
    }

    public void a(Context context, int i) {
        this.n = i;
        if (this.f != null) {
            this.f.setTextAppearance(context, i);
        }
    }

    public void a(h hVar, c cVar) {
        if (hVar != null || this.e != null) {
            o();
            h d = this.e.d();
            if (d != hVar) {
                if (d != null) {
                    d.b(this.J);
                    d.b(this.K);
                }
                if (this.K == null) {
                    this.K = new a();
                }
                cVar.d(true);
                if (hVar != null) {
                    hVar.a((o) cVar, this.l);
                    hVar.a(this.K, this.l);
                } else {
                    cVar.a(this.l, null);
                    this.K.a(this.l, null);
                    cVar.b(true);
                    this.K.b(true);
                }
                this.e.setPopupTheme(this.m);
                this.e.setPresenter(cVar);
                this.J = cVar;
            }
        }
    }

    public void a(android.support.v7.view.menu.o.a aVar, android.support.v7.view.menu.h.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        if (this.e != null) {
            this.e.a(aVar, aVar2);
        }
    }

    public boolean a() {
        return getVisibility() == 0 && this.e != null && this.e.a();
    }

    public void b(Context context, int i) {
        this.o = i;
        if (this.g != null) {
            this.g.setTextAppearance(context, i);
        }
    }

    public boolean b() {
        return this.e != null && this.e.g();
    }

    public boolean c() {
        return this.e != null && this.e.h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public boolean d() {
        return this.e != null && this.e.e();
    }

    public boolean e() {
        return this.e != null && this.e.f();
    }

    public void f() {
        if (this.e != null) {
            this.e.i();
        }
    }

    public boolean g() {
        return (this.K == null || this.K.b == null) ? false : true;
    }

    public int getContentInsetEnd() {
        return this.u != null ? this.u.d() : 0;
    }

    public int getContentInsetEndWithActions() {
        return this.w != Integer.MIN_VALUE ? this.w : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        return this.u != null ? this.u.a() : 0;
    }

    public int getContentInsetRight() {
        return this.u != null ? this.u.b() : 0;
    }

    public int getContentInsetStart() {
        return this.u != null ? this.u.c() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.v != Integer.MIN_VALUE ? this.v : getContentInsetStart();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    public int getCurrentContentInsetEnd() {
        /*
        r2 = this;
        r0 = r2.e;
        r1 = 0;
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r0 = r2.e;
        r0 = r0.d();
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r0.hasVisibleItems();
        if (r0 == 0) goto L_0x0015;
    L_0x0013:
        r0 = 1;
        goto L_0x0016;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        if (r0 == 0) goto L_0x0027;
    L_0x0018:
        r0 = r2.getContentInsetEnd();
        r2 = r2.w;
        r2 = java.lang.Math.max(r2, r1);
        r2 = java.lang.Math.max(r0, r2);
        return r2;
    L_0x0027:
        r2 = r2.getContentInsetEnd();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        return r.e(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return r.e(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        return this.i != null ? this.i.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.i != null ? this.i.getContentDescription() : null;
    }

    public Menu getMenu() {
        n();
        return this.e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.h != null ? this.h.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.h != null ? this.h.getDrawable() : null;
    }

    c getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        n();
        return this.e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.l;
    }

    public int getPopupTheme() {
        return this.m;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public ae getWrapper() {
        if (this.I == null) {
            this.I = new bh(this, true);
        }
        return this.I;
    }

    public void h() {
        j jVar = this.K == null ? null : this.K.b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    void i() {
        if (this.a == null) {
            this.a = new o(getContext(), null, android.support.v7.a.a.a.toolbarNavigationButtonStyle);
            this.a.setImageDrawable(this.j);
            this.a.setContentDescription(this.k);
            LayoutParams j = generateDefaultLayoutParams();
            j.a = 8388611 | (this.c & 112);
            j.b = 2;
            this.a.setLayoutParams(j);
            this.a.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.h();
                }
            });
        }
    }

    /* renamed from: j */
    protected b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    void k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((b) childAt.getLayoutParams()).b == 2 || childAt == this.e)) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    void l() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView((View) this.F.get(size));
        }
        this.F.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02aa A:{LOOP_END, LOOP:0: B:101:0x02a8->B:102:0x02aa} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02cc A:{LOOP_END, LOOP:1: B:104:0x02ca->B:105:0x02cc} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0306 A:{LOOP_END, LOOP:2: B:112:0x0304->B:113:0x0306} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b8  */
    protected void onLayout(boolean r25, int r26, int r27, int r28, int r29) {
        /*
        r24 = this;
        r0 = r24;
        r1 = android.support.v4.h.r.e(r24);
        r2 = 1;
        r3 = 0;
        if (r1 != r2) goto L_0x000c;
    L_0x000a:
        r1 = r2;
        goto L_0x000d;
    L_0x000c:
        r1 = r3;
    L_0x000d:
        r4 = r24.getWidth();
        r5 = r24.getHeight();
        r6 = r24.getPaddingLeft();
        r7 = r24.getPaddingRight();
        r8 = r24.getPaddingTop();
        r9 = r24.getPaddingBottom();
        r10 = r4 - r7;
        r11 = r0.G;
        r11[r2] = r3;
        r11[r3] = r3;
        r12 = android.support.v4.h.r.i(r24);
        if (r12 < 0) goto L_0x003a;
    L_0x0033:
        r13 = r29 - r27;
        r12 = java.lang.Math.min(r12, r13);
        goto L_0x003b;
    L_0x003a:
        r12 = r3;
    L_0x003b:
        r13 = r0.h;
        r13 = r0.a(r13);
        if (r13 == 0) goto L_0x0055;
    L_0x0043:
        if (r1 == 0) goto L_0x004d;
    L_0x0045:
        r13 = r0.h;
        r13 = r0.b(r13, r10, r11, r12);
        r14 = r6;
        goto L_0x0057;
    L_0x004d:
        r13 = r0.h;
        r13 = r0.a(r13, r6, r11, r12);
        r14 = r13;
        goto L_0x0056;
    L_0x0055:
        r14 = r6;
    L_0x0056:
        r13 = r10;
    L_0x0057:
        r15 = r0.a;
        r15 = r0.a(r15);
        if (r15 == 0) goto L_0x006e;
    L_0x005f:
        if (r1 == 0) goto L_0x0068;
    L_0x0061:
        r15 = r0.a;
        r13 = r0.b(r15, r13, r11, r12);
        goto L_0x006e;
    L_0x0068:
        r15 = r0.a;
        r14 = r0.a(r15, r14, r11, r12);
    L_0x006e:
        r15 = r0.e;
        r15 = r0.a(r15);
        if (r15 == 0) goto L_0x0085;
    L_0x0076:
        if (r1 == 0) goto L_0x007f;
    L_0x0078:
        r15 = r0.e;
        r14 = r0.a(r15, r14, r11, r12);
        goto L_0x0085;
    L_0x007f:
        r15 = r0.e;
        r13 = r0.b(r15, r13, r11, r12);
    L_0x0085:
        r15 = r24.getCurrentContentInsetLeft();
        r16 = r24.getCurrentContentInsetRight();
        r2 = r15 - r14;
        r2 = java.lang.Math.max(r3, r2);
        r11[r3] = r2;
        r2 = r10 - r13;
        r2 = r16 - r2;
        r2 = java.lang.Math.max(r3, r2);
        r17 = 1;
        r11[r17] = r2;
        r2 = java.lang.Math.max(r14, r15);
        r10 = r10 - r16;
        r10 = java.lang.Math.min(r13, r10);
        r13 = r0.b;
        r13 = r0.a(r13);
        if (r13 == 0) goto L_0x00c2;
    L_0x00b3:
        if (r1 == 0) goto L_0x00bc;
    L_0x00b5:
        r13 = r0.b;
        r10 = r0.b(r13, r10, r11, r12);
        goto L_0x00c2;
    L_0x00bc:
        r13 = r0.b;
        r2 = r0.a(r13, r2, r11, r12);
    L_0x00c2:
        r13 = r0.i;
        r13 = r0.a(r13);
        if (r13 == 0) goto L_0x00d9;
    L_0x00ca:
        if (r1 == 0) goto L_0x00d3;
    L_0x00cc:
        r13 = r0.i;
        r10 = r0.b(r13, r10, r11, r12);
        goto L_0x00d9;
    L_0x00d3:
        r13 = r0.i;
        r2 = r0.a(r13, r2, r11, r12);
    L_0x00d9:
        r13 = r0.f;
        r13 = r0.a(r13);
        r14 = r0.g;
        r14 = r0.a(r14);
        if (r13 == 0) goto L_0x0100;
    L_0x00e7:
        r15 = r0.f;
        r15 = r15.getLayoutParams();
        r15 = (android.support.v7.widget.Toolbar.b) r15;
        r3 = r15.topMargin;
        r19 = r7;
        r7 = r0.f;
        r7 = r7.getMeasuredHeight();
        r3 = r3 + r7;
        r7 = r15.bottomMargin;
        r3 = r3 + r7;
        r7 = 0;
        r3 = r3 + r7;
        goto L_0x0103;
    L_0x0100:
        r19 = r7;
        r3 = 0;
    L_0x0103:
        if (r14 == 0) goto L_0x011d;
    L_0x0105:
        r7 = r0.g;
        r7 = r7.getLayoutParams();
        r7 = (android.support.v7.widget.Toolbar.b) r7;
        r15 = r7.topMargin;
        r20 = r4;
        r4 = r0.g;
        r4 = r4.getMeasuredHeight();
        r15 = r15 + r4;
        r4 = r7.bottomMargin;
        r15 = r15 + r4;
        r3 = r3 + r15;
        goto L_0x011f;
    L_0x011d:
        r20 = r4;
    L_0x011f:
        if (r13 != 0) goto L_0x012b;
    L_0x0121:
        if (r14 == 0) goto L_0x0124;
    L_0x0123:
        goto L_0x012b;
    L_0x0124:
        r21 = r6;
        r22 = r12;
    L_0x0128:
        r7 = 0;
        goto L_0x029a;
    L_0x012b:
        if (r13 == 0) goto L_0x0130;
    L_0x012d:
        r4 = r0.f;
        goto L_0x0132;
    L_0x0130:
        r4 = r0.g;
    L_0x0132:
        if (r14 == 0) goto L_0x0137;
    L_0x0134:
        r7 = r0.g;
        goto L_0x0139;
    L_0x0137:
        r7 = r0.f;
    L_0x0139:
        r4 = r4.getLayoutParams();
        r4 = (android.support.v7.widget.Toolbar.b) r4;
        r7 = r7.getLayoutParams();
        r7 = (android.support.v7.widget.Toolbar.b) r7;
        if (r13 == 0) goto L_0x014f;
    L_0x0147:
        r15 = r0.f;
        r15 = r15.getMeasuredWidth();
        if (r15 > 0) goto L_0x0159;
    L_0x014f:
        if (r14 == 0) goto L_0x015d;
    L_0x0151:
        r15 = r0.g;
        r15 = r15.getMeasuredWidth();
        if (r15 <= 0) goto L_0x015d;
    L_0x0159:
        r21 = r6;
        r15 = 1;
        goto L_0x0160;
    L_0x015d:
        r21 = r6;
        r15 = 0;
    L_0x0160:
        r6 = r0.x;
        r6 = r6 & 112;
        r22 = r12;
        r12 = 48;
        if (r6 == r12) goto L_0x01a9;
    L_0x016a:
        r12 = 80;
        if (r6 == r12) goto L_0x019d;
    L_0x016e:
        r6 = r5 - r8;
        r6 = r6 - r9;
        r6 = r6 - r3;
        r6 = r6 / 2;
        r12 = r4.topMargin;
        r23 = r2;
        r2 = r0.s;
        r12 = r12 + r2;
        if (r6 >= r12) goto L_0x0184;
    L_0x017d:
        r2 = r4.topMargin;
        r3 = r0.s;
        r6 = r2 + r3;
        goto L_0x019b;
    L_0x0184:
        r5 = r5 - r9;
        r5 = r5 - r3;
        r5 = r5 - r6;
        r5 = r5 - r8;
        r2 = r4.bottomMargin;
        r3 = r0.t;
        r2 = r2 + r3;
        if (r5 >= r2) goto L_0x019b;
    L_0x018f:
        r2 = r7.bottomMargin;
        r3 = r0.t;
        r2 = r2 + r3;
        r2 = r2 - r5;
        r6 = r6 - r2;
        r2 = 0;
        r6 = java.lang.Math.max(r2, r6);
    L_0x019b:
        r8 = r8 + r6;
        goto L_0x01b6;
    L_0x019d:
        r23 = r2;
        r5 = r5 - r9;
        r2 = r7.bottomMargin;
        r5 = r5 - r2;
        r2 = r0.t;
        r5 = r5 - r2;
        r8 = r5 - r3;
        goto L_0x01b6;
    L_0x01a9:
        r23 = r2;
        r2 = r24.getPaddingTop();
        r3 = r4.topMargin;
        r2 = r2 + r3;
        r3 = r0.s;
        r8 = r2 + r3;
    L_0x01b6:
        if (r1 == 0) goto L_0x022b;
    L_0x01b8:
        if (r15 == 0) goto L_0x01be;
    L_0x01ba:
        r3 = r0.q;
        r1 = 1;
        goto L_0x01c0;
    L_0x01be:
        r1 = 1;
        r3 = 0;
    L_0x01c0:
        r2 = r11[r1];
        r3 = r3 - r2;
        r2 = 0;
        r4 = java.lang.Math.max(r2, r3);
        r10 = r10 - r4;
        r3 = -r3;
        r3 = java.lang.Math.max(r2, r3);
        r11[r1] = r3;
        if (r13 == 0) goto L_0x01f6;
    L_0x01d2:
        r1 = r0.f;
        r1 = r1.getLayoutParams();
        r1 = (android.support.v7.widget.Toolbar.b) r1;
        r2 = r0.f;
        r2 = r2.getMeasuredWidth();
        r2 = r10 - r2;
        r3 = r0.f;
        r3 = r3.getMeasuredHeight();
        r3 = r3 + r8;
        r4 = r0.f;
        r4.layout(r2, r8, r10, r3);
        r4 = r0.r;
        r2 = r2 - r4;
        r1 = r1.bottomMargin;
        r8 = r3 + r1;
        goto L_0x01f7;
    L_0x01f6:
        r2 = r10;
    L_0x01f7:
        if (r14 == 0) goto L_0x021f;
    L_0x01f9:
        r1 = r0.g;
        r1 = r1.getLayoutParams();
        r1 = (android.support.v7.widget.Toolbar.b) r1;
        r3 = r1.topMargin;
        r8 = r8 + r3;
        r3 = r0.g;
        r3 = r3.getMeasuredWidth();
        r3 = r10 - r3;
        r4 = r0.g;
        r4 = r4.getMeasuredHeight();
        r4 = r4 + r8;
        r5 = r0.g;
        r5.layout(r3, r8, r10, r4);
        r3 = r0.r;
        r3 = r10 - r3;
        r1 = r1.bottomMargin;
        goto L_0x0220;
    L_0x021f:
        r3 = r10;
    L_0x0220:
        if (r15 == 0) goto L_0x0227;
    L_0x0222:
        r1 = java.lang.Math.min(r2, r3);
        r10 = r1;
    L_0x0227:
        r2 = r23;
        goto L_0x0128;
    L_0x022b:
        if (r15 == 0) goto L_0x0233;
    L_0x022d:
        r3 = r0.q;
        r18 = r3;
        r7 = 0;
        goto L_0x0236;
    L_0x0233:
        r7 = 0;
        r18 = 0;
    L_0x0236:
        r1 = r11[r7];
        r1 = r18 - r1;
        r2 = java.lang.Math.max(r7, r1);
        r2 = r23 + r2;
        r1 = -r1;
        r1 = java.lang.Math.max(r7, r1);
        r11[r7] = r1;
        if (r13 == 0) goto L_0x026c;
    L_0x0249:
        r1 = r0.f;
        r1 = r1.getLayoutParams();
        r1 = (android.support.v7.widget.Toolbar.b) r1;
        r3 = r0.f;
        r3 = r3.getMeasuredWidth();
        r3 = r3 + r2;
        r4 = r0.f;
        r4 = r4.getMeasuredHeight();
        r4 = r4 + r8;
        r5 = r0.f;
        r5.layout(r2, r8, r3, r4);
        r5 = r0.r;
        r3 = r3 + r5;
        r1 = r1.bottomMargin;
        r8 = r4 + r1;
        goto L_0x026d;
    L_0x026c:
        r3 = r2;
    L_0x026d:
        if (r14 == 0) goto L_0x0293;
    L_0x026f:
        r1 = r0.g;
        r1 = r1.getLayoutParams();
        r1 = (android.support.v7.widget.Toolbar.b) r1;
        r4 = r1.topMargin;
        r8 = r8 + r4;
        r4 = r0.g;
        r4 = r4.getMeasuredWidth();
        r4 = r4 + r2;
        r5 = r0.g;
        r5 = r5.getMeasuredHeight();
        r5 = r5 + r8;
        r6 = r0.g;
        r6.layout(r2, r8, r4, r5);
        r5 = r0.r;
        r4 = r4 + r5;
        r1 = r1.bottomMargin;
        goto L_0x0294;
    L_0x0293:
        r4 = r2;
    L_0x0294:
        if (r15 == 0) goto L_0x029a;
    L_0x0296:
        r2 = java.lang.Math.max(r3, r4);
    L_0x029a:
        r1 = r0.E;
        r3 = 3;
        r0.a(r1, r3);
        r1 = r0.E;
        r1 = r1.size();
        r3 = r2;
        r2 = r7;
    L_0x02a8:
        if (r2 >= r1) goto L_0x02bb;
    L_0x02aa:
        r4 = r0.E;
        r4 = r4.get(r2);
        r4 = (android.view.View) r4;
        r12 = r22;
        r3 = r0.a(r4, r3, r11, r12);
        r2 = r2 + 1;
        goto L_0x02a8;
    L_0x02bb:
        r12 = r22;
        r1 = r0.E;
        r2 = 5;
        r0.a(r1, r2);
        r1 = r0.E;
        r1 = r1.size();
        r2 = r7;
    L_0x02ca:
        if (r2 >= r1) goto L_0x02db;
    L_0x02cc:
        r4 = r0.E;
        r4 = r4.get(r2);
        r4 = (android.view.View) r4;
        r10 = r0.b(r4, r10, r11, r12);
        r2 = r2 + 1;
        goto L_0x02ca;
    L_0x02db:
        r1 = r0.E;
        r2 = 1;
        r0.a(r1, r2);
        r1 = r0.E;
        r1 = r0.a(r1, r11);
        r4 = r20 - r21;
        r4 = r4 - r19;
        r4 = r4 / 2;
        r6 = r21 + r4;
        r2 = r1 / 2;
        r2 = r6 - r2;
        r1 = r1 + r2;
        if (r2 >= r3) goto L_0x02f7;
    L_0x02f6:
        goto L_0x02fe;
    L_0x02f7:
        if (r1 <= r10) goto L_0x02fd;
    L_0x02f9:
        r1 = r1 - r10;
        r3 = r2 - r1;
        goto L_0x02fe;
    L_0x02fd:
        r3 = r2;
    L_0x02fe:
        r1 = r0.E;
        r1 = r1.size();
    L_0x0304:
        if (r7 >= r1) goto L_0x0315;
    L_0x0306:
        r2 = r0.E;
        r2 = r2.get(r7);
        r2 = (android.view.View) r2;
        r3 = r0.a(r2, r3, r11, r12);
        r7 = r7 + 1;
        goto L_0x0304;
    L_0x0315:
        r0 = r0.E;
        r0.clear();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int measuredWidth;
        int max;
        int combineMeasuredStates;
        int measuredHeight;
        int combineMeasuredStates2;
        int[] iArr = this.G;
        if (bo.a(this)) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = 1;
            i3 = 0;
        }
        if (a(this.h)) {
            a(this.h, i, 0, i2, 0, this.p);
            measuredWidth = this.h.getMeasuredWidth() + b(this.h);
            max = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
            combineMeasuredStates = View.combineMeasuredStates(0, this.h.getMeasuredState());
        } else {
            measuredWidth = 0;
            max = measuredWidth;
            combineMeasuredStates = max;
        }
        if (a(this.a)) {
            a(this.a, i, 0, i2, 0, this.p);
            measuredWidth = this.a.getMeasuredWidth() + b(this.a);
            max = Math.max(max, this.a.getMeasuredHeight() + c(this.a));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = Math.max(currentContentInsetStart, measuredWidth) + 0;
        iArr[i3] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (a(this.e)) {
            a(this.e, i, max2, i2, 0, this.p);
            measuredWidth = this.e.getMeasuredWidth() + b(this.e);
            max = Math.max(max, this.e.getMeasuredHeight() + c(this.e));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.e.getMeasuredState());
        } else {
            measuredWidth = 0;
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        i3 = max2 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[i4] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (a(this.b)) {
            i3 += a(this.b, i, i3, i2, 0, iArr);
            max = Math.max(max, this.b.getMeasuredHeight() + c(this.b));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.b.getMeasuredState());
        }
        if (a(this.i)) {
            i3 += a(this.i, i, i3, i2, 0, iArr);
            max = Math.max(max, this.i.getMeasuredHeight() + c(this.i));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.i.getMeasuredState());
        }
        i4 = getChildCount();
        max2 = max;
        max = i3;
        for (i3 = 0; i3 < i4; i3++) {
            View childAt = getChildAt(i3);
            if (((b) childAt.getLayoutParams()).b == 0 && a(childAt)) {
                max += a(childAt, i, max, i2, 0, iArr);
                max2 = Math.max(max2, childAt.getMeasuredHeight() + c(childAt));
                combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, childAt.getMeasuredState());
            }
        }
        i3 = this.s + this.t;
        i4 = this.q + this.r;
        if (a(this.f)) {
            a(this.f, i, max + i4, i2, i3, iArr);
            measuredWidth = this.f.getMeasuredWidth() + b(this.f);
            measuredHeight = this.f.getMeasuredHeight() + c(this.f);
            combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f.getMeasuredState());
            combineMeasuredStates = measuredWidth;
        } else {
            measuredHeight = 0;
            combineMeasuredStates2 = combineMeasuredStates;
            combineMeasuredStates = measuredHeight;
        }
        if (a(this.g)) {
            int i5 = measuredHeight + i3;
            i3 = combineMeasuredStates2;
            combineMeasuredStates = Math.max(combineMeasuredStates, a(this.g, i, max + i4, i2, i5, iArr));
            measuredHeight += this.g.getMeasuredHeight() + c(this.g);
            combineMeasuredStates2 = View.combineMeasuredStates(i3, this.g.getMeasuredState());
        } else {
            i3 = combineMeasuredStates2;
        }
        max += combineMeasuredStates;
        measuredWidth = Math.max(max2, measuredHeight) + (getPaddingTop() + getPaddingBottom());
        int i6 = i;
        currentContentInsetStart = View.resolveSizeAndState(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i6, -16777216 & combineMeasuredStates2);
        measuredWidth = View.resolveSizeAndState(Math.max(measuredWidth, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16);
        if (r()) {
            measuredWidth = 0;
        }
        setMeasuredDimension(currentContentInsetStart, measuredWidth);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            super.onRestoreInstanceState(dVar.a());
            Menu d = this.e != null ? this.e.d() : null;
            if (!(dVar.a == 0 || this.K == null || d == null)) {
                MenuItem findItem = d.findItem(dVar.a);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
            if (dVar.b) {
                q();
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        s();
        aw awVar = this.u;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        awVar.a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable dVar = new d(super.onSaveInstanceState());
        if (!(this.K == null || this.K.b == null)) {
            dVar.a = this.K.b.getItemId();
        }
        dVar.b = b();
        return dVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(android.support.v7.b.a.a.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!d(this.i)) {
                a(this.i, true);
            }
        } else if (this.i != null && d(this.i)) {
            removeView(this.i);
            this.F.remove(this.i);
        }
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        if (this.i != null) {
            this.i.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            p();
        }
        if (this.h != null) {
            this.h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(android.support.v7.b.a.a.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            p();
            if (!d(this.h)) {
                a(this.h, true);
            }
        } else if (this.h != null && d(this.h)) {
            removeView(this.h);
            this.F.remove(this.h);
        }
        if (this.h != null) {
            this.h.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        p();
        this.h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.d = cVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        n();
        this.e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.m != i) {
            this.m = i;
            if (i == 0) {
                this.l = getContext();
                return;
            }
            this.l = new ContextThemeWrapper(getContext(), i);
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new aa(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TruncateAt.END);
                if (this.o != 0) {
                    this.g.setTextAppearance(context, this.o);
                }
                if (this.B != 0) {
                    this.g.setTextColor(this.B);
                }
            }
            if (!d(this.g)) {
                a(this.g, true);
            }
        } else if (this.g != null && d(this.g)) {
            removeView(this.g);
            this.F.remove(this.g);
        }
        if (this.g != null) {
            this.g.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.B = i;
        if (this.g != null) {
            this.g.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f == null) {
                Context context = getContext();
                this.f = new aa(context);
                this.f.setSingleLine();
                this.f.setEllipsize(TruncateAt.END);
                if (this.n != 0) {
                    this.f.setTextAppearance(context, this.n);
                }
                if (this.A != 0) {
                    this.f.setTextColor(this.A);
                }
            }
            if (!d(this.f)) {
                a(this.f, true);
            }
        } else if (this.f != null && d(this.f)) {
            removeView(this.f);
            this.F.remove(this.f);
        }
        if (this.f != null) {
            this.f.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.A = i;
        if (this.f != null) {
            this.f.setTextColor(i);
        }
    }
}
