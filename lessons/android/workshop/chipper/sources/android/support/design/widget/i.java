package android.support.design.widget;

import android.content.Context;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class i<V extends View> extends q<V> {
    OverScroller a;
    private Runnable b;
    private boolean c;
    private int d = -1;
    private int e;
    private int f = -1;
    private VelocityTracker g;

    private class a implements Runnable {
        private final CoordinatorLayout b;
        private final V c;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.b = coordinatorLayout;
            this.c = v;
        }

        public void run() {
            if (!(this.c == null || i.this.a == null)) {
                if (i.this.a.computeScrollOffset()) {
                    i.this.a_(this.b, this.c, i.this.a.getCurrY());
                    r.a(this.c, (Runnable) this);
                    return;
                }
                i.this.a(this.b, this.c);
            }
        }
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d() {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    int a() {
        return b();
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b = b();
        if (i2 != 0 && b >= i2 && b <= i3) {
            int a = android.support.v4.c.a.a(i, i2, i3);
            if (b != a) {
                a(a);
                return b - a;
            }
        }
        return 0;
    }

    int a(V v) {
        return v.getHeight();
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        View view = v;
        if (this.b != null) {
            view.removeCallbacks(this.b);
            this.b = null;
        }
        if (this.a == null) {
            this.a = new OverScroller(view.getContext());
        }
        this.a.fling(0, b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.a.computeScrollOffset()) {
            this.b = new a(coordinatorLayout, view);
            r.a(view, this.b);
            return true;
        }
        a(coordinatorLayout, view);
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.c) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (c(v) && coordinatorLayout.a((View) v, x, y)) {
                    this.e = y;
                    this.d = motionEvent.getPointerId(0);
                    d();
                    break;
                }
            case 1:
            case 3:
                this.c = false;
                this.d = -1;
                if (this.g != null) {
                    this.g.recycle();
                    this.g = null;
                    break;
                }
                break;
            case 2:
                int i = this.d;
                if (i != -1) {
                    i = motionEvent.findPointerIndex(i);
                    if (i != -1) {
                        i = (int) motionEvent.getY(i);
                        if (Math.abs(i - this.e) > this.f) {
                            this.c = true;
                            this.e = i;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return this.c;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, (View) v, a() - i, i2, i3);
    }

    int b(V v) {
        return -v.getHeight();
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                y = (int) motionEvent.getY();
                if (coordinatorLayout.a((View) v, (int) motionEvent.getX(), y) && c(v)) {
                    this.e = y;
                    this.d = motionEvent.getPointerId(0);
                    d();
                    break;
                }
                return false;
            case 1:
                if (this.g != null) {
                    this.g.addMovement(motionEvent);
                    this.g.computeCurrentVelocity(1000);
                    a(coordinatorLayout, (View) v, -a(v), 0, this.g.getYVelocity(this.d));
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.d);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                    y = this.e - findPointerIndex;
                    if (!this.c && Math.abs(y) > this.f) {
                        this.c = true;
                        y = y > 0 ? y - this.f : y + this.f;
                    }
                    int i = y;
                    if (this.c) {
                        this.e = findPointerIndex;
                        b(coordinatorLayout, v, i, b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.c = false;
        this.d = -1;
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return true;
    }

    boolean c(V v) {
        return false;
    }
}
