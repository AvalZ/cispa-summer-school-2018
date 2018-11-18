package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.at.i;
import android.support.v7.widget.at.j;
import android.support.v7.widget.at.p;
import android.support.v7.widget.at.u;
import android.support.v7.widget.at.x;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends i {
    private c a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final b g;
    private int h;
    int i;
    as j;
    boolean k;
    int l;
    int m;
    d n;
    final a o;

    static class a {
        as a;
        int b;
        int c;
        boolean d;
        boolean e;

        a() {
            a();
        }

        void a() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public void a(View view, int i) {
            int b = this.a.b();
            if (b >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            int e;
            if (this.d) {
                i = (this.a.d() - b) - this.a.b(view);
                this.c = this.a.d() - i;
                if (i > 0) {
                    e = this.c - this.a.e(view);
                    b = this.a.c();
                    e -= b + Math.min(this.a.a(view) - b, 0);
                    if (e < 0) {
                        this.c += Math.min(i, -e);
                        return;
                    }
                }
            }
            i = this.a.a(view);
            e = i - this.a.c();
            this.c = i;
            if (e > 0) {
                int d = (this.a.d() - Math.min(0, (this.a.d() - b) - this.a.b(view))) - (i + this.a.e(view));
                if (d < 0) {
                    this.c -= Math.min(e, -d);
                }
            }
        }

        boolean a(View view, u uVar) {
            j jVar = (j) view.getLayoutParams();
            return !jVar.d() && jVar.f() >= 0 && jVar.f() < uVar.e();
        }

        void b() {
            this.c = this.d ? this.a.d() : this.a.c();
        }

        public void b(View view, int i) {
            this.c = this.d ? this.a.b(view) + this.a.b() : this.a.a(view);
            this.b = i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AnchorInfo{mPosition=");
            stringBuilder.append(this.b);
            stringBuilder.append(", mCoordinate=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mLayoutFromEnd=");
            stringBuilder.append(this.d);
            stringBuilder.append(", mValid=");
            stringBuilder.append(this.e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    protected static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {
        boolean a = true;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        boolean i = false;
        int j;
        List<x> k = null;
        boolean l;

        c() {
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = ((x) this.k.get(i)).a;
                j jVar = (j) view.getLayoutParams();
                if (!jVar.d() && this.d == jVar.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        View a(p pVar) {
            if (this.k != null) {
                return b();
            }
            View c = pVar.c(this.d);
            this.d += this.e;
            return c;
        }

        public void a() {
            a(null);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0015 in {2, 4, 5} preds:[]
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
            */
        public void a(android.view.View r1) {
            /*
            r0 = this;
            r1 = r0.b(r1);
            if (r1 != 0) goto L_0x000a;
        L_0x0006:
            r1 = -1;
        L_0x0007:
            r0.d = r1;
            return;
        L_0x000a:
            r1 = r1.getLayoutParams();
            r1 = (android.support.v7.widget.at.j) r1;
            r1 = r1.f();
            goto L_0x0007;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.c.a(android.view.View):void");
        }

        boolean a(u uVar) {
            return this.d >= 0 && this.d < uVar.e();
        }

        public View b(View view) {
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((x) this.k.get(i2)).a;
                j jVar = (j) view3.getLayoutParams();
                if (!(view3 == view || jVar.d())) {
                    int f = (jVar.f() - this.d) * this.e;
                    if (f >= 0 && f < i) {
                        if (f == 0) {
                            return view3;
                        }
                        view2 = view3;
                        i = f;
                    }
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Creator<d> CREATOR = new Creator<d>() {
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };
        int a;
        int b;
        boolean c;

        d(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.c = z;
        }

        public d(d dVar) {
            this.a = dVar.a;
            this.b = dVar.b;
            this.c = dVar.c;
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        b(i);
        b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        android.support.v7.widget.at.i.b a = i.a(context, attributeSet, i, i2);
        b(a.a);
        b(a.c);
        a(a.d);
    }

    private void K() {
        boolean z = (this.i == 1 || !h()) ? this.c : this.c ^ true;
        this.k = z;
    }

    private View L() {
        return h(this.k ? v() - 1 : 0);
    }

    private View M() {
        return h(this.k ? 0 : v() - 1);
    }

    private int a(int i, p pVar, u uVar, boolean z) {
        int d = this.j.d() - i;
        if (d <= 0) {
            return 0;
        }
        int i2 = -c(-d, pVar, uVar);
        i += i2;
        if (z) {
            int d2 = this.j.d() - i;
            if (d2 > 0) {
                this.j.a(d2);
                return d2 + i2;
            }
        }
        return i2;
    }

    private View a(boolean z, boolean z2) {
        int v;
        int i;
        if (this.k) {
            v = v() - 1;
            i = -1;
        } else {
            v = 0;
            i = v();
        }
        return a(v, i, z, z2);
    }

    private void a(int i, int i2) {
        this.a.c = this.j.d() - i2;
        this.a.e = this.k ? -1 : 1;
        this.a.d = i;
        this.a.f = 1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private void a(int i, int i2, boolean z, u uVar) {
        this.a.l = k();
        this.a.h = b(uVar);
        this.a.f = i;
        int i3 = -1;
        View M;
        c cVar;
        if (i == 1) {
            c cVar2 = this.a;
            cVar2.h += this.j.g();
            M = M();
            cVar = this.a;
            if (!this.k) {
                i3 = 1;
            }
            cVar.e = i3;
            this.a.d = d(M) + this.a.e;
            this.a.b = this.j.b(M);
            i = this.j.b(M) - this.j.d();
        } else {
            M = L();
            cVar = this.a;
            cVar.h += this.j.c();
            cVar = this.a;
            if (this.k) {
                i3 = 1;
            }
            cVar.e = i3;
            this.a.d = d(M) + this.a.e;
            this.a.b = this.j.a(M);
            i = (-this.j.a(M)) + this.j.c();
        }
        this.a.c = i2;
        if (z) {
            c cVar3 = this.a;
            cVar3.c -= i;
        }
        this.a.g = i;
    }

    private void a(a aVar) {
        a(aVar.b, aVar.c);
    }

    private void a(p pVar, int i) {
        if (i >= 0) {
            int v = v();
            if (this.k) {
                v--;
                for (int i2 = v; i2 >= 0; i2--) {
                    View h = h(i2);
                    if (this.j.b(h) > i || this.j.c(h) > i) {
                        a(pVar, v, i2);
                        return;
                    }
                }
            } else {
                for (int i3 = 0; i3 < v; i3++) {
                    View h2 = h(i3);
                    if (this.j.b(h2) > i || this.j.c(h2) > i) {
                        a(pVar, 0, i3);
                        break;
                    }
                }
            }
        }
    }

    private void a(p pVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (i2--; i2 >= i; i2--) {
                    a(i2, pVar);
                }
            } else {
                while (i > i2) {
                    a(i, pVar);
                    i--;
                }
            }
        }
    }

    private void a(p pVar, c cVar) {
        if (cVar.a && !cVar.l) {
            if (cVar.f == -1) {
                b(pVar, cVar.g);
            } else {
                a(pVar, cVar.g);
            }
        }
    }

    private void a(p pVar, u uVar, a aVar) {
        if (!a(uVar, aVar) && !b(pVar, uVar, aVar)) {
            aVar.b();
            aVar.b = this.d ? uVar.e() - 1 : 0;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:19:0x0052
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:360)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:56)
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
    private boolean a(android.support.v7.widget.at.u r5, android.support.v7.widget.LinearLayoutManager.a r6) {
        /*
        r4 = this;
        r0 = r5.a();
        r1 = 0;
        if (r0 != 0) goto L_0x0103;
    L_0x0007:
        r0 = r4.l;
        r2 = -1;
        if (r0 != r2) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r0 = r4.l;
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r0 < 0) goto L_0x00ff;
    L_0x0013:
        r0 = r4.l;
        r5 = r5.e();
        if (r0 < r5) goto L_0x001d;
    L_0x001b:
        goto L_0x00ff;
    L_0x001d:
        r5 = r4.l;
        r6.b = r5;
        r5 = r4.n;
        r0 = 1;
        if (r5 == 0) goto L_0x0053;
    L_0x0026:
        r5 = r4.n;
        r5 = r5.a();
        if (r5 == 0) goto L_0x0053;
    L_0x002e:
        r5 = r4.n;
        r5 = r5.c;
        r6.d = r5;
        r5 = r6.d;
        if (r5 == 0) goto L_0x0046;
    L_0x0038:
        r5 = r4.j;
        r5 = r5.d();
        r4 = r4.n;
        r4 = r4.b;
        r5 = r5 - r4;
    L_0x0043:
        r6.c = r5;
        return r0;
    L_0x0046:
        r5 = r4.j;
        r5 = r5.c();
        r4 = r4.n;
        r4 = r4.b;
        r5 = r5 + r4;
        goto L_0x0043;
        return r0;
    L_0x0053:
        r5 = r4.m;
        if (r5 != r3) goto L_0x00e0;
    L_0x0057:
        r5 = r4.l;
        r5 = r4.c(r5);
        if (r5 == 0) goto L_0x00c0;
    L_0x005f:
        r2 = r4.j;
        r2 = r2.e(r5);
        r3 = r4.j;
        r3 = r3.f();
        if (r2 <= r3) goto L_0x0071;
    L_0x006d:
        r6.b();
        return r0;
    L_0x0071:
        r2 = r4.j;
        r2 = r2.a(r5);
        r3 = r4.j;
        r3 = r3.c();
        r2 = r2 - r3;
        if (r2 >= 0) goto L_0x008b;
    L_0x0080:
        r4 = r4.j;
        r4 = r4.c();
        r6.c = r4;
        r6.d = r1;
        return r0;
    L_0x008b:
        r1 = r4.j;
        r1 = r1.d();
        r2 = r4.j;
        r2 = r2.b(r5);
        r1 = r1 - r2;
        if (r1 >= 0) goto L_0x00a5;
    L_0x009a:
        r4 = r4.j;
        r4 = r4.d();
        r6.c = r4;
        r6.d = r0;
        return r0;
    L_0x00a5:
        r1 = r6.d;
        if (r1 == 0) goto L_0x00b7;
    L_0x00a9:
        r1 = r4.j;
        r5 = r1.b(r5);
        r4 = r4.j;
        r4 = r4.b();
        r5 = r5 + r4;
        goto L_0x00bd;
    L_0x00b7:
        r4 = r4.j;
        r5 = r4.a(r5);
    L_0x00bd:
        r6.c = r5;
        return r0;
    L_0x00c0:
        r5 = r4.v();
        if (r5 <= 0) goto L_0x00dc;
    L_0x00c6:
        r5 = r4.h(r1);
        r5 = r4.d(r5);
        r2 = r4.l;
        if (r2 >= r5) goto L_0x00d4;
    L_0x00d2:
        r5 = r0;
        goto L_0x00d5;
    L_0x00d4:
        r5 = r1;
    L_0x00d5:
        r4 = r4.k;
        if (r5 != r4) goto L_0x00da;
    L_0x00d9:
        r1 = r0;
    L_0x00da:
        r6.d = r1;
    L_0x00dc:
        r6.b();
        return r0;
    L_0x00e0:
        r5 = r4.k;
        r6.d = r5;
        r5 = r4.k;
        if (r5 == 0) goto L_0x00f4;
    L_0x00e8:
        r5 = r4.j;
        r5 = r5.d();
        r4 = r4.m;
        r5 = r5 - r4;
    L_0x00f1:
        r6.c = r5;
        return r0;
    L_0x00f4:
        r5 = r4.j;
        r5 = r5.c();
        r4 = r4.m;
        r5 = r5 + r4;
        goto L_0x00f1;
        return r0;
    L_0x00ff:
        r4.l = r2;
        r4.m = r3;
    L_0x0103:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.a(android.support.v7.widget.at$u, android.support.v7.widget.LinearLayoutManager$a):boolean");
    }

    private int b(int i, p pVar, u uVar, boolean z) {
        int c = i - this.j.c();
        if (c <= 0) {
            return 0;
        }
        int i2 = -c(c, pVar, uVar);
        i += i2;
        if (z) {
            i -= this.j.c();
            if (i > 0) {
                this.j.a(-i);
                i2 -= i;
            }
        }
        return i2;
    }

    private View b(boolean z, boolean z2) {
        int i;
        int v;
        if (this.k) {
            i = 0;
            v = v();
        } else {
            i = v() - 1;
            v = -1;
        }
        return a(i, v, z, z2);
    }

    private void b(a aVar) {
        g(aVar.b, aVar.c);
    }

    private void b(p pVar, int i) {
        int v = v();
        if (i >= 0) {
            int e = this.j.e() - i;
            if (this.k) {
                for (int i2 = 0; i2 < v; i2++) {
                    View h = h(i2);
                    if (this.j.a(h) < e || this.j.d(h) < e) {
                        a(pVar, 0, i2);
                        return;
                    }
                }
            } else {
                v--;
                for (i = v; i >= 0; i--) {
                    View h2 = h(i);
                    if (this.j.a(h2) < e || this.j.d(h2) < e) {
                        a(pVar, v, i);
                        break;
                    }
                }
            }
        }
    }

    private void b(p pVar, u uVar, int i, int i2) {
        p pVar2 = pVar;
        u uVar2 = uVar;
        if (uVar.b() && v() != 0 && !uVar.a() && b()) {
            List c = pVar.c();
            int size = c.size();
            int d = d(h(0));
            int i3 = 0;
            int i4 = i3;
            int i5 = i4;
            while (i3 < size) {
                x xVar = (x) c.get(i3);
                if (!xVar.q()) {
                    Object obj = 1;
                    if ((xVar.d() < d) != this.k) {
                        obj = -1;
                    }
                    if (obj == -1) {
                        i4 += this.j.e(xVar.a);
                    } else {
                        i5 += this.j.e(xVar.a);
                    }
                }
                i3++;
            }
            this.a.k = c;
            if (i4 > 0) {
                g(d(L()), i);
                this.a.h = i4;
                this.a.c = 0;
                this.a.a();
                a(pVar2, this.a, uVar2, false);
            }
            if (i5 > 0) {
                a(d(M()), i2);
                this.a.h = i5;
                this.a.c = 0;
                this.a.a();
                a(pVar2, this.a, uVar2, false);
            }
            this.a.k = null;
        }
    }

    private boolean b(p pVar, u uVar, a aVar) {
        boolean z = false;
        if (v() == 0) {
            return false;
        }
        View E = E();
        if (E != null && aVar.a(E, uVar)) {
            aVar.a(E, d(E));
            return true;
        } else if (this.b != this.d) {
            return false;
        } else {
            View f = aVar.d ? f(pVar, uVar) : g(pVar, uVar);
            if (f == null) {
                return false;
            }
            aVar.b(f, d(f));
            if (!uVar.a() && b()) {
                if (this.j.a(f) >= this.j.d() || this.j.b(f) < this.j.c()) {
                    z = true;
                }
                if (z) {
                    aVar.c = aVar.d ? this.j.d() : this.j.c();
                }
            }
            return true;
        }
    }

    private View f(p pVar, u uVar) {
        return this.k ? h(pVar, uVar) : i(pVar, uVar);
    }

    private View g(p pVar, u uVar) {
        return this.k ? i(pVar, uVar) : h(pVar, uVar);
    }

    private void g(int i, int i2) {
        this.a.c = i2 - this.j.c();
        this.a.d = i;
        this.a.e = this.k ? 1 : -1;
        this.a.f = -1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private View h(p pVar, u uVar) {
        return a(pVar, uVar, 0, v(), uVar.e());
    }

    private int i(u uVar) {
        if (v() == 0) {
            return 0;
        }
        i();
        as asVar = this.j;
        View a = a(this.e ^ true, true);
        return ax.a(uVar, asVar, a, b(this.e ^ true, true), this, this.e, this.k);
    }

    private View i(p pVar, u uVar) {
        return a(pVar, uVar, v() - 1, -1, uVar.e());
    }

    private int j(u uVar) {
        if (v() == 0) {
            return 0;
        }
        i();
        as asVar = this.j;
        View a = a(this.e ^ true, true);
        return ax.a(uVar, asVar, a, b(this.e ^ true, true), this, this.e);
    }

    private View j(p pVar, u uVar) {
        return this.k ? l(pVar, uVar) : m(pVar, uVar);
    }

    private int k(u uVar) {
        if (v() == 0) {
            return 0;
        }
        i();
        as asVar = this.j;
        View a = a(this.e ^ true, true);
        return ax.b(uVar, asVar, a, b(this.e ^ true, true), this, this.e);
    }

    private View k(p pVar, u uVar) {
        return this.k ? m(pVar, uVar) : l(pVar, uVar);
    }

    private View l(p pVar, u uVar) {
        return b(0, v());
    }

    private View m(p pVar, u uVar) {
        return b(v() - 1, -1);
    }

    public int a(int i, p pVar, u uVar) {
        return this.i == 1 ? 0 : c(i, pVar, uVar);
    }

    int a(p pVar, c cVar, u uVar, boolean z) {
        int i = cVar.c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.c < 0) {
                cVar.g += cVar.c;
            }
            a(pVar, cVar);
        }
        int i2 = cVar.c + cVar.h;
        b bVar = this.g;
        while (true) {
            if ((!cVar.l && i2 <= 0) || !cVar.a(uVar)) {
                break;
            }
            bVar.a();
            a(pVar, uVar, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!(bVar.c && this.a.k == null && uVar.a())) {
                    cVar.c -= bVar.a;
                    i2 -= bVar.a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.a;
                    if (cVar.c < 0) {
                        cVar.g += cVar.c;
                    }
                    a(pVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    public j a() {
        return new j(-2, -2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:13:0x001d in {2, 3, 5, 6, 9, 11, 12} preds:[]
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
    android.view.View a(int r2, int r3, boolean r4, boolean r5) {
        /*
        r1 = this;
        r1.i();
        r0 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        if (r4 == 0) goto L_0x000a;
    L_0x0007:
        r4 = 24579; // 0x6003 float:3.4443E-41 double:1.21436E-319;
        goto L_0x000b;
    L_0x000a:
        r4 = r0;
    L_0x000b:
        if (r5 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x000f;
    L_0x000e:
        r0 = 0;
    L_0x000f:
        r5 = r1.i;
        if (r5 != 0) goto L_0x001a;
    L_0x0013:
        r1 = r1.r;
    L_0x0015:
        r1 = r1.a(r2, r3, r4, r0);
        return r1;
    L_0x001a:
        r1 = r1.s;
        goto L_0x0015;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.a(int, int, boolean, boolean):android.view.View");
    }

    View a(p pVar, u uVar, int i, int i2, int i3) {
        i();
        int c = this.j.c();
        int d = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View h = h(i);
            int d2 = d(h);
            if (d2 >= 0 && d2 < i3) {
                if (((j) h.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = h;
                    }
                } else if (this.j.a(h) < d && this.j.b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view = h;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    public View a(View view, int i, p pVar, u uVar) {
        K();
        if (v() == 0) {
            return null;
        }
        int e = e(i);
        if (e == Integer.MIN_VALUE) {
            return null;
        }
        i();
        i();
        a(e, (int) (((float) this.j.f()) * 0.33333334f), false, uVar);
        this.a.g = Integer.MIN_VALUE;
        this.a.a = false;
        a(pVar, this.a, uVar, true);
        View k = e == -1 ? k(pVar, uVar) : j(pVar, uVar);
        View L = e == -1 ? L() : M();
        return L.hasFocusable() ? k == null ? null : L : k;
    }

    public void a(int i, int i2, u uVar, android.support.v7.widget.at.i.a aVar) {
        if (this.i != 0) {
            i = i2;
        }
        if (v() != 0 && i != 0) {
            i();
            a(i > 0 ? 1 : -1, Math.abs(i), true, uVar);
            a(uVar, this.a, aVar);
        }
    }

    public void a(int i, android.support.v7.widget.at.i.a aVar) {
        boolean z;
        int i2;
        int i3 = -1;
        if (this.n == null || !this.n.a()) {
            K();
            z = this.k;
            i2 = this.l == -1 ? z ? i - 1 : 0 : this.l;
        } else {
            z = this.n.c;
            i2 = this.n.a;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.h && i2 >= 0 && i2 < i; i4++) {
            aVar.b(i2, 0);
            i2 += i3;
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.n = (d) parcelable;
            o();
        }
    }

    void a(p pVar, u uVar, a aVar, int i) {
    }

    void a(p pVar, u uVar, c cVar, b bVar) {
        View a = cVar.a(pVar);
        if (a == null) {
            bVar.b = true;
            return;
        }
        int f;
        int i;
        int i2;
        int i3;
        j jVar = (j) a.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f == -1)) {
                b(a);
            } else {
                b(a, 0);
            }
        } else {
            if (this.k == (cVar.f == -1)) {
                a(a);
            } else {
                a(a, 0);
            }
        }
        a(a, 0, 0);
        bVar.a = this.j.e(a);
        int y;
        if (this.i == 1) {
            if (h()) {
                y = y() - C();
                f = y - this.j.f(a);
            } else {
                f = A();
                y = this.j.f(a) + f;
            }
            if (cVar.f == -1) {
                i = cVar.b - bVar.a;
                i2 = y;
                i3 = cVar.b;
            } else {
                i3 = cVar.b + bVar.a;
                i2 = y;
                i = cVar.b;
            }
        } else {
            y = B();
            f = this.j.f(a) + y;
            if (cVar.f == -1) {
                i = y;
                i2 = cVar.b;
                i3 = f;
                f = cVar.b - bVar.a;
            } else {
                i2 = cVar.b + bVar.a;
                i = y;
                i3 = f;
                f = cVar.b;
            }
        }
        a(a, f, i, i2, i3);
        if (jVar.d() || jVar.e()) {
            bVar.c = true;
        }
        bVar.d = a.hasFocusable();
    }

    public void a(u uVar) {
        super.a(uVar);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    void a(u uVar, c cVar, android.support.v7.widget.at.i.a aVar) {
        int i = cVar.d;
        if (i >= 0 && i < uVar.e()) {
            aVar.b(i, Math.max(0, cVar.g));
        }
    }

    public void a(at atVar, p pVar) {
        super.a(atVar, pVar);
        if (this.f) {
            c(pVar);
            pVar.a();
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(m());
            accessibilityEvent.setToIndex(n());
        }
    }

    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (this.d != z) {
            this.d = z;
            o();
        }
    }

    public int b(int i, p pVar, u uVar) {
        return this.i == 0 ? 0 : c(i, pVar, uVar);
    }

    protected int b(u uVar) {
        return uVar.d() ? this.j.f() : 0;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:19:0x003c in {2, 4, 5, 8, 11, 12, 15, 17, 18} preds:[]
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
    android.view.View b(int r4, int r5) {
        /*
        r3 = this;
        r3.i();
        if (r5 <= r4) goto L_0x0007;
    L_0x0005:
        r0 = 1;
        goto L_0x000c;
    L_0x0007:
        if (r5 >= r4) goto L_0x000b;
    L_0x0009:
        r0 = -1;
        goto L_0x000c;
    L_0x000b:
        r0 = 0;
    L_0x000c:
        if (r0 != 0) goto L_0x0013;
    L_0x000e:
        r3 = r3.h(r4);
        return r3;
    L_0x0013:
        r0 = r3.j;
        r1 = r3.h(r4);
        r0 = r0.a(r1);
        r1 = r3.j;
        r1 = r1.c();
        if (r0 >= r1) goto L_0x002a;
    L_0x0025:
        r0 = 16644; // 0x4104 float:2.3323E-41 double:8.223E-320;
        r1 = 16388; // 0x4004 float:2.2964E-41 double:8.0967E-320;
        goto L_0x002e;
    L_0x002a:
        r0 = 4161; // 0x1041 float:5.831E-42 double:2.056E-320;
        r1 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
    L_0x002e:
        r2 = r3.i;
        if (r2 != 0) goto L_0x0039;
    L_0x0032:
        r3 = r3.r;
    L_0x0034:
        r3 = r3.a(r4, r5, r0, r1);
        return r3;
    L_0x0039:
        r3 = r3.s;
        goto L_0x0034;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.b(int, int):android.view.View");
    }

    public void b(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.i || this.j == null) {
                this.j = as.a(this, i);
                this.o.a = this.j;
                this.i = i;
                o();
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid orientation:");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void b(boolean z) {
        a(null);
        if (z != this.c) {
            this.c = z;
            o();
        }
    }

    public boolean b() {
        return this.n == null && this.b == this.d;
    }

    int c(int i, p pVar, u uVar) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        this.a.a = true;
        i();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, uVar);
        int a = this.a.g + a(pVar, this.a, uVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.j.a(-i);
        this.a.j = i;
        return i;
    }

    public int c(u uVar) {
        return i(uVar);
    }

    public View c(int i) {
        int v = v();
        if (v == 0) {
            return null;
        }
        int d = i - d(h(0));
        if (d >= 0 && d < v) {
            View h = h(d);
            if (d(h) == i) {
                return h;
            }
        }
        return super.c(i);
    }

    public void c(p pVar, u uVar) {
        int i = -1;
        if (!(this.n == null && this.l == -1) && uVar.e() == 0) {
            c(pVar);
            return;
        }
        int i2;
        int i3;
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        i();
        this.a.a = false;
        K();
        View E = E();
        if (!this.o.e || this.l != -1 || this.n != null) {
            this.o.a();
            this.o.d = this.k ^ this.d;
            a(pVar, uVar, this.o);
            this.o.e = true;
        } else if (E != null && (this.j.a(E) >= this.j.d() || this.j.b(E) <= this.j.c())) {
            this.o.a(E, d(E));
        }
        int b = b(uVar);
        if (this.a.j >= 0) {
            i2 = b;
            b = 0;
        } else {
            i2 = 0;
        }
        b += this.j.c();
        i2 += this.j.g();
        if (!(!uVar.a() || this.l == -1 || this.m == Integer.MIN_VALUE)) {
            View c = c(this.l);
            if (c != null) {
                int d;
                if (this.k) {
                    d = this.j.d() - this.j.b(c);
                    i3 = this.m;
                } else {
                    i3 = this.j.a(c) - this.j.c();
                    d = this.m;
                }
                d -= i3;
                if (d > 0) {
                    b += d;
                } else {
                    i2 -= d;
                }
            }
        }
        if (this.o.d ? this.k : !this.k) {
            i = 1;
        }
        a(pVar, uVar, this.o, i);
        a(pVar);
        this.a.l = k();
        this.a.i = uVar.a();
        if (this.o.d) {
            b(this.o);
            this.a.h = b;
            a(pVar, this.a, uVar, false);
            b = this.a.b;
            i = this.a.d;
            if (this.a.c > 0) {
                i2 += this.a.c;
            }
            a(this.o);
            this.a.h = i2;
            c cVar = this.a;
            cVar.d += this.a.e;
            a(pVar, this.a, uVar, false);
            i2 = this.a.b;
            if (this.a.c > 0) {
                i3 = this.a.c;
                g(i, b);
                this.a.h = i3;
                a(pVar, this.a, uVar, false);
                b = this.a.b;
            }
        } else {
            a(this.o);
            this.a.h = i2;
            a(pVar, this.a, uVar, false);
            i2 = this.a.b;
            i = this.a.d;
            if (this.a.c > 0) {
                b += this.a.c;
            }
            b(this.o);
            this.a.h = b;
            c cVar2 = this.a;
            cVar2.d += this.a.e;
            a(pVar, this.a, uVar, false);
            b = this.a.b;
            if (this.a.c > 0) {
                i3 = this.a.c;
                a(i, i2);
                this.a.h = i3;
                a(pVar, this.a, uVar, false);
                i2 = this.a.b;
            }
        }
        if (v() > 0) {
            if ((this.k ^ this.d) != 0) {
                i = a(i2, pVar, uVar, true);
                b += i;
                i2 += i;
                i = b(b, pVar, uVar, false);
            } else {
                i = b(b, pVar, uVar, true);
                b += i;
                i2 += i;
                i = a(i2, pVar, uVar, false);
            }
            b += i;
            i2 += i;
        }
        b(pVar, uVar, b, i2);
        if (uVar.a()) {
            this.o.a();
        } else {
            this.j.a();
        }
        this.b = this.d;
    }

    public boolean c() {
        return true;
    }

    public int d(u uVar) {
        return i(uVar);
    }

    public Parcelable d() {
        if (this.n != null) {
            return new d(this.n);
        }
        Parcelable dVar = new d();
        if (v() > 0) {
            i();
            boolean z = this.b ^ this.k;
            dVar.c = z;
            View M;
            if (z) {
                M = M();
                dVar.b = this.j.d() - this.j.b(M);
                dVar.a = d(M);
                return dVar;
            }
            M = L();
            dVar.a = d(M);
            dVar.b = this.j.a(M) - this.j.c();
            return dVar;
        }
        dVar.b();
        return dVar;
    }

    public void d(int i) {
        this.l = i;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        o();
    }

    int e(int i) {
        int i2 = Integer.MIN_VALUE;
        if (i == 17) {
            return this.i == 0 ? -1 : Integer.MIN_VALUE;
        } else {
            if (i == 33) {
                return this.i == 1 ? -1 : Integer.MIN_VALUE;
            } else {
                if (i == 66) {
                    if (this.i == 0) {
                        i2 = 1;
                    }
                    return i2;
                } else if (i != 130) {
                    switch (i) {
                        case 1:
                            return (this.i != 1 && h()) ? 1 : -1;
                        case 2:
                            return (this.i != 1 && h()) ? -1 : 1;
                        default:
                            return Integer.MIN_VALUE;
                    }
                } else {
                    if (this.i == 1) {
                        i2 = 1;
                    }
                    return i2;
                }
            }
        }
    }

    public int e(u uVar) {
        return j(uVar);
    }

    public boolean e() {
        return this.i == 0;
    }

    public int f(u uVar) {
        return j(uVar);
    }

    public boolean f() {
        return this.i == 1;
    }

    public int g() {
        return this.i;
    }

    public int g(u uVar) {
        return k(uVar);
    }

    public int h(u uVar) {
        return k(uVar);
    }

    protected boolean h() {
        return t() == 1;
    }

    void i() {
        if (this.a == null) {
            this.a = j();
        }
    }

    c j() {
        return new c();
    }

    boolean k() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    boolean l() {
        return (x() == 1073741824 || w() == 1073741824 || !J()) ? false : true;
    }

    public int m() {
        View a = a(0, v(), false, true);
        return a == null ? -1 : d(a);
    }

    public int n() {
        View a = a(v() - 1, -1, false, true);
        return a == null ? -1 : d(a);
    }
}
