package android.support.design.widget;

import android.support.v4.h.r;
import android.support.v4.widget.q;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends android.support.design.widget.CoordinatorLayout.b<V> {
    private boolean a;
    q b;
    a c;
    int d = 2;
    float e = 0.5f;
    float f = 0.0f;
    float g = 0.5f;
    private float h = 0.0f;
    private boolean i;
    private final android.support.v4.widget.q.a j = new android.support.v4.widget.q.a() {
        private int b;
        private int c = -1;

        private boolean a(View view, float f) {
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            boolean z = false;
            if (i != 0) {
                boolean z2 = r.e(view) == 1;
                if (SwipeDismissBehavior.this.d == 2) {
                    return true;
                }
                if (SwipeDismissBehavior.this.d == 0) {
                    return z2 ? false : false;
                    return true;
                }
                if (SwipeDismissBehavior.this.d == 1) {
                    if (z2) {
                    }
                    return true;
                }
                return false;
            }
            if (Math.abs(view.getLeft() - this.b) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.e)) {
                z = true;
            }
            return z;
        }

        public int a(View view, int i, int i2) {
            return view.getTop();
        }

        public void a(int i) {
            if (SwipeDismissBehavior.this.c != null) {
                SwipeDismissBehavior.this.c.a(i);
            }
        }

        public void a(View view, float f, float f2) {
            int i;
            boolean z;
            this.c = -1;
            int width = view.getWidth();
            if (a(view, f)) {
                i = view.getLeft() < this.b ? this.b - width : this.b + width;
                z = true;
            } else {
                i = this.b;
                z = false;
            }
            if (SwipeDismissBehavior.this.b.a(i, view.getTop())) {
                r.a(view, new b(view, z));
                return;
            }
            if (z && SwipeDismissBehavior.this.c != null) {
                SwipeDismissBehavior.this.c.a(view);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f);
            float width2 = ((float) this.b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.g);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f), 1.0f));
            }
        }

        public boolean a(View view, int i) {
            return this.c == -1 && SwipeDismissBehavior.this.a(view);
        }

        public int b(View view) {
            return view.getWidth();
        }

        /* JADX WARNING: Missing block: B:6:0x0010, code:
            if (r5 != null) goto L_0x0012;
     */
        /* JADX WARNING: Missing block: B:8:0x001c, code:
            r5 = r2.b;
     */
        /* JADX WARNING: Missing block: B:12:0x002c, code:
            if (r5 != null) goto L_0x001c;
     */
        public int b(android.view.View r3, int r4, int r5) {
            /*
            r2 = this;
            r5 = android.support.v4.h.r.e(r3);
            r0 = 1;
            if (r5 != r0) goto L_0x0009;
        L_0x0007:
            r5 = r0;
            goto L_0x000a;
        L_0x0009:
            r5 = 0;
        L_0x000a:
            r1 = android.support.design.widget.SwipeDismissBehavior.this;
            r1 = r1.d;
            if (r1 != 0) goto L_0x0026;
        L_0x0010:
            if (r5 == 0) goto L_0x001c;
        L_0x0012:
            r5 = r2.b;
            r3 = r3.getWidth();
            r5 = r5 - r3;
            r2 = r2.b;
            goto L_0x0037;
        L_0x001c:
            r5 = r2.b;
        L_0x001e:
            r2 = r2.b;
            r3 = r3.getWidth();
            r2 = r2 + r3;
            goto L_0x0037;
        L_0x0026:
            r1 = android.support.design.widget.SwipeDismissBehavior.this;
            r1 = r1.d;
            if (r1 != r0) goto L_0x002f;
        L_0x002c:
            if (r5 == 0) goto L_0x0012;
        L_0x002e:
            goto L_0x001c;
        L_0x002f:
            r5 = r2.b;
            r0 = r3.getWidth();
            r5 = r5 - r0;
            goto L_0x001e;
        L_0x0037:
            r2 = android.support.design.widget.SwipeDismissBehavior.a(r5, r4, r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.SwipeDismissBehavior.1.b(android.view.View, int, int):int");
        }

        public void b(View view, int i) {
            this.c = i;
            this.b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    };

    public interface a {
        void a(int i);

        void a(View view);
    }

    private class b implements Runnable {
        private final View b;
        private final boolean c;

        b(View view, boolean z) {
            this.b = view;
            this.c = z;
        }

        public void run() {
            if (SwipeDismissBehavior.this.b == null || !SwipeDismissBehavior.this.b.a(true)) {
                if (this.c && SwipeDismissBehavior.this.c != null) {
                    SwipeDismissBehavior.this.c.a(this.b);
                }
                return;
            }
            r.a(this.b, (Runnable) this);
        }
    }

    static float a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void a(ViewGroup viewGroup) {
        if (this.b == null) {
            this.b = this.i ? q.a(viewGroup, this.h, this.j) : q.a(viewGroup, this.j);
        }
    }

    static float b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public void a(float f) {
        this.f = a(0.0f, f, 1.0f);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.a;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 3) {
            switch (actionMasked) {
                case 0:
                    this.a = coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                    z = this.a;
                    break;
                case 1:
                    break;
            }
        }
        this.a = false;
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.b.a(motionEvent);
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f) {
        this.g = a(0.0f, f, 1.0f);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.b == null) {
            return false;
        }
        this.b.b(motionEvent);
        return true;
    }
}
