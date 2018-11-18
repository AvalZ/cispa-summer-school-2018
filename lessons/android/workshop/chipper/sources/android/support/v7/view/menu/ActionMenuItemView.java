package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.a.a.j;
import android.support.v7.widget.aa;
import android.support.v7.widget.ak;
import android.support.v7.widget.bi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

public class ActionMenuItemView extends aa implements android.support.v7.view.menu.p.a, android.support.v7.widget.ActionMenuView.a, OnClickListener {
    j b;
    android.support.v7.view.menu.h.b c;
    b d;
    private CharSequence e;
    private Drawable f;
    private ak g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public static abstract class b {
        public abstract s a();
    }

    private class a extends ak {
        public a() {
            super(ActionMenuItemView.this);
        }

        public s a() {
            return ActionMenuItemView.this.d != null ? ActionMenuItemView.this.d.a() : null;
        }

        protected boolean b() {
            if (ActionMenuItemView.this.c == null || !ActionMenuItemView.this.c.a(ActionMenuItemView.this.b)) {
                return false;
            }
            s a = a();
            return a != null && a.d();
        }
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.h = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionMenuItemView, i, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k = -1;
        setSaveEnabled(false);
    }

    private boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || ((i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2);
    }

    private void f() {
        int i = 1;
        int isEmpty = TextUtils.isEmpty(this.e) ^ 1;
        if (!(this.f == null || (this.b.m() && (this.h || this.i)))) {
            i = 0;
        }
        isEmpty &= i;
        CharSequence charSequence = null;
        setText(isEmpty != 0 ? this.e : null);
        CharSequence contentDescription = this.b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = isEmpty != 0 ? null : this.b.getTitle();
        }
        setContentDescription(contentDescription);
        contentDescription = this.b.getTooltipText();
        if (TextUtils.isEmpty(contentDescription)) {
            if (isEmpty == 0) {
                charSequence = this.b.getTitle();
            }
            bi.a(this, charSequence);
            return;
        }
        bi.a(this, contentDescription);
    }

    public void a(j jVar, int i) {
        this.b = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.a((android.support.v7.view.menu.p.a) this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.g == null) {
            this.g = new a();
        }
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return TextUtils.isEmpty(getText()) ^ 1;
    }

    public boolean c() {
        return b() && this.b.getIcon() == null;
    }

    public boolean d() {
        return b();
    }

    public j getItemData() {
        return this.b;
    }

    public void onClick(View view) {
        if (this.c != null) {
            this.c.a(this.b);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h = e();
        f();
    }

    protected void onMeasure(int i, int i2) {
        boolean b = b();
        if (b && this.k >= 0) {
            super.setPadding(this.k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        i = mode == Integer.MIN_VALUE ? Math.min(i, this.j) : this.j;
        if (mode != 1073741824 && this.j > 0 && measuredWidth < i) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), i2);
        }
        if (!b && this.f != null) {
            super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.b.hasSubMenu() && this.g != null && this.g.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.i != z) {
            this.i = z;
            if (this.b != null) {
                this.b.h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.l) {
                f = ((float) this.l) / ((float) intrinsicWidth);
                intrinsicWidth = this.l;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.l) {
                f = ((float) this.l) / ((float) intrinsicHeight);
                intrinsicHeight = this.l;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        f();
    }

    public void setItemInvoker(android.support.v7.view.menu.h.b bVar) {
        this.c = bVar;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.d = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.e = charSequence;
        f();
    }
}
