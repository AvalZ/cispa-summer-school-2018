package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.a.a;

class p {
    private static final int[] a = new int[]{a.colorPrimary};

    static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        int hasValue = obtainStyledAttributes.hasValue(0) ^ 1;
        obtainStyledAttributes.recycle();
        if (hasValue != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
