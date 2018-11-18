package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.support.v4.g.f;
import android.support.v4.h.r;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class u implements Cloneable {
    private static final int[] g = new int[]{2, 1, 3, 4};
    private static final l h = new l() {
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<android.support.v4.g.a<Animator, a>> z = new ThreadLocal();
    private ViewGroup A = null;
    private ArrayList<Animator> B = new ArrayList();
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<c> F = null;
    private ArrayList<Animator> G = new ArrayList();
    private b H;
    private android.support.v4.g.a<String, String> I;
    private l J = h;
    long a = -1;
    ArrayList<Integer> b = new ArrayList();
    ArrayList<View> c = new ArrayList();
    y d = null;
    boolean e = false;
    x f;
    private String i = getClass().getName();
    private long j = -1;
    private TimeInterpolator k = null;
    private ArrayList<String> l = null;
    private ArrayList<Class> m = null;
    private ArrayList<Integer> n = null;
    private ArrayList<View> o = null;
    private ArrayList<Class> p = null;
    private ArrayList<String> q = null;
    private ArrayList<Integer> r = null;
    private ArrayList<View> s = null;
    private ArrayList<Class> t = null;
    private ab u = new ab();
    private ab v = new ab();
    private int[] w = g;
    private ArrayList<aa> x;
    private ArrayList<aa> y;

    private static class a {
        View a;
        String b;
        aa c;
        aw d;
        u e;

        a(View view, String str, u uVar, aw awVar, aa aaVar) {
            this.a = view;
            this.b = str;
            this.c = aaVar;
            this.d = awVar;
            this.e = uVar;
        }
    }

    public static abstract class b {
    }

    public interface c {
        void a(u uVar);

        void b(u uVar);

        void c(u uVar);

        void d(u uVar);
    }

    private void a(Animator animator, final android.support.v4.g.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    aVar.remove(animator);
                    u.this.B.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    u.this.B.add(animator);
                }
            });
            a(animator);
        }
    }

    private void a(ab abVar, ab abVar2) {
        android.support.v4.g.a aVar = new android.support.v4.g.a(abVar.a);
        android.support.v4.g.a aVar2 = new android.support.v4.g.a(abVar2.a);
        for (int i : this.w) {
            switch (i) {
                case 1:
                    a(aVar, aVar2);
                    break;
                case 2:
                    a(aVar, aVar2, abVar.d, abVar2.d);
                    break;
                case 3:
                    a(aVar, aVar2, abVar.b, abVar2.b);
                    break;
                case 4:
                    a(aVar, aVar2, abVar.c, abVar2.c);
                    break;
                default:
                    break;
            }
        }
        b(aVar, aVar2);
    }

    private static void a(ab abVar, View view, aa aaVar) {
        abVar.a.put(view, aaVar);
        int id = view.getId();
        if (id >= 0) {
            if (abVar.b.indexOfKey(id) >= 0) {
                abVar.b.put(id, null);
            } else {
                abVar.b.put(id, view);
            }
        }
        String k = r.k(view);
        if (k != null) {
            if (abVar.d.containsKey(k)) {
                abVar.d.put(k, null);
            } else {
                abVar.d.put(k, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (abVar.c.c(itemIdAtPosition) >= 0) {
                    view = (View) abVar.c.a(itemIdAtPosition);
                    if (view != null) {
                        r.a(view, false);
                        abVar.c.b(itemIdAtPosition, null);
                        return;
                    }
                }
                r.a(view, true);
                abVar.c.b(itemIdAtPosition, view);
            }
        }
    }

    private void a(android.support.v4.g.a<View, aa> aVar, android.support.v4.g.a<View, aa> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.b(size);
            if (view != null && a(view)) {
                aa aaVar = (aa) aVar2.remove(view);
                if (!(aaVar == null || aaVar.b == null || !a(aaVar.b))) {
                    this.x.add((aa) aVar.d(size));
                    this.y.add(aaVar);
                }
            }
        }
    }

    private void a(android.support.v4.g.a<View, aa> aVar, android.support.v4.g.a<View, aa> aVar2, android.support.v4.g.a<String, View> aVar3, android.support.v4.g.a<String, View> aVar4) {
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar3.c(i);
            if (view != null && a(view)) {
                View view2 = (View) aVar4.get(aVar3.b(i));
                if (view2 != null && a(view2)) {
                    aa aaVar = (aa) aVar.get(view);
                    aa aaVar2 = (aa) aVar2.get(view2);
                    if (!(aaVar == null || aaVar2 == null)) {
                        this.x.add(aaVar);
                        this.y.add(aaVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private void a(android.support.v4.g.a<View, aa> aVar, android.support.v4.g.a<View, aa> aVar2, f<View> fVar, f<View> fVar2) {
        int b = fVar.b();
        for (int i = 0; i < b; i++) {
            View view = (View) fVar.c(i);
            if (view != null && a(view)) {
                View view2 = (View) fVar2.a(fVar.b(i));
                if (view2 != null && a(view2)) {
                    aa aaVar = (aa) aVar.get(view);
                    aa aaVar2 = (aa) aVar2.get(view2);
                    if (!(aaVar == null || aaVar2 == null)) {
                        this.x.add(aaVar);
                        this.y.add(aaVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private void a(android.support.v4.g.a<View, aa> aVar, android.support.v4.g.a<View, aa> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null && a(view)) {
                View view2 = (View) sparseArray2.get(sparseArray.keyAt(i));
                if (view2 != null && a(view2)) {
                    aa aaVar = (aa) aVar.get(view);
                    aa aaVar2 = (aa) aVar2.get(view2);
                    if (!(aaVar == null || aaVar2 == null)) {
                        this.x.add(aaVar);
                        this.y.add(aaVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private static boolean a(aa aaVar, aa aaVar2, String str) {
        Object obj = aaVar.a.get(str);
        Object obj2 = aaVar2.a.get(str);
        boolean z = true;
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj != null) {
            if (obj2 == null) {
                return true;
            }
            z = true ^ obj.equals(obj2);
        }
        return z;
    }

    private void b(android.support.v4.g.a<View, aa> aVar, android.support.v4.g.a<View, aa> aVar2) {
        int i = 0;
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            aa aaVar = (aa) aVar.c(i2);
            if (a(aaVar.b)) {
                this.x.add(aaVar);
                this.y.add(null);
            }
        }
        while (i < aVar2.size()) {
            aa aaVar2 = (aa) aVar2.c(i);
            if (a(aaVar2.b)) {
                this.y.add(aaVar2);
                this.x.add(null);
            }
            i++;
        }
    }

    private void c(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.n != null && this.n.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.o == null || !this.o.contains(view)) {
                int size;
                int i = 0;
                if (this.p != null) {
                    size = this.p.size();
                    int i2 = 0;
                    while (i2 < size) {
                        if (!((Class) this.p.get(i2)).isInstance(view)) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    aa aaVar = new aa();
                    aaVar.b = view;
                    if (z) {
                        a(aaVar);
                    } else {
                        b(aaVar);
                    }
                    aaVar.c.add(this);
                    c(aaVar);
                    a(z ? this.u : this.v, view, aaVar);
                }
                if ((view instanceof ViewGroup) && (this.r == null || !this.r.contains(Integer.valueOf(id)))) {
                    if (this.s == null || !this.s.contains(view)) {
                        if (this.t != null) {
                            id = this.t.size();
                            size = 0;
                            while (size < id) {
                                if (!((Class) this.t.get(size)).isInstance(view)) {
                                    size++;
                                } else {
                                    return;
                                }
                            }
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        while (i < viewGroup.getChildCount()) {
                            c(viewGroup.getChildAt(i), z);
                            i++;
                        }
                    }
                }
            }
        }
    }

    private static android.support.v4.g.a<Animator, a> o() {
        android.support.v4.g.a<Animator, a> aVar = (android.support.v4.g.a) z.get();
        if (aVar != null) {
            return aVar;
        }
        aVar = new android.support.v4.g.a();
        z.set(aVar);
        return aVar;
    }

    public Animator a(ViewGroup viewGroup, aa aaVar, aa aaVar2) {
        return null;
    }

    public aa a(View view, boolean z) {
        if (this.d != null) {
            return this.d.a(view, z);
        }
        return (aa) (z ? this.u : this.v).a.get(view);
    }

    public u a(long j) {
        this.a = j;
        return this;
    }

    public u a(c cVar) {
        if (this.F == null) {
            this.F = new ArrayList();
        }
        this.F.add(cVar);
        return this;
    }

    String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(": ");
        str = stringBuilder.toString();
        if (this.a != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dur(");
            stringBuilder.append(this.a);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.j != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dly(");
            stringBuilder.append(this.j);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.k != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("interp(");
            stringBuilder.append(this.k);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.b.size() <= 0 && this.c.size() <= 0) {
            return str;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("tgts(");
        str = stringBuilder.toString();
        int i = 0;
        if (this.b.size() > 0) {
            String str2 = str;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                StringBuilder stringBuilder2;
                if (i2 > 0) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(", ");
                    str2 = stringBuilder2.toString();
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(this.b.get(i2));
                str2 = stringBuilder2.toString();
            }
            str = str2;
        }
        if (this.c.size() > 0) {
            while (i < this.c.size()) {
                if (i > 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(", ");
                    str = stringBuilder.toString();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.c.get(i));
                str = stringBuilder.toString();
                i++;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append(")");
        return stringBuilder3.toString();
    }

    protected void a(Animator animator) {
        if (animator == null) {
            k();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (c() >= 0) {
            animator.setStartDelay(c());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                u.this.k();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    public abstract void a(aa aaVar);

    public void a(b bVar) {
        this.H = bVar;
    }

    void a(ViewGroup viewGroup) {
        this.x = new ArrayList();
        this.y = new ArrayList();
        a(this.u, this.v);
        android.support.v4.g.a o = o();
        int size = o.size();
        aw b = am.b(viewGroup);
        for (size--; size >= 0; size--) {
            Animator animator = (Animator) o.b(size);
            if (animator != null) {
                a aVar = (a) o.get(animator);
                if (!(aVar == null || aVar.a == null || !b.equals(aVar.d))) {
                    aa aaVar = aVar.c;
                    View view = aVar.a;
                    aa a = a(view, true);
                    aa b2 = b(view, true);
                    boolean z = !(a == null && b2 == null) && aVar.e.a(aaVar, b2);
                    if (z) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            o.remove(animator);
                        }
                    }
                }
            }
        }
        a(viewGroup, this.u, this.v, this.x, this.y);
        e();
    }

    protected void a(ViewGroup viewGroup, ab abVar, ab abVar2, ArrayList<aa> arrayList, ArrayList<aa> arrayList2) {
        ViewGroup viewGroup2 = viewGroup;
        android.support.v4.g.a o = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i = 0;
        while (i < size) {
            int i2;
            int i3;
            aa aaVar = (aa) arrayList.get(i);
            aa aaVar2 = (aa) arrayList2.get(i);
            if (!(aaVar == null || aaVar.c.contains(this))) {
                aaVar = null;
            }
            if (!(aaVar2 == null || aaVar2.c.contains(this))) {
                aaVar2 = null;
            }
            if (!(aaVar == null && aaVar2 == null)) {
                Object obj = (aaVar == null || aaVar2 == null || a(aaVar, aaVar2)) ? 1 : null;
                if (obj != null) {
                    Animator a = a(viewGroup2, aaVar, aaVar2);
                    if (a != null) {
                        View view;
                        aa aaVar3;
                        Object obj2;
                        Animator animator;
                        if (aaVar2 != null) {
                            aa aaVar4;
                            view = aaVar2.b;
                            String[] a2 = a();
                            if (view == null || a2 == null || a2.length <= 0) {
                                i2 = size;
                                i3 = i;
                                a = a;
                                aaVar4 = null;
                            } else {
                                aaVar4 = new aa();
                                aaVar4.b = view;
                                animator = a;
                                i2 = size;
                                aaVar3 = (aa) abVar2.a.get(view);
                                if (aaVar3 != null) {
                                    size = 0;
                                    while (size < a2.length) {
                                        i3 = i;
                                        aa aaVar5 = aaVar3;
                                        aaVar4.a.put(a2[size], aaVar3.a.get(a2[size]));
                                        size++;
                                        i = i3;
                                        aaVar3 = aaVar5;
                                        ArrayList<aa> arrayList3 = arrayList2;
                                    }
                                }
                                i3 = i;
                                int size2 = o.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    a aVar = (a) o.get((Animator) o.b(i4));
                                    if (aVar.c != null && aVar.a == view && aVar.b.equals(n()) && aVar.c.equals(aaVar4)) {
                                        a = null;
                                        break;
                                    }
                                }
                                a = animator;
                            }
                            obj2 = a;
                            aaVar3 = aaVar4;
                        } else {
                            animator = a;
                            i2 = size;
                            i3 = i;
                            view = aaVar.b;
                            obj2 = animator;
                            aaVar3 = null;
                        }
                        if (obj2 != null) {
                            if (this.f != null) {
                                long a3 = this.f.a(viewGroup2, this, aaVar, aaVar2);
                                sparseIntArray.put(this.G.size(), (int) a3);
                                j = Math.min(a3, j);
                            }
                            long j2 = j;
                            o.put(obj2, new a(view, n(), this, am.b(viewGroup), aaVar3));
                            this.G.add(obj2);
                            j = j2;
                        }
                        i = i3 + 1;
                        size = i2;
                    }
                }
            }
            i2 = size;
            i3 = i;
            i = i3 + 1;
            size = i2;
        }
        if (j != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator2 = (Animator) this.G.get(sparseIntArray.keyAt(i5));
                animator2.setStartDelay((((long) sparseIntArray.valueAt(i5)) - j) + animator2.getStartDelay());
            }
        }
    }

    void a(ViewGroup viewGroup, boolean z) {
        int i;
        int i2;
        View view;
        a(z);
        int i3 = 0;
        if ((this.b.size() > 0 || this.c.size() > 0) && ((this.l == null || this.l.isEmpty()) && (this.m == null || this.m.isEmpty()))) {
            for (i = 0; i < this.b.size(); i++) {
                View findViewById = viewGroup.findViewById(((Integer) this.b.get(i)).intValue());
                if (findViewById != null) {
                    aa aaVar = new aa();
                    aaVar.b = findViewById;
                    if (z) {
                        a(aaVar);
                    } else {
                        b(aaVar);
                    }
                    aaVar.c.add(this);
                    c(aaVar);
                    a(z ? this.u : this.v, findViewById, aaVar);
                }
            }
            for (i2 = 0; i2 < this.c.size(); i2++) {
                view = (View) this.c.get(i2);
                aa aaVar2 = new aa();
                aaVar2.b = view;
                if (z) {
                    a(aaVar2);
                } else {
                    b(aaVar2);
                }
                aaVar2.c.add(this);
                c(aaVar2);
                a(z ? this.u : this.v, view, aaVar2);
            }
        } else {
            c(viewGroup, z);
        }
        if (!z && this.I != null) {
            i2 = this.I.size();
            ArrayList arrayList = new ArrayList(i2);
            for (i = 0; i < i2; i++) {
                arrayList.add(this.u.d.remove((String) this.I.b(i)));
            }
            while (i3 < i2) {
                view = (View) arrayList.get(i3);
                if (view != null) {
                    this.u.d.put((String) this.I.c(i3), view);
                }
                i3++;
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:5:0x0029 in {1, 3, 4} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    void a(boolean r1) {
        /*
        r0 = this;
        if (r1 == 0) goto L_0x0018;
    L_0x0002:
        r1 = r0.u;
        r1 = r1.a;
        r1.clear();
        r1 = r0.u;
        r1 = r1.b;
        r1.clear();
        r0 = r0.u;
    L_0x0012:
        r0 = r0.c;
        r0.c();
        return;
    L_0x0018:
        r1 = r0.v;
        r1 = r1.a;
        r1.clear();
        r1 = r0.v;
        r1 = r1.b;
        r1.clear();
        r0 = r0.v;
        goto L_0x0012;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.u.a(boolean):void");
    }

    public boolean a(aa aaVar, aa aaVar2) {
        if (aaVar == null || aaVar2 == null) {
            return false;
        }
        String[] a = a();
        if (a != null) {
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!a(aaVar, aaVar2, a[i])) {
                    i++;
                }
            }
            return false;
        }
        for (String a2 : aaVar.a.keySet()) {
            if (a(aaVar, aaVar2, a2)) {
            }
        }
        return false;
        return true;
    }

    /* JADX WARNING: Missing block: B:37:0x0082, code:
            return true;
     */
    boolean a(android.view.View r6) {
        /*
        r5 = this;
        r0 = r6.getId();
        r1 = r5.n;
        r2 = 0;
        if (r1 == 0) goto L_0x0016;
    L_0x0009:
        r1 = r5.n;
        r3 = java.lang.Integer.valueOf(r0);
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r5.o;
        if (r1 == 0) goto L_0x0023;
    L_0x001a:
        r1 = r5.o;
        r1 = r1.contains(r6);
        if (r1 == 0) goto L_0x0023;
    L_0x0022:
        return r2;
    L_0x0023:
        r1 = r5.p;
        if (r1 == 0) goto L_0x0042;
    L_0x0027:
        r1 = r5.p;
        r1 = r1.size();
        r3 = r2;
    L_0x002e:
        if (r3 >= r1) goto L_0x0042;
    L_0x0030:
        r4 = r5.p;
        r4 = r4.get(r3);
        r4 = (java.lang.Class) r4;
        r4 = r4.isInstance(r6);
        if (r4 == 0) goto L_0x003f;
    L_0x003e:
        return r2;
    L_0x003f:
        r3 = r3 + 1;
        goto L_0x002e;
    L_0x0042:
        r1 = r5.q;
        if (r1 == 0) goto L_0x0059;
    L_0x0046:
        r1 = android.support.v4.h.r.k(r6);
        if (r1 == 0) goto L_0x0059;
    L_0x004c:
        r1 = r5.q;
        r3 = android.support.v4.h.r.k(r6);
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0059;
    L_0x0058:
        return r2;
    L_0x0059:
        r1 = r5.b;
        r1 = r1.size();
        r3 = 1;
        if (r1 != 0) goto L_0x0083;
    L_0x0062:
        r1 = r5.c;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0083;
    L_0x006a:
        r1 = r5.m;
        if (r1 == 0) goto L_0x0076;
    L_0x006e:
        r1 = r5.m;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0083;
    L_0x0076:
        r1 = r5.l;
        if (r1 == 0) goto L_0x0082;
    L_0x007a:
        r1 = r5.l;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0083;
    L_0x0082:
        return r3;
    L_0x0083:
        r1 = r5.b;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r1.contains(r0);
        if (r0 != 0) goto L_0x00c9;
    L_0x008f:
        r0 = r5.c;
        r0 = r0.contains(r6);
        if (r0 == 0) goto L_0x0098;
    L_0x0097:
        return r3;
    L_0x0098:
        r0 = r5.l;
        if (r0 == 0) goto L_0x00a9;
    L_0x009c:
        r0 = r5.l;
        r1 = android.support.v4.h.r.k(r6);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x00a9;
    L_0x00a8:
        return r3;
    L_0x00a9:
        r0 = r5.m;
        if (r0 == 0) goto L_0x00c8;
    L_0x00ad:
        r0 = r2;
    L_0x00ae:
        r1 = r5.m;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x00c8;
    L_0x00b6:
        r1 = r5.m;
        r1 = r1.get(r0);
        r1 = (java.lang.Class) r1;
        r1 = r1.isInstance(r6);
        if (r1 == 0) goto L_0x00c5;
    L_0x00c4:
        return r3;
    L_0x00c5:
        r0 = r0 + 1;
        goto L_0x00ae;
    L_0x00c8:
        return r2;
    L_0x00c9:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.u.a(android.view.View):boolean");
    }

    public String[] a() {
        return null;
    }

    public long b() {
        return this.a;
    }

    aa b(View view, boolean z) {
        if (this.d != null) {
            return this.d.b(view, z);
        }
        ArrayList arrayList = z ? this.x : this.y;
        aa aaVar = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            aa aaVar2 = (aa) arrayList.get(i2);
            if (aaVar2 == null) {
                return null;
            }
            if (aaVar2.b == view) {
                i = i2;
                break;
            }
        }
        if (i >= 0) {
            aaVar = (aa) (z ? this.y : this.x).get(i);
        }
        return aaVar;
    }

    public u b(long j) {
        this.j = j;
        return this;
    }

    public u b(c cVar) {
        if (this.F == null) {
            return this;
        }
        this.F.remove(cVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    public u b(View view) {
        this.c.add(view);
        return this;
    }

    public abstract void b(aa aaVar);

    public long c() {
        return this.j;
    }

    public u c(View view) {
        this.c.remove(view);
        return this;
    }

    void c(aa aaVar) {
        if (!(this.f == null || aaVar.a.isEmpty())) {
            String[] a = this.f.a();
            if (a != null) {
                Object obj = null;
                for (Object containsKey : a) {
                    if (!aaVar.a.containsKey(containsKey)) {
                        break;
                    }
                }
                obj = 1;
                if (obj == null) {
                    this.f.a(aaVar);
                }
            }
        }
    }

    public TimeInterpolator d() {
        return this.k;
    }

    public void d(View view) {
        if (!this.E) {
            android.support.v4.g.a o = o();
            int size = o.size();
            aw b = am.b(view);
            for (size--; size >= 0; size--) {
                a aVar = (a) o.c(size);
                if (aVar.a != null && b.equals(aVar.d)) {
                    a.a((Animator) o.b(size));
                }
            }
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size2 = arrayList.size();
                for (size = 0; size < size2; size++) {
                    ((c) arrayList.get(size)).b(this);
                }
            }
            this.D = true;
        }
    }

    protected void e() {
        j();
        android.support.v4.g.a o = o();
        Iterator it = this.G.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (o.containsKey(animator)) {
                j();
                a(animator, o);
            }
        }
        this.G.clear();
        k();
    }

    public void e(View view) {
        if (this.D) {
            if (!this.E) {
                android.support.v4.g.a o = o();
                int size = o.size();
                aw b = am.b(view);
                for (size--; size >= 0; size--) {
                    a aVar = (a) o.c(size);
                    if (aVar.a != null && b.equals(aVar.d)) {
                        a.b((Animator) o.b(size));
                    }
                }
                if (this.F != null && this.F.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.F.clone();
                    int size2 = arrayList.size();
                    for (size = 0; size < size2; size++) {
                        ((c) arrayList.get(size)).c(this);
                    }
                }
            }
            this.D = false;
        }
    }

    public List<Integer> f() {
        return this.b;
    }

    public List<View> g() {
        return this.c;
    }

    public List<String> h() {
        return this.l;
    }

    public List<Class> i() {
        return this.m;
    }

    protected void j() {
        if (this.C == 0) {
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList.get(i)).d(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    protected void k() {
        this.C--;
        if (this.C == 0) {
            int i;
            View view;
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList.get(i2)).a(this);
                }
            }
            for (i = 0; i < this.u.c.b(); i++) {
                view = (View) this.u.c.c(i);
                if (view != null) {
                    r.a(view, false);
                }
            }
            for (i = 0; i < this.v.c.b(); i++) {
                view = (View) this.v.c.c(i);
                if (view != null) {
                    r.a(view, false);
                }
            }
            this.E = true;
        }
    }

    public l l() {
        return this.J;
    }

    /* renamed from: m */
    public u clone() {
        try {
            this = (u) super.clone();
            this.G = new ArrayList();
            this.u = new ab();
            this.v = new ab();
            this.x = null;
            this.y = null;
            return this;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String n() {
        return this.i;
    }

    public String toString() {
        return a("");
    }
}
