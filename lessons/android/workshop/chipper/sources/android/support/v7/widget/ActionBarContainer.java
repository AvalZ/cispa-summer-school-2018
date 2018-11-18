package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.h.r;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
    Drawable a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        r.a((View) this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.a = obtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.b = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        if (getId() == f.split_action_bar) {
            this.d = true;
            this.c = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (this.d ? this.c != null : !(this.a == null && this.b == null)) {
            z = true;
        }
        setWillNotDraw(z);
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return (view.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null && this.a.isStateful()) {
            this.a.setState(getDrawableState());
        }
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(getDrawableState());
        }
        if (this.c != null && this.c.isStateful()) {
            this.c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.g;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.a != null) {
            this.a.jumpToCurrentState();
        }
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
        if (this.c != null) {
            this.c.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(f.action_bar);
        this.i = findViewById(f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A:{SYNTHETIC, RETURN} */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
        r5 = this;
        super.onLayout(r6, r7, r8, r9, r10);
        r6 = r5.g;
        r8 = 8;
        r10 = 1;
        r0 = 0;
        if (r6 == 0) goto L_0x0013;
    L_0x000b:
        r1 = r6.getVisibility();
        if (r1 == r8) goto L_0x0013;
    L_0x0011:
        r1 = r10;
        goto L_0x0014;
    L_0x0013:
        r1 = r0;
    L_0x0014:
        if (r6 == 0) goto L_0x0035;
    L_0x0016:
        r2 = r6.getVisibility();
        if (r2 == r8) goto L_0x0035;
    L_0x001c:
        r8 = r5.getMeasuredHeight();
        r2 = r6.getLayoutParams();
        r2 = (android.widget.FrameLayout.LayoutParams) r2;
        r3 = r6.getMeasuredHeight();
        r3 = r8 - r3;
        r4 = r2.bottomMargin;
        r3 = r3 - r4;
        r2 = r2.bottomMargin;
        r8 = r8 - r2;
        r6.layout(r7, r3, r9, r8);
    L_0x0035:
        r7 = r5.d;
        if (r7 == 0) goto L_0x004e;
    L_0x0039:
        r6 = r5.c;
        if (r6 == 0) goto L_0x004c;
    L_0x003d:
        r6 = r5.c;
        r7 = r5.getMeasuredWidth();
        r8 = r5.getMeasuredHeight();
        r6.setBounds(r0, r0, r7, r8);
        goto L_0x00be;
    L_0x004c:
        r10 = r0;
        goto L_0x00be;
    L_0x004e:
        r7 = r5.a;
        if (r7 == 0) goto L_0x00a1;
    L_0x0052:
        r7 = r5.h;
        r7 = r7.getVisibility();
        if (r7 != 0) goto L_0x0078;
    L_0x005a:
        r7 = r5.a;
        r8 = r5.h;
        r8 = r8.getLeft();
        r9 = r5.h;
        r9 = r9.getTop();
        r0 = r5.h;
        r0 = r0.getRight();
        r2 = r5.h;
    L_0x0070:
        r2 = r2.getBottom();
        r7.setBounds(r8, r9, r0, r2);
        goto L_0x00a0;
    L_0x0078:
        r7 = r5.i;
        if (r7 == 0) goto L_0x009b;
    L_0x007c:
        r7 = r5.i;
        r7 = r7.getVisibility();
        if (r7 != 0) goto L_0x009b;
    L_0x0084:
        r7 = r5.a;
        r8 = r5.i;
        r8 = r8.getLeft();
        r9 = r5.i;
        r9 = r9.getTop();
        r0 = r5.i;
        r0 = r0.getRight();
        r2 = r5.i;
        goto L_0x0070;
    L_0x009b:
        r7 = r5.a;
        r7.setBounds(r0, r0, r0, r0);
    L_0x00a0:
        r0 = r10;
    L_0x00a1:
        r5.e = r1;
        if (r1 == 0) goto L_0x004c;
    L_0x00a5:
        r7 = r5.b;
        if (r7 == 0) goto L_0x004c;
    L_0x00a9:
        r7 = r5.b;
        r8 = r6.getLeft();
        r9 = r6.getTop();
        r0 = r6.getRight();
        r6 = r6.getBottom();
        r7.setBounds(r8, r9, r0, r6);
    L_0x00be:
        if (r10 == 0) goto L_0x00c3;
    L_0x00c0:
        r5.invalidate();
    L_0x00c3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    public void onMeasure(int r4, int r5) {
        /*
        r3 = this;
        r0 = r3.h;
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r0 != 0) goto L_0x001e;
    L_0x0006:
        r0 = android.view.View.MeasureSpec.getMode(r5);
        if (r0 != r1) goto L_0x001e;
    L_0x000c:
        r0 = r3.j;
        if (r0 < 0) goto L_0x001e;
    L_0x0010:
        r0 = r3.j;
        r5 = android.view.View.MeasureSpec.getSize(r5);
        r5 = java.lang.Math.min(r0, r5);
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1);
    L_0x001e:
        super.onMeasure(r4, r5);
        r4 = r3.h;
        if (r4 != 0) goto L_0x0026;
    L_0x0025:
        return;
    L_0x0026:
        r4 = android.view.View.MeasureSpec.getMode(r5);
        r0 = r3.g;
        if (r0 == 0) goto L_0x0073;
    L_0x002e:
        r0 = r3.g;
        r0 = r0.getVisibility();
        r2 = 8;
        if (r0 == r2) goto L_0x0073;
    L_0x0038:
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r4 == r0) goto L_0x0073;
    L_0x003c:
        r0 = r3.h;
        r0 = r3.a(r0);
        if (r0 != 0) goto L_0x004b;
    L_0x0044:
        r0 = r3.h;
    L_0x0046:
        r0 = r3.b(r0);
        goto L_0x0057;
    L_0x004b:
        r0 = r3.i;
        r0 = r3.a(r0);
        if (r0 != 0) goto L_0x0056;
    L_0x0053:
        r0 = r3.i;
        goto L_0x0046;
    L_0x0056:
        r0 = 0;
    L_0x0057:
        if (r4 != r1) goto L_0x005e;
    L_0x0059:
        r4 = android.view.View.MeasureSpec.getSize(r5);
        goto L_0x0061;
    L_0x005e:
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
    L_0x0061:
        r5 = r3.getMeasuredWidth();
        r1 = r3.g;
        r1 = r3.b(r1);
        r0 = r0 + r1;
        r4 = java.lang.Math.min(r0, r4);
        r3.setMeasuredDimension(r5, r4);
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        if (this.a != null) {
            this.a.setCallback(null);
            unscheduleDrawable(this.a);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.h != null) {
                this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        boolean z = false;
        if (this.d ? this.c != null : !(this.a == null && this.b == null)) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        if (this.c != null) {
            this.c.setCallback(null);
            unscheduleDrawable(this.c);
        }
        this.c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d && this.c != null) {
                this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.d ? this.c != null : !(this.a == null && this.b == null)) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
            unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e && this.b != null) {
                this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        boolean z = false;
        if (this.d ? this.c != null : !(this.a == null && this.b == null)) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ay ayVar) {
        if (this.g != null) {
            removeView(this.g);
        }
        this.g = ayVar;
        if (ayVar != null) {
            addView(ayVar);
            ViewGroup.LayoutParams layoutParams = ayVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            ayVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.a != null) {
            this.a.setVisible(z, false);
        }
        if (this.b != null) {
            this.b.setVisible(z, false);
        }
        if (this.c != null) {
            this.c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        return i != 0 ? super.startActionModeForChild(view, callback, i) : null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.a && !this.d) || ((drawable == this.b && this.e) || ((drawable == this.c && this.d) || super.verifyDrawable(drawable)));
    }
}
