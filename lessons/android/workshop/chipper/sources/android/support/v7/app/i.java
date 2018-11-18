package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.h.r;
import android.support.v7.view.menu.h;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ae;
import android.support.v7.widget.bh;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import java.util.ArrayList;

class i extends a {
    ae a;
    boolean b;
    Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<android.support.v7.app.a.b> f = new ArrayList();
    private final Runnable g = new Runnable() {
        public void run() {
            i.this.i();
        }
    };
    private final android.support.v7.widget.Toolbar.c h = new android.support.v7.widget.Toolbar.c() {
        public boolean a(MenuItem menuItem) {
            return i.this.c.onMenuItemSelected(0, menuItem);
        }
    };

    private final class a implements android.support.v7.view.menu.o.a {
        private boolean b;

        a() {
        }

        public void a(h hVar, boolean z) {
            if (!this.b) {
                this.b = true;
                i.this.a.n();
                if (i.this.c != null) {
                    i.this.c.onPanelClosed(108, hVar);
                }
                this.b = false;
            }
        }

        public boolean a(h hVar) {
            if (i.this.c == null) {
                return false;
            }
            i.this.c.onMenuOpened(108, hVar);
            return true;
        }
    }

    private final class b implements android.support.v7.view.menu.h.a {
        b() {
        }

        public void a(h hVar) {
            if (i.this.c != null) {
                if (i.this.a.i()) {
                    i.this.c.onPanelClosed(108, hVar);
                } else if (i.this.c.onPreparePanel(0, null, hVar)) {
                    i.this.c.onMenuOpened(108, hVar);
                }
            }
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return false;
        }
    }

    private class c extends android.support.v7.view.i {
        public c(Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i) {
            return i == 0 ? new View(i.this.a.b()) : super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !i.this.b) {
                i.this.a.m();
                i.this.b = true;
            }
            return onPreparePanel;
        }
    }

    i(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.a = new bh(toolbar, false);
        this.c = new c(callback);
        this.a.a(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.a.a(charSequence);
    }

    private Menu j() {
        if (!this.d) {
            this.a.a(new a(), new b());
            this.d = true;
        }
        return this.a.q();
    }

    public int a() {
        return this.a.o();
    }

    public void a(float f) {
        r.a(this.a.a(), f);
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public void a(boolean z) {
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        j.setQwertyMode(z);
        return j.performShortcut(i, keyEvent, 0);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    public Context b() {
        return this.a.b();
    }

    public void c(boolean z) {
    }

    public boolean c() {
        return this.a.k();
    }

    public void d(boolean z) {
    }

    public boolean d() {
        return this.a.l();
    }

    public void e(boolean z) {
        if (z != this.e) {
            this.e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                ((android.support.v7.app.a.b) this.f.get(i)).a(z);
            }
        }
    }

    public boolean e() {
        this.a.a().removeCallbacks(this.g);
        r.a(this.a.a(), this.g);
        return true;
    }

    public boolean f() {
        if (!this.a.c()) {
            return false;
        }
        this.a.d();
        return true;
    }

    void g() {
        this.a.a().removeCallbacks(this.g);
    }

    public Callback h() {
        return this.c;
    }

    void i() {
        Menu j = j();
        h hVar = j instanceof h ? (h) j : null;
        if (hVar != null) {
            hVar.h();
        }
        try {
            j.clear();
            if (!(this.c.onCreatePanelMenu(0, j) && this.c.onPreparePanel(0, null, j))) {
                j.clear();
            }
            if (hVar != null) {
                hVar.i();
            }
        } catch (Throwable th) {
            if (hVar != null) {
                hVar.i();
            }
        }
    }
}
