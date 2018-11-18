package android.support.v7.widget;

import android.support.v4.h.r;
import android.support.v4.h.s;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

class bj implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
    private static bj j;
    private static bj k;
    private final View a;
    private final CharSequence b;
    private final int c;
    private final Runnable d = new Runnable() {
        public void run() {
            bj.this.a(false);
        }
    };
    private final Runnable e = new Runnable() {
        public void run() {
            bj.this.a();
        }
    };
    private int f;
    private int g;
    private bk h;
    private boolean i;

    private bj(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.c = s.a(ViewConfiguration.get(this.a.getContext()));
        d();
        this.a.setOnLongClickListener(this);
        this.a.setOnHoverListener(this);
    }

    private static void a(bj bjVar) {
        if (j != null) {
            j.c();
        }
        j = bjVar;
        if (j != null) {
            j.b();
        }
    }

    public static void a(View view, CharSequence charSequence) {
        if (j != null && j.a == view) {
            a(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (k != null && k.a == view) {
                k.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        bj bjVar = new bj(view, charSequence);
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f) <= this.c && Math.abs(y - this.g) <= this.c) {
            return false;
        }
        this.f = x;
        this.g = y;
        return true;
    }

    private void b() {
        this.a.postDelayed(this.d, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.a.removeCallbacks(this.d);
    }

    private void d() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }

    void a() {
        if (k == this) {
            k = null;
            if (this.h != null) {
                this.h.a();
                this.h = null;
                d();
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a(null);
        }
        this.a.removeCallbacks(this.e);
    }

    void a(boolean z) {
        if (r.x(this.a)) {
            long j;
            a(null);
            if (k != null) {
                k.a();
            }
            k = this;
            this.i = z;
            this.h = new bk(this.a.getContext());
            this.h.a(this.a, this.f, this.g, this.i, this.b);
            this.a.addOnAttachStateChangeListener(this);
            if (this.i) {
                j = 2500;
            } else {
                j = ((r.l(this.a) & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.a.removeCallbacks(this.e);
            this.a.postDelayed(this.e, j);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7) {
            if (this.a.isEnabled() && this.h == null && a(motionEvent)) {
                a(this);
            }
            return false;
        } else if (action != 10) {
            return false;
        } else {
            d();
            a();
            return false;
        }
    }

    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
