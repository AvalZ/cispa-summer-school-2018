package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.d;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.design.widget.CoordinatorLayout.c;
import android.support.design.widget.CoordinatorLayout.e;
import android.support.v4.h.r;
import android.support.v7.widget.p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

@c(a = Behavior.class)
public class FloatingActionButton extends u {
    int a;
    boolean b;
    final Rect c;
    private ColorStateList d;
    private Mode e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private final Rect k;
    private p l;
    private g m;

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public static class Behavior extends android.support.design.widget.CoordinatorLayout.b<FloatingActionButton> {
        private Rect a;
        private a b;
        private boolean c;

        public Behavior() {
            this.c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.FloatingActionButton_Behavior_Layout);
            this.c = obtainStyledAttributes.getBoolean(k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.c;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                e eVar = (e) floatingActionButton.getLayoutParams();
                int i = 0;
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin ? rect.right : floatingActionButton.getLeft() <= eVar.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - eVar.bottomMargin) {
                    i = rect.bottom;
                } else if (floatingActionButton.getTop() <= eVar.topMargin) {
                    i = -rect.top;
                }
                if (i != 0) {
                    r.c(floatingActionButton, i);
                }
                if (i2 != 0) {
                    r.d(floatingActionButton, i2);
                }
            }
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            android.support.v4.widget.r.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.b, false);
            } else {
                floatingActionButton.a(this.b, false);
            }
            return true;
        }

        private static boolean a(View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            return layoutParams instanceof e ? ((e) layoutParams).b() instanceof BottomSheetBehavior : false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.c && ((e) floatingActionButton.getLayoutParams()).a() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((e) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.b(this.b, false);
            } else {
                floatingActionButton.a(this.b, false);
            }
            return true;
        }

        public void a(e eVar) {
            if (eVar.h == 0) {
                eVar.h = 80;
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List c = coordinatorLayout.c((View) floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) c.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.a((View) floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.c;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (a(view)) {
                b(view, floatingActionButton);
            }
            return false;
        }
    }

    private class b implements l {
        b() {
        }

        public float a() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.c.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(i + FloatingActionButton.this.a, i2 + FloatingActionButton.this.a, i3 + FloatingActionButton.this.a, i4 + FloatingActionButton.this.a);
        }

        public void a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean b() {
            return FloatingActionButton.this.b;
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        this.k = new Rect();
        p.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.FloatingActionButton, i, j.Widget_Design_FloatingActionButton);
        this.d = obtainStyledAttributes.getColorStateList(k.FloatingActionButton_backgroundTint);
        this.e = s.a(obtainStyledAttributes.getInt(k.FloatingActionButton_backgroundTintMode, -1), null);
        this.g = obtainStyledAttributes.getColor(k.FloatingActionButton_rippleColor, 0);
        this.h = obtainStyledAttributes.getInt(k.FloatingActionButton_fabSize, -1);
        this.i = obtainStyledAttributes.getDimensionPixelSize(k.FloatingActionButton_fabCustomSize, 0);
        this.f = obtainStyledAttributes.getDimensionPixelSize(k.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(k.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(k.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.b = obtainStyledAttributes.getBoolean(k.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.l = new p(this);
        this.l.a(attributeSet, i);
        this.j = (int) getResources().getDimension(d.design_fab_image_size);
        getImpl().a(this.d, this.e, this.g, this.f);
        getImpl().a(dimension);
        getImpl().b(dimension2);
    }

    private int a(int i) {
        Resources resources = getResources();
        if (this.i != 0) {
            return this.i;
        }
        if (i == -1) {
            return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? a(1) : a(0);
        } else {
            return resources.getDimensionPixelSize(i != 1 ? d.design_fab_size_normal : d.design_fab_size_mini);
        }
    }

    private static int a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            i = Math.min(i, i2);
        } else if (mode != 0) {
            return mode != 1073741824 ? i : i2;
        }
        return i;
    }

    private c a(final a aVar) {
        return aVar == null ? null : new c() {
            public void a() {
                aVar.a(FloatingActionButton.this);
            }

            public void b() {
                aVar.b(FloatingActionButton.this);
            }
        };
    }

    private g a() {
        return VERSION.SDK_INT >= 21 ? new h(this, new b()) : new g(this, new b());
    }

    private g getImpl() {
        if (this.m == null) {
            this.m = a();
        }
        return this.m;
    }

    void a(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    public boolean a(Rect rect) {
        if (!r.u(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.c.left;
        rect.top += this.c.top;
        rect.right -= this.c.right;
        rect.bottom -= this.c.bottom;
        return true;
    }

    void b(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.d;
    }

    public Mode getBackgroundTintMode() {
        return this.e;
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public Drawable getContentBackground() {
        return getImpl().c();
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getRippleColor() {
        return this.g;
    }

    public int getSize() {
        return this.h;
    }

    int getSizeDimension() {
        return a(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().f();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().g();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.a = (sizeDimension - this.j) / 2;
        getImpl().e();
        i = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        setMeasuredDimension((this.c.left + i) + this.c.right, (i + this.c.top) + this.c.bottom);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (motionEvent.getAction() == 0 && a(this.k) && !this.k.contains((int) motionEvent.getX(), (int) motionEvent.getY())) ? false : super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.d != colorStateList) {
            this.d = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().a(f);
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size should be non-negative.");
        }
        this.i = i;
    }

    public void setImageResource(int i) {
        this.l.a(i);
    }

    public void setRippleColor(int i) {
        if (this.g != i) {
            this.g = i;
            getImpl().a(i);
        }
    }

    public void setSize(int i) {
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.b != z) {
            this.b = z;
            getImpl().d();
        }
    }
}
