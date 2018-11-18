package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.h.v;
import android.support.v4.widget.i;
import android.support.v7.c.a.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

class ah extends ListView {
    b a;
    private final Rect b = new Rect();
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g;
    private Field h;
    private a i;
    private boolean j;
    private boolean k;
    private boolean l;
    private v m;
    private i n;

    private class b implements Runnable {
        b() {
        }

        public void a() {
            ah.this.a = null;
            ah.this.removeCallbacks(this);
        }

        public void b() {
            ah.this.post(this);
        }

        public void run() {
            ah.this.a = null;
            ah.this.drawableStateChanged();
        }
    }

    private static class a extends c {
        private boolean a = true;

        a(Drawable drawable) {
            super(drawable);
        }

        void a(boolean z) {
            this.a = z;
        }

        public void draw(Canvas canvas) {
            if (this.a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            return this.a ? super.setState(iArr) : false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.a ? super.setVisible(z, z2) : false;
        }
    }

    ah(Context context, boolean z) {
        super(context, null, android.support.v7.a.a.a.dropDownListViewStyle);
        this.k = z;
        setCacheColorHint(0);
        try {
            this.h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void a() {
        Drawable selector = getSelector();
        if (selector != null && c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        b(i, view);
        if (z2) {
            Rect rect = this.b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            android.support.v4.graphics.drawable.a.a(selector, exactCenterX, exactCenterY);
        }
    }

    private void a(int i, View view, float f, float f2) {
        a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            android.support.v4.graphics.drawable.a.a(selector, f, f2);
        }
    }

    private void a(Canvas canvas) {
        if (!this.b.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.b);
                selector.draw(canvas);
            }
        }
    }

    private void a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void a(View view, int i, float f, float f2) {
        this.l = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.g != -1) {
            View childAt = getChildAt(this.g - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.g = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void b() {
        this.l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.m != null) {
            this.m.b();
            this.m = null;
        }
    }

    private void b(int i, View view) {
        Rect rect = this.b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.c;
        rect.top -= this.d;
        rect.right += this.e;
        rect.bottom += this.f;
        try {
            boolean z = this.h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.h.set(this, Boolean.valueOf(z ^ 1));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean c() {
        return this.l;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.i != null) {
            this.i.a(z);
        }
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        i2 = getListPaddingTop();
        i3 = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return i2 + i3;
        }
        i2 += i3;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i6 = i2;
        i2 = 0;
        int i7 = i2;
        int i8 = i7;
        View view = null;
        while (i2 < count) {
            int itemViewType = adapter.getItemViewType(i2);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i2, view, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i2 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i4) {
                if (i5 >= 0 && i2 > i5 && i8 > 0 && i6 != i4) {
                    i4 = i8;
                }
                return i4;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    public boolean a(android.view.MotionEvent r8, int r9) {
        /*
        r7 = this;
        r0 = r8.getActionMasked();
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 1: goto L_0x0011;
            case 2: goto L_0x000f;
            case 3: goto L_0x000c;
            default: goto L_0x0009;
        };
    L_0x0009:
        r9 = r1;
        r3 = r2;
        goto L_0x0041;
    L_0x000c:
        r9 = r1;
        r3 = r9;
        goto L_0x0041;
    L_0x000f:
        r3 = r2;
        goto L_0x0012;
    L_0x0011:
        r3 = r1;
    L_0x0012:
        r9 = r8.findPointerIndex(r9);
        if (r9 >= 0) goto L_0x0019;
    L_0x0018:
        goto L_0x000c;
    L_0x0019:
        r4 = r8.getX(r9);
        r4 = (int) r4;
        r9 = r8.getY(r9);
        r9 = (int) r9;
        r5 = r7.pointToPosition(r4, r9);
        r6 = -1;
        if (r5 != r6) goto L_0x002c;
    L_0x002a:
        r9 = r2;
        goto L_0x0041;
    L_0x002c:
        r3 = r7.getFirstVisiblePosition();
        r3 = r5 - r3;
        r3 = r7.getChildAt(r3);
        r4 = (float) r4;
        r9 = (float) r9;
        r7.a(r3, r5, r4, r9);
        if (r0 != r2) goto L_0x0009;
    L_0x003d:
        r7.a(r3, r5);
        goto L_0x0009;
    L_0x0041:
        if (r3 == 0) goto L_0x0045;
    L_0x0043:
        if (r9 == 0) goto L_0x0048;
    L_0x0045:
        r7.b();
    L_0x0048:
        if (r3 == 0) goto L_0x0060;
    L_0x004a:
        r9 = r7.n;
        if (r9 != 0) goto L_0x0055;
    L_0x004e:
        r9 = new android.support.v4.widget.i;
        r9.<init>(r7);
        r7.n = r9;
    L_0x0055:
        r9 = r7.n;
        r9.a(r2);
        r9 = r7.n;
        r9.onTouch(r7, r8);
        return r3;
    L_0x0060:
        r8 = r7.n;
        if (r8 == 0) goto L_0x0069;
    L_0x0064:
        r7 = r7.n;
        r7.a(r1);
    L_0x0069:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ah.a(android.view.MotionEvent, int):boolean");
    }

    protected void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        if (this.a == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            a();
        }
    }

    public boolean hasFocus() {
        return this.k || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.k || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.k || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.k && this.j) || super.isInTouchMode();
    }

    protected void onDetachedFromWindow() {
        this.a = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.a == null) {
            this.a = new b();
            this.a.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                a();
            }
            return onHoverEvent;
        }
        setSelection(-1);
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.a != null) {
            this.a.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z) {
        this.j = z;
    }

    public void setSelector(Drawable drawable) {
        this.i = drawable != null ? new a(drawable) : null;
        super.setSelector(this.i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.c = rect.left;
        this.d = rect.top;
        this.e = rect.right;
        this.f = rect.bottom;
    }
}
