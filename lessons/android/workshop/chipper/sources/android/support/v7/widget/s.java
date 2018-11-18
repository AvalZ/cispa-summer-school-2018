package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.k;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

class s extends PopupWindow {
    private static final boolean a = (VERSION.SDK_INT < 21);
    private boolean b;

    public s(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        bg a = bg.a(context, attributeSet, j.PopupWindow, i, i2);
        if (a.g(j.PopupWindow_overlapAnchor)) {
            a(a.a(j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.a(j.PopupWindow_android_popupBackground));
        a.a();
    }

    private void a(boolean z) {
        if (a) {
            this.b = z;
        } else {
            k.a((PopupWindow) this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }
}
