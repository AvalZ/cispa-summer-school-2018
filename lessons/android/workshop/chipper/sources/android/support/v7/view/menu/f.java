package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.a.a.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class f implements o, OnItemClickListener {
    Context a;
    LayoutInflater b;
    h c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private android.support.v7.view.menu.o.a i;

    private class a extends BaseAdapter {
        private int b = -1;

        public a() {
            a();
        }

        /* renamed from: a */
        public j getItem(int i) {
            ArrayList m = f.this.c.m();
            i += f.this.e;
            if (this.b >= 0 && i >= this.b) {
                i++;
            }
            return (j) m.get(i);
        }

        void a() {
            j s = f.this.c.s();
            if (s != null) {
                ArrayList m = f.this.c.m();
                int size = m.size();
                for (int i = 0; i < size; i++) {
                    if (((j) m.get(i)) == s) {
                        this.b = i;
                        return;
                    }
                }
            }
            this.b = -1;
        }

        public int getCount() {
            int size = f.this.c.m().size() - f.this.e;
            return this.b < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = f.this.b.inflate(f.this.g, viewGroup, false);
            }
            ((android.support.v7.view.menu.p.a) view).a(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public f(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    public f(Context context, int i) {
        this(i, 0);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public p a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.d.setAdapter(this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARNING: Missing block: B:7:0x001e, code:
            if (r2.b == null) goto L_0x000d;
     */
    public void a(android.content.Context r3, android.support.v7.view.menu.h r4) {
        /*
        r2 = this;
        r0 = r2.f;
        if (r0 == 0) goto L_0x0016;
    L_0x0004:
        r0 = new android.view.ContextThemeWrapper;
        r1 = r2.f;
        r0.<init>(r3, r1);
        r2.a = r0;
    L_0x000d:
        r3 = r2.a;
        r3 = android.view.LayoutInflater.from(r3);
        r2.b = r3;
        goto L_0x0021;
    L_0x0016:
        r0 = r2.a;
        if (r0 == 0) goto L_0x0021;
    L_0x001a:
        r2.a = r3;
        r3 = r2.b;
        if (r3 != 0) goto L_0x0021;
    L_0x0020:
        goto L_0x000d;
    L_0x0021:
        r2.c = r4;
        r3 = r2.h;
        if (r3 == 0) goto L_0x002c;
    L_0x0027:
        r2 = r2.h;
        r2.notifyDataSetChanged();
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.f.a(android.content.Context, android.support.v7.view.menu.h):void");
    }

    public void a(h hVar, boolean z) {
        if (this.i != null) {
            this.i.a(hVar, z);
        }
    }

    public void a(android.support.v7.view.menu.o.a aVar) {
        this.i = aVar;
    }

    public boolean a(h hVar, j jVar) {
        return false;
    }

    public boolean a(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        new i(uVar).a(null);
        if (this.i != null) {
            this.i.a(uVar);
        }
        return true;
    }

    public void b(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public boolean b(h hVar, j jVar) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.getItem(i), (o) this, 0);
    }
}
