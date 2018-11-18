package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.h.r;
import android.support.v7.a.a.d;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.aq;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class t extends m implements o, OnKeyListener, OnItemClickListener, OnDismissListener {
    private static final int e = g.abc_popup_menu_item_layout;
    final aq a;
    final OnGlobalLayoutListener b = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (t.this.d() && !t.this.a.g()) {
                View view = t.this.c;
                if (view == null || !view.isShown()) {
                    t.this.c();
                } else {
                    t.this.a.a();
                }
            }
        }
    };
    View c;
    ViewTreeObserver d;
    private final Context f;
    private final h g;
    private final g h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private final OnAttachStateChangeListener m = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (t.this.d != null) {
                if (!t.this.d.isAlive()) {
                    t.this.d = view.getViewTreeObserver();
                }
                t.this.d.removeGlobalOnLayoutListener(t.this.b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private OnDismissListener n;
    private View o;
    private a p;
    private boolean q;
    private boolean r;
    private int s;
    private int t = 0;
    private boolean u;

    public t(Context context, h hVar, View view, int i, int i2, boolean z) {
        this.f = context;
        this.g = hVar;
        this.i = z;
        this.h = new g(hVar, LayoutInflater.from(context), this.i, e);
        this.k = i;
        this.l = i2;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.o = view;
        this.a = new aq(this.f, null, this.k, this.l);
        hVar.a((o) this, context);
    }

    private boolean h() {
        if (d()) {
            return true;
        }
        if (this.q || this.o == null) {
            return false;
        }
        this.c = this.o;
        this.a.a((OnDismissListener) this);
        this.a.a((OnItemClickListener) this);
        this.a.a(true);
        View view = this.c;
        boolean z = this.d == null;
        this.d = view.getViewTreeObserver();
        if (z) {
            this.d.addOnGlobalLayoutListener(this.b);
        }
        view.addOnAttachStateChangeListener(this.m);
        this.a.b(view);
        this.a.e(this.t);
        if (!this.r) {
            this.s = m.a(this.h, null, this.f, this.j);
            this.r = true;
        }
        this.a.g(this.s);
        this.a.h(2);
        this.a.a(g());
        this.a.a();
        ViewGroup e = this.a.e();
        e.setOnKeyListener(this);
        if (this.u && this.g.n() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f).inflate(g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.g.n());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, null, false);
        }
        this.a.a(this.h);
        this.a.a();
        return true;
    }

    public void a() {
        if (!h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void a(int i) {
        this.t = i;
    }

    public void a(h hVar) {
    }

    public void a(h hVar, boolean z) {
        if (hVar == this.g) {
            c();
            if (this.p != null) {
                this.p.a(hVar, z);
            }
        }
    }

    public void a(a aVar) {
        this.p = aVar;
    }

    public void a(View view) {
        this.o = view;
    }

    public void a(OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public void a(boolean z) {
        this.h.a(z);
    }

    public boolean a(u uVar) {
        if (uVar.hasVisibleItems()) {
            n nVar = new n(this.f, uVar, this.c, this.i, this.k, this.l);
            nVar.a(this.p);
            nVar.a(m.b((h) uVar));
            nVar.a(this.n);
            this.n = null;
            this.g.a(false);
            int j = this.a.j();
            int k = this.a.k();
            if ((Gravity.getAbsoluteGravity(this.t, r.e(this.o)) & 7) == 5) {
                j += this.o.getWidth();
            }
            if (nVar.a(j, k)) {
                if (this.p != null) {
                    this.p.a(uVar);
                }
                return true;
            }
        }
        return false;
    }

    public void b(int i) {
        this.a.c(i);
    }

    public void b(boolean z) {
        this.r = false;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public void c() {
        if (d()) {
            this.a.c();
        }
    }

    public void c(int i) {
        this.a.d(i);
    }

    public void c(boolean z) {
        this.u = z;
    }

    public boolean d() {
        return !this.q && this.a.d();
    }

    public ListView e() {
        return this.a.e();
    }

    public void onDismiss() {
        this.q = true;
        this.g.close();
        if (this.d != null) {
            if (!this.d.isAlive()) {
                this.d = this.c.getViewTreeObserver();
            }
            this.d.removeGlobalOnLayoutListener(this.b);
            this.d = null;
        }
        this.c.removeOnAttachStateChangeListener(this.m);
        if (this.n != null) {
            this.n.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }
}
