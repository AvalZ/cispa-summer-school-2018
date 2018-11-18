package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.f;
import android.support.design.a.k;
import android.support.design.widget.b.c;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout implements c {
    private TextView a;
    private Button b;
    private int c;
    private int d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.SnackbarLayout);
        this.c = obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_android_maxWidth, -1);
        this.d = obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i, int i2) {
        if (r.p(view)) {
            r.a(view, r.f(view), i, r.g(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.a.getPaddingTop() == i2 && this.a.getPaddingBottom() == i3) {
            return z;
        }
        a(this.a, i2, i3);
        return true;
    }

    public void a(int i, int i2) {
        this.a.setAlpha(0.0f);
        long j = (long) i2;
        long j2 = (long) i;
        this.a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(0.0f);
            this.b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public void b(int i, int i2) {
        this.a.setAlpha(1.0f);
        long j = (long) i2;
        long j2 = (long) i;
        this.a.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(1.0f);
            this.b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public Button getActionView() {
        return this.b;
    }

    public TextView getMessageView() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(f.snackbar_text);
        this.b = (Button) findViewById(f.snackbar_action);
    }

    /* JADX WARNING: Missing block: B:15:0x0055, code:
            if (a(1, r0, r0 - r1) != false) goto L_0x0064;
     */
    /* JADX WARNING: Missing block: B:19:0x0060, code:
            if (a(0, r0, r0) != false) goto L_0x0064;
     */
    protected void onMeasure(int r8, int r9) {
        /*
        r7 = this;
        super.onMeasure(r8, r9);
        r0 = r7.c;
        if (r0 <= 0) goto L_0x001a;
    L_0x0007:
        r0 = r7.getMeasuredWidth();
        r1 = r7.c;
        if (r0 <= r1) goto L_0x001a;
    L_0x000f:
        r8 = r7.c;
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0);
        super.onMeasure(r8, r9);
    L_0x001a:
        r0 = r7.getResources();
        r1 = android.support.design.a.d.design_snackbar_padding_vertical_2lines;
        r0 = r0.getDimensionPixelSize(r1);
        r1 = r7.getResources();
        r2 = android.support.design.a.d.design_snackbar_padding_vertical;
        r1 = r1.getDimensionPixelSize(r2);
        r2 = r7.a;
        r2 = r2.getLayout();
        r2 = r2.getLineCount();
        r3 = 0;
        r4 = 1;
        if (r2 <= r4) goto L_0x003e;
    L_0x003c:
        r2 = r4;
        goto L_0x003f;
    L_0x003e:
        r2 = r3;
    L_0x003f:
        if (r2 == 0) goto L_0x0058;
    L_0x0041:
        r5 = r7.d;
        if (r5 <= 0) goto L_0x0058;
    L_0x0045:
        r5 = r7.b;
        r5 = r5.getMeasuredWidth();
        r6 = r7.d;
        if (r5 <= r6) goto L_0x0058;
    L_0x004f:
        r1 = r0 - r1;
        r0 = r7.a(r4, r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0057:
        goto L_0x0064;
    L_0x0058:
        if (r2 == 0) goto L_0x005b;
    L_0x005a:
        goto L_0x005c;
    L_0x005b:
        r0 = r1;
    L_0x005c:
        r0 = r7.a(r3, r0, r0);
        if (r0 == 0) goto L_0x0063;
    L_0x0062:
        goto L_0x0064;
    L_0x0063:
        r4 = r3;
    L_0x0064:
        if (r4 == 0) goto L_0x0069;
    L_0x0066:
        super.onMeasure(r8, r9);
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.internal.SnackbarContentLayout.onMeasure(int, int):void");
    }
}
