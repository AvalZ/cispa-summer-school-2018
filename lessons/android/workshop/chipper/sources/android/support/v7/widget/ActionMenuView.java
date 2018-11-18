package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends an implements android.support.v7.view.menu.h.b, p {
    android.support.v7.view.menu.h.a a;
    e b;
    private h c;
    private Context d;
    private int e;
    private boolean f;
    private c g;
    private android.support.v7.view.menu.o.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public interface a {
        boolean c();

        boolean d();
    }

    public interface e {
        boolean a(MenuItem menuItem);
    }

    private static class b implements android.support.v7.view.menu.o.a {
        b() {
        }

        public void a(h hVar, boolean z) {
        }

        public boolean a(h hVar) {
            return false;
        }
    }

    public static class c extends android.support.v7.widget.an.a {
        @ExportedProperty
        public boolean a;
        @ExportedProperty
        public int b;
        @ExportedProperty
        public int c;
        @ExportedProperty
        public boolean d;
        @ExportedProperty
        public boolean e;
        boolean f;

        public c(int i, int i2) {
            super(i, i2);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }

        public c(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class d implements android.support.v7.view.menu.h.a {
        d() {
        }

        public void a(h hVar) {
            if (ActionMenuView.this.a != null) {
                ActionMenuView.this.a.a(hVar);
            }
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return ActionMenuView.this.b != null && ActionMenuView.this.b.a(menuItem);
        }
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        i3 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.b();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), i3);
            i2 = view.getMeasuredWidth();
            int i6 = i2 / i;
            if (i2 % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (!cVar.a && z2) {
            z = true;
        }
        cVar.d = z;
        cVar.b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i * i5, 1073741824), i3);
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x024a A:{LOOP_START, LOOP:5: B:135:0x024a->B:140:0x026c, PHI: r5 r32 } */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0273  */
    private void c(int r35, int r36) {
        /*
        r34 = this;
        r0 = r34;
        r1 = android.view.View.MeasureSpec.getMode(r36);
        r2 = android.view.View.MeasureSpec.getSize(r35);
        r3 = android.view.View.MeasureSpec.getSize(r36);
        r4 = r34.getPaddingLeft();
        r5 = r34.getPaddingRight();
        r4 = r4 + r5;
        r5 = r34.getPaddingTop();
        r6 = r34.getPaddingBottom();
        r5 = r5 + r6;
        r6 = -2;
        r7 = r36;
        r6 = getChildMeasureSpec(r7, r5, r6);
        r2 = r2 - r4;
        r4 = r0.k;
        r4 = r2 / r4;
        r7 = r0.k;
        r7 = r2 % r7;
        r8 = 0;
        if (r4 != 0) goto L_0x0037;
    L_0x0033:
        r0.setMeasuredDimension(r2, r8);
        return;
    L_0x0037:
        r9 = r0.k;
        r7 = r7 / r4;
        r9 = r9 + r7;
        r7 = r34.getChildCount();
        r14 = r4;
        r4 = r8;
        r10 = r4;
        r12 = r10;
        r13 = r12;
        r15 = r13;
        r16 = r15;
        r19 = 0;
    L_0x0049:
        if (r4 >= r7) goto L_0x00d6;
    L_0x004b:
        r11 = r0.getChildAt(r4);
        r8 = r11.getVisibility();
        r21 = r3;
        r3 = 8;
        if (r8 != r3) goto L_0x005d;
    L_0x0059:
        r23 = r2;
        goto L_0x00cd;
    L_0x005d:
        r3 = r11 instanceof android.support.v7.view.menu.ActionMenuItemView;
        r13 = r13 + 1;
        if (r3 == 0) goto L_0x0070;
    L_0x0063:
        r8 = r0.l;
        r22 = r13;
        r13 = r0.l;
        r23 = r2;
        r2 = 0;
        r11.setPadding(r8, r2, r13, r2);
        goto L_0x0075;
    L_0x0070:
        r23 = r2;
        r22 = r13;
        r2 = 0;
    L_0x0075:
        r8 = r11.getLayoutParams();
        r8 = (android.support.v7.widget.ActionMenuView.c) r8;
        r8.f = r2;
        r8.c = r2;
        r8.b = r2;
        r8.d = r2;
        r8.leftMargin = r2;
        r8.rightMargin = r2;
        if (r3 == 0) goto L_0x0094;
    L_0x0089:
        r2 = r11;
        r2 = (android.support.v7.view.menu.ActionMenuItemView) r2;
        r2 = r2.b();
        if (r2 == 0) goto L_0x0094;
    L_0x0092:
        r2 = 1;
        goto L_0x0095;
    L_0x0094:
        r2 = 0;
    L_0x0095:
        r8.e = r2;
        r2 = r8.a;
        if (r2 == 0) goto L_0x009d;
    L_0x009b:
        r2 = 1;
        goto L_0x009e;
    L_0x009d:
        r2 = r14;
    L_0x009e:
        r2 = a(r11, r9, r2, r6, r5);
        r3 = java.lang.Math.max(r15, r2);
        r13 = r8.d;
        if (r13 == 0) goto L_0x00ac;
    L_0x00aa:
        r16 = r16 + 1;
    L_0x00ac:
        r8 = r8.a;
        if (r8 == 0) goto L_0x00b1;
    L_0x00b0:
        r12 = 1;
    L_0x00b1:
        r14 = r14 - r2;
        r8 = r11.getMeasuredHeight();
        r10 = java.lang.Math.max(r10, r8);
        r8 = 1;
        if (r2 != r8) goto L_0x00c7;
    L_0x00bd:
        r2 = r8 << r4;
        r24 = r3;
        r2 = (long) r2;
        r2 = r19 | r2;
        r19 = r2;
        goto L_0x00c9;
    L_0x00c7:
        r24 = r3;
    L_0x00c9:
        r13 = r22;
        r15 = r24;
    L_0x00cd:
        r4 = r4 + 1;
        r3 = r21;
        r2 = r23;
        r8 = 0;
        goto L_0x0049;
    L_0x00d6:
        r23 = r2;
        r21 = r3;
        r2 = 2;
        if (r12 == 0) goto L_0x00e1;
    L_0x00dd:
        if (r13 != r2) goto L_0x00e1;
    L_0x00df:
        r3 = 1;
        goto L_0x00e2;
    L_0x00e1:
        r3 = 0;
    L_0x00e2:
        r4 = 0;
    L_0x00e3:
        r24 = 1;
        if (r16 <= 0) goto L_0x017e;
    L_0x00e7:
        if (r14 <= 0) goto L_0x017e;
    L_0x00e9:
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r11 = r5;
        r5 = 0;
        r8 = 0;
        r26 = 0;
    L_0x00f1:
        if (r5 >= r7) goto L_0x011f;
    L_0x00f3:
        r2 = r0.getChildAt(r5);
        r2 = r2.getLayoutParams();
        r2 = (android.support.v7.widget.ActionMenuView.c) r2;
        r28 = r4;
        r4 = r2.d;
        if (r4 != 0) goto L_0x0104;
    L_0x0103:
        goto L_0x0119;
    L_0x0104:
        r4 = r2.b;
        if (r4 >= r11) goto L_0x010f;
    L_0x0108:
        r2 = r2.b;
        r26 = r24 << r5;
        r11 = r2;
        r8 = 1;
        goto L_0x0119;
    L_0x010f:
        r2 = r2.b;
        if (r2 != r11) goto L_0x0119;
    L_0x0113:
        r29 = r24 << r5;
        r26 = r26 | r29;
        r8 = r8 + 1;
    L_0x0119:
        r5 = r5 + 1;
        r4 = r28;
        r2 = 2;
        goto L_0x00f1;
    L_0x011f:
        r28 = r4;
        r19 = r19 | r26;
        if (r8 <= r14) goto L_0x012c;
    L_0x0125:
        r32 = r6;
        r33 = r7;
        r31 = r10;
        goto L_0x0181;
    L_0x012c:
        r11 = r11 + 1;
        r2 = 0;
    L_0x012f:
        if (r2 >= r7) goto L_0x017a;
    L_0x0131:
        r4 = r0.getChildAt(r2);
        r5 = r4.getLayoutParams();
        r5 = (android.support.v7.widget.ActionMenuView.c) r5;
        r31 = r10;
        r8 = 1;
        r10 = r8 << r2;
        r32 = r6;
        r33 = r7;
        r6 = (long) r10;
        r24 = r26 & r6;
        r17 = 0;
        r8 = (r24 > r17 ? 1 : (r24 == r17 ? 0 : -1));
        if (r8 != 0) goto L_0x0154;
    L_0x014d:
        r4 = r5.b;
        if (r4 != r11) goto L_0x0171;
    L_0x0151:
        r19 = r19 | r6;
        goto L_0x0171;
    L_0x0154:
        if (r3 == 0) goto L_0x0167;
    L_0x0156:
        r6 = r5.e;
        if (r6 == 0) goto L_0x0167;
    L_0x015a:
        r6 = 1;
        if (r14 != r6) goto L_0x0168;
    L_0x015d:
        r7 = r0.l;
        r7 = r7 + r9;
        r8 = r0.l;
        r10 = 0;
        r4.setPadding(r7, r10, r8, r10);
        goto L_0x0168;
    L_0x0167:
        r6 = 1;
    L_0x0168:
        r4 = r5.b;
        r4 = r4 + r6;
        r5.b = r4;
        r5.f = r6;
        r14 = r14 + -1;
    L_0x0171:
        r2 = r2 + 1;
        r10 = r31;
        r6 = r32;
        r7 = r33;
        goto L_0x012f;
    L_0x017a:
        r2 = 2;
        r4 = 1;
        goto L_0x00e3;
    L_0x017e:
        r28 = r4;
        goto L_0x0125;
    L_0x0181:
        r2 = r19;
        if (r12 != 0) goto L_0x018a;
    L_0x0185:
        r4 = 1;
        if (r13 != r4) goto L_0x018b;
    L_0x0188:
        r5 = r4;
        goto L_0x018c;
    L_0x018a:
        r4 = 1;
    L_0x018b:
        r5 = 0;
    L_0x018c:
        if (r14 <= 0) goto L_0x0241;
    L_0x018e:
        r6 = 0;
        r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x0241;
    L_0x0194:
        r13 = r13 - r4;
        if (r14 < r13) goto L_0x019b;
    L_0x0197:
        if (r5 != 0) goto L_0x019b;
    L_0x0199:
        if (r15 <= r4) goto L_0x0241;
    L_0x019b:
        r4 = java.lang.Long.bitCount(r2);
        r4 = (float) r4;
        if (r5 != 0) goto L_0x01db;
    L_0x01a2:
        r5 = r2 & r24;
        r7 = 0;
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        if (r5 == 0) goto L_0x01bd;
    L_0x01ac:
        r5 = 0;
        r7 = r0.getChildAt(r5);
        r7 = r7.getLayoutParams();
        r7 = (android.support.v7.widget.ActionMenuView.c) r7;
        r7 = r7.e;
        if (r7 != 0) goto L_0x01be;
    L_0x01bb:
        r4 = r4 - r6;
        goto L_0x01be;
    L_0x01bd:
        r5 = 0;
    L_0x01be:
        r7 = r33 + -1;
        r8 = 1;
        r10 = r8 << r7;
        r10 = (long) r10;
        r10 = r10 & r2;
        r12 = 0;
        r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r8 == 0) goto L_0x01dc;
    L_0x01cb:
        r7 = r0.getChildAt(r7);
        r7 = r7.getLayoutParams();
        r7 = (android.support.v7.widget.ActionMenuView.c) r7;
        r7 = r7.e;
        if (r7 != 0) goto L_0x01dc;
    L_0x01d9:
        r4 = r4 - r6;
        goto L_0x01dc;
    L_0x01db:
        r5 = 0;
    L_0x01dc:
        r6 = 0;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x01e6;
    L_0x01e1:
        r14 = r14 * r9;
        r6 = (float) r14;
        r6 = r6 / r4;
        r8 = (int) r6;
        goto L_0x01e7;
    L_0x01e6:
        r8 = r5;
    L_0x01e7:
        r6 = r5;
        r11 = r28;
        r4 = r33;
    L_0x01ec:
        if (r6 >= r4) goto L_0x0246;
    L_0x01ee:
        r7 = 1;
        r10 = r7 << r6;
        r12 = (long) r10;
        r12 = r12 & r2;
        r14 = 0;
        r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r7 != 0) goto L_0x01fc;
    L_0x01f9:
        r7 = 1;
        r12 = 2;
        goto L_0x023e;
    L_0x01fc:
        r7 = r0.getChildAt(r6);
        r10 = r7.getLayoutParams();
        r10 = (android.support.v7.widget.ActionMenuView.c) r10;
        r7 = r7 instanceof android.support.v7.view.menu.ActionMenuItemView;
        if (r7 == 0) goto L_0x021f;
    L_0x020a:
        r10.c = r8;
        r7 = 1;
        r10.f = r7;
        if (r6 != 0) goto L_0x021b;
    L_0x0211:
        r7 = r10.e;
        if (r7 != 0) goto L_0x021b;
    L_0x0215:
        r7 = -r8;
        r12 = 2;
        r7 = r7 / r12;
        r10.leftMargin = r7;
        goto L_0x021c;
    L_0x021b:
        r12 = 2;
    L_0x021c:
        r7 = 1;
        r11 = 1;
        goto L_0x023e;
    L_0x021f:
        r12 = 2;
        r7 = r10.a;
        if (r7 == 0) goto L_0x022f;
    L_0x0224:
        r10.c = r8;
        r7 = 1;
        r10.f = r7;
        r11 = -r8;
        r11 = r11 / r12;
        r10.rightMargin = r11;
        r11 = r7;
        goto L_0x023e;
    L_0x022f:
        r7 = 1;
        if (r6 == 0) goto L_0x0236;
    L_0x0232:
        r13 = r8 / 2;
        r10.leftMargin = r13;
    L_0x0236:
        r13 = r4 + -1;
        if (r6 == r13) goto L_0x023e;
    L_0x023a:
        r13 = r8 / 2;
        r10.rightMargin = r13;
    L_0x023e:
        r6 = r6 + 1;
        goto L_0x01ec;
    L_0x0241:
        r4 = r33;
        r5 = 0;
        r11 = r28;
    L_0x0246:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r11 == 0) goto L_0x0271;
    L_0x024a:
        if (r5 >= r4) goto L_0x0271;
    L_0x024c:
        r3 = r0.getChildAt(r5);
        r6 = r3.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.c) r6;
        r7 = r6.f;
        if (r7 != 0) goto L_0x025d;
    L_0x025a:
        r7 = r32;
        goto L_0x026c;
    L_0x025d:
        r7 = r6.b;
        r7 = r7 * r9;
        r6 = r6.c;
        r7 = r7 + r6;
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r2);
        r7 = r32;
        r3.measure(r6, r7);
    L_0x026c:
        r5 = r5 + 1;
        r32 = r7;
        goto L_0x024a;
    L_0x0271:
        if (r1 == r2) goto L_0x0278;
    L_0x0273:
        r2 = r23;
        r1 = r31;
        goto L_0x027c;
    L_0x0278:
        r1 = r21;
        r2 = r23;
    L_0x027c:
        r0.setMeasuredDimension(r2, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuView.c(int, int):void");
    }

    /* renamed from: a */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected c generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return j();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.h <= 0) {
            cVar.h = 16;
        }
        return cVar;
    }

    public void a(h hVar) {
        this.c = hVar;
    }

    public void a(android.support.v7.view.menu.o.a aVar, android.support.v7.view.menu.h.a aVar2) {
        this.h = aVar;
        this.a = aVar2;
    }

    public boolean a() {
        return this.f;
    }

    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = 0 | ((a) childAt).d();
        }
        if (i > 0 && (childAt2 instanceof a)) {
            z |= ((a) childAt2).c();
        }
        return z;
    }

    public boolean a(j jVar) {
        return this.c.a((MenuItem) jVar, 0);
    }

    /* renamed from: b */
    protected c j() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    public c c() {
        c b = j();
        b.a = true;
        return b;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public h d() {
        return this.c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        return this.g != null && this.g.d();
    }

    public boolean f() {
        return this.g != null && this.g.e();
    }

    public boolean g() {
        return this.g != null && this.g.h();
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new h(context);
            this.c.a(new d());
            this.g = new c(context);
            this.g.c(true);
            this.g.a(this.h != null ? this.h : new b());
            this.c.a(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.c();
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        return this.g != null && this.g.i();
    }

    public void i() {
        if (this.g != null) {
            this.g.f();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.g != null) {
            this.g.b(false);
            if (this.g.h()) {
                this.g.e();
                this.g.d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.i) {
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = i3 - i;
            int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
            boolean a = bo.a(this);
            int i8 = paddingRight;
            int i9 = 0;
            int i10 = 0;
            for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
                View childAt = getChildAt(paddingRight);
                if (childAt.getVisibility() != 8) {
                    c cVar = (c) childAt.getLayoutParams();
                    if (cVar.a) {
                        int paddingLeft;
                        int i11;
                        i9 = childAt.getMeasuredWidth();
                        if (a(paddingRight)) {
                            i9 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = getPaddingLeft() + cVar.leftMargin;
                            i11 = paddingLeft + i9;
                        } else {
                            i11 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                            paddingLeft = i11 - i9;
                        }
                        i5 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i5, i11, measuredHeight + i5);
                        i8 -= i9;
                        i9 = 1;
                    } else {
                        i8 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                        boolean a2 = a(paddingRight);
                        i10++;
                    }
                }
            }
            if (childCount == 1 && i9 == 0) {
                View childAt2 = getChildAt(0);
                childCount = childAt2.getMeasuredWidth();
                dividerWidth = childAt2.getMeasuredHeight();
                i7 = (i7 / 2) - (childCount / 2);
                i6 -= dividerWidth / 2;
                childAt2.layout(i7, i6, childCount + i7, dividerWidth + i6);
                return;
            }
            i10 -= i9 ^ 1;
            if (i10 > 0) {
                i5 = i8 / i10;
                dividerWidth = 0;
            } else {
                dividerWidth = 0;
                i5 = 0;
            }
            i7 = Math.max(dividerWidth, i5);
            View childAt3;
            c cVar2;
            if (a) {
                paddingRight = getWidth() - getPaddingRight();
                while (dividerWidth < childCount) {
                    childAt3 = getChildAt(dividerWidth);
                    cVar2 = (c) childAt3.getLayoutParams();
                    if (!(childAt3.getVisibility() == 8 || cVar2.a)) {
                        paddingRight -= cVar2.rightMargin;
                        i9 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        i8 = i6 - (i10 / 2);
                        childAt3.layout(paddingRight - i9, i8, paddingRight, i10 + i8);
                        paddingRight -= (i9 + cVar2.leftMargin) + i7;
                    }
                    dividerWidth++;
                }
            } else {
                paddingRight = getPaddingLeft();
                while (dividerWidth < childCount) {
                    childAt3 = getChildAt(dividerWidth);
                    cVar2 = (c) childAt3.getLayoutParams();
                    if (!(childAt3.getVisibility() == 8 || cVar2.a)) {
                        paddingRight += cVar2.leftMargin;
                        i9 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        i8 = i6 - (i10 / 2);
                        childAt3.layout(paddingRight, i8, paddingRight + i9, i10 + i8);
                        paddingRight += (i9 + cVar2.rightMargin) + i7;
                    }
                    dividerWidth++;
                }
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.i;
        this.i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.i || this.c == null || size == this.j)) {
            this.j = size;
            this.c.b(true);
        }
        size = getChildCount();
        if (!this.i || size <= 0) {
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = (c) getChildAt(i3).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.d(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.b = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
                return;
            }
            this.d = new ContextThemeWrapper(getContext(), i);
        }
    }

    public void setPresenter(c cVar) {
        this.g = cVar;
        this.g.a(this);
    }
}
