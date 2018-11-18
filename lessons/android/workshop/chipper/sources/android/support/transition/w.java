package android.support.transition;

import android.support.v4.h.r;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class w {
    private static u a = new e();
    private static ThreadLocal<WeakReference<android.support.v4.g.a<ViewGroup, ArrayList<u>>>> b = new ThreadLocal();
    private static ArrayList<ViewGroup> c = new ArrayList();

    private static class a implements OnAttachStateChangeListener, OnPreDrawListener {
        u a;
        ViewGroup b;

        a(u uVar, ViewGroup viewGroup) {
            this.a = uVar;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!w.c.remove(this.b)) {
                return true;
            }
            final android.support.v4.g.a a = w.a();
            ArrayList arrayList = (ArrayList) a.get(this.b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a.put(this.b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.a);
            this.a.a(new v() {
                public void a(u uVar) {
                    ((ArrayList) a.get(a.this.b)).remove(uVar);
                }
            });
            this.a.a(this.b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((u) it.next()).e(this.b);
                }
            }
            this.a.a(this.b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            w.c.remove(this.b);
            ArrayList arrayList = (ArrayList) w.a().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((u) it.next()).e(this.b);
                }
            }
            this.a.a(true);
        }
    }

    static android.support.v4.g.a<ViewGroup, ArrayList<u>> a() {
        WeakReference weakReference = (WeakReference) b.get();
        if (weakReference == null || weakReference.get() == null) {
            WeakReference weakReference2 = new WeakReference(new android.support.v4.g.a());
            b.set(weakReference2);
            weakReference = weakReference2;
        }
        return (android.support.v4.g.a) weakReference.get();
    }

    public static void a(ViewGroup viewGroup, u uVar) {
        if (!c.contains(viewGroup) && r.u(viewGroup)) {
            c.add(viewGroup);
            if (uVar == null) {
                uVar = a;
            }
            uVar = uVar.clone();
            c(viewGroup, uVar);
            t.a(viewGroup, null);
            b(viewGroup, uVar);
        }
    }

    private static void b(ViewGroup viewGroup, u uVar) {
        if (uVar != null && viewGroup != null) {
            Object aVar = new a(uVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void c(ViewGroup viewGroup, u uVar) {
        ArrayList arrayList = (ArrayList) a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((u) it.next()).d(viewGroup);
            }
        }
        if (uVar != null) {
            uVar.a(viewGroup, true);
        }
        t a = t.a(viewGroup);
        if (a != null) {
            a.a();
        }
    }
}
