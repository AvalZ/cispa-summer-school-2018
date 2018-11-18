package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.h.r;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class q {
    private static final int[] a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final s b = (VERSION.SDK_INT >= 21 ? new r() : null);
    private static final s c = a();

    static class a {
        public f a;
        public boolean b;
        public c c;
        public f d;
        public boolean e;
        public c f;

        a() {
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        aVar = new a();
        sparseArray.put(i, aVar);
        return aVar;
    }

    private static s a() {
        try {
            return (s) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static s a(f fVar, f fVar2) {
        Object A;
        List arrayList = new ArrayList();
        if (fVar != null) {
            Object x = fVar.x();
            if (x != null) {
                arrayList.add(x);
            }
            x = fVar.w();
            if (x != null) {
                arrayList.add(x);
            }
            A = fVar.A();
            if (A != null) {
                arrayList.add(A);
            }
        }
        if (fVar2 != null) {
            A = fVar2.v();
            if (A != null) {
                arrayList.add(A);
            }
            A = fVar2.y();
            if (A != null) {
                arrayList.add(A);
            }
            A = fVar2.z();
            if (A != null) {
                arrayList.add(A);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (b != null && a(b, arrayList)) {
            return b;
        }
        if (c != null && a(c, arrayList)) {
            return c;
        }
        if (b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static android.support.v4.g.a<String, String> a(int i, ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        android.support.v4.g.a<String, String> aVar = new android.support.v4.g.a();
        for (i3--; i3 >= i2; i3--) {
            c cVar = (c) arrayList.get(i3);
            if (cVar.b(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
                if (cVar.r != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = cVar.r.size();
                    if (booleanValue) {
                        arrayList3 = cVar.r;
                        arrayList4 = cVar.s;
                    } else {
                        ArrayList arrayList5 = cVar.r;
                        arrayList3 = cVar.s;
                        arrayList4 = arrayList5;
                    }
                    for (int i4 = 0; i4 < size; i4++) {
                        String str = (String) arrayList4.get(i4);
                        String str2 = (String) arrayList3.get(i4);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    static android.support.v4.g.a<String, View> a(s sVar, android.support.v4.g.a<String, String> aVar, Object obj, a aVar2) {
        f fVar = aVar2.a;
        View l = fVar.l();
        if (aVar.isEmpty() || obj == null || l == null) {
            aVar.clear();
            return null;
        }
        w T;
        ArrayList arrayList;
        android.support.v4.g.a aVar3 = new android.support.v4.g.a();
        sVar.a((Map) aVar3, l);
        c cVar = aVar2.c;
        if (aVar2.b) {
            T = fVar.T();
            arrayList = cVar.r;
        } else {
            T = fVar.S();
            arrayList = cVar.s;
        }
        if (arrayList != null) {
            aVar3.a(arrayList);
            aVar3.a(aVar.values());
        }
        if (T != null) {
            T.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                l = (View) aVar3.get(str);
                if (l == null) {
                    str = a((android.support.v4.g.a) aVar, str);
                    if (str != null) {
                        aVar.remove(str);
                    }
                } else if (!str.equals(r.k(l))) {
                    str = a((android.support.v4.g.a) aVar, str);
                    if (str != null) {
                        aVar.put(str, r.k(l));
                    }
                }
            }
        } else {
            a((android.support.v4.g.a) aVar, aVar3);
        }
        return aVar3;
    }

    static View a(android.support.v4.g.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        c cVar = aVar2.c;
        if (obj == null || aVar == null || cVar.r == null || cVar.r.isEmpty()) {
            return null;
        }
        return (View) aVar.get((String) (z ? cVar.r : cVar.s).get(0));
    }

    private static Object a(s sVar, f fVar, f fVar2, boolean z) {
        if (fVar == null || fVar2 == null) {
            return null;
        }
        return sVar.c(sVar.b(z ? fVar2.A() : fVar.z()));
    }

    private static Object a(s sVar, f fVar, boolean z) {
        if (fVar == null) {
            return null;
        }
        return sVar.b(z ? fVar.y() : fVar.v());
    }

    private static Object a(s sVar, ViewGroup viewGroup, View view, android.support.v4.g.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final s sVar2 = sVar;
        View view2 = view;
        android.support.v4.g.a aVar3 = aVar;
        a aVar4 = aVar2;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        Object obj3 = obj;
        f fVar = aVar4.a;
        f fVar2 = aVar4.d;
        if (fVar != null) {
            fVar.l().setVisibility(0);
        }
        if (fVar == null || fVar2 == null) {
            return null;
        }
        Object obj4;
        boolean z = aVar4.b;
        Object a = aVar.isEmpty() ? null : a(sVar2, fVar, fVar2, z);
        android.support.v4.g.a b = b(sVar2, aVar3, a, aVar4);
        android.support.v4.g.a a2 = a(sVar2, aVar3, a, aVar4);
        if (aVar.isEmpty()) {
            if (b != null) {
                b.clear();
            }
            if (a2 != null) {
                a2.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, b, aVar.keySet());
            a(arrayList4, a2, aVar.values());
            obj4 = a;
        }
        if (obj3 == null && obj2 == null && obj4 == null) {
            return null;
        }
        Rect rect;
        View view3;
        a(fVar, fVar2, z, b, true);
        if (obj4 != null) {
            arrayList4.add(view2);
            sVar2.a(obj4, view2, arrayList3);
            a(sVar2, obj4, obj2, b, aVar4.e, aVar4.f);
            Rect rect2 = new Rect();
            View a3 = a(a2, aVar4, obj3, z);
            if (a3 != null) {
                sVar2.a(obj3, rect2);
            }
            rect = rect2;
            view3 = a3;
        } else {
            view3 = null;
            rect = view3;
        }
        final f fVar3 = fVar;
        final f fVar4 = fVar2;
        final boolean z2 = z;
        final android.support.v4.g.a aVar5 = a2;
        v.a(viewGroup, new Runnable() {
            public void run() {
                q.a(fVar3, fVar4, z2, aVar5, false);
                if (view3 != null) {
                    sVar2.a(view3, rect);
                }
            }
        });
        return obj4;
    }

    private static Object a(s sVar, Object obj, Object obj2, Object obj3, f fVar, boolean z) {
        boolean C = (obj == null || obj2 == null || fVar == null) ? true : z ? fVar.C() : fVar.B();
        return C ? sVar.a(obj2, obj, obj3) : sVar.b(obj2, obj, obj3);
    }

    private static String a(android.support.v4.g.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return (String) aVar.b(i);
            }
        }
        return null;
    }

    static ArrayList<View> a(s sVar, Object obj, f fVar, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2;
        if (obj != null) {
            arrayList2 = new ArrayList();
            View l = fVar.l();
            if (l != null) {
                sVar.a((ArrayList) arrayList2, l);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                sVar.a(obj, (ArrayList) arrayList2);
                return arrayList2;
            }
        }
        arrayList2 = null;
        return arrayList2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARNING: Missing block: B:19:0x0035, code:
            if (r10.l != false) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:41:0x006d, code:
            r1 = 1;
     */
    /* JADX WARNING: Missing block: B:42:0x006f, code:
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:47:0x007a, code:
            r13 = r1;
            r1 = null;
            r12 = 1;
     */
    /* JADX WARNING: Missing block: B:53:0x0089, code:
            if (r10.B == false) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:54:0x008b, code:
            r1 = true;
     */
    private static void a(android.support.v4.app.c r16, android.support.v4.app.c.a r17, android.util.SparseArray<android.support.v4.app.q.a> r18, boolean r19, boolean r20) {
        /*
        r0 = r16;
        r1 = r17;
        r2 = r18;
        r3 = r19;
        r10 = r1.b;
        if (r10 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r11 = r10.z;
        if (r11 != 0) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        if (r3 == 0) goto L_0x001b;
    L_0x0014:
        r4 = a;
        r1 = r1.a;
        r1 = r4[r1];
        goto L_0x001d;
    L_0x001b:
        r1 = r1.a;
    L_0x001d:
        r4 = 0;
        r5 = 1;
        if (r1 == r5) goto L_0x007e;
    L_0x0021:
        switch(r1) {
            case 3: goto L_0x0054;
            case 4: goto L_0x003c;
            case 5: goto L_0x0029;
            case 6: goto L_0x0054;
            case 7: goto L_0x007e;
            default: goto L_0x0024;
        };
    L_0x0024:
        r1 = r4;
        r12 = r1;
        r13 = r12;
        goto L_0x0092;
    L_0x0029:
        if (r20 == 0) goto L_0x0038;
    L_0x002b:
        r1 = r10.P;
        if (r1 == 0) goto L_0x008d;
    L_0x002f:
        r1 = r10.B;
        if (r1 != 0) goto L_0x008d;
    L_0x0033:
        r1 = r10.l;
        if (r1 == 0) goto L_0x008d;
    L_0x0037:
        goto L_0x008b;
    L_0x0038:
        r1 = r10.B;
        goto L_0x008e;
    L_0x003c:
        if (r20 == 0) goto L_0x004b;
    L_0x003e:
        r1 = r10.P;
        if (r1 == 0) goto L_0x006f;
    L_0x0042:
        r1 = r10.l;
        if (r1 == 0) goto L_0x006f;
    L_0x0046:
        r1 = r10.B;
        if (r1 == 0) goto L_0x006f;
    L_0x004a:
        goto L_0x006d;
    L_0x004b:
        r1 = r10.l;
        if (r1 == 0) goto L_0x006f;
    L_0x004f:
        r1 = r10.B;
        if (r1 != 0) goto L_0x006f;
    L_0x0053:
        goto L_0x004a;
    L_0x0054:
        if (r20 == 0) goto L_0x0071;
    L_0x0056:
        r1 = r10.l;
        if (r1 != 0) goto L_0x006f;
    L_0x005a:
        r1 = r10.J;
        if (r1 == 0) goto L_0x006f;
    L_0x005e:
        r1 = r10.J;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x006f;
    L_0x0066:
        r1 = r10.Q;
        r6 = 0;
        r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r1 < 0) goto L_0x006f;
    L_0x006d:
        r1 = r5;
        goto L_0x007a;
    L_0x006f:
        r1 = r4;
        goto L_0x007a;
    L_0x0071:
        r1 = r10.l;
        if (r1 == 0) goto L_0x006f;
    L_0x0075:
        r1 = r10.B;
        if (r1 != 0) goto L_0x006f;
    L_0x0079:
        goto L_0x006d;
    L_0x007a:
        r13 = r1;
        r1 = r4;
        r12 = r5;
        goto L_0x0092;
    L_0x007e:
        if (r20 == 0) goto L_0x0083;
    L_0x0080:
        r1 = r10.O;
        goto L_0x008e;
    L_0x0083:
        r1 = r10.l;
        if (r1 != 0) goto L_0x008d;
    L_0x0087:
        r1 = r10.B;
        if (r1 != 0) goto L_0x008d;
    L_0x008b:
        r1 = r5;
        goto L_0x008e;
    L_0x008d:
        r1 = r4;
    L_0x008e:
        r12 = r4;
        r13 = r12;
        r4 = r1;
        r1 = r5;
    L_0x0092:
        r6 = r2.get(r11);
        r6 = (android.support.v4.app.q.a) r6;
        if (r4 == 0) goto L_0x00a4;
    L_0x009a:
        r6 = a(r6, r2, r11);
        r6.a = r10;
        r6.b = r3;
        r6.c = r0;
    L_0x00a4:
        r14 = r6;
        r9 = 0;
        if (r20 != 0) goto L_0x00cc;
    L_0x00a8:
        if (r1 == 0) goto L_0x00cc;
    L_0x00aa:
        if (r14 == 0) goto L_0x00b2;
    L_0x00ac:
        r1 = r14.d;
        if (r1 != r10) goto L_0x00b2;
    L_0x00b0:
        r14.d = r9;
    L_0x00b2:
        r4 = r0.a;
        r1 = r10.b;
        if (r1 >= r5) goto L_0x00cc;
    L_0x00b8:
        r1 = r4.l;
        if (r1 < r5) goto L_0x00cc;
    L_0x00bc:
        r1 = r0.t;
        if (r1 != 0) goto L_0x00cc;
    L_0x00c0:
        r4.f(r10);
        r6 = 1;
        r7 = 0;
        r8 = 0;
        r1 = 0;
        r5 = r10;
        r9 = r1;
        r4.a(r5, r6, r7, r8, r9);
    L_0x00cc:
        if (r13 == 0) goto L_0x00de;
    L_0x00ce:
        if (r14 == 0) goto L_0x00d4;
    L_0x00d0:
        r1 = r14.d;
        if (r1 != 0) goto L_0x00de;
    L_0x00d4:
        r14 = a(r14, r2, r11);
        r14.d = r10;
        r14.e = r3;
        r14.f = r0;
    L_0x00de:
        if (r20 != 0) goto L_0x00eb;
    L_0x00e0:
        if (r12 == 0) goto L_0x00eb;
    L_0x00e2:
        if (r14 == 0) goto L_0x00eb;
    L_0x00e4:
        r0 = r14.a;
        if (r0 != r10) goto L_0x00eb;
    L_0x00e8:
        r0 = 0;
        r14.a = r0;
    L_0x00eb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.q.a(android.support.v4.app.c, android.support.v4.app.c$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void a(c cVar, SparseArray<a> sparseArray, boolean z) {
        int size = cVar.b.size();
        for (int i = 0; i < size; i++) {
            a(cVar, (a) cVar.b.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    static void a(f fVar, f fVar2, boolean z, android.support.v4.g.a<String, View> aVar, boolean z2) {
        w S = z ? fVar2.S() : fVar.S();
        if (S != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int i = 0;
            int size = aVar == null ? 0 : aVar.size();
            while (i < size) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
                i++;
            }
            if (z2) {
                S.a(arrayList2, arrayList, null);
                return;
            }
            S.b(arrayList2, arrayList, null);
        }
    }

    private static void a(l lVar, int i, a aVar, View view, android.support.v4.g.a<String, String> aVar2) {
        l lVar2 = lVar;
        a aVar3 = aVar;
        View view2 = view;
        View view3 = lVar2.n.a() ? (ViewGroup) lVar2.n.a(i) : null;
        if (view3 != null) {
            f fVar = aVar3.a;
            f fVar2 = aVar3.d;
            s a = a(fVar2, fVar);
            if (a != null) {
                boolean z = aVar3.b;
                boolean z2 = aVar3.e;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object a2 = a(a, fVar, z);
                Object b = b(a, fVar2, z2);
                Object obj = a2;
                View view4 = view3;
                ArrayList arrayList3 = arrayList2;
                Object a3 = a(a, (ViewGroup) view3, view2, (android.support.v4.g.a) aVar2, aVar3, arrayList2, arrayList, a2, b);
                Object obj2 = obj;
                if (obj2 == null && a3 == null) {
                    a2 = b;
                    if (a2 == null) {
                        return;
                    }
                }
                a2 = b;
                ArrayList a4 = a(a, a2, fVar2, arrayList3, view2);
                ArrayList a5 = a(a, obj2, fVar, arrayList, view2);
                a(a5, 4);
                f fVar3 = fVar;
                ArrayList arrayList4 = a4;
                Object a6 = a(a, obj2, a2, a3, fVar3, z);
                if (a6 != null) {
                    a(a, a2, fVar2, arrayList4);
                    ArrayList a7 = a.a(arrayList);
                    a.a(a6, obj2, a5, a2, arrayList4, a3, arrayList);
                    View view5 = view4;
                    a.a((ViewGroup) view5, a6);
                    a.a(view5, arrayList3, arrayList, a7, aVar2);
                    a(a5, 0);
                    a.a(a3, arrayList3, arrayList);
                }
            }
        }
    }

    static void a(l lVar, ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (lVar.l >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                c cVar = (c) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    b(cVar, sparseArray, z);
                } else {
                    a(cVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(lVar.m.g());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    android.support.v4.g.a a = a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                    a aVar = (a) sparseArray.valueAt(i4);
                    if (z) {
                        a(lVar, keyAt, aVar, view, a);
                    } else {
                        b(lVar, keyAt, aVar, view, a);
                    }
                }
            }
        }
    }

    private static void a(s sVar, ViewGroup viewGroup, f fVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final s sVar2 = sVar;
        final View view2 = view;
        final f fVar2 = fVar;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        v.a(viewGroup, new Runnable() {
            public void run() {
                if (obj3 != null) {
                    sVar2.c(obj3, view2);
                    arrayList5.addAll(q.a(sVar2, obj3, fVar2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        sVar2.b(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void a(s sVar, Object obj, f fVar, final ArrayList<View> arrayList) {
        if (fVar != null && obj != null && fVar.l && fVar.B && fVar.P) {
            fVar.f(true);
            sVar.b(obj, fVar.l(), (ArrayList) arrayList);
            v.a(fVar.I, new Runnable() {
                public void run() {
                    q.a(arrayList, 4);
                }
            });
        }
    }

    private static void a(s sVar, Object obj, Object obj2, android.support.v4.g.a<String, View> aVar, boolean z, c cVar) {
        if (cVar.r != null && !cVar.r.isEmpty()) {
            View view = (View) aVar.get((String) (z ? cVar.s : cVar.r).get(0));
            sVar.a(obj, view);
            if (obj2 != null) {
                sVar.a(obj2, view);
            }
        }
    }

    private static void a(android.support.v4.g.a<String, String> aVar, android.support.v4.g.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, android.support.v4.g.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.c(size);
            if (collection.contains(r.k(view))) {
                arrayList.add(view);
            }
        }
    }

    private static boolean a(s sVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!sVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static android.support.v4.g.a<String, View> b(s sVar, android.support.v4.g.a<String, String> aVar, Object obj, a aVar2) {
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        w S;
        ArrayList arrayList;
        f fVar = aVar2.d;
        Map aVar3 = new android.support.v4.g.a();
        sVar.a(aVar3, fVar.l());
        c cVar = aVar2.f;
        if (aVar2.e) {
            S = fVar.S();
            arrayList = cVar.s;
        } else {
            S = fVar.T();
            arrayList = cVar.r;
        }
        aVar3.a(arrayList);
        if (S != null) {
            S.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = (View) aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(r.k(view))) {
                    aVar.put(r.k(view), (String) aVar.remove(str));
                }
            }
        } else {
            aVar.a(aVar3.keySet());
        }
        return aVar3;
    }

    private static Object b(s sVar, f fVar, boolean z) {
        if (fVar == null) {
            return null;
        }
        return sVar.b(z ? fVar.w() : fVar.x());
    }

    private static Object b(s sVar, ViewGroup viewGroup, View view, android.support.v4.g.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        s sVar2 = sVar;
        a aVar3 = aVar2;
        final ArrayList arrayList3 = arrayList;
        final Object obj3 = obj;
        f fVar = aVar3.a;
        f fVar2 = aVar3.d;
        if (fVar == null || fVar2 == null) {
            return null;
        }
        android.support.v4.g.a aVar4;
        Object obj4;
        Object obj5;
        boolean z = aVar3.b;
        if (aVar.isEmpty()) {
            aVar4 = aVar;
            obj4 = null;
        } else {
            obj4 = a(sVar2, fVar, fVar2, z);
            aVar4 = aVar;
        }
        android.support.v4.g.a b = b(sVar2, aVar4, obj4, aVar3);
        if (aVar.isEmpty()) {
            obj5 = null;
        } else {
            arrayList3.addAll(b.values());
            obj5 = obj4;
        }
        if (obj3 == null && obj2 == null && obj5 == null) {
            return null;
        }
        Rect rect;
        a(fVar, fVar2, z, b, true);
        if (obj5 != null) {
            rect = new Rect();
            sVar2.a(obj5, view, arrayList3);
            a(sVar2, obj5, obj2, b, aVar3.e, aVar3.f);
            if (obj3 != null) {
                sVar2.a(obj3, rect);
            }
        } else {
            rect = null;
        }
        final s sVar3 = sVar2;
        final android.support.v4.g.a aVar5 = aVar4;
        final Object obj6 = obj5;
        final a aVar6 = aVar3;
        AnonymousClass4 anonymousClass4 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final f fVar3 = fVar;
        fVar = fVar2;
        final boolean z2 = z;
        final Rect rect2 = rect;
        AnonymousClass4 anonymousClass42 = new Runnable() {
            public void run() {
                android.support.v4.g.a a = q.a(sVar3, aVar5, obj6, aVar6);
                if (a != null) {
                    arrayList4.addAll(a.values());
                    arrayList4.add(view2);
                }
                q.a(fVar3, fVar, z2, a, false);
                if (obj6 != null) {
                    sVar3.a(obj6, arrayList3, arrayList4);
                    View a2 = q.a(a, aVar6, obj3, z2);
                    if (a2 != null) {
                        sVar3.a(a2, rect2);
                    }
                }
            }
        };
        v.a(viewGroup, anonymousClass4);
        return obj5;
    }

    public static void b(c cVar, SparseArray<a> sparseArray, boolean z) {
        if (cVar.a.n.a()) {
            for (int size = cVar.b.size() - 1; size >= 0; size--) {
                a(cVar, (a) cVar.b.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    private static void b(l lVar, int i, a aVar, View view, android.support.v4.g.a<String, String> aVar2) {
        l lVar2 = lVar;
        a aVar3 = aVar;
        View view2 = view;
        Map map = aVar2;
        ViewGroup viewGroup = lVar2.n.a() ? (ViewGroup) lVar2.n.a(i) : null;
        if (viewGroup != null) {
            f fVar = aVar3.a;
            f fVar2 = aVar3.d;
            s a = a(fVar2, fVar);
            if (a != null) {
                Object obj;
                boolean z = aVar3.b;
                boolean z2 = aVar3.e;
                Object a2 = a(a, fVar, z);
                Object b = b(a, fVar2, z2);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = arrayList;
                Object obj2 = b;
                Object obj3 = a2;
                s sVar = a;
                b = b(a, viewGroup, view2, map, aVar3, arrayList, arrayList2, a2, obj2);
                Object obj4 = obj3;
                if (obj4 == null && b == null) {
                    obj = obj2;
                    if (obj == null) {
                        return;
                    }
                }
                obj = obj2;
                ArrayList a3 = a(sVar, obj, fVar2, arrayList3, view2);
                Object obj5 = (a3 == null || a3.isEmpty()) ? null : obj;
                sVar.b(obj4, view2);
                Object a4 = a(sVar, obj4, obj5, b, fVar, aVar3.b);
                if (a4 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    s sVar2 = sVar;
                    arrayList3 = arrayList4;
                    sVar2.a(a4, obj4, arrayList4, obj5, a3, b, arrayList2);
                    a(sVar2, viewGroup, fVar, view2, arrayList2, obj4, arrayList3, obj5, a3);
                    ArrayList arrayList5 = arrayList2;
                    sVar.a((View) viewGroup, arrayList5, map);
                    sVar.a(viewGroup, a4);
                    sVar.a(viewGroup, arrayList5, map);
                }
            }
        }
    }
}
