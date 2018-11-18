package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.transition.u.c;
import android.view.View;
import android.view.ViewGroup;

public abstract class at extends u {
    private static final String[] g = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    private int h = 3;

    private static class b {
        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class a extends AnimatorListenerAdapter implements a, c {
        boolean a = false;
        private final View b;
        private final int c;
        private final ViewGroup d;
        private final boolean e;
        private boolean f;

        a(View view, int i, boolean z) {
            this.b = view;
            this.c = i;
            this.d = (ViewGroup) view.getParent();
            this.e = z;
            a(true);
        }

        private void a() {
            if (!this.a) {
                am.a(this.b, this.c);
                if (this.d != null) {
                    this.d.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            if (this.e && this.f != z && this.d != null) {
                this.f = z;
                af.a(this.d, z);
            }
        }

        public void a(u uVar) {
            a();
            uVar.b((c) this);
        }

        public void b(u uVar) {
            a(false);
        }

        public void c(u uVar) {
            a(true);
        }

        public void d(u uVar) {
        }

        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.a) {
                am.a(this.b, this.c);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.a) {
                am.a(this.b, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX WARNING: Missing block: B:24:0x0083, code:
            if (r5.d == 0) goto L_0x0096;
     */
    /* JADX WARNING: Missing block: B:28:0x008d, code:
            if (r5.e == null) goto L_0x0096;
     */
    /* JADX WARNING: Missing block: B:37:0x009f, code:
            if (r5.c == 0) goto L_0x00a1;
     */
    private android.support.transition.at.b b(android.support.transition.aa r6, android.support.transition.aa r7) {
        /*
        r5 = this;
        r5 = new android.support.transition.at$b;
        r0 = 0;
        r5.<init>(r0);
        r1 = 0;
        r5.a = r1;
        r5.b = r1;
        r2 = -1;
        if (r6 == 0) goto L_0x0035;
    L_0x000e:
        r3 = r6.a;
        r4 = "android:visibility:visibility";
        r3 = r3.containsKey(r4);
        if (r3 == 0) goto L_0x0035;
    L_0x0018:
        r3 = r6.a;
        r4 = "android:visibility:visibility";
        r3 = r3.get(r4);
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        r5.c = r3;
        r3 = r6.a;
        r4 = "android:visibility:parent";
        r3 = r3.get(r4);
        r3 = (android.view.ViewGroup) r3;
        r5.e = r3;
        goto L_0x0039;
    L_0x0035:
        r5.c = r2;
        r5.e = r0;
    L_0x0039:
        if (r7 == 0) goto L_0x0060;
    L_0x003b:
        r3 = r7.a;
        r4 = "android:visibility:visibility";
        r3 = r3.containsKey(r4);
        if (r3 == 0) goto L_0x0060;
    L_0x0045:
        r0 = r7.a;
        r2 = "android:visibility:visibility";
        r0 = r0.get(r2);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r5.d = r0;
        r0 = r7.a;
        r2 = "android:visibility:parent";
        r0 = r0.get(r2);
        r0 = (android.view.ViewGroup) r0;
        goto L_0x0062;
    L_0x0060:
        r5.d = r2;
    L_0x0062:
        r5.f = r0;
        r0 = 1;
        if (r6 == 0) goto L_0x0090;
    L_0x0067:
        if (r7 == 0) goto L_0x0090;
    L_0x0069:
        r6 = r5.c;
        r7 = r5.d;
        if (r6 != r7) goto L_0x0076;
    L_0x006f:
        r6 = r5.e;
        r7 = r5.f;
        if (r6 != r7) goto L_0x0076;
    L_0x0075:
        return r5;
    L_0x0076:
        r6 = r5.c;
        r7 = r5.d;
        if (r6 == r7) goto L_0x0086;
    L_0x007c:
        r6 = r5.c;
        if (r6 != 0) goto L_0x0081;
    L_0x0080:
        goto L_0x00a1;
    L_0x0081:
        r6 = r5.d;
        if (r6 != 0) goto L_0x00a4;
    L_0x0085:
        goto L_0x0096;
    L_0x0086:
        r6 = r5.f;
        if (r6 != 0) goto L_0x008b;
    L_0x008a:
        goto L_0x00a1;
    L_0x008b:
        r6 = r5.e;
        if (r6 != 0) goto L_0x00a4;
    L_0x008f:
        goto L_0x0096;
    L_0x0090:
        if (r6 != 0) goto L_0x009b;
    L_0x0092:
        r6 = r5.d;
        if (r6 != 0) goto L_0x009b;
    L_0x0096:
        r5.b = r0;
    L_0x0098:
        r5.a = r0;
        return r5;
    L_0x009b:
        if (r7 != 0) goto L_0x00a4;
    L_0x009d:
        r6 = r5.c;
        if (r6 != 0) goto L_0x00a4;
    L_0x00a1:
        r5.b = r1;
        goto L_0x0098;
    L_0x00a4:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.at.b(android.support.transition.aa, android.support.transition.aa):android.support.transition.at$b");
    }

    private void d(aa aaVar) {
        aaVar.a.put("android:visibility:visibility", Integer.valueOf(aaVar.b.getVisibility()));
        aaVar.a.put("android:visibility:parent", aaVar.b.getParent());
        Object obj = new int[2];
        aaVar.b.getLocationOnScreen(obj);
        aaVar.a.put("android:visibility:screenLocation", obj);
    }

    public Animator a(ViewGroup viewGroup, aa aaVar, int i, aa aaVar2, int i2) {
        if ((this.h & 1) != 1 || aaVar2 == null) {
            return null;
        }
        if (aaVar == null) {
            View view = (View) aaVar2.b.getParent();
            if (b(b(view, false), a(view, false)).a) {
                return null;
            }
        }
        return a(viewGroup, aaVar2.b, aaVar, aaVar2);
    }

    public Animator a(ViewGroup viewGroup, aa aaVar, aa aaVar2) {
        b b = b(aaVar, aaVar2);
        if (!b.a || (b.e == null && b.f == null)) {
            return null;
        }
        if (b.b) {
            return a(viewGroup, aaVar, b.c, aaVar2, b.d);
        }
        return b(viewGroup, aaVar, b.c, aaVar2, b.d);
    }

    public Animator a(ViewGroup viewGroup, View view, aa aaVar, aa aaVar2) {
        return null;
    }

    public void a(int i) {
        if ((i & -4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.h = i;
    }

    public void a(aa aaVar) {
        d(aaVar);
    }

    public boolean a(aa aaVar, aa aaVar2) {
        boolean z = false;
        if (aaVar == null && aaVar2 == null) {
            return false;
        }
        if (aaVar != null && aaVar2 != null && aaVar2.a.containsKey("android:visibility:visibility") != aaVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b = b(aaVar, aaVar2);
        if (b.a && (b.c == 0 || b.d == 0)) {
            z = true;
        }
        return z;
    }

    public String[] a() {
        return g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dd A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0076 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dd A:{RETURN} */
    /* JADX WARNING: Missing block: B:35:0x006c, code:
            if (r6.e != false) goto L_0x0029;
     */
    public android.animation.Animator b(android.view.ViewGroup r7, android.support.transition.aa r8, int r9, android.support.transition.aa r10, int r11) {
        /*
        r6 = this;
        r9 = r6.h;
        r0 = 2;
        r9 = r9 & r0;
        r1 = 0;
        if (r9 == r0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        if (r8 == 0) goto L_0x000d;
    L_0x000a:
        r9 = r8.b;
        goto L_0x000e;
    L_0x000d:
        r9 = r1;
    L_0x000e:
        if (r10 == 0) goto L_0x0013;
    L_0x0010:
        r2 = r10.b;
        goto L_0x0014;
    L_0x0013:
        r2 = r1;
    L_0x0014:
        r3 = 1;
        if (r2 == 0) goto L_0x0026;
    L_0x0017:
        r4 = r2.getParent();
        if (r4 != 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r4 = 4;
        if (r11 != r4) goto L_0x0022;
    L_0x0021:
        goto L_0x0024;
    L_0x0022:
        if (r9 != r2) goto L_0x0029;
    L_0x0024:
        r9 = r1;
        goto L_0x0073;
    L_0x0026:
        if (r2 == 0) goto L_0x002b;
    L_0x0028:
        r9 = r2;
    L_0x0029:
        r2 = r1;
        goto L_0x0073;
    L_0x002b:
        if (r9 == 0) goto L_0x0071;
    L_0x002d:
        r2 = r9.getParent();
        if (r2 != 0) goto L_0x0034;
    L_0x0033:
        goto L_0x0029;
    L_0x0034:
        r2 = r9.getParent();
        r2 = r2 instanceof android.view.View;
        if (r2 == 0) goto L_0x0071;
    L_0x003c:
        r2 = r9.getParent();
        r2 = (android.view.View) r2;
        r4 = r6.a(r2, r3);
        r5 = r6.b(r2, r3);
        r4 = r6.b(r4, r5);
        r4 = r4.a;
        if (r4 != 0) goto L_0x0057;
    L_0x0052:
        r9 = android.support.transition.z.a(r7, r9, r2);
        goto L_0x0029;
    L_0x0057:
        r4 = r2.getParent();
        if (r4 != 0) goto L_0x006f;
    L_0x005d:
        r2 = r2.getId();
        r4 = -1;
        if (r2 == r4) goto L_0x006f;
    L_0x0064:
        r2 = r7.findViewById(r2);
        if (r2 == 0) goto L_0x006f;
    L_0x006a:
        r2 = r6.e;
        if (r2 == 0) goto L_0x006f;
    L_0x006e:
        goto L_0x0029;
    L_0x006f:
        r9 = r1;
        goto L_0x0029;
    L_0x0071:
        r9 = r1;
        r2 = r9;
    L_0x0073:
        r4 = 0;
        if (r9 == 0) goto L_0x00bb;
    L_0x0076:
        if (r8 == 0) goto L_0x00bb;
    L_0x0078:
        r11 = r8.a;
        r1 = "android:visibility:screenLocation";
        r11 = r11.get(r1);
        r11 = (int[]) r11;
        r1 = r11[r4];
        r11 = r11[r3];
        r0 = new int[r0];
        r7.getLocationOnScreen(r0);
        r2 = r0[r4];
        r1 = r1 - r2;
        r2 = r9.getLeft();
        r1 = r1 - r2;
        r9.offsetLeftAndRight(r1);
        r0 = r0[r3];
        r11 = r11 - r0;
        r0 = r9.getTop();
        r11 = r11 - r0;
        r9.offsetTopAndBottom(r11);
        r11 = android.support.transition.af.a(r7);
        r11.a(r9);
        r7 = r6.b(r7, r9, r8, r10);
        if (r7 != 0) goto L_0x00b2;
    L_0x00ae:
        r11.b(r9);
        return r7;
    L_0x00b2:
        r8 = new android.support.transition.at$1;
        r8.<init>(r11, r9);
        r7.addListener(r8);
        return r7;
    L_0x00bb:
        if (r2 == 0) goto L_0x00dd;
    L_0x00bd:
        r9 = r2.getVisibility();
        android.support.transition.am.a(r2, r4);
        r7 = r6.b(r7, r2, r8, r10);
        if (r7 == 0) goto L_0x00d9;
    L_0x00ca:
        r8 = new android.support.transition.at$a;
        r8.<init>(r2, r11, r3);
        r7.addListener(r8);
        android.support.transition.a.a(r7, r8);
        r6.a(r8);
        return r7;
    L_0x00d9:
        android.support.transition.am.a(r2, r9);
        return r7;
    L_0x00dd:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.at.b(android.view.ViewGroup, android.support.transition.aa, int, android.support.transition.aa, int):android.animation.Animator");
    }

    public Animator b(ViewGroup viewGroup, View view, aa aaVar, aa aaVar2) {
        return null;
    }

    public void b(aa aaVar) {
        d(aaVar);
    }
}
