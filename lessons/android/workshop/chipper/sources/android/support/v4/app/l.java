package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.p;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class l extends k implements Factory2 {
    static final Interpolator F = new DecelerateInterpolator(2.5f);
    static final Interpolator G = new DecelerateInterpolator(1.5f);
    static final Interpolator H = new AccelerateInterpolator(2.5f);
    static final Interpolator I = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static Field q;
    Bundle A = null;
    SparseArray<Parcelable> B = null;
    ArrayList<i> C;
    m D;
    Runnable E = new Runnable() {
        public void run() {
            l.this.f();
        }
    };
    private final CopyOnWriteArrayList<f> J = new CopyOnWriteArrayList();
    ArrayList<h> b;
    boolean c;
    int d = 0;
    final ArrayList<f> e = new ArrayList();
    SparseArray<f> f;
    ArrayList<c> g;
    ArrayList<f> h;
    ArrayList<c> i;
    ArrayList<Integer> j;
    ArrayList<android.support.v4.app.k.b> k;
    int l = 0;
    j m;
    h n;
    f o;
    f p;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    ArrayList<c> x;
    ArrayList<Boolean> y;
    ArrayList<f> z;

    private static class b implements AnimationListener {
        private final AnimationListener a;

        b(AnimationListener animationListener) {
            this.a = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationStart(animation);
            }
        }
    }

    private static class c {
        public final Animation a;
        public final Animator b;

        c(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        c(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static class d extends AnimatorListenerAdapter {
        View a;

        d(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.setLayerType(0, null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.a.setLayerType(2, null);
        }
    }

    private static class e extends AnimationSet implements Runnable {
        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean d;
        private boolean e = true;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.a = viewGroup;
            this.b = view;
            addAnimation(animation);
            this.a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return this.d ^ true;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                v.a(this.a, this);
            }
            return true;
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return this.d ^ true;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                v.a(this.a, this);
            }
            return true;
        }

        public void run() {
            if (this.c || !this.e) {
                this.a.endViewTransition(this.b);
                this.d = true;
                return;
            }
            this.e = false;
            this.a.post(this);
        }
    }

    private static final class f {
        final android.support.v4.app.k.a a;
        final boolean b;
    }

    static class g {
        public static final int[] a = new int[]{16842755, 16842960, 16842961};
    }

    interface h {
        boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2);
    }

    private static class a extends b {
        View a;

        a(View view, AnimationListener animationListener) {
            super(animationListener);
            this.a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (r.x(this.a) || VERSION.SDK_INT >= 24) {
                this.a.post(new Runnable() {
                    public void run() {
                        a.this.a.setLayerType(0, null);
                    }
                });
            } else {
                this.a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    static class i implements c {
        final boolean a;
        final c b;
        private int c;

        i(c cVar, boolean z) {
            this.a = z;
            this.b = cVar;
        }

        public void a() {
            this.c--;
            if (this.c == 0) {
                this.b.a.e();
            }
        }

        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            int i = 0;
            int i2 = this.c > 0 ? 1 : 0;
            l lVar = this.b.a;
            int size = lVar.e.size();
            while (i < size) {
                f fVar = (f) lVar.e.get(i);
                fVar.a(null);
                if (i2 != 0 && fVar.X()) {
                    fVar.D();
                }
                i++;
            }
            this.b.a.a(this.b, this.a, i2 ^ true, true);
        }

        public void e() {
            this.b.a.a(this.b, this.a, false, false);
        }
    }

    l() {
    }

    private void A() {
        int i = 0;
        int size = this.f == null ? 0 : this.f.size();
        while (i < size) {
            f fVar = (f) this.f.valueAt(i);
            if (fVar != null) {
                if (fVar.U() != null) {
                    int W = fVar.W();
                    View U = fVar.U();
                    Animation animation = U.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        U.clearAnimation();
                    }
                    fVar.a(null);
                    a(fVar, W, 0, 0, false);
                } else if (fVar.V() != null) {
                    fVar.V().end();
                }
            }
            i++;
        }
    }

    private void B() {
        if (this.f != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    this.f.delete(this.f.keyAt(size));
                }
            }
        }
    }

    private int a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, android.support.v4.g.b<f> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            c cVar = (c) arrayList.get(i4);
            boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            boolean z = cVar.c() && !cVar.a((ArrayList) arrayList, i4 + 1, i2);
            if (z) {
                if (this.C == null) {
                    this.C = new ArrayList();
                }
                c iVar = new i(cVar, booleanValue);
                this.C.add(iVar);
                cVar.a(iVar);
                if (booleanValue) {
                    cVar.b();
                } else {
                    cVar.a(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, cVar);
                }
                b((android.support.v4.g.b) bVar);
            }
        }
        return i3;
    }

    static c a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220);
        return new c(alphaAnimation);
    }

    static c a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        Animation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new c(animationSet);
    }

    private static AnimationListener a(Animation animation) {
        Throwable e;
        String str;
        String str2;
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (AnimationListener) q.get(animation);
        } catch (NoSuchFieldException e2) {
            e = e2;
            str = "FragmentManager";
            str2 = "No field with the name mListener is found in Animation class";
            Log.e(str, str2, e);
            return null;
        } catch (IllegalAccessException e3) {
            e = e3;
            str = "FragmentManager";
            str2 = "Cannot access Animation's mListener field";
            Log.e(str, str2, e);
            return null;
        }
    }

    private void a(final f fVar, c cVar, int i) {
        final View view = fVar.J;
        final ViewGroup viewGroup = fVar.I;
        viewGroup.startViewTransition(view);
        fVar.b(i);
        if (cVar.a != null) {
            Animation eVar = new e(cVar.a, viewGroup, view);
            fVar.a(fVar.J);
            eVar.setAnimationListener(new b(a(eVar)) {
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() {
                        public void run() {
                            if (fVar.U() != null) {
                                fVar.a(null);
                                l.this.a(fVar, fVar.W(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            b(view, cVar);
            fVar.J.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.b;
        fVar.a(cVar.b);
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                animator = fVar.V();
                fVar.a(null);
                if (animator != null && viewGroup.indexOfChild(view) < 0) {
                    l.this.a(fVar, fVar.W(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fVar.J);
        b(fVar.J, cVar);
        animator.start();
    }

    private static void a(m mVar) {
        if (mVar != null) {
            List<f> a = mVar.a();
            if (a != null) {
                for (f fVar : a) {
                    fVar.E = true;
                }
            }
            List<m> b = mVar.b();
            if (b != null) {
                for (m a2 : b) {
                    a(a2);
                }
            }
        }
    }

    private void a(android.support.v4.g.b<f> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            f fVar = (f) bVar.b(i);
            if (!fVar.l) {
                View l = fVar.l();
                fVar.Q = l.getAlpha();
                l.setAlpha(0.0f);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new android.support.v4.g.e("FragmentManager"));
        if (this.m != null) {
            try {
                this.m.a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            a("  ", null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    /* JADX WARNING: Missing block: B:13:0x0032, code:
            if (((java.lang.Boolean) r9.get(r5)).booleanValue() != false) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:14:0x0034, code:
            r3.e();
     */
    /* JADX WARNING: Missing block: B:27:0x006d, code:
            if (((java.lang.Boolean) r9.get(r5)).booleanValue() != false) goto L_0x0034;
     */
    private void a(java.util.ArrayList<android.support.v4.app.c> r8, java.util.ArrayList<java.lang.Boolean> r9) {
        /*
        r7 = this;
        r0 = r7.C;
        r1 = 0;
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        r0 = r1;
        goto L_0x000d;
    L_0x0007:
        r0 = r7.C;
        r0 = r0.size();
    L_0x000d:
        r2 = r0;
        r0 = r1;
    L_0x000f:
        if (r0 >= r2) goto L_0x0076;
    L_0x0011:
        r3 = r7.C;
        r3 = r3.get(r0);
        r3 = (android.support.v4.app.l.i) r3;
        r4 = -1;
        if (r8 == 0) goto L_0x0038;
    L_0x001c:
        r5 = r3.a;
        if (r5 != 0) goto L_0x0038;
    L_0x0020:
        r5 = r3.b;
        r5 = r8.indexOf(r5);
        if (r5 == r4) goto L_0x0038;
    L_0x0028:
        r5 = r9.get(r5);
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x0038;
    L_0x0034:
        r3.e();
        goto L_0x0073;
    L_0x0038:
        r5 = r3.c();
        if (r5 != 0) goto L_0x004c;
    L_0x003e:
        if (r8 == 0) goto L_0x0073;
    L_0x0040:
        r5 = r3.b;
        r6 = r8.size();
        r5 = r5.a(r8, r1, r6);
        if (r5 == 0) goto L_0x0073;
    L_0x004c:
        r5 = r7.C;
        r5.remove(r0);
        r0 = r0 + -1;
        r2 = r2 + -1;
        if (r8 == 0) goto L_0x0070;
    L_0x0057:
        r5 = r3.a;
        if (r5 != 0) goto L_0x0070;
    L_0x005b:
        r5 = r3.b;
        r5 = r8.indexOf(r5);
        if (r5 == r4) goto L_0x0070;
    L_0x0063:
        r4 = r9.get(r5);
        r4 = (java.lang.Boolean) r4;
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x0070;
    L_0x006f:
        goto L_0x0034;
    L_0x0070:
        r3.d();
    L_0x0073:
        r0 = r0 + 1;
        goto L_0x000f;
    L_0x0076:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.l.a(java.util.ArrayList, java.util.ArrayList):void");
    }

    private void a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        ArrayList<c> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i;
        int i6 = i2;
        boolean z = ((c) arrayList3.get(i5)).t;
        if (this.z == null) {
            this.z = new ArrayList();
        } else {
            this.z.clear();
        }
        this.z.addAll(this.e);
        f v = v();
        boolean z2 = false;
        for (i3 = i5; i3 < i6; i3++) {
            c cVar = (c) arrayList3.get(i3);
            v = !((Boolean) arrayList4.get(i3)).booleanValue() ? cVar.a(this.z, v) : cVar.b(this.z, v);
            z2 = z2 || cVar.i;
        }
        this.z.clear();
        if (!z) {
            q.a(this, (ArrayList) arrayList3, (ArrayList) arrayList4, i5, i6, false);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            android.support.v4.g.b bVar = new android.support.v4.g.b();
            b(bVar);
            i3 = a((ArrayList) arrayList3, (ArrayList) arrayList4, i5, i6, bVar);
            a(bVar);
            i4 = i3;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z) {
            q.a(this, (ArrayList) arrayList3, (ArrayList) arrayList4, i5, i4, true);
            a(this.l, true);
        }
        while (i5 < i6) {
            c cVar2 = (c) arrayList3.get(i5);
            if (((Boolean) arrayList4.get(i5)).booleanValue() && cVar2.m >= 0) {
                c(cVar2.m);
                cVar2.m = -1;
            }
            cVar2.a();
            i5++;
        }
        if (z2) {
            h();
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        int i;
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (i = 0; i < childAnimations.size(); i++) {
                if (a((Animator) childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(c cVar) {
        if (cVar.a instanceof AlphaAnimation) {
            return true;
        }
        if (!(cVar.a instanceof AnimationSet)) {
            return a(cVar.b);
        }
        List animations = ((AnimationSet) cVar.a).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean a(View view, c cVar) {
        boolean z = false;
        if (view != null) {
            if (cVar == null) {
                return false;
            }
            if (VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && r.o(view) && a(cVar)) {
                z = true;
            }
        }
        return z;
    }

    private boolean a(String str, int i, int i2) {
        f();
        c(true);
        if (this.p != null && i < 0 && str == null) {
            k k = this.p.k();
            if (k != null && k.a()) {
                return true;
            }
        }
        boolean a = a(this.x, this.y, str, i, i2);
        if (a) {
            this.c = true;
            try {
                b(this.x, this.y);
            } finally {
                y();
            }
        }
        g();
        B();
        return a;
    }

    public static int b(int i, boolean z) {
        return i != 4097 ? i != 4099 ? i != 8194 ? -1 : z ? 3 : 4 : z ? 5 : 6 : z ? 1 : 2;
    }

    private void b(android.support.v4.g.b<f> bVar) {
        if (this.l >= 1) {
            int min = Math.min(this.l, 3);
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.e.get(i);
                if (fVar.b < min) {
                    a(fVar, min, fVar.P(), fVar.Q(), false);
                    if (!(fVar.J == null || fVar.B || !fVar.O)) {
                        bVar.add(fVar);
                    }
                }
            }
        }
    }

    private static void b(View view, c cVar) {
        if (!(view == null || cVar == null || !a(view, cVar))) {
            if (cVar.b != null) {
                cVar.b.addListener(new d(view));
                return;
            }
            AnimationListener a = a(cVar.a);
            view.setLayerType(2, null);
            cVar.a.setAnimationListener(new a(view, a));
        }
    }

    private void b(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a((ArrayList) arrayList, (ArrayList) arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!((c) arrayList.get(i)).t) {
                    if (i2 != i) {
                        a((ArrayList) arrayList, (ArrayList) arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((c) arrayList.get(i2)).t) {
                            i2++;
                        }
                    }
                    a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                a((ArrayList) arrayList, (ArrayList) arrayList2, i2, size);
            }
        }
    }

    private static void b(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            c cVar = (c) arrayList.get(i);
            boolean z = true;
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                cVar.a(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                cVar.a(z);
            } else {
                cVar.a(1);
                cVar.b();
            }
            i++;
        }
    }

    private void c(boolean z) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() != this.m.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                x();
            }
            if (this.x == null) {
                this.x = new ArrayList();
                this.y = new ArrayList();
            }
            this.c = true;
            try {
                a(null, null);
            } finally {
                this.c = false;
            }
        }
    }

    /* JADX WARNING: Missing block: B:13:0x003b, code:
            return false;
     */
    private boolean c(java.util.ArrayList<android.support.v4.app.c> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.b;	 Catch:{ all -> 0x003c }
        r1 = 0;
        if (r0 == 0) goto L_0x003a;
    L_0x0006:
        r0 = r4.b;	 Catch:{ all -> 0x003c }
        r0 = r0.size();	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x003a;
    L_0x000f:
        r0 = r4.b;	 Catch:{ all -> 0x003c }
        r0 = r0.size();	 Catch:{ all -> 0x003c }
        r2 = r1;
    L_0x0016:
        if (r1 >= r0) goto L_0x0028;
    L_0x0018:
        r3 = r4.b;	 Catch:{ all -> 0x003c }
        r3 = r3.get(r1);	 Catch:{ all -> 0x003c }
        r3 = (android.support.v4.app.l.h) r3;	 Catch:{ all -> 0x003c }
        r3 = r3.a(r5, r6);	 Catch:{ all -> 0x003c }
        r2 = r2 | r3;
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x0028:
        r5 = r4.b;	 Catch:{ all -> 0x003c }
        r5.clear();	 Catch:{ all -> 0x003c }
        r5 = r4.m;	 Catch:{ all -> 0x003c }
        r5 = r5.h();	 Catch:{ all -> 0x003c }
        r6 = r4.E;	 Catch:{ all -> 0x003c }
        r5.removeCallbacks(r6);	 Catch:{ all -> 0x003c }
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        return r2;
    L_0x003a:
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        return r1;
    L_0x003c:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.l.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    public static int d(int i) {
        int i2 = 8194;
        if (i != 4097) {
            if (i != 4099) {
                return i != 8194 ? 0 : 4097;
            } else {
                i2 = 4099;
            }
        }
        return i2;
    }

    private void e(int i) {
        try {
            this.c = true;
            a(i, false);
            f();
        } finally {
            this.c = false;
        }
    }

    private f p(f fVar) {
        ViewGroup viewGroup = fVar.I;
        View view = fVar.J;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.e.indexOf(fVar) - 1; indexOf >= 0; indexOf--) {
            f fVar2 = (f) this.e.get(indexOf);
            if (fVar2.I == viewGroup && fVar2.J != null) {
                return fVar2;
            }
        }
        return null;
    }

    private void x() {
        if (c()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.v != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can not perform this action inside of ");
            stringBuilder.append(this.v);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void y() {
        this.c = false;
        this.y.clear();
        this.x.clear();
    }

    private void z() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                ((i) this.C.remove(0)).d();
            }
        }
    }

    public f a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        f fVar = (f) this.f.get(i);
        if (fVar == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment no longer exists for key ");
            stringBuilder.append(str);
            stringBuilder.append(": index ");
            stringBuilder.append(i);
            a(new IllegalStateException(stringBuilder.toString()));
        }
        return fVar;
    }

    public f a(String str) {
        int size;
        f fVar;
        if (str != null) {
            for (size = this.e.size() - 1; size >= 0; size--) {
                fVar = (f) this.e.get(size);
                if (fVar != null && str.equals(fVar.A)) {
                    return fVar;
                }
            }
        }
        if (!(this.f == null || str == null)) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fVar = (f) this.f.valueAt(size);
                if (fVar != null && str.equals(fVar.A)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    c a(f fVar, int i, boolean z, int i2) {
        int P = fVar.P();
        Animation a = fVar.a(i, z, P);
        if (a != null) {
            return new c(a);
        }
        Animator b = fVar.b(i, z, P);
        if (b != null) {
            return new c(b);
        }
        if (P != 0) {
            boolean equals = "anim".equals(this.m.g().getResources().getResourceTypeName(P));
            Object obj = null;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.m.g(), P);
                    if (loadAnimation != null) {
                        return new c(loadAnimation);
                    }
                    obj = 1;
                } catch (NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                    if (obj == null) {
                        try {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(this.m.g(), P);
                            if (loadAnimator != null) {
                                return new c(loadAnimator);
                            }
                        } catch (RuntimeException e2) {
                            if (equals) {
                                throw e2;
                            }
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.m.g(), P);
                            if (loadAnimation2 != null) {
                                return new c(loadAnimation2);
                            }
                        }
                    }
                }
            }
        }
        if (i == 0) {
            return null;
        }
        i = b(i, z);
        if (i < 0) {
            return null;
        }
        switch (i) {
            case 1:
                return a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.m.g(), 0.0f, 1.0f);
            case 6:
                return a(this.m.g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.m.d()) {
                    i2 = this.m.e();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    public void a(int i, c cVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList();
            }
            int size = this.i.size();
            StringBuilder stringBuilder;
            if (i < size) {
                if (a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Setting back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" to ");
                    stringBuilder.append(cVar);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                this.i.set(i, cVar);
            } else {
                while (size < i) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList();
                    }
                    if (a) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Adding available back stack index ");
                        stringBuilder2.append(size);
                        Log.v("FragmentManager", stringBuilder2.toString());
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Adding back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" with ");
                    stringBuilder.append(cVar);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                this.i.add(cVar);
            }
        }
    }

    void a(int i, boolean z) {
        if (this.m == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.l) {
            this.l = i;
            if (this.f != null) {
                int i2;
                i = this.e.size();
                for (i2 = 0; i2 < i; i2++) {
                    e((f) this.e.get(i2));
                }
                i = this.f.size();
                for (i2 = 0; i2 < i; i2++) {
                    f fVar = (f) this.f.valueAt(i2);
                    if (fVar != null && ((fVar.m || fVar.C) && !fVar.O)) {
                        e(fVar);
                    }
                }
                d();
                if (this.r && this.m != null && this.l == 4) {
                    this.m.c();
                    this.r = false;
                }
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i = 0; i < this.e.size(); i++) {
            f fVar = (f) this.e.get(i);
            if (fVar != null) {
                fVar.a(configuration);
            }
        }
    }

    public void a(Bundle bundle, String str, f fVar) {
        if (fVar.f < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(fVar);
            stringBuilder.append(" is not currently in the FragmentManager");
            a(new IllegalStateException(stringBuilder.toString()));
        }
        bundle.putInt(str, fVar.f);
    }

    void a(Parcelable parcelable, m mVar) {
        if (parcelable != null) {
            n nVar = (n) parcelable;
            if (nVar.a != null) {
                List b;
                List c;
                int i;
                if (mVar != null) {
                    List a = mVar.a();
                    b = mVar.b();
                    c = mVar.c();
                    int size = a != null ? a.size() : 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = (f) a.get(i2);
                        if (a) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("restoreAllState: re-attaching retained ");
                            stringBuilder.append(fVar);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                        int i3 = 0;
                        while (i3 < nVar.a.length && nVar.a[i3].b != fVar.f) {
                            i3++;
                        }
                        if (i3 == nVar.a.length) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Could not find active fragment with index ");
                            stringBuilder2.append(fVar.f);
                            a(new IllegalStateException(stringBuilder2.toString()));
                        }
                        o oVar = nVar.a[i3];
                        oVar.l = fVar;
                        fVar.d = null;
                        fVar.r = 0;
                        fVar.o = false;
                        fVar.l = false;
                        fVar.i = null;
                        if (oVar.k != null) {
                            oVar.k.setClassLoader(this.m.g().getClassLoader());
                            fVar.d = oVar.k.getSparseParcelableArray("android:view_state");
                            fVar.c = oVar.k;
                        }
                    }
                } else {
                    b = null;
                    c = b;
                }
                this.f = new SparseArray(nVar.a.length);
                int i4 = 0;
                while (i4 < nVar.a.length) {
                    o oVar2 = nVar.a[i4];
                    if (oVar2 != null) {
                        m mVar2 = (b == null || i4 >= b.size()) ? null : (m) b.get(i4);
                        p pVar = (c == null || i4 >= c.size()) ? null : (p) c.get(i4);
                        f a2 = oVar2.a(this.m, this.n, this.o, mVar2, pVar);
                        if (a) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("restoreAllState: active #");
                            stringBuilder3.append(i4);
                            stringBuilder3.append(": ");
                            stringBuilder3.append(a2);
                            Log.v("FragmentManager", stringBuilder3.toString());
                        }
                        this.f.put(a2.f, a2);
                        oVar2.l = null;
                    }
                    i4++;
                }
                if (mVar != null) {
                    List a3 = mVar.a();
                    i4 = a3 != null ? a3.size() : 0;
                    for (int i5 = 0; i5 < i4; i5++) {
                        f fVar2 = (f) a3.get(i5);
                        if (fVar2.j >= 0) {
                            fVar2.i = (f) this.f.get(fVar2.j);
                            if (fVar2.i == null) {
                                StringBuilder stringBuilder4 = new StringBuilder();
                                stringBuilder4.append("Re-attaching retained fragment ");
                                stringBuilder4.append(fVar2);
                                stringBuilder4.append(" target no longer exists: ");
                                stringBuilder4.append(fVar2.j);
                                Log.w("FragmentManager", stringBuilder4.toString());
                            }
                        }
                    }
                }
                this.e.clear();
                if (nVar.b != null) {
                    for (i = 0; i < nVar.b.length; i++) {
                        StringBuilder stringBuilder5;
                        f fVar3 = (f) this.f.get(nVar.b[i]);
                        if (fVar3 == null) {
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("No instantiated fragment for index #");
                            stringBuilder5.append(nVar.b[i]);
                            a(new IllegalStateException(stringBuilder5.toString()));
                        }
                        fVar3.l = true;
                        if (a) {
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("restoreAllState: added #");
                            stringBuilder5.append(i);
                            stringBuilder5.append(": ");
                            stringBuilder5.append(fVar3);
                            Log.v("FragmentManager", stringBuilder5.toString());
                        }
                        if (this.e.contains(fVar3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.e) {
                            this.e.add(fVar3);
                        }
                    }
                }
                if (nVar.c != null) {
                    this.g = new ArrayList(nVar.c.length);
                    for (i = 0; i < nVar.c.length; i++) {
                        c a4 = nVar.c[i].a(this);
                        if (a) {
                            StringBuilder stringBuilder6 = new StringBuilder();
                            stringBuilder6.append("restoreAllState: back stack #");
                            stringBuilder6.append(i);
                            stringBuilder6.append(" (index ");
                            stringBuilder6.append(a4.m);
                            stringBuilder6.append("): ");
                            stringBuilder6.append(a4);
                            Log.v("FragmentManager", stringBuilder6.toString());
                            PrintWriter printWriter = new PrintWriter(new android.support.v4.g.e("FragmentManager"));
                            a4.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.g.add(a4);
                        if (a4.m >= 0) {
                            a(a4.m, a4);
                        }
                    }
                } else {
                    this.g = null;
                }
                if (nVar.d >= 0) {
                    this.p = (f) this.f.get(nVar.d);
                }
                this.d = nVar.e;
            }
        }
    }

    void a(c cVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(cVar);
    }

    void a(c cVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            cVar.a(z3);
        } else {
            cVar.b();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(cVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            q.a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.l, true);
        }
        if (this.f != null) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.f.valueAt(i);
                if (fVar != null && fVar.J != null && fVar.O && cVar.b(fVar.z)) {
                    if (fVar.Q > 0.0f) {
                        fVar.J.setAlpha(fVar.Q);
                    }
                    if (z3) {
                        fVar.Q = 0.0f;
                    } else {
                        fVar.Q = -1.0f;
                        fVar.O = false;
                    }
                }
            }
        }
    }

    public void a(f fVar) {
        if (fVar.L) {
            if (this.c) {
                this.w = true;
                return;
            }
            fVar.L = false;
            a(fVar, this.l, 0, 0, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:208:0x0440  */
    /* JADX WARNING: Missing block: B:83:0x01aa, code:
            c(r7);
     */
    /* JADX WARNING: Missing block: B:84:0x01ad, code:
            if (r11 <= 1) goto L_0x02a4;
     */
    /* JADX WARNING: Missing block: B:86:0x01b1, code:
            if (a == false) goto L_0x01c9;
     */
    /* JADX WARNING: Missing block: B:87:0x01b3, code:
            r1 = new java.lang.StringBuilder();
            r1.append("moveto ACTIVITY_CREATED: ");
            r1.append(r7);
            android.util.Log.v("FragmentManager", r1.toString());
     */
    /* JADX WARNING: Missing block: B:89:0x01cb, code:
            if (r7.n != false) goto L_0x028f;
     */
    /* JADX WARNING: Missing block: B:91:0x01cf, code:
            if (r7.z == 0) goto L_0x0241;
     */
    /* JADX WARNING: Missing block: B:93:0x01d4, code:
            if (r7.z != -1) goto L_0x01f4;
     */
    /* JADX WARNING: Missing block: B:94:0x01d6, code:
            r1 = new java.lang.StringBuilder();
            r1.append("Cannot create fragment ");
            r1.append(r7);
            r1.append(" for a container view with no id");
            a(new java.lang.IllegalArgumentException(r1.toString()));
     */
    /* JADX WARNING: Missing block: B:95:0x01f4, code:
            r0 = (android.view.ViewGroup) r6.n.a(r7.z);
     */
    /* JADX WARNING: Missing block: B:96:0x01fe, code:
            if (r0 != null) goto L_0x0242;
     */
    /* JADX WARNING: Missing block: B:98:0x0202, code:
            if (r7.p != false) goto L_0x0242;
     */
    /* JADX WARNING: Missing block: B:100:?, code:
            r1 = r7.h().getResourceName(r7.z);
     */
    /* JADX WARNING: Missing block: B:101:0x020f, code:
            r1 = "unknown";
     */
    /* JADX WARNING: Missing block: B:103:0x0241, code:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:143:0x031c, code:
            if (r11 >= 3) goto L_0x033e;
     */
    /* JADX WARNING: Missing block: B:145:0x0320, code:
            if (a == false) goto L_0x0338;
     */
    /* JADX WARNING: Missing block: B:146:0x0322, code:
            r1 = new java.lang.StringBuilder();
            r1.append("movefrom STARTED: ");
            r1.append(r7);
            android.util.Log.v("FragmentManager", r1.toString());
     */
    /* JADX WARNING: Missing block: B:147:0x0338, code:
            r7.L();
            e(r7, false);
     */
    /* JADX WARNING: Missing block: B:148:0x033e, code:
            if (r11 >= 2) goto L_0x03c5;
     */
    /* JADX WARNING: Missing block: B:150:0x0342, code:
            if (a == false) goto L_0x035a;
     */
    /* JADX WARNING: Missing block: B:151:0x0344, code:
            r1 = new java.lang.StringBuilder();
            r1.append("movefrom ACTIVITY_CREATED: ");
            r1.append(r7);
            android.util.Log.v("FragmentManager", r1.toString());
     */
    /* JADX WARNING: Missing block: B:153:0x035c, code:
            if (r7.J == null) goto L_0x036d;
     */
    /* JADX WARNING: Missing block: B:155:0x0364, code:
            if (r6.m.a(r7) == false) goto L_0x036d;
     */
    /* JADX WARNING: Missing block: B:157:0x0368, code:
            if (r7.d != null) goto L_0x036d;
     */
    /* JADX WARNING: Missing block: B:158:0x036a, code:
            m(r7);
     */
    /* JADX WARNING: Missing block: B:159:0x036d, code:
            r7.M();
            f(r7, false);
     */
    /* JADX WARNING: Missing block: B:160:0x0375, code:
            if (r7.J == null) goto L_0x03b6;
     */
    /* JADX WARNING: Missing block: B:162:0x0379, code:
            if (r7.I == null) goto L_0x03b6;
     */
    /* JADX WARNING: Missing block: B:163:0x037b, code:
            r7.I.endViewTransition(r7.J);
            r7.J.clearAnimation();
     */
    /* JADX WARNING: Missing block: B:164:0x038a, code:
            if (r6.l <= 0) goto L_0x03a7;
     */
    /* JADX WARNING: Missing block: B:166:0x038e, code:
            if (r6.u != false) goto L_0x03a7;
     */
    /* JADX WARNING: Missing block: B:168:0x0396, code:
            if (r7.J.getVisibility() != 0) goto L_0x03a7;
     */
    /* JADX WARNING: Missing block: B:170:0x039c, code:
            if (r7.Q < 0.0f) goto L_0x03a7;
     */
    /* JADX WARNING: Missing block: B:171:0x039e, code:
            r0 = a(r7, r17, false, r18);
     */
    /* JADX WARNING: Missing block: B:172:0x03a7, code:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:173:0x03a8, code:
            r7.Q = 0.0f;
     */
    /* JADX WARNING: Missing block: B:174:0x03aa, code:
            if (r0 == null) goto L_0x03af;
     */
    /* JADX WARNING: Missing block: B:175:0x03ac, code:
            a(r7, r0, r11);
     */
    /* JADX WARNING: Missing block: B:176:0x03af, code:
            r7.I.removeView(r7.J);
     */
    /* JADX WARNING: Missing block: B:177:0x03b6, code:
            r7.I = null;
            r7.J = null;
            r7.V = null;
            r7.W.a(null);
            r7.K = null;
            r7.o = false;
     */
    /* JADX WARNING: Missing block: B:178:0x03c5, code:
            if (r11 >= 1) goto L_0x043b;
     */
    /* JADX WARNING: Missing block: B:180:0x03c9, code:
            if (r6.u == false) goto L_0x03ec;
     */
    /* JADX WARNING: Missing block: B:182:0x03cf, code:
            if (r7.U() == null) goto L_0x03dc;
     */
    /* JADX WARNING: Missing block: B:183:0x03d1, code:
            r0 = r7.U();
            r7.a(null);
            r0.clearAnimation();
     */
    /* JADX WARNING: Missing block: B:185:0x03e0, code:
            if (r7.V() == null) goto L_0x03ec;
     */
    /* JADX WARNING: Missing block: B:186:0x03e2, code:
            r0 = r7.V();
            r7.a(null);
            r0.cancel();
     */
    /* JADX WARNING: Missing block: B:188:0x03f0, code:
            if (r7.U() != null) goto L_0x0437;
     */
    /* JADX WARNING: Missing block: B:190:0x03f6, code:
            if (r7.V() == null) goto L_0x03f9;
     */
    /* JADX WARNING: Missing block: B:192:0x03fb, code:
            if (a == false) goto L_0x0413;
     */
    /* JADX WARNING: Missing block: B:193:0x03fd, code:
            r1 = new java.lang.StringBuilder();
            r1.append("movefrom CREATED: ");
            r1.append(r7);
            android.util.Log.v("FragmentManager", r1.toString());
     */
    /* JADX WARNING: Missing block: B:195:0x0415, code:
            if (r7.E != false) goto L_0x041e;
     */
    /* JADX WARNING: Missing block: B:196:0x0417, code:
            r7.N();
            g(r7, false);
     */
    /* JADX WARNING: Missing block: B:197:0x041e, code:
            r7.b = 0;
     */
    /* JADX WARNING: Missing block: B:198:0x0420, code:
            r7.O();
            h(r7, false);
     */
    /* JADX WARNING: Missing block: B:199:0x0426, code:
            if (r19 != false) goto L_0x043b;
     */
    /* JADX WARNING: Missing block: B:201:0x042a, code:
            if (r7.E != false) goto L_0x0430;
     */
    /* JADX WARNING: Missing block: B:202:0x042c, code:
            g(r7);
     */
    /* JADX WARNING: Missing block: B:203:0x0430, code:
            r7.t = null;
            r7.x = null;
            r7.s = null;
     */
    /* JADX WARNING: Missing block: B:204:0x0437, code:
            r7.b(r11);
     */
    void a(android.support.v4.app.f r15, int r16, int r17, int r18, boolean r19) {
        /*
        r14 = this;
        r6 = r14;
        r7 = r15;
        r0 = r7.l;
        r8 = 1;
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r0 = r7.C;
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x000f;
    L_0x000c:
        r0 = r16;
        goto L_0x0014;
    L_0x000f:
        r0 = r16;
        if (r0 <= r8) goto L_0x0014;
    L_0x0013:
        r0 = r8;
    L_0x0014:
        r1 = r7.m;
        if (r1 == 0) goto L_0x002a;
    L_0x0018:
        r1 = r7.b;
        if (r0 <= r1) goto L_0x002a;
    L_0x001c:
        r0 = r7.b;
        if (r0 != 0) goto L_0x0028;
    L_0x0020:
        r0 = r7.c();
        if (r0 == 0) goto L_0x0028;
    L_0x0026:
        r0 = r8;
        goto L_0x002a;
    L_0x0028:
        r0 = r7.b;
    L_0x002a:
        r1 = r7.L;
        r9 = 3;
        r10 = 2;
        if (r1 == 0) goto L_0x0038;
    L_0x0030:
        r1 = r7.b;
        if (r1 >= r9) goto L_0x0038;
    L_0x0034:
        if (r0 <= r10) goto L_0x0038;
    L_0x0036:
        r11 = r10;
        goto L_0x0039;
    L_0x0038:
        r11 = r0;
    L_0x0039:
        r0 = r7.b;
        r12 = 0;
        r13 = 0;
        if (r0 > r11) goto L_0x02ee;
    L_0x003f:
        r0 = r7.n;
        if (r0 == 0) goto L_0x0048;
    L_0x0043:
        r0 = r7.o;
        if (r0 != 0) goto L_0x0048;
    L_0x0047:
        return;
    L_0x0048:
        r0 = r7.U();
        if (r0 != 0) goto L_0x0054;
    L_0x004e:
        r0 = r7.V();
        if (r0 == 0) goto L_0x0066;
    L_0x0054:
        r7.a(r12);
        r7.a(r12);
        r2 = r7.W();
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r6;
        r1 = r7;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0066:
        r0 = r7.b;
        switch(r0) {
            case 0: goto L_0x006d;
            case 1: goto L_0x01aa;
            case 2: goto L_0x02a4;
            case 3: goto L_0x02c6;
            default: goto L_0x006b;
        };
    L_0x006b:
        goto L_0x043b;
    L_0x006d:
        if (r11 <= 0) goto L_0x01aa;
    L_0x006f:
        r0 = a;
        if (r0 == 0) goto L_0x0089;
    L_0x0073:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0089:
        r0 = r7.c;
        if (r0 == 0) goto L_0x00e0;
    L_0x008d:
        r0 = r7.c;
        r1 = r6.m;
        r1 = r1.g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r7.c;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r7.d = r0;
        r0 = r7.c;
        r1 = "android:target_state";
        r0 = r6.a(r0, r1);
        r7.i = r0;
        r0 = r7.i;
        if (r0 == 0) goto L_0x00be;
    L_0x00b4:
        r0 = r7.c;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r13);
        r7.k = r0;
    L_0x00be:
        r0 = r7.e;
        if (r0 == 0) goto L_0x00cd;
    L_0x00c2:
        r0 = r7.e;
        r0 = r0.booleanValue();
        r7.M = r0;
        r7.e = r12;
        goto L_0x00d7;
    L_0x00cd:
        r0 = r7.c;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r8);
        r7.M = r0;
    L_0x00d7:
        r0 = r7.M;
        if (r0 != 0) goto L_0x00e0;
    L_0x00db:
        r7.L = r8;
        if (r11 <= r10) goto L_0x00e0;
    L_0x00df:
        r11 = r10;
    L_0x00e0:
        r0 = r6.m;
        r7.t = r0;
        r0 = r6.o;
        r7.x = r0;
        r0 = r6.o;
        if (r0 == 0) goto L_0x00f1;
    L_0x00ec:
        r0 = r6.o;
        r0 = r0.u;
        goto L_0x00f7;
    L_0x00f1:
        r0 = r6.m;
        r0 = r0.i();
    L_0x00f7:
        r7.s = r0;
        r0 = r7.i;
        if (r0 == 0) goto L_0x0141;
    L_0x00fd:
        r0 = r6.f;
        r1 = r7.i;
        r1 = r1.f;
        r0 = r0.get(r1);
        r1 = r7.i;
        if (r0 == r1) goto L_0x0131;
    L_0x010b:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1.append(r2);
        r1.append(r7);
        r2 = " declared target fragment ";
        r1.append(r2);
        r2 = r7.i;
        r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0131:
        r0 = r7.i;
        r0 = r0.b;
        if (r0 >= r8) goto L_0x0141;
    L_0x0137:
        r1 = r7.i;
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r6;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0141:
        r0 = r6.m;
        r0 = r0.g();
        r6.a(r7, r0, r13);
        r7.H = r13;
        r0 = r6.m;
        r0 = r0.g();
        r7.a(r0);
        r0 = r7.H;
        if (r0 != 0) goto L_0x0175;
    L_0x0159:
        r0 = new android.support.v4.app.x;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1.append(r2);
        r1.append(r7);
        r2 = " did not call through to super.onAttach()";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0175:
        r0 = r7.x;
        if (r0 != 0) goto L_0x017f;
    L_0x0179:
        r0 = r6.m;
        r0.b(r7);
        goto L_0x0184;
    L_0x017f:
        r0 = r7.x;
        r0.a(r7);
    L_0x0184:
        r0 = r6.m;
        r0 = r0.g();
        r6.b(r7, r0, r13);
        r0 = r7.S;
        if (r0 != 0) goto L_0x01a1;
    L_0x0191:
        r0 = r7.c;
        r6.a(r7, r0, r13);
        r0 = r7.c;
        r7.k(r0);
        r0 = r7.c;
        r6.b(r7, r0, r13);
        goto L_0x01a8;
    L_0x01a1:
        r0 = r7.c;
        r7.g(r0);
        r7.b = r8;
    L_0x01a8:
        r7.E = r13;
    L_0x01aa:
        r6.c(r7);
        if (r11 <= r8) goto L_0x02a4;
    L_0x01af:
        r0 = a;
        if (r0 == 0) goto L_0x01c9;
    L_0x01b3:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x01c9:
        r0 = r7.n;
        if (r0 != 0) goto L_0x028f;
    L_0x01cd:
        r0 = r7.z;
        if (r0 == 0) goto L_0x0241;
    L_0x01d1:
        r0 = r7.z;
        r1 = -1;
        if (r0 != r1) goto L_0x01f4;
    L_0x01d6:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1.append(r2);
        r1.append(r7);
        r2 = " for a container view with no id";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r6.a(r0);
    L_0x01f4:
        r0 = r6.n;
        r1 = r7.z;
        r0 = r0.a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0242;
    L_0x0200:
        r1 = r7.p;
        if (r1 != 0) goto L_0x0242;
    L_0x0204:
        r1 = r7.h();	 Catch:{ NotFoundException -> 0x020f }
        r2 = r7.z;	 Catch:{ NotFoundException -> 0x020f }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x020f }
        goto L_0x0211;
    L_0x020f:
        r1 = "unknown";
    L_0x0211:
        r2 = new java.lang.IllegalArgumentException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "No view found for id 0x";
        r3.append(r4);
        r4 = r7.z;
        r4 = java.lang.Integer.toHexString(r4);
        r3.append(r4);
        r4 = " (";
        r3.append(r4);
        r3.append(r1);
        r1 = ") for fragment ";
        r3.append(r1);
        r3.append(r7);
        r1 = r3.toString();
        r2.<init>(r1);
        r6.a(r2);
        goto L_0x0242;
    L_0x0241:
        r0 = r12;
    L_0x0242:
        r7.I = r0;
        r1 = r7.c;
        r1 = r7.d(r1);
        r2 = r7.c;
        r7.b(r1, r0, r2);
        r1 = r7.J;
        if (r1 == 0) goto L_0x028d;
    L_0x0253:
        r1 = r7.J;
        r7.K = r1;
        r1 = r7.J;
        r1.setSaveFromParentEnabled(r13);
        if (r0 == 0) goto L_0x0263;
    L_0x025e:
        r1 = r7.J;
        r0.addView(r1);
    L_0x0263:
        r0 = r7.B;
        if (r0 == 0) goto L_0x026e;
    L_0x0267:
        r0 = r7.J;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x026e:
        r0 = r7.J;
        r1 = r7.c;
        r7.a(r0, r1);
        r0 = r7.J;
        r1 = r7.c;
        r6.a(r7, r0, r1, r13);
        r0 = r7.J;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0289;
    L_0x0284:
        r0 = r7.I;
        if (r0 == 0) goto L_0x0289;
    L_0x0288:
        goto L_0x028a;
    L_0x0289:
        r8 = r13;
    L_0x028a:
        r7.O = r8;
        goto L_0x028f;
    L_0x028d:
        r7.K = r12;
    L_0x028f:
        r0 = r7.c;
        r7.l(r0);
        r0 = r7.c;
        r6.c(r7, r0, r13);
        r0 = r7.J;
        if (r0 == 0) goto L_0x02a2;
    L_0x029d:
        r0 = r7.c;
        r7.a(r0);
    L_0x02a2:
        r7.c = r12;
    L_0x02a4:
        if (r11 <= r10) goto L_0x02c6;
    L_0x02a6:
        r0 = a;
        if (r0 == 0) goto L_0x02c0;
    L_0x02aa:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02c0:
        r7.G();
        r6.b(r7, r13);
    L_0x02c6:
        if (r11 <= r9) goto L_0x043b;
    L_0x02c8:
        r0 = a;
        if (r0 == 0) goto L_0x02e2;
    L_0x02cc:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02e2:
        r7.H();
        r6.c(r7, r13);
        r7.c = r12;
        r7.d = r12;
        goto L_0x043b;
    L_0x02ee:
        r0 = r7.b;
        if (r0 <= r11) goto L_0x043b;
    L_0x02f2:
        r0 = r7.b;
        switch(r0) {
            case 1: goto L_0x03c5;
            case 2: goto L_0x033e;
            case 3: goto L_0x031c;
            case 4: goto L_0x02f9;
            default: goto L_0x02f7;
        };
    L_0x02f7:
        goto L_0x043b;
    L_0x02f9:
        r0 = 4;
        if (r11 >= r0) goto L_0x031c;
    L_0x02fc:
        r0 = a;
        if (r0 == 0) goto L_0x0316;
    L_0x0300:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0316:
        r7.K();
        r6.d(r7, r13);
    L_0x031c:
        if (r11 >= r9) goto L_0x033e;
    L_0x031e:
        r0 = a;
        if (r0 == 0) goto L_0x0338;
    L_0x0322:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0338:
        r7.L();
        r6.e(r7, r13);
    L_0x033e:
        if (r11 >= r10) goto L_0x03c5;
    L_0x0340:
        r0 = a;
        if (r0 == 0) goto L_0x035a;
    L_0x0344:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x035a:
        r0 = r7.J;
        if (r0 == 0) goto L_0x036d;
    L_0x035e:
        r0 = r6.m;
        r0 = r0.a(r7);
        if (r0 == 0) goto L_0x036d;
    L_0x0366:
        r0 = r7.d;
        if (r0 != 0) goto L_0x036d;
    L_0x036a:
        r6.m(r7);
    L_0x036d:
        r7.M();
        r6.f(r7, r13);
        r0 = r7.J;
        if (r0 == 0) goto L_0x03b6;
    L_0x0377:
        r0 = r7.I;
        if (r0 == 0) goto L_0x03b6;
    L_0x037b:
        r0 = r7.I;
        r1 = r7.J;
        r0.endViewTransition(r1);
        r0 = r7.J;
        r0.clearAnimation();
        r0 = r6.l;
        r1 = 0;
        if (r0 <= 0) goto L_0x03a7;
    L_0x038c:
        r0 = r6.u;
        if (r0 != 0) goto L_0x03a7;
    L_0x0390:
        r0 = r7.J;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x03a7;
    L_0x0398:
        r0 = r7.Q;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x03a7;
    L_0x039e:
        r0 = r17;
        r2 = r18;
        r0 = r6.a(r7, r0, r13, r2);
        goto L_0x03a8;
    L_0x03a7:
        r0 = r12;
    L_0x03a8:
        r7.Q = r1;
        if (r0 == 0) goto L_0x03af;
    L_0x03ac:
        r6.a(r7, r0, r11);
    L_0x03af:
        r0 = r7.I;
        r1 = r7.J;
        r0.removeView(r1);
    L_0x03b6:
        r7.I = r12;
        r7.J = r12;
        r7.V = r12;
        r0 = r7.W;
        r0.a(r12);
        r7.K = r12;
        r7.o = r13;
    L_0x03c5:
        if (r11 >= r8) goto L_0x043b;
    L_0x03c7:
        r0 = r6.u;
        if (r0 == 0) goto L_0x03ec;
    L_0x03cb:
        r0 = r7.U();
        if (r0 == 0) goto L_0x03dc;
    L_0x03d1:
        r0 = r7.U();
        r7.a(r12);
        r0.clearAnimation();
        goto L_0x03ec;
    L_0x03dc:
        r0 = r7.V();
        if (r0 == 0) goto L_0x03ec;
    L_0x03e2:
        r0 = r7.V();
        r7.a(r12);
        r0.cancel();
    L_0x03ec:
        r0 = r7.U();
        if (r0 != 0) goto L_0x0437;
    L_0x03f2:
        r0 = r7.V();
        if (r0 == 0) goto L_0x03f9;
    L_0x03f8:
        goto L_0x0437;
    L_0x03f9:
        r0 = a;
        if (r0 == 0) goto L_0x0413;
    L_0x03fd:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0413:
        r0 = r7.E;
        if (r0 != 0) goto L_0x041e;
    L_0x0417:
        r7.N();
        r6.g(r7, r13);
        goto L_0x0420;
    L_0x041e:
        r7.b = r13;
    L_0x0420:
        r7.O();
        r6.h(r7, r13);
        if (r19 != 0) goto L_0x043b;
    L_0x0428:
        r0 = r7.E;
        if (r0 != 0) goto L_0x0430;
    L_0x042c:
        r6.g(r7);
        goto L_0x043b;
    L_0x0430:
        r7.t = r12;
        r7.x = r12;
        r7.s = r12;
        goto L_0x043b;
    L_0x0437:
        r7.b(r11);
        goto L_0x043c;
    L_0x043b:
        r8 = r11;
    L_0x043c:
        r0 = r7.b;
        if (r0 == r8) goto L_0x046f;
    L_0x0440:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1.append(r2);
        r1.append(r7);
        r2 = " not updated inline; ";
        r1.append(r2);
        r2 = "expected state ";
        r1.append(r2);
        r1.append(r8);
        r2 = " found ";
        r1.append(r2);
        r2 = r7.b;
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r7.b = r8;
    L_0x046f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.l.a(android.support.v4.app.f, int, int, int, boolean):void");
    }

    void a(f fVar, Context context, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).a(fVar, context, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.a((k) this, fVar, context);
            }
        }
    }

    void a(f fVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).a(fVar, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.a((k) this, fVar, bundle);
            }
        }
    }

    void a(f fVar, View view, Bundle bundle, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).a(fVar, view, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.a(this, fVar, view, bundle);
            }
        }
    }

    public void a(f fVar, boolean z) {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("add: ");
            stringBuilder.append(fVar);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        f(fVar);
        if (!fVar.C) {
            if (this.e.contains(fVar)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Fragment already added: ");
                stringBuilder2.append(fVar);
                throw new IllegalStateException(stringBuilder2.toString());
            }
            synchronized (this.e) {
                this.e.add(fVar);
            }
            fVar.l = true;
            fVar.m = false;
            if (fVar.J == null) {
                fVar.P = false;
            }
            if (fVar.F && fVar.G) {
                this.r = true;
            }
            if (z) {
                b(fVar);
            }
        }
    }

    public void a(j jVar, h hVar, f fVar) {
        if (this.m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.m = jVar;
        this.n = hVar;
        this.o = fVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        f fVar;
        int size2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("    ");
        String stringBuilder2 = stringBuilder.toString();
        int i2 = 0;
        if (this.f != null) {
            size = this.f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fVar = (f) this.f.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fVar);
                    if (fVar != null) {
                        fVar.a(stringBuilder2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.e.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                fVar = (f) this.e.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fVar.toString());
            }
        }
        if (this.h != null) {
            size = this.h.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fVar = (f) this.h.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fVar.toString());
                }
            }
        }
        if (this.g != null) {
            size = this.g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    c cVar = (c) this.g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(cVar.toString());
                    cVar.a(stringBuilder2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.i != null) {
                size2 = this.i.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i3 = 0; i3 < size2; i3++) {
                        c cVar2 = (c) this.i.get(i3);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i3);
                        printWriter.print(": ");
                        printWriter.println(cVar2);
                    }
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        if (this.b != null) {
            size2 = this.b.size();
            if (size2 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < size2) {
                    h hVar = (h) this.b.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(hVar);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
    }

    public void a(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            f fVar = (f) this.e.get(size);
            if (fVar != null) {
                fVar.d(z);
            }
        }
    }

    public boolean a() {
        x();
        return a(null, -1, 0);
    }

    boolean a(int i) {
        return this.l >= i;
    }

    public boolean a(Menu menu) {
        int i = 0;
        if (this.l < 1) {
            return false;
        }
        boolean z = false;
        while (i < this.e.size()) {
            f fVar = (f) this.e.get(i);
            if (fVar != null && fVar.c(menu)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        if (this.l < 1) {
            return false;
        }
        ArrayList arrayList = null;
        int i2 = 0;
        boolean z = i2;
        while (i2 < this.e.size()) {
            f fVar = (f) this.e.get(i2);
            if (fVar != null && fVar.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fVar);
                z = true;
            }
            i2++;
        }
        if (this.h != null) {
            while (i < this.h.size()) {
                f fVar2 = (f) this.h.get(i);
                if (arrayList == null || !arrayList.contains(fVar2)) {
                    fVar2.u();
                }
                i++;
            }
        }
        this.h = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            f fVar = (f) this.e.get(i);
            if (fVar != null && fVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.g == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size));
            arrayList2.add(Boolean.valueOf(true));
            return true;
        }
        int size2;
        if (str != null || i >= 0) {
            size2 = this.g.size() - 1;
            while (size2 >= 0) {
                c cVar = (c) this.g.get(size2);
                if ((str != null && str.equals(cVar.d())) || (i >= 0 && i == cVar.m)) {
                    break;
                }
                size2--;
            }
            if (size2 < 0) {
                return false;
            }
            if ((i2 & 1) != 0) {
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        break;
                    }
                    c cVar2 = (c) this.g.get(size2);
                    if (str == null || !str.equals(cVar2.d())) {
                        if (i < 0 || i != cVar2.m) {
                            break;
                        }
                    }
                }
            }
        } else {
            size2 = -1;
        }
        if (size2 == this.g.size() - 1) {
            return false;
        }
        for (size = this.g.size() - 1; size > size2; size--) {
            arrayList.add(this.g.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        }
        return true;
    }

    public f b(int i) {
        int size;
        f fVar;
        for (size = this.e.size() - 1; size >= 0; size--) {
            fVar = (f) this.e.get(size);
            if (fVar != null && fVar.y == i) {
                return fVar;
            }
        }
        if (this.f != null) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fVar = (f) this.f.valueAt(size);
                if (fVar != null && fVar.y == i) {
                    return fVar;
                }
            }
        }
        return null;
    }

    public f b(String str) {
        if (!(this.f == null || str == null)) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                f fVar = (f) this.f.valueAt(size);
                if (fVar != null) {
                    fVar = fVar.a(str);
                    if (fVar != null) {
                        return fVar;
                    }
                }
            }
        }
        return null;
    }

    public List<f> b() {
        if (this.e.isEmpty()) {
            return Collections.emptyList();
        }
        List<f> list;
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    void b(f fVar) {
        a(fVar, this.l, 0, 0, false);
    }

    void b(f fVar, Context context, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).b(fVar, context, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.b((k) this, fVar, context);
            }
        }
    }

    void b(f fVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).b(fVar, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.b((k) this, fVar, bundle);
            }
        }
    }

    void b(f fVar, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).b(fVar, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.a(this, fVar);
            }
        }
    }

    public void b(Menu menu) {
        if (this.l >= 1) {
            for (int i = 0; i < this.e.size(); i++) {
                f fVar = (f) this.e.get(i);
                if (fVar != null) {
                    fVar.d(menu);
                }
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            f fVar = (f) this.e.get(size);
            if (fVar != null) {
                fVar.e(z);
            }
        }
    }

    public boolean b(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            f fVar = (f) this.e.get(i);
            if (fVar != null && fVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void c(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList();
            }
            if (a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing back stack index ");
                stringBuilder.append(i);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    void c(f fVar) {
        if (fVar.n && !fVar.q) {
            fVar.b(fVar.d(fVar.c), null, fVar.c);
            if (fVar.J != null) {
                fVar.K = fVar.J;
                fVar.J.setSaveFromParentEnabled(false);
                if (fVar.B) {
                    fVar.J.setVisibility(8);
                }
                fVar.a(fVar.J, fVar.c);
                a(fVar, fVar.J, fVar.c, false);
                return;
            }
            fVar.K = null;
        }
    }

    void c(f fVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).c(fVar, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.c(this, fVar, bundle);
            }
        }
    }

    void c(f fVar, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).c(fVar, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.b(this, fVar);
            }
        }
    }

    public boolean c() {
        return this.s || this.t;
    }

    void d() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                f fVar = (f) this.f.valueAt(i);
                if (fVar != null) {
                    a(fVar);
                }
            }
        }
    }

    void d(final f fVar) {
        if (fVar.J != null) {
            c a = a(fVar, fVar.Q(), fVar.B ^ true, fVar.R());
            if (a == null || a.b == null) {
                if (a != null) {
                    b(fVar.J, a);
                    fVar.J.startAnimation(a.a);
                    a.a.start();
                }
                int i = (!fVar.B || fVar.Y()) ? 0 : 8;
                fVar.J.setVisibility(i);
                if (fVar.Y()) {
                    fVar.f(false);
                }
            } else {
                a.b.setTarget(fVar.J);
                if (!fVar.B) {
                    fVar.J.setVisibility(0);
                } else if (fVar.Y()) {
                    fVar.f(false);
                } else {
                    final ViewGroup viewGroup = fVar.I;
                    final View view = fVar.J;
                    viewGroup.startViewTransition(view);
                    a.b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fVar.J != null) {
                                fVar.J.setVisibility(8);
                            }
                        }
                    });
                }
                b(fVar.J, a);
                a.b.start();
            }
        }
        if (fVar.l && fVar.F && fVar.G) {
            this.r = true;
        }
        fVar.P = false;
        fVar.a(fVar.B);
    }

    void d(f fVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).d(fVar, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.d(this, fVar, bundle);
            }
        }
    }

    void d(f fVar, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).d(fVar, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.c(this, fVar);
            }
        }
    }

    void e() {
        synchronized (this) {
            Object obj = null;
            Object obj2 = (this.C == null || this.C.isEmpty()) ? null : 1;
            if (this.b != null && this.b.size() == 1) {
                obj = 1;
            }
            if (!(obj2 == null && obj == null)) {
                this.m.h().removeCallbacks(this.E);
                this.m.h().post(this.E);
            }
        }
    }

    void e(f fVar) {
        if (fVar != null) {
            int i = this.l;
            if (fVar.m) {
                i = fVar.c() ? Math.min(i, 1) : Math.min(i, 0);
            }
            a(fVar, i, fVar.Q(), fVar.R(), false);
            if (fVar.J != null) {
                f p = p(fVar);
                if (p != null) {
                    View view = p.J;
                    ViewGroup viewGroup = fVar.I;
                    i = viewGroup.indexOfChild(view);
                    int indexOfChild = viewGroup.indexOfChild(fVar.J);
                    if (indexOfChild < i) {
                        viewGroup.removeViewAt(indexOfChild);
                        viewGroup.addView(fVar.J, i);
                    }
                }
                if (fVar.O && fVar.I != null) {
                    if (fVar.Q > 0.0f) {
                        fVar.J.setAlpha(fVar.Q);
                    }
                    fVar.Q = 0.0f;
                    fVar.O = false;
                    c a = a(fVar, fVar.Q(), true, fVar.R());
                    if (a != null) {
                        b(fVar.J, a);
                        if (a.a != null) {
                            fVar.J.startAnimation(a.a);
                        } else {
                            a.b.setTarget(fVar.J);
                            a.b.start();
                        }
                    }
                }
            }
            if (fVar.P) {
                d(fVar);
            }
        }
    }

    void e(f fVar, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).e(fVar, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.d(this, fVar);
            }
        }
    }

    void f(f fVar) {
        if (fVar.f < 0) {
            int i = this.d;
            this.d = i + 1;
            fVar.a(i, this.o);
            if (this.f == null) {
                this.f = new SparseArray();
            }
            this.f.put(fVar.f, fVar);
            if (a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Allocated fragment index ");
                stringBuilder.append(fVar);
                Log.v("FragmentManager", stringBuilder.toString());
            }
        }
    }

    void f(f fVar, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).f(fVar, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.e(this, fVar);
            }
        }
    }

    public boolean f() {
        c(true);
        boolean z = false;
        while (c(this.x, this.y)) {
            this.c = true;
            try {
                b(this.x, this.y);
                y();
                z = true;
            } catch (Throwable th) {
                y();
                throw th;
            }
        }
        g();
        B();
        return z;
    }

    void g() {
        if (this.w) {
            this.w = false;
            d();
        }
    }

    void g(f fVar) {
        if (fVar.f >= 0) {
            if (a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing fragment index ");
                stringBuilder.append(fVar);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            this.f.put(fVar.f, null);
            fVar.s();
        }
    }

    void g(f fVar, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).g(fVar, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.f(this, fVar);
            }
        }
    }

    void h() {
        if (this.k != null) {
            for (int i = 0; i < this.k.size(); i++) {
                ((android.support.v4.app.k.b) this.k.get(i)).a();
            }
        }
    }

    public void h(f fVar) {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("remove: ");
            stringBuilder.append(fVar);
            stringBuilder.append(" nesting=");
            stringBuilder.append(fVar.r);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        int c = fVar.c() ^ 1;
        if (!fVar.C || c != 0) {
            synchronized (this.e) {
                this.e.remove(fVar);
            }
            if (fVar.F && fVar.G) {
                this.r = true;
            }
            fVar.l = false;
            fVar.m = true;
        }
    }

    void h(f fVar, boolean z) {
        if (this.o != null) {
            k i = this.o.i();
            if (i instanceof l) {
                ((l) i).h(fVar, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (!z || fVar2.b) {
                fVar2.a.g(this, fVar);
            }
        }
    }

    m i() {
        a(this.D);
        return this.D;
    }

    public void i(f fVar) {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hide: ");
            stringBuilder.append(fVar);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (!fVar.B) {
            fVar.B = true;
            fVar.P = true ^ fVar.P;
        }
    }

    void j() {
        List list;
        List list2;
        List list3;
        if (this.f != null) {
            list = null;
            list2 = list;
            list3 = list2;
            for (int i = 0; i < this.f.size(); i++) {
                f fVar = (f) this.f.valueAt(i);
                if (fVar != null) {
                    Object obj;
                    if (fVar.D) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(fVar);
                        fVar.j = fVar.i != null ? fVar.i.f : -1;
                        if (a) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("retainNonConfig: keeping retained ");
                            stringBuilder.append(fVar);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                    }
                    if (fVar.u != null) {
                        fVar.u.j();
                        obj = fVar.u.D;
                    } else {
                        obj = fVar.v;
                    }
                    if (list2 == null && obj != null) {
                        list2 = new ArrayList(this.f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            list2.add(null);
                        }
                    }
                    if (list2 != null) {
                        list2.add(obj);
                    }
                    if (list3 == null && fVar.w != null) {
                        list3 = new ArrayList(this.f.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            list3.add(null);
                        }
                    }
                    if (list3 != null) {
                        list3.add(fVar.w);
                    }
                }
            }
        } else {
            list = null;
            list2 = list;
            list3 = list2;
        }
        if (list == null && list2 == null && list3 == null) {
            this.D = null;
        } else {
            this.D = new m(list, list2, list3);
        }
    }

    public void j(f fVar) {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("show: ");
            stringBuilder.append(fVar);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (fVar.B) {
            fVar.B = false;
            fVar.P ^= 1;
        }
    }

    Parcelable k() {
        z();
        A();
        f();
        this.s = true;
        d[] dVarArr = null;
        this.D = null;
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size = this.f.size();
        o[] oVarArr = new o[size];
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i2 < size) {
            f fVar = (f) this.f.valueAt(i2);
            if (fVar != null) {
                StringBuilder stringBuilder;
                if (fVar.f < 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Failure saving state: active ");
                    stringBuilder2.append(fVar);
                    stringBuilder2.append(" has cleared index: ");
                    stringBuilder2.append(fVar.f);
                    a(new IllegalStateException(stringBuilder2.toString()));
                }
                o oVar = new o(fVar);
                oVarArr[i2] = oVar;
                if (fVar.b <= 0 || oVar.k != null) {
                    oVar.k = fVar.c;
                } else {
                    oVar.k = n(fVar);
                    if (fVar.i != null) {
                        if (fVar.i.f < 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Failure saving state: ");
                            stringBuilder.append(fVar);
                            stringBuilder.append(" has target not in fragment manager: ");
                            stringBuilder.append(fVar.i);
                            a(new IllegalStateException(stringBuilder.toString()));
                        }
                        if (oVar.k == null) {
                            oVar.k = new Bundle();
                        }
                        a(oVar.k, "android:target_state", fVar.i);
                        if (fVar.k != 0) {
                            oVar.k.putInt("android:target_req_state", fVar.k);
                        }
                    }
                }
                if (a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Saved state of ");
                    stringBuilder.append(fVar);
                    stringBuilder.append(": ");
                    stringBuilder.append(oVar.k);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                i3 = true;
            }
            i2++;
        }
        if (i3 == 0) {
            if (a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int[] iArr;
        int size2 = this.e.size();
        if (size2 > 0) {
            iArr = new int[size2];
            for (i2 = 0; i2 < size2; i2++) {
                StringBuilder stringBuilder3;
                iArr[i2] = ((f) this.e.get(i2)).f;
                if (iArr[i2] < 0) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Failure saving state: active ");
                    stringBuilder3.append(this.e.get(i2));
                    stringBuilder3.append(" has cleared index: ");
                    stringBuilder3.append(iArr[i2]);
                    a(new IllegalStateException(stringBuilder3.toString()));
                }
                if (a) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("saveAllState: adding fragment #");
                    stringBuilder3.append(i2);
                    stringBuilder3.append(": ");
                    stringBuilder3.append(this.e.get(i2));
                    Log.v("FragmentManager", stringBuilder3.toString());
                }
            }
        } else {
            iArr = null;
        }
        if (this.g != null) {
            size2 = this.g.size();
            if (size2 > 0) {
                dVarArr = new d[size2];
                while (i < size2) {
                    dVarArr[i] = new d((c) this.g.get(i));
                    if (a) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("saveAllState: adding back stack #");
                        stringBuilder4.append(i);
                        stringBuilder4.append(": ");
                        stringBuilder4.append(this.g.get(i));
                        Log.v("FragmentManager", stringBuilder4.toString());
                    }
                    i++;
                }
            }
        }
        Parcelable nVar = new n();
        nVar.a = oVarArr;
        nVar.b = iArr;
        nVar.c = dVarArr;
        if (this.p != null) {
            nVar.d = this.p.f;
        }
        nVar.e = this.d;
        j();
        return nVar;
    }

    public void k(f fVar) {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detach: ");
            stringBuilder.append(fVar);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (!fVar.C) {
            fVar.C = true;
            if (fVar.l) {
                if (a) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("remove from detach: ");
                    stringBuilder2.append(fVar);
                    Log.v("FragmentManager", stringBuilder2.toString());
                }
                synchronized (this.e) {
                    this.e.remove(fVar);
                }
                if (fVar.F && fVar.G) {
                    this.r = true;
                }
                fVar.l = false;
            }
        }
    }

    public void l() {
        this.D = null;
        int i = 0;
        this.s = false;
        this.t = false;
        int size = this.e.size();
        while (i < size) {
            f fVar = (f) this.e.get(i);
            if (fVar != null) {
                fVar.I();
            }
            i++;
        }
    }

    public void l(f fVar) {
        StringBuilder stringBuilder;
        if (a) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("attach: ");
            stringBuilder.append(fVar);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (fVar.C) {
            fVar.C = false;
            if (!fVar.l) {
                if (this.e.contains(fVar)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Fragment already added: ");
                    stringBuilder2.append(fVar);
                    throw new IllegalStateException(stringBuilder2.toString());
                }
                if (a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("add from attach: ");
                    stringBuilder.append(fVar);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                synchronized (this.e) {
                    this.e.add(fVar);
                }
                fVar.l = true;
                if (fVar.F && fVar.G) {
                    this.r = true;
                }
            }
        }
    }

    public void m() {
        this.s = false;
        this.t = false;
        e(1);
    }

    void m(f fVar) {
        if (fVar.K != null) {
            if (this.B == null) {
                this.B = new SparseArray();
            } else {
                this.B.clear();
            }
            fVar.K.saveHierarchyState(this.B);
            if (this.B.size() > 0) {
                fVar.d = this.B;
                this.B = null;
            }
        }
    }

    Bundle n(f fVar) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        fVar.m(this.A);
        d(fVar, this.A, false);
        if (this.A.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.A;
            this.A = null;
        }
        if (fVar.J != null) {
            m(fVar);
        }
        if (fVar.d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fVar.d);
        }
        if (!fVar.M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fVar.M);
        }
        return bundle;
    }

    public void n() {
        this.s = false;
        this.t = false;
        e(2);
    }

    public void o() {
        this.s = false;
        this.t = false;
        e(3);
    }

    public void o(f fVar) {
        if (fVar == null || (this.f.get(fVar.f) == fVar && (fVar.t == null || fVar.i() == this))) {
            this.p = fVar;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(fVar);
        stringBuilder.append(" is not an active fragment of FragmentManager ");
        stringBuilder.append(this);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, g.a);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!f.a(this.m.g(), str2)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        StringBuilder stringBuilder;
        if (i == -1 && resourceId == -1 && string == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        f fVar;
        f b = resourceId != -1 ? b(resourceId) : null;
        if (b == null && string != null) {
            b = a(string);
        }
        if (b == null && i != -1) {
            b = b(i);
        }
        if (a) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("onCreateView: id=0x");
            stringBuilder2.append(Integer.toHexString(resourceId));
            stringBuilder2.append(" fname=");
            stringBuilder2.append(str2);
            stringBuilder2.append(" existing=");
            stringBuilder2.append(b);
            Log.v("FragmentManager", stringBuilder2.toString());
        }
        if (b == null) {
            f a = this.n.a(context2, str2, null);
            a.n = true;
            a.y = resourceId != 0 ? resourceId : i;
            a.z = i;
            a.A = string;
            a.o = true;
            a.s = this;
            a.t = this.m;
            a.a(this.m.g(), attributeSet2, a.c);
            a(a, true);
            fVar = a;
        } else if (b.o) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Duplicate id 0x");
            stringBuilder.append(Integer.toHexString(resourceId));
            stringBuilder.append(", tag ");
            stringBuilder.append(string);
            stringBuilder.append(", or parent id 0x");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(" with another fragment for ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            b.o = true;
            b.t = this.m;
            if (!b.E) {
                b.a(this.m.g(), attributeSet2, b.c);
            }
            fVar = b;
        }
        if (this.l >= 1 || !fVar.n) {
            b(fVar);
        } else {
            a(fVar, 1, 0, 0, false);
        }
        if (fVar.J == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(str2);
            stringBuilder.append(" did not create a view.");
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (resourceId != 0) {
            fVar.J.setId(resourceId);
        }
        if (fVar.J.getTag() == null) {
            fVar.J.setTag(string);
        }
        return fVar.J;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void p() {
        this.s = false;
        this.t = false;
        e(4);
    }

    public void q() {
        e(3);
    }

    public void r() {
        this.t = true;
        e(2);
    }

    public void s() {
        e(1);
    }

    public void t() {
        this.u = true;
        f();
        e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        android.support.v4.g.d.a(this.o != null ? this.o : this.m, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void u() {
        for (int i = 0; i < this.e.size(); i++) {
            f fVar = (f) this.e.get(i);
            if (fVar != null) {
                fVar.J();
            }
        }
    }

    public f v() {
        return this.p;
    }

    Factory2 w() {
        return this;
    }
}
