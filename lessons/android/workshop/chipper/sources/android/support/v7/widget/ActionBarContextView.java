package android.support.v7.widget;

import android.content.Context;
import android.support.v4.h.r;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.j;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private boolean p;
    private int q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bg a = bg.a(context, attributeSet, j.ActionMode, i, 0);
        r.a((View) this, a.a(j.ActionMode_background));
        this.n = a.g(j.ActionMode_titleTextStyle, 0);
        this.o = a.g(j.ActionMode_subtitleTextStyle, 0);
        this.e = a.f(j.ActionMode_height, 0);
        this.q = a.g(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        a.a();
    }

    private void e() {
        if (this.k == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            this.k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.l = (TextView) this.k.findViewById(f.action_bar_title);
            this.m = (TextView) this.k.findViewById(f.action_bar_subtitle);
            if (this.n != 0) {
                this.l.setTextAppearance(getContext(), this.n);
            }
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
        }
        this.l.setText(this.g);
        this.m.setText(this.h);
        int isEmpty = TextUtils.isEmpty(this.g) ^ 1;
        int isEmpty2 = TextUtils.isEmpty(this.h) ^ 1;
        int i = 8;
        this.m.setVisibility(isEmpty2 != 0 ? 0 : 8);
        LinearLayout linearLayout = this.k;
        if (!(isEmpty == 0 && isEmpty2 == 0)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.k.getParent() == null) {
            addView(this.k);
        }
    }

    /* JADX WARNING: Missing block: B:5:0x0021, code:
            if (r3.i.getParent() == null) goto L_0x0015;
     */
    public void a(final android.support.v7.view.b r4) {
        /*
        r3 = this;
        r0 = r3.i;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        r0 = r3.getContext();
        r0 = android.view.LayoutInflater.from(r0);
        r1 = r3.q;
        r2 = 0;
        r0 = r0.inflate(r1, r3, r2);
        r3.i = r0;
    L_0x0015:
        r0 = r3.i;
        r3.addView(r0);
        goto L_0x0024;
    L_0x001b:
        r0 = r3.i;
        r0 = r0.getParent();
        if (r0 != 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0015;
    L_0x0024:
        r0 = r3.i;
        r1 = android.support.v7.a.a.f.action_mode_close_button;
        r0 = r0.findViewById(r1);
        r1 = new android.support.v7.widget.ActionBarContextView$1;
        r1.<init>(r4);
        r0.setOnClickListener(r1);
        r4 = r4.b();
        r4 = (android.support.v7.view.menu.h) r4;
        r0 = r3.d;
        if (r0 == 0) goto L_0x0043;
    L_0x003e:
        r0 = r3.d;
        r0.f();
    L_0x0043:
        r0 = new android.support.v7.widget.c;
        r1 = r3.getContext();
        r0.<init>(r1);
        r3.d = r0;
        r0 = r3.d;
        r1 = 1;
        r0.c(r1);
        r0 = new android.view.ViewGroup$LayoutParams;
        r1 = -2;
        r2 = -1;
        r0.<init>(r1, r2);
        r1 = r3.d;
        r2 = r3.b;
        r4.a(r1, r2);
        r4 = r3.d;
        r4 = r4.a(r3);
        r4 = (android.support.v7.widget.ActionMenuView) r4;
        r3.c = r4;
        r4 = r3.c;
        r1 = 0;
        android.support.v4.h.r.a(r4, r1);
        r4 = r3.c;
        r3.addView(r4, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContextView.a(android.support.v7.view.b):void");
    }

    public boolean a() {
        return this.d != null ? this.d.d() : false;
    }

    public void b() {
        if (this.i == null) {
            c();
        }
    }

    public void c() {
        removeAllViews();
        this.j = null;
        this.c = null;
    }

    public boolean d() {
        return this.p;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.e();
            this.d.g();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = bo.a(this);
        int paddingRight = z ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        i2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.i == null || this.i.getVisibility() == 8) {
            i4 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.i.getLayoutParams();
            int i5 = z ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i4 = z ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a = a.a(paddingRight, i5, z);
            i4 = a.a(a + a(this.i, a, paddingTop, i2, z), i4, z);
        }
        if (!(this.k == null || this.j != null || this.k.getVisibility() == 8)) {
            i4 += a(this.k, i4, paddingTop, i2, z);
        }
        int i6 = i4;
        if (this.j != null) {
            a(this.j, i6, paddingTop, i2, z);
        }
        int paddingLeft = z ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a(this.c, paddingLeft, paddingTop, i2, z ^ 1);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        StringBuilder stringBuilder;
        if (MeasureSpec.getMode(i) != 1073741824) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(" can only be used ");
            stringBuilder.append("with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(stringBuilder.toString());
        } else if (MeasureSpec.getMode(i2) == 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(" can only be used ");
            stringBuilder.append("with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(stringBuilder.toString());
        } else {
            int i4;
            i = MeasureSpec.getSize(i);
            i2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            int i5 = i2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            int i6 = 0;
            if (this.i != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.i.getLayoutParams();
                paddingLeft = a(this.i, paddingLeft, makeMeasureSpec, 0) - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.k != null && this.j == null) {
                if (this.p) {
                    this.k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    makeMeasureSpec = this.k.getMeasuredWidth();
                    i4 = makeMeasureSpec <= paddingLeft ? 1 : 0;
                    if (i4 != 0) {
                        paddingLeft -= makeMeasureSpec;
                    }
                    this.k.setVisibility(i4 != 0 ? 0 : 8);
                } else {
                    paddingLeft = a(this.k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.j != null) {
                LayoutParams layoutParams = this.j.getLayoutParams();
                i4 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i5 = Math.min(layoutParams.height, i5);
                }
                this.j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, i4), MeasureSpec.makeMeasureSpec(i5, i3));
            }
            if (this.e <= 0) {
                i2 = getChildCount();
                i3 = 0;
                while (i6 < i2) {
                    paddingLeft = getChildAt(i6).getMeasuredHeight() + paddingTop;
                    if (paddingLeft > i3) {
                        i3 = paddingLeft;
                    }
                    i6++;
                }
                setMeasuredDimension(i, i3);
                return;
            }
            setMeasuredDimension(i, i2);
        }
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.j != null) {
            removeView(this.j);
        }
        this.j = view;
        if (!(view == null || this.k == null)) {
            removeView(this.k);
            this.k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.h = charSequence;
        e();
    }

    public void setTitle(CharSequence charSequence) {
        this.g = charSequence;
        e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.p) {
            requestLayout();
        }
        this.p = z;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
