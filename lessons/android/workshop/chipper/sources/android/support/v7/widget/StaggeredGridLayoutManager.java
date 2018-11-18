package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.at.i;
import android.support.v7.widget.at.j;
import android.support.v7.widget.at.p;
import android.support.v7.widget.at.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends i {
    private d A;
    private int B;
    private final Rect C = new Rect();
    private final a D = new a();
    private boolean E = false;
    private boolean F = true;
    private int[] G;
    private final Runnable H = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    };
    e[] a;
    as b;
    as c;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    c h = new c();
    private int i = -1;
    private int j;
    private int k;
    private final am l;
    private BitSet m;
    private int n = 2;
    private boolean o;
    private boolean z;

    class a {
        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            a();
        }

        void a() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            if (this.f != null) {
                Arrays.fill(this.f, -1);
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x001a in {2, 4, 5} preds:[]
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
        void a(int r2) {
            /*
            r1 = this;
            r0 = r1.c;
            if (r0 == 0) goto L_0x0010;
        L_0x0004:
            r0 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r0 = r0.b;
            r0 = r0.d();
            r0 = r0 - r2;
        L_0x000d:
            r1.b = r0;
            return;
        L_0x0010:
            r0 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r0 = r0.b;
            r0 = r0.c();
            r0 = r0 + r2;
            goto L_0x000d;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a.a(int):void");
        }

        void a(e[] eVarArr) {
            int length = eVarArr.length;
            if (this.f == null || this.f.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = eVarArr[i].a(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.b = this.c ? StaggeredGridLayoutManager.this.b.d() : StaggeredGridLayoutManager.this.b.c();
        }
    }

    static class c {
        int[] a;
        List<a> b;

        static class a implements Parcelable {
            public static final Creator<a> CREATOR = new Creator<a>() {
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* renamed from: a */
                public a[] newArray(int i) {
                    return new a[i];
                }
            };
            int a;
            int b;
            int[] c;
            boolean d;

            a() {
            }

            a(Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            int a(int i) {
                return this.c == null ? 0 : this.c[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("FullSpanItem{mPosition=");
                stringBuilder.append(this.a);
                stringBuilder.append(", mGapDir=");
                stringBuilder.append(this.b);
                stringBuilder.append(", mHasUnwantedGapAfter=");
                stringBuilder.append(this.d);
                stringBuilder.append(", mGapPerSpan=");
                stringBuilder.append(Arrays.toString(this.c));
                stringBuilder.append('}');
                return stringBuilder.toString();
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.c.length);
                parcel.writeIntArray(this.c);
            }
        }

        c() {
        }

        private void c(int i, int i2) {
            if (this.b != null) {
                int i3 = i + i2;
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.b.get(size);
                    if (aVar.a >= i) {
                        if (aVar.a < i3) {
                            this.b.remove(size);
                        } else {
                            aVar.a -= i2;
                        }
                    }
                }
            }
        }

        private void d(int i, int i2) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.b.get(size);
                    if (aVar.a >= i) {
                        aVar.a += i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.b == null) {
                return -1;
            }
            a f = f(i);
            if (f != null) {
                this.b.remove(f);
            }
            int size = this.b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((a) this.b.get(i2)).a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            a aVar = (a) this.b.get(i2);
            this.b.remove(i2);
            return aVar.a;
        }

        int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (((a) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        public a a(int i, int i2, int i3, boolean z) {
            if (this.b == null) {
                return null;
            }
            int size = this.b.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = (a) this.b.get(i4);
                if (aVar.a >= i2) {
                    return null;
                }
                if (aVar.a >= i && (i3 == 0 || aVar.b == i3 || (z && aVar.d))) {
                    return aVar;
                }
            }
            return null;
        }

        void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        void a(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                int i3 = i + i2;
                e(i3);
                System.arraycopy(this.a, i3, this.a, i, (this.a.length - i) - i2);
                Arrays.fill(this.a, this.a.length - i2, this.a.length, -1);
                c(i, i2);
            }
        }

        void a(int i, e eVar) {
            e(i);
            this.a[i] = eVar.e;
        }

        public void a(a aVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = (a) this.b.get(i);
                if (aVar2.a == aVar.a) {
                    this.b.remove(i);
                }
                if (aVar2.a >= aVar.a) {
                    this.b.add(i, aVar);
                    return;
                }
            }
            this.b.add(aVar);
        }

        int b(int i) {
            if (this.a == null || i >= this.a.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                Arrays.fill(this.a, i, this.a.length, -1);
                return this.a.length;
            }
            g++;
            Arrays.fill(this.a, i, g, -1);
            return g;
        }

        void b(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                int i3 = i + i2;
                e(i3);
                System.arraycopy(this.a, i, this.a, i3, (this.a.length - i) - i2);
                Arrays.fill(this.a, i, i3, -1);
                d(i, i2);
            }
        }

        int c(int i) {
            return (this.a == null || i >= this.a.length) ? -1 : this.a[i];
        }

        int d(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            if (this.a == null) {
                this.a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.a, -1);
                return;
            }
            if (i >= this.a.length) {
                Object obj = this.a;
                this.a = new int[d(i)];
                System.arraycopy(obj, 0, this.a, 0, obj.length);
                Arrays.fill(this.a, obj.length, this.a.length, -1);
            }
        }

        public a f(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
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
        int c;
        int[] d;
        int e;
        int[] f;
        List<a> g;
        boolean h;
        boolean i;
        boolean j;

        d(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            boolean z = false;
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            this.j = z;
            this.g = parcel.readArrayList(a.class.getClassLoader());
        }

        public d(d dVar) {
            this.c = dVar.c;
            this.a = dVar.a;
            this.b = dVar.b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.h = dVar.h;
            this.i = dVar.i;
            this.j = dVar.j;
            this.g = dVar.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeList(this.g);
        }
    }

    class e {
        ArrayList<View> a = new ArrayList();
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        e(int i) {
            this.e = i;
        }

        int a(int i) {
            if (this.b != Integer.MIN_VALUE) {
                return this.b;
            }
            if (this.a.size() == 0) {
                return i;
            }
            a();
            return this.b;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c = StaggeredGridLayoutManager.this.b.c();
            int d = StaggeredGridLayoutManager.this.b.d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.a.get(i);
                int a = StaggeredGridLayoutManager.this.b.a(view);
                int b = StaggeredGridLayoutManager.this.b.b(view);
                Object obj = null;
                Object obj2 = (z3 ? a > d : a >= d) ? null : 1;
                if (z3 ? b < c : b <= c) {
                    obj = 1;
                }
                if (!(obj2 == null || obj == null)) {
                    if (z && z2) {
                        if (a >= c && b <= d) {
                        }
                    } else if (!z2 && a >= c && b <= d) {
                    }
                    return StaggeredGridLayoutManager.this.d(view);
                }
                i += i3;
            }
            return -1;
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                i2 = this.a.size() - 1;
                while (i2 >= 0) {
                    View view2 = (View) this.a.get(i2);
                    if (StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) >= i) {
                        break;
                    } else if (StaggeredGridLayoutManager.this.d || StaggeredGridLayoutManager.this.d(view2) > i) {
                        if (!view2.hasFocusable()) {
                            break;
                        }
                        i2--;
                        view = view2;
                    } else {
                        return view;
                    }
                }
            }
            i2 = this.a.size();
            int i3 = 0;
            while (i3 < i2) {
                View view3 = (View) this.a.get(i3);
                if (StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) <= i) {
                    break;
                } else if (StaggeredGridLayoutManager.this.d || StaggeredGridLayoutManager.this.d(view3) < i) {
                    if (!view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                } else {
                    return view;
                }
            }
            return view;
        }

        void a() {
            View view = (View) this.a.get(0);
            b c = c(view);
            this.b = StaggeredGridLayoutManager.this.b.a(view);
            if (c.b) {
                a f = StaggeredGridLayoutManager.this.h.f(c.f());
                if (f != null && f.b == -1) {
                    this.b -= f.a(this.e);
                }
            }
        }

        void a(View view) {
            b c = c(view);
            c.a = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d += StaggeredGridLayoutManager.this.b.e(view);
            }
        }

        void a(boolean z, int i) {
            int b = z ? b(Integer.MIN_VALUE) : a(Integer.MIN_VALUE);
            e();
            if (b != Integer.MIN_VALUE) {
                if ((!z || b >= StaggeredGridLayoutManager.this.b.d()) && (z || b <= StaggeredGridLayoutManager.this.b.c())) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.c = b;
                    this.b = b;
                }
            }
        }

        int b() {
            if (this.b != Integer.MIN_VALUE) {
                return this.b;
            }
            a();
            return this.b;
        }

        int b(int i) {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        void b(View view) {
            b c = c(view);
            c.a = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d += StaggeredGridLayoutManager.this.b.e(view);
            }
        }

        b c(View view) {
            return (b) view.getLayoutParams();
        }

        void c() {
            View view = (View) this.a.get(this.a.size() - 1);
            b c = c(view);
            this.c = StaggeredGridLayoutManager.this.b.b(view);
            if (c.b) {
                a f = StaggeredGridLayoutManager.this.h.f(c.f());
                if (f != null && f.b == 1) {
                    this.c += f.a(this.e);
                }
            }
        }

        void c(int i) {
            this.b = i;
            this.c = i;
        }

        int d() {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            c();
            return this.c;
        }

        void d(int i) {
            if (this.b != Integer.MIN_VALUE) {
                this.b += i;
            }
            if (this.c != Integer.MIN_VALUE) {
                this.c += i;
            }
        }

        void e() {
            this.a.clear();
            f();
            this.d = 0;
        }

        void f() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        void g() {
            int size = this.a.size();
            View view = (View) this.a.remove(size - 1);
            b c = c(view);
            c.a = null;
            if (c.d() || c.e()) {
                this.d -= StaggeredGridLayoutManager.this.b.e(view);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        void h() {
            View view = (View) this.a.remove(0);
            b c = c(view);
            c.a = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d -= StaggeredGridLayoutManager.this.b.e(view);
            }
            this.b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.d;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x001c in {2, 4, 5} preds:[]
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
        public int j() {
            /*
            r3 = this;
            r0 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r0 = r0.d;
            r1 = 1;
            if (r0 == 0) goto L_0x0014;
        L_0x0007:
            r0 = r3.a;
            r0 = r0.size();
            r0 = r0 - r1;
            r2 = -1;
        L_0x000f:
            r3 = r3.a(r0, r2, r1);
            return r3;
        L_0x0014:
            r0 = 0;
            r2 = r3.a;
            r2 = r2.size();
            goto L_0x000f;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.e.j():int");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x001c in {2, 4, 5} preds:[]
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
        public int k() {
            /*
            r3 = this;
            r0 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r0 = r0.d;
            r1 = 1;
            if (r0 == 0) goto L_0x0013;
        L_0x0007:
            r0 = 0;
            r2 = r3.a;
            r2 = r2.size();
        L_0x000e:
            r3 = r3.a(r0, r2, r1);
            return r3;
        L_0x0013:
            r0 = r3.a;
            r0 = r0.size();
            r0 = r0 - r1;
            r2 = -1;
            goto L_0x000e;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.e.k():int");
        }
    }

    public static class b extends j {
        e a;
        boolean b;

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean a() {
            return this.b;
        }

        public final int b() {
            return this.a == null ? -1 : this.a.e;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.j = i2;
        a(i);
        this.l = new am();
        M();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        android.support.v7.widget.at.i.b a = i.a(context, attributeSet, i, i2);
        b(a.a);
        a(a.b);
        a(a.c);
        this.l = new am();
        M();
    }

    private void M() {
        this.b = as.a(this, this.j);
        this.c = as.a(this, 1 - this.j);
    }

    private void N() {
        boolean z = (this.j == 1 || !j()) ? this.d : this.d ^ true;
        this.e = z;
    }

    private void O() {
        if (this.c.h() != 1073741824) {
            int i;
            int v = v();
            int i2 = 0;
            float f = 0.0f;
            for (i = 0; i < v; i++) {
                View h = h(i);
                float e = (float) this.c.e(h);
                if (e >= f) {
                    if (((b) h.getLayoutParams()).a()) {
                        e = (e * 1.0f) / ((float) this.i);
                    }
                    f = Math.max(f, e);
                }
            }
            i = this.k;
            int round = Math.round(f * ((float) this.i));
            if (this.c.h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.c.f());
            }
            e(round);
            if (this.k != i) {
                while (i2 < v) {
                    View h2 = h(i2);
                    b bVar = (b) h2.getLayoutParams();
                    if (!bVar.b) {
                        int i3;
                        int i4;
                        if (j() && this.j == 1) {
                            i3 = (-((this.i - 1) - bVar.a.e)) * this.k;
                            i4 = (-((this.i - 1) - bVar.a.e)) * i;
                        } else {
                            i3 = bVar.a.e * this.k;
                            i4 = bVar.a.e * i;
                            if (this.j != 1) {
                                h2.offsetTopAndBottom(i3 - i4);
                            }
                        }
                        h2.offsetLeftAndRight(i3 - i4);
                    }
                    i2++;
                }
            }
        }
    }

    private int a(p pVar, am amVar, u uVar) {
        int c;
        boolean z;
        p pVar2 = pVar;
        am amVar2 = amVar;
        boolean z2 = false;
        this.m.set(0, this.i, true);
        int i = this.l.i ? amVar2.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : amVar2.e == 1 ? amVar2.g + amVar2.b : amVar2.f - amVar2.b;
        int i2 = i;
        a(amVar2.e, i2);
        int d = this.e ? this.b.d() : this.b.c();
        boolean z3 = false;
        while (amVar.a(uVar) && (this.l.i || !this.m.isEmpty())) {
            e a;
            int e;
            int i3;
            int i4;
            int e2;
            StaggeredGridLayoutManager staggeredGridLayoutManager;
            View view;
            int i5;
            View a2 = amVar2.a(pVar2);
            b bVar = (b) a2.getLayoutParams();
            i = bVar.f();
            c = this.h.c(i);
            z = c == -1 ? true : z2;
            if (z) {
                a = bVar.b ? this.a[z2] : a(amVar2);
                this.h.a(i, a);
            } else {
                a = this.a[c];
            }
            e eVar = a;
            bVar.a = eVar;
            if (amVar2.e == 1) {
                b(a2);
            } else {
                b(a2, (int) z2);
            }
            a(a2, bVar, z2);
            a m;
            if (amVar2.e == 1) {
                c = bVar.b ? q(d) : eVar.b(d);
                e = this.b.e(a2) + c;
                if (z && bVar.b) {
                    m = m(c);
                    m.b = -1;
                    m.a = i;
                    this.h.a(m);
                }
                i3 = e;
                e = c;
            } else {
                c = bVar.b ? p(d) : eVar.a(d);
                e = c - this.b.e(a2);
                if (z && bVar.b) {
                    m = n(c);
                    m.b = 1;
                    m.a = i;
                    this.h.a(m);
                }
                i3 = c;
            }
            if (bVar.b && amVar2.d == -1) {
                if (!z) {
                    if (((amVar2.e == 1 ? m() : n()) ^ 1) != 0) {
                        a f = this.h.f(i);
                        if (f != null) {
                            f.d = true;
                        }
                    }
                }
                this.E = true;
            }
            a(a2, bVar, amVar2);
            if (j() && this.j == 1) {
                i = bVar.b ? this.c.d() : this.c.d() - (((this.i - 1) - eVar.e) * this.k);
                i4 = i;
                e2 = i - this.c.e(a2);
            } else {
                i = bVar.b ? this.c.c() : (eVar.e * this.k) + this.c.c();
                e2 = i;
                i4 = this.c.e(a2) + i;
            }
            if (this.j == 1) {
                staggeredGridLayoutManager = this;
                view = a2;
                i5 = e2;
                e2 = e;
                e = i4;
            } else {
                staggeredGridLayoutManager = this;
                view = a2;
                i5 = e;
                e = i3;
                i3 = i4;
            }
            staggeredGridLayoutManager.a(view, i5, e2, e, i3);
            if (bVar.b) {
                a(this.l.e, i2);
            } else {
                a(eVar, this.l.e, i2);
            }
            a(pVar2, this.l);
            if (this.l.h && a2.hasFocusable()) {
                if (bVar.b) {
                    this.m.clear();
                } else {
                    z = false;
                    this.m.set(eVar.e, false);
                    z2 = z;
                    z3 = true;
                }
            }
            z = false;
            z2 = z;
            z3 = true;
        }
        z = z2;
        if (!z3) {
            a(pVar2, this.l);
        }
        c = this.l.e == -1 ? this.b.c() - p(this.b.c()) : q(this.b.d()) - this.b.d();
        return c > 0 ? Math.min(amVar2.b, c) : z;
    }

    private e a(am amVar) {
        int i;
        int i2;
        int i3 = -1;
        if (s(amVar.e)) {
            i = this.i - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.i;
            i2 = 1;
        }
        e eVar = null;
        int i4;
        int c;
        e eVar2;
        int b;
        if (amVar.e == 1) {
            i4 = Integer.MAX_VALUE;
            c = this.b.c();
            while (i != i3) {
                eVar2 = this.a[i];
                b = eVar2.b(c);
                if (b < i4) {
                    eVar = eVar2;
                    i4 = b;
                }
                i += i2;
            }
            return eVar;
        }
        i4 = Integer.MIN_VALUE;
        c = this.b.d();
        while (i != i3) {
            eVar2 = this.a[i];
            b = eVar2.a(c);
            if (b > i4) {
                eVar = eVar2;
                i4 = b;
            }
            i += i2;
        }
        return eVar;
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < this.i; i3++) {
            if (!this.a[i3].a.isEmpty()) {
                a(this.a[i3], i, i2);
            }
        }
    }

    private void a(a aVar) {
        boolean z;
        if (this.A.c > 0) {
            if (this.A.c == this.i) {
                for (int i = 0; i < this.i; i++) {
                    this.a[i].e();
                    int i2 = this.A.d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 += this.A.i ? this.b.d() : this.b.c();
                    }
                    this.a[i].c(i2);
                }
            } else {
                this.A.a();
                this.A.a = this.A.b;
            }
        }
        this.z = this.A.j;
        a(this.A.h);
        N();
        if (this.A.a != -1) {
            this.f = this.A.a;
            z = this.A.i;
        } else {
            z = this.e;
        }
        aVar.c = z;
        if (this.A.e > 1) {
            this.h.a = this.A.f;
            this.h.b = this.A.g;
        }
    }

    private void a(e eVar, int i, int i2) {
        int i3 = eVar.i();
        if (i == -1) {
            if (eVar.b() + i3 > i2) {
                return;
            }
        } else if (eVar.d() - i3 < i2) {
            return;
        }
        this.m.set(eVar.e, false);
    }

    private void a(p pVar, int i) {
        while (v() > 0) {
            int i2 = 0;
            View h = h(0);
            if (this.b.b(h) > i || this.b.c(h) > i) {
                break;
            }
            b bVar = (b) h.getLayoutParams();
            if (bVar.b) {
                int i3 = 0;
                while (i3 < this.i) {
                    if (this.a[i3].a.size() != 1) {
                        i3++;
                    } else {
                        return;
                    }
                }
                while (i2 < this.i) {
                    this.a[i2].h();
                    i2++;
                }
            } else if (bVar.a.a.size() != 1) {
                bVar.a.h();
            } else {
                return;
            }
            a(h, pVar);
        }
    }

    /* JADX WARNING: Missing block: B:8:0x0010, code:
            if (r4.e == -1) goto L_0x0012;
     */
    private void a(android.support.v7.widget.at.p r3, android.support.v7.widget.am r4) {
        /*
        r2 = this;
        r0 = r4.a;
        if (r0 == 0) goto L_0x004f;
    L_0x0004:
        r0 = r4.i;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r4.b;
        r1 = -1;
        if (r0 != 0) goto L_0x001e;
    L_0x000e:
        r0 = r4.e;
        if (r0 != r1) goto L_0x0018;
    L_0x0012:
        r4 = r4.g;
    L_0x0014:
        r2.b(r3, r4);
        return;
    L_0x0018:
        r4 = r4.f;
    L_0x001a:
        r2.a(r3, r4);
        return;
    L_0x001e:
        r0 = r4.e;
        if (r0 != r1) goto L_0x0039;
    L_0x0022:
        r0 = r4.f;
        r1 = r4.f;
        r1 = r2.o(r1);
        r0 = r0 - r1;
        if (r0 >= 0) goto L_0x002e;
    L_0x002d:
        goto L_0x0012;
    L_0x002e:
        r1 = r4.g;
        r4 = r4.b;
        r4 = java.lang.Math.min(r0, r4);
        r4 = r1 - r4;
        goto L_0x0014;
    L_0x0039:
        r0 = r4.g;
        r0 = r2.r(r0);
        r1 = r4.g;
        r0 = r0 - r1;
        if (r0 >= 0) goto L_0x0045;
    L_0x0044:
        goto L_0x0018;
    L_0x0045:
        r1 = r4.f;
        r4 = r4.b;
        r4 = java.lang.Math.min(r0, r4);
        r4 = r4 + r1;
        goto L_0x001a;
    L_0x004f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a(android.support.v7.widget.at$p, android.support.v7.widget.am):void");
    }

    /* JADX WARNING: Missing block: B:84:0x0154, code:
            if (g() != false) goto L_0x0158;
     */
    private void a(android.support.v7.widget.at.p r9, android.support.v7.widget.at.u r10, boolean r11) {
        /*
        r8 = this;
        r0 = r8.D;
        r1 = r8.A;
        r2 = -1;
        if (r1 != 0) goto L_0x000b;
    L_0x0007:
        r1 = r8.f;
        if (r1 == r2) goto L_0x0018;
    L_0x000b:
        r1 = r10.e();
        if (r1 != 0) goto L_0x0018;
    L_0x0011:
        r8.c(r9);
        r0.a();
        return;
    L_0x0018:
        r1 = r0.e;
        r3 = 0;
        r4 = 1;
        if (r1 == 0) goto L_0x0029;
    L_0x001e:
        r1 = r8.f;
        if (r1 != r2) goto L_0x0029;
    L_0x0022:
        r1 = r8.A;
        if (r1 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r1 = r3;
        goto L_0x002a;
    L_0x0029:
        r1 = r4;
    L_0x002a:
        if (r1 == 0) goto L_0x0043;
    L_0x002c:
        r0.a();
        r5 = r8.A;
        if (r5 == 0) goto L_0x0037;
    L_0x0033:
        r8.a(r0);
        goto L_0x003e;
    L_0x0037:
        r8.N();
        r5 = r8.e;
        r0.c = r5;
    L_0x003e:
        r8.a(r10, r0);
        r0.e = r4;
    L_0x0043:
        r5 = r8.A;
        if (r5 != 0) goto L_0x0060;
    L_0x0047:
        r5 = r8.f;
        if (r5 != r2) goto L_0x0060;
    L_0x004b:
        r5 = r0.c;
        r6 = r8.o;
        if (r5 != r6) goto L_0x0059;
    L_0x0051:
        r5 = r8.j();
        r6 = r8.z;
        if (r5 == r6) goto L_0x0060;
    L_0x0059:
        r5 = r8.h;
        r5.a();
        r0.d = r4;
    L_0x0060:
        r5 = r8.v();
        if (r5 <= 0) goto L_0x00cd;
    L_0x0066:
        r5 = r8.A;
        if (r5 == 0) goto L_0x0070;
    L_0x006a:
        r5 = r8.A;
        r5 = r5.c;
        if (r5 >= r4) goto L_0x00cd;
    L_0x0070:
        r5 = r0.d;
        if (r5 == 0) goto L_0x0092;
    L_0x0074:
        r1 = r3;
    L_0x0075:
        r5 = r8.i;
        if (r1 >= r5) goto L_0x00cd;
    L_0x0079:
        r5 = r8.a;
        r5 = r5[r1];
        r5.e();
        r5 = r0.b;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r5 == r6) goto L_0x008f;
    L_0x0086:
        r5 = r8.a;
        r5 = r5[r1];
        r6 = r0.b;
        r5.c(r6);
    L_0x008f:
        r1 = r1 + 1;
        goto L_0x0075;
    L_0x0092:
        if (r1 != 0) goto L_0x00b3;
    L_0x0094:
        r1 = r8.D;
        r1 = r1.f;
        if (r1 != 0) goto L_0x009b;
    L_0x009a:
        goto L_0x00b3;
    L_0x009b:
        r1 = r3;
    L_0x009c:
        r5 = r8.i;
        if (r1 >= r5) goto L_0x00cd;
    L_0x00a0:
        r5 = r8.a;
        r5 = r5[r1];
        r5.e();
        r6 = r8.D;
        r6 = r6.f;
        r6 = r6[r1];
        r5.c(r6);
        r1 = r1 + 1;
        goto L_0x009c;
    L_0x00b3:
        r1 = r3;
    L_0x00b4:
        r5 = r8.i;
        if (r1 >= r5) goto L_0x00c6;
    L_0x00b8:
        r5 = r8.a;
        r5 = r5[r1];
        r6 = r8.e;
        r7 = r0.b;
        r5.a(r6, r7);
        r1 = r1 + 1;
        goto L_0x00b4;
    L_0x00c6:
        r1 = r8.D;
        r5 = r8.a;
        r1.a(r5);
    L_0x00cd:
        r8.a(r9);
        r1 = r8.l;
        r1.a = r3;
        r8.E = r3;
        r1 = r8.c;
        r1 = r1.f();
        r8.e(r1);
        r1 = r0.a;
        r8.b(r1, r10);
        r1 = r0.c;
        if (r1 == 0) goto L_0x0104;
    L_0x00e8:
        r8.l(r2);
        r1 = r8.l;
        r8.a(r9, r1, r10);
        r8.l(r4);
    L_0x00f3:
        r1 = r8.l;
        r2 = r0.a;
        r5 = r8.l;
        r5 = r5.d;
        r2 = r2 + r5;
        r1.c = r2;
        r1 = r8.l;
        r8.a(r9, r1, r10);
        goto L_0x0110;
    L_0x0104:
        r8.l(r4);
        r1 = r8.l;
        r8.a(r9, r1, r10);
        r8.l(r2);
        goto L_0x00f3;
    L_0x0110:
        r8.O();
        r1 = r8.v();
        if (r1 <= 0) goto L_0x012a;
    L_0x0119:
        r1 = r8.e;
        if (r1 == 0) goto L_0x0124;
    L_0x011d:
        r8.b(r9, r10, r4);
        r8.c(r9, r10, r3);
        goto L_0x012a;
    L_0x0124:
        r8.c(r9, r10, r4);
        r8.b(r9, r10, r3);
    L_0x012a:
        if (r11 == 0) goto L_0x0157;
    L_0x012c:
        r11 = r10.a();
        if (r11 != 0) goto L_0x0157;
    L_0x0132:
        r11 = r8.n;
        if (r11 == 0) goto L_0x0148;
    L_0x0136:
        r11 = r8.v();
        if (r11 <= 0) goto L_0x0148;
    L_0x013c:
        r11 = r8.E;
        if (r11 != 0) goto L_0x0146;
    L_0x0140:
        r11 = r8.h();
        if (r11 == 0) goto L_0x0148;
    L_0x0146:
        r11 = r4;
        goto L_0x0149;
    L_0x0148:
        r11 = r3;
    L_0x0149:
        if (r11 == 0) goto L_0x0157;
    L_0x014b:
        r11 = r8.H;
        r8.a(r11);
        r11 = r8.g();
        if (r11 == 0) goto L_0x0157;
    L_0x0156:
        goto L_0x0158;
    L_0x0157:
        r4 = r3;
    L_0x0158:
        r11 = r10.a();
        if (r11 == 0) goto L_0x0163;
    L_0x015e:
        r11 = r8.D;
        r11.a();
    L_0x0163:
        r11 = r0.c;
        r8.o = r11;
        r11 = r8.j();
        r8.z = r11;
        if (r4 == 0) goto L_0x0177;
    L_0x016f:
        r11 = r8.D;
        r11.a();
        r8.a(r9, r10, r3);
    L_0x0177:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a(android.support.v7.widget.at$p, android.support.v7.widget.at$u, boolean):void");
    }

    private void a(View view, int i, int i2, boolean z) {
        b(view, this.C);
        b bVar = (b) view.getLayoutParams();
        i = b(i, bVar.leftMargin + this.C.left, bVar.rightMargin + this.C.right);
        i2 = b(i2, bVar.topMargin + this.C.top, bVar.bottomMargin + this.C.bottom);
        if (z ? a(view, i, i2, (j) bVar) : b(view, i, i2, (j) bVar)) {
            view.measure(i, i2);
        }
    }

    private void a(View view, b bVar, am amVar) {
        if (amVar.e == 1) {
            if (bVar.b) {
                p(view);
            } else {
                bVar.a.b(view);
            }
        } else if (bVar.b) {
            q(view);
        } else {
            bVar.a.a(view);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:14:0x0079 in {4, 5, 7, 9, 12, 13} preds:[]
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
    private void a(android.view.View r7, android.support.v7.widget.StaggeredGridLayoutManager.b r8, boolean r9) {
        /*
        r6 = this;
        r0 = r8.b;
        r1 = 1;
        if (r0 == 0) goto L_0x0043;
    L_0x0005:
        r0 = r6.j;
        if (r0 != r1) goto L_0x0026;
    L_0x0009:
        r0 = r6.B;
    L_0x000b:
        r2 = r6.z();
        r3 = r6.x();
        r4 = r6.B();
        r5 = r6.D();
        r4 = r4 + r5;
        r8 = r8.height;
        r8 = android.support.v7.widget.at.i.a(r2, r3, r4, r8, r1);
    L_0x0022:
        r6.a(r7, r0, r8, r9);
        return;
    L_0x0026:
        r0 = r6.y();
        r2 = r6.w();
        r3 = r6.A();
        r4 = r6.C();
        r3 = r3 + r4;
        r8 = r8.width;
        r8 = android.support.v7.widget.at.i.a(r0, r2, r3, r8, r1);
        r0 = r6.B;
        r6.a(r7, r8, r0, r9);
        return;
    L_0x0043:
        r0 = r6.j;
        r2 = 0;
        if (r0 != r1) goto L_0x0055;
    L_0x0048:
        r0 = r6.k;
        r3 = r6.w();
        r4 = r8.width;
        r0 = android.support.v7.widget.at.i.a(r0, r3, r2, r4, r2);
        goto L_0x000b;
    L_0x0055:
        r0 = r6.y();
        r3 = r6.w();
        r4 = r6.A();
        r5 = r6.C();
        r4 = r4 + r5;
        r5 = r8.width;
        r0 = android.support.v7.widget.at.i.a(r0, r3, r4, r5, r1);
        r1 = r6.k;
        r3 = r6.x();
        r8 = r8.height;
        r8 = android.support.v7.widget.at.i.a(r1, r3, r2, r8, r2);
        goto L_0x0022;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a(android.view.View, android.support.v7.widget.StaggeredGridLayoutManager$b, boolean):void");
    }

    private boolean a(e eVar) {
        if (this.e) {
            if (eVar.d() < this.b.d()) {
                return eVar.c((View) eVar.a.get(eVar.a.size() - 1)).b ^ 1;
            }
        } else if (eVar.b() > this.b.c()) {
            return eVar.c((View) eVar.a.get(0)).b ^ 1;
        }
        return false;
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int b(u uVar) {
        if (v() == 0) {
            return 0;
        }
        return ax.a(uVar, this.b, b(this.F ^ 1), c(this.F ^ 1), this, this.F, this.e);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    private void b(int r5, android.support.v7.widget.at.u r6) {
        /*
        r4 = this;
        r0 = r4.l;
        r1 = 0;
        r0.b = r1;
        r0 = r4.l;
        r0.c = r5;
        r0 = r4.s();
        r2 = 1;
        if (r0 == 0) goto L_0x0031;
    L_0x0010:
        r6 = r6.c();
        r0 = -1;
        if (r6 == r0) goto L_0x0031;
    L_0x0017:
        r0 = r4.e;
        if (r6 >= r5) goto L_0x001d;
    L_0x001b:
        r5 = r2;
        goto L_0x001e;
    L_0x001d:
        r5 = r1;
    L_0x001e:
        if (r0 != r5) goto L_0x0029;
    L_0x0020:
        r5 = r4.b;
        r5 = r5.f();
        r6 = r5;
        r5 = r1;
        goto L_0x0033;
    L_0x0029:
        r5 = r4.b;
        r5 = r5.f();
        r6 = r1;
        goto L_0x0033;
    L_0x0031:
        r5 = r1;
        r6 = r5;
    L_0x0033:
        r0 = r4.r();
        if (r0 == 0) goto L_0x0050;
    L_0x0039:
        r0 = r4.l;
        r3 = r4.b;
        r3 = r3.c();
        r3 = r3 - r5;
        r0.f = r3;
        r5 = r4.l;
        r0 = r4.b;
        r0 = r0.d();
        r0 = r0 + r6;
        r5.g = r0;
        goto L_0x0060;
    L_0x0050:
        r0 = r4.l;
        r3 = r4.b;
        r3 = r3.e();
        r3 = r3 + r6;
        r0.g = r3;
        r6 = r4.l;
        r5 = -r5;
        r6.f = r5;
    L_0x0060:
        r5 = r4.l;
        r5.h = r1;
        r5 = r4.l;
        r5.a = r2;
        r5 = r4.l;
        r6 = r4.b;
        r6 = r6.h();
        if (r6 != 0) goto L_0x007b;
    L_0x0072:
        r4 = r4.b;
        r4 = r4.e();
        if (r4 != 0) goto L_0x007b;
    L_0x007a:
        r1 = r2;
    L_0x007b:
        r5.i = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.b(int, android.support.v7.widget.at$u):void");
    }

    private void b(p pVar, int i) {
        for (int v = v() - 1; v >= 0; v--) {
            View h = h(v);
            if (this.b.a(h) < i || this.b.d(h) < i) {
                break;
            }
            b bVar = (b) h.getLayoutParams();
            if (bVar.b) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < this.i) {
                    if (this.a[i3].a.size() != 1) {
                        i3++;
                    } else {
                        return;
                    }
                }
                while (i2 < this.i) {
                    this.a[i2].g();
                    i2++;
                }
            } else if (bVar.a.a.size() != 1) {
                bVar.a.g();
            } else {
                return;
            }
            a(h, pVar);
        }
    }

    private void b(p pVar, u uVar, boolean z) {
        int q = q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            int d = this.b.d() - q;
            if (d > 0) {
                d -= -c(-d, pVar, uVar);
                if (z && d > 0) {
                    this.b.a(d);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A:{RETURN} */
    private void c(int r6, int r7, int r8) {
        /*
        r5 = this;
        r0 = r5.e;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r5.K();
        goto L_0x000d;
    L_0x0009:
        r0 = r5.L();
    L_0x000d:
        r1 = 8;
        if (r8 != r1) goto L_0x001b;
    L_0x0011:
        if (r6 >= r7) goto L_0x0016;
    L_0x0013:
        r2 = r7 + 1;
        goto L_0x001d;
    L_0x0016:
        r2 = r6 + 1;
        r3 = r2;
        r2 = r7;
        goto L_0x001f;
    L_0x001b:
        r2 = r6 + r7;
    L_0x001d:
        r3 = r2;
        r2 = r6;
    L_0x001f:
        r4 = r5.h;
        r4.b(r2);
        if (r8 == r1) goto L_0x0036;
    L_0x0026:
        switch(r8) {
            case 1: goto L_0x0030;
            case 2: goto L_0x002a;
            default: goto L_0x0029;
        };
    L_0x0029:
        goto L_0x0041;
    L_0x002a:
        r8 = r5.h;
        r8.a(r6, r7);
        goto L_0x0041;
    L_0x0030:
        r8 = r5.h;
        r8.b(r6, r7);
        goto L_0x0041;
    L_0x0036:
        r8 = r5.h;
        r1 = 1;
        r8.a(r6, r1);
        r6 = r5.h;
        r6.b(r7, r1);
    L_0x0041:
        if (r3 > r0) goto L_0x0044;
    L_0x0043:
        return;
    L_0x0044:
        r6 = r5.e;
        if (r6 == 0) goto L_0x004d;
    L_0x0048:
        r6 = r5.L();
        goto L_0x0051;
    L_0x004d:
        r6 = r5.K();
    L_0x0051:
        if (r2 > r6) goto L_0x0056;
    L_0x0053:
        r5.o();
    L_0x0056:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    private void c(p pVar, u uVar, boolean z) {
        int p = p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.b.c();
            if (p > 0) {
                p -= c(p, pVar, uVar);
                if (z && p > 0) {
                    this.b.a(-p);
                }
            }
        }
    }

    private boolean c(u uVar, a aVar) {
        aVar.a = this.o ? v(uVar.e()) : u(uVar.e());
        aVar.b = Integer.MIN_VALUE;
        return true;
    }

    private int i(u uVar) {
        if (v() == 0) {
            return 0;
        }
        return ax.a(uVar, this.b, b(this.F ^ 1), c(this.F ^ 1), this, this.F);
    }

    private int j(u uVar) {
        if (v() == 0) {
            return 0;
        }
        return ax.b(uVar, this.b, b(this.F ^ 1), c(this.F ^ 1), this, this.F);
    }

    private void l(int i) {
        this.l.e = i;
        am amVar = this.l;
        int i2 = 1;
        if (this.e != (i == -1)) {
            i2 = -1;
        }
        amVar.d = i2;
    }

    private a m(int i) {
        a aVar = new a();
        aVar.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            aVar.c[i2] = i - this.a[i2].b(i);
        }
        return aVar;
    }

    private a n(int i) {
        a aVar = new a();
        aVar.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            aVar.c[i2] = this.a[i2].a(i) - i;
        }
        return aVar;
    }

    private int o(int i) {
        int a = this.a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a2 = this.a[i2].a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int p(int i) {
        int a = this.a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a2 = this.a[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void p(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.a[i].b(view);
        }
    }

    private int q(int i) {
        int b = this.a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b2 = this.a[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void q(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.a[i].a(view);
        }
    }

    private int r(int i) {
        int b = this.a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b2 = this.a[i2].b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean s(int i) {
        boolean z = false;
        if (this.j == 0) {
            if ((i == -1) != this.e) {
                z = true;
            }
            return z;
        }
        if (((i == -1) == this.e) == j()) {
            z = true;
        }
        return z;
    }

    private int t(int i) {
        int i2 = -1;
        if (v() == 0) {
            if (this.e) {
                i2 = 1;
            }
            return i2;
        }
        return (i < L()) != this.e ? -1 : 1;
    }

    private int u(int i) {
        int v = v();
        for (int i2 = 0; i2 < v; i2++) {
            int d = d(h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int v(int i) {
        for (int v = v() - 1; v >= 0; v--) {
            int d = d(h(v));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int w(int i) {
        int i2 = Integer.MIN_VALUE;
        if (i == 17) {
            return this.j == 0 ? -1 : Integer.MIN_VALUE;
        } else {
            if (i == 33) {
                return this.j == 1 ? -1 : Integer.MIN_VALUE;
            } else {
                if (i == 66) {
                    if (this.j == 0) {
                        i2 = 1;
                    }
                    return i2;
                } else if (i != 130) {
                    switch (i) {
                        case 1:
                            return (this.j != 1 && j()) ? 1 : -1;
                        case 2:
                            return (this.j != 1 && j()) ? -1 : 1;
                        default:
                            return Integer.MIN_VALUE;
                    }
                } else {
                    if (this.j == 1) {
                        i2 = 1;
                    }
                    return i2;
                }
            }
        }
    }

    int K() {
        int v = v();
        return v == 0 ? 0 : d(h(v - 1));
    }

    int L() {
        return v() == 0 ? 0 : d(h(0));
    }

    public int a(int i, p pVar, u uVar) {
        return c(i, pVar, uVar);
    }

    public int a(p pVar, u uVar) {
        return this.j == 0 ? this.i : super.a(pVar, uVar);
    }

    public j a() {
        return this.j == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    public j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public j a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new b((MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public View a(View view, int i, p pVar, u uVar) {
        if (v() == 0) {
            return null;
        }
        view = e(view);
        if (view == null) {
            return null;
        }
        N();
        i = w(i);
        if (i == Integer.MIN_VALUE) {
            return null;
        }
        View a;
        b bVar = (b) view.getLayoutParams();
        boolean z = bVar.b;
        e eVar = bVar.a;
        int K = i == 1 ? K() : L();
        b(K, uVar);
        l(i);
        this.l.c = this.l.d + K;
        this.l.b = (int) (((float) this.b.f()) * 0.33333334f);
        this.l.h = true;
        int i2 = 0;
        this.l.a = false;
        a(pVar, this.l, uVar);
        this.o = this.e;
        if (!z) {
            View a2 = eVar.a(K, i);
            if (!(a2 == null || a2 == view)) {
                return a2;
            }
        }
        int i3;
        if (s(i)) {
            for (i3 = this.i - 1; i3 >= 0; i3--) {
                a = this.a[i3].a(K, i);
                if (a != null && a != view) {
                    return a;
                }
            }
        } else {
            for (i3 = 0; i3 < this.i; i3++) {
                a = this.a[i3].a(K, i);
                if (a != null && a != view) {
                    return a;
                }
            }
        }
        boolean z2 = (this.d ^ 1) == (i == -1);
        if (!z) {
            a = c(z2 ? eVar.j() : eVar.k());
            if (!(a == null || a == view)) {
                return a;
            }
        }
        if (s(i)) {
            for (i = this.i - 1; i >= 0; i--) {
                if (i != eVar.e) {
                    a = c(z2 ? this.a[i].j() : this.a[i].k());
                    if (!(a == null || a == view)) {
                        return a;
                    }
                }
            }
        } else {
            while (i2 < this.i) {
                View c = c(z2 ? this.a[i2].j() : this.a[i2].k());
                if (c != null && c != view) {
                    return c;
                }
                i2++;
            }
        }
        return null;
    }

    public void a(int i) {
        a(null);
        if (i != this.i) {
            i();
            this.i = i;
            this.m = new BitSet(this.i);
            this.a = new e[this.i];
            for (i = 0; i < this.i; i++) {
                this.a[i] = new e(i);
            }
            o();
        }
    }

    public void a(int i, int i2, u uVar, android.support.v7.widget.at.i.a aVar) {
        if (this.j != 0) {
            i = i2;
        }
        if (v() != 0 && i != 0) {
            a(i, uVar);
            if (this.G == null || this.G.length < this.i) {
                this.G = new int[this.i];
            }
            i = 0;
            i2 = 0;
            int i3 = i2;
            while (i2 < this.i) {
                int i4;
                int a;
                if (this.l.d == -1) {
                    i4 = this.l.f;
                    a = this.a[i2].a(this.l.f);
                } else {
                    i4 = this.a[i2].b(this.l.g);
                    a = this.l.g;
                }
                i4 -= a;
                if (i4 >= 0) {
                    this.G[i3] = i4;
                    i3++;
                }
                i2++;
            }
            Arrays.sort(this.G, 0, i3);
            while (i < i3 && this.l.a(uVar)) {
                aVar.b(this.l.c, this.G[i]);
                am amVar = this.l;
                amVar.c += this.l.d;
                i++;
            }
        }
    }

    void a(int i, u uVar) {
        int K;
        int i2;
        if (i > 0) {
            K = K();
            i2 = 1;
        } else {
            i2 = -1;
            K = L();
        }
        this.l.a = true;
        b(K, uVar);
        l(i2);
        this.l.c = K + this.l.d;
        this.l.b = Math.abs(i);
    }

    public void a(Rect rect, int i, int i2) {
        int a;
        int A = A() + C();
        int B = B() + D();
        if (this.j == 1) {
            a = i.a(i2, rect.height() + B, G());
            i = i.a(i, (this.k * this.i) + A, F());
        } else {
            i = i.a(i, rect.width() + A, F());
            a = i.a(i2, (this.k * this.i) + B, G());
        }
        f(i, a);
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.A = (d) parcelable;
            o();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:16:0x0039 in {3, 8, 9, 11, 14, 15} preds:[]
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
    public void a(android.support.v7.widget.at.p r7, android.support.v7.widget.at.u r8, android.view.View r9, android.support.v4.h.a.b r10) {
        /*
        r6 = this;
        r7 = r9.getLayoutParams();
        r8 = r7 instanceof android.support.v7.widget.StaggeredGridLayoutManager.b;
        if (r8 != 0) goto L_0x000c;
    L_0x0008:
        super.a(r9, r10);
        return;
    L_0x000c:
        r7 = (android.support.v7.widget.StaggeredGridLayoutManager.b) r7;
        r8 = r6.j;
        r9 = 1;
        if (r8 != 0) goto L_0x002b;
    L_0x0013:
        r0 = r7.b();
        r8 = r7.b;
        if (r8 == 0) goto L_0x001d;
    L_0x001b:
        r9 = r6.i;
    L_0x001d:
        r1 = r9;
        r2 = -1;
        r3 = -1;
    L_0x0020:
        r4 = r7.b;
        r5 = 0;
        r6 = android.support.v4.h.a.b.b.a(r0, r1, r2, r3, r4, r5);
        r10.b(r6);
        return;
    L_0x002b:
        r0 = -1;
        r1 = -1;
        r2 = r7.b();
        r8 = r7.b;
        if (r8 == 0) goto L_0x0037;
    L_0x0035:
        r9 = r6.i;
    L_0x0037:
        r3 = r9;
        goto L_0x0020;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a(android.support.v7.widget.at$p, android.support.v7.widget.at$u, android.view.View, android.support.v4.h.a.b):void");
    }

    public void a(u uVar) {
        super.a(uVar);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    void a(u uVar, a aVar) {
        if (!b(uVar, aVar) && !c(uVar, aVar)) {
            aVar.b();
            aVar.a = 0;
        }
    }

    public void a(at atVar) {
        this.h.a();
        o();
    }

    public void a(at atVar, int i, int i2) {
        c(i, i2, 1);
    }

    public void a(at atVar, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    public void a(at atVar, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    public void a(at atVar, p pVar) {
        super.a(atVar, pVar);
        a(this.H);
        for (int i = 0; i < this.i; i++) {
            this.a[i].e();
        }
        atVar.requestLayout();
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (v() > 0) {
            View b = b(false);
            View c = c(false);
            if (b != null && c != null) {
                int d = d(b);
                int d2 = d(c);
                if (d < d2) {
                    accessibilityEvent.setFromIndex(d);
                    accessibilityEvent.setToIndex(d2);
                    return;
                }
                accessibilityEvent.setFromIndex(d2);
                accessibilityEvent.setToIndex(d);
            }
        }
    }

    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (!(this.A == null || this.A.h == z)) {
            this.A.h = z;
        }
        this.d = z;
        o();
    }

    public boolean a(j jVar) {
        return jVar instanceof b;
    }

    public int b(int i, p pVar, u uVar) {
        return c(i, pVar, uVar);
    }

    public int b(p pVar, u uVar) {
        return this.j == 1 ? this.i : super.b(pVar, uVar);
    }

    View b(boolean z) {
        int c = this.b.c();
        int d = this.b.d();
        int v = v();
        View view = null;
        for (int i = 0; i < v; i++) {
            View h = h(i);
            int a = this.b.a(h);
            if (this.b.b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void b(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.j) {
                this.j = i;
                as asVar = this.b;
                this.b = this.c;
                this.c = asVar;
                o();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void b(at atVar, int i, int i2) {
        c(i, i2, 2);
    }

    public boolean b() {
        return this.A == null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:33:0x0078 in {4, 9, 16, 18, 23, 24, 29, 31, 32, 38, 39, 41, 45, 49, 51, 56, 57, 58, 60, 61, 62} preds:[]
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
    boolean b(android.support.v7.widget.at.u r5, android.support.v7.widget.StaggeredGridLayoutManager.a r6) {
        /*
        r4 = this;
        r0 = r5.a();
        r1 = 0;
        if (r0 != 0) goto L_0x00e6;
    L_0x0007:
        r0 = r4.f;
        r2 = -1;
        if (r0 != r2) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r0 = r4.f;
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r0 < 0) goto L_0x00e2;
    L_0x0013:
        r0 = r4.f;
        r5 = r5.e();
        if (r0 < r5) goto L_0x001d;
    L_0x001b:
        goto L_0x00e2;
    L_0x001d:
        r5 = r4.A;
        r0 = 1;
        if (r5 == 0) goto L_0x0036;
    L_0x0022:
        r5 = r4.A;
        r5 = r5.a;
        if (r5 == r2) goto L_0x0036;
    L_0x0028:
        r5 = r4.A;
        r5 = r5.c;
        if (r5 >= r0) goto L_0x002f;
    L_0x002e:
        goto L_0x0036;
    L_0x002f:
        r6.b = r3;
        r4 = r4.f;
        r6.a = r4;
        return r0;
    L_0x0036:
        r5 = r4.f;
        r5 = r4.c(r5);
        if (r5 == 0) goto L_0x00c3;
    L_0x003e:
        r1 = r4.e;
        if (r1 == 0) goto L_0x0047;
    L_0x0042:
        r1 = r4.K();
        goto L_0x004b;
    L_0x0047:
        r1 = r4.L();
    L_0x004b:
        r6.a = r1;
        r1 = r4.g;
        if (r1 == r3) goto L_0x0079;
    L_0x0051:
        r1 = r6.c;
        if (r1 == 0) goto L_0x0068;
    L_0x0055:
        r1 = r4.b;
        r1 = r1.d();
        r2 = r4.g;
        r1 = r1 - r2;
        r4 = r4.b;
        r4 = r4.b(r5);
    L_0x0064:
        r1 = r1 - r4;
        r6.b = r1;
        return r0;
    L_0x0068:
        r1 = r4.b;
        r1 = r1.c();
        r2 = r4.g;
        r1 = r1 + r2;
        r4 = r4.b;
        r4 = r4.a(r5);
        goto L_0x0064;
        return r0;
    L_0x0079:
        r1 = r4.b;
        r1 = r1.e(r5);
        r2 = r4.b;
        r2 = r2.f();
        if (r1 <= r2) goto L_0x009b;
    L_0x0087:
        r5 = r6.c;
        if (r5 == 0) goto L_0x0092;
    L_0x008b:
        r4 = r4.b;
        r4 = r4.d();
        goto L_0x0098;
    L_0x0092:
        r4 = r4.b;
        r4 = r4.c();
    L_0x0098:
        r6.b = r4;
        return r0;
    L_0x009b:
        r1 = r4.b;
        r1 = r1.a(r5);
        r2 = r4.b;
        r2 = r2.c();
        r1 = r1 - r2;
        if (r1 >= 0) goto L_0x00ae;
    L_0x00aa:
        r4 = -r1;
        r6.b = r4;
        return r0;
    L_0x00ae:
        r1 = r4.b;
        r1 = r1.d();
        r4 = r4.b;
        r4 = r4.b(r5);
        r1 = r1 - r4;
        if (r1 >= 0) goto L_0x00c0;
    L_0x00bd:
        r6.b = r1;
        return r0;
    L_0x00c0:
        r6.b = r3;
        return r0;
    L_0x00c3:
        r5 = r4.f;
        r6.a = r5;
        r5 = r4.g;
        if (r5 != r3) goto L_0x00da;
    L_0x00cb:
        r5 = r6.a;
        r4 = r4.t(r5);
        if (r4 != r0) goto L_0x00d4;
    L_0x00d3:
        r1 = r0;
    L_0x00d4:
        r6.c = r1;
        r6.b();
        goto L_0x00df;
    L_0x00da:
        r4 = r4.g;
        r6.a(r4);
    L_0x00df:
        r6.d = r0;
        return r0;
    L_0x00e2:
        r4.f = r2;
        r4.g = r3;
    L_0x00e6:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.b(android.support.v7.widget.at$u, android.support.v7.widget.StaggeredGridLayoutManager$a):boolean");
    }

    int c(int i, p pVar, u uVar) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        a(i, uVar);
        int a = a(pVar, this.l, uVar);
        if (this.l.b >= a) {
            i = i < 0 ? -a : a;
        }
        this.b.a(-i);
        this.o = this.e;
        this.l.b = 0;
        a(pVar, this.l);
        return i;
    }

    public int c(u uVar) {
        return b(uVar);
    }

    View c(boolean z) {
        int c = this.b.c();
        int d = this.b.d();
        View view = null;
        for (int v = v() - 1; v >= 0; v--) {
            View h = h(v);
            int a = this.b.a(h);
            int b = this.b.b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void c(p pVar, u uVar) {
        a(pVar, uVar, true);
    }

    public boolean c() {
        return this.n != 0;
    }

    public int d(u uVar) {
        return b(uVar);
    }

    public Parcelable d() {
        if (this.A != null) {
            return new d(this.A);
        }
        Parcelable dVar = new d();
        dVar.h = this.d;
        dVar.i = this.o;
        dVar.j = this.z;
        int i = 0;
        if (this.h == null || this.h.a == null) {
            dVar.e = 0;
        } else {
            dVar.f = this.h.a;
            dVar.e = dVar.f.length;
            dVar.g = this.h.b;
        }
        if (v() > 0) {
            dVar.a = this.o ? K() : L();
            dVar.b = k();
            dVar.c = this.i;
            dVar.d = new int[this.i];
            while (i < this.i) {
                int b;
                int d;
                if (this.o) {
                    b = this.a[i].b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        d = this.b.d();
                    } else {
                        dVar.d[i] = b;
                        i++;
                    }
                } else {
                    b = this.a[i].a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        d = this.b.c();
                    } else {
                        dVar.d[i] = b;
                        i++;
                    }
                }
                b -= d;
                dVar.d[i] = b;
                i++;
            }
        } else {
            dVar.a = -1;
            dVar.b = -1;
            dVar.c = 0;
        }
        return dVar;
    }

    public void d(int i) {
        if (!(this.A == null || this.A.a == i)) {
            this.A.b();
        }
        this.f = i;
        this.g = Integer.MIN_VALUE;
        o();
    }

    public int e(u uVar) {
        return i(uVar);
    }

    void e(int i) {
        this.k = i / this.i;
        this.B = MeasureSpec.makeMeasureSpec(i, this.c.h());
    }

    public boolean e() {
        return this.j == 0;
    }

    public int f(u uVar) {
        return i(uVar);
    }

    public boolean f() {
        return this.j == 1;
    }

    public int g(u uVar) {
        return j(uVar);
    }

    /* JADX WARNING: Missing block: B:33:0x0076, code:
            return false;
     */
    boolean g() {
        /*
        r7 = this;
        r0 = r7.v();
        r1 = 0;
        if (r0 == 0) goto L_0x0076;
    L_0x0007:
        r0 = r7.n;
        if (r0 == 0) goto L_0x0076;
    L_0x000b:
        r0 = r7.q();
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r7.e;
        if (r0 == 0) goto L_0x001f;
    L_0x0016:
        r0 = r7.K();
        r2 = r7.L();
        goto L_0x0027;
    L_0x001f:
        r0 = r7.L();
        r2 = r7.K();
    L_0x0027:
        r3 = 1;
        if (r0 != 0) goto L_0x003c;
    L_0x002a:
        r4 = r7.h();
        if (r4 == 0) goto L_0x003c;
    L_0x0030:
        r0 = r7.h;
        r0.a();
    L_0x0035:
        r7.I();
        r7.o();
        return r3;
    L_0x003c:
        r4 = r7.E;
        if (r4 != 0) goto L_0x0041;
    L_0x0040:
        return r1;
    L_0x0041:
        r4 = r7.e;
        r5 = -1;
        if (r4 == 0) goto L_0x0048;
    L_0x0046:
        r4 = r5;
        goto L_0x0049;
    L_0x0048:
        r4 = r3;
    L_0x0049:
        r6 = r7.h;
        r2 = r2 + r3;
        r6 = r6.a(r0, r2, r4, r3);
        if (r6 != 0) goto L_0x005a;
    L_0x0052:
        r7.E = r1;
        r7 = r7.h;
        r7.a(r2);
        return r1;
    L_0x005a:
        r1 = r7.h;
        r2 = r6.a;
        r4 = r4 * r5;
        r0 = r1.a(r0, r2, r4, r3);
        if (r0 != 0) goto L_0x006d;
    L_0x0065:
        r0 = r7.h;
        r1 = r6.a;
        r0.a(r1);
        goto L_0x0035;
    L_0x006d:
        r1 = r7.h;
        r0 = r0.a;
        r0 = r0 + r3;
        r1.a(r0);
        goto L_0x0035;
    L_0x0076:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.g():boolean");
    }

    public int h(u uVar) {
        return j(uVar);
    }

    /* JADX WARNING: Missing block: B:28:0x0074, code:
            if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:32:0x0086, code:
            if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:34:0x008a, code:
            r10 = false;
     */
    android.view.View h() {
        /*
        r12 = this;
        r0 = r12.v();
        r1 = 1;
        r0 = r0 - r1;
        r2 = new java.util.BitSet;
        r3 = r12.i;
        r2.<init>(r3);
        r3 = r12.i;
        r4 = 0;
        r2.set(r4, r3, r1);
        r3 = r12.j;
        r5 = -1;
        if (r3 != r1) goto L_0x0020;
    L_0x0018:
        r3 = r12.j();
        if (r3 == 0) goto L_0x0020;
    L_0x001e:
        r3 = r1;
        goto L_0x0021;
    L_0x0020:
        r3 = r5;
    L_0x0021:
        r6 = r12.e;
        if (r6 == 0) goto L_0x0027;
    L_0x0025:
        r6 = r5;
        goto L_0x002b;
    L_0x0027:
        r0 = r0 + 1;
        r6 = r0;
        r0 = r4;
    L_0x002b:
        if (r0 >= r6) goto L_0x002e;
    L_0x002d:
        r5 = r1;
    L_0x002e:
        if (r0 == r6) goto L_0x00ab;
    L_0x0030:
        r7 = r12.h(r0);
        r8 = r7.getLayoutParams();
        r8 = (android.support.v7.widget.StaggeredGridLayoutManager.b) r8;
        r9 = r8.a;
        r9 = r9.e;
        r9 = r2.get(r9);
        if (r9 == 0) goto L_0x0054;
    L_0x0044:
        r9 = r8.a;
        r9 = r12.a(r9);
        if (r9 == 0) goto L_0x004d;
    L_0x004c:
        return r7;
    L_0x004d:
        r9 = r8.a;
        r9 = r9.e;
        r2.clear(r9);
    L_0x0054:
        r9 = r8.b;
        if (r9 == 0) goto L_0x0059;
    L_0x0058:
        goto L_0x00a9;
    L_0x0059:
        r9 = r0 + r5;
        if (r9 == r6) goto L_0x00a9;
    L_0x005d:
        r9 = r12.h(r9);
        r10 = r12.e;
        if (r10 == 0) goto L_0x0077;
    L_0x0065:
        r10 = r12.b;
        r10 = r10.b(r7);
        r11 = r12.b;
        r11 = r11.b(r9);
        if (r10 >= r11) goto L_0x0074;
    L_0x0073:
        return r7;
    L_0x0074:
        if (r10 != r11) goto L_0x008a;
    L_0x0076:
        goto L_0x0088;
    L_0x0077:
        r10 = r12.b;
        r10 = r10.a(r7);
        r11 = r12.b;
        r11 = r11.a(r9);
        if (r10 <= r11) goto L_0x0086;
    L_0x0085:
        return r7;
    L_0x0086:
        if (r10 != r11) goto L_0x008a;
    L_0x0088:
        r10 = r1;
        goto L_0x008b;
    L_0x008a:
        r10 = r4;
    L_0x008b:
        if (r10 == 0) goto L_0x00a9;
    L_0x008d:
        r9 = r9.getLayoutParams();
        r9 = (android.support.v7.widget.StaggeredGridLayoutManager.b) r9;
        r8 = r8.a;
        r8 = r8.e;
        r9 = r9.a;
        r9 = r9.e;
        r8 = r8 - r9;
        if (r8 >= 0) goto L_0x00a0;
    L_0x009e:
        r8 = r1;
        goto L_0x00a1;
    L_0x00a0:
        r8 = r4;
    L_0x00a1:
        if (r3 >= 0) goto L_0x00a5;
    L_0x00a3:
        r9 = r1;
        goto L_0x00a6;
    L_0x00a5:
        r9 = r4;
    L_0x00a6:
        if (r8 == r9) goto L_0x00a9;
    L_0x00a8:
        return r7;
    L_0x00a9:
        r0 = r0 + r5;
        goto L_0x002e;
    L_0x00ab:
        r12 = 0;
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.h():android.view.View");
    }

    public void i() {
        this.h.a();
        o();
    }

    public void i(int i) {
        super.i(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.a[i2].d(i);
        }
    }

    public void j(int i) {
        super.j(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.a[i2].d(i);
        }
    }

    boolean j() {
        return t() == 1;
    }

    int k() {
        View c = this.e ? c(true) : b(true);
        return c == null ? -1 : d(c);
    }

    public void k(int i) {
        if (i == 0) {
            g();
        }
    }

    boolean m() {
        int b = this.a[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.a[i].b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean n() {
        int a = this.a[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.a[i].a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }
}
