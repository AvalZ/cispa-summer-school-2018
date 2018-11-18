package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.h.r;
import android.support.v7.widget.at.h;
import android.support.v7.widget.at.m;
import android.support.v7.widget.at.n;
import android.support.v7.widget.at.u;
import android.view.MotionEvent;

class ai extends h implements m {
    private static final int[] g = new int[]{16842919};
    private static final int[] h = new int[0];
    private final int[] A = new int[2];
    private final ValueAnimator B = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    private int C = 0;
    private final Runnable D = new Runnable() {
        public void run() {
            ai.this.a(500);
        }
    };
    private final n E = new n() {
        public void a(at atVar, int i, int i2) {
            ai.this.a(atVar.computeHorizontalScrollOffset(), atVar.computeVerticalScrollOffset());
        }
    };
    int a;
    int b;
    float c;
    int d;
    int e;
    float f;
    private final int i;
    private final int j;
    private final StateListDrawable k;
    private final Drawable l;
    private final int m;
    private final int n;
    private final StateListDrawable o;
    private final Drawable p;
    private final int q;
    private final int r;
    private int s = 0;
    private int t = 0;
    private at u;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private int y = 0;
    private final int[] z = new int[2];

    private class a extends AnimatorListenerAdapter {
        private boolean b;

        private a() {
            this.b = false;
        }

        /* synthetic */ a(ai aiVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onAnimationCancel(Animator animator) {
            this.b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.b) {
                this.b = false;
            } else if (((Float) ai.this.B.getAnimatedValue()).floatValue() == 0.0f) {
                ai.this.C = 0;
                ai.this.b(0);
            } else {
                ai.this.C = 2;
                ai.this.d();
            }
        }
    }

    private class b implements AnimatorUpdateListener {
        private b() {
        }

        /* synthetic */ b(ai aiVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            ai.this.k.setAlpha(floatValue);
            ai.this.l.setAlpha(floatValue);
            ai.this.d();
        }
    }

    ai(at atVar, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.k = stateListDrawable;
        this.l = drawable;
        this.o = stateListDrawable2;
        this.p = drawable2;
        this.m = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.n = Math.max(i, drawable.getIntrinsicWidth());
        this.q = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.r = Math.max(i, drawable2.getIntrinsicWidth());
        this.i = i2;
        this.j = i3;
        this.k.setAlpha(255);
        this.l.setAlpha(255);
        this.B.addListener(new a(this, null));
        this.B.addUpdateListener(new b(this, null));
        a(atVar);
    }

    private int a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        i -= i3;
        i4 = (int) (((f2 - f) / ((float) i4)) * ((float) i));
        i2 += i4;
        return (i2 >= i || i2 < 0) ? 0 : i4;
    }

    private void a(float f) {
        int[] g = g();
        f = Math.max((float) g[0], Math.min((float) g[1], f));
        if (Math.abs(((float) this.b) - f) >= 2.0f) {
            int a = a(this.c, f, g, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
            if (a != 0) {
                this.u.scrollBy(0, a);
            }
            this.c = f;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x005f in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    private void a(android.graphics.Canvas r7) {
        /*
        r6 = this;
        r0 = r6.s;
        r1 = r6.m;
        r0 = r0 - r1;
        r1 = r6.b;
        r2 = r6.a;
        r2 = r2 / 2;
        r1 = r1 - r2;
        r2 = r6.k;
        r3 = r6.m;
        r4 = r6.a;
        r5 = 0;
        r2.setBounds(r5, r5, r3, r4);
        r2 = r6.l;
        r3 = r6.n;
        r4 = r6.t;
        r2.setBounds(r5, r5, r3, r4);
        r2 = r6.e();
        if (r2 == 0) goto L_0x004a;
    L_0x0025:
        r0 = r6.l;
        r0.draw(r7);
        r0 = r6.m;
        r0 = (float) r0;
        r2 = (float) r1;
        r7.translate(r0, r2);
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r7.scale(r0, r2);
        r0 = r6.k;
        r0.draw(r7);
        r7.scale(r2, r2);
        r6 = r6.m;
        r6 = -r6;
    L_0x0043:
        r6 = (float) r6;
        r0 = -r1;
        r0 = (float) r0;
        r7.translate(r6, r0);
        return;
    L_0x004a:
        r2 = (float) r0;
        r3 = 0;
        r7.translate(r2, r3);
        r2 = r6.l;
        r2.draw(r7);
        r2 = (float) r1;
        r7.translate(r3, r2);
        r6 = r6.k;
        r6.draw(r7);
        r6 = -r0;
        goto L_0x0043;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ai.a(android.graphics.Canvas):void");
    }

    private void b() {
        this.u.a((h) this);
        this.u.a((m) this);
        this.u.a(this.E);
    }

    private void b(float f) {
        int[] h = h();
        f = Math.max((float) h[0], Math.min((float) h[1], f));
        if (Math.abs(((float) this.e) - f) >= 2.0f) {
            int a = a(this.f, f, h, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
            if (a != 0) {
                this.u.scrollBy(a, 0);
            }
            this.f = f;
        }
    }

    private void b(int i) {
        int i2;
        if (i == 2 && this.x != 2) {
            this.k.setState(g);
            f();
        }
        if (i == 0) {
            d();
        } else {
            a();
        }
        if (this.x != 2 || i == 2) {
            if (i == 1) {
                i2 = 1500;
            }
            this.x = i;
        }
        this.k.setState(h);
        i2 = 1200;
        c(i2);
        this.x = i;
    }

    private void b(Canvas canvas) {
        int i = this.t - this.q;
        int i2 = this.e - (this.d / 2);
        this.o.setBounds(0, 0, this.d, this.q);
        this.p.setBounds(0, 0, this.s, this.r);
        canvas.translate(0.0f, (float) i);
        this.p.draw(canvas);
        canvas.translate((float) i2, 0.0f);
        this.o.draw(canvas);
        canvas.translate((float) (-i2), (float) (-i));
    }

    private void c() {
        this.u.b((h) this);
        this.u.b((m) this);
        this.u.b(this.E);
        f();
    }

    private void c(int i) {
        f();
        this.u.postDelayed(this.D, (long) i);
    }

    private void d() {
        this.u.invalidate();
    }

    private boolean e() {
        return r.e(this.u) == 1;
    }

    private void f() {
        this.u.removeCallbacks(this.D);
    }

    private int[] g() {
        this.z[0] = this.j;
        this.z[1] = this.t - this.j;
        return this.z;
    }

    private int[] h() {
        this.A[0] = this.j;
        this.A[1] = this.s - this.j;
        return this.A;
    }

    public void a() {
        int i = this.C;
        if (i != 0) {
            if (i == 3) {
                this.B.cancel();
            } else {
                return;
            }
        }
        this.C = 1;
        this.B.setFloatValues(new float[]{((Float) this.B.getAnimatedValue()).floatValue(), 1.0f});
        this.B.setDuration(500);
        this.B.setStartDelay(0);
        this.B.start();
    }

    void a(int i) {
        switch (this.C) {
            case 1:
                this.B.cancel();
                break;
            case 2:
                break;
            default:
                return;
        }
        this.C = 3;
        this.B.setFloatValues(new float[]{((Float) this.B.getAnimatedValue()).floatValue(), 0.0f});
        this.B.setDuration((long) i);
        this.B.start();
    }

    void a(int i, int i2) {
        int computeVerticalScrollRange = this.u.computeVerticalScrollRange();
        int i3 = this.t;
        boolean z = computeVerticalScrollRange - i3 > 0 && this.t >= this.i;
        this.v = z;
        int computeHorizontalScrollRange = this.u.computeHorizontalScrollRange();
        int i4 = this.s;
        boolean z2 = computeHorizontalScrollRange - i4 > 0 && this.s >= this.i;
        this.w = z2;
        if (this.v || this.w) {
            if (this.v) {
                float f = (float) i3;
                this.b = (int) ((f * (((float) i2) + (f / 2.0f))) / ((float) computeVerticalScrollRange));
                this.a = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (this.w) {
                float f2 = (float) i4;
                this.e = (int) ((f2 * (((float) i) + (f2 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.d = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            if (this.x == 0 || this.x == 1) {
                b(1);
            }
            return;
        }
        if (this.x != 0) {
            b(0);
        }
    }

    public void a(Canvas canvas, at atVar, u uVar) {
        if (this.s == this.u.getWidth() && this.t == this.u.getHeight()) {
            if (this.C != 0) {
                if (this.v) {
                    a(canvas);
                }
                if (this.w) {
                    b(canvas);
                }
            }
            return;
        }
        this.s = this.u.getWidth();
        this.t = this.u.getHeight();
        b(0);
    }

    public void a(at atVar) {
        if (this.u != atVar) {
            if (this.u != null) {
                c();
            }
            this.u = atVar;
            if (this.u != null) {
                b();
            }
        }
    }

    public void a(boolean z) {
    }

    boolean a(float f, float f2) {
        if (e() ? f > ((float) (this.m / 2)) : f < ((float) (this.s - this.m))) {
            if (f2 >= ((float) (this.b - (this.a / 2))) && f2 <= ((float) (this.b + (this.a / 2)))) {
                return true;
            }
        }
        return false;
    }

    public boolean a(at atVar, MotionEvent motionEvent) {
        if (this.x == 1) {
            boolean a = a(motionEvent.getX(), motionEvent.getY());
            boolean b = b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!a && !b) {
                return false;
            }
            if (b) {
                this.y = 1;
                this.f = (float) ((int) motionEvent.getX());
            } else if (a) {
                this.y = 2;
                this.c = (float) ((int) motionEvent.getY());
            }
            b(2);
        } else if (this.x != 2) {
            return false;
        }
        return true;
    }

    public void b(at atVar, MotionEvent motionEvent) {
        if (this.x != 0) {
            if (motionEvent.getAction() == 0) {
                boolean a = a(motionEvent.getX(), motionEvent.getY());
                boolean b = b(motionEvent.getX(), motionEvent.getY());
                if (a || b) {
                    if (b) {
                        this.y = 1;
                        this.f = (float) ((int) motionEvent.getX());
                    } else if (a) {
                        this.y = 2;
                        this.c = (float) ((int) motionEvent.getY());
                    }
                    b(2);
                }
            } else if (motionEvent.getAction() == 1 && this.x == 2) {
                this.c = 0.0f;
                this.f = 0.0f;
                b(1);
                this.y = 0;
            } else if (motionEvent.getAction() == 2 && this.x == 2) {
                a();
                if (this.y == 1) {
                    b(motionEvent.getX());
                }
                if (this.y == 2) {
                    a(motionEvent.getY());
                }
            }
        }
    }

    boolean b(float f, float f2) {
        return f2 >= ((float) (this.t - this.q)) && f >= ((float) (this.e - (this.d / 2))) && f <= ((float) (this.e + (this.d / 2)));
    }
}
