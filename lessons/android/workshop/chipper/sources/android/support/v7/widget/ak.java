package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ak implements OnAttachStateChangeListener, OnTouchListener {
    private final float a;
    private final int b;
    final View c;
    private final int d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = ak.this.c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            ak.this.d();
        }
    }

    public ak(View view) {
        this.c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.d = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.h = motionEvent.getPointerId(0);
                if (this.e == null) {
                    this.e = new a();
                }
                view.postDelayed(this.e, (long) this.b);
                if (this.f == null) {
                    this.f = new b();
                }
                view.postDelayed(this.f, (long) this.d);
                break;
            case 1:
            case 3:
                e();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.h);
                if (findPointerIndex >= 0 && !a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.a)) {
                    e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            default:
                return false;
        }
        return false;
    }

    private static boolean a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    /* JADX WARNING: Missing block: B:21:0x0046, code:
            return false;
     */
    private boolean b(android.view.MotionEvent r5) {
        /*
        r4 = this;
        r0 = r4.c;
        r1 = r4.a();
        r2 = 0;
        if (r1 == 0) goto L_0x0046;
    L_0x0009:
        r3 = r1.d();
        if (r3 != 0) goto L_0x0010;
    L_0x000f:
        return r2;
    L_0x0010:
        r1 = r1.e();
        r1 = (android.support.v7.widget.ah) r1;
        if (r1 == 0) goto L_0x0046;
    L_0x0018:
        r3 = r1.isShown();
        if (r3 != 0) goto L_0x001f;
    L_0x001e:
        return r2;
    L_0x001f:
        r3 = android.view.MotionEvent.obtainNoHistory(r5);
        r4.b(r0, r3);
        r4.a(r1, r3);
        r4 = r4.h;
        r4 = r1.a(r3, r4);
        r3.recycle();
        r5 = r5.getActionMasked();
        r0 = 1;
        if (r5 == r0) goto L_0x003e;
    L_0x0039:
        r1 = 3;
        if (r5 == r1) goto L_0x003e;
    L_0x003c:
        r5 = r0;
        goto L_0x003f;
    L_0x003e:
        r5 = r2;
    L_0x003f:
        if (r4 == 0) goto L_0x0044;
    L_0x0041:
        if (r5 == 0) goto L_0x0044;
    L_0x0043:
        return r0;
    L_0x0044:
        r0 = r2;
        return r0;
    L_0x0046:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ak.b(android.view.MotionEvent):boolean");
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private void e() {
        if (this.f != null) {
            this.c.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    public abstract s a();

    protected boolean b() {
        s a = a();
        if (!(a == null || a.d())) {
            a.a();
        }
        return true;
    }

    protected boolean c() {
        s a = a();
        if (a != null && a.d()) {
            a.c();
        }
        return true;
    }

    void d() {
        e();
        View view = this.c;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        boolean z3 = true;
        if (z2) {
            z = b(motionEvent) || !c();
        } else {
            z = a(motionEvent) && b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.c.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.g = z;
        if (!z) {
            if (z2) {
                return true;
            }
            z3 = false;
        }
        return z3;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        if (this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }
}
