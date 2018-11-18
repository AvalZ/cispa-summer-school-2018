package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class an extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public static class a extends MarginLayoutParams {
        public float g;
        public int h;

        public a(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public a(int i, int i2, float f) {
            super(i, i2);
            this.h = -1;
            this.g = f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }

    public an(Context context) {
        this(context, null);
    }

    public an(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public an(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        bg a = bg.a(context, attributeSet, j.LinearLayoutCompat, i, 0);
        int a2 = a.a(j.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.a(j.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.a(j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.g = a.a(j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a.a(j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a.a(j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.a(j.LinearLayoutCompat_divider));
        this.n = a.a(j.LinearLayoutCompat_showDividers, 0);
        this.o = a.e(j.LinearLayoutCompat_dividerPadding, 0);
        a.a();
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    int a(View view) {
        return 0;
    }

    int a(View view, int i) {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x032b  */
    /* JADX WARNING: Missing block: B:126:0x02e1, code:
            if (r15 > 0) goto L_0x02ef;
     */
    /* JADX WARNING: Missing block: B:129:0x02ec, code:
            if (r15 < 0) goto L_0x02ee;
     */
    /* JADX WARNING: Missing block: B:130:0x02ee, code:
            r15 = 0;
     */
    /* JADX WARNING: Missing block: B:131:0x02ef, code:
            r13.measure(r2, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
            r6 = android.view.View.combineMeasuredStates(r6, r13.getMeasuredState() & -256);
     */
    void a(int r41, int r42) {
        /*
        r40 = this;
        r7 = r40;
        r8 = r41;
        r9 = r42;
        r10 = 0;
        r7.f = r10;
        r11 = r40.getVirtualChildCount();
        r12 = android.view.View.MeasureSpec.getMode(r41);
        r13 = android.view.View.MeasureSpec.getMode(r42);
        r14 = r7.b;
        r15 = r7.h;
        r16 = 0;
        r17 = 1;
        r1 = r10;
        r2 = r1;
        r3 = r2;
        r4 = r3;
        r5 = r4;
        r6 = r5;
        r18 = r6;
        r20 = r18;
        r0 = r16;
        r19 = r17;
    L_0x002b:
        r10 = 8;
        r22 = r4;
        if (r6 >= r11) goto L_0x0199;
    L_0x0031:
        r4 = r7.b(r6);
        if (r4 != 0) goto L_0x0048;
    L_0x0037:
        r4 = r7.f;
        r10 = r7.d(r6);
        r4 = r4 + r10;
        r7.f = r4;
        r31 = r11;
        r28 = r13;
        r4 = r22;
        goto L_0x018f;
    L_0x0048:
        r24 = r1;
        r1 = r4.getVisibility();
        if (r1 != r10) goto L_0x005f;
    L_0x0050:
        r1 = r7.a(r4, r6);
        r6 = r6 + r1;
        r31 = r11;
        r28 = r13;
        r4 = r22;
        r1 = r24;
        goto L_0x018f;
    L_0x005f:
        r1 = r7.c(r6);
        if (r1 == 0) goto L_0x006c;
    L_0x0065:
        r1 = r7.f;
        r10 = r7.m;
        r1 = r1 + r10;
        r7.f = r1;
    L_0x006c:
        r1 = r4.getLayoutParams();
        r10 = r1;
        r10 = (android.support.v7.widget.an.a) r10;
        r1 = r10.g;
        r25 = r0 + r1;
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r13 != r1) goto L_0x00a7;
    L_0x007b:
        r0 = r10.height;
        if (r0 != 0) goto L_0x00a7;
    L_0x007f:
        r0 = r10.g;
        r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1));
        if (r0 <= 0) goto L_0x00a7;
    L_0x0085:
        r0 = r7.f;
        r1 = r10.topMargin;
        r1 = r1 + r0;
        r26 = r2;
        r2 = r10.bottomMargin;
        r1 = r1 + r2;
        r0 = java.lang.Math.max(r0, r1);
        r7.f = r0;
        r8 = r4;
        r34 = r5;
        r31 = r11;
        r28 = r13;
        r18 = r17;
        r32 = r22;
        r33 = r24;
        r30 = r26;
        r13 = r6;
        goto L_0x0113;
    L_0x00a7:
        r26 = r2;
        r0 = r10.height;
        if (r0 != 0) goto L_0x00b8;
    L_0x00ad:
        r0 = r10.g;
        r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1));
        if (r0 <= 0) goto L_0x00b8;
    L_0x00b3:
        r0 = -2;
        r10.height = r0;
        r2 = 0;
        goto L_0x00ba;
    L_0x00b8:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x00ba:
        r23 = 0;
        r0 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1));
        if (r0 != 0) goto L_0x00c5;
    L_0x00c0:
        r0 = r7.f;
        r27 = r0;
        goto L_0x00c7;
    L_0x00c5:
        r27 = 0;
    L_0x00c7:
        r0 = r7;
        r28 = r13;
        r13 = r24;
        r24 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = r4;
        r29 = r2;
        r30 = r26;
        r2 = r6;
        r31 = r11;
        r11 = r3;
        r3 = r8;
        r8 = r4;
        r33 = r13;
        r32 = r22;
        r13 = r24;
        r4 = r23;
        r34 = r5;
        r5 = r9;
        r13 = r6;
        r6 = r27;
        r0.a(r1, r2, r3, r4, r5, r6);
        r0 = r29;
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r0 == r1) goto L_0x00f2;
    L_0x00f0:
        r10.height = r0;
    L_0x00f2:
        r0 = r8.getMeasuredHeight();
        r1 = r7.f;
        r2 = r1 + r0;
        r3 = r10.topMargin;
        r2 = r2 + r3;
        r3 = r10.bottomMargin;
        r2 = r2 + r3;
        r3 = r7.b(r8);
        r2 = r2 + r3;
        r1 = java.lang.Math.max(r1, r2);
        r7.f = r1;
        if (r15 == 0) goto L_0x0112;
    L_0x010d:
        r3 = java.lang.Math.max(r0, r11);
        goto L_0x0113;
    L_0x0112:
        r3 = r11;
    L_0x0113:
        if (r14 < 0) goto L_0x011d;
    L_0x0115:
        r6 = r13 + 1;
        if (r14 != r6) goto L_0x011d;
    L_0x0119:
        r0 = r7.f;
        r7.c = r0;
    L_0x011d:
        if (r13 >= r14) goto L_0x012d;
    L_0x011f:
        r0 = r10.g;
        r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1));
        if (r0 <= 0) goto L_0x012d;
    L_0x0125:
        r0 = new java.lang.RuntimeException;
        r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.";
        r0.<init>(r1);
        throw r0;
    L_0x012d:
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 == r0) goto L_0x013b;
    L_0x0131:
        r0 = r10.width;
        r1 = -1;
        if (r0 != r1) goto L_0x013b;
    L_0x0136:
        r0 = r17;
        r20 = r0;
        goto L_0x013c;
    L_0x013b:
        r0 = 0;
    L_0x013c:
        r1 = r10.leftMargin;
        r2 = r10.rightMargin;
        r1 = r1 + r2;
        r2 = r8.getMeasuredWidth();
        r2 = r2 + r1;
        r4 = r30;
        r4 = java.lang.Math.max(r4, r2);
        r5 = r8.getMeasuredState();
        r6 = r33;
        r5 = android.view.View.combineMeasuredStates(r6, r5);
        if (r19 == 0) goto L_0x0160;
    L_0x0158:
        r6 = r10.width;
        r11 = -1;
        if (r6 != r11) goto L_0x0160;
    L_0x015d:
        r6 = r17;
        goto L_0x0161;
    L_0x0160:
        r6 = 0;
    L_0x0161:
        r10 = r10.g;
        r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r10 <= 0) goto L_0x0176;
    L_0x0167:
        if (r0 == 0) goto L_0x016c;
    L_0x0169:
        r10 = r32;
        goto L_0x016e;
    L_0x016c:
        r1 = r2;
        goto L_0x0169;
    L_0x016e:
        r0 = java.lang.Math.max(r10, r1);
        r10 = r0;
        r0 = r34;
        goto L_0x0181;
    L_0x0176:
        r10 = r32;
        if (r0 == 0) goto L_0x017b;
    L_0x017a:
        r2 = r1;
    L_0x017b:
        r1 = r34;
        r0 = java.lang.Math.max(r1, r2);
    L_0x0181:
        r1 = r7.a(r8, r13);
        r1 = r1 + r13;
        r2 = r4;
        r19 = r6;
        r4 = r10;
        r6 = r1;
        r1 = r5;
        r5 = r0;
        r0 = r25;
    L_0x018f:
        r6 = r6 + 1;
        r13 = r28;
        r11 = r31;
        r8 = r41;
        goto L_0x002b;
    L_0x0199:
        r6 = r1;
        r4 = r2;
        r1 = r5;
        r31 = r11;
        r28 = r13;
        r2 = r22;
        r11 = r3;
        r3 = r7.f;
        if (r3 <= 0) goto L_0x01b7;
    L_0x01a7:
        r3 = r31;
        r5 = r7.c(r3);
        if (r5 == 0) goto L_0x01b9;
    L_0x01af:
        r5 = r7.f;
        r8 = r7.m;
        r5 = r5 + r8;
        r7.f = r5;
        goto L_0x01b9;
    L_0x01b7:
        r3 = r31;
    L_0x01b9:
        if (r15 == 0) goto L_0x0212;
    L_0x01bb:
        r5 = r28;
        r8 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r5 == r8) goto L_0x01c7;
    L_0x01c1:
        if (r5 != 0) goto L_0x01c4;
    L_0x01c3:
        goto L_0x01c7;
    L_0x01c4:
        r35 = r4;
        goto L_0x0216;
    L_0x01c7:
        r8 = 0;
        r7.f = r8;
        r8 = 0;
    L_0x01cb:
        if (r8 >= r3) goto L_0x01c4;
    L_0x01cd:
        r13 = r7.b(r8);
        if (r13 != 0) goto L_0x01dd;
    L_0x01d3:
        r13 = r7.f;
        r14 = r7.d(r8);
        r13 = r13 + r14;
        r7.f = r13;
        goto L_0x01e8;
    L_0x01dd:
        r14 = r13.getVisibility();
        if (r14 != r10) goto L_0x01eb;
    L_0x01e3:
        r13 = r7.a(r13, r8);
        r8 = r8 + r13;
    L_0x01e8:
        r35 = r4;
        goto L_0x020b;
    L_0x01eb:
        r14 = r13.getLayoutParams();
        r14 = (android.support.v7.widget.an.a) r14;
        r10 = r7.f;
        r21 = r10 + r11;
        r35 = r4;
        r4 = r14.topMargin;
        r21 = r21 + r4;
        r4 = r14.bottomMargin;
        r21 = r21 + r4;
        r4 = r7.b(r13);
        r4 = r21 + r4;
        r4 = java.lang.Math.max(r10, r4);
        r7.f = r4;
    L_0x020b:
        r8 = r8 + 1;
        r4 = r35;
        r10 = 8;
        goto L_0x01cb;
    L_0x0212:
        r35 = r4;
        r5 = r28;
    L_0x0216:
        r4 = r7.f;
        r8 = r40.getPaddingTop();
        r10 = r40.getPaddingBottom();
        r8 = r8 + r10;
        r4 = r4 + r8;
        r7.f = r4;
        r4 = r7.f;
        r8 = r40.getSuggestedMinimumHeight();
        r4 = java.lang.Math.max(r4, r8);
        r8 = 0;
        r4 = android.view.View.resolveSizeAndState(r4, r9, r8);
        r8 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r8 = r8 & r4;
        r10 = r7.f;
        r8 = r8 - r10;
        if (r18 != 0) goto L_0x0285;
    L_0x023c:
        if (r8 == 0) goto L_0x0243;
    L_0x023e:
        r10 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1));
        if (r10 <= 0) goto L_0x0243;
    L_0x0242:
        goto L_0x0285;
    L_0x0243:
        r0 = java.lang.Math.max(r1, r2);
        if (r15 == 0) goto L_0x027f;
    L_0x0249:
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r5 == r1) goto L_0x027f;
    L_0x024d:
        r1 = 0;
    L_0x024e:
        if (r1 >= r3) goto L_0x027f;
    L_0x0250:
        r2 = r7.b(r1);
        if (r2 == 0) goto L_0x027c;
    L_0x0256:
        r5 = r2.getVisibility();
        r8 = 8;
        if (r5 != r8) goto L_0x025f;
    L_0x025e:
        goto L_0x027c;
    L_0x025f:
        r5 = r2.getLayoutParams();
        r5 = (android.support.v7.widget.an.a) r5;
        r5 = r5.g;
        r5 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1));
        if (r5 <= 0) goto L_0x027c;
    L_0x026b:
        r5 = r2.getMeasuredWidth();
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8);
        r10 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r8);
        r2.measure(r5, r10);
    L_0x027c:
        r1 = r1 + 1;
        goto L_0x024e;
    L_0x027f:
        r1 = r35;
        r11 = r41;
        goto L_0x0371;
    L_0x0285:
        r2 = r7.g;
        r2 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1));
        if (r2 <= 0) goto L_0x028d;
    L_0x028b:
        r0 = r7.g;
    L_0x028d:
        r2 = 0;
        r7.f = r2;
        r11 = r0;
        r0 = r2;
        r10 = r8;
        r8 = r1;
        r1 = r35;
    L_0x0296:
        if (r0 >= r3) goto L_0x0360;
    L_0x0298:
        r13 = r7.b(r0);
        r14 = r13.getVisibility();
        r15 = 8;
        if (r14 != r15) goto L_0x02aa;
    L_0x02a4:
        r37 = r11;
        r11 = r41;
        goto L_0x0359;
    L_0x02aa:
        r14 = r13.getLayoutParams();
        r14 = (android.support.v7.widget.an.a) r14;
        r2 = r14.g;
        r18 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1));
        if (r18 <= 0) goto L_0x0301;
    L_0x02b6:
        r15 = (float) r10;
        r15 = r15 * r2;
        r15 = r15 / r11;
        r15 = (int) r15;
        r11 = r11 - r2;
        r10 = r10 - r15;
        r2 = r40.getPaddingLeft();
        r18 = r40.getPaddingRight();
        r2 = r2 + r18;
        r36 = r10;
        r10 = r14.leftMargin;
        r2 = r2 + r10;
        r10 = r14.rightMargin;
        r2 = r2 + r10;
        r10 = r14.width;
        r37 = r11;
        r11 = r41;
        r2 = getChildMeasureSpec(r11, r2, r10);
        r10 = r14.height;
        if (r10 != 0) goto L_0x02e4;
    L_0x02dc:
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r5 == r10) goto L_0x02e1;
    L_0x02e0:
        goto L_0x02e6;
    L_0x02e1:
        if (r15 <= 0) goto L_0x02ee;
    L_0x02e3:
        goto L_0x02ef;
    L_0x02e4:
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x02e6:
        r18 = r13.getMeasuredHeight();
        r15 = r18 + r15;
        if (r15 >= 0) goto L_0x02ef;
    L_0x02ee:
        r15 = 0;
    L_0x02ef:
        r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10);
        r13.measure(r2, r15);
        r2 = r13.getMeasuredState();
        r2 = r2 & -256;
        r6 = android.view.View.combineMeasuredStates(r6, r2);
        goto L_0x0308;
    L_0x0301:
        r2 = r11;
        r11 = r41;
        r37 = r2;
        r36 = r10;
    L_0x0308:
        r2 = r14.leftMargin;
        r10 = r14.rightMargin;
        r2 = r2 + r10;
        r10 = r13.getMeasuredWidth();
        r10 = r10 + r2;
        r1 = java.lang.Math.max(r1, r10);
        r15 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 == r15) goto L_0x0324;
    L_0x031a:
        r15 = r14.width;
        r38 = r1;
        r1 = -1;
        if (r15 != r1) goto L_0x0327;
    L_0x0321:
        r15 = r17;
        goto L_0x0328;
    L_0x0324:
        r38 = r1;
        r1 = -1;
    L_0x0327:
        r15 = 0;
    L_0x0328:
        if (r15 == 0) goto L_0x032b;
    L_0x032a:
        goto L_0x032c;
    L_0x032b:
        r2 = r10;
    L_0x032c:
        r2 = java.lang.Math.max(r8, r2);
        if (r19 == 0) goto L_0x0339;
    L_0x0332:
        r8 = r14.width;
        if (r8 != r1) goto L_0x0339;
    L_0x0336:
        r8 = r17;
        goto L_0x033a;
    L_0x0339:
        r8 = 0;
    L_0x033a:
        r10 = r7.f;
        r15 = r13.getMeasuredHeight();
        r15 = r15 + r10;
        r1 = r14.topMargin;
        r15 = r15 + r1;
        r1 = r14.bottomMargin;
        r15 = r15 + r1;
        r1 = r7.b(r13);
        r15 = r15 + r1;
        r1 = java.lang.Math.max(r10, r15);
        r7.f = r1;
        r19 = r8;
        r10 = r36;
        r1 = r38;
        r8 = r2;
    L_0x0359:
        r0 = r0 + 1;
        r11 = r37;
        r2 = 0;
        goto L_0x0296;
    L_0x0360:
        r11 = r41;
        r0 = r7.f;
        r2 = r40.getPaddingTop();
        r5 = r40.getPaddingBottom();
        r2 = r2 + r5;
        r0 = r0 + r2;
        r7.f = r0;
        r0 = r8;
    L_0x0371:
        if (r19 != 0) goto L_0x0378;
    L_0x0373:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 == r2) goto L_0x0378;
    L_0x0377:
        goto L_0x0379;
    L_0x0378:
        r0 = r1;
    L_0x0379:
        r1 = r40.getPaddingLeft();
        r2 = r40.getPaddingRight();
        r1 = r1 + r2;
        r0 = r0 + r1;
        r1 = r40.getSuggestedMinimumWidth();
        r0 = java.lang.Math.max(r0, r1);
        r0 = android.view.View.resolveSizeAndState(r0, r11, r6);
        r7.setMeasuredDimension(r0, r4);
        if (r20 == 0) goto L_0x0397;
    L_0x0394:
        r7.c(r3, r9);
    L_0x0397:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.an.a(int, int):void");
    }

    void a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        i5 = this.e & 112;
        int i6 = this.e & 8388615;
        int paddingTop = i5 != 16 ? i5 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.f : (((i4 - i2) - this.f) / 2) + getPaddingTop();
        int i7 = 0;
        while (i7 < virtualChildCount) {
            int i8;
            View b = b(i7);
            if (b == null) {
                paddingTop += d(i7);
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                i8 = aVar.h;
                if (i8 < 0) {
                    i8 = i6;
                }
                i8 = d.a(i8, r.e(this)) & 7;
                if (i8 == 1) {
                    i8 = (((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin;
                    i8 -= aVar.rightMargin;
                } else if (i8 != 5) {
                    i8 = aVar.leftMargin + paddingLeft;
                } else {
                    i8 = paddingRight - measuredWidth;
                    i8 -= aVar.rightMargin;
                }
                i5 = i8;
                if (c(i7)) {
                    paddingTop += this.m;
                }
                int i9 = paddingTop + aVar.topMargin;
                a aVar2 = aVar;
                a(b, i5, i9 + a(b), measuredWidth, measuredHeight);
                i7 += a(b, i7);
                paddingTop = i9 + ((measuredHeight + aVar2.bottomMargin) + b(b));
                i8 = 1;
                i7 += i8;
            }
            i8 = 1;
            i7 += i8;
        }
    }

    void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = b(i);
            if (!(b == null || b.getVisibility() == 8 || !c(i))) {
                a(canvas, (b.getTop() - ((a) b.getLayoutParams()).topMargin) - this.m);
            }
            i++;
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 == null) {
                virtualChildCount = (getHeight() - getPaddingBottom()) - this.m;
            } else {
                virtualChildCount = b2.getBottom() + ((a) b2.getLayoutParams()).bottomMargin;
            }
            a(canvas, virtualChildCount);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int b(View view) {
        return 0;
    }

    /* renamed from: b */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* renamed from: b */
    protected a generateLayoutParams(LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    View b(int i) {
        return getChildAt(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0433  */
    /* JADX WARNING: Missing block: B:156:0x039e, code:
            if (r4 > 0) goto L_0x03ac;
     */
    /* JADX WARNING: Missing block: B:159:0x03a9, code:
            if (r4 < 0) goto L_0x03ab;
     */
    /* JADX WARNING: Missing block: B:160:0x03ab, code:
            r4 = 0;
     */
    /* JADX WARNING: Missing block: B:161:0x03ac, code:
            r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r4, r9), r2);
            r6 = android.view.View.combineMeasuredStates(r6, r14.getMeasuredState() & -16777216);
            r2 = r37;
            r4 = r38;
     */
    void b(int r42, int r43) {
        /*
        r41 = this;
        r7 = r41;
        r8 = r42;
        r9 = r43;
        r10 = 0;
        r7.f = r10;
        r11 = r41.getVirtualChildCount();
        r12 = android.view.View.MeasureSpec.getMode(r42);
        r13 = android.view.View.MeasureSpec.getMode(r43);
        r0 = r7.i;
        r14 = 4;
        if (r0 == 0) goto L_0x001e;
    L_0x001a:
        r0 = r7.j;
        if (r0 != 0) goto L_0x0026;
    L_0x001e:
        r0 = new int[r14];
        r7.i = r0;
        r0 = new int[r14];
        r7.j = r0;
    L_0x0026:
        r15 = r7.i;
        r6 = r7.j;
        r16 = 3;
        r5 = -1;
        r15[r16] = r5;
        r17 = 2;
        r15[r17] = r5;
        r18 = 1;
        r15[r18] = r5;
        r15[r10] = r5;
        r6[r16] = r5;
        r6[r17] = r5;
        r6[r18] = r5;
        r6[r10] = r5;
        r4 = r7.a;
        r3 = r7.h;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 != r2) goto L_0x004c;
    L_0x0049:
        r19 = r18;
        goto L_0x004e;
    L_0x004c:
        r19 = r10;
    L_0x004e:
        r20 = 0;
        r1 = r10;
        r14 = r1;
        r21 = r14;
        r22 = r21;
        r23 = r22;
        r24 = r23;
        r25 = r24;
        r27 = r25;
        r26 = r18;
        r0 = r20;
    L_0x0062:
        r28 = r6;
        r5 = 8;
        if (r1 >= r11) goto L_0x0201;
    L_0x0068:
        r6 = r7.b(r1);
        if (r6 != 0) goto L_0x0081;
    L_0x006e:
        r5 = r7.f;
        r6 = r7.d(r1);
        r5 = r5 + r6;
        r7.f = r5;
    L_0x0077:
        r30 = r0;
        r0 = r1;
        r1 = r2;
        r31 = r3;
        r35 = r4;
        goto L_0x01ed;
    L_0x0081:
        r10 = r6.getVisibility();
        if (r10 != r5) goto L_0x008d;
    L_0x0087:
        r5 = r7.a(r6, r1);
        r1 = r1 + r5;
        goto L_0x0077;
    L_0x008d:
        r5 = r7.c(r1);
        if (r5 == 0) goto L_0x009a;
    L_0x0093:
        r5 = r7.f;
        r10 = r7.l;
        r5 = r5 + r10;
        r7.f = r5;
    L_0x009a:
        r5 = r6.getLayoutParams();
        r10 = r5;
        r10 = (android.support.v7.widget.an.a) r10;
        r5 = r10.g;
        r30 = r0 + r5;
        if (r12 != r2) goto L_0x00ef;
    L_0x00a7:
        r0 = r10.width;
        if (r0 != 0) goto L_0x00ef;
    L_0x00ab:
        r0 = r10.g;
        r0 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1));
        if (r0 <= 0) goto L_0x00ef;
    L_0x00b1:
        if (r19 == 0) goto L_0x00be;
    L_0x00b3:
        r0 = r7.f;
        r5 = r10.leftMargin;
        r2 = r10.rightMargin;
        r5 = r5 + r2;
        r0 = r0 + r5;
    L_0x00bb:
        r7.f = r0;
        goto L_0x00cb;
    L_0x00be:
        r0 = r7.f;
        r2 = r10.leftMargin;
        r2 = r2 + r0;
        r5 = r10.rightMargin;
        r2 = r2 + r5;
        r0 = java.lang.Math.max(r0, r2);
        goto L_0x00bb;
    L_0x00cb:
        if (r4 == 0) goto L_0x00e0;
    L_0x00cd:
        r0 = 0;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0);
        r6.measure(r2, r2);
        r33 = r1;
        r31 = r3;
        r35 = r4;
        r8 = r6;
        r29 = -2;
        goto L_0x0160;
    L_0x00e0:
        r33 = r1;
        r31 = r3;
        r35 = r4;
        r8 = r6;
        r22 = r18;
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r29 = -2;
        goto L_0x0162;
    L_0x00ef:
        r0 = r10.width;
        if (r0 != 0) goto L_0x00fe;
    L_0x00f3:
        r0 = r10.g;
        r0 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1));
        if (r0 <= 0) goto L_0x00fe;
    L_0x00f9:
        r5 = -2;
        r10.width = r5;
        r2 = 0;
        goto L_0x0101;
    L_0x00fe:
        r5 = -2;
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x0101:
        r0 = (r30 > r20 ? 1 : (r30 == r20 ? 0 : -1));
        if (r0 != 0) goto L_0x010a;
    L_0x0105:
        r0 = r7.f;
        r29 = r0;
        goto L_0x010c;
    L_0x010a:
        r29 = 0;
    L_0x010c:
        r32 = 0;
        r0 = r7;
        r33 = r1;
        r1 = r6;
        r34 = r2;
        r2 = r33;
        r31 = r3;
        r3 = r8;
        r35 = r4;
        r4 = r29;
        r29 = r5;
        r8 = -1;
        r5 = r9;
        r8 = r6;
        r9 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r6 = r32;
        r0.a(r1, r2, r3, r4, r5, r6);
        r0 = r34;
        if (r0 == r9) goto L_0x012f;
    L_0x012d:
        r10.width = r0;
    L_0x012f:
        r0 = r8.getMeasuredWidth();
        if (r19 == 0) goto L_0x0146;
    L_0x0135:
        r1 = r7.f;
        r2 = r10.leftMargin;
        r2 = r2 + r0;
        r3 = r10.rightMargin;
        r2 = r2 + r3;
        r3 = r7.b(r8);
        r2 = r2 + r3;
        r1 = r1 + r2;
    L_0x0143:
        r7.f = r1;
        goto L_0x015a;
    L_0x0146:
        r1 = r7.f;
        r2 = r1 + r0;
        r3 = r10.leftMargin;
        r2 = r2 + r3;
        r3 = r10.rightMargin;
        r2 = r2 + r3;
        r3 = r7.b(r8);
        r2 = r2 + r3;
        r1 = java.lang.Math.max(r1, r2);
        goto L_0x0143;
    L_0x015a:
        if (r31 == 0) goto L_0x0160;
    L_0x015c:
        r14 = java.lang.Math.max(r0, r14);
    L_0x0160:
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x0162:
        if (r13 == r1) goto L_0x016e;
    L_0x0164:
        r0 = r10.height;
        r2 = -1;
        if (r0 != r2) goto L_0x016e;
    L_0x0169:
        r0 = r18;
        r27 = r0;
        goto L_0x016f;
    L_0x016e:
        r0 = 0;
    L_0x016f:
        r2 = r10.topMargin;
        r3 = r10.bottomMargin;
        r2 = r2 + r3;
        r3 = r8.getMeasuredHeight();
        r3 = r3 + r2;
        r4 = r8.getMeasuredState();
        r6 = r25;
        r4 = android.view.View.combineMeasuredStates(r6, r4);
        if (r35 == 0) goto L_0x01af;
    L_0x0185:
        r5 = r8.getBaseline();
        r6 = -1;
        if (r5 == r6) goto L_0x01af;
    L_0x018c:
        r6 = r10.h;
        if (r6 >= 0) goto L_0x0193;
    L_0x0190:
        r6 = r7.e;
        goto L_0x0195;
    L_0x0193:
        r6 = r10.h;
    L_0x0195:
        r6 = r6 & 112;
        r9 = 4;
        r6 = r6 >> r9;
        r6 = r6 & -2;
        r6 = r6 >> 1;
        r9 = r15[r6];
        r9 = java.lang.Math.max(r9, r5);
        r15[r6] = r9;
        r9 = r28[r6];
        r5 = r3 - r5;
        r5 = java.lang.Math.max(r9, r5);
        r28[r6] = r5;
    L_0x01af:
        r5 = r21;
        r5 = java.lang.Math.max(r5, r3);
        if (r26 == 0) goto L_0x01bf;
    L_0x01b7:
        r6 = r10.height;
        r9 = -1;
        if (r6 != r9) goto L_0x01bf;
    L_0x01bc:
        r6 = r18;
        goto L_0x01c0;
    L_0x01bf:
        r6 = 0;
    L_0x01c0:
        r9 = r10.g;
        r9 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1));
        if (r9 <= 0) goto L_0x01d4;
    L_0x01c6:
        if (r0 == 0) goto L_0x01cb;
    L_0x01c8:
        r10 = r24;
        goto L_0x01cd;
    L_0x01cb:
        r2 = r3;
        goto L_0x01c8;
    L_0x01cd:
        r24 = java.lang.Math.max(r10, r2);
    L_0x01d1:
        r10 = r33;
        goto L_0x01e2;
    L_0x01d4:
        r10 = r24;
        if (r0 == 0) goto L_0x01d9;
    L_0x01d8:
        r3 = r2;
    L_0x01d9:
        r2 = r23;
        r23 = java.lang.Math.max(r2, r3);
        r24 = r10;
        goto L_0x01d1;
    L_0x01e2:
        r0 = r7.a(r8, r10);
        r0 = r0 + r10;
        r25 = r4;
        r21 = r5;
        r26 = r6;
    L_0x01ed:
        r0 = r0 + 1;
        r2 = r1;
        r6 = r28;
        r3 = r31;
        r4 = r35;
        r5 = -1;
        r8 = r42;
        r9 = r43;
        r10 = 0;
        r1 = r0;
        r0 = r30;
        goto L_0x0062;
    L_0x0201:
        r1 = r2;
        r31 = r3;
        r35 = r4;
        r3 = r21;
        r2 = r23;
        r10 = r24;
        r6 = r25;
        r9 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r29 = -2;
        r4 = r7.f;
        if (r4 <= 0) goto L_0x0223;
    L_0x0216:
        r4 = r7.c(r11);
        if (r4 == 0) goto L_0x0223;
    L_0x021c:
        r4 = r7.f;
        r8 = r7.l;
        r4 = r4 + r8;
        r7.f = r4;
    L_0x0223:
        r4 = r15[r18];
        r8 = -1;
        if (r4 != r8) goto L_0x0235;
    L_0x0228:
        r4 = 0;
        r1 = r15[r4];
        if (r1 != r8) goto L_0x0235;
    L_0x022d:
        r1 = r15[r17];
        if (r1 != r8) goto L_0x0235;
    L_0x0231:
        r1 = r15[r16];
        if (r1 == r8) goto L_0x0265;
    L_0x0235:
        r1 = r15[r16];
        r4 = 0;
        r8 = r15[r4];
        r5 = r15[r18];
        r9 = r15[r17];
        r5 = java.lang.Math.max(r5, r9);
        r5 = java.lang.Math.max(r8, r5);
        r1 = java.lang.Math.max(r1, r5);
        r5 = r28[r16];
        r8 = r28[r4];
        r4 = r28[r18];
        r9 = r28[r17];
        r4 = java.lang.Math.max(r4, r9);
        r4 = java.lang.Math.max(r8, r4);
        r4 = java.lang.Math.max(r5, r4);
        r1 = r1 + r4;
        r21 = java.lang.Math.max(r3, r1);
        r3 = r21;
    L_0x0265:
        if (r31 == 0) goto L_0x02c6;
    L_0x0267:
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r12 == r1) goto L_0x026d;
    L_0x026b:
        if (r12 != 0) goto L_0x02c6;
    L_0x026d:
        r1 = 0;
        r7.f = r1;
        r1 = 0;
    L_0x0271:
        if (r1 >= r11) goto L_0x02c6;
    L_0x0273:
        r4 = r7.b(r1);
        if (r4 != 0) goto L_0x0283;
    L_0x0279:
        r4 = r7.f;
        r5 = r7.d(r1);
        r4 = r4 + r5;
        r7.f = r4;
        goto L_0x0290;
    L_0x0283:
        r5 = r4.getVisibility();
        r8 = 8;
        if (r5 != r8) goto L_0x0293;
    L_0x028b:
        r4 = r7.a(r4, r1);
        r1 = r1 + r4;
    L_0x0290:
        r36 = r1;
        goto L_0x02c3;
    L_0x0293:
        r5 = r4.getLayoutParams();
        r5 = (android.support.v7.widget.an.a) r5;
        if (r19 == 0) goto L_0x02ac;
    L_0x029b:
        r8 = r7.f;
        r9 = r5.leftMargin;
        r9 = r9 + r14;
        r5 = r5.rightMargin;
        r9 = r9 + r5;
        r4 = r7.b(r4);
        r9 = r9 + r4;
        r8 = r8 + r9;
        r7.f = r8;
        goto L_0x0290;
    L_0x02ac:
        r8 = r7.f;
        r9 = r8 + r14;
        r36 = r1;
        r1 = r5.leftMargin;
        r9 = r9 + r1;
        r1 = r5.rightMargin;
        r9 = r9 + r1;
        r1 = r7.b(r4);
        r9 = r9 + r1;
        r1 = java.lang.Math.max(r8, r9);
        r7.f = r1;
    L_0x02c3:
        r1 = r36 + 1;
        goto L_0x0271;
    L_0x02c6:
        r1 = r7.f;
        r4 = r41.getPaddingLeft();
        r5 = r41.getPaddingRight();
        r4 = r4 + r5;
        r1 = r1 + r4;
        r7.f = r1;
        r1 = r7.f;
        r4 = r41.getSuggestedMinimumWidth();
        r1 = java.lang.Math.max(r1, r4);
        r4 = r42;
        r5 = 0;
        r8 = -1;
        r1 = android.view.View.resolveSizeAndState(r1, r4, r5);
        r5 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r5 = r5 & r1;
        r9 = r7.f;
        r5 = r5 - r9;
        if (r22 != 0) goto L_0x0336;
    L_0x02ef:
        if (r5 == 0) goto L_0x02f6;
    L_0x02f1:
        r21 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1));
        if (r21 <= 0) goto L_0x02f6;
    L_0x02f5:
        goto L_0x0336;
    L_0x02f6:
        r0 = java.lang.Math.max(r2, r10);
        if (r31 == 0) goto L_0x0332;
    L_0x02fc:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 == r2) goto L_0x0332;
    L_0x0300:
        r2 = 0;
    L_0x0301:
        if (r2 >= r11) goto L_0x0332;
    L_0x0303:
        r5 = r7.b(r2);
        if (r5 == 0) goto L_0x032f;
    L_0x0309:
        r8 = r5.getVisibility();
        r10 = 8;
        if (r8 != r10) goto L_0x0312;
    L_0x0311:
        goto L_0x032f;
    L_0x0312:
        r8 = r5.getLayoutParams();
        r8 = (android.support.v7.widget.an.a) r8;
        r8 = r8.g;
        r8 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1));
        if (r8 <= 0) goto L_0x032f;
    L_0x031e:
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r10 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r8);
        r12 = r5.getMeasuredHeight();
        r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r8);
        r5.measure(r10, r12);
    L_0x032f:
        r2 = r2 + 1;
        goto L_0x0301;
    L_0x0332:
        r5 = r43;
        goto L_0x04c7;
    L_0x0336:
        r3 = r7.g;
        r3 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1));
        if (r3 <= 0) goto L_0x033e;
    L_0x033c:
        r0 = r7.g;
    L_0x033e:
        r15[r16] = r8;
        r15[r17] = r8;
        r15[r18] = r8;
        r3 = 0;
        r15[r3] = r8;
        r28[r16] = r8;
        r28[r17] = r8;
        r28[r18] = r8;
        r28[r3] = r8;
        r7.f = r3;
        r10 = r2;
        r3 = r8;
        r2 = r0;
        r0 = 0;
    L_0x0355:
        if (r0 >= r11) goto L_0x0475;
    L_0x0357:
        r14 = r7.b(r0);
        if (r14 == 0) goto L_0x0468;
    L_0x035d:
        r8 = r14.getVisibility();
        r9 = 8;
        if (r8 != r9) goto L_0x0367;
    L_0x0365:
        goto L_0x0468;
    L_0x0367:
        r8 = r14.getLayoutParams();
        r8 = (android.support.v7.widget.an.a) r8;
        r9 = r8.g;
        r21 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1));
        if (r21 <= 0) goto L_0x03c3;
    L_0x0373:
        r4 = (float) r5;
        r4 = r4 * r9;
        r4 = r4 / r2;
        r4 = (int) r4;
        r2 = r2 - r9;
        r5 = r5 - r4;
        r9 = r41.getPaddingTop();
        r21 = r41.getPaddingBottom();
        r9 = r9 + r21;
        r37 = r2;
        r2 = r8.topMargin;
        r9 = r9 + r2;
        r2 = r8.bottomMargin;
        r9 = r9 + r2;
        r2 = r8.height;
        r38 = r5;
        r5 = r43;
        r2 = getChildMeasureSpec(r5, r9, r2);
        r9 = r8.width;
        if (r9 != 0) goto L_0x03a1;
    L_0x0399:
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 == r9) goto L_0x039e;
    L_0x039d:
        goto L_0x03a3;
    L_0x039e:
        if (r4 <= 0) goto L_0x03ab;
    L_0x03a0:
        goto L_0x03ac;
    L_0x03a1:
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x03a3:
        r21 = r14.getMeasuredWidth();
        r4 = r21 + r4;
        if (r4 >= 0) goto L_0x03ac;
    L_0x03ab:
        r4 = 0;
    L_0x03ac:
        r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r9);
        r14.measure(r4, r2);
        r2 = r14.getMeasuredState();
        r4 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r2 = r2 & r4;
        r6 = android.view.View.combineMeasuredStates(r6, r2);
        r2 = r37;
        r4 = r38;
        goto L_0x03c6;
    L_0x03c3:
        r4 = r5;
        r5 = r43;
    L_0x03c6:
        if (r19 == 0) goto L_0x03e7;
    L_0x03c8:
        r9 = r7.f;
        r21 = r14.getMeasuredWidth();
        r39 = r2;
        r2 = r8.leftMargin;
        r21 = r21 + r2;
        r2 = r8.rightMargin;
        r21 = r21 + r2;
        r2 = r7.b(r14);
        r21 = r21 + r2;
        r9 = r9 + r21;
        r7.f = r9;
        r40 = r4;
    L_0x03e4:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x0404;
    L_0x03e7:
        r39 = r2;
        r2 = r7.f;
        r9 = r14.getMeasuredWidth();
        r9 = r9 + r2;
        r40 = r4;
        r4 = r8.leftMargin;
        r9 = r9 + r4;
        r4 = r8.rightMargin;
        r9 = r9 + r4;
        r4 = r7.b(r14);
        r9 = r9 + r4;
        r2 = java.lang.Math.max(r2, r9);
        r7.f = r2;
        goto L_0x03e4;
    L_0x0404:
        if (r13 == r2) goto L_0x040e;
    L_0x0406:
        r2 = r8.height;
        r4 = -1;
        if (r2 != r4) goto L_0x040e;
    L_0x040b:
        r2 = r18;
        goto L_0x040f;
    L_0x040e:
        r2 = 0;
    L_0x040f:
        r4 = r8.topMargin;
        r9 = r8.bottomMargin;
        r4 = r4 + r9;
        r9 = r14.getMeasuredHeight();
        r9 = r9 + r4;
        r3 = java.lang.Math.max(r3, r9);
        if (r2 == 0) goto L_0x0420;
    L_0x041f:
        goto L_0x0421;
    L_0x0420:
        r4 = r9;
    L_0x0421:
        r2 = java.lang.Math.max(r10, r4);
        if (r26 == 0) goto L_0x042f;
    L_0x0427:
        r4 = r8.height;
        r10 = -1;
        if (r4 != r10) goto L_0x0430;
    L_0x042c:
        r4 = r18;
        goto L_0x0431;
    L_0x042f:
        r10 = -1;
    L_0x0430:
        r4 = 0;
    L_0x0431:
        if (r35 == 0) goto L_0x045e;
    L_0x0433:
        r14 = r14.getBaseline();
        if (r14 == r10) goto L_0x045e;
    L_0x0439:
        r10 = r8.h;
        if (r10 >= 0) goto L_0x0440;
    L_0x043d:
        r8 = r7.e;
        goto L_0x0442;
    L_0x0440:
        r8 = r8.h;
    L_0x0442:
        r8 = r8 & 112;
        r21 = 4;
        r8 = r8 >> 4;
        r8 = r8 & -2;
        r8 = r8 >> 1;
        r10 = r15[r8];
        r10 = java.lang.Math.max(r10, r14);
        r15[r8] = r10;
        r10 = r28[r8];
        r9 = r9 - r14;
        r9 = java.lang.Math.max(r10, r9);
        r28[r8] = r9;
        goto L_0x0460;
    L_0x045e:
        r21 = 4;
    L_0x0460:
        r10 = r2;
        r26 = r4;
        r2 = r39;
        r4 = r40;
        goto L_0x046d;
    L_0x0468:
        r4 = r5;
        r5 = r43;
        r21 = 4;
    L_0x046d:
        r0 = r0 + 1;
        r5 = r4;
        r4 = r42;
        r8 = -1;
        goto L_0x0355;
    L_0x0475:
        r5 = r43;
        r0 = r7.f;
        r2 = r41.getPaddingLeft();
        r4 = r41.getPaddingRight();
        r2 = r2 + r4;
        r0 = r0 + r2;
        r7.f = r0;
        r0 = r15[r18];
        r2 = -1;
        if (r0 != r2) goto L_0x0497;
    L_0x048a:
        r0 = 0;
        r4 = r15[r0];
        if (r4 != r2) goto L_0x0497;
    L_0x048f:
        r0 = r15[r17];
        if (r0 != r2) goto L_0x0497;
    L_0x0493:
        r0 = r15[r16];
        if (r0 == r2) goto L_0x04c6;
    L_0x0497:
        r0 = r15[r16];
        r2 = 0;
        r4 = r15[r2];
        r8 = r15[r18];
        r9 = r15[r17];
        r8 = java.lang.Math.max(r8, r9);
        r4 = java.lang.Math.max(r4, r8);
        r0 = java.lang.Math.max(r0, r4);
        r4 = r28[r16];
        r2 = r28[r2];
        r8 = r28[r18];
        r9 = r28[r17];
        r8 = java.lang.Math.max(r8, r9);
        r2 = java.lang.Math.max(r2, r8);
        r2 = java.lang.Math.max(r4, r2);
        r0 = r0 + r2;
        r0 = java.lang.Math.max(r3, r0);
        r3 = r0;
    L_0x04c6:
        r0 = r10;
    L_0x04c7:
        if (r26 != 0) goto L_0x04ce;
    L_0x04c9:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r13 == r2) goto L_0x04ce;
    L_0x04cd:
        goto L_0x04cf;
    L_0x04ce:
        r0 = r3;
    L_0x04cf:
        r2 = r41.getPaddingTop();
        r3 = r41.getPaddingBottom();
        r2 = r2 + r3;
        r0 = r0 + r2;
        r2 = r41.getSuggestedMinimumHeight();
        r0 = java.lang.Math.max(r0, r2);
        r2 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r2 = r2 & r6;
        r1 = r1 | r2;
        r2 = r6 << 16;
        r0 = android.view.View.resolveSizeAndState(r0, r5, r2);
        r7.setMeasuredDimension(r1, r0);
        if (r27 == 0) goto L_0x04f5;
    L_0x04f0:
        r0 = r42;
        r7.d(r11, r0);
    L_0x04f5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.an.b(int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010a  */
    void b(int r28, int r29, int r30, int r31) {
        /*
        r27 = this;
        r6 = r27;
        r2 = android.support.v7.widget.bo.a(r27);
        r7 = r27.getPaddingTop();
        r3 = r31 - r29;
        r4 = r27.getPaddingBottom();
        r8 = r3 - r4;
        r3 = r3 - r7;
        r4 = r27.getPaddingBottom();
        r9 = r3 - r4;
        r10 = r27.getVirtualChildCount();
        r3 = r6.e;
        r4 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r3 = r3 & r4;
        r4 = r6.e;
        r11 = r4 & 112;
        r12 = r6.a;
        r13 = r6.i;
        r14 = r6.j;
        r4 = android.support.v4.h.r.e(r27);
        r3 = android.support.v4.h.d.a(r3, r4);
        r15 = 2;
        r5 = 1;
        if (r3 == r5) goto L_0x004e;
    L_0x0039:
        r4 = 5;
        if (r3 == r4) goto L_0x0041;
    L_0x003c:
        r0 = r27.getPaddingLeft();
        goto L_0x0059;
    L_0x0041:
        r3 = r27.getPaddingLeft();
        r3 = r3 + r30;
        r3 = r3 - r28;
        r0 = r6.f;
        r0 = r3 - r0;
        goto L_0x0059;
    L_0x004e:
        r3 = r27.getPaddingLeft();
        r0 = r30 - r28;
        r1 = r6.f;
        r0 = r0 - r1;
        r0 = r0 / r15;
        r0 = r0 + r3;
    L_0x0059:
        r1 = 0;
        if (r2 == 0) goto L_0x0063;
    L_0x005c:
        r2 = r10 + -1;
        r16 = r2;
        r17 = -1;
        goto L_0x0067;
    L_0x0063:
        r16 = r1;
        r17 = r5;
    L_0x0067:
        r3 = r1;
    L_0x0068:
        if (r3 >= r10) goto L_0x0153;
    L_0x006a:
        r1 = r17 * r3;
        r2 = r16 + r1;
        r1 = r6.b(r2);
        if (r1 != 0) goto L_0x0085;
    L_0x0074:
        r1 = r6.d(r2);
        r0 = r0 + r1;
        r18 = r5;
        r26 = r7;
        r23 = r10;
        r24 = r11;
    L_0x0081:
        r20 = -1;
        goto L_0x0146;
    L_0x0085:
        r5 = r1.getVisibility();
        r15 = 8;
        if (r5 == r15) goto L_0x013a;
    L_0x008d:
        r15 = r1.getMeasuredWidth();
        r5 = r1.getMeasuredHeight();
        r20 = r1.getLayoutParams();
        r4 = r20;
        r4 = (android.support.v7.widget.an.a) r4;
        if (r12 == 0) goto L_0x00ad;
    L_0x009f:
        r22 = r3;
        r3 = r4.height;
        r23 = r10;
        r10 = -1;
        if (r3 == r10) goto L_0x00b1;
    L_0x00a8:
        r3 = r1.getBaseline();
        goto L_0x00b2;
    L_0x00ad:
        r22 = r3;
        r23 = r10;
    L_0x00b1:
        r3 = -1;
    L_0x00b2:
        r10 = r4.h;
        if (r10 >= 0) goto L_0x00b7;
    L_0x00b6:
        r10 = r11;
    L_0x00b7:
        r10 = r10 & 112;
        r24 = r11;
        r11 = 16;
        if (r10 == r11) goto L_0x00f6;
    L_0x00bf:
        r11 = 48;
        if (r10 == r11) goto L_0x00e3;
    L_0x00c3:
        r11 = 80;
        if (r10 == r11) goto L_0x00cc;
    L_0x00c7:
        r3 = r7;
        r11 = -1;
    L_0x00c9:
        r18 = 1;
        goto L_0x0104;
    L_0x00cc:
        r10 = r8 - r5;
        r11 = r4.bottomMargin;
        r10 = r10 - r11;
        r11 = -1;
        if (r3 == r11) goto L_0x00e1;
    L_0x00d4:
        r20 = r1.getMeasuredHeight();
        r20 = r20 - r3;
        r3 = 2;
        r21 = r14[r3];
        r21 = r21 - r20;
        r10 = r10 - r21;
    L_0x00e1:
        r3 = r10;
        goto L_0x00c9;
    L_0x00e3:
        r11 = -1;
        r10 = r4.topMargin;
        r10 = r10 + r7;
        if (r3 == r11) goto L_0x00f2;
    L_0x00e9:
        r18 = 1;
        r20 = r13[r18];
        r20 = r20 - r3;
        r10 = r10 + r20;
        goto L_0x00f4;
    L_0x00f2:
        r18 = 1;
    L_0x00f4:
        r3 = r10;
        goto L_0x0104;
    L_0x00f6:
        r11 = -1;
        r18 = 1;
        r3 = r9 - r5;
        r10 = 2;
        r3 = r3 / r10;
        r3 = r3 + r7;
        r10 = r4.topMargin;
        r3 = r3 + r10;
        r10 = r4.bottomMargin;
        r3 = r3 - r10;
    L_0x0104:
        r10 = r6.c(r2);
        if (r10 == 0) goto L_0x010d;
    L_0x010a:
        r10 = r6.l;
        r0 = r0 + r10;
    L_0x010d:
        r10 = r4.leftMargin;
        r10 = r10 + r0;
        r0 = r6.a(r1);
        r19 = r10 + r0;
        r0 = r6;
        r25 = r1;
        r11 = r2;
        r2 = r19;
        r19 = r22;
        r26 = r7;
        r20 = -1;
        r7 = r4;
        r4 = r15;
        r0.a(r1, r2, r3, r4, r5);
        r0 = r7.rightMargin;
        r15 = r15 + r0;
        r0 = r25;
        r1 = r6.b(r0);
        r15 = r15 + r1;
        r10 = r10 + r15;
        r0 = r6.a(r0, r11);
        r3 = r19 + r0;
        r0 = r10;
        goto L_0x0146;
    L_0x013a:
        r19 = r3;
        r26 = r7;
        r23 = r10;
        r24 = r11;
        r18 = 1;
        goto L_0x0081;
    L_0x0146:
        r3 = r3 + 1;
        r5 = r18;
        r10 = r23;
        r11 = r24;
        r7 = r26;
        r15 = 2;
        goto L_0x0068;
    L_0x0153:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.an.b(int, int, int, int):void");
    }

    void b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = bo.a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = b(i);
            if (!(b == null || b.getVisibility() == 8 || !c(i))) {
                a aVar = (a) b.getLayoutParams();
                b(canvas, a ? b.getRight() + aVar.rightMargin : (b.getLeft() - aVar.leftMargin) - this.l);
            }
            i++;
        }
        if (c(virtualChildCount)) {
            int i2;
            View b2 = b(virtualChildCount - 1);
            if (b2 != null) {
                a aVar2 = (a) b2.getLayoutParams();
                if (a) {
                    virtualChildCount = b2.getLeft();
                    i2 = aVar2.leftMargin;
                } else {
                    virtualChildCount = b2.getRight() + aVar2.rightMargin;
                    b(canvas, virtualChildCount);
                }
            } else if (a) {
                virtualChildCount = getPaddingLeft();
                b(canvas, virtualChildCount);
            } else {
                virtualChildCount = getWidth();
                i2 = getPaddingRight();
            }
            virtualChildCount = (virtualChildCount - i2) - this.l;
            b(canvas, virtualChildCount);
        }
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    protected boolean c(int i) {
        boolean z = false;
        if (i == 0) {
            if ((this.n & 1) != 0) {
                z = true;
            }
            return z;
        } else if (i == getChildCount()) {
            if ((this.n & 4) != 0) {
                z = true;
            }
            return z;
        } else {
            if ((this.n & 2) != 0) {
                for (i--; i >= 0; i--) {
                    if (getChildAt(i).getVisibility() != 8) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    int d(int i) {
        return 0;
    }

    public int getBaseline() {
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i = this.c;
            if (this.d == 1) {
                int i2 = this.e & 112;
                if (i2 != 48) {
                    if (i2 == 16) {
                        i += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2;
                    } else if (i2 == 80) {
                        i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                    }
                }
            }
            return (i + ((a) childAt.getLayoutParams()).topMargin) + baseline;
        } else if (this.b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    /* renamed from: j */
    protected a generateDefaultLayoutParams() {
        return this.d == 0 ? new a(-2, -2) : this.d == 1 ? new a(-1, -2) : null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k != null) {
            if (this.d == 1) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(an.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(an.class.getName());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("base aligned child index out of range (0, ");
            stringBuilder.append(getChildCount());
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.k) {
            this.k = drawable;
            boolean z = false;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        i &= 8388615;
        if ((8388615 & this.e) != i) {
            this.e = i | (this.e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public void setVerticalGravity(int i) {
        i &= 112;
        if ((this.e & 112) != i) {
            this.e = i | (this.e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
