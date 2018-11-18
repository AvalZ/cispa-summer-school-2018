package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.design.widget.CoordinatorLayout.c;
import android.support.design.widget.CoordinatorLayout.e;
import android.support.v4.g.i;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v4.h.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

@c(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    private int a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private z f;
    private List<b> g;
    private boolean h;
    private boolean i;
    private int[] j;

    public static class a extends LayoutParams {
        int a = 1;
        Interpolator b;

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.AppBarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.b;
        }

        boolean c() {
            return (this.a & 1) == 1 && (this.a & 10) != 0;
        }
    }

    public interface b {
        void a(AppBarLayout appBarLayout, int i);
    }

    public static class Behavior extends i<AppBarLayout> {
        private int b;
        private ValueAnimator c;
        private int d = -1;
        private boolean e;
        private float f;
        private WeakReference<View> g;
        private a h;

        public static abstract class a {
            public abstract boolean a(AppBarLayout appBarLayout);
        }

        protected static class b extends android.support.v4.h.a {
            public static final Creator<b> CREATOR = new ClassLoaderCreator<b>() {
                /* renamed from: a */
                public b createFromParcel(Parcel parcel) {
                    return new b(parcel, null);
                }

                /* renamed from: a */
                public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new b(parcel, classLoader);
                }

                /* renamed from: a */
                public b[] newArray(int i) {
                    return new b[i];
                }
            };
            int a;
            float b;
            boolean c;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.a = parcel.readInt();
                this.b = parcel.readFloat();
                this.c = parcel.readByte() != (byte) 0;
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.a);
                parcel.writeFloat(this.b);
                parcel.writeByte((byte) this.c);
            }
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -i;
                if (childAt.getTop() <= i3 && childAt.getBottom() >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int abs = Math.abs(a() - i);
            f = Math.abs(f);
            a(coordinatorLayout, appBarLayout, i, f > 0.0f ? Math.round((((float) abs) / f) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f));
        }

        private void a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            if (a() == i) {
                if (this.c != null && this.c.isRunning()) {
                    this.c.cancel();
                }
                return;
            }
            if (this.c == null) {
                this.c = new ValueAnimator();
                this.c.setInterpolator(a.e);
                this.c.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Behavior.this.a_(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.c.cancel();
            }
            this.c.setDuration((long) Math.min(i2, 600));
            this.c.setIntValues(new int[]{r0, i});
            this.c.start();
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View c = c(appBarLayout, i);
            if (c != null) {
                int a = ((a) c.getLayoutParams()).a();
                boolean z2 = false;
                if ((a & 1) != 0) {
                    int i3 = r.i(c);
                    if (i2 <= 0 || (a & 12) == 0 ? (a & 2) == 0 || (-i) < (c.getBottom() - i3) - appBarLayout.getTopInset() : (-i) < (c.getBottom() - i3) - appBarLayout.getTopInset()) {
                        z2 = true;
                    }
                }
                boolean a2 = appBarLayout.a(z2);
                if (VERSION.SDK_INT < 11) {
                    return;
                }
                if (z || (a2 && d(coordinatorLayout, appBarLayout))) {
                    appBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        private int b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = appBarLayout.getChildAt(i3);
                a aVar = (a) childAt.getLayoutParams();
                Interpolator b = aVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else {
                    if (b != null) {
                        childCount = aVar.a();
                        if ((childCount & 1) != 0) {
                            i2 = 0 + ((childAt.getHeight() + aVar.topMargin) + aVar.bottomMargin);
                            if ((childCount & 2) != 0) {
                                i2 -= r.i(childAt);
                            }
                        }
                        if (r.n(childAt)) {
                            i2 -= appBarLayout.getTopInset();
                        }
                        if (i2 > 0) {
                            float f = (float) i2;
                            return Integer.signum(i) * (childAt.getTop() + Math.round(f * b.getInterpolation(((float) (abs - childAt.getTop())) / f)));
                        }
                    }
                    return i;
                }
            }
            return i;
        }

        private static View c(AppBarLayout appBarLayout, int i) {
            i = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (i >= childAt.getTop() && i <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private void c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = a();
            int a2 = a(appBarLayout, a);
            if (a2 >= 0) {
                View childAt = appBarLayout.getChildAt(a2);
                int a3 = ((a) childAt.getLayoutParams()).a();
                if ((a3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a2 == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (a(a3, 2)) {
                        i2 += r.i(childAt);
                    } else if (a(a3, 5)) {
                        int i3 = r.i(childAt) + i2;
                        if (a < i3) {
                            i = i3;
                        } else {
                            i2 = i3;
                        }
                    }
                    if (a < (i2 + i) / 2) {
                        i = i2;
                    }
                    a(coordinatorLayout, appBarLayout, android.support.v4.c.a.a(i, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private boolean d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List d = coordinatorLayout.d((View) appBarLayout);
            int size = d.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                android.support.design.widget.CoordinatorLayout.b b = ((e) ((View) d.get(i)).getLayoutParams()).b();
                if (b instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) b).d() != 0) {
                        z = true;
                    }
                    return z;
                }
            }
            return false;
        }

        int a() {
            return b() + this.b;
        }

        int a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.b = 0;
            } else {
                int a2 = android.support.v4.c.a.a(i, i2, i3);
                if (a != a2) {
                    i = appBarLayout.b() ? b(appBarLayout, a2) : a2;
                    boolean a3 = a(i);
                    int i4 = a - a2;
                    this.b = a2 - i;
                    if (!a3 && appBarLayout.b()) {
                        coordinatorLayout.b((View) appBarLayout);
                    }
                    appBarLayout.a(b());
                    a(coordinatorLayout, appBarLayout, a2, a2 < a ? -1 : 1, false);
                    return i4;
                }
            }
            return 0;
        }

        void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            c(coordinatorLayout, appBarLayout);
        }

        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof b) {
                b bVar = (b) parcelable;
                super.a(coordinatorLayout, (View) appBarLayout, bVar.a());
                this.d = bVar.a;
                this.f = bVar.b;
                this.e = bVar.c;
                return;
            }
            super.a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.d = -1;
        }

        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (i == 0) {
                c(coordinatorLayout, appBarLayout);
            }
            this.g = new WeakReference(view);
        }

        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            if (i2 != 0) {
                int i4;
                if (i2 < 0) {
                    i4 = -appBarLayout.getTotalScrollRange();
                    i = appBarLayout.getDownNestedPreScrollRange() + i4;
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    i = 0;
                }
                int i5 = i4;
                int i6 = i;
                if (i5 != i6) {
                    iArr[1] = b(coordinatorLayout, appBarLayout, i2, i5, i6);
                }
            }
        }

        /* renamed from: a */
        boolean c(AppBarLayout appBarLayout) {
            if (this.h != null) {
                return this.h.a(appBarLayout);
            }
            boolean z = true;
            if (this.g != null) {
                View view = (View) this.g.get();
                if (view != null && view.isShown() && !view.canScrollVertically(-1)) {
                    return true;
                }
                z = false;
            }
            return z;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (this.d >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(this.d);
                a_(coordinatorLayout, appBarLayout, (-childAt.getBottom()) + (this.e ? r.i(childAt) + appBarLayout.getTopInset() : Math.round(((float) childAt.getHeight()) * this.f)));
            } else if (pendingAction != 0) {
                int i2 = (pendingAction & 4) != 0 ? 1 : 0;
                if ((pendingAction & 2) != 0) {
                    pendingAction = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, pendingAction, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, pendingAction);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.d();
            this.d = -1;
            a(android.support.v4.c.a.a(b(), -appBarLayout.getTotalScrollRange(), 0));
            a(coordinatorLayout, appBarLayout, b(), 0, true);
            appBarLayout.a(b());
            return a;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((e) appBarLayout.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, (View) appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.a((View) appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && appBarLayout.c() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.c != null) {
                this.c.cancel();
            }
            this.g = null;
            return z;
        }

        int b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable b = super.b(coordinatorLayout, appBarLayout);
            int b2 = b();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    Parcelable bVar = new b(b);
                    bVar.a = i;
                    if (bottom == r.i(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    bVar.c = z;
                    bVar.b = ((float) bottom) / ((float) childAt.getHeight());
                    return bVar;
                }
            }
            return b;
        }

        /* renamed from: c */
        int a(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }
    }

    public static class ScrollingViewBehavior extends j {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int a(AppBarLayout appBarLayout) {
            android.support.design.widget.CoordinatorLayout.b b = ((e) appBarLayout.getLayoutParams()).b();
            return b instanceof Behavior ? ((Behavior) b).a() : 0;
        }

        private void e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            android.support.design.widget.CoordinatorLayout.b b = ((e) view2.getLayoutParams()).b();
            if (b instanceof Behavior) {
                r.c(view, (((view2.getBottom() - view.getTop()) + ((Behavior) b).b) + a()) - c(view2));
            }
        }

        float a(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a = a(appBarLayout);
                if (downNestedPreScrollRange != 0 && totalScrollRange + a <= downNestedPreScrollRange) {
                    return 0.0f;
                }
                totalScrollRange -= downNestedPreScrollRange;
                if (totalScrollRange != 0) {
                    return (((float) a) / ((float) totalScrollRange)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* renamed from: a */
        AppBarLayout b(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a = b(coordinatorLayout.c(view));
            if (a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a.a(false, z ^ 1);
                    return true;
                }
            }
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        int b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.b(view);
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            e(coordinatorLayout, view, view2);
            return false;
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        p.a(context);
        if (VERSION.SDK_INT >= 21) {
            t.a(this);
            t.a(this, attributeSet, 0, j.Widget_Design_AppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.AppBarLayout, 0, j.Widget_Design_AppBarLayout);
        r.a((View) this, obtainStyledAttributes.getDrawable(k.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(k.AppBarLayout_expanded)) {
            a(obtainStyledAttributes.getBoolean(k.AppBarLayout_expanded, false), false, false);
        }
        if (VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(k.AppBarLayout_elevation)) {
            t.a(this, (float) obtainStyledAttributes.getDimensionPixelSize(k.AppBarLayout_elevation, 0));
        }
        if (VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (obtainStyledAttributes.hasValue(k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        obtainStyledAttributes.recycle();
        r.a((View) this, new p() {
            public z a(View view, z zVar) {
                return AppBarLayout.this.a(zVar);
            }
        });
    }

    private void a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i = 8;
        }
        this.e = i2 | i;
        requestLayout();
    }

    private boolean b(boolean z) {
        if (this.h == z) {
            return false;
        }
        this.h = z;
        refreshDrawableState();
        return true;
    }

    private void e() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (((a) getChildAt(i).getLayoutParams()).c()) {
                z = true;
                break;
            }
        }
        b(z);
    }

    private void f() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    /* renamed from: a */
    protected a generateDefaultLayoutParams() {
        return new a(-1, -2);
    }

    /* renamed from: a */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (VERSION.SDK_INT < 19 || !(layoutParams instanceof LayoutParams)) ? layoutParams instanceof MarginLayoutParams ? new a((MarginLayoutParams) layoutParams) : new a(layoutParams) : new a((LayoutParams) layoutParams);
    }

    z a(z zVar) {
        z zVar2 = r.n(this) ? zVar : null;
        if (!i.a(this.f, zVar2)) {
            this.f = zVar2;
            f();
        }
        return zVar;
    }

    void a(int i) {
        if (this.g != null) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.g.get(i2);
                if (bVar != null) {
                    bVar.a(this, i);
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    boolean a(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    boolean b() {
        return this.d;
    }

    boolean c() {
        return getTotalScrollRange() != 0;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void d() {
        this.e = 0;
    }

    int getDownNestedPreScrollRange() {
        if (this.b != -1) {
            return this.b;
        }
        int childCount;
        int i = 0;
        for (childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = aVar.a;
            if ((i2 & 5) == 5) {
                i += aVar.topMargin + aVar.bottomMargin;
                if ((i2 & 8) != 0) {
                    i += r.i(childAt);
                } else {
                    i += measuredHeight - ((i2 & 2) != 0 ? r.i(childAt) : getTopInset());
                }
            } else if (i > 0) {
                break;
            }
        }
        childCount = Math.max(0, i);
        this.b = childCount;
        return childCount;
    }

    int getDownNestedScrollRange() {
        if (this.c != -1) {
            return this.c;
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (aVar.topMargin + aVar.bottomMargin);
            int i3 = aVar.a;
            if ((i3 & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i3 & 2) != 0) {
                i2 -= r.i(childAt) + getTopInset();
                break;
            }
            i++;
        }
        childCount = Math.max(0, i2);
        this.c = childCount;
        return childCount;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int i = r.i(this);
        if (i == 0) {
            i = getChildCount();
            i = i >= 1 ? r.i(getChildAt(i - 1)) : 0;
            if (i == 0) {
                return getHeight() / 3;
            }
        }
        return (i * 2) + topInset;
    }

    int getPendingAction() {
        return this.e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        return this.f != null ? this.f.b() : 0;
    }

    public final int getTotalScrollRange() {
        if (this.a != -1) {
            return this.a;
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = aVar.a;
            if ((i3 & 1) == 0) {
                break;
            }
            i2 += (measuredHeight + aVar.topMargin) + aVar.bottomMargin;
            if ((i3 & 2) != 0) {
                i2 -= r.i(childAt);
                break;
            }
            i++;
        }
        childCount = Math.max(0, i2 - getTopInset());
        this.a = childCount;
        return childCount;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    protected int[] onCreateDrawableState(int i) {
        if (this.j == null) {
            this.j = new int[2];
        }
        int[] iArr = this.j;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.h ? android.support.design.a.b.state_collapsible : -android.support.design.a.b.state_collapsible;
        int i2 = (this.h && this.i) ? android.support.design.a.b.state_collapsed : -android.support.design.a.b.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        f();
        int i5 = 0;
        this.d = false;
        i = getChildCount();
        while (i5 < i) {
            if (((a) getChildAt(i5).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            }
            i5++;
        }
        e();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        f();
    }

    public void setExpanded(boolean z) {
        a(z, r.u(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            t.a(this, f);
        }
    }
}
