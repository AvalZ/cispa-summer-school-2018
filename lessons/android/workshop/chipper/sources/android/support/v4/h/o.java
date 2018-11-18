package android.support.v4.h;

import android.view.View;
import android.view.ViewGroup;

public class o {
    private final ViewGroup a;
    private int b;

    public o(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public int a() {
        return this.b;
    }

    public void a(View view, int i) {
        this.b = 0;
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        this.b = i;
    }
}
