package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class c extends android.support.v7.view.menu.b implements android.support.v4.h.c.a {
    private b A;
    d g;
    e h;
    a i;
    c j;
    final f k = new f();
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y = new SparseBooleanArray();
    private View z;

    private class c implements Runnable {
        private e b;

        public c(e eVar) {
            this.b = eVar;
        }

        public void run() {
            if (c.this.c != null) {
                c.this.c.g();
            }
            View view = (View) c.this.f;
            if (!(view == null || view.getWindowToken() == null || !this.b.c())) {
                c.this.h = this.b;
            }
            c.this.j = null;
        }
    }

    private class a extends n {
        public a(Context context, u uVar, View view) {
            super(context, uVar, view, false, android.support.v7.a.a.a.actionOverflowMenuStyle);
            if (!((j) uVar.getItem()).j()) {
                a(c.this.g == null ? (View) c.this.f : c.this.g);
            }
            a(c.this.k);
        }

        protected void e() {
            c.this.i = null;
            c.this.l = 0;
            super.e();
        }
    }

    private class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        b() {
        }

        public s a() {
            return c.this.i != null ? c.this.i.b() : null;
        }
    }

    private class e extends n {
        public e(Context context, h hVar, View view, boolean z) {
            super(context, hVar, view, z, android.support.v7.a.a.a.actionOverflowMenuStyle);
            a(8388613);
            a(c.this.k);
        }

        protected void e() {
            if (c.this.c != null) {
                c.this.c.close();
            }
            c.this.h = null;
            super.e();
        }
    }

    private class f implements android.support.v7.view.menu.o.a {
        f() {
        }

        public void a(h hVar, boolean z) {
            if (hVar instanceof u) {
                hVar.q().a(false);
            }
            android.support.v7.view.menu.o.a a = c.this.a();
            if (a != null) {
                a.a(hVar, z);
            }
        }

        public boolean a(h hVar) {
            boolean z = false;
            if (hVar == null) {
                return false;
            }
            c.this.l = ((u) hVar).getItem().getItemId();
            android.support.v7.view.menu.o.a a = c.this.a();
            if (a != null) {
                z = a.a(hVar);
            }
            return z;
        }
    }

    private class d extends q implements android.support.v7.widget.ActionMenuView.a {
        private final float[] b = new float[2];

        public d(Context context) {
            super(context, null, android.support.v7.a.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            bi.a(this, getContentDescription());
            setOnTouchListener(new ak(this, c.this) {
                public s a() {
                    return c.this.h == null ? null : c.this.h.b();
                }

                public boolean b() {
                    c.this.d();
                    return true;
                }

                public boolean c() {
                    if (c.this.j != null) {
                        return false;
                    }
                    c.this.e();
                    return true;
                }
            });
        }

        public boolean c() {
            return false;
        }

        public boolean d() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.d();
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                i2 = getWidth();
                i4 = getHeight();
                int max = Math.max(i2, i4) / 2;
                i2 = (i2 + (getPaddingLeft() - getPaddingRight())) / 2;
                i4 = (i4 + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.graphics.drawable.a.a(background, i2 - max, i4 - max, i2 + max, i4 + max);
            }
            return frame;
        }
    }

    public c(Context context) {
        super(context, g.abc_action_menu_layout, g.abc_action_menu_item_layout);
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof android.support.v7.view.menu.p.a) && ((android.support.v7.view.menu.p.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public p a(ViewGroup viewGroup) {
        p pVar = this.f;
        p a = super.a(viewGroup);
        if (pVar != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.n()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public void a(Context context, h hVar) {
        super.a(context, hVar);
        Resources resources = context.getResources();
        android.support.v7.view.a a = android.support.v7.view.a.a(context);
        if (!this.p) {
            this.o = a.b();
        }
        if (!this.v) {
            this.q = a.c();
        }
        if (!this.t) {
            this.s = a.a();
        }
        int i = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new d(this.a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.z = null;
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = android.support.v7.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void a(Drawable drawable) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    public void a(h hVar, boolean z) {
        f();
        super.a(hVar, z);
    }

    public void a(j jVar, android.support.v7.view.menu.p.a aVar) {
        aVar.a(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    public void a(boolean z) {
        if (z) {
            super.a(null);
            return;
        }
        if (this.c != null) {
            this.c.a(false);
        }
    }

    public boolean a(int i, j jVar) {
        return jVar.j();
    }

    public boolean a(u uVar) {
        boolean z = false;
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        u uVar2 = uVar;
        while (uVar2.t() != this.c) {
            uVar2 = (u) uVar2.t();
        }
        View a = a(uVar2.getItem());
        if (a == null) {
            return false;
        }
        this.l = uVar.getItem().getItemId();
        int size = uVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = uVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        this.i = new a(this.b, uVar, a);
        this.i.a(z);
        this.i.a();
        super.a(uVar);
        return true;
    }

    public boolean a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.g ? false : super.a(viewGroup, i);
    }

    public void b(boolean z) {
        ArrayList l;
        int size;
        super.b(z);
        ((View) this.f).requestLayout();
        int i = 0;
        if (this.c != null) {
            l = this.c.l();
            size = l.size();
            for (int i2 = 0; i2 < size; i2++) {
                android.support.v4.h.c a = ((j) l.get(i2)).a();
                if (a != null) {
                    a.a((android.support.v4.h.c.a) this);
                }
            }
        }
        l = this.c != null ? this.c.m() : null;
        if (this.o && l != null) {
            size = l.size();
            if (size == 1) {
                i = ((j) l.get(0)).isActionViewExpanded() ^ 1;
            } else if (size > 0) {
                i = 1;
            }
        }
        if (i != 0) {
            if (this.g == null) {
                this.g = new d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    public boolean b() {
        ArrayList j;
        int size;
        c cVar = this;
        boolean z = false;
        if (cVar.c != null) {
            j = cVar.c.j();
            size = j.size();
        } else {
            j = null;
            size = 0;
        }
        int i = cVar.s;
        int i2 = cVar.r;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f;
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        int i6 = i;
        for (i = i5; i < size; i++) {
            j jVar = (j) j.get(i);
            if (jVar.l()) {
                i3++;
            } else if (jVar.k()) {
                i5++;
            } else {
                i4 = 1;
            }
            if (cVar.w && jVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.o && (i4 != 0 || i5 + i3 > i6)) {
            i6--;
        }
        i6 -= i3;
        SparseBooleanArray sparseBooleanArray = cVar.y;
        sparseBooleanArray.clear();
        if (cVar.u) {
            i3 = i2 / cVar.x;
            i4 = ((i2 % cVar.x) / i3) + cVar.x;
        } else {
            i3 = 0;
            i4 = i3;
        }
        int i7 = 0;
        i5 = i2;
        i2 = i7;
        while (i2 < size) {
            boolean z2;
            int i8;
            j jVar2 = (j) j.get(i2);
            int measuredWidth;
            boolean z3;
            if (jVar2.l()) {
                View a = cVar.a(jVar2, cVar.z, viewGroup);
                if (cVar.z == null) {
                    cVar.z = a;
                }
                if (cVar.u) {
                    i3 -= ActionMenuView.a(a, i4, i3, makeMeasureSpec, z);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                measuredWidth = a.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i7 == 0) {
                    i7 = measuredWidth;
                }
                measuredWidth = jVar2.getGroupId();
                if (measuredWidth != 0) {
                    z3 = true;
                    sparseBooleanArray.put(measuredWidth, true);
                } else {
                    z3 = true;
                }
                jVar2.d(z3);
                z2 = z;
                i8 = size;
            } else if (jVar2.k()) {
                measuredWidth = jVar2.getGroupId();
                z3 = sparseBooleanArray.get(measuredWidth);
                z = (i6 > 0 || z3) && i5 > 0 && (!cVar.u || i3 > 0);
                if (z) {
                    int i9 = z;
                    View a2 = cVar.a(jVar2, cVar.z, viewGroup);
                    i8 = size;
                    if (cVar.z == null) {
                        cVar.z = a2;
                    }
                    if (cVar.u) {
                        int a3 = ActionMenuView.a(a2, i4, i3, makeMeasureSpec, 0);
                        i3 -= a3;
                        if (a3 == 0) {
                            i9 = 0;
                        }
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a2.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i7 == 0) {
                        i7 = measuredWidth2;
                    }
                    measuredWidth2 = (cVar.u ? i5 < 0 : i5 + i7 <= 0) ? 0 : 1;
                    z = i9 & measuredWidth2;
                } else {
                    boolean z4 = z;
                    i8 = size;
                }
                if (z && measuredWidth != 0) {
                    sparseBooleanArray.put(measuredWidth, true);
                } else if (z3) {
                    sparseBooleanArray.put(measuredWidth, false);
                    for (size = 0; size < i2; size++) {
                        j jVar3 = (j) j.get(size);
                        if (jVar3.getGroupId() == measuredWidth) {
                            if (jVar3.j()) {
                                i6++;
                            }
                            jVar3.d(false);
                        }
                    }
                }
                if (z) {
                    i6--;
                }
                jVar2.d(z);
                z2 = false;
            } else {
                z2 = z;
                i8 = size;
                jVar2.d(z2);
            }
            i2++;
            z = z2;
            size = i8;
            cVar = this;
        }
        return true;
    }

    public Drawable c() {
        return this.g != null ? this.g.getDrawable() : this.n ? this.m : null;
    }

    public void c(boolean z) {
        this.o = z;
        this.p = true;
    }

    public void d(boolean z) {
        this.w = z;
    }

    public boolean d() {
        if (!this.o || h() || this.c == null || this.f == null || this.j != null || this.c.m().isEmpty()) {
            return false;
        }
        this.j = new c(new e(this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.a(null);
        return true;
    }

    public boolean e() {
        if (this.j == null || this.f == null) {
            n nVar = this.h;
            if (nVar == null) {
                return false;
            }
            nVar.d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.j);
        this.j = null;
        return true;
    }

    public boolean f() {
        return g() | e();
    }

    public boolean g() {
        if (this.i == null) {
            return false;
        }
        this.i.d();
        return true;
    }

    public boolean h() {
        return this.h != null && this.h.f();
    }

    public boolean i() {
        return this.j != null || h();
    }
}
