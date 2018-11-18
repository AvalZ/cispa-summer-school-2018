package android.support.v4.widget;

import android.content.Context;
import android.support.v4.h.r;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public class q {
    private static final Interpolator v = new Interpolator() {
        public float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }
    };
    private int a;
    private int b;
    private int c = -1;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private OverScroller q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new Runnable() {
        public void run() {
            q.this.b(0);
        }
    };

    public static abstract class a {
        public int a(View view) {
            return 0;
        }

        public int a(View view, int i, int i2) {
            return 0;
        }

        public void a(int i) {
        }

        public void a(int i, int i2) {
        }

        public void a(View view, float f, float f2) {
        }

        public void a(View view, int i, int i2, int i3, int i4) {
        }

        public abstract boolean a(View view, int i);

        public int b(View view) {
            return 0;
        }

        public int b(View view, int i, int i2) {
            return 0;
        }

        public void b(int i, int i2) {
        }

        public void b(View view, int i) {
        }

        public boolean b(int i) {
            return false;
        }

        public int c(int i) {
            return i;
        }
    }

    private q(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.u = viewGroup;
            this.r = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = new OverScroller(context, v);
        }
    }

    private float a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f = (float) (width / 2);
        f += a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f;
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(f / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        i3 = b(i3, (int) this.n, (int) this.m);
        i4 = b(i4, (int) this.n, (int) this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i3);
        int abs4 = Math.abs(i4);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (i3 != 0) {
            f = (float) abs3;
            f2 = (float) i5;
        } else {
            f = (float) abs;
            f2 = (float) i6;
        }
        f /= f2;
        if (i4 != 0) {
            f3 = (float) abs4;
            f2 = (float) i5;
        } else {
            f3 = (float) abs2;
            f2 = (float) i6;
        }
        f3 /= f2;
        return (int) ((((float) a(i, i3, this.r.b(view))) * f) + (((float) a(i2, i4, this.r.a(view))) * f3));
    }

    public static q a(ViewGroup viewGroup, float f, a aVar) {
        q a = a(viewGroup, aVar);
        a.b = (int) (((float) a.b) * (1.0f / f));
        return a;
    }

    public static q a(ViewGroup viewGroup, a aVar) {
        return new q(viewGroup.getContext(), viewGroup, aVar);
    }

    private void a(float f, float f2) {
        this.t = true;
        this.r.a(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            b(0);
        }
    }

    private void a(float f, float f2, int i) {
        d(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        fArr = this.e;
        this.g[i] = f2;
        fArr[i] = f2;
        this.h[i] = d((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private boolean a(float f, float f2, int i, int i2) {
        f = Math.abs(f);
        f2 = Math.abs(f2);
        boolean z = false;
        if (!((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2)) {
            if (f <= ((float) this.b) && f2 <= ((float) this.b)) {
                return false;
            }
            if (f < f2 * 0.5f && this.r.b(i2)) {
                int[] iArr = this.j;
                iArr[i] = iArr[i] | i2;
                return false;
            } else if ((this.i[i] & i2) == 0 && f > ((float) this.b)) {
                z = true;
            }
        }
        return z;
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        i -= left;
        i2 -= top;
        if (i == 0 && i2 == 0) {
            this.q.abortAnimation();
            b(0);
            return false;
        }
        this.q.startScroll(left, top, i, i2, a(this.s, i, i2, i3, i4));
        b(2);
        return true;
    }

    private boolean a(View view, float f, float f2) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        boolean z2 = this.r.b(view) > 0;
        boolean z3 = this.r.a(view) > 0;
        if (z2 && z3) {
            if ((f * f) + (f2 * f2) > ((float) (this.b * this.b))) {
                z = true;
            }
            return z;
        } else if (z2) {
            if (Math.abs(f) > ((float) this.b)) {
                z = true;
            }
            return z;
        } else {
            if (z3 && Math.abs(f2) > ((float) this.b)) {
                z = true;
            }
            return z;
        }
    }

    private int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.b(i2, i);
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            i = this.r.b(this.s, i, i3);
            r.d(this.s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.r.a(this.s, i2, i4);
            r.c(this.s, i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.r.a(this.s, i5, i6, i5 - left, i6 - top);
        }
    }

    private void c() {
        if (this.d != null) {
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
    }

    private void c(int i) {
        if (this.d != null && a(i)) {
            this.d[i] = 0.0f;
            this.e[i] = 0.0f;
            this.f[i] = 0.0f;
            this.g[i] = 0.0f;
            this.h[i] = 0;
            this.i[i] = 0;
            this.j[i] = 0;
            this.k = (~(1 << i)) & this.k;
        }
    }

    private void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (e(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }

    private int d(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }

    private void d() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.c), this.n, this.m), a(this.l.getYVelocity(this.c), this.n, this.m));
    }

    private void d(int i) {
        if (this.d == null || this.d.length <= i) {
            i++;
            Object obj = new float[i];
            Object obj2 = new float[i];
            Object obj3 = new float[i];
            Object obj4 = new float[i];
            Object obj5 = new int[i];
            Object obj6 = new int[i];
            Object obj7 = new int[i];
            if (this.d != null) {
                System.arraycopy(this.d, 0, obj, 0, this.d.length);
                System.arraycopy(this.e, 0, obj2, 0, this.e.length);
                System.arraycopy(this.f, 0, obj3, 0, this.f.length);
                System.arraycopy(this.g, 0, obj4, 0, this.g.length);
                System.arraycopy(this.h, 0, obj5, 0, this.h.length);
                System.arraycopy(this.i, 0, obj6, 0, this.i.length);
                System.arraycopy(this.j, 0, obj7, 0, this.j.length);
            }
            this.d = obj;
            this.e = obj2;
            this.f = obj3;
            this.g = obj4;
            this.h = obj5;
            this.i = obj6;
            this.j = obj7;
        }
    }

    private boolean e(int i) {
        if (a(i)) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ignoring pointerId=");
        stringBuilder.append(i);
        stringBuilder.append(" because ACTION_DOWN was not received ");
        stringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
        stringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
        Log.e("ViewDragHelper", stringBuilder.toString());
        return false;
    }

    public int a() {
        return this.b;
    }

    public void a(View view, int i) {
        if (view.getParent() != this.u) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
            stringBuilder.append(this.u);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.s = view;
        this.c = i;
        this.r.b(view, i);
        b(1);
    }

    public boolean a(int i) {
        return (this.k & (1 << i)) != 0;
    }

    public boolean a(int i, int i2) {
        if (this.t) {
            return a(i, i2, (int) this.l.getXVelocity(this.c), (int) this.l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Missing block: B:38:0x00d4, code:
            if (r12 != r11) goto L_0x00dd;
     */
    public boolean a(android.view.MotionEvent r18) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r18.getActionMasked();
        r3 = r18.getActionIndex();
        if (r2 != 0) goto L_0x0011;
    L_0x000e:
        r17.b();
    L_0x0011:
        r4 = r0.l;
        if (r4 != 0) goto L_0x001b;
    L_0x0015:
        r4 = android.view.VelocityTracker.obtain();
        r0.l = r4;
    L_0x001b:
        r4 = r0.l;
        r4.addMovement(r1);
        r4 = 2;
        r6 = 1;
        switch(r2) {
            case 0: goto L_0x00fb;
            case 1: goto L_0x00f6;
            case 2: goto L_0x0067;
            case 3: goto L_0x00f6;
            case 4: goto L_0x0025;
            case 5: goto L_0x0030;
            case 6: goto L_0x0028;
            default: goto L_0x0025;
        };
    L_0x0025:
        r5 = 0;
        goto L_0x012d;
    L_0x0028:
        r1 = r1.getPointerId(r3);
        r0.c(r1);
        goto L_0x0025;
    L_0x0030:
        r2 = r1.getPointerId(r3);
        r7 = r1.getX(r3);
        r1 = r1.getY(r3);
        r0.a(r7, r1, r2);
        r3 = r0.a;
        if (r3 != 0) goto L_0x0055;
    L_0x0043:
        r1 = r0.h;
        r1 = r1[r2];
        r3 = r0.p;
        r3 = r3 & r1;
        if (r3 == 0) goto L_0x0025;
    L_0x004c:
        r3 = r0.r;
        r4 = r0.p;
        r1 = r1 & r4;
        r3.a(r1, r2);
        goto L_0x0025;
    L_0x0055:
        r3 = r0.a;
        if (r3 != r4) goto L_0x0025;
    L_0x0059:
        r3 = (int) r7;
        r1 = (int) r1;
        r1 = r0.c(r3, r1);
        r3 = r0.s;
        if (r1 != r3) goto L_0x0025;
    L_0x0063:
        r0.b(r1, r2);
        goto L_0x0025;
    L_0x0067:
        r2 = r0.d;
        if (r2 == 0) goto L_0x0025;
    L_0x006b:
        r2 = r0.e;
        if (r2 != 0) goto L_0x0070;
    L_0x006f:
        goto L_0x0025;
    L_0x0070:
        r2 = r18.getPointerCount();
        r3 = 0;
    L_0x0075:
        if (r3 >= r2) goto L_0x00f1;
    L_0x0077:
        r4 = r1.getPointerId(r3);
        r7 = r0.e(r4);
        if (r7 != 0) goto L_0x0083;
    L_0x0081:
        goto L_0x00ee;
    L_0x0083:
        r7 = r1.getX(r3);
        r8 = r1.getY(r3);
        r9 = r0.d;
        r9 = r9[r4];
        r9 = r7 - r9;
        r10 = r0.e;
        r10 = r10[r4];
        r10 = r8 - r10;
        r7 = (int) r7;
        r8 = (int) r8;
        r7 = r0.c(r7, r8);
        if (r7 == 0) goto L_0x00a7;
    L_0x009f:
        r8 = r0.a(r7, r9, r10);
        if (r8 == 0) goto L_0x00a7;
    L_0x00a5:
        r8 = r6;
        goto L_0x00a8;
    L_0x00a7:
        r8 = 0;
    L_0x00a8:
        if (r8 == 0) goto L_0x00dd;
    L_0x00aa:
        r11 = r7.getLeft();
        r12 = (int) r9;
        r13 = r11 + r12;
        r14 = r0.r;
        r12 = r14.b(r7, r13, r12);
        r13 = r7.getTop();
        r14 = (int) r10;
        r15 = r13 + r14;
        r5 = r0.r;
        r5 = r5.a(r7, r15, r14);
        r14 = r0.r;
        r14 = r14.b(r7);
        r15 = r0.r;
        r15 = r15.a(r7);
        if (r14 == 0) goto L_0x00d6;
    L_0x00d2:
        if (r14 <= 0) goto L_0x00dd;
    L_0x00d4:
        if (r12 != r11) goto L_0x00dd;
    L_0x00d6:
        if (r15 == 0) goto L_0x00f1;
    L_0x00d8:
        if (r15 <= 0) goto L_0x00dd;
    L_0x00da:
        if (r5 != r13) goto L_0x00dd;
    L_0x00dc:
        goto L_0x00f1;
    L_0x00dd:
        r0.b(r9, r10, r4);
        r5 = r0.a;
        if (r5 != r6) goto L_0x00e5;
    L_0x00e4:
        goto L_0x00f1;
    L_0x00e5:
        if (r8 == 0) goto L_0x00ee;
    L_0x00e7:
        r4 = r0.b(r7, r4);
        if (r4 == 0) goto L_0x00ee;
    L_0x00ed:
        goto L_0x00f1;
    L_0x00ee:
        r3 = r3 + 1;
        goto L_0x0075;
    L_0x00f1:
        r17.c(r18);
        goto L_0x0025;
    L_0x00f6:
        r17.b();
        goto L_0x0025;
    L_0x00fb:
        r2 = r18.getX();
        r3 = r18.getY();
        r5 = 0;
        r1 = r1.getPointerId(r5);
        r0.a(r2, r3, r1);
        r2 = (int) r2;
        r3 = (int) r3;
        r2 = r0.c(r2, r3);
        r3 = r0.s;
        if (r2 != r3) goto L_0x011c;
    L_0x0115:
        r3 = r0.a;
        if (r3 != r4) goto L_0x011c;
    L_0x0119:
        r0.b(r2, r1);
    L_0x011c:
        r2 = r0.h;
        r2 = r2[r1];
        r3 = r0.p;
        r3 = r3 & r2;
        if (r3 == 0) goto L_0x012d;
    L_0x0125:
        r3 = r0.r;
        r4 = r0.p;
        r2 = r2 & r4;
        r3.a(r2, r1);
    L_0x012d:
        r0 = r0.a;
        if (r0 != r6) goto L_0x0132;
    L_0x0131:
        r5 = r6;
    L_0x0132:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.q.a(android.view.MotionEvent):boolean");
    }

    public boolean a(View view, int i, int i2) {
        this.s = view;
        this.c = -1;
        boolean a = a(i, i2, 0, 0);
        if (!(a || this.a != 0 || this.s == null)) {
            this.s = null;
        }
        return a;
    }

    public boolean a(boolean z) {
        if (this.a == 2) {
            boolean computeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                r.d(this.s, left);
            }
            if (top != 0) {
                r.c(this.s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.r.a(this.s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.u.post(this.w);
                } else {
                    b(0);
                }
            }
        }
        return this.a == 2;
    }

    public void b() {
        this.c = -1;
        c();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    void b(int i) {
        this.u.removeCallbacks(this.w);
        if (this.a != i) {
            this.a = i;
            this.r.a(i);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Missing block: B:64:0x0138, code:
            b();
     */
    /* JADX WARNING: Missing block: B:65:0x013b, code:
            return;
     */
    /* JADX WARNING: Missing block: B:69:0x0165, code:
            return;
     */
    public void b(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r0 = r10.getActionMasked();
        r1 = r10.getActionIndex();
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r9.b();
    L_0x000d:
        r2 = r9.l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r9.l = r2;
    L_0x0017:
        r2 = r9.l;
        r2.addMovement(r10);
        r2 = 0;
        r3 = 1;
        switch(r0) {
            case 0: goto L_0x013c;
            case 1: goto L_0x0131;
            case 2: goto L_0x00ae;
            case 3: goto L_0x00a4;
            case 4: goto L_0x0021;
            case 5: goto L_0x0068;
            case 6: goto L_0x0022;
            default: goto L_0x0021;
        };
    L_0x0021:
        return;
    L_0x0022:
        r0 = r10.getPointerId(r1);
        r1 = r9.a;
        if (r1 != r3) goto L_0x0064;
    L_0x002a:
        r1 = r9.c;
        if (r0 != r1) goto L_0x0064;
    L_0x002e:
        r1 = r10.getPointerCount();
    L_0x0032:
        r3 = -1;
        if (r2 >= r1) goto L_0x005e;
    L_0x0035:
        r4 = r10.getPointerId(r2);
        r5 = r9.c;
        if (r4 != r5) goto L_0x003e;
    L_0x003d:
        goto L_0x005b;
    L_0x003e:
        r5 = r10.getX(r2);
        r6 = r10.getY(r2);
        r5 = (int) r5;
        r6 = (int) r6;
        r5 = r9.c(r5, r6);
        r6 = r9.s;
        if (r5 != r6) goto L_0x005b;
    L_0x0050:
        r5 = r9.s;
        r4 = r9.b(r5, r4);
        if (r4 == 0) goto L_0x005b;
    L_0x0058:
        r10 = r9.c;
        goto L_0x005f;
    L_0x005b:
        r2 = r2 + 1;
        goto L_0x0032;
    L_0x005e:
        r10 = r3;
    L_0x005f:
        if (r10 != r3) goto L_0x0064;
    L_0x0061:
        r9.d();
    L_0x0064:
        r9.c(r0);
        return;
    L_0x0068:
        r0 = r10.getPointerId(r1);
        r2 = r10.getX(r1);
        r10 = r10.getY(r1);
        r9.a(r2, r10, r0);
        r1 = r9.a;
        if (r1 != 0) goto L_0x0096;
    L_0x007b:
        r1 = (int) r2;
        r10 = (int) r10;
        r10 = r9.c(r1, r10);
        r9.b(r10, r0);
        r10 = r9.h;
        r10 = r10[r0];
        r1 = r9.p;
        r1 = r1 & r10;
        if (r1 == 0) goto L_0x0165;
    L_0x008d:
        r1 = r9.r;
        r9 = r9.p;
        r9 = r9 & r10;
        r1.a(r9, r0);
        return;
    L_0x0096:
        r1 = (int) r2;
        r10 = (int) r10;
        r10 = r9.b(r1, r10);
        if (r10 == 0) goto L_0x0165;
    L_0x009e:
        r10 = r9.s;
        r9.b(r10, r0);
        return;
    L_0x00a4:
        r10 = r9.a;
        if (r10 != r3) goto L_0x0138;
    L_0x00a8:
        r10 = 0;
        r9.a(r10, r10);
        goto L_0x0138;
    L_0x00ae:
        r0 = r9.a;
        if (r0 != r3) goto L_0x00ee;
    L_0x00b2:
        r0 = r9.c;
        r0 = r9.e(r0);
        if (r0 != 0) goto L_0x00bb;
    L_0x00ba:
        return;
    L_0x00bb:
        r0 = r9.c;
        r0 = r10.findPointerIndex(r0);
        r1 = r10.getX(r0);
        r0 = r10.getY(r0);
        r2 = r9.f;
        r3 = r9.c;
        r2 = r2[r3];
        r1 = r1 - r2;
        r1 = (int) r1;
        r2 = r9.g;
        r3 = r9.c;
        r2 = r2[r3];
        r0 = r0 - r2;
        r0 = (int) r0;
        r2 = r9.s;
        r2 = r2.getLeft();
        r2 = r2 + r1;
        r3 = r9.s;
        r3 = r3.getTop();
        r3 = r3 + r0;
        r9.b(r2, r3, r1, r0);
    L_0x00ea:
        r9.c(r10);
        return;
    L_0x00ee:
        r0 = r10.getPointerCount();
    L_0x00f2:
        if (r2 >= r0) goto L_0x00ea;
    L_0x00f4:
        r1 = r10.getPointerId(r2);
        r4 = r9.e(r1);
        if (r4 != 0) goto L_0x00ff;
    L_0x00fe:
        goto L_0x012e;
    L_0x00ff:
        r4 = r10.getX(r2);
        r5 = r10.getY(r2);
        r6 = r9.d;
        r6 = r6[r1];
        r6 = r4 - r6;
        r7 = r9.e;
        r7 = r7[r1];
        r7 = r5 - r7;
        r9.b(r6, r7, r1);
        r8 = r9.a;
        if (r8 != r3) goto L_0x011b;
    L_0x011a:
        goto L_0x00ea;
    L_0x011b:
        r4 = (int) r4;
        r5 = (int) r5;
        r4 = r9.c(r4, r5);
        r5 = r9.a(r4, r6, r7);
        if (r5 == 0) goto L_0x012e;
    L_0x0127:
        r1 = r9.b(r4, r1);
        if (r1 == 0) goto L_0x012e;
    L_0x012d:
        goto L_0x00ea;
    L_0x012e:
        r2 = r2 + 1;
        goto L_0x00f2;
    L_0x0131:
        r10 = r9.a;
        if (r10 != r3) goto L_0x0138;
    L_0x0135:
        r9.d();
    L_0x0138:
        r9.b();
        return;
    L_0x013c:
        r0 = r10.getX();
        r1 = r10.getY();
        r10 = r10.getPointerId(r2);
        r2 = (int) r0;
        r3 = (int) r1;
        r2 = r9.c(r2, r3);
        r9.a(r0, r1, r10);
        r9.b(r2, r10);
        r0 = r9.h;
        r0 = r0[r10];
        r1 = r9.p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x0165;
    L_0x015d:
        r1 = r9.r;
        r9 = r9.p;
        r9 = r9 & r0;
        r1.a(r9, r10);
    L_0x0165:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.q.b(android.view.MotionEvent):void");
    }

    public boolean b(int i, int i2) {
        return b(this.s, i, i2);
    }

    boolean b(View view, int i) {
        if (view == this.s && this.c == i) {
            return true;
        }
        if (view == null || !this.r.a(view, i)) {
            return false;
        }
        this.c = i;
        a(view, i);
        return true;
    }

    public boolean b(View view, int i, int i2) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            z = true;
        }
        return z;
    }

    public View c(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
