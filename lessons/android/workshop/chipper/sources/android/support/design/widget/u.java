package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class u extends ImageButton {
    private int a;

    public u(Context context) {
        this(context, null);
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = getVisibility();
    }

    final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.a;
    }

    public void setVisibility(int i) {
        a(i, true);
    }
}
