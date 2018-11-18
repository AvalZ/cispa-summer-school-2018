package android.support.v7.app;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.u;
import android.support.v4.h.r;
import android.support.v4.h.v;
import android.support.v4.h.x;
import android.support.v4.h.z;
import android.support.v4.widget.k;
import android.support.v7.a.a.i;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ad;
import android.support.v7.widget.aj;
import android.support.v7.widget.bg;
import android.support.v7.widget.bl;
import android.support.v7.widget.bo;
import android.support.v7.widget.l;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

class f extends e implements android.support.v7.view.menu.h.a, Factory2 {
    private static final boolean u = (VERSION.SDK_INT < 21);
    private static final int[] v = new int[]{16842836};
    private static boolean w = true;
    private g A;
    private boolean B = true;
    private boolean C;
    private ViewGroup D;
    private TextView E;
    private View F;
    private boolean G;
    private boolean H;
    private boolean I;
    private f[] J;
    private f K;
    private boolean L;
    private int M = -100;
    private boolean N;
    private d O;
    private final Runnable P = new Runnable() {
        public void run() {
            if ((f.this.t & 1) != 0) {
                f.this.g(0);
            }
            if ((f.this.t & 4096) != 0) {
                f.this.g(108);
            }
            f.this.s = false;
            f.this.t = 0;
        }
    };
    private boolean Q;
    private Rect R;
    private Rect S;
    private AppCompatViewInflater T;
    final Context a;
    final Window b;
    final Callback c;
    final Callback d;
    final d e;
    a f;
    MenuInflater g;
    android.support.v7.view.b h;
    ActionBarContextView i;
    PopupWindow j;
    Runnable k;
    v l = null;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    int t;
    private CharSequence x;
    private ad y;
    private a z;

    final class d {
        private k b;
        private boolean c;
        private BroadcastReceiver d;
        private IntentFilter e;

        d(k kVar) {
            this.b = kVar;
            this.c = kVar.a();
        }

        int a() {
            this.c = this.b.a();
            return this.c ? 2 : 1;
        }

        void b() {
            boolean a = this.b.a();
            if (a != this.c) {
                this.c = a;
                f.this.i();
            }
        }

        void c() {
            d();
            if (this.d == null) {
                this.d = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        d.this.b();
                    }
                };
            }
            if (this.e == null) {
                this.e = new IntentFilter();
                this.e.addAction("android.intent.action.TIME_SET");
                this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.e.addAction("android.intent.action.TIME_TICK");
            }
            f.this.a.registerReceiver(this.d, this.e);
        }

        void d() {
            if (this.d != null) {
                f.this.a.unregisterReceiver(this.d);
                this.d = null;
            }
        }
    }

    protected static final class f {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        h j;
        android.support.v7.view.menu.f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        f(int i) {
            this.a = i;
        }

        p a(android.support.v7.view.menu.o.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new android.support.v7.view.menu.f(this.l, android.support.v7.a.a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(android.support.v7.a.a.a.panelMenuListTheme, typedValue, true);
            newTheme.applyStyle(typedValue.resourceId != 0 ? typedValue.resourceId : i.Theme_AppCompat_CompactMenu, true);
            Context dVar = new android.support.v7.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(j.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(h hVar) {
            if (hVar != this.j) {
                if (this.j != null) {
                    this.j.b(this.k);
                }
                this.j = hVar;
                if (!(hVar == null || this.k == null)) {
                    hVar.a(this.k);
                }
            }
        }

        public boolean a() {
            boolean z = false;
            if (this.h == null) {
                return false;
            }
            if (this.i != null) {
                return true;
            }
            if (this.k.a().getCount() > 0) {
                z = true;
            }
            return z;
        }
    }

    private final class a implements android.support.v7.view.menu.o.a {
        a() {
        }

        public void a(h hVar, boolean z) {
            f.this.b(hVar);
        }

        public boolean a(h hVar) {
            Callback l = f.this.l();
            if (l != null) {
                l.onMenuOpened(108, hVar);
            }
            return true;
        }
    }

    class b implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a b;

        public b(android.support.v7.view.b.a aVar) {
            this.b = aVar;
        }

        public void a(android.support.v7.view.b bVar) {
            this.b.a(bVar);
            if (f.this.j != null) {
                f.this.b.getDecorView().removeCallbacks(f.this.k);
            }
            if (f.this.i != null) {
                f.this.q();
                f.this.l = r.j(f.this.i).a(0.0f);
                f.this.l.a(new x() {
                    public void b(View view) {
                        f.this.i.setVisibility(8);
                        if (f.this.j != null) {
                            f.this.j.dismiss();
                        } else if (f.this.i.getParent() instanceof View) {
                            r.m((View) f.this.i.getParent());
                        }
                        f.this.i.removeAllViews();
                        f.this.l.a(null);
                        f.this.l = null;
                    }
                });
            }
            if (f.this.e != null) {
                f.this.e.b(f.this.h);
            }
            f.this.h = null;
        }

        public boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.b.a(bVar, menu);
        }

        public boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.b.a(bVar, menuItem);
        }

        public boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.b.b(bVar, menu);
        }
    }

    class c extends android.support.v7.view.i {
        c(Callback callback) {
            super(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            android.support.v7.view.b.a aVar = new android.support.v7.view.f.a(f.this.a, callback);
            android.support.v7.view.b a = f.this.a(aVar);
            return a != null ? aVar.b(a) : null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return (i != 0 || (menu instanceof h)) ? super.onCreatePanelMenu(i, menu) : false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.e(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.d(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            h hVar = menu instanceof h ? (h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar != null) {
                hVar.c(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            f a = f.this.a(0, true);
            if (!(a == null || a.j == null)) {
                menu = a.j;
            }
            super.onProvideKeyboardShortcuts(list, menu, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return VERSION.SDK_INT >= 23 ? null : f.this.p() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (f.this.p() && i == 0) ? a(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    private class e extends ContentFrameLayout {
        public e(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            f.this.f(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(android.support.v7.b.a.a.b(getContext(), i));
        }
    }

    private final class g implements android.support.v7.view.menu.o.a {
        g() {
        }

        public void a(h hVar, boolean z) {
            Menu hVar2;
            Menu q = hVar2.q();
            boolean z2 = q != hVar2;
            f fVar = f.this;
            if (z2) {
                hVar2 = q;
            }
            f a = fVar.a(hVar2);
            if (a != null) {
                if (z2) {
                    f.this.a(a.a, a, q);
                    f.this.a(a, true);
                    return;
                }
                f.this.a(a, z);
            }
        }

        public boolean a(h hVar) {
            if (hVar == null && f.this.m) {
                Callback l = f.this.l();
                if (!(l == null || f.this.r)) {
                    l.onMenuOpened(108, hVar);
                }
            }
            return true;
        }
    }

    static {
        if (u && !w) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                private boolean a(Throwable th) {
                    if (!(th instanceof NotFoundException)) {
                        return false;
                    }
                    String message = th.getMessage();
                    return message != null ? message.contains("drawable") || message.contains("Drawable") : false;
                }

                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(th.getMessage());
                        stringBuilder.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        Throwable notFoundException = new NotFoundException(stringBuilder.toString());
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    f(Context context, Window window, d dVar) {
        this.a = context;
        this.b = window;
        this.e = dVar;
        this.c = this.b.getCallback();
        if (this.c instanceof c) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.d = new c(this.c);
        this.b.setCallback(this.d);
        bg a = bg.a(context, null, v);
        Drawable b = a.b(0);
        if (b != null) {
            this.b.setBackgroundDrawable(b);
        }
        a.a();
    }

    private boolean A() {
        boolean z = false;
        if (!this.N || !(this.a instanceof Activity)) {
            return false;
        }
        try {
            if ((this.a.getPackageManager().getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 512) == 0) {
                z = true;
            }
            return z;
        } catch (Throwable e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    private void a(f fVar, KeyEvent keyEvent) {
        if (!fVar.o && !this.r) {
            if (fVar.a == 0) {
                if ((this.a.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Callback l = l();
            if (l == null || l.onMenuOpened(fVar.a, fVar.j)) {
                WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
                if (windowManager != null && b(fVar, keyEvent)) {
                    int i;
                    LayoutParams layoutParams;
                    LayoutParams layoutParams2;
                    if (fVar.g == null || fVar.q) {
                        if (fVar.g == null) {
                            if (!a(fVar) || fVar.g == null) {
                                return;
                            }
                        } else if (fVar.q && fVar.g.getChildCount() > 0) {
                            fVar.g.removeAllViews();
                        }
                        if (c(fVar) && fVar.a()) {
                            layoutParams2 = fVar.h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new LayoutParams(-2, -2);
                            }
                            fVar.g.setBackgroundResource(fVar.b);
                            ViewParent parent = fVar.h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(fVar.h);
                            }
                            fVar.g.addView(fVar.h, layoutParams2);
                            if (!fVar.h.hasFocus()) {
                                fVar.h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else if (fVar.i != null) {
                        layoutParams2 = fVar.i.getLayoutParams();
                        if (layoutParams2 != null && layoutParams2.width == -1) {
                            i = -1;
                            fVar.n = false;
                            layoutParams = new WindowManager.LayoutParams(i, -2, fVar.d, fVar.e, 1002, 8519680, -3);
                            layoutParams.gravity = fVar.c;
                            layoutParams.windowAnimations = fVar.f;
                            windowManager.addView(fVar.g, layoutParams);
                            fVar.o = true;
                            return;
                        }
                    }
                    i = -2;
                    fVar.n = false;
                    layoutParams = new WindowManager.LayoutParams(i, -2, fVar.d, fVar.e, 1002, 8519680, -3);
                    layoutParams.gravity = fVar.c;
                    layoutParams.windowAnimations = fVar.f;
                    windowManager.addView(fVar.g, layoutParams);
                    fVar.o = true;
                    return;
                }
                return;
            }
            a(fVar, true);
        }
    }

    private void a(h hVar, boolean z) {
        if (this.y == null || !this.y.e() || (ViewConfiguration.get(this.a).hasPermanentMenuKey() && !this.y.g())) {
            f a = a(0, true);
            a.q = true;
            a(a, false);
            a(a, null);
            return;
        }
        Callback l = l();
        if (this.y.f() && z) {
            this.y.i();
            if (!this.r) {
                l.onPanelClosed(108, a(0, true).j);
            }
        } else if (!(l == null || this.r)) {
            if (this.s && (this.t & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.P);
                this.P.run();
            }
            f a2 = a(0, true);
            if (!(a2.j == null || a2.r || !l.onPreparePanel(0, a2.i, a2.j))) {
                l.onMenuOpened(108, a2.j);
                this.y.h();
            }
        }
    }

    private boolean a(f fVar) {
        fVar.a(m());
        fVar.g = new e(fVar.l);
        fVar.c = 81;
        return true;
    }

    private boolean a(f fVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((fVar.m || b(fVar, keyEvent)) && fVar.j != null) {
            z = fVar.j.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.y == null) {
            a(fVar, true);
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:14:0x0023, code:
            return false;
     */
    private boolean a(android.view.ViewParent r3) {
        /*
        r2 = this;
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r2 = r2.b;
        r2 = r2.getDecorView();
    L_0x000a:
        if (r3 != 0) goto L_0x000e;
    L_0x000c:
        r2 = 1;
        return r2;
    L_0x000e:
        if (r3 == r2) goto L_0x0023;
    L_0x0010:
        r1 = r3 instanceof android.view.View;
        if (r1 == 0) goto L_0x0023;
    L_0x0014:
        r1 = r3;
        r1 = (android.view.View) r1;
        r1 = android.support.v4.h.r.x(r1);
        if (r1 == 0) goto L_0x001e;
    L_0x001d:
        return r0;
    L_0x001e:
        r3 = r3.getParent();
        goto L_0x000a;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.f.a(android.view.ViewParent):boolean");
    }

    private boolean b(f fVar) {
        Context context = this.a;
        if ((fVar.a == 0 || fVar.a == 108) && this.y != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                Context dVar = new android.support.v7.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        h hVar = new h(context);
        hVar.a((android.support.v7.view.menu.h.a) this);
        fVar.a(hVar);
        return true;
    }

    private boolean b(f fVar, KeyEvent keyEvent) {
        if (this.r) {
            return false;
        }
        if (fVar.m) {
            return true;
        }
        if (!(this.K == null || this.K == fVar)) {
            a(this.K, false);
        }
        Callback l = l();
        if (l != null) {
            fVar.i = l.onCreatePanelView(fVar.a);
        }
        boolean z = fVar.a == 0 || fVar.a == 108;
        if (z && this.y != null) {
            this.y.j();
        }
        if (fVar.i == null && !(z && (k() instanceof i))) {
            if (fVar.j == null || fVar.r) {
                if (fVar.j == null && (!b(fVar) || fVar.j == null)) {
                    return false;
                }
                if (z && this.y != null) {
                    if (this.z == null) {
                        this.z = new a();
                    }
                    this.y.a(fVar.j, this.z);
                }
                fVar.j.h();
                if (l.onCreatePanelMenu(fVar.a, fVar.j)) {
                    fVar.r = false;
                } else {
                    fVar.a(null);
                    if (z && this.y != null) {
                        this.y.a(null, this.z);
                    }
                    return false;
                }
            }
            fVar.j.h();
            if (fVar.s != null) {
                fVar.j.b(fVar.s);
                fVar.s = null;
            }
            if (l.onPreparePanel(0, fVar.i, fVar.j)) {
                fVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                fVar.j.setQwertyMode(fVar.p);
                fVar.j.i();
            } else {
                if (z && this.y != null) {
                    this.y.a(null, this.z);
                }
                fVar.j.i();
                return false;
            }
        }
        fVar.m = true;
        fVar.n = false;
        this.K = fVar;
        return true;
    }

    private boolean c(f fVar) {
        if (fVar.i != null) {
            fVar.h = fVar.i;
            return true;
        } else if (fVar.j == null) {
            return false;
        } else {
            if (this.A == null) {
                this.A = new g();
            }
            fVar.h = (View) fVar.a(this.A);
            return fVar.h != null;
        }
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            f a = a(i, true);
            if (!a.o) {
                return b(a, keyEvent);
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
        r3 = this;
        r0 = r3.h;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = 1;
        r2 = r3.a(r4, r0);
        if (r4 != 0) goto L_0x0045;
    L_0x000d:
        r4 = r3.y;
        if (r4 == 0) goto L_0x0045;
    L_0x0011:
        r4 = r3.y;
        r4 = r4.e();
        if (r4 == 0) goto L_0x0045;
    L_0x0019:
        r4 = r3.a;
        r4 = android.view.ViewConfiguration.get(r4);
        r4 = r4.hasPermanentMenuKey();
        if (r4 != 0) goto L_0x0045;
    L_0x0025:
        r4 = r3.y;
        r4 = r4.f();
        if (r4 != 0) goto L_0x003e;
    L_0x002d:
        r4 = r3.r;
        if (r4 != 0) goto L_0x0065;
    L_0x0031:
        r4 = r3.b(r2, r5);
        if (r4 == 0) goto L_0x0065;
    L_0x0037:
        r4 = r3.y;
        r4 = r4.h();
        goto L_0x006c;
    L_0x003e:
        r4 = r3.y;
        r4 = r4.i();
        goto L_0x006c;
    L_0x0045:
        r4 = r2.o;
        if (r4 != 0) goto L_0x0067;
    L_0x0049:
        r4 = r2.n;
        if (r4 == 0) goto L_0x004e;
    L_0x004d:
        goto L_0x0067;
    L_0x004e:
        r4 = r2.m;
        if (r4 == 0) goto L_0x0065;
    L_0x0052:
        r4 = r2.r;
        if (r4 == 0) goto L_0x005d;
    L_0x0056:
        r2.m = r1;
        r4 = r3.b(r2, r5);
        goto L_0x005e;
    L_0x005d:
        r4 = r0;
    L_0x005e:
        if (r4 == 0) goto L_0x0065;
    L_0x0060:
        r3.a(r2, r5);
        r4 = r0;
        goto L_0x006c;
    L_0x0065:
        r4 = r1;
        goto L_0x006c;
    L_0x0067:
        r4 = r2.o;
        r3.a(r2, r0);
    L_0x006c:
        if (r4 == 0) goto L_0x0085;
    L_0x006e:
        r3 = r3.a;
        r5 = "audio";
        r3 = r3.getSystemService(r5);
        r3 = (android.media.AudioManager) r3;
        if (r3 == 0) goto L_0x007e;
    L_0x007a:
        r3.playSoundEffect(r1);
        return r4;
    L_0x007e:
        r3 = "AppCompatDelegate";
        r5 = "Couldn't get audio manager";
        android.util.Log.w(r3, r5);
    L_0x0085:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.f.e(int, android.view.KeyEvent):boolean");
    }

    private void j(int i) {
        this.t = (1 << i) | this.t;
        if (!this.s) {
            r.a(this.b.getDecorView(), this.P);
            this.s = true;
        }
    }

    private int k(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private boolean l(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        i = i == 2 ? 32 : 16;
        if (i2 == i) {
            return false;
        }
        if (A()) {
            ((Activity) this.a).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (VERSION.SDK_INT < 26) {
                h.a(resources);
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    private void t() {
        /*
        r3 = this;
        r3.u();
        r0 = r3.m;
        if (r0 == 0) goto L_0x003b;
    L_0x0007:
        r0 = r3.f;
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r0 = r3.c;
        r0 = r0 instanceof android.app.Activity;
        if (r0 == 0) goto L_0x0020;
    L_0x0012:
        r0 = new android.support.v7.app.l;
        r1 = r3.c;
        r1 = (android.app.Activity) r1;
        r2 = r3.n;
        r0.<init>(r1, r2);
    L_0x001d:
        r3.f = r0;
        goto L_0x0030;
    L_0x0020:
        r0 = r3.c;
        r0 = r0 instanceof android.app.Dialog;
        if (r0 == 0) goto L_0x0030;
    L_0x0026:
        r0 = new android.support.v7.app.l;
        r1 = r3.c;
        r1 = (android.app.Dialog) r1;
        r0.<init>(r1);
        goto L_0x001d;
    L_0x0030:
        r0 = r3.f;
        if (r0 == 0) goto L_0x003b;
    L_0x0034:
        r0 = r3.f;
        r3 = r3.Q;
        r0.c(r3);
    L_0x003b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.f.t():void");
    }

    private void u() {
        if (!this.C) {
            this.D = v();
            CharSequence n = n();
            if (!TextUtils.isEmpty(n)) {
                if (this.y != null) {
                    this.y.setWindowTitle(n);
                } else if (k() != null) {
                    k().a(n);
                } else if (this.E != null) {
                    this.E.setText(n);
                }
            }
            w();
            a(this.D);
            this.C = true;
            f a = a(0, false);
            if (!this.r) {
                if (a == null || a.j == null) {
                    j(108);
                }
            }
        }
    }

    private ViewGroup v() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowNoTitle, false)) {
                c(1);
            } else if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionBar, false)) {
                c(108);
            }
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionBarOverlay, false)) {
                c(109);
            }
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionModeOverlay, false)) {
                c(10);
            }
            this.p = obtainStyledAttributes.getBoolean(j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.q) {
                view = (ViewGroup) from.inflate(this.o ? android.support.v7.a.a.g.abc_screen_simple_overlay_action_mode : android.support.v7.a.a.g.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    r.a(view, new android.support.v4.h.p() {
                        public z a(View view, z zVar) {
                            int b = zVar.b();
                            int h = f.this.h(b);
                            if (b != h) {
                                zVar = zVar.a(zVar.a(), h, zVar.c(), zVar.d());
                            }
                            return r.a(view, zVar);
                        }
                    });
                } else {
                    ((aj) view).setOnFitSystemWindowsListener(new android.support.v7.widget.aj.a() {
                        public void a(Rect rect) {
                            rect.top = f.this.h(rect.top);
                        }
                    });
                }
            } else if (this.p) {
                view = (ViewGroup) from.inflate(android.support.v7.a.a.g.abc_dialog_title_material, null);
                this.n = false;
                this.m = false;
            } else if (this.m) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                view = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.a, typedValue.resourceId) : this.a).inflate(android.support.v7.a.a.g.abc_screen_toolbar, null);
                this.y = (ad) view.findViewById(android.support.v7.a.a.f.decor_content_parent);
                this.y.setWindowCallback(l());
                if (this.n) {
                    this.y.a(109);
                }
                if (this.G) {
                    this.y.a(2);
                }
                if (this.H) {
                    this.y.a(5);
                }
            } else {
                view = null;
            }
            if (view == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AppCompat does not support the current theme features: { windowActionBar: ");
                stringBuilder.append(this.m);
                stringBuilder.append(", windowActionBarOverlay: ");
                stringBuilder.append(this.n);
                stringBuilder.append(", android:windowIsFloating: ");
                stringBuilder.append(this.p);
                stringBuilder.append(", windowActionModeOverlay: ");
                stringBuilder.append(this.o);
                stringBuilder.append(", windowNoTitle: ");
                stringBuilder.append(this.q);
                stringBuilder.append(" }");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (this.y == null) {
                this.E = (TextView) view.findViewById(android.support.v7.a.a.f.title);
            }
            bo.b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(android.support.v7.a.a.f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new android.support.v7.widget.ContentFrameLayout.a() {
                public void a() {
                }

                public void b() {
                    f.this.s();
                }
            });
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void w() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.D.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(j.AppCompatTheme);
        obtainStyledAttributes.getValue(j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void x() {
        if (this.C) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int y() {
        return this.M != -100 ? this.M : e.j();
    }

    private void z() {
        if (this.O == null) {
            this.O = new d(k.a(this.a));
        }
    }

    public a a() {
        t();
        return this.f;
    }

    protected f a(int i, boolean z) {
        Object obj = this.J;
        if (obj == null || obj.length <= i) {
            Object obj2 = new f[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.J = obj2;
            obj = obj2;
        }
        f fVar = obj[i];
        if (fVar != null) {
            return fVar;
        }
        fVar = new f(i);
        obj[i] = fVar;
        return fVar;
    }

    f a(Menu menu) {
        f[] fVarArr = this.J;
        int i = 0;
        int length = fVarArr != null ? fVarArr.length : 0;
        while (i < length) {
            f fVar = fVarArr[i];
            if (fVar != null && fVar.j == menu) {
                return fVar;
            }
            i++;
        }
        return null;
    }

    public android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.h != null) {
            this.h.c();
        }
        android.support.v7.view.b.a bVar = new b(aVar);
        a a = a();
        if (a != null) {
            this.h = a.a(bVar);
            if (!(this.h == null || this.e == null)) {
                this.e.a(this.h);
            }
        }
        if (this.h == null) {
            this.h = b(bVar);
        }
        return this.h;
    }

    public <T extends View> T a(int i) {
        u();
        return this.b.findViewById(i);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = false;
        if (this.T == null) {
            AppCompatViewInflater appCompatViewInflater;
            String string = this.a.obtainStyledAttributes(j.AppCompatTheme).getString(j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.T = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to instantiate custom view inflater ");
                    stringBuilder.append(string);
                    stringBuilder.append(". Falling back to default.");
                    Log.i("AppCompatDelegate", stringBuilder.toString(), th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.T = appCompatViewInflater;
        }
        if (u) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z = true;
            }
        }
        return this.T.a(view, str, context, attributeSet, z, u, true, bl.a());
    }

    void a(int i, f fVar, Menu menu) {
        if (menu == null) {
            if (fVar == null && i >= 0 && i < this.J.length) {
                fVar = this.J[i];
            }
            if (fVar != null) {
                menu = fVar.j;
            }
        }
        if ((fVar == null || fVar.o) && !this.r) {
            this.c.onPanelClosed(i, menu);
        }
    }

    public void a(Configuration configuration) {
        if (this.m && this.C) {
            a a = a();
            if (a != null) {
                a.a(configuration);
            }
        }
        l.a().a(this.a);
        i();
    }

    public void a(Bundle bundle) {
        if (this.c instanceof Activity) {
            String str = null;
            try {
                str = u.b((Activity) this.c);
            } catch (IllegalArgumentException unused) {
                if (str != null) {
                    a k = k();
                    if (k == null) {
                        this.Q = true;
                    } else {
                        k.c(true);
                    }
                }
            }
        }
        if (bundle != null && this.M == -100) {
            this.M = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    void a(f fVar, boolean z) {
        if (z && fVar.a == 0 && this.y != null && this.y.f()) {
            b(fVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !fVar.o || fVar.g == null)) {
            windowManager.removeView(fVar.g);
            if (z) {
                a(fVar.a, fVar, null);
            }
        }
        fVar.m = false;
        fVar.n = false;
        fVar.o = false;
        fVar.h = null;
        fVar.q = true;
        if (this.K == fVar) {
            this.K = null;
        }
    }

    public void a(h hVar) {
        a(hVar, true);
    }

    public void a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            a a = a();
            if (a instanceof l) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            Window window;
            Callback h;
            this.g = null;
            if (a != null) {
                a.g();
            }
            if (toolbar != null) {
                a = new i(toolbar, ((Activity) this.c).getTitle(), this.d);
                this.f = a;
                window = this.b;
                h = a.h();
            } else {
                this.f = null;
                window = this.b;
                h = this.d;
            }
            window.setCallback(h);
            f();
        }
    }

    public void a(View view) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void a(View view, LayoutParams layoutParams) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void a(ViewGroup viewGroup) {
    }

    public final void a(CharSequence charSequence) {
        this.x = charSequence;
        if (this.y != null) {
            this.y.setWindowTitle(charSequence);
        } else if (k() != null) {
            k().a(charSequence);
        } else {
            if (this.E != null) {
                this.E.setText(charSequence);
            }
        }
    }

    boolean a(int i, KeyEvent keyEvent) {
        a a = a();
        if (a != null && a.a(i, keyEvent)) {
            return true;
        }
        if (this.K == null || !a(this.K, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.K == null) {
                f a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        if (this.K != null) {
            this.K.n = true;
        }
        return true;
    }

    public boolean a(h hVar, MenuItem menuItem) {
        Callback l = l();
        if (!(l == null || this.r)) {
            f a = a(hVar.q());
            if (a != null) {
                return l.onMenuItemSelected(a.a, menuItem);
            }
        }
        return false;
    }

    boolean a(KeyEvent keyEvent) {
        boolean z = true;
        if ((this.c instanceof android.support.v4.h.e.a) || (this.c instanceof g)) {
            View decorView = this.b.getDecorView();
            if (decorView != null && android.support.v4.h.e.a(decorView, keyEvent)) {
                return true;
            }
        }
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    android.support.v7.view.b b(android.support.v7.view.b.a aVar) {
        q();
        if (this.h != null) {
            this.h.c();
        }
        if (!(aVar instanceof b)) {
            aVar = new b(aVar);
        }
        if (!(this.e == null || this.r)) {
            android.support.v7.view.b a;
            try {
                a = this.e.a(aVar);
            } catch (AbstractMethodError unused) {
                a = null;
            }
            if (a != null) {
                this.h = a;
            } else {
                Context dVar;
                boolean z = true;
                if (this.i == null) {
                    if (this.p) {
                        TypedValue typedValue = new TypedValue();
                        Theme theme = this.a.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Theme newTheme = this.a.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            dVar = new android.support.v7.view.d(this.a, 0);
                            dVar.getTheme().setTo(newTheme);
                        } else {
                            dVar = this.a;
                        }
                        this.i = new ActionBarContextView(dVar);
                        this.j = new PopupWindow(dVar, null, android.support.v7.a.a.a.actionModePopupWindowStyle);
                        k.a(this.j, 2);
                        this.j.setContentView(this.i);
                        this.j.setWidth(-1);
                        dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                        this.i.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                        this.j.setHeight(-2);
                        this.k = new Runnable() {
                            public void run() {
                                f.this.j.showAtLocation(f.this.i, 55, 0, 0);
                                f.this.q();
                                if (f.this.o()) {
                                    f.this.i.setAlpha(0.0f);
                                    f.this.l = r.j(f.this.i).a(1.0f);
                                    f.this.l.a(new x() {
                                        public void a(View view) {
                                            f.this.i.setVisibility(0);
                                        }

                                        public void b(View view) {
                                            f.this.i.setAlpha(1.0f);
                                            f.this.l.a(null);
                                            f.this.l = null;
                                        }
                                    });
                                    return;
                                }
                                f.this.i.setAlpha(1.0f);
                                f.this.i.setVisibility(0);
                            }
                        };
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.D.findViewById(android.support.v7.a.a.f.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(m()));
                            this.i = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.i != null) {
                    q();
                    this.i.c();
                    dVar = this.i.getContext();
                    ActionBarContextView actionBarContextView = this.i;
                    if (this.j != null) {
                        z = false;
                    }
                    a = new android.support.v7.view.e(dVar, actionBarContextView, aVar, z);
                    if (aVar.a(a, a.b())) {
                        a.d();
                        this.i.a(a);
                        this.h = a;
                        if (o()) {
                            this.i.setAlpha(0.0f);
                            this.l = r.j(this.i).a(1.0f);
                            this.l.a(new x() {
                                public void a(View view) {
                                    f.this.i.setVisibility(0);
                                    f.this.i.sendAccessibilityEvent(32);
                                    if (f.this.i.getParent() instanceof View) {
                                        r.m((View) f.this.i.getParent());
                                    }
                                }

                                public void b(View view) {
                                    f.this.i.setAlpha(1.0f);
                                    f.this.l.a(null);
                                    f.this.l = null;
                                }
                            });
                        } else {
                            this.i.setAlpha(1.0f);
                            this.i.setVisibility(0);
                            this.i.sendAccessibilityEvent(32);
                            if (this.i.getParent() instanceof View) {
                                r.m((View) this.i.getParent());
                            }
                        }
                        if (this.j != null) {
                            this.b.getDecorView().post(this.k);
                        }
                    } else {
                        this.h = null;
                    }
                }
            }
            if (!(this.h == null || this.e == null)) {
                this.e.a(this.h);
            }
            return this.h;
        }
    }

    public MenuInflater b() {
        if (this.g == null) {
            t();
            this.g = new android.support.v7.view.g(this.f != null ? this.f.b() : this.a);
        }
        return this.g;
    }

    public void b(int i) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void b(Bundle bundle) {
        u();
    }

    void b(h hVar) {
        if (!this.I) {
            this.I = true;
            this.y.k();
            Callback l = l();
            if (!(l == null || this.r)) {
                l.onPanelClosed(108, hVar);
            }
            this.I = false;
        }
    }

    public void b(View view, LayoutParams layoutParams) {
        u();
        ((ViewGroup) this.D.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    boolean b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.L;
            this.L = false;
            f a = a(0, false);
            if (a == null || !a.o) {
                return r();
            } else {
                if (!z) {
                    a(a, true);
                }
                return true;
            }
        } else if (i != 82) {
            return false;
        } else {
            e(0, keyEvent);
            return true;
        }
    }

    public void c() {
        i();
    }

    public void c(Bundle bundle) {
        if (this.M != -100) {
            bundle.putInt("appcompat:local_night_mode", this.M);
        }
    }

    public boolean c(int i) {
        i = k(i);
        if (this.q && i == 108) {
            return false;
        }
        if (this.m && i == 1) {
            this.m = false;
        }
        switch (i) {
            case 1:
                x();
                this.q = true;
                return true;
            case 2:
                x();
                this.G = true;
                return true;
            case 5:
                x();
                this.H = true;
                return true;
            case 10:
                x();
                this.o = true;
                return true;
            case 108:
                x();
                this.m = true;
                return true;
            case 109:
                x();
                this.n = true;
                return true;
            default:
                return this.b.requestFeature(i);
        }
    }

    boolean c(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.L = z;
            return false;
        } else if (i != 82) {
            return false;
        } else {
            d(0, keyEvent);
            return true;
        }
    }

    public void d() {
        a a = a();
        if (a != null) {
            a.d(false);
        }
        if (this.O != null) {
            this.O.d();
        }
    }

    void d(int i) {
        if (i == 108) {
            a a = a();
            if (a != null) {
                a.e(false);
            }
        } else if (i == 0) {
            f a2 = a(i, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    public void e() {
        a a = a();
        if (a != null) {
            a.d(true);
        }
    }

    void e(int i) {
        if (i == 108) {
            a a = a();
            if (a != null) {
                a.e(true);
            }
        }
    }

    public void f() {
        a a = a();
        if (a == null || !a.e()) {
            j(0);
        }
    }

    void f(int i) {
        a(a(i, true), true);
    }

    public void g() {
        if (this.s) {
            this.b.getDecorView().removeCallbacks(this.P);
        }
        this.r = true;
        if (this.f != null) {
            this.f.g();
        }
        if (this.O != null) {
            this.O.d();
        }
    }

    void g(int i) {
        f a = a(i, true);
        if (a.j != null) {
            Bundle bundle = new Bundle();
            a.j.a(bundle);
            if (bundle.size() > 0) {
                a.s = bundle;
            }
            a.j.h();
            a.j.clear();
        }
        a.r = true;
        a.q = true;
        if ((i == 108 || i == 0) && this.y != null) {
            f a2 = a(0, false);
            if (a2 != null) {
                a2.m = false;
                b(a2, null);
            }
        }
    }

    int h(int i) {
        int i2;
        int i3 = 0;
        if (this.i == null || !(this.i.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i4;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.i.getLayoutParams();
            i2 = 1;
            if (this.i.isShown()) {
                if (this.R == null) {
                    this.R = new Rect();
                    this.S = new Rect();
                }
                Rect rect = this.R;
                Rect rect2 = this.S;
                rect.set(0, i, 0, 0);
                bo.a(this.D, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.F == null) {
                        this.F = new View(this.a);
                        this.F.setBackgroundColor(this.a.getResources().getColor(android.support.v7.a.a.c.abc_input_method_navigation_guard));
                        this.D.addView(this.F, -1, new LayoutParams(-1, i));
                    } else {
                        LayoutParams layoutParams = this.F.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.F.setLayoutParams(layoutParams);
                        }
                    }
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                if (this.F == null) {
                    i2 = 0;
                }
                if (!(this.o || r3 == 0)) {
                    i = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i4 = 1;
                i2 = 0;
            } else {
                i4 = 0;
                i2 = i4;
            }
            if (i4 != 0) {
                this.i.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.F != null) {
            View view = this.F;
            if (i2 == 0) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        return i;
    }

    public void h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            android.support.v4.h.f.a(from, this);
            return;
        }
        if (!(from.getFactory2() instanceof f)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    int i(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        if (VERSION.SDK_INT >= 23 && ((UiModeManager) this.a.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        z();
        return this.O.a();
    }

    public boolean i() {
        int y = y();
        int i = i(y);
        boolean l = i != -1 ? l(i) : false;
        if (y == 0) {
            z();
            this.O.c();
        }
        this.N = true;
        return l;
    }

    final a k() {
        return this.f;
    }

    final Callback l() {
        return this.b.getCallback();
    }

    final Context m() {
        a a = a();
        Context b = a != null ? a.b() : null;
        return b == null ? this.a : b;
    }

    final CharSequence n() {
        return this.c instanceof Activity ? ((Activity) this.c).getTitle() : this.x;
    }

    final boolean o() {
        return this.C && this.D != null && r.u(this.D);
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public boolean p() {
        return this.B;
    }

    void q() {
        if (this.l != null) {
            this.l.b();
        }
    }

    boolean r() {
        if (this.h != null) {
            this.h.c();
            return true;
        }
        a a = a();
        return a != null && a.f();
    }

    void s() {
        if (this.y != null) {
            this.y.k();
        }
        if (this.j != null) {
            this.b.getDecorView().removeCallbacks(this.k);
            if (this.j.isShowing()) {
                try {
                    this.j.dismiss();
                } catch (IllegalArgumentException unused) {
                    this.j = null;
                }
            }
        }
        q();
        f a = a(0, false);
        if (a != null && a.j != null) {
            a.j.close();
        }
    }
}
