package android.support.v7.widget;

import android.content.Context;
import android.support.v4.h.r;
import android.support.v7.a.a.f;
import android.support.v7.widget.an.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class AlertDialogLayout extends an {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private static int c(View view) {
        int i = r.i(view);
        if (i > 0) {
            return i;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return c(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean c(int i, int i2) {
        int i3;
        int combineMeasuredStates;
        int c;
        int measuredHeight;
        int measuredHeight2;
        int i4 = i;
        int i5 = i2;
        int childCount = getChildCount();
        View view = null;
        View view2 = view;
        View view3 = view2;
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == f.topPanel) {
                    view = childAt;
                } else if (id == f.buttonPanel) {
                    view2 = childAt;
                } else if ((id != f.contentPanel && id != f.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        i3 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i4, 0);
            paddingTop += view.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            combineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i4, 0);
            c = c(view2);
            measuredHeight = view2.getMeasuredHeight() - c;
            paddingTop += c;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
        } else {
            c = 0;
            measuredHeight = c;
        }
        if (view3 != null) {
            view3.measure(i4, i3 == 0 ? 0 : MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), i3));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        size -= paddingTop;
        if (view2 != null) {
            paddingTop -= c;
            measuredHeight = Math.min(size, measuredHeight);
            if (measuredHeight > 0) {
                size -= measuredHeight;
                c += measuredHeight;
            }
            view2.measure(i4, MeasureSpec.makeMeasureSpec(c, 1073741824));
            paddingTop += view2.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && size > 0) {
            paddingTop -= measuredHeight2;
            view3.measure(i4, MeasureSpec.makeMeasureSpec(measuredHeight2 + size, i3));
            paddingTop += view3.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
        }
        int i6 = 0;
        for (i3 = 0; i3 < childCount; i3++) {
            view3 = getChildAt(i3);
            if (view3.getVisibility() != 8) {
                i6 = Math.max(i6, view3.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i6 + (getPaddingLeft() + getPaddingRight()), i4, combineMeasuredStates), View.resolveSizeAndState(paddingTop, i5, 0));
        if (mode != 1073741824) {
            d(childCount, i5);
        }
        return true;
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5  */
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
        r17 = this;
        r6 = r17;
        r7 = r17.getPaddingLeft();
        r2 = r21 - r19;
        r3 = r17.getPaddingRight();
        r8 = r2 - r3;
        r2 = r2 - r7;
        r3 = r17.getPaddingRight();
        r9 = r2 - r3;
        r2 = r17.getMeasuredHeight();
        r10 = r17.getChildCount();
        r3 = r17.getGravity();
        r4 = r3 & 112;
        r5 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r11 = r3 & r5;
        r3 = 16;
        if (r4 == r3) goto L_0x0040;
    L_0x002c:
        r3 = 80;
        if (r4 == r3) goto L_0x0035;
    L_0x0030:
        r0 = r17.getPaddingTop();
        goto L_0x004a;
    L_0x0035:
        r3 = r17.getPaddingTop();
        r3 = r3 + r22;
        r3 = r3 - r20;
        r0 = r3 - r2;
        goto L_0x004a;
    L_0x0040:
        r3 = r17.getPaddingTop();
        r0 = r22 - r20;
        r0 = r0 - r2;
        r0 = r0 / 2;
        r0 = r0 + r3;
    L_0x004a:
        r1 = r17.getDividerDrawable();
        r2 = 0;
        if (r1 != 0) goto L_0x0053;
    L_0x0051:
        r12 = r2;
        goto L_0x0058;
    L_0x0053:
        r1 = r1.getIntrinsicHeight();
        r12 = r1;
    L_0x0058:
        r13 = r2;
    L_0x0059:
        if (r13 >= r10) goto L_0x00bb;
    L_0x005b:
        r1 = r6.getChildAt(r13);
        if (r1 == 0) goto L_0x00b8;
    L_0x0061:
        r2 = r1.getVisibility();
        r3 = 8;
        if (r2 == r3) goto L_0x00b8;
    L_0x0069:
        r4 = r1.getMeasuredWidth();
        r14 = r1.getMeasuredHeight();
        r2 = r1.getLayoutParams();
        r15 = r2;
        r15 = (android.support.v7.widget.an.a) r15;
        r2 = r15.h;
        if (r2 >= 0) goto L_0x007d;
    L_0x007c:
        r2 = r11;
    L_0x007d:
        r3 = android.support.v4.h.r.e(r17);
        r2 = android.support.v4.h.d.a(r2, r3);
        r2 = r2 & 7;
        r3 = 1;
        if (r2 == r3) goto L_0x0094;
    L_0x008a:
        r3 = 5;
        if (r2 == r3) goto L_0x0091;
    L_0x008d:
        r2 = r15.leftMargin;
        r2 = r2 + r7;
        goto L_0x009f;
    L_0x0091:
        r2 = r8 - r4;
        goto L_0x009c;
    L_0x0094:
        r2 = r9 - r4;
        r2 = r2 / 2;
        r2 = r2 + r7;
        r3 = r15.leftMargin;
        r2 = r2 + r3;
    L_0x009c:
        r3 = r15.rightMargin;
        r2 = r2 - r3;
    L_0x009f:
        r3 = r6.c(r13);
        if (r3 == 0) goto L_0x00a6;
    L_0x00a5:
        r0 = r0 + r12;
    L_0x00a6:
        r3 = r15.topMargin;
        r16 = r0 + r3;
        r0 = r6;
        r3 = r16;
        r5 = r14;
        r0.a(r1, r2, r3, r4, r5);
        r0 = r15.bottomMargin;
        r14 = r14 + r0;
        r16 = r16 + r14;
        r0 = r16;
    L_0x00b8:
        r13 = r13 + 1;
        goto L_0x0059;
    L_0x00bb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    protected void onMeasure(int i, int i2) {
        if (!c(i, i2)) {
            super.onMeasure(i, i2);
        }
    }
}
