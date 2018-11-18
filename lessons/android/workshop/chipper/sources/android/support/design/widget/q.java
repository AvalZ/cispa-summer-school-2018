package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.b;
import android.util.AttributeSet;
import android.view.View;

class q<V extends View> extends b<V> {
    private r a;
    private int b = 0;
    private int c = 0;

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int i) {
        if (this.a != null) {
            return this.a.a(i);
        }
        this.b = i;
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, v, i);
        if (this.a == null) {
            this.a = new r(v);
        }
        this.a.a();
        if (this.b != 0) {
            this.a.a(this.b);
            this.b = 0;
        }
        if (this.c != 0) {
            this.a.b(this.c);
            this.c = 0;
        }
        return true;
    }

    public int b() {
        return this.a != null ? this.a.b() : 0;
    }

    protected void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.a((View) v, i);
    }
}
