package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.h.r;
import android.support.v7.a.a.d;
import android.support.v7.a.a.g;
import android.support.v7.widget.ap;
import android.support.v7.widget.aq;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

final class e extends m implements o, OnKeyListener, OnDismissListener {
    private static final int g = g.abc_cascading_menu_item_layout;
    private OnDismissListener A;
    final Handler a;
    final List<a> b = new ArrayList();
    final OnGlobalLayoutListener c = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (e.this.d() && e.this.b.size() > 0 && !((a) e.this.b.get(0)).a.g()) {
                View view = e.this.d;
                if (view == null || !view.isShown()) {
                    e.this.c();
                    return;
                }
                for (a aVar : e.this.b) {
                    aVar.a.a();
                }
            }
        }
    };
    View d;
    ViewTreeObserver e;
    boolean f;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final boolean l;
    private final List<h> m = new ArrayList();
    private final OnAttachStateChangeListener n = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (e.this.e != null) {
                if (!e.this.e.isAlive()) {
                    e.this.e = view.getViewTreeObserver();
                }
                e.this.e.removeGlobalOnLayoutListener(e.this.c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final ap o = new ap() {
        public void a(h hVar, MenuItem menuItem) {
            e.this.a.removeCallbacksAndMessages(hVar);
        }

        public void b(final h hVar, final MenuItem menuItem) {
            a aVar = null;
            e.this.a.removeCallbacksAndMessages(null);
            int size = e.this.b.size();
            int i = 0;
            while (i < size) {
                if (hVar == ((a) e.this.b.get(i)).b) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                i++;
                if (i < e.this.b.size()) {
                    aVar = (a) e.this.b.get(i);
                }
                e.this.a.postAtTime(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            e.this.f = true;
                            aVar.b.a(false);
                            e.this.f = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hVar.a(menuItem, 4);
                        }
                    }
                }, hVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int p = 0;
    private int q = 0;
    private View r;
    private int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private android.support.v7.view.menu.o.a z;

    private static class a {
        public final aq a;
        public final h b;
        public final int c;

        public a(aq aqVar, h hVar, int i) {
            this.a = aqVar;
            this.b = hVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.e();
        }
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.h = context;
        this.r = view;
        this.j = i;
        this.k = i2;
        this.l = z;
        this.x = false;
        this.s = i();
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    private MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, h hVar) {
        MenuItem a = a(aVar.b, hVar);
        if (a == null) {
            return null;
        }
        int headersCount;
        g gVar;
        ListView a2 = aVar.a();
        ListAdapter adapter = a2.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            headersCount = 0;
        }
        int count = gVar.getCount();
        while (i < count) {
            if (a == gVar.getItem(i)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            return null;
        }
        i = (i + headersCount) - a2.getFirstVisiblePosition();
        return (i < 0 || i >= a2.getChildCount()) ? null : a2.getChildAt(i);
    }

    private void c(h hVar) {
        a aVar;
        View a;
        LayoutInflater from = LayoutInflater.from(this.h);
        ListAdapter gVar = new g(hVar, from, this.l, g);
        if (!d() && this.x) {
            gVar.a(true);
        } else if (d()) {
            gVar.a(m.b(hVar));
        }
        int a2 = m.a(gVar, null, this.h, this.i);
        aq h = h();
        h.a(gVar);
        h.g(a2);
        h.e(this.q);
        if (this.b.size() > 0) {
            aVar = (a) this.b.get(this.b.size() - 1);
            a = a(aVar, hVar);
        } else {
            aVar = null;
            a = aVar;
        }
        if (a != null) {
            int i;
            h.c(false);
            h.a(null);
            int d = d(a2);
            boolean z = d == 1;
            this.s = d;
            if (VERSION.SDK_INT >= 26) {
                h.b(a);
                d = 0;
                i = d;
            } else {
                int[] iArr = new int[2];
                this.r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                a.getLocationOnScreen(iArr2);
                if ((this.q & 7) == 5) {
                    iArr[0] = iArr[0] + this.r.getWidth();
                    iArr2[0] = iArr2[0] + a.getWidth();
                }
                i = iArr2[0] - iArr[0];
                d = iArr2[1] - iArr[1];
            }
            if ((this.q & 5) != 5) {
                if (z) {
                    a2 = a.getWidth();
                }
                i -= a2;
                h.c(i);
                h.b(true);
                h.d(d);
            } else if (!z) {
                a2 = a.getWidth();
                i -= a2;
                h.c(i);
                h.b(true);
                h.d(d);
            }
            i += a2;
            h.c(i);
            h.b(true);
            h.d(d);
        } else {
            if (this.t) {
                h.c(this.v);
            }
            if (this.u) {
                h.d(this.w);
            }
            h.a(g());
        }
        this.b.add(new a(h, hVar, this.s));
        h.a();
        ViewGroup e = h.e();
        e.setOnKeyListener(this);
        if (aVar == null && this.y && hVar.n() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(hVar.n());
            e.addHeaderView(frameLayout, null, false);
            h.a();
        }
    }

    private int d(int i) {
        ListView a = ((a) this.b.get(this.b.size() - 1)).a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.d.getWindowVisibleDisplayFrame(rect);
        return this.s == 1 ? (iArr[0] + a.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private int d(h hVar) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (hVar == ((a) this.b.get(i)).b) {
                return i;
            }
        }
        return -1;
    }

    private aq h() {
        aq aqVar = new aq(this.h, null, this.j, this.k);
        aqVar.a(this.o);
        aqVar.a((OnItemClickListener) this);
        aqVar.a((OnDismissListener) this);
        aqVar.b(this.r);
        aqVar.e(this.q);
        aqVar.a(true);
        aqVar.h(2);
        return aqVar;
    }

    private int i() {
        return r.e(this.r) == 1 ? 0 : 1;
    }

    public void a() {
        if (!d()) {
            for (h c : this.m) {
                c(c);
            }
            this.m.clear();
            this.d = this.r;
            if (this.d != null) {
                Object obj = this.e == null ? 1 : null;
                this.e = this.d.getViewTreeObserver();
                if (obj != null) {
                    this.e.addOnGlobalLayoutListener(this.c);
                }
                this.d.addOnAttachStateChangeListener(this.n);
            }
        }
    }

    public void a(int i) {
        if (this.p != i) {
            this.p = i;
            this.q = android.support.v4.h.d.a(i, r.e(this.r));
        }
    }

    public void a(h hVar) {
        hVar.a((o) this, this.h);
        if (d()) {
            c(hVar);
        } else {
            this.m.add(hVar);
        }
    }

    public void a(h hVar, boolean z) {
        int d = d(hVar);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.b.size()) {
                ((a) this.b.get(i)).b.a(false);
            }
            a aVar = (a) this.b.remove(d);
            aVar.b.b((o) this);
            if (this.f) {
                aVar.a.b(null);
                aVar.a.b(0);
            }
            aVar.a.c();
            d = this.b.size();
            this.s = d > 0 ? ((a) this.b.get(d - 1)).c : i();
            if (d == 0) {
                c();
                if (this.z != null) {
                    this.z.a(hVar, true);
                }
                if (this.e != null) {
                    if (this.e.isAlive()) {
                        this.e.removeGlobalOnLayoutListener(this.c);
                    }
                    this.e = null;
                }
                this.d.removeOnAttachStateChangeListener(this.n);
                this.A.onDismiss();
                return;
            }
            if (z) {
                ((a) this.b.get(0)).b.a(false);
            }
        }
    }

    public void a(android.support.v7.view.menu.o.a aVar) {
        this.z = aVar;
    }

    public void a(View view) {
        if (this.r != view) {
            this.r = view;
            this.q = android.support.v4.h.d.a(this.p, r.e(this.r));
        }
    }

    public void a(OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    public void a(boolean z) {
        this.x = z;
    }

    public boolean a(u uVar) {
        for (a aVar : this.b) {
            if (uVar == aVar.b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        a((h) uVar);
        if (this.z != null) {
            this.z.a(uVar);
        }
        return true;
    }

    public void b(int i) {
        this.t = true;
        this.v = i;
    }

    public void b(boolean z) {
        for (a a : this.b) {
            m.a(a.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public void c() {
        int size = this.b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.b.toArray(new a[size]);
            for (size--; size >= 0; size--) {
                a aVar = aVarArr[size];
                if (aVar.a.d()) {
                    aVar.a.c();
                }
            }
        }
    }

    public void c(int i) {
        this.u = true;
        this.w = i;
    }

    public void c(boolean z) {
        this.y = z;
    }

    public boolean d() {
        return this.b.size() > 0 && ((a) this.b.get(0)).a.d();
    }

    public ListView e() {
        return this.b.isEmpty() ? null : ((a) this.b.get(this.b.size() - 1)).a();
    }

    protected boolean f() {
        return false;
    }

    public void onDismiss() {
        a aVar;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            aVar = (a) this.b.get(i);
            if (!aVar.a.d()) {
                break;
            }
        }
        aVar = null;
        if (aVar != null) {
            aVar.b.a(false);
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
