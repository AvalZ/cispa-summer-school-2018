package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.h.a.d;
import android.support.v4.h.k;
import android.support.v4.h.l;
import android.support.v4.h.n;
import android.support.v4.h.o;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.List;

public class NestedScrollView extends FrameLayout implements k, n {
    private static final a w = new a();
    private static final int[] x = new int[]{16843130};
    private float A;
    private b B;
    private long a;
    private final Rect b;
    private OverScroller c;
    private EdgeEffect d;
    private EdgeEffect e;
    private int f;
    private boolean g;
    private boolean h;
    private View i;
    private boolean j;
    private VelocityTracker k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private final int[] s;
    private int t;
    private int u;
    private c v;
    private final o y;
    private final l z;

    public interface b {
        void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static class c extends BaseSavedState {
        public static final Creator<c> CREATOR = new Creator<c>() {
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            /* renamed from: a */
            public c[] newArray(int i) {
                return new c[i];
            }
        };
        public int a;

        c(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HorizontalScrollView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" scrollPosition=");
            stringBuilder.append(this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    static class a extends android.support.v4.h.b {
        a() {
        }

        public void a(View view, android.support.v4.h.a.b bVar) {
            super.a(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    bVar.c(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        bVar.a(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        bVar.a(4096);
                    }
                }
            }
        }

        public void a(View view, AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            d.a(accessibilityEvent, nestedScrollView.getScrollX());
            d.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            if (i == 4096) {
                min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.c(0, min);
                return true;
            } else if (i != 8192) {
                return false;
            } else {
                min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.c(0, min);
                return true;
            }
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Rect();
        this.g = true;
        this.h = false;
        this.i = null;
        this.j = false;
        this.m = true;
        this.q = -1;
        this.r = new int[2];
        this.s = new int[2];
        a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.y = new o(this);
        this.z = new l(this);
        setNestedScrollingEnabled(true);
        r.a((View) this, w);
    }

    private View a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        int size = focusables.size();
        int i3 = 0;
        View view = null;
        for (int i4 = i3; i4 < size; i4++) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                int i5 = (i >= top || bottom >= i2) ? 0 : 1;
                if (view == null) {
                    view = view2;
                    i3 = i5;
                } else {
                    Object obj = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (i3 != 0) {
                        if (i5 != 0) {
                            if (obj == null) {
                            }
                        }
                    } else if (i5 != 0) {
                        view = view2;
                        i3 = 1;
                    } else if (obj == null) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private void a() {
        this.c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.q) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.f = (int) motionEvent.getY(actionIndex);
            this.q = motionEvent.getPointerId(actionIndex);
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    private boolean a(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        height += scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View a = a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > height) {
            g(z2 ? i2 - scrollY : i3 - height);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean a(Rect rect, boolean z) {
        int a = a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
                return z2;
            }
            b(0, a);
        }
        return z2;
    }

    private boolean a(View view) {
        return a(view, 0, getHeight()) ^ 1;
    }

    private boolean a(View view, int i, int i2) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        return this.b.bottom + i >= getScrollY() && this.b.top - i <= getScrollY() + i2;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    private static int b(int i, int i2, int i3) {
        return (i2 >= i3 || i < 0) ? 0 : i2 + i > i3 ? i3 - i2 : i;
    }

    private void b(View view) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        int a = a(this.b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean b() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private void c() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        } else {
            this.k.clear();
        }
    }

    private void d() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private boolean d(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void e() {
        if (this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }

    private void f() {
        this.j = false;
        e();
        a(0);
        if (this.d != null) {
            this.d.onRelease();
            this.e.onRelease();
        }
    }

    private void g() {
        if (getOverScrollMode() == 2) {
            this.d = null;
            this.e = null;
        } else if (this.d == null) {
            Context context = getContext();
            this.d = new EdgeEffect(context);
            this.e = new EdgeEffect(context);
        }
    }

    private void g(int i) {
        if (i != 0) {
            if (this.m) {
                b(0, i);
                return;
            }
            scrollBy(0, i);
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.A;
    }

    private void h(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        float f = (float) i;
        if (!dispatchNestedPreFling(0.0f, f)) {
            dispatchNestedFling(0.0f, f, z);
            f(i);
        }
    }

    protected int a(Rect rect) {
        int i = 0;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        verticalFadingEdgeLength = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        if (rect.bottom <= verticalFadingEdgeLength || rect.top <= scrollY) {
            if (rect.top < scrollY && rect.bottom < verticalFadingEdgeLength) {
                i = Math.max(rect.height() > height ? 0 - (verticalFadingEdgeLength - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
            }
            return i;
        }
        return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - verticalFadingEdgeLength) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
    }

    public void a(int i) {
        this.z.c(i);
    }

    public void a(View view, int i, int i2, int i3, int i4, int i5) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        a(0, scrollY2, 0, i4 - scrollY2, null, i5);
    }

    public void a(View view, int i, int i2, int[] iArr, int i3) {
        a(i, i2, iArr, null, i3);
    }

    public boolean a(int i, int i2) {
        return this.z.a(i, i2);
    }

    boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        int overScrollMode = getOverScrollMode();
        int i9 = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : false;
        int i10 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : false;
        boolean z3 = overScrollMode == 0 || (overScrollMode == 1 && i9 != 0);
        boolean z4 = overScrollMode == 0 || (overScrollMode == 1 && i10 != 0);
        overScrollMode = i3 + i;
        int i11 = !z3 ? 0 : i7;
        i9 = i4 + i2;
        i10 = !z4 ? 0 : i8;
        int i12 = -i11;
        i11 += i5;
        int i13 = -i10;
        i10 += i6;
        if (overScrollMode > i11) {
            z2 = true;
            i12 = i11;
        } else if (overScrollMode < i12) {
            z2 = true;
        } else {
            i12 = overScrollMode;
            z2 = false;
        }
        if (i9 > i10) {
            i13 = i10;
        } else if (i9 >= i13) {
            i13 = i9;
            z3 = false;
            if (z3 && !b(1)) {
                this.c.springBack(i12, i13, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i12, i13, z2, z3);
            return z2 || z3;
        }
        z3 = true;
        this.c.springBack(i12, i13, 0, 0, 0, getScrollRange());
        onOverScrolled(i12, i13, z2, z3);
        if (!z2) {
        }
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.z.a(i, i2, i3, i4, iArr, i5);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.z.a(i, i2, iArr, iArr2, i3);
    }

    public boolean a(KeyEvent keyEvent) {
        this.b.setEmpty();
        boolean z = false;
        int i = 130;
        if (b()) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 62) {
                    switch (keyCode) {
                        case 19:
                            return !keyEvent.isAltPressed() ? e(33) : d(33);
                        case 20:
                            return !keyEvent.isAltPressed() ? e(130) : d(130);
                        default:
                            return false;
                    }
                }
                if (keyEvent.isShiftPressed()) {
                    i = 33;
                }
                c(i);
            }
            return false;
        }
        if (isFocused() && keyEvent.getKeyCode() != 4) {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (!(findFocus == null || findFocus == this || !findFocus.requestFocus(130))) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void b(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250) {
                View childAt = getChildAt(0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int height = (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                i2 = Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY;
                this.u = getScrollY();
                this.c.startScroll(getScrollX(), scrollY, 0, i2);
                r.c(this);
            } else {
                if (!this.c.isFinished()) {
                    this.c.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public void b(View view, View view2, int i, int i2) {
        this.y.a(view, view2, i, i2);
        a(2, i2);
    }

    public boolean b(int i) {
        return this.z.a(i);
    }

    public final void c(int i, int i2) {
        b(i - getScrollX(), i2 - getScrollY());
    }

    public void c(View view, int i) {
        this.y.a(view, i);
        a(i);
    }

    public boolean c(int i) {
        Rect rect;
        int i2 = 0;
        int i3 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i3 != 0) {
            this.b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                i2 = (childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin) + getPaddingBottom();
                if (this.b.top + height > i2) {
                    rect = this.b;
                    i2 -= height;
                }
            }
            this.b.bottom = this.b.top + height;
            return a(i, this.b.top, this.b.bottom);
        }
        this.b.top = getScrollY() - height;
        if (this.b.top < 0) {
            rect = this.b;
        }
        this.b.bottom = this.b.top + height;
        return a(i, this.b.top, this.b.bottom);
        rect.top = i2;
        this.b.bottom = this.b.top + height;
        return a(i, this.b.top, this.b.bottom);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.c.computeScrollOffset()) {
            this.c.getCurrX();
            int currY = this.c.getCurrY();
            int i = currY - this.u;
            if (a(0, i, this.s, null, 1)) {
                i -= this.s[1];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY;
                a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - i3;
                if (!a(0, scrollY2, 0, i2 - scrollY2, null, 1)) {
                    int overScrollMode = getOverScrollMode();
                    int i4 = (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) ? 1 : 0;
                    if (i4 != 0) {
                        EdgeEffect edgeEffect;
                        g();
                        if (currY <= 0 && i3 > 0) {
                            edgeEffect = this.d;
                        } else if (currY >= scrollRange && i3 < scrollRange) {
                            edgeEffect = this.e;
                        }
                        edgeEffect.onAbsorb((int) this.c.getCurrVelocity());
                    }
                }
            }
            this.u = currY;
            r.c(this);
            return;
        }
        if (b(1)) {
            a(1);
        }
        this.u = 0;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }

    public boolean d(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.b.top = 0;
        this.b.bottom = height;
        if (i2 != 0) {
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                this.b.bottom = (childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin) + getPaddingBottom();
                this.b.top = this.b.bottom - height;
            }
        }
        return a(i, this.b.top, this.b.bottom);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.z.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.z.a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.d != null) {
            int save;
            int width;
            int height;
            int scrollY = getScrollY();
            int i = 0;
            if (!this.d.isFinished()) {
                int paddingLeft;
                save = canvas.save();
                width = getWidth();
                height = getHeight();
                int min = Math.min(0, scrollY);
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) paddingLeft, (float) min);
                this.d.setSize(width, height);
                if (this.d.draw(canvas)) {
                    r.c(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.e.isFinished()) {
                save = canvas.save();
                width = getWidth();
                height = getHeight();
                scrollY = Math.max(getScrollRange(), scrollY) + height;
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i = 0 + getPaddingLeft();
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    scrollY -= getPaddingBottom();
                }
                canvas.translate((float) (i - width), (float) scrollY);
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.e.setSize(width, height);
                if (this.e.draw(canvas)) {
                    r.c(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public boolean e(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                findNextFocus = getChildAt(0);
                maxScrollAmount = Math.min((findNextFocus.getBottom() + ((LayoutParams) findNextFocus.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(findNextFocus, this.b);
            g(a(this.b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && a(findFocus)) {
            i = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(i);
        }
        return true;
    }

    public void f(int i) {
        if (getChildCount() > 0) {
            a(2, 1);
            this.c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.u = getScrollY();
            r.c(this);
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.y.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return b(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.z.a();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() != 8 || this.j)) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    verticalScrollFactorCompat = 0;
                } else if (verticalScrollFactorCompat > scrollRange) {
                    verticalScrollFactorCompat = scrollRange;
                }
                if (verticalScrollFactorCompat != scrollY) {
                    super.scrollTo(getScrollX(), verticalScrollFactorCompat);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.j) {
            return true;
        }
        action &= 255;
        if (action != 6) {
            switch (action) {
                case 0:
                    action = (int) motionEvent.getY();
                    if (!d((int) motionEvent.getX(), action)) {
                        this.j = false;
                        e();
                        break;
                    }
                    this.f = action;
                    this.q = motionEvent.getPointerId(0);
                    c();
                    this.k.addMovement(motionEvent);
                    this.c.computeScrollOffset();
                    this.j = this.c.isFinished() ^ true;
                    a(2, 0);
                    break;
                case 1:
                case 3:
                    this.j = false;
                    this.q = -1;
                    e();
                    if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        r.c(this);
                    }
                    a(0);
                    break;
                case 2:
                    action = this.q;
                    if (action != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(action);
                        if (findPointerIndex != -1) {
                            action = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(action - this.f) > this.n && (2 & getNestedScrollAxes()) == 0) {
                                this.j = true;
                                this.f = action;
                                d();
                                this.k.addMovement(motionEvent);
                                this.t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                    break;
                                }
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid pointerId=");
                        stringBuilder.append(action);
                        stringBuilder.append(" in onInterceptTouchEvent");
                        Log.e("NestedScrollView", stringBuilder.toString());
                        break;
                    }
                    break;
            }
        }
        a(motionEvent);
        return this.j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.g = false;
        if (this.i != null && a(this.i, (View) this)) {
            b(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.v != null) {
                scrollTo(getScrollX(), this.v.a);
                this.v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i5 = (childAt.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
            }
            i4 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            i = getScrollY();
            i5 = b(i, i4, i5);
            if (i5 != i) {
                scrollTo(getScrollX(), i5);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.h = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        h((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        b(view, view2, i, 0);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || a(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof c) {
            c cVar = (c) parcelable;
            super.onRestoreInstanceState(cVar.getSuperState());
            this.v = cVar;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable cVar = new c(super.onSaveInstanceState());
        cVar.a = getScrollY();
        return cVar;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.B != null) {
            this.B.a(this, i, i2, i3, i4);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (!(findFocus == null || this == findFocus || !a(findFocus, 0, i4))) {
            findFocus.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(findFocus, this.b);
            g(a(this.b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return a(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        c(view, 0);
    }

    /* JADX WARNING: Missing block: B:12:0x0066, code:
            if (r10.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0068;
     */
    /* JADX WARNING: Missing block: B:13:0x0068, code:
            android.support.v4.h.r.c(r23);
     */
    /* JADX WARNING: Missing block: B:71:0x020c, code:
            if (r10.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0068;
     */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
        r23 = this;
        r10 = r23;
        r11 = r24;
        r23.d();
        r12 = android.view.MotionEvent.obtain(r24);
        r0 = r24.getActionMasked();
        r13 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        r10.t = r13;
    L_0x0014:
        r1 = r10.t;
        r1 = (float) r1;
        r14 = 0;
        r12.offsetLocation(r14, r1);
        r1 = -1;
        r15 = 1;
        switch(r0) {
            case 0: goto L_0x0210;
            case 1: goto L_0x01d8;
            case 2: goto L_0x0072;
            case 3: goto L_0x0047;
            case 4: goto L_0x0020;
            case 5: goto L_0x0034;
            case 6: goto L_0x0022;
            default: goto L_0x0020;
        };
    L_0x0020:
        goto L_0x0249;
    L_0x0022:
        r23.a(r24);
        r0 = r10.q;
        r0 = r11.findPointerIndex(r0);
        r0 = r11.getY(r0);
        r0 = (int) r0;
        r10.f = r0;
        goto L_0x0249;
    L_0x0034:
        r0 = r24.getActionIndex();
        r1 = r11.getY(r0);
        r1 = (int) r1;
        r10.f = r1;
        r0 = r11.getPointerId(r0);
        r10.q = r0;
        goto L_0x0249;
    L_0x0047:
        r0 = r10.j;
        if (r0 == 0) goto L_0x006b;
    L_0x004b:
        r0 = r23.getChildCount();
        if (r0 <= 0) goto L_0x006b;
    L_0x0051:
        r2 = r10.c;
        r3 = r23.getScrollX();
        r4 = r23.getScrollY();
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = r23.getScrollRange();
        r0 = r2.springBack(r3, r4, r5, r6, r7, r8);
        if (r0 == 0) goto L_0x006b;
    L_0x0068:
        android.support.v4.h.r.c(r23);
    L_0x006b:
        r10.q = r1;
        r23.f();
        goto L_0x0249;
    L_0x0072:
        r0 = r10.q;
        r9 = r11.findPointerIndex(r0);
        if (r9 != r1) goto L_0x0099;
    L_0x007a:
        r0 = "NestedScrollView";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid pointerId=";
        r1.append(r2);
        r2 = r10.q;
        r1.append(r2);
        r2 = " in onTouchEvent";
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.e(r0, r1);
        goto L_0x0249;
    L_0x0099:
        r0 = r11.getY(r9);
        r6 = (int) r0;
        r0 = r10.f;
        r7 = r0 - r6;
        r1 = 0;
        r3 = r10.s;
        r4 = r10.r;
        r5 = 0;
        r0 = r10;
        r2 = r7;
        r0 = r0.a(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00c6;
    L_0x00b0:
        r0 = r10.s;
        r0 = r0[r15];
        r7 = r7 - r0;
        r0 = r10.r;
        r0 = r0[r15];
        r0 = (float) r0;
        r12.offsetLocation(r14, r0);
        r0 = r10.t;
        r1 = r10.r;
        r1 = r1[r15];
        r0 = r0 + r1;
        r10.t = r0;
    L_0x00c6:
        r0 = r10.j;
        if (r0 != 0) goto L_0x00e6;
    L_0x00ca:
        r0 = java.lang.Math.abs(r7);
        r1 = r10.n;
        if (r0 <= r1) goto L_0x00e6;
    L_0x00d2:
        r0 = r23.getParent();
        if (r0 == 0) goto L_0x00db;
    L_0x00d8:
        r0.requestDisallowInterceptTouchEvent(r15);
    L_0x00db:
        r10.j = r15;
        if (r7 <= 0) goto L_0x00e3;
    L_0x00df:
        r0 = r10.n;
        r7 = r7 - r0;
        goto L_0x00e6;
    L_0x00e3:
        r0 = r10.n;
        r7 = r7 + r0;
    L_0x00e6:
        r8 = r7;
        r0 = r10.j;
        if (r0 == 0) goto L_0x0249;
    L_0x00eb:
        r0 = r10.r;
        r0 = r0[r15];
        r6 = r6 - r0;
        r10.f = r6;
        r16 = r23.getScrollY();
        r7 = r23.getScrollRange();
        r0 = r23.getOverScrollMode();
        if (r0 == 0) goto L_0x0108;
    L_0x0100:
        if (r0 != r15) goto L_0x0105;
    L_0x0102:
        if (r7 <= 0) goto L_0x0105;
    L_0x0104:
        goto L_0x0108;
    L_0x0105:
        r17 = r13;
        goto L_0x010a;
    L_0x0108:
        r17 = r15;
    L_0x010a:
        r1 = 0;
        r3 = 0;
        r4 = r23.getScrollY();
        r5 = 0;
        r18 = 0;
        r19 = 0;
        r20 = 1;
        r0 = r10;
        r2 = r8;
        r6 = r7;
        r21 = r7;
        r7 = r18;
        r14 = r8;
        r8 = r19;
        r22 = r9;
        r9 = r20;
        r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        if (r0 == 0) goto L_0x0136;
    L_0x012b:
        r0 = r10.b(r13);
        if (r0 != 0) goto L_0x0136;
    L_0x0131:
        r0 = r10.k;
        r0.clear();
    L_0x0136:
        r0 = r23.getScrollY();
        r2 = r0 - r16;
        r4 = r14 - r2;
        r1 = 0;
        r3 = 0;
        r5 = r10.r;
        r6 = 0;
        r0 = r10;
        r0 = r0.a(r1, r2, r3, r4, r5, r6);
        if (r0 == 0) goto L_0x0167;
    L_0x014a:
        r0 = r10.f;
        r1 = r10.r;
        r1 = r1[r15];
        r0 = r0 - r1;
        r10.f = r0;
        r0 = r10.r;
        r0 = r0[r15];
        r0 = (float) r0;
        r1 = 0;
        r12.offsetLocation(r1, r0);
        r0 = r10.t;
        r1 = r10.r;
        r1 = r1[r15];
        r0 = r0 + r1;
        r10.t = r0;
        goto L_0x0249;
    L_0x0167:
        if (r17 == 0) goto L_0x0249;
    L_0x0169:
        r23.g();
        r0 = r16 + r14;
        if (r0 >= 0) goto L_0x0196;
    L_0x0170:
        r0 = r10.d;
        r1 = (float) r14;
        r2 = r23.getHeight();
        r2 = (float) r2;
        r1 = r1 / r2;
        r2 = r22;
        r2 = r11.getX(r2);
        r3 = r23.getWidth();
        r3 = (float) r3;
        r2 = r2 / r3;
        android.support.v4.widget.g.a(r0, r1, r2);
        r0 = r10.e;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x01c0;
    L_0x0190:
        r0 = r10.e;
    L_0x0192:
        r0.onRelease();
        goto L_0x01c0;
    L_0x0196:
        r1 = r21;
        r2 = r22;
        if (r0 <= r1) goto L_0x01c0;
    L_0x019c:
        r0 = r10.e;
        r1 = (float) r14;
        r3 = r23.getHeight();
        r3 = (float) r3;
        r1 = r1 / r3;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = r11.getX(r2);
        r4 = r23.getWidth();
        r4 = (float) r4;
        r2 = r2 / r4;
        r3 = r3 - r2;
        android.support.v4.widget.g.a(r0, r1, r3);
        r0 = r10.d;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x01c0;
    L_0x01bd:
        r0 = r10.d;
        goto L_0x0192;
    L_0x01c0:
        r0 = r10.d;
        if (r0 == 0) goto L_0x0249;
    L_0x01c4:
        r0 = r10.d;
        r0 = r0.isFinished();
        if (r0 == 0) goto L_0x01d4;
    L_0x01cc:
        r0 = r10.e;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x0249;
    L_0x01d4:
        android.support.v4.h.r.c(r23);
        goto L_0x0249;
    L_0x01d8:
        r0 = r10.k;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r10.p;
        r3 = (float) r3;
        r0.computeCurrentVelocity(r2, r3);
        r2 = r10.q;
        r0 = r0.getYVelocity(r2);
        r0 = (int) r0;
        r2 = java.lang.Math.abs(r0);
        r3 = r10.o;
        if (r2 <= r3) goto L_0x01f7;
    L_0x01f1:
        r0 = -r0;
        r10.h(r0);
        goto L_0x006b;
    L_0x01f7:
        r2 = r10.c;
        r3 = r23.getScrollX();
        r4 = r23.getScrollY();
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = r23.getScrollRange();
        r0 = r2.springBack(r3, r4, r5, r6, r7, r8);
        if (r0 == 0) goto L_0x006b;
    L_0x020e:
        goto L_0x0068;
    L_0x0210:
        r0 = r23.getChildCount();
        if (r0 != 0) goto L_0x0217;
    L_0x0216:
        return r13;
    L_0x0217:
        r0 = r10.c;
        r0 = r0.isFinished();
        r0 = r0 ^ r15;
        r10.j = r0;
        if (r0 == 0) goto L_0x022b;
    L_0x0222:
        r0 = r23.getParent();
        if (r0 == 0) goto L_0x022b;
    L_0x0228:
        r0.requestDisallowInterceptTouchEvent(r15);
    L_0x022b:
        r0 = r10.c;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x0238;
    L_0x0233:
        r0 = r10.c;
        r0.abortAnimation();
    L_0x0238:
        r0 = r24.getY();
        r0 = (int) r0;
        r10.f = r0;
        r0 = r11.getPointerId(r13);
        r10.q = r0;
        r0 = 2;
        r10.a(r0, r13);
    L_0x0249:
        r0 = r10.k;
        if (r0 == 0) goto L_0x0252;
    L_0x024d:
        r0 = r10.k;
        r0.addMovement(r12);
    L_0x0252:
        r12.recycle();
        return r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestChildFocus(View view, View view2) {
        if (this.g) {
            this.i = view2;
        } else {
            b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int width = (childAt.getWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
            i = b(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), width);
            i2 = b(i2, height, height2);
            if (i != getScrollX() || i2 != getScrollY()) {
                super.scrollTo(i, i2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.l) {
            this.l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.z.a(z);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.B = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return a(i, 0);
    }

    public void stopNestedScroll() {
        a(0);
    }
}
