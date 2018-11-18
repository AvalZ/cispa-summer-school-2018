package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.h.r;
import android.support.v4.h.v;
import android.support.v4.h.w;
import android.support.v4.h.x;
import android.support.v4.h.y;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.support.v7.app.a.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ae;
import android.support.v7.widget.ay;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class l extends a implements android.support.v7.widget.ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s = true;
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private ArrayList<b> C = new ArrayList();
    private boolean D;
    private int E = 0;
    private boolean F;
    private boolean G = s;
    private boolean H;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    ae d;
    ActionBarContextView e;
    View f;
    ay g;
    a h;
    android.support.v7.view.b i;
    android.support.v7.view.b.a j;
    boolean k = s;
    boolean l;
    boolean m;
    h n;
    boolean o;
    final w p = new x() {
        public void b(View view) {
            if (l.this.k && l.this.f != null) {
                l.this.f.setTranslationY(0.0f);
                l.this.c.setTranslationY(0.0f);
            }
            l.this.c.setVisibility(8);
            l.this.c.setTransitioning(false);
            l.this.n = null;
            l.this.h();
            if (l.this.b != null) {
                r.m(l.this.b);
            }
        }
    };
    final w q = new x() {
        public void b(View view) {
            l.this.n = null;
            l.this.c.requestLayout();
        }
    };
    final y r = new y() {
        public void a(View view) {
            ((View) l.this.c.getParent()).invalidate();
        }
    };
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList();
    private int z = -1;

    public class a extends android.support.v7.view.b implements android.support.v7.view.menu.h.a {
        private final Context b;
        private final android.support.v7.view.menu.h c;
        private android.support.v7.view.b.a d;
        private WeakReference<View> e;

        public a(Context context, android.support.v7.view.b.a aVar) {
            this.b = context;
            this.d = aVar;
            this.c = new android.support.v7.view.menu.h(context).a(1);
            this.c.a((android.support.v7.view.menu.h.a) this);
        }

        public MenuInflater a() {
            return new g(this.b);
        }

        public void a(int i) {
            b(l.this.a.getResources().getString(i));
        }

        public void a(android.support.v7.view.menu.h hVar) {
            if (this.d != null) {
                d();
                l.this.e.a();
            }
        }

        public void a(View view) {
            l.this.e.setCustomView(view);
            this.e = new WeakReference(view);
        }

        public void a(CharSequence charSequence) {
            l.this.e.setSubtitle(charSequence);
        }

        public void a(boolean z) {
            super.a(z);
            l.this.e.setTitleOptional(z);
        }

        public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            return this.d != null ? this.d.a((android.support.v7.view.b) this, menuItem) : false;
        }

        public Menu b() {
            return this.c;
        }

        public void b(int i) {
            a(l.this.a.getResources().getString(i));
        }

        public void b(CharSequence charSequence) {
            l.this.e.setTitle(charSequence);
        }

        public void c() {
            if (l.this.h == this) {
                if (l.a(l.this.l, l.this.m, false)) {
                    this.d.a(this);
                } else {
                    l.this.i = this;
                    l.this.j = this.d;
                }
                this.d = null;
                l.this.j(false);
                l.this.e.b();
                l.this.d.a().sendAccessibilityEvent(32);
                l.this.b.setHideOnContentScrollEnabled(l.this.o);
                l.this.h = null;
            }
        }

        public void d() {
            if (l.this.h == this) {
                this.c.h();
                try {
                    this.d.b(this, this.c);
                } finally {
                    this.c.i();
                }
            }
        }

        public boolean e() {
            this.c.h();
            try {
                boolean a = this.d.a((android.support.v7.view.b) this, this.c);
                return a;
            } finally {
                this.c.i();
            }
        }

        public CharSequence f() {
            return l.this.e.getTitle();
        }

        public CharSequence g() {
            return l.this.e.getSubtitle();
        }

        public boolean h() {
            return l.this.e.d();
        }

        public View i() {
            return this.e != null ? (View) this.e.get() : null;
        }
    }

    public l(Activity activity, boolean z) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.f = decorView.findViewById(16908290);
        }
    }

    public l(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.b = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        if (this.b != null) {
            this.b.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(f.action_bar));
        this.e = (ActionBarContextView) view.findViewById(f.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(f.action_bar_container);
        if (this.d == null || this.e == null || this.c == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(" can only be used ");
            stringBuilder.append("with a compatible window decor layout");
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.a = this.d.b();
        boolean z = (this.d.o() & 4) != 0 ? s : false;
        if (z) {
            this.A = s;
        }
        android.support.v7.view.a a = android.support.v7.view.a.a(this.a);
        z = (a.f() || z) ? s : false;
        a(z);
        k(a.d());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, j.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            b((boolean) s);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        return z3 ? s : (z || z2) ? false : s;
    }

    private ae b(View view) {
        if (view instanceof ae) {
            return (ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        stringBuilder.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void k(boolean z) {
        this.D = z;
        if (this.D) {
            this.c.setTabContainer(null);
            this.d.a(this.g);
        } else {
            this.d.a(null);
            this.c.setTabContainer(this.g);
        }
        int i = i();
        boolean z2 = s;
        z = i == 2 ? s : false;
        if (this.g != null) {
            if (z) {
                this.g.setVisibility(0);
                if (this.b != null) {
                    r.m(this.b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        ae aeVar = this.d;
        boolean z3 = (this.D || !z) ? false : s;
        aeVar.a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        if (this.D || !z) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void l(boolean z) {
        if (a(this.l, this.m, this.F)) {
            if (!this.G) {
                this.G = s;
                h(z);
            }
        } else if (this.G) {
            this.G = false;
            i(z);
        }
    }

    private void n() {
        if (!this.F) {
            this.F = s;
            if (this.b != null) {
                this.b.setShowingForActionMode(s);
            }
            l(false);
        }
    }

    private void o() {
        if (this.F) {
            this.F = false;
            if (this.b != null) {
                this.b.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private boolean p() {
        return r.u(this.c);
    }

    public int a() {
        return this.d.o();
    }

    public android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        if (this.h != null) {
            this.h.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        android.support.v7.view.b aVar2 = new a(this.e.getContext(), aVar);
        if (!aVar2.e()) {
            return null;
        }
        this.h = aVar2;
        aVar2.d();
        this.e.a(aVar2);
        j(s);
        this.e.sendAccessibilityEvent(32);
        return aVar2;
    }

    public void a(float f) {
        r.a(this.c, f);
    }

    public void a(int i) {
        this.E = i;
    }

    public void a(int i, int i2) {
        int o = this.d.o();
        if ((i2 & 4) != 0) {
            this.A = s;
        }
        this.d.c((i & i2) | ((~i2) & o));
    }

    public void a(Configuration configuration) {
        k(android.support.v7.view.a.a(this.a).d());
    }

    public void a(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    public void a(boolean z) {
        this.d.b(z);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h == null) {
            return false;
        }
        Menu b = this.h.b();
        if (b == null) {
            return false;
        }
        int keyboardType = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType();
        boolean z = s;
        if (keyboardType == 1) {
            z = false;
        }
        b.setQwertyMode(z);
        return b.performShortcut(i, keyEvent, 0);
    }

    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, s);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.v = new ContextThemeWrapper(this.a, i);
            } else {
                this.v = this.a;
            }
        }
        return this.v;
    }

    public void b(boolean z) {
        if (!z || this.b.a()) {
            this.o = z;
            this.b.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void c(boolean z) {
        if (!this.A) {
            f(z);
        }
    }

    public void d(boolean z) {
        this.H = z;
        if (!z && this.n != null) {
            this.n.c();
        }
    }

    public void e(boolean z) {
        if (z != this.B) {
            this.B = z;
            int size = this.C.size();
            for (int i = 0; i < size; i++) {
                ((b) this.C.get(i)).a(z);
            }
        }
    }

    public void f(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public boolean f() {
        if (this.d == null || !this.d.c()) {
            return false;
        }
        this.d.d();
        return s;
    }

    public void g(boolean z) {
        this.k = z;
    }

    void h() {
        if (this.j != null) {
            this.j.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    public void h(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.E == 0 && (this.H || z)) {
            this.c.setTranslationY(0.0f);
            float f = (float) (-this.c.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.c.setTranslationY(f);
            h hVar = new h();
            v b = r.j(this.c).b(0.0f);
            b.a(this.r);
            hVar.a(b);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f);
                hVar.a(r.j(this.f).b(0.0f));
            }
            hVar.a(u);
            hVar.a(250);
            hVar.a(this.q);
            this.n = hVar;
            hVar.a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.b(null);
        }
        if (this.b != null) {
            r.m(this.b);
        }
    }

    public int i() {
        return this.d.p();
    }

    public void i(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.E == 0 && (this.H || z)) {
            this.c.setAlpha(1.0f);
            this.c.setTransitioning(s);
            h hVar = new h();
            float f = (float) (-this.c.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            v b = r.j(this.c).b(f);
            b.a(this.r);
            hVar.a(b);
            if (this.k && this.f != null) {
                hVar.a(r.j(this.f).b(f));
            }
            hVar.a(t);
            hVar.a(250);
            hVar.a(this.p);
            this.n = hVar;
            hVar.a();
            return;
        }
        this.p.b(null);
    }

    public void j() {
        if (this.m) {
            this.m = false;
            l(s);
        }
    }

    public void j(boolean z) {
        if (z) {
            n();
        } else {
            o();
        }
        if (p()) {
            v a;
            v vVar;
            if (z) {
                v a2 = this.d.a(4, 100);
                a = this.e.a(0, 200);
                vVar = a2;
            } else {
                a = this.d.a(0, 200);
                vVar = this.e.a(8, 100);
            }
            h hVar = new h();
            hVar.a(vVar, a);
            hVar.a();
        } else if (z) {
            this.d.d(4);
            this.e.setVisibility(0);
        } else {
            this.d.d(0);
            this.e.setVisibility(8);
        }
    }

    public void k() {
        if (!this.m) {
            this.m = s;
            l(s);
        }
    }

    public void l() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    public void m() {
    }
}
