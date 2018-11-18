package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.e;
import android.support.v4.c.a;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.support.v4.h.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class j extends q<View> {
    final Rect a = new Rect();
    final Rect b = new Rect();
    private int c = 0;
    private int d;

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int c(int i) {
        return i == 0 ? 8388659 : i;
    }

    float a(View view) {
        return 1.0f;
    }

    final int a() {
        return this.c;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View b = b(coordinatorLayout.c(view));
            if (b != null) {
                View view2;
                if (!r.n(b) || r.n(view)) {
                    view2 = view;
                } else {
                    view2 = view;
                    r.b(view2, true);
                    if (r.n(view2)) {
                        view2.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.a(view2, i, i2, MeasureSpec.makeMeasureSpec((size - b.getMeasuredHeight()) + b(b), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    int b(View view) {
        return view.getMeasuredHeight();
    }

    abstract View b(List<View> list);

    public final void b(int i) {
        this.d = i;
    }

    protected void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        int bottom;
        View b = b(coordinatorLayout.c(view));
        if (b != null) {
            e eVar = (e) view.getLayoutParams();
            Rect rect = this.a;
            rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, b.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            z lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || !r.n(coordinatorLayout) || r.n(view))) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.b;
            d.a(c(eVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            i = c(b);
            view.layout(rect2.left, rect2.top - i, rect2.right, rect2.bottom - i);
            bottom = rect2.top - b.getBottom();
        } else {
            super.b(coordinatorLayout, view, i);
            bottom = 0;
        }
        this.c = bottom;
    }

    final int c(View view) {
        return this.d == 0 ? 0 : a.a((int) (a(view) * ((float) this.d)), 0, this.d);
    }

    public final int d() {
        return this.d;
    }
}
