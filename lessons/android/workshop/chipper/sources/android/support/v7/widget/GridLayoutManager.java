package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.at.i;
import android.support.v7.widget.at.j;
import android.support.v7.widget.at.p;
import android.support.v7.widget.at.u;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean a = false;
    int b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    c g = new a();
    final Rect h = new Rect();

    public static abstract class c {
        final SparseIntArray a = new SparseIntArray();
        private boolean b = false;

        public abstract int a(int i);

        /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A:{RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A:{RETURN} */
        public int a(int r6, int r7) {
            /*
            r5 = this;
            r0 = r5.a(r6);
            r1 = 0;
            if (r0 != r7) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            r2 = r5.b;
            if (r2 == 0) goto L_0x0026;
        L_0x000c:
            r2 = r5.a;
            r2 = r2.size();
            if (r2 <= 0) goto L_0x0026;
        L_0x0014:
            r2 = r5.b(r6);
            if (r2 < 0) goto L_0x0026;
        L_0x001a:
            r3 = r5.a;
            r3 = r3.get(r2);
            r4 = r5.a(r2);
            r3 = r3 + r4;
            goto L_0x0036;
        L_0x0026:
            r2 = r1;
            r3 = r2;
        L_0x0028:
            if (r2 >= r6) goto L_0x0039;
        L_0x002a:
            r4 = r5.a(r2);
            r3 = r3 + r4;
            if (r3 != r7) goto L_0x0033;
        L_0x0031:
            r3 = r1;
            goto L_0x0036;
        L_0x0033:
            if (r3 <= r7) goto L_0x0036;
        L_0x0035:
            r3 = r4;
        L_0x0036:
            r2 = r2 + 1;
            goto L_0x0028;
        L_0x0039:
            r0 = r0 + r3;
            if (r0 > r7) goto L_0x003d;
        L_0x003c:
            return r3;
        L_0x003d:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.c.a(int, int):int");
        }

        public void a() {
            this.a.clear();
        }

        int b(int i) {
            int size = this.a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            i2--;
            return (i2 < 0 || i2 >= this.a.size()) ? -1 : this.a.keyAt(i2);
        }

        int b(int i, int i2) {
            if (!this.b) {
                return a(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i2 = a(i, i2);
            this.a.put(i, i2);
            return i2;
        }

        public int c(int i, int i2) {
            int a = a(i);
            int i3 = 0;
            int i4 = i3;
            int i5 = i4;
            while (i3 < i) {
                int a2 = a(i3);
                i4 += a2;
                if (i4 == i2) {
                    i5++;
                    i4 = 0;
                } else if (i4 > i2) {
                    i5++;
                    i4 = a2;
                }
                i3++;
            }
            return i4 + a > i2 ? i5 + 1 : i5;
        }
    }

    public static final class a extends c {
        public int a(int i) {
            return 1;
        }

        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends j {
        int a = -1;
        int b = 0;

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

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(i.a(context, attributeSet, i, i2).b);
    }

    private void K() {
        this.e.clear();
        this.f.clear();
    }

    private void L() {
        int v = v();
        for (int i = 0; i < v; i++) {
            b bVar = (b) h(i).getLayoutParams();
            int f = bVar.f();
            this.e.put(f, bVar.b());
            this.f.put(f, bVar.a());
        }
    }

    private void M() {
        int y;
        int A;
        if (g() == 1) {
            y = y() - C();
            A = A();
        } else {
            y = z() - D();
            A = B();
        }
        l(y - A);
    }

    private void N() {
        if (this.d == null || this.d.length != this.b) {
            this.d = new View[this.b];
        }
    }

    private int a(p pVar, u uVar, int i) {
        if (!uVar.a()) {
            return this.g.c(i, this.b);
        }
        int b = pVar.b(i);
        if (b != -1) {
            return this.g.c(b, this.b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find span size for pre layout position. ");
        stringBuilder.append(i);
        Log.w("GridLayoutManager", stringBuilder.toString());
        return 0;
    }

    private void a(float f, int i) {
        l(Math.max(Math.round(f * ((float) this.b)), i));
    }

    private void a(p pVar, u uVar, int i, int i2, boolean z) {
        int i3;
        i2 = -1;
        int i4 = 0;
        if (z) {
            i3 = 1;
            i2 = i;
            i = 0;
        } else {
            i--;
            i3 = -1;
        }
        while (i != i2) {
            View view = this.d[i];
            b bVar = (b) view.getLayoutParams();
            bVar.b = c(pVar, uVar, d(view));
            bVar.a = i4;
            i4 += bVar.b;
            i += i3;
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        j jVar = (j) view.getLayoutParams();
        if (z ? a(view, i, i2, jVar) : b(view, i, i2, jVar)) {
            view.measure(i, i2);
        }
    }

    private void a(View view, int i, boolean z) {
        int a;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.d;
        int i2 = ((rect.top + rect.bottom) + bVar.topMargin) + bVar.bottomMargin;
        int i3 = ((rect.left + rect.right) + bVar.leftMargin) + bVar.rightMargin;
        int a2 = a(bVar.a, bVar.b);
        if (this.i == 1) {
            i = i.a(a2, i, i3, bVar.width, false);
            a = i.a(this.j.f(), x(), i2, bVar.height, true);
        } else {
            i = i.a(a2, i, i2, bVar.height, false);
            int a3 = i.a(this.j.f(), w(), i3, bVar.width, true);
            a = i;
            i = a3;
        }
        a(view, i, a, z);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3 = 1;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        i2 %= i;
        int i6 = 0;
        while (i3 <= i) {
            int i7;
            i4 += i2;
            if (i4 <= 0 || i - i4 >= i2) {
                i7 = i5;
            } else {
                i7 = i5 + 1;
                i4 -= i;
            }
            i6 += i7;
            iArr[i3] = i6;
            i3++;
        }
        return iArr;
    }

    private int b(p pVar, u uVar, int i) {
        if (!uVar.a()) {
            return this.g.b(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b = pVar.b(i);
        if (b != -1) {
            return this.g.b(b, this.b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        stringBuilder.append(i);
        Log.w("GridLayoutManager", stringBuilder.toString());
        return 0;
    }

    private void b(p pVar, u uVar, a aVar, int i) {
        i = i == 1 ? 1 : 0;
        int b = b(pVar, uVar, aVar.b);
        if (i != 0) {
            while (b > 0 && aVar.b > 0) {
                aVar.b--;
                b = b(pVar, uVar, aVar.b);
            }
            return;
        }
        i = uVar.e() - 1;
        int i2 = aVar.b;
        while (i2 < i) {
            int i3 = i2 + 1;
            int b2 = b(pVar, uVar, i3);
            if (b2 <= b) {
                break;
            }
            i2 = i3;
            b = b2;
        }
        aVar.b = i2;
    }

    private int c(p pVar, u uVar, int i) {
        if (!uVar.a()) {
            return this.g.a(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b = pVar.b(i);
        if (b != -1) {
            return this.g.a(b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        stringBuilder.append(i);
        Log.w("GridLayoutManager", stringBuilder.toString());
        return 1;
    }

    private void l(int i) {
        this.c = a(this.c, this.b, i);
    }

    int a(int i, int i2) {
        return (this.i == 1 && h()) ? this.c[this.b - i] - this.c[(this.b - i) - i2] : this.c[i2 + i] - this.c[i];
    }

    public int a(int i, p pVar, u uVar) {
        M();
        N();
        return super.a(i, pVar, uVar);
    }

    public int a(p pVar, u uVar) {
        return this.i == 0 ? this.b : uVar.e() < 1 ? 0 : a(pVar, uVar, uVar.e() - 1) + 1;
    }

    public j a() {
        return this.i == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    public j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public j a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new b((MarginLayoutParams) layoutParams) : new b(layoutParams);
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
            if (d2 >= 0 && d2 < i3 && b(pVar, uVar, d2) == 0) {
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

    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Missing block: B:54:0x00d8, code:
            if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Missing block: B:64:0x00f5, code:
            if (r13 == r10) goto L_0x00bb;
     */
    public android.view.View a(android.view.View r27, int r28, android.support.v7.widget.at.p r29, android.support.v7.widget.at.u r30) {
        /*
        r26 = this;
        r0 = r26;
        r1 = r29;
        r2 = r30;
        r3 = r26.e(r27);
        r4 = 0;
        if (r3 != 0) goto L_0x000e;
    L_0x000d:
        return r4;
    L_0x000e:
        r5 = r3.getLayoutParams();
        r5 = (android.support.v7.widget.GridLayoutManager.b) r5;
        r6 = r5.a;
        r7 = r5.a;
        r5 = r5.b;
        r7 = r7 + r5;
        r5 = super.a(r27, r28, r29, r30);
        if (r5 != 0) goto L_0x0022;
    L_0x0021:
        return r4;
    L_0x0022:
        r5 = r28;
        r5 = r0.e(r5);
        r9 = 1;
        if (r5 != r9) goto L_0x002d;
    L_0x002b:
        r5 = r9;
        goto L_0x002e;
    L_0x002d:
        r5 = 0;
    L_0x002e:
        r10 = r0.k;
        if (r5 == r10) goto L_0x0034;
    L_0x0032:
        r5 = r9;
        goto L_0x0035;
    L_0x0034:
        r5 = 0;
    L_0x0035:
        r10 = -1;
        if (r5 == 0) goto L_0x0040;
    L_0x0038:
        r5 = r26.v();
        r5 = r5 - r9;
        r11 = r10;
        r12 = r11;
        goto L_0x0047;
    L_0x0040:
        r5 = r26.v();
        r11 = r5;
        r12 = r9;
        r5 = 0;
    L_0x0047:
        r13 = r0.i;
        if (r13 != r9) goto L_0x0053;
    L_0x004b:
        r13 = r26.h();
        if (r13 == 0) goto L_0x0053;
    L_0x0051:
        r13 = r9;
        goto L_0x0054;
    L_0x0053:
        r13 = 0;
    L_0x0054:
        r14 = r0.a(r1, r2, r5);
        r8 = r10;
        r18 = r8;
        r15 = 0;
        r17 = 0;
        r10 = r4;
    L_0x005f:
        if (r5 == r11) goto L_0x0146;
    L_0x0061:
        r9 = r0.a(r1, r2, r5);
        r1 = r0.h(r5);
        if (r1 != r3) goto L_0x006d;
    L_0x006b:
        goto L_0x0146;
    L_0x006d:
        r20 = r1.hasFocusable();
        if (r20 == 0) goto L_0x0087;
    L_0x0073:
        if (r9 == r14) goto L_0x0087;
    L_0x0075:
        if (r4 == 0) goto L_0x0079;
    L_0x0077:
        goto L_0x0146;
    L_0x0079:
        r21 = r3;
        r23 = r8;
        r24 = r10;
        r22 = r11;
        r8 = r17;
        r11 = r18;
        goto L_0x0132;
    L_0x0087:
        r9 = r1.getLayoutParams();
        r9 = (android.support.v7.widget.GridLayoutManager.b) r9;
        r2 = r9.a;
        r21 = r3;
        r3 = r9.a;
        r22 = r11;
        r11 = r9.b;
        r3 = r3 + r11;
        r11 = r1.hasFocusable();
        if (r11 == 0) goto L_0x00a3;
    L_0x009e:
        if (r2 != r6) goto L_0x00a3;
    L_0x00a0:
        if (r3 != r7) goto L_0x00a3;
    L_0x00a2:
        return r1;
    L_0x00a3:
        r11 = r1.hasFocusable();
        if (r11 == 0) goto L_0x00ab;
    L_0x00a9:
        if (r4 == 0) goto L_0x00b3;
    L_0x00ab:
        r11 = r1.hasFocusable();
        if (r11 != 0) goto L_0x00be;
    L_0x00b1:
        if (r10 != 0) goto L_0x00be;
    L_0x00b3:
        r23 = r8;
        r24 = r10;
        r8 = r17;
    L_0x00b9:
        r11 = r18;
    L_0x00bb:
        r19 = 1;
        goto L_0x0102;
    L_0x00be:
        r11 = java.lang.Math.max(r2, r6);
        r20 = java.lang.Math.min(r3, r7);
        r11 = r20 - r11;
        r20 = r1.hasFocusable();
        if (r20 == 0) goto L_0x00db;
    L_0x00ce:
        if (r11 <= r15) goto L_0x00d1;
    L_0x00d0:
        goto L_0x00b3;
    L_0x00d1:
        if (r11 != r15) goto L_0x00f8;
    L_0x00d3:
        if (r2 <= r8) goto L_0x00d7;
    L_0x00d5:
        r11 = 1;
        goto L_0x00d8;
    L_0x00d7:
        r11 = 0;
    L_0x00d8:
        if (r13 != r11) goto L_0x00f8;
    L_0x00da:
        goto L_0x00b3;
    L_0x00db:
        if (r4 != 0) goto L_0x00f8;
    L_0x00dd:
        r23 = r8;
        r24 = r10;
        r8 = 1;
        r10 = 0;
        r16 = r0.a(r1, r10, r8);
        if (r16 == 0) goto L_0x00fc;
    L_0x00e9:
        r8 = r17;
        if (r11 <= r8) goto L_0x00ee;
    L_0x00ed:
        goto L_0x00b9;
    L_0x00ee:
        if (r11 != r8) goto L_0x00fe;
    L_0x00f0:
        r11 = r18;
        if (r2 <= r11) goto L_0x00f5;
    L_0x00f4:
        r10 = 1;
    L_0x00f5:
        if (r13 != r10) goto L_0x0100;
    L_0x00f7:
        goto L_0x00bb;
    L_0x00f8:
        r23 = r8;
        r24 = r10;
    L_0x00fc:
        r8 = r17;
    L_0x00fe:
        r11 = r18;
    L_0x0100:
        r19 = 0;
    L_0x0102:
        if (r19 == 0) goto L_0x0132;
    L_0x0104:
        r10 = r1.hasFocusable();
        if (r10 == 0) goto L_0x011f;
    L_0x010a:
        r4 = r9.a;
        r3 = java.lang.Math.min(r3, r7);
        r2 = java.lang.Math.max(r2, r6);
        r3 = r3 - r2;
        r15 = r3;
        r17 = r8;
        r18 = r11;
        r10 = r24;
        r8 = r4;
        r4 = r1;
        goto L_0x013a;
    L_0x011f:
        r8 = r9.a;
        r3 = java.lang.Math.min(r3, r7);
        r2 = java.lang.Math.max(r2, r6);
        r3 = r3 - r2;
        r10 = r1;
        r17 = r3;
        r18 = r8;
        r8 = r23;
        goto L_0x013a;
    L_0x0132:
        r17 = r8;
        r18 = r11;
        r8 = r23;
        r10 = r24;
    L_0x013a:
        r5 = r5 + r12;
        r3 = r21;
        r11 = r22;
        r1 = r29;
        r2 = r30;
        r9 = 1;
        goto L_0x005f;
    L_0x0146:
        r24 = r10;
        if (r4 == 0) goto L_0x014c;
    L_0x014a:
        r24 = r4;
    L_0x014c:
        return r24;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.a(android.view.View, int, android.support.v7.widget.at$p, android.support.v7.widget.at$u):android.view.View");
    }

    public void a(int i) {
        if (i != this.b) {
            this.a = true;
            if (i < 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Span count should be at least 1. Provided ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.b = i;
            this.g.a();
            o();
        }
    }

    public void a(Rect rect, int i, int i2) {
        int a;
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int A = A() + C();
        int B = B() + D();
        if (this.i == 1) {
            a = i.a(i2, rect.height() + B, G());
            i = i.a(i, this.c[this.c.length - 1] + A, F());
        } else {
            i = i.a(i, rect.width() + A, F());
            a = i.a(i2, this.c[this.c.length - 1] + B, G());
        }
        f(i, a);
    }

    void a(p pVar, u uVar, a aVar, int i) {
        super.a(pVar, uVar, aVar, i);
        M();
        if (uVar.e() > 0 && !uVar.a()) {
            b(pVar, uVar, aVar, i);
        }
        N();
    }

    void a(p pVar, u uVar, c cVar, b bVar) {
        int i;
        int c;
        p pVar2 = pVar;
        u uVar2 = uVar;
        c cVar2 = cVar;
        b bVar2 = bVar;
        int i2 = this.j.i();
        boolean z = i2 != 1073741824;
        int i3 = v() > 0 ? this.c[this.b] : 0;
        if (z) {
            M();
        }
        boolean z2 = cVar2.e == 1;
        int i4 = this.b;
        if (!z2) {
            i4 = b(pVar2, uVar2, cVar2.d) + c(pVar2, uVar2, cVar2.d);
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.b && cVar2.a(uVar2) && i4 > 0) {
            i = cVar2.d;
            c = c(pVar2, uVar2, i);
            if (c > this.b) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Item at position ");
                stringBuilder.append(i);
                stringBuilder.append(" requires ");
                stringBuilder.append(c);
                stringBuilder.append(" spans but GridLayoutManager has only ");
                stringBuilder.append(this.b);
                stringBuilder.append(" spans.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            i4 -= c;
            if (i4 < 0) {
                break;
            }
            View a = cVar2.a(pVar2);
            if (a == null) {
                break;
            }
            i5 += c;
            this.d[i6] = a;
            i6++;
        }
        if (i6 == 0) {
            bVar2.b = true;
            return;
        }
        View view;
        int e;
        float f = 0.0f;
        int i7 = i6;
        a(pVar2, uVar2, i6, i5, z2);
        int i8 = 0;
        for (i4 = 0; i4 < i7; i4++) {
            boolean z3;
            view = this.d[i4];
            if (cVar2.k != null) {
                z3 = false;
                if (z2) {
                    a(view);
                } else {
                    a(view, 0);
                }
            } else if (z2) {
                b(view);
                z3 = false;
            } else {
                z3 = false;
                b(view, 0);
            }
            b(view, this.h);
            a(view, i2, z3);
            i = this.j.e(view);
            if (i > i8) {
                i8 = i;
            }
            float f2 = (((float) this.j.f(view)) * 1.0f) / ((float) ((b) view.getLayoutParams()).b);
            if (f2 > f) {
                f = f2;
            }
        }
        if (z) {
            a(f, i3);
            i8 = 0;
            for (i4 = 0; i4 < i7; i4++) {
                view = this.d[i4];
                a(view, 1073741824, true);
                e = this.j.e(view);
                if (e > i8) {
                    i8 = e;
                }
            }
        }
        for (i4 = 0; i4 < i7; i4++) {
            view = this.d[i4];
            if (this.j.e(view) != i8) {
                b bVar3 = (b) view.getLayoutParams();
                Rect rect = bVar3.d;
                i6 = ((rect.top + rect.bottom) + bVar3.topMargin) + bVar3.bottomMargin;
                i2 = ((rect.left + rect.right) + bVar3.leftMargin) + bVar3.rightMargin;
                i5 = a(bVar3.a, bVar3.b);
                if (this.i == 1) {
                    i = i.a(i5, 1073741824, i2, bVar3.width, false);
                    i5 = MeasureSpec.makeMeasureSpec(i8 - i6, 1073741824);
                    i2 = i;
                } else {
                    i2 = MeasureSpec.makeMeasureSpec(i8 - i2, 1073741824);
                    i5 = i.a(i5, 1073741824, i6, bVar3.height, false);
                }
                a(view, i2, i5, true);
            }
        }
        c = 0;
        bVar2.a = i8;
        if (this.i == 1) {
            if (cVar2.f == -1) {
                i4 = cVar2.b;
                i = i4;
                e = i4 - i8;
            } else {
                i4 = cVar2.b;
                e = i4;
                i = i8 + i4;
            }
            i4 = 0;
            i8 = i4;
        } else if (cVar2.f == -1) {
            i4 = cVar2.b;
            e = 0;
            i = e;
            int i9 = i4 - i8;
            i8 = i4;
            i4 = i9;
        } else {
            i4 = cVar2.b;
            i8 += i4;
            e = 0;
            i = e;
        }
        while (c < i7) {
            int i10;
            int f3;
            int i11;
            View view2 = this.d[c];
            b bVar4 = (b) view2.getLayoutParams();
            if (this.i != 1) {
                e = B() + this.c[bVar4.a];
                i = this.j.f(view2) + e;
            } else if (h()) {
                i4 = A() + this.c[this.b - bVar4.a];
                i10 = i4;
                f3 = i4 - this.j.f(view2);
                i3 = e;
                i11 = i;
                a(view2, f3, i3, i10, i11);
                if (!bVar4.d() || bVar4.e()) {
                    bVar2.c = true;
                }
                bVar2.d |= view2.hasFocusable();
                c++;
                i4 = f3;
                e = i3;
                i8 = i10;
                i = i11;
            } else {
                i4 = A() + this.c[bVar4.a];
                i8 = this.j.f(view2) + i4;
            }
            f3 = i4;
            i10 = i8;
            i3 = e;
            i11 = i;
            a(view2, f3, i3, i10, i11);
            if (bVar4.d()) {
            }
            bVar2.c = true;
            bVar2.d |= view2.hasFocusable();
            c++;
            i4 = f3;
            e = i3;
            i8 = i10;
            i = i11;
        }
        Arrays.fill(this.d, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:22:0x005a in {3, 10, 11, 12, 14, 19, 20, 21} preds:[]
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
    public void a(android.support.v7.widget.at.p r8, android.support.v7.widget.at.u r9, android.view.View r10, android.support.v4.h.a.b r11) {
        /*
        r7 = this;
        r0 = r10.getLayoutParams();
        r1 = r0 instanceof android.support.v7.widget.GridLayoutManager.b;
        if (r1 != 0) goto L_0x000c;
    L_0x0008:
        super.a(r10, r11);
        return;
    L_0x000c:
        r0 = (android.support.v7.widget.GridLayoutManager.b) r0;
        r10 = r0.f();
        r8 = r7.a(r8, r9, r10);
        r9 = r7.i;
        r10 = 0;
        r1 = 1;
        if (r9 != 0) goto L_0x003f;
    L_0x001c:
        r9 = r0.a();
        r2 = r0.b();
        r4 = 1;
        r3 = r7.b;
        if (r3 <= r1) goto L_0x0033;
    L_0x0029:
        r0 = r0.b();
        r7 = r7.b;
        if (r0 != r7) goto L_0x0033;
    L_0x0031:
        r5 = r1;
        goto L_0x0034;
    L_0x0033:
        r5 = r10;
    L_0x0034:
        r6 = 0;
        r1 = r9;
        r3 = r8;
    L_0x0037:
        r7 = android.support.v4.h.a.b.b.a(r1, r2, r3, r4, r5, r6);
        r11.b(r7);
        return;
    L_0x003f:
        r2 = 1;
        r3 = r0.a();
        r4 = r0.b();
        r9 = r7.b;
        if (r9 <= r1) goto L_0x0056;
    L_0x004c:
        r9 = r0.b();
        r7 = r7.b;
        if (r9 != r7) goto L_0x0056;
    L_0x0054:
        r5 = r1;
        goto L_0x0057;
    L_0x0056:
        r5 = r10;
    L_0x0057:
        r6 = 0;
        r1 = r8;
        goto L_0x0037;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.a(android.support.v7.widget.at$p, android.support.v7.widget.at$u, android.view.View, android.support.v4.h.a.b):void");
    }

    public void a(u uVar) {
        super.a(uVar);
        this.a = false;
    }

    void a(u uVar, c cVar, android.support.v7.widget.at.i.a aVar) {
        int i = this.b;
        for (int i2 = 0; i2 < this.b && cVar.a(uVar) && i > 0; i2++) {
            int i3 = cVar.d;
            aVar.b(i3, Math.max(0, cVar.g));
            i -= this.g.a(i3);
            cVar.d += cVar.e;
        }
    }

    public void a(at atVar) {
        this.g.a();
    }

    public void a(at atVar, int i, int i2) {
        this.g.a();
    }

    public void a(at atVar, int i, int i2, int i3) {
        this.g.a();
    }

    public void a(at atVar, int i, int i2, Object obj) {
        this.g.a();
    }

    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    public boolean a(j jVar) {
        return jVar instanceof b;
    }

    public int b(int i, p pVar, u uVar) {
        M();
        N();
        return super.b(i, pVar, uVar);
    }

    public int b(p pVar, u uVar) {
        return this.i == 1 ? this.b : uVar.e() < 1 ? 0 : a(pVar, uVar, uVar.e() - 1) + 1;
    }

    public void b(at atVar, int i, int i2) {
        this.g.a();
    }

    public boolean b() {
        return this.n == null && !this.a;
    }

    public void c(p pVar, u uVar) {
        if (uVar.a()) {
            L();
        }
        super.c(pVar, uVar);
        K();
    }
}
