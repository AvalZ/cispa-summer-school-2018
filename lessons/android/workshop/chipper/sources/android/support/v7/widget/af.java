package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.h.r;
import android.support.v7.widget.at.x;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class af extends az {
    private static TimeInterpolator i;
    ArrayList<ArrayList<x>> a = new ArrayList();
    ArrayList<ArrayList<b>> b = new ArrayList();
    ArrayList<ArrayList<a>> c = new ArrayList();
    ArrayList<x> d = new ArrayList();
    ArrayList<x> e = new ArrayList();
    ArrayList<x> f = new ArrayList();
    ArrayList<x> g = new ArrayList();
    private ArrayList<x> j = new ArrayList();
    private ArrayList<x> k = new ArrayList();
    private ArrayList<b> l = new ArrayList();
    private ArrayList<a> m = new ArrayList();

    private static class a {
        public x a;
        public x b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(x xVar, x xVar2) {
            this.a = xVar;
            this.b = xVar2;
        }

        a(x xVar, x xVar2, int i, int i2, int i3, int i4) {
            this(xVar, xVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ChangeInfo{oldHolder=");
            stringBuilder.append(this.a);
            stringBuilder.append(", newHolder=");
            stringBuilder.append(this.b);
            stringBuilder.append(", fromX=");
            stringBuilder.append(this.c);
            stringBuilder.append(", fromY=");
            stringBuilder.append(this.d);
            stringBuilder.append(", toX=");
            stringBuilder.append(this.e);
            stringBuilder.append(", toY=");
            stringBuilder.append(this.f);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class b {
        public x a;
        public int b;
        public int c;
        public int d;
        public int e;

        b(x xVar, int i, int i2, int i3, int i4) {
            this.a = xVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    private void a(List<a> list, x xVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, xVar) && aVar.a == null && aVar.b == null) {
                list.remove(aVar);
            }
        }
    }

    private boolean a(a aVar, x xVar) {
        boolean z = false;
        if (aVar.b == xVar) {
            aVar.b = null;
        } else if (aVar.a != xVar) {
            return false;
        } else {
            aVar.a = null;
            z = true;
        }
        xVar.a.setAlpha(1.0f);
        xVar.a.setTranslationX(0.0f);
        xVar.a.setTranslationY(0.0f);
        a(xVar, z);
        return true;
    }

    private void b(a aVar) {
        if (aVar.a != null) {
            a(aVar, aVar.a);
        }
        if (aVar.b != null) {
            a(aVar, aVar.b);
        }
    }

    private void u(final x xVar) {
        final View view = xVar.a;
        final ViewPropertyAnimator animate = view.animate();
        this.f.add(xVar);
        animate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                af.this.i(xVar);
                af.this.f.remove(xVar);
                af.this.c();
            }

            public void onAnimationStart(Animator animator) {
                af.this.l(xVar);
            }
        }).start();
    }

    private void v(x xVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        xVar.a.animate().setInterpolator(i);
        d(xVar);
    }

    public void a() {
        int isEmpty = this.j.isEmpty() ^ 1;
        int isEmpty2 = this.l.isEmpty() ^ 1;
        int isEmpty3 = this.m.isEmpty() ^ 1;
        int isEmpty4 = this.k.isEmpty() ^ 1;
        if (isEmpty != 0 || isEmpty2 != 0 || isEmpty4 != 0 || isEmpty3 != 0) {
            final ArrayList arrayList;
            Runnable anonymousClass1;
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                u((x) it.next());
            }
            this.j.clear();
            if (isEmpty2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.l);
                this.b.add(arrayList);
                this.l.clear();
                anonymousClass1 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            af.this.b(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e);
                        }
                        arrayList.clear();
                        af.this.b.remove(arrayList);
                    }
                };
                if (isEmpty != 0) {
                    r.a(((b) arrayList.get(0)).a.a, anonymousClass1, g());
                } else {
                    anonymousClass1.run();
                }
            }
            if (isEmpty3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.m);
                this.c.add(arrayList);
                this.m.clear();
                anonymousClass1 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            af.this.a((a) it.next());
                        }
                        arrayList.clear();
                        af.this.c.remove(arrayList);
                    }
                };
                if (isEmpty != 0) {
                    r.a(((a) arrayList.get(0)).a.a, anonymousClass1, g());
                } else {
                    anonymousClass1.run();
                }
            }
            if (isEmpty4 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.k);
                this.a.add(arrayList2);
                this.k.clear();
                Runnable anonymousClass3 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            af.this.c((x) it.next());
                        }
                        arrayList2.clear();
                        af.this.a.remove(arrayList2);
                    }
                };
                if (isEmpty == 0 && isEmpty2 == 0 && isEmpty3 == 0) {
                    anonymousClass3.run();
                    return;
                }
                long j = 0;
                long g = isEmpty != 0 ? g() : 0;
                long e = isEmpty2 != 0 ? e() : 0;
                if (isEmpty3 != 0) {
                    j = h();
                }
                r.a(((x) arrayList2.get(0)).a, anonymousClass3, g + Math.max(e, j));
            }
        }
    }

    void a(final a aVar) {
        x xVar = aVar.a;
        View view = null;
        final View view2 = xVar == null ? null : xVar.a;
        x xVar2 = aVar.b;
        if (xVar2 != null) {
            view = xVar2.a;
        }
        if (view2 != null) {
            final ViewPropertyAnimator duration = view2.animate().setDuration(h());
            this.g.add(aVar.a);
            duration.translationX((float) (aVar.e - aVar.c));
            duration.translationY((float) (aVar.f - aVar.d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    af.this.a(aVar.a, true);
                    af.this.g.remove(aVar.a);
                    af.this.c();
                }

                public void onAnimationStart(Animator animator) {
                    af.this.b(aVar.a, true);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimator animate = view.animate();
            this.g.add(aVar.b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    af.this.a(aVar.b, false);
                    af.this.g.remove(aVar.b);
                    af.this.c();
                }

                public void onAnimationStart(Animator animator) {
                    af.this.b(aVar.b, false);
                }
            }).start();
        }
    }

    void a(List<x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((x) list.get(size)).a.animate().cancel();
        }
    }

    public boolean a(x xVar) {
        v(xVar);
        this.j.add(xVar);
        return true;
    }

    public boolean a(x xVar, int i, int i2, int i3, int i4) {
        View view = xVar.a;
        int translationX = i + ((int) xVar.a.getTranslationX());
        int translationY = i2 + ((int) xVar.a.getTranslationY());
        v(xVar);
        i = i3 - translationX;
        i2 = i4 - translationY;
        if (i == 0 && i2 == 0) {
            j(xVar);
            return false;
        }
        if (i != 0) {
            view.setTranslationX((float) (-i));
        }
        if (i2 != 0) {
            view.setTranslationY((float) (-i2));
        }
        this.l.add(new b(xVar, translationX, translationY, i3, i4));
        return true;
    }

    public boolean a(x xVar, x xVar2, int i, int i2, int i3, int i4) {
        if (xVar == xVar2) {
            return a(xVar, i, i2, i3, i4);
        }
        float translationX = xVar.a.getTranslationX();
        float translationY = xVar.a.getTranslationY();
        float alpha = xVar.a.getAlpha();
        v(xVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        xVar.a.setTranslationX(translationX);
        xVar.a.setTranslationY(translationY);
        xVar.a.setAlpha(alpha);
        if (xVar2 != null) {
            v(xVar2);
            xVar2.a.setTranslationX((float) (-i5));
            xVar2.a.setTranslationY((float) (-i6));
            xVar2.a.setAlpha(0.0f);
        }
        this.m.add(new a(xVar, xVar2, i, i2, i3, i4));
        return true;
    }

    public boolean a(x xVar, List<Object> list) {
        return !list.isEmpty() || super.a(xVar, (List) list);
    }

    void b(x xVar, int i, int i2, int i3, int i4) {
        final View view = xVar.a;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.e.add(xVar);
        final x xVar2 = xVar;
        animate.setDuration(e()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                af.this.j(xVar2);
                af.this.e.remove(xVar2);
                af.this.c();
            }

            public void onAnimationStart(Animator animator) {
                af.this.m(xVar2);
            }
        }).start();
    }

    public boolean b() {
        return (this.k.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.b.isEmpty() && this.a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    public boolean b(x xVar) {
        v(xVar);
        xVar.a.setAlpha(0.0f);
        this.k.add(xVar);
        return true;
    }

    void c() {
        if (!b()) {
            i();
        }
    }

    void c(final x xVar) {
        final View view = xVar.a;
        final ViewPropertyAnimator animate = view.animate();
        this.d.add(xVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                af.this.k(xVar);
                af.this.d.remove(xVar);
                af.this.c();
            }

            public void onAnimationStart(Animator animator) {
                af.this.n(xVar);
            }
        }).start();
    }

    public void d() {
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = (b) this.l.get(size);
            View view = bVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.a);
            this.l.remove(size);
        }
        for (size = this.j.size() - 1; size >= 0; size--) {
            i((x) this.j.get(size));
            this.j.remove(size);
        }
        size = this.k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            x xVar = (x) this.k.get(size);
            xVar.a.setAlpha(1.0f);
            k(xVar);
            this.k.remove(size);
        }
        for (size = this.m.size() - 1; size >= 0; size--) {
            b((a) this.m.get(size));
        }
        this.m.clear();
        if (b()) {
            ArrayList arrayList;
            for (size = this.b.size() - 1; size >= 0; size--) {
                ArrayList arrayList2 = (ArrayList) this.b.get(size);
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    b bVar2 = (b) arrayList2.get(size2);
                    View view2 = bVar2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.a);
                    arrayList2.remove(size2);
                    if (arrayList2.isEmpty()) {
                        this.b.remove(arrayList2);
                    }
                }
            }
            for (size = this.a.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.a.get(size);
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    x xVar2 = (x) arrayList.get(size3);
                    xVar2.a.setAlpha(1.0f);
                    k(xVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.a.remove(arrayList);
                    }
                }
            }
            for (size = this.c.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.c.get(size);
                for (int size4 = arrayList.size() - 1; size4 >= 0; size4--) {
                    b((a) arrayList.get(size4));
                    if (arrayList.isEmpty()) {
                        this.c.remove(arrayList);
                    }
                }
            }
            a(this.f);
            a(this.e);
            a(this.d);
            a(this.g);
            i();
        }
    }

    public void d(x xVar) {
        View view = xVar.a;
        view.animate().cancel();
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((b) this.l.get(size)).a == xVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(xVar);
                this.l.remove(size);
            }
        }
        a(this.m, xVar);
        if (this.j.remove(xVar)) {
            view.setAlpha(1.0f);
            i(xVar);
        }
        if (this.k.remove(xVar)) {
            view.setAlpha(1.0f);
            k(xVar);
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.c.get(size);
            a(list, xVar);
            if (list.isEmpty()) {
                this.c.remove(size);
            }
        }
        for (size = this.b.size() - 1; size >= 0; size--) {
            ArrayList arrayList = (ArrayList) this.b.get(size);
            int size2 = arrayList.size() - 1;
            while (size2 >= 0) {
                if (((b) arrayList.get(size2)).a == xVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(xVar);
                    arrayList.remove(size2);
                    if (arrayList.isEmpty()) {
                        this.b.remove(size);
                    }
                } else {
                    size2--;
                }
            }
        }
        for (size = this.a.size() - 1; size >= 0; size--) {
            ArrayList arrayList2 = (ArrayList) this.a.get(size);
            if (arrayList2.remove(xVar)) {
                view.setAlpha(1.0f);
                k(xVar);
                if (arrayList2.isEmpty()) {
                    this.a.remove(size);
                }
            }
        }
        this.f.remove(xVar);
        this.d.remove(xVar);
        this.g.remove(xVar);
        this.e.remove(xVar);
        c();
    }
}
